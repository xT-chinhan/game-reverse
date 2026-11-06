package com.taptap.sdk.compliance.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplianceUIHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"LOADING_DISMISS_DELAY", "", "getScreenHeight", "", "Landroid/content/Context;", "getScreenWidth", "tap-compliance_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ComplianceUIHelperKt {
    private static final long LOADING_DISMISS_DELAY = 15000;

    public static final int getScreenHeight(Context $this$getScreenHeight) {
        Intrinsics.checkNotNullParameter($this$getScreenHeight, "<this>");
        Object systemService = $this$getScreenHeight.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager wm = (WindowManager) systemService;
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    public static final int getScreenWidth(Context $this$getScreenWidth) {
        Intrinsics.checkNotNullParameter($this$getScreenWidth, "<this>");
        Object systemService = $this$getScreenWidth.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager wm = (WindowManager) systemService;
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
}
