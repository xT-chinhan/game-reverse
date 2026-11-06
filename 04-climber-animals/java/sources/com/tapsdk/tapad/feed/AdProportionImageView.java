package com.tapsdk.tapad.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tapsdk.tapad.R;

/* JADX INFO: loaded from: classes3.dex */
public class AdProportionImageView extends ImageView {
    private int a;
    private int b;

    public AdProportionImageView(Context context) {
        super(context);
        this.a = 16;
        this.b = 9;
    }

    public AdProportionImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 16;
        this.b = 9;
        a(attributeSet);
    }

    public AdProportionImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 16;
        this.b = 9;
        a(attributeSet);
    }

    public AdProportionImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = 16;
        this.b = 9;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.tapad_AdProportionImageView);
            this.a = typedArrayObtainStyledAttributes.getInt(R.styleable.tapad_AdProportionImageView_tapad_image_aspectRatioWidth, 16);
            this.b = typedArrayObtainStyledAttributes.getInt(R.styleable.tapad_AdProportionImageView_tapad_image_aspectRatioHeight, 9);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (i2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec((size * this.b) / this.a, mode);
        }
        if (i == 0) {
            i = View.MeasureSpec.makeMeasureSpec((size2 * this.a) / this.b, mode2);
        }
        super.onMeasure(i, i2);
    }
}
