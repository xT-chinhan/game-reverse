package com.byazt.dt;

import android.text.TextUtils;
import com.byazt.sd.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1167, 62})
public class fw {
    public static final Map<String, Integer> pr = new ConcurrentHashMap();
    public static volatile String hw = null;

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int iFl = a.hw().fl();
            return iFl > 0 && hn(str) >= iFl;
        } catch (Exception e) {
            return false;
        }
    }

    public static void hw(String str) {
        c(str);
    }

    private static int hn(String str) {
        String strPr = pr();
        if (strPr == null) {
            return 0;
        }
        x(strPr);
        Map<String, Integer> map = pr;
        Integer num = map.get(str);
        if (num != null) {
            return num.intValue();
        }
        int iPr = pr(str, strPr);
        map.put(str, Integer.valueOf(iPr));
        return iPr;
    }

    private static void x(String str) {
        if (!str.equals(hw)) {
            synchronized (fw.class) {
                if (!str.equals(hw)) {
                    pr.clear();
                    hw = str;
                }
            }
        }
    }

    private static int pr(String str, String str2) {
        try {
            String strHw = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "fsswiper_freq").hw(str, "");
            if (TextUtils.isEmpty(strHw)) {
                return 0;
            }
            return new JSONObject(strHw).optInt(str2, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    private static void c(String str) {
        String strPr;
        if (TextUtils.isEmpty(str) || (strPr = pr()) == null) {
            return;
        }
        x(strPr);
        Map<String, Integer> map = pr;
        Integer numValueOf = map.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(pr(str, strPr));
        }
        int iIntValue = numValueOf.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "fsswiper_freq");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(strPr, iIntValue);
            hnVarPr.pr(str, jSONObject.toString());
        } catch (Exception e) {
        }
    }

    private static String pr() {
        try {
            return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            return null;
        }
    }
}
