package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u0000 22\u00020\u0001:\u000223B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J-\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\u0019\u0010(\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020\u0013HÖ\u0001J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020%H\u0002J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0013J\u0006\u00100\u001a\u00020\u0019J\b\u00101\u001a\u00020\u0019H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00064"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "Ljava/io/Serializable;", "gcRootType", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "referencePath", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "leakingObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;)V", "elements", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceElement;", "getGcRootType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "getLeakingObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "getReferencePath", "()Ljava/util/List;", "retainedHeapByteSize", "", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "retainedObjectCount", "getRetainedObjectCount", com.umeng.ccg.a.A, "", "getSignature", "()Ljava/lang/String;", "suspectReferenceSubpath", "Lkotlin/sequences/Sequence;", "getSuspectReferenceSubpath", "()Lkotlin/sequences/Sequence;", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "", "fromV20", "fromV20$memleaksdk_release", "(Ljava/lang/Integer;)Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", TTDownloadField.TT_HASHCODE, "leakTraceAsString", "showLeakingStatus", "referencePathElementIsSuspect", com.umeng.ccg.a.H, "toSimplePathString", "toString", "Companion", "GcRootType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LeakTrace implements Serializable {
    public static final a d = new a(0);
    private static final long serialVersionUID = -6315725584154386429L;
    public final b a;
    public final List<LeakTraceReference> b;
    public final LeakTraceObject c;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeakTrace)) {
            return false;
        }
        LeakTrace leakTrace = (LeakTrace) other;
        return Intrinsics.areEqual(this.a, leakTrace.a) && Intrinsics.areEqual(this.b, leakTrace.b) && Intrinsics.areEqual(this.c, leakTrace.c);
    }

    public int hashCode() {
        b bVar = this.a;
        int iHashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        List<LeakTraceReference> list = this.b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        LeakTraceObject leakTraceObject = this.c;
        return iHashCode2 + (leakTraceObject != null ? leakTraceObject.hashCode() : 0);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", com.umeng.ccg.a.H, "", "<anonymous parameter 1>", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class d extends Lambda implements Function2<Integer, LeakTraceReference, Boolean> {
        d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Boolean invoke(Integer num, LeakTraceReference leakTraceReference) {
            return Boolean.valueOf(a(num.intValue(), leakTraceReference));
        }

        public final boolean a(int i, LeakTraceReference leakTraceReference) {
            Intrinsics.checkNotNullParameter(leakTraceReference, "<anonymous parameter 1>");
            return LeakTrace.this.a(i);
        }
    }

    public LeakTrace(b gcRootType, List<LeakTraceReference> referencePath, LeakTraceObject leakingObject) {
        Intrinsics.checkNotNullParameter(gcRootType, "gcRootType");
        Intrinsics.checkNotNullParameter(referencePath, "referencePath");
        Intrinsics.checkNotNullParameter(leakingObject, "leakingObject");
        this.a = gcRootType;
        this.b = referencePath;
        this.c = leakingObject;
    }

    public final Integer a() {
        List listListOf = CollectionsKt.listOf(this.c);
        List<LeakTraceReference> list = this.b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((LeakTraceReference) it.next()).a);
        }
        List listPlus = CollectionsKt.plus((Collection) listListOf, (Iterable) arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listPlus) {
            if (((LeakTraceObject) obj).d == LeakTraceObject.b.LEAKING) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Integer num = ((LeakTraceObject) it2.next()).f;
            if (num != null) {
                arrayList3.add(num);
            }
        }
        return (Integer) CollectionsKt.max((Iterable) arrayList3);
    }

    public final Sequence<LeakTraceReference> b() {
        return SequencesKt.filterIndexed(CollectionsKt.asSequence(this.b), new d());
    }

    public final String c() {
        return ct.a(SequencesKt.joinToString$default(b(), "", null, null, 0, null, c.a, 30, null));
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "element", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class c extends Lambda implements Function1<LeakTraceReference, CharSequence> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(LeakTraceReference element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return element.a.b + element.c();
        }
    }

    public final boolean a(int i) {
        int i2 = bh.a[this.b.get(i).a.d.ordinal()];
        if (i2 != 1) {
            return i2 == 2 && (i == CollectionsKt.getLastIndex(this.b) || this.b.get(i + 1).a.d != LeakTraceObject.b.NOT_LEAKING);
        }
        return true;
    }

    public String toString() {
        return a(true);
    }

    private final String a(boolean z) {
        String strTrimIndent = StringsKt.trimIndent("\n        ┬───\n        │ GC Root: " + this.a.j + "\n        │\n      ");
        int i = 0;
        for (Object obj : this.b) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LeakTraceReference leakTraceReference = (LeakTraceReference) obj;
            LeakTraceObject leakTraceObject = leakTraceReference.a;
            strTrimIndent = ((strTrimIndent + "\n") + leakTraceObject.a("├─ ", "│    ", z, (i == 0 && this.a == b.JAVA_FRAME) ? "thread" : leakTraceObject.b())) + d.a(this, leakTraceReference, i, z);
            i = i2;
        }
        return (strTrimIndent + "\n") + LeakTraceObject.a(this.c, "╰→ ", "\u200b     ", z, null, 8);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "", BundleKey.DESCRIPTION, "", "(Ljava/lang/String;ILjava/lang/String;)V", BillingClientConstants.METHOD_GET_PRODUCT_DESCRIPTION, "()Ljava/lang/String;", "JNI_GLOBAL", "JNI_LOCAL", "JAVA_FRAME", "NATIVE_STACK", "STICKY_CLASS", "THREAD_BLOCK", "MONITOR_USED", "THREAD_OBJECT", "JNI_MONITOR", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        JNI_GLOBAL("Global variable in native code"),
        JNI_LOCAL("Local variable in native code"),
        JAVA_FRAME("Java local variable"),
        NATIVE_STACK("Input or output parameters in native code"),
        STICKY_CLASS("System class"),
        THREAD_BLOCK("Thread block"),
        MONITOR_USED("Monitor (anything that called the wait() or notify() methods, or that is synchronized.)"),
        THREAD_OBJECT("Thread object"),
        JNI_MONITOR("Root JNI monitor");

        public static final a k = new a(0);
        public final String j;

        b(String str) {
            this.j = str;
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$b$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType$Companion;", "", "()V", "fromGcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "gcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }

            public final b a(GcRoot gcRoot) {
                Intrinsics.checkNotNullParameter(gcRoot, "gcRoot");
                if (gcRoot instanceof GcRoot.e) {
                    return b.JNI_GLOBAL;
                }
                if (gcRoot instanceof GcRoot.f) {
                    return b.JNI_LOCAL;
                }
                if (gcRoot instanceof GcRoot.d) {
                    return b.JAVA_FRAME;
                }
                if (gcRoot instanceof GcRoot.i) {
                    return b.NATIVE_STACK;
                }
                if (gcRoot instanceof GcRoot.k) {
                    return b.STICKY_CLASS;
                }
                if (gcRoot instanceof GcRoot.l) {
                    return b.THREAD_BLOCK;
                }
                if (gcRoot instanceof GcRoot.h) {
                    return b.MONITOR_USED;
                }
                if (gcRoot instanceof GcRoot.m) {
                    return b.THREAD_OBJECT;
                }
                if (gcRoot instanceof GcRoot.g) {
                    return b.JNI_MONITOR;
                }
                throw new IllegalStateException("Unexpected gc root " + gcRoot);
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$Companion;", "", "()V", "ZERO_WIDTH_SPACE", "", "serialVersionUID", "", "getNextElementString", "", "leakTrace", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "reference", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", com.umeng.ccg.a.H, "", "showLeakingStatus", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a(LeakTrace leakTrace, LeakTraceReference leakTraceReference, int i, boolean z) {
            String str = "    ↓" + (leakTraceReference.b == LeakTraceReference.b.STATIC_FIELD ? " static" : "") + ' ' + leakTraceReference.a() + '.' + leakTraceReference.b();
            if (z && leakTrace.a(i)) {
                int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) + 1;
                return "\n│" + str + "\n│" + StringsKt.repeat(" ", iLastIndexOf$default) + StringsKt.repeat("~", str.length() - iLastIndexOf$default);
            }
            return "\n│" + str;
        }
    }
}
