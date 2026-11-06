package ms.bz.bd.c.Pgl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pbla extends pbls.pgla {
    private static pbla n;

    public static class pgla {
        private long n;
        private String qg;

        public final void n(String str) {
            this.qg = str;
            this.n = System.currentTimeMillis();
        }

        public final void n(String str, int i) {
            pbla pblaVarN = pbla.n();
            if (pblaVarN == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.n;
            pblaVarN.n(jCurrentTimeMillis - j, j, this.qg, str, i);
        }

        public final void qg(String str, int i) {
            pbla pblaVarN = pbla.n();
            if (pblaVarN == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.n;
            pblaVarN.qg(jCurrentTimeMillis - j, j, this.qg, str, i);
        }
    }

    public static synchronized pbla n() {
        return n;
    }

    public static synchronized void n(pbla pblaVar) {
        n = pblaVar;
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !n(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0310e9", new byte[]{14, 26});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                n(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void n(long j, long j2, String str, String str2, int i);

    public abstract void n(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean n(String str);

    public abstract void qg(long j, long j2, String str, String str2, int i);
}
