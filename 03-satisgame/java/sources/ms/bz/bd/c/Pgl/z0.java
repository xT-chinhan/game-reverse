package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 {
    static String n;
    static String qg;

    public static synchronized String n(Context context) {
        String str = n;
        if (str != null) {
            return k1.n(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblm.n("6765744465766963654964")), new Class[0]);
            declaredMethod.setAccessible(true);
            n = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return k1.n(n);
        } catch (Throwable unused) {
        }
    }

    public static synchronized String qg(Context context) {
        String str = n;
        if (str != null) {
            return k1.n(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblm.n("676574537562736372696265724964")), new Class[0]);
            declaredMethod.setAccessible(true);
            qg = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return k1.n(qg);
        } catch (Throwable unused) {
        }
    }
}
