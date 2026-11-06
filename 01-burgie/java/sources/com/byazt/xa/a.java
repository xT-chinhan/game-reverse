package com.byazt.xa;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a extends hn {
    public final Context c;

    public a(Context context) {
        super(true, false);
        this.c = context;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        aj.pr(jSONObject, "sim_region", ((TelephonyManager) this.c.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
