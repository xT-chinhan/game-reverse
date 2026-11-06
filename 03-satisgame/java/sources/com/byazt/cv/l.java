package com.byazt.cv;

import android.content.Context;
import com.byazt.vh.ou;
import com.byazt.vh.py;
import com.byazt.vh.sz;
import com.byazt.xz.cy;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1039, 18})
public class l extends com.byazt.et.qg implements ou {
    public com.byazt.tk.ou cp;

    @Override // com.byazt.vh.ou
    public void n() {
    }

    @Override // com.byazt.vh.ou
    public void n(py pyVar) {
    }

    @Override // com.byazt.vh.ou
    public void n(JSONObject jSONObject) {
    }

    @Override // com.byazt.vh.ou
    public void qg() {
    }

    @Override // com.byazt.vh.ou
    public void s() {
    }

    public l(Context context) {
        super(context);
        this.cp = new com.byazt.tk.ou(context, 1, com.byazt.vyf.s.cy().q());
    }

    private int d() {
        JSONObject jSONObjectN;
        if (this.qg == null) {
            return 0;
        }
        JSONObject jSONObjectTj = this.qg.tj();
        if (jSONObjectTj != null) {
            return jSONObjectTj.optInt("meta_hashcode", 0);
        }
        sz szVarF = this.qg.f();
        if (szVarF == null || (jSONObjectN = szVarF.n()) == null) {
            return 0;
        }
        return jSONObjectN.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        Map<String, Object> mapQg;
        this.qg.n(this);
        if (this.cp == null) {
            this.cp = new com.byazt.tk.ou(this.tj, 1, com.byazt.vyf.s.cy().q());
        }
        sz szVarF = this.qg.f();
        if (szVarF == null || (mapQg = szVarF.qg()) == null) {
            return false;
        }
        Object obj = mapQg.get("shake_value");
        if (obj instanceof Integer) {
            this.cp.n(((Integer) obj).floatValue());
        }
        Object obj2 = mapQg.get("calculation_method");
        if (obj2 instanceof Integer) {
            this.cp.l(((Integer) obj2).intValue());
        }
        Object obj3 = mapQg.get("shake_interact_conf");
        if (obj3 instanceof JSONObject) {
            this.cp.s((JSONObject) obj3);
        }
        Object obj4 = mapQg.get("rotation_angle");
        if (obj4 instanceof Integer) {
            this.cp.qg(((Integer) obj4).floatValue());
        }
        Object obj5 = mapQg.get("twist_config");
        if (obj5 instanceof JSONObject) {
            this.cp.n((JSONObject) obj5);
        }
        Object obj6 = mapQg.get("twist_interact_conf");
        if (obj6 instanceof JSONObject) {
            this.cp.qg((JSONObject) obj6);
        }
        Object obj7 = mapQg.get("calculation_method_twist");
        if (!(obj7 instanceof Integer)) {
            return false;
        }
        this.cp.w(((Integer) obj7).intValue());
        return false;
    }

    @Override // com.byazt.vh.ou
    public void q() {
        if (this.cp == null || !this.qg.rv().isShown()) {
            return;
        }
        this.cp.n(new com.byazt.tk.ou.n() { // from class: com.byazt.cv.l.1
            @Override // com.byazt.tk.ou.n
            public void n(int i) {
                if (i != 1 || l.this.oa() || l.this.n == null) {
                    return;
                }
                l.this.n.n(l.this.qg, l.this.w, l.this.s.qg(), l.this.s);
            }
        });
        this.cp.n(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa() {
        sz szVarF;
        cy cyVarS;
        if (this.qg == null || this.qg.f() == null || (cyVarS = (szVarF = this.qg.f()).s()) == null || !cyVarS.n("shake", "")) {
            return false;
        }
        HashMap map = new HashMap();
        map.put(TapEventParamConstants.PARAM_NAME, this.qg.v());
        cyVarS.n(szVarF.q(), "shake", map);
        return true;
    }

    @Override // com.byazt.vh.ou
    public void l() {
        com.byazt.tk.ou ouVar = this.cp;
        if (ouVar != null) {
            ouVar.qg(d());
        }
    }

    @Override // com.byazt.vh.ou
    public void n(boolean z) {
        com.byazt.tk.ou ouVar = this.cp;
        if (ouVar != null) {
            if (z) {
                ouVar.n(d());
            } else {
                ouVar.qg(d());
            }
        }
    }
}
