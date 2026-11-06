package com.byazt.ko;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd extends s {
    public hd() {
        super(true, false);
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        jSONObject.put(TapEventParamConstants.PARAM_SUB_ROM, com.byazt.km.n.q());
        return true;
    }
}
