package com.byazt.hr;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 62})
public class fw {
    public final pr pr;

    interface pr {
        com.byazt.hr.pr.hw pr(int i, int i2, int i3, Object obj);

        void pr(com.byazt.hr.pr.hw hwVar);
    }

    public fw(pr prVar) {
        this.pr = prVar;
    }

    public void pr(List<com.byazt.hr.pr.hw> list) {
        while (true) {
            int iHw = hw(list);
            if (iHw != -1) {
                pr(list, iHw, iHw + 1);
            } else {
                return;
            }
        }
    }

    private void pr(List<com.byazt.hr.pr.hw> list, int i, int i2) {
        com.byazt.hr.pr.hw hwVar = list.get(i);
        com.byazt.hr.pr.hw hwVar2 = list.get(i2);
        switch (hwVar2.pr) {
            case 1:
                hn(list, i, hwVar, i2, hwVar2);
                break;
            case 2:
                pr(list, i, hwVar, i2, hwVar2);
                break;
            case 4:
                hw(list, i, hwVar, i2, hwVar2);
                break;
        }
    }

    public void pr(List<com.byazt.hr.pr.hw> list, int i, com.byazt.hr.pr.hw hwVar, int i2, com.byazt.hr.pr.hw hwVar2) {
        boolean z;
        boolean z2 = false;
        if (hwVar.hw < hwVar.x) {
            if (hwVar2.hw == hwVar.hw && hwVar2.x == hwVar.x - hwVar.hw) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (hwVar2.hw == hwVar.x + 1 && hwVar2.x == hwVar.hw - hwVar.x) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (hwVar.x < hwVar2.hw) {
            hwVar2.hw--;
        } else if (hwVar.x < hwVar2.hw + hwVar2.x) {
            hwVar2.x--;
            hwVar.pr = 2;
            hwVar.x = 1;
            if (hwVar2.x == 0) {
                list.remove(i2);
                this.pr.pr(hwVar2);
                return;
            }
            return;
        }
        com.byazt.hr.pr.hw hwVarPr = null;
        if (hwVar.hw <= hwVar2.hw) {
            hwVar2.hw++;
        } else if (hwVar.hw < hwVar2.hw + hwVar2.x) {
            hwVarPr = this.pr.pr(2, hwVar.hw + 1, (hwVar2.hw + hwVar2.x) - hwVar.hw, null);
            hwVar2.x = hwVar.hw - hwVar2.hw;
        }
        if (z2) {
            list.set(i, hwVar2);
            list.remove(i2);
            this.pr.pr(hwVar);
            return;
        }
        if (z) {
            if (hwVarPr != null) {
                if (hwVar.hw > hwVarPr.hw) {
                    hwVar.hw -= hwVarPr.x;
                }
                if (hwVar.x > hwVarPr.hw) {
                    hwVar.x -= hwVarPr.x;
                }
            }
            if (hwVar.hw > hwVar2.hw) {
                hwVar.hw -= hwVar2.x;
            }
            if (hwVar.x > hwVar2.hw) {
                hwVar.x -= hwVar2.x;
            }
        } else {
            if (hwVarPr != null) {
                if (hwVar.hw >= hwVarPr.hw) {
                    hwVar.hw -= hwVarPr.x;
                }
                if (hwVar.x >= hwVarPr.hw) {
                    hwVar.x -= hwVarPr.x;
                }
            }
            if (hwVar.hw >= hwVar2.hw) {
                hwVar.hw -= hwVar2.x;
            }
            if (hwVar.x >= hwVar2.hw) {
                hwVar.x -= hwVar2.x;
            }
        }
        list.set(i, hwVar2);
        if (hwVar.hw != hwVar.x) {
            list.set(i2, hwVar);
        } else {
            list.remove(i2);
        }
        if (hwVarPr != null) {
            list.add(i, hwVarPr);
        }
    }

    private void hn(List<com.byazt.hr.pr.hw> list, int i, com.byazt.hr.pr.hw hwVar, int i2, com.byazt.hr.pr.hw hwVar2) {
        int i3;
        if (hwVar.x >= hwVar2.hw) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        if (hwVar.hw < hwVar2.hw) {
            i3++;
        }
        if (hwVar2.hw <= hwVar.hw) {
            hwVar.hw += hwVar2.x;
        }
        if (hwVar2.hw <= hwVar.x) {
            hwVar.x += hwVar2.x;
        }
        hwVar2.hw += i3;
        list.set(i, hwVar2);
        list.set(i2, hwVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031  */
    /* JADX WARN: Code duplicated, block: B:12:0x0037  */
    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    /* JADX WARN: Code duplicated, block: B:17:0x005f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0063  */
    /* JADX WARN: Code duplicated, block: B:20:0x006d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void hw(List<com.byazt.hr.pr.hw> list, int i, com.byazt.hr.pr.hw hwVar, int i2, com.byazt.hr.pr.hw hwVar2) {
        com.byazt.hr.pr.hw hwVarPr;
        com.byazt.hr.pr.hw hwVarPr2 = null;
        if (hwVar.x < hwVar2.hw) {
            hwVar2.hw--;
        } else {
            if (hwVar.x < hwVar2.hw + hwVar2.x) {
                hwVar2.x--;
                hwVarPr = this.pr.pr(4, hwVar.hw, 1, hwVar2.hn);
            }
            if (hwVar.hw <= hwVar2.hw) {
                hwVar2.hw++;
            } else if (hwVar.hw < hwVar2.hw + hwVar2.x) {
                int i3 = (hwVar2.hw + hwVar2.x) - hwVar.hw;
                hwVarPr2 = this.pr.pr(4, hwVar.hw + 1, i3, hwVar2.hn);
                hwVar2.x -= i3;
            }
            list.set(i2, hwVar);
            if (hwVar2.x > 0) {
                list.set(i, hwVar2);
            } else {
                list.remove(i);
                this.pr.pr(hwVar2);
            }
            if (hwVarPr != null) {
                list.add(i, hwVarPr);
            }
            if (hwVarPr2 != null) {
                list.add(i, hwVarPr2);
            }
        }
        hwVarPr = null;
        if (hwVar.hw <= hwVar2.hw) {
            hwVar2.hw++;
        } else if (hwVar.hw < hwVar2.hw + hwVar2.x) {
            int i4 = (hwVar2.hw + hwVar2.x) - hwVar.hw;
            hwVarPr2 = this.pr.pr(4, hwVar.hw + 1, i4, hwVar2.hn);
            hwVar2.x -= i4;
        }
        list.set(i2, hwVar);
        if (hwVar2.x > 0) {
            list.set(i, hwVar2);
        } else {
            list.remove(i);
            this.pr.pr(hwVar2);
        }
        if (hwVarPr != null) {
            list.add(i, hwVarPr);
        }
        if (hwVarPr2 != null) {
            list.add(i, hwVarPr2);
        }
    }

    private int hw(List<com.byazt.hr.pr.hw> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).pr == 8) {
                if (z) {
                    return size;
                }
            } else {
                z = true;
            }
        }
        return -1;
    }
}
