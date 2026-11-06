package com.bytedance.sdk.openadsdk.tools.floatwindow.page;

/* JADX INFO: loaded from: classes2.dex */
public class UGenTestToolsPage extends BaseToolPage {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f4123ms;

    @Override // com.bytedance.sdk.openadsdk.tools.floatwindow.page.BaseToolPage
    public String getPageTitle() {
        return "UGen调试";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4123ms = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4123ms = true;
    }
}
