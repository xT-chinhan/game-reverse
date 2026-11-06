package com.anythink.nativead.api;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.core.common.h.n;
import com.anythink.core.common.t.a;
import com.anythink.core.common.u.c;

/* JADX INFO: loaded from: classes.dex */
public class ATNativeAdView extends FrameLayout {
    private static final String TAG = "ATNativeAdView";
    View mAdView;
    NativeAd.ImpressionEventListener mImpressionEventListener;
    boolean mIsInWindow;
    NativeAd mNativeAd;
    int mNativeAdId;

    public ATNativeAdView(Context context) {
        super(context);
    }

    public ATNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void renderView(int i, View view, NativeAd.ImpressionEventListener impressionEventListener) {
        View view2 = this.mAdView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mAdView = view;
        this.mNativeAdId = i;
        this.mImpressionEventListener = impressionEventListener;
        addView(view);
        if (this.mIsInWindow && getVisibility() == 0) {
            callbackImpression();
        }
    }

    public synchronized void attachNativeAd(NativeAd nativeAd) {
        this.mNativeAd = nativeAd;
    }

    synchronized void clear() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            try {
                nativeAd.clear(this);
            } catch (Throwable unused) {
            }
            this.mNativeAd = null;
        }
    }

    public void clearImpressionListener(int i) {
        if (this.mNativeAdId == i) {
            this.mImpressionEventListener = null;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && getVisibility() == 0) {
            callbackImpression();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsInWindow = true;
        if (getVisibility() == 0) {
            callbackImpression();
        }
        if (isHardwareAccelerated()) {
            return;
        }
        Log.w(TAG, "Native ads of some video types may display abnormally, because this view is attached to a window that does not enable hardware acceleration.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsInWindow = false;
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || nativeAd.mBaseNativeAd == null) {
            return;
        }
        clearAdClickRecord(this.mNativeAd.mBaseNativeAd.getDetail());
    }

    private void callbackImpression() {
        NativeAd.ImpressionEventListener impressionEventListener = this.mImpressionEventListener;
        if (impressionEventListener != null) {
            impressionEventListener.onImpression();
        }
    }

    protected boolean isAttachInWindow() {
        return this.mIsInWindow;
    }

    public void destory() {
        this.mImpressionEventListener = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        n detail;
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null && nativeAd.mBaseNativeAd != null && (detail = this.mNativeAd.mBaseNativeAd.getDetail()) != null) {
            a.a(getContext(), motionEvent, detail);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void clearAdClickRecord(n nVar) {
        c.a().b().d(nVar);
    }
}
