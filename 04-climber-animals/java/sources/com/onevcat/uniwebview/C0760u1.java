package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.onevcat.uniwebview.u1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0760u1 extends Lambda implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0760u1(String str, String str2) {
        super(1);
        this.a = str;
        this.b = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C0764w c0764w = it.p;
        String key = this.a;
        String str = this.b;
        c0764w.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        if (StringsKt.isBlank(key)) {
            C0731l c0731l = C0731l.b;
            c0731l.getClass();
            Intrinsics.checkNotNullParameter("Trying to set null or empty key for header field. Please check you have set correct key.", "message");
            c0731l.a(EnumC0728k.CRITICAL, "Trying to set null or empty key for header field. Please check you have set correct key.");
        } else if (str == null) {
            c0764w.e.g.remove(key);
        } else {
            c0764w.e.g.put(key, str);
        }
        return Unit.INSTANCE;
    }
}
