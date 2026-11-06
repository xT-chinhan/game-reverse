package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.fi.BaseConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class vf extends Handler {
    public final /* synthetic */ wf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vf(wf wfVar, Looper looper) {
        super(looper);
        this.a = wfVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ag agVar;
        xf xfVar = this.a.a;
        synchronized (xfVar) {
            if (xfVar.f && !xfVar.e && (agVar = xfVar.b) != null) {
                boolean zA = agVar.a();
                while (!zA) {
                    ag agVar2 = (ag) xfVar.a.poll();
                    xfVar.b = agVar2;
                    if (agVar2 != null) {
                        zA = agVar2.a();
                    }
                }
                ag agVar3 = xfVar.b;
                int i = agVar3.f + 1;
                agVar3.f = i;
                if (agVar3.a - i > 0) {
                    agVar3.e = BaseConstants.Time.MINUTE;
                    xfVar.a.addLast(agVar3);
                }
                xfVar.b = null;
                xfVar.c();
            }
        }
    }
}
