package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C0867p0 implements G {
    final /* synthetic */ RunnableC0869q0 a;

    C0867p0(RunnableC0869q0 runnableC0869q0) {
        this.a = runnableC0869q0;
    }

    public final void a() {
        RunnableC0869q0 runnableC0869q0 = this.a;
        runnableC0869q0.a = true;
        if (runnableC0869q0.b) {
            runnableC0869q0.c.release();
        }
    }
}
