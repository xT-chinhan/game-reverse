package com.meta.android.mpg.cm.core;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c1m.m2a.m1g.e;
import c1m.m2a.m1g.k;
import c1m.m2a.m1g.q;
import c1m.m2a.m1g.s;
import c1m.m2a.m1g.u;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.C;
import com.meta.android.mpg.cm.BuildConfig;
import com.meta.android.mpg.cm.api.IAdCallback;
import com.meta.android.mpg.cm.api.IMetaAdApi;
import com.meta.android.mpg.cm.api.InitCallback;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IMetaAdApi {
    private Application a;
    private String b;
    private String c;
    private final AtomicBoolean d;

    class a implements e<k<Object>> {
        final /* synthetic */ InitCallback a;

        a(InitCallback initCallback) {
            this.a = initCallback;
        }

        @Override // c1m.m2a.m1g.e
        public void a(int i, String str) {
            c.this.d.set(false);
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "init-->onFail errCode:" + i + ", errMsg:" + str);
            InitCallback initCallback = this.a;
            if (initCallback != null) {
                initCallback.onInitFailed(10001, i != 1000 ? "verification failed" : "network error");
            }
        }

        @Override // c1m.m2a.m1g.e
        public void a(k<Object> kVar) {
            c.this.d.set(true);
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "init-->onSuccess");
            c.this.c();
            InitCallback initCallback = this.a;
            if (initCallback != null) {
                initCallback.onInitSuccess();
            }
        }
    }

    private static class b {
        private static final IMetaAdApi a = new c(null);
    }

    private c() {
        this.d = new AtomicBoolean(false);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static IMetaAdApi a() {
        return b.a;
    }

    private void a(Context context, IAdCallback iAdCallback, Intent intent) {
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "startAdActivityByAction.context: ", context);
        if (context != null && intent != null) {
            try {
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "startAdActivityByAction.startActivity.ErrorInfo: ", e.getMessage());
                if (iAdCallback == null) {
                    return;
                }
            }
        } else if (iAdCallback == null) {
            return;
        }
        iAdCallback.onAdShowFailed(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "params invalid");
    }

    private boolean a(Context context, IAdCallback iAdCallback) {
        if (!this.d.get()) {
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "checkParamIllegal.not verified");
            if (iAdCallback != null) {
                iAdCallback.onAdShowFailed(20003, "uninitialized verification");
            }
            return false;
        }
        if (context != null) {
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "checkParamIllegal.success");
            return true;
        }
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "checkParamIllegal.context is null");
        if (iAdCallback != null) {
            iAdCallback.onAdShowFailed(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "params invalid");
        }
        return false;
    }

    private void b() {
        com.meta.android.mpg.cm.core.b.a(this.a);
        com.meta.android.mpg.cm.core.a.a(this.a);
        this.c = com.meta.android.mpg.cm.core.b.a();
    }

    private void b(Context context, IAdCallback iAdCallback, Intent intent) {
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "startAdActivityByAction.context: " + context);
        if (context != null && intent != null) {
            try {
                context.sendBroadcast(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "startAdActivityByAction.startActivity.ErrorInfo: " + e.getMessage());
                if (iAdCallback == null) {
                    return;
                }
            }
        } else if (iAdCallback == null) {
            return;
        }
        iAdCallback.onAdShowFailed(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "params invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        q.a(this.a);
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void closeBannerAd() {
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "closeBannerAd");
        if (this.d.get()) {
            Intent intent = new Intent();
            intent.putExtra("mpg_cm_pkg", this.a.getPackageName());
            intent.putExtra("mpg_cm_banner_operation", 1);
            intent.setAction(u.a(this.a.getPackageName(), ".banner.ad.operation"));
            b(this.a, null, intent);
        }
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public String getApiVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void init(Application application, String str, InitCallback initCallback) {
        if (isInitialized()) {
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "init-->onSuccess already initialized");
            if (initCallback != null) {
                initCallback.onInitSuccess();
                return;
            }
            return;
        }
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "init-->appKey:" + str);
        if (application == null || TextUtils.isEmpty(str)) {
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "init-->params invalid");
            if (initCallback != null) {
                initCallback.onInitFailed(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "params invalid");
                return;
            }
            return;
        }
        this.a = application;
        this.b = str;
        application.unregisterActivityLifecycleCallbacks(s.b());
        application.registerActivityLifecycleCallbacks(s.b());
        b();
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "init-->check");
        d.a(application.getPackageName(), str, new a(initCallback));
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public boolean isInSupportVersion() {
        return isInSupportVersion(1) && isInSupportVersion(3);
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public boolean isInSupportVersion(int i) {
        if (!isInitialized()) {
            c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "isInSupportVersion-->not initialized");
            return false;
        }
        if (i == 1) {
            return u.a("com.meta.mpg.cm.wrapper", this.a) || u.a(u.a(this.c, ".mpg.cm.wrapper"), this.a) || u.a(com.meta.android.mpg.cm.core.a.a(), this.a);
        }
        if (i != 3) {
            return false;
        }
        return u.a(u.a(this.c, ".interstitial.ad"), this.a);
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public boolean isInitialized() {
        return this.d.get();
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void setLogLevel(int i) {
        c1m.m2a.m1g.b.a().setLogLevel(i);
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void setPersonalRecommendAd(boolean z) {
        if (this.d.get()) {
            Intent intent = new Intent();
            intent.putExtra("mpg_cm_pkg", this.a.getPackageName());
            intent.putExtra("extra_personal_recommend_ad", z);
            intent.putExtra("mpg_cm_ad_operation_type", 100);
            intent.setAction(u.a(this.a.getPackageName(), "mpg.ad.operation"));
            b(this.a, null, intent);
        }
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void showBannerAd(int i, IAdCallback iAdCallback) {
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "showBannerAd: pos:" + i);
        if (a(this.a, iAdCallback)) {
            Intent intent = new Intent();
            intent.putExtra("mpg_cm_pkg", this.a.getPackageName());
            intent.putExtra("mpg_cm_key", this.b);
            intent.putExtra("mpg_cm_pos", i);
            intent.setAction(u.a(this.a.getPackageName(), ".banner.ad"));
            q.a(iAdCallback);
            b(this.a, iAdCallback, intent);
        }
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void showInterstitialAd(int i, IAdCallback iAdCallback) {
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", String.format(Locale.getDefault(), "showInterstitialAd: pos:%1d", Integer.valueOf(i)));
        if (a(this.a, iAdCallback)) {
            if (!isInSupportVersion(3)) {
                if (iAdCallback != null) {
                    iAdCallback.onAdShowFailed(30007, "version not support");
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("mpg_cm_pkg", this.a.getPackageName());
            intent.putExtra("mpg_cm_key", this.b);
            intent.putExtra("mpg_cm_pos", i);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            intent.setAction(u.a(this.c, ".interstitial.ad"));
            q.b(iAdCallback);
            a(this.a, iAdCallback, intent);
        }
    }

    @Override // com.meta.android.mpg.cm.api.IMetaAdApi
    public void showVideoAd(int i, IAdCallback.IVideoIAdCallback iVideoIAdCallback) {
        String str;
        c1m.m2a.m1g.b.a().a("MetaAdApiImpl", String.format(Locale.getDefault(), "showVideoAd: pos:%1d", Integer.valueOf(i)));
        if (a(this.a, iVideoIAdCallback)) {
            if (!isInSupportVersion(1)) {
                c1m.m2a.m1g.b.a().a("MetaAdApiImpl", "showVideoAd-->not support version");
                if (iVideoIAdCallback != null) {
                    iVideoIAdCallback.onAdShowFailed(30007, "version not support");
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("mpg_cm_pkg", this.a.getPackageName());
            intent.putExtra("mpg_cm_key", this.b);
            intent.putExtra("mpg_cm_pos", i);
            Intent intent2 = new Intent();
            intent2.setFlags(C.ENCODING_PCM_MU_LAW);
            Context context = this.a;
            String strA = u.a(this.c, ".mpg.cm.wrapper");
            if (u.a(strA, this.a)) {
                str = strA;
            } else {
                str = "com.meta.mpg.cm.wrapper";
                if (!u.a("com.meta.mpg.cm.wrapper", this.a)) {
                    if (u.a(com.meta.android.mpg.cm.core.a.a(), this.a)) {
                        strA = com.meta.android.mpg.cm.core.a.a();
                        intent.putExtra("mpg_cm_loc_type", true);
                        Context contextA = s.b().a();
                        if (contextA != null) {
                            intent2.setFlags(intent2.getFlags() & (-268435457));
                            context = contextA;
                        }
                        str = strA;
                    } else {
                        str = "";
                    }
                }
            }
            intent2.putExtra("android.intent.extra.INTENT", intent);
            if (TextUtils.isEmpty(str)) {
                if (iVideoIAdCallback != null) {
                    iVideoIAdCallback.onAdShowFailed(30007, "version not support");
                }
            } else {
                intent2.setAction(str);
                q.a(iVideoIAdCallback);
                a(context, iVideoIAdCallback, intent2);
            }
        }
    }
}
