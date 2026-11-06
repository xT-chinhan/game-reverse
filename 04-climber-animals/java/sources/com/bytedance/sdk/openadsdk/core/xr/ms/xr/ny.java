package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends com.bytedance.sdk.openadsdk.core.xr.ms.ms {
    private com.bytedance.sdk.openadsdk.core.xr.d c;
    com.bytedance.sdk.openadsdk.core.xr.ms.ms.c ka = new com.bytedance.sdk.openadsdk.core.xr.ms.ms.c();

    public ny() {
    }

    public ny(lm lmVar, Context context, com.bytedance.sdk.openadsdk.core.xr.d dVar) {
        this.c = dVar;
        this.f3767ms = lmVar;
        this.xr = context;
    }

    public void ms(int i) {
        this.ka.xr(i);
    }

    public void ms(boolean z) {
        this.ka.xr(z);
    }

    public void ms(String str) {
        this.ka.ms(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        if (!new ch(this.f3767ms, this.xr).ms(this.ka.hi()).ms(this.ka.ny()).xr(this.ka.ah()).ms(new ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ny.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms
            public void ms() {
                ny.this.xr(map, ahVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms
            public void xr() {
                ny.this.ah(map, ahVar);
            }
        })) {
            return 0;
        }
        ch.ms(true);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        com.bytedance.sdk.openadsdk.core.xr.d dVar = this.c;
        if (dVar != null) {
            final com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVarXr = ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) dVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).xr();
            final com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms msVarMs = cVarXr.ms();
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ny.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms msVar = msVarMs;
                    if (msVar != null) {
                        msVar.ms(ny.this.d, cVarXr.d());
                    }
                }
            });
            if (((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map, ahVar) == 0) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class)).ms(map, ahVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        com.bytedance.sdk.openadsdk.core.xr.d dVar = this.c;
        if (dVar == null || ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) dVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(map, ahVar) != 0) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map, ahVar);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class)).ms(map, ahVar);
    }
}
