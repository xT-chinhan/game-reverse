package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class p extends le {
    private final pc c;
    private final Context ka;

    p(Context context, pc pcVar) {
        super(false, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put(com.tapsdk.tapad.internal.tracker.experiment.a.b, "3.9.1.baseChina-rc.42");
        jSONObject.put("channel", this.c.ch());
        jw.ms(jSONObject, "aid", this.c.ny());
        jw.ms(jSONObject, "release_build", this.c.yu());
        jw.ms(jSONObject, "app_region", this.c.zb());
        jw.ms(jSONObject, "app_language", this.c.sl());
        jw.ms(jSONObject, "user_agent", this.c.op());
        jw.ms(jSONObject, "ab_sdk_version", this.c.ub());
        jw.ms(jSONObject, "ab_version", this.c.y());
        jw.ms(jSONObject, "aliyun_uuid", this.c.ms());
        String strHi = this.c.hi();
        if (TextUtils.isEmpty(strHi)) {
            strHi = qr.ms(this.ka, this.c);
        }
        if (!TextUtils.isEmpty(strHi)) {
            jw.ms(jSONObject, "google_aid", strHi);
        }
        String strW = this.c.w();
        if (!TextUtils.isEmpty(strW)) {
            try {
                jSONObject.put("app_track", new JSONObject(strW));
            } catch (Throwable th) {
                oh.xr(th);
            }
        }
        String strU = this.c.u();
        if (strU != null && strU.length() > 0) {
            jSONObject.put("custom", new JSONObject(strU));
        }
        jw.ms(jSONObject, "user_unique_id", this.c.ao());
        return true;
    }
}
