package com.taptap.sdk.login.internal.util;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientLoginUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/internal/util/ClientLoginUtils;", "", "()V", "isClientLogin", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClientLoginUtils {
    public static final ClientLoginUtils INSTANCE = new ClientLoginUtils();

    private ClientLoginUtils() {
    }

    public final boolean isClientLogin(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new Intent("com.taptap.sdk.action").resolveActivity(activity.getPackageManager()) != null;
    }
}
