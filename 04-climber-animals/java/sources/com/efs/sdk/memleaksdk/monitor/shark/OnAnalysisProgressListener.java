package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "", "onAnalysisProgress", "", "step", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "Companion", "Step", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public interface OnAnalysisProgressListener {
    public static final a b = a.a;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "", "(Ljava/lang/String;I)V", "PARSING_HEAP_DUMP", "EXTRACTING_METADATA", "FINDING_RETAINED_OBJECTS", "FINDING_PATHS_TO_RETAINED_OBJECTS", "FINDING_DOMINATORS", "INSPECTING_OBJECTS", "COMPUTING_NATIVE_RETAINED_SIZE", "COMPUTING_RETAINED_SIZE", "BUILDING_LEAK_TRACES", "REPORTING_HEAP_ANALYSIS", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        PARSING_HEAP_DUMP,
        EXTRACTING_METADATA,
        FINDING_RETAINED_OBJECTS,
        FINDING_PATHS_TO_RETAINED_OBJECTS,
        FINDING_DOMINATORS,
        INSPECTING_OBJECTS,
        COMPUTING_NATIVE_RETAINED_SIZE,
        COMPUTING_RETAINED_SIZE,
        BUILDING_LEAK_TRACES,
        REPORTING_HEAP_ANALYSIS
    }

    void a(b bVar);

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\u00042\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0086\nø\u0001\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Companion;", "", "()V", "NO_OP", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "getNO_OP", "()Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "invoke", "block", "Lkotlin/Function1;", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final OnAnalysisProgressListener b = C0355a.a;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bp$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener$Step;", "onAnalysisProgress"}, k = 3, mv = {1, 4, 1})
        static final class C0355a implements OnAnalysisProgressListener {
            public static final C0355a a = new C0355a();

            C0355a() {
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.OnAnalysisProgressListener
            public final void a(b it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        }

        private a() {
        }
    }
}
