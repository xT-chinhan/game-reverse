package com.bytedance.sdk.openadsdk.core.t;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class sl implements com.bytedance.sdk.component.x.ms.ms.c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.component.ny.xr.ka f3316ms;

    sl(com.bytedance.sdk.component.ny.xr.ka kaVar) {
        this.f3316ms = kaVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.c
    public void ms(String str) {
        com.bytedance.sdk.component.ny.xr.ka kaVar = this.f3316ms;
        if (kaVar != null) {
            kaVar.ms(str);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.c
    public void ms(String str, byte[] bArr) {
        com.bytedance.sdk.component.ny.xr.ka kaVar = this.f3316ms;
        if (kaVar != null) {
            kaVar.ms(str, bArr);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.c
    public void ms(String str, String str2) {
        com.bytedance.sdk.component.ny.xr.ka kaVar = this.f3316ms;
        if (kaVar != null) {
            kaVar.xr(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.c
    public void xr(String str) {
        com.bytedance.sdk.component.ny.xr.ka kaVar = this.f3316ms;
        if (kaVar != null) {
            kaVar.ah(str);
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.c
    public com.bytedance.sdk.component.x.ms.ms.ka ms() {
        if (this.f3316ms == null) {
            return null;
        }
        return new hi(this.f3316ms.ms());
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.c
    public void ms(final com.bytedance.sdk.component.x.ms.ms.ah ahVar) {
        com.bytedance.sdk.component.ny.xr.ka kaVar = this.f3316ms;
        if (kaVar != null) {
            kaVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.t.sl.1
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (ahVar != null) {
                        ahVar.ms(new c(dVar), new ab(xrVar));
                    }
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    if (ahVar != null) {
                        ahVar.ms(new c(dVar), iOException);
                    }
                }
            });
        }
    }
}
