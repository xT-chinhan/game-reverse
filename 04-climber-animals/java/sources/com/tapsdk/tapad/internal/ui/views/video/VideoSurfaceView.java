package com.tapsdk.tapad.internal.ui.views.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import com.tapsdk.tapad.internal.utils.TapADLogger;

/* JADX INFO: loaded from: classes3.dex */
public class VideoSurfaceView extends SurfaceView {
    private int videoHeight;
    private int videoWidth;

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoWidth = 0;
        this.videoHeight = 0;
    }

    public void adjustSize(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
        getHolder().setFixedSize(i, i2);
        requestLayout();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        String str;
        int defaultSize = SurfaceView.getDefaultSize(this.videoWidth, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.videoHeight, i2);
        if (this.videoWidth > 0 && this.videoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                TapADLogger.d("origin width:" + size2 + "," + size);
                int i4 = this.videoWidth;
                int i5 = i4 * size2;
                int i6 = this.videoHeight;
                if (i5 < size * i6) {
                    size = (int) (((size2 * 1.0f) * i4) / i6);
                } else {
                    size2 = (int) (((size * 1.0f) * i6) / i4);
                }
                defaultSize = size;
                defaultSize2 = size2;
                TapADLogger.d("condition1 video width & video height wrap content:" + this.videoHeight + "," + this.videoWidth);
                str = "condition1 width & height wrap content:" + defaultSize2 + "," + defaultSize;
            } else if (mode == 1073741824) {
                int i7 = (int) (((this.videoHeight * size) * 1.0f) / this.videoWidth);
                defaultSize2 = (mode2 != Integer.MIN_VALUE || i7 <= size2) ? i7 : size2;
                TapADLogger.d("condition2 width match parent & height wrap content:" + defaultSize2 + "," + size);
                defaultSize = size;
            } else if (mode2 == 1073741824) {
                int i8 = (int) (((this.videoWidth * size2) * 1.0f) / this.videoHeight);
                defaultSize = (mode != Integer.MIN_VALUE || i8 <= size) ? i8 : size;
                TapADLogger.d("condition3 height match parent & width wrap content:" + size2 + "," + defaultSize);
                defaultSize2 = size2;
            } else {
                int i9 = this.videoWidth;
                int i10 = this.videoHeight;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    i3 = i9;
                    size2 = i10;
                } else {
                    i3 = (int) (((size2 * i9) * 1.0f) / i10);
                }
                if (mode != Integer.MIN_VALUE || i3 <= size) {
                    defaultSize = i3;
                } else {
                    size2 = (int) (((i10 * size) * 1.0f) / i9);
                    defaultSize = size;
                }
                defaultSize2 = size2;
                str = "condition4 width & height wrap content";
            }
            TapADLogger.d(str);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }
}
