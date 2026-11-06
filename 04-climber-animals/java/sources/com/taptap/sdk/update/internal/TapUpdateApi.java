package com.taptap.sdk.update.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpResponseHandler;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpNoBodyParam;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.update.TapUpdateApiCallback;
import com.taptap.sdk.update.bean.UpdateResult;
import com.taptap.sdk.update.extension.SystemExtKt;
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
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapUpdateApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u00012\u0006\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH\u0086Hø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rJT\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u00012\u0006\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0086Hø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/update/internal/TapUpdateApi;", "", "()V", "cachedUpdateInfo", "Lcom/taptap/sdk/update/bean/UpdateResult;", "get", "Lkotlin/Result;", "T", "path", "", "queryMap", "", "get-0E7RQCE", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "body", "post-BWLJW6A", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUpdateInfo", "Lkotlinx/coroutines/Job;", "packageName", TTDownloadField.TT_VERSION_CODE, "", "callback", "Lcom/taptap/sdk/update/TapUpdateApiCallback;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateApi {
    public static final TapUpdateApi INSTANCE = new TapUpdateApi();
    private static UpdateResult cachedUpdateInfo;

    private TapUpdateApi() {
    }

    public static /* synthetic */ Job requestUpdateInfo$default(TapUpdateApi tapUpdateApi, String str, int i, TapUpdateApiCallback tapUpdateApiCallback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            tapUpdateApiCallback = null;
        }
        return tapUpdateApi.requestUpdateInfo(str, i, tapUpdateApiCallback);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapUpdateApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1", f = "TapUpdateApi.kt", i = {}, l = {62, 144, 78, 89}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapUpdateApiCallback $callback;
        final /* synthetic */ String $packageName;
        final /* synthetic */ int $versionCode;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, TapUpdateApiCallback tapUpdateApiCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$packageName = str;
            this.$versionCode = i;
            this.$callback = tapUpdateApiCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$packageName, this.$versionCode, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:33:0x010a A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM54enqueueResultgIAlus$default;
            Object obj2;
            TapUpdateApiCallback tapUpdateApiCallback;
            TapUpdateApi$requestUpdateInfo$1$2$1 tapUpdateApi$requestUpdateInfo$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    objM54enqueueResultgIAlus$default = ((Result) obj).getValue();
                    obj2 = objM54enqueueResultgIAlus$default;
                    tapUpdateApiCallback = this.$callback;
                    if (Result.m181isSuccessimpl(obj2)) {
                        tapUpdateApi$requestUpdateInfo$1$2$1 = new TapUpdateApi$requestUpdateInfo$1$2$1((UpdateResult) obj2, tapUpdateApiCallback, null);
                        this.L$0 = obj2;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 3) {
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            if (TapUpdateApi.cachedUpdateInfo != null) {
                this.label = 1;
                if (SystemExtKt.dispatchMain(new C06571(this.$callback, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            TapUpdateApi tapUpdateApi = TapUpdateApi.INSTANCE;
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("identifier", this.$packageName), TuplesKt.to("taptap_version_code", String.valueOf(this.$versionCode)), TuplesKt.to("update_id", UpdateTracker.INSTANCE.getSessionId()));
            TapHttpNoBodyParam tapHttpNoBodyParam = TapUpdateApiKt.getNetApi().get(TapUpdateApiKt.PATH_UPDATE_GAME);
            for (Map.Entry entry : mapMutableMapOf.entrySet()) {
                AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            }
            TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
            this.label = 2;
            objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(new TapHttpCall(tapHttpNoBodyParam2, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, UpdateResult>() { // from class: com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$invokeSuspend$$inlined$get-0E7RQCE$1
                /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.update.bean.UpdateResult, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public final UpdateResult invoke(JsonObject jsonObject) {
                    TapJson tapJson = TapJson.INSTANCE;
                    try {
                        if (jsonObject == null) {
                            return null;
                        }
                        Json json = tapJson.getJson();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(UpdateResult.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                    } catch (Exception e) {
                        TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                        return null;
                    }
                }
            }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpNoBodyParam2.getBackoffHandler())), 0L, this, 1, null);
            if (objM54enqueueResultgIAlus$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM54enqueueResultgIAlus$default;
            tapUpdateApiCallback = this.$callback;
            if (Result.m181isSuccessimpl(obj2)) {
                tapUpdateApi$requestUpdateInfo$1$2$1 = new TapUpdateApi$requestUpdateInfo$1$2$1((UpdateResult) obj2, tapUpdateApiCallback, null);
                this.L$0 = obj2;
                this.label = 3;
                if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TapUpdateApiCallback tapUpdateApiCallback2 = this.$callback;
            Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(obj2);
            if (thM177exceptionOrNullimpl != null) {
                TapUpdateApi$requestUpdateInfo$1$3$1 tapUpdateApi$requestUpdateInfo$1$3$1 = new TapUpdateApi$requestUpdateInfo$1$3$1(tapUpdateApiCallback2, thM177exceptionOrNullimpl, null);
                this.L$0 = obj2;
                this.label = 4;
                if (SystemExtKt.dispatchMain(tapUpdateApi$requestUpdateInfo$1$3$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TapUpdateApi.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.taptap.sdk.update.internal.TapUpdateApi$requestUpdateInfo$1$1", f = "TapUpdateApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06571 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ TapUpdateApiCallback $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C06571(TapUpdateApiCallback tapUpdateApiCallback, Continuation<? super C06571> continuation) {
                super(1, continuation);
                this.$callback = tapUpdateApiCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C06571(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C06571) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    UpdateResult updateResult = TapUpdateApi.cachedUpdateInfo;
                    if (updateResult != null) {
                        updateResult.updateSessionId();
                    }
                    TapUpdateApiCallback tapUpdateApiCallback = this.$callback;
                    if (tapUpdateApiCallback != null) {
                        tapUpdateApiCallback.onSuccess(TapUpdateApi.cachedUpdateInfo);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job requestUpdateInfo(String packageName, int versionCode, TapUpdateApiCallback callback) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return SystemExtKt.runAsync(new AnonymousClass1(packageName, versionCode, callback, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: get-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m77get0E7RQCE$default(TapUpdateApi tapUpdateApi, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new LinkedHashMap();
        }
        TapHttpNoBodyParam tapHttpNoBodyParam = TapUpdateApiKt.getNetApi().get(str);
        for (Map.Entry entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(tapHttpNoBodyParam2, new TapHttpParser.SdkDefaultParser(null, TapUpdateApi$get0E7RQCE$$inlined$toCall$1.INSTANCE, 1, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpNoBodyParam2.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM54enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: get-0E7RQCE, reason: not valid java name */
    public final /* synthetic */ <T> Object m79get0E7RQCE(String str, Map<String, String> map, Continuation<? super Result<? extends T>> continuation) {
        TapHttpNoBodyParam tapHttpNoBodyParam = TapUpdateApiKt.getNetApi().get(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, entry.getKey(), entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(tapHttpNoBodyParam2, new TapHttpParser.SdkDefaultParser(null, TapUpdateApi$get0E7RQCE$$inlined$toCall$1.INSTANCE, 1, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpNoBodyParam2.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM54enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: post-BWLJW6A$default, reason: not valid java name */
    public static /* synthetic */ Object m78postBWLJW6A$default(TapUpdateApi tapUpdateApi, String str, Map map, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new LinkedHashMap();
        }
        int i2 = i & 4;
        ITapHttpResponseHandler iTapHttpResponseHandler = null;
        Object[] objArr = 0;
        if (i2 != 0) {
            str2 = null;
        }
        TapHttpJsonParam tapHttpJsonParamPostJson = TapUpdateApiKt.getNetApi().postJson(str);
        for (Map.Entry entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        if (str2 != null) {
            tapHttpJsonParamPostJson.addBody(new JSONObject(str2));
        }
        TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(tapHttpJsonParam, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, TapUpdateApi$postBWLJW6A$$inlined$toCall$1.INSTANCE, 1, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpJsonParam.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM54enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: post-BWLJW6A, reason: not valid java name */
    public final /* synthetic */ <T> Object m80postBWLJW6A(String str, Map<String, String> map, String str2, Continuation<? super Result<? extends T>> continuation) {
        TapHttpJsonParam tapHttpJsonParamPostJson = TapUpdateApiKt.getNetApi().postJson(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, entry.getKey(), entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        if (str2 != null) {
            tapHttpJsonParamPostJson.addBody(new JSONObject(str2));
        }
        TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(tapHttpJsonParam, new TapHttpParser.SdkDefaultParser(null, TapUpdateApi$postBWLJW6A$$inlined$toCall$1.INSTANCE, 1, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(tapHttpJsonParam.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM54enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }
}
