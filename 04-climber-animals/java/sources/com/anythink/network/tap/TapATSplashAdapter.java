package com.anythink.network.tap;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapSplashAd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATSplashAdapter extends CustomSplashAdapter {
    private boolean b;
    private TapAdNative d;
    private TapSplashAd e;
    private int f;
    private final TapATInitManager a = TapATInitManager.getInstance();
    private int c = 0;

    static /* synthetic */ int d(TapATSplashAdapter tapATSplashAdapter) {
        tapATSplashAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int f(TapATSplashAdapter tapATSplashAdapter) {
        tapATSplashAdapter.mDismissType = 3;
        return 3;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.b = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private static int a(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    private static int b(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        TapSplashAd tapSplashAd = this.e;
        if (tapSplashAd != null) {
            tapSplashAd.dispose();
            this.e = null;
        }
        TapAdNative tapAdNative = this.d;
        if (tapAdNative != null) {
            tapAdNative.dispose();
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return String.valueOf(this.c);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return this.a.getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return this.a.getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.e != null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, final Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "Tap SplashAd context must be activity.");
            return;
        }
        int spaceId = this.a.getSpaceId(map);
        this.c = spaceId;
        if (spaceId == 0) {
            notifyATLoadFail("", "Tap SplashAd spaceId is null or zero. spaceId:" + this.c);
        } else {
            this.a.initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.tap.TapATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TapATSplashAdapter.this.postOnMainThread(new Runnable() { // from class: com.anythink.network.tap.TapATSplashAdapter.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TapATSplashAdapter.a(TapATSplashAdapter.this, context, map2);
                        }
                    });
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TapATSplashAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    private void a(String str) {
        this.mDismissType = 99;
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode("", "", str));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    private void a() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    private void b() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShow();
        }
    }

    private void c() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    private void a(Context context, Map<String, Object> map) {
        this.f = ATInitMediation.getIntFromMap(map, TapATInitManager.ORIENTATION_KEY, 1);
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        this.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadSplashAd(this.a.getAdRequest(this.c, map), new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements TapAdNative.SplashAdListener {
        AnonymousClass2() {
        }

        @Override // com.tapsdk.tapad.internal.CommonListener
        public final void onError(int i, String str) {
            TapATSplashAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.tapsdk.tapad.TapAdNative.SplashAdListener
        public final void onSplashAdLoad(TapSplashAd tapSplashAd) {
            if (tapSplashAd != null) {
                TapATSplashAdapter.this.e = tapSplashAd;
                TapATSplashAdapter.this.a.handleAdLoadedCallback(TapATSplashAdapter.this.b, tapSplashAd, tapSplashAd.getMediaExtraInfo(), TapATSplashAdapter.this.mBiddingListener, TapATSplashAdapter.this.mLoadListener, new BaseAd[0]);
            } else {
                TapATSplashAdapter.this.notifyATLoadFail("", "Tap SplashAd load failed, splashAd = null.");
            }
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        int i;
        int i2;
        TapSplashAd tapSplashAd = this.e;
        if (tapSplashAd == null) {
            a("Tap SplashAd show failed, mSplashAd = null.");
            return;
        }
        if (activity == null) {
            a("Tap SplashAd show failed, activity == null.");
            return;
        }
        tapSplashAd.setSplashInteractionListener(new TapSplashAd.AdInteractionListener() { // from class: com.anythink.network.tap.TapATSplashAdapter.3
            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public final void onAdValidShow() {
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public final void onAdSkip() {
                TapATSplashAdapter.d(TapATSplashAdapter.this);
                TapATSplashAdapter.e(TapATSplashAdapter.this);
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public final void onAdTimeOver() {
                TapATSplashAdapter.f(TapATSplashAdapter.this);
                TapATSplashAdapter.e(TapATSplashAdapter.this);
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public final void onAdClick() {
                TapATSplashAdapter.g(TapATSplashAdapter.this);
            }

            @Override // com.tapsdk.tapad.TapSplashAd.AdInteractionListener
            public final void onAdShow() {
                TapATSplashAdapter.h(TapATSplashAdapter.this);
            }
        });
        try {
            if (viewGroup != null) {
                View splashView = this.e.getSplashView(activity);
                if (splashView.getParent() != null) {
                    ((ViewGroup) splashView.getParent()).removeView(splashView);
                }
                int i3 = this.f;
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
                    i2 = layoutParams.width;
                    i = layoutParams.height;
                    if (i3 == 1) {
                        i = (i2 * 16) / 9;
                    } else {
                        i2 = (i * 16) / 9;
                    }
                } else if (i3 == 1) {
                    i2 = activity.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
                    i = (i2 * 16) / 9;
                } else {
                    i = activity.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
                    i2 = (i * 16) / 9;
                }
                viewGroup.addView(splashView, new ViewGroup.LayoutParams(i2, i));
                return;
            }
            this.e.show(activity);
        } catch (Throwable th) {
            a(th.getMessage());
        }
    }

    private static ViewGroup.LayoutParams a(Context context, ViewGroup viewGroup, int i) {
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            i3 = layoutParams.width;
            i2 = layoutParams.height;
            if (i == 1) {
                i2 = (i3 * 16) / 9;
            } else {
                i3 = (i2 * 16) / 9;
            }
        } else if (i == 1) {
            i3 = context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
            i2 = (i3 * 16) / 9;
        } else {
            i2 = context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
            i3 = (i2 * 16) / 9;
        }
        return new ViewGroup.LayoutParams(i3, i2);
    }

    static /* synthetic */ void a(TapATSplashAdapter tapATSplashAdapter, Context context, Map map) {
        tapATSplashAdapter.f = ATInitMediation.getIntFromMap(map, TapATInitManager.ORIENTATION_KEY, 1);
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        tapATSplashAdapter.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadSplashAd(tapATSplashAdapter.a.getAdRequest(tapATSplashAdapter.c, map), tapATSplashAdapter.new AnonymousClass2());
    }

    static /* synthetic */ void e(TapATSplashAdapter tapATSplashAdapter) {
        if (tapATSplashAdapter.mImpressionListener != null) {
            tapATSplashAdapter.mImpressionListener.onSplashAdDismiss();
        }
    }

    static /* synthetic */ void g(TapATSplashAdapter tapATSplashAdapter) {
        if (tapATSplashAdapter.mImpressionListener != null) {
            tapATSplashAdapter.mImpressionListener.onSplashAdClicked();
        }
    }

    static /* synthetic */ void h(TapATSplashAdapter tapATSplashAdapter) {
        if (tapATSplashAdapter.mImpressionListener != null) {
            tapATSplashAdapter.mImpressionListener.onSplashAdShow();
        }
    }
}
