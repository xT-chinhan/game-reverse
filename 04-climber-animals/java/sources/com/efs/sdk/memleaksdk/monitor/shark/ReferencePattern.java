package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "Ljava/io/Serializable;", "()V", "Companion", "InstanceFieldPattern", "JavaLocalPattern", "NativeGlobalVariablePattern", "StaticFieldPattern", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$JavaLocalPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$StaticFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$InstanceFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$NativeGlobalVariablePattern;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class ReferencePattern implements Serializable {
    public static final a a = new a(0);
    private static final long serialVersionUID = -5113635523713591133L;

    private ReferencePattern() {
    }

    public /* synthetic */ ReferencePattern(byte b2) {
        this();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$JavaLocalPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "threadName", "", "(Ljava/lang/String;)V", "getThreadName", "()Ljava/lang/String;", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class c extends ReferencePattern {
        public static final a c = new a(0);
        private static final long serialVersionUID = -8985446122829543654L;
        public final String b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof c) && Intrinsics.areEqual(this.b, ((c) other).b);
            }
            return true;
        }

        public int hashCode() {
            String str = this.b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String threadName) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            this.b = threadName;
        }

        public String toString() {
            return "local variable on thread " + this.b;
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$c$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$JavaLocalPattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$StaticFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "className", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getFieldName", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class e extends ReferencePattern {
        public static final a d = new a(0);
        private static final long serialVersionUID = 7656908128775899611L;
        public final String b;
        public final String c;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof e)) {
                return false;
            }
            e eVar = (e) other;
            return Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c);
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.c;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String className, String fieldName) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            this.b = className;
            this.c = fieldName;
        }

        public String toString() {
            return "static field " + this.b + '#' + this.c;
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$e$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$StaticFieldPattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$InstanceFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "className", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getFieldName", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class b extends ReferencePattern {
        public static final a d = new a(0);
        private static final long serialVersionUID = 6649791455204159802L;
        public final String b;
        public final String c;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.c;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String className, String fieldName) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            this.b = className;
            this.c = fieldName;
        }

        public String toString() {
            return "instance field " + this.b + '#' + this.c;
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$b$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$InstanceFieldPattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$NativeGlobalVariablePattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "className", "", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class d extends ReferencePattern {
        public static final a c = new a(0);
        private static final long serialVersionUID = -2651328076202244933L;
        public final String b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof d) && Intrinsics.areEqual(this.b, ((d) other).b);
            }
            return true;
        }

        public int hashCode() {
            String str = this.b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String className) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(className, "className");
            this.b = className;
        }

        public String toString() {
            return "native global variable referencing " + this.b;
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$d$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$NativeGlobalVariablePattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
