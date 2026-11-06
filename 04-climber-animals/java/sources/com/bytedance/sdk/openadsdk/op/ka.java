package com.bytedance.sdk.openadsdk.op;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.ub;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ub {
    @Override // com.bytedance.sdk.component.utils.ub
    public boolean ms(Context context, TelephonyManager telephonyManager) {
        return xr(context, telephonyManager);
    }

    private static boolean xr(Context context, TelephonyManager telephonyManager) {
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                int iMs = ms();
                if (iMs == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iMs));
                }
                return ms(serviceState);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static int ms() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean ms(ServiceState serviceState) {
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
