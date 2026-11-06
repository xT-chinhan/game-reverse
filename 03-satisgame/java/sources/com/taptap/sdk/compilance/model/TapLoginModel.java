package com.taptap.sdk.compilance.model;

import android.app.Activity;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.api.LoginService;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: TapLoginModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0006\u0010\u0013\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/compilance/model/TapLoginModel;", "Lorg/koin/core/component/KoinComponent;", "()V", "tapTapLoginService", "Lcom/taptap/sdk/login/api/LoginService;", "getTapTapLoginService", "()Lcom/taptap/sdk/login/api/LoginService;", "tapTapLoginService$delegate", "Lkotlin/Lazy;", "checkAccessTokenLocally", "", "currentToken", "Lcom/taptap/sdk/login/AccessToken;", "getTapIdentifyToken", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "isTapLoggedIn", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapLoginModel implements KoinComponent {
    public static final TapLoginModel INSTANCE;

    /* JADX INFO: renamed from: tapTapLoginService$delegate, reason: from kotlin metadata */
    private static final Lazy tapTapLoginService;

    private TapLoginModel() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TapLoginModel tapLoginModel = new TapLoginModel();
        INSTANCE = tapLoginModel;
        final TapLoginModel tapLoginModel2 = tapLoginModel;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        tapTapLoginService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<LoginService>() { // from class: com.taptap.sdk.compilance.model.TapLoginModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.login.api.LoginService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final LoginService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapLoginModel2;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = objArr;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(LoginService.class), qualifier2, function0);
            }
        });
    }

    private final LoginService getTapTapLoginService() {
        return (LoginService) tapTapLoginService.getValue();
    }

    public final void getTapIdentifyToken(Activity activity, TapTapCallback<AccessToken> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getTapTapLoginService().authWithScopeInternal(activity, new String[]{TapComplianceInternal.INSTANCE.getWithUserAgeInfo() ? TapLoginModelKt.COMPLIANCE_SCOPE : TapLoginModelKt.COMPLIANCE_BASIC_SCOPE}, false, callback);
    }

    public final boolean checkAccessTokenLocally(AccessToken currentToken) {
        Set<String> scopes;
        if (currentToken == null) {
            TapTapAccount currentTapAccount = getTapTapLoginService().getCurrentTapAccount();
            currentToken = currentTapAccount != null ? currentTapAccount.getAccessToken() : null;
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
        TapTapAccount currentTapAccount = getTapTapLoginService().getCurrentTapAccount();
        return (currentTapAccount != null ? currentTapAccount.getAccessToken() : null) != null;
    }
}
