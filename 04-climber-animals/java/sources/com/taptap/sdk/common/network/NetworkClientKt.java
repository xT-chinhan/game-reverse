package com.taptap.sdk.common.network;

import com.taptap.sdk.common.network.convert.BizConverterFactory;
import com.taptap.sdk.common.network.convert.ErrorHandlerCallFactory;
import com.taptap.sdk.common.network.interceptor.DefaultCommonArgsInterceptor;
import com.taptap.sdk.common.network.interceptor.RequestSignInterceptor;
import com.taptap.sdk.common.network.sign.DefaultSignStrategy;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.okhttp3.OkHttpClient;
import com.taptap.sdk.retrofit2.Retrofit;
import com.taptap.sdk.retrofit2.converter.kotlinx.serialization.KotlinSerializationConverterFactory;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\n"}, d2 = {"provideJson", "Lkotlinx/serialization/json/Json;", "provideOkHttpClient", "Lcom/taptap/sdk/okhttp3/OkHttpClient;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "provideRetrofit", "Lcom/taptap/sdk/retrofit2/Retrofit;", "baseUrl", "", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class NetworkClientKt {
    public static /* synthetic */ Retrofit provideRetrofit$default(String str, TapTapSdkOptions tapTapSdkOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            tapTapSdkOptions = null;
        }
        return provideRetrofit(str, tapTapSdkOptions);
    }

    public static final Retrofit provideRetrofit(String baseUrl, TapTapSdkOptions tapTapSdkOptions) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().baseUrl(baseUrl).client(provideOkHttpClient(TapTapKit.INSTANCE.getSdkOptions())).addCallAdapterFactory(ErrorHandlerCallFactory.INSTANCE.create()).addConverterFactory(BizConverterFactory.INSTANCE.create());
        Json jsonProvideJson = provideJson();
        MediaType mediaType = MediaType.parse("application/json");
        if (mediaType == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNullExpressionValue(mediaType, "checkNotNull(MediaType.parse(\"application/json\"))");
        Retrofit retrofitBuild = builderAddConverterFactory.addConverterFactory(KotlinSerializationConverterFactory.create(jsonProvideJson, mediaType)).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…son\"))))\n        .build()");
        return retrofitBuild;
    }

    public static final OkHttpClient provideOkHttpClient(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Set of = SetsKt.setOf((Object[]) new String[]{"/account/v1/profile", "/friendship/v1/create", "/friendship/v1/delete", "/friend/v1/list-by-me", "/friend-lite/v1/list-by-me", "/friend-lite/v1/following-by-me", "/friend-lite/v1/fans-by-me", "/friend-lite/v1/sync", "/message/v1/share", "/account/v1/profile", "/leaderboard/v1/my-current-scores", "/friendship/v1/create", "/friendship/v1/delete", "/leaderboard/v1/get-url", "/leaderboard/v1/friend-scores", "/leaderboard/v1/my-friend-score", "/leaderboard/v1/my-top-score", "/leaderboard/v1/user-centered-friend-scores", "/leaderboard/v1/user-centered-top-scores", "/leaderboard/v1/submit-scores", "/leaderboard/v1/top-scores", "/leaderboard/v1/user-scores"});
        String clientId = options.getClientId();
        String language = TapLocalizeUtil.getPreferredLanguage().getLanguage();
        String deviceId = TapIdentifierUtil.INSTANCE.getDeviceId(options.getContext());
        if (deviceId == null) {
            deviceId = "";
        }
        OkHttpClient okHttpClientBuild = builder.addInterceptor(new DefaultCommonArgsInterceptor(new DefaultCommonArgsInterceptor.Config(of, clientId, language, "TapSDK-Android/4.8.1-beta.7", deviceId, "Android"))).addInterceptor(new RequestSignInterceptor(new RequestSignInterceptor.Config(new DefaultSignStrategy(new DefaultSignStrategy.Config(options.getClientId(), options.getClientToken()))))).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "Builder()\n        .addIn…       )\n        .build()");
        return okHttpClientBuild;
    }

    public static final Json provideJson() {
        return JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.taptap.sdk.common.network.NetworkClientKt.provideJson.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
                Json.setLenient(true);
                Json.setCoerceInputValues(true);
            }
        }, 1, null);
    }
}
