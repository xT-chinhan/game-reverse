package com.taptap.sdk.common.network.transform;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.taptap.sdk.base.network.transform.BizTransformer;
import com.taptap.sdk.common.network.data.response.BaseResponse;
import com.taptap.sdk.common.network.data.response.ErrResponse;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.time.TapTime;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: DefaultBizTransformer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/common/network/transform/DefaultBizTransformer;", "Lcom/taptap/sdk/base/network/transform/BizTransformer;", "()V", "parseBaseResponse", "Lcom/taptap/sdk/common/network/data/response/BaseResponse;", "jsonStr", "", "parseErrorResponse", "Lcom/taptap/sdk/common/network/data/response/ErrResponse;", "data", "Lkotlinx/serialization/json/JsonElement;", "transform", "Ljava/io/InputStream;", LiveConfigKey.ORIGIN, "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultBizTransformer implements BizTransformer {
    @Override // com.taptap.sdk.base.network.transform.BizTransformer
    public InputStream transform(InputStream origin) throws TapNetworkException {
        Intrinsics.checkNotNullParameter(origin, "origin");
        BaseResponse response = parseBaseResponse(new String(ByteStreamsKt.readBytes(origin), Charsets.UTF_8));
        TapTime.INSTANCE.calibrateServerTime(Integer.valueOf(response.getNow()));
        if (response.getSuccess()) {
            StringFormat $this$encodeToString$iv = Json.INSTANCE;
            JsonElement data = response.getData();
            SerializersModule $this$serializer$iv$iv = $this$encodeToString$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(JsonElement.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            byte[] bytes = $this$encodeToString$iv.encodeToString(kSerializerSerializer, data).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        ErrResponse serverError = parseErrorResponse(response.getData());
        if (serverError.getCode() != 0) {
            if (serverError.getError().length() > 0) {
                TapNetworkException.Err err = new TapNetworkException.Err(ApiErr.INSTANCE.from(serverError.getError()), serverError.getCode(), serverError.getMsg(), serverError.getDescription());
                throw new TapNetworkException(err, null, 2, null);
            }
        }
        StringFormat $this$encodeToString$iv2 = Json.INSTANCE;
        JsonElement data2 = response.getData();
        SerializersModule $this$serializer$iv$iv2 = $this$encodeToString$iv2.getSerializersModule();
        KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv2, Reflection.typeOf(JsonElement.class));
        Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        byte[] bytes2 = $this$encodeToString$iv2.encodeToString(kSerializerSerializer2, data2).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes2);
    }

    private final BaseResponse parseBaseResponse(String jsonStr) throws TapNetworkException {
        BaseResponse baseResponse;
        try {
            StringFormat $this$decodeFromString$iv = TapJson.INSTANCE.getJson();
            SerializersModule $this$serializer$iv$iv = $this$decodeFromString$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(BaseResponse.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            baseResponse = (BaseResponse) $this$decodeFromString$iv.decodeFromString(kSerializerSerializer, jsonStr);
        } catch (Exception e) {
            baseResponse = null;
        }
        BaseResponse baseResponse2 = baseResponse;
        if (!(baseResponse2 == null)) {
            return baseResponse2;
        }
        throw new TapNetworkException(new TapNetworkException.Err(ApiErr.JSON_PARSE_ERROR.INSTANCE, -1, "parse jsonStr fail", null), null, 2, null);
    }

    private final ErrResponse parseErrorResponse(JsonElement data) throws TapNetworkException {
        ErrResponse errResponse;
        try {
            Json $this$decodeFromJsonElement$iv = TapJson.INSTANCE.getJson();
            SerializersModule $this$serializer$iv$iv = $this$decodeFromJsonElement$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(ErrResponse.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            errResponse = (ErrResponse) $this$decodeFromJsonElement$iv.decodeFromJsonElement(kSerializerSerializer, data);
        } catch (Exception e) {
            errResponse = null;
        }
        ErrResponse errorResponse = errResponse;
        if (!(errorResponse == null)) {
            return errorResponse;
        }
        throw new TapNetworkException(new TapNetworkException.Err(ApiErr.JSON_PARSE_ERROR.INSTANCE, -1, "parse BaseResponse.data fail", null), null, 2, null);
    }
}
