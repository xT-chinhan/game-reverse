package com.byazt.ko;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a extends s {
    public final Context l;

    public a(Context context) {
        super(true, false);
        this.l = context;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        rv.n(jSONObject, "sim_region", ((TelephonyManager) this.l.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
