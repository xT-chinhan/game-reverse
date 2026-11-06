package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.cc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pbla extends pbls.pgla {
    private static pbla pr;

    public static class pgla {
        private String hw;
        private long pr;

        public final void hw(String str, int i) {
            pbla pblaVarPr = pbla.pr();
            if (pblaVarPr == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.pr;
            pblaVarPr.hw(jCurrentTimeMillis - j, j, this.hw, str, i);
        }

        public final void pr(String str) {
            this.hw = str;
            this.pr = System.currentTimeMillis();
        }

        public final void pr(String str, int i) {
            pbla pblaVarPr = pbla.pr();
            if (pblaVarPr == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.pr;
            pblaVarPr.pr(jCurrentTimeMillis - j, j, this.hw, str, i);
        }
    }

    public static synchronized pbla pr() {
        return pr;
    }

    public static synchronized void pr(pbla pblaVar) {
        pr = pblaVar;
    }

    public abstract void hw(long j, long j2, String str, String str2, int i);

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !pr(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0310e9", new byte[]{cc.l, 26});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                pr(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void pr(long j, long j2, String str, String str2, int i);

    public abstract void pr(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean pr(String str);
}
