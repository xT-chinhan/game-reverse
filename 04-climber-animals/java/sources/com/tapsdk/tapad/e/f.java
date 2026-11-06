package com.tapsdk.tapad.e;

import android.util.Base64;
import com.tapsdk.tapad.model.entities.UninstalledAdInfo;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final String a = "uninstalled_ad_info";
    private static final com.tapsdk.tapad.internal.i.a b = new com.tapsdk.tapad.internal.i.b(com.tapsdk.tapad.c.a);

    public static void a() {
        b.a(a);
    }

    public static void a(UninstalledAdInfo uninstalledAdInfo) {
        b.a(a, Base64.encodeToString(com.tapsdk.tapad.internal.tracker.experiment.j.g.a(uninstalledAdInfo), 0));
    }

    public static String b() {
        return b.b(a);
    }

    public static UninstalledAdInfo c() {
        String strB = b();
        if (strB == null || strB.length() <= 0) {
            return null;
        }
        try {
            UninstalledAdInfo uninstalledAdInfo = (UninstalledAdInfo) com.tapsdk.tapad.internal.tracker.experiment.j.g.a(Base64.decode(strB, 0), UninstalledAdInfo.CREATOR);
            if (com.tapsdk.tapad.internal.utils.b.a(com.tapsdk.tapad.c.a, com.tapsdk.tapad.internal.utils.f.a(com.tapsdk.tapad.c.a, com.tapsdk.tapad.internal.a.a(com.tapsdk.tapad.c.a, uninstalledAdInfo.adInfo)))) {
                return null;
            }
            return uninstalledAdInfo;
        } catch (Throwable unused) {
            return null;
        }
    }
}
