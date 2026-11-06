package com.bytedance.sdk.openadsdk.core.ka.ms;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.ms.d;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.ka.ka.ka;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.of;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah {
    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.ah
    protected boolean ms() {
        return false;
    }

    public ms(com.bytedance.sdk.openadsdk.core.ka.ka.xr xrVar) {
        super(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.ah, com.bytedance.sdk.openadsdk.core.ka.ms.xr
    public com.bytedance.sdk.openadsdk.core.ka.ka.ah ms(final lm lmVar, final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, Bundle bundle) {
        final com.bytedance.sdk.openadsdk.core.component.reward.xr xrVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.xr(re.getContext(), lmVar, xrVar);
        final boolean z = bundle.getBoolean("is_cache", false);
        final long j = bundle.getLong("start_time");
        xrVar2.ms(z);
        xrVar2.ms(z ? 101 : 102);
        if (lmVar.no() <= 0) {
            xrVar2.ms(System.currentTimeMillis() + 10500000);
        } else {
            xrVar2.ms(lmVar.no() * 1000);
        }
        if (!com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar) && !nw.ah(lmVar) && !fm.ms(lmVar) && z) {
            xrVar2.ms();
        }
        return new com.bytedance.sdk.openadsdk.core.ka.ka.ah() { // from class: com.bytedance.sdk.openadsdk.core.ka.ms.ms.1
            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ah
            public void ms() {
                if (ms.this.f2807ms != null) {
                    ms.this.f2807ms.ms().ms(xrVar, lmVar, xrVar2, z);
                }
                ka kaVar2 = kaVar;
                if (kaVar2 != null) {
                    kaVar2.ms(xrVar2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_from_cache", z);
                    jSONObject.put("is_adm", !TextUtils.isEmpty(xrVar.nw()));
                    jSONObject.put("cache_strategy", d.ms(ms.this.ms()));
                    jSONObject.put("src_req_id", lmVar.wn());
                    jSONObject.put("is_map", lmVar.fg());
                    jSONObject.put("load_duration", System.currentTimeMillis() - j);
                } catch (JSONException unused) {
                }
                u.ms().ms(lmVar, "stats_reward_full_ad_loaded", jSONObject);
                ms.this.ms(this, lmVar, xrVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ah
            public void xr() {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(lmVar, f.xr(xrVar.t()), j);
                xrVar2.xr(1);
                ka kaVar2 = kaVar;
                if (kaVar2 != null) {
                    kaVar2.xr(xrVar2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ah
            public void ah() {
                if (z) {
                    if (ms.this.f2807ms != null) {
                        ms.this.f2807ms.ms().ah(xrVar, lmVar);
                    }
                } else if (ms.this.f2807ms != null) {
                    ms.this.f2807ms.ms().xr(xrVar, lmVar);
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.ah
    protected boolean ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        List<lm> listXr;
        if (msVar != null && (listXr = msVar.xr()) != null) {
            lm lmVar = listXr.get(0);
            if (le.ms(lmVar)) {
                return lmVar.fi().ah() != 1;
            }
            if (of.xr(ms(), lmVar, false) && of.d(lmVar) != 0) {
                return true;
            }
        }
        return false;
    }
}
