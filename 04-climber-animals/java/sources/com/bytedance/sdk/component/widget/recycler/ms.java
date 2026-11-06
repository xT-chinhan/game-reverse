package com.bytedance.sdk.component.widget.recycler;

import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ms implements ab.ms {
    private com.bytedance.sdk.component.widget.recycler.ms.xr.d.ms<xr> ab;
    final InterfaceC0252ms ah;
    final ab c;
    Runnable d;
    final boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final ArrayList<xr> f1418ms;
    private int x;
    final ArrayList<xr> xr;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.ms$ms, reason: collision with other inner class name */
    interface InterfaceC0252ms {
        void ah(int i, int i2);

        void d(int i, int i2);

        RecyclerView.re ms(int i);

        void ms(int i, int i2);

        void ms(int i, int i2, Object obj);

        void xr(int i, int i2);
    }

    ms(InterfaceC0252ms interfaceC0252ms) {
        this(interfaceC0252ms, false);
    }

    ms(InterfaceC0252ms interfaceC0252ms, boolean z) {
        this.ab = new com.bytedance.sdk.component.widget.recycler.ms.xr.d.xr(30);
        this.f1418ms = new ArrayList<>();
        this.xr = new ArrayList<>();
        this.x = 0;
        this.ah = interfaceC0252ms;
        this.ka = z;
        this.c = new ab(this);
    }

    void ms() {
        ms(this.f1418ms);
        ms(this.xr);
        this.x = 0;
    }

    void xr() {
        this.c.ms(this.f1418ms);
        int size = this.f1418ms.size();
        for (int i = 0; i < size; i++) {
            xr xrVar = this.f1418ms.get(i);
            int i2 = xrVar.f1419ms;
            if (i2 == 1) {
                c(xrVar);
            } else if (i2 == 2) {
                ah(xrVar);
            } else if (i2 == 4) {
                d(xrVar);
            } else if (i2 == 8) {
                xr(xrVar);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1418ms.clear();
    }

    void ah() {
        int size = this.xr.size();
        for (int i = 0; i < size; i++) {
            this.xr.get(i);
        }
        ms(this.xr);
        this.x = 0;
    }

    private void xr(xr xrVar) {
        ab(xrVar);
    }

    private void ah(xr xrVar) {
        boolean z;
        byte b;
        int i = xrVar.xr;
        int i2 = xrVar.xr + xrVar.d;
        int i3 = xrVar.xr;
        byte b2 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.ah.ms(i3) != null || d(i3)) {
                if (b2 == 0) {
                    ka(ms(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    ab(ms(2, i, i4, null));
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
        if (i4 != xrVar.d) {
            ms(xrVar);
            xrVar = ms(2, i, i4, null);
        }
        if (b2 == 0) {
            ka(xrVar);
        } else {
            ab(xrVar);
        }
    }

    private void d(xr xrVar) {
        int i = xrVar.xr;
        int i2 = xrVar.xr + xrVar.d;
        byte b = -1;
        int i3 = 0;
        for (int i4 = xrVar.xr; i4 < i2; i4++) {
            if (this.ah.ms(i4) != null || d(i4)) {
                if (b == 0) {
                    ka(ms(4, i, i3, xrVar.ah));
                    i = i4;
                    i3 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    ab(ms(4, i, i3, xrVar.ah));
                    i = i4;
                    i3 = 0;
                }
                b = 0;
            }
            i3++;
        }
        if (i3 != xrVar.d) {
            Object obj = xrVar.ah;
            ms(xrVar);
            xrVar = ms(4, i, i3, obj);
        }
        if (b == 0) {
            ka(xrVar);
        } else {
            ab(xrVar);
        }
    }

    private void ka(xr xrVar) {
        int i;
        if (xrVar.f1419ms != 1 && xrVar.f1419ms != 8) {
            int iXr = xr(xrVar.xr, xrVar.f1419ms);
            int i2 = xrVar.xr;
            int i3 = xrVar.f1419ms;
            if (i3 == 2) {
                i = 0;
            } else {
                if (i3 != 4) {
                    throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(xrVar)));
                }
                i = 1;
            }
            int i4 = 1;
            for (int i5 = 1; i5 < xrVar.d; i5++) {
                int iXr2 = xr(xrVar.xr + (i * i5), xrVar.f1419ms);
                int i6 = xrVar.f1419ms;
                if (i6 == 2 ? iXr2 == iXr : i6 == 4 && iXr2 == iXr + 1) {
                    i4++;
                } else {
                    xr xrVarMs = ms(xrVar.f1419ms, iXr, i4, xrVar.ah);
                    ms(xrVarMs, i2);
                    ms(xrVarMs);
                    if (xrVar.f1419ms == 4) {
                        i2 += i4;
                    }
                    i4 = 1;
                    iXr = iXr2;
                }
            }
            Object obj = xrVar.ah;
            ms(xrVar);
            if (i4 > 0) {
                xr xrVarMs2 = ms(xrVar.f1419ms, iXr, i4, obj);
                ms(xrVarMs2, i2);
                ms(xrVarMs2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void ms(xr xrVar, int i) {
        int i2 = xrVar.f1419ms;
        if (i2 == 2) {
            this.ah.ms(i, xrVar.d);
        } else {
            if (i2 == 4) {
                this.ah.ms(i, xrVar.d, xrVar.ah);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int xr(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.xr.size() - 1; size >= 0; size--) {
            xr xrVar = this.xr.get(size);
            if (xrVar.f1419ms == 8) {
                if (xrVar.xr < xrVar.d) {
                    i3 = xrVar.xr;
                    i4 = xrVar.d;
                } else {
                    i3 = xrVar.d;
                    i4 = xrVar.xr;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == xrVar.xr) {
                        if (i2 == 1) {
                            xrVar.d++;
                        } else if (i2 == 2) {
                            xrVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            xrVar.xr++;
                        } else if (i2 == 2) {
                            xrVar.xr--;
                        }
                        i--;
                    }
                } else if (i < xrVar.xr) {
                    if (i2 == 1) {
                        xrVar.xr++;
                        xrVar.d++;
                    } else if (i2 == 2) {
                        xrVar.xr--;
                        xrVar.d--;
                    }
                }
            } else if (xrVar.xr <= i) {
                if (xrVar.f1419ms == 1) {
                    i -= xrVar.d;
                } else if (xrVar.f1419ms == 2) {
                    i += xrVar.d;
                }
            } else if (i2 == 1) {
                xrVar.xr++;
            } else if (i2 == 2) {
                xrVar.xr--;
            }
        }
        for (int size2 = this.xr.size() - 1; size2 >= 0; size2--) {
            xr xrVar2 = this.xr.get(size2);
            if (xrVar2.f1419ms == 8) {
                if (xrVar2.d == xrVar2.xr || xrVar2.d < 0) {
                    this.xr.remove(size2);
                    ms(xrVar2);
                }
            } else if (xrVar2.d <= 0) {
                this.xr.remove(size2);
                ms(xrVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.xr.size();
        for (int i2 = 0; i2 < size; i2++) {
            xr xrVar = this.xr.get(i2);
            if (xrVar.f1419ms == 8) {
                if (ms(xrVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (xrVar.f1419ms == 1) {
                int i3 = xrVar.xr + xrVar.d;
                for (int i4 = xrVar.xr; i4 < i3; i4++) {
                    if (ms(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void c(xr xrVar) {
        ab(xrVar);
    }

    private void ab(xr xrVar) {
        this.xr.add(xrVar);
        int i = xrVar.f1419ms;
        if (i == 1) {
            this.ah.ah(xrVar.xr, xrVar.d);
            return;
        }
        if (i == 2) {
            this.ah.xr(xrVar.xr, xrVar.d);
        } else if (i == 4) {
            this.ah.ms(xrVar.xr, xrVar.d, xrVar.ah);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(xrVar)));
            }
            this.ah.d(xrVar.xr, xrVar.d);
        }
    }

    boolean d() {
        return this.f1418ms.size() > 0;
    }

    boolean ms(int i) {
        return (i & this.x) != 0;
    }

    int xr(int i) {
        return ms(i, 0);
    }

    int ms(int i, int i2) {
        int size = this.xr.size();
        while (i2 < size) {
            xr xrVar = this.xr.get(i2);
            if (xrVar.f1419ms == 8) {
                if (xrVar.xr == i) {
                    i = xrVar.d;
                } else {
                    if (xrVar.xr < i) {
                        i--;
                    }
                    if (xrVar.d <= i) {
                        i++;
                    }
                }
            } else if (xrVar.xr > i) {
                continue;
            } else if (xrVar.f1419ms == 2) {
                if (i < xrVar.xr + xrVar.d) {
                    return -1;
                }
                i -= xrVar.d;
            } else if (xrVar.f1419ms == 1) {
                i += xrVar.d;
            }
            i2++;
        }
        return i;
    }

    boolean ms(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.f1418ms.add(ms(4, i, i2, obj));
        this.x |= 4;
        return this.f1418ms.size() == 1;
    }

    void ka() {
        ah();
        int size = this.f1418ms.size();
        for (int i = 0; i < size; i++) {
            xr xrVar = this.f1418ms.get(i);
            int i2 = xrVar.f1419ms;
            if (i2 == 1) {
                this.ah.ah(xrVar.xr, xrVar.d);
            } else if (i2 == 2) {
                this.ah.ms(xrVar.xr, xrVar.d);
            } else if (i2 == 4) {
                this.ah.ms(xrVar.xr, xrVar.d, xrVar.ah);
            } else if (i2 == 8) {
                this.ah.d(xrVar.xr, xrVar.d);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
        ms(this.f1418ms);
        this.x = 0;
    }

    public int ah(int i) {
        int size = this.f1418ms.size();
        for (int i2 = 0; i2 < size; i2++) {
            xr xrVar = this.f1418ms.get(i2);
            int i3 = xrVar.f1419ms;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (xrVar.xr == i) {
                            i = xrVar.d;
                        } else {
                            if (xrVar.xr < i) {
                                i--;
                            }
                            if (xrVar.d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (xrVar.xr > i) {
                    continue;
                } else {
                    if (xrVar.xr + xrVar.d > i) {
                        return -1;
                    }
                    i -= xrVar.d;
                }
            } else if (xrVar.xr <= i) {
                i += xrVar.d;
            }
        }
        return i;
    }

    boolean c() {
        return (this.xr.isEmpty() || this.f1418ms.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ab.ms
    public xr ms(int i, int i2, int i3, Object obj) {
        xr xrVarMs = this.ab.ms();
        if (xrVarMs == null) {
            return new xr(i, i2, i3, obj);
        }
        xrVarMs.f1419ms = i;
        xrVarMs.xr = i2;
        xrVarMs.d = i3;
        xrVarMs.ah = obj;
        return xrVarMs;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ab.ms
    public void ms(xr xrVar) {
        if (this.ka) {
            return;
        }
        xrVar.ah = null;
        this.ab.ms(xrVar);
    }

    void ms(List<xr> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ms(list.get(i));
        }
        list.clear();
    }

    static class xr {
        Object ah;
        int d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1419ms;
        int xr;

        xr(int i, int i2, int i3, Object obj) {
            this.f1419ms = i;
            this.xr = i2;
            this.d = i3;
            this.ah = obj;
        }

        String ms() {
            int i = this.f1419ms;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return t.w;
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return g.R;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + ms() + ",s:" + this.xr + "c:" + this.d + ",p:" + this.ah + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            xr xrVar = (xr) obj;
            int i = this.f1419ms;
            if (i != xrVar.f1419ms) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.xr) == 1 && this.d == xrVar.xr && this.xr == xrVar.d) {
                return true;
            }
            if (this.d != xrVar.d || this.xr != xrVar.xr) {
                return false;
            }
            Object obj2 = this.ah;
            if (obj2 != null) {
                if (!obj2.equals(xrVar.ah)) {
                    return false;
                }
            } else if (xrVar.ah != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1419ms * 31) + this.xr) * 31) + this.d;
        }
    }
}
