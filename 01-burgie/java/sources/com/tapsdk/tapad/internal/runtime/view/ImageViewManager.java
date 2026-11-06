package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;

/* JADX INFO: loaded from: classes3.dex */
public class ImageViewManager extends BaseViewManager<ImageView, ImageViewProps> {
    public static final String NAME = "image";
    public static final String SCALE_TYPE_CENTER_CROP = "centerCrop";
    public static final String SCALE_TYPE_CENTER_INSIDE = "centerInside";
    public static final String SCALE_TYPE_FILL_WIDTH_TOP_CROP = "fillWidthTopCrop";
    public static final String SCALE_TYPE_FIT_CENTER = "fitCenter";
    public static final String SCALE_TYPE_FIT_XY = "fitXY";
    public static final int VIEW_TYPE = 2;
    private final float mDensity;

    public static class FillWidthImageView extends ImageView {
        public FillWidthImageView(Context context) {
            super(context);
        }

        private void applyFillWidthMatrix() {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return;
            }
            int width = getWidth();
            int height = getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (width <= 0 || height <= 0 || intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return;
            }
            float f = width / intrinsicWidth;
            float f2 = intrinsicHeight * f;
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            float f3 = height;
            if (f2 < f3 && intrinsicWidth >= intrinsicHeight) {
                matrix.postTranslate(0.0f, (f3 - f2) / 2.0f);
            }
            setImageMatrix(matrix);
        }

        @Override // android.widget.ImageView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            MechanicalImageLoader.onImageDrawn(this);
        }

        @Override // android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (getScaleType() == ImageView.ScaleType.MATRIX) {
                applyFillWidthMatrix();
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (getScaleType() == ImageView.ScaleType.MATRIX) {
                applyFillWidthMatrix();
            }
        }

        @Override // android.widget.ImageView
        public void setImageDrawable(Drawable drawable) {
            super.setImageDrawable(drawable);
            if (getScaleType() == ImageView.ScaleType.MATRIX) {
                applyFillWidthMatrix();
            }
        }
    }

    public ImageViewManager(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0042  */
    private void applyScaleType(ImageView imageView, String str) {
        str.getClass();
        switch (str) {
            case "centerInside":
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case "fitXY":
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case "fitCenter":
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "fillWidthTopCrop":
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                break;
            case "centerCrop":
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            default:
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
        }
    }

    private void applyTintColor(ImageView imageView, String str) {
        if (str == null || str.isEmpty()) {
            imageView.clearColorFilter();
        } else {
            imageView.setColorFilter(parseColor(str), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public String getName() {
        return NAME;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public Class<ImageViewProps> getPropsClass() {
        return ImageViewProps.class;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public int getViewType() {
        return 2;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public ImageView createView(Context context, String str) {
        FillWidthImageView fillWidthImageView = new FillWidthImageView(context);
        fillWidthImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return fillWidthImageView;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void setStyle(ImageView imageView, String str, String str2) {
        if (applyBaseStyle(imageView, str, str2, this.mDensity)) {
            return;
        }
        str.getClass();
        if (str.equals("scaleType")) {
            applyScaleType(imageView, str2);
        } else if (str.equals("tintColor")) {
            applyTintColor(imageView, str2);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void updateProps(ImageView imageView, ImageViewProps imageViewProps) {
        if (imageViewProps == null) {
            return;
        }
        applyBaseProps(imageView, imageViewProps, this.mDensity);
        String str = imageViewProps.scaleType;
        if (str != null) {
            applyScaleType(imageView, str);
        }
        String str2 = imageViewProps.tintColor;
        if (str2 != null) {
            applyTintColor(imageView, str2);
        }
    }
}
