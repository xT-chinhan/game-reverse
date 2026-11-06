package com.byazt.ko;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends s {
    public final Context l;

    public oa(Context context) {
        super(true, true);
        this.l = context;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        rv.n(jSONObject, "access", com.byazt.km.w.n(this.l));
        return true;
    }
}
