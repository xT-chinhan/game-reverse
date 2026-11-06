package com.taptap.sdk.kit.internal.http.param;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.RequestBody;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: TapHttpFormParam.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0010R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/param/TapHttpFormParam;", "Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "http", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", ImagesContract.URL, "", "form", "", "(Lcom/taptap/sdk/kit/internal/http/TapHttp;Ljava/lang/String;Ljava/util/Map;)V", "buildRequest", "Lcom/taptap/sdk/okhttp3/Request;", "buildRequest$tap_kit_release", "getContentByteArray", "", "getContentByteArray$tap_kit_release", "getTechnicalLogParam", "getTechnicalLogParam$tap_kit_release", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttpFormParam extends AbsTapHttpParam<TapHttpFormParam> {
    private final Map<String, String> form;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapHttpFormParam(TapHttp http, String url, Map<String, String> form) {
        super(http, url, TapHttp.METHOD_POST);
        Intrinsics.checkNotNullParameter(http, "http");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(form, "form");
        this.form = form;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public byte[] getContentByteArray$tap_kit_release() {
        Map<String, String> map = this.form;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + '=' + Uri.encode(entry.getValue()));
        }
        byte[] bytes = CollectionsKt.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public Request buildRequest$tap_kit_release() {
        Map mutableMap = MapsKt.toMutableMap(getHeaderParams());
        mutableMap.putAll(getTapHttp().getSignHandler().getHeaders(getTapHttp().getModuleName(), getTapHttp().getModuleVersion(), getMethod()));
        String strBuildUrlString = buildUrlString();
        byte[] contentByteArray$tap_kit_release = getContentByteArray$tap_kit_release();
        byte[] bArrHandle = getTapHttp().getCompressHandler().handle(contentByteArray$tap_kit_release);
        getTapHttp().getSignHandler().handle(new ITapHttpSign.HandleData(strBuildUrlString, getMethod(), getTapHttp().getEnableAuthorization(), contentByteArray$tap_kit_release, bArrHandle, mutableMap));
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        Request.Builder builderUrl = new Request.Builder().url(strBuildUrlString);
        for (Map.Entry entry : mutableMap.entrySet()) {
            builderUrl.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request requestBuild = builderUrl.post(RequestBody.create(mediaType, bArrHandle)).build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "Builder()\n            .u…nt))\n            .build()");
        return requestBuild;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public String getTechnicalLogParam$tap_kit_release() {
        String strEncodeToString;
        StringBuilder sb = new StringBuilder("form=");
        TapJson tapJson = TapJson.INSTANCE;
        Map<String, String> map = this.form;
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, map);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        return sb.append(strEncodeToString).toString();
    }
}
