package com.bytedance.sdk.openadsdk.core.le.ms.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;

/* JADX INFO: loaded from: classes2.dex */
public class d implements EventListener {
    public void ms(Bridge bridge, Bridge bridge2, Bridge bridge3) {
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (i != 223200 || result == null || result.values() == null) {
            return null;
        }
        ValueSet valueSetValues = result.values();
        ms((Bridge) valueSetValues.objectValue(ValueSetConstants.VALUE_DOWNLOAD_MODEL, Bridge.class), (Bridge) valueSetValues.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG, Bridge.class), (Bridge) valueSetValues.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, Bridge.class));
        return null;
    }
}
