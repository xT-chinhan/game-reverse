package com.byazt.lfg;

import com.byazt.cp.n;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 1652, 2352})
public class UGenTestToolsPage extends BaseToolPage {
    public boolean n;

    @Override // com.byazt.lfg.BaseToolPage
    public String getPageTitle() {
        return "UGen调试";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = true;
    }
}
