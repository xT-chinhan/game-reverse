package com.bytedance.sdk.openadsdk.core.nw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class of {
    private static int ah;
    private static int ao;
    private static int ch;
    private static int d;
    private static int hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f3072ms;
    private static int ny;
    private static int sl;
    private static int u;
    private static int ub;
    private static int xr;
    private static int zb;
    private final int h;
    private final int nw;
    private final int qv;
    private final int t;
    private final int y;
    private static final ArrayList<int[]> ka = new ArrayList<>();
    private static final ArrayList<int[]> c = new ArrayList<>();
    private static final ArrayList<int[]> ab = new ArrayList<>();
    private static final ArrayList<int[]> x = new ArrayList<>();

    public static void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("insert_ad_control", 1);
                f3072ms = iOptInt;
                if (iOptInt < 0 || iOptInt > 1) {
                    f3072ms = 1;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("insert_ad_control_fs", 1);
                xr = iOptInt2;
                if (iOptInt2 < 0 || iOptInt2 > 1) {
                    xr = 1;
                }
                ah = jSONObjectOptJSONObject.optInt("insert_ad_req_num", 3);
                d = jSONObjectOptJSONObject.optInt("insert_ad_req_num_fs", 2);
                ny = jSONObjectOptJSONObject.optInt("insert_ad_toast_max_time", 5);
                ch = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time", 0);
                hi = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("refresh_ad_control", 1);
                sl = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > 1) {
                    sl = 1;
                }
                zb = jSONObjectOptJSONObject.optInt("refresh_ad_req_num", 3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("force_refresh_ad_control", 1);
                u = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > 1) {
                    u = 1;
                }
                ub = jSONObjectOptJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                ao = jSONObjectOptJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ka.clear();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                            ka.add(new int[]{jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1)});
                        }
                    }
                } else {
                    ka.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    c.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                        JSONArray jSONArrayOptJSONArray4 = jSONArrayOptJSONArray3.optJSONArray(i2);
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() == 2) {
                            c.add(new int[]{jSONArrayOptJSONArray4.optInt(0), jSONArrayOptJSONArray4.optInt(1)});
                        }
                    }
                } else {
                    c.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    ab.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray5.length(); i3++) {
                        JSONArray jSONArrayOptJSONArray6 = jSONArrayOptJSONArray5.optJSONArray(i3);
                        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() == 2) {
                            ab.add(new int[]{jSONArrayOptJSONArray6.optInt(0), jSONArrayOptJSONArray6.optInt(1)});
                        }
                    }
                } else {
                    ab.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
                    x.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray7.length(); i4++) {
                        JSONArray jSONArrayOptJSONArray8 = jSONArrayOptJSONArray7.optJSONArray(i4);
                        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() == 2) {
                            x.add(new int[]{jSONArrayOptJSONArray8.optInt(0), jSONArrayOptJSONArray8.optInt(1)});
                        }
                    }
                    return;
                }
                x.add(new int[]{0, 500});
            } catch (Exception unused) {
            }
        }
    }

    public static boolean ms() {
        return f3072ms == 1;
    }

    public static boolean xr() {
        return xr == 1;
    }

    public static boolean ah() {
        return sl == 1;
    }

    public static boolean d() {
        return u == 1;
    }

    public static int ka() {
        return ah;
    }

    public static int c() {
        return d;
    }

    public static int ab() {
        return zb;
    }

    public static int x() {
        return ny;
    }

    public static int ms(boolean z) {
        if (z) {
            return ch;
        }
        return hi;
    }

    public static boolean ms(boolean z, boolean z2, int i) {
        return z ? ms(z2, i) : xr(z2, i);
    }

    private static boolean ms(boolean z, int i) {
        if (z) {
            for (int[] iArr : c) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : ka) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean xr(boolean z, int i) {
        if (z) {
            for (int[] iArr : x) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : ab) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ms(int i, lm lmVar) {
        return ka(lmVar) > 0 && i * 1000 >= ka(lmVar);
    }

    public static boolean xr(int i, lm lmVar) {
        return ka(lmVar) > 0 && i * 1000 >= ka(lmVar);
    }

    public static int ny() {
        return ub;
    }

    public static int ch() {
        return ao / 1000;
    }

    public of(JSONObject jSONObject) {
        this.nw = jSONObject.optInt("carousel_pos", -1);
        this.h = jSONObject.optInt("insert_ad_control", 0);
        this.qv = jSONObject.optInt("refresh_ad_control", 0);
        this.t = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.y = jSONObject.optInt("force_refresh_ad_control", 0);
    }

    public static void ms(com.bytedance.sdk.component.d.ms.xr xrVar) {
        try {
            xrVar.ms("insert_ad_control", f3072ms);
            xrVar.ms("insert_ad_control_fs", xr);
            xrVar.ms("insert_ad_req_num", ah);
            xrVar.ms("insert_ad_req_num_fs", d);
            xrVar.ms("insert_ad_toast_max_time", ny);
            xrVar.ms("insert_ad_tip_max_time", ch);
            xrVar.ms("insert_ad_tip_max_time_fs", hi);
            xrVar.ms("refresh_ad_control", sl);
            xrVar.ms("refresh_ad_req_num", zb);
            ArrayList<int[]> arrayList = ka;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (int[] iArr : arrayList) {
                    if (iArr != null && iArr.length == 2) {
                        hashSet.add(iArr[0] + "," + iArr[1]);
                    }
                }
                xrVar.ms("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = c;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (int[] iArr2 : arrayList2) {
                    if (iArr2 != null && iArr2.length == 2) {
                        hashSet2.add(iArr2[0] + "," + iArr2[1]);
                    }
                }
                xrVar.ms("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = ab;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                for (int[] iArr3 : arrayList3) {
                    if (iArr3 != null && iArr3.length == 2) {
                        hashSet3.add(iArr3[0] + "," + iArr3[1]);
                    }
                }
                xrVar.ms("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = x;
            if (arrayList4.isEmpty()) {
                return;
            }
            HashSet hashSet4 = new HashSet();
            for (int[] iArr4 : arrayList4) {
                if (iArr4 != null && iArr4.length == 2) {
                    hashSet4.add(iArr4[0] + "," + iArr4[1]);
                }
            }
            xrVar.ms("insert_ad_vd_show_time_fs", hashSet4);
        } catch (Exception unused) {
        }
    }

    public static void xr(com.bytedance.sdk.component.d.ms.xr xrVar) {
        try {
            f3072ms = xrVar.getInt("insert_ad_control", 1);
            xr = xrVar.getInt("insert_ad_control_fs", 1);
            ah = xrVar.getInt("insert_ad_req_num", 3);
            d = xrVar.getInt("insert_ad_req_num_fs", 2);
            ny = xrVar.getInt("insert_ad_toast_max_time", 5);
            ch = xrVar.getInt("insert_ad_tip_max_time", 0);
            hi = xrVar.getInt("insert_ad_tip_max_time_fs", 3);
            sl = xrVar.getInt("refresh_ad_control", 1);
            zb = xrVar.getInt("refresh_ad_req_num", 3);
            Set<String> stringSet = xrVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                ka.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(",");
                    if (strArrSplit.length == 2) {
                        ka.add(new int[]{Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])});
                    }
                }
            }
            Set<String> stringSet2 = xrVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                c.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] strArrSplit2 = it2.next().split(",");
                    if (strArrSplit2.length == 2) {
                        c.add(new int[]{Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1])});
                    }
                }
            }
            Set<String> stringSet3 = xrVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                ab.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] strArrSplit3 = it3.next().split(",");
                    if (strArrSplit3.length == 2) {
                        ab.add(new int[]{Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1])});
                    }
                }
            }
            Set<String> stringSet4 = xrVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 == null || stringSet4.isEmpty()) {
                return;
            }
            x.clear();
            Iterator<String> it4 = stringSet4.iterator();
            while (it4.hasNext()) {
                String[] strArrSplit4 = it4.next().split(",");
                if (strArrSplit4.length == 2) {
                    x.add(new int[]{Integer.parseInt(strArrSplit4[0]), Integer.parseInt(strArrSplit4[1])});
                }
            }
        } catch (Exception unused) {
        }
    }

    public void xr(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.nw);
            jSONObject.put("insert_ad_control", this.h);
            jSONObject.put("refresh_ad_control", this.qv);
            jSONObject.put("refresh_ad_imp_max_time", this.t);
            jSONObject.put("force_refresh_ad_control", this.y);
        } catch (JSONException unused) {
        }
    }

    private static of c(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.eg();
    }

    public static int ms(lm lmVar) {
        of ofVarC = c(lmVar);
        if (ofVarC == null) {
            return 0;
        }
        return ofVarC.h;
    }

    public static int xr(lm lmVar) {
        of ofVarC = c(lmVar);
        if (ofVarC == null) {
            return 0;
        }
        return ofVarC.qv;
    }

    public static int ah(lm lmVar) {
        of ofVarC = c(lmVar);
        if (ofVarC == null) {
            return 0;
        }
        return ofVarC.y;
    }

    public static int d(lm lmVar) {
        of ofVarC = c(lmVar);
        if (ofVarC == null) {
            return -1;
        }
        return ofVarC.nw;
    }

    public static int ka(lm lmVar) {
        of ofVarC = c(lmVar);
        if (ofVarC == null) {
            return 0;
        }
        return ofVarC.t;
    }

    public static boolean ms(boolean z, lm lmVar, boolean z2) {
        return z ? ah(lmVar, z2) : d(lmVar, z2);
    }

    private static boolean ah(lm lmVar, boolean z) {
        return (!z || f3072ms == 1) && ms(lmVar) == 1 && d(lmVar) > 0;
    }

    private static boolean d(lm lmVar, boolean z) {
        return (!z || xr == 1) && ms(lmVar) == 1 && d(lmVar) > 0;
    }

    public static boolean ms(lm lmVar, boolean z) {
        return (!z || sl == 1) && xr(lmVar) == 1 && d(lmVar) > 0;
    }

    public static boolean xr(lm lmVar, boolean z) {
        return (!z || u == 1) && ah(lmVar) == 1 && d(lmVar) > 0;
    }

    public static boolean xr(boolean z, lm lmVar, boolean z2) {
        return ms(z, lmVar, z2) || ms(lmVar, z2) || xr(lmVar, z2);
    }
}
