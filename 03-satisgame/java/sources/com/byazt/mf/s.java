package com.byazt.mf;

import android.text.TextUtils;
import android.util.Pair;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qk.x;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1054, 8})
public class s implements rv {
    public com.byazt.qk.n cp;
    public File cy;
    public x d;
    public Map<String, String> fs;
    public boolean hd;
    public JSONObject k;
    public Map<String, String> l;
    public final com.byazt.xl.qg n;
    public Map<String, String> oa;
    public String q;
    public final com.byazt.phf.qg qg;
    public Map<String, Pair<String, byte[]>> rv;
    public int s;
    public Map<String, Object> sz;
    public Pair<String, byte[]> tj;
    public String w;
    public byte[] x;

    public s(com.byazt.xl.qg qgVar, com.byazt.phf.qg qgVar2) {
        this.n = qgVar;
        this.qg = qgVar2;
    }

    @Override // com.byazt.qk.rv
    public rv n(int i) {
        this.s = i;
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str) {
        this.q = str;
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str, String str2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        this.l.put(str, str2);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv qg(String str) {
        this.w = str;
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(byte[] bArr) {
        this.x = bArr;
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv qg(String str, String str2) {
        if (str == null) {
            return this;
        }
        if (this.oa == null) {
            this.oa = new HashMap();
        }
        this.oa.put(str, str2);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv s(String str, String str2) {
        if (this.s != 2) {
            throw new IllegalArgumentException("Only POST method support multipart body");
        }
        if (this.fs == null) {
            this.fs = new HashMap();
        }
        this.fs.put(str, str2);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str, String str2, byte[] bArr) {
        if (this.s != 2) {
            throw new IllegalArgumentException("Only POST method support multipart body");
        }
        if (this.rv == null) {
            this.rv = new HashMap();
        }
        this.rv.put(str2, new Pair<>(str2, bArr));
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str, byte[] bArr) {
        if (this.s != 2) {
            throw new IllegalArgumentException("Only POST method support multipart body");
        }
        this.tj = new Pair<>(str, bArr);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(com.byazt.qk.n nVar) {
        this.cp = nVar;
        return this;
    }

    private com.byazt.vcq.s w() {
        com.byazt.vcq.s sVarX;
        int i = this.s;
        if (i == 2) {
            sVarX = x();
        } else if (i == 1) {
            final com.byazt.vcq.qg qgVar = new com.byazt.vcq.qg(this.qg.n());
            Map<String, String> map = this.oa;
            if (map != null) {
                map.forEach(new BiConsumer<String, String>() { // from class: com.byazt.mf.s.1
                    @Override // java.util.function.BiConsumer
                    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                    public void accept(String str, String str2) {
                        qgVar.n(str, str2);
                    }
                });
            }
            qgVar.n(this.hd);
            sVarX = qgVar;
        } else if (i == 3) {
            com.byazt.vcq.n nVar = new com.byazt.vcq.n(this.qg.n());
            nVar.n(this.cy.getParent(), this.cy.getName());
            sVarX = nVar;
        } else {
            throw new IllegalArgumentException("method " + this.s + " is not supported");
        }
        sVarX.n(this.q);
        Map<String, String> map2 = this.l;
        if (map2 != null) {
            sVarX.q(map2);
        }
        sVarX.l(this.sz);
        return sVarX;
    }

    private com.byazt.vcq.s x() {
        com.byazt.vcq.q qVar = new com.byazt.vcq.q(this.qg.n());
        n(qVar);
        return qVar;
    }

    private void n(com.byazt.vcq.q qVar) {
        JSONObject jSONObject = this.k;
        if (jSONObject != null) {
            qVar.s(jSONObject.toString());
            return;
        }
        Pair<String, byte[]> pair = this.tj;
        if (pair != null) {
            qVar.n((String) pair.first, (byte[]) this.tj.second);
            return;
        }
        Map<String, String> map = this.oa;
        if (map != null) {
            qVar.n(map);
            return;
        }
        String str = this.w;
        if (str != null) {
            qVar.s(str);
        } else if (this.x != null) {
            qVar.n(true);
            qVar.n("application/octet-stream", this.x);
        }
    }

    @Override // com.byazt.qk.rv
    public oa n() {
        return new q(w().n());
    }

    @Override // com.byazt.qk.rv
    public void n(x xVar) {
        this.d = xVar;
        w().n(new com.byazt.dgx.n() { // from class: com.byazt.mf.s.2
            @Override // com.byazt.dgx.n
            public void n(com.byazt.vcq.s sVar, com.byazt.phf.q qVar) {
                if (s.this.d == null) {
                    return;
                }
                s.this.d.n(new q(qVar));
            }

            @Override // com.byazt.dgx.n
            public void n(com.byazt.vcq.s sVar, IOException iOException) {
                if (s.this.d == null) {
                    return;
                }
                s.this.d.n(0, "onFailure", iOException);
            }
        });
    }

    @Override // com.byazt.qk.rv
    public void qg() {
        com.byazt.vcq.s sVarW = w();
        if (sVarW != null) {
            sVarW.s();
        }
    }

    @Override // com.byazt.qk.rv
    public byte[] s() {
        if (!TextUtils.isEmpty(this.w)) {
            return this.w.getBytes();
        }
        byte[] bArr = this.x;
        return bArr != null ? bArr : new byte[0];
    }

    @Override // com.byazt.qk.rv
    public rv n(Map<String, Object> map) {
        this.sz = map;
        return this;
    }

    @Override // com.byazt.qk.rv
    public Map<String, Object> q() {
        return this.sz;
    }

    @Override // com.byazt.qk.rv
    public rv n(JSONObject jSONObject) {
        this.k = jSONObject;
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv q(String str, String str2) {
        this.cy = new File(str, str2);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv l() {
        this.hd = true;
        return this;
    }
}
