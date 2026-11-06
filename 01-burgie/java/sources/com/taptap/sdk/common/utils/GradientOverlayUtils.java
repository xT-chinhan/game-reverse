package com.taptap.sdk.common.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: GradientOverlayUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bJ0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/common/utils/GradientOverlayUtils;", "", "()V", "addGradientOverlay", "", "imageView", "Landroid/widget/ImageView;", "color", "", "startAlpha", "", "endAlpha", "direction", "Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientDirection;", "cornerRadius", "createGradientDrawable", "Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientOverlayDrawable;", "removeGradientOverlay", "GradientDirection", "GradientOverlayDrawable", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GradientOverlayUtils {
    public static final GradientOverlayUtils INSTANCE = new GradientOverlayUtils();

    /* JADX INFO: compiled from: GradientOverlayUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientDirection;", "", "(Ljava/lang/String;I)V", "TOP_TO_BOTTOM", "BOTTOM_TO_TOP", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum GradientDirection {
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    private GradientOverlayUtils() {
    }

    public final void addGradientOverlay(ImageView imageView, int color, float startAlpha, float endAlpha, GradientDirection direction, int cornerRadius) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(direction, "direction");
        GradientOverlayDrawable gradientDrawable = createGradientDrawable(color, startAlpha, endAlpha, direction, cornerRadius);
        Drawable originalDrawable = imageView.getDrawable();
        if (originalDrawable != null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{originalDrawable, gradientDrawable});
            layerDrawable.setLayerInset(1, 0, 0, 0, 0);
            imageView.setImageDrawable(layerDrawable);
        } else {
            imageView.setBackground(gradientDrawable);
        }
        imageView.invalidate();
    }

    private final GradientOverlayDrawable createGradientDrawable(int color, float startAlpha, float endAlpha, GradientDirection direction, int cornerRadius) {
        return new GradientOverlayDrawable(color, startAlpha, endAlpha, direction, cornerRadius);
    }

    public final void removeGradientOverlay(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Drawable drawable = imageView.getDrawable();
        if ((drawable instanceof LayerDrawable) && ((LayerDrawable) drawable).getNumberOfLayers() > 1) {
            imageView.setImageDrawable(((LayerDrawable) drawable).getDrawable(0));
        } else {
            imageView.setBackground(null);
        }
        imageView.invalidate();
    }

    /* JADX INFO: compiled from: GradientOverlayUtils.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientOverlayDrawable;", "Landroid/graphics/drawable/Drawable;", "color", "", "startAlpha", "", "endAlpha", "direction", "Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientDirection;", "cornerRadius", "(IFFLcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientDirection;I)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "adjustAlpha", "alpha", MediationConstant.RIT_TYPE_DRAW, "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class GradientOverlayDrawable extends Drawable {
        private final int color;
        private final int cornerRadius;
        private final GradientDirection direction;
        private final float endAlpha;
        private final Paint paint;
        private final Path path;
        private final RectF rectF;
        private final float startAlpha;

        /* JADX INFO: compiled from: GradientOverlayUtils.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GradientDirection.values().length];
                try {
                    iArr[GradientDirection.TOP_TO_BOTTOM.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[GradientDirection.BOTTOM_TO_TOP.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[GradientDirection.LEFT_TO_RIGHT.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[GradientDirection.RIGHT_TO_LEFT.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public GradientOverlayDrawable(int color, float startAlpha, float endAlpha, GradientDirection direction, int cornerRadius) {
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.color = color;
            this.startAlpha = startAlpha;
            this.endAlpha = endAlpha;
            this.direction = direction;
            this.cornerRadius = cornerRadius;
            Paint $this$paint_u24lambda_u240 = new Paint();
            $this$paint_u24lambda_u240.setAntiAlias(true);
            $this$paint_u24lambda_u240.setStyle(Paint.Style.FILL);
            this.paint = $this$paint_u24lambda_u240;
            this.path = new Path();
            this.rectF = new RectF();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            LinearGradient linearGradient;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
            if (bounds.isEmpty()) {
                return;
            }
            int startColor = adjustAlpha(this.color, this.startAlpha);
            int endColor = adjustAlpha(this.color, this.endAlpha);
            switch (WhenMappings.$EnumSwitchMapping$0[this.direction.ordinal()]) {
                case 1:
                    linearGradient = new LinearGradient(bounds.left, bounds.top, bounds.left, bounds.bottom, startColor, endColor, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    linearGradient = new LinearGradient(bounds.left, bounds.bottom, bounds.left, bounds.top, startColor, endColor, Shader.TileMode.CLAMP);
                    break;
                case 3:
                    linearGradient = new LinearGradient(bounds.left, bounds.top, bounds.right, bounds.top, startColor, endColor, Shader.TileMode.CLAMP);
                    break;
                case 4:
                    linearGradient = new LinearGradient(bounds.right, bounds.top, bounds.left, bounds.top, startColor, endColor, Shader.TileMode.CLAMP);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            LinearGradient gradient = linearGradient;
            this.paint.setShader(gradient);
            if (this.cornerRadius <= 0) {
                canvas.drawRect(bounds, this.paint);
                return;
            }
            this.rectF.set(bounds);
            this.path.reset();
            int i = this.cornerRadius;
            float[] radii = {i, i, i, i, 0.0f, 0.0f, 0.0f, 0.0f};
            this.path.addRoundRect(this.rectF, radii, Path.Direction.CW);
            this.path.close();
            canvas.drawPath(this.path, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.paint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        private final int adjustAlpha(int color, float alpha) {
            int alphaInt = RangesKt.coerceIn((int) (255 * alpha), 0, 255);
            int rgbColor = 16777215 & color;
            return (alphaInt << 24) | rgbColor;
        }
    }
}
