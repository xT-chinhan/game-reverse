package com.byazt.tka;

import android.text.TextUtils;
import android.util.Base64;
import com.byakv.z.SoftDecTool;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 113})
public class d {
    public static volatile d n = null;
    public static volatile boolean qg = false;
    public static AtomicInteger s = new AtomicInteger(0);

    private d() {
    }

    public static d n() {
        if (n == null) {
            synchronized (d.class) {
                if (n == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.byazt.xhd.s.n("panglearmor");
                        qg = true;
                        s.set(1);
                    } catch (Throwable unused) {
                        qg = false;
                        s.set(2);
                    }
                    n = new d();
                    n(10001, System.currentTimeMillis() - jCurrentTimeMillis, s.get());
                }
            }
        }
        return n;
    }

    public static boolean qg() {
        return qg;
    }

    public static int s() {
        return s.get();
    }

    public byte[] n(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && qg) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] qg(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && qg) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String n(String str) {
        if (str == null || str.length() == 0 || !qg) {
            return null;
        }
        try {
            byte[] bArrN = n(str.getBytes());
            if (bArrN == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrN, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            return strEncodeToString;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String qg(String str) {
        if (str == null || str.length() == 0 || !qg) {
            return null;
        }
        try {
            byte[] bArrQg = qg(Base64.decode(str, 0));
            if (bArrQg != null) {
                return new String(bArrQg);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String s(String str) {
        return qg.n(str);
    }

    public static String q(String str) {
        return qg.qg(str);
    }

    public static void n(int i, long j, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (j >= 0) {
                jSONObject.put("cost_time", j);
            }
            if (i != -1) {
                jSONObject.put("event_res", i);
            }
            if (i2 != -1) {
                jSONObject.put("armor_load_status", i2);
            }
            n("encrypt_track", jSONObject);
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
    }

    public static void n(String str, final JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            ((com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null))).n(str, (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.tka.d.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    return jSONObject;
                }
            });
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
    }
}
