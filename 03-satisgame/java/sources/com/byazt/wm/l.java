package com.byazt.wm;

import com.byazt.qx.BaseException;
import com.byazt.ta.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 18})
public class l implements Closeable {
    public BufferedOutputStream n;
    public FileDescriptor qg;
    public RandomAccessFile s;

    public l(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.s = randomAccessFile;
            this.qg = randomAccessFile.getFD();
            if (i > 0) {
                int i2 = 8192;
                if (i >= 8192) {
                    i2 = 131072;
                    i = i > 131072 ? i2 : i;
                }
                this.n = new BufferedOutputStream(new FileOutputStream(this.s.getFD()), i);
                return;
            }
            this.n = new BufferedOutputStream(new FileOutputStream(this.s.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void n(byte[] bArr, int i, int i2) throws IOException {
        this.n.write(bArr, i, i2);
    }

    public void n() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.n;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.qg;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void qg() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.n;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void s() throws IOException {
        FileDescriptor fileDescriptor = this.qg;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        w.n(this.s, this.n);
    }

    public void n(long j) throws IOException {
        this.s.seek(j);
    }

    public void qg(long j) throws IOException {
        this.s.setLength(j);
    }
}
