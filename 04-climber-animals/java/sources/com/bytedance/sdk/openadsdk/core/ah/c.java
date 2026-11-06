package com.bytedance.sdk.openadsdk.core.ah;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile c f1969ms;

    public static c ms() {
        if (f1969ms == null) {
            synchronized (c.class) {
                if (f1969ms == null) {
                    f1969ms = new c();
                }
            }
        }
        return f1969ms;
    }

    public com.bytedance.sdk.openadsdk.core.cv.xr ms(String str) {
        Object obj;
        com.bytedance.sdk.openadsdk.core.cv.xr xrVar = new com.bytedance.sdk.openadsdk.core.cv.xr();
        HashMap map = new HashMap();
        try {
            xrVar.ms(str.length());
            Pair<Integer, ?> pairAh = ms().ah(str);
            int iIntValue = 3;
            if (pairAh != null) {
                obj = pairAh.second;
                if (pairAh.first != null) {
                    iIntValue = ((Integer) pairAh.first).intValue();
                }
            } else {
                obj = null;
            }
            if (iIntValue == 4) {
                map.put("x-ad-sdk-version", g.ah);
                map.put("x-plugin-version", "6.9.2.3");
                map.put("x-pglcypher", String.valueOf(iIntValue));
                map.put("Content-Type", "application/octet-stream");
                xrVar.ms((byte[]) obj);
                xrVar.ms(map);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", g.ah);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
                xrVar.xr(jSONObject);
                xrVar.ms(map);
            }
        } catch (Throwable unused) {
        }
        return xrVar;
    }

    public com.bytedance.sdk.openadsdk.core.cv.xr xr(String str) {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.cv.xr xrVar = new com.bytedance.sdk.openadsdk.core.cv.xr();
        HashMap map = new HashMap();
        try {
            xrVar.ms(str.length());
            Pair<Integer, JSONObject> pairMs = ms().ms(str, false);
            if (pairMs != null) {
                JSONObject jSONObject2 = (JSONObject) pairMs.second;
                try {
                    iIntValue = pairMs.first != null ? ((Integer) pairMs.first).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                iIntValue = 3;
            }
            jSONObject.put("ad_sdk_version", g.ah);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            if (iIntValue != 3) {
                map.put("x-ad-sdk-version", g.ah);
                map.put("x-plugin-version", "6.9.2.3");
                map.put("x-pglcypher", String.valueOf(iIntValue));
            }
        } catch (Throwable unused2) {
        }
        xrVar.ms(map);
        xrVar.xr(jSONObject);
        return xrVar;
    }

    public Pair<Integer, JSONObject> ms(String str, boolean z) {
        try {
            if (re.xr().nn()) {
                return xr(str, z);
            }
        } catch (Throwable th) {
            sl.xr(th.getMessage());
        }
        return d(str);
    }

    public Pair<Integer, ?> ah(String str) {
        try {
            if (!TextUtils.isEmpty(str) && re.xr().nn()) {
                return ms(str, "get_ad");
            }
        } catch (Throwable th) {
            sl.xr(th.getMessage());
        }
        return d(str);
    }

    private Pair<Integer, JSONObject> c(String str) {
        return d(str);
    }

    public Pair<Integer, JSONObject> d(String str) {
        return new Pair<>(3, com.bytedance.sdk.component.utils.ms.ms(str));
    }

    private Pair<Integer, JSONObject> xr(String str, boolean z) {
        JSONObject jSONObjectKa = (TextUtils.isEmpty(str) || !ny.xr()) ? null : ka(str);
        if (jSONObjectKa == null || TextUtils.isEmpty(jSONObjectKa.optString("message"))) {
            if (ny.xr() && z) {
                u.ms().ms(3, -1L, (String) null);
            }
            return c(str);
        }
        return new Pair<>(4, jSONObjectKa);
    }

    public JSONObject ka(String str) {
        if (TextUtils.isEmpty(str) || !ny.xr()) {
            return null;
        }
        try {
            byte[] bArrMs = ny.ms().ms(str.getBytes(StandardCharsets.UTF_8));
            if (bArrMs == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrMs, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", strEncodeToString);
            jSONObject.put("cypher", 4);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Pair<Integer, ?> ms(String str, String str2) {
        byte[] bArrMs;
        if (TextUtils.isEmpty(str)) {
            return c(str);
        }
        if (ny.xr()) {
            bArrMs = ny.ms().ms(com.bytedance.sdk.openadsdk.core.jw.sl.ms(str.getBytes(StandardCharsets.UTF_8)));
        } else {
            bArrMs = null;
        }
        if (bArrMs == null || bArrMs.length == 0) {
            if (ny.xr()) {
                u.ms().ms(3, -1L, str2);
            }
            return c(str);
        }
        return new Pair<>(4, bArrMs);
    }

    public static Pair<Boolean, JSONObject> ms(com.bytedance.sdk.component.ny.xr xrVar, String str, boolean z) {
        if (com.bytedance.sdk.component.ny.d.ms.ms(xrVar.ah())) {
            return new Pair<>(Boolean.FALSE, ms(xrVar.ch(), str));
        }
        String strD = xrVar.d();
        if (strD != null && !strD.startsWith("{") && !strD.endsWith("}") && !strD.contains("message") && !strD.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, ms(xrVar.ch(), str));
        }
        JSONObject jSONObject = null;
        if (strD != null) {
            try {
                jSONObject = new JSONObject(strD);
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        return new Pair<>(Boolean.TRUE, ms(jSONObject, true, z));
    }

    public static JSONObject ms(JSONObject jSONObject, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strMs = ms(jSONObject, z);
            String strOptString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(strMs)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strMs);
            if (z2) {
                try {
                    jSONObject2.put("auction_price", strOptString);
                } catch (Throwable unused) {
                }
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String ms(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                return com.bytedance.sdk.component.utils.ms.ah(strOptString);
            }
            if (iOptInt != 4) {
                return strOptString;
            }
            String strMs = ny.ms().ms(strOptString);
            if (!TextUtils.isEmpty(strMs) || !z) {
                return strMs;
            }
            u.ms().ms(1, -1L, (String) null);
            return strMs;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject ms(byte[] bArr, String str) {
        try {
            String strXr = xr(bArr, str);
            if (TextUtils.isEmpty(strXr)) {
                return null;
            }
            return new JSONObject(strXr);
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    private static String xr(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] bArrXr = ny.ms().xr(bArr);
                    String strXr = com.bytedance.sdk.openadsdk.core.jw.sl.xr(bArrXr);
                    if (!TextUtils.isEmpty(strXr)) {
                        return strXr;
                    }
                    u.ms().ms((bArrXr == null || bArrXr.length == 0) ? 1 : 2, -1L, str);
                    return null;
                }
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        return null;
    }
}
