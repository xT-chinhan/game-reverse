package com.efs.sdk.memleaksdk.monitor.shark;

import com.anythink.core.common.d.j;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.al, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\r\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/Leak;", "leakTraces", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "(Ljava/util/List;)V", "leakTrace", "getLeakTraces", "()Ljava/util/List;", "retainedHeapByteSize", "", "Ljava/lang/Integer;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", com.umeng.ccg.a.A, "getSignature", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "leakTraceFromV20", "leakTraceFromV20$memleaksdk_release", "toString", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class ApplicationLeak extends Leak {
    public static final a a = new a(0);
    private static final long serialVersionUID = 524928276700576863L;
    private final List<LeakTrace> c;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ApplicationLeak) && Intrinsics.areEqual(c(), ((ApplicationLeak) other).c());
        }
        return true;
    }

    public int hashCode() {
        List<LeakTrace> listC = c();
        if (listC != null) {
            return listC.hashCode();
        }
        return 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    public List<LeakTrace> c() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationLeak(List<LeakTrace> leakTraces) {
        super((byte) 0);
        Intrinsics.checkNotNullParameter(leakTraces, "leakTraces");
        this.c = leakTraces;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    public String a() {
        return ((LeakTrace) CollectionsKt.first((List) c())).c();
    }

    public String b() {
        LeakTrace leakTrace = (LeakTrace) CollectionsKt.first((List) c());
        LeakTraceReference leakTraceReference = (LeakTraceReference) SequencesKt.firstOrNull(leakTrace.b());
        if (leakTraceReference != null) {
            String str = leakTraceReference.a.a() + j.z + leakTraceReference.c();
            if (str != null) {
                return str;
            }
        }
        return leakTrace.c.b;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    public String toString() {
        return super.toString();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.al$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
