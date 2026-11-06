package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.view.View;
import com.tapsdk.tapad.internal.runtime.ShowHostFacts;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationShowAdmissionBridge {
    private MediationShowAdmissionBridge() {
    }

    public static void bindTransferred(DirichletAd dirichletAd, long j, int i) {
        if (dirichletAd == null || j == 0 || !dirichletAd.installMediationShowLease(j, i)) {
            releaseNative(j);
            throw new IllegalStateException("mediation show lease bind failed");
        }
    }

    private static boolean claim(DirichletAd dirichletAd, int i, int i2, boolean z) {
        long jMediationShowLeaseToken = dirichletAd.mediationShowLeaseToken();
        if (jMediationShowLeaseToken == 0) {
            return false;
        }
        try {
            return nativeClaim(jMediationShowLeaseToken, i, i2, z) == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean claimFullscreen(DirichletAd dirichletAd, int i, Activity activity, boolean z) {
        if (dirichletAd == null) {
            return false;
        }
        return claim(dirichletAd, i, ShowHostFacts.forFullscreen(activity, false), z);
    }

    public static boolean claimInline(DirichletAd dirichletAd, int i, View view, boolean z) {
        if (dirichletAd == null) {
            return false;
        }
        return claim(dirichletAd, i, ShowHostFacts.forInlinePreparation(view), z);
    }

    public static boolean claimProviderRender(DirichletAd dirichletAd, int i, boolean z) {
        if (dirichletAd == null) {
            return false;
        }
        return claim(dirichletAd, i, ShowHostFacts.forProviderPreparation(z), z);
    }

    public static boolean isReady(DirichletAd dirichletAd, int i, boolean z) {
        if (dirichletAd != null && z) {
            long jMediationShowLeaseToken = dirichletAd.mediationShowLeaseToken();
            if (jMediationShowLeaseToken == 0) {
                return false;
            }
            try {
                return nativeIsReady(jMediationShowLeaseToken, i, true);
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static native int nativeClaim(long j, int i, int i2, boolean z);

    private static native boolean nativeIsReady(long j, int i, boolean z);

    private static native boolean nativeRelease(long j);

    private static native long nativeStageTransfer(long j, byte[] bArr, long j2, int i);

    public static void release(DirichletAd dirichletAd) {
        if (dirichletAd == null) {
            return;
        }
        releaseNative(dirichletAd.clearMediationShowLease());
    }

    private static void releaseNative(long j) {
        if (j == 0) {
            return;
        }
        try {
            nativeRelease(j);
        } catch (Throwable th) {
        }
    }

    public static long stageTransfer(long j, byte[] bArr, long j2, int i) {
        if (j != 0 && bArr != null && j2 > 0) {
            try {
                return nativeStageTransfer(j, bArr, j2, i);
            } catch (Throwable th) {
            }
        }
        return 0L;
    }
}
