package com.byazt.md;

import android.content.Context;
import android.view.View;
import com.byazt.hg.fo;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.wt.er;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 238, 37})
public class pr extends hw {
    public com.byazt.qx.hn c;
    public int uc;

    public pr() {
    }

    public pr(of ofVar, Context context) {
        this.pr = ofVar;
        this.hw = context;
    }

    public void pr(com.byazt.qx.hn hnVar) {
        this.c = hnVar;
    }

    public void pr(int i) {
        this.uc = i;
    }

    @Override // com.byazt.ln.pr
    public void pr(View view) {
        this.x = view;
    }

    @Override // com.byazt.ln.pr
    public int pr(Map<String, Object> map, com.byazt.ln.hn hnVar) {
        if (this.c == null) {
            return 0;
        }
        if (this.hn == null) {
            this.hn = new vk();
        }
        View viewVk = this.hn.vk();
        int[] iArrPr = new int[2];
        int[] iArrHn = new int[2];
        if (viewVk != null) {
            iArrPr = er.pr(viewVk);
            iArrHn = er.hn(viewVk);
        }
        this.c.pr(this.x, this.uc, new fo.pr().x(this.hn.lb()).hn(this.hn.qa()).hw(this.hn.a()).pr(this.hn.cz()).hw(this.hn.nt()).pr(this.hn.yb()).pr(iArrPr[0]).hw(iArrPr[1]).hn(iArrHn[0]).x(iArrHn[1]).pr(this.hn.aj()).pr(this.hn.g()).pr());
        return 1;
    }
}
