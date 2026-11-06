package com.bykv.vk.openvk.component.video.ms.xr.ka;

import com.bykv.vk.openvk.component.video.ms.xr.ny;
import com.bytedance.sdk.component.xr.ms.ao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends ms {
    private ao ah;

    public c(ao aoVar, ka kaVar) {
        com.bytedance.sdk.component.xr.ms.c cVarAb;
        this.ah = aoVar;
        this.f87ms = new ArrayList();
        if (aoVar != null && (cVarAb = aoVar.ab()) != null) {
            for (int i = 0; i < cVarAb.ms(); i++) {
                this.f87ms.add(new ny.xr(cVarAb.ms(i), cVarAb.xr(i)));
            }
        }
        this.xr = kaVar;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public int ms() {
        return this.ah.ah();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public boolean xr() {
        return this.ah.ah() >= 200 && this.ah.ah() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public String ms(String str, String str2) {
        return ms(str) != null ? ms(str).xr : str2;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public List<ny.xr> ah() {
        return this.f87ms;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public InputStream d() {
        return this.ah.c().ah();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public String ka() {
        ao aoVar = this.ah;
        return (aoVar == null || aoVar.x() == null) ? "http/1.1" : this.ah.x().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.ms
    public String c() {
        return ms(this.ah.ah());
    }
}
