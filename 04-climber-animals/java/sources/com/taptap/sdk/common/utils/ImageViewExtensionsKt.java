package com.taptap.sdk.common.utils;

import android.widget.ImageView;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageViewExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002¨\u0006\f"}, d2 = {"addGradientOverlay", "", "Landroid/widget/ImageView;", "color", "", "startAlpha", "", "endAlpha", "direction", "Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientDirection;", "cornerRadius", "removeGradientOverlay", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ImageViewExtensionsKt {
    public static /* synthetic */ void addGradientOverlay$default(ImageView imageView, int i, float f, float f2, GradientOverlayUtils.GradientDirection gradientDirection, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f = 0.4f;
        }
        float f3 = f;
        if ((i3 & 4) != 0) {
            f2 = 1.0f;
        }
        float f4 = f2;
        if ((i3 & 8) != 0) {
            gradientDirection = GradientOverlayUtils.GradientDirection.TOP_TO_BOTTOM;
        }
        GradientOverlayUtils.GradientDirection gradientDirection2 = gradientDirection;
        if ((i3 & 16) != 0) {
            i2 = UIExtKt.toPx(20.0f);
        }
        addGradientOverlay(imageView, i, f3, f4, gradientDirection2, i2);
    }

    public static final void addGradientOverlay(ImageView imageView, int i, float f, float f2, GradientOverlayUtils.GradientDirection direction, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        GradientOverlayUtils.INSTANCE.addGradientOverlay(imageView, i, f, f2, direction, i2);
    }

    public static final void removeGradientOverlay(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        GradientOverlayUtils.INSTANCE.removeGradientOverlay(imageView);
    }

    public static final void addGradientOverlay(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        addGradientOverlay(imageView, i, 0.4f, 1.0f, GradientOverlayUtils.GradientDirection.TOP_TO_BOTTOM, UIExtKt.toPx(20.0f));
    }

    public static final void addGradientOverlay(ImageView imageView, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        addGradientOverlay(imageView, i, 0.4f, 1.0f, GradientOverlayUtils.GradientDirection.TOP_TO_BOTTOM, i2);
    }
}
