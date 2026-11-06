package com.taptap.sdk.base.utils.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;

/* JADX INFO: compiled from: DensityUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/base/utils/ui/TapDensityUtils;", "", "()V", "dip", "", "getDip", "(I)I", "dp", "", "getDp", "(I)F", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapDensityUtils {
    public static final TapDensityUtils INSTANCE = new TapDensityUtils();

    private TapDensityUtils() {
    }

    public final int getDip(int $this$dip) {
        return (int) getDp($this$dip);
    }

    public final float getDp(int $this$dp) {
        return TypedValue.applyDimension(1, $this$dp, Resources.getSystem().getDisplayMetrics());
    }
}
