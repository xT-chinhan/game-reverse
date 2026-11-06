package com.byazt.mf;

import com.byazt.qk.oa;
import com.byazt.qk.tj;
import com.byazt.tbt.cp;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1054, 5})
public class q implements oa {
    public final com.byazt.phf.q n;

    public q(com.byazt.phf.q qVar) {
        this.n = qVar;
    }

    @Override // com.byazt.qk.oa
    public int n() {
        return this.n.qg();
    }

    @Override // com.byazt.qk.oa
    public String qg() {
        return this.n.s();
    }

    @Override // com.byazt.qk.oa
    public Map<String, String> s() {
        return this.n.q();
    }

    @Override // com.byazt.qk.oa
    public String n(String str) {
        return this.n.q().get(str);
    }

    @Override // com.byazt.qk.oa
    public String n(String str, String str2) {
        return this.n.q().getOrDefault(str, str2);
    }

    @Override // com.byazt.qk.oa
    public byte[] q() {
        return this.n.cp();
    }

    @Override // com.byazt.qk.oa
    public JSONObject l() {
        String strL = this.n.l();
        if (strL == null) {
            return null;
        }
        try {
            return new JSONObject(strL);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.byazt.qk.oa
    public tj w() {
        final cp cpVarD = this.n.d();
        return new tj() { // from class: com.byazt.mf.q.1
            @Override // com.byazt.qk.tj
            public long n() {
                return cpVarD.n;
            }

            @Override // com.byazt.qk.tj
            public long qg() {
                return cpVarD.qg;
            }

            @Override // com.byazt.qk.tj
            public long s() {
                return cpVarD.s;
            }

            @Override // com.byazt.qk.tj
            public long q() {
                return cpVarD.q;
            }

            @Override // com.byazt.qk.tj
            public long l() {
                return cpVarD.l;
            }

            @Override // com.byazt.qk.tj
            public long w() {
                return cpVarD.w;
            }

            @Override // com.byazt.qk.tj
            public long x() {
                return cpVarD.x;
            }

            @Override // com.byazt.qk.tj
            public long fs() {
                return q.this.n.w();
            }

            @Override // com.byazt.qk.tj
            public long rv() {
                return q.this.n.x();
            }
        };
    }

    @Override // com.byazt.qk.oa
    public boolean x() {
        return this.n.rv();
    }

    @Override // com.byazt.qk.oa
    public String fs() {
        return this.n.l();
    }

    @Override // com.byazt.qk.oa
    public long rv() {
        return this.n.tj();
    }

    @Override // com.byazt.qk.oa
    public File tj() {
        return this.n.fs();
    }

    @Override // com.byazt.qk.oa
    public Throwable cp() {
        return this.n.n();
    }

    @Override // com.byazt.qk.oa
    public String d() {
        com.byazt.phf.q qVar = this.n;
        if (qVar != null) {
            return qVar.oa();
        }
        return null;
    }

    @Override // com.byazt.qk.oa
    public String oa() {
        com.byazt.phf.q qVar = this.n;
        if (qVar != null) {
            return qVar.sz();
        }
        return null;
    }
}
