package com.bytedance.sdk.component.c.ah.ms.xr;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.c.qv;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements qv {
    private com.bytedance.sdk.component.c.ah.ms.ah<String, Bitmap> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1181ms;
    private int xr;

    public xr(int i, int i2) {
        this.xr = i;
        this.f1181ms = i2;
        this.ah = new com.bytedance.sdk.component.c.ah.ms.ah<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.c.ah.ms.xr.xr.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.c.ah.ms.ah
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int xr(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return xr.ms(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.c.ms
    public boolean ms(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.ah.ms(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.c.ms
    public Bitmap ms(String str) {
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

    public static int ms(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
