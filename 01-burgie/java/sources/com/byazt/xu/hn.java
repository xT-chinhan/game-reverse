package com.byazt.xu;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 20})
public class hn extends pr {
    public hn(Activity activity, of ofVar, pj pjVar) {
        super(activity, ofVar, pjVar);
    }

    @Override // com.byazt.wv.hw
    public boolean uc() {
        return (TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.k)) ? false : true;
    }

    @Override // com.byazt.wv.hw
    public int fw() {
        return 1;
    }

    @Override // com.byazt.xu.pr, com.byazt.wv.hw
    public com.byazt.wv.hw.pr pr(vk vkVar) {
        return hn(vkVar);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reward_name", this.w);
            jSONObject.put("reward_amount", this.k);
            jSONObject.put("extra_info", this.pr);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
