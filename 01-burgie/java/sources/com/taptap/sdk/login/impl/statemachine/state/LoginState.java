package com.taptap.sdk.login.impl.statemachine.state;

import com.byazt.mg.PluginConstants;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.LoginAction;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\b !\"#$%&'¨\u0006("}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "", "()V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "isAuth", "", "()Z", "isIdle", "isLogin", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "AuthInProgress", "Cancelled", "Failed", "HandlingResponse", "Idle", "LoggedOut", "LoginInProgress", "Success", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$AuthInProgress;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Cancelled;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Failed;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$HandlingResponse;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Idle;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$LoggedOut;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$LoginInProgress;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Success;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class LoginState {
    public /* synthetic */ LoginState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TapTapCallback<?> getCallback();

    public abstract Integer getCode();

    public abstract LoginRequest getRequest();

    public abstract String getSessionId();

    private LoginState() {
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Idle;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "()V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Idle extends LoginState {
        public static final Idle INSTANCE = new Idle();
        private static final TapTapCallback<?> callback = null;
        private static final Integer code = null;
        private static final LoginRequest request = null;
        private static final String sessionId = null;

        private Idle() {
            super(null);
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return request;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<?> getCallback() {
            return callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return code;
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$LoginInProgress;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "sessionId", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/TapTapAccount;", "(Lcom/taptap/sdk/login/impl/data/model/LoginRequest;Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class LoginInProgress extends LoginState {
        private final TapTapCallback<TapTapAccount> callback;
        private final Integer code;
        private final LoginRequest request;
        private final String sessionId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoginInProgress copy$default(LoginInProgress loginInProgress, LoginRequest loginRequest, String str, TapTapCallback tapTapCallback, int i, Object obj) {
            if ((i & 1) != 0) {
                loginRequest = loginInProgress.request;
            }
            if ((i & 2) != 0) {
                str = loginInProgress.sessionId;
            }
            if ((i & 4) != 0) {
                tapTapCallback = loginInProgress.callback;
            }
            return loginInProgress.copy(loginRequest, str, tapTapCallback);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoginRequest getRequest() {
            return this.request;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final TapTapCallback<TapTapAccount> component3() {
            return this.callback;
        }

        public final LoginInProgress copy(LoginRequest request, String sessionId, TapTapCallback<TapTapAccount> callback) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return new LoginInProgress(request, sessionId, callback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoginInProgress)) {
                return false;
            }
            LoginInProgress loginInProgress = (LoginInProgress) other;
            return Intrinsics.areEqual(this.request, loginInProgress.request) && Intrinsics.areEqual(this.sessionId, loginInProgress.sessionId) && Intrinsics.areEqual(this.callback, loginInProgress.callback);
        }

        public int hashCode() {
            return (((this.request.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "LoginInProgress(request=" + this.request + ", sessionId=" + this.sessionId + ", callback=" + this.callback + ')';
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return this.request;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return this.sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<TapTapAccount> getCallback() {
            return this.callback;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginInProgress(LoginRequest request, String sessionId, TapTapCallback<TapTapAccount> callback) {
            super(null);
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.request = request;
            this.sessionId = sessionId;
            this.callback = callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$AuthInProgress;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "sessionId", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/AccessToken;", "(Lcom/taptap/sdk/login/impl/data/model/LoginRequest;Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class AuthInProgress extends LoginState {
        private final TapTapCallback<AccessToken> callback;
        private final Integer code;
        private final LoginRequest request;
        private final String sessionId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AuthInProgress copy$default(AuthInProgress authInProgress, LoginRequest loginRequest, String str, TapTapCallback tapTapCallback, int i, Object obj) {
            if ((i & 1) != 0) {
                loginRequest = authInProgress.request;
            }
            if ((i & 2) != 0) {
                str = authInProgress.sessionId;
            }
            if ((i & 4) != 0) {
                tapTapCallback = authInProgress.callback;
            }
            return authInProgress.copy(loginRequest, str, tapTapCallback);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoginRequest getRequest() {
            return this.request;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final TapTapCallback<AccessToken> component3() {
            return this.callback;
        }

        public final AuthInProgress copy(LoginRequest request, String sessionId, TapTapCallback<AccessToken> callback) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return new AuthInProgress(request, sessionId, callback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthInProgress)) {
                return false;
            }
            AuthInProgress authInProgress = (AuthInProgress) other;
            return Intrinsics.areEqual(this.request, authInProgress.request) && Intrinsics.areEqual(this.sessionId, authInProgress.sessionId) && Intrinsics.areEqual(this.callback, authInProgress.callback);
        }

        public int hashCode() {
            return (((this.request.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "AuthInProgress(request=" + this.request + ", sessionId=" + this.sessionId + ", callback=" + this.callback + ')';
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return this.request;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return this.sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<AccessToken> getCallback() {
            return this.callback;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthInProgress(LoginRequest request, String sessionId, TapTapCallback<AccessToken> callback) {
            super(null);
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.request = request;
            this.sessionId = sessionId;
            this.callback = callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0017\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$HandlingResponse;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "delegate", "(Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;)V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDelegate", "()Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class HandlingResponse extends LoginState {
        private final Integer code;
        private final LoginState delegate;

        public static /* synthetic */ HandlingResponse copy$default(HandlingResponse handlingResponse, LoginState loginState, int i, Object obj) {
            if ((i & 1) != 0) {
                loginState = handlingResponse.delegate;
            }
            return handlingResponse.copy(loginState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoginState getDelegate() {
            return this.delegate;
        }

        public final HandlingResponse copy(LoginState delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            return new HandlingResponse(delegate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HandlingResponse) && Intrinsics.areEqual(this.delegate, ((HandlingResponse) other).delegate);
        }

        public int hashCode() {
            return this.delegate.hashCode();
        }

        public String toString() {
            return "HandlingResponse(delegate=" + this.delegate + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlingResponse(LoginState delegate) {
            super(null);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
        }

        public final LoginState getDelegate() {
            return this.delegate;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return this.delegate.getSessionId();
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return this.delegate.getRequest();
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<?> getCallback() {
            return this.delegate.getCallback();
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Success;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "sessionId", "", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "(Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/LoginRequest;)V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Success extends LoginState {
        private final TapTapCallback<?> callback;
        private final int code;
        private final LoginRequest request;
        private final String sessionId;

        public static /* synthetic */ Success copy$default(Success success, String str, LoginRequest loginRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.sessionId;
            }
            if ((i & 2) != 0) {
                loginRequest = success.request;
            }
            return success.copy(str, loginRequest);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LoginRequest getRequest() {
            return this.request;
        }

        public final Success copy(String sessionId, LoginRequest request) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(request, "request");
            return new Success(sessionId, request);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.sessionId, success.sessionId) && Intrinsics.areEqual(this.request, success.request);
        }

        public int hashCode() {
            return (this.sessionId.hashCode() * 31) + this.request.hashCode();
        }

        public String toString() {
            return "Success(sessionId=" + this.sessionId + ", request=" + this.request + ')';
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return this.sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return this.request;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String sessionId, LoginRequest request) {
            super(null);
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(request, "request");
            this.sessionId = sessionId;
            this.request = request;
            this.code = LoginAction.LOGIN_SUCCESS;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<?> getCallback() {
            return this.callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return Integer.valueOf(this.code);
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u000eHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Failed;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "sessionId", "", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "exception", "Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "(Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/LoginRequest;Lcom/taptap/sdk/kit/internal/exception/TapTapException;)V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "getException", "()Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Failed extends LoginState {
        private final TapTapCallback<?> callback;
        private final int code;
        private final TapTapException exception;
        private final LoginRequest request;
        private final String sessionId;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, LoginRequest loginRequest, TapTapException tapTapException, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.sessionId;
            }
            if ((i & 2) != 0) {
                loginRequest = failed.request;
            }
            if ((i & 4) != 0) {
                tapTapException = failed.exception;
            }
            return failed.copy(str, loginRequest, tapTapException);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LoginRequest getRequest() {
            return this.request;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final TapTapException getException() {
            return this.exception;
        }

        public final Failed copy(String sessionId, LoginRequest request, TapTapException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Failed(sessionId, request, exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return Intrinsics.areEqual(this.sessionId, failed.sessionId) && Intrinsics.areEqual(this.request, failed.request) && Intrinsics.areEqual(this.exception, failed.exception);
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            LoginRequest loginRequest = this.request;
            return ((iHashCode + (loginRequest != null ? loginRequest.hashCode() : 0)) * 31) + this.exception.hashCode();
        }

        public String toString() {
            return "Failed(sessionId=" + this.sessionId + ", request=" + this.request + ", exception=" + this.exception + ')';
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return this.sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return this.request;
        }

        public final TapTapException getException() {
            return this.exception;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String sessionId, LoginRequest request, TapTapException exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.sessionId = sessionId;
            this.request = request;
            this.exception = exception;
            this.code = LoginAction.LOGIN_FAIL;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<?> getCallback() {
            return this.callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return Integer.valueOf(this.code);
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$Cancelled;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "sessionId", "", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "(Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/LoginRequest;)V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Cancelled extends LoginState {
        private final TapTapCallback<?> callback;
        private final int code;
        private final LoginRequest request;
        private final String sessionId;

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, String str, LoginRequest loginRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cancelled.sessionId;
            }
            if ((i & 2) != 0) {
                loginRequest = cancelled.request;
            }
            return cancelled.copy(str, loginRequest);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LoginRequest getRequest() {
            return this.request;
        }

        public final Cancelled copy(String sessionId, LoginRequest request) {
            return new Cancelled(sessionId, request);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cancelled)) {
                return false;
            }
            Cancelled cancelled = (Cancelled) other;
            return Intrinsics.areEqual(this.sessionId, cancelled.sessionId) && Intrinsics.areEqual(this.request, cancelled.request);
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            LoginRequest loginRequest = this.request;
            return iHashCode + (loginRequest != null ? loginRequest.hashCode() : 0);
        }

        public String toString() {
            return "Cancelled(sessionId=" + this.sessionId + ", request=" + this.request + ')';
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return this.sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return this.request;
        }

        public Cancelled(String sessionId, LoginRequest request) {
            super(null);
            this.sessionId = sessionId;
            this.request = request;
            this.code = LoginAction.LOGIN_CANCEL;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<?> getCallback() {
            return this.callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return Integer.valueOf(this.code);
        }
    }

    /* JADX INFO: compiled from: LoginState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$LoggedOut;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "()V", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "getCallback", "()Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", PluginConstants.KEY_ERROR_CODE, "", "getCode", "()Ljava/lang/Integer;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "getRequest", "()Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LoggedOut extends LoginState {
        private static final TapTapCallback<?> callback = null;
        private static final LoginRequest request = null;
        private static final String sessionId = null;
        public static final LoggedOut INSTANCE = new LoggedOut();
        private static final int code = LoginAction.LOGOUT;

        private LoggedOut() {
            super(null);
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public String getSessionId() {
            return sessionId;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public LoginRequest getRequest() {
            return request;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public TapTapCallback<?> getCallback() {
            return callback;
        }

        @Override // com.taptap.sdk.login.impl.statemachine.state.LoginState
        public Integer getCode() {
            return Integer.valueOf(code);
        }
    }

    public final boolean isIdle() {
        return this instanceof Idle;
    }

    public final boolean isLogin() {
        if (this instanceof LoginInProgress) {
            return true;
        }
        if (this instanceof HandlingResponse) {
            return ((HandlingResponse) this).getDelegate() instanceof LoginInProgress;
        }
        return false;
    }

    public final boolean isAuth() {
        if (this instanceof AuthInProgress) {
            return true;
        }
        if (this instanceof HandlingResponse) {
            return ((HandlingResponse) this).getDelegate() instanceof AuthInProgress;
        }
        return false;
    }
}
