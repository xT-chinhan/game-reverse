package com.taptap.sdk.login.impl.ui.activity;

import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.window.OnBackInvokedCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.impl.core.LoginManager;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.data.model.LoginTypes;
import com.taptap.sdk.login.impl.exception.CloudGameException;
import com.taptap.sdk.login.impl.ui.fragment.DefaultTapLoginFragmentProvider;
import com.taptap.sdk.login.impl.ui.fragment.TapFragmentLoginCallback;
import com.taptap.sdk.login.impl.ui.fragment.TapLoginFragmentProvider;
import com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment;
import com.umeng.analytics.pro.d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTapLoginActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u00020\bH\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0017J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\bH\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/activity/TapTapLoginActivity;", "Landroid/app/Activity;", "()V", "fragmentProvider", "Lcom/taptap/sdk/login/impl/ui/fragment/TapLoginFragmentProvider;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "fallbackToWeb", "", "handleBackPressed", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "replaceContentByLoginType", "setupFullScreenDisplay", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapLoginActivity extends Activity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRAS_REQUEST = "com_taptap_sdk_login_request";
    private static final String FRAGMENT_TAG = "com_taptap_sdk_login_fragment";
    private static final String TAG = "TapTapLoginActivity";
    private final TapLoginFragmentProvider fragmentProvider = new DefaultTapLoginFragmentProvider(new TapFragmentLoginCallback() { // from class: com.taptap.sdk.login.impl.ui.activity.TapTapLoginActivity$fragmentProvider$1
        @Override // com.taptap.sdk.login.impl.ui.fragment.TapFragmentLoginCallback
        public void onSuccess(LoginRequest request, LoginResponse response) {
            LoginManager.INSTANCE.getInstance().handleLoginResponse(this.this$0, request, response);
            this.this$0.finish();
        }

        @Override // com.taptap.sdk.login.impl.ui.fragment.TapFragmentLoginCallback
        public void onFail(TapTapException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            LoginManager.INSTANCE.getInstance().notifyFail(this.this$0.request, error);
            this.this$0.finish();
        }

        @Override // com.taptap.sdk.login.impl.ui.fragment.TapFragmentLoginCallback
        public void onCancel(LoginRequest request) {
            LoginManager.INSTANCE.getInstance().notifyCancel(request);
            this.this$0.finish();
        }

        @Override // com.taptap.sdk.login.impl.ui.fragment.TapFragmentLoginCallback
        public void executeFallbackStrategy(LoginRequest request, CloudGameException error) {
            if (error != null) {
                Log.w("TapTapLoginActivity", "Execute fallback strategy to web login. Error: " + error.getMessage() + ", Cause: " + error.getCause());
            }
            this.this$0.fallbackToWeb(request);
        }
    });
    private LoginRequest request;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: com.taptap.sdk.login.impl.ui.activity.TapTapLoginActivity$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    TapTapLoginActivity.onCreate$lambda$0(this.f$0);
                }
            });
        }
        setupFullScreenDisplay();
        LoginRequest request = (LoginRequest) getIntent().getParcelableExtra(EXTRAS_REQUEST);
        if (request != null) {
            this.request = request;
            if (savedInstanceState == null) {
                Fragment fragment = this.fragmentProvider.provide(request);
                getFragmentManager().beginTransaction().replace(R.id.content, fragment, FRAGMENT_TAG).commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(TapTapLoginActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleBackPressed();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // android.app.Activity
    @Deprecated(message = "Deprecated in API 33", replaceWith = @ReplaceWith(expression = "onBackPressedDispatcher.onBackPressed()", imports = {}))
    public void onBackPressed() {
        handleBackPressed();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LoginManager.INSTANCE.getInstance().onActivityDestroy(this.request);
    }

    private final void handleBackPressed() {
        Fragment fragment;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && (fragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG)) != null && (fragment instanceof WebLoginFragment)) {
            ((WebLoginFragment) fragment).onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    private final void setupFullScreenDisplay() {
        getWindow().setFlags(512, 512);
        getWindow().setStatusBarColor(0);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(lp);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setDecorFitsSystemWindows(false);
            return;
        }
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
    }

    public final void fallbackToWeb(LoginRequest request) {
        if (request != null) {
            replaceContentByLoginType(request.copy((524255 & 1) != 0 ? request.state : null, (524255 & 2) != 0 ? request.clientId : null, (524255 & 4) != 0 ? request.scopes : null, (524255 & 8) != 0 ? request.versionCode : null, (524255 & 16) != 0 ? request.info : null, (524255 & 32) != 0 ? request.trackInfo : null, (524255 & 64) != 0 ? request.regionType : null, (524255 & 128) != 0 ? request.preApproved : false, (524255 & 256) != 0 ? request.phoneVerifyToken : null, (524255 & 512) != 0 ? request.preferredLoginType : null, (524255 & 1024) != 0 ? request.loginVersion : null, (524255 & 2048) != 0 ? request.responseType : null, (524255 & 4096) != 0 ? request.redirectUri : null, (524255 & 8192) != 0 ? request.codeVerifier : null, (524255 & 16384) != 0 ? request.codeChallengeMethod : null, (524255 & 32768) != 0 ? request.isAuth : false, (524255 & 65536) != 0 ? request.loginType : LoginTypes.WEB.getValue(), (524255 & 131072) != 0 ? request.sessionId : null, (524255 & 262144) != 0 ? request.screenOrientation : 0));
        }
    }

    private final void replaceContentByLoginType(LoginRequest request) {
        Fragment fragment = this.fragmentProvider.provide(request);
        getFragmentManager().beginTransaction().replace(R.id.content, fragment, FRAGMENT_TAG).commit();
    }

    /* JADX INFO: compiled from: TapTapLoginActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/activity/TapTapLoginActivity$Companion;", "", "()V", "EXTRAS_REQUEST", "", "FRAGMENT_TAG", "TAG", "startLoginActivity", "", d.R, "Landroid/content/Context;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startLoginActivity(Context context, LoginRequest request) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(request, "request");
            Intent intent = new Intent(context, (Class<?>) TapTapLoginActivity.class);
            intent.putExtra(TapTapLoginActivity.EXTRAS_REQUEST, request);
            context.startActivity(intent);
        }
    }
}
