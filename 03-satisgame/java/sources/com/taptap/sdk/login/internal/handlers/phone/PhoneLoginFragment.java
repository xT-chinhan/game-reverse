package com.taptap.sdk.login.internal.handlers.phone;

import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.internal.LoginActivityImpl;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneLoginFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginFragment;", "Landroid/app/Fragment;", "()V", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneLoginFragment extends Fragment {
    private LoginRequest request;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.activty_tap_login, container, false);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LoginRequest loginRequest = (LoginRequest) getArguments().getParcelable("request");
        if (loginRequest == null) {
            loginRequest = savedInstanceState != null ? (LoginRequest) savedInstanceState.getParcelable("request") : null;
        }
        this.request = loginRequest;
        PhoneLoginHandler.INSTANCE.setResultCallback(new PhoneLoginHandler.PhoneLoginResultCallback() { // from class: com.taptap.sdk.login.internal.handlers.phone.PhoneLoginFragment.onViewCreated.1
            @Override // com.taptap.sdk.login.internal.handlers.phone.PhoneLoginHandler.PhoneLoginResultCallback
            public void continueWebLogin(String token, String preferredLoginType, String[] scopes) {
                PhoneLoginHandler.INSTANCE.setResultCallback(null);
                LoginRequest loginRequest2 = PhoneLoginFragment.this.request;
                if (loginRequest2 != null) {
                    ComponentCallbacks2 activity = PhoneLoginFragment.this.getActivity();
                    LoginActivityImpl.TapLoginActivityCallback tapLoginActivityCallback = activity instanceof LoginActivityImpl.TapLoginActivityCallback ? (LoginActivityImpl.TapLoginActivityCallback) activity : null;
                    if (tapLoginActivityCallback != null) {
                        tapLoginActivityCallback.fallbackToWeb(new LoginRequest(loginRequest2.getState(), loginRequest2.getClientId(), scopes == null ? loginRequest2.getScopes() : scopes, loginRequest2.getVersionCode(), loginRequest2.getInfo(), null, loginRequest2.getRegionType(), loginRequest2.getPreApproved(), token, preferredLoginType, loginRequest2.getLoginVersion(), loginRequest2.getResponseType(), loginRequest2.getRedirectUri(), loginRequest2.getCodeVerifier(), loginRequest2.getCodeChallengeMethod(), false, 32800, null));
                    }
                }
            }

            @Override // com.taptap.sdk.login.internal.handlers.phone.PhoneLoginHandler.PhoneLoginResultCallback
            public void cancelLogin() {
                PhoneLoginHandler.INSTANCE.setResultCallback(null);
                LoginManager.INSTANCE.notifyCancel(PhoneLoginFragment.this.request);
                PhoneLoginFragment.this.getActivity().finish();
            }
        });
    }
}
