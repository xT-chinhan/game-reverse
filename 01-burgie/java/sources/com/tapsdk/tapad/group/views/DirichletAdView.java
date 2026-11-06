package com.tapsdk.tapad.group.views;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.AdNetworkType;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletAdView extends FrameLayout {
    private AdNetworkType adNetworkType;
    private String adType;
    private View contentView;
    private String instanceId;
    private boolean isInitialized;

    public DirichletAdView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
        setBackgroundColor(Color.parseColor("#00000000"));
        this.isInitialized = true;
        this.instanceId = "dirichlet_ad_" + System.currentTimeMillis() + "_" + hashCode();
    }

    public void destroy() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (this.contentView != null) {
            removeAllViews();
            this.contentView = null;
        }
        this.adType = null;
        this.adNetworkType = null;
        this.isInitialized = false;
    }

    public String getAdType() {
        String str = this.adType;
        return str != null ? str : "unknown";
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i) {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("android.") || className.startsWith("com.android.") || className.contains("webkit") || className.contains("WebView") || className.contains("chromium") || className.contains("LayoutManager") || className.contains("RecyclerView") || className.startsWith("com.tapsdk.tapad.") || className.contains("bytedance") || className.contains("qq.e") || stackTraceElement.getMethodName().equals("onMeasure") || stackTraceElement.getMethodName().equals("onLayout") || stackTraceElement.getMethodName().equals("dispatchDraw") || stackTraceElement.getMethodName().equals(MediationConstant.RIT_TYPE_DRAW)) {
                return super.getChildAt(i);
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("android.") || className.startsWith("com.android.") || className.contains("webkit") || className.contains("WebView") || className.contains("chromium") || className.contains("LayoutManager") || className.contains("RecyclerView") || className.startsWith("com.tapsdk.tapad.") || className.contains("bytedance") || className.contains("qq.e") || stackTraceElement.getMethodName().equals("onMeasure") || stackTraceElement.getMethodName().equals("onLayout") || stackTraceElement.getMethodName().equals("dispatchDraw") || stackTraceElement.getMethodName().equals(MediationConstant.RIT_TYPE_DRAW)) {
                return super.getChildCount();
            }
        }
        return 0;
    }

    public int[] getContentSize() {
        View view = this.contentView;
        return view != null ? new int[]{view.getWidth(), this.contentView.getHeight()} : new int[]{0, 0};
    }

    public String getDebugInfo() {
        return "DirichletAdView Debug Info:\n- Instance ID: " + this.instanceId + "\n- Ad Type: " + getAdType() + "\n- Ad Network Type: " + this.adNetworkType + "\n- Initialized: " + this.isInitialized + "\n- Has Content: " + hasValidContent() + "\n- Size: " + getWidth() + "x" + getHeight() + "\n- Content Size: " + Arrays.toString(getContentSize());
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public boolean hasValidContent() {
        return this.contentView != null && this.isInitialized;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public synchronized void setAdContent(View view, String str, AdNetworkType adNetworkType) {
        if (!this.isInitialized) {
            throw new IllegalStateException("DirichletAdView not initialized");
        }
        this.adNetworkType = adNetworkType;
        removeAllViews();
        this.contentView = view;
        if (str == null) {
            str = "unknown";
        }
        this.adType = str;
        if (view != null) {
            addView(view, view.getLayoutParams() instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) view.getLayoutParams() : new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.view.View
    public String toString() {
        return "DirichletAdView{adType='" + getAdType() + "', adNetworkType=" + this.adNetworkType + ", instanceId='" + this.instanceId + "', size=" + getWidth() + "x" + getHeight() + ", hasContent=" + hasValidContent() + AbstractJsonLexerKt.END_OBJ;
    }

    public synchronized void setAdContent(View view, String str, AdNetworkType adNetworkType, int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.isInitialized) {
            this.adNetworkType = adNetworkType;
            removeAllViews();
            this.contentView = view;
            if (str == null) {
                str = "unknown";
            }
            this.adType = str;
            if (view != null) {
                if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                } else {
                    layoutParams = new FrameLayout.LayoutParams(i, i2);
                }
                addView(view, layoutParams);
            }
        } else {
            throw new IllegalStateException("DirichletAdView not initialized");
        }
    }
}
