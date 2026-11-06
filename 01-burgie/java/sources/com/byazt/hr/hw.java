package com.byazt.hr;

import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 13})
public class hw {
    public final InterfaceC0088hw pr;
    public final pr hw = new pr();
    public final List<View> hn = new ArrayList();

    /* JADX INFO: renamed from: com.byazt.hr.hw$hw, reason: collision with other inner class name */
    interface InterfaceC0088hw {
        void hn(int i);

        void hn(View view);

        View hw(int i);

        RecyclerView.fo hw(View view);

        void hw();

        int pr();

        int pr(View view);

        void pr(int i);

        void pr(View view, int i);

        void pr(View view, int i, ViewGroup.LayoutParams layoutParams);

        void x(View view);
    }

    public hw(InterfaceC0088hw interfaceC0088hw) {
        this.pr = interfaceC0088hw;
    }

    private void fw(View view) {
        this.hn.add(view);
        this.pr.hn(view);
    }

    private boolean zo(View view) {
        if (this.hn.remove(view)) {
            this.pr.x(view);
            return true;
        }
        return false;
    }

    public void pr(View view, boolean z) {
        pr(view, -1, z);
    }

    public void pr(View view, int i, boolean z) {
        int iUc;
        if (i < 0) {
            iUc = this.pr.pr();
        } else {
            iUc = uc(i);
        }
        this.hw.insert(iUc, z);
        if (z) {
            fw(view);
        }
        this.pr.pr(view, iUc);
    }

    private int uc(int i) {
        if (i < 0) {
            return -1;
        }
        int iPr = this.pr.pr();
        int i2 = i;
        while (i2 < iPr) {
            int iC = i - (i2 - this.hw.c(i2));
            if (iC != 0) {
                i2 += iC;
            } else {
                while (this.hw.hn(i2)) {
                    i2++;
                }
                return i2;
            }
        }
        return -1;
    }

    public void pr(View view) {
        int iPr = this.pr.pr(view);
        if (iPr >= 0) {
            if (this.hw.x(iPr)) {
                zo(view);
            }
            this.pr.pr(iPr);
        }
    }

    public void pr(int i) {
        int iUc = uc(i);
        View viewHw = this.pr.hw(iUc);
        if (viewHw != null) {
            if (this.hw.x(iUc)) {
                zo(viewHw);
            }
            this.pr.pr(iUc);
        }
    }

    public View hw(int i) {
        return this.pr.hw(uc(i));
    }

    public void pr() {
        this.hw.pr();
        for (int size = this.hn.size() - 1; size >= 0; size--) {
            this.pr.x(this.hn.get(size));
            this.hn.remove(size);
        }
        this.pr.hw();
    }

    public View hn(int i) {
        int size = this.hn.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.hn.get(i2);
            RecyclerView.fo foVarHw = this.pr.hw(view);
            if (foVarHw.x() == i && !foVarHw.g() && !foVarHw.yb()) {
                return view;
            }
        }
        return null;
    }

    public void pr(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iUc;
        if (i < 0) {
            iUc = this.pr.pr();
        } else {
            iUc = uc(i);
        }
        this.hw.insert(iUc, z);
        if (z) {
            fw(view);
        }
        this.pr.pr(view, iUc, layoutParams);
    }

    public int hw() {
        return this.pr.pr() - this.hn.size();
    }

    public int hn() {
        return this.pr.pr();
    }

    public View x(int i) {
        return this.pr.hw(i);
    }

    public void c(int i) {
        int iUc = uc(i);
        this.hw.x(iUc);
        this.pr.hn(iUc);
    }

    public int hw(View view) {
        int iPr = this.pr.pr(view);
        if (iPr == -1 || this.hw.hn(iPr)) {
            return -1;
        }
        return iPr - this.hw.c(iPr);
    }

    public boolean hn(View view) {
        return this.hn.contains(view);
    }

    public void x(View view) {
        int iPr = this.pr.pr(view);
        if (iPr < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.hw.pr(iPr);
        fw(view);
    }

    public void c(View view) {
        int iPr = this.pr.pr(view);
        if (iPr < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        if (!this.hw.hn(iPr)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        this.hw.hw(iPr);
        zo(view);
    }

    public String toString() {
        return this.hw.toString() + ", hidden list:" + this.hn.size();
    }

    public boolean uc(View view) {
        int iPr = this.pr.pr(view);
        if (iPr == -1) {
            zo(view);
            return true;
        }
        if (this.hw.hn(iPr)) {
            this.hw.x(iPr);
            zo(view);
            this.pr.pr(iPr);
            return true;
        }
        return false;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    static class pr {
        public pr hw;
        public long pr = 0;

        public void pr(int i) {
            if (i >= 64) {
                hw();
                this.hw.pr(i - 64);
            } else {
                this.pr |= 1 << i;
            }
        }

        private void hw() {
            if (this.hw == null) {
                this.hw = new pr();
            }
        }

        public void hw(int i) {
            if (i >= 64) {
                pr prVar = this.hw;
                if (prVar != null) {
                    prVar.hw(i - 64);
                    return;
                }
                return;
            }
            this.pr &= ~(1 << i);
        }

        public boolean hn(int i) {
            if (i < 64) {
                return (this.pr & (1 << i)) != 0;
            }
            hw();
            return this.hw.hn(i - 64);
        }

        public void pr() {
            this.pr = 0L;
            pr prVar = this.hw;
            if (prVar != null) {
                prVar.pr();
            }
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                hw();
                this.hw.insert(i - 64, z);
                return;
            }
            long j = this.pr;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.pr = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                pr(i);
            } else {
                hw(i);
            }
            if (z2 || this.hw != null) {
                hw();
                this.hw.insert(0, z2);
            }
        }

        public boolean x(int i) {
            if (i >= 64) {
                hw();
                return this.hw.x(i - 64);
            }
            long j = 1 << i;
            long j2 = this.pr;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.pr = j3;
            long j4 = j - 1;
            this.pr = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            pr prVar = this.hw;
            if (prVar != null) {
                if (prVar.hn(0)) {
                    pr(63);
                }
                this.hw.x(0);
            }
            return z;
        }

        public int c(int i) {
            pr prVar = this.hw;
            if (prVar == null) {
                return Long.bitCount(i >= 64 ? this.pr : this.pr & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.pr & ((1 << i) - 1)) : prVar.c(i - 64) + Long.bitCount(this.pr);
        }

        public String toString() {
            return this.hw == null ? Long.toBinaryString(this.pr) : this.hw.toString() + "xx" + Long.toBinaryString(this.pr);
        }
    }
}
