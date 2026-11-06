package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class L0 extends Lambda implements Function1 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L0(String str) {
        super(1);
        this.a = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C0764w c0764w = it.p;
        String scheme = this.a;
        c0764w.getClass();
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        C0749r c0749r = c0764w.e.h;
        c0749r.getClass();
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        c0749r.d.remove(scheme);
        return Unit.INSTANCE;
    }
}
