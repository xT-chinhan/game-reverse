package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0720h0 extends Lambda implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0720h0(String str, boolean z) {
        super(0);
        this.a = str;
        this.b = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0707d c0707d = C0707d.b;
        String name = this.a;
        c0707d.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        A a = (A) c0707d.a.get(name);
        if (a != null) {
            a.i = this.b;
        }
        return Unit.INSTANCE;
    }
}
