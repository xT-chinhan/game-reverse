package com.taptap.sdk.login.internal.handlers.web;

import android.app.Activity;
import android.app.Fragment;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import com.taptap.sdk.login.internal.handlers.LoginHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/web/WebHandler;", "Lcom/taptap/sdk/login/internal/handlers/LoginHandler;", "()V", "canHandle", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "getFragment", "Landroid/app/Fragment;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebHandler implements LoginHandler {
    @Override // com.taptap.sdk.login.internal.handlers.LoginHandler
    public boolean canHandle(Activity activity, LoginRequest request) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(request, "request");
        return true;
    }

    @Override // com.taptap.sdk.login.internal.handlers.LoginHandler
    public Fragment getFragment() {
        return new WebLoginFragment();
    }
}
