package com.taptap.sdk.login.unity;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeParams;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import kotlin.Metadata;

/* JADX INFO: compiled from: BridgeLoginService.kt */
/* JADX INFO: loaded from: classes3.dex */
@EngineBridgeService("BridgeLoginService")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J-\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0005H'¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H'¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/unity/BridgeLoginService;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "getCurrentTapAccount", "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "loginWithScope", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "scopes", "", "", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;)V", "logout", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BridgeLoginService extends IEngineBridgeService {
    @EngineBridgeMethod("getCurrentTapAccount")
    void getCurrentTapAccount(EngineBridgeCallback callback);

    @EngineBridgeMethod("loginWithScope")
    void loginWithScope(Activity activity, @EngineBridgeParams("scopes") String[] scopes, EngineBridgeCallback callback);

    @EngineBridgeMethod("logout")
    void logout();
}
