package com.taptap.sdk.login.impl.statemachine.state;

import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: LoginStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;", "", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "checkNoRequestInProgress", "", "getCurrentState", "transitionToAuthInProgress", "newState", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$AuthInProgress;", "transitionToCancelled", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "transitionToFailed", "exception", "Lcom/taptap/sdk/kit/internal/exception/TapTapException;", "transitionToHandlingResponse", "transitionToLoggedOut", "transitionToLoginInProgress", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState$LoginInProgress;", "transitionToSuccess", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginStateManager {
    private final MutableStateFlow<LoginState> _stateFlow;
    private final StateFlow<LoginState> stateFlow;

    public LoginStateManager() {
        MutableStateFlow<LoginState> MutableStateFlow = StateFlowKt.MutableStateFlow(LoginState.Idle.INSTANCE);
        this._stateFlow = MutableStateFlow;
        this.stateFlow = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<LoginState> getStateFlow() {
        return this.stateFlow;
    }

    public final LoginState getCurrentState() {
        return this._stateFlow.getValue();
    }

    public final void transitionToLoginInProgress(LoginState.LoginInProgress newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        this._stateFlow.setValue(newState);
    }

    public final void transitionToAuthInProgress(LoginState.AuthInProgress newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        this._stateFlow.setValue(newState);
    }

    public final void transitionToHandlingResponse() {
        this._stateFlow.setValue(new LoginState.HandlingResponse(getCurrentState()));
    }

    public final void transitionToSuccess(LoginRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this._stateFlow.setValue(new LoginState.Success(request.getSessionId(), request));
    }

    public final void transitionToFailed(LoginRequest request, TapTapException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        LoginState currentState = getCurrentState();
        this._stateFlow.setValue(new LoginState.Failed(currentState.getSessionId(), request, exception));
    }

    public final void transitionToCancelled(LoginRequest request) {
        LoginState currentState = getCurrentState();
        this._stateFlow.setValue(new LoginState.Cancelled(currentState.getSessionId(), request));
    }

    public final void transitionToLoggedOut() {
        this._stateFlow.setValue(LoginState.LoggedOut.INSTANCE);
    }

    public final void checkNoRequestInProgress() throws TapTapException {
        LoginState currentState = getCurrentState();
        if (currentState instanceof LoginState.LoginInProgress ? true : currentState instanceof LoginState.AuthInProgress ? true : currentState instanceof LoginState.HandlingResponse) {
            throw new TapTapException("Another login request is in progress");
        }
    }
}
