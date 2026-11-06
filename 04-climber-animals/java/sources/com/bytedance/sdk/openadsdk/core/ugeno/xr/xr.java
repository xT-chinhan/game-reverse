package com.bytedance.sdk.openadsdk.core.ugeno.xr;

import android.content.Context;
import com.bytedance.adsdk.ugeno.ah.h;
import com.bytedance.adsdk.ugeno.ah.hi;
import com.bytedance.adsdk.ugeno.ah.qv;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.core.ch;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.adsdk.ugeno.ka.ah.ms implements qv {
    private b hi;

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ah() {
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms() {
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms(h hVar) {
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void xr() {
    }

    public xr(Context context) {
        super(context);
        this.hi = new b(context, 2, ch.ub().ka());
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        this.xr.ms(this);
        if (this.hi == null) {
            this.hi = new b(this.ch, 2, ch.ub().ka());
        }
        hi hiVarF = this.xr.f();
        if (hiVarF == null) {
            return false;
        }
        Map<String, Object> mapXr = hiVarF.xr();
        if (mapXr != null) {
            Object obj = mapXr.get("rotation_angle");
            if (obj instanceof Integer) {
                this.hi.xr(((Integer) obj).floatValue());
            }
            Object obj2 = mapXr.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.hi.c(((Integer) obj2).intValue());
            }
            Object obj3 = mapXr.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.hi.ms((JSONObject) obj3);
            }
            Object obj4 = mapXr.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.hi.xr((JSONObject) obj4);
            }
        }
        this.hi.ms(new b.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xr.xr.1
            @Override // com.bytedance.sdk.component.utils.b.ms
            public void ms(int i) {
                if (xr.this.f360ms == null || i != 2) {
                    return;
                }
                xr.this.f360ms.ms(xr.this.xr, xr.this.c, xr.this.ah.xr());
            }
        });
        return false;
    }

    private int ny() {
        JSONObject jSONObjectMs;
        if (this.xr == null) {
            return 0;
        }
        JSONObject jSONObjectCh = this.xr.ch();
        if (jSONObjectCh != null) {
            return jSONObjectCh.optInt("meta_hashcode", 0);
        }
        hi hiVarF = this.xr.f();
        if (hiVarF == null || (jSONObjectMs = hiVarF.ms()) == null) {
            return 0;
        }
        return jSONObjectMs.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void d() {
        if (this.hi == null || !this.xr.ny().isShown()) {
            return;
        }
        this.hi.ms(ny());
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ka() {
        b bVar = this.hi;
        if (bVar != null) {
            bVar.xr(ny());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.qv
    public void ms(boolean z) {
        b bVar = this.hi;
        if (bVar != null) {
            if (z) {
                bVar.ms(ny());
            } else {
                bVar.xr(ny());
            }
        }
    }
}
