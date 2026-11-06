package com.byazt.hg;

import android.text.TextUtils;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 121})
public class x {
    public String aj;
    public String c;
    public String fw;
    public String hn;
    public String hw;
    public String k;
    public JSONObject m;
    public String pr;
    public String uc;
    public String vk;
    public JSONArray w;
    public List<pr> x;
    public float zo;

    public x(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            this.pr = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
            this.hw = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.hn = jSONObjectOptJSONObject.optString("developer_name");
            this.x = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.x.add(new pr(jSONArrayOptJSONArray.optJSONObject(i)));
                }
            }
            this.c = jSONObjectOptJSONObject.optString("policy_url");
            String strOptString = jSONObjectOptJSONObject.optString(AbsServerManager.PACKAGE_QUERY_BINDER);
            this.uc = strOptString;
            if (TextUtils.isEmpty(strOptString)) {
                this.uc = jSONObjectOptJSONObject.optString("package_name");
            }
            this.fw = jSONObjectOptJSONObject.optString("icon_url");
            this.aj = jSONObjectOptJSONObject.optString("desc_url");
            this.vk = jSONObjectOptJSONObject.optString("reg_number");
            this.k = jSONObjectOptJSONObject.optString("reg_url");
            this.m = jSONObjectOptJSONObject.optJSONObject("reg_info");
        } catch (Throwable th) {
        }
    }

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public String hn() {
        return this.hn;
    }

    public String x() {
        return this.fw;
    }

    public void pr(float f) {
        this.zo = f;
    }

    public void pr(JSONArray jSONArray) {
        this.w = jSONArray;
    }

    public String c() {
        return this.aj;
    }

    public String uc() {
        return this.k;
    }

    public boolean fw() {
        List<pr> list;
        return (TextUtils.isEmpty(this.pr) || TextUtils.isEmpty(this.hw) || TextUtils.isEmpty(hn()) || (list = this.x) == null || list.size() == 0 || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.aj)) ? false : true;
    }

    public String zo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, this.pr);
        } catch (JSONException e) {
        }
        try {
            jSONObject.put("app_version", this.hw);
        } catch (JSONException e2) {
        }
        try {
            jSONObject.put("developer_name", this.hn);
        } catch (JSONException e3) {
        }
        try {
            jSONObject.put("package_name", this.uc);
        } catch (JSONException e4) {
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<pr> it = this.x.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pr());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException e5) {
        }
        try {
            jSONObject.put("privacy_policy_url", this.c);
        } catch (JSONException e6) {
        }
        try {
            jSONObject.put("score", this.zo);
        } catch (JSONException e7) {
        }
        try {
            jSONObject.put("creative_tags", this.w);
        } catch (JSONException e8) {
        }
        try {
            jSONObject.put("desc_url", this.aj);
        } catch (JSONException e9) {
        }
        try {
            jSONObject.put("reg_number", this.vk);
        } catch (JSONException e10) {
        }
        try {
            jSONObject.put("icon_url", this.fw);
        } catch (JSONException e11) {
        }
        try {
            jSONObject.put("reg_url", this.k);
        } catch (JSONException e12) {
        }
        try {
            jSONObject.put("reg_info", this.m);
        } catch (JSONException e13) {
        }
        return jSONObject.toString();
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static class pr {
        public final String hw;
        public final String pr;

        public pr(JSONObject jSONObject) {
            this.pr = jSONObject.optString("permission_name");
            this.hw = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.hw);
            } catch (JSONException e) {
            }
            try {
                jSONObject.put("permission_name", this.pr);
            } catch (JSONException e2) {
            }
            return jSONObject;
        }
    }
}
