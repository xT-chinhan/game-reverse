package com.byazt.hr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 37})
public class pr implements fw.pr {
    public final boolean c;
    public com.byazt.fz.x.pr<hw> fw;
    public final InterfaceC0089pr hn;
    public final ArrayList<hw> hw;
    public final ArrayList<hw> pr;
    public final fw uc;
    public Runnable x;
    public int zo;

    /* JADX INFO: renamed from: com.byazt.hr.pr$pr, reason: collision with other inner class name */
    interface InterfaceC0089pr {
        void hn(int i, int i2);

        void hw(int i, int i2);

        RecyclerView.fo pr(int i);

        void pr(int i, int i2);

        void pr(int i, int i2, Object obj);

        void x(int i, int i2);
    }

    public pr(InterfaceC0089pr interfaceC0089pr) {
        this(interfaceC0089pr, false);
    }

    public pr(InterfaceC0089pr interfaceC0089pr, boolean z) {
        this.fw = new com.byazt.fz.x.hw(30);
        this.pr = new ArrayList<>();
        this.hw = new ArrayList<>();
        this.zo = 0;
        this.hn = interfaceC0089pr;
        this.c = z;
        this.uc = new fw(this);
    }

    public void pr() {
        pr(this.pr);
        pr(this.hw);
        this.zo = 0;
    }

    public void hw() {
        this.uc.pr(this.pr);
        int size = this.pr.size();
        for (int i = 0; i < size; i++) {
            hw hwVar = this.pr.get(i);
            switch (hwVar.pr) {
                case 1:
                    uc(hwVar);
                    break;
                case 2:
                    hn(hwVar);
                    break;
                case 4:
                    x(hwVar);
                    break;
                case 8:
                    hw(hwVar);
                    break;
            }
            Runnable runnable = this.x;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.pr.clear();
    }

    public void hn() {
        int size = this.hw.size();
        for (int i = 0; i < size; i++) {
            this.hw.get(i);
        }
        pr(this.hw);
        this.zo = 0;
    }

    private void hw(hw hwVar) {
        fw(hwVar);
    }

    private void hn(hw hwVar) {
        boolean z;
        byte b;
        int i = hwVar.hw;
        int i2 = hwVar.hw + hwVar.x;
        int i3 = hwVar.hw;
        byte b2 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.hn.pr(i3) == null && !x(i3)) {
                if (b2 != 1) {
                    z = false;
                } else {
                    fw(pr(2, i, i4, null));
                    z = true;
                }
                b = 0;
            } else {
                if (b2 != 0) {
                    z = false;
                } else {
                    c(pr(2, i, i4, null));
                    z = true;
                }
                b = 1;
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
        if (i4 != hwVar.x) {
            pr(hwVar);
            hwVar = pr(2, i, i4, null);
        }
        if (b2 == 0) {
            c(hwVar);
        } else {
            fw(hwVar);
        }
    }

    private void x(hw hwVar) {
        int i = hwVar.hw;
        int i2 = hwVar.hw + hwVar.x;
        byte b = -1;
        int i3 = 0;
        for (int i4 = hwVar.hw; i4 < i2; i4++) {
            if (this.hn.pr(i4) == null && !x(i4)) {
                if (b == 1) {
                    fw(pr(4, i, i3, hwVar.hn));
                    i = i4;
                    i3 = 0;
                }
                b = 0;
            } else {
                if (b == 0) {
                    c(pr(4, i, i3, hwVar.hn));
                    i = i4;
                    i3 = 0;
                }
                b = 1;
            }
            i3++;
        }
        if (i3 != hwVar.x) {
            Object obj = hwVar.hn;
            pr(hwVar);
            hwVar = pr(4, i, i3, obj);
        }
        if (b == 0) {
            c(hwVar);
        } else {
            fw(hwVar);
        }
    }

    private void c(hw hwVar) {
        int i;
        boolean z;
        if (hwVar.pr != 1 && hwVar.pr != 8) {
            int iHw = hw(hwVar.hw, hwVar.pr);
            int i2 = hwVar.hw;
            switch (hwVar.pr) {
                case 2:
                    i = 0;
                    break;
                case 3:
                default:
                    throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(hwVar)));
                case 4:
                    i = 1;
                    break;
            }
            int i3 = 1;
            for (int i4 = 1; i4 < hwVar.x; i4++) {
                int iHw2 = hw(hwVar.hw + (i * i4), hwVar.pr);
                switch (hwVar.pr) {
                    case 2:
                        z = iHw2 == iHw;
                        break;
                    case 3:
                    default:
                        z = false;
                        break;
                    case 4:
                        z = iHw2 == iHw + 1;
                        break;
                }
                if (z) {
                    i3++;
                } else {
                    hw hwVarPr = pr(hwVar.pr, iHw, i3, hwVar.hn);
                    pr(hwVarPr, i2);
                    pr(hwVarPr);
                    if (hwVar.pr == 4) {
                        i2 += i3;
                    }
                    i3 = 1;
                    iHw = iHw2;
                }
            }
            Object obj = hwVar.hn;
            pr(hwVar);
            if (i3 > 0) {
                hw hwVarPr2 = pr(hwVar.pr, iHw, i3, obj);
                pr(hwVarPr2, i2);
                pr(hwVarPr2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void pr(hw hwVar, int i) {
        switch (hwVar.pr) {
            case 2:
                this.hn.pr(i, hwVar.x);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.hn.pr(i, hwVar.x, hwVar.hn);
                return;
        }
    }

    private int hw(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.hw.size() - 1; size >= 0; size--) {
            hw hwVar = this.hw.get(size);
            if (hwVar.pr == 8) {
                if (hwVar.hw < hwVar.x) {
                    i3 = hwVar.hw;
                    i4 = hwVar.x;
                } else {
                    i3 = hwVar.x;
                    i4 = hwVar.hw;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == hwVar.hw) {
                        if (i2 == 1) {
                            hwVar.x++;
                        } else if (i2 == 2) {
                            hwVar.x--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            hwVar.hw++;
                        } else if (i2 == 2) {
                            hwVar.hw--;
                        }
                        i--;
                    }
                } else if (i < hwVar.hw) {
                    if (i2 == 1) {
                        hwVar.hw++;
                        hwVar.x++;
                    } else if (i2 == 2) {
                        hwVar.hw--;
                        hwVar.x--;
                    }
                }
            } else if (hwVar.hw <= i) {
                if (hwVar.pr == 1) {
                    i -= hwVar.x;
                } else if (hwVar.pr == 2) {
                    i += hwVar.x;
                }
            } else if (i2 == 1) {
                hwVar.hw++;
            } else if (i2 == 2) {
                hwVar.hw--;
            }
        }
        for (int size2 = this.hw.size() - 1; size2 >= 0; size2--) {
            hw hwVar2 = this.hw.get(size2);
            if (hwVar2.pr == 8) {
                if (hwVar2.x == hwVar2.hw || hwVar2.x < 0) {
                    this.hw.remove(size2);
                    pr(hwVar2);
                }
            } else if (hwVar2.x <= 0) {
                this.hw.remove(size2);
                pr(hwVar2);
            }
        }
        return i;
    }

    private boolean x(int i) {
        int size = this.hw.size();
        for (int i2 = 0; i2 < size; i2++) {
            hw hwVar = this.hw.get(i2);
            if (hwVar.pr == 8) {
                if (pr(hwVar.x, i2 + 1) == i) {
                    return true;
                }
            } else if (hwVar.pr == 1) {
                int i3 = hwVar.hw + hwVar.x;
                for (int i4 = hwVar.hw; i4 < i3; i4++) {
                    if (pr(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void uc(hw hwVar) {
        fw(hwVar);
    }

    private void fw(hw hwVar) {
        this.hw.add(hwVar);
        switch (hwVar.pr) {
            case 1:
                this.hn.hn(hwVar.hw, hwVar.x);
                return;
            case 2:
                this.hn.hw(hwVar.hw, hwVar.x);
                return;
            case 4:
                this.hn.pr(hwVar.hw, hwVar.x, hwVar.hn);
                return;
            case 8:
                this.hn.x(hwVar.hw, hwVar.x);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(hwVar)));
        }
    }

    public boolean x() {
        return this.pr.size() > 0;
    }

    public boolean pr(int i) {
        return (i & this.zo) != 0;
    }

    public int hw(int i) {
        return pr(i, 0);
    }

    public int pr(int i, int i2) {
        int size = this.hw.size();
        while (i2 < size) {
            hw hwVar = this.hw.get(i2);
            if (hwVar.pr == 8) {
                if (hwVar.hw == i) {
                    i = hwVar.x;
                } else {
                    if (hwVar.hw < i) {
                        i--;
                    }
                    if (hwVar.x <= i) {
                        i++;
                    }
                }
            } else if (hwVar.hw > i) {
                continue;
            } else if (hwVar.pr == 2) {
                if (i < hwVar.hw + hwVar.x) {
                    return -1;
                }
                i -= hwVar.x;
            } else if (hwVar.pr == 1) {
                i += hwVar.x;
            }
            i2++;
        }
        return i;
    }

    public boolean pr(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.pr.add(pr(4, i, i2, obj));
        this.zo |= 4;
        return this.pr.size() == 1;
    }

    public void c() {
        hn();
        int size = this.pr.size();
        for (int i = 0; i < size; i++) {
            hw hwVar = this.pr.get(i);
            switch (hwVar.pr) {
                case 1:
                    this.hn.hn(hwVar.hw, hwVar.x);
                    break;
                case 2:
                    this.hn.pr(hwVar.hw, hwVar.x);
                    break;
                case 4:
                    this.hn.pr(hwVar.hw, hwVar.x, hwVar.hn);
                    break;
                case 8:
                    this.hn.x(hwVar.hw, hwVar.x);
                    break;
            }
            Runnable runnable = this.x;
            if (runnable != null) {
                runnable.run();
            }
        }
        pr(this.pr);
        this.zo = 0;
    }

    public int hn(int i) {
        int size = this.pr.size();
        for (int i2 = 0; i2 < size; i2++) {
            hw hwVar = this.pr.get(i2);
            switch (hwVar.pr) {
                case 1:
                    if (hwVar.hw <= i) {
                        i += hwVar.x;
                    }
                    break;
                case 2:
                    if (hwVar.hw > i) {
                        continue;
                    } else {
                        if (hwVar.hw + hwVar.x > i) {
                            return -1;
                        }
                        i -= hwVar.x;
                    }
                    break;
                case 8:
                    if (hwVar.hw == i) {
                        i = hwVar.x;
                    } else {
                        if (hwVar.hw < i) {
                            i--;
                        }
                        if (hwVar.x <= i) {
                            i++;
                        }
                    }
                    break;
            }
        }
        return i;
    }

    public boolean uc() {
        return (this.hw.isEmpty() || this.pr.isEmpty()) ? false : true;
    }

    @Override // com.byazt.hr.fw.pr
    public hw pr(int i, int i2, int i3, Object obj) {
        hw hwVarPr = this.fw.pr();
        if (hwVarPr == null) {
            return new hw(i, i2, i3, obj);
        }
        hwVarPr.pr = i;
        hwVarPr.hw = i2;
        hwVarPr.x = i3;
        hwVarPr.hn = obj;
        return hwVarPr;
    }

    @Override // com.byazt.hr.fw.pr
    public void pr(hw hwVar) {
        if (!this.c) {
            hwVar.hn = null;
            this.fw.pr(hwVar);
        }
    }

    public void pr(List<hw> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            pr(list.get(i));
        }
        list.clear();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    static class hw {
        public Object hn;
        public int hw;
        public int pr;
        public int x;

        public hw(int i, int i2, int i3, Object obj) {
            this.pr = i;
            this.hw = i2;
            this.x = i3;
            this.hn = obj;
        }

        public String pr() {
            switch (this.pr) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case 8:
                    return "mv";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + pr() + ",s:" + this.hw + "c:" + this.x + ",p:" + this.hn + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            hw hwVar = (hw) obj;
            int i = this.pr;
            if (i != hwVar.pr) {
                return false;
            }
            if (i == 8 && Math.abs(this.x - this.hw) == 1 && this.x == hwVar.hw && this.hw == hwVar.x) {
                return true;
            }
            if (this.x != hwVar.x || this.hw != hwVar.hw) {
                return false;
            }
            Object obj2 = this.hn;
            if (obj2 != null) {
                if (!obj2.equals(hwVar.hn)) {
                    return false;
                }
            } else if (hwVar.hn != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.pr * 31) + this.hw) * 31) + this.x;
        }
    }
}
