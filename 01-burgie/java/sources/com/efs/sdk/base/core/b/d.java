package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.controller.ControllerCenter;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements e {
    @Override // com.efs.sdk.base.core.b.e
    public final void a(com.efs.sdk.base.core.d.b bVar) throws Throwable {
        if (bVar.c == null) {
            return;
        }
        com.efs.sdk.base.core.util.b.a(new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(bVar)), bVar.c);
        com.efs.sdk.base.core.f.f.a.a.c.b();
        com.efs.sdk.base.core.f.f.a.a.c.c();
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(File file) throws Throwable {
        com.efs.sdk.base.core.util.b.a(file, com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
    }

    @Override // com.efs.sdk.base.core.b.e
    public final boolean a(File file, com.efs.sdk.base.core.d.b bVar) {
        if (!file.exists()) {
            return false;
        }
        bVar.d = file;
        bVar.c();
        bVar.b(1);
        return true;
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(String str) {
    }
}
