package com.byazt.tiu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 250})
public class k extends c {
    public static final int pr = c.pr("IHDR");
    public int hn;
    public int hw;
    public byte[] zo = new byte[5];

    @Override // com.byazt.tiu.c
    public void pr(com.byazt.fe.pr prVar) throws IOException {
        this.hw = prVar.hw();
        this.hn = prVar.hw();
        byte[] bArr = this.zo;
        prVar.pr(bArr, 0, bArr.length);
    }
}
