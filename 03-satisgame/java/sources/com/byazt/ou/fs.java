package com.byazt.ou;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byazt.gct.g;
import com.byazt.gct.pk;
import com.byazt.udb.sz;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 849, 101})
public class fs extends com.byazt.ou.n {
    public n w;
    public View x;

    public interface n {
        void n();

        void n(ViewGroup viewGroup);
    }

    public fs(pk pkVar, com.byazt.rg.n nVar, g gVar) {
        super(pkVar, nVar, gVar);
    }

    public void n(n nVar) {
        this.w = nVar;
    }

    @Override // com.byazt.ou.n
    public void n(ViewGroup viewGroup, View view, View view2, float[] fArr, sz szVar) {
        if (viewGroup == null || view2 == null) {
            n(false, viewGroup == null ? 101 : 102);
            n(viewGroup);
            return;
        }
        View view3 = this.x;
        if (view3 != null && view3 != view2) {
            d();
        }
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        this.x = view2;
        view2.setVisibility(0);
        n(true, 0);
        FrameLayout frameLayoutCy = szVar instanceof com.byazt.gn.q ? ((com.byazt.gn.q) szVar).cy() : null;
        n nVar = this.w;
        if (nVar != null) {
            nVar.n(frameLayoutCy);
        }
    }

    private void n(boolean z, int i) {
        com.byazt.de.w.s(com.byazt.de.x.n(this.n), z ? 1 : 2);
        com.byazt.rg.s.qg(this.n, this.q, z, i, null);
    }

    public void cp() {
        d();
    }

    private void d() {
        View view = this.x;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.x = null;
    }

    @Override // com.byazt.ou.n
    public void n(ViewGroup viewGroup) {
        final n nVar = this.w;
        if (nVar == null) {
            return;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ou.fs.1
            @Override // java.lang.Runnable
            public void run() {
                nVar.n();
            }
        });
    }
}
