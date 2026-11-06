package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public final RandomAccessFile pr;

    public c(File file, String str) throws pr {
        try {
            this.pr = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new pr(e);
        }
    }

    public void pr(long j) throws pr {
        try {
            this.pr.seek(j);
        } catch (IOException e) {
            throw new pr(e);
        }
    }

    public void pr(byte[] bArr, int i, int i2) throws pr {
        try {
            this.pr.write(bArr, i, i2);
        } catch (IOException e) {
            throw new pr(e);
        }
    }

    public void pr() {
        com.byazt.a.pr.pr(this.pr);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 169})
    static class pr extends Exception {
        public pr(Throwable th) {
            super(th);
        }
    }
}
