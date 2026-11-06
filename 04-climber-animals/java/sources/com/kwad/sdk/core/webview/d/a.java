package com.kwad.sdk.core.webview.d;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.a(C0504a.KX());
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    public static final class C0504a extends com.kwad.sdk.core.response.a.a {
        public String LN;
        public int Qv;
        public int Qw;
        public String SDKVersion;
        public int SDKVersionCode;
        public String aCk;
        public String aCl;
        public String aHz;
        public String aIB;
        public String aIk;
        public String aIn;
        public String aIo;
        public String aNI;
        public String aNJ;
        public boolean aNK;
        public String aNL;
        public String adg;
        public String adh;
        public int adi;
        public String adj;
        public int adk;
        public String adl;
        public String adm;
        public int adn;
        public int ado;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C0504a KX() {
            C0504a c0504a = new C0504a();
            c0504a.SDKVersion = BuildConfig.VERSION_NAME;
            c0504a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0504a.aHz = "6.1.7";
            c0504a.aNL = "1.3";
            c0504a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0504a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0504a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0504a.appVersion = m.cE(context);
            c0504a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0504a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0504a.aNI = "";
            c0504a.aIo = ag.Qz();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0504a.aIn = hVar.qd();
            }
            c0504a.adg = String.valueOf(ao.df(context));
            c0504a.adh = br.Sd();
            c0504a.model = br.RT();
            c0504a.LN = br.RV();
            c0504a.adi = 1;
            c0504a.adj = br.getOsVersion();
            c0504a.adk = br.Sg();
            c0504a.adl = br.getLanguage();
            c0504a.adm = br.getLocale();
            c0504a.aNK = ((f) ServiceProvider.get(f.class)).Bk();
            c0504a.aNJ = bd.getDeviceId();
            c0504a.Qw = br.getScreenWidth(context);
            c0504a.Qv = br.getScreenHeight(context);
            c0504a.aCk = bd.m36do(context);
            c0504a.aCl = bd.getOaid();
            c0504a.aIk = bd.dp(context);
            c0504a.aIB = bd.dq(context);
            c0504a.adn = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0504a.ado = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0504a;
        }
    }
}
