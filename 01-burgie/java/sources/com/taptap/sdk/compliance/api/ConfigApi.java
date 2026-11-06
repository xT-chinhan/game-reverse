package com.taptap.sdk.compliance.api;

import com.taptap.sdk.compliance.bean.RealNameConfig;
import com.taptap.sdk.compliance.bean.UserAntiConfig;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.constants.RequestPath;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.ComplianceApiService;
import com.taptap.sdk.compliance.internal.TapComplianceApi;
import com.taptap.sdk.compliance.internal.TapComplianceApiKt;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.compliance.model.UserModel;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ConfigApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/compliance/api/ConfigApi;", "", "()V", "fetchRealNameConfig", "Lkotlinx/coroutines/Job;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compliance/bean/RealNameConfig;", "fetchUserAntiConfig", "Lcom/taptap/sdk/compliance/bean/UserAntiConfig;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConfigApi {
    public static final ConfigApi INSTANCE = new ConfigApi();

    private ConfigApi() {
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.ConfigApi$fetchRealNameConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConfigApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.ConfigApi$fetchRealNameConfig$1", f = "ConfigApi.kt", i = {1}, l = {96, 27, 34}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
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

        /* JADX WARN: Code duplicated, block: B:26:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:32:0x00e7 A[Catch: all -> 0x00fb, TryCatch #3 {all -> 0x00fb, blocks: (B:23:0x00ad, B:32:0x00e7, B:33:0x00ef, B:34:0x00fa, B:27:0x00b6, B:30:0x00db), top: B:62:0x00ad, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00ef A[Catch: all -> 0x00fb, TryCatch #3 {all -> 0x00fb, blocks: (B:23:0x00ad, B:32:0x00e7, B:33:0x00ef, B:34:0x00fa, B:27:0x00b6, B:30:0x00db), top: B:62:0x00ad, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0118  */
        /* JADX WARN: Code duplicated, block: B:44:0x0130 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x0131  */
        /* JADX WARN: Code duplicated, block: B:47:0x013d A[PHI: r0 r3 r7
          0x013d: PHI (r0v18 com.taptap.sdk.compliance.api.ConfigApi$fetchRealNameConfig$1) = 
          (r0v9 com.taptap.sdk.compliance.api.ConfigApi$fetchRealNameConfig$1)
          (r0v19 com.taptap.sdk.compliance.api.ConfigApi$fetchRealNameConfig$1)
         binds: [B:41:0x0116, B:46:0x0132] A[DONT_GENERATE, DONT_INLINE]
          0x013d: PHI (r3v14 '$result' java.lang.Object) = (r3v2 '$result' java.lang.Object), (r3v16 '$result' java.lang.Object) binds: [B:41:0x0116, B:46:0x0132] A[DONT_GENERATE, DONT_INLINE]
          0x013d: PHI (r7v11 '$result' java.lang.Object) = (r7v5 '$result' java.lang.Object), (r7v12 '$result' java.lang.Object) binds: [B:41:0x0116, B:46:0x0132] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:49:0x0146  */
        /* JADX WARN: Code duplicated, block: B:51:0x0161 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x0162  */
        /* JADX WARN: Code duplicated, block: B:60:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object $result;
            int i;
            int i2;
            String accessToken;
            Object obj2;
            TapJson this_$iv$iv;
            Object $result2;
            AnonymousClass1 anonymousClass2;
            Object $result3;
            Object $result4;
            AnonymousClass1 anonymousClass3;
            TapTapCallback<RealNameConfig> tapTapCallback;
            RealNameConfig it;
            ConfigApi$fetchRealNameConfig$1$1$1 configApi$fetchRealNameConfig$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<RealNameConfig> tapTapCallback2;
            Throwable it2;
            ConfigApi$fetchRealNameConfig$1$2$1 configApi$fetchRealNameConfig$1$2$1;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                    $result = obj;
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    Map queryMap$iv = new LinkedHashMap();
                    Map headerMap$iv = new LinkedHashMap();
                    i = 0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Map<String, String> mutableMap = MapsKt.toMutableMap(queryMap$iv);
                        mutableMap.put(BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                        Map<String, String> mutableMap2 = MapsKt.toMutableMap(headerMap$iv);
                        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                            accessToken = "";
                        }
                        mutableMap2.put("X-TAP-Anti-Addiction-Token", accessToken);
                        TapJson tapJson = TapJson.INSTANCE;
                        ComplianceApiService api = TapComplianceApiKt.getApi();
                        anonymousClass1.L$0 = tapJson;
                        anonymousClass1.label = 1;
                        obj2 = api.get(RequestPath.GET_REAL_NAME_GLOBAL_CONFIG, mutableMap, mutableMap2, anonymousClass1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this_$iv$iv = tapJson;
                        $result2 = $result;
                        anonymousClass2 = anonymousClass1;
                        try {
                            data$iv$iv = (JsonElement) obj2;
                            if (data$iv$iv == null) {
                                try {
                                    Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(RealNameConfig.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromJsonElement = null;
                                }
                                break;
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement != null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            Object objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                            $result3 = $result2;
                            $result4 = objM534constructorimpl;
                            anonymousClass3 = anonymousClass2;
                            tapTapCallback = anonymousClass3.$callback;
                            if (Result.m541isSuccessimpl($result4)) {
                                it = (RealNameConfig) $result4;
                                configApi$fetchRealNameConfig$1$1$1 = new ConfigApi$fetchRealNameConfig$1$1$1(tapTapCallback, it, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = it;
                                anonymousClass3.label = 2;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$1$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                TapComplianceSettings.INSTANCE.cacheRealNameConfig(it);
                                TapComplianceSettings.INSTANCE.setRealNameConfig(it);
                                tapTapCallback2 = anonymousClass3.$callback;
                                it2 = Result.m537exceptionOrNullimpl($result4);
                                if (it2 != null) {
                                    RealNameConfig cachedConfig = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                    configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig, it2, tapTapCallback2, null);
                                    anonymousClass3.L$0 = $result4;
                                    anonymousClass3.L$1 = null;
                                    anonymousClass3.label = 3;
                                    if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result5 = $result3;
                                }
                            } else {
                                tapTapCallback2 = anonymousClass3.$callback;
                                it2 = Result.m537exceptionOrNullimpl($result4);
                                if (it2 != null) {
                                    RealNameConfig cachedConfig2 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                    configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig2, it2, tapTapCallback2, null);
                                    anonymousClass3.L$0 = $result4;
                                    anonymousClass3.L$1 = null;
                                    anonymousClass3.label = 3;
                                    if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result5 = $result3;
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            anonymousClass1 = anonymousClass2;
                            $result = $result2;
                            i2 = i;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result3 = $result;
                            $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                            anonymousClass3 = anonymousClass1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = 0;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        anonymousClass3 = anonymousClass1;
                        tapTapCallback = anonymousClass3.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            it = (RealNameConfig) $result4;
                            configApi$fetchRealNameConfig$1$1$1 = new ConfigApi$fetchRealNameConfig$1$1$1(tapTapCallback, it, null);
                            anonymousClass3.L$0 = $result4;
                            anonymousClass3.L$1 = it;
                            anonymousClass3.label = 2;
                            if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$1$1, anonymousClass3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            TapComplianceSettings.INSTANCE.cacheRealNameConfig(it);
                            TapComplianceSettings.INSTANCE.setRealNameConfig(it);
                            tapTapCallback2 = anonymousClass3.$callback;
                            it2 = Result.m537exceptionOrNullimpl($result4);
                            if (it2 != null) {
                                RealNameConfig cachedConfig3 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig3, it2, tapTapCallback2, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                        } else {
                            tapTapCallback2 = anonymousClass3.$callback;
                            it2 = Result.m537exceptionOrNullimpl($result4);
                            if (it2 != null) {
                                RealNameConfig cachedConfig4 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig4, it2, tapTapCallback2, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    break;
                case 1:
                    anonymousClass1 = this;
                    $result = obj;
                    i2 = 0;
                    this_$iv$iv = (TapJson) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj2 = $result;
                        i = 0;
                        anonymousClass2 = anonymousClass1;
                        $result2 = obj2;
                        data$iv$iv = (JsonElement) obj2;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(RealNameConfig.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer2, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement != null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        Object objM534constructorimpl2 = Result.m534constructorimpl(objDecodeFromJsonElement);
                        $result3 = $result2;
                        $result4 = objM534constructorimpl2;
                        anonymousClass3 = anonymousClass2;
                        tapTapCallback = anonymousClass3.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            it = (RealNameConfig) $result4;
                            configApi$fetchRealNameConfig$1$1$1 = new ConfigApi$fetchRealNameConfig$1$1$1(tapTapCallback, it, null);
                            anonymousClass3.L$0 = $result4;
                            anonymousClass3.L$1 = it;
                            anonymousClass3.label = 2;
                            if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$1$1, anonymousClass3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            TapComplianceSettings.INSTANCE.cacheRealNameConfig(it);
                            TapComplianceSettings.INSTANCE.setRealNameConfig(it);
                            tapTapCallback2 = anonymousClass3.$callback;
                            it2 = Result.m537exceptionOrNullimpl($result4);
                            if (it2 != null) {
                                RealNameConfig cachedConfig5 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig5, it2, tapTapCallback2, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                        } else {
                            tapTapCallback2 = anonymousClass3.$callback;
                            it2 = Result.m537exceptionOrNullimpl($result4);
                            if (it2 != null) {
                                RealNameConfig cachedConfig6 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig6, it2, tapTapCallback2, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        anonymousClass3 = anonymousClass1;
                        tapTapCallback = anonymousClass3.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            it = (RealNameConfig) $result4;
                            configApi$fetchRealNameConfig$1$1$1 = new ConfigApi$fetchRealNameConfig$1$1$1(tapTapCallback, it, null);
                            anonymousClass3.L$0 = $result4;
                            anonymousClass3.L$1 = it;
                            anonymousClass3.label = 2;
                            if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$1$1, anonymousClass3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            TapComplianceSettings.INSTANCE.cacheRealNameConfig(it);
                            TapComplianceSettings.INSTANCE.setRealNameConfig(it);
                            tapTapCallback2 = anonymousClass3.$callback;
                            it2 = Result.m537exceptionOrNullimpl($result4);
                            if (it2 != null) {
                                RealNameConfig cachedConfig7 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig7, it2, tapTapCallback2, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                        } else {
                            tapTapCallback2 = anonymousClass3.$callback;
                            it2 = Result.m537exceptionOrNullimpl($result4);
                            if (it2 != null) {
                                RealNameConfig cachedConfig8 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                                configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig8, it2, tapTapCallback2, null);
                                anonymousClass3.L$0 = $result4;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    anonymousClass3 = this;
                    $result3 = obj;
                    it = (RealNameConfig) anonymousClass3.L$1;
                    $result4 = anonymousClass3.L$0;
                    ResultKt.throwOnFailure($result3);
                    TapComplianceSettings.INSTANCE.cacheRealNameConfig(it);
                    TapComplianceSettings.INSTANCE.setRealNameConfig(it);
                    tapTapCallback2 = anonymousClass3.$callback;
                    it2 = Result.m537exceptionOrNullimpl($result4);
                    if (it2 != null) {
                        RealNameConfig cachedConfig9 = TapComplianceSettings.INSTANCE.getCachedRealNameConfig();
                        configApi$fetchRealNameConfig$1$2$1 = new ConfigApi$fetchRealNameConfig$1$2$1(cachedConfig9, it2, tapTapCallback2, null);
                        anonymousClass3.L$0 = $result4;
                        anonymousClass3.L$1 = null;
                        anonymousClass3.label = 3;
                        if (SystemExtKt.dispatchMain(configApi$fetchRealNameConfig$1$2$1, anonymousClass3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result5 = $result3;
                    }
                    return Unit.INSTANCE;
                case 3:
                    $result5 = obj;
                    ResultKt.throwOnFailure($result5);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job fetchRealNameConfig(TapTapCallback<RealNameConfig> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new AnonymousClass1(callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.ConfigApi$fetchUserAntiConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConfigApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.ConfigApi$fetchUserAntiConfig$1", f = "ConfigApi.kt", i = {}, l = {96, 59, 63}, m = "invokeSuspend", n = {}, s = {})
    static final class C03021 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<UserAntiConfig> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03021(TapTapCallback<UserAntiConfig> tapTapCallback, Continuation<? super C03021> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03021(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03021) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:36:0x0110 A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:27:0x00d6, B:36:0x0110, B:37:0x0118, B:38:0x0123, B:31:0x00df, B:34:0x0104), top: B:60:0x00d6, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0118 A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:27:0x00d6, B:36:0x0110, B:37:0x0118, B:38:0x0123, B:31:0x00df, B:34:0x0104), top: B:60:0x00d6, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x0140  */
        /* JADX WARN: Code duplicated, block: B:48:0x0160 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x0161  */
        /* JADX WARN: Code duplicated, block: B:53:0x016c  */
        /* JADX WARN: Code duplicated, block: B:55:0x017f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x0180  */
        /* JADX WARN: Code duplicated, block: B:65:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C03021 c03021;
            Object $result;
            int i;
            int i2;
            String accessToken;
            Object $result2;
            TapJson this_$iv$iv;
            Object $result3;
            Object $result4;
            C03021 c03022;
            TapTapCallback<UserAntiConfig> tapTapCallback;
            ConfigApi$fetchUserAntiConfig$1$1$1 configApi$fetchUserAntiConfig$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<UserAntiConfig> tapTapCallback2;
            Throwable it;
            ConfigApi$fetchUserAntiConfig$1$2$1 configApi$fetchUserAntiConfig$1$2$1;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c03021 = this;
                    $result = obj;
                    StringBuilder sbAppend = new StringBuilder().append("fetchUserAntiConfig: token=");
                    UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                    TapLoggerKt.logInfo(sbAppend.append(currentUser != null ? currentUser.getAccessToken() : null).toString());
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    Map queryMap$iv = MapsKt.mutableMapOf(TuplesKt.to("platform", "android"));
                    Map headerMap$iv = new LinkedHashMap();
                    i = 0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Map<String, String> mutableMap = MapsKt.toMutableMap(queryMap$iv);
                        mutableMap.put(BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                        Map<String, String> mutableMap2 = MapsKt.toMutableMap(headerMap$iv);
                        UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
                        if (currentUser2 == null || (accessToken = currentUser2.getAccessToken()) == null) {
                            accessToken = "";
                        }
                        mutableMap2.put("X-TAP-Anti-Addiction-Token", accessToken);
                        TapJson tapJson = TapJson.INSTANCE;
                        ComplianceApiService api = TapComplianceApiKt.getApi();
                        c03021.L$0 = tapJson;
                        c03021.label = 1;
                        Object obj2 = api.get(RequestPath.GET_USER_ANTI_CONFIG, mutableMap, mutableMap2, c03021);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = obj2;
                        this_$iv$iv = tapJson;
                        try {
                            data$iv$iv = (JsonElement) $result;
                            if (data$iv$iv == null) {
                                try {
                                    Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(UserAntiConfig.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromJsonElement = null;
                                }
                                break;
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement != null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            $result4 = Result.m534constructorimpl(objDecodeFromJsonElement);
                            c03022 = c03021;
                            $result3 = $result2;
                            tapTapCallback = c03022.$callback;
                            if (Result.m541isSuccessimpl($result4)) {
                                UserAntiConfig it2 = (UserAntiConfig) $result4;
                                TapComplianceSettings.INSTANCE.cacheUserAntiConfig(it2);
                                UserModel.INSTANCE.updateUserAntiConfig(it2);
                                configApi$fetchUserAntiConfig$1$1$1 = new ConfigApi$fetchUserAntiConfig$1$1$1(tapTapCallback, it2, null);
                                c03022.L$0 = $result4;
                                c03022.label = 2;
                                if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$1$1, c03022) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            tapTapCallback2 = c03022.$callback;
                            it = Result.m537exceptionOrNullimpl($result4);
                            if (it != null) {
                                configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(it, tapTapCallback2, null);
                                c03022.L$0 = $result4;
                                c03022.label = 3;
                                if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, c03022) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            $result = $result2;
                            i2 = i;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result3 = $result;
                            $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                            c03022 = c03021;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = 0;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03022 = c03021;
                        tapTapCallback = c03022.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            UserAntiConfig it3 = (UserAntiConfig) $result4;
                            TapComplianceSettings.INSTANCE.cacheUserAntiConfig(it3);
                            UserModel.INSTANCE.updateUserAntiConfig(it3);
                            configApi$fetchUserAntiConfig$1$1$1 = new ConfigApi$fetchUserAntiConfig$1$1$1(tapTapCallback, it3, null);
                            c03022.L$0 = $result4;
                            c03022.label = 2;
                            if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$1$1, c03022) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03022.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(it, tapTapCallback2, null);
                            c03022.L$0 = $result4;
                            c03022.label = 3;
                            if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, c03022) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                    break;
                case 1:
                    c03021 = this;
                    $result = obj;
                    i2 = 0;
                    this_$iv$iv = (TapJson) c03021.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i = 0;
                        $result2 = $result;
                        data$iv$iv = (JsonElement) $result;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(UserAntiConfig.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer2, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement != null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        $result4 = Result.m534constructorimpl(objDecodeFromJsonElement);
                        c03022 = c03021;
                        $result3 = $result2;
                        tapTapCallback = c03022.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            UserAntiConfig it4 = (UserAntiConfig) $result4;
                            TapComplianceSettings.INSTANCE.cacheUserAntiConfig(it4);
                            UserModel.INSTANCE.updateUserAntiConfig(it4);
                            configApi$fetchUserAntiConfig$1$1$1 = new ConfigApi$fetchUserAntiConfig$1$1$1(tapTapCallback, it4, null);
                            c03022.L$0 = $result4;
                            c03022.label = 2;
                            if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$1$1, c03022) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03022.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(it, tapTapCallback2, null);
                            c03022.L$0 = $result4;
                            c03022.label = 3;
                            if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, c03022) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03022 = c03021;
                        tapTapCallback = c03022.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            UserAntiConfig it5 = (UserAntiConfig) $result4;
                            TapComplianceSettings.INSTANCE.cacheUserAntiConfig(it5);
                            UserModel.INSTANCE.updateUserAntiConfig(it5);
                            configApi$fetchUserAntiConfig$1$1$1 = new ConfigApi$fetchUserAntiConfig$1$1$1(tapTapCallback, it5, null);
                            c03022.L$0 = $result4;
                            c03022.label = 2;
                            if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$1$1, c03022) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03022.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(it, tapTapCallback2, null);
                            c03022.L$0 = $result4;
                            c03022.label = 3;
                            if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, c03022) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    c03022 = this;
                    $result3 = obj;
                    $result4 = c03022.L$0;
                    ResultKt.throwOnFailure($result3);
                    tapTapCallback2 = c03022.$callback;
                    it = Result.m537exceptionOrNullimpl($result4);
                    if (it != null) {
                        configApi$fetchUserAntiConfig$1$2$1 = new ConfigApi$fetchUserAntiConfig$1$2$1(it, tapTapCallback2, null);
                        c03022.L$0 = $result4;
                        c03022.label = 3;
                        if (SystemExtKt.dispatchMain(configApi$fetchUserAntiConfig$1$2$1, c03022) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result5 = $result3;
                    }
                    return Unit.INSTANCE;
                case 3:
                    $result5 = obj;
                    ResultKt.throwOnFailure($result5);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job fetchUserAntiConfig(TapTapCallback<UserAntiConfig> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C03021(callback, null));
    }
}
