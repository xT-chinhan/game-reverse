package com.byazt.wv;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.byazt.hg.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 61})
public class aj extends pr {
    public String yb;

    public aj(Activity activity, of ofVar, pj pjVar) {
        super(activity, ofVar, pjVar);
        z zVarYl = this.fw.yl();
        if (zVarYl != null) {
            this.yb = zVarYl.pr();
        }
    }

    @Override // com.byazt.wv.hw
    public boolean uc() {
        String str = this.yb;
        return (str == null || str.equals("0") || TextUtils.isEmpty(this.yb)) ? false : true;
    }

    @Override // com.byazt.wv.hw
    public int fw() {
        return 5;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        return hn(vkVar);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.yb);
            boolean z = false;
            try {
                if (Double.parseDouble(this.yb) != 0.0d) {
                    z = true;
                }
            } catch (NumberFormatException e) {
            }
            jSONObject.put("is_display_unit", z);
        } catch (JSONException e2) {
        }
        return jSONObject.toString();
    }
}
