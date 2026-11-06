package com.byazt.mp;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.byazt.ca.ho;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.vkw.nt;
import com.byazt.wt.rc;
import com.byazt.wt.w;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 168, 5})
public class uc {
    public static volatile uc pr;

    public static uc pr() {
        if (pr == null) {
            synchronized (uc.class) {
                if (pr == null) {
                    pr = new uc();
                }
            }
        }
        return pr;
    }

    public com.byazt.wn.hw pr(String str) {
        Object obj;
        com.byazt.wn.hw hwVar = new com.byazt.wn.hw();
        HashMap map = new HashMap();
        try {
            hwVar.pr(str.length());
            Pair<Integer, ?> pairHn = pr().hn(str);
            int iIntValue = 3;
            if (pairHn == null) {
                obj = null;
            } else {
                obj = pairHn.second;
                if (pairHn.first != null) {
                    iIntValue = ((Integer) pairHn.first).intValue();
                }
            }
            if (iIntValue == 4) {
                map.put("x-ad-sdk-version", iu.c);
                map.put("x-plugin-version", "7.7.1.4");
                map.put("x-pglcypher", String.valueOf(iIntValue));
                map.put("Content-Type", "application/octet-stream");
                hwVar.pr((byte[]) obj);
                hwVar.pr(map);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", iu.c);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                hwVar.hw(jSONObject);
                hwVar.pr(map);
            }
        } catch (Throwable th) {
        }
        return hwVar;
    }

    public com.byazt.wn.hw hw(String str) {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        com.byazt.wn.hw hwVar = new com.byazt.wn.hw();
        HashMap map = new HashMap();
        try {
            hwVar.pr(str.length());
            Pair<Integer, JSONObject> pairPr = pr().pr(str, false);
            if (pairPr == null) {
                iIntValue = 3;
            } else {
                JSONObject jSONObject2 = (JSONObject) pairPr.second;
                try {
                    iIntValue = pairPr.first != null ? ((Integer) pairPr.first).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable th) {
                    jSONObject = jSONObject2;
                }
            }
            jSONObject.put("ad_sdk_version", iu.c);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            if (iIntValue != 3) {
                map.put("x-ad-sdk-version", iu.c);
                map.put("x-plugin-version", "7.7.1.4");
                map.put("x-pglcypher", String.valueOf(iIntValue));
            }
        } catch (Throwable th2) {
        }
        hwVar.pr(map);
        hwVar.hw(jSONObject);
        return hwVar;
    }

    public Pair<Integer, JSONObject> pr(String str, boolean z) {
        try {
            if (a.hw().tv()) {
                return fw(str);
            }
        } catch (Throwable th) {
            ho.pr(th.getMessage());
        }
        return x(str);
    }

    public Pair<Integer, ?> hn(String str) {
        try {
            if (!TextUtils.isEmpty(str) && a.hw().tv()) {
                return pr(str, "get_ad");
            }
        } catch (Throwable th) {
            ho.pr(th.getMessage());
        }
        return x(str);
    }

    private Pair<Integer, JSONObject> uc(String str) {
        if (a.hw().rf() == 1) {
            return new Pair<>(3, new JSONObject());
        }
        return x(str);
    }

    public Pair<Integer, JSONObject> x(String str) {
        return new Pair<>(3, rc.pr(str));
    }

    private Pair<Integer, JSONObject> fw(String str) {
        nt ntVarHn = rc.hn();
        if (TextUtils.isEmpty(str)) {
            return uc(str);
        }
        JSONObject jSONObjectC = null;
        if (ntVarHn != null) {
            if (ntVarHn.hw()) {
                jSONObjectC = c(str);
            }
            if (jSONObjectC == null || TextUtils.isEmpty(jSONObjectC.optString("message"))) {
                com.byazt.xk.hw.pr().pr(3, -1L, (String) null, ntVarHn.hn());
                return uc(str);
            }
        }
        return new Pair<>(4, jSONObjectC);
    }

    public JSONObject c(String str) {
        nt ntVarHn = rc.hn();
        if (TextUtils.isEmpty(str) || ntVarHn == null || !ntVarHn.hw()) {
            return null;
        }
        try {
            byte[] bArrPr = ntVarHn.pr(str.getBytes(StandardCharsets.UTF_8));
            if (bArrPr == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrPr, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", strEncodeToString);
            jSONObject.put("cypher", 4);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public Pair<Integer, ?> pr(String str, String str2) {
        nt ntVarHn = rc.hn();
        if (TextUtils.isEmpty(str)) {
            return uc(str);
        }
        byte[] bArrPr = null;
        if (ntVarHn != null) {
            if (ntVarHn.hw()) {
                bArrPr = ntVarHn.pr(w.pr(str.getBytes(StandardCharsets.UTF_8)));
            }
            if (bArrPr == null || bArrPr.length == 0) {
                com.byazt.xk.hw.pr().pr(3, -1L, str2, ntVarHn.hn());
                if ("settings".equals(str2)) {
                    return x(str);
                }
                return uc(str);
            }
        }
        return new Pair<>(4, bArrPr);
    }

    public static Pair<Boolean, JSONObject> pr(m mVar, String str, boolean z) {
        if (com.byazt.am.pr.pr(mVar.hn())) {
            return new Pair<>(Boolean.FALSE, pr(mVar.x(), str));
        }
        String strZo = mVar.zo();
        if (strZo != null && !strZo.startsWith("{") && !strZo.endsWith("}") && !strZo.contains("message") && !strZo.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, pr(mVar.x(), str));
        }
        JSONObject jSONObject = null;
        if (strZo != null) {
            try {
                jSONObject = new JSONObject(strZo);
            } catch (JSONException e) {
            }
        }
        return new Pair<>(Boolean.TRUE, pr(jSONObject, true, z));
    }

    public static JSONObject pr(JSONObject jSONObject, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strPr = pr(jSONObject, z);
            String strOptString = jSONObject.optString("auction_price", "");
            if (!TextUtils.isEmpty(strPr)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strPr);
                    if (z2) {
                        try {
                            jSONObject2.put("auction_price", strOptString);
                        } catch (Throwable th) {
                            return jSONObject2;
                        }
                    }
                    return jSONObject2;
                } catch (Throwable th2) {
                    return jSONObject;
                }
            }
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public static String pr(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            nt ntVarHn = rc.hn();
            if (iOptInt == 3) {
                return ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(strOptString);
            }
            if (iOptInt == 4 && ntVarHn != null) {
                String strHw = ntVarHn.hw(strOptString);
                if (TextUtils.isEmpty(strHw) && z) {
                    com.byazt.xk.hw.pr().pr(1, -1L, (String) null, ntVarHn.hn());
                    return strHw;
                }
                return strHw;
            }
            return strOptString;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject pr(byte[] bArr, String str) {
        try {
            String strHw = hw(bArr, str);
            if (!TextUtils.isEmpty(strHw)) {
                return new JSONObject(strHw);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String hw(byte[] bArr, String str) {
        nt ntVarHn;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (ntVarHn = rc.hn()) == null) {
                    return null;
                }
                byte[] bArrHw = ntVarHn.hw(bArr);
                String strHw = w.hw(bArrHw);
                if (TextUtils.isEmpty(strHw)) {
                    com.byazt.xk.hw.pr().pr((bArrHw == null || bArrHw.length == 0) ? 1 : 2, -1L, str, ntVarHn.hn());
                    return null;
                }
                return strHw;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
