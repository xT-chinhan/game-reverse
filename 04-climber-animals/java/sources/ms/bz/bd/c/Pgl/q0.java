package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.xr;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class q0 extends pbly.pgla {
    q0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        File file = new File(xr.ms(pblv.ms().xr()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "300d4d", new byte[]{108, com.anythink.core.common.s.a.c.c, 80, 20, 10, 103, 49}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
