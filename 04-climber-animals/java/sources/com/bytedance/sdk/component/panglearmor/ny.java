package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    private static AtomicInteger ah = new AtomicInteger(0);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ny f1317ms = null;
    private static volatile boolean xr = false;

    private ny() {
    }

    public static ny ms() {
        if (f1317ms == null) {
            synchronized (ny.class) {
                if (f1317ms == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.bytedance.sdk.openadsdk.op.c.ms("panglearmor");
                        xr = true;
                        ah.set(1);
                    } catch (Throwable unused) {
                        xr = false;
                        ah.set(2);
                    }
                    f1317ms = new ny();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    x xVarAb = c.ab();
                    if (xVarAb != null) {
                        xVarAb.ms(jCurrentTimeMillis2 - jCurrentTimeMillis, xr);
                    }
                }
            }
        }
        return f1317ms;
    }

    public static boolean xr() {
        return xr;
    }

    public static int ah() {
        return ah.get();
    }

    public byte[] ms(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && xr) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] xr(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && xr) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String ms(String str) {
        if (str == null || str.length() == 0 || !xr) {
            return null;
        }
        try {
            byte[] bArrXr = xr(Base64.decode(str, 0));
            if (bArrXr != null) {
                return new String(bArrXr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
