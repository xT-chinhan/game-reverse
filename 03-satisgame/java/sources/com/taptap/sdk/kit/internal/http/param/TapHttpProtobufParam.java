package com.taptap.sdk.kit.internal.http.param;

import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign;
import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.RequestBody;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapHttpProtobufParam.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\bH\u0010¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/param/TapHttpProtobufParam;", "Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "http", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", ImagesContract.URL, "", "protobufByteArray", "Lkotlin/Function0;", "", "(Lcom/taptap/sdk/kit/internal/http/TapHttp;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getProtobufByteArray", "()Lkotlin/jvm/functions/Function0;", "buildRequest", "Lcom/taptap/sdk/okhttp3/Request;", "buildRequest$tap_kit_release", "getContentByteArray", "getContentByteArray$tap_kit_release", "getTechnicalLogParam", "getTechnicalLogParam$tap_kit_release", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttpProtobufParam extends AbsTapHttpParam<TapHttpProtobufParam> {
    private final Function0<byte[]> protobufByteArray;

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public String getTechnicalLogParam$tap_kit_release() {
        return "ProtobufData()";
    }

    public final Function0<byte[]> getProtobufByteArray() {
        return this.protobufByteArray;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapHttpProtobufParam(TapHttp http, String url, Function0<byte[]> protobufByteArray) {
        super(http, url, TapHttp.METHOD_POST);
        Intrinsics.checkNotNullParameter(http, "http");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(protobufByteArray, "protobufByteArray");
        this.protobufByteArray = protobufByteArray;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public byte[] getContentByteArray$tap_kit_release() {
        return this.protobufByteArray.invoke();
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public Request buildRequest$tap_kit_release() {
        Map mutableMap = MapsKt.toMutableMap(getHeaderParams());
        mutableMap.putAll(getTapHttp().getSignHandler().getHeaders(getTapHttp().getModuleName(), getTapHttp().getModuleVersion(), getMethod()));
        String strBuildUrlString = buildUrlString();
        byte[] contentByteArray$tap_kit_release = getContentByteArray$tap_kit_release();
        byte[] bArrHandle = getTapHttp().getCompressHandler().handle(contentByteArray$tap_kit_release);
        getTapHttp().getSignHandler().handle(new ITapHttpSign.HandleData(strBuildUrlString, getMethod(), getTapHttp().getEnableAuthorization(), contentByteArray$tap_kit_release, bArrHandle, mutableMap));
        MediaType mediaType = MediaType.parse("application/x-protobuf");
        Request.Builder builderUrl = new Request.Builder().url(strBuildUrlString);
        for (Map.Entry entry : mutableMap.entrySet()) {
            builderUrl.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request requestBuild = builderUrl.post(RequestBody.create(mediaType, bArrHandle)).build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "Builder()\n            .u…nt))\n            .build()");
        return requestBuild;
    }
}
