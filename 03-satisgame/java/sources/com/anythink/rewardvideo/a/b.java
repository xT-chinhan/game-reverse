package com.anythink.rewardvideo.a;

import android.content.Context;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.s;
import com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ATRewardVideoExListener {
    ATRewardVideoAutoEventListener a;
    ATAdRevenueListener b;

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdFailed(AdError adError) {
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdLoaded() {
    }

    protected b(ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener, ATAdRevenueListener aTAdRevenueListener) {
        this.a = aTRewardVideoAutoEventListener;
        this.b = aTAdRevenueListener;
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onDeeplinkCallback(aTAdInfo, z);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.8
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onDownloadConfirm(context, aTAdInfo, aTNetworkConfirmInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.9
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdAgainPlayStart(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayEnd(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.10
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdAgainPlayEnd(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.11
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdAgainPlayFailed(adError, aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardedVideoAdAgainPlayClicked(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.12
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdAgainPlayClicked(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onAgainReward(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.13
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onAgainReward(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onAgainRewardFailed(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.14
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.a != null) {
                        b.this.a.onAgainRewardFailed(aTAdInfo);
                    }
                } catch (Throwable th) {
                    Log.w("anythink", "onAgainRewardFailed: " + th.getMessage());
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
    public final void onRewardFailed(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.15
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.a != null) {
                        b.this.a.onRewardFailed(aTAdInfo);
                    }
                } catch (Throwable th) {
                    Log.w("anythink", "onRewardFailed: " + th.getMessage());
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayStart(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.b != null) {
                    b.this.b.onAdRevenuePaid(aTAdInfo);
                }
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdPlayStart(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayEnd(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdPlayEnd(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.4
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdPlayFailed(adError, aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.5
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdClosed(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.6
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardedVideoAdPlayClicked(aTAdInfo);
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
    public final void onReward(final ATAdInfo aTAdInfo) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.b.7
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.onReward(aTAdInfo);
                }
            }
        });
    }
}
