package com.byazt.dl;

import android.content.Context;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 671, 37})
public class pr extends com.byazt.ln.pr {
    public hw c = new hw();

    /* JADX INFO: renamed from: com.byazt.dl.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0041pr {
        void pr(View view, int i);
    }

    public void pr(int i) {
        this.c.hw(i);
    }

    public void pr(Map<String, Object> map) {
        this.c.pr(map);
    }

    public void pr(String str) {
        this.c.pr(str);
    }

    public void pr(boolean z) {
        this.c.pr(z);
    }

    public void pr(of ofVar) {
        this.pr = ofVar;
        this.c.pr(ofVar);
    }

    public void pr(Context context) {
        this.hw = context;
        this.c.pr(context);
    }

    public void pr(com.byazt.nv.hn hnVar) {
        this.c.pr(hnVar);
    }

    public com.byazt.nv.hn pr() {
        return this.c.uc();
    }

    public void hw(boolean z) {
        this.c.x(z);
    }

    public void pr(Object obj) {
        this.c.pr(obj);
    }

    public void hn(boolean z) {
        this.c.hn(z);
    }

    public void pr(com.byazt.ng.pr prVar) {
        this.c.pr(prVar);
    }

    public void x(boolean z) {
        this.c.hw(z);
    }

    public void pr(InterfaceC0041pr interfaceC0041pr) {
        this.c.pr(interfaceC0041pr);
    }

    public void hw(int i) {
        if (!this.c.x()) {
            return;
        }
        this.c.pr(i);
    }

    public void pr(long j) {
        this.c.pr(j);
    }

    public void pr(com.byazt.ga.hw hwVar) {
        this.c.pr(hwVar);
    }

    public hw hw() {
        return this.c;
    }

    @Override // com.byazt.ln.pr
    public int pr(Map<String, Object> map, com.byazt.ln.hn hnVar) {
        return 0;
    }

    public void hn() {
        if (!this.c.hw() || !this.c.x()) {
            return;
        }
        com.byazt.nv.hn hnVarUc = this.c.uc();
        if (!(hnVarUc instanceof com.byazt.ri.pr)) {
            return;
        }
        ((com.byazt.ri.pr) hnVarUc).c(true);
    }

    public void x() {
        if (!this.c.x()) {
            return;
        }
        com.byazt.ng.pr prVarC = this.c.c();
        if (ls.x(this.pr) && prVarC != null) {
            prVarC.hw();
        }
    }
}
