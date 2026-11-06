package com.taptap.sdk.login.internal.service;

import android.app.Activity;
import com.baidu.mobads.sdk.internal.ay;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapFirstPartyLoginOptions;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.TapTapAccountInternal;
import com.taptap.sdk.login.TapTapLogin;
import com.taptap.sdk.login.TapTapLoginCallback;
import com.taptap.sdk.login.api.LoginService;
import com.taptap.sdk.login.internal.AccountManager;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.TapLoginInternal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.json.JSONException;

/* JADX INFO: compiled from: LoginServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016¢\u0006\u0002\u0010\fJ1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016¢\u0006\u0002\u0010\fJ\n\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J1\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016¢\u0006\u0002\u0010\fJ1\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/login/internal/service/LoginServiceImpl;", "Lcom/taptap/sdk/login/api/LoginService;", "()V", "authWithScope", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "authWithScope2", "Lcom/taptap/sdk/login/AccessToken;", "getAccount", "getCurrentTapAccount", "Lcom/taptap/sdk/login/TapTapAccountInternal;", "loginWithScope", "loginWithScope2", "Lcom/taptap/sdk/login/TapTapAccount;", ay.b, "registerTapLoginCallback", "Lcom/taptap/sdk/login/TapTapLoginCallback;", "unregisterTapLoginCallback", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginServiceImpl implements LoginService {
    @Override // com.taptap.sdk.login.api.LoginService
    public void loginWithScope(Activity activity, String[] scopes, final TapTapCallback<String> callback) throws JSONException, TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.loginWithScope(activity, scopes, new TapFirstPartyLoginOptions.Builder().build(), new TapTapCallback<TapTapAccount>() { // from class: com.taptap.sdk.login.internal.service.LoginServiceImpl.loginWithScope.1
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
    public void loginWithScope2(Activity activity, String[] scopes, TapTapCallback<TapTapAccount> callback) throws JSONException, TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.loginWithScope(activity, scopes, new TapFirstPartyLoginOptions.Builder().build(), callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void authWithScope(Activity activity, String[] scopes, final TapTapCallback<String> callback) throws JSONException, TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.authWithScope$tap_login_release(activity, scopes, new TapTapCallback<AccessToken>() { // from class: com.taptap.sdk.login.internal.service.LoginServiceImpl.authWithScope.1
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
    public void authWithScope2(Activity activity, String[] scopes, TapTapCallback<AccessToken> callback) throws JSONException, TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.authWithScope$tap_login_release(activity, scopes, callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public TapTapAccountInternal getCurrentTapAccount() {
        return AccountManager.INSTANCE.getAccountInternal$tap_login_release();
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void registerTapLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoginInternal.INSTANCE.registerLoginCallback(callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void unregisterTapLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoginInternal.INSTANCE.unregisterLoginCallback(callback);
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
    public void logout() throws TapTapException {
        LoginManager.INSTANCE.logout();
    }
}
