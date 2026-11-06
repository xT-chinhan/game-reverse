package com.bytedance.sdk.component.ah.xr.ms.ka;

/* JADX INFO: loaded from: classes2.dex */
public enum xr {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int ab;

    xr(int i) {
        this.ab = i;
    }

    public static xr ms(int i) {
        try {
            for (xr xrVar : values()) {
                if (xrVar.ab == i) {
                    return xrVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
