package com.byazt.xa;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 250})
public class k extends hn {
    public final Context c;
    public final zo uc;

    public k(Context context, zo zoVar) {
        super(true, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        String strHw = com.byazt.ec.pr.hw();
        if (!TextUtils.isEmpty(strHw)) {
            jSONObject.put(an.A, strHw);
            return true;
        }
        return true;
    }
}
