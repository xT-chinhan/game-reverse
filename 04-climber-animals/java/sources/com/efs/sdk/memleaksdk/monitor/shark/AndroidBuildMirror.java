package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aj, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "", "manufacturer", "", "sdkInt", "", "(Ljava/lang/String;I)V", "getManufacturer", "()Ljava/lang/String;", "getSdkInt", "()I", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class AndroidBuildMirror {
    public static final a c = new a(0);
    final String a;
    final int b;

    public AndroidBuildMirror(String manufacturer, int i) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        this.a = manufacturer;
        this.b = i;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aj$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror$Companion;", "", "()V", "fromHeapGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aj$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class C0347a extends Lambda implements Function0<AndroidBuildMirror> {
            final /* synthetic */ HeapGraph a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0347a(HeapGraph heapGraph) {
                super(0);
                this.a = heapGraph;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AndroidBuildMirror invoke() {
                HeapObject.b bVarA = this.a.a("android.os.Build");
                Intrinsics.checkNotNull(bVarA);
                HeapObject.b bVarA2 = this.a.a("android.os.Build$VERSION");
                Intrinsics.checkNotNull(bVarA2);
                HeapField heapFieldB = bVarA.b("MANUFACTURER");
                Intrinsics.checkNotNull(heapFieldB);
                String strG = heapFieldB.c.g();
                Intrinsics.checkNotNull(strG);
                HeapField heapFieldB2 = bVarA2.b("SDK_INT");
                Intrinsics.checkNotNull(heapFieldB2);
                Integer numB = heapFieldB2.c.b();
                Intrinsics.checkNotNull(numB);
                return new AndroidBuildMirror(strG, numB.intValue());
            }
        }

        public final AndroidBuildMirror a(HeapGraph graph) {
            Intrinsics.checkNotNullParameter(graph, "graph");
            GraphContext b = graph.getB();
            String name = AndroidBuildMirror.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "AndroidBuildMirror::class.java.name");
            return (AndroidBuildMirror) b.a(name, new C0347a(graph));
        }
    }
}
