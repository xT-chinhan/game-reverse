package com.onevcat.uniwebview;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0755t extends Lambda implements Function0 {
    public final /* synthetic */ C0764w a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0755t(C0764w c0764w) {
        super(0);
        this.a = c0764w;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.a.get_webClient$uniwebview_release().g;
    }
}
