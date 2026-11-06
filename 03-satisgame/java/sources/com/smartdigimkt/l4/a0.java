package com.smartdigimkt.l4;

import android.os.FileObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends FileObserver {
    public final /* synthetic */ b0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(b0 b0Var, String str) {
        super(str, 2);
        this.a = b0Var;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (this.a.O.hasMessages(1)) {
            return;
        }
        this.a.O.sendEmptyMessageDelayed(1, 30L);
    }
}
