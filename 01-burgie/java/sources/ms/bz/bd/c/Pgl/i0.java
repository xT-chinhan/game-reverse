package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements j0.pgla {
    private final pblo hn;
    private final Context hw;
    private final long pr;

    i0(pblo pbloVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.hn = pbloVar;
        this.hw = context.getApplicationContext();
        this.pr = j;
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final Map<String, String> getFeatureHash(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            long j = this.pr;
            int i = pbls.pr;
            String[] strArr = (String[]) com.volcengine.mobsecBiz.matrix.pgla.a(33554438, 0, j, str, bArr);
            if (strArr != null && strArr.length % 2 == 0) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    String str2 = strArr[i2];
                    String str3 = strArr[i2 + 1];
                    if (str2 != null && str3 != null) {
                        map.put(str2, str3);
                    }
                }
            }
        }
        return map;
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final String getToken() {
        long j = this.pr;
        if (j == -1) {
            return "";
        }
        int i = pbls.pr;
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(33554439, 0, j, null, null);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final void report(String str) {
        if (this.pr == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.pr;
        Context context = this.hw;
        int i = pbls.pr;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final void setBDDeviceID(String str) {
        this.hn.d = str;
        long j = this.pr;
        if (j != -1) {
            Context context = this.hw;
            int i = pbls.pr;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554437, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final void setCollectMode(int i) {
        long j = this.pr;
        if (j != -1) {
            int i2 = pbls.pr;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554441, i, j, null, null);
        }
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final void setDeviceID(String str) {
        this.hn.c = str;
        long j = this.pr;
        if (j != -1) {
            Context context = this.hw;
            int i = pbls.pr;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.j0.pgla
    public final void setInstallID(String str) {
        this.hn.e = str;
        long j = this.pr;
        if (j != -1) {
            Context context = this.hw;
            int i = pbls.pr;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554435, 0, j, str, context);
        }
    }
}
