package com.efs.sdk.memleaksdk.monitor.shark;

import com.anythink.core.common.e.f;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.at, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapField;", "", "declaringClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", Common.System.NAME, "", f.a.d, "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapValue;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;Ljava/lang/String;Lcom/efs/sdk/memleaksdk/monitor/shark/HeapValue;)V", "getDeclaringClass", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", BillingClientConstants.METHOD_GET_PRODUCT_NAME, "()Ljava/lang/String;", "getValue", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapValue;", "valueAsClass", "getValueAsClass", "valueAsInstance", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "getValueAsInstance", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "valueAsObjectArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "getValueAsObjectArray", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "valueAsPrimitiveArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "getValueAsPrimitiveArray", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HeapField {
    final HeapObject.b a;
    public final String b;
    public final HeapValue c;

    public HeapField(HeapObject.b declaringClass, String name, HeapValue value) {
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = declaringClass;
        this.b = name;
        this.c = value;
    }
}
