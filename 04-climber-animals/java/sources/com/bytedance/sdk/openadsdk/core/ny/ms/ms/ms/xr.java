package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private String ah;
    private Map<String, Object> c;
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms d;
    private com.bytedance.sdk.component.hi.ms.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3150ms;
    private lm xr;

    public xr(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar, Context context, lm lmVar, String str, Map<String, Object> map, com.bytedance.sdk.component.hi.ms.ms msVar2) {
        this.d = msVar;
        this.f3150ms = context;
        this.xr = lmVar;
        this.ah = str;
        this.ka = msVar2;
        this.c = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(final Map<String, Object> map) {
        if (!com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms(this.xr, false)) {
            com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar = this.d;
            return msVar != null && msVar.ms(map);
        }
        if (ch.ka(this.xr)) {
            com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar2 = this.d;
            return msVar2 != null && msVar2.ms(map);
        }
        if (ch.d(this.xr)) {
            com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar3 = this.d;
            return msVar3 != null && msVar3.ms(map);
        }
        new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d(this.xr, this.f3150ms).ms(this.ah).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms
            public void ms() {
                if (xr.this.d.ms(map)) {
                    return;
                }
                xr.this.ka.xr(xr.this.c);
            }
        });
        return true;
    }
}
