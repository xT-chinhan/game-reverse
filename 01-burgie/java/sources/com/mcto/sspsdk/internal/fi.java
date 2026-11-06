package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mcto.sspsdk.QyAdSlot;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class fi implements f7 {
    public static final int[] e = {1380};
    public static final int[] f = {5000, 10000};
    public f7 a = null;
    public c0 b = null;
    public volatile boolean c = false;
    public boolean d = false;

    public final void a(QyAdSlot qyAdSlot, int i, f7 f7Var) {
        this.d = true;
        long j = v4.a(jd.a).f;
        String strConcat = "asm=".concat((j <= 0 || System.currentTimeMillis() - j >= 60000) ? "1" : "0");
        if (!qyAdSlot.isSupportPreRequest()) {
            HashMap map = c0.k;
            b0 b0Var = new b0();
            b0Var.b = f7Var;
            b0Var.a = qyAdSlot;
            b0Var.c = gj.a(qyAdSlot.h());
            b0Var.d = 3;
            b0Var.e = "rm=1&" + strConcat;
            b0Var.f = i;
            b0Var.g = e;
            new c0(b0Var).b();
            return;
        }
        String string = nh.a(jd.a).a.getSharedPreferences("iad_spa", 0).getString("csabr", "");
        if (!lj.b(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                long jCurrentTimeMillis = System.currentTimeMillis();
                AtomicInteger atomicInteger = gj.a;
                lj.b("yyyy-MM-dd");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                string = jSONObject.optString(simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis)));
            } catch (JSONException e2) {
                r9.a("ssp_splash_provider", "requestAd: ", e2);
            }
        }
        if (lj.b(string)) {
            string = "rm=1";
        }
        this.a = f7Var;
        HashMap map2 = c0.k;
        b0 b0Var2 = new b0();
        b0Var2.b = this;
        b0Var2.a = qyAdSlot;
        b0Var2.c = gj.a(qyAdSlot.h());
        b0Var2.d = 3;
        b0Var2.e = string + "&" + strConcat;
        b0Var2.f = i;
        b0Var2.g = e;
        c0 c0Var = new c0(b0Var2);
        this.b = c0Var;
        c0Var.b();
    }

    public static void a(QyAdSlot qyAdSlot, int i) {
        String strA = gj.a(qyAdSlot.h());
        boolean z = rd.a;
        String strA2 = c0.a(3, qyAdSlot, strA, null, "rm=0", z, i);
        bg bgVar = new bg();
        bgVar.c = TapHttp.METHOD_GET;
        bgVar.g = f;
        if (strA2 != null) {
            bgVar.b = strA2;
        }
        bgVar.d = strA;
        bgVar.a = z;
        bgVar.e = new ei();
        cg cgVar = new cg(bgVar);
        c7 c7VarA = c7.a();
        c7VarA.getClass();
        ih.a.a(new b7(c7VarA, cgVar));
    }

    public static r3 a(String str) {
        String str2;
        int i;
        int i2;
        JSONArray jSONArray;
        long j;
        String strSubstring;
        try {
            JSONObject jSONObject = new JSONObject(str);
            r3 r3Var = new r3();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adSlots");
            String str3 = "";
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray("ads") : null;
                    if (jSONArrayOptJSONArray2 == null) {
                        str2 = str3;
                        i = length;
                    } else if (jSONArrayOptJSONArray2.length() == 0) {
                        str2 = str3;
                        i = length;
                    } else {
                        long jOptLong = jSONObjectOptJSONObject.optLong("orderItemStartTime");
                        str2 = str3;
                        long jOptLong2 = jSONObjectOptJSONObject.optLong("orderItemEndTime");
                        int length2 = jSONArrayOptJSONArray2.length();
                        StringBuilder sb = new StringBuilder();
                        int i4 = 0;
                        while (i4 < length2) {
                            int i5 = length;
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i4);
                            if (jSONObjectOptJSONObject2 == null) {
                                j = jOptLong2;
                                i2 = length2;
                                jSONArray = jSONArrayOptJSONArray2;
                            } else {
                                i2 = length2;
                                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("creativeObject");
                                if (jSONObjectOptJSONObject3 == null) {
                                    j = jOptLong2;
                                    jSONArray = jSONArrayOptJSONArray2;
                                } else {
                                    jSONArray = jSONArrayOptJSONArray2;
                                    ui uiVar = new ui();
                                    uiVar.c = jOptLong;
                                    uiVar.d = jOptLong2;
                                    j = jOptLong2;
                                    Pair pairA = a(jSONObjectOptJSONObject2.optString("templateType"), jSONObjectOptJSONObject3);
                                    if (pairA != null) {
                                        uiVar.b = (String) pairA.first;
                                        String strSubstring2 = (String) pairA.second;
                                        uiVar.a = strSubstring2;
                                        if (lj.b(strSubstring2)) {
                                            strSubstring = str2;
                                        } else {
                                            int iIndexOf = strSubstring2.indexOf(63);
                                            if (iIndexOf > 0) {
                                                strSubstring2 = strSubstring2.substring(0, iIndexOf);
                                            }
                                            int iLastIndexOf = strSubstring2.lastIndexOf(47);
                                            if (iLastIndexOf > 0) {
                                                strSubstring = strSubstring2.substring(iLastIndexOf + 1);
                                            } else {
                                                strSubstring = str2;
                                            }
                                        }
                                        if (strSubstring.length() > 4) {
                                            strSubstring = strSubstring.substring(0, 4);
                                        }
                                        r3Var.a.add(uiVar);
                                        sb.append("ori:").append(jSONObjectOptJSONObject2.optString("orderItemId")).append(",cra:").append(jSONObjectOptJSONObject2.optString("creativeId")).append(",crn:").append(strSubstring).append(";");
                                    }
                                }
                            }
                            i4++;
                            length = i5;
                            length2 = i2;
                            jSONArrayOptJSONArray2 = jSONArray;
                            jOptLong2 = j;
                        }
                        i = length;
                        AtomicInteger atomicInteger = gj.a;
                        lj.b("yyyy-MM-dd");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                        jSONObject2.put(simpleDateFormat.format(Long.valueOf(jOptLong * 1000)), "rm=1&boi=" + gj.f(sb.toString()));
                    }
                    i3++;
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    str3 = str2;
                    length = i;
                }
                String string = jSONObject2.toString();
                HashMap map = new HashMap(2);
                map.put("csar", str);
                map.put("csabr", string);
                nh.a(jd.a).b(map);
                return r3Var;
            }
            HashMap map2 = new HashMap(2);
            map2.put("csar", str);
            map2.put("csabr", "");
            nh.a(jd.a).b(map2);
            return null;
        } catch (Exception e2) {
            r9.a("ssp_splash_provider", "getPreLoadCreative: ", e2);
            return null;
        }
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        f7 f7Var = this.a;
        if (f7Var != null) {
            f7Var.a(vhVar);
        }
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        if (this.d && !this.c && 1 == i) {
            String string = nh.a(jd.a).a.getSharedPreferences("iad_spa", 0).getString("csar", "");
            if (lj.b(string)) {
                f7 f7Var = this.a;
                if (f7Var != null) {
                    f7Var.a(vhVar, i, "local data is empty");
                    return;
                }
                return;
            }
            this.c = true;
            this.b.a(string, new h7(1380, 3), false);
            return;
        }
        this.a.a(vhVar, i, str);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    public static Pair a(String str, JSONObject jSONObject) {
        String strA;
        if (jSONObject == null) {
            return null;
        }
        boolean z = jSONObject.optInt("videoSource") == 1;
        String strOptString = jSONObject.optString("renderType");
        if (str != null && str.contains(MediationConstant.RIT_TYPE_INTERSTITIAL)) {
            if (TextUtils.equals("video", strOptString)) {
                strA = gj.a(jSONObject.optString("dynamicUrl"), z);
            } else if (TextUtils.equals(ImageViewManager.NAME, strOptString)) {
                strA = jSONObject.optString("portraitUrl");
            } else {
                strA = "";
            }
        } else if ("mobile_flow_new".equals(str)) {
            strA = jSONObject.optString(BreakpointSQLiteKey.URL);
            strOptString = ImageViewManager.NAME;
        } else if ("roll".equals(str)) {
            strA = gj.a(jSONObject.optString("m400Url"), z);
            strOptString = "video";
        } else {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new Pair(strOptString, strA);
    }
}
