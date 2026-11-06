package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.xr.ms.ao;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.component.xr.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.component.ah.xr.ka f1605ms;

    public d(com.bytedance.sdk.component.ah.xr.ka kaVar) {
        this.f1605ms = kaVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public ao ms() throws IOException {
        return new ny(this.f1605ms.xr());
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public void ms(final com.bytedance.sdk.component.xr.ms.ah ahVar) {
        this.f1605ms.ms(new com.bytedance.sdk.component.ah.xr.c() { // from class: com.bytedance.sdk.component.xr.ms.ms.ms.d.1
            @Override // com.bytedance.sdk.component.ah.xr.c
            public void ms(com.bytedance.sdk.component.ah.xr.ka kaVar, IOException iOException) {
                ahVar.onFailure(new d(kaVar), iOException);
            }

            @Override // com.bytedance.sdk.component.ah.xr.c
            public void ms(com.bytedance.sdk.component.ah.xr.ka kaVar, cv cvVar) throws IOException {
                ahVar.onResponse(new d(kaVar), new ny(cvVar));
            }
        });
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public void xr() {
        this.f1605ms.ah();
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.xr.ms.xr clone() {
        return new d(this.f1605ms.ka());
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public boolean ah() {
        return this.f1605ms.d();
    }
}
