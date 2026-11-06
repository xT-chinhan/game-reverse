package ms.bz.bd.c.Pgl;

import com.byazt.qyu.qg;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class m0 extends pbls.pgla {
    m0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        File file = new File(qg.n(pblp.n().qg()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6e9737", new byte[]{105, 106, 89, 71, 13, 52, 52}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
