package com.anythink.network.baidu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATNativeExpressFeedAd extends CustomNativeAd {
    public static final String TAG = "BaiduATNativeExpressFeedAd";
    private final Context a;
    private final ExpressResponse b;
    private RenderCallback c;
    private FrameLayout d;
    private Map<String, Object> e;

    public interface RenderCallback {
        void onAdRenderFail();

        void onAdRenderSuccess(CustomNativeAd customNativeAd);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return true;
    }

    public BaiduATNativeExpressFeedAd(Context context, ExpressResponse expressResponse, int i, int i2, boolean z) {
        this.a = context;
        this.b = expressResponse;
        if (i > 0 && i2 > 0) {
            expressResponse.setExpectedSizePixel(i, i2);
        }
        this.d = new FrameLayout(context);
        int adActionType = expressResponse.getAdActionType();
        int i3 = 2;
        if (adActionType != 1) {
            if (adActionType != 2) {
                i3 = 3;
                if (adActionType != 3) {
                    i3 = 0;
                }
            } else {
                i3 = 1;
            }
        }
        setNativeInteractionType(i3);
        if (z) {
            if (this.e == null) {
                this.e = new HashMap();
            }
            this.e.put(BaiduATConst.EN_P_KEY, expressResponse.getPECPM());
            setNetworkInfoMap(this.e);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        ExpressResponse expressResponse = this.b;
        if (expressResponse == null) {
            return;
        }
        expressResponse.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.anythink.network.baidu.BaiduATNativeExpressFeedAd.1
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
            public final void onDislikeWindowClose() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
            public final void onDislikeWindowShow() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
            public final void onDislikeItemClick(String str) {
                String str2 = BaiduATNativeExpressFeedAd.TAG;
                BaiduATNativeExpressFeedAd.this.notifyAdDislikeClick();
            }
        });
        this.b.setAdCloseListener(new ExpressResponse.ExpressCloseListener() { // from class: com.anythink.network.baidu.BaiduATNativeExpressFeedAd.2
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressCloseListener
            public final void onAdClose(ExpressResponse expressResponse2) {
                String str = BaiduATNativeExpressFeedAd.TAG;
                BaiduATNativeExpressFeedAd.this.notifyAdDislikeClick();
            }
        });
        View expressAdView = this.b.getExpressAdView();
        if (this.d == null) {
            this.d = new FrameLayout(this.a);
        }
        if (this.d.getChildCount() > 0) {
            this.d.removeAllViews();
        }
        if (expressAdView != null) {
            ViewParent parent = expressAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(expressAdView);
            }
            this.d.addView(expressAdView);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.d = null;
        }
    }

    public void startRender() {
        ExpressResponse expressResponse = this.b;
        if (expressResponse != null) {
            expressResponse.setInteractionListener(new AnonymousClass3());
            expressResponse.setAdDislikeListener(new AnonymousClass4());
            expressResponse.render();
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$3, reason: invalid class name */
    final class AnonymousClass3 implements ExpressResponse.ExpressInteractionListener {
        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdUnionClick() {
        }

        AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdClick() {
            BaiduATNativeExpressFeedAd.this.notifyAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdExposed() {
            BaiduATNativeExpressFeedAd.this.notifyAdImpression();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderFail(View view, String str, int i) {
            if (BaiduATNativeExpressFeedAd.this.c != null) {
                BaiduATNativeExpressFeedAd.this.c.onAdRenderFail();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderSuccess(View view, float f, float f2) {
            if (BaiduATNativeExpressFeedAd.this.c != null) {
                BaiduATNativeExpressFeedAd.this.c.onAdRenderSuccess(BaiduATNativeExpressFeedAd.this);
            }
        }
    }

    private void a(ExpressResponse expressResponse) {
        if (expressResponse == null) {
            return;
        }
        expressResponse.setInteractionListener(new AnonymousClass3());
        expressResponse.setAdDislikeListener(new AnonymousClass4());
        expressResponse.render();
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$4, reason: invalid class name */
    final class AnonymousClass4 implements ExpressResponse.ExpressDislikeListener {
        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowShow() {
        }

        AnonymousClass4() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeItemClick(String str) {
            BaiduATNativeExpressFeedAd.this.notifyAdDislikeClick();
        }
    }

    public void setRenderCallback(RenderCallback renderCallback) {
        this.c = renderCallback;
    }
}
