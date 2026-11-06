package com.taptap.sdk.login;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.impl.core.LoginManager;
import com.taptap.sdk.login.impl.storage.MigrationAccountStorage;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTapLogin.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0007¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/login/TapTapLogin;", "", "()V", "getCurrentTapAccount", "Lcom/taptap/sdk/login/TapTapAccount;", "loginWithScopes", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "logout", "peekCachedTapAccount", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapLogin {
    public static final TapTapLogin INSTANCE = new TapTapLogin();

    private TapTapLogin() {
    }

    @JvmStatic
    public static final void loginWithScopes(Activity activity, String[] scopes, TapTapCallback<TapTapAccount> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            callback.onFail(new TapTapException("SDK not initialized"));
        } else {
            LoginManager.INSTANCE.getInstance().login(activity, ArraysKt.toList(scopes), new TapFirstPartyLoginOptions.Builder().build(), callback);
        }
    }

    @JvmStatic
    public static final TapTapAccount getCurrentTapAccount() {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return MigrationAccountStorage.INSTANCE.getInstance().getAccount();
        }
        return null;
    }

    @JvmStatic
    public static final TapTapAccount peekCachedTapAccount() {
        if (!TapSdkChecker.INSTANCE.checkLocalInitialize(false)) {
            return null;
        }
        return MigrationAccountStorage.INSTANCE.getInstance().getAccount();
    }

    @JvmStatic
    public static final void logout() {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        LoginManager.INSTANCE.getInstance().logout();
    }
}
