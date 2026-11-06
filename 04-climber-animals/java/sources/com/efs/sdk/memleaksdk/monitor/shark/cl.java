package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class cl {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[HprofRecordTag.values().length];
        a = iArr;
        iArr[HprofRecordTag.CLASS_DUMP.ordinal()] = 1;
        iArr[HprofRecordTag.INSTANCE_DUMP.ordinal()] = 2;
        iArr[HprofRecordTag.OBJECT_ARRAY_DUMP.ordinal()] = 3;
        iArr[HprofRecordTag.PRIMITIVE_ARRAY_DUMP.ordinal()] = 4;
    }
}
