package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.hi;
import com.bytedance.sdk.component.xr.ms.zb;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends ao {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public cv f1608ms;

    public ny(cv cvVar) {
        this.f1608ms = cvVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public long ms() {
        return this.f1608ms.u();
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public long xr() {
        return this.f1608ms.zb();
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public int ah() {
        cv cvVar = this.f1608ms;
        if (cvVar != null) {
            return cvVar.ah();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public boolean d() {
        return this.f1608ms.d();
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public String ka() {
        return this.f1608ms.ka();
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public h c() {
        return new ch(this.f1608ms.x());
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public com.bytedance.sdk.component.xr.ms.c ab() {
        return new com.bytedance.sdk.component.xr.ms.c(this.f1608ms.ab().f1136ms);
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public String ms(String str) {
        return this.f1608ms.ms(str);
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public String ms(String str, String str2) {
        return this.f1608ms.ms(str, str2);
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1608ms.close();
    }

    public String toString() {
        return this.f1608ms.toString();
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public zb x() {
        try {
            return zb.ms(this.f1608ms.xr().toString());
        } catch (Exception unused) {
            return zb.HTTP_1_1;
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.ao
    public hi ny() {
        if (this.f1608ms == null) {
            return null;
        }
        return new hi(this.f1608ms.ub());
    }
}
