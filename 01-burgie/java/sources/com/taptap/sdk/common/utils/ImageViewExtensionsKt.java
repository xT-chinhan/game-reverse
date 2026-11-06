package com.taptap.sdk.common.utils;

import android.widget.ImageView;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageViewExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002¨\u0006\f"}, d2 = {"addGradientOverlay", "", "Landroid/widget/ImageView;", "color", "", "startAlpha", "", "endAlpha", "direction", "Lcom/taptap/sdk/common/utils/GradientOverlayUtils$GradientDirection;", "cornerRadius", "removeGradientOverlay", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ImageViewExtensionsKt {
    public static final void addGradientOverlay(ImageView $this$addGradientOverlay, int color, float startAlpha, float endAlpha, GradientOverlayUtils.GradientDirection direction, int cornerRadius) {
        Intrinsics.checkNotNullParameter($this$addGradientOverlay, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        GradientOverlayUtils.INSTANCE.addGradientOverlay($this$addGradientOverlay, color, startAlpha, endAlpha, direction, cornerRadius);
    }

    public static final void removeGradientOverlay(ImageView $this$removeGradientOverlay) {
        Intrinsics.checkNotNullParameter($this$removeGradientOverlay, "<this>");
        GradientOverlayUtils.INSTANCE.removeGradientOverlay($this$removeGradientOverlay);
    }

    public static final void addGradientOverlay(ImageView $this$addGradientOverlay, int color) {
        Intrinsics.checkNotNullParameter($this$addGradientOverlay, "<this>");
        addGradientOverlay($this$addGradientOverlay, color, 0.4f, 1.0f, GradientOverlayUtils.GradientDirection.TOP_TO_BOTTOM, UIExtKt.toPx(20.0f));
    }

    public static final void addGradientOverlay(ImageView $this$addGradientOverlay, int color, int cornerRadius) {
        Intrinsics.checkNotNullParameter($this$addGradientOverlay, "<this>");
        addGradientOverlay($this$addGradientOverlay, color, 0.4f, 1.0f, GradientOverlayUtils.GradientDirection.TOP_TO_BOTTOM, cornerRadius);
    }
}
