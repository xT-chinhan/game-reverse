package com.taptap.sdk.compilance.di;

import android.content.Context;
import com.taptap.sdk.compilance.internal.ComplianceTracker;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.initializer.api.ModuleInitializer;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplianceInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/compilance/di/ComplianceInitializer;", "Lcom/taptap/sdk/initializer/api/ModuleInitializer;", "()V", "initialize", "", "context", "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceInitializer implements ModuleInitializer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean initialized;

    @Override // com.taptap.sdk.initializer.api.ModuleInitializer
    public void initialize(Context context, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getRegion() == 1) {
            return;
        }
        TapComplianceInternal.INSTANCE.setShowSwitchAccount(options.getShowSwitchAccount());
        TapComplianceInternal.INSTANCE.setWithUserAgeInfo(options.getUseAgeRange());
        TapComplianceInternal.INSTANCE.setClientId(options.getClientId());
        TapComplianceInternal.INSTANCE.setRegionType(options.getRegion());
        ComplianceTracker.INSTANCE.trackInit$tap_compliance_release();
        TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "TapCompliance init: showSwitchAccount=" + TapComplianceInternal.INSTANCE.getShowSwitchAccount() + ", withUserAgeInfo=" + TapComplianceInternal.INSTANCE.getWithUserAgeInfo() + ", clientId=" + TapComplianceInternal.INSTANCE.getClientId() + ", regionType=" + TapComplianceInternal.INSTANCE.getRegionType());
        initialized = true;
    }

    /* JADX INFO: compiled from: ComplianceInitializer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/compilance/di/ComplianceInitializer$Companion;", "", "()V", "initialized", "", "getInitialized$tap_compliance_release", "()Z", "setInitialized$tap_compliance_release", "(Z)V", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getInitialized$tap_compliance_release() {
            return ComplianceInitializer.initialized;
        }

        public final void setInitialized$tap_compliance_release(boolean z) {
            ComplianceInitializer.initialized = z;
        }
    }
}
