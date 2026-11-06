package com.byazt.xa;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 108})
public class m extends hn {
    public final Context c;

    public m(Context context) {
        super(true, true);
        this.c = context;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        aj.pr(jSONObject, an.Q, com.byazt.ec.uc.pr(this.c));
        return true;
    }
}
