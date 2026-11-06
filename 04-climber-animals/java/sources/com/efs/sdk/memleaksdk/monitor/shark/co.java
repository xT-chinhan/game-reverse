package com.efs.sdk.memleaksdk.monitor.shark;

import com.taptap.sdk.db.constant.Common;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0004@ABCB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#0\u0007H\u0002J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007*\u00020\u00182\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0014\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\f\u0010-\u001a\u00020)*\u00020*H\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020*H\u0002J\u0014\u0010.\u001a\u00020\u000b*\u00020\u00032\u0006\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\u00020,*\u00020*H\u0002J \u00102\u001a\b\u0012\u0004\u0012\u00020403*\u00020!2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007H\u0002J\u0012\u00106\u001a\u000207*\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\u001c\u00108\u001a\u00020)*\u00020*2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020,H\u0002J\u001c\u0010;\u001a\u00020)*\u00020*2\u0006\u0010<\u001a\u00020!2\u0006\u0010:\u001a\u00020,H\u0002J\u001c\u0010=\u001a\u00020)*\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010:\u001a\u00020,H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "listener", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;Ljava/util/List;)V", "SAME_INSTANCE_THRESHOLD", "", "fieldNameByClassName", "", "", "instanceCountMap", "", "", "", "jniGlobalReferenceMatchers", "staticFieldNameByClassName", "threadNameReferenceMatchers", "determineSizeOfObjectInstances", "objectClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "findPathsFromGcRoots", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$PathFindingResults;", "leakingObjectIds", "", "computeRetainedHeapSize", "", "isOverThresholdInstance", "graphObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "sortedGcRoots", "Lkotlin/Pair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "classHierarchyWithoutJavaLangObject", "javaLangObjectId", "enqueue", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$State;", "node", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "enqueueGcRoots", "getRecordSize", "field", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "poll", "readAllNonNullFieldsOfReferenceType", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$InstanceRefField;", "classHierarchy", "toLongScatterSet", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "visitClassRecord", "heapClass", "parent", "visitInstance", "instance", "visitObjectArray", "objectArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "InstanceRefField", "PathFindingResults", "State", "VisitTracker", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class co {
    private final Map<String, Map<String, ReferenceMatcher>> a;
    private final Map<String, Map<String, ReferenceMatcher>> b;
    private final Map<String, ReferenceMatcher> c;
    private final Map<String, ReferenceMatcher> d;
    private final int e;
    private Map<Long, Short> f;
    private final HeapGraph g;
    private final OnAnalysisProgressListener h;

    public co(HeapGraph graph, OnAnalysisProgressListener listener, List<? extends ReferenceMatcher> referenceMatchers) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(referenceMatchers, "referenceMatchers");
        this.g = graph;
        this.h = listener;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        ArrayList<ReferenceMatcher> arrayList = new ArrayList();
        for (Object obj : referenceMatchers) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) obj;
            if ((referenceMatcher instanceof IgnoredReferenceMatcher) || ((referenceMatcher instanceof LibraryLeakReferenceMatcher) && ((LibraryLeakReferenceMatcher) referenceMatcher).b.invoke(this.g).booleanValue())) {
                arrayList.add(obj);
            }
        }
        for (ReferenceMatcher referenceMatcher2 : arrayList) {
            ReferencePattern a2 = referenceMatcher2.getA();
            if (a2 instanceof ReferencePattern.c) {
                linkedHashMap3.put(((ReferencePattern.c) a2).b, referenceMatcher2);
            } else if (a2 instanceof ReferencePattern.e) {
                ReferencePattern.e eVar = (ReferencePattern.e) a2;
                LinkedHashMap linkedHashMap5 = (Map) linkedHashMap2.get(eVar.b);
                if (linkedHashMap5 == null) {
                    linkedHashMap5 = new LinkedHashMap();
                    linkedHashMap2.put(eVar.b, linkedHashMap5);
                }
                linkedHashMap5.put(eVar.c, referenceMatcher2);
            } else if (a2 instanceof ReferencePattern.b) {
                ReferencePattern.b bVar = (ReferencePattern.b) a2;
                LinkedHashMap linkedHashMap6 = (Map) linkedHashMap.get(bVar.b);
                if (linkedHashMap6 == null) {
                    linkedHashMap6 = new LinkedHashMap();
                    linkedHashMap.put(bVar.b, linkedHashMap6);
                }
                linkedHashMap6.put(bVar.c, referenceMatcher2);
            } else if (a2 instanceof ReferencePattern.d) {
                linkedHashMap4.put(((ReferencePattern.d) a2).b, referenceMatcher2);
            }
        }
        this.a = linkedHashMap;
        this.b = linkedHashMap2;
        this.c = linkedHashMap3;
        this.d = linkedHashMap4;
        this.e = 1024;
        this.f = new LinkedHashMap();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$PathFindingResults;", "", "pathsToLeakingObjects", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "dominatorTree", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "(Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;)V", "getDominatorTree", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "getPathsToLeakingObjects", "()Ljava/util/List;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {
        public final List<cq> a;
        public final cg b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends cq> pathsToLeakingObjects, cg cgVar) {
            Intrinsics.checkNotNullParameter(pathsToLeakingObjects, "pathsToLeakingObjects");
            this.a = pathsToLeakingObjects;
            this.b = cgVar;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "", "()V", "visited", "", "objectId", "", "parentObjectId", "Dominated", "Visited", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Dominated;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Visited;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class d {
        public abstract boolean a(long j, long j2);

        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Dominated;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "dominatorTree", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "getDominatorTree", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "visited", "", "objectId", "", "parentObjectId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a extends d {
            final cg a;

            public a(int i) {
                super((byte) 0);
                this.a = new cg(i);
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.co.d
            public boolean a(long j, long j2) {
                return this.a.a(j, j2);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Visited;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "visitedSet", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "visited", "", "objectId", "", "parentObjectId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class b extends d {
            private final dd a;

            public b(int i) {
                super((byte) 0);
                this.a = new dd(i);
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.co.d
            public boolean a(long j, long j2) {
                return !this.a.a(j);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 4, 1})
    public static final class h<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((a) t).c, ((a) t2).c);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$State;", "", "leakingObjectIds", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "sizeOfObjectInstances", "", "computeRetainedHeapSize", "", "javaLangObjectId", "", "estimatedVisitedObjects", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;IZJI)V", "getComputeRetainedHeapSize", "()Z", "getJavaLangObjectId", "()J", "getLeakingObjectIds", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "queuesNotEmpty", "getQueuesNotEmpty", "getSizeOfObjectInstances", "()I", "toVisitLastQueue", "Ljava/util/Deque;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "getToVisitLastQueue", "()Ljava/util/Deque;", "toVisitLastSet", "getToVisitLastSet", "toVisitQueue", "getToVisitQueue", "toVisitSet", "getToVisitSet", "visitTracker", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "getVisitTracker", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "visitingLast", "getVisitingLast", "setVisitingLast", "(Z)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    static final class c {
        final Deque<cq> a;
        final Deque<cq> b;
        final dd c;
        final dd d;
        final d e;
        boolean f;
        final dd g;
        final int h;
        final boolean i;
        final long j;

        public c(dd leakingObjectIds, int i, boolean z, long j, int i2) {
            d.b bVar;
            Intrinsics.checkNotNullParameter(leakingObjectIds, "leakingObjectIds");
            this.g = leakingObjectIds;
            this.h = i;
            this.i = z;
            this.j = j;
            this.a = new ArrayDeque();
            this.b = new ArrayDeque();
            this.c = new dd(0, 1);
            this.d = new dd(0, 1);
            if (z) {
                bVar = new d.a(i2);
            } else {
                bVar = new d.b(i2);
            }
            this.e = bVar;
        }

        public final boolean a() {
            return (this.a.isEmpty() ^ true) || (this.b.isEmpty() ^ true);
        }
    }

    public final b a(Set<Long> leakingObjectIds, boolean z) {
        Intrinsics.checkNotNullParameter(leakingObjectIds, "leakingObjectIds");
        this.h.a(OnAnalysisProgressListener.b.FINDING_PATHS_TO_RETAINED_OBJECTS);
        HeapObject.b bVarA = this.g.a("java.lang.Object");
        return a(new c(a(leakingObjectIds), a(bVarA, this.g), z, bVarA != null ? bVarA.getE() : -1L, RangesKt.coerceAtLeast(this.g.c() / 2, 4)));
    }

    private final int a(HeapObject.b bVar, HeapGraph heapGraph) {
        if (bVar == null) {
            return 0;
        }
        int i = bVar.i();
        int iA = heapGraph.a() + PrimitiveType.INT.j;
        if (i == iA) {
            return iA;
        }
        return 0;
    }

    private final dd a(Set<Long> set) {
        dd ddVar = new dd(0, 1);
        ddVar.a(set.size());
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            ddVar.a(((Number) it.next()).longValue());
        }
        return ddVar;
    }

    private final b a(c cVar) {
        c(cVar);
        ArrayList arrayList = new ArrayList();
        while (cVar.a()) {
            cq cqVarB = b(cVar);
            if (cVar.g.b(cqVarB.getA())) {
                arrayList.add(cqVarB);
                if (arrayList.size() == cVar.g.a()) {
                    if (!cVar.i) {
                        break;
                    }
                    this.h.a(OnAnalysisProgressListener.b.FINDING_DOMINATORS);
                }
            }
            HeapObject heapObjectA = this.g.a(cqVarB.getA());
            if (heapObjectA instanceof HeapObject.b) {
                a(cVar, (HeapObject.b) heapObjectA, cqVarB);
            } else if (heapObjectA instanceof HeapObject.c) {
                a(cVar, (HeapObject.c) heapObjectA, cqVarB);
            } else if (heapObjectA instanceof HeapObject.d) {
                a(cVar, (HeapObject.d) heapObjectA, cqVarB);
            }
        }
        return new b(arrayList, cVar.e instanceof d.a ? ((d.a) cVar.e).a : null);
    }

    private final void c(c cVar) {
        cq.a bVar;
        ReferenceMatcher referenceMatcher;
        List<Pair<HeapObject, GcRoot>> listA = a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            HeapObject heapObject = (HeapObject) pair.component1();
            GcRoot gcRoot = (GcRoot) pair.component2();
            if (gcRoot instanceof GcRoot.m) {
                Integer numValueOf = Integer.valueOf(((GcRoot.m) gcRoot).a);
                HeapObject.c cVarE = heapObject.e();
                Intrinsics.checkNotNull(cVarE);
                linkedHashMap2.put(numValueOf, TuplesKt.to(cVarE, gcRoot));
                a(cVar, new cq.c.b(gcRoot.getA(), gcRoot));
            } else if (gcRoot instanceof GcRoot.d) {
                Pair pair2 = (Pair) linkedHashMap2.get(Integer.valueOf(((GcRoot.d) gcRoot).a));
                if (pair2 == null) {
                    a(cVar, new cq.c.b(gcRoot.getA(), gcRoot));
                } else {
                    HeapObject.c cVar2 = (HeapObject.c) pair2.component1();
                    GcRoot.m mVar = (GcRoot.m) pair2.component2();
                    String strInvoke = (String) linkedHashMap.get(cVar2);
                    if (strInvoke == null) {
                        strInvoke = new e(cVar2, this, cVar, linkedHashMap2, linkedHashMap).invoke();
                    }
                    ReferenceMatcher referenceMatcher2 = this.c.get(strInvoke);
                    if (!(referenceMatcher2 instanceof IgnoredReferenceMatcher)) {
                        cq.c.b bVar2 = new cq.c.b(mVar.getA(), gcRoot);
                        LeakTraceReference.b bVar3 = LeakTraceReference.b.LOCAL;
                        if (referenceMatcher2 instanceof LibraryLeakReferenceMatcher) {
                            bVar = new cq.a.C0356a(gcRoot.getA(), bVar2, bVar3, "", (LibraryLeakReferenceMatcher) referenceMatcher2, 0L, 32);
                        } else {
                            bVar = new cq.a.b(gcRoot.getA(), bVar2, bVar3, "", 0L, 16);
                        }
                        a(cVar, bVar);
                    }
                }
            } else if (gcRoot instanceof GcRoot.e) {
                if (heapObject instanceof HeapObject.b) {
                    referenceMatcher = this.d.get(((HeapObject.b) heapObject).f());
                } else if (heapObject instanceof HeapObject.c) {
                    referenceMatcher = this.d.get(((HeapObject.c) heapObject).h());
                } else if (heapObject instanceof HeapObject.d) {
                    referenceMatcher = this.d.get(((HeapObject.d) heapObject).f());
                } else {
                    if (!(heapObject instanceof HeapObject.e)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    referenceMatcher = this.d.get(((HeapObject.e) heapObject).g());
                }
                if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                    if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                        a(cVar, new cq.c.a(gcRoot.getA(), gcRoot, (LibraryLeakReferenceMatcher) referenceMatcher));
                    } else {
                        a(cVar, new cq.c.b(gcRoot.getA(), gcRoot));
                    }
                }
            } else {
                a(cVar, new cq.c.b(gcRoot.getA(), gcRoot));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$enqueueGcRoots$1$threadName$1"}, k = 3, mv = {1, 4, 1})
    static final class e extends Lambda implements Function0<String> {
        final /* synthetic */ HeapObject.c a;
        final /* synthetic */ co b;
        final /* synthetic */ c c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(HeapObject.c cVar, co coVar, c cVar2, Map map, Map map2) {
            super(0);
            this.a = cVar;
            this.b = coVar;
            this.c = cVar2;
            this.d = map;
            this.e = map2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            String strG;
            HeapValue heapValue;
            HeapField heapFieldB = this.a.b(Reflection.getOrCreateKotlinClass(Thread.class), Common.System.NAME);
            if (heapFieldB == null || (heapValue = heapFieldB.c) == null || (strG = heapValue.g()) == null) {
                strG = "";
            }
            this.e.put(this.a, strG);
            return strG;
        }
    }

    private final List<Pair<HeapObject, GcRoot>> a() {
        g gVar = g.a;
        List<GcRoot> listD = this.g.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listD) {
            if (this.g.c(((GcRoot) obj).getA())) {
                arrayList.add(obj);
            }
        }
        ArrayList<GcRoot> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (GcRoot gcRoot : arrayList2) {
            arrayList3.add(TuplesKt.to(this.g.a(gcRoot.getA()), gcRoot));
        }
        return CollectionsKt.sortedWith(arrayList3, new f(gVar));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "graphObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class g extends Lambda implements Function1<HeapObject, String> {
        public static final g a = new g();

        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(HeapObject graphObject) {
            Intrinsics.checkNotNullParameter(graphObject, "graphObject");
            if (graphObject instanceof HeapObject.b) {
                return ((HeapObject.b) graphObject).f();
            }
            if (graphObject instanceof HeapObject.c) {
                return ((HeapObject.c) graphObject).h();
            }
            if (graphObject instanceof HeapObject.d) {
                return ((HeapObject.d) graphObject).f();
            }
            if (graphObject instanceof HeapObject.e) {
                return ((HeapObject.e) graphObject).g();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u00032&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 1>", "compare"}, k = 3, mv = {1, 4, 1})
    static final class f<T> implements Comparator<Pair<? extends HeapObject, ? extends GcRoot>> {
        final /* synthetic */ Function1 a;

        f(Function1 function1) {
            this.a = function1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(Pair<? extends HeapObject, ? extends GcRoot> pair, Pair<? extends HeapObject, ? extends GcRoot> pair2) {
            HeapObject heapObjectComponent1 = pair.component1();
            GcRoot gcRootComponent2 = pair.component2();
            HeapObject heapObjectComponent2 = pair2.component1();
            String name = pair2.component2().getClass().getName();
            String name2 = gcRootComponent2.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "root1::class.java.name");
            int iCompareTo = name.compareTo(name2);
            return iCompareTo != 0 ? iCompareTo : ((String) this.a.invoke(heapObjectComponent1)).compareTo((String) this.a.invoke(heapObjectComponent2));
        }
    }

    private final void a(c cVar, HeapObject.b bVar, cq cqVar) {
        cq.a.C0356a c0356a;
        Map<String, ReferenceMatcher> mapEmptyMap = this.b.get(bVar.f());
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        for (HeapField heapField : bVar.p()) {
            if (heapField.c.e()) {
                String str = heapField.b;
                if (!Intrinsics.areEqual(str, "$staticOverhead") && !Intrinsics.areEqual(str, "$classOverhead")) {
                    ValueHolder valueHolder = heapField.c.a;
                    if (valueHolder == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.ValueHolder.ReferenceHolder");
                    }
                    long j = ((ValueHolder.i) valueHolder).b;
                    ReferenceMatcher referenceMatcher = mapEmptyMap.get(str);
                    if (referenceMatcher == null) {
                        c0356a = new cq.a.b(j, cqVar, LeakTraceReference.b.STATIC_FIELD, str, 0L, 16);
                    } else if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                        c0356a = new cq.a.C0356a(j, cqVar, LeakTraceReference.b.STATIC_FIELD, str, (LibraryLeakReferenceMatcher) referenceMatcher, 0L, 32);
                    } else {
                        if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        c0356a = null;
                    }
                    if (c0356a != null) {
                        a(cVar, c0356a);
                    }
                }
            }
        }
    }

    private final void a(c cVar, HeapObject.c cVar2, cq cqVar) {
        cq.a.C0356a c0356a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<HeapObject.b> it = cVar2.i().k().iterator();
        while (it.hasNext()) {
            Map<String, ReferenceMatcher> map = this.a.get(it.next().f());
            if (map != null) {
                for (Map.Entry<String, ReferenceMatcher> entry : map.entrySet()) {
                    String key = entry.getKey();
                    ReferenceMatcher value = entry.getValue();
                    if (!linkedHashMap.containsKey(key)) {
                        linkedHashMap.put(key, value);
                    }
                }
            }
        }
        List<a> listA = a(cVar2, a(cVar2.i(), cVar.j));
        if (listA.size() > 1) {
            CollectionsKt.sortWith(listA, new h());
        }
        for (a aVar : listA) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) linkedHashMap.get(aVar.c);
            if (referenceMatcher == null) {
                c0356a = new cq.a.b(aVar.b, cqVar, LeakTraceReference.b.INSTANCE_FIELD, aVar.c, aVar.a);
            } else if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                c0356a = new cq.a.C0356a(aVar.b, cqVar, LeakTraceReference.b.INSTANCE_FIELD, aVar.c, (LibraryLeakReferenceMatcher) referenceMatcher, aVar.a);
            } else {
                if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                    throw new NoWhenBranchMatchedException();
                }
                c0356a = null;
            }
            if (c0356a != null) {
                a(cVar, c0356a);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$InstanceRefField;", "", "declaringClassId", "", "refObjectId", "fieldName", "", "(JJLjava/lang/String;)V", "getDeclaringClassId", "()J", "getFieldName", "()Ljava/lang/String;", "getRefObjectId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    static final class a {
        final long a;
        final long b;
        final String c;

        public a(long j, long j2, String fieldName) {
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            this.a = j;
            this.b = j2;
            this.c = fieldName;
        }
    }

    private final List<a> a(HeapObject.c cVar, List<HeapObject.b> list) {
        HeapGraph heapGraphG = cVar.g();
        ch chVar = null;
        ArrayList arrayList = new ArrayList();
        int iA = 0;
        for (HeapObject.b bVar : list) {
            for (HprofRecord.a.AbstractC0350a.C0351a.C0352a c0352a : bVar.o()) {
                if (c0352a.b != 2) {
                    iA += a(heapGraphG, c0352a);
                } else {
                    if (chVar == null) {
                        chVar = new ch(cVar.b(), heapGraphG.a());
                    }
                    chVar.a(iA);
                    long jA = chVar.a();
                    if (jA != 0) {
                        arrayList.add(new a(bVar.getE(), jA, bVar.a(c0352a)));
                    }
                    iA = 0;
                }
            }
        }
        return arrayList;
    }

    private final List<HeapObject.b> a(HeapObject.b bVar, long j) {
        ArrayList arrayList = new ArrayList();
        while (bVar != null && bVar.getE() != j) {
            arrayList.add(bVar);
            bVar = bVar.j();
        }
        return arrayList;
    }

    private final void a(c cVar, HeapObject.d dVar, cq cqVar) {
        long[] jArr = dVar.b().a;
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            long j = jArr[i2];
            if (j != 0 && this.g.c(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        for (Object obj : arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            a(cVar, new cq.a.b(((Number) obj).longValue(), cqVar, LeakTraceReference.b.ARRAY_ENTRY, String.valueOf(i), 0L, 16));
            i = i3;
        }
    }

    private final boolean a(HeapObject.c cVar) {
        if (StringsKt.startsWith$default(cVar.h(), "java.util", false, 2, (Object) null) || StringsKt.startsWith$default(cVar.h(), "android.util", false, 2, (Object) null) || StringsKt.startsWith$default(cVar.h(), "java.lang.String", false, 2, (Object) null)) {
            return false;
        }
        Short sh = this.f.get(Long.valueOf(cVar.j()));
        if (sh == null) {
            sh = (short) 0;
        }
        if (sh.shortValue() < this.e) {
            this.f.put(Long.valueOf(cVar.j()), Short.valueOf((short) (sh.shortValue() + 1)));
        }
        return sh.shortValue() >= this.e;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f6  */
    private final void a(c cVar, cq cqVar) {
        boolean z;
        boolean z2;
        long a2 = 0;
        if (cqVar.getA() == 0) {
            return;
        }
        boolean z3 = false;
        if (cVar.f || (cqVar instanceof cq.b) || ((cqVar instanceof cq.c) && (((cq.c) cqVar).getB() instanceof GcRoot.m))) {
            z = true;
        } else {
            if (cqVar instanceof cq.a.b) {
                cq.a.b bVar = (cq.a.b) cqVar;
                if ((bVar.getB() instanceof cq.c) && (((cq.c) bVar.getB()).getB() instanceof GcRoot.d)) {
                    z = true;
                }
            }
            z = false;
        }
        if (!(cqVar instanceof cq.c)) {
            if (cqVar != null) {
                a2 = ((cq.a) cqVar).getB().getA();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.internal.ReferencePathNode.ChildNode");
            }
        }
        boolean zA = cVar.e.a(cqVar.getA(), a2);
        if (zA && (z || cVar.c.b(cqVar.getA()) || !cVar.d.b(cqVar.getA()))) {
            return;
        }
        if (zA) {
            cVar.a.add(cqVar);
            cVar.c.a(cqVar.getA());
            for (cq cqVar2 : cVar.b) {
                if (cqVar2.getA() == cqVar.getA()) {
                    cVar.b.remove(cqVar2);
                    cVar.d.c(cqVar.getA());
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        if (!cVar.g.b(cqVar.getA())) {
            HeapObject heapObjectA = this.g.a(cqVar.getA());
            if (!(heapObjectA instanceof HeapObject.b)) {
                if (heapObjectA instanceof HeapObject.c) {
                    HeapObject.c cVar2 = (HeapObject.c) heapObjectA;
                    if (cVar2.f() || Intrinsics.areEqual(cVar2.h(), "java.lang.String") || cVar2.i().g() <= cVar.h) {
                        z3 = true;
                    } else {
                        Iterator<HeapObject.b> it = cVar2.i().k().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = true;
                                break;
                            }
                            HeapObject.b next = it.next();
                            if (!(next.getE() == cVar.j || !next.h())) {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2 || a(cVar2)) {
                            z3 = true;
                        }
                    }
                } else {
                    if (heapObjectA instanceof HeapObject.d) {
                        if (cp.a((HeapObject.d) heapObjectA)) {
                        }
                    } else if (!(heapObjectA instanceof HeapObject.e)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z3 = true;
                }
            }
            if (z3) {
                return;
            }
        }
        if (z) {
            cVar.b.add(cqVar);
            cVar.d.a(cqVar.getA());
        } else {
            cVar.a.add(cqVar);
            cVar.c.a(cqVar.getA());
        }
    }

    private final cq b(c cVar) {
        if (!cVar.f && !cVar.a.isEmpty()) {
            cq removedNode = cVar.a.poll();
            cVar.c.c(removedNode.getA());
            Intrinsics.checkNotNullExpressionValue(removedNode, "removedNode");
            return removedNode;
        }
        cVar.f = true;
        cq removedNode2 = cVar.b.poll();
        cVar.d.c(removedNode2.getA());
        Intrinsics.checkNotNullExpressionValue(removedNode2, "removedNode");
        return removedNode2;
    }

    private final int a(HeapGraph heapGraph, HprofRecord.a.AbstractC0350a.C0351a.C0352a c0352a) {
        int i = c0352a.b;
        if (i == 2) {
            return heapGraph.a();
        }
        if (i != PrimitiveType.BOOLEAN.i) {
            if (i == PrimitiveType.CHAR.i) {
                return 2;
            }
            if (i != PrimitiveType.FLOAT.i) {
                if (i != PrimitiveType.DOUBLE.i) {
                    if (i != PrimitiveType.BYTE.i) {
                        if (i == PrimitiveType.SHORT.i) {
                            return 2;
                        }
                        if (i != PrimitiveType.INT.i) {
                            if (i != PrimitiveType.LONG.i) {
                                throw new IllegalStateException("Unknown type " + c0352a.b);
                            }
                        }
                    }
                }
                return 8;
            }
            return 4;
        }
        return 1;
    }
}
