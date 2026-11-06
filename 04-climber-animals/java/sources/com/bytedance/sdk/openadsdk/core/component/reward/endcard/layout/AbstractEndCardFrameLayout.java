package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.xr.xr;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractEndCardFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final TTBaseVideoActivity f2171ms;
    protected final lm xr;

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    abstract void ms();

    public abstract void setClickListener(xr xrVar);

    public void xr() {
    }

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity);
        this.f2171ms = tTBaseVideoActivity;
        this.xr = lmVar;
        ms();
    }
}
