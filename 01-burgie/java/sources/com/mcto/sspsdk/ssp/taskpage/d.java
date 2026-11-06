package com.mcto.sspsdk.ssp.taskpage;

import com.mcto.sspsdk.internal.vh;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {
    public final /* synthetic */ vh a;
    public final /* synthetic */ int b;
    public final /* synthetic */ e c;

    public d(e eVar, vh vhVar, int i) {
        this.c = eVar;
        this.a = vhVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.v.setVisibility(8);
        vh vhVar = this.a;
        if (vhVar != null && this.b != 1) {
            QyTaskPageActivity.a(this.c.a, vhVar);
            QyTaskPageActivity.a(this.c.a, (ArrayList) null);
        } else {
            if (this.c.a.B.get()) {
                QyTaskPageActivity.a(this.c.a, (ArrayList) null);
                return;
            }
            this.c.a.f.setVisibility(8);
            this.c.a.g.setText("网络异常\n任务加载失败，请检查网络后重试");
            this.c.a.h.setVisibility(0);
        }
    }
}
