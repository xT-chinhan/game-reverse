package com.byazt.r;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.m.tj;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 889, 26})
public class qg {
    public static long n;
    public static final Handler q;
    public static long qg;
    public static final HandlerThread s;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        s = handlerThread;
        qg();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        q = handler;
        handler.post(new Runnable() { // from class: com.byazt.r.qg.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper n() {
        return s.getLooper();
    }

    public static void n(final String str, final tj tjVar) {
        q.post(new Runnable() { // from class: com.byazt.r.qg.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                s sVarN = null;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        List<com.byazt.wm.s> listQg = qg.qg(0L, null, null);
                        sVarN = n.n().n(str) ? n.n().n(str, listQg) : null;
                        if (sVarN == null) {
                            s sVar = new s(str, listQg, 0L);
                            try {
                                sVar.n();
                                if (sVar.l()) {
                                    n.n().n(str, sVar);
                                }
                                sVarN = sVar;
                            } catch (Exception unused) {
                                sVarN = sVar;
                                try {
                                    sVarN.s();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            } catch (Throwable th) {
                                th = th;
                                sVarN = sVar;
                                try {
                                    sVarN.s();
                                } catch (Throwable unused3) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> mapRv = sVarN.rv();
                        tj tjVar2 = tjVar;
                        if (tjVar2 != null) {
                            tjVar2.n(mapRv);
                        }
                        try {
                            sVarN.s();
                        } catch (Throwable unused4) {
                        }
                    } catch (Exception unused5) {
                    }
                } else {
                    tj tjVar3 = tjVar;
                    if (tjVar3 != null) {
                        tjVar3.n(null);
                    }
                }
            }
        });
    }

    private static void qg() {
        n = com.byazt.f.n.s().n("preconnect_connection_outdate_time", 300000L);
        qg = com.byazt.f.n.s().n("preconnect_head_info_outdate_time", 300000L);
        n.n().n(com.byazt.f.n.s().n("preconnect_max_cache_size", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.byazt.wm.s> qg(long j, DownloadInfo downloadInfo, List<com.byazt.wm.s> list) {
        return w.n(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
