package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0005TUVWXB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JV\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J>\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001dH\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000eH\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eH\u0002J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0-H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J$\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/0\u001f2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0011H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001eH\u0002J.\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020'2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e2\u0006\u0010;\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J,\u0010<\u001a\u00020=*\u00020>2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00107\u001a\u00020\u001eH\u0002Jh\u0010?\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u000e0\u001f*\u00020>2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\u000e2\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u000e2 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001dH\u0002J.\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u000e*\u00020>2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u000e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eH\u0002JB\u0010I\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001d*\u00020>2\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u000e2\u0006\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020M*\u00020>2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001e0OJ(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e*\u00020>2\u0006\u0010Q\u001a\u00020R2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001e0OH\u0002J&\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u000e*\u00020>2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer;", "", "listener", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;)V", "analyze", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "leakingObjectFinder", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakingObjectFinder;", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectInspector;", "metadataExtractor", "Lcom/efs/sdk/memleaksdk/monitor/shark/MetadataExtractor;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "buildLeakTraceObjects", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "inspectedObjects", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$InspectedObject;", "retainedSizes", "", "", "Lkotlin/Pair;", "", "computeLeakStatuses", "leakReporters", "Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectReporter;", "deduplicateShortestPaths", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$ShortestPath;", "inputPathResults", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "findResultsInTrie", "", "parentNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "outputPathResults", "", "recordClassName", "", "heap", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "resolveStatus", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "reporter", "leakingWins", "since", "analysisStartNanoTime", "updateTrie", "pathNode", "path", "pathIndex", "analyzeGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalysisSuccess;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$FindLeakInput;", "buildLeakTraces", "Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "shortestPaths", "inspectedObjectsByPath", "buildReferencePath", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "shortestChildPath", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "leakTraceObjects", "computeRetainedSizes", "dominatorTree", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "findLeaks", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$LeaksAndUnreachableObjects;", "leakingObjectIds", "", "findUnreachableObjects", "pathFindingResults", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$PathFindingResults;", "inspectObjects", "FindLeakInput", "InspectedObject", "LeaksAndUnreachableObjects", "ShortestPath", "TrieNode", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalyzer {
    private final OnAnalysisProgressListener a;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$f */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", com.umeng.ccg.a.H, "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 1})
    static final class f extends Lambda implements Function1<Integer, Integer> {
        final /* synthetic */ Ref.IntRef a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Ref.IntRef intRef) {
            super(1);
            this.a = intRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Integer invoke(Integer num) {
            return a(num.intValue());
        }

        public final Integer a(int i) {
            if (i < this.a.element) {
                return Integer.valueOf(i + 1);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$g */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", com.umeng.ccg.a.H, "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 1})
    static final class g extends Lambda implements Function1<Integer, Integer> {
        final /* synthetic */ Ref.IntRef a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Ref.IntRef intRef) {
            super(1);
            this.a = intRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Integer invoke(Integer num) {
            return a(num.intValue());
        }

        public final Integer a(int i) {
            if (i > this.a.element) {
                return Integer.valueOf(i - 1);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$h */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "objectId", "", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class h extends Lambda implements Function1<Long, Integer> {
        final /* synthetic */ Map a;
        final /* synthetic */ cr b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Map map, cr crVar) {
            super(1);
            this.a = map;
            this.b = crVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Integer invoke(Long l) {
            return Integer.valueOf(a(l.longValue()));
        }

        public final int a(long j) {
            Integer num = (Integer) this.a.get(Long.valueOf(j));
            return (num != null ? num.intValue() : 0) + this.b.a(j);
        }
    }

    public HeapAnalyzer(OnAnalysisProgressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.a = listener;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$FindLeakInput;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectInspector;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;Ljava/util/List;ZLjava/util/List;)V", "getComputeRetainedHeapSize", "()Z", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getObjectInspectors", "()Ljava/util/List;", "getReferenceMatchers", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        final HeapGraph a;
        final List<ReferenceMatcher> b;
        final boolean c;
        final List<Object> d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(HeapGraph graph, List<? extends ReferenceMatcher> referenceMatchers, boolean z, List<? extends Object> objectInspectors) {
            Intrinsics.checkNotNullParameter(graph, "graph");
            Intrinsics.checkNotNullParameter(referenceMatchers, "referenceMatchers");
            Intrinsics.checkNotNullParameter(objectInspectors, "objectInspectors");
            this.a = graph;
            this.b = referenceMatchers;
            this.c = z;
            this.d = objectInspectors;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$LeaksAndUnreachableObjects;", "", "applicationLeaks", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "libraryLeaks", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "unreachableObjects", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getApplicationLeaks", "()Ljava/util/List;", "getLibraryLeaks", "getUnreachableObjects", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class c {
        public final List<ApplicationLeak> a;
        private final List<LibraryLeak> b;
        private final List<LeakTraceObject> c;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
        }

        public int hashCode() {
            List<ApplicationLeak> list = this.a;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<LibraryLeak> list2 = this.b;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<LeakTraceObject> list3 = this.c;
            return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            return "LeaksAndUnreachableObjects(applicationLeaks=" + this.a + ", libraryLeaks=" + this.b + ", unreachableObjects=" + this.c + ")";
        }

        public c(List<ApplicationLeak> applicationLeaks, List<LibraryLeak> libraryLeaks, List<LeakTraceObject> unreachableObjects) {
            Intrinsics.checkNotNullParameter(applicationLeaks, "applicationLeaks");
            Intrinsics.checkNotNullParameter(libraryLeaks, "libraryLeaks");
            Intrinsics.checkNotNullParameter(unreachableObjects, "unreachableObjects");
            this.a = applicationLeaks;
            this.b = libraryLeaks;
            this.c = unreachableObjects;
        }
    }

    public final c a(a findLeaks, Set<Long> leakingObjectIds) {
        Intrinsics.checkNotNullParameter(findLeaks, "$this$findLeaks");
        Intrinsics.checkNotNullParameter(leakingObjectIds, "leakingObjectIds");
        co.b bVarA = new co(findLeaks.a, this.a, findLeaks.b).a(leakingObjectIds, findLeaks.c);
        List<LeakTraceObject> listA = a(findLeaks, bVarA, leakingObjectIds);
        List<d> listA2 = a(bVarA.a);
        List<List<b>> listA3 = a(findLeaks, listA2);
        Pair<List<ApplicationLeak>, List<LibraryLeak>> pairA = a(findLeaks, listA2, listA3, bVarA.b != null ? a(findLeaks, listA3, bVarA.b) : null);
        return new c(pairA.component1(), pairA.component2(), listA);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode;", "", "()V", "objectId", "", "getObjectId", "()J", "LeafNode", "ParentNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$LeafNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class e {
        private e() {
        }

        public /* synthetic */ e(byte b2) {
            this();
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$e$b */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode;", "objectId", "", "(J)V", "children", "", "getChildren", "()Ljava/util/Map;", "getObjectId", "()J", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class b extends e {
            final Map<Long, e> a;
            private final long b;

            public b(long j) {
                super((byte) 0);
                this.b = j;
                this.a = new LinkedHashMap();
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public long getB() {
                return this.b;
            }

            public String toString() {
                return "ParentNode(objectId=" + getB() + ", children=" + this.a + ')';
            }
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$e$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$LeafNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode;", "objectId", "", "pathNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;)V", "getObjectId", "()J", "getPathNode", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a extends e {
            final cq a;
            private final long b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, cq pathNode) {
                super((byte) 0);
                Intrinsics.checkNotNullParameter(pathNode, "pathNode");
                this.b = j;
                this.a = pathNode;
            }
        }
    }

    private final List<d> a(List<? extends cq> list) {
        e.b bVar = new e.b(0L);
        for (cq cqVar : list) {
            ArrayList arrayList = new ArrayList();
            cq b2 = cqVar;
            while (b2 instanceof cq.a) {
                arrayList.add(0, Long.valueOf(b2.getA()));
                b2 = ((cq.a) b2).getB();
            }
            arrayList.add(0, Long.valueOf(b2.getA()));
            a(cqVar, arrayList, 0, bVar);
        }
        ArrayList arrayList2 = new ArrayList();
        a(bVar, arrayList2);
        if (arrayList2.size() != list.size()) {
            SharkLog sharkLog = SharkLog.b;
            if (SharkLog.a != null) {
                String str = "Found " + list.size() + " paths to retained objects, down to " + arrayList2.size() + " after removing duplicated paths";
            }
        } else {
            SharkLog sharkLog2 = SharkLog.b;
            if (SharkLog.a != null) {
                String str2 = "Found " + arrayList2.size() + " paths to retained objects";
            }
        }
        ArrayList<cq> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (cq b3 : arrayList3) {
            ArrayList arrayList5 = new ArrayList();
            while (b3 instanceof cq.a) {
                arrayList5.add(0, b3);
                b3 = ((cq.a) b3).getB();
            }
            if (b3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.internal.ReferencePathNode.RootNode");
            }
            arrayList4.add(new d((cq.c) b3, arrayList5));
        }
        return arrayList4;
    }

    private final void a(cq cqVar, List<Long> list, int i2, e.b bVar) {
        while (true) {
            long jLongValue = list.get(i2).longValue();
            if (i2 == CollectionsKt.getLastIndex(list)) {
                bVar.a.put(Long.valueOf(jLongValue), new e.a(jLongValue, cqVar));
                return;
            }
            e.b bVarInvoke = bVar.a.get(Long.valueOf(jLongValue));
            if (bVarInvoke == null) {
                bVarInvoke = new i(jLongValue, bVar).invoke();
            }
            if (!(bVarInvoke instanceof e.b)) {
                return;
            }
            i2++;
            bVar = (e.b) bVarInvoke;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$i */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class i extends Lambda implements Function0<e.b> {
        final /* synthetic */ long a;
        final /* synthetic */ e.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j, e.b bVar) {
            super(0);
            this.a = j;
            this.b = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.b invoke() {
            e.b bVar = new e.b(this.a);
            this.b.a.put(Long.valueOf(this.a), bVar);
            return bVar;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$ShortestPath;", "", "root", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "childPath", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;Ljava/util/List;)V", "getChildPath", "()Ljava/util/List;", "getRoot", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "asList", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class d {
        final cq.c a;
        final List<cq.a> b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(cq.c root, List<? extends cq.a> childPath) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(childPath, "childPath");
            this.a = root;
            this.b = childPath;
        }

        public final List<cq> a() {
            return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.a), (Iterable) this.b);
        }
    }

    private final Pair<List<ApplicationLeak>, List<LibraryLeak>> a(a aVar, List<d> list, List<? extends List<b>> list2, Map<Long, Pair<Integer, Integer>> map) {
        Object next;
        cq.b bVar;
        this.a.a(OnAnalysisProgressListener.b.BUILDING_LEAK_TRACES);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            d dVar = (d) obj;
            List<LeakTraceObject> listA = a(list2.get(i2), map);
            LeakTrace leakTrace = new LeakTrace(LeakTrace.b.k.a(dVar.a.getB()), a(aVar, dVar.b, listA), (LeakTraceObject) CollectionsKt.last((List) listA));
            if (dVar.a instanceof cq.b) {
                bVar = (cq.b) dVar.a;
            } else {
                Iterator<T> it = dVar.b.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(((cq.a) next) instanceof cq.b));
                bVar = (cq.b) next;
            }
            if (bVar != null) {
                LibraryLeakReferenceMatcher c2 = bVar.getC();
                String strA = ct.a(c2.getA().toString());
                Object obj2 = linkedHashMap2.get(strA);
                if (obj2 == null) {
                    obj2 = TuplesKt.to(c2, new ArrayList());
                    linkedHashMap2.put(strA, obj2);
                }
                ((List) ((Pair) obj2).getSecond()).add(leakTrace);
            } else {
                String strC = leakTrace.c();
                Object obj3 = linkedHashMap.get(strC);
                if (obj3 == null) {
                    obj3 = (List) new ArrayList();
                    linkedHashMap.put(strC, obj3);
                }
                ((List) obj3).add(leakTrace);
            }
            i2 = i3;
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add(new ApplicationLeak((List) ((Map.Entry) it2.next()).getValue()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(linkedHashMap2.size());
        Iterator it3 = linkedHashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            Pair pair = (Pair) ((Map.Entry) it3.next()).getValue();
            LibraryLeakReferenceMatcher libraryLeakReferenceMatcher = (LibraryLeakReferenceMatcher) pair.component1();
            arrayList3.add(new LibraryLeak((List) pair.component2(), libraryLeakReferenceMatcher.getA(), libraryLeakReferenceMatcher.a));
        }
        return TuplesKt.to(arrayList2, arrayList3);
    }

    private final List<List<b>> a(a aVar, List<d> list) {
        this.a.a(OnAnalysisProgressListener.b.INSPECTING_OBJECTS);
        List<d> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            List<cq> listA = ((d) it.next()).a();
            List<cq> list3 = listA;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            int i2 = 0;
            for (Object obj : list3) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ObjectReporter objectReporter = new ObjectReporter(aVar.a.a(((cq) obj).getA()));
                Object obj2 = i3 < listA.size() ? (cq) listA.get(i3) : null;
                if (obj2 instanceof cq.b) {
                    objectReporter.a.add("Library leak match: " + ((cq.b) obj2).getC().getA());
                }
                arrayList2.add(objectReporter);
                i2 = i3;
            }
            arrayList.add(arrayList2);
        }
        ArrayList arrayList3 = arrayList;
        Iterator<T> it2 = aVar.d.iterator();
        while (it2.hasNext()) {
            it2.next();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                Iterator it4 = ((List) it3.next()).iterator();
                while (it4.hasNext()) {
                    it4.next();
                }
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            arrayList5.add(b((List) it5.next()));
        }
        return arrayList5;
    }

    private final Map<Long, Pair<Integer, Integer>> a(a aVar, List<? extends List<b>> list, cg cgVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                b bVar = (b) obj;
                if (bVar.b == LeakTraceObject.b.UNKNOWN || bVar.b == LeakTraceObject.b.LEAKING) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(Long.valueOf(((b) it2.next()).a.getE()));
            }
            CollectionsKt.addAll(arrayList, arrayList4);
        }
        Set<Long> set = CollectionsKt.toSet(arrayList);
        this.a.a(OnAnalysisProgressListener.b.COMPUTING_NATIVE_RETAINED_SIZE);
        Map<Long, Integer> mapA = new cc(aVar.a).a();
        this.a.a(OnAnalysisProgressListener.b.COMPUTING_RETAINED_SIZE);
        return cgVar.a(set, new h(mapA, new cr(aVar.a)));
    }

    private final List<LeakTraceObject> a(List<b> list, Map<Long, Pair<Integer, Integer>> map) {
        LeakTraceObject.c cVar;
        List<b> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (b bVar : list2) {
            HeapObject heapObject = bVar.a;
            String strA = a(heapObject);
            if (heapObject instanceof HeapObject.b) {
                cVar = LeakTraceObject.c.CLASS;
            } else if ((heapObject instanceof HeapObject.d) || (heapObject instanceof HeapObject.e)) {
                cVar = LeakTraceObject.c.ARRAY;
            } else {
                cVar = LeakTraceObject.c.INSTANCE;
            }
            LeakTraceObject.c cVar2 = cVar;
            Integer second = null;
            Pair<Integer, Integer> pair = map != null ? map.get(Long.valueOf(bVar.a.getE())) : null;
            long e2 = heapObject.getE();
            Set<String> set = bVar.d;
            LeakTraceObject.b bVar2 = bVar.b;
            String str = bVar.c;
            Integer first = pair != null ? pair.getFirst() : null;
            if (pair != null) {
                second = pair.getSecond();
            }
            arrayList.add(new LeakTraceObject(e2, cVar2, strA, set, bVar2, str, first, second));
        }
        return arrayList;
    }

    private final List<LeakTraceReference> a(a aVar, List<? extends cq.a> list, List<LeakTraceObject> list2) {
        String strF;
        List<? extends cq.a> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        int i2 = 0;
        for (Object obj : list3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            cq.a aVar2 = (cq.a) obj;
            LeakTraceObject leakTraceObject = list2.get(i2);
            LeakTraceReference.b c2 = aVar2.getC();
            if (aVar2.getE() != 0) {
                HeapObject.b bVarD = aVar.a.a(aVar2.getE()).d();
                Intrinsics.checkNotNull(bVarD);
                strF = bVarD.f();
            } else {
                strF = list2.get(i2).b;
            }
            arrayList.add(new LeakTraceReference(leakTraceObject, c2, strF, aVar2.getD()));
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$InspectedObject;", "", "heapObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "leakingStatus", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "", "labels", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/util/Set;)V", "getHeapObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "()Ljava/lang/String;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {
        final HeapObject a;
        final LeakTraceObject.b b;
        final String c;
        final Set<String> d;

        public b(HeapObject heapObject, LeakTraceObject.b leakingStatus, String leakingStatusReason, Set<String> labels) {
            Intrinsics.checkNotNullParameter(heapObject, "heapObject");
            Intrinsics.checkNotNullParameter(leakingStatus, "leakingStatus");
            Intrinsics.checkNotNullParameter(leakingStatusReason, "leakingStatusReason");
            Intrinsics.checkNotNullParameter(labels, "labels");
            this.a = heapObject;
            this.b = leakingStatus;
            this.c = leakingStatusReason;
            this.d = labels;
        }
    }

    private final List<b> b(List<ObjectReporter> list) {
        int i2;
        Number number;
        Pair pair;
        Number number2;
        Pair pair2;
        int size = list.size() - 1;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = size;
        ArrayList arrayList = new ArrayList();
        List<ObjectReporter> list2 = list;
        Iterator<T> it = list2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Pair<LeakTraceObject.b, String> pairA = a((ObjectReporter) it.next(), i3 == size);
            if (i3 == size) {
                int i4 = as.b[pairA.getFirst().ordinal()];
                if (i4 != 1) {
                    if (i4 == 2) {
                        pairA = TuplesKt.to(LeakTraceObject.b.LEAKING, "This is the leaking object");
                    } else {
                        if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        pairA = TuplesKt.to(LeakTraceObject.b.LEAKING, "This is the leaking object. Conflicts with " + pairA.getSecond());
                    }
                }
            }
            arrayList.add(pairA);
            LeakTraceObject.b bVarComponent1 = pairA.component1();
            if (bVarComponent1 == LeakTraceObject.b.NOT_LEAKING) {
                intRef.element = i3;
                intRef2.element = size;
            } else if (bVarComponent1 == LeakTraceObject.b.LEAKING && intRef2.element == size) {
                intRef2.element = i3;
            }
            i3++;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(ct.a(a(((ObjectReporter) it2.next()).d), '.'));
        }
        ArrayList arrayList3 = arrayList2;
        int i5 = intRef.element;
        int i6 = 0;
        while (i6 < i5) {
            Pair pair3 = (Pair) arrayList.get(i6);
            LeakTraceObject.b bVar = (LeakTraceObject.b) pair3.component1();
            String str = (String) pair3.component2();
            int i7 = i6 + 1;
            Iterator it3 = SequencesKt.generateSequence(Integer.valueOf(i7), new f(intRef)).iterator();
            do {
                if (!it3.hasNext()) {
                    throw new NoSuchElementException("Sequence contains no element matching the predicate.");
                }
                number2 = (Number) it3.next();
            } while (!(((LeakTraceObject.b) ((Pair) arrayList.get(number2.intValue())).getFirst()) == LeakTraceObject.b.NOT_LEAKING));
            String str2 = (String) arrayList3.get(number2.intValue());
            int i8 = as.c[bVar.ordinal()];
            if (i8 == 1) {
                pair2 = TuplesKt.to(LeakTraceObject.b.NOT_LEAKING, str2 + "↓ is not leaking");
            } else if (i8 == 2) {
                pair2 = TuplesKt.to(LeakTraceObject.b.NOT_LEAKING, str2 + "↓ is not leaking and " + str);
            } else {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                pair2 = TuplesKt.to(LeakTraceObject.b.NOT_LEAKING, str2 + "↓ is not leaking. Conflicts with " + str);
            }
            arrayList.set(i6, pair2);
            i6 = i7;
        }
        int i9 = size - 1;
        if (intRef2.element < i9 && i9 >= (i2 = intRef2.element + 1)) {
            while (true) {
                Pair pair4 = (Pair) arrayList.get(i9);
                LeakTraceObject.b bVar2 = (LeakTraceObject.b) pair4.component1();
                String str3 = (String) pair4.component2();
                Iterator it4 = SequencesKt.generateSequence(Integer.valueOf(i9 - 1), new g(intRef2)).iterator();
                do {
                    if (!it4.hasNext()) {
                        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
                    }
                    number = (Number) it4.next();
                } while (!(((LeakTraceObject.b) ((Pair) arrayList.get(number.intValue())).getFirst()) == LeakTraceObject.b.LEAKING));
                String str4 = (String) arrayList3.get(number.intValue());
                int i10 = as.d[bVar2.ordinal()];
                if (i10 == 1) {
                    pair = TuplesKt.to(LeakTraceObject.b.LEAKING, str4 + "↑ is leaking");
                } else {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new IllegalStateException("Should never happen");
                    }
                    pair = TuplesKt.to(LeakTraceObject.b.LEAKING, str4 + "↑ is leaking and " + str3);
                }
                arrayList.set(i9, pair);
                if (i9 == i2) {
                    break;
                }
                i9--;
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i11 = 0;
        for (Object obj : list2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ObjectReporter objectReporter = (ObjectReporter) obj;
            Pair pair5 = (Pair) arrayList.get(i11);
            arrayList4.add(new b(objectReporter.d, (LeakTraceObject.b) pair5.component1(), (String) pair5.component2(), objectReporter.a));
            i11 = i12;
        }
        return arrayList4;
    }

    private final Pair<LeakTraceObject.b, String> a(ObjectReporter objectReporter, boolean z) {
        String strJoinToString$default;
        LeakTraceObject.b bVar = LeakTraceObject.b.UNKNOWN;
        if (!objectReporter.c.isEmpty()) {
            bVar = LeakTraceObject.b.NOT_LEAKING;
            strJoinToString$default = CollectionsKt.joinToString$default(objectReporter.c, " and ", null, null, 0, null, null, 62, null);
        } else {
            strJoinToString$default = "";
        }
        Set<String> set = objectReporter.b;
        if (!set.isEmpty()) {
            String strJoinToString$default2 = CollectionsKt.joinToString$default(set, " and ", null, null, 0, null, null, 62, null);
            if (bVar != LeakTraceObject.b.NOT_LEAKING) {
                bVar = LeakTraceObject.b.LEAKING;
                strJoinToString$default = strJoinToString$default2;
            } else if (z) {
                bVar = LeakTraceObject.b.LEAKING;
                strJoinToString$default = strJoinToString$default2 + ". Conflicts with " + strJoinToString$default;
            } else {
                strJoinToString$default = strJoinToString$default + ". Conflicts with " + strJoinToString$default2;
            }
        }
        return TuplesKt.to(bVar, strJoinToString$default);
    }

    private final String a(HeapObject heapObject) {
        if (heapObject instanceof HeapObject.b) {
            return ((HeapObject.b) heapObject).f();
        }
        if (heapObject instanceof HeapObject.c) {
            return ((HeapObject.c) heapObject).h();
        }
        if (heapObject instanceof HeapObject.d) {
            return ((HeapObject.d) heapObject).f();
        }
        if (heapObject instanceof HeapObject.e) {
            return ((HeapObject.e) heapObject).g();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<LeakTraceObject> a(a aVar, co.b bVar, Set<Long> set) {
        List<cq> list = bVar.a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((cq) it.next()).getA()));
        }
        Set setMinus = SetsKt.minus((Set) set, (Iterable) CollectionsKt.toSet(arrayList));
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setMinus, 10));
        Iterator it2 = setMinus.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new ObjectReporter(aVar.a.a(((Number) it2.next()).longValue())));
        }
        ArrayList arrayList3 = arrayList2;
        Iterator<T> it3 = aVar.d.iterator();
        while (it3.hasNext()) {
            it3.next();
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        ArrayList<ObjectReporter> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (ObjectReporter objectReporter : arrayList4) {
            Pair<LeakTraceObject.b, String> pairA = a(objectReporter, true);
            LeakTraceObject.b bVarComponent1 = pairA.component1();
            String strComponent2 = pairA.component2();
            int i2 = as.a[bVarComponent1.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    strComponent2 = "This is a leaking object";
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strComponent2 = "This is a leaking object. Conflicts with " + strComponent2;
                }
            }
            arrayList5.add(new b(objectReporter.d, LeakTraceObject.b.LEAKING, strComponent2, objectReporter.a));
        }
        return a(arrayList5, (Map<Long, Pair<Integer, Integer>>) null);
    }

    private final void a(e.b bVar, List<cq> list) {
        for (e eVar : bVar.a.values()) {
            if (eVar instanceof e.b) {
                a((e.b) eVar, list);
            } else if (eVar instanceof e.a) {
                list.add(((e.a) eVar).a);
            }
        }
    }
}
