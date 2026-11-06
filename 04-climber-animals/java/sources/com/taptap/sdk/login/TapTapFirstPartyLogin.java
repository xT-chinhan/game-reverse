package com.taptap.sdk.login;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.util.ClientLoginUtils;
import com.taptap.sdk.login.internal.util.CloudGameUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: TapTapFirstPartyLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J9\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/login/TapTapFirstPartyLogin;", "", "()V", "getLoginType", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "login", "", "scopes", "", "firstPartyLoginOptions", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/login/TapTapAccount;", "([Ljava/lang/String;Landroid/app/Activity;Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapFirstPartyLogin {
    public static final TapTapFirstPartyLogin INSTANCE = new TapTapFirstPartyLogin();

    private TapTapFirstPartyLogin() {
    }

    @JvmStatic
    public static final void login(String[] scopes, Activity activity, TapFirstPartyLoginOptions firstPartyLoginOptions, TapTapCallback<TapTapAccount> callback) throws JSONException, TapTapException {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(firstPartyLoginOptions, "firstPartyLoginOptions");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoginManager.INSTANCE.loginWithScope(activity, scopes, firstPartyLoginOptions, callback);
    }

    @JvmStatic
    public static final String getLoginType(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (CloudGameUtils.INSTANCE.isCloudGame(activity)) {
            return "cloud";
        }
        return ClientLoginUtils.INSTANCE.isClientLogin(activity) ? "mobile_client" : "embedded_web";
    }
}
