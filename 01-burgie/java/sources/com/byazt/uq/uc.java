package com.byazt.uq;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.bh;
import com.byazt.hg.iu;
import com.byazt.hg.of;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 5})
public class uc {
    public Context c;
    public final List<com.byazt.tg.pr> hn;
    public final pr hw;
    public final of pr;
    public com.byazt.qe.hw x;

    public uc(of ofVar, pr prVar) {
        this.pr = ofVar;
        this.hw = prVar;
        this.hn = new ArrayList();
    }

    public uc(of ofVar, pr prVar, com.byazt.qe.hw hwVar, Context context) {
        this(ofVar, prVar);
        this.x = hwVar;
        this.c = context;
    }

    public void pr(ViewGroup viewGroup, View view) {
        List<bh> listX;
        hw(viewGroup, view);
        if (!iu.hw(this.pr) || (listX = iu.x(this.pr)) == null || listX.isEmpty()) {
            return;
        }
        for (bh bhVar : listX) {
            if (bhVar != null) {
                hn.pr(this.pr, bhVar);
                com.byazt.tg.x xVar = new com.byazt.tg.x(this.pr, this.hw, bhVar);
                xVar.pr(this.x);
                xVar.pr(this.c);
                xVar.hw(viewGroup, bhVar.x() == 0 ? viewGroup : view);
                this.hn.add(xVar);
            }
        }
    }

    public com.byazt.tg.fw pr() {
        bh bhVarHn = iu.hn(this.pr);
        if (bhVarHn == null) {
            return null;
        }
        hn.pr(this.pr, bhVarHn);
        com.byazt.tg.fw fwVar = new com.byazt.tg.fw(this.pr, this.hw, bhVarHn);
        fwVar.pr(this.x);
        fwVar.pr(this.c);
        this.hn.add(fwVar);
        return fwVar;
    }

    private void hw(ViewGroup viewGroup, View view) {
        pr(viewGroup);
        if (view instanceof ViewGroup) {
            pr((ViewGroup) view);
        }
    }

    private void pr(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("effects_tag".equals(childAt.getTag())) {
                viewGroup.removeView(childAt);
            }
        }
    }

    public void hw() {
        for (com.byazt.tg.pr prVar : this.hn) {
            if (prVar != null) {
                prVar.pr((com.byazt.qe.hw) null);
                prVar.pr((Context) null);
                prVar.uc();
            }
        }
        this.hn.clear();
    }
}
