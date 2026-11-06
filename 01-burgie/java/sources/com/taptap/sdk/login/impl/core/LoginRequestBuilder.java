package com.taptap.sdk.login.impl.core;

import com.taptap.sdk.compliance.api.ComplianceService;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.login.TapFirstPartyLoginOptions;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginTypes;
import com.taptap.sdk.login.impl.data.model.Orientation;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LoginRequestBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0002J4\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0013J&\u0010\u001f\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginRequestBuilder;", "", "clientId", "", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "orientation", "Lcom/taptap/sdk/login/impl/data/model/Orientation;", "(Ljava/lang/String;Lcom/taptap/sdk/initializer/api/model/RegionType;Lcom/taptap/sdk/login/impl/data/model/Orientation;)V", "complianceService", "Lcom/taptap/sdk/compliance/api/ComplianceService;", "getComplianceService", "()Lcom/taptap/sdk/compliance/api/ComplianceService;", "complianceService$delegate", "Lkotlin/Lazy;", "getRegionType", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "buildInfo", "isPreApproved", "", "loginType", "Lcom/taptap/sdk/login/impl/data/model/LoginTypes;", "sessionId", "requestScope", "", "buildLoginRequest", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "scopes", "options", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "isAuth", "buildTrackInfo", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginRequestBuilder {
    private final String clientId;

    /* JADX INFO: renamed from: complianceService$delegate, reason: from kotlin metadata */
    private final Lazy complianceService;
    private final Orientation orientation;
    private final RegionType regionType;

    public LoginRequestBuilder(String clientId, RegionType regionType, Orientation orientation) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(regionType, "regionType");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.clientId = clientId;
        this.regionType = regionType;
        this.orientation = orientation;
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        this.complianceService = LazyKt.lazy(new Function0<ComplianceService>() { // from class: com.taptap.sdk.login.impl.core.LoginRequestBuilder$special$$inlined$injectOrNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.taptap.sdk.compliance.api.ComplianceService, com.taptap.sdk.servicemanager.ServiceManager$Service] */
            @Override // kotlin.jvm.functions.Function0
            public final ComplianceService invoke() {
                return ServiceManager.INSTANCE.getService(ComplianceService.class);
            }
        });
    }

    public final RegionType getRegionType() {
        return this.regionType;
    }

    private final ComplianceService getComplianceService() {
        return (ComplianceService) this.complianceService.getValue();
    }

    public final LoginRequest buildLoginRequest(List<String> scopes, LoginTypes loginType, TapFirstPartyLoginOptions options, String sessionId, boolean isAuth) throws JSONException {
        ComplianceService complianceService;
        String scope;
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) scopes);
        if (!isAuth && (complianceService = getComplianceService()) != null && (scope = complianceService.getAgeRangeScope()) != null && !mutableList.contains(scope)) {
            mutableList.add(scope);
        }
        String string = UUID.randomUUID().toString();
        String str = this.clientId;
        String strBuildInfo = buildInfo(options.getIsPreApproved(), loginType, sessionId, mutableList);
        String strBuildTrackInfo = buildTrackInfo(mutableList, loginType, sessionId);
        RegionType regionType = this.regionType;
        boolean isPreApproved = options.getIsPreApproved();
        String preferLoginType = options.getPreferLoginType();
        String phoneVerifyToken = options.getPhoneVerifyToken();
        String value = loginType.getValue();
        int code = this.orientation.getCode();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return new LoginRequest(string, str, mutableList, "4.10.9", strBuildInfo, strBuildTrackInfo, regionType, isPreApproved, phoneVerifyToken, preferLoginType, null, null, null, null, null, isAuth, value, sessionId, code, 31744, null);
    }

    private final String buildInfo(boolean isPreApproved, LoginTypes loginType, String sessionId, List<String> requestScope) {
        StringBuilder sb = new StringBuilder();
        sb.append("biz_source=GAME");
        sb.append("&client_id=" + this.clientId);
        sb.append("&uuid=" + TapIdentifierUtil.INSTANCE.getInstallUUID());
        sb.append("&name=TapLoginAndroid");
        sb.append("&scopes=" + CollectionsKt.joinToString$default(requestScope, ",", null, null, 0, null, null, 62, null));
        sb.append("&session_id=" + sessionId);
        sb.append("&session_type=tapsdk");
        sb.append("&tapsdk_login_type=" + loginType.getValue());
        sb.append("&orientation=" + this.orientation.getValue());
        sb.append("&version=4.10.9");
        sb.append("&version_code=410090000");
        sb.append("&preapproved=" + (isPreApproved ? 1 : 0));
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final String buildTrackInfo(List<String> requestScope, LoginTypes loginType, String sessionId) throws JSONException {
        JSONObject $this$buildTrackInfo_u24lambda_u242 = new JSONObject();
        $this$buildTrackInfo_u24lambda_u242.put("scopes", CollectionsKt.joinToString$default(requestScope, ",", null, null, 0, null, null, 62, null));
        $this$buildTrackInfo_u24lambda_u242.put("session_id", sessionId);
        $this$buildTrackInfo_u24lambda_u242.put("session_type", "tapsdk");
        $this$buildTrackInfo_u24lambda_u242.put("tapsdk_client_id", this.clientId);
        $this$buildTrackInfo_u24lambda_u242.put("tapsdk_login_type", loginType.getValue());
        String string = $this$buildTrackInfo_u24lambda_u242.toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …lue)\n        }.toString()");
        return string;
    }
}
