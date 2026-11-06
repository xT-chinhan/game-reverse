package com.taptap.sdk.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.anythink.core.common.l.f;
import com.taptap.sdk.login.internal.LoginActivityImpl;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapTapLoginActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/login/ui/TapTapLoginActivity;", "Landroid/app/Activity;", "Lcom/taptap/sdk/login/internal/LoginActivityImpl$TapLoginActivityCallback;", "()V", "impl", "Lcom/taptap/sdk/login/internal/LoginActivityImpl;", "fallbackToWeb", "", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "onActivityResult", "requestCode", "", "resultCode", f.R, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapLoginActivity extends Activity implements LoginActivityImpl.TapLoginActivityCallback {
    private final LoginActivityImpl impl = new LoginActivityImpl();

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            this.impl.onCreate(this);
        }
    }

    @Override // com.taptap.sdk.login.internal.LoginActivityImpl.TapLoginActivityCallback
    public void fallbackToWeb(LoginRequest request) {
        this.impl.fallbackToWeb(this, request);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.impl.onActivityResult(this, requestCode, resultCode, data);
    }
}
