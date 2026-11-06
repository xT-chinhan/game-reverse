package com.taptap.sdk.kit.internal.http.param;

import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.hanlder.AbsTapHttpBackoff;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpBackoff;
import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.RequestBody;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapHttpJsonParam.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0010J\r\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0010¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/param/TapHttpJsonParam;", "Lcom/taptap/sdk/kit/internal/http/param/AbsTapHttpParam;", "http", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", BreakpointSQLiteKey.URL, "", "(Lcom/taptap/sdk/kit/internal/http/TapHttp;Ljava/lang/String;)V", "backoffHandler", "Lcom/taptap/sdk/kit/internal/http/hanlder/AbsTapHttpBackoff;", "getBackoffHandler", "()Lcom/taptap/sdk/kit/internal/http/hanlder/AbsTapHttpBackoff;", "setBackoffHandler", "(Lcom/taptap/sdk/kit/internal/http/hanlder/AbsTapHttpBackoff;)V", "body", "", "addBody", "Lorg/json/JSONObject;", "buildRequest", "Lcom/taptap/sdk/okhttp3/Request;", "buildRequest$tap_common_release", "getContentByteArray", "", "getContentByteArray$tap_common_release", "getTechnicalLogParam", "getTechnicalLogParam$tap_common_release", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttpJsonParam extends AbsTapHttpParam<TapHttpJsonParam> {
    private AbsTapHttpBackoff backoffHandler;
    private Object body;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapHttpJsonParam(TapHttp http, String url) {
        super(http, url, TapHttp.METHOD_POST);
        Intrinsics.checkNotNullParameter(http, "http");
        Intrinsics.checkNotNullParameter(url, "url");
        this.body = new JSONObject();
        this.backoffHandler = new TapHttpBackoff.Fixed(0, 1, null);
    }

    public final TapHttpJsonParam addBody(JSONObject body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TapHttpJsonParam $this$addBody_u24lambda_u240 = this;
        $this$addBody_u24lambda_u240.body = body;
        return this;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public AbsTapHttpBackoff getBackoffHandler() {
        return this.backoffHandler;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public void setBackoffHandler(AbsTapHttpBackoff absTapHttpBackoff) {
        Intrinsics.checkNotNullParameter(absTapHttpBackoff, "<set-?>");
        this.backoffHandler = absTapHttpBackoff;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public byte[] getContentByteArray$tap_common_release() {
        byte[] bytes = this.body.toString().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public Request buildRequest$tap_common_release() {
        Map headersMap = MapsKt.toMutableMap(getHeaderParams());
        headersMap.putAll(getTapHttp().getSignHandler().getHeaders(getTapHttp().getModuleName(), getTapHttp().getModuleVersion(), getMethod()));
        String requestUrl = buildUrlString();
        byte[] content = getContentByteArray$tap_common_release();
        byte[] compressContent = getTapHttp().getCompressHandler().handle(content);
        getTapHttp().getSignHandler().handle(new ITapHttpSign.HandleData(requestUrl, getMethod(), getTapHttp().getEnableAuthorization(), content, compressContent, headersMap));
        MediaType mediaType = MediaType.parse("application/json");
        Request.Builder $this$buildRequest_u24lambda_u242 = new Request.Builder().url(requestUrl);
        for (Object element$iv : headersMap.entrySet()) {
            Map.Entry it = (Map.Entry) element$iv;
            $this$buildRequest_u24lambda_u242.addHeader((String) it.getKey(), (String) it.getValue());
        }
        Request requestBuild = $this$buildRequest_u24lambda_u242.post(RequestBody.create(mediaType, compressContent)).build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "Builder()\n            .u…nt))\n            .build()");
        return requestBuild;
    }

    @Override // com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam
    public String getTechnicalLogParam$tap_common_release() {
        return "json=" + this.body;
    }
}
