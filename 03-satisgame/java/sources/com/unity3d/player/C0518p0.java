package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0518p0 implements G {
    final /* synthetic */ RunnableC0520q0 a;

    C0518p0(RunnableC0520q0 runnableC0520q0) {
        this.a = runnableC0520q0;
    }

    public final void a() {
        RunnableC0520q0 runnableC0520q0 = this.a;
        runnableC0520q0.a = true;
        if (runnableC0520q0.b) {
            runnableC0520q0.c.release();
        }
    }
}
