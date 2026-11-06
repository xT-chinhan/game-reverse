package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.ny.c;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public class ka implements Closeable {
    private RandomAccessFile ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private BufferedOutputStream f4713ms;
    private FileDescriptor xr;

    public ka(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.ah = randomAccessFile;
            this.xr = randomAccessFile.getFD();
            if (i > 0) {
                int i2 = 8192;
                if (i >= 8192) {
                    i2 = 131072;
                    i = i > 131072 ? i2 : i;
                }
                this.f4713ms = new BufferedOutputStream(new FileOutputStream(this.ah.getFD()), i);
                return;
            }
            this.f4713ms = new BufferedOutputStream(new FileOutputStream(this.ah.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void ms(byte[] bArr, int i, int i2) throws IOException {
        this.f4713ms.write(bArr, i, i2);
    }

    public void ms() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f4713ms;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.xr;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void xr() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f4713ms;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void ah() throws IOException {
        FileDescriptor fileDescriptor = this.xr;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c.ms(this.ah, this.f4713ms);
    }

    public void ms(long j) throws IOException {
        this.ah.seek(j);
    }

    public void xr(long j) throws IOException {
        this.ah.setLength(j);
    }
}
