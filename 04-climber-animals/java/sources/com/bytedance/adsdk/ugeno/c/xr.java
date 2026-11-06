package com.bytedance.adsdk.ugeno.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
    }

    public static JSONObject ms(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            sl.ms(e);
            return jSONObject;
        }
    }

    public static JSONArray ms(String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str)) {
            return jSONArray;
        }
        try {
            return new JSONArray(str);
        } catch (JSONException unused) {
            return jSONArray;
        }
    }

    public static void ms(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return;
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            Object objOpt = jSONArray2.opt(i);
            if (objOpt != null) {
                jSONArray.put(objOpt);
            }
        }
    }
}
