package com.smartdigimkt.x2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Handler {
    public final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, Looper looper) {
        super(looper);
        this.a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int size;
        b[] bVarArr;
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        d dVar = this.a;
        while (true) {
            synchronized (dVar.b) {
                size = dVar.d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                dVar.d.toArray(bVarArr);
                dVar.d.clear();
            }
            for (int i = 0; i < size; i++) {
                b bVar = bVarArr[i];
                int size2 = bVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = (c) bVar.b.get(i2);
                    if (!cVar.d) {
                        cVar.b.onReceive(dVar.a, bVar.a);
                    }
                }
            }
        }
    }
}
