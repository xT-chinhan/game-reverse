package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0705c0 extends Lambda implements Function1 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0705c0(String str) {
        super(1);
        this.a = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C0764w c0764w = it.p;
        String domain = this.a;
        c0764w.getClass();
        Intrinsics.checkNotNullParameter(domain, "domain");
        c0764w.d.h.add(domain);
        return Unit.INSTANCE;
    }
}
