package com.byazt.yn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, 37})
public class pr implements com.byazt.hcx.hn {
    public final String c;
    public final String hn;
    public final int hw;
    public final boolean pr;
    public final Throwable uc;
    public final byte[] x;

    public pr(boolean z, int i, String str, byte[] bArr, String str2, Throwable th) {
        this.pr = z;
        this.hw = i;
        this.hn = str;
        this.x = bArr;
        this.c = str2;
        this.uc = th;
    }

    @Override // com.byazt.hcx.hn
    public boolean pr() {
        return this.pr;
    }

    @Override // com.byazt.hcx.hn
    public int hw() {
        return this.hw;
    }

    @Override // com.byazt.hcx.hn
    public String hn() {
        return this.hn;
    }

    @Override // com.byazt.hcx.hn
    public boolean x() {
        int i;
        return this.pr && (i = this.hw) >= 200 && i < 300;
    }

    @Override // com.byazt.hcx.hn
    public byte[] c() {
        return this.x;
    }

    @Override // com.byazt.hcx.hn
    public String uc() {
        return this.c;
    }

    @Override // com.byazt.hcx.hn
    public Throwable fw() {
        return this.uc;
    }
}
