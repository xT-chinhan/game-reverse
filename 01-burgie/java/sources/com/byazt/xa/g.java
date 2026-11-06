package com.byazt.xa;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public final class g extends hn {
    public final Context c;
    public final zo uc;

    public g(Context context, zo zoVar) {
        super(true, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException, SecurityException {
        Map<String, String> mapPr = com.byazt.xev.fw.pr(this.c, this.uc.c());
        if (mapPr == null) {
            return !com.byazt.zrg.pr.hw;
        }
        jSONObject.put("oaid", new JSONObject(mapPr));
        return true;
    }
}
