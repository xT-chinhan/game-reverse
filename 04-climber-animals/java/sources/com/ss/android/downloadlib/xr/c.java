package com.ss.android.downloadlib.xr;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadlib.ab.zb;
import com.tapsdk.tapad.e.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Handler f4531ms = new Handler(Looper.getMainLooper());

    public static void ms(final com.ss.android.downloadad.api.ms.xr xrVar, final x xVar) {
        boolean zXr = com.ss.android.socialbase.downloader.ms.ms.ms().xr();
        if (!zXr && Build.VERSION.SDK_INT >= 29) {
            zb.ah();
        }
        boolean zXr2 = com.ss.android.socialbase.downloader.ms.ms.ms().xr();
        boolean z = !zXr && zXr2;
        if (xrVar != null) {
            xrVar.sl(z);
        }
        xVar.ms(z);
        if (xrVar == null) {
            return;
        }
        xr(xrVar, ch(xrVar));
        if (zXr2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(new com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms() { // from class: com.ss.android.downloadlib.xr.c.1
            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void ah() {
            }

            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void xr() {
                com.ss.android.socialbase.downloader.ms.ms.ms().xr(this);
                com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.xr.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zAh = zb.ah(xrVar.ka());
                        long jKa = c.ka(xrVar);
                        if (!zAh || jKa >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            if (System.currentTimeMillis() - jCurrentTimeMillis > c.x(xrVar)) {
                                com.ss.android.downloadlib.d.ms.ms().ms("deeplink_delay_timeout", xrVar);
                                return;
                            }
                            xrVar.sl(true);
                            com.ss.android.downloadlib.d.ms.ms().ms("deeplink_delay_invoke", xrVar);
                            xVar.ms(true);
                            c.xr(xrVar, c.ch(xrVar));
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final com.ss.android.downloadad.api.ms.xr xrVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.xr.c.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (zb.ah(xrVar.ka())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!xrVar.v()) {
                            i2 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                    } catch (JSONException e) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    }
                    com.ss.android.downloadlib.d.ms.ms().ms("deeplink_success_2", jSONObject, xrVar);
                    return;
                }
                c.xr(xrVar, i - 1);
            }
        }, ny(xrVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long x(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("app_link_check_timeout", 300000L);
    }

    private static int ny(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ch(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("app_link_check_count", 10);
    }

    public static boolean ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).xr("app_link_opt_switch") == 1;
    }

    public static boolean xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).xr("app_link_opt_install_switch") == 1;
    }

    public static boolean ah(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).xr("app_link_opt_invoke_switch") == 1;
    }

    public static boolean d(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).xr("app_link_opt_dialog_switch") == 1;
    }

    public static long ka(com.ss.android.downloadad.api.ms.xr xrVar) {
        return xrVar == null ? a.f : com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("app_link_opt_back_time_limit", 3) * 1000;
    }
}
