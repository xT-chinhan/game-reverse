package com.taptap.sdk.compliance.internal;

import android.content.Context;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.startup.task.InitializeTask;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplianceInitializeTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/compliance/internal/ComplianceInitializeTask;", "Lcom/taptap/sdk/startup/task/InitializeTask;", "()V", "execute", "", d.R, "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceInitializeTask implements InitializeTask {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean initialized;

    @Override // com.taptap.sdk.startup.task.InitializeTask
    public void execute(Context context, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getRegion() == RegionType.GLOBAL) {
            return;
        }
        TapComplianceInternal.INSTANCE.setShowSwitchAccount(options.getShowSwitchAccount());
        TapComplianceInternal.INSTANCE.setWithUserAgeInfo(options.getUseAgeRange());
        TapComplianceInternal.INSTANCE.setClientId(options.getClientId());
        TapComplianceInternal.INSTANCE.setRegionType(options.getRegion());
        ComplianceTracker.INSTANCE.trackInit$tap_compliance_release();
        TapLoggerKt.logInfo("TapCompliance init: showSwitchAccount=" + TapComplianceInternal.INSTANCE.getShowSwitchAccount() + ", withUserAgeInfo=" + TapComplianceInternal.INSTANCE.getWithUserAgeInfo() + ", clientId=" + TapComplianceInternal.INSTANCE.getClientId() + ", regionType=" + TapComplianceInternal.INSTANCE.getRegionType());
        initialized = true;
    }

    /* JADX INFO: compiled from: ComplianceInitializeTask.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/compliance/internal/ComplianceInitializeTask$Companion;", "", "()V", "initialized", "", "getInitialized$tap_compliance_release", "()Z", "setInitialized$tap_compliance_release", "(Z)V", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getInitialized$tap_compliance_release() {
            return ComplianceInitializeTask.initialized;
        }

        public final void setInitialized$tap_compliance_release(boolean z) {
            ComplianceInitializeTask.initialized = z;
        }
    }
}
