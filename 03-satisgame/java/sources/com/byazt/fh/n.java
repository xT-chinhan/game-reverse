package com.byazt.fh;

import android.text.TextUtils;
import com.byazt.ju.q;
import com.byazt.ya.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1104, 19})
public class n {
    public static final ArrayList<C0174n> n = new ArrayList<>();
    public static final ArrayList<String> q;
    public static final String[] qg;
    public static final ArrayList<String> s;

    /* JADX INFO: renamed from: com.byazt.fh.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1104, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0174n {
        public String n;
        public int qg;
        public String s;

        public C0174n(String str, int i, String str2) {
            this.n = str;
            this.qg = i;
            this.s = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "Stub_Standard", "com.byazt.mlu", "com.qq", "com.kwad", "baidu", "mbridge", MediationConstant.ADN_SIGMOB, MediationConstant.ADN_UNITY, MediationConstant.ADN_KLEVIN};
        qg = strArr;
        s = new ArrayList<>(Arrays.asList(strArr));
        q = new ArrayList<>();
    }

    public static boolean n(String str, int i, int i2) {
        ArrayList<C0174n> arrayList = n;
        if (arrayList.size() <= 0) {
            return TextUtils.equals("baidu", str);
        }
        for (C0174n c0174n : arrayList) {
            if (c0174n != null && TextUtils.equals(c0174n.n, str) && i2 == c0174n.qg) {
                String str2 = c0174n.s;
                q qVarN = qg.n().n(str);
                String strQg = qVarN != null ? qVarN.qg() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strQg)) {
                    if (str2.startsWith("<=")) {
                        return n(strQg, str2);
                    }
                    if (str2.startsWith(">=")) {
                        return qg(strQg, str2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean n(String str, String str2) {
        return s(str, str2) <= 0;
    }

    private static boolean qg(String str, String str2) {
        return s(str, str2) >= 0;
    }

    private static int s(String str, String str2) {
        String strSubstring = str2.substring(2);
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        return str.compareTo(strSubstring);
    }

    public static void n(String str) {
        ArrayList<String> arrayList;
        List listAsList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            s.clear();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("act_str");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        s.add(strOptString);
                    }
                }
            }
            q.clear();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("not_act_str");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        q.add(strOptString2);
                    }
                }
            }
            n.clear();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("not_support");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject != null) {
                        n.add(new C0174n(jSONObjectOptJSONObject.optString("adn"), jSONObjectOptJSONObject.optInt("subtype"), jSONObjectOptJSONObject.optString("versions")));
                    }
                }
            }
            arrayList = s;
            listAsList = Arrays.asList(qg);
        } catch (JSONException unused) {
            arrayList = s;
            listAsList = Arrays.asList(qg);
        } catch (Throwable th) {
            s.addAll(Arrays.asList(qg));
            throw th;
        }
        arrayList.addAll(listAsList);
    }

    public static boolean qg(String str) {
        com.byazt.rb.qg.qg(MediationConstant.TAG, "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return s(str);
            }
        }
        return false;
    }

    private static boolean s(String str) {
        ArrayList<String> arrayList = q;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
