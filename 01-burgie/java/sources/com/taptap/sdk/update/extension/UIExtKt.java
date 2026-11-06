package com.taptap.sdk.update.extension;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;

/* JADX INFO: compiled from: UIExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0001¨\u0006\u0004"}, d2 = {"toDp", "", "toPx", "", "tap-update_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UIExtKt {
    public static final int toPx(float $this$toPx) {
        return (int) TypedValue.applyDimension(1, $this$toPx, Resources.getSystem().getDisplayMetrics());
    }

    public static final float toDp(float $this$toDp) {
        return TypedValue.applyDimension(0, $this$toDp, Resources.getSystem().getDisplayMetrics());
    }
}
