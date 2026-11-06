package com.byazt.uq;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.byazt.hg.r;
import com.byazt.wt.ls;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 109})
public class w {
    public List<com.byazt.tg.uc> c;
    public pr hn;
    public com.byazt.qe.hw hw;
    public of pr;
    public Context x;

    public w(of ofVar, pr prVar) {
        this.pr = ofVar;
        this.hn = prVar;
        this.c = new ArrayList();
        if (ofVar != null && r.hw(ofVar)) {
            com.byazt.qd.uc.pr(ofVar, String.valueOf(ls.m(ofVar)), ls.k(ofVar), 3, com.byazt.ewt.fw.pr(ofVar));
            final int iC = b.c(this.pr);
            com.byazt.qd.uc.pr().pr(com.byazt.ewt.fw.pr(ofVar), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.w.1
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.zo) {
                        ((com.byazt.pv.zo) hwVar).hn = iC;
                    }
                }
            });
            com.byazt.qd.hw.pr().pr(com.byazt.ewt.fw.pr(ofVar), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.w.2
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).w = iC;
                    }
                }
            });
        }
    }

    public w(of ofVar, pr prVar, com.byazt.qe.hw hwVar, Context context) {
        this(ofVar, prVar);
        this.hw = hwVar;
        this.x = context;
    }

    public void pr(ViewGroup viewGroup, View view) {
        final List<bh> listPr;
        hw(viewGroup, view);
        if (!r.hw(this.pr) || (listPr = r.pr(this.pr)) == null || listPr.isEmpty()) {
            return;
        }
        if (listPr.get(0) != null) {
            com.byazt.qd.uc.pr().pr(com.byazt.ewt.fw.pr(this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.w.3
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.zo) {
                        com.byazt.pv.zo zoVar = (com.byazt.pv.zo) hwVar;
                        zoVar.hw = ((bh) listPr.get(0)).c();
                        zoVar.c = ((bh) listPr.get(0)).x();
                    }
                }
            });
            com.byazt.qd.hw.pr().pr(com.byazt.ewt.fw.pr(this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.w.4
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).vk = ((bh) listPr.get(0)).c();
                    }
                }
            });
        }
        com.byazt.qd.uc.hw(com.byazt.ewt.fw.pr(this.pr));
        for (bh bhVar : listPr) {
            if (bhVar != null) {
                hn.pr(this.pr, bhVar);
                com.byazt.tg.uc ucVar = new com.byazt.tg.uc(this.pr, this.hn, bhVar);
                ucVar.pr(this.hw);
                ucVar.pr(this.x);
                ucVar.hw(viewGroup, bhVar.x() == 0 ? viewGroup : view);
                this.c.add(ucVar);
            }
        }
    }

    private void hw(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("overlay_tag".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("overlay_tag".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                }
            }
        }
    }

    public void pr() {
        for (com.byazt.tg.uc ucVar : this.c) {
            if (ucVar != null) {
                ucVar.pr((com.byazt.qe.hw) null);
                ucVar.pr((Context) null);
                ucVar.uc();
            }
        }
        this.c.clear();
    }
}
