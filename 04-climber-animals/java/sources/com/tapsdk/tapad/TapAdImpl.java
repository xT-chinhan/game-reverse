package com.tapsdk.tapad;

import android.app.Application;
import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.e.g;
import com.tapsdk.tapad.e.h;
import com.tapsdk.tapad.e.l;
import com.tapsdk.tapad.internal.logging.HttpLoggingInterceptor;
import com.tapsdk.tapad.internal.q.c.e;
import com.tapsdk.tapad.internal.tracker.experiment.ExpTdsTrackerConfig;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.v;
import java.lang.ref.WeakReference;
import java.net.URL;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class TapAdImpl implements ITapAd {
    private volatile boolean initialized = false;
    private volatile TapAdConfig tapAdConfig;

    private class b implements com.tapsdk.tapad.internal.q.c.c {
        private b() {
        }

        @Override // com.tapsdk.tapad.internal.q.c.c
        public void a(NetworkInfo networkInfo, com.tapsdk.tapad.internal.q.e.a aVar) {
            f fVar = new f();
            URL url = aVar.b;
            if (url != null) {
                fVar.g(url.toString());
            }
            fVar.c(aVar.c).b(aVar.h).b(aVar.d).c(aVar.e).a(aVar.k - aVar.j).a(aVar.i);
            TapAdCustomController tapAdCustomController = TapAdImpl.this.tapAdConfig != null ? TapAdImpl.this.tapAdConfig.mCustomController : null;
            if (tapAdCustomController != null) {
                fVar.e(tapAdCustomController.isCanUseLocation()).f(tapAdCustomController.isCanUsePhoneState()).h(tapAdCustomController.isCanUseWriteExternal()).c(tapAdCustomController.isCanUseAndroidId()).g(TapAdImpl.this.tapAdConfig.shakeEnabled);
            }
            if (TapAdImpl.this.tapAdConfig != null) {
                if (!TextUtils.isEmpty(TapAdImpl.this.tapAdConfig.mTapClientId)) {
                    fVar.e(TapAdImpl.this.tapAdConfig.mTapClientId);
                }
                if (TapAdImpl.this.tapAdConfig.mCustomController != null) {
                    fVar.d(!TextUtils.isEmpty(TapAdImpl.this.tapAdConfig.mCustomController.getDevOaid()) ? TapAdImpl.this.tapAdConfig.mCustomController.getDevOaid() : h.b().a());
                    String strB = l.a().b();
                    if (!TextUtils.isEmpty(strB)) {
                        fVar.f(strB);
                    }
                }
            }
            fVar.b(g.d().e());
            fVar.a(g.d().f());
            fVar.d(g.d().g());
            try {
                com.tapsdk.tapad.internal.tracker.experiment.f.b().a(com.tapsdk.tapad.internal.tracker.experiment.g.a).a(fVar);
            } catch (Exception unused) {
            }
        }

        @Override // com.tapsdk.tapad.internal.q.c.c
        public void a(NetworkInfo networkInfo, com.tapsdk.tapad.internal.q.e.a aVar, Exception exc) {
            f fVar = new f();
            URL url = aVar.b;
            if (url != null) {
                fVar.g(url.toString());
            }
            fVar.c(aVar.c).b(aVar.h).b(aVar.d).c(aVar.e).a(aVar.k - aVar.j).a(aVar.i).a(exc.getMessage());
            TapAdCustomController tapAdCustomController = TapAdImpl.this.tapAdConfig != null ? TapAdImpl.this.tapAdConfig.mCustomController : null;
            if (tapAdCustomController != null) {
                fVar.e(tapAdCustomController.isCanUseLocation()).f(tapAdCustomController.isCanUsePhoneState()).h(tapAdCustomController.isCanUseWriteExternal()).c(tapAdCustomController.isCanUseAndroidId()).g(TapAdImpl.this.tapAdConfig.shakeEnabled);
            }
            com.tapsdk.tapad.internal.tracker.experiment.f.b().a(com.tapsdk.tapad.internal.tracker.experiment.g.a).a(fVar);
        }
    }

    private void initAdNet(Context context, TapAdConfig tapAdConfig) {
        com.tapsdk.tapad.internal.t.a aVar = new com.tapsdk.tapad.internal.t.a(tapAdConfig.mMediaId, tapAdConfig.mMediaKey.substring(0, 32), tapAdConfig.mMediaVersion, "1");
        com.tapsdk.tapad.internal.t.a aVar2 = new com.tapsdk.tapad.internal.t.a(tapAdConfig.mMediaId, tapAdConfig.mMediaKey.substring(32), tapAdConfig.mMediaVersion, "1");
        String strB = (com.tapsdk.tapad.b.b() == null || com.tapsdk.tapad.b.b().length() <= 0) ? BuildConfig.BASE_SERVER_URL_CN : com.tapsdk.tapad.b.b();
        b bVar = new b();
        e eVar = new e(context);
        eVar.a(bVar);
        com.tapsdk.tapad.internal.q.d.a aVar3 = new com.tapsdk.tapad.internal.q.d.a(new com.tapsdk.tapad.internal.q.f.b(eVar));
        Application application = (Application) context.getApplicationContext();
        com.tapsdk.tapad.internal.tracker.experiment.f.b().b(new ExpTdsTrackerConfig.b().c(com.tapsdk.tapad.internal.tracker.experiment.g.a).a(tapAdConfig.mMediaId + "_" + tapAdConfig.mMediaVersion + "_1").b(tapAdConfig.mMediaKey).c("commercial.iem.taptap.cn").e("tap-ad-log").d("adn-sdk").f("3.16.3.45").b(31603045).a(application), application, new com.tapsdk.tapad.internal.tracker.experiment.i.b());
        com.tapsdk.tapad.internal.tracker.experiment.f.b().b(new ExpTdsTrackerConfig.b().c(com.tapsdk.tapad.internal.tracker.experiment.g.b).a(tapAdConfig.mMediaId + "_" + tapAdConfig.mMediaVersion + "_1").b(tapAdConfig.mMediaKey).c("commercial.iem.taptap.cn").e("tap-adn-log").d("adn-sdk-eventtracker").f("3.16.3.45").b(31603045).a(application), application, new com.tapsdk.tapad.internal.tracker.experiment.i.c());
        com.tapsdk.tapad.internal.q.a aVarA = new com.tapsdk.tapad.internal.q.a.C0627a().a(aVar3).a(true).a();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(com.tapsdk.tapad.b.d(), com.tapsdk.tapad.b.g());
        httpLoggingInterceptor.a(com.tapsdk.tapad.b.f());
        com.tapsdk.tapad.a.a().a(Constants.b.a, new com.tapsdk.tapad.internal.network.a.g().a(strB).a(new OkHttpClient.Builder().addInterceptor(new com.tapsdk.tapad.internal.t.e(aVar)).addInterceptor(new com.tapsdk.tapad.internal.t.d(aVar2)).addInterceptor(aVarA).addNetworkInterceptor(httpLoggingInterceptor).eventListener(new com.tapsdk.tapad.internal.q.b.a()).build()).b(v.a().a(strB)).a());
    }

    private void initAdRecordNet() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(com.tapsdk.tapad.b.d(), com.tapsdk.tapad.b.g());
        httpLoggingInterceptor.a(com.tapsdk.tapad.b.f());
        com.tapsdk.tapad.a.a().a(Constants.b.c, new com.tapsdk.tapad.internal.network.a.g().a(new OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor).build()).a("").b(Constants.b.d).a());
    }

    private void initAdSrcNet(TapAdConfig tapAdConfig) {
        com.tapsdk.tapad.internal.t.a aVar = new com.tapsdk.tapad.internal.t.a(tapAdConfig.mMediaId, tapAdConfig.mMediaKey.substring(0, 32), tapAdConfig.mMediaVersion, "1");
        com.tapsdk.tapad.internal.t.a aVar2 = new com.tapsdk.tapad.internal.t.a(tapAdConfig.mMediaId, tapAdConfig.mMediaKey.substring(32), tapAdConfig.mMediaVersion, "1");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(com.tapsdk.tapad.b.d(), com.tapsdk.tapad.b.g());
        httpLoggingInterceptor.a(com.tapsdk.tapad.b.f());
        com.tapsdk.tapad.a.a().a(Constants.b.b, new com.tapsdk.tapad.internal.network.a.g().a(new OkHttpClient.Builder().addInterceptor(new com.tapsdk.tapad.internal.t.e(aVar)).addInterceptor(new com.tapsdk.tapad.internal.t.d(aVar2)).addNetworkInterceptor(httpLoggingInterceptor).build()).a("").b(Constants.b.d).a());
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013 A[Catch: all -> 0x006a, TryCatch #0 {, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x001c, B:14:0x0023, B:15:0x0057, B:17:0x0059, B:20:0x005f, B:23:0x0068, B:9:0x0013), top: B:28:0x0006 }] */
    @Override // com.tapsdk.tapad.ITapAd
    public void init(Context context, TapAdConfig tapAdConfig) {
        String str;
        synchronized (TapAdImpl.class) {
            if (tapAdConfig == null) {
                TapADLogger.setLevel(TapADLogger.Level.INFO);
                com.tapsdk.tapad.e.o.a.l.a.a(false);
            } else if (tapAdConfig.mIsDebug) {
                TapADLogger.setLevel(TapADLogger.Level.DEBUG);
                com.tapsdk.tapad.e.o.a.l.a.a(true);
            } else {
                TapADLogger.setLevel(TapADLogger.Level.INFO);
                com.tapsdk.tapad.e.o.a.l.a.a(false);
            }
            if (!this.initialized && tapAdConfig != null) {
                TapADLogger.d("TapAdSdk init start");
                this.tapAdConfig = tapAdConfig;
                com.tapsdk.tapad.internal.utils.c.a = new WeakReference<>(this.tapAdConfig);
                c.a(context);
                v.a().a(context);
                initAdNet(context, tapAdConfig);
                initAdSrcNet(tapAdConfig);
                initAdRecordNet();
                TapAdManager.get().init(context, tapAdConfig);
                com.tapsdk.tapad.internal.tracker.c.a();
                this.initialized = true;
                TapADLogger.d("TapAdSdk init end");
                return;
            }
            if (!this.initialized) {
                str = tapAdConfig == null ? "TapAdSdk init param config is null" : "TapAdSdk repeated initialization";
            }
            TapADLogger.w(str);
        }
    }

    @Override // com.tapsdk.tapad.ITapAd
    public void updateAdConfig(TapAdConfig tapAdConfig) {
        synchronized (TapAdImpl.class) {
            if (this.initialized && this.tapAdConfig != null && tapAdConfig != null) {
                if (tapAdConfig.data != null) {
                    this.tapAdConfig.data = tapAdConfig.data;
                }
            }
        }
    }
}
