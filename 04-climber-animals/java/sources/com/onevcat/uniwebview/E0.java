package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class E0 extends Lambda implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E0(String str, String str2) {
        super(1);
        this.a = str;
        this.b = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C0764w c0764w = it.p;
        String str = this.a;
        String str2 = this.b;
        c0764w.getClass();
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("UniWebView will load HTML string with base url: ", str2, c0731l, "message"));
        String message = "Input HTML content: \n" + str;
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.VERBOSE, message);
        J j = c0764w.e;
        j.f = 200;
        j.d = true;
        j.c = false;
        j.e = false;
        if (str == null) {
            str = "";
        }
        c0764w.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        return Unit.INSTANCE;
    }
}
