package com.byazt.iza;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.view.LinearContainerViewManager;
import com.taptap.sdk.db.constant.Common;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 124, 121})
public class x {
    public static List<hn> pr(String str, JSONObject jSONObject) {
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
                    arrayList.add(pr(jSONObjectOptJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static hn pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        hn hnVar = new hn();
        hnVar.hw(com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString(Constants.DELAY_FIELD), jSONObject2), 0L));
        hnVar.hn(com.byazt.tn.hw.pr(jSONObject.optString(Common.System.NAME), jSONObject2));
        hnVar.hw(com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString("playState"), jSONObject2), 1));
        hnVar.pr(Math.max(com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString("duration"), jSONObject2), 0L), 0L));
        hnVar.pr(com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString("playCount"), jSONObject2), 1));
        hnVar.pr(com.byazt.tn.hw.pr(jSONObject.optString("playDirection"), jSONObject2));
        hnVar.pr(hn(jSONObject.optString("transformOrigin"), jSONObject2));
        hnVar.hw(com.byazt.tn.hw.pr(jSONObject.optString("timingFunction", LinearContainerViewManager.NAME), jSONObject2));
        hnVar.pr(jSONObject.optJSONObject("effect"));
        hnVar.pr(pr(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return hnVar;
    }

    public static Map<String, TreeMap<Float, String>> pr(JSONArray jSONArray, JSONObject jSONObject) {
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
                        treeMap.put(Float.valueOf(fOptDouble), x(jSONObjectOptJSONObject.optString(next), jSONObject));
                    }
                }
            }
        }
        return map;
    }

    private static String x(String str, JSONObject jSONObject) {
        String strPr = com.byazt.tn.hw.pr(str, jSONObject);
        if (hn(strPr)) {
            return Arrays.toString(hw(strPr, jSONObject));
        }
        return com.byazt.tn.hw.pr(strPr, jSONObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public static int pr(String str) {
        switch (str) {
            case "alternate":
                return 2;
            case "normal":
            default:
                return 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    public static Interpolator hw(String str) {
        switch (str) {
            case "ease_in":
                return new AccelerateInterpolator();
            case "ease_in_out":
                return new AccelerateDecelerateInterpolator();
            case "ease_out":
                return new DecelerateInterpolator();
            case "linear":
            default:
                return new LinearInterpolator();
        }
    }

    public static float[] hw(String str, JSONObject jSONObject) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayPr = com.byazt.aa.hw.pr(jSONObject, str, null);
        if (jSONArrayPr == null || jSONArrayPr.length() != 2) {
            return fArr;
        }
        fArr[0] = (float) com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONArrayPr.optString(0), jSONObject), 0.0d);
        fArr[1] = (float) com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONArrayPr.optString(1), jSONObject), 0.0d);
        return fArr;
    }

    public static boolean hn(String str) {
        JSONArray jSONArrayPr = com.byazt.aa.hw.pr(str, (JSONArray) null);
        return jSONArrayPr != null && jSONArrayPr.length() > 0;
    }

    public static int pr(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        return i - 1;
    }

    public static hn.pr hn(String str, JSONObject jSONObject) {
        JSONArray jSONArrayPr;
        if (TextUtils.isEmpty(str) || (jSONArrayPr = com.byazt.aa.hw.pr(jSONObject, str, null)) == null || jSONArrayPr.length() != 2) {
            return null;
        }
        hn.pr prVar = new hn.pr();
        prVar.pr = com.byazt.tn.hw.pr(jSONArrayPr.optString(0), jSONObject);
        prVar.hw = com.byazt.tn.hw.pr(jSONArrayPr.optString(1), jSONObject);
        return prVar;
    }

    public static int pr(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        switch (str) {
            case "center":
                return i2;
            case "bottom":
            case "right":
                return i;
            case "left":
            case "top":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException e) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e2) {
                    return i2;
                }
        }
    }
}
