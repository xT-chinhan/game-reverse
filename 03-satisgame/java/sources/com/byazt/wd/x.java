package com.byazt.wd;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, 21})
public class x {
    public static final Map<String, Integer> n = new ConcurrentHashMap();
    public static volatile String qg = null;

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int iKz = com.byazt.nf.rv.qg().kz();
            return iKz > 0 && s(str) >= iKz;
        } catch (Exception unused) {
        }
    }

    public static void qg(String str) {
        l(str);
    }

    private static int s(String str) {
        String strN = n();
        if (strN == null) {
            return 0;
        }
        q(strN);
        Map<String, Integer> map = n;
        Integer num = map.get(str);
        if (num != null) {
            return num.intValue();
        }
        int iN = n(str, strN);
        map.put(str, Integer.valueOf(iN));
        return iN;
    }

    private static void q(String str) {
        if (str.equals(qg)) {
            return;
        }
        synchronized (x.class) {
            if (!str.equals(qg)) {
                n.clear();
                qg = str;
            }
        }
    }

    private static int n(String str, String str2) {
        try {
            String strQg = com.byazt.lk.l.n(com.byazt.vgx.s.q(), "fsswiper_freq").qg(str, "");
            if (TextUtils.isEmpty(strQg)) {
                return 0;
            }
            return new JSONObject(strQg).optInt(str2, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static void l(String str) {
        String strN;
        if (TextUtils.isEmpty(str) || (strN = n()) == null) {
            return;
        }
        q(strN);
        Map<String, Integer> map = n;
        Integer numValueOf = map.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(n(str, strN));
        }
        int iIntValue = numValueOf.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(com.byazt.vgx.s.q(), "fsswiper_freq");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(strN, iIntValue);
            sVarN.n(str, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    private static String n() {
        try {
            return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
