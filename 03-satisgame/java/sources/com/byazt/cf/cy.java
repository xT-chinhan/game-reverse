package com.byazt.cf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public static py n;
    public final List<sz> l;
    public final tj q;
    public final n qg;
    public final com.byazt.uad.q s;
    public volatile boolean w;

    public static tj n(com.byazt.uad.q qVar) {
        return new tj(qVar);
    }

    public <T> void n(String str, T t) {
        qg();
        this.qg.n(str, t);
    }

    public cy n(String str, l<?, ?> lVar) {
        return n(str, (String) null, lVar);
    }

    public cy n(String str, String str2, l<?, ?> lVar) {
        qg();
        this.qg.w.n(str, lVar);
        return this;
    }

    public cy n(String str, q.qg qgVar) {
        return n(str, (String) null, qgVar);
    }

    public cy n(String str, String str2, q.qg qgVar) {
        qg();
        this.qg.w.n(str, qgVar);
        return this;
    }

    public boolean n(String str) {
        n nVar = this.qg;
        if (nVar == null || nVar.w == null) {
            return false;
        }
        return this.qg.w.n(str);
    }

    public void n() {
        if (this.w) {
            return;
        }
        this.qg.s();
        this.w = true;
        Iterator<sz> it = this.l.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public cy(tj tjVar) {
        py pyVar;
        ArrayList arrayList = new ArrayList();
        this.l = arrayList;
        this.w = false;
        this.q = tjVar;
        a aVarN = (!tjVar.fs || (pyVar = n) == null) ? null : pyVar.n(tjVar.cp);
        if (tjVar.n != null && tjVar.qg == null) {
            this.qg = new m();
        } else {
            this.qg = tjVar.qg;
        }
        this.qg.n(tjVar.s());
        this.qg.n(tjVar, aVarN);
        this.s = tjVar.n;
        arrayList.add(tjVar.tj);
        rv.n(tjVar.w);
        wm.n(tjVar.x);
    }

    private void qg() {
        if (this.w) {
            rv.n(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
