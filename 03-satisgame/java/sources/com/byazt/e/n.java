package com.byazt.e;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 19})
public class n {
    public String l;
    public String n;
    public String q;
    public int qg = -1;
    public String s;

    public String n() {
        return qg().toString();
    }

    public JSONObject qg() {
        JSONObject jSONObject = new JSONObject();
        n(jSONObject);
        return jSONObject;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.n);
            jSONObject.put("error_code", String.valueOf(this.qg));
            jSONObject.put("error_msg", this.s);
            jSONObject.put("real_device_plan", this.q);
            jSONObject.put("device_plans", this.l);
        } catch (Throwable unused) {
        }
    }

    public static n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            nVar.l = jSONObject.optString("device_plans", null);
            nVar.q = jSONObject.optString("real_device_plan", null);
            nVar.s = jSONObject.optString("error_msg", null);
            nVar.n = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                nVar.qg = -1;
            } else {
                nVar.qg = Integer.parseInt(strOptString);
            }
        } catch (Throwable unused) {
        }
        return nVar;
    }
}
