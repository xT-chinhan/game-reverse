package com.bytedance.sdk.openadsdk.core.re;

import android.os.SystemClock;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.ny;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile long f3299ms = 0;
    private static volatile String xr = "0";

    public static String ms() {
        return System.currentTimeMillis() - f3299ms < j.k.a ? xr : "0";
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.re.ms$ms, reason: collision with other inner class name */
    public static class C0304ms implements ny {
        @Override // com.bytedance.sdk.component.xr.ms.ny
        public ao ms(ny.ms msVar) throws IOException {
            h hVarC;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            u uVarMs = msVar.ms();
            ao aoVarMs = msVar.ms(uVarMs);
            if (!"GET".equalsIgnoreCase(uVarMs.ah()) || (hVarC = aoVarMs.c()) == null) {
                return aoVarMs;
            }
            long jMs = hVarC.ms();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 0 && jMs > 10240) {
                String unused = ms.xr = String.format("%.2f", Double.valueOf(((jMs / 1024.0d) / jElapsedRealtime2) * 1000.0d));
                long unused2 = ms.f3299ms = System.currentTimeMillis();
                String unused3 = ms.xr;
            }
            return aoVarMs;
        }
    }
}
