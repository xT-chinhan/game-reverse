package com.byazt.ng;

import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.msdk.report.plugin.AdnMaterialWindowCopyUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 548, 19})
public class n {
    public static String n = "";
    public static volatile List<C0266n> qg = new ArrayList();

    private static double n(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        return d;
    }

    public static void n() {
        n((JSONArray) null);
    }

    public static void n(JSONArray jSONArray) {
        n = jSONArray != null ? jSONArray.toString() : "";
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("a_n");
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(new C0266n(strOptString, n(jSONObjectOptJSONObject.optDouble("s_r", 0.0d)), Math.max(0L, jSONObjectOptJSONObject.optLong(f.aD, 0L)), n(jSONObjectOptJSONObject.optDouble("i_r", 0.0d)), n(jSONObjectOptJSONObject.optDouble("d_r", 0.0d)), jSONObjectOptJSONObject.optInt("d_p", i) == 1 && Build.VERSION.SDK_INT >= 26 && s()));
                    }
                }
                i2++;
                i = 0;
            }
        }
        qg = arrayList;
    }

    public static String qg() {
        return n;
    }

    public static C0266n n(String str, boolean z) {
        List<C0266n> list = qg;
        if (!z && list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (C0266n c0266n : list) {
                if (c0266n != null && !TextUtils.isEmpty(c0266n.n) && (TextUtils.equals(c0266n.n, str) || c0266n.n.equalsIgnoreCase(str))) {
                    return c0266n;
                }
            }
        }
        return null;
    }

    private static boolean s() {
        try {
            AdnMaterialWindowCopyUtils.class.getClassLoader();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ng.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 548, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0266n {
        public final double l;
        public final String n;
        public final double q;
        public final double qg;
        public final long s;
        public final boolean w;

        public C0266n(String str, double d, long j, double d2, double d3, boolean z) {
            this.n = str;
            this.qg = d;
            this.s = j;
            this.q = d2;
            this.l = d3;
            this.w = z;
        }
    }
}
