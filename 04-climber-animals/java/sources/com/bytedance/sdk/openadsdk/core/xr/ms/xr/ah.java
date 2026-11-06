package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.openadsdk.core.xr.ms.ms {
    private com.bytedance.sdk.openadsdk.core.xr.d c;
    private String ka;

    public ah() {
    }

    public ah(lm lmVar, Context context, com.bytedance.sdk.openadsdk.core.xr.d dVar) {
        this.f3767ms = lmVar;
        this.xr = context;
        this.c = dVar;
    }

    public void ms(String str) {
        this.ka = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.f3767ms) || com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.f3767ms) || !d.ms(this.f3767ms, false)) {
            return 0;
        }
        return new d(this.f3767ms, this.xr).ms(this.ka).ms(new d.ms() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ah.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms
            public void ms() {
                try {
                    if (ah.this.c == null || ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) ah.this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(map, ahVar) != 0) {
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ah.this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map, ahVar);
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) ah.this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class)).ms(map, ahVar);
                } catch (Throwable th) {
                    sl.ms(th);
                }
            }
        });
    }
}
