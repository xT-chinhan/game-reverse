package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.byazt.qyu.qg;

/* JADX INFO: loaded from: classes3.dex */
final class k extends pbls.pgla {
    k() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        Context contextQg = pblp.n().qg();
        String[] strArrSplit = str.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dababe", new byte[]{73, 127}));
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        SharedPreferences.Editor editorEdit = qg.qg(contextQg, str2, 0).edit();
        editorEdit.putString(str3, (String) obj);
        editorEdit.commit();
        return null;
    }
}
