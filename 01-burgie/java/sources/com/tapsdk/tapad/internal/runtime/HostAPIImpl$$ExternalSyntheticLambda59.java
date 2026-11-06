package com.tapsdk.tapad.internal.runtime;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class HostAPIImpl$$ExternalSyntheticLambda59 implements Runnable {
    public final /* synthetic */ HostAPIImpl f$0;

    public /* synthetic */ HostAPIImpl$$ExternalSyntheticLambda59(HostAPIImpl hostAPIImpl) {
        this.f$0 = hostAPIImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.cancelHapticVibrationNow();
    }
}
