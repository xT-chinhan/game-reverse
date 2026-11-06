package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.xr;
import com.umeng.analytics.pro.ek;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class pblz extends pbly.pgla {
    pblz() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        File file = new File(xr.ms(pblv.ms().xr()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d1fb10", new byte[]{59, 62, 6, 18, ek.m, 51, 102}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
