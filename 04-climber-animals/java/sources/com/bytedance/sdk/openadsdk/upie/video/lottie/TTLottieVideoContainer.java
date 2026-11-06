package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class TTLottieVideoContainer extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.renderview.xr.ms f4238ms;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public View getView() {
        return this;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(com.bykv.vk.openvk.component.video.api.renderview.ms msVar) {
    }

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.bykv.vk.openvk.component.video.api.renderview.xr.ms msVar) {
        this.f4238ms = msVar;
    }
}
