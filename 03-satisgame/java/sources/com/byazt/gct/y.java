package com.byazt.gct;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 99})
public class y {
    public String cd;
    public long cp;
    public Bundle cy;
    public long d;
    public int hd;
    public int l;
    public com.byazt.msp.s.n m;
    public int q;
    public String s;
    public long tj;
    public String um;
    public String wm = com.byazt.vgx.w.x();
    public int n = -1;
    public int qg = -1;
    public JSONArray w = null;
    public int x = 1;
    public long fs = System.currentTimeMillis();
    public long rv = System.currentTimeMillis();
    public JSONObject oa = null;
    public int sz = -1;
    public com.byazt.vyf.w k = com.byazt.vyf.w.n("");
    public boolean a = false;
    public int py = 0;
    public int ou = 0;

    public y n() {
        y yVar = new y();
        yVar.n = this.n;
        yVar.qg = this.qg;
        yVar.w = this.w;
        yVar.x = this.x;
        yVar.fs = this.fs;
        yVar.tj = this.tj;
        yVar.cp = this.cp;
        yVar.d = this.d;
        yVar.sz = this.sz;
        yVar.um = this.um;
        return yVar;
    }

    public void n(String str) {
        this.wm = str;
    }

    public String qg() {
        return this.wm;
    }

    public void n(String str, boolean z) {
        com.byazt.vyf.w wVar;
        if (!z || (wVar = this.k) == null || str == null) {
            return;
        }
        wVar.qg("cst_".concat(String.valueOf(str)));
    }

    public void n(String str, long j, boolean z) {
        com.byazt.vyf.w wVar;
        if (!z || (wVar = this.k) == null || str == null) {
            return;
        }
        wVar.n("cst_".concat(String.valueOf(str)), j);
    }

    public void n(int i, String str, int i2, com.byazt.zq.qg qgVar) {
        this.m = new com.byazt.msp.s.n(i, str, i2, System.currentTimeMillis(), qgVar);
    }

    public void n(Object obj, int i) {
        int size = obj != null ? 1 : 0;
        try {
            if (obj instanceof List) {
                size = ((List) obj).size();
            }
        } catch (Exception unused) {
        }
        com.byazt.msp.s.n nVar = this.m;
        if (nVar != null) {
            nVar.n(size);
            com.byazt.msp.s.n(this.m, i);
            this.m = null;
        }
    }
}
