package com.byazt.fc;

import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.dg.qg;
import com.byazt.ee.CSJSpriteView;
import com.byazt.pp.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2353, 19})
public class n extends com.byazt.kw.n {
    public String cp;
    public double cy;
    public int d;
    public double k;
    public double oa;
    public double sz;
    public boolean tj;

    public n(Context context, CSJSpriteView cSJSpriteView, qg qgVar, JSONObject jSONObject, String str) {
        super(context, cSJSpriteView, qgVar, jSONObject, str);
        this.tj = false;
    }

    @Override // com.byazt.kw.n
    public com.byazt.eu.n n(qg qgVar, double d, double d2) {
        return new com.byazt.eb.n(qgVar, d, d2);
    }

    @Override // com.byazt.kw.n
    public void n(com.byazt.eu.n nVar) {
        nVar.n(new com.byazt.eu.n.l() { // from class: com.byazt.fc.n.1
            @Override // com.byazt.eu.n.l
            public void n(String str, int i, double d, double d2, double d3, double d4) {
                n.this.cp = str;
                n.this.d = i;
                n.this.oa = d;
                n.this.sz = d2;
                n.this.k = d3;
                n.this.cy = d4;
                n.this.tj = true;
                n.this.l();
            }

            @Override // com.byazt.eu.n.l
            public void n(double d, double d2, double d3) {
                n.this.qg.n(d, d2, d3);
            }

            @Override // com.byazt.eu.n.l
            public void n() {
                n.this.tj = false;
                n.this.qg.q();
            }
        });
    }

    @Override // com.byazt.kw.n
    public void n(String str) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String str;
        com.byazt.tl.n nVarN = n();
        if (!this.tj || nVarN == null || (str = this.cp) == null) {
            return;
        }
        if (this.d == 1) {
            w wVarQg = nVarN.qg(str);
            if (wVarQg == null) {
                return;
            }
            this.qg.qg(wVarQg, this.q, this.oa, this.sz, this.k, this.cy);
            return;
        }
        Bitmap bitmapN = nVarN.n(str);
        if (bitmapN == null) {
            return;
        }
        this.qg.n(bitmapN, this.oa, this.sz, this.k, this.cy);
    }
}
