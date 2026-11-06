package com.mcto.sspsdk.component.interaction;

import com.mcto.sspsdk.internal.u3;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements u3 {
    public final /* synthetic */ QySharkView a;

    public b(QySharkView qySharkView) {
        this.a = qySharkView;
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void a() {
        this.a.c = false;
        QySharkView.d(this.a);
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void b() {
        this.a.c = true;
        QySharkView.c(this.a);
    }
}
