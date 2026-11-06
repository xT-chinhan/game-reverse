package com.smartdigimkt.y2;

import android.content.Context;
import com.smartdigimkt.r4.y;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static volatile a a;
    public static boolean b;

    public static a a(Context context) {
        a aVar = a;
        if (aVar != null && aVar.a()) {
            return aVar;
        }
        a aVarA = d.a(y.c(context, "sdm_adx_rp_sdk", "ky_carrier_mcc"), y.c(context, "sdm_adx_rp_sdk", "ky_carrier_mnc"));
        if (!aVarA.a()) {
            return a.c;
        }
        a = aVarA;
        return aVarA;
    }

    public static synchronized void b(Context context) {
        if (b) {
            a(context);
            return;
        }
        b = true;
        a aVarA = c.a(context);
        if (!aVarA.a()) {
            a(context);
            return;
        }
        if (!aVarA.equals(a)) {
            a = aVarA;
            if (!aVarA.equals(d.a(y.c(context, "sdm_adx_rp_sdk", "ky_carrier_mcc"), y.c(context, "sdm_adx_rp_sdk", "ky_carrier_mnc"))) && aVarA.a()) {
                HashMap map = new HashMap();
                map.put("ky_carrier_mcc", aVarA.a);
                map.put("ky_carrier_mnc", aVarA.b);
                if (context != null) {
                    try {
                        com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_sdk").a(map);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
