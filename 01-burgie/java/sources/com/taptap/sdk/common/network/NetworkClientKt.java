package com.taptap.sdk.common.network;

import com.taptap.sdk.common.network.convert.BizConverterFactory;
import com.taptap.sdk.common.network.convert.ErrorHandlerCallFactory;
import com.taptap.sdk.common.network.interceptor.DefaultCommonArgsInterceptor;
import com.taptap.sdk.common.network.interceptor.RequestSignInterceptor;
import com.taptap.sdk.common.network.interceptor.TapLogInterceptor;
import com.taptap.sdk.common.network.sign.DefaultSignStrategy;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.okhttp3.OkHttpClient;
import com.taptap.sdk.retrofit2.Retrofit;
import com.taptap.sdk.retrofit2.converter.kotlinx.serialization.KotlinSerializationConverterFactory;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a&\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f\u001a\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007\u001a&\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0017H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0000\u001a$\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0000¨\u0006\u001a"}, d2 = {"provideJson", "Lkotlinx/serialization/json/Json;", "provideOkHttpClient", "Lcom/taptap/sdk/okhttp3/OkHttpClient;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "enableLog", "", "provideRetrofit", "Lcom/taptap/sdk/retrofit2/Retrofit;", "baseUrl", "", "provideRetrofitForTapDB", "provideRetrofitForUploadWithTimeout", "connectTimeoutMillis", "", "readTimeoutMillis", "writeTimeoutMillis", "provideRetrofitWithCallTimeout", "callTimeoutMillis", "provideRetrofitWithLog", "provideRetrofitWithTimeout", "addTapFactories", "Lcom/taptap/sdk/retrofit2/Retrofit$Builder;", "withCallTimeout", "withTimeouts", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class NetworkClientKt {
    private static final Retrofit.Builder addTapFactories(Retrofit.Builder $this$addTapFactories) {
        Retrofit.Builder builderAddConverterFactory = $this$addTapFactories.addCallAdapterFactory(ErrorHandlerCallFactory.INSTANCE.create()).addConverterFactory(BizConverterFactory.INSTANCE.create());
        Json jsonProvideJson = provideJson();
        MediaType mediaType = MediaType.parse("application/json");
        if (mediaType != null) {
            Intrinsics.checkNotNullExpressionValue(mediaType, "checkNotNull(MediaType.parse(\"application/json\"))");
            Retrofit.Builder builderAddConverterFactory2 = builderAddConverterFactory.addConverterFactory(KotlinSerializationConverterFactory.create(jsonProvideJson, mediaType));
            Intrinsics.checkNotNullExpressionValue(builderAddConverterFactory2, "addCallAdapterFactory(Er…cation/json\")))\n        )");
            return builderAddConverterFactory2;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final OkHttpClient withCallTimeout(OkHttpClient $this$withCallTimeout, long callTimeoutMillis) {
        Intrinsics.checkNotNullParameter($this$withCallTimeout, "<this>");
        OkHttpClient okHttpClientBuild = $this$withCallTimeout.newBuilder().callTimeout(callTimeoutMillis, TimeUnit.MILLISECONDS).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "newBuilder()\n        .ca…SECONDS)\n        .build()");
        return okHttpClientBuild;
    }

    public static final OkHttpClient withTimeouts(OkHttpClient $this$withTimeouts, long connectTimeoutMillis, long readTimeoutMillis, long writeTimeoutMillis) {
        Intrinsics.checkNotNullParameter($this$withTimeouts, "<this>");
        OkHttpClient okHttpClientBuild = $this$withTimeouts.newBuilder().connectTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS).readTimeout(readTimeoutMillis, TimeUnit.MILLISECONDS).writeTimeout(writeTimeoutMillis, TimeUnit.MILLISECONDS).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "newBuilder()\n        .co…SECONDS)\n        .build()");
        return okHttpClientBuild;
    }

    public static /* synthetic */ Retrofit provideRetrofit$default(String str, TapTapSdkOptions tapTapSdkOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            tapTapSdkOptions = null;
        }
        return provideRetrofit(str, tapTapSdkOptions);
    }

    public static final Retrofit provideRetrofit(String baseUrl, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(baseUrl).client(provideOkHttpClient(options == null ? TapTapKit.INSTANCE.getSdkOptions() : options));
        Intrinsics.checkNotNullExpressionValue(builderClient, "Builder()\n        .baseU…?: TapTapKit.sdkOptions))");
        Retrofit retrofitBuild = addTapFactories(builderClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…tories()\n        .build()");
        return retrofitBuild;
    }

    public static final Retrofit provideRetrofitWithLog(String baseUrl, boolean enableLog) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(baseUrl).client(provideOkHttpClient(TapTapKit.INSTANCE.getSdkOptions(), enableLog));
        Intrinsics.checkNotNullExpressionValue(builderClient, "Builder()\n        .baseU…t.sdkOptions, enableLog))");
        Retrofit retrofitBuild = addTapFactories(builderClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…tories()\n        .build()");
        return retrofitBuild;
    }

    public static final Retrofit provideRetrofitWithTimeout(String baseUrl, long connectTimeoutMillis, long readTimeoutMillis, long writeTimeoutMillis) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(baseUrl).client(withTimeouts(provideOkHttpClient(TapTapKit.INSTANCE.getSdkOptions()), connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis));
        Intrinsics.checkNotNullExpressionValue(builderClient, "Builder()\n        .baseU…s\n            )\n        )");
        Retrofit retrofitBuild = addTapFactories(builderClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…tories()\n        .build()");
        return retrofitBuild;
    }

    public static final Retrofit provideRetrofitForUploadWithTimeout(String baseUrl, long connectTimeoutMillis, long readTimeoutMillis, long writeTimeoutMillis) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(baseUrl).client(new OkHttpClient.Builder().connectTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS).readTimeout(readTimeoutMillis, TimeUnit.MILLISECONDS).writeTimeout(writeTimeoutMillis, TimeUnit.MILLISECONDS).build());
        Intrinsics.checkNotNullExpressionValue(builderClient, "Builder()\n        .baseU…       .build()\n        )");
        Retrofit retrofitBuild = addTapFactories(builderClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…tories()\n        .build()");
        return retrofitBuild;
    }

    public static final Retrofit provideRetrofitWithCallTimeout(String baseUrl, long callTimeoutMillis) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(baseUrl).client(withCallTimeout(provideOkHttpClient(TapTapKit.INSTANCE.getSdkOptions()), callTimeoutMillis));
        Intrinsics.checkNotNullExpressionValue(builderClient, "Builder()\n        .baseU…meout(callTimeoutMillis))");
        Retrofit retrofitBuild = addTapFactories(builderClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…tories()\n        .build()");
        return retrofitBuild;
    }

    public static final Retrofit provideRetrofitForTapDB(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(baseUrl).client(new OkHttpClient());
        Intrinsics.checkNotNullExpressionValue(builderClient, "Builder()\n        .baseU…  .client(OkHttpClient())");
        Retrofit retrofitBuild = addTapFactories(builderClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n        .baseU…tories()\n        .build()");
        return retrofitBuild;
    }

    public static final OkHttpClient provideOkHttpClient(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return provideOkHttpClient(options, options.getEnableLog());
    }

    public static final OkHttpClient provideOkHttpClient(final TapTapSdkOptions options, boolean enableLog) {
        Intrinsics.checkNotNullParameter(options, "options");
        OkHttpClient.Builder $this$provideOkHttpClient_u24lambda_u240 = new OkHttpClient.Builder();
        if (enableLog) {
            $this$provideOkHttpClient_u24lambda_u240.addInterceptor(new TapLogInterceptor(true, TapLogInterceptor.Level.BASIC));
        }
        OkHttpClient okHttpClientBuild = $this$provideOkHttpClient_u24lambda_u240.addInterceptor(new DefaultCommonArgsInterceptor(new DefaultCommonArgsInterceptor.Config((Set<String>) SetsKt.setOf((Object[]) new String[]{"/auth/v1/login-by-token", "/account/v1/profile", "/friendship/v1/create", "/friendship/v1/delete", "/friend/v1/list-by-me", "/friend-lite/v1/list-by-me", "/friend-lite/v1/following-by-me", "/friend-lite/v1/fans-by-me", "/friend-lite/v1/sync", "/message/v1/share", "/account/v1/profile", "/leaderboard/v1/my-current-scores", "/friendship/v1/create", "/friendship/v1/delete", "/leaderboard/v1/get-url", "/leaderboard/v1/friend-scores", "/leaderboard/v1/my-friend-score", "/leaderboard/v1/my-top-score", "/leaderboard/v1/user-centered-friend-scores", "/leaderboard/v1/user-centered-top-scores", "/leaderboard/v1/submit-scores", "/leaderboard/v1/top-scores", "/leaderboard/v1/user-scores", "/leaderboard/v1/scores", "/leaderboard/v1/my-score", "/leaderboard/v1/user-centered-scores"}), options.getClientId(), new Function0<String>() { // from class: com.taptap.sdk.common.network.NetworkClientKt.provideOkHttpClient.2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return TapLocalizeUtil.getPreferredLanguage().getLanguage();
            }
        }, PlatformXUA.getTrackUA(), new Function0<String>() { // from class: com.taptap.sdk.common.network.NetworkClientKt.provideOkHttpClient.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String deviceId = TapIdentifierUtil.INSTANCE.getDeviceId(options.getContext());
                return deviceId == null ? "" : deviceId;
            }
        }, PlatformXUA.getTrackSDKArtifact()))).addInterceptor(new RequestSignInterceptor(new RequestSignInterceptor.Config(new DefaultSignStrategy(new DefaultSignStrategy.Config(options.getClientId(), options.getClientToken()))))).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "options: TapTapSdkOption…       )\n        .build()");
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
