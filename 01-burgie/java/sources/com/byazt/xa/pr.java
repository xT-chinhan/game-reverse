package com.byazt.xa;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 37})
public class pr extends hn {
    public final Context c;
    public final zo uc;

    public pr(Context context, zo zoVar) {
        super(true, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException, SecurityException {
        if (!TextUtils.isEmpty(this.uc.e())) {
            jSONObject.put("ab_client", this.uc.e());
        }
        if (!TextUtils.isEmpty(this.uc.qa())) {
            if (com.byazt.ec.w.hw) {
                com.byazt.ec.w.pr("init config has abversion:" + this.uc.qa(), null);
            }
            jSONObject.put("ab_version", this.uc.qa());
        }
        if (!TextUtils.isEmpty(this.uc.s())) {
            jSONObject.put("ab_group", this.uc.s());
        }
        if (!TextUtils.isEmpty(this.uc.ls())) {
            jSONObject.put("ab_feature", this.uc.ls());
            return true;
        }
        return true;
    }
}
