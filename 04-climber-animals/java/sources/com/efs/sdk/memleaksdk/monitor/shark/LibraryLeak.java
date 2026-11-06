package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bm, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0012HÖ\u0001J\r\u0010!\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000b¨\u0006%"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/Leak;", "leakTraces", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "pattern", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", BundleKey.DESCRIPTION, "", "(Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;Ljava/lang/String;)V", BillingClientConstants.METHOD_GET_PRODUCT_DESCRIPTION, "()Ljava/lang/String;", "leakTrace", "getLeakTraces", "()Ljava/util/List;", "getPattern", "()Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "retainedHeapByteSize", "", "Ljava/lang/Integer;", "shortDescription", "getShortDescription", com.umeng.ccg.a.A, "getSignature", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "leakTraceFromV20", "leakTraceFromV20$memleaksdk_release", "toString", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LibraryLeak extends Leak {
    public static final a a = new a(0);
    private static final long serialVersionUID = 3943636164568681903L;
    private final List<LeakTrace> c;
    private final ReferencePattern d;
    private final String e;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryLeak)) {
            return false;
        }
        LibraryLeak libraryLeak = (LibraryLeak) other;
        return Intrinsics.areEqual(c(), libraryLeak.c()) && Intrinsics.areEqual(this.d, libraryLeak.d) && Intrinsics.areEqual(this.e, libraryLeak.e);
    }

    public int hashCode() {
        List<LeakTrace> listC = c();
        int iHashCode = (listC != null ? listC.hashCode() : 0) * 31;
        ReferencePattern referencePattern = this.d;
        int iHashCode2 = (iHashCode + (referencePattern != null ? referencePattern.hashCode() : 0)) * 31;
        String str = this.e;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    public List<LeakTrace> c() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryLeak(List<LeakTrace> leakTraces, ReferencePattern pattern, String description) {
        super((byte) 0);
        Intrinsics.checkNotNullParameter(leakTraces, "leakTraces");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(description, "description");
        this.c = leakTraces;
        this.d = pattern;
        this.e = description;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    public String a() {
        return ct.a(this.d.toString());
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.Leak
    public String toString() {
        return "Leak pattern: " + this.d + "\nDescription: " + this.e + '\n' + super.toString() + '\n';
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bm$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
