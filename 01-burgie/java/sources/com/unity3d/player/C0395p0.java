package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0395p0 implements G {
    final /* synthetic */ RunnableC0397q0 a;

    C0395p0(RunnableC0397q0 runnableC0397q0) {
        this.a = runnableC0397q0;
    }

    public final void a() {
        RunnableC0397q0 runnableC0397q0 = this.a;
        runnableC0397q0.a = true;
        if (runnableC0397q0.b) {
            runnableC0397q0.c.release();
        }
    }
}
