package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import com.anythink.core.common.d.j;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    lm f3445ms;

    ah(lm lmVar) {
        this.f3445ms = lmVar;
    }

    public void ms(final int i, final boolean z) {
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ah.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(j.w.E, Integer.valueOf(i));
                jSONObject.putOpt("is_root_container", Boolean.valueOf(z));
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().x(ah.this.f3445ms.lx()).ms("stats_easy_playable_render_start").xr(jSONObject.toString());
            }
        }, "stats_easy_playable_render_start");
    }

    public void ms(final int i) {
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ah.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(j.w.E, Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().x(ah.this.f3445ms.lx()).ms("stats_easy_playable_render_exec").xr(jSONObject.toString());
            }
        }, "stats_easy_playable_render_exec");
    }

    public void xr(final int i) {
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ah.3
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(j.w.E, Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().x(ah.this.f3445ms.lx()).ms("stats_easy_playable_inject_view").xr(jSONObject.toString());
            }
        }, "stats_easy_playable_inject_view");
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    public void ms(boolean z, Map<String, Object> map) {
        int i;
        String strAh = op.ah(this.f3445ms);
        if (map != null) {
            Object obj = map.get(j.w.E);
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                i = 1;
                if (iIntValue != 1) {
                    if (iIntValue == 0) {
                        i = 2;
                    } else {
                        i = -1;
                    }
                }
            } else {
                i = -1;
            }
        } else {
            i = -1;
        }
        ch.ms(this.f3445ms, z, strAh, i, map);
    }
}
