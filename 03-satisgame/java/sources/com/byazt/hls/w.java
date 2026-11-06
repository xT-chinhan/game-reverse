package com.byazt.hls;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.vf.cp;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1598, 13})
public class w {
    public static volatile Random n;

    public static boolean n(com.byazt.vf.n nVar, String str, double d) {
        if (!TextUtils.isEmpty(str) && !com.byazt.asa.qg.n.contains(str)) {
            try {
                JSONObject jSONObjectCy = ((cp) com.byazt.qp.q.n("csj_settings", nVar)).cy();
                if (jSONObjectCy != null) {
                    d = jSONObjectCy.optDouble(str, d);
                }
                return n(d);
            } catch (Throwable th) {
                x.q("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }

    private static boolean n(double d) {
        if (d >= 1.0d) {
            return true;
        }
        return d > 0.0d && n().nextInt(1000000) < ((int) (d * 1000000.0d));
    }

    private static Random n() {
        if (n != null) {
            return n;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                n = SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                n = new SecureRandom();
            }
        } else {
            n = new SecureRandom();
        }
        return n;
    }
}
