package com.efs.sdk.memleaksdk.monitor.shark;

import com.anythink.core.common.e.f;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b6\u0018\u0000 #2\u00020\u0001:\u0005#$%&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H&R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e\u0082\u0001\u0004\u0004\b\f\u0010¨\u0006("}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "", "()V", "asClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getAsClass", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "asInstance", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "getAsInstance", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "asObjectArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "getAsObjectArray", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "asPrimitiveArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "getAsPrimitiveArray", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "objectId", "", "getObjectId", "()J", "objectIndex", "", "getObjectIndex", "()I", "recordSize", "getRecordSize", "readRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Companion", "HeapClass", "HeapInstance", "HeapObjectArray", "HeapPrimitiveArray", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class HeapObject {
    static final Set<String> a;
    public static final a b = new a(0);
    private static final Map<String, PrimitiveType> c;

    /* JADX INFO: renamed from: a */
    public abstract long getE();

    public abstract HprofRecord.a.AbstractC0350a b();

    public abstract int c();

    private HeapObject() {
    }

    public /* synthetic */ HeapObject(byte b2) {
        this();
    }

    public final b d() {
        if (this instanceof b) {
            return (b) this;
        }
        return null;
    }

    public final c e() {
        if (this instanceof c) {
            return (c) this;
        }
        return null;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020%H\u0086\u0002J\u000e\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020\tJ\b\u0010A\u001a\u00020BH\u0016J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020?0DJ\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0DJ\u0010\u0010G\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020%J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020;0\fJ\u0011\u0010I\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u0000H\u0086\u0004J\u0011\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u0000H\u0086\u0004J\b\u0010L\u001a\u00020%H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u0011\u0010 \u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001aR\u0011\u0010#\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\f8F¢\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\f8F¢\u0006\u0006\u001a\u0004\b0\u0010\u000fR\u0014\u00101\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001dR\u0011\u00103\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b4\u0010'R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00000\f8F¢\u0006\u0006\u001a\u0004\b6\u0010\u000fR\u0013\u00107\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006M"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "hprofGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;", "indexedObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;", "objectId", "", "objectIndex", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;JI)V", "_classHierarchy", "Lkotlin/sequences/Sequence;", "classHierarchy", "getClassHierarchy", "()Lkotlin/sequences/Sequence;", "directInstances", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "getDirectInstances", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "hasReferenceInstanceFields", "", "getHasReferenceInstanceFields", "()Z", "instanceByteSize", "getInstanceByteSize", "()I", "instances", "getInstances", "isArrayClass", "isObjectArrayClass", "isPrimitiveArrayClass", "isPrimitiveWrapperClass", Common.System.NAME, "", BillingClientConstants.METHOD_GET_PRODUCT_NAME, "()Ljava/lang/String;", "objectArrayInstances", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "getObjectArrayInstances", "getObjectId", "()J", "getObjectIndex", "primitiveArrayInstances", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrayInstances", "recordSize", "getRecordSize", "simpleName", "getSimpleName", "subclasses", "getSubclasses", "superclass", "getSuperclass", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "get", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapField;", "fieldName", "instanceFieldName", "fieldRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "readFieldsByteSize", "readRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readRecordFields", "", "readRecordStaticFields", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "readStaticField", "readStaticFields", "subclassOf", "superclassOf", "subclass", "toString", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b extends HeapObject {
        private Sequence<b> c;
        private final HprofHeapGraph d;
        private final cm.a e;
        private final long f;
        private final int g;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$b$b, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class C0349b extends Lambda implements Function1<c, Boolean> {
            C0349b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(c cVar) {
                return Boolean.valueOf(a(cVar));
            }

            public final boolean a(c it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.c.a == b.this.getE();
            }
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getE() {
            return this.f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HprofHeapGraph hprofGraph, cm.a indexedObject, long j, int i) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(hprofGraph, "hprofGraph");
            Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
            this.d = hprofGraph;
            this.e = indexedObject;
            this.f = j;
            this.g = i;
        }

        public final String f() {
            return this.d.d(getE());
        }

        public final int g() {
            return this.e.b;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        public int c() {
            return (int) this.e.getC();
        }

        public final boolean h() {
            return this.d.c(this.e);
        }

        public final int i() {
            int iIntValue;
            int i = 0;
            for (HprofRecord.a.AbstractC0350a.C0351a.C0352a c0352a : o()) {
                if (c0352a.b == 2) {
                    iIntValue = this.d.a();
                } else {
                    PrimitiveType.a aVar = PrimitiveType.k;
                    iIntValue = ((Number) MapsKt.getValue(PrimitiveType.m, Integer.valueOf(c0352a.b))).intValue();
                }
                i += iIntValue;
            }
            return i;
        }

        public final b j() {
            if (this.e.a == 0) {
                return null;
            }
            HeapObject heapObjectA = this.d.a(this.e.a);
            if (heapObjectA != null) {
                return (b) heapObjectA;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.HeapObject.HeapClass");
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$b$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "it", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class a extends Lambda implements Function1<b, b> {
            public static final a a = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b invoke(b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.j();
            }
        }

        public final Sequence<b> k() {
            if (this.c == null) {
                this.c = SequencesKt.generateSequence(this, a.a);
            }
            Sequence<b> sequence = this.c;
            Intrinsics.checkNotNull(sequence);
            return sequence;
        }

        public final Sequence<c> l() {
            return SequencesKt.filter(this.d.e(), new C0349b());
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public HprofRecord.a.AbstractC0350a.C0351a b() {
            return this.d.a(getE(), this.e);
        }

        public final List<HprofRecord.a.AbstractC0350a.C0351a.b> n() {
            return this.d.a(this.e);
        }

        public final List<HprofRecord.a.AbstractC0350a.C0351a.C0352a> o() {
            return this.d.b(this.e);
        }

        public final String a(HprofRecord.a.AbstractC0350a.C0351a.C0352a fieldRecord) {
            Intrinsics.checkNotNullParameter(fieldRecord, "fieldRecord");
            return this.d.a(getE(), fieldRecord);
        }

        public final Sequence<HeapField> p() {
            return SequencesKt.map(CollectionsKt.asSequence(n()), new c());
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$b$c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapField;", "fieldRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class c extends Lambda implements Function1<HprofRecord.a.AbstractC0350a.C0351a.b, HeapField> {
            c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final HeapField invoke(HprofRecord.a.AbstractC0350a.C0351a.b fieldRecord) {
                Intrinsics.checkNotNullParameter(fieldRecord, "fieldRecord");
                b bVar = b.this;
                return new HeapField(bVar, bVar.d.a(b.this.getE(), fieldRecord), new HeapValue(b.this.d, fieldRecord.b));
            }
        }

        public final HeapField a(String fieldName) {
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            for (HprofRecord.a.AbstractC0350a.C0351a.b bVar : n()) {
                if (Intrinsics.areEqual(this.d.a(getE(), bVar), fieldName)) {
                    return new HeapField(this, fieldName, new HeapValue(this.d, bVar.b));
                }
            }
            return null;
        }

        public final HeapField b(String fieldName) {
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            return a(fieldName);
        }

        public String toString() {
            return "class " + f();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cH\u0086\u0002J#\u0010(\u001a\u0004\u0018\u00010)2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u0010+\u001a\u00020\u001cH\u0086\u0002J\u0011\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0015H\u0086\u0004J\u0011\u0010/\u001a\u00020\"2\u0006\u00101\u001a\u00020\u001cH\u0086\u0004J\u0015\u0010/\u001a\u00020\"2\n\u00100\u001a\u0006\u0012\u0002\b\u00030-H\u0086\u0004J\b\u00102\u001a\u0004\u0018\u00010\u001cJ\u0018\u00103\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cJ \u00103\u001a\u0004\u0018\u00010)2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u0010+\u001a\u00020\u001cJ\f\u00104\u001a\b\u0012\u0004\u0012\u00020)05J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001cH\u0016R\u0011\u0010\u000b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u0014\u0010&\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\r¨\u00069"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "hprofGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;", "indexedObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "objectId", "", "objectIndex", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;JI)V", "byteSize", "getByteSize", "()I", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getIndexedObject$memleaksdk_release", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "instanceClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getInstanceClass", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "instanceClassId", "getInstanceClassId", "()J", "instanceClassName", "", "getInstanceClassName", "()Ljava/lang/String;", "instanceClassSimpleName", "getInstanceClassSimpleName", "isPrimitiveWrapper", "", "()Z", "getObjectId", "getObjectIndex", "recordSize", "getRecordSize", "get", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapField;", "declaringClassName", "fieldName", "declaringClass", "Lkotlin/reflect/KClass;", "", "instanceOf", "expectedClass", "className", "readAsJavaString", "readField", "readFields", "Lkotlin/sequences/Sequence;", "readRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "toString", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class c extends HeapObject {
        public final cm.b c;
        private final HprofHeapGraph d;
        private final long e;
        private final int f;

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getE() {
            return this.e;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HprofHeapGraph hprofGraph, cm.b indexedObject, long j, int i) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(hprofGraph, "hprofGraph");
            Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
            this.d = hprofGraph;
            this.c = indexedObject;
            this.e = j;
            this.f = i;
        }

        public HeapGraph g() {
            return this.d;
        }

        public final String h() {
            return this.d.d(this.c.a);
        }

        public final b i() {
            HeapObject heapObjectA = this.d.a(this.c.a);
            if (heapObjectA != null) {
                return (b) heapObjectA;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.HeapObject.HeapClass");
        }

        public final long j() {
            return this.c.a;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public HprofRecord.a.AbstractC0350a.b b() {
            return this.d.a(getE(), this.c);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        public int c() {
            return (int) this.c.getC();
        }

        public final boolean a(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            Iterator<b> it = i().k().iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().f(), className)) {
                    return true;
                }
            }
            return false;
        }

        public final HeapField a(KClass<? extends Object> declaringClass, String fieldName) {
            Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            String name = JvmClassMappingKt.getJavaClass((KClass) declaringClass).getName();
            Intrinsics.checkNotNullExpressionValue(name, "declaringClass.java.name");
            return a(name, fieldName);
        }

        public final HeapField a(String declaringClassName, String fieldName) {
            HeapField next;
            Intrinsics.checkNotNullParameter(declaringClassName, "declaringClassName");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            Iterator<HeapField> it = l().iterator();
            while (it.hasNext()) {
                next = it.next();
                HeapField heapField = next;
                if (Intrinsics.areEqual(heapField.a.f(), declaringClassName) && Intrinsics.areEqual(heapField.b, fieldName)) {
                    return next;
                }
            }
            next = null;
            return next;
        }

        public final HeapField b(KClass<? extends Object> declaringClass, String fieldName) {
            Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            return a(declaringClass, fieldName);
        }

        public final HeapField b(String declaringClassName, String fieldName) {
            Intrinsics.checkNotNullParameter(declaringClassName, "declaringClassName");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            return a(declaringClassName, fieldName);
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$c$b */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader;", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class b extends Lambda implements Function0<ci> {
            b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ci invoke() {
                return c.this.d.a(c.this.b());
            }
        }

        public final Sequence<HeapField> l() {
            return SequencesKt.flatten(SequencesKt.map(i().k(), new a(LazyKt.lazy(new b()), null)));
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$c$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapField;", "heapClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class a extends Lambda implements Function1<b, Sequence<? extends HeapField>> {
            final /* synthetic */ Lazy b;
            final /* synthetic */ KProperty c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Lazy lazy, KProperty kProperty) {
                super(1);
                this.b = lazy;
                this.c = kProperty;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Sequence<HeapField> invoke(final b heapClass) {
                Intrinsics.checkNotNullParameter(heapClass, "heapClass");
                return SequencesKt.map(CollectionsKt.asSequence(heapClass.o()), new Function1<HprofRecord.a.AbstractC0350a.C0351a.C0352a, HeapField>() { // from class: com.efs.sdk.memleaksdk.monitor.internal.av.c.a.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final HeapField invoke(HprofRecord.a.AbstractC0350a.C0351a.C0352a fieldRecord) {
                        Intrinsics.checkNotNullParameter(fieldRecord, "fieldRecord");
                        return new HeapField(heapClass, c.this.d.a(heapClass.getE(), fieldRecord), new HeapValue(c.this.d, ((ci) a.this.b.getValue()).a(fieldRecord)));
                    }
                });
            }
        }

        public final String m() {
            char[] cArrCopyOfRange;
            int iIntValue;
            HeapValue heapValue;
            HeapValue heapValue2;
            Integer numB = null;
            if (!Intrinsics.areEqual(h(), "java.lang.String")) {
                return null;
            }
            HeapField heapFieldB = b("java.lang.String", "count");
            Integer numB2 = (heapFieldB == null || (heapValue2 = heapFieldB.c) == null) ? null : heapValue2.b();
            if (numB2 != null && numB2.intValue() == 0) {
                return "";
            }
            HeapField heapFieldB2 = b("java.lang.String", f.a.d);
            Intrinsics.checkNotNull(heapFieldB2);
            HeapObject heapObjectF = heapFieldB2.c.f();
            Intrinsics.checkNotNull(heapObjectF);
            HprofRecord.a.AbstractC0350a abstractC0350aB = heapObjectF.b();
            if (abstractC0350aB instanceof HprofRecord.a.AbstractC0350a.d.c) {
                HeapField heapFieldB3 = b("java.lang.String", "offset");
                if (heapFieldB3 != null && (heapValue = heapFieldB3.c) != null) {
                    numB = heapValue.b();
                }
                if (numB2 != null && numB != null) {
                    HprofRecord.a.AbstractC0350a.d.c cVar = (HprofRecord.a.AbstractC0350a.d.c) abstractC0350aB;
                    if (numB.intValue() + numB2.intValue() > cVar.a.length) {
                        iIntValue = cVar.a.length;
                    } else {
                        iIntValue = numB2.intValue() + numB.intValue();
                    }
                    cArrCopyOfRange = ArraysKt.copyOfRange(cVar.a, numB.intValue(), iIntValue);
                } else {
                    cArrCopyOfRange = ((HprofRecord.a.AbstractC0350a.d.c) abstractC0350aB).a;
                }
                return new String(cArrCopyOfRange);
            }
            if (!(abstractC0350aB instanceof HprofRecord.a.AbstractC0350a.d.b)) {
                StringBuilder sb = new StringBuilder("'value' field ");
                HeapField heapFieldB4 = b("java.lang.String", f.a.d);
                Intrinsics.checkNotNull(heapFieldB4);
                throw new UnsupportedOperationException(sb.append(heapFieldB4.c).append(" was expected to be either a char or byte array in string instance with id ").append(getE()).toString());
            }
            byte[] bArr = ((HprofRecord.a.AbstractC0350a.d.b) abstractC0350aB).a;
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
            return new String(bArr, charsetForName);
        }

        public String toString() {
            return "instance @" + getE() + " of " + h();
        }

        public final boolean f() {
            return HeapObject.a.contains(h());
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010!\u001a\u00020\tJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006("}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "hprofGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;", "indexedObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;", "objectId", "", "objectIndex", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;JI)V", "arrayClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getArrayClass", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "arrayClassSimpleName", "getArrayClassSimpleName", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getIndexedObject$memleaksdk_release", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;", "getObjectId", "()J", "getObjectIndex", "()I", "recordSize", "getRecordSize", "readByteSize", "readElements", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapValue;", "readRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "toString", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class d extends HeapObject {
        private final HprofHeapGraph c;
        private final cm.c d;
        private final long e;
        private final int f;

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getE() {
            return this.e;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HprofHeapGraph hprofGraph, cm.c indexedObject, long j, int i) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(hprofGraph, "hprofGraph");
            Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
            this.c = hprofGraph;
            this.d = indexedObject;
            this.e = j;
            this.f = i;
        }

        public final String f() {
            return this.c.d(this.d.a);
        }

        public final int g() {
            return this.c.b(getE(), this.d);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public HprofRecord.a.AbstractC0350a.c b() {
            return this.c.a(getE(), this.d);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        public int c() {
            return (int) this.d.getC();
        }

        public String toString() {
            return "object array @" + getE() + " of " + f();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001a¨\u0006%"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "hprofGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;", "indexedObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;", "objectId", "", "objectIndex", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;JI)V", "arrayClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getArrayClass", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getObjectId", "()J", "getObjectIndex", "()I", "primitiveType", "Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "getPrimitiveType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "recordSize", "getRecordSize", "readByteSize", "readRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "toString", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class e extends HeapObject {
        private final HprofHeapGraph c;
        private final cm.d d;
        private final long e;
        private final int f;

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getE() {
            return this.e;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(HprofHeapGraph hprofGraph, cm.d indexedObject, long j, int i) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(hprofGraph, "hprofGraph");
            Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
            this.c = hprofGraph;
            this.d = indexedObject;
            this.e = j;
            this.f = i;
        }

        public final int f() {
            return this.c.b(getE(), this.d);
        }

        public final String g() {
            StringBuilder sb = new StringBuilder();
            String strName = this.d.c().name();
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return sb.append(lowerCase).append("[]").toString();
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public HprofRecord.a.AbstractC0350a.d b() {
            return this.c.a(getE(), this.d);
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapObject
        public int c() {
            return (int) this.d.getC();
        }

        public String toString() {
            return "primitive array @" + getE() + " of " + g();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.av$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$Companion;", "", "()V", "primitiveTypesByPrimitiveArrayClassName", "", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "getPrimitiveTypesByPrimitiveArrayClassName$memleaksdk_release", "()Ljava/util/Map;", "primitiveWrapperClassNames", "", "classSimpleName", "className", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        PrimitiveType[] primitiveTypeArrValues = PrimitiveType.values();
        ArrayList arrayList = new ArrayList(primitiveTypeArrValues.length);
        for (PrimitiveType primitiveType : primitiveTypeArrValues) {
            StringBuilder sb = new StringBuilder();
            String strName = primitiveType.name();
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            arrayList.add(TuplesKt.to(sb.append(lowerCase).append("[]").toString(), primitiveType));
        }
        c = MapsKt.toMap(arrayList);
        String name = Boolean.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Boolean::class.javaObjectType.name");
        String name2 = Character.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "Char::class.javaObjectType.name");
        String name3 = Float.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "Float::class.javaObjectType.name");
        String name4 = Double.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "Double::class.javaObjectType.name");
        String name5 = Byte.class.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "Byte::class.javaObjectType.name");
        String name6 = Short.class.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "Short::class.javaObjectType.name");
        String name7 = Integer.class.getName();
        Intrinsics.checkNotNullExpressionValue(name7, "Int::class.javaObjectType.name");
        String name8 = Long.class.getName();
        Intrinsics.checkNotNullExpressionValue(name8, "Long::class.javaObjectType.name");
        a = SetsKt.setOf((Object[]) new String[]{name, name2, name3, name4, name5, name6, name7, name8});
    }
}
