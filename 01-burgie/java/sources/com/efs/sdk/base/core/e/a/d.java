package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {
    private ILogEncryptAction b;

    public d() {
        if (ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.b = new com.efs.sdk.base.core.e.b();
        } else {
            this.b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        if ((1 != bVar.a.e) || "wa".equals(bVar.a.a) || Constants.LOG_TYPE_STARTPERF.equals(bVar.a.a) || (1 == bVar.a.b && !bVar.b.a) || 1 == bVar.a.c) {
            b(bVar);
            return;
        }
        byte[] bArrEncrypt = this.b.encrypt(ControllerCenter.getGlobalEnvStruct().getSecret(), bVar.c);
        if (bArrEncrypt != null) {
            bVar.a(bArrEncrypt);
            bVar.a(this.b.getDeVal());
        }
        b(bVar);
    }
}
