package com.bytedance.sdk.openadsdk.core.component.reward.xr;

import android.os.Bundle;
import android.view.View;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.ch;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private String ah;
    private boolean d = false;
    private View ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTBaseVideoActivity f2294ms;
    private lm xr;

    public ah(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f2294ms = tTBaseVideoActivity;
    }

    public void ms(lm lmVar, String str, View view) {
        if (this.d) {
            return;
        }
        this.d = true;
        this.xr = lmVar;
        this.ah = str;
        this.ka = view;
    }

    public JSONObject ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.f2294ms.sa() != null) {
                jSONObject.put("reward_full_scene_type", this.f2294ms.sa().cv());
                this.f2294ms.sa().ms(jSONObject);
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        return jSONObject;
    }

    public void ms(Map<String, Object> map) {
        if (map == null || this.f2294ms.sa() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.f2294ms.sa().cv()));
        this.f2294ms.sa().ms(map);
    }

    public void ms() {
        final JSONObject jSONObjectMs = ms(new JSONObject());
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, "skip", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ah.1
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObjectMs, ah.this.xr);
                jSONObject.put("ad_extra_data", jSONObjectMs);
            }
        });
    }

    public void xr() {
        final JSONObject jSONObjectMs = ms(new JSONObject());
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, "skip_endcard", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ah.2
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObjectMs, ah.this.xr);
                jSONObject.put("ad_extra_data", jSONObjectMs);
            }
        });
    }

    public void ah() {
        final JSONObject jSONObjectMs = ms(new JSONObject());
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, "reward_arrived_begin", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ah.3
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObjectMs, ah.this.xr);
                jSONObject.put("ad_extra_data", jSONObjectMs);
            }
        });
    }

    public void ms(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z);
            jSONObject2.put("isServerCallback", z2);
            jSONObject2.put(MediationConstant.KEY_REWARD_TYPE, i);
            jSONObject2.put(MediationConstant.KEY_ERROR_CODE, i2);
            jSONObject2.put(MediationConstant.KEY_ERROR_MSG, string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e) {
            sl.d("RewardFullEventManager", e.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, str, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ah.4
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject3) throws JSONException {
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, ah.this.xr);
                jSONObject3.put("ad_extra_data", ah.this.ms(jSONObject));
            }
        });
    }

    public void ms(String str, int i, String str2) {
        final JSONObject jSONObjectMs = ms(new JSONObject());
        try {
            jSONObjectMs.put("dialog_type", i);
            jSONObjectMs.put("template_url", str2);
        } catch (JSONException e) {
            sl.ms(e);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, str, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ah.5
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObjectMs, ah.this.xr);
                jSONObject.put("ad_extra_data", ah.this.ms(jSONObjectMs));
            }
        });
    }

    public void ms(boolean z, int i, long j) {
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(this.xr.df()).ms(this.ah).xr(z ? "scroll_up" : "scroll_down").d(this.xr.lx()).ms(new ms(i, j, ms(new JSONObject())));
    }

    private static class ms implements com.bytedance.sdk.openadsdk.c.ms.ms {
        private final JSONObject ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final int f2300ms;
        private final long xr;

        ms(int i, long j, JSONObject jSONObject) {
            this.f2300ms = i;
            this.xr = j;
            this.ah = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.c.ms.ms
        public void ms(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.ah;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.f2300ms);
            jSONObject2.put("duration", this.xr);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        }
    }

    public void ms(View view, hi hiVar) {
        try {
            xr(view, hiVar);
        } catch (Exception e) {
            sl.d("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    @DungeonFlag
    private void xr(View view, hi hiVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387615) {
            ms("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387636) {
            ms("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387881) {
            ms("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387799) {
            ms("click_play_logo", (JSONObject) null);
        } else if (view.getId() == 2114387655 || view.getId() == 2114387931 || view.getId() == 2114387964) {
            ms("click_start_play_bar", d());
        } else if (view.getId() == 2114387648) {
            ms("click_video", d());
        } else if (view.getId() == 2114387870) {
            ms("fallback_endcard_click", d());
        }
        ah(view, hiVar);
    }

    @DungeonFlag
    private void ah(View view, hi hiVar) {
        if (ka() || this.xr == null || view == null) {
            return;
        }
        if (view.getId() == 2114387615 || view.getId() == 2114387636 || view.getId() == 2114387881 || view.getId() == 2114387799 || view.getId() == 2114387655 || view.getId() == 2114387931 || view.getId() == 2114387964 || view.getId() == 2114387836 || view.getId() == 2114387648 || view.getId() == 2114387870) {
            int iX = ul.x(re.getContext());
            com.bytedance.sdk.openadsdk.core.zb.ah.ms("click_other", this.xr, new ch.ms().c(hiVar.u()).ka(hiVar.ub()).d(hiVar.ao()).ah(hiVar.h()).xr(System.currentTimeMillis()).ms(0L).xr(ul.ms(this.ka)).ms(ul.ms((View) null)).ah(ul.ah(this.ka)).d(ul.ah((View) null)).ah(hiVar.xr()).d(hiVar.ah()).ka(hiVar.d()).ms(hiVar.ch()).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(iX).ms(ul.c(re.getContext())).xr(ul.ab(re.getContext())).ms(), this.ah, true, this.f2294ms.eg(), -1, false);
        }
    }

    @DungeonFlag
    protected JSONObject d() {
        try {
            long jU = this.f2294ms.l().u();
            int iUb = this.f2294ms.l().ub();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jU);
                jSONObject.put("percent", iUb);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void ms(String str, JSONObject jSONObject) {
        lm lmVar = this.xr;
        String str2 = this.ah;
        if (!this.f2294ms.op()) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, str2, str, jSONObject);
    }

    private boolean ka() {
        lm lmVar = this.xr;
        return lmVar == null || nw.hi(lmVar) != 1;
    }
}
