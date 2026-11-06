package com.byazt.fj;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.hm.q;
import com.byazt.vh.a;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.vyf.l;
import com.byazt.xz.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 695, 26})
public class qg implements a, cd {
    public a l;
    public Context n;
    public n q;
    public q qg;
    public com.byazt.ih.s<View> s;
    public String w;
    public int x;

    interface n {
        void n(cy cyVar);
    }

    @Override // com.byazt.vh.cd
    public void n(com.byazt.ih.s sVar, String str, x.n nVar) {
    }

    public qg(Context context, q qVar, String str, int i) {
        this.n = context;
        this.qg = qVar;
        this.w = str;
        this.x = i;
    }

    public void n(n nVar) {
        this.q = nVar;
    }

    public void n(a aVar) {
        this.l = aVar;
    }

    public void n(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.ozc.x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(jSONObject, jSONObject2, xVar);
        } else {
            l.q().post(new Runnable() { // from class: com.byazt.fj.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.qg(jSONObject, jSONObject2, xVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ozc.x xVar) {
        k kVar = new k(this.n);
        com.byazt.ih.s<View> sVarN = kVar.n(jSONObject);
        this.s = sVarN;
        if (sVarN == null) {
            q qVar = this.qg;
            if (qVar != null) {
                qVar.n(-1, "ugeno render fail");
            }
            if (xVar != null) {
                xVar.n(-1, "");
                return;
            }
            return;
        }
        kVar.n((a) this);
        kVar.n((cd) this);
        kVar.qg(jSONObject2);
        this.qg.n(0L);
        if (xVar != null) {
            xVar.n(this.s);
        }
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        n nVar2;
        if (cyVar == null || cyVar.qg() != 1 || (nVar2 = this.q) == null) {
            return;
        }
        nVar2.n(cyVar);
    }

    @Override // com.byazt.vh.a
    public void n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        a aVar = this.l;
        if (aVar != null) {
            aVar.n(sVar, motionEvent);
        }
    }
}
