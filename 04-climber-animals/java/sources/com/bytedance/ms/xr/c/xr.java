package com.bytedance.ms.xr.c;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    xr(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strKa = x.ms().ka();
        if (TextUtils.isEmpty(strKa) || "0".equals(strKa)) {
            ms(ah());
            ch.ms("[DeviceIdTask] did is null, continue check.");
        } else {
            x.ah().ms(strKa);
            ch.ms("[DeviceIdTask] did is ".concat(String.valueOf(strKa)));
        }
    }
}
