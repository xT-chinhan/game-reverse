package com.tapsdk.tapad.internal.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.utils.TapADLogger;

/* JADX INFO: loaded from: classes3.dex */
public class PortraitSplashFixedAspectRatioFrameLayout extends FrameLayout {
    private int mAspectRatioHeight;
    private int mAspectRatioWidth;

    public PortraitSplashFixedAspectRatioFrameLayout(Context context) {
        super(context);
    }

    public PortraitSplashFixedAspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PortraitSplashFixedAspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.tapad_FixedAspectRatioFrameLayout);
        this.mAspectRatioWidth = typedArrayObtainStyledAttributes.getInt(R.styleable.tapad_FixedAspectRatioFrameLayout_tapad_aspectRatioWidth, 4);
        this.mAspectRatioHeight = typedArrayObtainStyledAttributes.getInt(R.styleable.tapad_FixedAspectRatioFrameLayout_tapad_aspectRatioHeight, 3);
        TapADLogger.d("aspect ratio:(" + this.mAspectRatioWidth + "," + this.mAspectRatioHeight + ")");
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.mAspectRatioHeight;
        int i4 = (size * i3) / this.mAspectRatioWidth;
        if (i4 <= size2 || i4 <= i3) {
            i3 = i4;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public void resetExpectedSize(int i, int i2) {
        this.mAspectRatioWidth = i;
        this.mAspectRatioHeight = i2;
        requestLayout();
    }
}
