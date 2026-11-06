package com.taptap.sdk.update;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.update.internal.TapUpdateInternal;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTapUpdate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/update/TapTapUpdate;", "", "()V", "checkForceUpdate", "", "updateGame", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "callback", "Lcom/taptap/sdk/update/TapTapUpdateCallback;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapUpdate {
    public static final TapTapUpdate INSTANCE = new TapTapUpdate();

    private TapTapUpdate() {
    }

    @JvmStatic
    public static final void updateGame(Activity activity, TapTapUpdateCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            TapUpdateInternal.INSTANCE.updateGame(activity, callback);
        }
    }

    @JvmStatic
    public static final void checkForceUpdate() {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            TapUpdateInternal.INSTANCE.checkForceUpdate();
        }
    }
}
