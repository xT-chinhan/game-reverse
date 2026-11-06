package com.tapsdk.tapad.internal.runtime;

import android.app.Activity;
import android.view.View;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.generated.DirichletProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class ShowHostFacts {
    private ShowHostFacts() {
    }

    private static int build(boolean z, boolean z2) {
        int i = z ? 3 : 1;
        return (z2 || AndroidLifecycleHost.getInstance().isAppInForeground()) ? i | 4 : i;
    }

    public static int forFullscreen(Activity activity, boolean z) {
        boolean z2 = true;
        boolean z3 = (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
        if (!z3 && !z) {
            z2 = false;
        }
        return build(z2, z3);
    }

    public static int forInline(View view) {
        boolean z = view != null && view.isAttachedToWindow();
        return build(z, z);
    }

    public static int forInlinePreparation(View view) {
        return build(view != null, false);
    }

    public static int forProviderPreparation(boolean z) {
        return build(z, false);
    }

    public static boolean isAdmissionRejection(int i) {
        switch (i) {
            case DirichletProtocol.ShowAdmissionResult.REJECT_INVALID_HOST_FACTS /* -9360 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_FORMAT_MISMATCH /* -9359 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_INVALID_CLOCK /* -9358 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_BACKGROUND /* -9357 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_NOT_PRESENTABLE /* -9356 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_OWNER_DESTROYED /* -9355 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_ALREADY_CLAIMED /* -9354 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_UNSUPPORTED_MATERIAL /* -9353 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_EXPIRED /* -9352 */:
            case DirichletProtocol.ShowAdmissionResult.REJECT_NOT_READY /* -9351 */:
                return true;
            default:
                return false;
        }
    }
}
