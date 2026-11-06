package com.bytedance.sdk.openadsdk.core.ugeno;

import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends com.bytedance.adsdk.ugeno.ah.ms.xr {
    private volatile ms c;

    public ny(ub ubVar) {
        super(ubVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ms.xr
    public void ah(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        if (this.c == null) {
            this.c = xr();
        }
        this.c.ms(zbVar);
        this.c.ms(xrVar);
        this.c.ms(msVar);
        JSONObject jSONObjectAh = zbVar.ah();
        if (jSONObjectAh == null) {
            return;
        }
        new com.bytedance.sdk.component.hi.ms.xr.ms(jSONObjectAh.optString("type")).xr(this.d).ms(new com.bytedance.sdk.component.hi.d.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ny.1
            @Override // com.bytedance.sdk.component.hi.d.ah
            public void ms(com.bytedance.sdk.component.hi.ms.ms msVar2) {
                ny.this.ms(msVar2);
            }
        }).ms().ms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (this.ka) {
            return;
        }
        ms msVarXr = xr();
        msVarXr.ms(ms(msVarXr.ah, msVar));
        msVar.ms(msVarXr);
    }

    protected zb ms(zb zbVar, com.bytedance.sdk.component.hi.ms.ms msVar) {
        com.bytedance.sdk.component.hi.ah.ms msVar2;
        if (zbVar == null || msVar == null) {
            return zbVar;
        }
        zb zbVar2 = new zb();
        com.bytedance.adsdk.ugeno.xr.ah ahVarMs = zbVar.ms();
        if (ahVarMs == null) {
            return zbVar;
        }
        zbVar2.ms(zbVar.xr());
        com.bytedance.sdk.component.hi.ah.ms msVarAb = msVar.ab();
        JSONObject jSONObjectMs = ms(ahVarMs, zbVar2, msVarAb);
        com.bytedance.sdk.component.hi.ah.ah ahVarMs2 = com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(msVar.d());
        List<com.bytedance.sdk.component.hi.ah.ms> listMs = ahVarMs2.ms(msVarAb, ahVarMs.ch(), new HashMap());
        zbVar2.ms(jSONObjectMs);
        if (!listMs.isEmpty()) {
            com.bytedance.sdk.component.hi.ah.ms msVar3 = listMs.get(0);
            if (msVar3 == null) {
                return zbVar2;
            }
            zb zbVar3 = new zb();
            zbVar3.ms(ms(ahVarMs, zbVar3, msVar3));
            zbVar3.ms(ahVarMs);
            zbVar2.ms(zbVar3);
        }
        List<com.bytedance.sdk.component.hi.ah.ms> listXr = ahVarMs2.xr(msVarAb, ahVarMs.ch(), new HashMap());
        if (listXr.isEmpty() || (msVar2 = listXr.get(0)) == null) {
            return zbVar2;
        }
        zb zbVar4 = new zb();
        zbVar4.ms(ms(ahVarMs, zbVar4, msVar2));
        zbVar4.ms(ahVarMs);
        zbVar2.xr(zbVar4);
        return zbVar2;
    }

    private JSONObject ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, zb zbVar, com.bytedance.sdk.component.hi.ah.ms msVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (msVar == null) {
                return jSONObject;
            }
            Map<String, String> mapAh = msVar.ah();
            String strMs = msVar.ms();
            zbVar.ms(ahVar);
            jSONObject.put("type", strMs);
            if (mapAh != null && !mapAh.isEmpty()) {
                for (Map.Entry<String, String> entry : mapAh.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    private ms xr() {
        if (this.c != null) {
            return this.c;
        }
        synchronized (ms.class) {
            if (this.c != null) {
                return this.c;
            }
            this.c = new ms();
            return this.c;
        }
    }

    class ms implements com.bytedance.sdk.component.hi.d.xr {
        private zb ah;
        private ub.xr d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        ub.ms f3561ms;

        ms() {
        }

        public void ms(zb zbVar) {
            this.ah = zbVar;
        }

        public void ms(ub.xr xrVar) {
            this.d = xrVar;
        }

        public void ms(ub.ms msVar) {
            this.f3561ms = msVar;
        }

        @Override // com.bytedance.sdk.component.hi.d.xr
        public void ms() {
            ny.this.xr(this.ah, this.d, this.f3561ms);
        }
    }
}
