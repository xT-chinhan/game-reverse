package com.taptap.sdk.kit.internal.http.hanlder;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.bean.TapHttpResponse;
import com.taptap.sdk.kit.internal.bean.TapHttpResponseError;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.okhttp3.ResponseBody;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: TapHttpParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/hanlder/TapHttpParser;", "", "()V", "EventParser", "SdkDefaultParser", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttpParser {

    /* JADX INFO: compiled from: TapHttpParser.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0002\u0010\bJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/hanlder/TapHttpParser$SdkDefaultParser;", "DataBean", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpParser;", "responseHandler", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpResponseHandler;", "parserResponse", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonObject;", "(Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpResponseHandler;Lkotlin/jvm/functions/Function1;)V", "getParserResponse", "()Lkotlin/jvm/functions/Function1;", "parse", "Lkotlin/Result;", "response", "Lcom/taptap/sdk/okhttp3/Response;", "parse-IoAF18A", "(Lcom/taptap/sdk/okhttp3/Response;)Ljava/lang/Object;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SdkDefaultParser<DataBean> implements ITapHttpParser<DataBean> {
        private final Function1<JsonObject, DataBean> parserResponse;
        private final ITapHttpResponseHandler<DataBean> responseHandler;

        /* JADX WARN: Multi-variable type inference failed */
        public SdkDefaultParser(ITapHttpResponseHandler<DataBean> iTapHttpResponseHandler, Function1<? super JsonObject, ? extends DataBean> parserResponse) {
            Intrinsics.checkNotNullParameter(parserResponse, "parserResponse");
            this.responseHandler = iTapHttpResponseHandler;
            this.parserResponse = parserResponse;
        }

        public /* synthetic */ SdkDefaultParser(ITapHttpResponseHandler iTapHttpResponseHandler, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : iTapHttpResponseHandler, function1);
        }

        public final Function1<JsonObject, DataBean> getParserResponse() {
            return this.parserResponse;
        }

        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpParser
        /* JADX INFO: renamed from: parse-IoAF18A */
        public Object mo421parseIoAF18A(Response response) {
            Object objDecodeFromString;
            Object objDecodeFromJsonElement;
            Object objDecodeFromString2;
            Intrinsics.checkNotNullParameter(response, "response");
            int code = response.code();
            Object objDecodeFromJsonElement2 = null;
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                String body = responseBodyBody != null ? responseBodyBody.string() : null;
                TapJson this_$iv = TapJson.INSTANCE;
                String str = body;
                if (str == null || str.length() == 0) {
                    objDecodeFromString2 = null;
                } else {
                    try {
                        StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(TapHttpResponse.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(JsonObject.class))));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString2 = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, body);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        objDecodeFromString2 = null;
                    }
                }
                TapHttpResponse<JsonObject> tapHttpResponse = (TapHttpResponse) objDecodeFromString2;
                ITapHttpResponseHandler<DataBean> iTapHttpResponseHandler = this.responseHandler;
                Result<DataBean> resultM422handleResponseCmtIpJM = iTapHttpResponseHandler != null ? iTapHttpResponseHandler.m422handleResponseCmtIpJM(tapHttpResponse) : null;
                if (resultM422handleResponseCmtIpJM != null) {
                    return resultM422handleResponseCmtIpJM.getValue();
                }
                Boolean boolValueOf = tapHttpResponse != null ? Boolean.valueOf(tapHttpResponse.getSuccess()) : null;
                if (Intrinsics.areEqual((Object) boolValueOf, (Object) true)) {
                    TapTime.INSTANCE.calibrateServerTime(tapHttpResponse.getNow());
                    Object data = this.parserResponse.invoke(tapHttpResponse.getData());
                    if (data != null) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m534constructorimpl(data);
                    }
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.ParseDataError(code, tapHttpResponse)));
                }
                if (Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
                    TapTime.INSTANCE.calibrateServerTime(tapHttpResponse.getNow());
                    TapJson this_$iv2 = TapJson.INSTANCE;
                    JsonElement data$iv = tapHttpResponse.getData();
                    if (data$iv != null) {
                        try {
                            Json $this$decodeFromJsonElement$iv$iv = this_$iv2.getJson();
                            SerializersModule $this$serializer$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv2, Reflection.typeOf(TapHttpResponseError.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement2 = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer2, data$iv);
                        } catch (Exception e$iv2) {
                            TapLogger.loge$default(TapJson.TAG, null, e$iv2, 2, null);
                            objDecodeFromJsonElement2 = null;
                        }
                    }
                    TapHttpResponseError responseError = (TapHttpResponseError) objDecodeFromJsonElement2;
                    if (responseError != null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.ServerError(code, tapHttpResponse, responseError)));
                    }
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.NoServerError(code, body)));
                }
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.NoServerError(code, body)));
            }
            ResponseBody responseBodyBody2 = response.body();
            String body2 = responseBodyBody2 != null ? responseBodyBody2.string() : null;
            TapJson this_$iv3 = TapJson.INSTANCE;
            String str2 = body2;
            if (str2 == null || str2.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    StringFormat $this$decodeFromString$iv$iv2 = this_$iv3.getJson();
                    SerializersModule $this$serializer$iv$iv$iv3 = $this$decodeFromString$iv$iv2.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv3, Reflection.typeOf(TapHttpResponse.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(JsonObject.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = $this$decodeFromString$iv$iv2.decodeFromString(kSerializerSerializer3, body2);
                } catch (Exception e$iv3) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv3, 2, null);
                    objDecodeFromString = null;
                }
            }
            TapHttpResponse httpResponse = (TapHttpResponse) objDecodeFromString;
            TapTime.INSTANCE.calibrateServerTime(httpResponse != null ? httpResponse.getNow() : null);
            if (httpResponse != null && !httpResponse.getSuccess()) {
                TapJson this_$iv4 = TapJson.INSTANCE;
                JsonElement data$iv2 = (JsonElement) httpResponse.getData();
                if (data$iv2 == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    try {
                        Json $this$decodeFromJsonElement$iv$iv2 = this_$iv4.getJson();
                        SerializersModule $this$serializer$iv$iv$iv4 = $this$decodeFromJsonElement$iv$iv2.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer4 = SerializersKt.serializer($this$serializer$iv$iv$iv4, Reflection.typeOf(TapHttpResponseError.class));
                        Intrinsics.checkNotNull(kSerializerSerializer4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv2.decodeFromJsonElement(kSerializerSerializer4, data$iv2);
                    } catch (Exception e$iv4) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv4, 2, null);
                        objDecodeFromJsonElement = null;
                    }
                }
                TapHttpResponseError responseError2 = (TapHttpResponseError) objDecodeFromJsonElement;
                if (responseError2 != null) {
                    String error = responseError2.getError();
                    if (!(error == null || error.length() == 0)) {
                        Result.Companion companion6 = Result.INSTANCE;
                        return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.ServerError(code, httpResponse, responseError2)));
                    }
                }
                Result.Companion companion7 = Result.INSTANCE;
                return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.NoServerError(code, body2)));
            }
            Result.Companion companion8 = Result.INSTANCE;
            return Result.m534constructorimpl(ResultKt.createFailure(new TapHttpException.NoServerError(code, body2)));
        }
    }

    /* JADX INFO: compiled from: TapHttpParser.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/hanlder/TapHttpParser$EventParser;", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpParser;", "", "()V", "parse", "Lkotlin/Result;", "response", "Lcom/taptap/sdk/okhttp3/Response;", "parse-IoAF18A", "(Lcom/taptap/sdk/okhttp3/Response;)Ljava/lang/Object;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EventParser implements ITapHttpParser<Boolean> {
        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpParser
        /* JADX INFO: renamed from: parse-IoAF18A */
        public Object mo421parseIoAF18A(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful() || response.code() == 400) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m534constructorimpl(true);
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m534constructorimpl(false);
        }
    }
}
