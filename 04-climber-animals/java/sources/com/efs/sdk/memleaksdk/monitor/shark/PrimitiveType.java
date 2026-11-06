package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.br, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "", "hprofType", "", "byteSize", "(Ljava/lang/String;III)V", "getByteSize", "()I", "getHprofType", "BOOLEAN", "CHAR", "FLOAT", "DOUBLE", "BYTE", "SHORT", "INT", "LONG", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public enum PrimitiveType {
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);

    public static final a k = new a(0 == true ? 1 : 0);
    private static final Map<Integer, Integer> m;
    private static final Map<Integer, PrimitiveType> n;
    public final int i;
    public final int j;

    PrimitiveType(int i, int i2) {
        this.i = i;
        this.j = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PrimitiveType[] primitiveTypeArrValues = values();
        ArrayList arrayList = new ArrayList(primitiveTypeArrValues.length);
        for (PrimitiveType primitiveType : primitiveTypeArrValues) {
            arrayList.add(TuplesKt.to(Integer.valueOf(primitiveType.i), Integer.valueOf(primitiveType.j)));
        }
        m = MapsKt.toMap(arrayList);
        PrimitiveType[] primitiveTypeArrValues2 = values();
        ArrayList arrayList2 = new ArrayList(primitiveTypeArrValues2.length);
        for (PrimitiveType primitiveType2 : primitiveTypeArrValues2) {
            arrayList2.add(TuplesKt.to(Integer.valueOf(primitiveType2.i), primitiveType2));
        }
        n = MapsKt.toMap(arrayList2);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.br$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType$Companion;", "", "()V", "REFERENCE_HPROF_TYPE", "", "byteSizeByHprofType", "", "getByteSizeByHprofType", "()Ljava/util/Map;", "primitiveTypeByHprofType", "Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "getPrimitiveTypeByHprofType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
