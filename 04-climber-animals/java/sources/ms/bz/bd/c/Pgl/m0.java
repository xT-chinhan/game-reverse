package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class m0 implements n0.pgla {
    private final pblu ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long f4837ms;
    private final Context xr;

    m0(pblu pbluVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.ah = pbluVar;
        this.xr = context.getApplicationContext();
        this.f4837ms = j;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final Map<String, String> getFeatureHash(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            long j = this.f4837ms;
            int i = pbly.f4864ms;
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

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final String getToken() {
        long j = this.f4837ms;
        if (j == -1) {
            return "";
        }
        int i = pbly.f4864ms;
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(33554439, 0, j, null, null);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void report(String str) {
        if (this.f4837ms == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.f4837ms;
        Context context = this.xr;
        int i = pbly.f4864ms;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setBDDeviceID(String str) {
        this.ah.d = str;
        long j = this.f4837ms;
        if (j != -1) {
            Context context = this.xr;
            int i = pbly.f4864ms;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554437, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setCollectMode(int i) {
        long j = this.f4837ms;
        if (j != -1) {
            int i2 = pbly.f4864ms;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554441, i, j, null, null);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setDeviceID(String str) {
        this.ah.c = str;
        long j = this.f4837ms;
        if (j != -1) {
            Context context = this.xr;
            int i = pbly.f4864ms;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setInstallID(String str) {
        this.ah.e = str;
        long j = this.f4837ms;
        if (j != -1) {
            Context context = this.xr;
            int i = pbly.f4864ms;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554435, 0, j, str, context);
        }
    }
}
