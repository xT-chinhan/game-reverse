package ms.bz.bd.c.Pgl;

import com.byazt.qyu.qg;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class pblt extends pbls.pgla {
    pblt() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        File file = new File(qg.n(pblp.n().qg()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "152ee9", new byte[]{110, 58, 82, 21, 91, 58, 51}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
