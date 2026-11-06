package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 576})
public class ww {
    public static int aj;
    public static int g;
    public static int hn;
    public static int ho;
    public static int hw;
    public static int k;
    public static int lb;
    public static int m;
    public static int nt;
    public static int pr;
    public static int vk;
    public static int w;
    public static int x;
    public static int yb;
    public final int a;
    public final int cz;
    public final int fo;
    public final int ny;
    public final int qa;
    public final int rc;
    public final String z;
    public static final ArrayList<int[]> c = new ArrayList<>();
    public static final ArrayList<int[]> uc = new ArrayList<>();
    public static final ArrayList<int[]> fw = new ArrayList<>();
    public static final ArrayList<int[]> zo = new ArrayList<>();
    public static String b = "已为您延迟到奖励下发后再播放下一个";
    public static int iu = 3;
    public static int ve = 0;
    public static int gz = 0;

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("insert_ad_control", 1);
                pr = iOptInt;
                if (iOptInt < 0 || iOptInt > 1) {
                    pr = 1;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("insert_ad_control_fs", 1);
                hw = iOptInt2;
                if (iOptInt2 < 0 || iOptInt2 > 1) {
                    hw = 1;
                }
                hn = jSONObjectOptJSONObject.optInt("insert_ad_req_num", 3);
                x = jSONObjectOptJSONObject.optInt("insert_ad_req_num_fs", 2);
                aj = jSONObjectOptJSONObject.optInt("insert_ad_toast_max_time", 5);
                vk = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time", 0);
                w = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                k = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time", 3);
                m = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time_fs", 3);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("refresh_ad_control", 1);
                g = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > 1) {
                    g = 1;
                }
                ho = jSONObjectOptJSONObject.optInt("refresh_ad_req_num", 3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("force_refresh_ad_control", 1);
                nt = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > 1) {
                    nt = 1;
                }
                yb = jSONObjectOptJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                lb = jSONObjectOptJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    c.clear();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                            c.add(new int[]{jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1)});
                        }
                    }
                } else {
                    c.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    uc.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                        JSONArray jSONArrayOptJSONArray4 = jSONArrayOptJSONArray3.optJSONArray(i2);
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() == 2) {
                            uc.add(new int[]{jSONArrayOptJSONArray4.optInt(0), jSONArrayOptJSONArray4.optInt(1)});
                        }
                    }
                } else {
                    uc.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    fw.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray5.length(); i3++) {
                        JSONArray jSONArrayOptJSONArray6 = jSONArrayOptJSONArray5.optJSONArray(i3);
                        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() == 2) {
                            fw.add(new int[]{jSONArrayOptJSONArray6.optInt(0), jSONArrayOptJSONArray6.optInt(1)});
                        }
                    }
                } else {
                    fw.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
                    zo.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray7.length(); i4++) {
                        JSONArray jSONArrayOptJSONArray8 = jSONArrayOptJSONArray7.optJSONArray(i4);
                        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() == 2) {
                            zo.add(new int[]{jSONArrayOptJSONArray8.optInt(0), jSONArrayOptJSONArray8.optInt(1)});
                        }
                    }
                } else {
                    zo.add(new int[]{0, 500});
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_aggregation_config");
                if (jSONObjectOptJSONObject2 != null) {
                    b = jSONObjectOptJSONObject2.optString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
                    iu = jSONObjectOptJSONObject2.optInt("refresh_ad_clickafter_tip_content_max_time", 3);
                    ve = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich");
                    gz = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich_fs");
                }
            } catch (Exception e) {
            }
        }
    }

    public static boolean pr() {
        return pr == 1;
    }

    public static boolean hw() {
        return hw == 1;
    }

    public static boolean hn() {
        return g == 1;
    }

    public static boolean x() {
        return nt == 1;
    }

    public static int c() {
        return hn;
    }

    public static int uc() {
        return x;
    }

    public static int fw() {
        return ho;
    }

    public static int zo() {
        return aj;
    }

    public static int pr(boolean z) {
        if (z) {
            return vk;
        }
        return w;
    }

    public static int hw(boolean z) {
        if (z) {
            return k;
        }
        return m;
    }

    public static boolean pr(boolean z, boolean z2, int i) {
        return z ? pr(z2, i) : hw(z2, i);
    }

    private static boolean pr(boolean z, int i) {
        if (z) {
            for (int[] iArr : uc) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : c) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hw(boolean z, int i) {
        if (z) {
            for (int[] iArr : zo) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : fw) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pr(int i, of ofVar, boolean z) {
        return c(ofVar) > 0 && i * 1000 >= c(ofVar) - (hw(z) * 1000);
    }

    public static boolean pr(int i, of ofVar) {
        return c(ofVar) > 0 && i * 1000 >= c(ofVar);
    }

    public static int aj() {
        return yb;
    }

    public static int vk() {
        return lb / 1000;
    }

    public ww(JSONObject jSONObject) {
        this.rc = jSONObject.optInt("carousel_pos", -1);
        this.qa = jSONObject.optInt("insert_ad_control", 0);
        this.a = jSONObject.optInt("refresh_ad_control", 0);
        this.fo = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.cz = jSONObject.optInt("force_refresh_ad_control", 0);
        this.ny = jSONObject.optInt("web_refresh_control", 0);
        this.z = jSONObject.optString("carousel_tip_content", "秒后将继续播放下一个");
    }

    public static void pr(com.byazt.zq.c cVar) {
        try {
            pr = cVar.getInt("insert_ad_control", 1);
            hw = cVar.getInt("insert_ad_control_fs", 1);
            hn = cVar.getInt("insert_ad_req_num", 3);
            x = cVar.getInt("insert_ad_req_num_fs", 2);
            aj = cVar.getInt("insert_ad_toast_max_time", 5);
            vk = cVar.getInt("insert_ad_tip_max_time", 0);
            w = cVar.getInt("insert_ad_tip_max_time_fs", 3);
            k = cVar.getInt("refresh_ad_tip_max_time", 3);
            m = cVar.getInt("refresh_ad_tip_max_time_fs", 3);
            g = cVar.getInt("refresh_ad_control", 1);
            ho = cVar.getInt("refresh_ad_req_num", 3);
            nt = cVar.getInt("force_refresh_ad_control", 1);
            yb = cVar.getInt("force_refresh_ad_pause_over_time", 5000);
            lb = cVar.getInt("refresh_ad_reduce_time", 0);
            Set<String> stringSet = cVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                c.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(",");
                    if (strArrSplit.length == 2) {
                        c.add(new int[]{Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])});
                    }
                }
            }
            Set<String> stringSet2 = cVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                uc.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] strArrSplit2 = it2.next().split(",");
                    if (strArrSplit2.length == 2) {
                        uc.add(new int[]{Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1])});
                    }
                }
            }
            Set<String> stringSet3 = cVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                fw.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] strArrSplit3 = it3.next().split(",");
                    if (strArrSplit3.length == 2) {
                        fw.add(new int[]{Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1])});
                    }
                }
            }
            Set<String> stringSet4 = cVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 != null && !stringSet4.isEmpty()) {
                zo.clear();
                Iterator<String> it4 = stringSet4.iterator();
                while (it4.hasNext()) {
                    String[] strArrSplit4 = it4.next().split(",");
                    if (strArrSplit4.length == 2) {
                        zo.add(new int[]{Integer.parseInt(strArrSplit4[0]), Integer.parseInt(strArrSplit4[1])});
                    }
                }
            }
            b = cVar.getString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
            iu = cVar.getInt("refresh_ad_clickafter_tip_content_max_time", 3);
            ve = cVar.getInt("refresh_ad_ifclick_swtich", 0);
            gz = cVar.getInt("refresh_ad_ifclick_swtich_fs", 0);
        } catch (Exception e) {
        }
    }

    public static void hw(com.byazt.zq.c cVar) {
        try {
            cVar.pr("insert_ad_control", pr);
            cVar.pr("insert_ad_control_fs", hw);
            cVar.pr("insert_ad_req_num", hn);
            cVar.pr("insert_ad_req_num_fs", x);
            cVar.pr("insert_ad_toast_max_time", aj);
            cVar.pr("insert_ad_tip_max_time", vk);
            cVar.pr("insert_ad_tip_max_time_fs", w);
            cVar.pr("refresh_ad_tip_max_time", k);
            cVar.pr("refresh_ad_tip_max_time_fs", m);
            cVar.pr("refresh_ad_control", g);
            cVar.pr("refresh_ad_req_num", ho);
            cVar.pr("force_refresh_ad_control", nt);
            cVar.pr("force_refresh_ad_pause_over_time", yb);
            cVar.pr("refresh_ad_reduce_time", lb);
            ArrayList<int[]> arrayList = c;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (int[] iArr : arrayList) {
                    if (iArr != null && iArr.length == 2) {
                        hashSet.add(iArr[0] + "," + iArr[1]);
                    }
                }
                cVar.pr("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = uc;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (int[] iArr2 : arrayList2) {
                    if (iArr2 != null && iArr2.length == 2) {
                        hashSet2.add(iArr2[0] + "," + iArr2[1]);
                    }
                }
                cVar.pr("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = fw;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                for (int[] iArr3 : arrayList3) {
                    if (iArr3 != null && iArr3.length == 2) {
                        hashSet3.add(iArr3[0] + "," + iArr3[1]);
                    }
                }
                cVar.pr("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = zo;
            if (!arrayList4.isEmpty()) {
                HashSet hashSet4 = new HashSet();
                for (int[] iArr4 : arrayList4) {
                    if (iArr4 != null && iArr4.length == 2) {
                        hashSet4.add(iArr4[0] + "," + iArr4[1]);
                    }
                }
                cVar.pr("insert_ad_vd_show_time_fs", hashSet4);
            }
            cVar.pr("refresh_ad_ifclick_swtich_fs", gz);
            cVar.pr("refresh_ad_ifclick_swtich", ve);
            cVar.pr("refresh_ad_clickafter_tip_content", b);
            cVar.pr("refresh_ad_clickafter_tip_content_max_time", iu);
        } catch (Exception e) {
        }
    }

    public void hw(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.rc);
            jSONObject.put("insert_ad_control", this.qa);
            jSONObject.put("refresh_ad_control", this.a);
            jSONObject.put("refresh_ad_imp_max_time", this.fo);
            jSONObject.put("force_refresh_ad_control", this.cz);
            jSONObject.put("web_refresh_control", this.ny);
            jSONObject.put("carousel_tip_content", this.z);
        } catch (JSONException e) {
        }
    }

    private static ww fw(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.u();
    }

    public static int pr(of ofVar) {
        ww wwVarFw = fw(ofVar);
        if (wwVarFw == null) {
            return 0;
        }
        return wwVarFw.qa;
    }

    public static int hw(of ofVar) {
        ww wwVarFw = fw(ofVar);
        if (wwVarFw == null) {
            return 0;
        }
        return wwVarFw.a;
    }

    public static int hn(of ofVar) {
        ww wwVarFw = fw(ofVar);
        if (wwVarFw == null) {
            return 0;
        }
        return wwVarFw.cz;
    }

    public static int x(of ofVar) {
        ww wwVarFw = fw(ofVar);
        if (wwVarFw == null) {
            return -1;
        }
        return wwVarFw.rc;
    }

    public static int c(of ofVar) {
        ww wwVarFw = fw(ofVar);
        if (wwVarFw == null) {
            return 0;
        }
        return wwVarFw.fo;
    }

    public static String uc(of ofVar) {
        ww wwVarFw = fw(ofVar);
        if (wwVarFw == null) {
            return "秒后将继续播放下一个";
        }
        return wwVarFw.z;
    }

    public static boolean pr(boolean z, of ofVar, boolean z2) {
        return z ? hn(ofVar, z2) : x(ofVar, z2);
    }

    private static boolean hn(of ofVar, boolean z) {
        return (!z || pr == 1) && pr(ofVar) == 1 && x(ofVar) > 0;
    }

    private static boolean x(of ofVar, boolean z) {
        return (!z || hw == 1) && pr(ofVar) == 1 && x(ofVar) > 0;
    }

    public static boolean pr(of ofVar, boolean z) {
        return (!z || g == 1) && hw(ofVar) == 1 && x(ofVar) > 0;
    }

    public static boolean hw(of ofVar, boolean z) {
        return (!z || nt == 1) && hn(ofVar) == 1 && x(ofVar) > 0;
    }

    public static boolean hw(boolean z, of ofVar, boolean z2) {
        return pr(z, ofVar, z2) || pr(ofVar, z2) || hw(ofVar, z2);
    }

    public static String w() {
        return b;
    }

    public static int k() {
        return iu;
    }

    public static int m() {
        return ve;
    }

    public static int g() {
        return gz;
    }
}
