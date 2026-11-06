package com.bytedance.sdk.openadsdk.core.re.ms;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.sl;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private Bitmap ah;
    private List<Object> d;
    private Map<String, String> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f3302ms;
    private byte[] xr;

    public xr(byte[] bArr, int i) {
        this.ah = null;
        this.d = null;
        this.ka = null;
        this.xr = bArr;
        this.f3302ms = i;
    }

    public xr(Bitmap bitmap, int i) {
        this.xr = null;
        this.d = null;
        this.ka = null;
        this.ah = bitmap;
        this.f3302ms = i;
    }

    public Bitmap ms() {
        return this.ah;
    }

    public int xr() {
        return this.f3302ms;
    }

    public byte[] ah() {
        try {
            if (this.xr == null) {
                this.xr = d.xr(this.ah);
            }
        } catch (OutOfMemoryError e) {
            sl.ms(e);
        }
        return this.xr;
    }

    public boolean d() {
        if (this.ah != null) {
            return true;
        }
        byte[] bArr = this.xr;
        return bArr != null && bArr.length > 0;
    }

    public boolean ka() {
        byte[] bArr = this.xr;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
