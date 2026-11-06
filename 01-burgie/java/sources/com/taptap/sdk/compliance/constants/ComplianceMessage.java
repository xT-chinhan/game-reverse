package com.taptap.sdk.compliance.constants;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: ComplianceMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/compliance/constants/ComplianceMessage;", "", "()V", "AGE_LIMIT", "", "AGE_RESTRICT", "getAGE_RESTRICT$annotations", "DURATION_LIMIT", "getDURATION_LIMIT$annotations", "EXITED", "INVALID_CLIENT_OR_NETWORK_ERROR", "LOGIN_SUCCESS", "OPEN_ALERT_TIP", "PERIOD_RESTRICT", "REAL_NAME_STOP", "SWITCH_ACCOUNT", "TOKEN_EXPIRED", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceMessage {
    public static final int AGE_LIMIT = 1100;
    public static final int AGE_RESTRICT = 1100;
    public static final int DURATION_LIMIT = 1050;
    public static final int EXITED = 1000;
    public static final ComplianceMessage INSTANCE = new ComplianceMessage();
    public static final int INVALID_CLIENT_OR_NETWORK_ERROR = 1200;
    public static final int LOGIN_SUCCESS = 500;
    public static final int OPEN_ALERT_TIP = 1095;
    public static final int PERIOD_RESTRICT = 1030;
    public static final int REAL_NAME_STOP = 9002;
    public static final int SWITCH_ACCOUNT = 1001;
    public static final int TOKEN_EXPIRED = 9001;

    @Deprecated(level = DeprecationLevel.WARNING, message = "已废弃， 请使用 AGE_LIMIT", replaceWith = @ReplaceWith(expression = "ComplianceMessage.AGE_LIMIT", imports = {}))
    public static /* synthetic */ void getAGE_RESTRICT$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "已废弃，时长限制统一使用 PERIOD_RESTRICT(1030)。", replaceWith = @ReplaceWith(expression = "ComplianceMessage.PERIOD_RESTRICT", imports = {}))
    public static /* synthetic */ void getDURATION_LIMIT$annotations() {
    }

    private ComplianceMessage() {
    }
}
