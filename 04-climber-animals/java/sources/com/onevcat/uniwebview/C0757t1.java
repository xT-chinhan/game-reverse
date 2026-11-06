package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.t1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0757t1 extends Lambda implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0757t1(int i, int i2, int i3, int i4) {
        super(1);
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        it.a(this.a, this.b, this.c, this.d);
        return Unit.INSTANCE;
    }
}
