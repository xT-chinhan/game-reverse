package com.taptap.sdk.base.utils.image;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageViewUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/base/utils/image/ImageViewUtils;", "", "()V", "applyCircleOutline", "", "Landroid/view/View;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageViewUtils {
    public static final ImageViewUtils INSTANCE = new ImageViewUtils();

    private ImageViewUtils() {
    }

    public final void applyCircleOutline(View $this$applyCircleOutline) {
        Intrinsics.checkNotNullParameter($this$applyCircleOutline, "<this>");
        $this$applyCircleOutline.setClipToOutline(true);
        $this$applyCircleOutline.setOutlineProvider(new ViewOutlineProvider() { // from class: com.taptap.sdk.base.utils.image.ImageViewUtils.applyCircleOutline.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
    }
}
