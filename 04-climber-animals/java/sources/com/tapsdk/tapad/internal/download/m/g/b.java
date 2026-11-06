package com.tapsdk.tapad.internal.download.m.g;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.tapsdk.tapad.internal.download.m.g.a {
    private final FileChannel a;
    final ParcelFileDescriptor b;
    final BufferedOutputStream c;
    final FileOutputStream d;

    public static class a implements com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a {
        @Override // com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a
        public com.tapsdk.tapad.internal.download.m.g.a a(Context context, Uri uri, int i) throws FileNotFoundException {
            return new b(context, uri, i);
        }

        @Override // com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a
        public com.tapsdk.tapad.internal.download.m.g.a a(Context context, File file, int i) throws FileNotFoundException {
            return new b(context, Uri.fromFile(file), i);
        }

        @Override // com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a
        public boolean a() {
            return true;
        }
    }

    public b(Context context, Uri uri, int i) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.b = parcelFileDescriptorOpenFileDescriptor;
        FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
        this.d = fileOutputStream;
        this.a = fileOutputStream.getChannel();
        this.c = new BufferedOutputStream(fileOutputStream, i);
    }

    b(FileChannel fileChannel, ParcelFileDescriptor parcelFileDescriptor, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream) {
        this.a = fileChannel;
        this.b = parcelFileDescriptor;
        this.d = fileOutputStream;
        this.c = bufferedOutputStream;
    }

    @Override // com.tapsdk.tapad.internal.download.m.g.a
    public void a() throws IOException {
        this.c.flush();
        this.b.getFileDescriptor().sync();
    }

    @Override // com.tapsdk.tapad.internal.download.m.g.a
    public void a(long j) {
        StringBuilder sb;
        try {
            Os.posix_fallocate(this.b.getFileDescriptor(), 0L, j);
        } catch (Throwable th) {
            th = th;
            if (th instanceof ErrnoException) {
                int i = th.errno;
                if (i == OsConstants.ENOSYS || i == OsConstants.ENOTSUP) {
                    com.tapsdk.tapad.internal.download.m.c.c("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                    try {
                        Os.ftruncate(this.b.getFileDescriptor(), j);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        sb = new StringBuilder("It can't pre-allocate length(");
                        com.tapsdk.tapad.internal.download.m.c.c("DownloadUriOutputStream", sb.append(j).append(") on the sdk version(").append(Build.VERSION.SDK_INT).append("), because of ").append(th).toString());
                    }
                }
                return;
            }
            sb = new StringBuilder("It can't pre-allocate length(");
            com.tapsdk.tapad.internal.download.m.c.c("DownloadUriOutputStream", sb.append(j).append(") on the sdk version(").append(Build.VERSION.SDK_INT).append("), because of ").append(th).toString());
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.g.a
    public void a(byte[] bArr, int i, int i2) throws IOException {
        this.c.write(bArr, i, i2);
    }

    @Override // com.tapsdk.tapad.internal.download.m.g.a
    public void b(long j) throws IOException {
        this.a.position(j);
    }

    @Override // com.tapsdk.tapad.internal.download.m.g.a
    public void close() throws IOException {
        this.c.close();
        this.d.close();
        this.b.close();
    }
}
