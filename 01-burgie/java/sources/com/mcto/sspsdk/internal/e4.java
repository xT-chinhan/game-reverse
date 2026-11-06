package com.mcto.sspsdk.internal;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.eyv.AdBaseConstants;
import com.mcto.sspsdk.QyCustomMade;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e4 {
    public static volatile e4 b;
    public u1 a;

    public e4() {
        String strReplace;
        d4 d4Var = new d4(this);
        bg bgVar = new bg();
        try {
            if (kl.a == null) {
                String strA = nh.a(jd.a).a("mu");
                kl.a = strA;
                if (TextUtils.isEmpty(strA)) {
                    kl.a = "https://resource.cupid.iqiyi.com/app?";
                }
            }
            StringBuilder sb = new StringBuilder(rd.b ? kl.a : kl.a.replace("https://", "http://"));
            StringBuilder sbAppend = sb.append("m=").append(gj.f(Build.MODEL)).append("&cpmf=").append(gj.f(Build.MANUFACTURER.toLowerCase())).append("&os=").append(gj.f(Build.VERSION.RELEASE)).append("&brd=").append(gj.f(Build.BRAND.toLowerCase())).append("&a=").append(y4.r.i()).append("&oaid=");
            QyCustomMade qyCustomMade = rd.d;
            sbAppend.append(qyCustomMade != null ? qyCustomMade.getOaid() : null).append("&d=").append(rd.f).append("&i=gphone&r=2.3.102");
            if (!rd.a()) {
                sb.append("&ql=1");
            }
            strReplace = sb.toString();
        } catch (Exception e) {
            e.getMessage();
            if (kl.a == null) {
                String strA2 = nh.a(jd.a).a("mu");
                kl.a = strA2;
                if (TextUtils.isEmpty(strA2)) {
                    kl.a = "https://resource.cupid.iqiyi.com/app?";
                }
            }
            strReplace = rd.b ? kl.a : kl.a.replace("https://", "http://");
        }
        if (strReplace != null) {
            bgVar.b = strReplace;
        }
        bgVar.c = TapHttp.METHOD_GET;
        bgVar.e = d4Var;
        bgVar.g = new int[]{5000, 10000, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS};
        cg cgVar = new cg(bgVar);
        c7 c7VarA = c7.a();
        c7VarA.getClass();
        zg.a.a(new a7(c7VarA, cgVar));
    }

    public static void a(JSONArray jSONArray) {
        ra taVar;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        va.a.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("pids");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i2));
                    }
                }
                wa waVar = new wa();
                waVar.a.addAll(arrayList);
                waVar.e = jSONObjectOptJSONObject.optString("pkName");
                waVar.b = jSONObjectOptJSONObject.optString("scheme");
                waVar.c = jSONObjectOptJSONObject.optString("regId");
                waVar.d = jSONObjectOptJSONObject.optString("regSubId");
                String str = waVar.e;
                str.getClass();
                switch (str) {
                    case "com.qiyi.video":
                        taVar = new ta(waVar);
                        break;
                    case "tv.pps.mobile":
                        taVar = new ua(waVar);
                        break;
                    case "com.qiyi.video.lite":
                        taVar = new sa(waVar);
                        break;
                    default:
                        taVar = new ra(waVar);
                        break;
                }
                va.a.add(0, taVar);
            }
        }
        nh.a(jd.a).a("iad_dev", "onlinemoviead_sch", jSONArray.toString());
    }
}
