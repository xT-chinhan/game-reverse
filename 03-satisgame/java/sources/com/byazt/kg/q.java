package com.byazt.kg;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1238, 5})
public class q {
    public static int n(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        return i - 1;
    }

    public static List<s> n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(n(jSONObjectOptJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static s n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        s sVar = new s();
        sVar.qg(com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("delay"), jSONObject2), 0L));
        sVar.s(com.byazt.mcb.qg.n(jSONObject.optString(TapEventParamConstants.PARAM_NAME), jSONObject2));
        sVar.qg(com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("playState"), jSONObject2), 1));
        sVar.n(Math.max(com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString(MediationConstant.EXTRA_DURATION), jSONObject2), 0L), 0L));
        sVar.n(com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("playCount"), jSONObject2), 1));
        sVar.n(com.byazt.mcb.qg.n(jSONObject.optString("playDirection"), jSONObject2));
        sVar.n(s(jSONObject.optString("transformOrigin"), jSONObject2));
        sVar.qg(com.byazt.mcb.qg.n(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        sVar.n(jSONObject.optJSONObject("effect"));
        sVar.n(n(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return sVar;
    }

    public static Map<String, TreeMap<Float, String>> n(JSONArray jSONArray, JSONObject jSONObject) {
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
                    if (!TextUtils.equals(next, "offset")) {
                        TreeMap treeMap = (TreeMap) map.get(next);
                        if (treeMap == null) {
                            treeMap = new TreeMap();
                            map.put(next, treeMap);
                        }
                        treeMap.put(Float.valueOf(fOptDouble), q(jSONObjectOptJSONObject.optString(next), jSONObject));
                    }
                }
            }
        }
        return map;
    }

    private static String q(String str, JSONObject jSONObject) {
        String strN = com.byazt.mcb.qg.n(str, jSONObject);
        if (s(strN)) {
            return Arrays.toString(qg(strN, jSONObject));
        }
        return com.byazt.mcb.qg.n(strN, jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    public static int n(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1408024454) {
            if (iHashCode == -1039745817 && str.equals("normal")) {
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
    public static Interpolator qg(String str) {
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

    public static float[] qg(String str, JSONObject jSONObject) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayN = com.byazt.hb.qg.n(jSONObject, str, null);
        if (jSONArrayN != null && jSONArrayN.length() == 2) {
            fArr[0] = (float) com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONArrayN.optString(0), jSONObject), 0.0d);
            fArr[1] = (float) com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONArrayN.optString(1), jSONObject), 0.0d);
        }
        return fArr;
    }

    public static boolean s(String str) {
        JSONArray jSONArrayN = com.byazt.hb.qg.n(str, (JSONArray) null);
        return jSONArrayN != null && jSONArrayN.length() > 0;
    }

    public static s.n s(String str, JSONObject jSONObject) {
        JSONArray jSONArrayN;
        if (TextUtils.isEmpty(str) || (jSONArrayN = com.byazt.hb.qg.n(jSONObject, str, null)) == null || jSONArrayN.length() != 2) {
            return null;
        }
        s.n nVar = new s.n();
        nVar.n = com.byazt.mcb.qg.n(jSONArrayN.optString(0), jSONObject);
        nVar.qg = com.byazt.mcb.qg.n(jSONArrayN.optString(1), jSONObject);
        return nVar;
    }

    public static int n(String str, int i) {
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
