package com.byazt.tbt;

import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 110})
public abstract class sz {
    public d n;

    public k fs() {
        return null;
    }

    public String l() {
        return null;
    }

    public abstract Object n();

    public abstract String q();

    public abstract x qg();

    public abstract Map<String, List<String>> w();

    public abstract com.byazt.tbt.n x();

    public String s() {
        x xVarQg = qg();
        if (xVarQg == null) {
            return null;
        }
        return xVarQg.toString();
    }

    public void n(d dVar) {
        this.n = dVar;
    }

    public n rv() {
        return new n(this);
    }

    @com.byazt.cp.n(n = {0, 1, 1089, 1222})
    public static class n {
        public w.n fs;
        public String l;
        public com.byazt.tbt.n n;
        public String q;
        public Map<String, List<String>> qg;
        public x s;
        public Object w;
        public k x;

        public n() {
            this.qg = new HashMap();
            this.fs = new w.n();
        }

        public n n(com.byazt.tbt.n nVar) {
            this.n = nVar;
            return this;
        }

        public n(sz szVar) {
            this.s = szVar.qg();
            this.q = szVar.q();
            this.l = szVar.l();
            this.qg = szVar.w();
            this.w = szVar.n();
            this.x = szVar.fs();
            this.n = szVar.x();
        }

        public n n(Object obj) {
            this.w = obj;
            return this;
        }

        public n n(String str) {
            this.l = str;
            return this;
        }

        public n qg(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            x xVarS = x.s(str);
            if (xVarS == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return n(xVarS);
        }

        public n n(x xVar) {
            this.s = xVar;
            return this;
        }

        public n n(String str, String str2) {
            return qg(str, str2);
        }

        public n n(w wVar) {
            if (wVar != null) {
                this.qg = wVar.qg();
            }
            return this;
        }

        public n qg(String str, String str2) {
            if (!this.qg.containsKey(str)) {
                this.qg.put(str, new ArrayList());
            }
            this.qg.get(str).add(str2);
            return this;
        }

        public n n() {
            return n(TapHttp.METHOD_GET, (k) null);
        }

        public n n(String str, k kVar) {
            this.q = str;
            this.x = kVar;
            return this;
        }

        public n n(k kVar) {
            return n(TapHttp.METHOD_POST, kVar);
        }

        public sz qg() {
            return new sz() { // from class: com.byazt.tbt.sz.n.1
                public String toString() {
                    return "";
                }

                @Override // com.byazt.tbt.sz
                public Object n() {
                    return n.this.w;
                }

                @Override // com.byazt.tbt.sz
                public x qg() {
                    return n.this.s;
                }

                @Override // com.byazt.tbt.sz
                public String q() {
                    return n.this.q;
                }

                @Override // com.byazt.tbt.sz
                public String l() {
                    return n.this.l;
                }

                @Override // com.byazt.tbt.sz
                public Map w() {
                    return n.this.qg;
                }

                @Override // com.byazt.tbt.sz
                public com.byazt.tbt.n x() {
                    return n.this.n;
                }

                @Override // com.byazt.tbt.sz
                public k fs() {
                    return n.this.x;
                }
            };
        }
    }
}
