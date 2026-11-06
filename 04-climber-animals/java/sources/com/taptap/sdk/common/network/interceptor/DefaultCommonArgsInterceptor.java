package com.taptap.sdk.common.network.interceptor;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.common.network.utils.FixedTimeUtil;
import com.taptap.sdk.common.network.utils.RandomUtils;
import com.taptap.sdk.common.services.AuthorizationService;
import com.taptap.sdk.okhttp3.Headers;
import com.taptap.sdk.okhttp3.HttpUrl;
import com.taptap.sdk.okhttp3.Interceptor;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.retrofit2.Invocation;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0002J \u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor;", "Lcom/taptap/sdk/okhttp3/Interceptor;", "config", "Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor$Config;", "(Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor$Config;)V", "authorizationService", "Lcom/taptap/sdk/common/services/AuthorizationService;", "getAuthorizationService", "()Lcom/taptap/sdk/common/services/AuthorizationService;", "authorizationService$delegate", "Lkotlin/Lazy;", "getAuthorization", "", "url", "method", "getCommonHeaders", "Lcom/taptap/sdk/okhttp3/Headers;", "invocation", "Lcom/taptap/sdk/retrofit2/Invocation;", "getModuleFromInvocation", "Lcom/taptap/sdk/base/network/annotation/Module;", "intercept", "Lcom/taptap/sdk/okhttp3/Response;", "chain", "Lcom/taptap/sdk/okhttp3/Interceptor$Chain;", "shouldAddAuthorization", "", "paths", "", "from", "Lcom/taptap/sdk/okhttp3/HttpUrl;", "queryMap", "", "Config", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        HttpUrl httpUrlUrl = request.url();
        Intrinsics.checkNotNullExpressionValue(httpUrlUrl, "originRequest.url()");
        HttpUrl httpUrlFrom = from(httpUrlUrl, MapsKt.hashMapOf(TuplesKt.to("client_id", this.config.getClientId())));
        builderNewBuilder.url(httpUrlFrom);
        builderNewBuilder.headers(getCommonHeaders((Invocation) request.tag(Invocation.class)));
        String strEncodedPath = httpUrlFrom.encodedPath();
        Intrinsics.checkNotNullExpressionValue(strEncodedPath, "targetUrl.encodedPath()");
        if (shouldAddAuthorization(strEncodedPath, this.config.getPaths())) {
            String string = httpUrlFrom.toString();
            Intrinsics.checkNotNullExpressionValue(string, "targetUrl.toString()");
            String strMethod = request.method();
            Intrinsics.checkNotNullExpressionValue(strMethod, "originRequest.method()");
            String authorization = getAuthorization(string, strMethod);
            if (authorization != null) {
                builderNewBuilder.header("Authorization", authorization);
            }
            Response responseProceed = chain.proceed(builderNewBuilder.build());
            Intrinsics.checkNotNullExpressionValue(responseProceed, "chain.proceed(newRequestBuilder.build())");
            return responseProceed;
        }
        Response responseProceed2 = chain.proceed(builderNewBuilder.build());
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

    private final HttpUrl from(HttpUrl httpUrl, Map<String, String> map) {
        List<Pair> list = MapsKt.toList(map);
        HttpUrl.Builder builderNewBuilder = httpUrl.newBuilder();
        for (Pair pair : list) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            if (httpUrl.queryParameter(str) == null) {
                builderNewBuilder.addQueryParameter(str, str2);
            }
        }
        HttpUrl httpUrlBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(httpUrlBuild, "queryMap.toList()\n      …   }\n            .build()");
        return httpUrlBuild;
    }

    private final Headers getCommonHeaders(Invocation invocation) {
        HashMap map = new HashMap();
        Pair pair = TuplesKt.to("X-Tap-PN", "TapSDK");
        map.put(pair.getFirst(), pair.getSecond());
        Pair pair2 = TuplesKt.to("X-Tap-Device-Id", this.config.getDeviceId());
        map.put(pair2.getFirst(), pair2.getSecond());
        Pair pair3 = TuplesKt.to("X-Tap-Platform", "Android");
        map.put(pair3.getFirst(), pair3.getSecond());
        Pair pair4 = TuplesKt.to("X-Tap-SDK-Artifact", this.config.getSdkArtifact());
        map.put(pair4.getFirst(), pair4.getSecond());
        Pair pair5 = TuplesKt.to("X-Tap-Ts", String.valueOf(FixedTimeUtil.INSTANCE.getCurrentTimeInMillis() / ((long) 1000)));
        map.put(pair5.getFirst(), pair5.getSecond());
        Pair pair6 = TuplesKt.to("X-Tap-Nonce", RandomUtils.INSTANCE.getRandomString(10));
        map.put(pair6.getFirst(), pair6.getSecond());
        Pair pair7 = TuplesKt.to("X-Tap-Lang", this.config.getLanguage());
        map.put(pair7.getFirst(), pair7.getSecond());
        Pair pair8 = TuplesKt.to("User-Agent", this.config.getUserAgent());
        map.put(pair8.getFirst(), pair8.getSecond());
        Module moduleFromInvocation = getModuleFromInvocation(invocation);
        if (moduleFromInvocation != null) {
            Pair pair9 = TuplesKt.to("X-Tap-SDK-Module", moduleFromInvocation.name());
            map.put(pair9.getFirst(), pair9.getSecond());
            Pair pair10 = TuplesKt.to("X-Tap-SDK-Module-Version", moduleFromInvocation.version());
            map.put(pair10.getFirst(), pair10.getSecond());
        }
        Headers headersOf = Headers.of(map);
        Intrinsics.checkNotNullExpressionValue(headersOf, "of(params)");
        return headersOf;
    }

    private final boolean shouldAddAuthorization(String url, Set<String> paths) {
        Set<String> set = paths;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/taptap/sdk/common/network/interceptor/DefaultCommonArgsInterceptor$Config;", "", "paths", "", "", "clientId", "language", TTDownloadField.TT_USERAGENT, "deviceId", "sdkArtifact", "(Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getDeviceId", "getLanguage", "getPaths", "()Ljava/util/Set;", "getSdkArtifact", "getUserAgent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Config {
        private final String clientId;
        private final String deviceId;
        private final String language;
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
    }
}
