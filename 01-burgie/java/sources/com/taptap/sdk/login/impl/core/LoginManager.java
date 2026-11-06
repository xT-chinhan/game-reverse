package com.taptap.sdk.login.impl.core;

import android.app.Activity;
import android.content.Context;
import android.webkit.CookieManager;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapFirstPartyLoginOptions;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.LoginTracker;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.data.model.LoginTypes;
import com.taptap.sdk.login.impl.statemachine.state.LoginStateManager;
import com.taptap.sdk.login.impl.utils.WebViewUriProvider;
import com.umeng.analytics.pro.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoginManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\u001f\u001a\u00020\u000bJ2\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\"\u001a\u00020#2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020$0\u0012J\u0006\u0010%\u001a\u00020\u000bJ\u0010\u0010&\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010'\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginManager;", "", "builder", "Lcom/taptap/sdk/login/impl/core/LoginManager$Builder;", "(Lcom/taptap/sdk/login/impl/core/LoginManager$Builder;)V", "coordinator", "Lcom/taptap/sdk/login/impl/core/LoginCoordinator;", "sdkOptions", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/login/impl/core/LoginCoordinator;Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "auth", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/AccessToken;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "clearLoginDomainCookies", "getLoginType", "Lcom/taptap/sdk/login/impl/data/model/LoginTypes;", "handleLoginResponse", d.R, "Landroid/content/Context;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "response", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "initialize", "login", "", "options", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "Lcom/taptap/sdk/login/TapTapAccount;", "logout", "notifyCancel", "notifyFail", "error", "Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "onActivityDestroy", "Builder", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile LoginManager INSTANCE;
    private static volatile boolean _isInstanceInitialized;
    private static volatile Builder builderInstance;
    private final LoginCoordinator coordinator;
    private final TapTapSdkOptions sdkOptions;

    public /* synthetic */ LoginManager(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final LoginManager getInstance() {
        return INSTANCE.getInstance();
    }

    private LoginManager(LoginCoordinator coordinator, TapTapSdkOptions sdkOptions) {
        this.coordinator = coordinator;
        this.sdkOptions = sdkOptions;
    }

    private LoginManager(Builder builder) {
        LoginRequestBuilder requestBuilder = builder.getRequestBuilder();
        if (requestBuilder == null) {
            throw new IllegalStateException("LoginRequestBuilder is not provided".toString());
        }
        LoginTracker tracker = builder.getTracker();
        if (tracker == null) {
            throw new IllegalStateException("LoginTracker is not provided".toString());
        }
        LoginStateManager stateManager = builder.getStateManager();
        if (stateManager == null) {
            throw new IllegalStateException("LoginStateManager is not provided".toString());
        }
        LoginResponseHandler responseHandler = builder.getResponseHandler();
        if (responseHandler == null) {
            throw new IllegalStateException("LoginResponseHandler is not provided".toString());
        }
        LoginCoordinator loginCoordinator = new LoginCoordinator(stateManager, requestBuilder, tracker, responseHandler, builder.getScope());
        TapTapSdkOptions sdkOptions = builder.getSdkOptions();
        if (sdkOptions == null) {
            throw new IllegalStateException("TapTapSdkOptions is not provided".toString());
        }
        this(loginCoordinator, sdkOptions);
    }

    public final void initialize() {
        LoginStatusChangeManager.INSTANCE.startObserving(this.coordinator.getStateManager());
    }

    public final void login(Activity activity, List<String> scopes, TapFirstPartyLoginOptions options, TapTapCallback<TapTapAccount> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.coordinator.login(activity, scopes, options, callback);
    }

    public final void auth(Activity activity, String[] scopes, TapTapCallback<AccessToken> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.coordinator.auth(activity, ArraysKt.toList(scopes), callback);
    }

    public final void logout() {
        AccountManager.INSTANCE.getInstance().clearCache();
        clearLoginDomainCookies();
        this.coordinator.getStateManager().transitionToLoggedOut();
    }

    public final LoginTypes getLoginType(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.coordinator.getLoginType(activity);
    }

    public final void handleLoginResponse(Context context, LoginRequest request, LoginResponse response) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.coordinator.handleLoginResponse(context, request, response);
    }

    public final void notifyCancel(LoginRequest request) {
        this.coordinator.notifyCancel(request);
    }

    public final void notifyFail(LoginRequest request, TapTapException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.coordinator.notifyFail(request, error);
    }

    public final void onActivityDestroy(LoginRequest request) {
        this.coordinator.onActivityDestroy(request);
    }

    private final void clearLoginDomainCookies() {
        Iterable iterableSplit$default;
        String currentWebUrl = WebViewUriProvider.INSTANCE.provide(TapTapKit.INSTANCE.isRND(), this.sdkOptions.getRegion());
        CookieManager cookieManager = CookieManager.getInstance();
        String cookies = cookieManager.getCookie(currentWebUrl);
        if (cookies == null || (iterableSplit$default = StringsKt.split$default((CharSequence) cookies, new String[]{";"}, false, 0, 6, (Object) null)) == null) {
            return;
        }
        Iterable $this$onEach$iv = iterableSplit$default;
        for (Object element$iv : $this$onEach$iv) {
            String cookie = (String) element$iv;
            List cookieParts = StringsKt.split$default((CharSequence) cookie, new String[]{"="}, false, 0, 6, (Object) null);
            List $this$forEach$iv = cookieParts;
            for (Object element$iv2 : $this$forEach$iv) {
                cookieManager.setCookie(currentWebUrl, StringsKt.trim((CharSequence) cookieParts.get(0)).toString() + "=;Max-Age=0");
                cookies = cookies;
            }
        }
    }

    /* JADX INFO: compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0014@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0018@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginManager$Builder;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "Lcom/taptap/sdk/login/impl/core/LoginRequestBuilder;", "requestBuilder", "getRequestBuilder$tap_login_release", "()Lcom/taptap/sdk/login/impl/core/LoginRequestBuilder;", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler;", "responseHandler", "getResponseHandler$tap_login_release", "()Lcom/taptap/sdk/login/impl/core/LoginResponseHandler;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "sdkOptions", "getSdkOptions$tap_login_release", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;", "stateManager", "getStateManager$tap_login_release", "()Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;", "Lcom/taptap/sdk/login/impl/LoginTracker;", "tracker", "getTracker$tap_login_release", "()Lcom/taptap/sdk/login/impl/LoginTracker;", "applyRequestBuilder", "applyResponseHandler", "applySdkOptions", "applyStateManager", "applyTracker", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private LoginRequestBuilder requestBuilder;
        private LoginResponseHandler responseHandler;
        private final CoroutineScope scope;
        private TapTapSdkOptions sdkOptions;
        private LoginStateManager stateManager;
        private LoginTracker tracker;

        public Builder(CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.scope = scope;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        /* JADX INFO: renamed from: getRequestBuilder$tap_login_release, reason: from getter */
        public final LoginRequestBuilder getRequestBuilder() {
            return this.requestBuilder;
        }

        /* JADX INFO: renamed from: getTracker$tap_login_release, reason: from getter */
        public final LoginTracker getTracker() {
            return this.tracker;
        }

        /* JADX INFO: renamed from: getStateManager$tap_login_release, reason: from getter */
        public final LoginStateManager getStateManager() {
            return this.stateManager;
        }

        /* JADX INFO: renamed from: getResponseHandler$tap_login_release, reason: from getter */
        public final LoginResponseHandler getResponseHandler() {
            return this.responseHandler;
        }

        /* JADX INFO: renamed from: getSdkOptions$tap_login_release, reason: from getter */
        public final TapTapSdkOptions getSdkOptions() {
            return this.sdkOptions;
        }

        public final Builder applyRequestBuilder(LoginRequestBuilder requestBuilder) {
            Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
            Builder $this$applyRequestBuilder_u24lambda_u240 = this;
            $this$applyRequestBuilder_u24lambda_u240.requestBuilder = requestBuilder;
            return this;
        }

        public final Builder applyTracker(LoginTracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            Builder $this$applyTracker_u24lambda_u241 = this;
            $this$applyTracker_u24lambda_u241.tracker = tracker;
            return this;
        }

        public final Builder applyStateManager(LoginStateManager stateManager) {
            Intrinsics.checkNotNullParameter(stateManager, "stateManager");
            Builder $this$applyStateManager_u24lambda_u242 = this;
            $this$applyStateManager_u24lambda_u242.stateManager = stateManager;
            return this;
        }

        public final Builder applyResponseHandler(LoginResponseHandler responseHandler) {
            Intrinsics.checkNotNullParameter(responseHandler, "responseHandler");
            Builder $this$applyResponseHandler_u24lambda_u243 = this;
            $this$applyResponseHandler_u24lambda_u243.responseHandler = responseHandler;
            return this;
        }

        public final Builder applySdkOptions(TapTapSdkOptions sdkOptions) {
            Intrinsics.checkNotNullParameter(sdkOptions, "sdkOptions");
            Builder $this$applySdkOptions_u24lambda_u244 = this;
            $this$applySdkOptions_u24lambda_u244.sdkOptions = sdkOptions;
            return this;
        }
    }

    /* JADX INFO: compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u0006\u0010\u000f\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginManager$Companion;", "", "()V", "INSTANCE", "Lcom/taptap/sdk/login/impl/core/LoginManager;", "_isInstanceInitialized", "", "builderInstance", "Lcom/taptap/sdk/login/impl/core/LoginManager$Builder;", "applyBuilder", "", "builder", "configure", "create", "getInstance", "initialized", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginManager configure(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            applyBuilder(builder);
            return getInstance();
        }

        @JvmStatic
        public final LoginManager getInstance() {
            LoginManager it;
            LoginManager loginManager = LoginManager.INSTANCE;
            if (loginManager != null) {
                return loginManager;
            }
            synchronized (this) {
                it = LoginManager.INSTANCE;
                if (it == null) {
                    it = LoginManager.INSTANCE.create();
                    Companion companion = LoginManager.INSTANCE;
                    LoginManager.INSTANCE = it;
                }
            }
            return it;
        }

        public final boolean initialized() {
            return LoginManager._isInstanceInitialized;
        }

        private final void applyBuilder(Builder builder) {
            LoginManager.builderInstance = builder;
        }

        private final LoginManager create() {
            Builder builder = LoginManager.builderInstance;
            if (builder == null) {
                throw new IllegalStateException("LoginManager is not configured, please call LoginManager.configure() first.".toString());
            }
            LoginManager loginManager = new LoginManager(builder, (DefaultConstructorMarker) null);
            Companion companion = LoginManager.INSTANCE;
            LoginManager._isInstanceInitialized = true;
            return loginManager;
        }
    }
}
