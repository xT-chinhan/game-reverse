package com.byazt.wq;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.byazt.gct.dg;
import com.byazt.gct.pk;
import com.byazt.ivn.l;
import com.byazt.llp.cp;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.op.q;
import com.byazt.op.s;
import com.byazt.op.x;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1099, 26})
public class qg {
    public final q n;

    private qg() {
        if (!l.n()) {
            this.n = new com.byazt.op.qg();
            return;
        }
        if (tj.fs) {
            this.n = new x();
        } else if (tj.fs()) {
            this.n = new com.byazt.op.l();
        } else {
            this.n = new com.byazt.op.qg();
        }
    }

    public static final qg n() {
        return n.n;
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        this.n.n(function);
    }

    public int n(Context context, cp cpVar, Map<String, Object> map) {
        if (context == null || cpVar == null) {
            return 5;
        }
        return this.n.n(context, cpVar, map);
    }

    public int n(Context context, long j) {
        return this.n.n(context, j);
    }

    public void n(String str, boolean z) {
        this.n.n(str, z);
    }

    public int n(cp cpVar, s sVar, String str, Map<String, Object> map) {
        return this.n.n(cpVar, sVar, str, map);
    }

    public int n(Context context, pk pkVar, Map<String, Object> map) {
        return this.n.n(context, pkVar, map);
    }

    public boolean n(pk pkVar) {
        return this.n.a_(pkVar);
    }

    public void n(String str, pk pkVar, long j) {
        this.n.n(str, pkVar, j);
    }

    public boolean qg(pk pkVar) {
        if (pkVar == null || TextUtils.isEmpty(pkVar.tj())) {
            return false;
        }
        return n(pkVar.tj(), pkVar.l());
    }

    public boolean n(String str, int i) {
        return this.n.n(str, i);
    }

    public void qg() {
        this.n.n();
    }

    public int s() {
        return this.n.qg();
    }

    public int s(pk pkVar) {
        if (rv.qg().fb()) {
            return this.n.qg(pkVar);
        }
        return 0;
    }

    public void q() {
        this.n.q();
    }

    public int l() {
        return this.n.l();
    }

    public void q(final pk pkVar) {
        if (pkVar == null) {
            return;
        }
        l(pkVar);
        if (TextUtils.isEmpty(pkVar.tj())) {
            return;
        }
        int iQg = com.byazt.ed.s.n().qg() + 1;
        if (iQg > 100) {
            iQg = 100;
        }
        com.byazt.ed.s.n().n(iQg);
        final int iS = s();
        final int iL = l();
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        if (pkVar.l() == 1 && pkVar.gf() == 1) {
            com.byazt.eji.s.n().n("saas_miss", new com.byazt.rs.n() { // from class: com.byazt.wq.qg.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ext", pkVar.F_());
                        jSONObject2.put("live_sdk_status", iS);
                        jSONObject2.put("live_auth_status", iL);
                        jSONObject2.put("app_start_time", jElapsedRealtime);
                        jSONObject2.put("is_web", pkVar.B_());
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    public int w() {
        return com.byazt.ed.s.n().qg();
    }

    public String x() {
        return this.n.x();
    }

    public void n(View view, dg dgVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || dgVar == null || (tag = view.getTag(TTAdConstant.KEY_CLICK_AREA)) == null || !(tag instanceof Integer)) {
            return;
        }
        int iIntValue = ((Integer) tag).intValue();
        int i = iIntValue & 255;
        int i2 = (iIntValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (i == 101 && !dgVar.s()) {
            i = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i));
        map2.put("click_saas_area", Integer.valueOf(i2));
    }

    public JSONObject fs() {
        return this.n.fs();
    }

    public int n(String str) {
        return this.n.n(str);
    }

    public int n(com.byazt.wc.qg qgVar, boolean z) {
        return this.n.n(qgVar, z);
    }

    public void l(pk pkVar) {
        this.n.s(pkVar);
    }

    public void n(com.byazt.hnb.q qVar) {
        this.n.n(qVar);
    }

    public long rv() {
        return this.n.s();
    }

    public boolean w(pk pkVar) {
        return pkVar != null && pkVar.ta() == 2;
    }

    @com.byazt.cp.n(n = {0, 1, 1099, 48})
    private static final class n {
        public static final qg n = new qg();
    }
}
