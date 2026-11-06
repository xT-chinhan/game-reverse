package com.byazt.xa;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 48})
public class lb extends hn {
    public final zo c;

    public lb(zo zoVar) {
        super(true, false, false);
        this.c = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesC = this.c.c();
        String string = sharedPreferencesC.getString("install_id", null);
        String string2 = sharedPreferencesC.getString("device_id", null);
        String string3 = sharedPreferencesC.getString("ssid", null);
        aj.pr(jSONObject, "install_id", string);
        aj.pr(jSONObject, "device_id", string2);
        aj.pr(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesC.getLong("register_time", 0L);
        if ((!aj.hw(string) || !aj.hw(string2)) && j2 != 0) {
            sharedPreferencesC.edit().putLong("register_time", 0L).apply();
        } else {
            j = j2;
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
