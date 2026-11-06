package com.byazt.fg;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.byazt.apo.c;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1035, 13})
public class hw implements c {
    @Override // com.byazt.apo.c
    public boolean pr(Context context, TelephonyManager telephonyManager) {
        return hw(context, telephonyManager);
    }

    private static boolean hw(Context context, TelephonyManager telephonyManager) {
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                int iPr = pr();
                if (iPr == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iPr));
                }
                return pr(serviceState);
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static int pr() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean pr(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                int iIntValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                if (iIntValue != 3 && iIntValue != 2) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
