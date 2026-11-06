package com.byazt.gzx;

import android.text.TextUtils;
import com.byazt.gct.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1081, 101})
public final class fs {

    @com.byazt.cp.n(n = {0, 1, 1081, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public static final class n {
        public int n = 0;
        public int qg = 0;
    }

    public static n n(String str) {
        n nVar = new n();
        if (TextUtils.isEmpty(str)) {
            return nVar;
        }
        try {
            int iN = wo.n();
            if (iN <= 0) {
                return nVar;
            }
            Object objN = com.byazt.aun.q.n().n("cache_fea_load_send_time", "show_load_time", str);
            if (objN instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objN;
                double dOptDouble = jSONObject.optDouble("time_avg", -1.0d);
                int iOptInt = jSONObject.optInt("show_cnt", 0);
                int iS = wo.s();
                boolean z = iS <= 0 || iOptInt >= iS;
                boolean z2 = dOptDouble >= 0.0d;
                if (z && z2) {
                    nVar.n = dOptDouble > ((double) iN) ? 1 : 2;
                }
                int iQg = wo.qg();
                if (z && iQg > 0 && dOptDouble > iQg) {
                    Object objN2 = com.byazt.aun.q.n().n("cache_fea_send_seq", "send_show_seq", str);
                    Object objN3 = com.byazt.aun.q.n().n("cache_fea_send_price_seq", "send_show_seq", str);
                    Object objN4 = com.byazt.aun.q.n().n("cache_fea_show_seq", "send_show_seq", str);
                    JSONArray jSONArrayOptJSONArray = objN2 instanceof JSONObject ? ((JSONObject) objN2).optJSONArray("send_seq") : null;
                    JSONArray jSONArrayOptJSONArray2 = objN3 instanceof JSONObject ? ((JSONObject) objN3).optJSONArray("send_price_seq") : null;
                    JSONArray jSONArrayOptJSONArray3 = objN4 instanceof JSONObject ? ((JSONObject) objN4).optJSONArray("show_seq") : null;
                    if (n(jSONArrayOptJSONArray) && n(jSONArrayOptJSONArray2) && n(jSONArrayOptJSONArray3)) {
                        boolean z3 = n(jSONArrayOptJSONArray, jSONArrayOptJSONArray2) ? false : true;
                        Double dQg = qg(jSONArrayOptJSONArray3, jSONArrayOptJSONArray2);
                        if (z3 && dQg != null) {
                            nVar.qg = dQg.doubleValue() > 0.0d ? 1 : 2;
                            dQg.doubleValue();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return nVar;
    }

    private static boolean n(JSONArray jSONArray) {
        return jSONArray != null && jSONArray.length() >= 2;
    }

    private static boolean n(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i, null);
            String strOptString2 = jSONArray2.optString(i, null);
            if (strOptString == null) {
                if (strOptString2 != null) {
                    return false;
                }
            } else {
                if (!strOptString.equals(strOptString2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Double qg(JSONArray jSONArray, JSONArray jSONArray2) {
        Integer num;
        if (jSONArray == null || jSONArray2 == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray2.length(); i++) {
            String strOptString = jSONArray2.optString(i, null);
            if (!TextUtils.isEmpty(strOptString) && !map.containsKey(strOptString)) {
                map.put(strOptString, Integer.valueOf(i));
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String strOptString2 = jSONArray.optString(i2, null);
            if (!TextUtils.isEmpty(strOptString2) && (num = (Integer) map.get(strOptString2)) != null) {
                arrayList.add(Integer.valueOf(i2));
                arrayList2.add(num);
            }
        }
        int size = arrayList.size();
        if (size < 2) {
            return null;
        }
        double dIntValue = 0.0d;
        double dIntValue2 = 0.0d;
        for (int i3 = 0; i3 < size; i3++) {
            dIntValue += (double) ((Integer) arrayList.get(i3)).intValue();
            dIntValue2 += (double) ((Integer) arrayList2.get(i3)).intValue();
        }
        double d = size;
        double d2 = dIntValue / d;
        double d3 = dIntValue2 / d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        for (int i4 = 0; i4 < size; i4++) {
            double dIntValue3 = ((double) ((Integer) arrayList.get(i4)).intValue()) - d2;
            double dIntValue4 = ((double) ((Integer) arrayList2.get(i4)).intValue()) - d3;
            d5 += dIntValue3 * dIntValue4;
            d4 += dIntValue3 * dIntValue3;
            d6 += dIntValue4 * dIntValue4;
        }
        if (d4 <= 0.0d || d6 <= 0.0d) {
            return null;
        }
        return Double.valueOf(d5 / Math.sqrt(d4 * d6));
    }
}
