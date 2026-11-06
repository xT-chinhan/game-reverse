package com.byazt.eji;

import android.graphics.Bitmap;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, 26})
public class qg implements m<Bitmap> {
    public String l;
    public String n;
    public String q;
    public int qg;
    public String s;

    public qg(String str, String str2, String str3, String str4, int i) {
        this.n = str;
        this.s = str2;
        this.q = str3;
        this.l = str4;
        this.qg = i;
    }

    @Override // com.byazt.si.m
    public void n(cy<Bitmap> cyVar) {
        if (cyVar == null || cyVar.s() == null) {
            s.n().n("load_icon_error", this.n, this.q, this.s, this.qg, "", this.l, null, com.byazt.bxg.n.n(202), 202, null);
        }
    }

    @Override // com.byazt.si.m
    public void n(int i, String str, Throwable th) {
        s.n().n("load_icon_error", this.n, this.q, this.s, this.qg, "", this.l, null, com.byazt.bxg.n.n(201), 201, null);
    }
}
