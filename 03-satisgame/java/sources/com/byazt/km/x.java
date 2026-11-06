package com.byazt.km;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 21})
public class x {
    public static String n(TelephonyManager telephonyManager) throws SecurityException {
        if (cp.qg) {
            cp.n("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
