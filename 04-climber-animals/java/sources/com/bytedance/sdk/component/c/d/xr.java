package com.bytedance.sdk.component.c.d;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private byte[] f1188ms;
    private com.bytedance.sdk.component.c.c xr;

    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "image_type";
    }

    public xr(byte[] bArr, com.bytedance.sdk.component.c.c cVar) {
        this.f1188ms = bArr;
        this.xr = cVar;
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(com.bytedance.sdk.component.c.ah.ah ahVar) {
        ny xVar;
        int iZb = ahVar.zb();
        ahVar.ms(this.f1188ms.length);
        if (iZb != 2) {
            if (iZb == 3) {
                byte[] bArr = this.f1188ms;
                xVar = new zb(bArr, bArr, this.xr, com.bytedance.sdk.component.c.ah.ah.ms.xr(bArr));
            } else {
                boolean zXr = com.bytedance.sdk.component.c.ah.ah.ms.xr(this.f1188ms);
                if (zXr) {
                    byte[] bArr2 = this.f1188ms;
                    xVar = new zb(bArr2, bArr2, this.xr, zXr);
                } else if (com.bytedance.sdk.component.c.ah.ah.ms.ms(this.f1188ms)) {
                    xVar = new ka(this.f1188ms, this.xr);
                } else {
                    byte[] bArr3 = this.f1188ms;
                    xVar = new zb(bArr3, bArr3, this.xr, zXr);
                }
            }
        } else if (com.bytedance.sdk.component.c.ah.ah.ms.ms(this.f1188ms)) {
            xVar = new ka(this.f1188ms, this.xr);
        } else if (this.xr == null) {
            xVar = new hi();
        } else {
            xVar = new x(1001, "not image format", null);
        }
        ahVar.ms(xVar);
    }
}
