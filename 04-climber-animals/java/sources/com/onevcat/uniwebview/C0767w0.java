package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0767w0 extends Lambda implements Function1 {
    public static final C0767w0 a = new C0767w0();

    public C0767w0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C0764w c0764w = it.p;
        C0764w c0764w2 = c0764w.d.i;
        if (c0764w2 != null) {
            if (c0764w2.canGoForward()) {
                c0764w2.goForward();
            }
        } else if (c0764w.canGoForward()) {
            c0764w.goForward();
        }
        return Unit.INSTANCE;
    }
}
