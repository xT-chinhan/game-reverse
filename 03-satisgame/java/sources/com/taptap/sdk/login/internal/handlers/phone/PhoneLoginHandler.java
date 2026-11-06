package com.taptap.sdk.login.internal.handlers.phone;

import android.app.Activity;
import com.anythink.core.common.h.au;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import com.taptap.sdk.login.internal.handlers.LoginHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneLoginHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R.\u0010\u0003\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginHandler;", "Lcom/taptap/sdk/login/internal/handlers/LoginHandler;", "()V", "phoneLoginCallback", "Lkotlin/Function1;", "", "", "", "getPhoneLoginCallback", "()Lkotlin/jvm/functions/Function1;", "setPhoneLoginCallback", "(Lkotlin/jvm/functions/Function1;)V", "resultCallback", "Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginHandler$PhoneLoginResultCallback;", "getResultCallback", "()Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginHandler$PhoneLoginResultCallback;", "setResultCallback", "(Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginHandler$PhoneLoginResultCallback;)V", "canHandle", "", "activity", "Landroid/app/Activity;", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "getFragment", "Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginFragment;", "PhoneLoginResultCallback", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneLoginHandler implements LoginHandler {
    public static final PhoneLoginHandler INSTANCE = new PhoneLoginHandler();
    private static Function1<? super String[], Unit> phoneLoginCallback;
    private static PhoneLoginResultCallback resultCallback;

    /* JADX INFO: compiled from: PhoneLoginHandler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J1\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/phone/PhoneLoginHandler$PhoneLoginResultCallback;", "", "cancelLogin", "", "continueWebLogin", au.b.a, "", "preferredLoginType", "scopes", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface PhoneLoginResultCallback {
        void cancelLogin();

        void continueWebLogin(String token, String preferredLoginType, String[] scopes);
    }

    private PhoneLoginHandler() {
    }

    public final Function1<String[], Unit> getPhoneLoginCallback() {
        return phoneLoginCallback;
    }

    public final void setPhoneLoginCallback(Function1<? super String[], Unit> function1) {
        phoneLoginCallback = function1;
    }

    public final PhoneLoginResultCallback getResultCallback() {
        return resultCallback;
    }

    public final void setResultCallback(PhoneLoginResultCallback phoneLoginResultCallback) {
        resultCallback = phoneLoginResultCallback;
    }

    @Override // com.taptap.sdk.login.internal.handlers.LoginHandler
    public boolean canHandle(Activity activity, LoginRequest request) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(request, "request");
        return phoneLoginCallback != null;
    }

    @Override // com.taptap.sdk.login.internal.handlers.LoginHandler
    public PhoneLoginFragment getFragment() {
        return new PhoneLoginFragment();
    }
}
