package com.taptap.sdk.update.download.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.taptap.sdk.update.download.core.Util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadUriOutputStream implements DownloadOutputStream {
    private final FileChannel channel;
    final FileOutputStream fos;
    final BufferedOutputStream out;
    final ParcelFileDescriptor pdf;

    public DownloadUriOutputStream(Context context, Uri uri, int bufferSize) throws FileNotFoundException {
        ParcelFileDescriptor pdf = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (pdf == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.pdf = pdf;
        FileOutputStream fileOutputStream = new FileOutputStream(pdf.getFileDescriptor());
        this.fos = fileOutputStream;
        this.channel = fileOutputStream.getChannel();
        this.out = new BufferedOutputStream(fileOutputStream, bufferSize);
    }

    DownloadUriOutputStream(FileChannel channel, ParcelFileDescriptor pdf, FileOutputStream fos, BufferedOutputStream out) {
        this.channel = channel;
        this.pdf = pdf;
        this.fos = fos;
        this.out = out;
    }

    @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
    }

    @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream
    public void close() throws IOException {
        this.out.close();
        this.fos.close();
        this.pdf.close();
    }

    @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream
    public void flushAndSync() throws IOException {
        this.out.flush();
        this.pdf.getFileDescriptor().sync();
    }

    @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream
    public void seek(long offset) throws IOException {
        this.channel.position(offset);
    }

    @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream
    public void setLength(long newLength) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.posix_fallocate(this.pdf.getFileDescriptor(), 0L, newLength);
                return;
            } catch (Throwable e) {
                if (e instanceof ErrnoException) {
                    if (((ErrnoException) e).errno == OsConstants.ENOSYS || ((ErrnoException) e).errno == OsConstants.ENOTSUP) {
                        Util.w("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                        try {
                            Os.ftruncate(this.pdf.getFileDescriptor(), newLength);
                            return;
                        } catch (Throwable e1) {
                            Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + newLength + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + e1);
                            return;
                        }
                    }
                    return;
                }
                Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + newLength + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + e);
                return;
            }
        }
        Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + newLength + ") on the sdk version(" + Build.VERSION.SDK_INT + ")");
    }

    public static class Factory implements DownloadOutputStream.Factory {
        @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, File file, int flushBufferSize) throws FileNotFoundException {
            return new DownloadUriOutputStream(context, Uri.fromFile(file), flushBufferSize);
        }

        @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, Uri uri, int flushBufferSize) throws FileNotFoundException {
            return new DownloadUriOutputStream(context, uri, flushBufferSize);
        }

        @Override // com.taptap.sdk.update.download.core.file.DownloadOutputStream.Factory
        public boolean supportSeek() {
            return true;
        }
    }
}
