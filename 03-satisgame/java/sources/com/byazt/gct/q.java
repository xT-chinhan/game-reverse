package com.byazt.gct;

import android.text.TextUtils;
import com.byazt.gc.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 5})
public class q {
    public JSONArray cp;
    public String d;
    public float fs;
    public String l;
    public String n;
    public JSONObject oa;
    public List<n> q;
    public String qg;
    public String rv;
    public String s;
    public String tj;
    public String w;
    public String x;

    public q(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            this.n = jSONObjectOptJSONObject.optString("app_name");
            this.qg = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.s = jSONObjectOptJSONObject.optString("developer_name");
            this.q = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.q.add(new n(jSONArrayOptJSONArray.optJSONObject(i)));
                }
            }
            this.l = jSONObjectOptJSONObject.optString("policy_url");
            String strOptString = jSONObjectOptJSONObject.optString(AbsServerManager.PACKAGE_QUERY_BINDER);
            this.w = strOptString;
            if (TextUtils.isEmpty(strOptString)) {
                this.w = jSONObjectOptJSONObject.optString("package_name");
            }
            this.x = jSONObjectOptJSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL);
            this.rv = jSONObjectOptJSONObject.optString("desc_url");
            this.tj = jSONObjectOptJSONObject.optString("reg_number");
            this.d = jSONObjectOptJSONObject.optString("reg_url");
            this.oa = jSONObjectOptJSONObject.optJSONObject("reg_info");
        } catch (Throwable unused) {
        }
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public String q() {
        return this.x;
    }

    public void n(float f) {
        this.fs = f;
    }

    public void n(JSONArray jSONArray) {
        this.cp = jSONArray;
    }

    public String l() {
        return this.rv;
    }

    public String w() {
        return this.d;
    }

    public boolean x() {
        List<n> list;
        return (TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.qg) || TextUtils.isEmpty(s()) || (list = this.q) == null || list.size() == 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.rv)) ? false : true;
    }

    public String fs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", this.n);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("app_version", this.qg);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put("developer_name", this.s);
        } catch (JSONException unused3) {
        }
        try {
            jSONObject.put("package_name", this.w);
        } catch (JSONException unused4) {
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<n> it = this.q.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().n());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException unused5) {
        }
        try {
            jSONObject.put("privacy_policy_url", this.l);
        } catch (JSONException unused6) {
        }
        try {
            jSONObject.put("score", this.fs);
        } catch (JSONException unused7) {
        }
        try {
            jSONObject.put("creative_tags", this.cp);
        } catch (JSONException unused8) {
        }
        try {
            jSONObject.put("desc_url", this.rv);
        } catch (JSONException unused9) {
        }
        try {
            jSONObject.put("reg_number", this.tj);
        } catch (JSONException unused10) {
        }
        try {
            jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, this.x);
        } catch (JSONException unused11) {
        }
        try {
            jSONObject.put("reg_url", this.d);
        } catch (JSONException unused12) {
        }
        try {
            jSONObject.put("reg_info", this.oa);
        } catch (JSONException unused13) {
        }
        return jSONObject.toString();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public final String n;
        public final String qg;

        public n(JSONObject jSONObject) {
            this.n = jSONObject.optString("permission_name");
            this.qg = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.qg);
            } catch (JSONException unused) {
            }
            try {
                jSONObject.put("permission_name", this.n);
            } catch (JSONException unused2) {
            }
            return jSONObject;
        }
    }
}
