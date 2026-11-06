package com.bytedance.adsdk.ugeno.ms;

import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static int ms(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return i - 1;
    }

    public static xr ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xr xrVar = new xr();
        xrVar.xr(jSONObject.optLong("delay"));
        xrVar.ms(jSONObject.optLong("duration"));
        xrVar.ms(jSONObject.optInt("playCount", 1));
        xrVar.ms(jSONObject.optString("playDirection"));
        xrVar.ms(d(jSONObject.optString("transformOrigin")));
        xrVar.xr(jSONObject.optString("timingFunction", "linear"));
        xrVar.ms(jSONObject.optJSONObject("effect"));
        xrVar.ms(ms(jSONObject.optJSONArray("keyframes")));
        return xrVar;
    }

    public static Map<String, TreeMap<Float, String>> ms(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble("offset");
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (map.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            new Pair(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            treeMap2.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            map.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    public static int ms(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1408024454) {
            if (iHashCode == -1039745817 && str.equals(PrerollVideoResponse.NORMAL)) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("alternate")) {
            b = 0;
        } else {
            b = -1;
        }
        return b != 0 ? 1 : 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    public static Interpolator xr(String str) {
        byte b;
        switch (str) {
            case "ease_in":
                b = 0;
                break;
            case "linear":
                b = 3;
                break;
            case "ease_out":
                b = 2;
                break;
            case "ease_in_out":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return new AccelerateInterpolator();
        }
        if (b == 1) {
            return new AccelerateDecelerateInterpolator();
        }
        if (b == 2) {
            return new DecelerateInterpolator();
        }
        return new LinearInterpolator();
    }

    public static float[] ah(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayMs = com.bytedance.adsdk.ugeno.c.xr.ms(str, (JSONArray) null);
        if (jSONArrayMs != null && jSONArrayMs.length() == 2) {
            fArr[0] = (float) jSONArrayMs.optDouble(0);
            fArr[1] = (float) jSONArrayMs.optDouble(1);
        }
        return fArr;
    }

    public static xr.ms d(String str) {
        JSONArray jSONArrayMs;
        if (TextUtils.isEmpty(str) || (jSONArrayMs = com.bytedance.adsdk.ugeno.c.xr.ms(str, (JSONArray) null)) == null || jSONArrayMs.length() != 2) {
            return null;
        }
        xr.ms msVar = new xr.ms();
        msVar.f385ms = jSONArrayMs.optString(0);
        msVar.xr = jSONArrayMs.optString(1);
        return msVar;
    }

    public static int ms(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i;
            case "center":
                return i2;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }
}
