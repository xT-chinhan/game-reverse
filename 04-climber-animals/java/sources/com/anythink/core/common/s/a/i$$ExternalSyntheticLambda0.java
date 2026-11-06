package com.anythink.core.common.s.a;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ i f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ i$$ExternalSyntheticLambda0(i iVar, Runnable runnable) {
        this.f$0 = iVar;
        this.f$1 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.b(this.f$1);
    }
}
