package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.controller.ControllerCenter;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        com.efs.sdk.base.core.b.e eVarA;
        if (bVar.b.a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.b.a aVar = com.efs.sdk.base.core.b.a.b.a;
        if (!"wa".equals(bVar.a.a) && !com.efs.sdk.base.core.b.c.a().a) {
            if (!aVar.a) {
                com.efs.sdk.base.core.f.f fVar = com.efs.sdk.base.core.f.f.a.a;
                int i = com.efs.sdk.base.core.config.a.c.a().d.a;
                if (fVar.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    fVar.b.send(fVar.a("disk_limit", i));
                }
            }
            aVar.a = true;
            return;
        }
        if ((bVar.a.c == 0 && (bVar.c == null || bVar.c.length == 0)) || (eVarA = aVar.c.a(bVar.a.b)) == null) {
            return;
        }
        eVarA.a(bVar);
    }
}
