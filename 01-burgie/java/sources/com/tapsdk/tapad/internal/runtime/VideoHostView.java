package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoHostView extends FrameLayout {
    private Bitmap frozenTextureFrame;
    private int generation;
    private boolean pendingRecover;
    private boolean released;
    private View renderView;
    private SurfaceHolder.Callback surfaceCallback;
    private SurfaceListener surfaceListener;
    private VideoTextureView.SurfaceReadyCallback textureCallback;
    private final boolean useTextureView;
    private int videoHeight;
    private int videoWidth;

    public interface SurfaceListener {
        boolean onFrameAvailable(int i);

        void onHostAttached(int i);

        void onHostDetached(int i);

        void onHostVisible(int i);

        void onSurfaceHolderReady(int i, SurfaceHolder surfaceHolder);

        void onSurfaceLost(int i);

        void onSurfaceReady(int i, Surface surface);
    }

    public VideoHostView(Context context, boolean z) {
        super(context);
        this.generation = 1;
        this.useTextureView = z;
        setClipChildren(false);
        setClipToPadding(false);
        resetFirstFrameVisibility();
        createRenderView();
    }

    private void applyVideoSize(View view) {
        if (view instanceof VideoSurfaceView) {
            ((VideoSurfaceView) view).setVideoSize(this.videoWidth, this.videoHeight);
        } else if (view instanceof VideoTextureView) {
            ((VideoTextureView) view).setVideoSize(this.videoWidth, this.videoHeight);
        }
    }

    private void clearFrozenTextureFrame() {
        setBackground(null);
        Bitmap bitmap = this.frozenTextureFrame;
        if (bitmap != null) {
            bitmap.recycle();
            this.frozenTextureFrame = null;
        }
    }

    private void clearRenderView() {
        View view = this.renderView;
        if (view == null) {
            return;
        }
        if ((view instanceof VideoSurfaceView) && this.surfaceCallback != null) {
            ((VideoSurfaceView) view).getHolder().removeCallback(this.surfaceCallback);
        } else if (view instanceof VideoTextureView) {
            VideoTextureView videoTextureView = (VideoTextureView) view;
            videoTextureView.setSurfaceReadyCallback(null);
            videoTextureView.setSurfaceTextureListener(null);
            videoTextureView.releaseSurface();
        }
        this.surfaceCallback = null;
        this.textureCallback = null;
        removeView(view);
        this.renderView = null;
    }

    private void createRenderView() {
        if (this.released || this.renderView != null) {
            return;
        }
        if (this.useTextureView) {
            VideoTextureView videoTextureView = new VideoTextureView(getContext());
            videoTextureView.setAlpha(0.0f);
            final int i = this.generation;
            VideoTextureView.SurfaceReadyCallback surfaceReadyCallback = new VideoTextureView.SurfaceReadyCallback() { // from class: com.tapsdk.tapad.internal.runtime.VideoHostView.1
                @Override // com.tapsdk.tapad.internal.runtime.VideoTextureView.SurfaceReadyCallback
                public boolean onFrameAvailable() {
                    SurfaceListener surfaceListener = VideoHostView.this.surfaceListener;
                    if (surfaceListener == null || VideoHostView.this.released || i != VideoHostView.this.generation) {
                        return true;
                    }
                    return surfaceListener.onFrameAvailable(i);
                }

                @Override // com.tapsdk.tapad.internal.runtime.VideoTextureView.SurfaceReadyCallback
                public void onSurfaceDestroyed() {
                    SurfaceListener surfaceListener = VideoHostView.this.surfaceListener;
                    if (surfaceListener == null || VideoHostView.this.released || i != VideoHostView.this.generation) {
                        return;
                    }
                    surfaceListener.onSurfaceLost(i);
                }

                @Override // com.tapsdk.tapad.internal.runtime.VideoTextureView.SurfaceReadyCallback
                public void onSurfaceReady(Surface surface) {
                    SurfaceListener surfaceListener = VideoHostView.this.surfaceListener;
                    if (surfaceListener == null || VideoHostView.this.released || i != VideoHostView.this.generation) {
                        return;
                    }
                    surfaceListener.onSurfaceReady(i, surface);
                }
            };
            this.textureCallback = surfaceReadyCallback;
            videoTextureView.setSurfaceReadyCallback(surfaceReadyCallback);
            this.renderView = videoTextureView;
        } else {
            VideoSurfaceView videoSurfaceView = new VideoSurfaceView(getContext());
            final int i2 = this.generation;
            this.surfaceCallback = new SurfaceHolder.Callback() { // from class: com.tapsdk.tapad.internal.runtime.VideoHostView.2
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    SurfaceListener surfaceListener = VideoHostView.this.surfaceListener;
                    if (surfaceListener == null || VideoHostView.this.released || i2 != VideoHostView.this.generation) {
                        return;
                    }
                    surfaceListener.onSurfaceHolderReady(i2, surfaceHolder);
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    SurfaceListener surfaceListener = VideoHostView.this.surfaceListener;
                    if (surfaceListener == null || VideoHostView.this.released || i2 != VideoHostView.this.generation) {
                        return;
                    }
                    surfaceListener.onSurfaceLost(i2);
                }
            };
            videoSurfaceView.getHolder().addCallback(this.surfaceCallback);
            this.renderView = videoSurfaceView;
        }
        this.renderView.setClickable(false);
        applyVideoSize(this.renderView);
        addView(this.renderView, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void freezeCurrentTextureFrame(VideoTextureView videoTextureView) {
        if (videoTextureView.getAlpha() <= 0.0f || !videoTextureView.isAvailable() || videoTextureView.getWidth() <= 0 || videoTextureView.getHeight() <= 0) {
            return;
        }
        try {
            Bitmap bitmap = videoTextureView.getBitmap();
            if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                clearFrozenTextureFrame();
                this.frozenTextureFrame = bitmap;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
                bitmapDrawable.setGravity(119);
                setBackground(bitmapDrawable);
                return;
            }
            if (bitmap != null) {
                bitmap.recycle();
            }
        } catch (RuntimeException e) {
        }
    }

    private void recreateRenderView() {
        clearRenderView();
        this.generation++;
        createRenderView();
    }

    public int getGeneration() {
        return this.generation;
    }

    public boolean isSurfaceRecoveryReady() {
        return !this.released && isAttachedToWindow() && getWindowVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.released) {
            return;
        }
        if (this.renderView == null) {
            createRenderView();
        }
        SurfaceListener surfaceListener = this.surfaceListener;
        if (surfaceListener != null) {
            surfaceListener.onHostAttached(this.generation);
        }
        if (this.pendingRecover) {
            post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoHostView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.recoverSurface();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        SurfaceListener surfaceListener = this.surfaceListener;
        if (surfaceListener != null && !this.released) {
            surfaceListener.onHostDetached(this.generation);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        SurfaceListener surfaceListener;
        super.onWindowVisibilityChanged(i);
        if (i == 0 && isSurfaceRecoveryReady() && (surfaceListener = this.surfaceListener) != null) {
            surfaceListener.onHostVisible(this.generation);
        }
    }

    public void recoverSurface() {
        if (this.released || this.useTextureView) {
            return;
        }
        if (!isAttachedToWindow()) {
            this.pendingRecover = true;
        } else {
            this.pendingRecover = false;
            recreateRenderView();
        }
    }

    public void release() {
        this.released = true;
        this.pendingRecover = false;
        this.surfaceListener = null;
        clearFrozenTextureFrame();
        clearRenderView();
    }

    public void resetFirstFrameVisibility() {
        if (this.useTextureView) {
            View view = this.renderView;
            if (view instanceof VideoTextureView) {
                VideoTextureView videoTextureView = (VideoTextureView) view;
                freezeCurrentTextureFrame(videoTextureView);
                videoTextureView.setAlpha(0.0f);
                videoTextureView.resetFirstFrameSignal();
            }
        }
    }

    public void revealFirstFrame() {
        if (this.useTextureView) {
            View view = this.renderView;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            clearFrozenTextureFrame();
        }
    }

    public void setSurfaceListener(SurfaceListener surfaceListener) {
        this.surfaceListener = surfaceListener;
    }

    public void setVideoSize(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
        applyVideoSize(this.renderView);
    }
}
