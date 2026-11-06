package com.byazt.prf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 19})
public class n implements fs.n {
    public int fs;
    public final boolean l;
    public final ArrayList<qg> n;
    public Runnable q;
    public final ArrayList<qg> qg;
    public final InterfaceC0304n s;
    public final fs w;
    public com.byazt.ip.q.n<qg> x;

    /* JADX INFO: renamed from: com.byazt.prf.n$n, reason: collision with other inner class name */
    interface InterfaceC0304n {
        RecyclerView.m n(int i);

        void n(int i, int i2);

        void n(int i, int i2, Object obj);

        void n(qg qgVar);

        void q(int i, int i2);

        void qg(int i, int i2);

        void qg(qg qgVar);

        void s(int i, int i2);
    }

    public n(InterfaceC0304n interfaceC0304n) {
        this(interfaceC0304n, false);
    }

    public n(InterfaceC0304n interfaceC0304n, boolean z) {
        this.x = new com.byazt.ip.q.qg(30);
        this.n = new ArrayList<>();
        this.qg = new ArrayList<>();
        this.fs = 0;
        this.s = interfaceC0304n;
        this.l = z;
        this.w = new fs(this);
    }

    public void n() {
        n(this.n);
        n(this.qg);
        this.fs = 0;
    }

    public void qg() {
        this.w.n(this.n);
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            qg qgVar = this.n.get(i);
            int i2 = qgVar.n;
            if (i2 == 1) {
                w(qgVar);
            } else if (i2 == 2) {
                s(qgVar);
            } else if (i2 == 4) {
                q(qgVar);
            } else if (i2 == 8) {
                qg(qgVar);
            }
            Runnable runnable = this.q;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.n.clear();
    }

    public void s() {
        int size = this.qg.size();
        for (int i = 0; i < size; i++) {
            this.s.qg(this.qg.get(i));
        }
        n(this.qg);
        this.fs = 0;
    }

    private void qg(qg qgVar) {
        x(qgVar);
    }

    private void s(qg qgVar) {
        boolean z;
        byte b;
        int i = qgVar.qg;
        int i2 = qgVar.qg + qgVar.q;
        int i3 = qgVar.qg;
        byte b2 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.s.n(i3) != null || q(i3)) {
                if (b2 == 0) {
                    l(n(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    x(n(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b2 = b;
        }
        if (i4 != qgVar.q) {
            n(qgVar);
            qgVar = n(2, i, i4, null);
        }
        if (b2 == 0) {
            l(qgVar);
        } else {
            x(qgVar);
        }
    }

    private void q(qg qgVar) {
        int i = qgVar.qg;
        int i2 = qgVar.qg + qgVar.q;
        byte b = -1;
        int i3 = 0;
        for (int i4 = qgVar.qg; i4 < i2; i4++) {
            if (this.s.n(i4) != null || q(i4)) {
                if (b == 0) {
                    l(n(4, i, i3, qgVar.s));
                    i = i4;
                    i3 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    x(n(4, i, i3, qgVar.s));
                    i = i4;
                    i3 = 0;
                }
                b = 0;
            }
            i3++;
        }
        if (i3 != qgVar.q) {
            Object obj = qgVar.s;
            n(qgVar);
            qgVar = n(4, i, i3, obj);
        }
        if (b == 0) {
            l(qgVar);
        } else {
            x(qgVar);
        }
    }

    private void l(qg qgVar) {
        int i;
        if (qgVar.n != 1 && qgVar.n != 8) {
            int iS = s(qgVar.qg, qgVar.n);
            int i2 = qgVar.qg;
            int i3 = qgVar.n;
            if (i3 == 2) {
                i = 0;
            } else {
                if (i3 != 4) {
                    throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(qgVar)));
                }
                i = 1;
            }
            int i4 = 1;
            for (int i5 = 1; i5 < qgVar.q; i5++) {
                int iS2 = s(qgVar.qg + (i * i5), qgVar.n);
                int i6 = qgVar.n;
                if (i6 == 2 ? iS2 == iS : i6 == 4 && iS2 == iS + 1) {
                    i4++;
                } else {
                    qg qgVarN = n(qgVar.n, iS, i4, qgVar.s);
                    n(qgVarN, i2);
                    n(qgVarN);
                    if (qgVar.n == 4) {
                        i2 += i4;
                    }
                    i4 = 1;
                    iS = iS2;
                }
            }
            Object obj = qgVar.s;
            n(qgVar);
            if (i4 > 0) {
                qg qgVarN2 = n(qgVar.n, iS, i4, obj);
                n(qgVarN2, i2);
                n(qgVarN2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void n(qg qgVar, int i) {
        this.s.n(qgVar);
        int i2 = qgVar.n;
        if (i2 == 2) {
            this.s.n(i, qgVar.q);
        } else {
            if (i2 == 4) {
                this.s.n(i, qgVar.q, qgVar.s);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int s(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.qg.size() - 1; size >= 0; size--) {
            qg qgVar = this.qg.get(size);
            if (qgVar.n == 8) {
                if (qgVar.qg < qgVar.q) {
                    i3 = qgVar.qg;
                    i4 = qgVar.q;
                } else {
                    i3 = qgVar.q;
                    i4 = qgVar.qg;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == qgVar.qg) {
                        if (i2 == 1) {
                            qgVar.q++;
                        } else if (i2 == 2) {
                            qgVar.q--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            qgVar.qg++;
                        } else if (i2 == 2) {
                            qgVar.qg--;
                        }
                        i--;
                    }
                } else if (i < qgVar.qg) {
                    if (i2 == 1) {
                        qgVar.qg++;
                        qgVar.q++;
                    } else if (i2 == 2) {
                        qgVar.qg--;
                        qgVar.q--;
                    }
                }
            } else if (qgVar.qg <= i) {
                if (qgVar.n == 1) {
                    i -= qgVar.q;
                } else if (qgVar.n == 2) {
                    i += qgVar.q;
                }
            } else if (i2 == 1) {
                qgVar.qg++;
            } else if (i2 == 2) {
                qgVar.qg--;
            }
        }
        for (int size2 = this.qg.size() - 1; size2 >= 0; size2--) {
            qg qgVar2 = this.qg.get(size2);
            if (qgVar2.n == 8) {
                if (qgVar2.q == qgVar2.qg || qgVar2.q < 0) {
                    this.qg.remove(size2);
                    n(qgVar2);
                }
            } else if (qgVar2.q <= 0) {
                this.qg.remove(size2);
                n(qgVar2);
            }
        }
        return i;
    }

    private boolean q(int i) {
        int size = this.qg.size();
        for (int i2 = 0; i2 < size; i2++) {
            qg qgVar = this.qg.get(i2);
            if (qgVar.n == 8) {
                if (n(qgVar.q, i2 + 1) == i) {
                    return true;
                }
            } else if (qgVar.n == 1) {
                int i3 = qgVar.qg + qgVar.q;
                for (int i4 = qgVar.qg; i4 < i3; i4++) {
                    if (n(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void w(qg qgVar) {
        x(qgVar);
    }

    private void x(qg qgVar) {
        this.qg.add(qgVar);
        int i = qgVar.n;
        if (i == 1) {
            this.s.s(qgVar.qg, qgVar.q);
            return;
        }
        if (i == 2) {
            this.s.qg(qgVar.qg, qgVar.q);
        } else if (i == 4) {
            this.s.n(qgVar.qg, qgVar.q, qgVar.s);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(qgVar)));
            }
            this.s.q(qgVar.qg, qgVar.q);
        }
    }

    public boolean q() {
        return this.n.size() > 0;
    }

    public boolean n(int i) {
        return (i & this.fs) != 0;
    }

    public int qg(int i) {
        return n(i, 0);
    }

    public int n(int i, int i2) {
        int size = this.qg.size();
        while (i2 < size) {
            qg qgVar = this.qg.get(i2);
            if (qgVar.n == 8) {
                if (qgVar.qg == i) {
                    i = qgVar.q;
                } else {
                    if (qgVar.qg < i) {
                        i--;
                    }
                    if (qgVar.q <= i) {
                        i++;
                    }
                }
            } else if (qgVar.qg > i) {
                continue;
            } else if (qgVar.n == 2) {
                if (i < qgVar.qg + qgVar.q) {
                    return -1;
                }
                i -= qgVar.q;
            } else if (qgVar.n == 1) {
                i += qgVar.q;
            }
            i2++;
        }
        return i;
    }

    public boolean n(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.n.add(n(4, i, i2, obj));
        this.fs |= 4;
        return this.n.size() == 1;
    }

    public boolean qg(int i, int i2) {
        if (i2 <= 0) {
            return false;
        }
        this.n.add(n(1, i, i2, null));
        this.fs |= 1;
        return this.n.size() == 1;
    }

    public void l() {
        s();
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            qg qgVar = this.n.get(i);
            int i2 = qgVar.n;
            if (i2 == 1) {
                this.s.qg(qgVar);
                this.s.s(qgVar.qg, qgVar.q);
            } else if (i2 == 2) {
                this.s.qg(qgVar);
                this.s.n(qgVar.qg, qgVar.q);
            } else if (i2 == 4) {
                this.s.qg(qgVar);
                this.s.n(qgVar.qg, qgVar.q, qgVar.s);
            } else if (i2 == 8) {
                this.s.qg(qgVar);
                this.s.q(qgVar.qg, qgVar.q);
            }
            Runnable runnable = this.q;
            if (runnable != null) {
                runnable.run();
            }
        }
        n(this.n);
        this.fs = 0;
    }

    public int s(int i) {
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            qg qgVar = this.n.get(i2);
            int i3 = qgVar.n;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (qgVar.qg == i) {
                            i = qgVar.q;
                        } else {
                            if (qgVar.qg < i) {
                                i--;
                            }
                            if (qgVar.q <= i) {
                                i++;
                            }
                        }
                    }
                } else if (qgVar.qg > i) {
                    continue;
                } else {
                    if (qgVar.qg + qgVar.q > i) {
                        return -1;
                    }
                    i -= qgVar.q;
                }
            } else if (qgVar.qg <= i) {
                i += qgVar.q;
            }
        }
        return i;
    }

    public boolean w() {
        return (this.qg.isEmpty() || this.n.isEmpty()) ? false : true;
    }

    @Override // com.byazt.prf.fs.n
    public qg n(int i, int i2, int i3, Object obj) {
        qg qgVarN = this.x.n();
        if (qgVarN == null) {
            return new qg(i, i2, i3, obj);
        }
        qgVarN.n = i;
        qgVarN.qg = i2;
        qgVarN.q = i3;
        qgVarN.s = obj;
        return qgVarN;
    }

    @Override // com.byazt.prf.fs.n
    public void n(qg qgVar) {
        if (this.l) {
            return;
        }
        qgVar.s = null;
        this.x.n(qgVar);
    }

    public void n(List<qg> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            n(list.get(i));
        }
        list.clear();
    }

    @com.byazt.cp.n(n = {0, 1, 102, 226})
    static class qg {
        public int n;
        public int q;
        public int qg;
        public Object s;

        public qg(int i, int i2, int i3, Object obj) {
            this.n = i;
            this.qg = i2;
            this.q = i3;
            this.s = obj;
        }

        public String n() {
            int i = this.n;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return "rm";
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + n() + ",s:" + this.qg + "c:" + this.q + ",p:" + this.s + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            qg qgVar = (qg) obj;
            int i = this.n;
            if (i != qgVar.n) {
                return false;
            }
            if (i == 8 && Math.abs(this.q - this.qg) == 1 && this.q == qgVar.qg && this.qg == qgVar.q) {
                return true;
            }
            if (this.q != qgVar.q || this.qg != qgVar.qg) {
                return false;
            }
            Object obj2 = this.s;
            if (obj2 != null) {
                if (!obj2.equals(qgVar.s)) {
                    return false;
                }
            } else if (qgVar.s != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.n * 31) + this.qg) * 31) + this.q;
        }
    }
}
