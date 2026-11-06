package com.byazt.nn;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.vkw.k;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 938, 5})
public class uc {
    public static volatile Random pr;

    public static boolean pr(com.byazt.vkw.pr prVar, String str, double d) {
        if (TextUtils.isEmpty(str) || com.byazt.yt.hw.pr.contains(str)) {
            return true;
        }
        try {
            JSONObject jSONObjectNt = ((k) com.byazt.zs.uc.pr("csj_settings", prVar)).nt();
            if (jSONObjectNt != null) {
                d = jSONObjectNt.optDouble(str, d);
            }
            return pr(d);
        } catch (Throwable th) {
            fw.x("sample throwable:" + th.getMessage());
            return true;
        }
    }

    private static boolean pr(double d) {
        if (d >= 1.0d) {
            return true;
        }
        return d > 0.0d && pr().nextInt(1000000) < ((int) (d * 1000000.0d));
    }

    private static Random pr() {
        if (pr != null) {
            return pr;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                pr = SecureRandom.getInstanceStrong();
            } catch (Throwable th) {
                pr = new SecureRandom();
            }
        } else {
            pr = new SecureRandom();
        }
        return pr;
    }
}
