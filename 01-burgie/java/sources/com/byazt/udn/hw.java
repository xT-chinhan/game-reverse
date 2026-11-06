package com.byazt.udn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.edb.vk;
import com.byazt.tuy.uc;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1254, 13})
public class hw {
    public static final HandlerThread hn;
    public static long hw;
    public static long pr;
    public static final Handler x;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        hn = handlerThread;
        hw();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        x = handler;
        handler.post(new Runnable() { // from class: com.byazt.udn.hw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable th) {
                }
            }
        });
    }

    public static Looper pr() {
        return hn.getLooper();
    }

    public static void pr(final String str, final vk vkVar) {
        x.post(new Runnable() { // from class: com.byazt.udn.hw.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                hn hnVarPr = null;
                if (TextUtils.isEmpty(str)) {
                    vk vkVar2 = vkVar;
                    if (vkVar2 != null) {
                        vkVar2.pr(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<com.byazt.auw.hn> listHw = hw.hw(0L, null, null);
                        hnVarPr = pr.pr().pr(str) ? pr.pr().pr(str, listHw) : null;
                        if (hnVarPr == null) {
                            hn hnVar = new hn(str, listHw, 0L);
                            try {
                                hnVar.pr();
                                if (hnVar.c()) {
                                    pr.pr().pr(str, hnVar);
                                }
                                hnVarPr = hnVar;
                            } catch (Exception e) {
                                hnVarPr = hnVar;
                                hnVarPr.hn();
                                return;
                            } catch (Throwable th) {
                                th = th;
                                hnVarPr = hnVar;
                                try {
                                    hnVarPr.hn();
                                } catch (Throwable th2) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> mapAj = hnVarPr.aj();
                        vk vkVar3 = vkVar;
                        if (vkVar3 != null) {
                            vkVar3.pr(mapAj);
                        }
                        hnVarPr.hn();
                    } catch (Throwable th3) {
                    }
                } catch (Exception e2) {
                }
            }
        });
    }

    private static void hw() {
        pr = com.byazt.ew.pr.hn().pr("preconnect_connection_outdate_time", 300000L);
        hw = com.byazt.ew.pr.hn().pr("preconnect_head_info_outdate_time", 300000L);
        pr.pr().pr(com.byazt.ew.pr.hn().pr("preconnect_max_cache_size", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.byazt.auw.hn> hw(long j, DownloadInfo downloadInfo, List<com.byazt.auw.hn> list) {
        return uc.pr(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
