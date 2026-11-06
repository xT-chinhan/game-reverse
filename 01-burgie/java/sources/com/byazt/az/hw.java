package com.byazt.az;

import android.content.Context;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.hg.vk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 513, 13})
public class hw extends x {
    public com.byazt.ln.hn c;
    public final int hn;
    public final String hw;
    public final of pr;
    public int x;

    public hw(Context context, of ofVar, String str, int i) {
        super(context);
        this.x = 1;
        this.pr = ofVar;
        this.hw = str;
        this.hn = i;
        c();
    }

    private void c() {
        com.byazt.ln.hn hnVarPr = this.zo.pr(this.pr, this.uc, this, pr());
        this.c = hnVarPr;
        hnVarPr.pr(this.fw);
        ((com.byazt.yx.pr) pr(com.byazt.yx.pr.class)).pr(this.hw);
        ((com.byazt.dl.pr) pr(com.byazt.dl.pr.class)).pr(this.hw);
        ((com.byazt.dl.pr) pr(com.byazt.dl.pr.class)).pr(this.hn);
        if (pr()) {
            ((com.byazt.dl.pr) pr(com.byazt.dl.pr.class)).x(true);
        }
    }

    public void pr(int i) {
        this.x = i;
        if (this.fw != null) {
            this.fw.pr(i);
        }
    }

    public void pr(vk vkVar) {
        this.fw = vkVar;
    }

    public vk hw() {
        return this.fw;
    }

    public void pr(View view) {
        this.fw.hw(view);
    }

    public void hw(View view) {
        this.fw.pr(view);
    }

    public void hw(int i) {
        this.fw.x(i);
    }

    public void hn(int i) {
        this.fw.hn(i);
    }

    public void x(int i) {
        this.fw.hw(i);
    }

    @Override // com.byazt.az.x
    public void pr(View view, vk vkVar) {
        if (of.uc(this.pr)) {
            return;
        }
        ((com.byazt.dl.pr) pr(com.byazt.dl.pr.class)).pr(((com.byazt.yx.pr) pr(com.byazt.yx.pr.class)).c());
        this.c.pr(view);
        if (vkVar == null) {
            vkVar = new vk();
        }
        this.c.pr(vkVar);
        this.c.hw();
        of.fw(this.pr);
    }

    public boolean pr() {
        return false;
    }
}
