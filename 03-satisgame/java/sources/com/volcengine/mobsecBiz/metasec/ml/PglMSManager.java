package com.volcengine.mobsecBiz.metasec.ml;

import java.util.Map;
import ms.bz.bd.c.Pgl.i0;
import ms.bz.bd.c.Pgl.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class PglMSManager implements j0.pgla {
    private final j0.pgla a;

    PglMSManager(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        return this.a.getFeatureHash(str, bArr);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public String getToken() {
        return this.a.getToken();
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public void report(String str) {
        this.a.report(str);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public void setBDDeviceID(String str) {
        this.a.setBDDeviceID(str);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public void setCollectMode(int i) {
        this.a.setCollectMode(i);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public void setDeviceID(String str) {
        this.a.setDeviceID(str);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public void setInstallID(String str) {
        this.a.setInstallID(str);
    }
}
