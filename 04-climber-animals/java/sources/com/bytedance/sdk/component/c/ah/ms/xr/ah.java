package com.bytedance.sdk.component.c.ah.ms.xr;

import com.bytedance.sdk.component.c.y;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements y {
    private com.bytedance.sdk.component.c.ah.ms.ah<String, byte[]> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1178ms;
    private int xr;

    public ah(int i, int i2) {
        this.xr = i;
        this.f1178ms = i2;
        this.ah = new com.bytedance.sdk.component.c.ah.ms.ah<String, byte[]>(i) { // from class: com.bytedance.sdk.component.c.ah.ms.xr.ah.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.c.ah.ms.ah
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int xr(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.c.ms
    public boolean ms(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.ah.ms(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.c.ms
    public byte[] ms(String str) {
        return this.ah.ms(str);
    }

    @Override // com.bytedance.sdk.component.c.ms
    public boolean xr(String str) {
        return this.ah.ms(str) != null;
    }

    @Override // com.bytedance.sdk.component.c.ms
    public void ms(double d) {
        this.ah.ms((int) (((double) this.xr) * d));
    }
}
