package com.taptap.sdk.login.impl.utils;

import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.NewCloudLoginMessage;
import defpackage.listToJsonArray;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: AuthorizeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/AuthorizeUtils;", "", "()V", "encodeExtra", "", "extra", "Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data$Extra;", "generate", "messageId", "isPortrait", "", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AuthorizeUtils {
    public static final AuthorizeUtils INSTANCE = new AuthorizeUtils();

    private AuthorizeUtils() {
    }

    public final String generate(String messageId, boolean isPortrait, LoginRequest request) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(request, "request");
        Pair[] pairArr = new Pair[13];
        pairArr[0] = TuplesKt.to("com.taptap.sdk.request.client_id", request.getClientId());
        pairArr[1] = TuplesKt.to("com.taptap.sdk.request.permissions", request.getScopes());
        pairArr[2] = TuplesKt.to("com.taptap.sdk.request.state", request.getState());
        pairArr[3] = TuplesKt.to("com.taptap.sdk.request.sdk_version", request.getVersionCode());
        pairArr[4] = TuplesKt.to("com.taptap.sdk.request.screen.portrait", Boolean.valueOf(isPortrait));
        pairArr[5] = TuplesKt.to("com.taptap.sdk.request.info", request.getInfo());
        pairArr[6] = TuplesKt.to("com.taptap.sdk.request.sdk_track_info", request.getTrackInfo());
        pairArr[7] = TuplesKt.to("com.taptap.sdk.request.login_version", request.getLoginVersion());
        pairArr[8] = TuplesKt.to("com.taptap.sdk.request.response_type", request.getResponseType());
        pairArr[9] = TuplesKt.to("com.taptap.sdk.request.redirect_uri", request.getRedirectUri());
        pairArr[10] = TuplesKt.to("com.taptap.sdk.request.code_challenge", CodeUtil.INSTANCE.getCodeChallenge(request.getCodeVerifier()));
        pairArr[11] = TuplesKt.to("com.taptap.sdk.request.code_challenge_method", request.getCodeChallengeMethod());
        pairArr[12] = TuplesKt.to("com.taptap.sdk.request.extra", encodeExtra(new NewCloudLoginMessage.Data.Extra(request.getPreApproved() ? 1 : 0)));
        Map newDataMap = MapsKt.mutableMapOf(pairArr);
        Map legacyDataMap = MapsKt.mapOf(TuplesKt.to("client_id", request.getClientId()), TuplesKt.to("scopes", request.getScopes()), TuplesKt.to("state", request.getState()), TuplesKt.to("sdk_version", request.getVersionCode()), TuplesKt.to("portrait", Boolean.valueOf(isPortrait)), TuplesKt.to("sdk_info", request.getInfo()), TuplesKt.to("sdk_track_info", request.getTrackInfo()), TuplesKt.to("response_type", request.getResponseType()), TuplesKt.to("redirect_uri", request.getRedirectUri()), TuplesKt.to("code_challenge", CodeUtil.INSTANCE.getCodeChallenge(request.getCodeVerifier())), TuplesKt.to("code_challenge_method", request.getCodeChallengeMethod()));
        Map mergedDataMap = MapsKt.plus(newDataMap, legacyDataMap);
        Map resultMap = MapsKt.mapOf(TuplesKt.to("type", "login_taptap"), TuplesKt.to("message_id", messageId), TuplesKt.to("data", mergedDataMap));
        String string = listToJsonArray.mapToJsonObject(resultMap).toString();
        Intrinsics.checkNotNullExpressionValue(string, "mapToJsonObject(resultMap).toString()");
        return string;
    }

    private final String encodeExtra(NewCloudLoginMessage.Data.Extra extra) {
        StringFormat $this$encodeToString$iv = Json.INSTANCE;
        SerializersModule $this$serializer$iv$iv = $this$encodeToString$iv.getSerializersModule();
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(NewCloudLoginMessage.Data.Extra.class));
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$encodeToString$iv.encodeToString(kSerializerSerializer, extra);
    }
}
