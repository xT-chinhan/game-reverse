package com.tapsdk.tapad.internal;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WasmInterstitialPresenter$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ WasmInterstitialPresenter f$0;

    public /* synthetic */ WasmInterstitialPresenter$$ExternalSyntheticLambda2(WasmInterstitialPresenter wasmInterstitialPresenter) {
        this.f$0 = wasmInterstitialPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.finishWithClose();
    }
}
