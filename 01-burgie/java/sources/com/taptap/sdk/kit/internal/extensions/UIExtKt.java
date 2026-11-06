package com.taptap.sdk.kit.internal.extensions;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.taptap.sdk.kit.internal.TapTapKit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a2\u0010\u000b\u001a\u00020\t*\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r\u001a\f\u0010\u0011\u001a\u00020\t*\u0004\u0018\u00010\n\u001a\f\u0010\u0012\u001a\u00020\t*\u0004\u0018\u00010\n\u001a\f\u0010\u0013\u001a\u00020\u0006*\u0004\u0018\u00010\n\u001a(\u0010\u0014\u001a\u00020\t*\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\u0018\u001a\n\u0010\u0019\u001a\u00020\r*\u00020\r\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\r\u001a\f\u0010\u001b\u001a\u00020\t*\u0004\u0018\u00010\n¨\u0006\u001c"}, d2 = {"getColorRes", "", "res", "getThemeText", "", "isDarkMode", "", "isLandscape", "applyCircleOutline", "", "Landroid/view/View;", "applyCustomRoundedCorners", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "gone", "invisible", "isVisible", "setDebounceClickListener", "debounceInterval", "", "listenerBlock", "Lkotlin/Function1;", "toDp", "toPx", "visible", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UIExtKt {
    public static final void visible(View $this$visible) {
        if ($this$visible == null) {
            return;
        }
        $this$visible.setVisibility(0);
    }

    public static final void gone(View $this$gone) {
        if ($this$gone == null) {
            return;
        }
        $this$gone.setVisibility(8);
    }

    public static final void invisible(View $this$invisible) {
        if ($this$invisible == null) {
            return;
        }
        $this$invisible.setVisibility(4);
    }

    public static final boolean isVisible(View $this$isVisible) {
        return $this$isVisible != null && $this$isVisible.getVisibility() == 0;
    }

    public static final int toPx(float $this$toPx) {
        return (int) TypedValue.applyDimension(1, $this$toPx, Resources.getSystem().getDisplayMetrics());
    }

    public static final float toDp(float $this$toDp) {
        return TypedValue.applyDimension(0, $this$toDp, Resources.getSystem().getDisplayMetrics());
    }

    public static /* synthetic */ void setDebounceClickListener$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        setDebounceClickListener(view, j, function1);
    }

    public static final void setDebounceClickListener(View $this$setDebounceClickListener, long debounceInterval, Function1<? super View, Unit> listenerBlock) {
        Intrinsics.checkNotNullParameter($this$setDebounceClickListener, "<this>");
        Intrinsics.checkNotNullParameter(listenerBlock, "listenerBlock");
        $this$setDebounceClickListener.setOnClickListener(new DebounceOnClickListener(debounceInterval, listenerBlock));
    }

    public static final String getThemeText() {
        return (TapTapKit.INSTANCE.getContext().getResources().getConfiguration().uiMode & 48) == 32 ? "dark" : "light";
    }

    public static final void applyCircleOutline(View $this$applyCircleOutline) {
        Intrinsics.checkNotNullParameter($this$applyCircleOutline, "<this>");
        $this$applyCircleOutline.setClipToOutline(true);
        $this$applyCircleOutline.setOutlineProvider(new ViewOutlineProvider() { // from class: com.taptap.sdk.kit.internal.extensions.UIExtKt.applyCircleOutline.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
    }

    public static /* synthetic */ void applyCustomRoundedCorners$default(View view, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        applyCustomRoundedCorners(view, f, f2, f3, f4);
    }

    public static final void applyCustomRoundedCorners(View $this$applyCustomRoundedCorners, final float leftTop, final float rightTop, final float rightBottom, final float leftBottom) {
        Intrinsics.checkNotNullParameter($this$applyCustomRoundedCorners, "<this>");
        $this$applyCustomRoundedCorners.setClipToOutline(true);
        $this$applyCustomRoundedCorners.setOutlineProvider(new ViewOutlineProvider() { // from class: com.taptap.sdk.kit.internal.extensions.UIExtKt.applyCustomRoundedCorners.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                Path $this$getOutline_u24lambda_u240 = new Path();
                float f = leftTop;
                float f2 = rightTop;
                float f3 = rightBottom;
                float f4 = leftBottom;
                $this$getOutline_u24lambda_u240.addRoundRect(0.0f, 0.0f, view.getWidth(), view.getHeight(), new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
                try {
                    if (Build.VERSION.SDK_INT >= 30) {
                        outline.setPath($this$getOutline_u24lambda_u240);
                    } else {
                        outline.setConvexPath($this$getOutline_u24lambda_u240);
                    }
                } catch (Exception e) {
                    float maxRadius = ComparisonsKt.maxOf(leftTop, rightTop, rightBottom, leftBottom);
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), maxRadius);
                }
            }
        });
    }

    public static final boolean isLandscape() {
        try {
            return TapTapKit.INSTANCE.getSdkOptions().getScreenOrientation() == 1;
        } catch (Throwable th) {
            return true;
        }
    }

    public static final boolean isDarkMode() {
        return (TapTapKit.INSTANCE.getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final int getColorRes(int res) {
        return TapTapKit.INSTANCE.getContext().getResources().getColor(res);
    }
}
