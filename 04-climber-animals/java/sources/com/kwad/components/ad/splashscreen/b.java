package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final Handler iK = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    static class C0401b {
        private volatile boolean Fb;

        private C0401b() {
            this.Fb = false;
        }

        /* synthetic */ C0401b(byte b) {
            this();
        }

        static /* synthetic */ boolean a(C0401b c0401b, boolean z) {
            c0401b.Fb = true;
            return true;
        }
    }

    static class a {
        private volatile boolean Fa;

        private a() {
            this.Fa = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(sceneImplCovert);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.u(sceneImplCovert.getPosId());
        boolean zB = n.tn().b(sceneImplCovert, "loadSplashScreenAd");
        sceneImplCovert.setAdStyle(4);
        sceneImplCovert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b = 0;
        final a aVar = new a(b);
        aVar.Fa = false;
        final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(sceneImplCovert);
        final C0401b c0401b = new C0401b(b);
        com.kwad.components.core.p.a.se().sg();
        Handler handler = iK;
        handler.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(impInfo);
            }
        }, 15000L);
        final bg bgVar = new bg() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                C0401b.a(c0401b, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                splashScreenAdListener.onError(com.kwad.sdk.core.network.e.aEs.errorCode, com.kwad.sdk.core.network.e.aEs.msg);
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.c(false, com.kwad.sdk.core.network.e.aEs.errorCode, com.kwad.sdk.core.network.e.aEs.msg, sceneImplCovert.getPosId());
                com.kwad.components.core.p.a.se().aS(4);
            }
        };
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FM);
        if (iA < 0) {
            iA = 5000;
        }
        handler.postDelayed(bgVar, iA);
        final long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.f(sceneImplCovert.getPosId(), jElapsedRealtime3);
        SplashPreloadManager.lD().a(sceneImplCovert.getPosId(), 2);
        List<String> listLE = SplashPreloadManager.lD().lE();
        List<Integer> listI = SplashPreloadManager.lD().i(listLE);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.a(sceneImplCovert.getPosId(), listLE, listI);
        KsAdLoadManager.M().a(new com.kwad.components.core.request.model.a.C0444a().e(impInfo).aL(true).aM(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i, final String str, boolean z) {
                if (!c0401b.Fb) {
                    b.iK.removeCallbacks(bgVar);
                    if (!aVar.Fa && i != com.kwad.sdk.core.network.e.aEq.errorCode) {
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.b(z, i, str, sceneImplCovert.getPosId());
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, sceneImplCovert.getPosId());
                    }
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                            splashScreenAdListener.onError(i, str);
                            if (i == com.kwad.sdk.core.network.e.aEt.errorCode) {
                                com.kwad.components.core.p.a.se().aS(0);
                            } else {
                                com.kwad.components.core.p.a.se().aS(3);
                            }
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v9, types: [com.kwad.components.ad.splashscreen.KsSplashScreenAdControl, com.kwad.sdk.api.KsSplashScreenAd] */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final AdResultData adResultData, boolean z) {
                boolean ksSplashScreenAdControl;
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.lX().t(sceneImplCovert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (b.a(adResultData, aVar, this, z, sceneImplCovert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    adTemplate.requestStartTime = jElapsedRealtime;
                    adTemplate.notNetworkRequest = z;
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.e(adTemplate, jElapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(sceneImplCovert, 1);
                    long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                    ksSplashScreenAdControl = new KsSplashScreenAdControl(sceneImplCovert, adResultData);
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
                        try {
                            SplashPreloadManager.lD();
                            if (SplashPreloadManager.i(adResultData)) {
                                if (b.a(c0401b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                if (SplashPreloadManager.lD().h(adResultData)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.p.a.se().aS(1);
                                    adTemplate.splashAdLoadType = 2;
                                    return;
                                }
                                if (SplashPreloadManager.lD().a(adResultData, true, 1) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.components.core.p.a.se().aS(2);
                                    adTemplate.splashAdLoadType = 1;
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, jElapsedRealtime4, jElapsedRealtime3);
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            ksSplashScreenAdControl = z;
                        }
                    }
                    SplashPreloadManager.lD();
                    if (!SplashPreloadManager.i(adResultData)) {
                        SplashPreloadManager.lD();
                        if (!SplashPreloadManager.j(adResultData)) {
                            if (b.a(c0401b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, jElapsedRealtime4, jElapsedRealtime3);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.p.a.se().aS(5);
                            return;
                        }
                    }
                    boolean zH = SplashPreloadManager.lD().h(adResultData);
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + zH);
                    if (zH) {
                        if (b.a(c0401b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, jElapsedRealtime4, jElapsedRealtime3);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.p.a.se().aS(1);
                        adTemplate.splashAdLoadType = 2;
                        return;
                    }
                    SplashPreloadManager.lD();
                    try {
                        if (!SplashPreloadManager.i(adResultData)) {
                            if (!c0401b.Fb) {
                                b.iK.removeCallbacks(bgVar);
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, jElapsedRealtime4, jElapsedRealtime3);
                                aVar.Fa = true;
                                a(com.kwad.sdk.core.network.e.aEr.errorCode, "请求成功，但缓存未命中", z);
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                                com.kwad.components.core.p.a.se().aS(3);
                                return;
                            }
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int iA2 = SplashPreloadManager.lD().a(adResultData, true, 1);
                        if (b.a(c0401b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                            return;
                        }
                        if (iA2 > 0) {
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, jElapsedRealtime4, jElapsedRealtime3);
                            com.kwad.components.core.p.a.se().aS(2);
                            adTemplate.splashAdLoadType = 1;
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, jElapsedRealtime4, jElapsedRealtime3);
                        aVar.Fa = true;
                        a(com.kwad.sdk.core.network.e.aEt.errorCode, com.kwad.sdk.core.network.e.aEt.msg, z);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ksSplashScreenAdControl = z;
                }
                ServiceProvider.reportSdkCaughtException(th);
                a(com.kwad.sdk.core.network.e.aEv.errorCode, com.kwad.sdk.core.network.e.aEv.msg, ksSplashScreenAdControl);
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0401b c0401b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (c0401b.Fb) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        iK.removeCallbacks(runnable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a(ksSplashScreenAd);
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    com.kwad.components.ad.splashscreen.monitor.a.lX().af(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.c(z, com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg, j);
        aVar.Fa = true;
        dVar.a(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg, z);
        com.kwad.components.core.p.a.se().aS(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.p.a.se().sh();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.v(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M().a(new com.kwad.components.core.request.model.a.C0444a().e(impInfo2).aM(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, sceneImpl.getPosId());
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void b(AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.lD().a(adResultData, false, 2));
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - jElapsedRealtime, sceneImpl.getPosId());
                            com.kwad.components.core.p.a.se().aT(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            }).sw());
        }
    }
}
