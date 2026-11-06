package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bb, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 {2\u00020\u0001:\u0001{B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020\bJ\u000e\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020\bJ\u000e\u0010B\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010Q\u001a\u00020RJ\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020VJ\u0016\u0010W\u001a\u00020X2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010Y\u001a\u00020ZJ\u000e\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\bJ\u0006\u0010^\u001a\u00020_J\u0006\u0010`\u001a\u00020aJ\u0006\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020eJ\u0006\u0010f\u001a\u00020\rJ\u0006\u0010g\u001a\u00020\bJ\u0006\u0010h\u001a\u00020\rJ\u000e\u0010i\u001a\u00020X2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\rJ\u0006\u0010m\u001a\u00020nJ\u000e\u0010o\u001a\u00020\r2\u0006\u0010l\u001a\u00020\rJ\u000e\u0010p\u001a\u00020q2\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010p\u001a\u00020q2\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010r\u001a\u00020qJ\u0006\u0010s\u001a\u00020qJ\u0006\u0010t\u001a\u00020qJ\u0006\u0010u\u001a\u00020qJ\u0006\u0010v\u001a\u00020qJ\u0006\u0010w\u001a\u00020qJ\u0006\u0010x\u001a\u00020qJ\u0006\u0010y\u001a\u00020qJ\u0006\u0010z\u001a\u00020qR\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "source", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;)V", "<set-?>", "", "bytesRead", "getBytesRead", "()J", "identifierByteSize", "", "typeSizes", "", "readBoolean", "", "readBooleanArray", "", "arrayLength", "readByte", "", "readByteArray", "", "byteCount", "readChar", "", "readCharArray", "", "readClassDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readDebuggerGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Debugger;", "readDouble", "", "readDoubleArray", "", "readFinalizingGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Finalizing;", "readFloat", "", "readFloatArray", "", "readHeapDumpInfoRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "readId", "readIdArray", "", "readInstanceDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "readInt", "readIntArray", "readInternedStringGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$InternedString;", "readJavaFrameGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JavaFrame;", "readJniGlobalGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniGlobal;", "readJniLocalGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniLocal;", "readJniMonitorGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniMonitor;", "readLoadClassRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$LoadClassRecord;", "readLong", "readLongArray", "readMonitorUsedGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$MonitorUsed;", "readNativeStackGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$NativeStack;", "readObjectArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readPrimitiveArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readReferenceCleanupGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ReferenceCleanup;", "readShort", "", "readShortArray", "", "readStackFrameRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StackFrameRecord;", "readStackTraceRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StackTraceRecord;", "readStickyClassGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$StickyClass;", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readStringRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StringRecord;", "length", "readThreadBlockGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadBlock;", "readThreadObjectGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadObject;", "readUnknownGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unknown;", "readUnreachableGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unreachable;", "readUnsignedByte", "readUnsignedInt", "readUnsignedShort", "readUtf8", "readValue", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "type", "readVmInternalGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$VmInternal;", "sizeOf", "skip", "", "skipClassDumpConstantPool", "skipClassDumpFields", "skipClassDumpHeader", "skipClassDumpRecord", "skipClassDumpStaticFields", "skipHeapDumpInfoRecord", "skipInstanceDumpRecord", "skipObjectArrayDumpRecord", "skipPrimitiveArrayDumpRecord", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HprofRecordReader {
    public static final a c = new a(0);
    private static final int f = PrimitiveType.BOOLEAN.j;
    private static final int g = PrimitiveType.CHAR.j;
    private static final int h = PrimitiveType.BYTE.j;
    private static final int i = PrimitiveType.SHORT.j;
    private static final int j = PrimitiveType.INT.j;
    private static final int k = PrimitiveType.LONG.j;
    private static final int l = PrimitiveType.BOOLEAN.i;
    private static final int m = PrimitiveType.CHAR.i;
    private static final int n = PrimitiveType.FLOAT.i;
    private static final int o = PrimitiveType.DOUBLE.i;
    private static final int p = PrimitiveType.BYTE.i;
    private static final int q = PrimitiveType.SHORT.i;
    private static final int r = PrimitiveType.INT.i;
    private static final int s = PrimitiveType.LONG.i;
    public long a;
    final int[] b;
    private final int d;
    private final n e;

    public HprofRecordReader(HprofHeader header, n source) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(source, "source");
        this.e = source;
        int i2 = header.c;
        this.d = i2;
        PrimitiveType.a aVar = PrimitiveType.k;
        Map mapPlus = MapsKt.plus(PrimitiveType.m, TuplesKt.to(2, Integer.valueOf(i2)));
        Object objMax = CollectionsKt.max((Iterable) mapPlus.keySet());
        Intrinsics.checkNotNull(objMax);
        int iIntValue = ((Number) objMax).intValue() + 1;
        int[] iArr = new int[iIntValue];
        for (int i3 = 0; i3 < iIntValue; i3++) {
            Integer num = (Integer) mapPlus.get(Integer.valueOf(i3));
            iArr[i3] = num != null ? num.intValue() : 0;
        }
        this.b = iArr;
    }

    public final GcRoot.n a() {
        return new GcRoot.n(N());
    }

    public final GcRoot.e b() {
        return new GcRoot.e(N(), N());
    }

    public final GcRoot.f c() {
        return new GcRoot.f(N(), G(), G());
    }

    public final GcRoot.d d() {
        return new GcRoot.d(N(), G(), G());
    }

    public final GcRoot.i e() {
        return new GcRoot.i(N(), G());
    }

    public final GcRoot.k f() {
        return new GcRoot.k(N());
    }

    public final GcRoot.l g() {
        return new GcRoot.l(N(), G());
    }

    public final GcRoot.h h() {
        return new GcRoot.h(N());
    }

    public final GcRoot.m i() {
        return new GcRoot.m(N(), G(), G());
    }

    public final GcRoot.c j() {
        return new GcRoot.c(N());
    }

    public final GcRoot.b k() {
        return new GcRoot.b(N());
    }

    public final GcRoot.a l() {
        return new GcRoot.a(N());
    }

    public final GcRoot.j m() {
        return new GcRoot.j(N());
    }

    public final GcRoot.p n() {
        return new GcRoot.p(N());
    }

    public final GcRoot.g o() {
        return new GcRoot.g(N(), G(), G());
    }

    public final GcRoot.o p() {
        return new GcRoot.o(N());
    }

    public final HprofRecord.a.AbstractC0350a.b q() {
        return new HprofRecord.a.AbstractC0350a.b(N(), G(), N(), k(G()));
    }

    public final HprofRecord.a.AbstractC0350a.C0351a r() throws IOException {
        HprofRecordReader hprofRecordReader = this;
        long jN = N();
        int iG = G();
        long jN2 = N();
        long jN3 = N();
        long jN4 = N();
        long jN5 = N();
        N();
        N();
        int iG2 = G();
        int iO = O();
        for (int i2 = 0; i2 < iO; i2++) {
            hprofRecordReader.a(i);
            hprofRecordReader.a(hprofRecordReader.b[E()]);
        }
        int iO2 = O();
        ArrayList arrayList = new ArrayList(iO2);
        int i3 = 0;
        while (i3 < iO2) {
            long j2 = jN5;
            long jN6 = N();
            int i4 = iO2;
            int iE = E();
            arrayList.add(new HprofRecord.a.AbstractC0350a.C0351a.b(jN6, iE, hprofRecordReader.b(iE)));
            i3++;
            hprofRecordReader = this;
            jN5 = j2;
            iO2 = i4;
            iG2 = iG2;
        }
        long j3 = jN5;
        int i5 = iG2;
        int iO3 = O();
        ArrayList arrayList2 = new ArrayList(iO3);
        int i6 = 0;
        while (i6 < iO3) {
            arrayList2.add(new HprofRecord.a.AbstractC0350a.C0351a.C0352a(N(), E()));
            i6++;
            jN4 = jN4;
        }
        return new HprofRecord.a.AbstractC0350a.C0351a(jN, iG, jN2, jN3, jN4, j3, i5, arrayList, arrayList2);
    }

    public final HprofRecord.a.AbstractC0350a.d s() {
        long jN = N();
        int iG = G();
        int iG2 = G();
        int iE = E();
        if (iE == l) {
            return new HprofRecord.a.AbstractC0350a.d.C0353a(jN, iG, d(iG2));
        }
        if (iE == m) {
            return new HprofRecord.a.AbstractC0350a.d.c(jN, iG, e(iG2));
        }
        if (iE == n) {
            return new HprofRecord.a.AbstractC0350a.d.e(jN, iG, f(iG2));
        }
        if (iE == o) {
            return new HprofRecord.a.AbstractC0350a.d.C0354d(jN, iG, g(iG2));
        }
        if (iE == p) {
            return new HprofRecord.a.AbstractC0350a.d.b(jN, iG, k(iG2));
        }
        if (iE == q) {
            return new HprofRecord.a.AbstractC0350a.d.h(jN, iG, h(iG2));
        }
        if (iE == r) {
            return new HprofRecord.a.AbstractC0350a.d.f(jN, iG, i(iG2));
        }
        if (iE == s) {
            return new HprofRecord.a.AbstractC0350a.d.g(jN, iG, j(iG2));
        }
        throw new IllegalStateException("Unexpected type " + iE);
    }

    public final HprofRecord.a.AbstractC0350a.c t() {
        return new HprofRecord.a.AbstractC0350a.c(N(), G(), N(), c(G()));
    }

    public final void u() throws IOException {
        a((j * 2) + (this.d * 7));
        v();
    }

    public final void v() throws IOException {
        int iO = O();
        for (int i2 = 0; i2 < iO; i2++) {
            a(PrimitiveType.SHORT.j);
            a(this.b[E()]);
        }
    }

    public final void w() throws IOException {
        int iIntValue;
        int iO = O();
        for (int i2 = 0; i2 < iO; i2++) {
            a(this.d);
            int iE = E();
            if (iE == 2) {
                iIntValue = this.d;
            } else {
                PrimitiveType.a aVar = PrimitiveType.k;
                iIntValue = ((Number) MapsKt.getValue(PrimitiveType.m, Integer.valueOf(iE))).intValue();
            }
            a(iIntValue);
        }
    }

    public final void x() throws IOException {
        a((this.d + 1) * O());
    }

    public final void y() throws IOException {
        int i2 = this.d;
        a(j + i2 + i2);
        a(G());
    }

    public final void z() throws IOException {
        int i2 = this.d;
        int i3 = j;
        a(i2 + i3 + i2 + i2 + i2 + i2 + i2 + i2 + i3);
        int iO = O();
        for (int i4 = 0; i4 < iO; i4++) {
            a(i);
            a(this.b[E()]);
        }
        int iO2 = O();
        for (int i5 = 0; i5 < iO2; i5++) {
            a(this.d);
            a(this.b[E()]);
        }
        a(O() * (this.d + h));
    }

    public final void A() throws IOException {
        a(this.d + j);
        int iG = G();
        int i2 = this.d;
        a(i2 + (iG * i2));
    }

    public final void B() throws IOException {
        a(this.d + j);
        a(G() * this.b[E()]);
    }

    public final void C() throws IOException {
        int i2 = this.d;
        a(i2 + i2);
    }

    public final void a(int i2) throws IOException {
        long j2 = i2;
        this.a += j2;
        this.e.c(j2);
    }

    public final void a(long j2) throws IOException {
        this.a += j2;
        this.e.c(j2);
    }

    public final long D() {
        return ((long) G()) & 4294967295L;
    }

    public final int E() {
        return I() & UByte.MAX_VALUE;
    }

    public final ValueHolder b(int i2) {
        if (i2 == 2) {
            return new ValueHolder.i(N());
        }
        if (i2 == l) {
            return new ValueHolder.a(J());
        }
        if (i2 == m) {
            return new ValueHolder.c(K());
        }
        if (i2 == n) {
            return new ValueHolder.f(L());
        }
        if (i2 == o) {
            return new ValueHolder.e(M());
        }
        if (i2 == p) {
            return new ValueHolder.b(I());
        }
        if (i2 == q) {
            return new ValueHolder.j(F());
        }
        if (i2 == r) {
            return new ValueHolder.g(G());
        }
        if (i2 == s) {
            return new ValueHolder.h(H());
        }
        throw new IllegalStateException("Unknown type " + i2);
    }

    public final short F() {
        this.a += (long) i;
        return this.e.d();
    }

    public final int G() {
        this.a += (long) j;
        return this.e.e();
    }

    public final long[] c(int i2) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = N();
        }
        return jArr;
    }

    public final boolean[] d(int i2) {
        boolean[] zArr = new boolean[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            zArr[i3] = I() != 0;
        }
        return zArr;
    }

    public final char[] e(int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = K();
        }
        return cArr;
    }

    public final String a(int i2, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        long j2 = i2;
        this.a += j2;
        String strA = this.e.a(j2, charset);
        Intrinsics.checkNotNullExpressionValue(strA, "source.readString(byteCount.toLong(), charset)");
        return strA;
    }

    public final float[] f(int i2) {
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = L();
        }
        return fArr;
    }

    public final double[] g(int i2) {
        double[] dArr = new double[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            dArr[i3] = M();
        }
        return dArr;
    }

    public final short[] h(int i2) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = F();
        }
        return sArr;
    }

    public final int[] i(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = G();
        }
        return iArr;
    }

    public final long[] j(int i2) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = H();
        }
        return jArr;
    }

    public final long H() {
        this.a += (long) k;
        return this.e.f();
    }

    public final byte I() {
        this.a += (long) h;
        return this.e.c();
    }

    public final boolean J() {
        this.a += (long) f;
        return this.e.c() != 0;
    }

    public final byte[] k(int i2) throws IOException {
        long j2 = i2;
        this.a += j2;
        byte[] bArrB = this.e.b(j2);
        Intrinsics.checkNotNullExpressionValue(bArrB, "source.readByteArray(byteCount.toLong())");
        return bArrB;
    }

    public final char K() {
        return a(g, Charsets.UTF_16BE).charAt(0);
    }

    public final float L() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(G());
    }

    public final double M() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(H());
    }

    public final long N() {
        int I;
        int i2 = this.d;
        if (i2 == 1) {
            I = I();
        } else if (i2 == 2) {
            I = F();
        } else {
            if (i2 != 4) {
                if (i2 == 8) {
                    return H();
                }
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
            }
            I = G();
        }
        return I;
    }

    public final String b(long j2) throws IOException {
        this.a += j2;
        String strA = this.e.a(j2);
        Intrinsics.checkNotNullExpressionValue(strA, "source.readUtf8(byteCount)");
        return strA;
    }

    public final int O() {
        return F() & UShort.MAX_VALUE;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bb$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader$Companion;", "", "()V", "BOOLEAN_SIZE", "", "BOOLEAN_TYPE", "BYTE_MASK", "BYTE_SIZE", "BYTE_TYPE", "CHAR_SIZE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_MASK", "", "INT_SIZE", "INT_TYPE", "LONG_SIZE", "LONG_TYPE", "SHORT_SIZE", "SHORT_TYPE", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
