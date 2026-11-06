package com.onevcat.uniwebview;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class H0 extends Lambda implements Function0 {
    public final /* synthetic */ U1 a;
    public final /* synthetic */ UniWebViewNativeChannel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H0(U1 u1, UniWebViewNativeChannel uniWebViewNativeChannel) {
        super(0);
        this.a = u1;
        this.b = uniWebViewNativeChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        U1 u1 = this.a;
        UniWebViewNativeChannel uniWebViewNativeChannel = this.b;
        u1.getClass();
        UniWebViewInterface.channel = uniWebViewNativeChannel;
        return Unit.INSTANCE;
    }
}
