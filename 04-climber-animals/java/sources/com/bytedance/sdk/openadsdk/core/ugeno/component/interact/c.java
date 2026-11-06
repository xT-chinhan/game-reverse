package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends xr {
    private final ab ab;
    private final com.bytedance.sdk.openadsdk.core.b.xr c;
    private PlayableFeedWebView ka;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr
    protected int ms() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr
    public boolean ms(int i, int i2) {
        return true;
    }

    public c(lm lmVar, boolean z, ms msVar, ah ahVar) {
        super(lmVar, msVar, ahVar);
        this.ab = new ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ms() {
                if (c.this.ka != null) {
                    c.this.ka.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ms(boolean z2) {
                if (c.this.ka != null) {
                    c.this.ka.ms(z2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void xr() {
                if (c.this.ka != null) {
                    c.this.ka.ab();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ah() {
                c.this.ka.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void d() {
                if (op.ms() && c.this.c != null) {
                    c.this.c.ms(c.this.f3460ms);
                }
            }
        };
        this.c = new com.bytedance.sdk.openadsdk.core.b.xr(lmVar);
        this.d = z;
    }

    public boolean ah() {
        return op.xr(this.f3460ms);
    }

    public void ms(final ViewGroup viewGroup, final View view, final boolean z) {
        if (viewGroup == null) {
            HashMap map = new HashMap();
            map.put(j.w.E, Integer.valueOf(ms()));
            map.put("error_code", 100);
            this.ah.ms(false, (Map<String, Object>) map);
            return;
        }
        this.ah.ms(ms());
        PlayableFeedWebView playableFeedWebView = new PlayableFeedWebView(this.c, viewGroup);
        this.ka = playableFeedWebView;
        this.c.ms(playableFeedWebView);
        this.ka.setMaterialMeta(pc.ms(this.f3460ms));
        this.ka.setEasyPlayableListener(this.xr);
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c.2
            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.ms(viewGroup, view, cVar.ka, z, false, null, null);
            }
        });
    }

    public void d() {
        PlayableFeedWebView playableFeedWebView = this.ka;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr
    public ab xr() {
        return this.ab;
    }

    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        this.c.ms(xrVar);
    }
}
