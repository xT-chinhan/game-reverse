package com.tapsdk.tapad.internal.ionia;

import com.tapsdk.tapad.internal.runtime.WasmModule;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class IoniaIdentityManager$$ExternalSyntheticLambda0 implements IoniaIdentityManager.ExecFn {
    public final /* synthetic */ WasmModule f$0;

    public /* synthetic */ IoniaIdentityManager$$ExternalSyntheticLambda0(WasmModule wasmModule) {
        this.f$0 = wasmModule;
    }

    @Override // com.tapsdk.tapad.internal.ionia.IoniaIdentityManager.ExecFn
    public final byte[] exec(int i, byte[] bArr) {
        return this.f$0.callSecurityExecSync(i, bArr);
    }
}
