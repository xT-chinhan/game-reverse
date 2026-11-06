package com.taptap.sdk.kit.internal.http.hanlder;

import com.taptap.sdk.common.services.AuthorizationService;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.net.URL;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TapHttpSign.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/hanlder/TapHttpSign;", "", "()V", "Companion", "Default", "None", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttpSign {
    public static final String QUERY_CLIENT_ID = "client_id";

    /* JADX INFO: compiled from: TapHttpSign.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J,\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/hanlder/TapHttpSign$Default;", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "()V", "authorizationService", "Lcom/taptap/sdk/common/services/AuthorizationService;", "getAuthorizationService", "()Lcom/taptap/sdk/common/services/AuthorizationService;", "authorizationService$delegate", "Lkotlin/Lazy;", "getFixQueryParams", "", "", "getGetHeaders", "", "moduleName", "moduleVersion", "getHeaders", "method", "getPostHeaders", "handle", "", "data", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign$HandleData;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Default implements ITapHttpSign {

        /* JADX INFO: renamed from: authorizationService$delegate, reason: from kotlin metadata */
        private final Lazy authorizationService;

        public Default() {
            ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
            this.authorizationService = LazyKt.lazy(new Function0<AuthorizationService>() { // from class: com.taptap.sdk.kit.internal.http.hanlder.TapHttpSign$Default$special$$inlined$injectOrNull$1
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

        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
        public Map<String, String> getFixQueryParams() {
            Map $this$getFixQueryParams_u24lambda_u240 = new LinkedHashMap();
            $this$getFixQueryParams_u24lambda_u240.put("client_id", TapTapKit.INSTANCE.getClientId$tap_common_release());
            return $this$getFixQueryParams_u24lambda_u240;
        }

        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
        public Map<String, String> getHeaders(String moduleName, String moduleVersion, String method) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(moduleVersion, "moduleVersion");
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual(method, TapHttp.METHOD_POST)) {
                return getPostHeaders(moduleName, moduleVersion);
            }
            if (Intrinsics.areEqual(method, TapHttp.METHOD_GET)) {
                return getGetHeaders(moduleName, moduleVersion);
            }
            return MapsKt.emptyMap();
        }

        private final Map<String, String> getGetHeaders(String moduleName, String moduleVersion) {
            Pair[] pairArr = new Pair[10];
            pairArr[0] = TuplesKt.to("X-Tap-PN", "TapSDK");
            String deviceId = TapIdentifierUtil.INSTANCE.getDeviceId(TapTapKit.INSTANCE.getContext());
            if (deviceId == null) {
                deviceId = "";
            }
            pairArr[1] = TuplesKt.to("X-Tap-Device-Id", deviceId);
            pairArr[2] = TuplesKt.to("X-Tap-Platform", "Android");
            pairArr[3] = TuplesKt.to("X-Tap-SDK-Module", moduleName);
            pairArr[4] = TuplesKt.to("X-Tap-SDK-Module-Version", moduleVersion);
            pairArr[5] = TuplesKt.to("X-Tap-SDK-Artifact", PlatformXUA.getTrackSDKArtifact());
            pairArr[6] = TuplesKt.to("X-Tap-Ts", String.valueOf(TapTime.INSTANCE.getCurrentTimeInMillis() / ((long) 1000)));
            pairArr[7] = TuplesKt.to("X-Tap-Nonce", TapHttpUtil.INSTANCE.getRandomString(10));
            pairArr[8] = TuplesKt.to("X-Tap-Lang", TapLocalizeUtil.getPreferredLanguage().getLanguage());
            pairArr[9] = TuplesKt.to("User-Agent", PlatformXUA.getTrackUA());
            Map<String, String> mapMutableMapOf = MapsKt.mutableMapOf(pairArr);
            String it = TapIdentifierUtil.INSTANCE.getGameUserId();
            if (it != null) {
                if (it.length() > 0) {
                    mapMutableMapOf.put("X-Tap-SDK-Game-User-Id", it);
                }
            }
            return mapMutableMapOf;
        }

        private final Map<String, String> getPostHeaders(String moduleName, String moduleVersion) {
            Pair[] pairArr = new Pair[10];
            pairArr[0] = TuplesKt.to("X-Tap-PN", "TapSDK");
            String deviceId = TapIdentifierUtil.INSTANCE.getDeviceId(TapTapKit.INSTANCE.getContext());
            if (deviceId == null) {
                deviceId = "";
            }
            pairArr[1] = TuplesKt.to("X-Tap-Device-Id", deviceId);
            pairArr[2] = TuplesKt.to("X-Tap-Platform", "Android");
            pairArr[3] = TuplesKt.to("X-Tap-SDK-Module", moduleName);
            pairArr[4] = TuplesKt.to("X-Tap-SDK-Module-Version", moduleVersion);
            pairArr[5] = TuplesKt.to("X-Tap-SDK-Artifact", PlatformXUA.getTrackSDKArtifact());
            pairArr[6] = TuplesKt.to("X-Tap-Ts", String.valueOf(TapTime.INSTANCE.getCurrentTimeInMillis() / ((long) 1000)));
            pairArr[7] = TuplesKt.to("X-Tap-Nonce", TapHttpUtil.INSTANCE.getRandomString(10));
            pairArr[8] = TuplesKt.to("X-Tap-Lang", TapLocalizeUtil.getPreferredLanguage().getLanguage());
            pairArr[9] = TuplesKt.to("User-Agent", PlatformXUA.getTrackUA());
            Map<String, String> mapMutableMapOf = MapsKt.mutableMapOf(pairArr);
            String it = TapIdentifierUtil.INSTANCE.getGameUserId();
            if (it != null) {
                if (it.length() > 0) {
                    mapMutableMapOf.put("X-Tap-SDK-Game-User-Id", it);
                }
            }
            return mapMutableMapOf;
        }

        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
        public void handle(ITapHttpSign.HandleData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.getEnableAuthorization() && !data.getHeaders().containsKey("Authorization")) {
                AuthorizationService authorizationService = getAuthorizationService();
                String executeResult = authorizationService != null ? authorizationService.obtainAuthorization(data.getUrl(), data.getMethod()) : null;
                if (executeResult != null) {
                    String it = executeResult;
                    data.getHeaders().put("Authorization", it);
                }
            }
            URL urlObj = new URL(data.getUrl());
            String pathAndQuery = urlObj.getPath() + (urlObj.getQuery() != null ? '?' + urlObj.getQuery() : "");
            Map<String, String> headers = data.getHeaders();
            LinkedHashMap result$iv = new LinkedHashMap();
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                String it2 = entry.getKey();
                String lowerCase = it2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (StringsKt.startsWith$default(lowerCase, "x-tap-", false, 2, (Object) null)) {
                    result$iv.put(entry.getKey(), entry.getValue());
                }
            }
            Iterable $this$sortedBy$iv = result$iv.entrySet();
            String filteredHeaders = CollectionsKt.joinToString$default(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.taptap.sdk.kit.internal.http.hanlder.TapHttpSign$Default$handle$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map.Entry it3 = (Map.Entry) t;
                    String lowerCase2 = ((String) it3.getKey()).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    Map.Entry it4 = (Map.Entry) t2;
                    String lowerCase3 = ((String) it4.getKey()).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    return ComparisonsKt.compareValues(lowerCase2, lowerCase3);
                }
            }), "\n", null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: com.taptap.sdk.kit.internal.http.hanlder.TapHttpSign$Default$handle$filteredHeaders$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CharSequence invoke2(Map.Entry<String, String> it3) {
                    Intrinsics.checkNotNullParameter(it3, "it");
                    StringBuilder sb = new StringBuilder();
                    String lowerCase2 = it3.getKey().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    return sb.append(lowerCase2).append(AbstractJsonLexerKt.COLON).append(it3.getValue()).toString();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry2) {
                    return invoke2((Map.Entry<String, String>) entry2);
                }
            }, 30, null);
            String bodyString = new String(data.getCompressContent(), Charsets.UTF_8);
            String stringToSign = data.getMethod() + '\n' + pathAndQuery + '\n' + filteredHeaders + '\n' + bodyString + '\n';
            String signature = TapHttpUtil.secret$default(TapHttpUtil.INSTANCE, TapTapKit.INSTANCE.getClientToken$tap_common_release(), stringToSign, null, 4, null);
            data.getHeaders().put("X-Tap-Sign", signature);
        }
    }

    /* JADX INFO: compiled from: TapHttpSign.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/hanlder/TapHttpSign$None;", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "()V", "getFixQueryParams", "", "", "getHeaders", "moduleName", "moduleVersion", "method", "handle", "", "data", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign$HandleData;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class None implements ITapHttpSign {
        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
        public Map<String, String> getFixQueryParams() {
            return MapsKt.emptyMap();
        }

        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
        public Map<String, String> getHeaders(String moduleName, String moduleVersion, String method) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(moduleVersion, "moduleVersion");
            Intrinsics.checkNotNullParameter(method, "method");
            return MapsKt.emptyMap();
        }

        @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
        public void handle(ITapHttpSign.HandleData data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }
}
