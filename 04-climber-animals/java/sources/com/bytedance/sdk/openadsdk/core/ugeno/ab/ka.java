package com.bytedance.sdk.openadsdk.core.ugeno.ab;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    public interface ms {
        void ms(JSONObject jSONObject);
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar, ms msVar2) {
        if (msVar == null) {
            if (msVar2 != null) {
                msVar2.ms(null);
            }
        } else {
            ms(msVar.ah(), msVar.ms(), msVar.xr(), msVar2);
        }
    }

    public static void ms(String str, String str2, String str3, final ms msVar) {
        JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.ugeno.ab.ms().ms(str2, str3);
        if (jSONObjectMs == null) {
            com.bytedance.sdk.openadsdk.core.re.xr.ms(str, str2, str3, new com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.1
                @Override // com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr
                public void ms(JSONObject jSONObject) {
                    ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ms(jSONObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.re.xr.InterfaceC0306xr
                public void ms() {
                    ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ms(null);
                    }
                }
            });
        } else if (msVar != null) {
            msVar.ms(jSONObjectMs);
        }
    }
}
