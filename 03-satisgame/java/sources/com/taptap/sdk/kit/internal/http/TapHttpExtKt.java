package com.taptap.sdk.kit.internal.http;

import android.R;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.json.TapJson;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: TapHttpExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a8\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u0006\u0012\u0002\b\u00030\fH\u0086\b\u001a\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003*\u0006\u0012\u0002\b\u00030\f\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003*\u0006\u0012\u0002\b\u00030\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"enqueueResult", "Lkotlin/Result;", "T", "Lcom/taptap/sdk/kit/internal/http/call/TapHttpCall;", "onSuccess", "Lkotlin/Function1;", "", "(Lcom/taptap/sdk/kit/internal/http/call/TapHttpCall;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeResult", "(Lcom/taptap/sdk/kit/internal/http/call/TapHttpCall;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toCall", "DataBean", "Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "toEventCall", "", "toOpenLogCall", "tap-kit_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapHttpExtKt {

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.http.TapHttpExtKt$enqueueResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapHttpExt.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.http.TapHttpExtKt", f = "TapHttpExt.kt", i = {0}, l = {22}, m = "enqueueResult", n = {"onSuccess"}, s = {"L$0"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objEnqueueResult = TapHttpExtKt.enqueueResult(null, null, this);
            return objEnqueueResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEnqueueResult : Result.m183boximpl(objEnqueueResult);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <DataBean> TapHttpCall<DataBean> toCall(AbsTapHttpParam<?> absTapHttpParam) {
        Intrinsics.checkNotNullParameter(absTapHttpParam, "<this>");
        Intrinsics.needClassReification();
        return new TapHttpCall<>(absTapHttpParam, new TapHttpParser.SdkDefaultParser(null, new Function1<JsonObject, DataBean>() { // from class: com.taptap.sdk.kit.internal.http.TapHttpExtKt.toCall.1
            @Override // kotlin.jvm.functions.Function1
            public final DataBean invoke(JsonObject jsonObject) {
                TapJson tapJson = TapJson.INSTANCE;
                try {
                    if (jsonObject == null) {
                        return null;
                    }
                    Json json = tapJson.getJson();
                    SerializersModule serializersModule = json.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, "DataBean?");
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(serializersModule, (KType) null);
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    KSerializer<Object> kSerializer = kSerializerSerializer;
                    return (DataBean) json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    return null;
                }
            }
        }, 1, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParam.getBackoffHandler()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object enqueueResult(TapHttpCall<T> tapHttpCall, Function1<? super T, Unit> function1, Continuation<? super Result<? extends T>> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM76enqueueResultgIAlus$default;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass2.L$0 = function1;
            anonymousClass2.label = 1;
            objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(tapHttpCall, 0L, anonymousClass2, 1, null);
            if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
        }
        if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
            function1.invoke(objM76enqueueResultgIAlus$default);
        }
        return objM76enqueueResultgIAlus$default;
    }

    public static final <T> Object executeResult(TapHttpCall<T> tapHttpCall, Function1<? super T, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(tapHttpCall, "<this>");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        R.bool boolVar = (Object) ITapHttpCall.DefaultImpls.m78executeResultIoAF18A$default(tapHttpCall, 0L, 1, null);
        if (Result.m191isSuccessimpl(boolVar)) {
            onSuccess.invoke(boolVar);
        }
        return boolVar;
    }

    public static final TapHttpCall<Boolean> toEventCall(AbsTapHttpParam<?> absTapHttpParam) {
        Intrinsics.checkNotNullParameter(absTapHttpParam, "<this>");
        return new TapHttpCall<>(absTapHttpParam, new TapHttpParser.EventParser(), new TapHttpRetry.NoneRetry());
    }

    public static final TapHttpCall<Boolean> toOpenLogCall(AbsTapHttpParam<?> absTapHttpParam) {
        Intrinsics.checkNotNullParameter(absTapHttpParam, "<this>");
        return new TapHttpCall<>(absTapHttpParam, new TapHttpParser.OpenLogParser(), new TapHttpRetry.NoneRetry());
    }
}
