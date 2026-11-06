package com.efs.sdk.memleaksdk.monitor.shark;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 {2\u00020\u0001:\u0001{B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001f2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020C2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bDJ\u001b\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u001f2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000fH\u0000¢\u0006\u0002\bKJ\b\u0010L\u001a\u00020MH\u0016J\u0015\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ\u001d\u0010S\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020>H\u0000¢\u0006\u0002\bUJ\u0012\u0010V\u001a\u0004\u0018\u00010\u00172\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010W\u001a\u0002062\u0006\u0010X\u001a\u00020\u000fH\u0016J\u0012\u0010Y\u001a\u0004\u0018\u0001062\u0006\u0010X\u001a\u00020\u000fH\u0016J\u0010\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\nH\u0016J\u0006\u0010\\\u001a\u00020IJ\u0010\u0010]\u001a\u00020C2\u0006\u0010X\u001a\u00020\u000fH\u0016J\u001d\u0010^\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020@H\u0000¢\u0006\u0002\b`J\u001d\u0010a\u001a\u00020Q2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020bH\u0000¢\u0006\u0002\bcJ\u001d\u0010d\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020eH\u0000¢\u0006\u0002\bfJ\u001d\u0010g\u001a\u00020h2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020eH\u0000¢\u0006\u0002\biJ@\u0010j\u001a\u0002Hk\"\b\b\u0000\u0010k*\u0002022\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020l2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u0002Hk0n¢\u0006\u0002\bpH\u0002¢\u0006\u0002\u0010qJ\u001d\u0010r\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020sH\u0000¢\u0006\u0002\btJ\u001d\u0010u\u001a\u00020v2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020sH\u0000¢\u0006\u0002\bwJ\u001d\u0010x\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020FH\u0000¢\u0006\u0002\byJ \u0010z\u001a\u0002062\u0006\u0010[\u001a\u00020\n2\u0006\u0010_\u001a\u00020l2\u0006\u0010X\u001a\u00020\u000fH\u0002R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0019R\u0010\u0010*\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0019R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\fR\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0019R\u0014\u00108\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\fR\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph;", "Lcom/efs/sdk/memleaksdk/monitor/shark/CloseableHeapGraph;", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", com.umeng.ccg.a.H, "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;)V", "classCount", "", "getClassCount", "()I", "classMap", "", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "getClassMap", "()Ljava/util/Map;", "setClassMap", "(Ljava/util/Map;)V", "classes", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", com.umeng.analytics.pro.g.X, "Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "getContext", "()Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "gcRoots", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "getIdentifierByteSize", "instanceCount", "getInstanceCount", "instances", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "getInstances", "javaLangObjectClass", "objectArrayCount", "getObjectArrayCount", "objectArrays", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCache", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/LruCache;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "objectCount", "getObjectCount", "objects", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "getObjects", "primitiveArrayCount", "getPrimitiveArrayCount", "primitiveArrays", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "classDumpFields", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "indexedClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;", "classDumpFields$memleaksdk_release", "classDumpHasReferenceFields", "", "classDumpHasReferenceFields$memleaksdk_release", "classDumpStaticFields", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "classDumpStaticFields$memleaksdk_release", "className", "", "classId", "className$memleaksdk_release", ILivePush.ClickType.CLOSE, "", "createFieldValuesReader", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader;", "record", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "createFieldValuesReader$memleaksdk_release", "fieldName", "fieldRecord", "fieldName$memleaksdk_release", "findClassByName", "findObjectById", "objectId", "findObjectByIdOrNull", "findObjectByIndex", "objectIndex", "lruCacheStats", "objectExists", "readClassDumpRecord", "indexedObject", "readClassDumpRecord$memleaksdk_release", "readInstanceDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "readInstanceDumpRecord$memleaksdk_release", "readObjectArrayByteSize", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedObjectArray;", "readObjectArrayByteSize$memleaksdk_release", "readObjectArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArrayDumpRecord$memleaksdk_release", "readObjectRecord", "T", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject;", "readBlock", "Lkotlin/Function1;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lkotlin/ExtensionFunctionType;", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject;Lkotlin/jvm/functions/Function1;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "readPrimitiveArrayByteSize", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedPrimitiveArray;", "readPrimitiveArrayByteSize$memleaksdk_release", "readPrimitiveArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArrayDumpRecord$memleaksdk_release", "staticFieldName", "staticFieldName$memleaksdk_release", "wrapIndexedObject", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HprofHeapGraph implements CloseableHeapGraph {
    public static final a a = new a(0);
    private static int i = 3000;
    private final GraphContext b;
    private final cn<Long, HprofRecord.a.AbstractC0350a> c;
    private final HeapObject.b d;
    private Map<Long, HprofRecord.a.AbstractC0350a.C0351a> e;
    private final HprofHeader f;
    private final RandomAccessHprofReader g;
    private final cj h;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class e extends Lambda implements Function1<HprofRecordReader, Integer> {
        public static final e a = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Integer invoke(HprofRecordReader hprofRecordReader) {
            return Integer.valueOf(a(hprofRecordReader));
        }

        public final int a(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver.G();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$h */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class h extends Lambda implements Function1<HprofRecordReader, Integer> {
        public static final h a = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Integer invoke(HprofRecordReader hprofRecordReader) {
            return Integer.valueOf(a(hprofRecordReader));
        }

        public final int a(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver.G();
        }
    }

    public HprofHeapGraph(HprofHeader header, RandomAccessHprofReader reader, cj index) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(index, "index");
        this.f = header;
        this.g = reader;
        this.h = index;
        this.b = new GraphContext();
        this.c = new cn<>(i);
        this.d = a("java.lang.Object");
        this.e = new LinkedHashMap();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public int a() {
        return this.f.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    /* JADX INFO: renamed from: b, reason: from getter */
    public GraphContext getB() {
        return this.b;
    }

    public int f() {
        return this.h.a.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public int c() {
        return this.h.b.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public List<GcRoot> d() {
        return this.h.c;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public Sequence<HeapObject.c> e() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = f();
        return SequencesKt.map(this.h.a(), new b(intRef));
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public HeapObject a(long j) {
        HeapObject heapObjectB = b(j);
        if (heapObjectB != null) {
            return heapObjectB;
        }
        throw new IllegalArgumentException("Object id " + j + " not found in heap dump.");
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public HeapObject b(long j) {
        HeapObject.b bVar = this.d;
        if (bVar != null && j == bVar.getE()) {
            return this.d;
        }
        cy<cm> cyVarB = this.h.b(j);
        if (cyVarB != null) {
            return a(cyVarB.a, cyVarB.b, j);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public HeapObject.b a(String className) {
        int iIndexOf$default;
        Object obj;
        Intrinsics.checkNotNullParameter(className, "className");
        if (this.f.b != HprofVersion.ANDROID && (iIndexOf$default = StringsKt.indexOf$default((CharSequence) className, AbstractJsonLexerKt.BEGIN_LIST, 0, false, 6, (Object) null)) != -1) {
            int length = (className.length() - iIndexOf$default) / 2;
            String strSubstring = className.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            StringBuilder sbAppend = new StringBuilder().append(StringsKt.repeat("[", length));
            switch (strSubstring) {
                case "double":
                    obj = 'D';
                    break;
                case "int":
                    obj = 'I';
                    break;
                case "byte":
                    obj = 'B';
                    break;
                case "char":
                    obj = 'C';
                    break;
                case "long":
                    obj = 'J';
                    break;
                case "float":
                    obj = 'F';
                    break;
                case "short":
                    obj = 'S';
                    break;
                default:
                    obj = "L" + strSubstring + ';';
                    break;
            }
            className = sbAppend.append(obj).toString();
        }
        Long lA = this.h.a(className);
        if (lA == null) {
            return null;
        }
        HeapObject heapObjectA = a(lA.longValue());
        if (heapObjectA != null) {
            return (HeapObject.b) heapObjectA;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.HeapObject.HeapClass");
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.HeapGraph
    public boolean c(long j) {
        return this.h.c(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.close();
    }

    public final List<HprofRecord.a.AbstractC0350a.C0351a.b> a(cm.a indexedClass) {
        Intrinsics.checkNotNullParameter(indexedClass, "indexedClass");
        return this.h.d.a(indexedClass);
    }

    public final List<HprofRecord.a.AbstractC0350a.C0351a.C0352a> b(cm.a indexedClass) {
        Intrinsics.checkNotNullParameter(indexedClass, "indexedClass");
        return this.h.d.b(indexedClass);
    }

    public final boolean c(cm.a indexedClass) {
        Intrinsics.checkNotNullParameter(indexedClass, "indexedClass");
        return this.h.d.c(indexedClass);
    }

    public final String a(long j, HprofRecord.a.AbstractC0350a.C0351a.C0352a fieldRecord) {
        Intrinsics.checkNotNullParameter(fieldRecord, "fieldRecord");
        return this.h.a(j, fieldRecord.a);
    }

    public final String a(long j, HprofRecord.a.AbstractC0350a.C0351a.b fieldRecord) {
        Intrinsics.checkNotNullParameter(fieldRecord, "fieldRecord");
        return this.h.a(j, fieldRecord.a);
    }

    public final ci a(HprofRecord.a.AbstractC0350a.b record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return new ci(record, a());
    }

    public final String d(long j) {
        String strA = this.h.a(j);
        if (this.f.b == HprofVersion.ANDROID) {
            return strA;
        }
        String str = strA;
        if (!StringsKt.startsWith$default((CharSequence) str, AbstractJsonLexerKt.BEGIN_LIST, false, 2, (Object) null)) {
            return strA;
        }
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, AbstractJsonLexerKt.BEGIN_LIST, 0, false, 6, (Object) null);
        int i2 = iLastIndexOf$default + 1;
        String strRepeat = StringsKt.repeat("[]", i2);
        char cCharAt = strA.charAt(i2);
        if (cCharAt == 'F') {
            return "float" + strRepeat;
        }
        if (cCharAt == 'L') {
            int i3 = iLastIndexOf$default + 2;
            StringBuilder sb = new StringBuilder();
            int length = strA.length() - 1;
            if (strA == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strA.substring(i3, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return sb.append(strSubstring).append(strRepeat).toString();
        }
        if (cCharAt == 'S') {
            return "short" + strRepeat;
        }
        if (cCharAt == 'Z') {
            return "boolean" + strRepeat;
        }
        if (cCharAt == 'I') {
            return IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL + strRepeat;
        }
        if (cCharAt != 'J') {
            switch (cCharAt) {
                case 'B':
                    return "byte" + strRepeat;
                case 'C':
                    return "char" + strRepeat;
                case 'D':
                    return "double" + strRepeat;
                default:
                    throw new IllegalStateException(("Unexpected type char " + cCharAt).toString());
            }
        }
        return "long" + strRepeat;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$f */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class f extends Lambda implements Function1<HprofRecordReader, HprofRecord.a.AbstractC0350a.c> {
        public static final f a = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0350a.c invoke(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver.t();
        }
    }

    public final HprofRecord.a.AbstractC0350a.c a(long j, cm.c indexedObject) {
        Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
        return (HprofRecord.a.AbstractC0350a.c) a(j, indexedObject, f.a);
    }

    public final int b(long j, cm.c indexedObject) {
        int iIntValue;
        int iA;
        Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
        HprofRecord.a.AbstractC0350a.c cVar = (HprofRecord.a.AbstractC0350a.c) this.c.a(Long.valueOf(j));
        if (cVar != null) {
            iIntValue = cVar.a.length;
            iA = a();
        } else {
            iIntValue = ((Number) this.g.a(indexedObject.getB() + ((long) a()) + ((long) PrimitiveType.INT.j), PrimitiveType.INT.j, e.a)).intValue();
            iA = a();
        }
        return iIntValue * iA;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$i */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class i extends Lambda implements Function1<HprofRecordReader, HprofRecord.a.AbstractC0350a.d> {
        public static final i a = new i();

        i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0350a.d invoke(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver.s();
        }
    }

    public final HprofRecord.a.AbstractC0350a.d a(long j, cm.d indexedObject) {
        Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
        return (HprofRecord.a.AbstractC0350a.d) a(j, indexedObject, i.a);
    }

    public final int b(long j, cm.d indexedObject) {
        int length;
        int i2;
        Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
        HprofRecord.a.AbstractC0350a.d dVar = (HprofRecord.a.AbstractC0350a.d) this.c.a(Long.valueOf(j));
        if (dVar != null) {
            if (dVar instanceof HprofRecord.a.AbstractC0350a.d.C0353a) {
                length = ((HprofRecord.a.AbstractC0350a.d.C0353a) dVar).a.length;
                i2 = PrimitiveType.BOOLEAN.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.c) {
                length = ((HprofRecord.a.AbstractC0350a.d.c) dVar).a.length;
                i2 = PrimitiveType.CHAR.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.e) {
                length = ((HprofRecord.a.AbstractC0350a.d.e) dVar).a.length;
                i2 = PrimitiveType.FLOAT.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.C0354d) {
                length = ((HprofRecord.a.AbstractC0350a.d.C0354d) dVar).a.length;
                i2 = PrimitiveType.DOUBLE.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.b) {
                length = ((HprofRecord.a.AbstractC0350a.d.b) dVar).a.length;
                i2 = PrimitiveType.BYTE.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.h) {
                length = ((HprofRecord.a.AbstractC0350a.d.h) dVar).a.length;
                i2 = PrimitiveType.SHORT.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.f) {
                length = ((HprofRecord.a.AbstractC0350a.d.f) dVar).a.length;
                i2 = PrimitiveType.INT.j;
            } else if (dVar instanceof HprofRecord.a.AbstractC0350a.d.g) {
                length = ((HprofRecord.a.AbstractC0350a.d.g) dVar).a.length;
                i2 = PrimitiveType.LONG.j;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return length * i2;
        }
        return ((Number) this.g.a(indexedObject.getB() + ((long) a()) + ((long) PrimitiveType.INT.j), PrimitiveType.INT.j, h.a)).intValue() * indexedObject.c().j;
    }

    public final HprofRecord.a.AbstractC0350a.C0351a a(long j, cm.a indexedObject) {
        Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
        HprofRecord.a.AbstractC0350a.C0351a c0351a = this.e.get(Long.valueOf(j));
        if (c0351a != null) {
            return c0351a;
        }
        HprofRecord.a.AbstractC0350a.C0351a c0351a2 = (HprofRecord.a.AbstractC0350a.C0351a) a(j, indexedObject, c.a);
        this.e.put(Long.valueOf(j), c0351a2);
        return c0351a2;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class c extends Lambda implements Function1<HprofRecordReader, HprofRecord.a.AbstractC0350a.C0351a> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0350a.C0351a invoke(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver.r();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class d extends Lambda implements Function1<HprofRecordReader, HprofRecord.a.AbstractC0350a.b> {
        public static final d a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0350a.b invoke(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver.q();
        }
    }

    public final HprofRecord.a.AbstractC0350a.b a(long j, cm.b indexedObject) {
        Intrinsics.checkNotNullParameter(indexedObject, "indexedObject");
        return (HprofRecord.a.AbstractC0350a.b) a(j, indexedObject, d.a);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <T extends HprofRecord.a.AbstractC0350a> T a(long j, cm cmVar, Function1<? super HprofRecordReader, ? extends T> function1) {
        T t = (T) this.c.a(Long.valueOf(j));
        if (t != null) {
            return t;
        }
        T t2 = (T) this.g.a(cmVar.getB(), cmVar.getC(), new g(function1));
        this.c.a(Long.valueOf(j), t2);
        return t2;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$g */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "invoke", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;)Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord;"}, k = 3, mv = {1, 4, 1})
    static final class g<T> extends Lambda implements Function1<HprofRecordReader, T> {
        final /* synthetic */ Function1 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* JADX WARN: Incorrect return type in method signature: (Lcom/efs/sdk/memleaksdk/monitor/internal/bb;)TT; */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HprofRecord.a.AbstractC0350a invoke(HprofRecordReader receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (HprofRecord.a.AbstractC0350a) this.a.invoke(receiver);
        }
    }

    private final HeapObject a(int i2, cm cmVar, long j) {
        if (cmVar instanceof cm.a) {
            return new HeapObject.b(this, (cm.a) cmVar, j, i2);
        }
        if (cmVar instanceof cm.b) {
            return new HeapObject.c(this, (cm.b) cmVar, j, i2);
        }
        if (cmVar instanceof cm.c) {
            return new HeapObject.d(this, (cm.c) cmVar, j, i2);
        }
        if (cmVar instanceof cm.d) {
            return new HeapObject.e(this, (cm.d) cmVar, j, i2);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nH\u0002J4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nH\u0007J&\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\nJ&\u0010\u0014\u001a\u00020\u0015*\u00020\u00182\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeapGraph$Companion;", "", "()V", "INTERNAL_LRU_CACHE_SIZE", "", "getINTERNAL_LRU_CACHE_SIZE", "()I", "setINTERNAL_LRU_CACHE_SIZE", "(I)V", "deprecatedDefaultIndexedGcRootTypes", "", "Lkotlin/reflect/KClass;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "indexHprof", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "hprof", "Lcom/efs/sdk/memleaksdk/monitor/shark/Hprof;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "indexedGcRootTypes", "openHeapGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/CloseableHeapGraph;", "Lcom/efs/sdk/memleaksdk/monitor/shark/DualSourceProvider;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final CloseableHeapGraph a(File openHeapGraph, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> indexedGcRootTypes) {
            Intrinsics.checkNotNullParameter(openHeapGraph, "$this$openHeapGraph");
            Intrinsics.checkNotNullParameter(indexedGcRootTypes, "indexedGcRootTypes");
            return a(new FileSourceProvider(openHeapGraph), proguardMapping, indexedGcRootTypes);
        }

        public final CloseableHeapGraph a(DualSourceProvider openHeapGraph, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> indexedGcRootTypes) {
            Intrinsics.checkNotNullParameter(openHeapGraph, "$this$openHeapGraph");
            Intrinsics.checkNotNullParameter(indexedGcRootTypes, "indexedGcRootTypes");
            n nVarA = openHeapGraph.a();
            try {
                HprofHeader hprofHeaderA = HprofHeader.d.a(nVarA);
                CloseableKt.closeFinally(nVarA, null);
                return HprofIndex.a.a(openHeapGraph, hprofHeaderA, proguardMapping, indexedGcRootTypes).a();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(nVarA, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ay$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "it", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedInstance;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class b extends Lambda implements Function1<db<? extends cm.b>, HeapObject.c> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.IntRef intRef) {
            super(1);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HeapObject.c invoke(db<cm.b> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            long j = it.a;
            cm.b bVar = it.b;
            HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            intRef.element = i + 1;
            return new HeapObject.c(hprofHeapGraph, bVar, j, i);
        }
    }
}
