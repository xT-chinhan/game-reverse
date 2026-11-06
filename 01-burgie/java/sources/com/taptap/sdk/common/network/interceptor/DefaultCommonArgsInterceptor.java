package com.taptap.sdk.common.network.interceptor;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.base.network.annotation.RequiresAuthorization;
import com.taptap.sdk.common.network.utils.RandomUtils;
import com.taptap.sdk.common.services.AuthorizationService;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.taptap.sdk.okhttp3.Headers;
import com.taptap.sdk.okhttp3.HttpUrl;
import com.taptap.sdk.okhttp3.Interceptor;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.retrofit2.Invocation;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DefaultCommonArgsInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J \u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor;", "Lcom/taptap/sdk/okhttp3/Interceptor;", "config", "Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor$Config;", "(Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor$Config;)V", "authorizationService", "Lcom/taptap/sdk/common/services/AuthorizationService;", "getAuthorizationService", "()Lcom/taptap/sdk/common/services/AuthorizationService;", "authorizationService$delegate", "Lkotlin/Lazy;", "getAuthorization", "", BreakpointSQLiteKey.URL, "method", "getCommonHeaders", "Lcom/taptap/sdk/okhttp3/Headers;", "invocation", "Lcom/taptap/sdk/retrofit2/Invocation;", "getModuleFromInvocation", "Lcom/taptap/sdk/base/network/annotation/Module;", "intercept", "Lcom/taptap/sdk/okhttp3/Response;", "chain", "Lcom/taptap/sdk/okhttp3/Interceptor$Chain;", "shouldAddAuthorization", "", "paths", "", "from", "Lcom/taptap/sdk/okhttp3/HttpUrl;", "queryMap", "", "Config", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultCommonArgsInterceptor implements Interceptor {

    /* JADX INFO: renamed from: authorizationService$delegate, reason: from kotlin metadata */
    private final Lazy authorizationService;
    private final Config config;

    public DefaultCommonArgsInterceptor(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        this.authorizationService = LazyKt.lazy(new Function0<AuthorizationService>() { // from class: com.taptap.sdk.common.network.interceptor.DefaultCommonArgsInterceptor$special$$inlined$injectOrNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.taptap.sdk.common.services.AuthorizationService, com.taptap.sdk.servicemanager.ServiceManager$Service] */
            @Override // kotlin.jvm.functions.Function0
            public final AuthorizationService invoke() {
                return ServiceManager.INSTANCE.getService(AuthorizationService.class);
            }
        });
    }

    private final AuthorizationService getAuthorizationService() {
        return (AuthorizationService) this.authorizationService.getValue();
    }

    @Override // com.taptap.sdk.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request originRequest = chain.request();
        Request.Builder newRequestBuilder = originRequest.newBuilder();
        HttpUrl httpUrlUrl = originRequest.url();
        Intrinsics.checkNotNullExpressionValue(httpUrlUrl, "originRequest.url()");
        HttpUrl targetUrl = from(httpUrlUrl, MapsKt.hashMapOf(TuplesKt.to("client_id", this.config.getClientId())));
        newRequestBuilder.url(targetUrl);
        Headers commonHeaders = getCommonHeaders((Invocation) originRequest.tag(Invocation.class));
        int size = commonHeaders.size();
        for (int index = 0; index < size; index++) {
            newRequestBuilder.header(commonHeaders.name(index), commonHeaders.value(index));
        }
        String strEncodedPath = targetUrl.encodedPath();
        Intrinsics.checkNotNullExpressionValue(strEncodedPath, "targetUrl.encodedPath()");
        if (shouldAddAuthorization(strEncodedPath, this.config.getPaths(), (Invocation) originRequest.tag(Invocation.class))) {
            if (originRequest.header("Authorization") == null) {
                String string = targetUrl.toString();
                Intrinsics.checkNotNullExpressionValue(string, "targetUrl.toString()");
                String strMethod = originRequest.method();
                Intrinsics.checkNotNullExpressionValue(strMethod, "originRequest.method()");
                String value = getAuthorization(string, strMethod);
                if (value != null) {
                    newRequestBuilder.header("Authorization", value);
                }
            }
            Response responseProceed = chain.proceed(newRequestBuilder.build());
            Intrinsics.checkNotNullExpressionValue(responseProceed, "chain.proceed(newRequestBuilder.build())");
            return responseProceed;
        }
        Response responseProceed2 = chain.proceed(newRequestBuilder.build());
        Intrinsics.checkNotNullExpressionValue(responseProceed2, "chain.proceed(newRequestBuilder.build())");
        return responseProceed2;
    }

    private final String getAuthorization(String url, String method) {
        AuthorizationService authorizationService = getAuthorizationService();
        if (authorizationService != null) {
            return authorizationService.obtainAuthorization(url, method);
        }
        return null;
    }

    private final HttpUrl from(HttpUrl $this$from, Map<String, String> map) {
        Iterable $this$fold$iv = MapsKt.toList(map);
        HttpUrl.Builder builderNewBuilder = $this$from.newBuilder();
        for (Object element$iv : $this$fold$iv) {
            Pair pair = (Pair) element$iv;
            HttpUrl.Builder builder = builderNewBuilder;
            String key = (String) pair.component1();
            String value = (String) pair.component2();
            String existingValue = $this$from.queryParameter(key);
            if (existingValue == null) {
                builder.addQueryParameter(key, value);
            }
            builderNewBuilder = builder;
        }
        HttpUrl httpUrlBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(httpUrlBuild, "queryMap.toList()\n      …   }\n            .build()");
        return httpUrlBuild;
    }

    private final Headers getCommonHeaders(Invocation invocation) {
        HashMap params = new HashMap();
        Pair pair = TuplesKt.to("X-Tap-PN", "TapSDK");
        params.put(pair.getFirst(), pair.getSecond());
        Pair pair2 = TuplesKt.to("X-Tap-Device-Id", this.config.deviceIdValue$tap_common_release());
        params.put(pair2.getFirst(), pair2.getSecond());
        Pair pair3 = TuplesKt.to("X-Tap-Platform", "Android");
        params.put(pair3.getFirst(), pair3.getSecond());
        Pair pair4 = TuplesKt.to("X-Tap-SDK-Artifact", this.config.getSdkArtifact());
        params.put(pair4.getFirst(), pair4.getSecond());
        Pair pair5 = TuplesKt.to("X-Tap-Ts", String.valueOf(TapTime.INSTANCE.getCurrentTimeInMillis() / ((long) 1000)));
        params.put(pair5.getFirst(), pair5.getSecond());
        Pair pair6 = TuplesKt.to("X-Tap-Nonce", RandomUtils.INSTANCE.getRandomString(10));
        params.put(pair6.getFirst(), pair6.getSecond());
        Pair pair7 = TuplesKt.to("X-Tap-Lang", this.config.languageValue$tap_common_release());
        params.put(pair7.getFirst(), pair7.getSecond());
        Pair pair8 = TuplesKt.to("User-Agent", this.config.getUserAgent());
        params.put(pair8.getFirst(), pair8.getSecond());
        String gameUserId = TapIdentifierUtil.INSTANCE.getGameUserId();
        if (gameUserId != null) {
            if (!(gameUserId.length() > 0)) {
                gameUserId = null;
            }
            if (gameUserId != null) {
                Pair pair9 = TuplesKt.to("X-Tap-SDK-Game-User-Id", gameUserId);
                params.put(pair9.getFirst(), pair9.getSecond());
            }
        }
        Module module = getModuleFromInvocation(invocation);
        if (module != null) {
            Pair pair10 = TuplesKt.to("X-Tap-SDK-Module", module.name());
            params.put(pair10.getFirst(), pair10.getSecond());
            Pair pair11 = TuplesKt.to("X-Tap-SDK-Module-Version", module.version());
            params.put(pair11.getFirst(), pair11.getSecond());
        }
        Headers headersOf = Headers.of(params);
        Intrinsics.checkNotNullExpressionValue(headersOf, "of(params)");
        return headersOf;
    }

    private final boolean shouldAddAuthorization(String url, Set<String> paths, Invocation invocation) {
        boolean z;
        Class<?> declaringClass;
        Method method = invocation != null ? invocation.method() : null;
        if ((method != null ? (RequiresAuthorization) method.getAnnotation(RequiresAuthorization.class) : null) != null) {
            return true;
        }
        if (((method == null || (declaringClass = method.getDeclaringClass()) == null) ? null : (RequiresAuthorization) declaringClass.getAnnotation(RequiresAuthorization.class)) != null) {
            return true;
        }
        Set<String> $this$any$iv = paths;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            z = false;
        } else {
            for (Object element$iv : $this$any$iv) {
                String path = (String) element$iv;
                if (StringsKt.contains$default((CharSequence) url, (CharSequence) path, false, 2, (Object) null)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    private final Module getModuleFromInvocation(Invocation invocation) {
        Method method;
        Class<?> declaringClass;
        if (invocation == null || (method = invocation.method()) == null || (declaringClass = method.getDeclaringClass()) == null) {
            return null;
        }
        return (Module) declaringClass.getAnnotation(Module.class);
    }

    /* JADX INFO: compiled from: DefaultCommonArgsInterceptor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\b\u0010\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bB;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\r\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\r\u0010%\u001a\u00020\u0004H\u0000¢\u0006\u0002\b&J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006("}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor$Config;", "", "paths", "", "", "clientId", "language", "Lkotlin/Function0;", "userAgent", "deviceId", "sdkArtifact", "(Ljava/util/Set;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "(Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getDeviceId", "deviceIdSupplier", "getLanguage", "languageSupplier", "getPaths", "()Ljava/util/Set;", "getSdkArtifact", "getUserAgent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "deviceIdValue", "deviceIdValue$tap_common_release", "equals", "", "other", "hashCode", "", "languageValue", "languageValue$tap_common_release", "toString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Config {
        private final String clientId;
        private final String deviceId;
        private Function0<String> deviceIdSupplier;
        private final String language;
        private Function0<String> languageSupplier;
        private final Set<String> paths;
        private final String sdkArtifact;
        private final String userAgent;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config config, Set set, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                set = config.paths;
            }
            if ((i & 2) != 0) {
                str = config.clientId;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = config.language;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = config.userAgent;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = config.deviceId;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = config.sdkArtifact;
            }
            return config.copy(set, str6, str7, str8, str9, str5);
        }

        public final Set<String> component1() {
            return this.paths;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUserAgent() {
            return this.userAgent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSdkArtifact() {
            return this.sdkArtifact;
        }

        public final Config copy(Set<String> paths, String clientId, String language, String userAgent, String deviceId, String sdkArtifact) {
            Intrinsics.checkNotNullParameter(paths, "paths");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(language, "language");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(sdkArtifact, "sdkArtifact");
            return new Config(paths, clientId, language, userAgent, deviceId, sdkArtifact);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.paths, config.paths) && Intrinsics.areEqual(this.clientId, config.clientId) && Intrinsics.areEqual(this.language, config.language) && Intrinsics.areEqual(this.userAgent, config.userAgent) && Intrinsics.areEqual(this.deviceId, config.deviceId) && Intrinsics.areEqual(this.sdkArtifact, config.sdkArtifact);
        }

        public int hashCode() {
            return (((((((((this.paths.hashCode() * 31) + this.clientId.hashCode()) * 31) + this.language.hashCode()) * 31) + this.userAgent.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.sdkArtifact.hashCode();
        }

        public String toString() {
            return "Config(paths=" + this.paths + ", clientId=" + this.clientId + ", language=" + this.language + ", userAgent=" + this.userAgent + ", deviceId=" + this.deviceId + ", sdkArtifact=" + this.sdkArtifact + ')';
        }

        public Config(Set<String> paths, String clientId, String language, String userAgent, String deviceId, String sdkArtifact) {
            Intrinsics.checkNotNullParameter(paths, "paths");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(language, "language");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(sdkArtifact, "sdkArtifact");
            this.paths = paths;
            this.clientId = clientId;
            this.language = language;
            this.userAgent = userAgent;
            this.deviceId = deviceId;
            this.sdkArtifact = sdkArtifact;
            this.languageSupplier = new Function0<String>() { // from class: com.taptap.sdk.common.network.interceptor.DefaultCommonArgsInterceptor$Config$languageSupplier$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return this.this$0.getLanguage();
                }
            };
            this.deviceIdSupplier = new Function0<String>() { // from class: com.taptap.sdk.common.network.interceptor.DefaultCommonArgsInterceptor$Config$deviceIdSupplier$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return this.this$0.getDeviceId();
                }
            };
        }

        public final Set<String> getPaths() {
            return this.paths;
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final String getUserAgent() {
            return this.userAgent;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getSdkArtifact() {
            return this.sdkArtifact;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Config(Set<String> paths, String clientId, Function0<String> language, String userAgent, Function0<String> deviceId, String sdkArtifact) {
            this(paths, clientId, "", userAgent, "", sdkArtifact);
            Intrinsics.checkNotNullParameter(paths, "paths");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(language, "language");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            Intrinsics.checkNotNullParameter(sdkArtifact, "sdkArtifact");
            this.languageSupplier = language;
            this.deviceIdSupplier = deviceId;
        }

        public final String languageValue$tap_common_release() {
            return this.languageSupplier.invoke();
        }

        public final String deviceIdValue$tap_common_release() {
            return this.deviceIdSupplier.invoke();
        }
    }
}
