package com.byazt.wd;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile rv n;
    public int q;
    public boolean qg;
    public boolean w;
    public final Set<String> s = new CopyOnWriteArraySet();
    public final Map<String, Long> l = new ConcurrentHashMap();

    private rv() {
    }

    public static rv n() {
        if (n == null) {
            synchronized (rv.class) {
                if (n == null) {
                    n = new rv();
                }
            }
        }
        return n;
    }

    private void s() {
        if (this.w) {
            return;
        }
        this.w = true;
        com.byazt.nf.rv.qg().hd();
    }

    public void n(String str, int i, int i2, String str2) {
        String str3;
        if (!qg() || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        String strValueOf = String.valueOf(i);
        if (i2 != 0) {
            str3 = (strValueOf + "_") + String.valueOf(i2);
        } else {
            str3 = strValueOf;
        }
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(str2, "req_exemption_error_code");
        if (this.s.contains(strValueOf) || this.s.contains(str3)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            sVarN.n(str, jCurrentTimeMillis);
            this.l.put(str, Long.valueOf(jCurrentTimeMillis));
        }
    }

    public void n(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        }
        n(jSONObject);
    }

    public void n(JSONObject jSONObject) {
        this.s.clear();
        if (jSONObject != null) {
            this.qg = jSONObject.optBoolean("enable", false);
            int iOptInt = jSONObject.optInt(MediationConstant.EXTRA_DURATION, 0) * 1000;
            this.q = iOptInt;
            if (iOptInt <= 0) {
                this.qg = false;
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("error_codes");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.s.add(strOptString);
                    }
                }
            }
            if (this.s.isEmpty()) {
                this.qg = false;
                return;
            }
            return;
        }
        this.qg = false;
    }

    public s n(String str, String str2) {
        s sVar = new s();
        if (!qg() || TextUtils.isEmpty(str)) {
            return sVar;
        }
        Long lValueOf = this.l.get(str);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(com.byazt.lk.l.n(str2, "req_exemption_error_code").getLong(str, -1L));
            if (lValueOf.longValue() != -1) {
                this.l.put(str, lValueOf);
            } else {
                lValueOf = null;
            }
        }
        if (lValueOf == null) {
            sVar.n(true);
            return sVar;
        }
        if (System.currentTimeMillis() - lValueOf.longValue() > this.q) {
            this.l.remove(str);
            com.byazt.lk.l.n(str2, "req_exemption_error_code").n(str);
            sVar.n(true);
        }
        return sVar;
    }

    public boolean qg() {
        s();
        return this.qg;
    }
}
