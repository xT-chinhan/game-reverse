package com.taptap.sdk.compliance.api;

import com.tapsdk.tapad.internal.tracker.experiment.d;
import com.taptap.sdk.compliance.bean.CheckPaymentResult;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.constants.RequestPath;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.TapComplianceApi;
import com.taptap.sdk.compliance.internal.TapComplianceApiKt;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.model.UserModel;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/compliance/api/PaymentApi;", "", "()V", "checkPayment", "Lkotlinx/coroutines/Job;", d.q, "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compliance/bean/CheckPaymentResult;", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PaymentApi {
    public static final PaymentApi INSTANCE = new PaymentApi();

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.PaymentApi$checkPayment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PaymentApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.PaymentApi$checkPayment$1", f = "PaymentApi.kt", i = {}, l = {98, 23, 28}, m = "invokeSuspend", n = {}, s = {})
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

        /* JADX WARN: Code duplicated, block: B:35:0x013d  */
        /* JADX WARN: Code duplicated, block: B:37:0x014e A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String accessToken;
            Object objM54enqueueResultgIAlus$default;
            TapTapCallback<CheckPaymentResult> tapTapCallback;
            Throwable thM177exceptionOrNullimpl;
            PaymentApi$checkPayment$1$2$1 paymentApi$checkPayment$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(d.q, String.valueOf(this.$amount)));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(RequestPath.CHECK_PAYABLE);
                for (Map.Entry entry : mapMutableMapOf.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, (String) entry2.getKey(), (String) entry2.getValue(), false, 4, null);
                }
                TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
                AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam2, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId(), false, 4, null);
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, CheckPaymentResult>() { // from class: com.taptap.sdk.compliance.api.PaymentApi$checkPayment$1$invokeSuspend$$inlined$get-yxL6bBk$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compliance.bean.CheckPaymentResult, java.lang.Object] */
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
                if (objM54enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM54enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    objM54enqueueResultgIAlus$default = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM54enqueueResultgIAlus$default);
                    if (thM177exceptionOrNullimpl != null) {
                        paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(thM177exceptionOrNullimpl, tapTapCallback, null);
                        this.L$0 = objM54enqueueResultgIAlus$default;
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
            if (Result.m181isSuccessimpl(objM54enqueueResultgIAlus$default)) {
                PaymentApi$checkPayment$1$1$1 paymentApi$checkPayment$1$1$1 = new PaymentApi$checkPayment$1$1$1(tapTapCallback2, (CheckPaymentResult) objM54enqueueResultgIAlus$default, null);
                this.L$0 = objM54enqueueResultgIAlus$default;
                this.label = 2;
                if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM54enqueueResultgIAlus$default);
            if (thM177exceptionOrNullimpl != null) {
                paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(thM177exceptionOrNullimpl, tapTapCallback, null);
                this.L$0 = objM54enqueueResultgIAlus$default;
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

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.PaymentApi$submitPayment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaymentApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.PaymentApi$submitPayment$1", f = "PaymentApi.kt", i = {}, l = {99, 49, 54}, m = "invokeSuspend", n = {}, s = {})
    static final class C07831 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $amount;
        final /* synthetic */ TapTapCallback<JsonElement> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07831(int i, TapTapCallback<JsonElement> tapTapCallback, Continuation<? super C07831> continuation) {
            super(1, continuation);
            this.$amount = i;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C07831(this.$amount, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C07831) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x010d  */
        /* JADX WARN: Code duplicated, block: B:37:0x011e A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            JSONObject jSONObject;
            String accessToken;
            Object objM54enqueueResultgIAlus$default;
            Object obj2;
            TapTapCallback<JsonElement> tapTapCallback;
            Throwable thM177exceptionOrNullimpl;
            PaymentApi$submitPayment$1$2$1 paymentApi$submitPayment$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.q, this.$amount);
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
                jSONObject.put(BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                tapHttpJsonParamPostJson.addBody(jSONObject);
                TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM54enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m54enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, JsonElement>() { // from class: com.taptap.sdk.compliance.api.PaymentApi$submitPayment$1$invokeSuspend$$inlined$post-yxL6bBk$default$1
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
                if (objM54enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM54enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(obj2);
                    if (thM177exceptionOrNullimpl != null) {
                        paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(thM177exceptionOrNullimpl, tapTapCallback, null);
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
            obj2 = objM54enqueueResultgIAlus$default;
            TapTapCallback<JsonElement> tapTapCallback2 = this.$callback;
            if (Result.m181isSuccessimpl(obj2)) {
                PaymentApi$submitPayment$1$1$1 paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback2, (JsonElement) obj2, null);
                this.L$0 = obj2;
                this.label = 2;
                if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(obj2);
            if (thM177exceptionOrNullimpl != null) {
                paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(thM177exceptionOrNullimpl, tapTapCallback, null);
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
        return SystemExtKt.runAsync(new C07831(amount, callback, null));
    }
}
