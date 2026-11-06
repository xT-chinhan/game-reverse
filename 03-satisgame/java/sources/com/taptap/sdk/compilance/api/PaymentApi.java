package com.taptap.sdk.compilance.api;

import com.anythink.core.common.l.f;
import com.taptap.sdk.compilance.bean.CheckPaymentResult;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.constants.RequestPath;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.internal.TapComplianceApi;
import com.taptap.sdk.compilance.internal.TapComplianceApiKt;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compilance.model.UserModel;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpResponseHandler;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* JADX INFO: compiled from: PaymentApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/compilance/api/PaymentApi;", "", "()V", "checkPayment", "Lkotlinx/coroutines/Job;", "amount", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compilance/bean/CheckPaymentResult;", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PaymentApi {
    public static final PaymentApi INSTANCE = new PaymentApi();

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.PaymentApi$checkPayment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PaymentApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.PaymentApi$checkPayment$1", f = "PaymentApi.kt", i = {}, l = {96, 23, 28}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $amount;
        final /* synthetic */ TapTapCallback<CheckPaymentResult> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, TapTapCallback<CheckPaymentResult> tapTapCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$amount = i;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$amount, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x013f  */
        /* JADX WARN: Code duplicated, block: B:40:0x0150 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            TapTapCallback<CheckPaymentResult> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            PaymentApi$checkPayment$1$2$1 paymentApi$checkPayment$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("amount", String.valueOf(this.$amount)));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(RequestPath.CHECK_PAYABLE);
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
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, CheckPaymentResult>() { // from class: com.taptap.sdk.compilance.api.PaymentApi$checkPayment$1$invokeSuspend$$inlined$get-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.CheckPaymentResult, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final CheckPaymentResult invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(CheckPaymentResult.class));
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
                        paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(thM187exceptionOrNullimpl, tapTapCallback, null);
                        this.L$0 = objM76enqueueResultgIAlus$default;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, this) == coroutine_suspended) {
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
            TapTapCallback<CheckPaymentResult> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
                PaymentApi$checkPayment$1$1$1 paymentApi$checkPayment$1$1$1 = new PaymentApi$checkPayment$1$1$1(tapTapCallback2, (CheckPaymentResult) objM76enqueueResultgIAlus$default, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 2;
                if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
            if (thM187exceptionOrNullimpl != null) {
                paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(thM187exceptionOrNullimpl, tapTapCallback, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 3;
                if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private PaymentApi() {
    }

    public final Job checkPayment(int amount, TapTapCallback<CheckPaymentResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new AnonymousClass1(amount, callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.PaymentApi$submitPayment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaymentApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.PaymentApi$submitPayment$1", f = "PaymentApi.kt", i = {}, l = {99, 49, 54}, m = "invokeSuspend", n = {}, s = {})
    static final class C04571 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $amount;
        final /* synthetic */ TapTapCallback<JsonElement> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04571(int i, TapTapCallback<JsonElement> tapTapCallback, Continuation<? super C04571> continuation) {
            super(1, continuation);
            this.$amount = i;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04571(this.$amount, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04571) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x012a  */
        /* JADX WARN: Code duplicated, block: B:40:0x013b A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            JSONObject jSONObject;
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            Object obj2;
            TapTapCallback<JsonElement> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            PaymentApi$submitPayment$1$2$1 paymentApi$submitPayment$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("amount", this.$amount);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                String string = jSONObject2.toString();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TapHttpJsonParam tapHttpJsonParamPostJson = TapComplianceApiKt.getNetApi().postJson(RequestPath.SUBMIT_PAYMENT);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                if (string != null) {
                    jSONObject = new JSONObject(string);
                } else {
                    jSONObject = new JSONObject();
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, f.aI, "1", false, 4, null);
                }
                tapHttpJsonParamPostJson.addBody(jSONObject);
                TapComplianceLoggerKt.logInfo("TapComplianceApi post: body=" + jSONObject);
                TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, JsonElement>() { // from class: com.taptap.sdk.compilance.api.PaymentApi$submitPayment$1$invokeSuspend$$inlined$post-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, kotlinx.serialization.json.JsonElement] */
                    @Override // kotlin.jvm.functions.Function1
                    public final JsonElement invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(JsonElement.class));
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
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(obj2);
                    if (thM187exceptionOrNullimpl != null) {
                        paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(thM187exceptionOrNullimpl, tapTapCallback, null);
                        this.L$0 = obj2;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, this) == coroutine_suspended) {
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
            obj2 = objM76enqueueResultgIAlus$default;
            TapTapCallback<JsonElement> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(obj2)) {
                PaymentApi$submitPayment$1$1$1 paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback2, (JsonElement) obj2, null);
                this.L$0 = obj2;
                this.label = 2;
                if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(obj2);
            if (thM187exceptionOrNullimpl != null) {
                paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(thM187exceptionOrNullimpl, tapTapCallback, null);
                this.L$0 = obj2;
                this.label = 3;
                if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Job submitPayment(int amount, TapTapCallback<JsonElement> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C04571(amount, callback, null));
    }
}
