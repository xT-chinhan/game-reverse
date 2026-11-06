package com.taptap.sdk.login;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.impl.core.LoginManager;
import com.taptap.sdk.login.impl.data.model.LoginTypes;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTapFirstPartyLogin.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J9\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/login/TapTapFirstPartyLogin;", "", "()V", "TAG", "", "getLoginType", "Lcom/taptap/sdk/login/impl/data/model/LoginTypes;", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "login", "", "scopes", "", "firstPartyLoginOptions", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/TapTapAccount;", "([Ljava/lang/String;Landroid/app/Activity;Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapFirstPartyLogin {
    public static final TapTapFirstPartyLogin INSTANCE = new TapTapFirstPartyLogin();
    private static final String TAG = "TapTapFirstPartyLogin";

    private TapTapFirstPartyLogin() {
    }

    @JvmStatic
    public static final void login(String[] scopes, Activity activity, TapFirstPartyLoginOptions firstPartyLoginOptions, TapTapCallback<TapTapAccount> callback) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(firstPartyLoginOptions, "firstPartyLoginOptions");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            TapLogger.loge$default(TAG, "LoginManager not initialized", null, 4, null);
            callback.onFail(new TapTapException("SDK not initialized"));
        } else {
            LoginManager.INSTANCE.getInstance().login(activity, ArraysKt.toList(scopes), firstPartyLoginOptions, callback);
        }
    }

    @JvmStatic
    public static final LoginTypes getLoginType(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return LoginManager.INSTANCE.getInstance().getLoginType(activity);
    }
}
