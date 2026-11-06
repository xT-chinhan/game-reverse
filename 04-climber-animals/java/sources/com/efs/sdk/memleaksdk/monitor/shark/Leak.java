package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bf, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/Leak;", "Ljava/io/Serializable;", "()V", "leakTraces", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "getLeakTraces", "()Ljava/util/List;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", com.umeng.ccg.a.A, "getSignature", "totalRetainedHeapByteSize", "", "getTotalRetainedHeapByteSize", "()Ljava/lang/Integer;", "totalRetainedObjectCount", "getTotalRetainedObjectCount", "toString", "Companion", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class Leak implements Serializable {
    public static final a b = new a(0);
    private static final long serialVersionUID = -2287572510360910916L;

    public abstract String a();

    public abstract List<LeakTrace> c();

    private Leak() {
    }

    public /* synthetic */ Leak(byte b2) {
        this();
    }

    public final Integer d() {
        if (((LeakTrace) CollectionsKt.first((List) c())).a() == null) {
            return null;
        }
        Iterator<T> it = c().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            Integer numA = ((LeakTrace) it.next()).a();
            Intrinsics.checkNotNull(numA);
            iIntValue += numA.intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public String toString() {
        return (d() != null ? d() + " bytes retained by leaking objects\n" : "") + (c().size() > 1 ? "Displaying only 1 leak trace out of " + c().size() + " with the same signature\n" : "") + "Signature: " + a() + '\n' + ((LeakTrace) CollectionsKt.first((List) c()));
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bf$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/Leak$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
