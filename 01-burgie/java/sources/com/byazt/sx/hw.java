package com.byazt.sx;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.vlj.zo;
import com.byazt.wf.vk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 892, 13})
public class hw extends pr {
    public hw(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strC = zo.pr().c();
        if (TextUtils.isEmpty(strC) || "0".equals(strC)) {
            pr(hn());
            vk.pr("[DeviceIdTask] did is null, continue check.");
        } else {
            zo.hn().pr(strC);
            vk.pr("[DeviceIdTask] did is ".concat(String.valueOf(strC)));
        }
    }
}
