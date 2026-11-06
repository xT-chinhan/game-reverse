package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00062\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "", "()V", "BooleanHolder", "ByteHolder", "CharHolder", "Companion", "DoubleHolder", "FloatHolder", "IntHolder", "LongHolder", "ReferenceHolder", "ShortHolder", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ReferenceHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$BooleanHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$CharHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$FloatHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$DoubleHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ByteHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ShortHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$IntHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$LongHolder;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class ValueHolder {
    public static final d a = new d(0);

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$i */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ReferenceHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(J)V", "isNull", "", "()Z", "getValue", "()J", "component1", "copy", "equals", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class i extends ValueHolder {
        public final long b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof i) && this.b == ((i) other).b;
            }
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.b);
        }

        public String toString() {
            return "ReferenceHolder(value=" + this.b + ")";
        }

        public i(long j) {
            super((byte) 0);
            this.b = j;
        }

        public final boolean a() {
            return this.b == 0;
        }
    }

    private ValueHolder() {
    }

    public /* synthetic */ ValueHolder(byte b2) {
        this();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$BooleanHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class a extends ValueHolder {
        final boolean b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof a) && this.b == ((a) other).b;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.b;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "BooleanHolder(value=" + this.b + ")";
        }

        public a(boolean z) {
            super((byte) 0);
            this.b = z;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$CharHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(C)V", "getValue", "()C", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class c extends ValueHolder {
        private final char b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof c) && this.b == ((c) other).b;
            }
            return true;
        }

        public int hashCode() {
            return Character.hashCode(this.b);
        }

        public String toString() {
            return "CharHolder(value=" + this.b + ")";
        }

        public c(char c) {
            super((byte) 0);
            this.b = c;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$f */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$FloatHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class f extends ValueHolder {
        private final float b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof f) && Float.compare(this.b, ((f) other).b) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.b);
        }

        public String toString() {
            return "FloatHolder(value=" + this.b + ")";
        }

        public f(float f) {
            super((byte) 0);
            this.b = f;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$DoubleHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(D)V", "getValue", "()D", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class e extends ValueHolder {
        private final double b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof e) && Double.compare(this.b, ((e) other).b) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Double.hashCode(this.b);
        }

        public String toString() {
            return "DoubleHolder(value=" + this.b + ")";
        }

        public e(double d) {
            super((byte) 0);
            this.b = d;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ByteHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(B)V", "getValue", "()B", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class b extends ValueHolder {
        private final byte b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof b) && this.b == ((b) other).b;
            }
            return true;
        }

        public int hashCode() {
            return Byte.hashCode(this.b);
        }

        public String toString() {
            return "ByteHolder(value=" + ((int) this.b) + ")";
        }

        public b(byte b) {
            super((byte) 0);
            this.b = b;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$j */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ShortHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(S)V", "getValue", "()S", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class j extends ValueHolder {
        private final short b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof j) && this.b == ((j) other).b;
            }
            return true;
        }

        public int hashCode() {
            return Short.hashCode(this.b);
        }

        public String toString() {
            return "ShortHolder(value=" + ((int) this.b) + ")";
        }

        public j(short s) {
            super((byte) 0);
            this.b = s;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$g */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$IntHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class g extends ValueHolder {
        final int b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof g) && this.b == ((g) other).b;
            }
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.b);
        }

        public String toString() {
            return "IntHolder(value=" + this.b + ")";
        }

        public g(int i) {
            super((byte) 0);
            this.b = i;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$h */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$LongHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", com.anythink.core.common.e.f.a.d, "", "(J)V", "getValue", "()J", "component1", "copy", "equals", "", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class h extends ValueHolder {
        final long b;

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof h) && this.b == ((h) other).b;
            }
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.b);
        }

        public String toString() {
            return "LongHolder(value=" + this.b + ")";
        }

        public h(long j) {
            super((byte) 0);
            this.b = j;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$Companion;", "", "()V", "NULL_REFERENCE", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }
}
