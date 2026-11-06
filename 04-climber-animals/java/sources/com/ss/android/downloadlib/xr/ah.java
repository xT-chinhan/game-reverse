package com.ss.android.downloadlib.xr;

import android.os.Build;
import com.ss.android.downloadlib.ab.zb;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    public static void ms(final com.ss.android.downloadad.api.ms.xr xrVar, final com.ss.android.downloadlib.guide.install.ms msVar) {
        boolean zXr = com.ss.android.socialbase.downloader.ms.ms.ms().xr();
        if (!zXr && Build.VERSION.SDK_INT >= 29) {
            zb.ah();
        }
        boolean zXr2 = com.ss.android.socialbase.downloader.ms.ms.ms().xr();
        if (!zXr && zXr2 && xrVar != null) {
            xrVar.sl(true);
        }
        msVar.ms();
        com.ss.android.socialbase.downloader.ah.ms.xr("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zXr2)));
        if (zXr2) {
            return;
        }
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(new com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms() { // from class: com.ss.android.downloadlib.xr.ah.1
            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void ah() {
            }

            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void xr() {
                com.ss.android.socialbase.downloader.ah.ms.xr("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.ms.ms.ms().xr(this);
                if (zb.xr(xrVar)) {
                    return;
                }
                xrVar.zb(true);
                com.ss.android.downloadlib.d.ms.ms().ms("install_delay_invoke", xrVar);
                msVar.ms();
            }
        });
    }
}
