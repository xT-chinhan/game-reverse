package com.byazt.vy;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static boolean l = true;
    public static boolean n = true;
    public static boolean q = true;
    public static boolean qg = true;
    public static boolean s = true;
    public static boolean w;
    public static final Map<Integer, Map<String, List<List<String>>>> x = new HashMap();

    public static boolean n() {
        return w;
    }

    public static void n(boolean z) {
        w = z;
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                                Integer numValueOf = Integer.valueOf(jSONObject2.optInt("rit_type"));
                                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (jSONArrayOptJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                        JSONArray jSONArray = jSONArrayOptJSONArray2.getJSONArray(i2);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                String string = jSONArray.getString(i3);
                                                if (!TextUtils.isEmpty(string)) {
                                                    arrayList2.add(string);
                                                }
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        HashMap map = new HashMap();
                                        map.put(next, arrayList);
                                        x.put(numValueOf, map);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.byazt.rb.qg.n("TMe", "supervisorFeature error: " + e.toString());
                return;
            }
        }
        com.byazt.rb.qg.n("TMe", "--==-- adn features:" + x);
    }

    private static boolean n(Object obj, List<List<String>> list) {
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i = 0; i < stackTraceElementArr.length; i++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (stackTraceElement != null) {
                        String string = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(string) && string.contains(list2.get(0)) && (list2.size() == 1 || n(stackTraceElementArr, i, list2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean n(Object obj, int i, List<String> list) {
        int i2;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            if (TextUtils.isEmpty(str) || (i2 = i + i3) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            if (stackTraceElement != null) {
                String string = stackTraceElement.toString();
                if (TextUtils.isEmpty(string) || !string.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean qg() {
        StackTraceElement[] stackTrace;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0 || (map = x.get(7)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return n(stackTrace, list);
    }

    public static boolean s() {
        StackTraceElement[] stackTrace;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0 || (map = x.get(8)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return n(stackTrace, list);
    }

    public static boolean q() {
        if (!n) {
            return false;
        }
        n = false;
        return true;
    }

    public static boolean l() {
        if (!qg) {
            return false;
        }
        qg = false;
        return true;
    }

    public static boolean w() {
        if (!s) {
            return false;
        }
        s = false;
        return true;
    }

    public static boolean x() {
        if (!q) {
            return false;
        }
        q = false;
        return true;
    }

    public static boolean fs() {
        if (!l) {
            return false;
        }
        l = false;
        return true;
    }
}
