package com.bytedance.sdk.openadsdk.core.h.ms;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class jw extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.ab.ms f2541ms;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, com.bytedance.sdk.openadsdk.core.widget.ab.ms msVar) {
        hVar.ms("UgenDownloadDialogInteraction", (com.bytedance.sdk.component.ms.ka<?, ?>) new jw(msVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        ms(jSONObject);
        return ah();
    }

    private void ms(JSONObject jSONObject) {
        if (jSONObject == null || this.f2541ms == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("InteractionType");
        if (iOptInt == 1) {
            this.f2541ms.ah(null);
            return;
        }
        if (iOptInt == 2) {
            this.f2541ms.ms(null);
            return;
        }
        if (iOptInt == 3) {
            this.f2541ms.ms();
        } else if (iOptInt == 4) {
            this.f2541ms.xr(null);
        } else {
            if (iOptInt != 5) {
                return;
            }
            this.f2541ms.d(null);
        }
    }

    public jw(com.bytedance.sdk.openadsdk.core.widget.ab.ms msVar) {
        this.f2541ms = msVar;
    }

    public JSONObject ah() {
        return new JSONObject();
    }
}
