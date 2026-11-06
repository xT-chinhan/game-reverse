package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.o1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0742o1 extends Lambda implements Function1 {
    public final /* synthetic */ boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0742o1(boolean z) {
        super(1);
        this.a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        boolean z = this.a;
        it.r.removeView(it.q);
        if (z) {
            it.r.addView(it.q, 0);
        } else {
            it.r.addView(it.q);
        }
        return Unit.INSTANCE;
    }
}
