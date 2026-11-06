package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT})
public class j {
    public static int cd;
    public static int cp;
    public static int cy;
    public static int d;
    public static int hd;
    public static int k;
    public static int n;
    public static int oa;
    public static int q;
    public static int qg;
    public static int rv;
    public static int s;
    public static int sz;
    public static int tj;
    public final int a;
    public final String hu;
    public final int m;
    public final int ou;
    public final int py;
    public final int um;
    public final int wm;
    public static final ArrayList<int[]> l = new ArrayList<>();
    public static final ArrayList<int[]> w = new ArrayList<>();
    public static final ArrayList<int[]> x = new ArrayList<>();
    public static final ArrayList<int[]> fs = new ArrayList<>();
    public static String h = "已为您延迟到奖励下发后再播放下一个";
    public static int t = 3;
    public static int ur = 0;
    public static int bb = 0;

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("insert_ad_control", 1);
                n = iOptInt;
                if (iOptInt < 0 || iOptInt > 1) {
                    n = 1;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("insert_ad_control_fs", 1);
                qg = iOptInt2;
                if (iOptInt2 < 0 || iOptInt2 > 1) {
                    qg = 1;
                }
                s = jSONObjectOptJSONObject.optInt("insert_ad_req_num", 3);
                q = jSONObjectOptJSONObject.optInt("insert_ad_req_num_fs", 2);
                rv = jSONObjectOptJSONObject.optInt("insert_ad_toast_max_time", 5);
                tj = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time", 0);
                cp = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                d = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time", 3);
                oa = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time_fs", 3);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("refresh_ad_control", 1);
                sz = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > 1) {
                    sz = 1;
                }
                k = jSONObjectOptJSONObject.optInt("refresh_ad_req_num", 3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("force_refresh_ad_control", 1);
                cy = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > 1) {
                    cy = 1;
                }
                hd = jSONObjectOptJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                cd = jSONObjectOptJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    l.clear();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                            l.add(new int[]{jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1)});
                        }
                    }
                } else {
                    l.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    w.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                        JSONArray jSONArrayOptJSONArray4 = jSONArrayOptJSONArray3.optJSONArray(i2);
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() == 2) {
                            w.add(new int[]{jSONArrayOptJSONArray4.optInt(0), jSONArrayOptJSONArray4.optInt(1)});
                        }
                    }
                } else {
                    w.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    x.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray5.length(); i3++) {
                        JSONArray jSONArrayOptJSONArray6 = jSONArrayOptJSONArray5.optJSONArray(i3);
                        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() == 2) {
                            x.add(new int[]{jSONArrayOptJSONArray6.optInt(0), jSONArrayOptJSONArray6.optInt(1)});
                        }
                    }
                } else {
                    x.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
                    fs.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray7.length(); i4++) {
                        JSONArray jSONArrayOptJSONArray8 = jSONArrayOptJSONArray7.optJSONArray(i4);
                        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() == 2) {
                            fs.add(new int[]{jSONArrayOptJSONArray8.optInt(0), jSONArrayOptJSONArray8.optInt(1)});
                        }
                    }
                } else {
                    fs.add(new int[]{0, 500});
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_aggregation_config");
                if (jSONObjectOptJSONObject2 != null) {
                    h = jSONObjectOptJSONObject2.optString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
                    t = jSONObjectOptJSONObject2.optInt("refresh_ad_clickafter_tip_content_max_time", 3);
                    ur = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich");
                    bb = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich_fs");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean n() {
        return n == 1;
    }

    public static boolean qg() {
        return qg == 1;
    }

    public static boolean s() {
        return sz == 1;
    }

    public static boolean q() {
        return cy == 1;
    }

    public static int l() {
        return s;
    }

    public static int w() {
        return q;
    }

    public static int x() {
        return k;
    }

    public static int fs() {
        return rv;
    }

    public static int n(boolean z) {
        if (z) {
            return tj;
        }
        return cp;
    }

    public static int qg(boolean z) {
        if (z) {
            return d;
        }
        return oa;
    }

    public static boolean n(boolean z, boolean z2, int i) {
        return z ? n(z2, i) : qg(z2, i);
    }

    private static boolean n(boolean z, int i) {
        if (z) {
            for (int[] iArr : w) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : l) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean qg(boolean z, int i) {
        if (z) {
            for (int[] iArr : fs) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : x) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(int i, pk pkVar, boolean z) {
        return l(pkVar) > 0 && i * 1000 >= l(pkVar) - (qg(z) * 1000);
    }

    public static boolean n(int i, pk pkVar) {
        return l(pkVar) > 0 && i * 1000 >= l(pkVar);
    }

    public static int rv() {
        return hd;
    }

    public static int tj() {
        return cd / 1000;
    }

    public j(JSONObject jSONObject) {
        this.m = jSONObject.optInt("carousel_pos", -1);
        this.um = jSONObject.optInt("insert_ad_control", 0);
        this.a = jSONObject.optInt("refresh_ad_control", 0);
        this.wm = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.py = jSONObject.optInt("force_refresh_ad_control", 0);
        this.ou = jSONObject.optInt("web_refresh_control", 0);
        this.hu = jSONObject.optString("carousel_tip_content", "秒后将继续播放下一个");
    }

    public static void n(com.byazt.gwu.l lVar) {
        try {
            n = lVar.getInt("insert_ad_control", 1);
            qg = lVar.getInt("insert_ad_control_fs", 1);
            s = lVar.getInt("insert_ad_req_num", 3);
            q = lVar.getInt("insert_ad_req_num_fs", 2);
            rv = lVar.getInt("insert_ad_toast_max_time", 5);
            tj = lVar.getInt("insert_ad_tip_max_time", 0);
            cp = lVar.getInt("insert_ad_tip_max_time_fs", 3);
            d = lVar.getInt("refresh_ad_tip_max_time", 3);
            oa = lVar.getInt("refresh_ad_tip_max_time_fs", 3);
            sz = lVar.getInt("refresh_ad_control", 1);
            k = lVar.getInt("refresh_ad_req_num", 3);
            cy = lVar.getInt("force_refresh_ad_control", 1);
            hd = lVar.getInt("force_refresh_ad_pause_over_time", 5000);
            cd = lVar.getInt("refresh_ad_reduce_time", 0);
            Set<String> stringSet = lVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                l.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(",");
                    if (strArrSplit.length == 2) {
                        l.add(new int[]{Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])});
                    }
                }
            }
            Set<String> stringSet2 = lVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                w.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] strArrSplit2 = it2.next().split(",");
                    if (strArrSplit2.length == 2) {
                        w.add(new int[]{Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1])});
                    }
                }
            }
            Set<String> stringSet3 = lVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                x.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] strArrSplit3 = it3.next().split(",");
                    if (strArrSplit3.length == 2) {
                        x.add(new int[]{Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1])});
                    }
                }
            }
            Set<String> stringSet4 = lVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 != null && !stringSet4.isEmpty()) {
                fs.clear();
                Iterator<String> it4 = stringSet4.iterator();
                while (it4.hasNext()) {
                    String[] strArrSplit4 = it4.next().split(",");
                    if (strArrSplit4.length == 2) {
                        fs.add(new int[]{Integer.parseInt(strArrSplit4[0]), Integer.parseInt(strArrSplit4[1])});
                    }
                }
            }
            h = lVar.getString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
            t = lVar.getInt("refresh_ad_clickafter_tip_content_max_time", 3);
            ur = lVar.getInt("refresh_ad_ifclick_swtich", 0);
            bb = lVar.getInt("refresh_ad_ifclick_swtich_fs", 0);
        } catch (Exception unused) {
        }
    }

    public static void qg(com.byazt.gwu.l lVar) {
        try {
            lVar.n("insert_ad_control", n);
            lVar.n("insert_ad_control_fs", qg);
            lVar.n("insert_ad_req_num", s);
            lVar.n("insert_ad_req_num_fs", q);
            lVar.n("insert_ad_toast_max_time", rv);
            lVar.n("insert_ad_tip_max_time", tj);
            lVar.n("insert_ad_tip_max_time_fs", cp);
            lVar.n("refresh_ad_tip_max_time", d);
            lVar.n("refresh_ad_tip_max_time_fs", oa);
            lVar.n("refresh_ad_control", sz);
            lVar.n("refresh_ad_req_num", k);
            lVar.n("force_refresh_ad_control", cy);
            lVar.n("force_refresh_ad_pause_over_time", hd);
            lVar.n("refresh_ad_reduce_time", cd);
            ArrayList<int[]> arrayList = l;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (int[] iArr : arrayList) {
                    if (iArr != null && iArr.length == 2) {
                        hashSet.add(iArr[0] + "," + iArr[1]);
                    }
                }
                lVar.n("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = w;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (int[] iArr2 : arrayList2) {
                    if (iArr2 != null && iArr2.length == 2) {
                        hashSet2.add(iArr2[0] + "," + iArr2[1]);
                    }
                }
                lVar.n("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = x;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                for (int[] iArr3 : arrayList3) {
                    if (iArr3 != null && iArr3.length == 2) {
                        hashSet3.add(iArr3[0] + "," + iArr3[1]);
                    }
                }
                lVar.n("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = fs;
            if (!arrayList4.isEmpty()) {
                HashSet hashSet4 = new HashSet();
                for (int[] iArr4 : arrayList4) {
                    if (iArr4 != null && iArr4.length == 2) {
                        hashSet4.add(iArr4[0] + "," + iArr4[1]);
                    }
                }
                lVar.n("insert_ad_vd_show_time_fs", hashSet4);
            }
            lVar.n("refresh_ad_ifclick_swtich_fs", bb);
            lVar.n("refresh_ad_ifclick_swtich", ur);
            lVar.n("refresh_ad_clickafter_tip_content", h);
            lVar.n("refresh_ad_clickafter_tip_content_max_time", t);
        } catch (Exception unused) {
        }
    }

    public void qg(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.m);
            jSONObject.put("insert_ad_control", this.um);
            jSONObject.put("refresh_ad_control", this.a);
            jSONObject.put("refresh_ad_imp_max_time", this.wm);
            jSONObject.put("force_refresh_ad_control", this.py);
            jSONObject.put("web_refresh_control", this.ou);
            jSONObject.put("carousel_tip_content", this.hu);
        } catch (JSONException unused) {
        }
    }

    private static j x(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.ei();
    }

    public static int n(pk pkVar) {
        j jVarX = x(pkVar);
        if (jVarX == null) {
            return 0;
        }
        return jVarX.um;
    }

    public static int qg(pk pkVar) {
        j jVarX = x(pkVar);
        if (jVarX == null) {
            return 0;
        }
        return jVarX.a;
    }

    public static int s(pk pkVar) {
        j jVarX = x(pkVar);
        if (jVarX == null) {
            return 0;
        }
        return jVarX.py;
    }

    public static int q(pk pkVar) {
        j jVarX = x(pkVar);
        if (jVarX == null) {
            return -1;
        }
        return jVarX.m;
    }

    public static int l(pk pkVar) {
        j jVarX = x(pkVar);
        if (jVarX == null) {
            return 0;
        }
        return jVarX.wm;
    }

    public static String w(pk pkVar) {
        j jVarX = x(pkVar);
        return jVarX == null ? "秒后将继续播放下一个" : jVarX.hu;
    }

    public static boolean n(boolean z, pk pkVar, boolean z2) {
        return z ? s(pkVar, z2) : q(pkVar, z2);
    }

    private static boolean s(pk pkVar, boolean z) {
        return (!z || n == 1) && n(pkVar) == 1 && q(pkVar) > 0;
    }

    private static boolean q(pk pkVar, boolean z) {
        return (!z || qg == 1) && n(pkVar) == 1 && q(pkVar) > 0;
    }

    public static boolean n(pk pkVar, boolean z) {
        return (!z || sz == 1) && qg(pkVar) == 1 && q(pkVar) > 0;
    }

    public static boolean qg(pk pkVar, boolean z) {
        return (!z || cy == 1) && s(pkVar) == 1 && q(pkVar) > 0;
    }

    public static boolean qg(boolean z, pk pkVar, boolean z2) {
        return n(z, pkVar, z2) || n(pkVar, z2) || qg(pkVar, z2);
    }

    public static String cp() {
        return h;
    }

    public static int d() {
        return t;
    }

    public static int oa() {
        return ur;
    }

    public static int sz() {
        return bb;
    }
}
