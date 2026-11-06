package com.byazt.shr;

import com.byazt.gct.pk;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 33})
public class um {
    public pk l;
    public long n;
    public com.byazt.zsl.l q;
    public String qg;
    public int s;

    public um(long j, String str, int i, com.byazt.zsl.l lVar, pk pkVar) {
        this.n = j;
        this.qg = str;
        this.s = i;
        this.q = lVar;
        this.l = pkVar;
    }

    public long n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public com.byazt.zsl.l q() {
        return this.q;
    }

    public pk l() {
        return this.l;
    }

    @com.byazt.cp.n(n = {0, 1, 1216, 1217})
    public static class n {
        public int cp;
        public Map<String, Object> cy;
        public int d;
        public JSONArray k;
        public int oa;
        public int rv;
        public int tj;
        public long n = 0;
        public long qg = 0;
        public long s = 0;
        public long q = -1;
        public boolean l = false;
        public boolean w = false;
        public int x = 0;
        public int fs = 0;
        public boolean sz = false;

        public void n(JSONArray jSONArray) {
            this.k = jSONArray;
        }

        public JSONArray n() {
            return this.k;
        }

        public long qg() {
            return this.n;
        }

        public void n(long j) {
            this.n = j;
        }

        public long s() {
            return this.qg;
        }

        public void qg(long j) {
            this.qg = j;
        }

        public long q() {
            return this.s;
        }

        public void s(long j) {
            this.s = j;
        }

        public long l() {
            return this.q;
        }

        public void q(long j) {
            this.q = j;
        }

        public boolean w() {
            return this.q >= 0;
        }

        public int x() {
            return this.x;
        }

        public void n(int i) {
            this.x = i;
        }

        public int fs() {
            return this.fs;
        }

        public void qg(int i) {
            this.fs = i;
        }

        public int rv() {
            return this.rv;
        }

        public void s(int i) {
            this.rv = i;
        }

        public int tj() {
            return this.tj;
        }

        public void q(int i) {
            this.tj = i;
        }

        public int cp() {
            long j = this.s;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.n * 100) / j), 100);
        }

        public int d() {
            return this.cp;
        }

        public void l(int i) {
            this.cp = i;
        }

        public int oa() {
            return this.d;
        }

        public int sz() {
            return this.oa;
        }

        public void w(int i) {
            this.oa = i;
        }

        public boolean k() {
            return this.sz;
        }

        public void n(boolean z) {
            this.sz = z;
        }

        public boolean cy() {
            return this.l;
        }

        public void qg(boolean z) {
            this.l = z;
        }

        public void s(boolean z) {
            this.w = z;
        }

        public boolean hd() {
            return this.w;
        }

        public void n(Map<String, Object> map) {
            this.cy = map;
        }

        public Map<String, Object> cd() {
            return this.cy;
        }
    }
}
