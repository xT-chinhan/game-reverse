package com.bytedance.sdk.openadsdk.core.le.ms.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements EventListener {
    public void ah(Bridge bridge) {
    }

    public void ms() {
    }

    public void ms(Bridge bridge) {
    }

    public void ms(Bridge bridge, int i) {
    }

    public void ms(Bridge bridge, Bridge bridge2) {
    }

    public void xr(Bridge bridge) {
    }

    public void xr(Bridge bridge, int i) {
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE /* 223600 */:
                ms();
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START /* 223601 */:
                if (result != null && result.values() != null) {
                    ValueSet valueSetValues = result.values();
                    ms((Bridge) valueSetValues.objectValue(ValueSetConstants.VALUE_DOWNLOAD_MODEL, Bridge.class), (Bridge) valueSetValues.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, Bridge.class));
                    break;
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE /* 223602 */:
                if (result != null && result.values() != null) {
                    ValueSet valueSetValues2 = result.values();
                    ms((Bridge) valueSetValues2.objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, Bridge.class), ((Integer) valueSetValues2.objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, Integer.class)).intValue());
                    break;
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED /* 223603 */:
                if (result != null && result.values() != null) {
                    ValueSet valueSetValues3 = result.values();
                    xr((Bridge) valueSetValues3.objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, Bridge.class), ((Integer) valueSetValues3.objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, Integer.class)).intValue());
                    break;
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED /* 223604 */:
                if (result != null && result.values() != null) {
                    ms((Bridge) result.values().objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, Bridge.class));
                    break;
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED /* 223605 */:
                if (result != null && result.values() != null) {
                    xr((Bridge) result.values().objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, Bridge.class));
                    break;
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED /* 223606 */:
                if (result != null && result.values() != null) {
                    ah((Bridge) result.values().objectValue(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, Bridge.class));
                    break;
                }
                break;
        }
        return null;
    }
}
