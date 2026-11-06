package com.tapsdk.tapad.group.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletDownloadConfirmFrameLayout extends FrameLayout {
    private DirichletNativeFeedAd ad;

    public DirichletDownloadConfirmFrameLayout(Context context) {
        super(context);
    }

    public void cancelDownload() {
        DirichletNativeFeedAd dirichletNativeFeedAd = this.ad;
        if (dirichletNativeFeedAd != null) {
            dirichletNativeFeedAd.cancelDownload();
        }
    }

    public void confirmDownload() {
        DirichletNativeFeedAd dirichletNativeFeedAd = this.ad;
        if (dirichletNativeFeedAd != null) {
            dirichletNativeFeedAd.confirmDownload();
        }
    }

    public void setAdData(DirichletNativeFeedAd dirichletNativeFeedAd) {
        this.ad = dirichletNativeFeedAd;
    }

    public DirichletDownloadConfirmFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DirichletDownloadConfirmFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DirichletDownloadConfirmFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
