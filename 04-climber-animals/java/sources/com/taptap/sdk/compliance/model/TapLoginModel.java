package com.taptap.sdk.compliance.model;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccountInternal;
import com.taptap.sdk.login.api.LoginService;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapLoginModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0006\u0010\u0013\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/compliance/model/TapLoginModel;", "", "()V", "tapTapLoginService", "Lcom/taptap/sdk/login/api/LoginService;", "getTapTapLoginService", "()Lcom/taptap/sdk/login/api/LoginService;", "tapTapLoginService$delegate", "Lkotlin/Lazy;", "checkAccessTokenLocally", "", "currentToken", "Lcom/taptap/sdk/login/AccessToken;", "getTapIdentifyToken", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "isTapLoggedIn", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapLoginModel {
    public static final TapLoginModel INSTANCE = new TapLoginModel();

    /* JADX INFO: renamed from: tapTapLoginService$delegate, reason: from kotlin metadata */
    private static final Lazy tapTapLoginService;

    private TapLoginModel() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        tapTapLoginService = LazyKt.lazy(new Function0<LoginService>() { // from class: com.taptap.sdk.compliance.model.TapLoginModel$special$$inlined$inject$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoginService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(LoginService.class);
                if (service != null) {
                    return (LoginService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.login.api.LoginService");
            }
        });
    }

    private final LoginService getTapTapLoginService() {
        return (LoginService) tapTapLoginService.getValue();
    }

    public final void getTapIdentifyToken(Activity activity, TapTapCallback<AccessToken> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getTapTapLoginService().authWithScope2(activity, new String[]{TapComplianceInternal.INSTANCE.getWithUserAgeInfo() ? TapLoginModelKt.COMPLIANCE_SCOPE : TapLoginModelKt.COMPLIANCE_BASIC_SCOPE}, callback);
    }

    public final boolean checkAccessTokenLocally(AccessToken currentToken) {
        Set<String> scopes;
        if (currentToken == null) {
            TapTapAccountInternal currentTapAccount = getTapTapLoginService().getCurrentTapAccount();
            currentToken = currentTapAccount != null ? currentTapAccount.getSdkToken() : null;
        }
        boolean withUserAgeInfo = TapComplianceInternal.INSTANCE.getWithUserAgeInfo();
        if (currentToken == null || (scopes = currentToken.getScopes()) == null) {
            return false;
        }
        if (withUserAgeInfo) {
            return scopes.contains(TapLoginModelKt.COMPLIANCE_SCOPE);
        }
        return scopes.contains(TapLoginModelKt.COMPLIANCE_SCOPE) || scopes.contains(TapLoginModelKt.COMPLIANCE_BASIC_SCOPE);
    }

    public final boolean isTapLoggedIn() {
        TapTapAccountInternal currentTapAccount = getTapTapLoginService().getCurrentTapAccount();
        return (currentTapAccount != null ? currentTapAccount.getSdkToken() : null) != null;
    }
}
