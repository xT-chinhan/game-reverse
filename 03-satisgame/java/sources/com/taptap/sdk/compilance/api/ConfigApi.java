package com.taptap.sdk.compilance.api;

import com.anythink.core.common.l.f;
import com.taptap.sdk.compilance.bean.RealNameConfig;
import com.taptap.sdk.compilance.bean.UserAntiConfig;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.constants.RequestPath;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.internal.TapComplianceApi;
import com.taptap.sdk.compilance.internal.TapComplianceApiKt;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compilance.internal.TapComplianceSettings;
import com.taptap.sdk.compilance.model.UserModel;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpResponseHandler;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpNoBodyParam;
import com.taptap.sdk.kit.internal.json.TapJson;
import java.util.LinkedHashMap;
import java.util.Map;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: ConfigApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/compilance/api/ConfigApi;", "", "()V", "fetchRealNameConfig", "Lkotlinx/coroutines/Job;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compilance/bean/RealNameConfig;", "fetchUserAntiConfig", "Lcom/taptap/sdk/compilance/bean/UserAntiConfig;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConfigApi {
    public static final ConfigApi INSTANCE = new ConfigApi();

    private ConfigApi() {
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.ConfigApi$fetchRealNameConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConfigApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.ConfigApi$fetchRealNameConfig$1", f = "ConfigApi.kt", i = {1}, l = {113, 26, 33}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<RealNameConfig> $callback;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TapTapCallback<RealNameConfig> tapTapCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x0144  */
        /* JADX WARN: Code duplicated, block: B:42:0x015d A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            Object obj2;
            RealNameConfig realNameConfig;
            TapTapCallback<RealNameConfig> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            ConfigApi$fetchRealNameConfig$1$2$1 configApi$fetchRealNameConfig$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(RequestPath.GET_REAL_NAME_GLOBAL_CONFIG);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                    AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, (String) entry2.getKey(), (String) entry2.getValue(), false, 4, null);
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, f.aI, "1", false, 4, null);
                }
                TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, RealNameConfig>() { // from class: com.taptap.sdk.compilance.api.ConfigApi$fetchRealNameConfig$1$invokeSuspend$$inlined$get-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.RealNameConfig, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final RealNameConfig invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(RealNameConfig.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    realNameConfig = (RealNameConfig) this.L$1;
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    TapComplianceSettings.INSTANCE.cacheRealNameConfig(realNameConfig);
                    TapComplianceSettings.INSTANCE.setRealNameConfig(realNameConfig);
                    objM76enqueueResultgIAlus$default = obj2;
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
                    if (thM187exceptionOrNullimpl != null) {
                        configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(TapComplianceSettings.INSTANCE.getCachedRealNameConfig(), thM187exceptionOrNullimpl, tapTapCallback, null);
                        this.L$0 = objM76enqueueResultgIAlus$default;
                        this.L$1 = null;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            TapTapCallback<RealNameConfig> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
                RealNameConfig realNameConfig2 = (RealNameConfig) objM76enqueueResultgIAlus$default;
                ConfigApi$fetchRealNameConfig$1$1$1 configApi$fetchRealNameConfig$1$1$1 = new ConfigApi$fetchRealNameConfig$1$1$1(tapTapCallback2, realNameConfig2, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.L$1 = realNameConfig2;
                this.label = 2;
                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objM76enqueueResultgIAlus$default;
                realNameConfig = realNameConfig2;
                TapComplianceSettings.INSTANCE.cacheRealNameConfig(realNameConfig);
                TapComplianceSettings.INSTANCE.setRealNameConfig(realNameConfig);
                objM76enqueueResultgIAlus$default = obj2;
                tapTapCallback = this.$callback;
                thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
                if (thM187exceptionOrNullimpl != null) {
                    configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(TapComplianceSettings.INSTANCE.getCachedRealNameConfig(), thM187exceptionOrNullimpl, tapTapCallback, null);
                    this.L$0 = objM76enqueueResultgIAlus$default;
                    this.L$1 = null;
                    this.label = 3;
                    if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                tapTapCallback = this.$callback;
                thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
                if (thM187exceptionOrNullimpl != null) {
                    configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(TapComplianceSettings.INSTANCE.getCachedRealNameConfig(), thM187exceptionOrNullimpl, tapTapCallback, null);
                    this.L$0 = objM76enqueueResultgIAlus$default;
                    this.L$1 = null;
                    this.label = 3;
                    if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Job fetchRealNameConfig(TapTapCallback<RealNameConfig> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new AnonymousClass1(callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.ConfigApi$fetchUserAntiConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConfigApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.ConfigApi$fetchUserAntiConfig$1", f = "ConfigApi.kt", i = {}, l = {113, 59, 63}, m = "invokeSuspend", n = {}, s = {})
    static final class C04521 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<UserAntiConfig> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04521(TapTapCallback<UserAntiConfig> tapTapCallback, Continuation<? super C04521> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04521(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04521) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x0165  */
        /* JADX WARN: Code duplicated, block: B:44:0x0176 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            TapTapCallback<UserAntiConfig> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            ConfigApi$fetchUserAntiConfig$1$2$1 configApi$fetchUserAntiConfig$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StringBuilder sb = new StringBuilder("fetchUserAntiConfig: token=");
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                TapComplianceLoggerKt.logInfo(sb.append(currentUser != null ? currentUser.getAccessToken() : null).toString());
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("platform", "android"));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(RequestPath.GET_USER_ANTI_CONFIG);
                for (Map.Entry entry : mapMutableMapOf.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, (String) entry2.getKey(), (String) entry2.getValue(), false, 4, null);
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, f.aI, "1", false, 4, null);
                }
                TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
                UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
                if (currentUser2 == null || (accessToken = currentUser2.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, UserAntiConfig>() { // from class: com.taptap.sdk.compilance.api.ConfigApi$fetchUserAntiConfig$1$invokeSuspend$$inlined$get-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.UserAntiConfig, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final UserAntiConfig invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(UserAntiConfig.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    objM76enqueueResultgIAlus$default = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
                    if (thM187exceptionOrNullimpl != null) {
                        configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(thM187exceptionOrNullimpl, tapTapCallback, null);
                        this.L$0 = objM76enqueueResultgIAlus$default;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            TapTapCallback<UserAntiConfig> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
                UserAntiConfig userAntiConfig = (UserAntiConfig) objM76enqueueResultgIAlus$default;
                TapComplianceSettings.INSTANCE.cacheUserAntiConfig(userAntiConfig);
                UserModel.INSTANCE.updateUserAntiConfig(userAntiConfig);
                ConfigApi$fetchUserAntiConfig$1$1$1 configApi$fetchUserAntiConfig$1$1$1 = new ConfigApi$fetchUserAntiConfig$1$1$1(tapTapCallback2, userAntiConfig, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 2;
                if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
            if (thM187exceptionOrNullimpl != null) {
                configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(thM187exceptionOrNullimpl, tapTapCallback, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 3;
                if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Job fetchUserAntiConfig(TapTapCallback<UserAntiConfig> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C04521(callback, null));
    }
}
