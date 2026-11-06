package com.byazt.tiu;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public int c;
    public int fw;
    public int uc;
    public int x;

    public static int pr(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    public void hw(com.byazt.fe.pr prVar) throws IOException {
        int iX = prVar.x();
        pr(prVar);
        int iX2 = iX - prVar.x();
        int i = this.x;
        if (iX2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iX2 < i) {
            prVar.pr(i - iX2);
        }
    }

    public void pr(com.byazt.fe.pr prVar) throws IOException {
    }
}
