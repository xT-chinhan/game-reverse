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
@com.byazt.cp.n(n = {0, 1, 1039, 13})
public class w extends com.byazt.et.qg implements ou {
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

    public w(Context context) {
        super(context);
        this.cp = new com.byazt.tk.ou(context, 2, com.byazt.vyf.s.cy().q());
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        this.qg.n(this);
        if (this.cp == null) {
            this.cp = new com.byazt.tk.ou(this.tj, 2, com.byazt.vyf.s.cy().q());
        }
        sz szVarF = this.qg.f();
        if (szVarF == null) {
            return false;
        }
        Map<String, Object> mapQg = szVarF.qg();
        if (mapQg != null) {
            Object obj = mapQg.get("rotation_angle");
            if (obj instanceof Integer) {
                this.cp.qg(((Integer) obj).floatValue());
            }
            Object obj2 = mapQg.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.cp.w(((Integer) obj2).intValue());
            }
            Object obj3 = mapQg.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.cp.n((JSONObject) obj3);
            }
            Object obj4 = mapQg.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.cp.qg((JSONObject) obj4);
            }
        }
        this.cp.n(new com.byazt.tk.ou.n() { // from class: com.byazt.cv.w.1
            @Override // com.byazt.tk.ou.n
            public void n(int i) {
                if (i != 2 || w.this.d() || w.this.n == null) {
                    return;
                }
                w.this.n.n(w.this.qg, w.this.w, w.this.s.qg(), w.this.s);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        sz szVarF;
        cy cyVarS;
        if (this.qg == null || this.qg.f() == null || (cyVarS = (szVarF = this.qg.f()).s()) == null || !cyVarS.n("twist", "")) {
            return false;
        }
        HashMap map = new HashMap();
        map.put(TapEventParamConstants.PARAM_NAME, this.qg.v());
        cyVarS.n(szVarF.q(), "twist", map);
        return true;
    }

    private int oa() {
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

    @Override // com.byazt.vh.ou
    public void q() {
        if (this.cp == null || !this.qg.rv().isShown()) {
            return;
        }
        this.cp.n(oa());
    }

    @Override // com.byazt.vh.ou
    public void l() {
        com.byazt.tk.ou ouVar = this.cp;
        if (ouVar != null) {
            ouVar.qg(oa());
        }
    }

    @Override // com.byazt.vh.ou
    public void n(boolean z) {
        com.byazt.tk.ou ouVar = this.cp;
        if (ouVar != null) {
            if (z) {
                ouVar.n(oa());
            } else {
                ouVar.qg(oa());
            }
        }
    }
}
