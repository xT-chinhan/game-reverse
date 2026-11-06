package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.t;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.v;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.anythink.core.common.o.b {
    private static volatile d c;
    String a = "InterstitialAuto";
    ATInterstitialAutoLoadListener b = new ATInterstitialAutoLoadListener() { // from class: com.anythink.interstitial.a.d.1
        @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
        public final void onInterstitialAutoLoaded(final String str) {
            s.b();
            s.b(new Runnable() { // from class: com.anythink.interstitial.a.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.d != null) {
                        d.this.d.onInterstitialAutoLoaded(str);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
        public final void onInterstitialAutoLoadFail(final String str, final AdError adError) {
            s.b();
            s.b(new Runnable() { // from class: com.anythink.interstitial.a.d.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.d != null) {
                        d.this.d.onInterstitialAutoLoadFail(str, adError);
                    }
                }
            });
        }
    };
    private ATInterstitialAutoLoadListener d;
    private ATNativeAdCustomRender e;

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public final void a(Context context, String[] strArr, ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener, ATAdRequest aTAdRequest) {
        if (context == null) {
            Log.e("anythink", this.a + " init failed: context = null");
            return;
        }
        if (context instanceof Activity) {
            s.b().a((Activity) context);
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    if (ATAdxSetting.getInstance().isAdxNetworkMode(str)) {
                        Log.w("anythink", "Forbidden placement, this placement is in adx network mode");
                    } else if (v.a().a(str)) {
                        Log.w("anythink", "Forbidden placement");
                    } else if (!t.a().a(str)) {
                        t.a().a(str, true);
                        com.anythink.core.common.o.d dVarA = f(str).a();
                        if (dVarA != null) {
                            dVarA.a(this);
                            dVarA.a(context, aTAdRequest, 3);
                        }
                    }
                }
            }
        }
        this.d = aTInterstitialAutoLoadListener;
    }

    public final void a(ATAdRequest aTAdRequest, String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (ATAdxSetting.getInstance().isAdxNetworkMode(str)) {
                    Log.w("anythink", "Forbidden placement, this placement is in adx network mode");
                } else if (v.a().a(str)) {
                    Log.w("anythink", "Forbidden placement");
                } else if (!t.a().a(str)) {
                    t.a().a(str, true);
                    com.anythink.core.common.o.d dVarA = f(str).a();
                    if (dVarA != null) {
                        dVarA.a(this);
                        dVarA.a(s.b().M(), aTAdRequest, 3);
                    }
                }
            }
        }
    }

    public static void a(String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                t.a().a(str, false);
                com.anythink.core.common.o.d dVarA = f(str).a();
                if (dVarA != null) {
                    dVarA.a((com.anythink.core.common.o.b) null);
                    dVarA.d();
                }
            }
        }
    }

    public static void a(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f(str).b(map);
    }

    public final boolean b(String str) {
        boolean zIsReady = false;
        if (!TextUtils.isEmpty(str)) {
            ATAdStatusInfo aTAdStatusInfoE = e(str);
            if (aTAdStatusInfoE == null) {
                return false;
            }
            zIsReady = aTAdStatusInfoE.isReady();
        }
        aa.b(str, i.s.v, i.s.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public final ATAdStatusInfo c(String str) {
        ATAdStatusInfo aTAdStatusInfo;
        if (TextUtils.isEmpty(str) || (aTAdStatusInfo = e(str)) == null) {
            aTAdStatusInfo = new ATAdStatusInfo(false, false, null);
        }
        aa.b(str, i.s.v, i.s.C, aTAdStatusInfo.toString(), "");
        return aTAdStatusInfo;
    }

    public static List<ATAdInfo> d(String str) {
        com.anythink.core.common.f fVarF = f(str);
        if (fVarF != null) {
            return fVarF.a(s.b().M());
        }
        return null;
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        com.anythink.core.common.f fVarF;
        if (TextUtils.isEmpty(str) || (fVarF = f(str)) == null) {
            return;
        }
        s.b().a(fVarF, str2, "3", map);
    }

    private ATAdStatusInfo e(String str) {
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.a, "SDK init error!");
            return null;
        }
        com.anythink.core.common.f fVarF = f(str);
        if (fVarF != null) {
            return fVarF.a(s.b().M(), (Map<String, Object>) null);
        }
        return null;
    }

    private ATInterstitialAutoLoadListener b() {
        return this.b;
    }

    private static com.anythink.core.common.f f(String str) {
        return com.anythink.core.common.f.a(s.b().g(), str, "3");
    }

    @Override // com.anythink.core.common.o.b
    public final void a(String str) {
        ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener = a().b;
        if (aTInterstitialAutoLoadListener != null) {
            aTInterstitialAutoLoadListener.onInterstitialAutoLoaded(str);
        }
    }

    @Override // com.anythink.core.common.o.b
    public final void a(String str, AdError adError) {
        ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener = a().b;
        if (aTInterstitialAutoLoadListener != null) {
            aTInterstitialAutoLoadListener.onInterstitialAutoLoadFail(str, adError);
        }
    }

    public final void a(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.e = aTNativeAdCustomRender;
    }

    public final void a(Activity activity, String str, ATShowConfig aTShowConfig, ATInterstitialAutoEventListener aTInterstitialAutoEventListener, ATAdRevenueListener aTAdRevenueListener) {
        aa.b(str, i.s.v, i.s.A, i.s.o, "");
        if (TextUtils.isEmpty(str)) {
            Log.e(this.a, "PlacementId is Empty!");
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId is empty.");
            if (aTInterstitialAutoEventListener != null) {
                aTInterstitialAutoEventListener.onInterstitialAdVideoError(errorCode);
                return;
            }
            return;
        }
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.a, "Show error: SDK init error!");
            AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.exception, "", "sdk init error");
            if (aTInterstitialAutoEventListener != null) {
                aTInterstitialAutoEventListener.onInterstitialAdVideoError(errorCode2);
                return;
            }
            return;
        }
        if (activity == null) {
            Log.e(this.a, "Interstitial Show Activity is null.");
        }
        b bVarA = b.a(activity, str);
        if (bVarA != null) {
            bVarA.a(activity, aTShowConfig, new e(aTInterstitialAutoEventListener, aTAdRevenueListener), null, null, this.e);
        } else if (aTInterstitialAutoEventListener != null) {
            aTInterstitialAutoEventListener.onInterstitialAdVideoError(ErrorCode.getErrorCode(ErrorCode.exception, "", "adLoadManager is null"));
        }
    }

    public final void a(ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener) {
        this.d = aTInterstitialAutoLoadListener;
    }
}
