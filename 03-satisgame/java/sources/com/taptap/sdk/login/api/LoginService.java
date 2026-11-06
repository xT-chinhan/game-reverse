package com.taptap.sdk.login.api;

import android.app.Activity;
import com.anythink.core.common.h.au;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LoginService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH&¢\u0006\u0002\u0010\rJ9\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u0010\u001a\u00020\u0003H&J1\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J9\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH&¢\u0006\u0002\u0010\rJ9\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00170\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u0003H&J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH&J\"\u0010\u001e\u001a\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u001fH&J\b\u0010 \u001a\u00020\u0003H&¨\u0006!"}, d2 = {"Lcom/taptap/sdk/login/api/LoginService;", "", "authWithScope", "", "activity", "Landroid/app/Activity;", "scopes", "", "", "isPreApproved", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "(Landroid/app/Activity;[Ljava/lang/String;ZLcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "authWithScopeInternal", "Lcom/taptap/sdk/login/AccessToken;", "cancelLogin", "continueWebLogin", au.b.a, "preferredLoginType", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getAccount", "getCurrentTapAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "loginWithScope", "loginWithScopeInternal", "logout", "obtainAuthorization", ImagesContract.URL, "method", "registerClientLoginCallback", "Lkotlin/Function1;", "removeClientLoginCallback", "tap-login-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface LoginService {
    void authWithScope(Activity activity, String[] scopes, boolean isPreApproved, TapTapCallback<String> callback);

    void authWithScopeInternal(Activity activity, String[] scopes, boolean isPreApproved, TapTapCallback<AccessToken> callback);

    void cancelLogin();

    void continueWebLogin(String token, String preferredLoginType, String[] scopes);

    String getAccount();

    TapTapAccount getCurrentTapAccount();

    void loginWithScope(Activity activity, String[] scopes, boolean isPreApproved, TapTapCallback<String> callback);

    void loginWithScopeInternal(Activity activity, String[] scopes, boolean isPreApproved, TapTapCallback<TapTapAccount> callback);

    void logout();

    String obtainAuthorization(String url, String method);

    void registerClientLoginCallback(Function1<? super String[], Unit> callback);

    void removeClientLoginCallback();
}
