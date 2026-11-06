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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a2\u0010\n\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f\u001a\f\u0010\u0010\u001a\u00020\b*\u0004\u0018\u00010\t\u001a\f\u0010\u0011\u001a\u00020\b*\u0004\u0018\u00010\t\u001a\f\u0010\u0012\u001a\u00020\u0006*\u0004\u0018\u00010\t\u001a(\u0010\u0013\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b0\u0017\u001a\n\u0010\u0018\u001a\u00020\f*\u00020\f\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\f\u001a\f\u0010\u001a\u001a\u00020\b*\u0004\u0018\u00010\t¨\u0006\u001b"}, d2 = {"getColorRes", "", "res", "getThemeText", "", "isLandscape", "", "applyCircleOutline", "", "Landroid/view/View;", "applyCustomRoundedCorners", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "gone", "invisible", "isVisible", "setDebounceClickListener", "debounceInterval", "", "listenerBlock", "Lkotlin/Function1;", "toDp", "toPx", "visible", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UIExtKt {
    public static final void visible(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public static final void gone(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public static final void invisible(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
    }

    public static final boolean isVisible(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static final int toPx(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static final float toDp(float f) {
        return TypedValue.applyDimension(0, f, Resources.getSystem().getDisplayMetrics());
    }

    public static /* synthetic */ void setDebounceClickListener$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        setDebounceClickListener(view, j, function1);
    }

    public static final void setDebounceClickListener(View view, long j, Function1<? super View, Unit> listenerBlock) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listenerBlock, "listenerBlock");
        view.setOnClickListener(new DebounceOnClickListener(j, listenerBlock));
    }

    public static final String getThemeText() {
        return (TapTapKit.INSTANCE.getContext().getResources().getConfiguration().uiMode & 48) == 32 ? "dark" : "light";
    }

    public static final void applyCircleOutline(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setClipToOutline(true);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.taptap.sdk.kit.internal.extensions.UIExtKt.applyCircleOutline.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setOval(0, 0, view2.getWidth(), view2.getHeight());
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

    public static final void applyCustomRoundedCorners(View view, final float f, final float f2, final float f3, final float f4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setClipToOutline(true);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.taptap.sdk.kit.internal.extensions.UIExtKt.applyCustomRoundedCorners.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                Path path = new Path();
                float f5 = f;
                float f6 = f2;
                float f7 = f3;
                float f8 = f4;
                path.addRoundRect(0.0f, 0.0f, view2.getWidth(), view2.getHeight(), new float[]{f5, f5, f6, f6, f7, f7, f8, f8}, Path.Direction.CW);
                try {
                    if (Build.VERSION.SDK_INT >= 30) {
                        outline.setPath(path);
                    } else {
                        outline.setConvexPath(path);
                    }
                } catch (Exception unused) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), ComparisonsKt.maxOf(f, f2, f3, f4));
                }
            }
        });
    }

    public static final boolean isLandscape() {
        try {
            return TapTapKit.INSTANCE.getSdkOptions().getScreenOrientation() == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static final int getColorRes(int i) {
        return TapTapKit.INSTANCE.getContext().getResources().getColor(i);
    }
}
