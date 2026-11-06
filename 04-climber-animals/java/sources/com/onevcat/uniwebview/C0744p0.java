package com.onevcat.uniwebview;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0744p0 extends Lambda implements Function1 {
    public static final C0744p0 a = new C0744p0();

    public C0744p0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws IOException {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ViewParent parent = it.e.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(it.e);
        }
        it.b();
        ByteArrayOutputStream byteArrayOutputStream = it.m;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        it.m = null;
        it.n = null;
        it.p.destroy();
        C0710e c0710e = C0710e.b;
        String name = it.b;
        c0710e.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.DEBUG, AbstractC0746q.a("Removing web view container from manager: ", name, c0731l, "message"));
        c0710e.a.remove(name);
        P.b();
        return Unit.INSTANCE;
    }
}
