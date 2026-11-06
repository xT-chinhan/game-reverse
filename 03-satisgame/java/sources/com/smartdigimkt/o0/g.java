package com.smartdigimkt.o0;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements e {
    public final com.smartdigimkt.z0.m a;
    public final int b;
    public final int c;
    public int d;
    public int e;

    public g(b bVar) {
        com.smartdigimkt.z0.m mVar = bVar.P0;
        this.a = mVar;
        mVar.c(12);
        this.c = mVar.h() & 255;
        this.b = mVar.h();
    }

    @Override // com.smartdigimkt.o0.e
    public final boolean a() {
        return false;
    }

    @Override // com.smartdigimkt.o0.e
    public final int b() {
        return this.b;
    }

    @Override // com.smartdigimkt.o0.e
    public final int c() {
        int i = this.c;
        if (i == 8) {
            return this.a.e();
        }
        if (i == 16) {
            return this.a.j();
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.e & 15;
        }
        int iE = this.a.e();
        this.e = iE;
        return (iE & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) >> 4;
    }
}
