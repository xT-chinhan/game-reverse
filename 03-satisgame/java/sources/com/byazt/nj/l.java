package com.byazt.nj;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.mr.EmptyView;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1070, 18})
public final class l {
    public EmptyView l;
    public final n n;
    public w q;
    public final Queue<w> qg = new ArrayDeque();
    public com.byazt.nj.n s;

    public interface n {
        Context getContext();

        boolean l();

        ViewGroup n();

        void n(boolean z, boolean z2);

        boolean q();

        pk qg();

        String s();
    }

    public l(n nVar) {
        this.n = nVar;
    }

    public void n(boolean z, boolean z2) {
        if (this.n == null) {
            return;
        }
        com.byazt.nj.n nVarS = s();
        if (!nVarS.s()) {
            this.n.n(z, z2);
            return;
        }
        nVarS.n(this.n.qg(), true);
        this.qg.offer(new w(z, z2));
        q();
    }

    public void qg(boolean z, boolean z2) {
        n nVar = this.n;
        if (nVar == null) {
            return;
        }
        nVar.n(z, z2);
    }

    public void n() {
        com.byazt.nj.n nVar;
        qg();
        if (this.n == null || (nVar = this.s) == null) {
            return;
        }
        n(nVar.qg(false));
    }

    private void qg() {
        this.qg.clear();
        this.q = null;
        EmptyView emptyView = this.l;
        if (emptyView != null) {
            emptyView.setNeedCheckingShow(false);
            this.l = null;
        }
    }

    private com.byazt.nj.n s() {
        if (this.s == null) {
            this.s = new com.byazt.nj.n(x());
            this.s.qg(this.n.qg(), w());
            n(this.s.qg(false));
        }
        return this.s;
    }

    private void q() {
        if (this.q != null || this.qg.isEmpty()) {
            return;
        }
        if (this.n.l() || this.n.n() == null) {
            qg();
            return;
        }
        this.q = this.qg.poll();
        s().qg();
        l().setNeedCheckingShow(true);
    }

    private EmptyView l() {
        if (this.l == null) {
            EmptyView emptyView = new EmptyView(this.n.getContext(), this.n.n(), x());
            this.l = emptyView;
            emptyView.setOnlyShowThresholdCheck(true);
            this.l.n(this.n.qg(), this.n.s());
            this.l.setAdType(w());
            this.l.setShowThresholdCheckController(s());
            this.l.setCallback(new EmptyView.n() { // from class: com.byazt.nj.l.1
                @Override // com.byazt.mr.EmptyView.n
                public void n() {
                }

                @Override // com.byazt.mr.EmptyView.n
                public void n(boolean z) {
                }

                @Override // com.byazt.mr.EmptyView.n
                public void qg() {
                }

                @Override // com.byazt.mr.EmptyView.n
                public void n(View view, Map<String, Object> map) {
                    l.this.fs();
                }
            });
            this.l.setNeedCheckingShow(false);
            this.l.setSkipAttachShowCheck(true);
            this.n.n().addView(this.l);
        }
        return this.l;
    }

    private int w() {
        return this.n.q() ? 7 : 8;
    }

    private int x() {
        pk pkVarQg = this.n.qg();
        if (pkVarQg != null) {
            return pkVarQg.yq();
        }
        return 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        w wVar = this.q;
        if (wVar == null) {
            return;
        }
        this.n.n(wVar.n(), this.q.qg());
        this.q = null;
        q();
    }

    private void n(qg qgVar) {
        com.byazt.nj.n.n(this.n.qg(), qgVar);
    }
}
