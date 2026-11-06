package com.byazt.ax;

import android.os.Bundle;
import android.view.View;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.aj;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.vk;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 20})
public class hn {
    public View c;
    public String hn;
    public of hw;
    public final TTBaseVideoActivity pr;
    public com.byazt.pj.hw uc;
    public boolean x = false;

    public hn(TTBaseVideoActivity tTBaseVideoActivity) {
        this.pr = tTBaseVideoActivity;
    }

    public void pr(of ofVar, String str, View view) {
        if (this.x) {
            return;
        }
        this.x = true;
        this.hw = ofVar;
        this.hn = str;
        this.c = view;
    }

    public JSONObject pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.pr.bm() != null) {
                jSONObject.put("reward_full_scene_type", this.pr.bm().y());
                this.pr.bm().pr(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public void pr(Map<String, Object> map) {
        if (map != null && this.pr.bm() != null) {
            map.put("reward_full_scene_type", Integer.valueOf(this.pr.bm().y()));
            this.pr.bm().pr(map);
        }
    }

    public void pr() {
        final JSONObject jSONObjectPr = pr(new JSONObject());
        com.byazt.pj.pr.pr(this.hw, this.hn, "skip", new com.byazt.ttf.pr() { // from class: com.byazt.ax.hn.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                com.byazt.ja.pr.pr(jSONObjectPr, hn.this.hw);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectPr);
                return jSONObjectPr;
            }
        });
    }

    public void hw() {
        final JSONObject jSONObjectPr = pr(new JSONObject());
        com.byazt.pj.pr.pr(this.hw, this.hn, "skip_endcard", new com.byazt.ttf.pr() { // from class: com.byazt.ax.hn.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                com.byazt.ja.pr.pr(jSONObjectPr, hn.this.hw);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectPr);
                return jSONObjectPr;
            }
        });
    }

    public void hn() {
        final JSONObject jSONObjectPr = pr(new JSONObject());
        com.byazt.pj.pr.pr(this.hw, this.hn, "reward_arrived_begin", new com.byazt.ttf.pr() { // from class: com.byazt.ax.hn.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                com.byazt.ja.pr.pr(jSONObjectPr, hn.this.hw);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectPr);
                return jSONObjectPr;
            }
        });
    }

    public void pr(Bundle bundle) {
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
            ho.hw("RewardFullEventManager", e.getMessage());
        }
        com.byazt.pj.pr.pr(this.hw, this.hn, str, new com.byazt.ttf.pr() { // from class: com.byazt.ax.hn.4
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject3) throws JSONException {
                com.byazt.ja.pr.pr(jSONObject, hn.this.hw);
                JSONObject jSONObjectPr = hn.this.pr(jSONObject);
                jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectPr);
                return jSONObjectPr;
            }
        });
    }

    public void pr(String str, int i, String str2) {
        final JSONObject jSONObjectPr = pr(new JSONObject());
        try {
            jSONObjectPr.put("dialog_type", i);
            jSONObjectPr.put("template_url", str2);
        } catch (JSONException e) {
        }
        com.byazt.pj.pr.pr(this.hw, this.hn, str, new com.byazt.ttf.pr() { // from class: com.byazt.ax.hn.5
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                com.byazt.ja.pr.pr(jSONObjectPr, hn.this.hw);
                JSONObject jSONObjectPr2 = hn.this.pr(jSONObjectPr);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectPr2);
                return jSONObjectPr2;
            }
        });
    }

    public void pr(boolean z, int i, long j) {
        com.byazt.pj.pr.pr(this.hw, this.hn, z ? "scroll_up" : "scroll_down", new pr(i, j, pr(new JSONObject())));
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 116})
    private static class pr implements com.byazt.ttf.pr {
        public final JSONObject hn;
        public final long hw;
        public final int pr;

        public pr(int i, long j, JSONObject jSONObject) {
            this.pr = i;
            this.hw = j;
            this.hn = jSONObject;
        }

        @Override // com.byazt.ttf.pr
        public JSONObject pr(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.hn;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.pr);
            jSONObject2.put("duration", this.hw);
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            return jSONObject2;
        }
    }

    public void pr(View view, vk vkVar) {
        try {
            hw(view, vkVar);
        } catch (Exception e) {
            ho.hw("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    @DungeonFlag
    private void hw(View view, vk vkVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387609) {
            pr("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387630) {
            pr("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387875) {
            pr("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387793) {
            pr("click_play_logo", (JSONObject) null);
        } else if (view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964) {
            pr("click_start_play_bar", x());
        } else if (view.getId() == 2114387642) {
            pr("click_video", x());
        } else if (view.getId() == 2114387864) {
            pr("fallback_endcard_click", x());
        }
        hn(view, vkVar);
    }

    @DungeonFlag
    private void hn(View view, vk vkVar) {
        if (uc() || this.hw == null || view == null) {
            return;
        }
        if (view.getId() == 2114387609 || view.getId() == 2114387630 || view.getId() == 2114387875 || view.getId() == 2114387793 || view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964 || view.getId() == 2114387830 || view.getId() == 2114387642 || view.getId() == 2114387864) {
            int iA = ((g) com.byazt.zs.uc.pr("device_info_new")).a();
            com.byazt.pj.pr.pr("click_other", this.hw, new aj.pr().uc(vkVar.lb()).c(vkVar.qa()).x(vkVar.a()).hn(vkVar.cz()).hw(System.currentTimeMillis()).pr(0L).hw(er.pr(this.c)).pr(er.pr((View) null)).hn(er.hn(this.c)).x(er.hn((View) null)).x(vkVar.uc()).c(vkVar.fw()).uc(vkVar.zo()).pr(vkVar.g()).hn(zo.nt().hw() ? 1 : 2).hw(iA).pr(er.fw(a.getContext())).hw(er.zo(a.getContext())).pr(com.byazt.ri.c.hw(this.hw)).pr(), this.hn, true, this.pr.ii(), -1, false, vkVar.pr());
        }
    }

    @DungeonFlag
    public JSONObject x() {
        try {
            long jG = this.pr.o().g();
            int iHo = this.pr.o().ho();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jG);
                jSONObject.put("percent", iHo);
                return jSONObject;
            } catch (Throwable th) {
                return jSONObject;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public void pr(String str, JSONObject jSONObject) {
        of ofVar = this.hw;
        String str2 = this.hn;
        if (!this.pr.iu()) {
            jSONObject = null;
        }
        com.byazt.pj.pr.pr(ofVar, str2, str, jSONObject);
    }

    private boolean uc() {
        of ofVar = this.hw;
        return ofVar == null || qa.zo(ofVar) != 1;
    }

    public com.byazt.pj.hw c() {
        if (this.uc == null) {
            this.uc = new com.byazt.pj.hw(this.hw, this.hn);
        }
        return this.uc;
    }
}
