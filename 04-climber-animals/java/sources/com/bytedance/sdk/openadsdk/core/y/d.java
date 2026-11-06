package com.bytedance.sdk.openadsdk.core.y;

import com.bytedance.sdk.openadsdk.core.ch;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.u.ms {
    @Override // com.bytedance.sdk.openadsdk.u.ms
    public boolean xr() {
        return ch.ub().ka();
    }

    @Override // com.bytedance.sdk.openadsdk.u.ms
    public boolean ah() {
        return super.ah();
    }

    @Override // com.bytedance.sdk.openadsdk.u.ms
    public com.bytedance.sdk.openadsdk.u.d d() {
        return ka();
    }

    private com.bytedance.sdk.openadsdk.u.d ka() {
        String strC = com.bytedance.sdk.openadsdk.core.x.ms.c();
        strC.hashCode();
        switch (strC) {
            case "2g":
                return com.bytedance.sdk.openadsdk.u.d.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.u.d.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.u.d.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.u.d.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.u.d.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.u.d.TYPE_UNKNOWN;
        }
    }
}
