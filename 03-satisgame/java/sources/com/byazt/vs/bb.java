package com.byazt.vs;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF})
public class bb extends com.byazt.cf.l<JSONObject, JSONObject> {
    public Context n;
    public com.byazt.gct.pk qg;

    public bb(Context context, com.byazt.gct.pk pkVar) {
        this.n = context;
        this.qg = pkVar;
    }

    public static void n(com.byazt.cf.cy cyVar, Context context, com.byazt.gct.pk pkVar) {
        cyVar.n("openNewCommonWebPage", (com.byazt.cf.l<?, ?>) new bb(context, pkVar));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        try {
            String strOptString = jSONObject.optString("web_url");
            String strOptString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = "";
            }
            TTDelegateActivity.q(this.n, strOptString, strOptString2);
            return null;
        } catch (Throwable th) {
            com.byazt.tk.k.qg("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
