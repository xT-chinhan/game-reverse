package com.mcto.sspsdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ra {
    public final wa a;
    public String b;

    public ra() {
        this.a = a();
    }

    public wa a() {
        wa waVar = null;
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        String strA = nh.a(jd.a).a("onlinemoviead_sch");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(strA);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("pkName");
                        if (TextUtils.equals(this.b, strOptString)) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("pids");
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    arrayList.add(jSONArrayOptJSONArray.optString(i2));
                                }
                            }
                            wa waVar2 = new wa();
                            try {
                                waVar2.a.addAll(arrayList);
                                waVar2.e = strOptString;
                                waVar2.b = jSONObjectOptJSONObject.optString("scheme");
                                waVar2.c = jSONObjectOptJSONObject.optString("regId");
                                waVar2.d = jSONObjectOptJSONObject.optString("regSubId");
                                return waVar2;
                            } catch (Exception e) {
                                waVar = waVar2;
                                e = e;
                            }
                        }
                        r9.a("BaseDispatcher", "parse sp SchemeModule: ", e);
                        return waVar;
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public String b(String str, String str2) {
        return "tvid=" + str + "&aid=" + str2;
    }

    public ra(wa waVar) {
        this.a = waVar;
    }

    public final boolean a(Context context, String str, String str2) {
        if (this.a != null && !TextUtils.isEmpty(str) && e1.c(this.a.e)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("biz_id", this.a.c).put("biz_plugin", "").put("biz_params", new JSONObject().put("biz_sub_id", this.a.d).put("biz_params", b(str, str2)).put("biz_dynamic_params", a(str, str2)).put("biz_extend_params", "to=3").put("biz_statistics", ""));
                StringBuilder sb = new StringBuilder(this.a.b);
                sb.append("?pluginParams=").append(Uri.encode(jSONObject.toString()));
                return e1.a(false, context, sb.toString(), this.a.e);
            } catch (JSONException e) {
                r9.a("BaseDispatcher", "wrapperOpen(): ", e);
            }
        }
        return false;
    }

    public String a(String str, String str2) {
        return "";
    }
}
