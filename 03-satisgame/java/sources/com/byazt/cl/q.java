package com.byazt.cl;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.anythink.core.common.l.b;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qk.oa;
import com.byazt.qyu.PluginConstants;
import com.byazt.shr.cd;
import com.byazt.tk.k;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1321, 5})
public class q {
    public static volatile q n;

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public cd n(String str) {
        Object obj;
        cd cdVar = new cd();
        HashMap map = new HashMap();
        try {
            cdVar.n(str.length());
            Pair<Integer, ?> pairS = n().s(str);
            int iIntValue = 3;
            if (pairS != null) {
                obj = pairS.second;
                if (pairS.first != null) {
                    iIntValue = ((Integer) pairS.first).intValue();
                }
            } else {
                obj = null;
            }
            if (iIntValue == 4) {
                map.put("x-ad-sdk-version", tj.w);
                map.put("x-plugin-version", "7.8.1.4");
                map.put("x-pglcypher", String.valueOf(iIntValue));
                map.put(b.g, "application/octet-stream");
                cdVar.n((byte[]) obj);
                cdVar.n(map);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", tj.w);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                cdVar.qg(jSONObject);
                cdVar.n(map);
            }
        } catch (Throwable unused) {
        }
        return cdVar;
    }

    public cd qg(String str) {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        cd cdVar = new cd();
        HashMap map = new HashMap();
        try {
            cdVar.n(str.length());
            Pair<Integer, JSONObject> pairN = n().n(str, false);
            if (pairN != null) {
                JSONObject jSONObject2 = (JSONObject) pairN.second;
                try {
                    iIntValue = pairN.first != null ? ((Integer) pairN.first).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                iIntValue = 3;
            }
            jSONObject.put("ad_sdk_version", tj.w);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            if (iIntValue != 3) {
                map.put("x-ad-sdk-version", tj.w);
                map.put("x-plugin-version", "7.8.1.4");
                map.put("x-pglcypher", String.valueOf(iIntValue));
            }
        } catch (Throwable unused2) {
        }
        cdVar.n(map);
        cdVar.qg(jSONObject);
        return cdVar;
    }

    public Pair<Integer, JSONObject> n(String str, boolean z) {
        try {
            if (rv.qg().dz()) {
                return x(str);
            }
        } catch (Throwable th) {
            k.n(th.getMessage());
        }
        return q(str);
    }

    public Pair<Integer, ?> s(String str) {
        try {
            if (!TextUtils.isEmpty(str) && rv.qg().dz()) {
                return n(str, "get_ad");
            }
        } catch (Throwable th) {
            k.n(th.getMessage());
        }
        return q(str);
    }

    private Pair<Integer, JSONObject> w(String str) {
        if (rv.qg().ax() == 1) {
            return new Pair<>(3, new JSONObject());
        }
        return q(str);
    }

    public Pair<Integer, JSONObject> q(String str) {
        return new Pair<>(3, s.n(str));
    }

    private Pair<Integer, JSONObject> x(String str) {
        com.byazt.vf.k kVarS = s.s();
        if (TextUtils.isEmpty(str)) {
            return w(str);
        }
        JSONObject jSONObjectL = null;
        if (kVarS != null) {
            jSONObjectL = kVarS.qg() ? l(str) : null;
            if (jSONObjectL == null || TextUtils.isEmpty(jSONObjectL.optString("message"))) {
                com.byazt.eji.s.n().n(3, -1L, (String) null, kVarS.s());
                return w(str);
            }
        }
        return new Pair<>(4, jSONObjectL);
    }

    public JSONObject l(String str) {
        com.byazt.vf.k kVarS = s.s();
        if (TextUtils.isEmpty(str) || kVarS == null || !kVarS.qg()) {
            return null;
        }
        try {
            byte[] bArrN = kVarS.n(str.getBytes(StandardCharsets.UTF_8));
            if (bArrN == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrN, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", strEncodeToString);
            jSONObject.put("cypher", 4);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Pair<Integer, ?> n(String str, String str2) {
        com.byazt.vf.k kVarS = s.s();
        if (TextUtils.isEmpty(str)) {
            return w(str);
        }
        byte[] bArrN = null;
        if (kVarS != null) {
            bArrN = kVarS.qg() ? kVarS.n(com.byazt.xu.q.n(str.getBytes(StandardCharsets.UTF_8))) : null;
            if (bArrN == null || bArrN.length == 0) {
                com.byazt.eji.s.n().n(3, -1L, str2, kVarS.s());
                if ("settings".equals(str2)) {
                    return q(str);
                }
                return w(str);
            }
        }
        return new Pair<>(4, bArrN);
    }

    public static Pair<Boolean, JSONObject> n(oa oaVar, String str, boolean z) {
        if (com.byazt.nx.n.n(oaVar.s())) {
            return new Pair<>(Boolean.FALSE, n(oaVar.q(), str));
        }
        String strFs = oaVar.fs();
        if (strFs != null && !strFs.startsWith("{") && !strFs.endsWith("}") && !strFs.contains("message") && !strFs.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, n(oaVar.q(), str));
        }
        JSONObject jSONObject = null;
        if (strFs != null) {
            try {
                jSONObject = new JSONObject(strFs);
            } catch (JSONException unused) {
            }
        }
        return new Pair<>(Boolean.TRUE, n(jSONObject, true, z));
    }

    public static JSONObject n(JSONObject jSONObject, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strN = n(jSONObject, z);
            String strOptString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(strN)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strN);
            if (z2) {
                try {
                    jSONObject2.put("auction_price", strOptString);
                } catch (Throwable unused) {
                }
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String n(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            com.byazt.vf.k kVarS = s.s();
            if (iOptInt == 3) {
                return ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).q(strOptString);
            }
            if (iOptInt != 4 || kVarS == null) {
                return strOptString;
            }
            String strQg = kVarS.qg(strOptString);
            if (!TextUtils.isEmpty(strQg) || !z) {
                return strQg;
            }
            com.byazt.eji.s.n().n(1, -1L, (String) null, kVarS.s());
            return strQg;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject n(byte[] bArr, String str) {
        try {
            String strQg = qg(bArr, str);
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            return new JSONObject(strQg);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String qg(byte[] bArr, String str) {
        com.byazt.vf.k kVarS;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (kVarS = s.s()) == null) {
                    return null;
                }
                byte[] bArrQg = kVarS.qg(bArr);
                String strQg = com.byazt.xu.q.qg(bArrQg);
                if (!TextUtils.isEmpty(strQg)) {
                    return strQg;
                }
                com.byazt.eji.s.n().n((bArrQg == null || bArrQg.length == 0) ? 1 : 2, -1L, str, kVarS.s());
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
