package com.onevcat.uniwebview;

import android.graphics.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0750r0 extends Lambda implements Function1 {
    public final /* synthetic */ Rect a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0750r0(Rect rect) {
        super(1);
        this.a = rect;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Rect rect = this.a;
        if (it.e.getHeight() > 0 && it.e.getWidth() > 0) {
            it.n = it.a(rect);
        }
        return Unit.INSTANCE;
    }
}
