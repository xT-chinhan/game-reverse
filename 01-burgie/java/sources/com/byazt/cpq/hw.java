package com.byazt.cpq;

/* JADX INFO: loaded from: classes.dex */
public enum hw {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int fw;

    hw(int i) {
        this.fw = i;
    }

    public static hw pr(int i) {
        try {
            for (hw hwVar : values()) {
                if (hwVar.fw == i) {
                    return hwVar;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
