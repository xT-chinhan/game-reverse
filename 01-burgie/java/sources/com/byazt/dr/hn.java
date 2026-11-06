package com.byazt.dr;

import android.content.Context;
import android.view.View;
import com.byazt.ca.ho;
import com.byazt.hr.RecyclerView;
import com.byazt.hr.aj;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1091, 20})
public class hn extends com.byazt.hr.c {
    public int a;
    public int cz;
    public int fo;
    public boolean lb;
    public boolean ny;
    public final aj qa;
    public pr rc;
    public final RecyclerView.w z;

    public interface pr {
        void pr();

        void pr(boolean z, int i);

        void pr(boolean z, int i, boolean z2);
    }

    public hn(Context context, int i, boolean z) {
        super(context, i, z);
        this.ny = false;
        this.lb = true;
        this.z = new RecyclerView.w() { // from class: com.byazt.dr.hn.1
            @Override // com.byazt.hr.RecyclerView.w
            public void pr(View view) {
                if (hn.this.rc != null && hn.this.qa() == 1) {
                    hn.this.rc.pr();
                }
            }

            @Override // com.byazt.hr.RecyclerView.w
            public void hw(View view) {
                if (hn.this.rc != null) {
                    hn.this.rc.pr(hn.this.a >= 0, hn.this.x(view));
                }
            }
        };
        this.qa = new aj();
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void hn(RecyclerView recyclerView) {
        super.hn(recyclerView);
        this.qa.pr(recyclerView);
        recyclerView.pr(this.z);
    }

    @Override // com.byazt.hr.c, com.byazt.hr.RecyclerView.aj
    public void pr(RecyclerView recyclerView, RecyclerView.nt ntVar) {
        super.pr(recyclerView, ntVar);
        try {
            c cVar = (c) recyclerView.hn(this.fo);
            if (cVar != null) {
                cVar.gz();
            }
        } catch (Exception e) {
            ho.pr("cubic detached exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void w(int i) {
        boolean z;
        pr prVar;
        boolean z2;
        this.cz = i;
        if (i == 0) {
            View viewPr = this.qa.pr(this);
            boolean z3 = false;
            if (viewPr == null) {
                z = true;
            } else {
                int iX = x(viewPr);
                if (this.fo == iX) {
                    z = true;
                } else {
                    z = false;
                }
                this.fo = iX;
            }
            if (this.ny) {
                this.ny = false;
                if (!z && (prVar = this.rc) != null) {
                    if (this.a >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i2 = this.fo;
                    if (i2 == gz() - 1) {
                        z3 = true;
                    }
                    prVar.pr(z2, i2, z3);
                }
            }
        }
        if (i == 2) {
            this.ny = true;
        }
    }

    public void hw(boolean z) {
        this.lb = z;
    }

    @Override // com.byazt.hr.c, com.byazt.hr.RecyclerView.aj
    public int hw(int i, RecyclerView.nt ntVar, RecyclerView.a aVar) {
        this.a = i;
        return super.hw(i, ntVar, aVar);
    }

    @Override // com.byazt.hr.c, com.byazt.hr.RecyclerView.aj
    public int pr(int i, RecyclerView.nt ntVar, RecyclerView.a aVar) {
        this.a = i;
        return super.pr(i, ntVar, aVar);
    }

    public void pr(pr prVar) {
        this.rc = prVar;
    }
}
