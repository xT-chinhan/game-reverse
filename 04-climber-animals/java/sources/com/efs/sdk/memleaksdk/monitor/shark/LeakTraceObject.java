package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0003:;<BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJh\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u000eHÖ\u0001J\b\u00105\u001a\u00020\u0007H\u0016J/\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u0002012\b\b\u0002\u0010$\u001a\u00020\u0007H\u0000¢\u0006\u0002\b9R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\u0012¨\u0006="}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "Ljava/io/Serializable;", "objectId", "", "type", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "className", "", "labels", "", "leakingStatus", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "retainedHeapByteSize", "", "retainedObjectCount", "(JLcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getClassName", "()Ljava/lang/String;", "classSimpleName", "getClassSimpleName", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "setLeakingStatusReason", "(Ljava/lang/String;)V", "getObjectId", "()J", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetainedObjectCount", "getType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "typeName", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "firstLinePrefix", "additionalLinesPrefix", "showLeakingStatus", "toString$memleaksdk_release", "Companion", "LeakingStatus", "ObjectType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LeakTraceObject implements Serializable {
    public static final a h = new a(0);
    private static final long serialVersionUID = -3616216391305196341L;
    public final long a;
    public final String b;
    public final Set<String> c;
    final b d;
    public String e;
    public final Integer f;
    public final Integer g;
    private final c i;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "", "(Ljava/lang/String;I)V", "NOT_LEAKING", "LEAKING", "UNKNOWN", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        NOT_LEAKING,
        LEAKING,
        UNKNOWN
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "", "(Ljava/lang/String;I)V", "CLASS", "ARRAY", "INSTANCE", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum c {
        CLASS,
        ARRAY,
        INSTANCE
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeakTraceObject)) {
            return false;
        }
        LeakTraceObject leakTraceObject = (LeakTraceObject) other;
        return this.a == leakTraceObject.a && Intrinsics.areEqual(this.i, leakTraceObject.i) && Intrinsics.areEqual(this.b, leakTraceObject.b) && Intrinsics.areEqual(this.c, leakTraceObject.c) && Intrinsics.areEqual(this.d, leakTraceObject.d) && Intrinsics.areEqual(this.e, leakTraceObject.e) && Intrinsics.areEqual(this.f, leakTraceObject.f) && Intrinsics.areEqual(this.g, leakTraceObject.g);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.a) * 31;
        c cVar = this.i;
        int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        String str = this.b;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Set<String> set = this.c;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        b bVar = this.d;
        int iHashCode5 = (iHashCode4 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        String str2 = this.e;
        int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.f;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.g;
        return iHashCode7 + (num2 != null ? num2.hashCode() : 0);
    }

    public LeakTraceObject(long j, c type, String className, Set<String> labels, b leakingStatus, String leakingStatusReason, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(labels, "labels");
        Intrinsics.checkNotNullParameter(leakingStatus, "leakingStatus");
        Intrinsics.checkNotNullParameter(leakingStatusReason, "leakingStatusReason");
        this.a = j;
        this.i = type;
        this.b = className;
        this.c = labels;
        this.d = leakingStatus;
        this.e = leakingStatusReason;
        this.f = num;
        this.g = num2;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final String a() {
        return ct.a(this.b, '.');
    }

    public final String b() {
        String strName = this.i.name();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
        if (strName == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public String toString() {
        return a(this, "", "\u200b  ", true, null, 8);
    }

    public static /* synthetic */ String a(LeakTraceObject leakTraceObject, String str, String str2, boolean z, String str3, int i) {
        if ((i & 8) != 0) {
            str3 = leakTraceObject.b();
        }
        return leakTraceObject.a(str, str2, z, str3);
    }

    public final String a(String firstLinePrefix, String additionalLinesPrefix, boolean z, String typeName) {
        String str;
        Intrinsics.checkNotNullParameter(firstLinePrefix, "firstLinePrefix");
        Intrinsics.checkNotNullParameter(additionalLinesPrefix, "additionalLinesPrefix");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        int i = bj.a[this.d.ordinal()];
        if (i == 1) {
            str = "UNKNOWN";
        } else if (i == 2) {
            str = "NO (" + this.e + ')';
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "YES (" + this.e + ')';
        }
        String str2 = "" + firstLinePrefix + this.b + ' ' + typeName;
        if (z) {
            str2 = str2 + '\n' + additionalLinesPrefix + "Leaking: " + str;
        }
        Integer num = this.f;
        if (num != null) {
            str2 = str2 + '\n' + additionalLinesPrefix + "Retaining " + h.a(num.intValue()) + " in " + this.g + " objects";
        }
        Iterator<String> it = this.c.iterator();
        while (it.hasNext()) {
            str2 = str2 + '\n' + additionalLinesPrefix + it.next();
        }
        return str2;
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$Companion;", "", "()V", "serialVersionUID", "", "humanReadableByteCount", "", "bytes", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        final String a(long j) {
            if (j < 1000) {
                return j + " B";
            }
            double d = j;
            double d2 = 1000;
            int iLog = (int) (Math.log(d) / Math.log(d2));
            char cCharAt = "kMGTPE".charAt(iLog - 1);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%.1f %sB", Arrays.copyOf(new Object[]{Double.valueOf(d / Math.pow(d2, iLog)), Character.valueOf(cCharAt)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            return str;
        }
    }
}
