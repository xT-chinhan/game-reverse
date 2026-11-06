package com.taptap.sdk.login.impl.service;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.TapFirstPartyLoginOptions;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.TapTapLogin;
import com.taptap.sdk.login.TapTapLoginCallback;
import com.taptap.sdk.login.api.LoginService;
import com.taptap.sdk.login.impl.core.AccountManager;
import com.taptap.sdk.login.impl.core.LoginManager;
import com.taptap.sdk.login.impl.core.LoginStatusChangeManager;
import com.taptap.sdk.login.impl.utils.ReflectUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: LoginServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002JE\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JE\u0010\u0013\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0016H\u0016¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/login/impl/service/LoginServiceImpl;", "Lcom/taptap/sdk/login/api/LoginService;", "()V", "authorizeWithScopes", "", "T", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "returnType", "Ljava/lang/Class;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;Ljava/lang/Class;)V", "getAccount", "getCurrentTapAccount", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "loginWithScopes", "logout", "registerTapLoginCallback", "Lcom/taptap/sdk/login/TapTapLoginCallback;", "unregisterTapLoginCallback", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginServiceImpl implements LoginService {
    private static final String TAG = "LoginServiceImpl";

    @Override // com.taptap.sdk.login.api.LoginService
    public <T> void loginWithScopes(Activity activity, String[] scopes, final TapTapCallback<T> callback, final Class<T> returnType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            TapLogger.loge$default(TAG, "LoginManager not initialized", null, 4, null);
            callback.onFail(new TapTapException("SDK not initialized"));
        } else {
            LoginManager.INSTANCE.getInstance().login(activity, ArraysKt.toList(scopes), new TapFirstPartyLoginOptions.Builder().build(), new TapTapCallback<TapTapAccount>() { // from class: com.taptap.sdk.login.impl.service.LoginServiceImpl.loginWithScopes.1
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onSuccess(TapTapAccount result) {
                    Object objEncodeToString;
                    Intrinsics.checkNotNullParameter(result, "result");
                    TapTapCallback<T> tapTapCallback = callback;
                    ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                    Class actualType$iv = returnType;
                    if (Intrinsics.areEqual(actualType$iv, String.class)) {
                        TapJson this_$iv$iv = TapJson.INSTANCE;
                        objEncodeToString = null;
                        try {
                            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(TapTapAccount.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, result);
                        } catch (Exception e$iv$iv) {
                            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                        }
                        if (objEncodeToString == null) {
                            objEncodeToString = "";
                        }
                    } else if (actualType$iv.isAssignableFrom(result.getClass())) {
                        objEncodeToString = result;
                    } else {
                        throw new IllegalArgumentException("Unsupported return type: " + actualType$iv.getName());
                    }
                    tapTapCallback.onSuccess(objEncodeToString);
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
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public <T> void authorizeWithScopes(Activity activity, String[] scopes, final TapTapCallback<T> callback, final Class<T> returnType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            TapLogger.loge$default(TAG, "LoginManager not initialized", null, 4, null);
            callback.onFail(new TapTapException("SDK not initialized"));
        } else {
            LoginManager.INSTANCE.getInstance().auth(activity, scopes, new TapTapCallback<AccessToken>() { // from class: com.taptap.sdk.login.impl.service.LoginServiceImpl.authorizeWithScopes.1
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onSuccess(AccessToken result) {
                    Object objEncodeToString;
                    Intrinsics.checkNotNullParameter(result, "result");
                    TapTapCallback<T> tapTapCallback = callback;
                    ReflectUtils reflectUtils = ReflectUtils.INSTANCE;
                    Class actualType$iv = returnType;
                    if (Intrinsics.areEqual(actualType$iv, String.class)) {
                        TapJson this_$iv$iv = TapJson.INSTANCE;
                        objEncodeToString = null;
                        try {
                            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(AccessToken.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, result);
                        } catch (Exception e$iv$iv) {
                            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                        }
                        if (objEncodeToString == null) {
                            objEncodeToString = "";
                        }
                    } else if (actualType$iv.isAssignableFrom(result.getClass())) {
                        objEncodeToString = result;
                    } else {
                        throw new IllegalArgumentException("Unsupported return type: " + actualType$iv.getName());
                    }
                    tapTapCallback.onSuccess(objEncodeToString);
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
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public PrivateTapSdkAccount getCurrentTapAccount() {
        return AccountManager.INSTANCE.getInstance().getPrivateTapSdkAccount();
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void registerTapLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginStatusChangeManager.INSTANCE.registerLoginCallback(callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void unregisterTapLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginStatusChangeManager.INSTANCE.unregisterLoginCallback(callback);
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public String getAccount() {
        TapTapAccount value = TapTapLogin.getCurrentTapAccount();
        if (value == null) {
            return null;
        }
        TapJson this_$iv = TapJson.INSTANCE;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(TapTapAccount.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, value);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            return null;
        }
    }

    @Override // com.taptap.sdk.login.api.LoginService
    public void logout() {
        LoginManager.INSTANCE.getInstance().logout();
    }
}
