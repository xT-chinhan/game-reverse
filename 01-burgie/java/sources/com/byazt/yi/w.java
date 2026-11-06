package com.byazt.yi;

import android.text.TextUtils;
import android.util.Base64;
import com.byakv.z.SoftDecTool;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 109})
public class w {
    public static volatile w pr;
    public static volatile boolean hw = false;
    public static AtomicInteger hn = new AtomicInteger(0);

    private w() {
    }

    public static w pr() {
        if (pr == null) {
            synchronized (w.class) {
                if (pr == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.byazt.zp.fw.pr("panglearmor");
                        hw = true;
                        hn.set(1);
                    } catch (Throwable th) {
                        hw = false;
                        hn.set(2);
                    }
                    pr = new w();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    vk vkVarUc = zo.uc();
                    if (vkVarUc != null) {
                        vkVarUc.pr(jCurrentTimeMillis2 - jCurrentTimeMillis, hw);
                    }
                }
            }
        }
        return pr;
    }

    public static boolean hw() {
        return hw;
    }

    public static int hn() {
        return hn.get();
    }

    public byte[] pr(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || !hw) {
            return null;
        }
        try {
            return SoftDecTool.bc(1010, bArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public byte[] hw(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || !hw) {
            return null;
        }
        try {
            return SoftDecTool.bc(1011, bArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public String pr(String str) {
        if (str == null || str.length() == 0 || !hw) {
            return null;
        }
        try {
            byte[] bArrPr = pr(str.getBytes());
            if (bArrPr == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrPr, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            return strEncodeToString;
        } catch (Throwable th) {
            return null;
        }
    }

    public String hw(String str) {
        if (str == null || str.length() == 0 || !hw) {
            return null;
        }
        try {
            byte[] bArrHw = hw(Base64.decode(str, 0));
            if (bArrHw == null) {
                return null;
            }
            return new String(bArrHw);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String hn(String str) {
        return hw.pr(str);
    }

    public static String x(String str) {
        return hw.hw(str);
    }
}
