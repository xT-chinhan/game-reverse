package com.taptap.sdk.login.api;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.TapTapLoginCallback;
import com.taptap.sdk.servicemanager.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: LoginService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00040\rH&¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&JE\u0010\u0012\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00040\rH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/login/api/LoginService;", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "authorizeWithScopes", "", "T", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "returnType", "Ljava/lang/Class;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;Ljava/lang/Class;)V", "getAccount", "getCurrentTapAccount", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "loginWithScopes", "logout", "registerTapLoginCallback", "Lcom/taptap/sdk/login/TapTapLoginCallback;", "unregisterTapLoginCallback", "tap-login-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface LoginService extends ServiceManager.Service {
    <T> void authorizeWithScopes(Activity activity, String[] scopes, TapTapCallback<T> callback, Class<T> returnType);

    String getAccount();

    PrivateTapSdkAccount getCurrentTapAccount();

    <T> void loginWithScopes(Activity activity, String[] scopes, TapTapCallback<T> callback, Class<T> returnType);

    void logout();

    void registerTapLoginCallback(TapTapLoginCallback callback);

    void unregisterTapLoginCallback(TapTapLoginCallback callback);
}
