package com.ss.android.socialbase.downloader.network.ms;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.ch;
import com.ss.android.socialbase.downloader.ny.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    private static final HandlerThread ah;
    private static final Handler d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static long f4733ms;
    static long xr;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        ah = handlerThread;
        xr();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        d = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper ms() {
        return ah.getLooper();
    }

    public static void ms(final String str, final ch chVar) {
        d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ms.xr.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ah ahVarMs = null;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        List<com.ss.android.socialbase.downloader.model.ah> listXr = xr.xr(0L, null, null);
                        ahVarMs = ms.ms().ms(str) ? ms.ms().ms(str, listXr) : null;
                        if (ahVarMs == null) {
                            ah ahVar = new ah(str, listXr, 0L);
                            try {
                                ahVar.ms();
                                if (ahVar.ka()) {
                                    ms.ms().ms(str, ahVar);
                                }
                                ahVarMs = ahVar;
                            } catch (Exception e) {
                                e = e;
                                ahVarMs = ahVar;
                                ab.ms(e);
                                try {
                                    ahVarMs.ah();
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            } catch (Throwable th) {
                                th = th;
                                ahVarMs = ahVar;
                                try {
                                    ahVarMs.ah();
                                } catch (Throwable unused2) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> mapNy = ahVarMs.ny();
                        ch chVar2 = chVar;
                        if (chVar2 != null) {
                            chVar2.ms(mapNy);
                        }
                        try {
                            ahVarMs.ah();
                        } catch (Throwable unused3) {
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    ch chVar3 = chVar;
                    if (chVar3 != null) {
                        chVar3.ms(null);
                    }
                }
            }
        });
    }

    private static void xr() {
        f4733ms = com.ss.android.socialbase.downloader.ab.ms.ah().ms("preconnect_connection_outdate_time", 300000L);
        xr = com.ss.android.socialbase.downloader.ab.ms.ah().ms("preconnect_head_info_outdate_time", 300000L);
        ms.ms().ms(com.ss.android.socialbase.downloader.ab.ms.ah().ms("preconnect_max_cache_size", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.ah> xr(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.ah> list) {
        return c.ms(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
