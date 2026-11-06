package com.byazt.fe;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1390, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements uc {
    public uc pr;

    public c(uc ucVar) {
        this.pr = ucVar;
    }

    @Override // com.byazt.fe.uc
    public long pr(long j) throws IOException {
        return this.pr.pr(j);
    }

    @Override // com.byazt.fe.uc
    public byte c_() throws IOException {
        return this.pr.c_();
    }

    @Override // com.byazt.fe.uc
    public void d_() throws IOException {
        this.pr.d_();
    }

    @Override // com.byazt.fe.uc
    public int hn() {
        return this.pr.hn();
    }

    @Override // com.byazt.fe.uc
    public int pr(byte[] bArr, int i, int i2) throws IOException {
        return this.pr.pr(bArr, i, i2);
    }

    @Override // com.byazt.fe.uc
    public int x() throws IOException {
        return this.pr.x();
    }

    @Override // com.byazt.fe.uc
    public InputStream c() throws IOException {
        d_();
        return this.pr.c();
    }
}
