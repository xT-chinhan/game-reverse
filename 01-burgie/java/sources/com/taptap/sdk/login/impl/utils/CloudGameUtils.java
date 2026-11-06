package com.taptap.sdk.login.impl.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.byazt.ol.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudGameUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/CloudGameUtils;", "", "()V", "isCloudGame", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CloudGameUtils {
    public static final CloudGameUtils INSTANCE = new CloudGameUtils();

    private CloudGameUtils() {
    }

    public final boolean isCloudGame(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent("com.cloud.taptap.gaming.daemon");
        intent.setPackage("com.cloud.taptap.gaming");
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.taptap.sdk.login.impl.utils.CloudGameUtils$isCloudGame$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }
        };
        boolean bound = activity.bindService(intent, serviceConnection, 1);
        if (bound) {
            activity.unbindService(serviceConnection);
        }
        return bound;
    }
}
