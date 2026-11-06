package com.taptap.sdk.login.impl.core;

import android.app.Activity;
import android.content.Context;
import com.byazt.ol.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.StringExtKt;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapFirstPartyLoginOptions;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.LoginTracker;
import com.taptap.sdk.login.impl.data.model.Actions;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.data.model.LoginTypes;
import com.taptap.sdk.login.impl.statemachine.state.LoginState;
import com.taptap.sdk.login.impl.statemachine.state.LoginStateManager;
import com.taptap.sdk.login.impl.ui.activity.TapTapLoginActivity;
import com.umeng.analytics.pro.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;

/* JADX INFO: compiled from: LoginCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#J \u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0002J2\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010)\u001a\u00020*2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020&0\u0019J\u0010\u0010+\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010,\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginCoordinator;", "", "stateManager", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;", "requestBuilder", "Lcom/taptap/sdk/login/impl/core/LoginRequestBuilder;", "tracker", "Lcom/taptap/sdk/login/impl/LoginTracker;", "responseHandler", "Lcom/taptap/sdk/login/impl/core/LoginResponseHandler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;Lcom/taptap/sdk/login/impl/core/LoginRequestBuilder;Lcom/taptap/sdk/login/impl/LoginTracker;Lcom/taptap/sdk/login/impl/core/LoginResponseHandler;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getStateManager", "()Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;", "auth", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/AccessToken;", "getLoginType", "Lcom/taptap/sdk/login/impl/data/model/LoginTypes;", "handleLoginResponse", d.R, "Landroid/content/Context;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "response", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "handleSuccess", "account", "Lcom/taptap/sdk/login/TapTapAccount;", "sdkToken", "login", "options", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "notifyCancel", "notifyFail", "exception", "Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "onActivityDestroy", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginCoordinator {
    private final CoroutineScope coroutineScope;
    private final LoginRequestBuilder requestBuilder;
    private final LoginResponseHandler responseHandler;
    private final LoginStateManager stateManager;
    private final LoginTracker tracker;

    public LoginCoordinator(LoginStateManager stateManager, LoginRequestBuilder requestBuilder, LoginTracker tracker, LoginResponseHandler responseHandler, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(stateManager, "stateManager");
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(responseHandler, "responseHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.stateManager = stateManager;
        this.requestBuilder = requestBuilder;
        this.tracker = tracker;
        this.responseHandler = responseHandler;
        this.coroutineScope = coroutineScope;
    }

    public final LoginStateManager getStateManager() {
        return this.stateManager;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void login(Activity activity, List<String> scopes, TapFirstPartyLoginOptions options, TapTapCallback<TapTapAccount> callback) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginTypes loginType = LoginTypes.INSTANCE.from(activity, Actions.INSTANCE.from(this.requestBuilder.getRegionType()));
        String sessionId = StringExtKt.generateSessionId();
        if (scopes.isEmpty()) {
            this.tracker.trackFail$tap_login_release("loginWithScopes", sessionId, MapsKt.mapOf(TuplesKt.to("login_type", loginType.getValue())), -1, "Scope is empty");
            callback.onFail(new TapTapException("Scope cannot be empty"));
            return;
        }
        try {
            this.stateManager.checkNoRequestInProgress();
            this.tracker.trackFuncStart$tap_login_release("loginWithScopes", sessionId);
            LoginRequest request = this.requestBuilder.buildLoginRequest(CollectionsKt.toList(scopes), loginType, options, sessionId, false);
            LoginState.LoginInProgress newState = new LoginState.LoginInProgress(request, sessionId, callback);
            this.stateManager.transitionToLoginInProgress(newState);
            LoginTracker.INSTANCE.trackLoginStart$tap_login_release("loginWithScopes", sessionId, MapsKt.mapOf(TuplesKt.to("login_type", request.getLoginType()), TuplesKt.to("scopes", CollectionsKt.joinToString$default(request.getScopes(), ",", null, null, 0, null, null, 62, null))));
            TapTapLoginActivity.INSTANCE.startLoginActivity(activity, request);
        } catch (TapTapException e) {
            callback.onFail(e);
        }
    }

    public final void auth(Activity activity, List<String> scopes, TapTapCallback<AccessToken> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginTypes loginType = LoginTypes.INSTANCE.from(activity, Actions.INSTANCE.from(this.requestBuilder.getRegionType()));
        String sessionId = StringExtKt.generateSessionId();
        try {
            this.stateManager.checkNoRequestInProgress();
            LoginRequest request = this.requestBuilder.buildLoginRequest(scopes, loginType, new TapFirstPartyLoginOptions.Builder().build(), sessionId, true);
            LoginState.AuthInProgress newState = new LoginState.AuthInProgress(request, sessionId, callback);
            this.stateManager.transitionToAuthInProgress(newState);
            TapTapLoginActivity.INSTANCE.startLoginActivity(activity, request);
        } catch (TapTapException e) {
            callback.onFail(e);
        }
    }

    public final void handleLoginResponse(Context context, LoginRequest request, LoginResponse response) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (request == null || response == null) {
            notifyFail(request, new TapTapException("Fail to login"));
        } else {
            this.stateManager.transitionToHandlingResponse();
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(context, request, response, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.impl.core.LoginCoordinator$handleLoginResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginCoordinator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.impl.core.LoginCoordinator$handleLoginResponse$1", f = "LoginCoordinator.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ LoginRequest $request;
        final /* synthetic */ LoginResponse $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, LoginRequest loginRequest, LoginResponse loginResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$request = loginRequest;
            this.$response = loginResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginCoordinator.this.new AnonymousClass1(this.$context, this.$request, this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0041 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:16:0x003b, B:18:0x0041, B:19:0x0057, B:21:0x005b, B:22:0x0063, B:24:0x0067), top: B:37:0x003b }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0057 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:16:0x003b, B:18:0x0041, B:19:0x0057, B:21:0x005b, B:22:0x0063, B:24:0x0067), top: B:37:0x003b }] */
        /* JADX WARN: Code duplicated, block: B:21:0x005b A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:16:0x003b, B:18:0x0041, B:19:0x0057, B:21:0x005b, B:22:0x0063, B:24:0x0067), top: B:37:0x003b }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0063 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:16:0x003b, B:18:0x0041, B:19:0x0057, B:21:0x005b, B:22:0x0063, B:24:0x0067), top: B:37:0x003b }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0067 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:16:0x003b, B:18:0x0041, B:19:0x0057, B:21:0x005b, B:22:0x0063, B:24:0x0067), top: B:37:0x003b }] */
        /* JADX WARN: Code duplicated, block: B:32:0x008c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Throwable e;
            AnonymousClass1 anonymousClass2;
            String message;
            LoginResponseHandler.Result result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    try {
                        anonymousClass1.label = 1;
                        Object objHandleResponse = LoginCoordinator.this.responseHandler.handleResponse(anonymousClass1.$context, anonymousClass1.$request, anonymousClass1.$response, anonymousClass1);
                        if (objHandleResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objHandleResponse;
                        try {
                            result = (LoginResponseHandler.Result) $result;
                            if (result instanceof LoginResponseHandler.Result.Success) {
                                LoginCoordinator.this.handleSuccess(anonymousClass1.$request, ((LoginResponseHandler.Result.Success) result).getAccount(), ((LoginResponseHandler.Result.Success) result).getSdkToken());
                            } else if (result instanceof LoginResponseHandler.Result.Cancelled) {
                                LoginCoordinator.this.notifyCancel(anonymousClass1.$request);
                            } else if (result instanceof LoginResponseHandler.Result.Failed) {
                                LoginCoordinator.this.notifyFail(anonymousClass1.$request, ((LoginResponseHandler.Result.Failed) result).getException());
                            }
                            break;
                        } catch (Throwable th) {
                            AnonymousClass1 anonymousClass3 = anonymousClass1;
                            e = th;
                            $result = $result;
                            anonymousClass2 = anonymousClass3;
                            LoginCoordinator loginCoordinator = LoginCoordinator.this;
                            LoginRequest loginRequest = anonymousClass2.$request;
                            message = e.getMessage();
                            if (message == null) {
                                message = "";
                            }
                            loginCoordinator.notifyFail(loginRequest, new TapTapException(message));
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        e = th2;
                        anonymousClass2 = anonymousClass1;
                        LoginCoordinator loginCoordinator2 = LoginCoordinator.this;
                        LoginRequest loginRequest2 = anonymousClass2.$request;
                        message = e.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        loginCoordinator2.notifyFail(loginRequest2, new TapTapException(message));
                        return Unit.INSTANCE;
                    }
                case 1:
                    anonymousClass2 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = anonymousClass2;
                        result = (LoginResponseHandler.Result) $result;
                        if (result instanceof LoginResponseHandler.Result.Success) {
                            LoginCoordinator.this.handleSuccess(anonymousClass1.$request, ((LoginResponseHandler.Result.Success) result).getAccount(), ((LoginResponseHandler.Result.Success) result).getSdkToken());
                        } else if (result instanceof LoginResponseHandler.Result.Cancelled) {
                            LoginCoordinator.this.notifyCancel(anonymousClass1.$request);
                        } else if (result instanceof LoginResponseHandler.Result.Failed) {
                            LoginCoordinator.this.notifyFail(anonymousClass1.$request, ((LoginResponseHandler.Result.Failed) result).getException());
                        }
                        break;
                    } catch (Throwable th3) {
                        e = th3;
                        LoginCoordinator loginCoordinator3 = LoginCoordinator.this;
                        LoginRequest loginRequest3 = anonymousClass2.$request;
                        message = e.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        loginCoordinator3.notifyFail(loginRequest3, new TapTapException(message));
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSuccess(LoginRequest request, TapTapAccount account, AccessToken sdkToken) {
        LoginState currentState = this.stateManager.getCurrentState();
        if (currentState instanceof LoginState.HandlingResponse) {
            LoginState delegate = ((LoginState.HandlingResponse) currentState).getDelegate();
            if (delegate instanceof LoginState.LoginInProgress) {
                this.tracker.trackSuccess$tap_login_release("loginWithScopes", request.getSessionId(), MapsKt.mapOf(TuplesKt.to("login_type", request.getLoginType())));
                ((LoginState.LoginInProgress) delegate).getCallback().onSuccess(account);
            } else if (delegate instanceof LoginState.AuthInProgress) {
                ((LoginState.AuthInProgress) delegate).getCallback().onSuccess(sdkToken);
            }
        }
        this.stateManager.transitionToSuccess(request);
    }

    public final void notifyCancel(LoginRequest request) {
        String loginType;
        String loginType2;
        LoginState currentState = this.stateManager.getCurrentState();
        String str = "";
        if (currentState instanceof LoginState.LoginInProgress) {
            LoginTracker loginTracker = this.tracker;
            String sessionId = ((LoginState.LoginInProgress) currentState).getSessionId();
            if (request != null && (loginType2 = request.getLoginType()) != null) {
                str = loginType2;
            }
            loginTracker.trackCancel$tap_login_release("loginWithScopes", sessionId, MapsKt.mapOf(TuplesKt.to("login_type", str)));
            ((LoginState.LoginInProgress) currentState).getCallback().onCancel();
        } else if (currentState instanceof LoginState.AuthInProgress) {
            ((LoginState.AuthInProgress) currentState).getCallback().onCancel();
        } else if (currentState instanceof LoginState.HandlingResponse) {
            LoginState delegate = ((LoginState.HandlingResponse) currentState).getDelegate();
            if (delegate instanceof LoginState.LoginInProgress) {
                LoginTracker loginTracker2 = this.tracker;
                String sessionId2 = ((LoginState.LoginInProgress) delegate).getSessionId();
                if (request != null && (loginType = request.getLoginType()) != null) {
                    str = loginType;
                }
                loginTracker2.trackCancel$tap_login_release("loginWithScopes", sessionId2, MapsKt.mapOf(TuplesKt.to("login_type", str)));
                ((LoginState.LoginInProgress) delegate).getCallback().onCancel();
            } else if (delegate instanceof LoginState.AuthInProgress) {
                ((LoginState.AuthInProgress) delegate).getCallback().onCancel();
            }
        }
        this.stateManager.transitionToCancelled(request);
    }

    public final void notifyFail(LoginRequest request, TapTapException exception) {
        String loginType;
        String loginType2;
        Intrinsics.checkNotNullParameter(exception, "exception");
        LoginState currentState = this.stateManager.getCurrentState();
        String str = "";
        if (currentState instanceof LoginState.LoginInProgress) {
            LoginTracker loginTracker = this.tracker;
            String sessionId = ((LoginState.LoginInProgress) currentState).getSessionId();
            if (request != null && (loginType2 = request.getLoginType()) != null) {
                str = loginType2;
            }
            loginTracker.trackFail$tap_login_release("loginWithScopes", sessionId, MapsKt.mapOf(TuplesKt.to("login_type", str)), -1, exception.getMessage());
            ((LoginState.LoginInProgress) currentState).getCallback().onFail(exception);
        } else if (currentState instanceof LoginState.AuthInProgress) {
            ((LoginState.AuthInProgress) currentState).getCallback().onFail(exception);
        } else if (currentState instanceof LoginState.HandlingResponse) {
            LoginState delegate = ((LoginState.HandlingResponse) currentState).getDelegate();
            if (delegate instanceof LoginState.LoginInProgress) {
                LoginTracker loginTracker2 = this.tracker;
                String sessionId2 = ((LoginState.LoginInProgress) delegate).getSessionId();
                if (request != null && (loginType = request.getLoginType()) != null) {
                    str = loginType;
                }
                loginTracker2.trackFail$tap_login_release("loginWithScopes", sessionId2, MapsKt.mapOf(TuplesKt.to("login_type", str)), -1, exception.getMessage());
                ((LoginState.LoginInProgress) delegate).getCallback().onFail(exception);
            } else if (delegate instanceof LoginState.AuthInProgress) {
                ((LoginState.AuthInProgress) delegate).getCallback().onFail(exception);
            }
        }
        this.stateManager.transitionToFailed(request, exception);
    }

    public final void onActivityDestroy(LoginRequest request) {
        LoginState currentState = this.stateManager.getCurrentState();
        if (!(currentState instanceof LoginState.HandlingResponse)) {
            notifyCancel(request);
        }
    }

    public final LoginTypes getLoginType(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return LoginTypes.INSTANCE.from(activity, Actions.INSTANCE.from(this.requestBuilder.getRegionType()));
    }
}
