package com.mcto.sspsdk.component.interaction;

import com.mcto.sspsdk.internal.u3;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements u3 {
    public final /* synthetic */ QyTwistView a;

    public c(QyTwistView qyTwistView) {
        this.a = qyTwistView;
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void a() {
        this.a.i = false;
        QyTwistView.b(this.a);
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void b() {
        this.a.i = true;
        this.a.c();
    }
}
