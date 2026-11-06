package com.byazt.p;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 914, 5})
public class q {
    public final long l;
    public final s n;
    public Long q;
    public List<String> qg;
    public Long s;
    public boolean w;

    public q(s sVar, long j, boolean z) {
        this(sVar, j, null, z);
    }

    public q(s sVar, long j, List<String> list, boolean z) {
        if (sVar == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        this.l = j;
        this.n = sVar;
        this.qg = list;
        if (z) {
            n();
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
    public void n() {
        if (this.w) {
            return;
        }
        this.w = true;
        if (this.qg == null) {
            this.qg = new ArrayList();
        }
        l lVarD = this.n.d();
        long jQg = lVarD.qg();
        l lVarOa = this.n.oa();
        long jQg2 = lVarOa.qg();
        l lVarCp = this.n.cp();
        long jQg3 = lVarCp.qg();
        long j = 0;
        if (lVarD.n() == 0) {
            if (lVarCp.n() != 0) {
                this.q = Long.valueOf(jQg3 - this.l);
                this.qg.add("Error: zero orig time -- cannot compute delay");
                return;
            } else {
                this.qg.add("Error: zero orig time -- cannot compute delay/offset");
                return;
            }
        }
        if (lVarOa.n() == 0 || lVarCp.n() == 0) {
            this.qg.add("Warning: zero rcvNtpTime or xmitNtpTime");
            long j2 = this.l;
            if (jQg > j2) {
                this.qg.add("Error: OrigTime > DestRcvTime");
            } else {
                this.s = Long.valueOf(j2 - jQg);
            }
            if (lVarOa.n() != 0) {
                this.q = Long.valueOf(jQg2 - jQg);
                return;
            } else {
                if (lVarCp.n() != 0) {
                    this.q = Long.valueOf(jQg3 - this.l);
                    return;
                }
                return;
            }
        }
        long j3 = this.l - jQg;
        if (jQg3 < jQg2) {
            this.qg.add("Error: xmitTime < rcvTime");
        } else {
            long j4 = jQg3 - jQg2;
            if (j4 <= j3) {
                j = j3 - j4;
            } else if (j4 - j3 != 1) {
                this.qg.add("Warning: processing time > total network time");
            } else if (j3 != 0) {
                this.qg.add("Info: processing time > total network time by 1 ms -> assume zero delay");
            }
            this.s = Long.valueOf(j);
            if (jQg > this.l) {
                this.qg.add("Error: OrigTime > DestRcvTime");
            }
            this.q = Long.valueOf(((jQg2 - jQg) + (jQg3 - this.l)) / 2);
        }
        j = j3;
        this.s = Long.valueOf(j);
        if (jQg > this.l) {
            this.qg.add("Error: OrigTime > DestRcvTime");
        }
        this.q = Long.valueOf(((jQg2 - jQg) + (jQg3 - this.l)) / 2);
    }

    public s qg() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            q qVar = (q) obj;
            if (this.l == qVar.l && this.n.equals(qVar.n)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.l) * 31) + this.n.hashCode();
    }
}
