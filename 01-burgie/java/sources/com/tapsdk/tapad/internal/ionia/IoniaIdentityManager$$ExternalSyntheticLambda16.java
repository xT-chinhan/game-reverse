package com.tapsdk.tapad.internal.ionia;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class IoniaIdentityManager$$ExternalSyntheticLambda16 implements Runnable {
    public final /* synthetic */ IoniaIdentityManager f$0;

    public /* synthetic */ IoniaIdentityManager$$ExternalSyntheticLambda16(IoniaIdentityManager ioniaIdentityManager) {
        this.f$0 = ioniaIdentityManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.applyPrivacyPolicy();
    }
}
