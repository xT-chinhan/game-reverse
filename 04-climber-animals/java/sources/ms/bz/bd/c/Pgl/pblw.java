package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.ek;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pblw extends pbly.pgla {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static pblw f4862ms;

    public static class pgla {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private long f4863ms;
        private String xr;

        public final void ms(String str) {
            this.xr = str;
            this.f4863ms = System.currentTimeMillis();
        }

        public final void ms(String str, int i) {
            pblw pblwVarMs = pblw.ms();
            if (pblwVarMs == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f4863ms;
            pblwVarMs.ms(jCurrentTimeMillis - j, j, this.xr, str, i);
        }

        public final void xr(String str, int i) {
            pblw pblwVarMs = pblw.ms();
            if (pblwVarMs == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f4863ms;
            pblwVarMs.xr(jCurrentTimeMillis - j, j, this.xr, str, i);
        }
    }

    public static synchronized pblw ms() {
        return f4862ms;
    }

    public static synchronized void ms(pblw pblwVar) {
        f4862ms = pblwVar;
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !ms(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "07895f", new byte[]{ek.l, 30});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                ms(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void ms(long j, long j2, String str, String str2, int i);

    public abstract void ms(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean ms(String str);

    public abstract void xr(long j, long j2, String str, String str2, int i);
}
