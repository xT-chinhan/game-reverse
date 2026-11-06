package com.taptap.sdk.compliance.constants;

import kotlin.Metadata;

/* JADX INFO: compiled from: RequestPath.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/compliance/constants/RequestPath;", "", "()V", "CHECK_PAYABLE", "", "GET_REAL_NAME_GLOBAL_CONFIG", "GET_TAP_TOKEN", "GET_USER_ANTI_CONFIG", "HEARTBEAT", "IDENTITY_VERIFY", "IDENTITY_VERIFY_MANUAL", "SUBMIT_PAYMENT", "UPGRADE_TOKEN", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RequestPath {
    public static final String CHECK_PAYABLE = "/anti-addiction/v1/payable";
    public static final String GET_REAL_NAME_GLOBAL_CONFIG = "/real-name/v1/get-global-config";
    public static final String GET_TAP_TOKEN = "/real-name/v1/anti-addiction-token-taptap";
    public static final String GET_USER_ANTI_CONFIG = "/anti-addiction/v1/get-config-by-token";
    public static final String HEARTBEAT = "/anti-addiction/v1/heartbeat";
    public static final String IDENTITY_VERIFY = "/real-name/v1/anti-addiction-token";
    public static final String IDENTITY_VERIFY_MANUAL = "/real-name/v1/anti-addiction-token-manual";
    public static final RequestPath INSTANCE = new RequestPath();
    public static final String SUBMIT_PAYMENT = "anti-addiction/v1/payment-submit";
    public static final String UPGRADE_TOKEN = "/real-name/v1/anti-addiction-token-upgrade";

    private RequestPath() {
    }
}
