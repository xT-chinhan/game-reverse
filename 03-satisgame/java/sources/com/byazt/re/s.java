package com.byazt.re;

import android.os.Bundle;
import android.view.View;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.rv;
import com.byazt.gct.tj;
import com.byazt.gct.um;
import com.byazt.ho.BaseConstants;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 796, 8})
public class s {
    public View l;
    public final TTBaseVideoActivity n;
    public boolean q = false;
    public pk qg;
    public String s;
    public com.byazt.hm.qg w;

    public s(TTBaseVideoActivity tTBaseVideoActivity) {
        this.n = tTBaseVideoActivity;
    }

    public void n(pk pkVar, String str, View view) {
        if (this.q) {
            return;
        }
        this.q = true;
        this.qg = pkVar;
        this.s = str;
        this.l = view;
    }

    public JSONObject n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.n.nf() != null) {
                jSONObject.put("reward_full_scene_type", this.n.nf().v());
                this.n.nf().n(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void n(Map<String, Object> map) {
        if (map == null || this.n.nf() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.n.nf().v()));
        this.n.nf().n(map);
    }

    public void n() {
        final JSONObject jSONObjectN = n(new JSONObject());
        com.byazt.hm.n.n(this.qg, this.s, "skip", new com.byazt.rs.n() { // from class: com.byazt.re.s.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                com.byazt.aci.n.n(jSONObjectN, s.this.qg);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN);
                return jSONObjectN;
            }
        });
    }

    public void qg() {
        final JSONObject jSONObjectN = n(new JSONObject());
        com.byazt.hm.n.n(this.qg, this.s, "skip_endcard", new com.byazt.rs.n() { // from class: com.byazt.re.s.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                com.byazt.aci.n.n(jSONObjectN, s.this.qg);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN);
                return jSONObjectN;
            }
        });
    }

    public void s() {
        final JSONObject jSONObjectN = n(new JSONObject());
        com.byazt.hm.n.n(this.qg, this.s, "reward_arrived_begin", new com.byazt.rs.n() { // from class: com.byazt.re.s.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                com.byazt.aci.n.n(jSONObjectN, s.this.qg);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN);
                return jSONObjectN;
            }
        });
    }

    public void n(Bundle bundle) {
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
            k.qg("RewardFullEventManager", e.getMessage());
        }
        com.byazt.hm.n.n(this.qg, this.s, str, new com.byazt.rs.n() { // from class: com.byazt.re.s.4
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject3) throws JSONException {
                com.byazt.aci.n.n(jSONObject, s.this.qg);
                JSONObject jSONObjectN = s.this.n(jSONObject);
                jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN);
                return jSONObjectN;
            }
        });
    }

    public void n(String str, int i, String str2) {
        final JSONObject jSONObjectN = n(new JSONObject());
        try {
            jSONObjectN.put("dialog_type", i);
            jSONObjectN.put("template_url", str2);
        } catch (JSONException unused) {
        }
        com.byazt.hm.n.n(this.qg, this.s, str, new com.byazt.rs.n() { // from class: com.byazt.re.s.5
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                com.byazt.aci.n.n(jSONObjectN, s.this.qg);
                JSONObject jSONObjectN2 = s.this.n(jSONObjectN);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectN2);
                return jSONObjectN2;
            }
        });
    }

    public void n(boolean z, int i, long j) {
        com.byazt.hm.n.n(this.qg, this.s, z ? "scroll_up" : "scroll_down", new n(i, j, n(new JSONObject())));
    }

    @com.byazt.cp.n(n = {0, 1, 796, 546})
    private static class n implements com.byazt.rs.n {
        public final int n;
        public final long qg;
        public final JSONObject s;

        public n(int i, long j, JSONObject jSONObject) {
            this.n = i;
            this.qg = j;
            this.s = jSONObject;
        }

        @Override // com.byazt.rs.n
        public JSONObject n(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.s;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.n);
            jSONObject2.put(MediationConstant.EXTRA_DURATION, this.qg);
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            return jSONObject2;
        }
    }

    public void n(View view, tj tjVar) {
        try {
            qg(view, tjVar);
        } catch (Exception e) {
            k.qg("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    @DungeonFlag
    private void qg(View view, tj tjVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387609) {
            n("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387630) {
            n("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387875) {
            n("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387793) {
            n("click_play_logo", (JSONObject) null);
        } else if (view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964) {
            n("click_start_play_bar", q());
        } else if (view.getId() == 2114387642) {
            n("click_video", q());
        } else if (view.getId() == 2114387864) {
            n("fallback_endcard_click", q());
        }
        s(view, tjVar);
    }

    @DungeonFlag
    private void s(View view, tj tjVar) {
        if (w() || this.qg == null || view == null) {
            return;
        }
        if (view.getId() == 2114387609 || view.getId() == 2114387630 || view.getId() == 2114387875 || view.getId() == 2114387793 || view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964 || view.getId() == 2114387830 || view.getId() == 2114387642 || view.getId() == 2114387864) {
            int iA = ((oa) com.byazt.qp.q.n("device_info_new")).a();
            com.byazt.hm.n.n("click_other", this.qg, new rv.n().w(tjVar.cd()).l(tjVar.um()).q(tjVar.a()).s(tjVar.py()).qg(System.currentTimeMillis()).n(0L).qg(com.byazt.okk.s.n(this.l)).n(com.byazt.okk.s.n((View) null)).s(com.byazt.okk.s.s(this.l)).q(com.byazt.okk.s.s((View) null)).q(tjVar.w()).l(tjVar.x()).w(tjVar.fs()).n(tjVar.sz()).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).qg(iA).n(com.byazt.okk.s.x(com.byazt.nf.rv.getContext())).qg(com.byazt.okk.s.fs(com.byazt.nf.rv.getContext())).n(com.byazt.oh.l.qg(this.qg)).n(), this.s, true, this.n.pk(), -1, false, tjVar.n());
        }
    }

    @DungeonFlag
    public JSONObject q() {
        try {
            long jSz = this.n.b().sz();
            int iK = this.n.b().k();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MediationConstant.EXTRA_DURATION, jSz);
                jSONObject.put("percent", iK);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void n(String str, JSONObject jSONObject) {
        pk pkVar = this.qg;
        String str2 = this.s;
        if (!this.n.t()) {
            jSONObject = null;
        }
        com.byazt.hm.n.n(pkVar, str2, str, jSONObject);
    }

    private boolean w() {
        pk pkVar = this.qg;
        return pkVar == null || um.fs(pkVar) != 1;
    }

    public com.byazt.hm.qg l() {
        if (this.w == null) {
            this.w = new com.byazt.hm.qg(this.qg, this.s);
        }
        return this.w;
    }
}
