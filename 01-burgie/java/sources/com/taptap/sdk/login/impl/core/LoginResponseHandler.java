package com.taptap.sdk.login.impl.core;

import android.content.Context;
import android.net.Uri;
import com.byazt.mg.PluginConstants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.LoginTracker;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.repository.LoginRepository;
import com.taptap.sdk.login.impl.utils.LoginToastHelper;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginResponseHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J@\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginResponseHandler;", "", "repository", "Lcom/taptap/sdk/login/impl/repository/LoginRepository;", "accountManager", "Lcom/taptap/sdk/login/impl/core/AccountManager;", "(Lcom/taptap/sdk/login/impl/repository/LoginRepository;Lcom/taptap/sdk/login/impl/core/AccountManager;)V", "handleCode", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result;", d.R, "Landroid/content/Context;", PluginConstants.KEY_ERROR_CODE, "", "codeVerifier", "serverUri", "sessionId", "isAuth", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "response", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "(Landroid/content/Context;Lcom/taptap/sdk/login/impl/data/model/LoginRequest;Lcom/taptap/sdk/login/impl/data/model/LoginResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showLoginSuccessToast", "", "Companion", "Result", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginResponseHandler {
    private static final String ERROR_ACCESS_DENIED = "access_denied";
    private static final String TAG = "LoginResponseHandler";
    private final AccountManager accountManager;
    private final LoginRepository repository;

    /* JADX INFO: renamed from: com.taptap.sdk.login.impl.core.LoginResponseHandler$handleCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginResponseHandler.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.impl.core.LoginResponseHandler", f = "LoginResponseHandler.kt", i = {0, 0, 0, 0}, l = {121}, m = "handleCode", n = {"this", d.R, "serverUri", "isAuth"}, s = {"L$0", "L$1", "L$2", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginResponseHandler.this.handleCode(null, null, null, null, null, false, this);
        }
    }

    public LoginResponseHandler(LoginRepository repository, AccountManager accountManager) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(accountManager, "accountManager");
        this.repository = repository;
        this.accountManager = accountManager;
    }

    /* JADX INFO: compiled from: LoginResponseHandler.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result;", "", "()V", "Cancelled", "Failed", "Success", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result$Cancelled;", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result$Failed;", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result$Success;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Result {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        /* JADX INFO: compiled from: LoginResponseHandler.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result$Success;", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result;", "account", "Lcom/taptap/sdk/login/TapTapAccount;", "sdkToken", "Lcom/taptap/sdk/login/AccessToken;", "(Lcom/taptap/sdk/login/TapTapAccount;Lcom/taptap/sdk/login/AccessToken;)V", "getAccount", "()Lcom/taptap/sdk/login/TapTapAccount;", "getSdkToken", "()Lcom/taptap/sdk/login/AccessToken;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Success extends Result {
            private final TapTapAccount account;
            private final AccessToken sdkToken;

            public static /* synthetic */ Success copy$default(Success success, TapTapAccount tapTapAccount, AccessToken accessToken, int i, Object obj) {
                if ((i & 1) != 0) {
                    tapTapAccount = success.account;
                }
                if ((i & 2) != 0) {
                    accessToken = success.sdkToken;
                }
                return success.copy(tapTapAccount, accessToken);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TapTapAccount getAccount() {
                return this.account;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final AccessToken getSdkToken() {
                return this.sdkToken;
            }

            public final Success copy(TapTapAccount account, AccessToken sdkToken) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(sdkToken, "sdkToken");
                return new Success(account, sdkToken);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.account, success.account) && Intrinsics.areEqual(this.sdkToken, success.sdkToken);
            }

            public int hashCode() {
                return (this.account.hashCode() * 31) + this.sdkToken.hashCode();
            }

            public String toString() {
                return "Success(account=" + this.account + ", sdkToken=" + this.sdkToken + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(TapTapAccount account, AccessToken sdkToken) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(sdkToken, "sdkToken");
                this.account = account;
                this.sdkToken = sdkToken;
            }

            public final TapTapAccount getAccount() {
                return this.account;
            }

            public final AccessToken getSdkToken() {
                return this.sdkToken;
            }
        }

        /* JADX INFO: compiled from: LoginResponseHandler.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result$Cancelled;", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result;", "()V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Cancelled extends Result {
            public static final Cancelled INSTANCE = new Cancelled();

            private Cancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: LoginResponseHandler.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result$Failed;", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler$Result;", "exception", "Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "(Lcom/taptap/sdk/kit/internal/exception/TapTapException;)V", "getException", "()Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Failed extends Result {
            private final TapTapException exception;

            public static /* synthetic */ Failed copy$default(Failed failed, TapTapException tapTapException, int i, Object obj) {
                if ((i & 1) != 0) {
                    tapTapException = failed.exception;
                }
                return failed.copy(tapTapException);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TapTapException getException() {
                return this.exception;
            }

            public final Failed copy(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new Failed(exception);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failed) && Intrinsics.areEqual(this.exception, ((Failed) other).exception);
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "Failed(exception=" + this.exception + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(TapTapException exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public final TapTapException getException() {
                return this.exception;
            }
        }
    }

    public final Object handleResponse(Context context, LoginRequest request, LoginResponse response, Continuation<? super Result> continuation) {
        if (!Intrinsics.areEqual(request.getState(), response.getId())) {
            return new Result.Failed(new TapTapException("State mismatch"));
        }
        if (response.getCancel()) {
            return Result.Cancelled.INSTANCE;
        }
        String errorMessage = response.getErrorMessage();
        if (!(errorMessage == null || errorMessage.length() == 0)) {
            if (Intrinsics.areEqual(response.getErrorMessage(), "access_denied")) {
                return Result.Cancelled.INSTANCE;
            }
            return new Result.Failed(new TapTapException("Fail to login"));
        }
        LoginTracker.INSTANCE.trackAuthCode$tap_login_release(request.getTrackInfo());
        String code = response.getCode();
        if (code != null) {
            return handleCode(context, code, request.getCodeVerifier(), response.getServerUri(), request.getSessionId(), request.isAuth(), continuation);
        }
        TapLogger.loge$default(TAG, "No code in response", null, 4, null);
        return new Result.Failed(new TapTapException("No authorization code"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object handleCode(Context context, String str, String str2, String str3, String str4, boolean isAuth, Continuation<? super Result> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        String serverUri;
        Object objLoginWithCode;
        LoginResponseHandler loginResponseHandler;
        boolean isAuth2;
        Context context2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    serverUri = str3;
                    LoginRepository loginRepository = this.repository;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = context;
                    anonymousClass1.L$2 = serverUri;
                    anonymousClass1.Z$0 = isAuth;
                    anonymousClass1.label = 1;
                    objLoginWithCode = loginRepository.loginWithCode(str, str2, "tapoauth://authorize", str4, "tapsdk", anonymousClass1);
                    if (objLoginWithCode == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loginResponseHandler = this;
                    isAuth2 = isAuth;
                    context2 = context;
                    break;
                    break;
                case 1:
                    isAuth2 = anonymousClass1.Z$0;
                    String serverUri2 = (String) anonymousClass1.L$2;
                    context2 = (Context) anonymousClass1.L$1;
                    loginResponseHandler = (LoginResponseHandler) anonymousClass1.L$0;
                    ResultKt.throwOnFailure($result);
                    serverUri = serverUri2;
                    objLoginWithCode = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PrivateTapSdkAccount privateTapSdkAccount = (PrivateTapSdkAccount) objLoginWithCode;
            TapTapAccount account = privateTapSdkAccount.convertAsTapTapAccount();
            if (!isAuth2) {
                loginResponseHandler.accountManager.saveAccount(account);
                loginResponseHandler.accountManager.savePrivateTapSdkAccount(privateTapSdkAccount);
                loginResponseHandler.showLoginSuccessToast(context2, serverUri);
            }
            return new Result.Success(account, privateTapSdkAccount.getSdkToken());
        } catch (Throwable e) {
            TapLogger.loge(TAG, "Failed to exchange code for token", e);
            return new Result.Failed(new TapTapException("Failed to login"));
        }
    }

    private final void showLoginSuccessToast(Context context, String serverUri) {
        if (serverUri != null) {
            try {
                Uri rawUri = Uri.parse(serverUri);
                String name = rawUri.getQueryParameter(Common.System.NAME);
                if (name != null) {
                    LoginToastHelper loginToastHelper = LoginToastHelper.INSTANCE;
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    String string = context.getResources().getString(R.string.login_account_logged_tip, name);
                    Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…unt_logged_tip, userName)");
                    loginToastHelper.showToast(applicationContext, string);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th) {
                TapLogger.logw$default(TAG, "Failed to parse server uri for toast", false, 4, null);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
