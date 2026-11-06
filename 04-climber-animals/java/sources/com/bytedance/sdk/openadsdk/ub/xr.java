package com.bytedance.sdk.openadsdk.ub;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.f.ka;
import com.bytedance.sdk.openadsdk.core.jw.y;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.pro.bv;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4222ms;

    public static String ah() {
        return "";
    }

    public static Uri ms(String str, String str2) {
        return null;
    }

    public static void ms(Context context, JSONObject jSONObject) {
        try {
            float f = 0.0f;
            float f2 = com.bytedance.sdk.openadsdk.core.jw.d.ms(context) == null ? 0.0f : com.bytedance.sdk.openadsdk.core.jw.d.ms(context).f2673ms;
            if (com.bytedance.sdk.openadsdk.core.jw.d.ms(context) != null) {
                f = com.bytedance.sdk.openadsdk.core.jw.d.ms(context).xr;
            }
            jSONObject.put("latitude", f2);
            jSONObject.put("longitude", f);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public static void ms(ka kaVar, List<String> list) {
        if (kaVar.ms()) {
            list.add(g.h);
            list.add(g.g);
        }
    }

    public static void ms(JSONObject jSONObject, int i) {
        com.bytedance.sdk.openadsdk.core.jw.ah ahVarMs = com.bytedance.sdk.openadsdk.core.jw.d.ms(re.getContext());
        if (ahVarMs != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", ahVarMs.f2673ms);
                jSONObject2.put("longitude", ahVarMs.xr);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static void xr(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("imei", t.ab());
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    private static String d() {
        if (TextUtils.isEmpty(f4222ms)) {
            String strAb = t.ab();
            if (!TextUtils.isEmpty(strAb)) {
                f4222ms = com.bytedance.sdk.component.utils.ka.xr(strAb);
            }
        }
        return f4222ms;
    }

    public static String ms() {
        if (ch.ub().ao().d()) {
            return t.ch();
        }
        return null;
    }

    public static void ah(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("udid", t.ab());
            jSONObject.put(bv.A, t.b());
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public static void d(Context context, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayMs = y.ms(context);
            if (jSONArrayMs != null) {
                jSONObject.put("app_list", jSONArrayMs);
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public static void ms(Context context) {
        com.bytedance.sdk.openadsdk.core.jw.d.ms(context);
    }

    public static void xr() {
        com.bytedance.sdk.openadsdk.core.g.ah.ah().d();
    }

    public static boolean ms(String str) {
        return y.ms(str);
    }

    public static void xr(Context context) {
        if ((re.xr().fs() & 8) != 0) {
            return;
        }
        ms.ms(context);
    }
}
