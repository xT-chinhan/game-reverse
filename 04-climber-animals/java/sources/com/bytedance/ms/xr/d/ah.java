package com.bytedance.ms.xr.d;

import android.content.Context;
import com.bytedance.ms.xr.ka.ms.ka;
import com.bytedance.ms.xr.x.d;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f563ms;

    @Override // com.bytedance.ms.xr.d.xr
    public boolean ms(Throwable th) {
        return true;
    }

    @Override // com.bytedance.ms.xr.d.xr
    public void ms(long j, Thread thread, Throwable th) throws Throwable {
        com.bytedance.ms.xr.ah.ms msVarMs = com.bytedance.ms.xr.ah.ms.ms(j, this.f563ms, thread, th);
        d.ms(this.f563ms, com.bytedance.ms.xr.ah.JAVA.ms(), Thread.currentThread().getName());
        com.bytedance.ms.xr.ab.ms.ms().ms(ka.ms().ms(com.bytedance.ms.xr.ah.JAVA, msVarMs).ms());
    }

    public ah(Context context) {
        this.f563ms = context;
    }
}
