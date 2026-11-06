package com.anythink.dlopt.common.a;

import com.anythink.core.common.h.bj;
import com.anythink.dlopt.api.ATApk;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ATApk {
    private j a;

    private b(j jVar) {
        this.a = jVar;
    }

    private j a() {
        return this.a;
    }

    @Override // com.anythink.dlopt.api.ATApk
    public final String getPackageName() {
        j jVar = this.a;
        return jVar != null ? jVar.e : "";
    }

    @Override // com.anythink.dlopt.api.ATApk
    public final String getTitle() {
        j jVar = this.a;
        return jVar != null ? jVar.c : "";
    }

    @Override // com.anythink.dlopt.api.ATApk
    public final String getDesc() {
        j jVar = this.a;
        return (jVar == null || jVar.j == null) ? "" : this.a.j.y();
    }

    @Override // com.anythink.dlopt.api.ATApk
    public final String getAppName() {
        j jVar = this.a;
        return (jVar == null || !(jVar.j instanceof bj)) ? "" : ((bj) this.a.j).aK();
    }

    @Override // com.anythink.dlopt.api.ATApk
    public final String getLogoUrl() {
        j jVar = this.a;
        return (jVar == null || jVar.j == null) ? "" : this.a.j.z();
    }
}
