package com.taptap.sdk.login.internal.service;

import android.app.Activity;
import com.anythink.core.common.h.au;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.TapTapLogin;
import com.taptap.sdk.login.api.LoginService;
import com.taptap.sdk.login.internal.AccountManager;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.handlers.phone.PhoneLoginHandler;
import com.taptap.sdk.login.internal.util.CodeUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: LoginServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016¢\u0006\u0002\u0010\u000eJ9\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0004H\u0016J1\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J9\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016¢\u0006\u0002\u0010\u000eJ9\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\"\u0010\u001f\u001a\u00020\u00042\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040 H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016¨\u0006\""}, d2 = {"Lcom/taptap/sdk/login/internal/service/LoginServiceImpl;", "Lcom/taptap/sdk/login/api/LoginService;", "()V", "authWithScope", "", "activity", "Landroid/app/Activity;", "scopes", "", "", "isPreApproved", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "(Landroid/app/Activity;[Ljava/lang/String;ZLcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "authWithScopeInternal", "Lcom/taptap/sdk/login/AccessToken;", "cancelLogin", "continueWebLogin", au.b.a, "preferredLoginType", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getAccount", "getCurrentTapAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "loginWithScope", "loginWithScopeInternal", "logout", "obtainAuthorization", ImagesContract.URL, "method", "registerClientLoginCallback", "Lkotlin/Function1;", "removeClientLoginCallback", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginServiceImpl implements LoginService {
    @Override // com.taptap.sdk.login.api.LoginService
    public String obtainAuthorization(String url, String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        TapTapAccount account = AccountManager.INSTANCE.getAccount();
        if (account != null) {
            if (url.length() > 0) {
                if (method.length() > 0) {
                    return CodeUtil.INSTANCE.getAuthorization(url, method, account.getAccessToken().getKid(), account.getAccessToken().getMacKey());
                }
            }
        }
        return null;
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void loginWithScope(Activity activity, String[] scopes, boolean isPreApproved, final TapTapCallback<String> callback) throws TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithScopeInternal(activity, scopes, isPreApproved, new TapTapCallback<TapTapAccount>() { // from class: com.taptap.sdk.login.internal.service.LoginServiceImpl.loginWithScope.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(TapTapAccount result) {
                String strEncodeToString;
                Intrinsics.checkNotNullParameter(result, "result");
                TapTapCallback<String> tapTapCallback = callback;
                try {
                    Json json = TapJson.INSTANCE.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapAccount.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, result);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                tapTapCallback.onSuccess(strEncodeToString);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                callback.onFail(exception);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                callback.onCancel();
            }
        });
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void loginWithScopeInternal(Activity activity, String[] scopes, boolean isPreApproved, TapTapCallback<TapTapAccount> callback) throws TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.loginWithScope(activity, scopes, isPreApproved, callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void authWithScope(Activity activity, String[] scopes, boolean isPreApproved, final TapTapCallback<String> callback) throws TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authWithScopeInternal(activity, scopes, isPreApproved, new TapTapCallback<AccessToken>() { // from class: com.taptap.sdk.login.internal.service.LoginServiceImpl.authWithScope.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(AccessToken result) {
                String strEncodeToString;
                Intrinsics.checkNotNullParameter(result, "result");
                TapTapCallback<String> tapTapCallback = callback;
                try {
                    Json json = TapJson.INSTANCE.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(AccessToken.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, result);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                tapTapCallback.onSuccess(strEncodeToString);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                callback.onFail(exception);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                callback.onCancel();
            }
        });
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void authWithScopeInternal(Activity activity, String[] scopes, boolean isPreApproved, TapTapCallback<AccessToken> callback) throws TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.authWithScope(activity, scopes, isPreApproved, callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public TapTapAccount getCurrentTapAccount() {
        return LoginManager.INSTANCE.getCurrentTapAccount();
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void registerClientLoginCallback(Function1<? super String[], Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        PhoneLoginHandler.INSTANCE.setPhoneLoginCallback(callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void removeClientLoginCallback() {
        PhoneLoginHandler.INSTANCE.setPhoneLoginCallback(null);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void continueWebLogin(String token, String preferredLoginType, String[] scopes) {
        PhoneLoginHandler.PhoneLoginResultCallback resultCallback = PhoneLoginHandler.INSTANCE.getResultCallback();
        if (resultCallback != null) {
            resultCallback.continueWebLogin(token, preferredLoginType, scopes);
        }
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public String getAccount() {
        if (TapTapLogin.getCurrentTapAccount() == null) {
            return null;
        }
        TapJson tapJson = TapJson.INSTANCE;
        TapTapAccount currentTapAccount = TapTapLogin.getCurrentTapAccount();
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(TapTapAccount.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return json.encodeToString(kSerializerSerializer, currentTapAccount);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            return null;
        }
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void cancelLogin() {
        PhoneLoginHandler.PhoneLoginResultCallback resultCallback = PhoneLoginHandler.INSTANCE.getResultCallback();
        if (resultCallback != null) {
            resultCallback.cancelLogin();
        }
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void logout() throws TapTapException {
        LoginManager.INSTANCE.logout();
    }
}
