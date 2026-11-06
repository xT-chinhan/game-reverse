package com.efs.sdk.memleaksdk.monitor.shark;

import com.kwad.sdk.api.model.AdnName;
import com.umeng.ccg.a;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0082\f\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\f\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¨\u0006\u000b"}, d2 = {"and", "", "", AdnName.OTHER, "", "readInt", "", a.H, "readLong", "readShort", "", "memleaksdk_release"}, k = 2, mv = {1, 4, 1})
public final class ce {
    public static final short a(byte[] readShort, int i) {
        Intrinsics.checkNotNullParameter(readShort, "$this$readShort");
        int i2 = i + 1;
        return (short) ((readShort[i2] & UByte.MAX_VALUE) | ((readShort[i] & UByte.MAX_VALUE) << 8));
    }

    public static final int b(byte[] readInt, int i) {
        Intrinsics.checkNotNullParameter(readInt, "$this$readInt");
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((readInt[i] & UByte.MAX_VALUE) << 24) | ((readInt[i2] & UByte.MAX_VALUE) << 16);
        int i5 = i3 + 1;
        return (readInt[i5] & UByte.MAX_VALUE) | i4 | ((readInt[i3] & UByte.MAX_VALUE) << 8);
    }

    public static final long c(byte[] readLong, int i) {
        Intrinsics.checkNotNullParameter(readLong, "$this$readLong");
        int i2 = i + 1;
        long j = (((long) readLong[i]) & 255) << 56;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) readLong[i2]) & 255) << 48) | ((((long) readLong[i3]) & 255) << 40);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) readLong[i4]) & 255) << 32);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) readLong[i5]) & 255) << 24);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) readLong[i6]) & 255) << 16);
        int i8 = i7 + 1;
        return (((long) readLong[i8]) & 255) | j5 | ((((long) readLong[i7]) & 255) << 8);
    }
}
