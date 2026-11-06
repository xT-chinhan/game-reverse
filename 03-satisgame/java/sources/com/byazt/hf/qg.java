package com.byazt.hf;

/* JADX INFO: loaded from: classes.dex */
public enum qg {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int x;

    qg(int i) {
        this.x = i;
    }

    public static qg n(int i) {
        try {
            for (qg qgVar : values()) {
                if (qgVar.x == i) {
                    return qgVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
