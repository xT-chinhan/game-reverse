package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class h1 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static String f4834ms;
    static String xr;

    public static synchronized String ms(Context context) {
        String str = f4834ms;
        if (str != null) {
            return q1.ms(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.ms("6765744465766963654964")), new Class[0]);
            declaredMethod.setAccessible(true);
            f4834ms = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return q1.ms(f4834ms);
        } catch (Throwable unused) {
        }
    }

    public static synchronized String xr(Context context) {
        String str = f4834ms;
        if (str != null) {
            return q1.ms(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.ms("676574537562736372696265724964")), new Class[0]);
            declaredMethod.setAccessible(true);
            xr = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return q1.ms(xr);
        } catch (Throwable unused) {
        }
    }
}
