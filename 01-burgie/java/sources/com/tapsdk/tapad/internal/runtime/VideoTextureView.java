package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class VideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final String TAG = "VideoTextureView";
    private boolean mFirstFrameUpdated;
    private Surface mSurface;
    private SurfaceReadyCallback mSurfaceReadyCallback;
    private int videoHeight;
    private int videoWidth;

    public interface SurfaceReadyCallback {
        boolean onFrameAvailable();

        void onSurfaceDestroyed();

        void onSurfaceReady(Surface surface);
    }

    public VideoTextureView(Context context) {
        super(context);
        this.videoWidth = 0;
        this.videoHeight = 0;
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        setKeepScreenOn(true);
    }

    private void updateGravity() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.videoHeight > this.videoWidth ? 49 : 17;
            setLayoutParams(layoutParams2);
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public boolean hasVideoSize() {
        return this.videoWidth > 0 && this.videoHeight > 0;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.videoWidth;
        if (i4 <= 0 || (i3 = this.videoHeight) <= 0 || size <= 0 || size2 <= 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        float f = i4 / i3;
        if (size2 > size) {
            size2 = (int) (size / f);
        } else {
            size = (int) (size2 * f);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mFirstFrameUpdated = false;
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        SurfaceReadyCallback surfaceReadyCallback = this.mSurfaceReadyCallback;
        if (surfaceReadyCallback != null) {
            surfaceReadyCallback.onSurfaceReady(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        SurfaceReadyCallback surfaceReadyCallback = this.mSurfaceReadyCallback;
        if (surfaceReadyCallback != null) {
            surfaceReadyCallback.onSurfaceDestroyed();
        }
        releaseSurface();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        SurfaceReadyCallback surfaceReadyCallback;
        if (this.mFirstFrameUpdated || (surfaceReadyCallback = this.mSurfaceReadyCallback) == null) {
            return;
        }
        this.mFirstFrameUpdated = surfaceReadyCallback.onFrameAvailable();
    }

    public void releaseSurface() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    public void resetFirstFrameSignal() {
        this.mFirstFrameUpdated = false;
    }

    public void setSurfaceReadyCallback(SurfaceReadyCallback surfaceReadyCallback) {
        this.mSurfaceReadyCallback = surfaceReadyCallback;
        Surface surface = this.mSurface;
        if (surface == null || surfaceReadyCallback == null) {
            return;
        }
        surfaceReadyCallback.onSurfaceReady(surface);
    }

    public void setVideoSize(int i, int i2) {
        if (this.videoWidth == i && this.videoHeight == i2) {
            return;
        }
        this.videoWidth = i;
        this.videoHeight = i2;
        if (i > 0 && i2 > 0) {
            updateGravity();
        }
        requestLayout();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoWidth = 0;
        this.videoHeight = 0;
        init();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoWidth = 0;
        this.videoHeight = 0;
        init();
    }
}
