package com.byazt.gu;

import android.content.Context;
import com.byazt.xz.cp;
import com.byazt.xz.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 13})
public class w {
    public static volatile w n;
    public com.byazt.ey.n fs;
    public n l;
    public qg q;
    public List<com.byazt.vh.qg> qg;
    public com.byazt.vh.s s;
    public com.byazt.mcb.n w;
    public com.byazt.uy.q x;

    public static w n() {
        if (n == null) {
            synchronized (w.class) {
                if (n == null) {
                    n = new w();
                }
            }
        }
        return n;
    }

    private w() {
    }

    public void n(Context context, com.byazt.vh.s sVar, qg qgVar) {
        this.s = sVar;
        this.q = qgVar;
        x();
    }

    public qg qg() {
        return this.q;
    }

    private void x() {
        ArrayList arrayList = new ArrayList();
        this.qg = arrayList;
        com.byazt.vh.s sVar = this.s;
        if (sVar != null) {
            arrayList.addAll(sVar.n());
        }
        com.byazt.vh.q.n(this.qg);
    }

    public void n(com.byazt.mcb.n nVar) {
        this.w = nVar;
    }

    public com.byazt.mcb.n s() {
        return this.w;
    }

    public void n(rv rvVar) {
        ArrayList arrayList = new ArrayList(new com.byazt.xz.n().n());
        if (rvVar != null) {
            arrayList.addAll(rvVar.n());
        }
        cp.n(arrayList);
    }

    public void n(com.byazt.xz.s sVar) {
        ArrayList arrayList = new ArrayList(new com.byazt.xz.w().n());
        if (sVar != null) {
            arrayList.addAll(sVar.n());
        }
        com.byazt.xz.q.n(arrayList);
    }

    public n q() {
        return this.l;
    }

    public void n(com.byazt.uy.q qVar) {
        this.x = qVar;
    }

    public com.byazt.uy.q l() {
        return this.x;
    }

    public void n(com.byazt.ey.n nVar) {
        this.fs = nVar;
    }

    public com.byazt.ey.n w() {
        return this.fs;
    }
}
