package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class VideoSurfaceView extends SurfaceView {
    private static final String TAG = "VideoSurfaceView";
    private int videoHeight;
    private int videoWidth;

    public VideoSurfaceView(Context context) {
        super(context);
        this.videoWidth = 0;
        this.videoHeight = 0;
        init();
    }

    private void init() {
        SurfaceHolder holder = getHolder();
        holder.setType(3);
        holder.setFormat(2);
        setZOrderOnTop(false);
        setKeepScreenOn(true);
    }

    private void updateGravity() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 17;
            setLayoutParams(layoutParams2);
        }
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

    @Override // android.view.SurfaceView, android.view.View
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
        float f2 = size;
        float f3 = size2;
        if (f > f2 / f3) {
            size2 = (int) (f2 / f);
        } else {
            size = (int) (f3 * f);
        }
        setMeasuredDimension(size, size2);
    }

    public void setVideoSize(int i, int i2) {
        if (this.videoWidth == i && this.videoHeight == i2) {
            return;
        }
        this.videoWidth = i;
        this.videoHeight = i2;
        if (i > 0 && i2 > 0) {
            getHolder().setFixedSize(i, i2);
            updateGravity();
        }
        requestLayout();
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoWidth = 0;
        this.videoHeight = 0;
        init();
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoWidth = 0;
        this.videoHeight = 0;
        init();
    }
}
