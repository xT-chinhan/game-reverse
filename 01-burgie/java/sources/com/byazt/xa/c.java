package com.byazt.xa;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c extends hn {
    public final zo c;

    public c(Context context, zo zoVar) {
        super(true, false);
        this.c = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException, SecurityException {
        String strPr = com.byazt.xev.fw.pr(this.c.c());
        if (!TextUtils.isEmpty(strPr)) {
            jSONObject.put("cdid", strPr);
            return true;
        }
        return false;
    }
}
