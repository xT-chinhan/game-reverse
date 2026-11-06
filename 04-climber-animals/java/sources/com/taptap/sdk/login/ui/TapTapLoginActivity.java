package com.taptap.sdk.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.taptap.sdk.login.internal.LoginActivityImpl;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: TapTapLoginActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J\b\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/login/ui/TapTapLoginActivity;", "Landroid/app/Activity;", "Lcom/taptap/sdk/login/internal/LoginActivityImpl$TapLoginActivityCallback;", "()V", "impl", "Lcom/taptap/sdk/login/internal/LoginActivityImpl;", "loginRequest", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "fallbackToWeb", "", "request", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupFullScreenDisplay", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapLoginActivity extends Activity implements LoginActivityImpl.TapLoginActivityCallback {
    private final LoginActivityImpl impl = new LoginActivityImpl();
    private LoginRequest loginRequest;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws JSONException {
        super.onCreate(savedInstanceState);
        setupFullScreenDisplay();
        this.loginRequest = (LoginRequest) getIntent().getParcelableExtra("request");
        if (savedInstanceState == null) {
            this.impl.onCreate(this);
        }
    }

    private final void setupFullScreenDisplay() {
        getWindow().setFlags(512, 512);
        getWindow().setStatusBarColor(0);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setDecorFitsSystemWindows(false);
            return;
        }
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
    }

    @Override // com.taptap.sdk.login.internal.LoginActivityImpl.TapLoginActivityCallback
    public void fallbackToWeb(LoginRequest request) throws JSONException {
        this.impl.fallbackToWeb(this, request);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.impl.onActivityResult(this, requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        LoginManager.INSTANCE.onBackPressed(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LoginManager.INSTANCE.onActivityDestroy(this.loginRequest);
    }
}
