package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader;", "", "record", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "readShort", "", "readValue", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "field", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ci {
    public static final a a = new a(0);
    private static final int e = PrimitiveType.BOOLEAN.i;
    private static final int f = PrimitiveType.CHAR.i;
    private static final int g = PrimitiveType.FLOAT.i;
    private static final int h = PrimitiveType.DOUBLE.i;
    private static final int i = PrimitiveType.BYTE.i;
    private static final int j = PrimitiveType.SHORT.i;
    private static final int k = PrimitiveType.INT.i;
    private static final int l = PrimitiveType.LONG.i;
    private int b;
    private final HprofRecord.a.AbstractC0350a.b c;
    private final int d;

    public ci(HprofRecord.a.AbstractC0350a.b record, int i2) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.c = record;
        this.d = i2;
    }

    private final long a() {
        int iC;
        int i2 = this.d;
        if (i2 == 1) {
            iC = c();
        } else if (i2 == 2) {
            iC = e();
        } else {
            if (i2 != 4) {
                if (i2 == 8) {
                    return f();
                }
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
            }
            iC = d();
        }
        return iC;
    }

    private final boolean b() {
        byte[] bArr = this.c.a;
        int i2 = this.b;
        byte b = bArr[i2];
        this.b = i2 + 1;
        return b != ((byte) 0);
    }

    private final byte c() {
        byte[] bArr = this.c.a;
        int i2 = this.b;
        byte b = bArr[i2];
        this.b = i2 + 1;
        return b;
    }

    private final int d() {
        int iB = ce.b(this.c.a, this.b);
        this.b += 4;
        return iB;
    }

    private final short e() {
        short sA = ce.a(this.c.a, this.b);
        this.b += 2;
        return sA;
    }

    private final long f() {
        long jC = ce.c(this.c.a, this.b);
        this.b += 8;
        return jC;
    }

    private final float g() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(d());
    }

    private final double h() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(f());
    }

    private final char i() {
        String str = new String(this.c.a, this.b, 2, Charsets.UTF_16BE);
        this.b += 2;
        return str.charAt(0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader$Companion;", "", "()V", "BOOLEAN_TYPE", "", "BYTE_TYPE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_TYPE", "LONG_TYPE", "SHORT_TYPE", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final ValueHolder a(HprofRecord.a.AbstractC0350a.C0351a.C0352a field) {
        Intrinsics.checkNotNullParameter(field, "field");
        int i2 = field.b;
        if (i2 == 2) {
            return new ValueHolder.i(a());
        }
        if (i2 == e) {
            return new ValueHolder.a(b());
        }
        if (i2 == f) {
            return new ValueHolder.c(i());
        }
        if (i2 == g) {
            return new ValueHolder.f(g());
        }
        if (i2 == h) {
            return new ValueHolder.e(h());
        }
        if (i2 == i) {
            return new ValueHolder.b(c());
        }
        if (i2 == j) {
            return new ValueHolder.j(e());
        }
        if (i2 == k) {
            return new ValueHolder.g(d());
        }
        if (i2 == l) {
            return new ValueHolder.h(f());
        }
        throw new IllegalStateException("Unknown type " + field.b);
    }
}
