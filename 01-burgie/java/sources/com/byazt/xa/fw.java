package com.byazt.xa;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 62})
public class fw extends hn {
    public final Context c;
    public final zo uc;

    public fw(Context context, zo zoVar) {
        super(false, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 7714);
        jSONObject.put("sdk_version_name", "7.7.1.4");
        jSONObject.put("channel", this.uc.w());
        aj.pr(jSONObject, "aid", this.uc.vk());
        aj.pr(jSONObject, "release_build", this.uc.b());
        aj.pr(jSONObject, "app_region", this.uc.m());
        aj.pr(jSONObject, "app_language", this.uc.k());
        aj.pr(jSONObject, "user_agent", this.uc.iu());
        aj.pr(jSONObject, "ab_sdk_version", this.uc.ho());
        aj.pr(jSONObject, "ab_version", this.uc.qa());
        aj.pr(jSONObject, "aliyun_uuid", this.uc.hw());
        String strZ = this.uc.z();
        if (!TextUtils.isEmpty(strZ)) {
            try {
                jSONObject.put("app_track", new JSONObject(strZ));
            } catch (Throwable th) {
                com.byazt.ec.w.hw(th);
            }
        }
        String strG = this.uc.g();
        if (strG != null && strG.length() > 0) {
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, new JSONObject(strG));
        }
        aj.pr(jSONObject, "user_unique_id", this.uc.nt());
        return true;
    }
}
