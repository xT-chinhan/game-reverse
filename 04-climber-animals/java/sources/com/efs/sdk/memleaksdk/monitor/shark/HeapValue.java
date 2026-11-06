package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aw, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00106\u001a\u0004\u0018\u000107R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b*\u0010\"R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b5\u00104¨\u00068"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapValue;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "holder", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;)V", "asBoolean", "", "getAsBoolean", "()Ljava/lang/Boolean;", "asByte", "", "getAsByte", "()Ljava/lang/Byte;", "asChar", "", "getAsChar", "()Ljava/lang/Character;", "asDouble", "", "getAsDouble", "()Ljava/lang/Double;", "asFloat", "", "getAsFloat", "()Ljava/lang/Float;", "asInt", "", "getAsInt", "()Ljava/lang/Integer;", "asLong", "", "getAsLong", "()Ljava/lang/Long;", "asNonNullObjectId", "getAsNonNullObjectId", "asObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "getAsObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "asObjectId", "getAsObjectId", "asShort", "", "getAsShort", "()Ljava/lang/Short;", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getHolder", "()Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "isNonNullReference", "()Z", "isNullReference", "readAsJavaString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HeapValue {
    public final ValueHolder a;
    private final HeapGraph b;

    public HeapValue(HeapGraph graph, ValueHolder holder) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.b = graph;
        this.a = holder;
    }

    public final Boolean a() {
        ValueHolder valueHolder = this.a;
        if (valueHolder instanceof ValueHolder.a) {
            return Boolean.valueOf(((ValueHolder.a) valueHolder).b);
        }
        return null;
    }

    public final Integer b() {
        ValueHolder valueHolder = this.a;
        if (valueHolder instanceof ValueHolder.g) {
            return Integer.valueOf(((ValueHolder.g) valueHolder).b);
        }
        return null;
    }

    public final Long c() {
        ValueHolder valueHolder = this.a;
        if (valueHolder instanceof ValueHolder.h) {
            return Long.valueOf(((ValueHolder.h) valueHolder).b);
        }
        return null;
    }

    public final Long d() {
        ValueHolder valueHolder = this.a;
        if (!(valueHolder instanceof ValueHolder.i) || ((ValueHolder.i) valueHolder).a()) {
            return null;
        }
        return Long.valueOf(((ValueHolder.i) this.a).b);
    }

    public final boolean e() {
        ValueHolder valueHolder = this.a;
        return (valueHolder instanceof ValueHolder.i) && !((ValueHolder.i) valueHolder).a();
    }

    public final HeapObject f() {
        ValueHolder valueHolder = this.a;
        if (!(valueHolder instanceof ValueHolder.i) || ((ValueHolder.i) valueHolder).a()) {
            return null;
        }
        return this.b.a(((ValueHolder.i) this.a).b);
    }

    public final String g() {
        HeapObject heapObjectB;
        HeapObject.c cVarE;
        ValueHolder valueHolder = this.a;
        if (!(valueHolder instanceof ValueHolder.i) || ((ValueHolder.i) valueHolder).a() || (heapObjectB = this.b.b(((ValueHolder.i) this.a).b)) == null || (cVarE = heapObjectB.e()) == null) {
            return null;
        }
        return cVarE.m();
    }
}
