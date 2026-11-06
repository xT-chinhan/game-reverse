package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 {
    static String hw;
    static String pr;

    public static synchronized String hw(Context context) {
        String str = pr;
        if (str != null) {
            return k1.pr(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblm.pr("676574537562736372696265724964")), new Class[0]);
            declaredMethod.setAccessible(true);
            hw = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return k1.pr(hw);
        } catch (Throwable th) {
        }
    }

    public static synchronized String pr(Context context) {
        String str = pr;
        if (str != null) {
            return k1.pr(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblm.pr("6765744465766963654964")), new Class[0]);
            declaredMethod.setAccessible(true);
            pr = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return k1.pr(pr);
        } catch (Throwable th) {
        }
    }
}
