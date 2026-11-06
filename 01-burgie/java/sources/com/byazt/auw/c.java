package com.byazt.auw;

import com.byazt.lhc.BaseException;
import com.byazt.tuy.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements Closeable {
    public RandomAccessFile hn;
    public FileDescriptor hw;
    public BufferedOutputStream pr;

    public c(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.hn = randomAccessFile;
            this.hw = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.pr = new BufferedOutputStream(new FileOutputStream(this.hn.getFD()), i);
                return;
            }
            this.pr = new BufferedOutputStream(new FileOutputStream(this.hn.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void pr(byte[] bArr, int i, int i2) throws IOException {
        this.pr.write(bArr, i, i2);
    }

    public void pr() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.pr;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.hw;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void hw() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.pr;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void hn() throws IOException {
        FileDescriptor fileDescriptor = this.hw;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        uc.pr(this.hn, this.pr);
    }

    public void pr(long j) throws IOException {
        this.hn.seek(j);
    }

    public void hw(long j) throws IOException {
        this.hn.setLength(j);
    }
}
