package com.efs.sdk.memleaksdk.monitor.shark;

import com.anythink.core.common.e.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord;", "", "()V", "HeapDumpEndRecord", "HeapDumpRecord", "LoadClassRecord", "StackFrameRecord", "StackTraceRecord", "StringRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StringRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$LoadClassRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpEndRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StackFrameRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StackTraceRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class HprofRecord {
    private HprofRecord() {
    }

    public /* synthetic */ HprofRecord(byte b) {
        this();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord;", "()V", "GcRootRecord", "HeapDumpInfoRecord", "ObjectRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$GcRootRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class a extends HprofRecord {
        private a() {
            super((byte) 0);
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord;", "()V", "ClassDumpRecord", "InstanceDumpRecord", "ObjectArrayDumpRecord", "PrimitiveArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static abstract class AbstractC0350a extends a {
            private AbstractC0350a() {
                super((byte) 0);
            }

            public /* synthetic */ AbstractC0350a(byte b2) {
                this();
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$a, reason: collision with other inner class name */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002\u001d\u001eBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "superclassId", "classLoaderId", "signersId", "protectionDomainId", "instanceSize", "staticFields", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "fields", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "(JIJJJJILjava/util/List;Ljava/util/List;)V", "getClassLoaderId", "()J", "getFields", "()Ljava/util/List;", "getId", "getInstanceSize", "()I", "getProtectionDomainId", "getSignersId", "getStackTraceSerialNumber", "getStaticFields", "getSuperclassId", "FieldRecord", "StaticFieldRecord", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
            public static final class C0351a extends AbstractC0350a {
                private final long a;
                private final int b;
                private final long c;
                private final long d;
                private final long e;
                private final long f;
                private final int g;
                private final List<b> h;
                private final List<C0352a> i;

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$a$b */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "", "nameStringId", "", "type", "", f.a.d, "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "(JILcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;)V", "getNameStringId", "()J", "getType", "()I", "getValue", "()Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final /* data */ class b {
                    final long a;
                    final ValueHolder b;
                    private final int c;

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof b)) {
                            return false;
                        }
                        b bVar = (b) other;
                        return this.a == bVar.a && this.c == bVar.c && Intrinsics.areEqual(this.b, bVar.b);
                    }

                    public int hashCode() {
                        int iHashCode = ((Long.hashCode(this.a) * 31) + Integer.hashCode(this.c)) * 31;
                        ValueHolder valueHolder = this.b;
                        return iHashCode + (valueHolder != null ? valueHolder.hashCode() : 0);
                    }

                    public String toString() {
                        return "StaticFieldRecord(nameStringId=" + this.a + ", type=" + this.c + ", value=" + this.b + ")";
                    }

                    public b(long j, int i, ValueHolder value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.a = j;
                        this.c = i;
                        this.b = value;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0351a(long j, int i, long j2, long j3, long j4, long j5, int i2, List<b> staticFields, List<C0352a> fields) {
                    super((byte) 0);
                    Intrinsics.checkNotNullParameter(staticFields, "staticFields");
                    Intrinsics.checkNotNullParameter(fields, "fields");
                    this.a = j;
                    this.b = i;
                    this.c = j2;
                    this.d = j3;
                    this.e = j4;
                    this.f = j5;
                    this.g = i2;
                    this.h = staticFields;
                    this.i = fields;
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$a$a, reason: collision with other inner class name */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "", "nameStringId", "", "type", "", "(JI)V", "getNameStringId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final /* data */ class C0352a {
                    final long a;
                    public final int b;

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof C0352a)) {
                            return false;
                        }
                        C0352a c0352a = (C0352a) other;
                        return this.a == c0352a.a && this.b == c0352a.b;
                    }

                    public int hashCode() {
                        return (Long.hashCode(this.a) * 31) + Integer.hashCode(this.b);
                    }

                    public String toString() {
                        return "FieldRecord(nameStringId=" + this.a + ", type=" + this.b + ")";
                    }

                    public C0352a(long j, int i) {
                        this.a = j;
                        this.b = i;
                    }
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$b */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "classId", "fieldValues", "", "(JIJ[B)V", "getClassId", "()J", "getFieldValues", "()[B", "getId", "getStackTraceSerialNumber", "()I", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
            public static final class b extends AbstractC0350a {
                public final byte[] a;
                private final long b;
                private final int c;
                private final long d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(long j, int i, long j2, byte[] fieldValues) {
                    super((byte) 0);
                    Intrinsics.checkNotNullParameter(fieldValues, "fieldValues");
                    this.b = j;
                    this.c = i;
                    this.d = j2;
                    this.a = fieldValues;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$c */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "arrayClassId", "elementIds", "", "(JIJ[J)V", "getArrayClassId", "()J", "getElementIds", "()[J", "getId", "getStackTraceSerialNumber", "()I", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
            public static final class c extends AbstractC0350a {
                public final long[] a;
                private final long b;
                private final int c;
                private final long d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(long j, int i, long j2, long[] elementIds) {
                    super((byte) 0);
                    Intrinsics.checkNotNullParameter(elementIds, "elementIds");
                    this.b = j;
                    this.c = i;
                    this.d = j2;
                    this.a = elementIds;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\u0082\u0001\b\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "()V", "id", "", "getId", "()J", "size", "", "getSize", "()I", "stackTraceSerialNumber", "getStackTraceSerialNumber", "BooleanArrayDump", "ByteArrayDump", "CharArrayDump", "DoubleArrayDump", "FloatArrayDump", "IntArrayDump", "LongArrayDump", "ShortArrayDump", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$BooleanArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$FloatArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$DoubleArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ShortArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$LongArrayDump;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
            public static abstract class d extends AbstractC0350a {
                private d() {
                    super((byte) 0);
                }

                public /* synthetic */ d(byte b2) {
                    this();
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$a, reason: collision with other inner class name */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$BooleanArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[Z)V", "getArray", "()[Z", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class C0353a extends d {
                    final boolean[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0353a(long j, int i, boolean[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$c */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[C)V", "getArray", "()[C", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class c extends d {
                    final char[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public c(long j, int i, char[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$e */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$FloatArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[F)V", "getArray", "()[F", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class e extends d {
                    final float[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public e(long j, int i, float[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$d, reason: collision with other inner class name */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$DoubleArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[D)V", "getArray", "()[D", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class C0354d extends d {
                    final double[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0354d(long j, int i, double[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$b */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[B)V", "getArray", "()[B", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class b extends d {
                    final byte[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(long j, int i, byte[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$h */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0017\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ShortArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[S)V", "getArray", "()[S", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class h extends d {
                    final short[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public h(long j, int i, short[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$f */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[I)V", "getArray", "()[I", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class f extends d {
                    final int[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public f(long j, int i, int[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ba$a$a$d$g */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$LongArrayDump;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[J)V", "getArray", "()[J", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
                public static final class g extends d {
                    final long[] a;
                    private final long b;
                    private final int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public g(long j, int i, long[] array) {
                        super((byte) 0);
                        Intrinsics.checkNotNullParameter(array, "array");
                        this.b = j;
                        this.c = i;
                        this.a = array;
                    }
                }
            }
        }
    }
}
