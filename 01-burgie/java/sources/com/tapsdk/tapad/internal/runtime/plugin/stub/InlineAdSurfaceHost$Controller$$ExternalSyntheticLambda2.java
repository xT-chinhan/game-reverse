package com.tapsdk.tapad.internal.runtime.plugin.stub;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ InlineAdSurfaceHost.Controller f$0;

    public /* synthetic */ InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda2(InlineAdSurfaceHost.Controller controller) {
        this.f$0 = controller;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.renderIfReady();
    }
}
