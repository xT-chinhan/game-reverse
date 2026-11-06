package com.bytedance.sdk.openadsdk.core;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements com.bytedance.sdk.openadsdk.core.jw.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<Integer, WeakReference<com.bytedance.sdk.openadsdk.core.jw.ms.xr>> f2760ms = new HashMap();

    ka() {
    }

    public void ms(Bridge bridge) {
        Object xrVar;
        if (bridge == null) {
            return;
        }
        EventListener eventListener = new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.ka.1
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i, Result result) {
                if (i == 0) {
                    ka.this.ms();
                    return null;
                }
                if (i != 1) {
                    return null;
                }
                ka.this.xr();
                return null;
            }
        };
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        if (g.xr >= 6800) {
            xrVar = eventListener;
            xrVar = new com.bytedance.sdk.openadsdk.core.f.xr(eventListener);
        }
        xrVar = eventListener;
        bridge.call(9, xrVarMs.ms(0, xrVar).xr(), null);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.jw.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        this.f2760ms.put(Integer.valueOf(xrVar.hashCode()), new WeakReference<>(xrVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void ms() {
        Iterator<Map.Entry<Integer, WeakReference<com.bytedance.sdk.openadsdk.core.jw.ms.xr>>> it = this.f2760ms.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.jw.ms.xr> value = it.next().getValue();
            if (value != null) {
                com.bytedance.sdk.openadsdk.core.jw.ms.xr xrVar = value.get();
                if (xrVar != null) {
                    xrVar.ms();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void xr() {
        Iterator<Map.Entry<Integer, WeakReference<com.bytedance.sdk.openadsdk.core.jw.ms.xr>>> it = this.f2760ms.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.jw.ms.xr> value = it.next().getValue();
            if (value != null) {
                com.bytedance.sdk.openadsdk.core.jw.ms.xr xrVar = value.get();
                if (xrVar != null) {
                    xrVar.xr();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
