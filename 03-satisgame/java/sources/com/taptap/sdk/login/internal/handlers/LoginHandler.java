package com.taptap.sdk.login.internal.handlers;

import android.app.Activity;
import android.app.Fragment;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: LoginHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/LoginHandler;", "", "canHandle", "", "activity", "Landroid/app/Activity;", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "getFragment", "Landroid/app/Fragment;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface LoginHandler {
    boolean canHandle(Activity activity, LoginRequest request);

    Fragment getFragment();
}
