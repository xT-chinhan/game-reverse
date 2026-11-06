package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.mar.sdk.IAction;
import com.qq.e.comm.pi.IBidding;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.an;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n0 {
    public static final Map a;
    public static final Map b;

    static {
        HashMap map = new HashMap();
        map.put(IAction.PurchaseKey.Price, "sp");
        map.put("adnCodeId", "dspz");
        map.put("cardIndex", "cdi");
        map.put("creativeType", "fe_ardt");
        map.put("industry", "fe_aiid");
        map.put("apkName", "pkg");
        map.put("appName", "app");
        map.put("source", "dsps");
        map.put(BundleKey.TITLE, "crt");
        map.put("uuid", an.aF);
        map.put("entryId", "fe_entry");
        a = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put(4, "71000240");
        map2.put(8, "71000247");
        map2.put(7, "71000248");
        map2.put(5, "71000253");
        map2.put(9, "71000292");
        map2.put(10, "71000293");
        b = Collections.unmodifiableMap(map2);
    }

    public static String a(String str, JSONObject jSONObject, int i) {
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject;
        try {
            jSONObject2 = new JSONObject(str);
        } catch (Exception e) {
            jSONObject2 = null;
        }
        String strOptString = jSONObject2 != null ? jSONObject2.optString(BreakpointSQLiteKey.URL) : null;
        if (TextUtils.isEmpty(strOptString)) {
            if (lj.b(h4.c)) {
                strOptString = "https://t7z.cupid.iqiyi.com/etx";
                h4.c = "https://t7z.cupid.iqiyi.com/etx";
            } else {
                strOptString = h4.c;
            }
        }
        if (!strOptString.contains("?")) {
            strOptString = strOptString.concat("?");
        }
        StringBuilder sb = new StringBuilder(strOptString);
        sb.append("a=").append(i).append("&ds=").append((String) b.get(Integer.valueOf(jSONObject.optInt("adnType")))).append("&b=").append(System.currentTimeMillis() / 1000).append("&dspt=2");
        if (jSONObject2 != null && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("trp")) != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString2 = jSONObjectOptJSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString2)) {
                    sb.append("&").append(next).append('=').append(strOptString2);
                }
            }
        }
        Iterator<String> itKeys2 = jSONObject.keys();
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            Map map = a;
            if (map.containsKey(next2)) {
                String strF = gj.f(jSONObject.optString(next2));
                if (!TextUtils.isEmpty(strF)) {
                    sb.append(Typography.amp).append((String) map.get(next2)).append('=').append(strF);
                }
            }
        }
        return sb.toString();
    }

    public static void a(int i, l7 l7Var, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (i == 0) {
                HashMap map = new HashMap();
                map.put(IAction.PurchaseKey.Price, jSONObject.optString(IAction.PurchaseKey.Price));
                map.put(IBidding.ADN_ID, jSONObject.optString("adnType"));
                l7Var.loss(map);
            }
            try {
                String strA = a(l7Var.getAdExtra().get("tunnel"), jSONObject, i);
                bg bgVar = new bg();
                if (strA != null) {
                    bgVar.b = strA;
                }
                cg cgVar = new cg(bgVar);
                c7 c7VarA = c7.a();
                c7VarA.getClass();
                zg.a.a(new a7(c7VarA, cgVar));
            } catch (Exception e) {
                r9.a("ssp_adn", "report", e);
            }
        } catch (Exception e2) {
            r9.a("ssp_adn", "report error", e2);
        }
    }
}
