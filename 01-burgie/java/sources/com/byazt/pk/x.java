package com.byazt.pk;

import android.graphics.Bitmap;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.sd.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 121})
public class x implements rc<Bitmap> {
    public String c;
    public String hn;
    public int hw;
    public String pr;
    public String x;

    public x(String str, String str2, String str3, String str4, int i) {
        this.pr = str;
        this.hn = str2;
        this.x = str3;
        this.c = str4;
        this.hw = i;
    }

    @Override // com.byazt.ld.rc
    public void pr(nt<Bitmap> ntVar) {
        if (ntVar == null || ntVar.hn() == null) {
            com.byazt.xk.hw.pr().pr("load_icon_error", this.pr, this.x, this.hn, this.hw, "", this.c, null, fw.pr(202), 202, null);
        }
    }

    @Override // com.byazt.ld.rc
    public void pr(int i, String str, Throwable th) {
        com.byazt.xk.hw.pr().pr("load_icon_error", this.pr, this.x, this.hn, this.hw, "", this.c, null, fw.pr(201), 201, null);
    }
}
