package com.byazt.xa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb extends hn {
    public yb() {
        super(true, false);
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        jSONObject.put(Common.Predefined.SUB_ROM, com.byazt.ec.pr.x());
        return true;
    }
}
