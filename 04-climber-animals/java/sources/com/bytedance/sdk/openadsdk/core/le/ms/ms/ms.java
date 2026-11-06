package com.bytedance.sdk.openadsdk.core.le.ms.ms;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements EventListener {
    public void handleComplianceDialog(boolean z) {
    }

    public void handleMarketFailedComplianceDialog() {
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (i != 223100) {
            if (i != 223110) {
                return null;
            }
            handleMarketFailedComplianceDialog();
            return null;
        }
        if (result == null || result.values() == null) {
            return null;
        }
        handleComplianceDialog(result.values().booleanValue(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW));
        return null;
    }
}
