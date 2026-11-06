package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bk, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0002#$B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "Ljava/io/Serializable;", "originObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "referenceType", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "owningClassName", "", "referenceName", "(Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;Ljava/lang/String;Ljava/lang/String;)V", "getOriginObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "getOwningClassName", "()Ljava/lang/String;", "owningClassSimpleName", "getOwningClassSimpleName", "referenceDisplayName", "getReferenceDisplayName", "referenceGenericName", "getReferenceGenericName", "getReferenceName", "getReferenceType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "component1", "component2", "component3", "component4", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "Companion", "ReferenceType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LeakTraceReference implements Serializable {
    public static final a c = new a(0);
    private static final long serialVersionUID = 1;
    public final LeakTraceObject a;
    final b b;
    private final String d;
    private final String e;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bk$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "", "(Ljava/lang/String;I)V", "INSTANCE_FIELD", "STATIC_FIELD", "LOCAL", "ARRAY_ENTRY", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL,
        ARRAY_ENTRY
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeakTraceReference)) {
            return false;
        }
        LeakTraceReference leakTraceReference = (LeakTraceReference) other;
        return Intrinsics.areEqual(this.a, leakTraceReference.a) && Intrinsics.areEqual(this.b, leakTraceReference.b) && Intrinsics.areEqual(this.d, leakTraceReference.d) && Intrinsics.areEqual(this.e, leakTraceReference.e);
    }

    public int hashCode() {
        LeakTraceObject leakTraceObject = this.a;
        int iHashCode = (leakTraceObject != null ? leakTraceObject.hashCode() : 0) * 31;
        b bVar = this.b;
        int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
        String str = this.d;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LeakTraceReference(originObject=" + this.a + ", referenceType=" + this.b + ", owningClassName=" + this.d + ", referenceName=" + this.e + ")";
    }

    public LeakTraceReference(LeakTraceObject originObject, b referenceType, String owningClassName, String referenceName) {
        Intrinsics.checkNotNullParameter(originObject, "originObject");
        Intrinsics.checkNotNullParameter(referenceType, "referenceType");
        Intrinsics.checkNotNullParameter(owningClassName, "owningClassName");
        Intrinsics.checkNotNullParameter(referenceName, "referenceName");
        this.a = originObject;
        this.b = referenceType;
        this.d = owningClassName;
        this.e = referenceName;
    }

    public final String a() {
        return ct.a(this.d, '.');
    }

    public final String b() {
        int i = bl.a[this.b.ordinal()];
        if (i == 1) {
            return "[" + this.e + AbstractJsonLexerKt.END_LIST;
        }
        if (i == 2 || i == 3) {
            return this.e;
        }
        if (i == 4) {
            return "<Java Local>";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String c() {
        int i = bl.b[this.b.ordinal()];
        if (i == 1) {
            return "[x]";
        }
        if (i == 2 || i == 3) {
            return this.e;
        }
        if (i == 4) {
            return "<Java Local>";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bk$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
