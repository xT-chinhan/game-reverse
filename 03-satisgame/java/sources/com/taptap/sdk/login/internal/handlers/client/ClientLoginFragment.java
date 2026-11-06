package com.taptap.sdk.login.internal.handlers.client;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.common.l.f;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import com.taptap.sdk.login.internal.bean.LoginResponse;
import com.taptap.sdk.login.internal.util.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientLoginFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/client/ClientLoginFragment;", "Landroid/app/Fragment;", "()V", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "onActivityResult", "", "requestCode", "", "resultCode", f.R, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onViewCreated", "view", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClientLoginFragment extends Fragment {
    private static final String KEY_RESPONSE = "com.taptap.sdk.response";
    private static final int REQUEST_CODE = 10;
    private static final String REQ_KEY_REQUEST = "com.taptap.sdk.request";
    private LoginRequest request;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.activty_tap_login, container, false);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LoginRequest loginRequest = (LoginRequest) getArguments().getParcelable("request");
        Unit unit = null;
        if (loginRequest == null) {
            loginRequest = savedInstanceState != null ? (LoginRequest) savedInstanceState.getParcelable("request") : null;
        }
        this.request = loginRequest;
        if (savedInstanceState != null) {
            return;
        }
        if (loginRequest != null) {
            Intent intent = new Intent(IntentHelper.INSTANCE.getAction(loginRequest));
            intent.putExtra(REQ_KEY_REQUEST, loginRequest.toBundle());
            getActivity().startActivityForResult(intent, 10);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            TapLogger.logd(Constants.TAG, "Fail to get login request");
            getActivity().finish();
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 10) {
            getActivity().finish();
            return;
        }
        if (resultCode == 0) {
            LoginManager.INSTANCE.notifyCancel(this.request);
            getActivity().finish();
            return;
        }
        if (resultCode != -1) {
            LoginManager.INSTANCE.notifyFail(this.request, new TapTapException("Fail to login"));
            getActivity().finish();
            return;
        }
        Bundle bundleExtra = data != null ? data.getBundleExtra(KEY_RESPONSE) : null;
        if (bundleExtra == null) {
            LoginManager.INSTANCE.notifyFail(this.request, new TapTapException("Fail to login"));
            getActivity().finish();
            return;
        }
        LoginResponse fromBundle = LoginResponse.INSTANCE.parseFromBundle(bundleExtra);
        LoginManager loginManager = LoginManager.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        loginManager.handleLoginResponse(activity, this.request, fromBundle);
        getActivity().finish();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        LoginRequest loginRequest = this.request;
        if (loginRequest != null) {
            outState.putParcelable("request", loginRequest);
        }
    }
}
