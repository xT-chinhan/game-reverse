package com.taptap.sdk.compliance.internal;

import com.taptap.sdk.compliance.api.ComplianceService;
import com.taptap.sdk.compliance.model.TapLoginModelKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ComplianceServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/compliance/internal/ComplianceServiceImpl;", "Lcom/taptap/sdk/compliance/api/ComplianceService;", "()V", "getAgeRangeScope", "", "withUserAgeInfo", "", "withUserAge", "", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceServiceImpl implements ComplianceService {
    @Override // com.taptap.sdk.compliance.api.ComplianceService
    public String getAgeRangeScope() {
        if (!ComplianceInitializeTask.INSTANCE.getInitialized$tap_compliance_release()) {
            return null;
        }
        if (TapComplianceInternal.INSTANCE.getWithUserAgeInfo()) {
            return TapLoginModelKt.COMPLIANCE_SCOPE;
        }
        return TapLoginModelKt.COMPLIANCE_BASIC_SCOPE;
    }

    @Override // com.taptap.sdk.compliance.api.ComplianceService
    public void withUserAgeInfo(boolean withUserAge) {
        TapComplianceInternal.INSTANCE.setWithUserAgeInfo(withUserAge);
    }
}
