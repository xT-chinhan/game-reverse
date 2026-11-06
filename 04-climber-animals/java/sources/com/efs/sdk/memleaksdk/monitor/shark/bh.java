package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
public final /* synthetic */ class bh {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[LeakTraceObject.b.values().length];
        a = iArr;
        iArr[LeakTraceObject.b.UNKNOWN.ordinal()] = 1;
        iArr[LeakTraceObject.b.NOT_LEAKING.ordinal()] = 2;
    }
}
