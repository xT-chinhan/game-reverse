package com.bytedance.sdk.component.adexpress.dynamic.d;

import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab implements x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.ka.xr f783ms;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d.x
    public void ms(com.bytedance.sdk.component.adexpress.dynamic.ka.xr xrVar) {
        this.f783ms = xrVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d.x
    public void ms(final zb zbVar) {
        if (zbVar.ub() == 1) {
            xr(zbVar);
        } else {
            com.bytedance.sdk.component.adexpress.d.ka.ms(new com.bytedance.sdk.component.ch.ny("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.d.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    ab.this.xr(zbVar);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(zb zbVar) {
        try {
            JSONObject jSONObjectKa = zbVar.ka();
            JSONObject jSONObject = new JSONObject(jSONObjectKa.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectKa.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.ah.x xVarMs = new c(jSONObject, jSONObjectOptJSONObject, jSONObjectKa.optJSONObject("AdSize"), new JSONObject(jSONObjectKa.optString("diff_template_Plugin"))).ms(zbVar.d(), zbVar.zb(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), zbVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                xVarMs.ms(jSONObject2.optString("color"));
                xVarMs.ms(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.f783ms.ms(xVarMs);
        } catch (Exception e) {
            sl.ms(e);
        }
    }
}
