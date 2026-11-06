package com.onevcat.uniwebview;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0732l0 extends Lambda implements Function1 {
    public static final C0732l0 a = new C0732l0();

    public C0732l0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C0764w c0764w = it.p;
        C0764w c0764w2 = c0764w.d.i;
        return Boolean.valueOf((c0764w2 != null && c0764w2.canGoForward()) || c0764w.canGoForward());
    }
}
