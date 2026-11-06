package com.byazt.ey;

import com.byazt.ih.s;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.xz.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1415, 26})
public abstract class qg implements cd {
    public cd n;
    public JSONObject q;
    public String qg;
    public boolean s = true;
    public boolean l = false;

    public abstract void s(cy cyVar, cd.qg qgVar, cd.n nVar);

    public qg(cd cdVar) {
        this.n = cdVar;
    }

    public void n(JSONObject jSONObject) {
        this.q = jSONObject;
    }

    public void n(String str) {
        this.qg = str;
    }

    public void n(boolean z) {
        this.s = z;
    }

    public boolean n() {
        String str;
        return this.s && (str = this.qg) != null && "3".compareTo(str) <= 0 && this.q != null;
    }

    public void qg(boolean z) {
        this.l = z;
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        if (n()) {
            s(cyVar, qgVar, nVar);
        } else {
            qg(cyVar, qgVar, nVar);
        }
    }

    @Override // com.byazt.vh.cd
    public void n(s sVar, String str, x.n nVar) {
        cd cdVar = this.n;
        if (cdVar == null) {
            return;
        }
        cdVar.n(sVar, str, nVar);
    }

    public void qg(cy cyVar, cd.qg qgVar, cd.n nVar) {
        cd cdVar = this.n;
        if (cdVar == null) {
            return;
        }
        cdVar.n(cyVar, qgVar, nVar);
    }
}
