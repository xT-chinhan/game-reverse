package com.efs.sdk.memleaksdk.monitor.shark;

import com.kwad.sdk.api.model.AdnName;
import com.umeng.ccg.a;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010\u0014\u001a\u00020\u0005*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0082\fJ\u0015\u0010\u0014\u001a\u00020\t*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0082\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldIdReader;", "", "record", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readByteId", "", a.H, "array", "", "readId", "readIntId", "readLongId", "readShortId", "skipBytes", "", "count", "and", "", AdnName.OTHER, "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ch {
    private int a;
    private final HprofRecord.a.AbstractC0350a.b b;
    private final int c;

    public ch(HprofRecord.a.AbstractC0350a.b record, int i) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.b = record;
        this.c = i;
    }

    public final long a() {
        long jA;
        int i = this.c;
        if (i == 1) {
            jA = this.b.a[this.a];
        } else if (i == 2) {
            jA = a(this.a, this.b.a);
        } else if (i == 4) {
            jA = b(this.a, this.b.a);
        } else if (i == 8) {
            jA = c(this.a, this.b.a);
        } else {
            throw new IllegalStateException("ID Length must be 1, 2, 4, or 8".toString());
        }
        this.a += this.c;
        return jA;
    }

    public final void a(int i) {
        this.a += i;
    }

    private final long a(int i, byte[] bArr) {
        return ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i + 1] & UByte.MAX_VALUE);
    }

    private final long b(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i2] & UByte.MAX_VALUE) << 16) | ((bArr[i3] & UByte.MAX_VALUE) << 8) | (bArr[i3 + 1] & UByte.MAX_VALUE);
    }

    private final long c(int i, byte[] bArr) {
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i7 + 1;
        return (((long) bArr[i8]) & 255) | j5 | ((((long) bArr[i7]) & 255) << 8);
    }
}
