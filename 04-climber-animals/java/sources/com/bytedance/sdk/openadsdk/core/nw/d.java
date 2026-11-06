package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private String ab;
    private String ah;
    private String c;
    private String ch;
    private List<ms> d;
    private JSONArray hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3046ms;
    private String ny;
    private String sl;
    private float x;
    private String xr;
    private JSONObject zb;

    public d(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("package");
            this.f3046ms = jSONObjectOptJSONObject.optString("app_name");
            this.xr = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.ah = jSONObjectOptJSONObject.optString("developer_name");
            this.d = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.d.add(new ms(jSONArrayOptJSONArray.optJSONObject(i)));
                }
            }
            this.ka = jSONObjectOptJSONObject.optString("policy_url");
            String strOptString = jSONObjectOptJSONObject.optString("package");
            this.c = strOptString;
            if (TextUtils.isEmpty(strOptString)) {
                this.c = jSONObjectOptJSONObject.optString("package_name");
            }
            this.ab = jSONObjectOptJSONObject.optString("icon_url");
            this.ny = jSONObjectOptJSONObject.optString("desc_url");
            this.ch = jSONObjectOptJSONObject.optString("reg_number");
            this.sl = jSONObjectOptJSONObject.optString("reg_url");
            this.zb = jSONObjectOptJSONObject.optJSONObject("reg_info");
        } catch (Throwable unused) {
        }
    }

    public String ms() {
        return this.f3046ms;
    }

    public String xr() {
        return this.ah;
    }

    public String ah() {
        return this.ab;
    }

    public void ms(float f) {
        this.x = f;
    }

    public void ms(JSONArray jSONArray) {
        this.hi = jSONArray;
    }

    public String d() {
        return this.ny;
    }

    public boolean ka() {
        List<ms> list;
        return (TextUtils.isEmpty(this.f3046ms) || TextUtils.isEmpty(this.xr) || TextUtils.isEmpty(xr()) || (list = this.d) == null || list.size() == 0 || TextUtils.isEmpty(this.ka) || TextUtils.isEmpty(this.ny)) ? false : true;
    }

    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", this.f3046ms);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            jSONObject.put("app_version", this.xr);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
        try {
            jSONObject.put("developer_name", this.ah);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.sl.ms(e3);
        }
        try {
            jSONObject.put("package_name", this.c);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.sl.ms(e4);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<ms> it = this.d.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().ms());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.sl.ms(e5);
        }
        try {
            jSONObject.put("privacy_policy_url", this.ka);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.sl.ms(e6);
        }
        try {
            jSONObject.put("score", this.x);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.sl.ms(e7);
        }
        try {
            jSONObject.put("creative_tags", this.hi);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.sl.ms(e8);
        }
        try {
            jSONObject.put("desc_url", this.ny);
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.sl.ms(e9);
        }
        try {
            jSONObject.put("reg_number", this.ch);
        } catch (JSONException e10) {
            com.bytedance.sdk.component.utils.sl.ms(e10);
        }
        try {
            jSONObject.put("icon_url", this.ab);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sl.ms(e11);
        }
        try {
            jSONObject.put("reg_url", this.sl);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sl.ms(e12);
        }
        try {
            jSONObject.put("reg_info", this.zb);
        } catch (JSONException e13) {
            com.bytedance.sdk.component.utils.sl.ms(e13);
        }
        return jSONObject.toString();
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f3047ms;
        private final String xr;

        public ms(JSONObject jSONObject) {
            this.f3047ms = jSONObject.optString("permission_name");
            this.xr = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject ms() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.xr);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            try {
                jSONObject.put("permission_name", this.f3047ms);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.sl.ms(e2);
            }
            return jSONObject;
        }
    }
}
