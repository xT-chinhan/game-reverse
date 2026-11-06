package com.bytedance.sdk.component.widget.recycler;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final ms f1397ms;

    interface ms {
        com.bytedance.sdk.component.widget.recycler.ms.xr ms(int i, int i2, int i3, Object obj);

        void ms(com.bytedance.sdk.component.widget.recycler.ms.xr xrVar);
    }

    ab(ms msVar) {
        this.f1397ms = msVar;
    }

    void ms(List<com.bytedance.sdk.component.widget.recycler.ms.xr> list) {
        while (true) {
            int iXr = xr(list);
            if (iXr == -1) {
                return;
            } else {
                ms(list, iXr, iXr + 1);
            }
        }
    }

    private void ms(List<com.bytedance.sdk.component.widget.recycler.ms.xr> list, int i, int i2) {
        com.bytedance.sdk.component.widget.recycler.ms.xr xrVar = list.get(i);
        com.bytedance.sdk.component.widget.recycler.ms.xr xrVar2 = list.get(i2);
        int i3 = xrVar2.f1419ms;
        if (i3 == 1) {
            ah(list, i, xrVar, i2, xrVar2);
        } else if (i3 == 2) {
            ms(list, i, xrVar, i2, xrVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            xr(list, i, xrVar, i2, xrVar2);
        }
    }

    void ms(List<com.bytedance.sdk.component.widget.recycler.ms.xr> list, int i, com.bytedance.sdk.component.widget.recycler.ms.xr xrVar, int i2, com.bytedance.sdk.component.widget.recycler.ms.xr xrVar2) {
        boolean z;
        boolean z2 = false;
        if (xrVar.xr < xrVar.d) {
            if (xrVar2.xr == xrVar.xr && xrVar2.d == xrVar.d - xrVar.xr) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (xrVar2.xr == xrVar.d + 1 && xrVar2.d == xrVar.xr - xrVar.d) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (xrVar.d < xrVar2.xr) {
            xrVar2.xr--;
        } else if (xrVar.d < xrVar2.xr + xrVar2.d) {
            xrVar2.d--;
            xrVar.f1419ms = 2;
            xrVar.d = 1;
            if (xrVar2.d == 0) {
                list.remove(i2);
                this.f1397ms.ms(xrVar2);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.widget.recycler.ms.xr xrVarMs = null;
        if (xrVar.xr <= xrVar2.xr) {
            xrVar2.xr++;
        } else if (xrVar.xr < xrVar2.xr + xrVar2.d) {
            xrVarMs = this.f1397ms.ms(2, xrVar.xr + 1, (xrVar2.xr + xrVar2.d) - xrVar.xr, null);
            xrVar2.d = xrVar.xr - xrVar2.xr;
        }
        if (z2) {
            list.set(i, xrVar2);
            list.remove(i2);
            this.f1397ms.ms(xrVar);
            return;
        }
        if (z) {
            if (xrVarMs != null) {
                if (xrVar.xr > xrVarMs.xr) {
                    xrVar.xr -= xrVarMs.d;
                }
                if (xrVar.d > xrVarMs.xr) {
                    xrVar.d -= xrVarMs.d;
                }
            }
            if (xrVar.xr > xrVar2.xr) {
                xrVar.xr -= xrVar2.d;
            }
            if (xrVar.d > xrVar2.xr) {
                xrVar.d -= xrVar2.d;
            }
        } else {
            if (xrVarMs != null) {
                if (xrVar.xr >= xrVarMs.xr) {
                    xrVar.xr -= xrVarMs.d;
                }
                if (xrVar.d >= xrVarMs.xr) {
                    xrVar.d -= xrVarMs.d;
                }
            }
            if (xrVar.xr >= xrVar2.xr) {
                xrVar.xr -= xrVar2.d;
            }
            if (xrVar.d >= xrVar2.xr) {
                xrVar.d -= xrVar2.d;
            }
        }
        list.set(i, xrVar2);
        if (xrVar.xr != xrVar.d) {
            list.set(i2, xrVar);
        } else {
            list.remove(i2);
        }
        if (xrVarMs != null) {
            list.add(i, xrVarMs);
        }
    }

    private void ah(List<com.bytedance.sdk.component.widget.recycler.ms.xr> list, int i, com.bytedance.sdk.component.widget.recycler.ms.xr xrVar, int i2, com.bytedance.sdk.component.widget.recycler.ms.xr xrVar2) {
        int i3 = xrVar.d < xrVar2.xr ? -1 : 0;
        if (xrVar.xr < xrVar2.xr) {
            i3++;
        }
        if (xrVar2.xr <= xrVar.xr) {
            xrVar.xr += xrVar2.d;
        }
        if (xrVar2.xr <= xrVar.d) {
            xrVar.d += xrVar2.d;
        }
        xrVar2.xr += i3;
        list.set(i, xrVar2);
        list.set(i2, xrVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x006b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    void xr(List<com.bytedance.sdk.component.widget.recycler.ms.xr> list, int i, com.bytedance.sdk.component.widget.recycler.ms.xr xrVar, int i2, com.bytedance.sdk.component.widget.recycler.ms.xr xrVar2) {
        com.bytedance.sdk.component.widget.recycler.ms.xr xrVarMs;
        com.bytedance.sdk.component.widget.recycler.ms.xr xrVarMs2 = null;
        if (xrVar.d < xrVar2.xr) {
            xrVar2.xr--;
        } else {
            if (xrVar.d < xrVar2.xr + xrVar2.d) {
                xrVar2.d--;
                xrVarMs = this.f1397ms.ms(4, xrVar.xr, 1, xrVar2.ah);
            }
            if (xrVar.xr <= xrVar2.xr) {
                xrVar2.xr++;
            } else if (xrVar.xr < xrVar2.xr + xrVar2.d) {
                int i3 = (xrVar2.xr + xrVar2.d) - xrVar.xr;
                xrVarMs2 = this.f1397ms.ms(4, xrVar.xr + 1, i3, xrVar2.ah);
                xrVar2.d -= i3;
            }
            list.set(i2, xrVar);
            if (xrVar2.d > 0) {
                list.set(i, xrVar2);
            } else {
                list.remove(i);
                this.f1397ms.ms(xrVar2);
            }
            if (xrVarMs != null) {
                list.add(i, xrVarMs);
            }
            if (xrVarMs2 != null) {
                list.add(i, xrVarMs2);
            }
        }
        xrVarMs = null;
        if (xrVar.xr <= xrVar2.xr) {
            xrVar2.xr++;
        } else if (xrVar.xr < xrVar2.xr + xrVar2.d) {
            int i4 = (xrVar2.xr + xrVar2.d) - xrVar.xr;
            xrVarMs2 = this.f1397ms.ms(4, xrVar.xr + 1, i4, xrVar2.ah);
            xrVar2.d -= i4;
        }
        list.set(i2, xrVar);
        if (xrVar2.d > 0) {
            list.set(i, xrVar2);
        } else {
            list.remove(i);
            this.f1397ms.ms(xrVar2);
        }
        if (xrVarMs != null) {
            list.add(i, xrVarMs);
        }
        if (xrVarMs2 != null) {
            list.add(i, xrVarMs2);
        }
    }

    private int xr(List<com.bytedance.sdk.component.widget.recycler.ms.xr> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1419ms != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
