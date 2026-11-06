package com.byazt.qp;

import com.byazt.vf.fi;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 8})
public class s {
    public static com.byazt.xl.qg n() {
        return new com.byazt.xl.qg() { // from class: com.byazt.qp.s.1
            @Override // com.byazt.xl.qg
            public int q() {
                return 10000;
            }

            @Override // com.byazt.xl.qg
            public int qg() {
                return 10000;
            }

            @Override // com.byazt.xl.qg
            public int s() {
                return 10000;
            }

            @Override // com.byazt.xl.qg
            public int n() {
                return s.s("max_request_per_host", com.byazt.ed.qg.n().l());
            }

            @Override // com.byazt.xl.qg
            public Set<String> l() {
                return Collections.emptySet();
            }

            @Override // com.byazt.xl.qg
            public int w() {
                return s.s("max_request", 32);
            }

            @Override // com.byazt.xl.qg
            public List<com.byazt.qk.k> x() {
                return Collections.emptyList();
            }

            @Override // com.byazt.xl.qg
            public com.byazt.xl.s fs() {
                return new com.byazt.mw.q();
            }

            @Override // com.byazt.xl.qg
            public int rv() {
                return s.q("max_idle", -1);
            }

            @Override // com.byazt.xl.qg
            public int tj() {
                return s.s("keep_alive", -1);
            }

            @Override // com.byazt.xl.qg
            public int cp() {
                return s.q("ready_max_count", -1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(String str, int i) {
        int iL = l(str, i);
        return iL > 0 ? iL : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(String str, int i) {
        int iL = l(str, i);
        return iL >= 0 ? iL : i;
    }

    private static int l(String str, int i) {
        try {
            fi fiVar = (fi) q.n("strategy");
            if (fiVar == null) {
                return -1;
            }
            JSONObject jSONObjectN = fiVar.n("c_s_s_network_config", null);
            if (jSONObjectN != null && jSONObjectN.has(str) && !jSONObjectN.isNull(str)) {
                return jSONObjectN.optInt(str, i);
            }
        } catch (Throwable unused) {
        }
        return i;
    }
}
