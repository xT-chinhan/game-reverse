package com.taptap.sdk.login.internal.handlers.cloud;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.login.internal.LoginEntrance;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import com.taptap.sdk.login.internal.handlers.LoginHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudLoginHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudLoginHandler;", "Lcom/taptap/sdk/login/internal/handlers/LoginHandler;", "()V", "canHandle", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "getFragment", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudLoginFragment;", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CloudLoginHandler implements LoginHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: CloudLoginHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudLoginHandler$Companion;", "", "()V", "getIntent", "Landroid/content/Intent;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent() {
            Intent intent = new Intent("com.cloud.taptap.gaming.daemon");
            intent.setPackage("com.cloud.taptap.gaming");
            return intent;
        }
    }

    @Override // com.taptap.sdk.login.internal.handlers.LoginHandler
    public boolean canHandle(final Activity activity, LoginRequest request) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(request, "request");
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.taptap.sdk.login.internal.handlers.cloud.CloudLoginHandler$canHandle$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                activity.unbindService(this);
            }
        };
        boolean zBindService = activity.bindService(INSTANCE.getIntent(), serviceConnection, 1);
        if (zBindService) {
            LoginManager.INSTANCE.setCurrentLoginEntrance$tap_login_release(LoginEntrance.CLOUD);
        }
        activity.unbindService(serviceConnection);
        return zBindService;
    }

    @Override // com.taptap.sdk.login.internal.handlers.LoginHandler
    public CloudLoginFragment getFragment() {
        return new CloudLoginFragment();
    }
}
