package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class as {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;
    public static final /* synthetic */ int[] d;

    static {
        int[] iArr = new int[LeakTraceObject.b.values().length];
        a = iArr;
        iArr[LeakTraceObject.b.LEAKING.ordinal()] = 1;
        iArr[LeakTraceObject.b.UNKNOWN.ordinal()] = 2;
        iArr[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 3;
        int[] iArr2 = new int[LeakTraceObject.b.values().length];
        b = iArr2;
        iArr2[LeakTraceObject.b.LEAKING.ordinal()] = 1;
        iArr2[LeakTraceObject.b.UNKNOWN.ordinal()] = 2;
        iArr2[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 3;
        int[] iArr3 = new int[LeakTraceObject.b.values().length];
        c = iArr3;
        iArr3[LeakTraceObject.b.UNKNOWN.ordinal()] = 1;
        iArr3[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 2;
        iArr3[LeakTraceObject.b.LEAKING.ordinal()] = 3;
        int[] iArr4 = new int[LeakTraceObject.b.values().length];
        d = iArr4;
        iArr4[LeakTraceObject.b.UNKNOWN.ordinal()] = 1;
        iArr4[LeakTraceObject.b.LEAKING.ordinal()] = 2;
        iArr4[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 3;
    }
}
