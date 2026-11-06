package com.byazt.sj;

import android.content.Context;
import com.byazt.ee.CSJSpriteView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 83, 8})
public class s extends com.byazt.ih.s<CSJSpriteView> {
    public CSJSpriteView n;
    public com.byazt.kw.n sq;

    public s(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public CSJSpriteView n() {
        CSJSpriteView cSJSpriteView = new CSJSpriteView(this.qg);
        this.n = cSJSpriteView;
        return cSJSpriteView;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        if (this.sq != null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = m() != null ? m().optJSONObject("gameConfig") : null;
        String strQ = f() != null ? f().q() : null;
        com.byazt.dg.qg qgVarN = com.byazt.dg.n.n(jSONObjectOptJSONObject, tj());
        if (qgVarN == null) {
            return;
        }
        com.byazt.kw.n nVarN = com.byazt.kw.qg.n(this.qg, this.n, qgVarN, tj(), strQ);
        this.sq = nVarN;
        nVarN.s();
    }

    public n fs() {
        com.byazt.kw.n nVar = this.sq;
        if (nVar != null) {
            return nVar.qg();
        }
        return null;
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void l() {
        super.l();
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void w() {
        super.w();
        cx();
    }

    public void cx() {
        com.byazt.kw.n nVar = this.sq;
        if (nVar != null) {
            nVar.q();
        }
    }
}
