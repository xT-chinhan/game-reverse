package com.bytedance.sdk.openadsdk.core.ka.xr;

import android.text.TextUtils;
import com.anythink.core.common.m.e;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f2819ms;
    public String xr;

    public d(String str, String str2) {
        this.f2819ms = str;
        this.xr = str2;
    }

    public static JSONObject ms(List<d> list) {
        if (list == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            if (dVar != null) {
                jSONArray.put(ms(dVar.f2819ms, dVar.xr));
            }
        }
        try {
            jSONObject.put("ads", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject ms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder("id=");
            sb.append(str).append("&timestamp=");
            sb.append(iCurrentTimeMillis).append("&ext=");
            sb.append(str2);
            String upperCase = com.bytedance.sdk.component.utils.ka.xr(sb.toString()).toUpperCase();
            jSONObject.put("id", str);
            jSONObject.put("timestamp", iCurrentTimeMillis);
            jSONObject.put(e.X, upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static List<d> ms(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(lmVar.df(), lmVar.lx()));
        String strSd = lmVar.sd();
        if (TextUtils.isEmpty(strSd)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(strSd);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new d(jSONObjectOptJSONObject.optString("ad_id"), jSONObjectOptJSONObject.optString("ext")));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static lm ms(ah ahVar, lm lmVar) {
        Map<String, Boolean> map;
        Boolean bool;
        Boolean bool2;
        if (ahVar != null && ahVar.xr != null && lmVar != null && (bool = (map = ahVar.xr).get(lmVar.df())) != null && bool.booleanValue()) {
            String strSd = lmVar.sd();
            if (TextUtils.isEmpty(strSd)) {
                return lmVar;
            }
            try {
                JSONArray jSONArray = new JSONArray(strSd);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && ((bool2 = map.get(jSONObjectOptJSONObject.optString("ad_id"))) == null || !bool2.booleanValue())) {
                        return null;
                    }
                }
                return lmVar;
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        return null;
    }
}
