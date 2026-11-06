package com.taptap.sdk.compliance.api;

import com.mar.sdk.IAction;
import com.taptap.sdk.compliance.bean.CheckPaymentResult;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.constants.RequestPath;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.ComplianceApiService;
import com.taptap.sdk.compliance.internal.TapComplianceApi;
import com.taptap.sdk.compliance.internal.TapComplianceApiKt;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.model.UserModel;
import com.taptap.sdk.kit.internal.TapLogger;
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
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONObject;

/* JADX INFO: compiled from: PaymentApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/compliance/api/PaymentApi;", "", "()V", "checkPayment", "Lkotlinx/coroutines/Job;", IAction.BuyKey.CostAmount, "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compliance/bean/CheckPaymentResult;", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PaymentApi {
    public static final PaymentApi INSTANCE = new PaymentApi();

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.PaymentApi$checkPayment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PaymentApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.PaymentApi$checkPayment$1", f = "PaymentApi.kt", i = {}, l = {77, 23, 28}, m = "invokeSuspend", n = {}, s = {})
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

        /* JADX WARN: Code duplicated, block: B:26:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:32:0x00f0 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:23:0x00b6, B:32:0x00f0, B:33:0x00f8, B:34:0x0103, B:27:0x00bf, B:30:0x00e4), top: B:56:0x00b6, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00f8 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:23:0x00b6, B:32:0x00f0, B:33:0x00f8, B:34:0x0103, B:27:0x00bf, B:30:0x00e4), top: B:56:0x00b6, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0120  */
        /* JADX WARN: Code duplicated, block: B:44:0x0136 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x0137  */
        /* JADX WARN: Code duplicated, block: B:49:0x0142  */
        /* JADX WARN: Code duplicated, block: B:51:0x0155 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x0156  */
        /* JADX WARN: Code duplicated, block: B:61:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object $result;
            int i;
            int i2;
            String accessToken;
            Object $result2;
            TapJson this_$iv$iv;
            Object $result3;
            Object $result4;
            AnonymousClass1 anonymousClass2;
            TapTapCallback<CheckPaymentResult> tapTapCallback;
            PaymentApi$checkPayment$1$1$1 paymentApi$checkPayment$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<CheckPaymentResult> tapTapCallback2;
            Throwable it;
            PaymentApi$checkPayment$1$2$1 paymentApi$checkPayment$1$2$1;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                    $result = obj;
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    Map queryMap$iv = MapsKt.mutableMapOf(TuplesKt.to(IAction.BuyKey.CostAmount, String.valueOf(anonymousClass1.$amount)));
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
                        Object obj2 = api.get(RequestPath.CHECK_PAYABLE, mutableMap, mutableMap2, anonymousClass1);
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
                                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(CheckPaymentResult.class));
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
                            anonymousClass2 = anonymousClass1;
                            $result3 = $result2;
                            tapTapCallback = anonymousClass2.$callback;
                            if (Result.m541isSuccessimpl($result4)) {
                                paymentApi$checkPayment$1$1$1 = new PaymentApi$checkPayment$1$1$1(tapTapCallback, (CheckPaymentResult) $result4, null);
                                anonymousClass2.L$0 = $result4;
                                anonymousClass2.label = 2;
                                if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$1$1, anonymousClass2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            tapTapCallback2 = anonymousClass2.$callback;
                            it = Result.m537exceptionOrNullimpl($result4);
                            if (it != null) {
                                paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(it, tapTapCallback2, null);
                                anonymousClass2.L$0 = $result4;
                                anonymousClass2.label = 3;
                                if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, anonymousClass2) == coroutine_suspended) {
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
                            anonymousClass2 = anonymousClass1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = 0;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        anonymousClass2 = anonymousClass1;
                        tapTapCallback = anonymousClass2.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            paymentApi$checkPayment$1$1$1 = new PaymentApi$checkPayment$1$1$1(tapTapCallback, (CheckPaymentResult) $result4, null);
                            anonymousClass2.L$0 = $result4;
                            anonymousClass2.label = 2;
                            if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$1$1, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = anonymousClass2.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(it, tapTapCallback2, null);
                            anonymousClass2.L$0 = $result4;
                            anonymousClass2.label = 3;
                            if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
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
                        i = 0;
                        $result2 = $result;
                        data$iv$iv = (JsonElement) $result;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(CheckPaymentResult.class));
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
                        anonymousClass2 = anonymousClass1;
                        $result3 = $result2;
                        tapTapCallback = anonymousClass2.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            paymentApi$checkPayment$1$1$1 = new PaymentApi$checkPayment$1$1$1(tapTapCallback, (CheckPaymentResult) $result4, null);
                            anonymousClass2.L$0 = $result4;
                            anonymousClass2.label = 2;
                            if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$1$1, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = anonymousClass2.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(it, tapTapCallback2, null);
                            anonymousClass2.L$0 = $result4;
                            anonymousClass2.label = 3;
                            if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, anonymousClass2) == coroutine_suspended) {
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
                        anonymousClass2 = anonymousClass1;
                        tapTapCallback = anonymousClass2.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            paymentApi$checkPayment$1$1$1 = new PaymentApi$checkPayment$1$1$1(tapTapCallback, (CheckPaymentResult) $result4, null);
                            anonymousClass2.L$0 = $result4;
                            anonymousClass2.label = 2;
                            if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$1$1, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = anonymousClass2.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(it, tapTapCallback2, null);
                            anonymousClass2.L$0 = $result4;
                            anonymousClass2.label = 3;
                            if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    anonymousClass2 = this;
                    $result3 = obj;
                    $result4 = anonymousClass2.L$0;
                    ResultKt.throwOnFailure($result3);
                    tapTapCallback2 = anonymousClass2.$callback;
                    it = Result.m537exceptionOrNullimpl($result4);
                    if (it != null) {
                        paymentApi$checkPayment$1$2$1 = new PaymentApi$checkPayment$1$2$1(it, tapTapCallback2, null);
                        anonymousClass2.L$0 = $result4;
                        anonymousClass2.label = 3;
                        if (SystemExtKt.dispatchMain(paymentApi$checkPayment$1$2$1, anonymousClass2) == coroutine_suspended) {
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

    private PaymentApi() {
    }

    public final Job checkPayment(int amount, TapTapCallback<CheckPaymentResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new AnonymousClass1(amount, callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.PaymentApi$submitPayment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaymentApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.PaymentApi$submitPayment$1", f = "PaymentApi.kt", i = {}, l = {98, 48, 53}, m = "invokeSuspend", n = {}, s = {})
    static final class C03071 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $amount;
        final /* synthetic */ TapTapCallback<JsonElement> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03071(int i, TapTapCallback<JsonElement> tapTapCallback, Continuation<? super C03071> continuation) {
            super(1, continuation);
            this.$amount = i;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03071(this.$amount, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03071) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00ca A[Catch: all -> 0x01b2, TryCatch #1 {all -> 0x01b2, blocks: (B:14:0x0073, B:16:0x0078, B:27:0x00c5, B:30:0x00d9, B:31:0x00f0, B:33:0x00f6, B:34:0x0119, B:36:0x0136, B:39:0x013e, B:23:0x0090, B:26:0x00bd, B:29:0x00ca), top: B:78:0x0073, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00f6 A[Catch: all -> 0x01b2, LOOP:0: B:31:0x00f0->B:33:0x00f6, LOOP_END, TryCatch #1 {all -> 0x01b2, blocks: (B:14:0x0073, B:16:0x0078, B:27:0x00c5, B:30:0x00d9, B:31:0x00f0, B:33:0x00f6, B:34:0x0119, B:36:0x0136, B:39:0x013e, B:23:0x0090, B:26:0x00bd, B:29:0x00ca), top: B:78:0x0073, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x013c  */
        /* JADX WARN: Code duplicated, block: B:41:0x015c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x015d  */
        /* JADX WARN: Code duplicated, block: B:46:0x016a  */
        /* JADX WARN: Code duplicated, block: B:52:0x0199 A[Catch: all -> 0x01ad, TryCatch #4 {all -> 0x01ad, blocks: (B:43:0x0163, B:52:0x0199, B:53:0x01a1, B:54:0x01ac, B:47:0x016c, B:50:0x018e), top: B:84:0x0163, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x01a1 A[Catch: all -> 0x01ad, TryCatch #4 {all -> 0x01ad, blocks: (B:43:0x0163, B:52:0x0199, B:53:0x01a1, B:54:0x01ac, B:47:0x016c, B:50:0x018e), top: B:84:0x0163, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x01cc  */
        /* JADX WARN: Code duplicated, block: B:64:0x01e3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:65:0x01e4  */
        /* JADX WARN: Code duplicated, block: B:69:0x01ef  */
        /* JADX WARN: Code duplicated, block: B:71:0x0203 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:72:0x0204  */
        /* JADX WARN: Code duplicated, block: B:80:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C03071 c03071;
            Object $result;
            int i;
            int i2;
            Map mapBuild;
            JsonObjectBuilder builder$iv$iv;
            UserInfo currentUser;
            String accessToken;
            TapJson tapJson;
            Object objPost;
            TapJson this_$iv$iv;
            Object $result2;
            Object objDecodeFromString;
            Object $result3;
            C03071 c03072;
            Object $result4;
            TapTapCallback<JsonElement> tapTapCallback;
            PaymentApi$submitPayment$1$1$1 paymentApi$submitPayment$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<JsonElement> tapTapCallback2;
            Throwable it;
            PaymentApi$submitPayment$1$2$1 paymentApi$submitPayment$1$2$1;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c03071 = this;
                    $result = obj;
                    JSONObject body = new JSONObject();
                    body.put(IAction.BuyKey.CostAmount, c03071.$amount);
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    String body$iv = body.toString();
                    Map queryMap$iv = new LinkedHashMap();
                    i = 0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        if (body$iv != null) {
                            TapJson this_$iv$iv2 = TapJson.INSTANCE;
                            if (body$iv.length() == 0) {
                                objDecodeFromString = null;
                            } else {
                                try {
                                    StringFormat $this$decodeFromString$iv$iv$iv = this_$iv$iv2.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromString$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(JsonObject.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromString = $this$decodeFromString$iv$iv$iv.decodeFromString(kSerializerSerializer, body$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromString = null;
                                }
                            }
                            mapBuild = (JsonObject) objDecodeFromString;
                            if (mapBuild == null) {
                                mapBuild = new JsonObjectBuilder().build();
                            }
                            Map postBody$iv = mapBuild;
                            builder$iv$iv = new JsonObjectBuilder();
                            Map $this$forEach$iv$iv = postBody$iv;
                            for (Map.Entry<String, JsonElement> entry : $this$forEach$iv$iv.entrySet()) {
                                String key$iv = entry.getKey();
                                JsonElement value$iv = entry.getValue();
                                builder$iv$iv.put(key$iv, value$iv);
                            }
                            JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                            JsonObject requestBody$iv = builder$iv$iv.build();
                            currentUser = UserModel.INSTANCE.getCurrentUser();
                            if (currentUser != null || (accessToken = currentUser.getAccessToken()) == null) {
                                accessToken = "";
                            }
                            Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                            tapJson = TapJson.INSTANCE;
                            ComplianceApiService api = TapComplianceApiKt.getApi();
                            c03071.L$0 = tapJson;
                            c03071.label = 1;
                            objPost = api.post(RequestPath.SUBMIT_PAYMENT, queryMap$iv, mapMapOf, requestBody$iv, c03071);
                            if (objPost == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this_$iv$iv = tapJson;
                            $result = objPost;
                            $result2 = $result;
                            try {
                                data$iv$iv = (JsonElement) $result;
                                if (data$iv$iv == null) {
                                    objDecodeFromJsonElement = null;
                                } else {
                                    try {
                                        Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                        SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                        KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(JsonElement.class));
                                        Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                        objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer2, data$iv$iv);
                                    } catch (Exception e$iv$iv2) {
                                        TapLogger.loge$default(TapJson.TAG, null, e$iv$iv2, 2, null);
                                        objDecodeFromJsonElement = null;
                                    }
                                }
                                if (objDecodeFromJsonElement == null) {
                                    throw new IllegalStateException("empty compliance response".toString());
                                }
                                Object objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                                $result4 = $result2;
                                $result3 = objM534constructorimpl;
                                c03072 = c03071;
                                tapTapCallback = c03072.$callback;
                                if (Result.m541isSuccessimpl($result3)) {
                                    paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback, (JsonElement) $result3, null);
                                    c03072.L$0 = $result3;
                                    c03072.label = 2;
                                    if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, c03072) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                tapTapCallback2 = c03072.$callback;
                                it = Result.m537exceptionOrNullimpl($result3);
                                if (it != null) {
                                    paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(it, tapTapCallback2, null);
                                    c03072.L$0 = $result3;
                                    c03072.label = 3;
                                    if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, c03072) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result5 = $result4;
                                }
                            } catch (Throwable th) {
                                th = th;
                                $result = $result2;
                                i2 = i;
                                Result.Companion companion2 = Result.INSTANCE;
                                $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                                c03072 = c03071;
                                $result4 = $result;
                            }
                        } else {
                            mapBuild = new JsonObjectBuilder().build();
                            Map postBody$iv2 = mapBuild;
                            builder$iv$iv = new JsonObjectBuilder();
                            Map $this$forEach$iv$iv2 = postBody$iv2;
                            while (r16.hasNext()) {
                                String key$iv2 = entry.getKey();
                                JsonElement value$iv2 = entry.getValue();
                                builder$iv$iv.put(key$iv2, value$iv2);
                            }
                            JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                            JsonObject requestBody$iv2 = builder$iv$iv.build();
                            currentUser = UserModel.INSTANCE.getCurrentUser();
                            if (currentUser != null) {
                                accessToken = "";
                            } else {
                                accessToken = "";
                            }
                            Map<String, String> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                            tapJson = TapJson.INSTANCE;
                            ComplianceApiService api2 = TapComplianceApiKt.getApi();
                            c03071.L$0 = tapJson;
                            c03071.label = 1;
                            objPost = api2.post(RequestPath.SUBMIT_PAYMENT, queryMap$iv, mapMapOf2, requestBody$iv2, c03071);
                            if (objPost == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this_$iv$iv = tapJson;
                            $result = objPost;
                            $result2 = $result;
                            data$iv$iv = (JsonElement) $result;
                            if (data$iv$iv == null) {
                                Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                                SerializersModule $this$serializer$iv$iv$iv$iv3 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                                KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv3, Reflection.typeOf(JsonElement.class));
                                Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer3, data$iv$iv);
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement == null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            Object objM534constructorimpl2 = Result.m534constructorimpl(objDecodeFromJsonElement);
                            $result4 = $result2;
                            $result3 = objM534constructorimpl2;
                            c03072 = c03071;
                            tapTapCallback = c03072.$callback;
                            if (Result.m541isSuccessimpl($result3)) {
                                paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback, (JsonElement) $result3, null);
                                c03072.L$0 = $result3;
                                c03072.label = 2;
                                if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, c03072) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            tapTapCallback2 = c03072.$callback;
                            it = Result.m537exceptionOrNullimpl($result3);
                            if (it != null) {
                                paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(it, tapTapCallback2, null);
                                c03072.L$0 = $result3;
                                c03072.label = 3;
                                if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, c03072) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result4;
                            }
                        }
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = 0;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03072 = c03071;
                        $result4 = $result;
                        tapTapCallback = c03072.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback, (JsonElement) $result3, null);
                            c03072.L$0 = $result3;
                            c03072.label = 2;
                            if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, c03072) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03072.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(it, tapTapCallback2, null);
                            c03072.L$0 = $result3;
                            c03072.label = 3;
                            if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, c03072) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result4;
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03071 = this;
                    $result = obj;
                    i2 = 0;
                    this_$iv$iv = (TapJson) c03071.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $result2 = $result;
                        i = 0;
                        data$iv$iv = (JsonElement) $result;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv3 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv4 = $this$decodeFromJsonElement$iv$iv$iv3.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer4 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv4, Reflection.typeOf(JsonElement.class));
                            Intrinsics.checkNotNull(kSerializerSerializer4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv3.decodeFromJsonElement(kSerializerSerializer4, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement == null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        Object objM534constructorimpl3 = Result.m534constructorimpl(objDecodeFromJsonElement);
                        $result4 = $result2;
                        $result3 = objM534constructorimpl3;
                        c03072 = c03071;
                        tapTapCallback = c03072.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback, (JsonElement) $result3, null);
                            c03072.L$0 = $result3;
                            c03072.label = 2;
                            if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, c03072) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03072.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(it, tapTapCallback2, null);
                            c03072.L$0 = $result3;
                            c03072.label = 3;
                            if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, c03072) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result4;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03072 = c03071;
                        $result4 = $result;
                        tapTapCallback = c03072.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            paymentApi$submitPayment$1$1$1 = new PaymentApi$submitPayment$1$1$1(tapTapCallback, (JsonElement) $result3, null);
                            c03072.L$0 = $result3;
                            c03072.label = 2;
                            if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$1$1, c03072) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03072.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(it, tapTapCallback2, null);
                            c03072.L$0 = $result3;
                            c03072.label = 3;
                            if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, c03072) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result4;
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    c03072 = this;
                    $result4 = obj;
                    $result3 = c03072.L$0;
                    ResultKt.throwOnFailure($result4);
                    tapTapCallback2 = c03072.$callback;
                    it = Result.m537exceptionOrNullimpl($result3);
                    if (it != null) {
                        paymentApi$submitPayment$1$2$1 = new PaymentApi$submitPayment$1$2$1(it, tapTapCallback2, null);
                        c03072.L$0 = $result3;
                        c03072.label = 3;
                        if (SystemExtKt.dispatchMain(paymentApi$submitPayment$1$2$1, c03072) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result5 = $result4;
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

    public final Job submitPayment(int amount, TapTapCallback<JsonElement> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C03071(amount, callback, null));
    }
}
