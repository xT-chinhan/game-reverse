package com.onevcat.uniwebview;

import android.graphics.Color;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0727j1 extends Lambda implements Function1 {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0727j1(float f, float f2, float f3, float f4) {
        super(1);
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Q q = it.q;
        float f = this.a;
        float f2 = this.b;
        float f3 = this.c;
        float f4 = this.d;
        q.getClass();
        float f5 = 255;
        int iArgb = Color.argb((int) (f4 * f5), (int) (f * f5), (int) (f2 * f5), (int) (f3 * f5));
        q.b.setTextColor(iArgb);
        q.c.setTextColor(iArgb);
        q.a.setTextColor(iArgb);
        return Unit.INSTANCE;
    }
}
