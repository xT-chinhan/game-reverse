package com.byazt.zc;

import android.os.Looper;
import android.os.Message;
import com.byazt.ep.cp;
import com.byazt.ep.s;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.tk.t;
import com.byazt.tn.qg;
import com.byazt.udb.fs;
import com.byazt.udb.x;
import com.byazt.vf.wo;
import com.byazt.vh.ou;
import com.byazt.za.py;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 30, 19})
public class n implements wo.n {
    public fs l;
    public t n = new t(Looper.getMainLooper(), this);
    public x q;
    public com.byazt.gn.fs qg;
    public final pk s;
    public qg w;

    public n(pk pkVar) {
        this.s = pkVar;
    }

    public void n(fs fsVar) {
        this.l = fsVar;
    }

    public void n(x xVar) {
        this.q = xVar;
    }

    public void n(qg qgVar) {
        this.w = qgVar;
    }

    public void n(String str, String str2, final int i, final int i2, int i3) {
        if (i3 > 0) {
            this.n.sendEmptyMessageDelayed(1, i3);
        }
        cp.n(str, str2, new s() { // from class: com.byazt.zc.n.1
            @Override // com.byazt.ep.s
            public void n(String str3) {
                try {
                    n nVar = n.this;
                    nVar.n(nVar.s, new JSONObject(str3), i, i2);
                } catch (Throwable unused) {
                    if (n.this.q != null) {
                        n.this.q.n(-1, "render fail");
                    }
                }
            }

            @Override // com.byazt.ep.s
            public void n() {
                if (n.this.q != null) {
                    n.this.q.n(-1, "request fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(pk pkVar, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
        } catch (Throwable unused) {
        }
        com.byazt.gn.s.n nVar = new com.byazt.gn.s.n();
        nVar.n(com.byazt.ns.qg.n(pkVar, jSONObject2, jSONObject, false, null, false));
        nVar.n((ou) new py());
        nVar.n(i);
        nVar.qg(0.0f);
        com.byazt.gn.fs fsVar = new com.byazt.gn.fs(rv.getContext(), null, nVar.n(), null);
        this.qg = fsVar;
        x xVar = this.q;
        if (xVar != null) {
            fsVar.n(xVar);
        }
        fs fsVar2 = this.l;
        if (fsVar2 != null) {
            this.qg.n(fsVar2);
        }
        qg qgVar = this.w;
        if (qgVar != null) {
            this.qg.n(qgVar);
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        x xVar;
        if (message.what == 1 && (xVar = this.q) != null) {
            xVar.n(-2, "render timeout");
        }
    }
}
