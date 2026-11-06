package com.mcto.sspsdk.ssp.taskpage;

import com.mcto.sspsdk.internal.f7;
import com.mcto.sspsdk.internal.kh;
import com.mcto.sspsdk.internal.vh;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f7 {
    public final /* synthetic */ QyTaskPageActivity a;

    public e(QyTaskPageActivity qyTaskPageActivity) {
        this.a = qyTaskPageActivity;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        this.a.y = false;
        kh.a.a(new c(this, vhVar));
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        this.a.y = true;
        kh.a.a(new d(this, vhVar, i));
    }
}
