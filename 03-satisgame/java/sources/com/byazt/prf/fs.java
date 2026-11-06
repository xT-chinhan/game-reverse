package com.byazt.prf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 101})
public class fs {
    public final n n;

    interface n {
        com.byazt.prf.n.qg n(int i, int i2, int i3, Object obj);

        void n(com.byazt.prf.n.qg qgVar);
    }

    public fs(n nVar) {
        this.n = nVar;
    }

    public void n(List<com.byazt.prf.n.qg> list) {
        while (true) {
            int iQg = qg(list);
            if (iQg == -1) {
                return;
            } else {
                n(list, iQg, iQg + 1);
            }
        }
    }

    private void n(List<com.byazt.prf.n.qg> list, int i, int i2) {
        com.byazt.prf.n.qg qgVar = list.get(i);
        com.byazt.prf.n.qg qgVar2 = list.get(i2);
        int i3 = qgVar2.n;
        if (i3 == 1) {
            s(list, i, qgVar, i2, qgVar2);
        } else if (i3 == 2) {
            n(list, i, qgVar, i2, qgVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            qg(list, i, qgVar, i2, qgVar2);
        }
    }

    public void n(List<com.byazt.prf.n.qg> list, int i, com.byazt.prf.n.qg qgVar, int i2, com.byazt.prf.n.qg qgVar2) {
        boolean z;
        boolean z2 = false;
        if (qgVar.qg < qgVar.q) {
            if (qgVar2.qg == qgVar.qg && qgVar2.q == qgVar.q - qgVar.qg) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (qgVar2.qg == qgVar.q + 1 && qgVar2.q == qgVar.qg - qgVar.q) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (qgVar.q < qgVar2.qg) {
            qgVar2.qg--;
        } else if (qgVar.q < qgVar2.qg + qgVar2.q) {
            qgVar2.q--;
            qgVar.n = 2;
            qgVar.q = 1;
            if (qgVar2.q == 0) {
                list.remove(i2);
                this.n.n(qgVar2);
                return;
            }
            return;
        }
        com.byazt.prf.n.qg qgVarN = null;
        if (qgVar.qg <= qgVar2.qg) {
            qgVar2.qg++;
        } else if (qgVar.qg < qgVar2.qg + qgVar2.q) {
            qgVarN = this.n.n(2, qgVar.qg + 1, (qgVar2.qg + qgVar2.q) - qgVar.qg, null);
            qgVar2.q = qgVar.qg - qgVar2.qg;
        }
        if (z2) {
            list.set(i, qgVar2);
            list.remove(i2);
            this.n.n(qgVar);
            return;
        }
        if (z) {
            if (qgVarN != null) {
                if (qgVar.qg > qgVarN.qg) {
                    qgVar.qg -= qgVarN.q;
                }
                if (qgVar.q > qgVarN.qg) {
                    qgVar.q -= qgVarN.q;
                }
            }
            if (qgVar.qg > qgVar2.qg) {
                qgVar.qg -= qgVar2.q;
            }
            if (qgVar.q > qgVar2.qg) {
                qgVar.q -= qgVar2.q;
            }
        } else {
            if (qgVarN != null) {
                if (qgVar.qg >= qgVarN.qg) {
                    qgVar.qg -= qgVarN.q;
                }
                if (qgVar.q >= qgVarN.qg) {
                    qgVar.q -= qgVarN.q;
                }
            }
            if (qgVar.qg >= qgVar2.qg) {
                qgVar.qg -= qgVar2.q;
            }
            if (qgVar.q >= qgVar2.qg) {
                qgVar.q -= qgVar2.q;
            }
        }
        list.set(i, qgVar2);
        if (qgVar.qg != qgVar.q) {
            list.set(i2, qgVar);
        } else {
            list.remove(i2);
        }
        if (qgVarN != null) {
            list.add(i, qgVarN);
        }
    }

    private void s(List<com.byazt.prf.n.qg> list, int i, com.byazt.prf.n.qg qgVar, int i2, com.byazt.prf.n.qg qgVar2) {
        int i3 = qgVar.q < qgVar2.qg ? -1 : 0;
        if (qgVar.qg < qgVar2.qg) {
            i3++;
        }
        if (qgVar2.qg <= qgVar.qg) {
            qgVar.qg += qgVar2.q;
        }
        if (qgVar2.qg <= qgVar.q) {
            qgVar.q += qgVar2.q;
        }
        qgVar2.qg += i3;
        list.set(i, qgVar2);
        list.set(i2, qgVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x006b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void qg(List<com.byazt.prf.n.qg> list, int i, com.byazt.prf.n.qg qgVar, int i2, com.byazt.prf.n.qg qgVar2) {
        com.byazt.prf.n.qg qgVarN;
        com.byazt.prf.n.qg qgVarN2 = null;
        if (qgVar.q < qgVar2.qg) {
            qgVar2.qg--;
        } else {
            if (qgVar.q < qgVar2.qg + qgVar2.q) {
                qgVar2.q--;
                qgVarN = this.n.n(4, qgVar.qg, 1, qgVar2.s);
            }
            if (qgVar.qg <= qgVar2.qg) {
                qgVar2.qg++;
            } else if (qgVar.qg < qgVar2.qg + qgVar2.q) {
                int i3 = (qgVar2.qg + qgVar2.q) - qgVar.qg;
                qgVarN2 = this.n.n(4, qgVar.qg + 1, i3, qgVar2.s);
                qgVar2.q -= i3;
            }
            list.set(i2, qgVar);
            if (qgVar2.q > 0) {
                list.set(i, qgVar2);
            } else {
                list.remove(i);
                this.n.n(qgVar2);
            }
            if (qgVarN != null) {
                list.add(i, qgVarN);
            }
            if (qgVarN2 != null) {
                list.add(i, qgVarN2);
            }
        }
        qgVarN = null;
        if (qgVar.qg <= qgVar2.qg) {
            qgVar2.qg++;
        } else if (qgVar.qg < qgVar2.qg + qgVar2.q) {
            int i4 = (qgVar2.qg + qgVar2.q) - qgVar.qg;
            qgVarN2 = this.n.n(4, qgVar.qg + 1, i4, qgVar2.s);
            qgVar2.q -= i4;
        }
        list.set(i2, qgVar);
        if (qgVar2.q > 0) {
            list.set(i, qgVar2);
        } else {
            list.remove(i);
            this.n.n(qgVar2);
        }
        if (qgVarN != null) {
            list.add(i, qgVarN);
        }
        if (qgVarN2 != null) {
            list.add(i, qgVarN2);
        }
    }

    private int qg(List<com.byazt.prf.n.qg> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).n != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
