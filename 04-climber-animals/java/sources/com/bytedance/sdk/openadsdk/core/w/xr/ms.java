package com.bytedance.sdk.openadsdk.core.w.xr;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.w.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static void ms() {
        try {
            com.bytedance.sdk.openadsdk.core.w.ms.ms.xr().ka();
            ch.ms(new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.w.xr.ms.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    if (i != 0) {
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.core.w.d.ms.ka();
                    return null;
                }
            });
        } catch (Throwable th) {
            sl.ms(th);
        }
    }
}
