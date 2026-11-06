package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.az, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofIndex;", "", "sourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", com.umeng.ccg.a.H, "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;)V", "openHeapGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/CloseableHeapGraph;", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HprofIndex {
    public static final a a = new a(0);
    private final RandomAccessSourceProvider b;
    private final HprofHeader c;
    private final cj d;

    private HprofIndex(RandomAccessSourceProvider randomAccessSourceProvider, HprofHeader hprofHeader, cj cjVar) {
        this.b = randomAccessSourceProvider;
        this.c = hprofHeader;
        this.d = cjVar;
    }

    public /* synthetic */ HprofIndex(RandomAccessSourceProvider randomAccessSourceProvider, HprofHeader hprofHeader, cj cjVar, byte b) {
        this(randomAccessSourceProvider, hprofHeader, cjVar);
    }

    public final CloseableHeapGraph a() {
        return new HprofHeapGraph(this.c, RandomAccessHprofReader.a.a(this.b, this.c), this.d);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.az$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofIndex$Companion;", "", "()V", "defaultIndexedGcRootTags", "Ljava/util/EnumSet;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "kotlin.jvm.PlatformType", "indexRecordsOf", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofIndex;", "hprofSourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/DualSourceProvider;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "indexedGcRootTags", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final HprofIndex a(DualSourceProvider hprofSourceProvider, HprofHeader hprofHeader, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> indexedGcRootTags) {
            Intrinsics.checkNotNullParameter(hprofSourceProvider, "hprofSourceProvider");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            Intrinsics.checkNotNullParameter(indexedGcRootTags, "indexedGcRootTags");
            StreamingHprofReader streamingHprofReaderA = StreamingHprofReader.a.a(hprofSourceProvider, hprofHeader);
            return new HprofIndex(hprofSourceProvider, hprofHeader, cj.e.a(streamingHprofReaderA, hprofHeader, proguardMapping, indexedGcRootTags), (byte) 0);
        }
    }
}
