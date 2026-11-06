package com.taptap.sdk.kit.internal.extensions;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: UIExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0004\u001a\f\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"gone", "", "Landroid/view/View;", "toDp", "", "toPx", "", "visible", "tap-kit_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
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

    public static final int toPx(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static final float toDp(float f) {
        return TypedValue.applyDimension(0, f, Resources.getSystem().getDisplayMetrics());
    }
}
