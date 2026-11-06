package com.byazt.xa;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 121})
public class x extends hn {
    public final Context c;
    public final zo uc;

    public x(Context context, zo zoVar) {
        super(true, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException, SecurityException {
        jSONObject.put("os", "Android");
        jSONObject.put(an.y, Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", com.byazt.ec.pr.c());
        jSONObject.put(an.F, Build.BRAND);
        jSONObject.put(an.H, com.byazt.ec.pr.uc());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.uc.qn() ? pr(this.c) : this.uc.qi());
        return true;
    }

    private static String pr(Context context) {
        String serial = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                serial = Build.getSerial();
            } catch (Throwable th) {
            }
        }
        if (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) {
            serial = Build.SERIAL;
        }
        if (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) {
            return "";
        }
        return serial;
    }
}
