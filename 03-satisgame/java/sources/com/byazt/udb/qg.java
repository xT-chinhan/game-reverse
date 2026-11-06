package com.byazt.udb;

import android.content.Context;
import android.view.View;
import com.byazt.hne.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1064, 26})
public class qg implements tj {
    public oa l;
    public Context n;
    public fs q;
    public com.byazt.iv.n qg;
    public ThemeStatusBroadcastReceiver s;
    public int w;

    public qg(Context context, oa oaVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.hkc.fs fsVar, fs fsVar2, com.byazt.xnr.n nVar) {
        this(context, oaVar, themeStatusBroadcastReceiver, z, fsVar, fsVar2, nVar, null);
    }

    public qg(Context context, oa oaVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.hkc.fs fsVar, fs fsVar2, com.byazt.xnr.n nVar, com.byazt.iv.n nVar2) {
        this.n = context;
        this.l = oaVar;
        this.s = themeStatusBroadcastReceiver;
        this.q = fsVar2;
        if (nVar2 != null) {
            this.qg = nVar2;
        } else {
            this.qg = new com.byazt.iv.n(this.n, this.s, z, fsVar, this.l, nVar);
        }
        this.qg.n(this.q);
        if (fsVar instanceof com.byazt.hkc.x) {
            this.w = 3;
        } else {
            this.w = 2;
        }
    }

    public void n(boolean z) {
        this.qg.s(z);
    }

    @Override // com.byazt.udb.tj
    public boolean n(final tj.n nVar) {
        this.l.x().n(this.w);
        this.qg.n(new x() { // from class: com.byazt.udb.qg.1
            @Override // com.byazt.udb.x
            public void n(View view, sz szVar) {
                if (nVar.s()) {
                    return;
                }
                qg.this.l.x().l(qg.this.w);
                qg.this.l.x().w(qg.this.w);
                qg.this.l.x().oa();
                k kVarQg = nVar.qg();
                if (kVarQg == null) {
                    return;
                }
                kVarQg.n(qg.this.qg, szVar);
                nVar.n(true);
            }

            @Override // com.byazt.udb.x
            public void n(int i, String str) {
                qg.this.l.x().n(qg.this.w, i, str, nVar.qg(qg.this));
                if (nVar.qg(qg.this)) {
                    nVar.n(qg.this);
                    return;
                }
                k kVarQg = nVar.qg();
                if (kVarQg == null) {
                    return;
                }
                kVarQg.a_(i);
            }
        });
        return true;
    }

    @Override // com.byazt.udb.tj
    public void qg(boolean z) {
        com.byazt.iv.n nVar = this.qg;
        if (nVar != null) {
            nVar.n(z);
        }
    }

    public com.byazt.tq.q n() {
        com.byazt.iv.n nVar = this.qg;
        if (nVar != null) {
            return nVar.l();
        }
        return null;
    }
}
