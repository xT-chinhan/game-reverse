package com.byazt.ck;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.byazt.cy.tj;
import com.byazt.fvm.q;
import com.byazt.fvm.sz;
import com.byazt.fvm.x;
import com.byazt.np.cp;
import com.byazt.nq.l;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1900, 19})
public class n extends sz {
    public com.byazt.mi.qg fs;
    public View l = null;
    public final cp n;
    public com.byazt.fx.qg q;
    public com.byazt.lr.n qg;
    public com.byazt.fx.n s;
    public com.byazt.mi.s w;
    public com.byazt.fx.s x;

    @Override // com.byazt.fvm.sz
    public void n(int i) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.sz
    public void n(JSONObject jSONObject) {
    }

    @Override // com.byazt.fvm.sz
    public void n(boolean z) {
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    @Override // com.byazt.fvm.sz
    public String tj() {
        return null;
    }

    @Override // com.byazt.fvm.sz
    public void x() {
    }

    public n(cp cpVar) {
        this.n = cpVar;
        cp();
    }

    private void cp() {
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.n(new com.byazt.gl.n() { // from class: com.byazt.ck.n.1
                @Override // com.byazt.gl.n
                public void n(com.byazt.mj.n nVar) {
                }

                @Override // com.byazt.gl.n
                public void n() {
                    if (n.this.qg != null) {
                        n.this.qg.n(0, "ad closed", true);
                    }
                    if (n.this.s != null) {
                        n.this.s.n();
                    }
                }

                @Override // com.byazt.gl.n
                public void n(View view) {
                    if (n.this.q != null) {
                        n.this.q.n(view, 0);
                    }
                    if (n.this.s != null) {
                        n.this.s.n(view, 0);
                    }
                }

                @Override // com.byazt.gl.n
                public void qg(View view) {
                    if (n.this.q != null) {
                        n.this.q.qg(view, 0);
                    }
                    if (n.this.s != null) {
                        n.this.s.qg(view, 0);
                    }
                }
            });
        }
    }

    private void d() {
        com.byazt.mi.s sVar;
        cp cpVar = this.n;
        if (cpVar == null || (sVar = this.w) == null) {
            return;
        }
        cpVar.n(sVar);
    }

    private void sz() {
        com.byazt.mi.qg qgVar;
        cp cpVar = this.n;
        if (cpVar == null || (qgVar = this.fs) == null) {
            return;
        }
        cpVar.n(qgVar);
    }

    private void k() {
        com.byazt.fx.s sVar;
        cp cpVar = this.n;
        if (cpVar == null || (sVar = this.x) == null) {
            return;
        }
        cpVar.n(sVar);
    }

    @Override // com.byazt.fvm.sz
    public View n() {
        cp cpVar;
        if (this.l == null && (cpVar = this.n) != null) {
            this.l = cpVar.l();
        }
        d();
        k();
        sz();
        return this.l;
    }

    @Override // com.byazt.fvm.sz
    public int qg() {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar.w();
        }
        return 0;
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.qg qgVar) {
        this.q = qgVar;
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.n nVar) {
        this.s = nVar;
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.mi.s sVar) {
        this.w = sVar;
        d();
    }

    @Override // com.byazt.fvm.sz
    public int s() {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar.oa();
        }
        return -1;
    }

    @Override // com.byazt.fvm.sz
    public void q() {
        com.byazt.fx.qg qgVar = this.q;
        if (qgVar != null) {
            qgVar.n(this.l, 0.0f, 0.0f);
        }
        com.byazt.fx.n nVar = this.s;
        if (nVar != null) {
            nVar.n(this.l, 0.0f, 0.0f);
        }
    }

    @Override // com.byazt.fvm.sz
    public void l() {
        if (this.l != null) {
            this.l = null;
        }
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.s();
        }
        if (this.w != null) {
            this.w = null;
        }
        if (this.x != null) {
            this.x = null;
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(Activity activity, com.byazt.lr.n nVar) {
        this.qg = nVar;
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.n(activity, nVar);
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(Dialog dialog, Integer[] numArr) {
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.n(dialog, numArr);
        }
    }

    @Override // com.byazt.fvm.sz
    public void n(String str) {
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.n(str);
        }
    }

    @Override // com.byazt.fvm.sz
    public x n(Activity activity) {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar.n(activity);
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public q w() {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar.sz();
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public void n(com.byazt.fx.s sVar) {
        this.x = sVar;
        k();
    }

    @Override // com.byazt.fvm.sz
    public Map<String, Object> fs() {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar.x();
        }
        return null;
    }

    @Override // com.byazt.fvm.sz
    public l rv() {
        return new tj(new qg(this.n));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        this.fs = qgVar;
        cp cpVar = this.n;
        if (cpVar != null) {
            cpVar.n(qgVar);
        }
    }
}
