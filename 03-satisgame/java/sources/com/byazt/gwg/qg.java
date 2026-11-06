package com.byazt.gwg;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.anythink.china.b.c;
import com.byazt.hsi.w;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1164, 26})
public class qg implements w {
    @Override // com.byazt.hsi.w
    public boolean n(Context context, TelephonyManager telephonyManager) {
        return qg(context, telephonyManager);
    }

    private static boolean qg(Context context, TelephonyManager telephonyManager) {
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission(c.a) == 0) {
            try {
                int iN = n();
                if (iN == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iN));
                }
                return n(serviceState);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static int n() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean n(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                int iIntValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                return iIntValue == 3 || iIntValue == 2;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
