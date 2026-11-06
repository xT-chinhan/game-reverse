package com.taptap.sdk.login.internal.net;

import android.os.Build;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpResponseHandler;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.TapTapAccountInternal;
import com.taptap.sdk.login.TapTapAccountInternalKt;
import com.taptap.sdk.login.internal.AccountManager;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.util.Constants;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0011\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/login/internal/net/NetworkClient;", "", "()V", "tokenHttp", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "getTokenHttp", "()Lcom/taptap/sdk/kit/internal/http/TapHttp;", "tokenHttp$delegate", "Lkotlin/Lazy;", "loginWithCode", "", "code", "", "codeVerifier", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/TapTapAccountInternal;", "refreshToken", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NetworkClient {
    private static final CoroutineScope loginNetworkScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* JADX INFO: renamed from: tokenHttp$delegate, reason: from kotlin metadata */
    private final Lazy tokenHttp = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$tokenHttp$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapHttp invoke() {
            return TapHttp.INSTANCE.newBuilder(Constants.TAG, "4.8.1-beta.7").enableAuthorization().build();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final TapHttp getTokenHttp() {
        return (TapHttp) this.tokenHttp.getValue();
    }

    public final void refreshToken() {
        if (AccountManager.INSTANCE.getAccountInternal$tap_login_release() == null && AccountManager.INSTANCE.getAccount() == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(loginNetworkScope, null, null, new C08221(null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.internal.net.NetworkClient$refreshToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetworkClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.internal.net.NetworkClient$refreshToken$1", f = "NetworkClient.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    static final class C08221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08221(Continuation<? super C08221> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NetworkClient.this.new C08221(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            Object objM54enqueueResultgIAlus$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapHttpJsonParam tapHttpJsonParamPostJson = NetworkClient.this.getTokenHttp().postJson("/auth/v1/login-by-token");
                JSONObject jSONObject = new JSONObject();
                TapJson tapJson = TapJson.INSTANCE;
                HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("device_id", Build.MANUFACTURER + ' ' + Build.MODEL), TuplesKt.to("uuid", TapIdentifierUtil.INSTANCE.getInstallUUID()));
                ITapHttpResponseHandler iTapHttpResponseHandler = null;
                Object[] objArr = 0;
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, mapHashMapOf);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                jSONObject.put("info", strEncodeToString);
                tapHttpJsonParamPostJson.addBody(jSONObject);
                TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                this.label = 1;
                objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(new TapHttpCall(tapHttpJsonParam, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, TapTapAccountInternal>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$refreshToken$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.login.TapTapAccountInternal, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final TapTapAccountInternal invoke(JsonObject jsonObject) {
                        TapJson tapJson2 = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json2 = tapJson2.getJson();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(TapTapAccountInternal.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json2.decodeFromJsonElement(kSerializerSerializer2, jsonObject);
                        } catch (Exception e2) {
                            TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpJsonParam.getBackoffHandler())), 0L, this, 1, null);
                if (objM54enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM54enqueueResultgIAlus$default = ((Result) obj).getValue();
            }
            if (Result.m181isSuccessimpl(objM54enqueueResultgIAlus$default)) {
                TapTapAccountInternal tapTapAccountInternal = (TapTapAccountInternal) objM54enqueueResultgIAlus$default;
                AccountManager.INSTANCE.setAccount(TapTapAccountInternalKt.toTapAccount(tapTapAccountInternal));
                AccountManager.INSTANCE.setAccountInternal$tap_login_release(tapTapAccountInternal);
            }
            Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM54enqueueResultgIAlus$default);
            if (thM177exceptionOrNullimpl != null && (thM177exceptionOrNullimpl instanceof TapHttpException.ServerError) && Intrinsics.areEqual(((TapHttpException.ServerError) thM177exceptionOrNullimpl).getError().getError(), TapErrorConstants.ERROR_INVALID_GRANT)) {
                AccountManager.INSTANCE.clearCache();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.internal.net.NetworkClient$loginWithCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.internal.net.NetworkClient$loginWithCode$1", f = "NetworkClient.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<TapTapAccountInternal> $callback;
        final /* synthetic */ String $code;
        final /* synthetic */ String $codeVerifier;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, TapTapCallback<TapTapAccountInternal> tapTapCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$codeVerifier = str2;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NetworkClient.this.new AnonymousClass1(this.$code, this.$codeVerifier, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            Object objM54enqueueResultgIAlus$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapHttpJsonParam tapHttpJsonParamPostJson = NetworkClient.this.getTokenHttp().postJson("/auth/v1/login-by-authorization-code");
                JSONObject jSONObject = new JSONObject();
                String str = this.$code;
                String str2 = this.$codeVerifier;
                jSONObject.put("code", str);
                jSONObject.put("code_verifier", str2);
                jSONObject.put("redirect_uri", "tapoauth://authorize");
                jSONObject.put("session_id", LoginManager.INSTANCE.getSessionId$tap_login_release());
                jSONObject.put("session_type", "tapsdk");
                TapJson tapJson = TapJson.INSTANCE;
                HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("device_id", Build.MANUFACTURER + ' ' + Build.MODEL), TuplesKt.to("uuid", TapIdentifierUtil.INSTANCE.getInstallUUID()));
                ITapHttpResponseHandler iTapHttpResponseHandler = null;
                Object[] objArr = 0;
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, mapHashMapOf);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                jSONObject.put("info", strEncodeToString);
                tapHttpJsonParamPostJson.addBody(jSONObject);
                TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                this.label = 1;
                objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(new TapHttpCall(tapHttpJsonParam, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, TapTapAccountInternal>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$loginWithCode$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.login.TapTapAccountInternal, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final TapTapAccountInternal invoke(JsonObject jsonObject) {
                        TapJson tapJson2 = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json2 = tapJson2.getJson();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(TapTapAccountInternal.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json2.decodeFromJsonElement(kSerializerSerializer2, jsonObject);
                        } catch (Exception e2) {
                            TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpJsonParam.getBackoffHandler())), 0L, this, 1, null);
                if (objM54enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM54enqueueResultgIAlus$default = ((Result) obj).getValue();
            }
            TapTapCallback<TapTapAccountInternal> tapTapCallback = this.$callback;
            if (Result.m181isSuccessimpl(objM54enqueueResultgIAlus$default)) {
                tapTapCallback.onSuccess((TapTapAccountInternal) objM54enqueueResultgIAlus$default);
            }
            TapTapCallback<TapTapAccountInternal> tapTapCallback2 = this.$callback;
            if (Result.m177exceptionOrNullimpl(objM54enqueueResultgIAlus$default) != null) {
                tapTapCallback2.onFail(new TapTapException("Fail to fetch token"));
            }
            return Unit.INSTANCE;
        }
    }

    public final void loginWithCode(String code, String codeVerifier, TapTapCallback<TapTapAccountInternal> callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(loginNetworkScope, null, null, new AnonymousClass1(code, codeVerifier, callback, null), 3, null);
    }
}
