package com.byazt.ly;

import android.content.Context;
import android.view.View;
import com.byazt.prf.RecyclerView;
import com.byazt.prf.tj;
import com.byazt.prf.w;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 8})
public class s extends w {
    public final RecyclerView.cp fs;
    public boolean l;
    public boolean n;
    public int q;
    public final tj qg;
    public int s;
    public int w;
    public n x;

    public interface n {
        void n();

        void n(boolean z, int i);

        void n(boolean z, int i, boolean z2);
    }

    public s(Context context, int i, boolean z) {
        super(context, i, z);
        this.l = false;
        this.n = true;
        this.fs = new RecyclerView.cp() { // from class: com.byazt.ly.s.1
            @Override // com.byazt.prf.RecyclerView.cp
            public void n(View view) {
                if (s.this.x == null || s.this.py() != 1) {
                    return;
                }
                s.this.x.n();
            }

            @Override // com.byazt.prf.RecyclerView.cp
            public void qg(View view) {
                if (s.this.x != null) {
                    s.this.x.n(s.this.s >= 0, s.this.q(view));
                }
            }
        };
        this.qg = new tj();
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void q(RecyclerView recyclerView) {
        super.q(recyclerView);
        this.qg.n(recyclerView);
        recyclerView.n(this.fs);
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public void n(RecyclerView recyclerView, RecyclerView.cy cyVar) {
        super.n(recyclerView, cyVar);
        try {
            l lVar = (l) recyclerView.s(this.w);
            if (lVar != null) {
                lVar.bb();
            }
        } catch (Exception e) {
            k.n("cubic detached exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.prf.RecyclerView.rv
    public void d(int i) {
        boolean z;
        n nVar;
        this.q = i;
        if (i == 0) {
            View viewN = this.qg.n(this);
            if (viewN != null) {
                int iQ = q(viewN);
                z = this.w == iQ;
                this.w = iQ;
            } else {
                z = true;
            }
            if (this.l) {
                this.l = false;
                if (!z && (nVar = this.x) != null) {
                    boolean z2 = this.s >= 0;
                    int i2 = this.w;
                    nVar.n(z2, i2, i2 == lh() - 1);
                }
            }
        }
        if (i == 2) {
            this.l = true;
        }
    }

    public void qg(boolean z) {
        this.n = z;
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public int qg(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        this.s = i;
        return super.qg(i, cyVar, pyVar);
    }

    @Override // com.byazt.prf.w, com.byazt.prf.RecyclerView.rv
    public int n(int i, RecyclerView.cy cyVar, RecyclerView.py pyVar) {
        this.s = i;
        return super.n(i, cyVar, pyVar);
    }

    public void n(n nVar) {
        this.x = nVar;
    }
}
