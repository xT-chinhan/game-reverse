package com.anythink.splashad.unitgroup.api;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomSplashEyeAd implements IATSplashEyeAd {
    protected ATSplashEyeAdListener mATSplashEyeAdListener;
    protected ATBaseAdAdapter mAtBaseAdAdapter;
    protected ViewGroup mEyeAdContainer;
    protected View mSplashView;

    public abstract void customResourceDestory();

    protected abstract void show(Context context, Rect rect);

    public CustomSplashEyeAd(ATBaseAdAdapter aTBaseAdAdapter) {
        this.mAtBaseAdAdapter = aTBaseAdAdapter;
    }

    public void setSplashView(View view) {
        this.mSplashView = view;
    }

    public ATSplashEyeAdListener getSplashEyeAdListener() {
        return this.mATSplashEyeAdListener;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public final void show(Context context, Rect rect, ATSplashEyeAdListener aTSplashEyeAdListener) {
        this.mATSplashEyeAdListener = aTSplashEyeAdListener;
        show(context, rect);
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void setEyeAdContainer(ViewGroup viewGroup) {
        this.mEyeAdContainer = viewGroup;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public final void destroy() {
        try {
            ATBaseAdAdapter aTBaseAdAdapter = this.mAtBaseAdAdapter;
            if (aTBaseAdAdapter != null) {
                if (aTBaseAdAdapter instanceof CustomSplashAdapter) {
                    ((CustomSplashAdapter) aTBaseAdAdapter).cleanImpressionListener();
                }
                this.mAtBaseAdAdapter.internalDestroy();
                this.mAtBaseAdAdapter = null;
            }
            this.mATSplashEyeAdListener = null;
            View view = this.mSplashView;
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) this.mSplashView.getParent()).removeView(this.mSplashView);
                }
                this.mSplashView = null;
            }
            ViewGroup viewGroup = this.mEyeAdContainer;
            if (viewGroup != null) {
                if (viewGroup.getParent() != null) {
                    ((ViewGroup) this.mEyeAdContainer.getParent()).removeView(this.mEyeAdContainer);
                }
                this.mEyeAdContainer = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            customResourceDestory();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
