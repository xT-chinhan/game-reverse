package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mcto.sspsdk.IQySplash;

/* JADX INFO: loaded from: classes2.dex */
public final class mi extends Handler {
    public final /* synthetic */ pi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi(pi piVar, Looper looper) {
        super(looper);
        this.a = piVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        pi piVar;
        fj fjVar;
        if (this.a.b.get() && (fjVar = (piVar = this.a).j) != null) {
            int i = piVar.g - 100;
            piVar.g = i;
            fjVar.a(i);
            pi piVar2 = this.a;
            int i2 = piVar2.h;
            if (i2 != -1 && piVar2.g > i2 * 1000 && !piVar2.d.get()) {
                a4 a4Var = new a4();
                pi piVar3 = this.a;
                a4Var.a = piVar3.j;
                a4Var.b = z3.AUTO_ACT;
                pi.a(piVar3, new b4(a4Var));
                this.a.h = -1;
            }
        }
        pi piVar4 = this.a;
        if (piVar4.g > 0) {
            piVar4.n.removeMessages(1);
            this.a.n.sendEmptyMessageDelayed(1, 100L);
            return;
        }
        piVar4.n.removeCallbacksAndMessages(null);
        IQySplash.IAdInteractionListener iAdInteractionListener = this.a.k;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdTimeOver();
        }
    }
}
