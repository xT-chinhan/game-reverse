package com.byazt.tx;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.bb;
import com.byazt.gct.pk;
import com.byazt.ou.w;
import com.byazt.sj.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1052, 19})
public class n {
    public final pk n;
    public final AtomicBoolean q = new AtomicBoolean(false);
    public final bb qg;
    public w s;

    public n(pk pkVar) {
        this.n = pkVar;
        this.qg = pkVar != null ? pkVar.tk() : null;
    }

    public boolean n() {
        bb bbVar = this.qg;
        return bbVar != null && bbVar.s();
    }

    public void n(FrameLayout frameLayout, View view) {
        if (!n() || frameLayout == null) {
            return;
        }
        s();
        w wVar = new w(this.n, this.qg);
        this.s = wVar;
        wVar.n(frameLayout);
        w wVar2 = this.s;
        if (view == null) {
            view = frameLayout;
        }
        wVar2.qg(frameLayout, view);
    }

    public void n(ViewGroup viewGroup, View view) {
        if (!n() || viewGroup == null) {
            return;
        }
        s();
        w wVar = new w(this.n, this.qg);
        this.s = wVar;
        wVar.qg(viewGroup);
        w wVar2 = this.s;
        if (view == null) {
            view = viewGroup;
        }
        wVar2.qg(viewGroup, view);
    }

    private void s() {
        w wVar = this.s;
        if (wVar != null) {
            wVar.x();
            this.s = null;
        }
    }

    public void n(boolean z) {
        w wVar = this.s;
        if (wVar == null || wVar.n() == null) {
            return;
        }
        this.s.n().qg(z);
    }

    public void qg() {
        if (this.q.compareAndSet(false, true) && n() && this.s != null) {
            pk pkVar = this.n;
            com.byazt.sj.q.n(pkVar, l.n(pkVar != null ? pkVar.py() : null));
            this.s.x();
        }
    }
}
