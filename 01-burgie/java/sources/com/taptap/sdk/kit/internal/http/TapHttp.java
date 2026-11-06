package com.taptap.sdk.kit.internal.http;

import com.taptap.sdk.common.network.interceptor.TapLogInterceptor;
import com.taptap.sdk.kit.internal.TapSDKHost;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpCompress;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpCompress;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpSign;
import com.taptap.sdk.kit.internal.http.param.TapHttpFile;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpNoBodyParam;
import com.taptap.sdk.okhttp3.Call;
import com.taptap.sdk.okhttp3.Dispatcher;
import com.taptap.sdk.okhttp3.OkHttpClient;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapHttp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0002-.B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014J\r\u0010\"\u001a\u00020\u0014H\u0000¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020)2\u0006\u0010!\u001a\u00020\u0014J\u0016\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/TapHttp;", "", "builder", "Lcom/taptap/sdk/kit/internal/http/TapHttp$Builder;", "(Lcom/taptap/sdk/kit/internal/http/TapHttp$Builder;)V", "client", "Lcom/taptap/sdk/okhttp3/OkHttpClient;", "compressHandler", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpCompress;", "getCompressHandler$tap_common_release", "()Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpCompress;", "setCompressHandler$tap_common_release", "(Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpCompress;)V", "enableAuthorization", "", "getEnableAuthorization$tap_common_release", "()Z", "enableTechnicalLog", "getEnableTechnicalLog$tap_common_release", "moduleName", "", "getModuleName$tap_common_release", "()Ljava/lang/String;", "moduleVersion", "getModuleVersion$tap_common_release", "signHandler", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "getSignHandler$tap_common_release", "()Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "setSignHandler$tap_common_release", "(Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;)V", "get", "Lcom/taptap/sdk/kit/internal/http/param/TapHttpNoBodyParam;", BreakpointSQLiteKey.URL, "getDomain", "getDomain$tap_common_release", "newCall", "Lcom/taptap/sdk/okhttp3/Call;", "buildRequest", "Lcom/taptap/sdk/okhttp3/Request;", "postJson", "Lcom/taptap/sdk/kit/internal/http/param/TapHttpJsonParam;", "put", "Lcom/taptap/sdk/kit/internal/http/param/TapHttpFile;", "localPath", "Builder", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapHttp {
    private static final long CONNECT_TIMEOUT_MILLIS = 10000;
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    private static final long READ_TIMEOUT_MILLIS = 5000;
    private static final long WRITE_TIMEOUT_MILLIS = 5000;
    private final Builder builder;
    private final OkHttpClient client;
    private ITapHttpCompress compressHandler;
    private final boolean enableAuthorization;
    private final boolean enableTechnicalLog;
    private final String moduleName;
    private final String moduleVersion;
    private ITapHttpSign signHandler;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Dispatcher defaultDispatcher = new Dispatcher();

    public /* synthetic */ TapHttp(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private TapHttp(Builder builder) {
        this.builder = builder;
        OkHttpClient.Builder $this$client_u24lambda_u240 = builder.getOkHttpClientBuilder();
        if (builder.getEnableConsoleLog()) {
            $this$client_u24lambda_u240.addInterceptor(new TapLogInterceptor(builder.getEnableConsoleLog(), builder.getLogLevel()));
        }
        OkHttpClient okHttpClientBuild = $this$client_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "builder.okHttpClientBuil…)\n        }\n    }.build()");
        this.client = okHttpClientBuild;
        this.compressHandler = builder.getCompressHandler();
        this.signHandler = builder.getSignHandler();
        this.moduleName = builder.getModuleName();
        this.moduleVersion = builder.getModuleVersion();
        this.enableTechnicalLog = builder.getEnableTechnicalLog();
        this.enableAuthorization = builder.getEnableAuthorization();
    }

    /* JADX INFO: renamed from: getCompressHandler$tap_common_release, reason: from getter */
    public final ITapHttpCompress getCompressHandler() {
        return this.compressHandler;
    }

    public final void setCompressHandler$tap_common_release(ITapHttpCompress iTapHttpCompress) {
        Intrinsics.checkNotNullParameter(iTapHttpCompress, "<set-?>");
        this.compressHandler = iTapHttpCompress;
    }

    /* JADX INFO: renamed from: getSignHandler$tap_common_release, reason: from getter */
    public final ITapHttpSign getSignHandler() {
        return this.signHandler;
    }

    public final void setSignHandler$tap_common_release(ITapHttpSign iTapHttpSign) {
        Intrinsics.checkNotNullParameter(iTapHttpSign, "<set-?>");
        this.signHandler = iTapHttpSign;
    }

    /* JADX INFO: renamed from: getModuleName$tap_common_release, reason: from getter */
    public final String getModuleName() {
        return this.moduleName;
    }

    /* JADX INFO: renamed from: getModuleVersion$tap_common_release, reason: from getter */
    public final String getModuleVersion() {
        return this.moduleVersion;
    }

    /* JADX INFO: renamed from: getEnableTechnicalLog$tap_common_release, reason: from getter */
    public final boolean getEnableTechnicalLog() {
        return this.enableTechnicalLog;
    }

    /* JADX INFO: renamed from: getEnableAuthorization$tap_common_release, reason: from getter */
    public final boolean getEnableAuthorization() {
        return this.enableAuthorization;
    }

    public final TapHttpNoBodyParam get(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new TapHttpNoBodyParam(this, url);
    }

    public final TapHttpJsonParam postJson(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new TapHttpJsonParam(this, url);
    }

    public final TapHttpFile put(String url, String localPath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        return new TapHttpFile(this, url, localPath);
    }

    public final Call newCall(Request buildRequest) {
        Intrinsics.checkNotNullParameter(buildRequest, "buildRequest");
        Call callNewCall = this.client.newCall(buildRequest);
        Intrinsics.checkNotNullExpressionValue(callNewCall, "client.newCall(buildRequest)");
        return callNewCall;
    }

    public final String getDomain$tap_common_release() {
        if (this.builder.getDomain().length() > 0) {
            return this.builder.getDomain();
        }
        return TapSDKHost.INSTANCE.getApiHost();
    }

    /* JADX INFO: compiled from: TapHttp.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/TapHttp$Companion;", "", "()V", "CONNECT_TIMEOUT_MILLIS", "", "METHOD_GET", "", "METHOD_POST", "METHOD_PUT", "READ_TIMEOUT_MILLIS", "WRITE_TIMEOUT_MILLIS", "defaultDispatcher", "Lcom/taptap/sdk/okhttp3/Dispatcher;", "newBuilder", "Lcom/taptap/sdk/kit/internal/http/TapHttp$Builder;", "moduleName", "moduleVersion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Builder newBuilder(String moduleName, String moduleVersion) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(moduleVersion, "moduleVersion");
            return new Builder(moduleName, moduleVersion);
        }
    }

    /* JADX INFO: compiled from: TapHttp.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010/\u001a\u000200J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0000J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u000204J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0012J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0012J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010;\u001a\u00020*J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u000204R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000eR\u0014\u0010%\u001a\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006>"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/TapHttp$Builder;", "", "moduleName", "", "moduleVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "compressHandler", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpCompress;", "getCompressHandler$tap_common_release", "()Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpCompress;", "setCompressHandler$tap_common_release", "(Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpCompress;)V", "domain", "getDomain$tap_common_release", "()Ljava/lang/String;", "setDomain$tap_common_release", "(Ljava/lang/String;)V", "enableAuthorization", "", "getEnableAuthorization$tap_common_release", "()Z", "setEnableAuthorization$tap_common_release", "(Z)V", "enableConsoleLog", "getEnableConsoleLog$tap_common_release", "setEnableConsoleLog$tap_common_release", "enableTechnicalLog", "getEnableTechnicalLog$tap_common_release", "setEnableTechnicalLog$tap_common_release", "logLevel", "Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$Level;", "getLogLevel$tap_common_release", "()Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$Level;", "setLogLevel$tap_common_release", "(Lcom/taptap/sdk/common/network/interceptor/TapLogInterceptor$Level;)V", "getModuleName", "getModuleVersion", "okHttpClientBuilder", "Lcom/taptap/sdk/okhttp3/OkHttpClient$Builder;", "getOkHttpClientBuilder$tap_common_release", "()Lcom/taptap/sdk/okhttp3/OkHttpClient$Builder;", "signHandler", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "getSignHandler$tap_common_release", "()Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "setSignHandler$tap_common_release", "(Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;)V", "build", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "compress", "connectTimeout", "connectTimeoutMillis", "", "debugLogLevel", "readTimeout", "readTimeoutMillis", "setLogEnable", "enable", "setTechnicalLogEnable", "sign", "writeTimeout", "writeTimeoutMillis", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private ITapHttpCompress compressHandler;
        private String domain;
        private boolean enableAuthorization;
        private boolean enableConsoleLog;
        private boolean enableTechnicalLog;
        private TapLogInterceptor.Level logLevel;
        private final String moduleName;
        private final String moduleVersion;
        private final OkHttpClient.Builder okHttpClientBuilder;
        private ITapHttpSign signHandler;

        public Builder(String moduleName, String moduleVersion) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(moduleVersion, "moduleVersion");
            this.moduleName = moduleName;
            this.moduleVersion = moduleVersion;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            this.okHttpClientBuilder = builder;
            builder.connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(5000L, TimeUnit.MILLISECONDS).writeTimeout(5000L, TimeUnit.MILLISECONDS).dispatcher(TapHttp.defaultDispatcher);
            this.domain = "";
            this.signHandler = new TapHttpSign.Default();
            this.compressHandler = new TapHttpCompress.None();
            this.logLevel = TapLogInterceptor.Level.BASIC;
            this.enableTechnicalLog = true;
        }

        public final String getModuleName() {
            return this.moduleName;
        }

        public final String getModuleVersion() {
            return this.moduleVersion;
        }

        /* JADX INFO: renamed from: getOkHttpClientBuilder$tap_common_release, reason: from getter */
        public final OkHttpClient.Builder getOkHttpClientBuilder() {
            return this.okHttpClientBuilder;
        }

        /* JADX INFO: renamed from: getDomain$tap_common_release, reason: from getter */
        public final String getDomain() {
            return this.domain;
        }

        public final void setDomain$tap_common_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.domain = str;
        }

        /* JADX INFO: renamed from: getSignHandler$tap_common_release, reason: from getter */
        public final ITapHttpSign getSignHandler() {
            return this.signHandler;
        }

        public final void setSignHandler$tap_common_release(ITapHttpSign iTapHttpSign) {
            Intrinsics.checkNotNullParameter(iTapHttpSign, "<set-?>");
            this.signHandler = iTapHttpSign;
        }

        /* JADX INFO: renamed from: getCompressHandler$tap_common_release, reason: from getter */
        public final ITapHttpCompress getCompressHandler() {
            return this.compressHandler;
        }

        public final void setCompressHandler$tap_common_release(ITapHttpCompress iTapHttpCompress) {
            Intrinsics.checkNotNullParameter(iTapHttpCompress, "<set-?>");
            this.compressHandler = iTapHttpCompress;
        }

        /* JADX INFO: renamed from: getLogLevel$tap_common_release, reason: from getter */
        public final TapLogInterceptor.Level getLogLevel() {
            return this.logLevel;
        }

        public final void setLogLevel$tap_common_release(TapLogInterceptor.Level level) {
            Intrinsics.checkNotNullParameter(level, "<set-?>");
            this.logLevel = level;
        }

        /* JADX INFO: renamed from: getEnableTechnicalLog$tap_common_release, reason: from getter */
        public final boolean getEnableTechnicalLog() {
            return this.enableTechnicalLog;
        }

        public final void setEnableTechnicalLog$tap_common_release(boolean z) {
            this.enableTechnicalLog = z;
        }

        /* JADX INFO: renamed from: getEnableConsoleLog$tap_common_release, reason: from getter */
        public final boolean getEnableConsoleLog() {
            return this.enableConsoleLog;
        }

        public final void setEnableConsoleLog$tap_common_release(boolean z) {
            this.enableConsoleLog = z;
        }

        /* JADX INFO: renamed from: getEnableAuthorization$tap_common_release, reason: from getter */
        public final boolean getEnableAuthorization() {
            return this.enableAuthorization;
        }

        public final void setEnableAuthorization$tap_common_release(boolean z) {
            this.enableAuthorization = z;
        }

        public final Builder connectTimeout(long connectTimeoutMillis) {
            Builder $this$connectTimeout_u24lambda_u240 = this;
            $this$connectTimeout_u24lambda_u240.okHttpClientBuilder.connectTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder readTimeout(long readTimeoutMillis) {
            Builder $this$readTimeout_u24lambda_u241 = this;
            $this$readTimeout_u24lambda_u241.okHttpClientBuilder.readTimeout(readTimeoutMillis, TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder writeTimeout(long writeTimeoutMillis) {
            Builder $this$writeTimeout_u24lambda_u242 = this;
            $this$writeTimeout_u24lambda_u242.okHttpClientBuilder.writeTimeout(writeTimeoutMillis, TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder domain(String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            Builder $this$domain_u24lambda_u243 = this;
            $this$domain_u24lambda_u243.domain = domain;
            return this;
        }

        public final Builder compressHandler(ITapHttpCompress compress) {
            Intrinsics.checkNotNullParameter(compress, "compress");
            Builder $this$compressHandler_u24lambda_u244 = this;
            $this$compressHandler_u24lambda_u244.compressHandler = compress;
            return this;
        }

        public final Builder signHandler(ITapHttpSign sign) {
            Intrinsics.checkNotNullParameter(sign, "sign");
            Builder $this$signHandler_u24lambda_u245 = this;
            $this$signHandler_u24lambda_u245.signHandler = sign;
            return this;
        }

        public final Builder debugLogLevel(TapLogInterceptor.Level logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Builder $this$debugLogLevel_u24lambda_u246 = this;
            $this$debugLogLevel_u24lambda_u246.logLevel = logLevel;
            return this;
        }

        public final Builder setTechnicalLogEnable(boolean enable) {
            Builder $this$setTechnicalLogEnable_u24lambda_u247 = this;
            $this$setTechnicalLogEnable_u24lambda_u247.enableTechnicalLog = enable;
            return this;
        }

        public final Builder setLogEnable(boolean enable) {
            Builder $this$setLogEnable_u24lambda_u248 = this;
            $this$setLogEnable_u24lambda_u248.enableConsoleLog = enable;
            return this;
        }

        public final Builder enableAuthorization() {
            Builder $this$enableAuthorization_u24lambda_u249 = this;
            $this$enableAuthorization_u24lambda_u249.enableAuthorization = true;
            return this;
        }

        public final TapHttp build() {
            return new TapHttp(this, null);
        }
    }
}
