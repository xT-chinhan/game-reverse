package com.byazt.gaz;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1689, 121})
public class x {
    public final long c;
    public Long hn;
    public List<String> hw;
    public final hn pr;
    public boolean uc;
    public Long x;

    public x(hn hnVar, long j, boolean z) {
        this(hnVar, j, null, z);
    }

    public x(hn hnVar, long j, List<String> list, boolean z) {
        if (hnVar == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        this.c = j;
        this.pr = hnVar;
        this.hw = list;
        if (z) {
            pr();
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
    public void pr() {
        if (!this.uc) {
            this.uc = true;
            if (this.hw == null) {
                this.hw = new ArrayList();
            }
            c cVarK = this.pr.k();
            long jHw = cVarK.hw();
            c cVarM = this.pr.m();
            long jHw2 = cVarM.hw();
            c cVarW = this.pr.w();
            long jHw3 = cVarW.hw();
            long j = 0;
            if (cVarK.pr() == 0) {
                if (cVarW.pr() != 0) {
                    this.x = Long.valueOf(jHw3 - this.c);
                    this.hw.add("Error: zero orig time -- cannot compute delay");
                    return;
                } else {
                    this.hw.add("Error: zero orig time -- cannot compute delay/offset");
                    return;
                }
            }
            if (cVarM.pr() == 0 || cVarW.pr() == 0) {
                this.hw.add("Warning: zero rcvNtpTime or xmitNtpTime");
                long j2 = this.c;
                if (jHw <= j2) {
                    this.hn = Long.valueOf(j2 - jHw);
                } else {
                    this.hw.add("Error: OrigTime > DestRcvTime");
                }
                if (cVarM.pr() != 0) {
                    this.x = Long.valueOf(jHw2 - jHw);
                    return;
                } else {
                    if (cVarW.pr() != 0) {
                        this.x = Long.valueOf(jHw3 - this.c);
                        return;
                    }
                    return;
                }
            }
            long j3 = this.c - jHw;
            if (jHw3 < jHw2) {
                this.hw.add("Error: xmitTime < rcvTime");
            } else {
                long j4 = jHw3 - jHw2;
                if (j4 <= j3) {
                    j = j3 - j4;
                } else if (j4 - j3 != 1) {
                    this.hw.add("Warning: processing time > total network time");
                } else if (j3 != 0) {
                    this.hw.add("Info: processing time > total network time by 1 ms -> assume zero delay");
                }
                this.hn = Long.valueOf(j);
                if (jHw > this.c) {
                    this.hw.add("Error: OrigTime > DestRcvTime");
                }
                this.x = Long.valueOf(((jHw2 - jHw) + (jHw3 - this.c)) / 2);
            }
            j = j3;
            this.hn = Long.valueOf(j);
            if (jHw > this.c) {
                this.hw.add("Error: OrigTime > DestRcvTime");
            }
            this.x = Long.valueOf(((jHw2 - jHw) + (jHw3 - this.c)) / 2);
        }
    }

    public hn hw() {
        return this.pr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        if (this.c == xVar.c && this.pr.equals(xVar.pr)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.c) * 31) + this.pr.hashCode();
    }
}
