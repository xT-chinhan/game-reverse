package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    private final Handler ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ny.x<String, xr> f4720ms;
    private final Handler xr;

    public interface ms {
        void ms(String str, List<InetAddress> list);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.ah$ah, reason: collision with other inner class name */
    private static class C0571ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ah f4723ms = new ah();
    }

    private ah() {
        this.f4720ms = new com.ss.android.socialbase.downloader.ny.x<>(4, 16, false);
        this.xr = new Handler(com.ss.android.socialbase.downloader.network.ms.xr.ms());
        this.ah = new Handler(com.ss.android.socialbase.downloader.x.ka.ms());
    }

    public static ah ms() {
        return C0571ah.f4723ms;
    }

    public void ms(final String str, final ms msVar, final long j) {
        this.xr.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ah.this.xr(str, msVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final String str, final ms msVar, long j) {
        final xr xrVar;
        List<InetAddress> listMs;
        c cVarB;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.f4720ms) {
                xrVar = this.f4720ms.get(host);
            }
            if (xrVar != null) {
                if (System.currentTimeMillis() - xrVar.xr < com.ss.android.socialbase.downloader.ab.ms.ah().ms("dns_expire_min", 10) * 60 * 1000) {
                    if (msVar != null) {
                        msVar.ms(str, xrVar.f4724ms);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ah.2
                @Override // java.lang.Runnable
                public void run() {
                    ms msVar2 = msVar;
                    if (msVar2 != null) {
                        String str2 = str;
                        xr xrVar2 = xrVar;
                        msVar2.ms(str2, xrVar2 == null ? null : xrVar2.f4724ms);
                    }
                }
            };
            this.ah.postDelayed(runnable, j);
            if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("use_host_dns", 1) != 1 || (cVarB = com.ss.android.socialbase.downloader.downloader.ah.b()) == null) {
                listMs = null;
            } else {
                try {
                    listMs = cVarB.ms(host);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    listMs = null;
                }
            }
            if (listMs == null || listMs.isEmpty()) {
                try {
                    listMs = com.ss.android.socialbase.downloader.downloader.ah.re().ms(host);
                } catch (Throwable th2) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th2);
                }
            }
            if (listMs != null && !listMs.isEmpty()) {
                ms(host, listMs);
            } else if (xrVar != null) {
                listMs = xrVar.f4724ms;
            }
            this.ah.removeCallbacks(runnable);
            if (msVar != null) {
                msVar.ms(str, listMs);
            }
        } catch (Throwable th3) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th3);
        }
    }

    private void ms(String str, List<InetAddress> list) {
        synchronized (this.f4720ms) {
            xr xrVar = this.f4720ms.get(str);
            if (xrVar == null) {
                xrVar = new xr();
                this.f4720ms.put(str, xrVar);
            }
            xrVar.f4724ms = list;
            xrVar.xr = System.currentTimeMillis();
        }
    }

    private static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        List<InetAddress> f4724ms;
        long xr;

        private xr() {
        }
    }
}
