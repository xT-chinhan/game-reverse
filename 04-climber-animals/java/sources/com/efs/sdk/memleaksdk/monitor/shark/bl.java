package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class bl {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[LeakTraceReference.b.values().length];
        a = iArr;
        iArr[LeakTraceReference.b.ARRAY_ENTRY.ordinal()] = 1;
        iArr[LeakTraceReference.b.STATIC_FIELD.ordinal()] = 2;
        iArr[LeakTraceReference.b.INSTANCE_FIELD.ordinal()] = 3;
        iArr[LeakTraceReference.b.LOCAL.ordinal()] = 4;
        int[] iArr2 = new int[LeakTraceReference.b.values().length];
        b = iArr2;
        iArr2[LeakTraceReference.b.ARRAY_ENTRY.ordinal()] = 1;
        iArr2[LeakTraceReference.b.STATIC_FIELD.ordinal()] = 2;
        iArr2[LeakTraceReference.b.INSTANCE_FIELD.ordinal()] = 3;
        iArr2[LeakTraceReference.b.LOCAL.ordinal()] = 4;
    }
}
