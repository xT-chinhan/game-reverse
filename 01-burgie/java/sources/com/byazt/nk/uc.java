package com.byazt.nk;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import com.byazt.ch.cz;
import com.byazt.ch.g;
import com.byazt.ch.ny;
import com.byazt.sd.zo;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 5})
public class uc extends com.byazt.xv.hw implements ny {
    public com.byazt.ca.ny w;

    public uc(Context context) {
        super(context);
        this.w = new com.byazt.ca.ny(context, 2, zo.nt().x());
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        this.hw.pr(this);
        if (this.w == null) {
            this.w = new com.byazt.ca.ny(this.vk, 2, zo.nt().x());
        }
        g gVarLs = this.hw.ls();
        if (gVarLs != null) {
            Map<String, Object> mapHw = gVarLs.hw();
            if (mapHw != null) {
                Object obj = mapHw.get("rotation_angle");
                if (obj instanceof Integer) {
                    this.w.hw(((Integer) obj).floatValue());
                }
                Object obj2 = mapHw.get("calculation_method_twist");
                if (obj2 instanceof Integer) {
                    this.w.uc(((Integer) obj2).intValue());
                }
                Object obj3 = mapHw.get("twist_config");
                if (obj3 instanceof JSONObject) {
                    this.w.pr((JSONObject) obj3);
                }
                Object obj4 = mapHw.get("twist_interact_conf");
                if (obj4 instanceof JSONObject) {
                    this.w.hw((JSONObject) obj4);
                }
            }
            this.w.pr(new com.byazt.ca.ny.pr() { // from class: com.byazt.nk.uc.1
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    if (uc.this.pr != null && i == 2) {
                        uc.this.pr.pr(uc.this.hw, uc.this.uc, uc.this.hn.hw(), uc.this.hn);
                    }
                }
            });
            return false;
        }
        return false;
    }

    @Override // com.byazt.ch.ny
    public void pr() {
    }

    @Override // com.byazt.ch.ny
    public void hw() {
    }

    @Override // com.byazt.ch.ny
    public void hn() {
    }

    @Override // com.byazt.ch.ny
    public void pr(cz czVar) {
    }

    @Override // com.byazt.ch.ny
    public void pr(JSONObject jSONObject) {
    }

    private int k() {
        JSONObject jSONObjectPr;
        if (this.hw == null) {
            return 0;
        }
        JSONObject jSONObjectVk = this.hw.vk();
        if (jSONObjectVk != null) {
            return jSONObjectVk.optInt("meta_hashcode", 0);
        }
        g gVarLs = this.hw.ls();
        if (gVarLs == null || (jSONObjectPr = gVarLs.pr()) == null) {
            return 0;
        }
        return jSONObjectPr.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.ch.ny
    public void x() {
        if (this.w != null && this.hw.aj().isShown()) {
            this.w.pr(k());
        }
    }

    @Override // com.byazt.ch.ny
    public void c() {
        com.byazt.ca.ny nyVar = this.w;
        if (nyVar != null) {
            nyVar.hw(k());
        }
    }

    @Override // com.byazt.ch.ny
    public void pr(boolean z) {
        com.byazt.ca.ny nyVar = this.w;
        if (nyVar != null) {
            if (z) {
                nyVar.pr(k());
            } else {
                nyVar.hw(k());
            }
        }
    }
}
