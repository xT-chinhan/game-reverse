package com.taptap.sdk.login.unity;

import android.app.Activity;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeResult;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.TapTapLogin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: BridgeLoginServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J+\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/login/unity/BridgeLoginServiceImpl;", "Lcom/taptap/sdk/login/unity/BridgeLoginService;", "()V", "getCurrentTapAccount", "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "loginWithScope", "activity", "Landroid/app/Activity;", "scopes", "", "", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;)V", "logout", "tap-login-unity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BridgeLoginServiceImpl implements BridgeLoginService {
    @Override // com.taptap.sdk.login.unity.BridgeLoginService
    public void loginWithScope(Activity activity, String[] scopes, final EngineBridgeCallback callback) throws TapTapException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapTapLogin.loginWithScopes(activity, scopes, new TapTapCallback<TapTapAccount>() { // from class: com.taptap.sdk.login.unity.BridgeLoginServiceImpl.loginWithScope.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(TapTapAccount result) {
                Intrinsics.checkNotNullParameter(result, "result");
                EngineBridgeCallback engineBridgeCallback = callback;
                TapJson tapJson = TapJson.INSTANCE;
                String strEncodeToString = null;
                EngineBridgeResult engineBridgeResult = new EngineBridgeResult(0, null, result);
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TapTapAccount.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                EngineBridgeCallback engineBridgeCallback = callback;
                TapJson tapJson = TapJson.INSTANCE;
                String strEncodeToString = null;
                EngineBridgeResult engineBridgeResult = new EngineBridgeResult(1, null, null);
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                EngineBridgeCallback engineBridgeCallback = callback;
                TapJson tapJson = TapJson.INSTANCE;
                String strEncodeToString = null;
                EngineBridgeResult engineBridgeResult = new EngineBridgeResult(-1, exception.getMessage(), null);
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }
        });
    }

    @Override // com.taptap.sdk.login.unity.BridgeLoginService
    public void getCurrentTapAccount(EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapJson tapJson = TapJson.INSTANCE;
        String strEncodeToString = null;
        EngineBridgeResult engineBridgeResult = new EngineBridgeResult(0, null, TapTapLogin.getCurrentTapAccount());
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TapTapAccount.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, engineBridgeResult);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
        }
        if (strEncodeToString == null) {
            strEncodeToString = "";
        }
        callback.onResult(strEncodeToString);
    }

    @Override // com.taptap.sdk.login.unity.BridgeLoginService
    public void logout() throws TapTapException {
        TapTapLogin.logout();
    }
}
