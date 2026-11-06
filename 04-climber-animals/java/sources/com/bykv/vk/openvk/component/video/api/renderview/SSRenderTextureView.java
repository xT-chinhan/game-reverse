package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f25ms;
    private xr.ms xr;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(ms msVar) {
        this.f25ms = msVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            sl.ms(th);
            if (com.bykv.vk.openvk.component.video.api.c.ah.xr()) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        ms msVar = this.f25ms;
        if (msVar != null) {
            msVar.ms(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        ms msVar = this.f25ms;
        if (msVar != null) {
            return msVar.ms(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(xr.ms msVar) {
        this.xr = msVar;
    }
}
