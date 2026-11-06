package com.bytedance.adsdk.xr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.adsdk.ugeno.d.ms {
    @Override // com.bytedance.adsdk.ugeno.d.ms
    public com.bytedance.adsdk.ugeno.d.ms.InterfaceC0193ms ms(String str) {
        return ms.ms(str);
    }

    static class ms implements com.bytedance.adsdk.ugeno.d.ms.InterfaceC0193ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private com.bytedance.adsdk.xr.xr.ms f456ms;
        private String xr;

        private ms(String str) {
            this.xr = str;
            this.f456ms = com.bytedance.adsdk.xr.xr.ms.ms(str);
        }

        public static ms ms(String str) {
            return new ms(str);
        }

        @Override // com.bytedance.adsdk.ugeno.d.ms.InterfaceC0193ms
        public Object ms(JSONObject jSONObject) {
            com.bytedance.adsdk.xr.xr.ms msVar = this.f456ms;
            if (msVar == null) {
                return this.xr;
            }
            Object objMs = msVar.ms(jSONObject);
            if (objMs instanceof String) {
                return objMs;
            }
            if (objMs instanceof com.bytedance.adsdk.xr.xr.ms.ms) {
                return String.valueOf(ny.ms((com.bytedance.adsdk.xr.xr.ms.ms) objMs));
            }
            return String.valueOf(objMs);
        }
    }
}
