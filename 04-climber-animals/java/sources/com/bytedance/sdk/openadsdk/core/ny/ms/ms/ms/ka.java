package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private com.bytedance.sdk.component.hi.ms.ms ah;
    private Map<String, Object> d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f3138ms;
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms xr;

    public ka(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar, lm lmVar, com.bytedance.sdk.component.hi.ms.ms msVar2, Map<String, Object> map, String str) {
        this.f3138ms = lmVar;
        this.xr = msVar;
        this.ah = msVar2;
        this.d = map;
        this.ka = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(final Map<String, Object> map) {
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.f3138ms, new com.bytedance.sdk.openadsdk.core.live.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ka.1
            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms(int i) {
                if (ka.this.xr != null && ka.this.xr.ms(map)) {
                    return;
                }
                ka.this.ah.xr(ka.this.d);
            }
        }, this.ka);
        if (iMs == 1 || iMs == 2) {
            ms();
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar = this.xr;
        return msVar != null && msVar.ms(map);
    }

    private void ms() {
        Map<String, Object> map;
        Map<String, Object> map2 = this.d;
        if (map2 != null) {
            Object obj = map2.get("click_chain");
            Object obj2 = this.d.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.xr.ms.ah)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah) obj;
            com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ahVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
            if (msVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    map = (Map) obj2;
                } else {
                    map = new HashMap<>();
                }
                msVar.ms(map, ahVar);
            }
        }
    }
}
