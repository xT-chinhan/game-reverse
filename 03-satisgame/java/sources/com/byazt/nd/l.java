package com.byazt.nd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 18})
public class l {
    public final RandomAccessFile n;

    public l(File file, String str) throws n {
        try {
            this.n = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new n(e);
        }
    }

    public void n(long j) throws n {
        try {
            this.n.seek(j);
        } catch (IOException e) {
            throw new n(e);
        }
    }

    public void n(byte[] bArr, int i, int i2) throws n {
        try {
            this.n.write(bArr, i, i2);
        } catch (IOException e) {
            throw new n(e);
        }
    }

    public void n() {
        com.byazt.cmv.n.n(this.n);
    }

    @com.byazt.cp.n(n = {0, 1, 674, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    static class n extends Exception {
        public n(Throwable th) {
            super(th);
        }
    }
}
