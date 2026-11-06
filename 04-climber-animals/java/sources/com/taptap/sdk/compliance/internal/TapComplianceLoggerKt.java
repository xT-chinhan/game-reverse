package com.taptap.sdk.compliance.internal;

import com.taptap.sdk.kit.internal.TapLogger;
import com.umeng.analytics.pro.bv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapComplianceLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"LOGGER_TAG", "", "logDebug", "", "msg", "logError", bv.aI, "", "logInfo", "tap-compliance_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceLoggerKt {
    public static final String LOGGER_TAG = "TapComplianceLog";

    public static final void logDebug(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        TapLogger.logd(LOGGER_TAG, msg);
    }

    public static final void logInfo(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        TapLogger.logi(LOGGER_TAG, msg);
    }

    public static final void logError(String str, Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        TapLogger.loge(LOGGER_TAG, str, t);
    }
}
