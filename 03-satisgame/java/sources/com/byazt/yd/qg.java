package com.byazt.yd;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.qf.fs;
import com.byazt.yw.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 169, 26})
public class qg extends n {
    public qg(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strL = fs.n().l();
        if (TextUtils.isEmpty(strL) || "0".equals(strL)) {
            n(s());
            tj.n("[DeviceIdTask] did is null, continue check.");
        } else {
            fs.s().n(strL);
            tj.n("[DeviceIdTask] did is ".concat(String.valueOf(strL)));
        }
    }
}
