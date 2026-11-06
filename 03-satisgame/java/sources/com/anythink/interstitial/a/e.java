package com.anythink.interstitial.a;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.s;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialExListener;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ATInterstitialExListener {
    ATInterstitialAutoEventListener a;
    ATAdRevenueListener b;

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdLoadFail(AdError adError) {
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdLoaded() {
    }

    protected e(ATInterstitialAutoEventListener aTInterstitialAutoEventListener, ATAdRevenueListener aTAdRevenueListener) {
        this.a = aTInterstitialAutoEventListener;
        this.b = aTAdRevenueListener;
    }

    @Override // com.anythink.interstitial.api.ATInterstitialExListener
    public final void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onDeeplinkCallback(aTAdInfo, z);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialExListener
    public final void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.2
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    ATInterstitialAutoEventListener aTInterstitialAutoEventListener = e.this.a;
                    Context contextM = context;
                    if (contextM == null) {
                        contextM = s.b().M();
                    }
                    aTInterstitialAutoEventListener.onDownloadConfirm(contextM, aTAdInfo, aTNetworkConfirmInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialExListener
    public final void onInterstitialAdReward(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.3
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdReward(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdVideoStart(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.4
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdVideoStart(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdVideoEnd(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.5
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdVideoEnd(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdVideoError(final AdError adError) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.6
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdVideoError(adError);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdClose(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.7
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdClose(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdClicked(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.8
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdClicked(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.interstitial.api.ATInterstitialListener
    public final void onInterstitialAdShow(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.interstitial.a.e.9
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.b != null) {
                    e.this.b.onAdRevenuePaid(aTAdInfo);
                }
                if (e.this.a != null) {
                    e.this.a.onInterstitialAdShow(aTAdInfo);
                }
            }
        });
    }
}
