package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0762v0 extends Lambda implements Function1 {
    public static final C0762v0 a = new C0762v0();

    public C0762v0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        it.p.b();
        return Unit.INSTANCE;
    }
}
