package com.bytedance.sdk.component.xr.ms.ms;

import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.xr.ms.ms.ms.c;
import com.bytedance.sdk.component.xr.ms.ms.xr.ah;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f1602ms;
    private static AtomicBoolean xr = new AtomicBoolean(true);

    private ms() {
    }

    public static ms ms() {
        if (f1602ms == null) {
            synchronized (ms.class) {
                if (f1602ms == null) {
                    f1602ms = new ms();
                }
            }
        }
        return f1602ms;
    }

    public void ms(boolean z) {
        sl.ms("NetClientAdapter", "set useOkHttp:".concat(String.valueOf(z)));
        xr.set(z);
    }

    public boolean xr() {
        AtomicBoolean atomicBoolean = xr;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static com.bytedance.sdk.component.xr.ms.sl ms(com.bytedance.sdk.component.xr.ms.sl.ms msVar) {
        return new ah(msVar);
    }

    public static com.bytedance.sdk.component.xr.ms.sl ms(re.ms msVar) {
        return new c(msVar);
    }
}
