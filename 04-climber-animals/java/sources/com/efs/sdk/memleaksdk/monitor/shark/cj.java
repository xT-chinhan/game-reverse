package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 D2\u00020\u0001:\u0002CDB\u0095\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\u0015\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0002\u0010+J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)J\u0016\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020)J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020)H\u0002J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100J\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040100J\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060100J\u0016\u00107\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001082\u0006\u0010:\u001a\u00020)J\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090100J\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0100J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u000209012\u0006\u0010?\u001a\u00020\u0003J\u000e\u0010@\u001a\u00020\u00182\u0006\u0010:\u001a\u00020)J\f\u0010A\u001a\u000202*\u00020BH\u0002R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "", "positionSize", "", "hprofStringCache", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectScatterMap;", "", "classNames", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap;", "classIndex", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;", "instanceIndex", "objectArrayIndex", "primitiveArrayIndex", "gcRoots", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "bytesForClassSize", "bytesForInstanceSize", "bytesForObjectArraySize", "bytesForPrimitiveArraySize", "useForwardSlashClassPackageSeparator", "", "classFieldsReader", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ClassFieldsReader;", "classFieldsIndexSize", "(ILcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectScatterMap;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;IIIIZLcom/efs/sdk/memleaksdk/monitor/shark/internal/ClassFieldsReader;I)V", "classCount", "getClassCount", "()I", "getClassFieldsReader", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ClassFieldsReader;", "instanceCount", "getInstanceCount", "objectArrayCount", "getObjectArrayCount", "primitiveArrayCount", "getPrimitiveArrayCount", "classId", "", "className", "(Ljava/lang/String;)Ljava/lang/Long;", "fieldName", "id", "hprofStringById", "indexedClassSequence", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;", "indexedInstanceSequence", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "indexedObjectArraySequence", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;", "indexedObjectOrNull", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/IntObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject;", "objectId", "indexedObjectSequence", "indexedPrimitiveArraySequence", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;", "objectAtIndex", com.umeng.ccg.a.H, "objectIdIsIndexed", "readClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ByteSubArray;", "Builder", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cj {
    public static final b e = new b(0);
    public final cs a;
    public final cs b;
    public final List<GcRoot> c;
    public final cf d;
    private final int f;
    private final dc<String> g;
    private final da h;
    private final cs i;
    private final cs j;
    private final ProguardMapping k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final boolean p;
    private final int q;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¨\u0006\u0012"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex$Companion;", "", "()V", "byteSizeForUnsigned", "", "maxValue", "", "indexHprof", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "indexedGcRootTags", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {
        final int a(long j) {
            int i = 0;
            while (j != 0) {
                j >>= 8;
                i++;
            }
            return i;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"com/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener$Companion$invoke$1", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "onHprofRecord", "", TTDownloadField.TT_TAG, "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "length", "", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a implements OnHprofRecordTagListener {
            final /* synthetic */ Ref.IntRef b;
            final /* synthetic */ Ref.LongRef c;
            final /* synthetic */ Ref.IntRef d;
            final /* synthetic */ Ref.IntRef e;
            final /* synthetic */ Ref.LongRef f;
            final /* synthetic */ Ref.IntRef g;
            final /* synthetic */ Ref.LongRef h;
            final /* synthetic */ Ref.IntRef i;
            final /* synthetic */ Ref.LongRef j;

            public a(Ref.IntRef intRef, Ref.LongRef longRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.LongRef longRef2, Ref.IntRef intRef4, Ref.LongRef longRef3, Ref.IntRef intRef5, Ref.LongRef longRef4) {
                this.b = intRef;
                this.c = longRef;
                this.d = intRef2;
                this.e = intRef3;
                this.f = longRef2;
                this.g = intRef4;
                this.h = longRef3;
                this.i = intRef5;
                this.j = longRef4;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.OnHprofRecordTagListener
            public void a(HprofRecordTag tag, long j, HprofRecordReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(reader, "reader");
                long j2 = reader.a;
                int i = cl.a[tag.ordinal()];
                if (i == 1) {
                    this.b.element++;
                    reader.u();
                    long j3 = reader.a;
                    reader.w();
                    reader.x();
                    Ref.LongRef longRef = this.c;
                    longRef.element = Math.max(longRef.element, reader.a - j2);
                    this.d.element += (int) (reader.a - j3);
                    return;
                }
                if (i == 2) {
                    this.e.element++;
                    reader.y();
                    Ref.LongRef longRef2 = this.f;
                    longRef2.element = Math.max(longRef2.element, reader.a - j2);
                    return;
                }
                if (i == 3) {
                    this.g.element++;
                    reader.A();
                    Ref.LongRef longRef3 = this.h;
                    longRef3.element = Math.max(longRef3.element, reader.a - j2);
                    return;
                }
                if (i != 4) {
                    return;
                }
                this.i.element++;
                reader.B();
                Ref.LongRef longRef4 = this.j;
                longRef4.element = Math.max(longRef4.element, reader.a - j2);
            }
        }

        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public final cj a(StreamingHprofReader reader, HprofHeader hprofHeader, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> indexedGcRootTags) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            Intrinsics.checkNotNullParameter(indexedGcRootTags, "indexedGcRootTags");
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = 0L;
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = 0L;
            Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.element = 0L;
            Ref.LongRef longRef4 = new Ref.LongRef();
            longRef4.element = 0L;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = 0;
            Ref.IntRef intRef3 = new Ref.IntRef();
            intRef3.element = 0;
            Ref.IntRef intRef4 = new Ref.IntRef();
            intRef4.element = 0;
            Ref.IntRef intRef5 = new Ref.IntRef();
            intRef5.element = 0;
            EnumSet enumSetOf = EnumSet.of(HprofRecordTag.CLASS_DUMP, HprofRecordTag.INSTANCE_DUMP, HprofRecordTag.OBJECT_ARRAY_DUMP, HprofRecordTag.PRIMITIVE_ARRAY_DUMP);
            Intrinsics.checkNotNullExpressionValue(enumSetOf, "EnumSet.of(CLASS_DUMP, I…MP, PRIMITIVE_ARRAY_DUMP)");
            EnumSet enumSet = enumSetOf;
            OnHprofRecordTagListener.a aVar = OnHprofRecordTagListener.a;
            a aVar2 = new a(hprofHeader.c == 8, reader.a(enumSet, new a(intRef, longRef, intRef5, intRef2, longRef2, intRef3, longRef3, intRef4, longRef4)), intRef.element, intRef2.element, intRef3.element, intRef4.element, a(longRef.element), a(longRef2.element), a(longRef3.element), a(longRef4.element), intRef5.element);
            EnumSet enumSetOf2 = EnumSet.of(HprofRecordTag.STRING_IN_UTF8, HprofRecordTag.LOAD_CLASS, HprofRecordTag.CLASS_DUMP, HprofRecordTag.INSTANCE_DUMP, HprofRecordTag.OBJECT_ARRAY_DUMP, HprofRecordTag.PRIMITIVE_ARRAY_DUMP);
            Intrinsics.checkNotNullExpressionValue(enumSetOf2, "EnumSet.of(\n        STRI…MITIVE_ARRAY_DUMP\n      )");
            HprofRecordTag.a aVar3 = HprofRecordTag.L;
            reader.a(SetsKt.plus((Set) enumSetOf2, (Iterable) CollectionsKt.intersect(HprofRecordTag.N, indexedGcRootTags)), aVar2);
            SharkLog sharkLog = SharkLog.b;
            if (SharkLog.a != null) {
                String str = "classCount:" + intRef.element + " instanceCount:" + intRef2.element + " objectArrayCount:" + intRef3.element + " primitiveArrayCount:" + intRef4.element;
            }
            return aVar2.a(proguardMapping, hprofHeader);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private cj(int i, dc<String> dcVar, da daVar, cs csVar, cs csVar2, cs csVar3, cs csVar4, List<? extends GcRoot> list, ProguardMapping proguardMapping, int i2, int i3, int i4, int i5, boolean z, cf cfVar, int i6) {
        this.f = i;
        this.g = dcVar;
        this.h = daVar;
        this.a = csVar;
        this.b = csVar2;
        this.i = csVar3;
        this.j = csVar4;
        this.c = list;
        this.k = proguardMapping;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        this.o = i5;
        this.p = z;
        this.d = cfVar;
        this.q = i6;
    }

    public /* synthetic */ cj(int i, dc dcVar, da daVar, cs csVar, cs csVar2, cs csVar3, cs csVar4, List list, ProguardMapping proguardMapping, int i2, int i3, int i4, int i5, boolean z, cf cfVar, int i6, byte b2) {
        this(i, dcVar, daVar, csVar, csVar2, csVar3, csVar4, list, proguardMapping, i2, i3, i4, i5, z, cfVar, i6);
    }

    public final String a(long j, long j2) {
        String strD = d(j2);
        if (this.k == null) {
            return strD;
        }
        String strA = this.k.a(d(this.h.b(j)), strD);
        return strA != null ? strA : strD;
    }

    public final String a(long j) {
        String strA;
        String strD = d(this.h.b(j));
        ProguardMapping proguardMapping = this.k;
        String str = (proguardMapping == null || (strA = proguardMapping.a(strD)) == null) ? strD : strA;
        return this.p ? StringsKt.replace$default(str, '/', '.', false, 4, (Object) null) : str;
    }

    public final Long a(String className) {
        db<String> next;
        cz next2;
        Intrinsics.checkNotNullParameter(className, "className");
        if (this.p) {
            className = StringsKt.replace$default(className, '.', '/', false, 4, (Object) null);
        }
        Iterator<db<String>> it = this.g.b().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(next.b, className));
        db<String> dbVar = next;
        Long lValueOf = dbVar != null ? Long.valueOf(dbVar.a) : null;
        if (lValueOf == null) {
            return null;
        }
        long jLongValue = lValueOf.longValue();
        Iterator<cz> it2 = this.h.b().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!(next2.b == jLongValue));
        cz czVar = next2;
        if (czVar != null) {
            return Long.valueOf(czVar.a);
        }
        return null;
    }

    public final Sequence<db<cm.b>> a() {
        return SequencesKt.map(this.b.a(), new c());
    }

    public final cy<cm> b(long j) {
        int iB = this.a.b(j);
        if (iB >= 0) {
            return de.a(iB, a(this.a.a(iB)));
        }
        int iB2 = this.b.b(j);
        if (iB2 >= 0) {
            cd cdVarA = this.b.a(iB2);
            return de.a(this.a.c + iB2, new cm.b(cdVarA.a(this.f), cdVarA.b(), cdVarA.a(this.m)));
        }
        int iB3 = this.i.b(j);
        if (iB3 >= 0) {
            cd cdVarA2 = this.i.a(iB3);
            return de.a(this.a.c + this.b.c + iB3, new cm.c(cdVarA2.a(this.f), cdVarA2.b(), cdVarA2.a(this.n)));
        }
        int iB4 = this.j.b(j);
        if (iB4 < 0) {
            return null;
        }
        cd cdVarA3 = this.j.a(iB4);
        return de.a(this.a.c + this.b.c + iB4 + this.j.c, new cm.d(cdVarA3.a(this.f), PrimitiveType.values()[cdVarA3.a()], cdVarA3.a(this.o)));
    }

    private final cm.a a(cd cdVar) {
        return new cm.a(cdVar.a(this.f), cdVar.b(), cdVar.c(), cdVar.a(this.l), (int) cdVar.a(this.q));
    }

    public final boolean c(long j) {
        return (this.a.a(j) == null && this.b.a(j) == null && this.i.a(j) == null && this.j.a(j) == null) ? false : true;
    }

    private final String d(long j) {
        String strA = this.g.a(j);
        if (strA != null) {
            return strA;
        }
        throw new IllegalArgumentException("Hprof string " + j + " not in cache");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010J\u0018\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u000201H\u0002J \u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0016J\u0014\u00109\u001a\u000203*\u0002082\u0006\u0010:\u001a\u00020\u0007H\u0002R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex$Builder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "longIdentifiers", "", "maxPosition", "", "classCount", "", "instanceCount", "objectArrayCount", "primitiveArrayCount", "bytesForClassSize", "bytesForInstanceSize", "bytesForObjectArraySize", "bytesForPrimitiveArraySize", "classFieldsTotalBytes", "(ZJIIIIIIIII)V", "getBytesForClassSize", "()I", "getBytesForInstanceSize", "getBytesForObjectArraySize", "getBytesForPrimitiveArraySize", "classFieldBytes", "", "classFieldsIndex", "classFieldsIndexSize", "getClassFieldsTotalBytes", "classIndex", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/UnsortedByteEntries;", "classNames", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap;", "gcRoots", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "hprofStringCache", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectScatterMap;", "", "identifierSize", "instanceIndex", "objectArrayIndex", "positionSize", "primitiveArrayIndex", "buildIndex", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "lastClassFieldsShort", "", "onHprofRecord", "", TTDownloadField.TT_TAG, "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "length", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "copyToClassFields", "byteCount", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    static final class a implements OnHprofRecordTagListener {
        private final int b;
        private final int c;
        private final int d;
        private final dc<String> e;
        private final da f;
        private final byte[] g;
        private int h;
        private final cu i;
        private final cu j;
        private final cu k;
        private final cu l;
        private final List<GcRoot> m;
        private final int n;
        private final int o;
        private final int p;
        private final int q;
        private final int r;

        public a(boolean z, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.n = i5;
            this.o = i6;
            this.p = i7;
            this.q = i8;
            this.r = i9;
            int i10 = z ? 8 : 4;
            this.b = i10;
            int iA = cj.e.a(j);
            this.c = iA;
            int iA2 = cj.e.a(i9);
            this.d = iA2;
            this.e = new dc<>();
            this.f = new da(i);
            this.g = new byte[i9];
            this.i = new cu(iA + i10 + 4 + i5 + iA2, z, i, 0.0d, 8);
            this.j = new cu(iA + i10 + i6, z, i2, 0.0d, 8);
            this.k = new cu(i10 + iA + i7, z, i3, 0.0d, 8);
            this.l = new cu(iA + 1 + i8, z, i4, 0.0d, 8);
            this.m = new ArrayList();
        }

        private final void a(HprofRecordReader hprofRecordReader, int i) {
            int i2 = 1;
            if (1 > i) {
                return;
            }
            while (true) {
                byte[] bArr = this.g;
                int i3 = this.h;
                this.h = i3 + 1;
                bArr[i3] = hprofRecordReader.I();
                if (i2 == i) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        private final short a() {
            byte[] bArr = this.g;
            int i = this.h;
            return (short) ((bArr[i - 1] & UByte.MAX_VALUE) | ((bArr[i - 2] & UByte.MAX_VALUE) << 8));
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.OnHprofRecordTagListener
        public void a(HprofRecordTag tag, long j, HprofRecordReader reader) throws IOException {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(reader, "reader");
            switch (ck.a[tag.ordinal()]) {
                case 1:
                    this.e.a(reader.N(), reader.b(j - ((long) this.b)));
                    return;
                case 2:
                    reader.a(PrimitiveType.INT.j);
                    long jN = reader.N();
                    reader.a(PrimitiveType.INT.j);
                    this.f.a(jN, reader.N());
                    return;
                case 3:
                    GcRoot.n nVarA = reader.a();
                    if (nVarA.getA() != 0) {
                        this.m.add(nVarA);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                case 4:
                    GcRoot.e eVarB = reader.b();
                    if (eVarB.getA() != 0) {
                        this.m.add(eVarB);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return;
                case 5:
                    GcRoot.f fVarC = reader.c();
                    if (fVarC.getA() != 0) {
                        this.m.add(fVarC);
                    }
                    Unit unit3 = Unit.INSTANCE;
                    return;
                case 6:
                    GcRoot.d dVarD = reader.d();
                    if (dVarD.getA() != 0) {
                        this.m.add(dVarD);
                    }
                    Unit unit4 = Unit.INSTANCE;
                    return;
                case 7:
                    GcRoot.i iVarE = reader.e();
                    if (iVarE.getA() != 0) {
                        this.m.add(iVarE);
                    }
                    Unit unit5 = Unit.INSTANCE;
                    return;
                case 8:
                    GcRoot.k kVarF = reader.f();
                    if (kVarF.getA() != 0) {
                        this.m.add(kVarF);
                    }
                    Unit unit6 = Unit.INSTANCE;
                    return;
                case 9:
                    GcRoot.l lVarG = reader.g();
                    if (lVarG.getA() != 0) {
                        this.m.add(lVarG);
                    }
                    Unit unit7 = Unit.INSTANCE;
                    return;
                case 10:
                    GcRoot.h hVarH = reader.h();
                    if (hVarH.getA() != 0) {
                        this.m.add(hVarH);
                    }
                    Unit unit8 = Unit.INSTANCE;
                    return;
                case 11:
                    GcRoot.m mVarI = reader.i();
                    if (mVarI.getA() != 0) {
                        this.m.add(mVarI);
                    }
                    Unit unit9 = Unit.INSTANCE;
                    return;
                case 12:
                    GcRoot.c cVarJ = reader.j();
                    if (cVarJ.getA() != 0) {
                        this.m.add(cVarJ);
                    }
                    Unit unit10 = Unit.INSTANCE;
                    return;
                case 13:
                    GcRoot.b bVarK = reader.k();
                    if (bVarK.getA() != 0) {
                        this.m.add(bVarK);
                    }
                    Unit unit11 = Unit.INSTANCE;
                    return;
                case 14:
                    GcRoot.a aVarL = reader.l();
                    if (aVarL.getA() != 0) {
                        this.m.add(aVarL);
                    }
                    Unit unit12 = Unit.INSTANCE;
                    return;
                case 15:
                    GcRoot.j jVarM = reader.m();
                    if (jVarM.getA() != 0) {
                        this.m.add(jVarM);
                    }
                    Unit unit13 = Unit.INSTANCE;
                    return;
                case 16:
                    GcRoot.p pVarN = reader.n();
                    if (pVarN.getA() != 0) {
                        this.m.add(pVarN);
                    }
                    Unit unit14 = Unit.INSTANCE;
                    return;
                case 17:
                    GcRoot.g gVarO = reader.o();
                    if (gVarO.getA() != 0) {
                        this.m.add(gVarO);
                    }
                    Unit unit15 = Unit.INSTANCE;
                    return;
                case 18:
                    GcRoot.o oVarP = reader.p();
                    if (oVarP.getA() != 0) {
                        this.m.add(oVarP);
                    }
                    Unit unit16 = Unit.INSTANCE;
                    return;
                case 19:
                    long j2 = reader.a;
                    long jN2 = reader.N();
                    reader.a(PrimitiveType.INT.j);
                    long jN3 = reader.N();
                    reader.a(this.b * 5);
                    int iG = reader.G();
                    reader.v();
                    int i = this.h;
                    long j3 = reader.a;
                    int i2 = 2;
                    a(reader, 2);
                    int iA = a() & UShort.MAX_VALUE;
                    int i3 = 0;
                    while (i3 < iA) {
                        a(reader, this.b);
                        a(reader, 1);
                        int i4 = iA;
                        int i5 = this.g[this.h - 1] & UByte.MAX_VALUE;
                        if (i5 == 2) {
                            a(reader, this.b);
                        } else {
                            PrimitiveType.a aVar = PrimitiveType.k;
                            a(reader, ((Number) MapsKt.getValue(PrimitiveType.m, Integer.valueOf(i5))).intValue());
                        }
                        i3++;
                        iA = i4;
                        i2 = 2;
                    }
                    a(reader, i2);
                    int iA2 = a() & UShort.MAX_VALUE;
                    for (int i6 = 0; i6 < iA2; i6++) {
                        a(reader, this.b);
                        a(reader, 1);
                    }
                    int i7 = (int) (reader.a - j3);
                    long j4 = reader.a - j2;
                    cu.a aVarA = this.i.a(jN2);
                    aVarA.a(j2, this.c);
                    aVarA.a(jN3);
                    aVarA.a(iG);
                    aVarA.a(j4, this.n);
                    aVarA.a(i, this.d);
                    Unit unit17 = Unit.INSTANCE;
                    int i8 = i + i7;
                    if (!(i8 == this.h)) {
                        throw new IllegalArgumentException(("Expected " + this.h + " to have moved by " + i7 + " and be equal to " + i8).toString());
                    }
                    return;
                case 20:
                    long j5 = reader.a;
                    long jN4 = reader.N();
                    reader.a(PrimitiveType.INT.j);
                    long jN5 = reader.N();
                    reader.a(reader.G());
                    long j6 = reader.a - j5;
                    cu.a aVarA2 = this.j.a(jN4);
                    aVarA2.a(j5, this.c);
                    aVarA2.a(jN5);
                    aVarA2.a(j6, this.o);
                    Unit unit18 = Unit.INSTANCE;
                    return;
                case 21:
                    long j7 = reader.a;
                    long jN6 = reader.N();
                    reader.a(PrimitiveType.INT.j);
                    int iG2 = reader.G();
                    long jN7 = reader.N();
                    reader.a(this.b * iG2);
                    long j8 = reader.a - j7;
                    cu.a aVarA3 = this.k.a(jN6);
                    aVarA3.a(j7, this.c);
                    aVarA3.a(jN7);
                    aVarA3.a(j8, this.p);
                    Unit unit19 = Unit.INSTANCE;
                    return;
                case 22:
                    long j9 = reader.a;
                    long jN8 = reader.N();
                    reader.a(PrimitiveType.INT.j);
                    int iG3 = reader.G();
                    PrimitiveType.a aVar2 = PrimitiveType.k;
                    PrimitiveType primitiveType = (PrimitiveType) MapsKt.getValue(PrimitiveType.n, Integer.valueOf(reader.E()));
                    reader.a(iG3 * primitiveType.j);
                    long j10 = reader.a - j9;
                    cu.a aVarA4 = this.l.a(jN8);
                    aVarA4.a(j9, this.c);
                    aVarA4.a((byte) primitiveType.ordinal());
                    aVarA4.a(j10, this.q);
                    Unit unit20 = Unit.INSTANCE;
                    return;
                default:
                    return;
            }
        }

        public final cj a(ProguardMapping proguardMapping, HprofHeader hprofHeader) {
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            if (!(this.h == this.g.length)) {
                throw new IllegalArgumentException(("Read " + this.h + " into fields bytes instead of expected " + this.g.length).toString());
            }
            return new cj(this.c, this.e, this.f, this.i.a(), this.j.a(), this.k.a(), this.l.a(), this.m, proguardMapping, this.n, this.o, this.p, this.q, hprofHeader.b != HprofVersion.ANDROID, new cf(this.b, this.g), this.d, (byte) 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "it", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ByteSubArray;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class c extends Lambda implements Function1<db<? extends cd>, db<? extends cm.b>> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final db<cm.b> invoke(db<cd> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            long j = it.a;
            cd cdVar = it.b;
            return de.a(j, new cm.b(cdVar.a(cj.this.f), cdVar.b(), cdVar.a(cj.this.m)));
        }
    }
}
