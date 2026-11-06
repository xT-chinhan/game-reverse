package com.byazt.ph;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends vk {
    public long pr;

    public c(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.byazt.ph.vk, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.pr += jSkip;
        return jSkip;
    }

    @Override // com.byazt.ph.vk
    public synchronized void pr(int i) {
        if (i != -1) {
            this.pr += (long) i;
        }
    }

    public int pr() {
        long jHw = hw();
        if (jHw > 2147483647L) {
            throw new ArithmeticException("The byte count " + jHw + " is too large to be converted to an int");
        }
        return (int) jHw;
    }

    public synchronized long hw() {
        return this.pr;
    }
}
