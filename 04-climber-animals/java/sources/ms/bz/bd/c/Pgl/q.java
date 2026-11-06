package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.api.plugin.xr;

/* JADX INFO: loaded from: classes4.dex */
final class q extends pbly.pgla {
    q() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        Context contextXr = pblv.ms().xr();
        String[] strArrSplit = str.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "33f239", new byte[]{30, 45}));
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        SharedPreferences.Editor editorEdit = xr.xr(contextXr, str2, 0).edit();
        editorEdit.putString(str3, (String) obj);
        editorEdit.commit();
        return null;
    }
}
