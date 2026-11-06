package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ax, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "", "heapDumpTimestamp", "", "version", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "identifierByteSize", "", "(JLcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;I)V", "getHeapDumpTimestamp", "()J", "getIdentifierByteSize", "()I", "recordsPosition", "getRecordsPosition", "getVersion", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class HprofHeader {
    public static final a d = new a(0 == true ? 1 : 0);
    private static final Map<String, HprofVersion> f;
    final int a;
    public final HprofVersion b;
    public final int c;
    private final long e;

    public HprofHeader() {
        this(0L, null, 0, 7);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HprofHeader)) {
            return false;
        }
        HprofHeader hprofHeader = (HprofHeader) other;
        return this.e == hprofHeader.e && Intrinsics.areEqual(this.b, hprofHeader.b) && this.c == hprofHeader.c;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.e) * 31;
        HprofVersion hprofVersion = this.b;
        return ((iHashCode + (hprofVersion != null ? hprofVersion.hashCode() : 0)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "HprofHeader(heapDumpTimestamp=" + this.e + ", version=" + this.b + ", identifierByteSize=" + this.c + ")";
    }

    public HprofHeader(long j, HprofVersion version, int i) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.e = j;
        this.b = version;
        this.c = i;
        String str = version.e;
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.a = bytes.length + 1 + 4 + 8;
    }

    public /* synthetic */ HprofHeader(long j, HprofVersion hprofVersion, int i, int i2) {
        this((i2 & 1) != 0 ? System.currentTimeMillis() : j, (i2 & 2) != 0 ? HprofVersion.ANDROID : hprofVersion, (i2 & 4) != 0 ? 4 : i);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ax$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader$Companion;", "", "()V", "supportedVersions", "", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "parseHeaderOf", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "source", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", "hprofFile", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final HprofHeader a(n source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!source.b())) {
                throw new IllegalArgumentException("Source has no available bytes");
            }
            String strA = source.a(source.a((byte) 0));
            HprofVersion hprofVersion = (HprofVersion) HprofHeader.f.get(strA);
            if (hprofVersion == null) {
                throw new IllegalStateException(("Unsupported Hprof version [" + strA + "] not in supported list " + HprofHeader.f.keySet()).toString());
            }
            source.c(1L);
            return new HprofHeader(source.f(), hprofVersion, source.e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        HprofVersion[] hprofVersionArrValues = HprofVersion.values();
        ArrayList arrayList = new ArrayList(hprofVersionArrValues.length);
        for (HprofVersion hprofVersion : hprofVersionArrValues) {
            arrayList.add(TuplesKt.to(hprofVersion.e, hprofVersion));
        }
        f = MapsKt.toMap(arrayList);
    }
}
