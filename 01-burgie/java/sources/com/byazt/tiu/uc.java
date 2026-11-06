package com.byazt.tiu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 5})
public class uc extends c {
    public static final int pr = c.pr("fcTL");
    public int aj;
    public byte g;
    public int hn;
    public int hw;
    public short k;
    public byte m;
    public int vk;
    public short w;
    public int zo;

    @Override // com.byazt.tiu.c
    public void pr(com.byazt.fe.pr prVar) throws IOException {
        this.hw = prVar.hw();
        this.hn = prVar.hw();
        this.zo = prVar.hw();
        this.aj = prVar.hw();
        this.vk = prVar.hw();
        this.w = prVar.a_();
        this.k = prVar.a_();
        this.m = prVar.c_();
        this.g = prVar.c_();
    }
}
