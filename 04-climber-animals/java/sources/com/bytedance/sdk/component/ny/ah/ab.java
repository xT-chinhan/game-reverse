package com.bytedance.sdk.component.ny.ah;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    private static HashMap<Integer, ms> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ab f1274ms;
    private static HashMap<Integer, ka> xr;

    private ab() {
        xr = new HashMap<>();
        ah = new HashMap<>();
    }

    public static synchronized ab ms() {
        if (f1274ms == null) {
            synchronized (ab.class) {
                if (f1274ms == null) {
                    f1274ms = new ab();
                }
            }
        }
        return f1274ms;
    }

    public ka ms(int i) {
        ka kaVar = xr.get(Integer.valueOf(i));
        if (kaVar != null) {
            return kaVar;
        }
        ka kaVar2 = new ka(i);
        xr.put(Integer.valueOf(i), kaVar2);
        return kaVar2;
    }

    public ms ms(int i, Context context) {
        ms msVar = ah.get(Integer.valueOf(i));
        if (msVar != null) {
            return msVar;
        }
        ms msVar2 = new ms(context, i);
        ah.put(Integer.valueOf(i), msVar2);
        return msVar2;
    }
}
