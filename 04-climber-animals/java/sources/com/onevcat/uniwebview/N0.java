package com.onevcat.uniwebview;

import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class N0 extends Lambda implements Function1 {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ CountDownLatch c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(Ref.ObjectRef objectRef, Function1 function1, CountDownLatch countDownLatch) {
        super(1);
        this.a = objectRef;
        this.b = function1;
        this.c = countDownLatch;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.element = this.b.invoke(it);
        this.c.countDown();
        return Unit.INSTANCE;
    }
}
