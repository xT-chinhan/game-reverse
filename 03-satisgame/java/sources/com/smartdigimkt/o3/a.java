package com.smartdigimkt.o3;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends CountDownTimer {
    public final /* synthetic */ b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, long j, long j2) {
        super(j, j2);
        this.a = bVar;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.a.a();
        this.a.c();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        b bVar = this.a;
        bVar.e = j;
        bVar.a(j);
    }
}
