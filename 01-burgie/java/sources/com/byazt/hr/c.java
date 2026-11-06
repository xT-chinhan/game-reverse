package com.byazt.hr;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends RecyclerView.aj implements RecyclerView.qa.hw {
    public boolean a;
    public int c;
    public boolean cz;
    public boolean fo;
    public final pr fw;
    public boolean hn;
    public zo hw;
    public hn lb;
    public boolean ny;
    public int pr;
    public boolean qa;
    public final hw rc;
    public x uc;
    public int x;
    public int z;

    public c(Context context) {
        this(context, 1, false);
    }

    public c(Context context, int i, boolean z) {
        this.pr = 1;
        this.a = false;
        this.hn = false;
        this.cz = false;
        this.ny = true;
        this.x = -1;
        this.c = Integer.MIN_VALUE;
        this.uc = null;
        this.fw = new pr();
        this.rc = new hw();
        this.z = 2;
        pr(i);
        pr(z);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public boolean pr() {
        return true;
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public RecyclerView.vk hw() {
        return new RecyclerView.vk(-2, -2);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void pr(RecyclerView recyclerView, RecyclerView.nt ntVar) {
        super.pr(recyclerView, ntVar);
        if (this.fo) {
            hn(ntVar);
            ntVar.pr();
        }
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public boolean hn() {
        return this.pr == 0;
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public boolean x() {
        return this.pr == 1;
    }

    public void pr(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        pr((String) null);
        if (i != this.pr || this.hw == null) {
            zo zoVarPr = zo.pr(this, i);
            this.hw = zoVarPr;
            this.fw.pr = zoVarPr;
            this.pr = i;
            m();
        }
    }

    private void e() {
        if (this.pr != 1 && c()) {
            this.hn = !this.a;
        } else {
            this.hn = this.a;
        }
    }

    public void pr(boolean z) {
        pr((String) null);
        if (z != this.a) {
            this.a = z;
            m();
        }
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public View hw(int i) {
        int iQa = qa();
        if (iQa == 0) {
            return null;
        }
        int iX = i - x(zo(0));
        if (iX >= 0 && iX < iQa) {
            View viewZo = zo(iX);
            if (x(viewZo) == i) {
                return viewZo;
            }
        }
        return super.hw(i);
    }

    public int pr(RecyclerView.a aVar) {
        if (aVar.hn()) {
            return this.hw.uc();
        }
        return 0;
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void pr(RecyclerView recyclerView, RecyclerView.a aVar, int i) {
        uc ucVar = new uc(recyclerView.getContext());
        ucVar.hn(i);
        pr(ucVar);
    }

    @Override // com.byazt.hr.RecyclerView.qa.hw
    public PointF hn(int i) {
        if (qa() == 0) {
            return null;
        }
        boolean z = false;
        if (i < x(zo(0))) {
            z = true;
        }
        int i2 = z != this.hn ? -1 : 1;
        return this.pr == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void pr(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        int i;
        int i2;
        int i3;
        int i4;
        View viewHw;
        int iPr;
        if ((this.uc != null || this.x != -1) && aVar.x() == 0) {
            hn(ntVar);
            return;
        }
        x xVar = this.uc;
        if (xVar != null && xVar.pr()) {
            this.x = this.uc.pr;
        }
        uc();
        this.lb.pr = false;
        e();
        View viewVe = ve();
        if (this.fw.c && this.x == -1 && this.uc == null) {
            if (viewVe != null && (this.hw.pr(viewVe) >= this.hw.x() || this.hw.hw(viewVe) <= this.hw.hn())) {
                this.fw.pr(viewVe, x(viewVe));
            }
        } else {
            this.fw.pr();
            this.fw.x = this.hn ^ this.cz;
            pr(ntVar, aVar, this.fw);
            this.fw.c = true;
        }
        int iPr2 = pr(aVar);
        if (this.lb.vk >= 0) {
            i = iPr2;
            iPr2 = 0;
        } else {
            i = 0;
        }
        int iHn = iPr2 + this.hw.hn();
        int iFw = i + this.hw.fw();
        if (aVar.pr() && (i4 = this.x) != -1 && this.c != Integer.MIN_VALUE && (viewHw = hw(i4)) != null) {
            if (this.hn) {
                iPr = (this.hw.x() - this.hw.hw(viewHw)) - this.c;
            } else {
                iPr = this.c - (this.hw.pr(viewHw) - this.hw.hn());
            }
            if (iPr > 0) {
                iHn += iPr;
            } else {
                iFw -= iPr;
            }
        }
        pr(ntVar);
        this.lb.k = zo();
        this.lb.aj = aVar.pr();
        if (this.fw.x) {
            hw(this.fw);
            this.lb.zo = iHn;
            pr(ntVar, this.lb, aVar, false);
            i3 = this.lb.hw;
            int i5 = this.lb.x;
            if (this.lb.hn > 0) {
                iFw += this.lb.hn;
            }
            pr(this.fw);
            this.lb.zo = iFw;
            this.lb.x += this.lb.c;
            pr(ntVar, this.lb, aVar, false);
            i2 = this.lb.hw;
            if (this.lb.hn > 0) {
                int i6 = this.lb.hn;
                fw(i5, i3);
                this.lb.zo = i6;
                pr(ntVar, this.lb, aVar, false);
                i3 = this.lb.hw;
            }
        } else {
            pr(this.fw);
            this.lb.zo = iFw;
            pr(ntVar, this.lb, aVar, false);
            i2 = this.lb.hw;
            int i7 = this.lb.x;
            if (this.lb.hn > 0) {
                iHn += this.lb.hn;
            }
            hw(this.fw);
            this.lb.zo = iHn;
            this.lb.x += this.lb.c;
            pr(ntVar, this.lb, aVar, false);
            i3 = this.lb.hw;
            if (this.lb.hn > 0) {
                int i8 = this.lb.hn;
                uc(i7, i2);
                this.lb.zo = i8;
                pr(ntVar, this.lb, aVar, false);
                i2 = this.lb.hw;
            }
        }
        if (qa() > 0) {
            if (this.hn ^ this.cz) {
                int iPr3 = pr(i2, ntVar, aVar, true);
                int i9 = i3 + iPr3;
                int i10 = i2 + iPr3;
                int iHw = hw(i9, ntVar, aVar, false);
                i3 = i9 + iHw;
                i2 = i10 + iHw;
            } else {
                int iHw2 = hw(i3, ntVar, aVar, true);
                int i11 = i3 + iHw2;
                int i12 = i2 + iHw2;
                int iPr4 = pr(i12, ntVar, aVar, false);
                i3 = i11 + iPr4;
                i2 = i12 + iPr4;
            }
        }
        hw(ntVar, aVar, i3, i2);
        if (!aVar.pr()) {
            this.hw.pr();
        } else {
            this.fw.pr();
        }
        this.qa = this.cz;
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void hw(RecyclerView.a aVar) {
        super.hw(aVar);
        this.uc = null;
        this.x = -1;
        this.c = Integer.MIN_VALUE;
        this.fw.pr();
    }

    private void hw(RecyclerView.nt ntVar, RecyclerView.a aVar, int i, int i2) {
        boolean z;
        if (aVar.hw() && qa() != 0 && !aVar.pr() && k()) {
            List<RecyclerView.fo> listHn = ntVar.hn();
            int size = listHn.size();
            int iX = x(zo(0));
            int iC = 0;
            int iC2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                RecyclerView.fo foVar = listHn.get(i3);
                if (!foVar.yb()) {
                    if (foVar.x() >= iX) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if ((z != this.hn ? (byte) -1 : (byte) 1) == -1) {
                        iC += this.hw.c(foVar.pr);
                    } else {
                        iC2 += this.hw.c(foVar.pr);
                    }
                }
            }
            this.lb.w = listHn;
            if (iC > 0) {
                fw(x(s()), i);
                this.lb.zo = iC;
                this.lb.hn = 0;
                this.lb.pr();
                pr(ntVar, this.lb, aVar, false);
            }
            if (iC2 > 0) {
                uc(x(ls()), i2);
                this.lb.zo = iC2;
                this.lb.hn = 0;
                this.lb.pr();
                pr(ntVar, this.lb, aVar, false);
            }
            this.lb.w = null;
        }
    }

    private void pr(RecyclerView.nt ntVar, RecyclerView.a aVar, pr prVar) {
        if (!pr(aVar, prVar) && !hw(ntVar, aVar, prVar)) {
            prVar.hw();
            prVar.hw = this.cz ? aVar.x() - 1 : 0;
        }
    }

    private boolean hw(RecyclerView.nt ntVar, RecyclerView.a aVar, pr prVar) {
        if (qa() == 0) {
            return false;
        }
        View viewVe = ve();
        if (viewVe != null && prVar.pr(viewVe, aVar)) {
            prVar.pr(viewVe, x(viewVe));
            return true;
        }
        if (this.qa != this.cz) {
            return false;
        }
        View viewHw = prVar.x ? hw(ntVar, aVar) : hn(ntVar, aVar);
        if (viewHw == null) {
            return false;
        }
        prVar.hw(viewHw, x(viewHw));
        if (!aVar.pr() && k()) {
            if (this.hw.pr(viewHw) >= this.hw.x() || this.hw.hw(viewHw) < this.hw.hn()) {
                prVar.hn = prVar.x ? this.hw.x() : this.hw.hn();
            }
        }
        return true;
    }

    private boolean pr(RecyclerView.a aVar, pr prVar) {
        int i;
        if (aVar.pr() || (i = this.x) == -1) {
            return false;
        }
        if (i >= 0 && i < aVar.x()) {
            prVar.hw = this.x;
            x xVar = this.uc;
            if (xVar == null || !xVar.pr()) {
                if (this.c == Integer.MIN_VALUE) {
                    View viewHw = hw(this.x);
                    if (viewHw != null) {
                        if (this.hw.c(viewHw) > this.hw.uc()) {
                            prVar.hw();
                            return true;
                        }
                        if (this.hw.pr(viewHw) - this.hw.hn() < 0) {
                            prVar.hn = this.hw.hn();
                            prVar.x = false;
                            return true;
                        }
                        if (this.hw.x() - this.hw.hw(viewHw) < 0) {
                            prVar.hn = this.hw.x();
                            prVar.x = true;
                            return true;
                        }
                        prVar.hn = prVar.x ? this.hw.hw(viewHw) + this.hw.hw() : this.hw.pr(viewHw);
                    } else {
                        if (qa() > 0) {
                            prVar.x = (this.x < x(zo(0))) == this.hn;
                        }
                        prVar.hw();
                    }
                    return true;
                }
                prVar.x = this.hn;
                if (this.hn) {
                    prVar.hn = this.hw.x() - this.c;
                } else {
                    prVar.hn = this.hw.hn() + this.c;
                }
                return true;
            }
            prVar.x = this.uc.hn;
            if (prVar.x) {
                prVar.hn = this.hw.x() - this.uc.hw;
            } else {
                prVar.hn = this.hw.hn() + this.uc.hw;
            }
            return true;
        }
        this.x = -1;
        this.c = Integer.MIN_VALUE;
        return false;
    }

    private int pr(int i, RecyclerView.nt ntVar, RecyclerView.a aVar, boolean z) {
        int iX;
        int iX2 = this.hw.x() - i;
        if (iX2 > 0) {
            int i2 = -hn(-iX2, ntVar, aVar);
            int i3 = i + i2;
            if (z && (iX = this.hw.x() - i3) > 0) {
                this.hw.pr(iX);
                return iX + i2;
            }
            return i2;
        }
        return 0;
    }

    private int hw(int i, RecyclerView.nt ntVar, RecyclerView.a aVar, boolean z) {
        int iHn;
        int iHn2 = i - this.hw.hn();
        if (iHn2 > 0) {
            int i2 = -hn(iHn2, ntVar, aVar);
            int i3 = i + i2;
            if (z && (iHn = i3 - this.hw.hn()) > 0) {
                this.hw.pr(-iHn);
                return i2 - iHn;
            }
            return i2;
        }
        return 0;
    }

    private void pr(pr prVar) {
        uc(prVar.hw, prVar.hn);
    }

    private void uc(int i, int i2) {
        this.lb.hn = this.hw.x() - i2;
        this.lb.c = this.hn ? -1 : 1;
        this.lb.x = i;
        this.lb.uc = 1;
        this.lb.hw = i2;
        this.lb.fw = Integer.MIN_VALUE;
    }

    private void hw(pr prVar) {
        fw(prVar.hw, prVar.hn);
    }

    private void fw(int i, int i2) {
        this.lb.hn = i2 - this.hw.hn();
        this.lb.x = i;
        this.lb.c = this.hn ? 1 : -1;
        this.lb.uc = -1;
        this.lb.hw = i2;
        this.lb.fw = Integer.MIN_VALUE;
    }

    public boolean c() {
        return yb() == 1;
    }

    public void uc() {
        if (this.lb == null) {
            this.lb = fw();
        }
    }

    public hn fw() {
        return new hn();
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void x(int i) {
        this.x = i;
        this.c = Integer.MIN_VALUE;
        x xVar = this.uc;
        if (xVar != null) {
            xVar.hw();
        }
        m();
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int pr(int i, RecyclerView.nt ntVar, RecyclerView.a aVar) {
        if (this.pr == 1) {
            return 0;
        }
        return hn(i, ntVar, aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int hw(int i, RecyclerView.nt ntVar, RecyclerView.a aVar) {
        if (this.pr == 0) {
            return 0;
        }
        return hn(i, ntVar, aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int hn(RecyclerView.a aVar) {
        return aj(aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int x(RecyclerView.a aVar) {
        return aj(aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int c(RecyclerView.a aVar) {
        return vk(aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int uc(RecyclerView.a aVar) {
        return vk(aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int fw(RecyclerView.a aVar) {
        return w(aVar);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public int zo(RecyclerView.a aVar) {
        return w(aVar);
    }

    private int aj(RecyclerView.a aVar) {
        if (qa() == 0) {
            return 0;
        }
        uc();
        return vk.pr(aVar, this.hw, pr(!this.ny, true), hw(!this.ny, true), this, this.ny, this.hn);
    }

    private int vk(RecyclerView.a aVar) {
        if (qa() == 0) {
            return 0;
        }
        uc();
        return vk.pr(aVar, this.hw, pr(!this.ny, true), hw(!this.ny, true), this, this.ny);
    }

    private int w(RecyclerView.a aVar) {
        if (qa() == 0) {
            return 0;
        }
        uc();
        return vk.hw(aVar, this.hw, pr(!this.ny, true), hw(!this.ny, true), this, this.ny);
    }

    private void pr(int i, int i2, boolean z, RecyclerView.a aVar) {
        int iHn;
        this.lb.k = zo();
        this.lb.zo = pr(aVar);
        this.lb.uc = i;
        if (i == 1) {
            this.lb.zo += this.hw.fw();
            View viewLs = ls();
            this.lb.c = this.hn ? -1 : 1;
            this.lb.x = x(viewLs) + this.lb.c;
            this.lb.hw = this.hw.hw(viewLs);
            iHn = this.hw.hw(viewLs) - this.hw.x();
        } else {
            View viewS = s();
            this.lb.zo += this.hw.hn();
            this.lb.c = this.hn ? 1 : -1;
            this.lb.x = x(viewS) + this.lb.c;
            this.lb.hw = this.hw.pr(viewS);
            iHn = (-this.hw.pr(viewS)) + this.hw.hn();
        }
        this.lb.hn = i2;
        if (z) {
            this.lb.hn -= iHn;
        }
        this.lb.fw = iHn;
    }

    public boolean zo() {
        return this.hw.zo() == 0 && this.hw.c() == 0;
    }

    public void pr(RecyclerView.a aVar, hn hnVar, RecyclerView.aj.pr prVar) {
        int i = hnVar.x;
        if (i >= 0 && i < aVar.x()) {
            prVar.hw(i, Math.max(0, hnVar.fw));
        }
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void pr(int i, RecyclerView.aj.pr prVar) {
        boolean z;
        int i2;
        x xVar = this.uc;
        if (xVar != null && xVar.pr()) {
            z = this.uc.hn;
            i2 = this.uc.pr;
        } else {
            e();
            z = this.hn;
            i2 = this.x;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.z && i2 >= 0 && i2 < i; i4++) {
            prVar.hw(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void pr(int i, int i2, RecyclerView.a aVar, RecyclerView.aj.pr prVar) {
        if (this.pr != 0) {
            i = i2;
        }
        if (qa() != 0 && i != 0) {
            uc();
            pr(i > 0 ? 1 : -1, Math.abs(i), true, aVar);
            pr(aVar, this.lb, prVar);
        }
    }

    public int hn(int i, RecyclerView.nt ntVar, RecyclerView.a aVar) {
        if (qa() == 0 || i == 0) {
            return 0;
        }
        this.lb.pr = true;
        uc();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        pr(i2, iAbs, true, aVar);
        int iPr = this.lb.fw + pr(ntVar, this.lb, aVar, false);
        if (iPr < 0) {
            return 0;
        }
        if (iAbs > iPr) {
            i = i2 * iPr;
        }
        this.hw.pr(-i);
        this.lb.vk = i;
        return i;
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public void pr(String str) {
        if (this.uc == null) {
            super.pr(str);
        }
    }

    private void pr(RecyclerView.nt ntVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    pr(i3, ntVar);
                }
                return;
            }
            while (i > i2) {
                pr(i, ntVar);
                i--;
            }
        }
    }

    private void pr(RecyclerView.nt ntVar, int i) {
        if (i >= 0) {
            int iQa = qa();
            if (this.hn) {
                int i2 = iQa - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View viewZo = zo(i3);
                    if (this.hw.hw(viewZo) > i || this.hw.hn(viewZo) > i) {
                        pr(ntVar, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i4 = 0; i4 < iQa; i4++) {
                View viewZo2 = zo(i4);
                if (this.hw.hw(viewZo2) > i || this.hw.hn(viewZo2) > i) {
                    pr(ntVar, 0, i4);
                    return;
                }
            }
        }
    }

    private void hw(RecyclerView.nt ntVar, int i) {
        int iQa = qa();
        if (i >= 0) {
            int iC = this.hw.c() - i;
            if (this.hn) {
                for (int i2 = 0; i2 < iQa; i2++) {
                    View viewZo = zo(i2);
                    if (this.hw.pr(viewZo) < iC || this.hw.x(viewZo) < iC) {
                        pr(ntVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iQa - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewZo2 = zo(i4);
                if (this.hw.pr(viewZo2) < iC || this.hw.x(viewZo2) < iC) {
                    pr(ntVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void pr(RecyclerView.nt ntVar, hn hnVar) {
        if (hnVar.pr && !hnVar.k) {
            if (hnVar.uc == -1) {
                hw(ntVar, hnVar.fw);
            } else {
                pr(ntVar, hnVar.fw);
            }
        }
    }

    public int pr(RecyclerView.nt ntVar, hn hnVar, RecyclerView.a aVar, boolean z) {
        int i = hnVar.hn;
        if (hnVar.fw != Integer.MIN_VALUE) {
            if (hnVar.hn < 0) {
                hnVar.fw += hnVar.hn;
            }
            pr(ntVar, hnVar);
        }
        int i2 = hnVar.hn + hnVar.zo;
        hw hwVar = this.rc;
        while (true) {
            if ((!hnVar.k && i2 <= 0) || !hnVar.pr(aVar)) {
                break;
            }
            hwVar.pr();
            pr(ntVar, aVar, hnVar, hwVar);
            if (!hwVar.hw) {
                hnVar.hw += hwVar.pr * hnVar.uc;
                if (!hwVar.hn || this.lb.w != null || !aVar.pr()) {
                    hnVar.hn -= hwVar.pr;
                    i2 -= hwVar.pr;
                }
                if (hnVar.fw != Integer.MIN_VALUE) {
                    hnVar.fw += hwVar.pr;
                    if (hnVar.hn < 0) {
                        hnVar.fw += hnVar.hn;
                    }
                    pr(ntVar, hnVar);
                }
                if (z && hwVar.x) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - hnVar.hn;
    }

    public void pr(RecyclerView.nt ntVar, RecyclerView.a aVar, hn hnVar, hw hwVar) {
        int i;
        int i2;
        int i3;
        int iRc;
        int iUc;
        View viewPr = hnVar.pr(ntVar);
        if (viewPr == null) {
            hwVar.hw = true;
            return;
        }
        RecyclerView.vk vkVar = (RecyclerView.vk) viewPr.getLayoutParams();
        if (hnVar.w == null) {
            if (this.hn == (hnVar.uc == -1)) {
                hw(viewPr);
            } else {
                hw(viewPr, 0);
            }
        } else {
            if (this.hn == (hnVar.uc == -1)) {
                pr(viewPr);
            } else {
                pr(viewPr, 0);
            }
        }
        pr(viewPr, 0, 0);
        hwVar.pr = this.hw.c(viewPr);
        if (this.pr == 1) {
            if (c()) {
                iUc = ny() - b();
                iRc = iUc - this.hw.uc(viewPr);
            } else {
                iRc = rc();
                iUc = this.hw.uc(viewPr) + iRc;
            }
            if (hnVar.uc == -1) {
                int i4 = hnVar.hw;
                i2 = hnVar.hw - hwVar.pr;
                i = iUc;
                i3 = i4;
            } else {
                int i5 = hnVar.hw;
                i3 = hnVar.hw + hwVar.pr;
                i = iUc;
                i2 = i5;
            }
        } else {
            int iZ = z();
            int iUc2 = this.hw.uc(viewPr) + iZ;
            if (hnVar.uc == -1) {
                i2 = iZ;
                i = hnVar.hw;
                i3 = iUc2;
                iRc = hnVar.hw - hwVar.pr;
            } else {
                int i6 = hnVar.hw;
                i = hnVar.hw + hwVar.pr;
                i2 = iZ;
                i3 = iUc2;
                iRc = i6;
            }
        }
        pr(viewPr, iRc, i2, i, i3);
        if (vkVar.hw() || vkVar.hn()) {
            hwVar.hn = true;
        }
        hwVar.x = viewPr.hasFocusable();
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public boolean aj() {
        return (cz() == 1073741824 || a() == 1073741824 || !n()) ? false : true;
    }

    public int c(int i) {
        switch (i) {
            case 1:
                return (this.pr != 1 && c()) ? 1 : -1;
            case 2:
                return (this.pr != 1 && c()) ? -1 : 1;
            case 17:
                return this.pr == 0 ? -1 : Integer.MIN_VALUE;
            case 33:
                return this.pr == 1 ? -1 : Integer.MIN_VALUE;
            case 66:
                return this.pr == 0 ? 1 : Integer.MIN_VALUE;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                return this.pr == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View s() {
        return zo(this.hn ? qa() - 1 : 0);
    }

    private View ls() {
        return zo(this.hn ? 0 : qa() - 1);
    }

    private View pr(boolean z, boolean z2) {
        int iQa;
        int iQa2;
        if (this.hn) {
            iQa = qa() - 1;
            iQa2 = -1;
        } else {
            iQa = 0;
            iQa2 = qa();
        }
        return pr(iQa, iQa2, z, z2);
    }

    private View hw(boolean z, boolean z2) {
        int iQa;
        int iQa2;
        if (this.hn) {
            iQa = 0;
            iQa2 = qa();
        } else {
            iQa = qa() - 1;
            iQa2 = -1;
        }
        return pr(iQa, iQa2, z, z2);
    }

    private View hw(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return this.hn ? x(ntVar, aVar) : c(ntVar, aVar);
    }

    private View hn(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return this.hn ? c(ntVar, aVar) : x(ntVar, aVar);
    }

    private View x(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return pr(ntVar, aVar, 0, qa(), aVar.x());
    }

    private View c(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return pr(ntVar, aVar, qa() - 1, -1, aVar.x());
    }

    public View pr(RecyclerView.nt ntVar, RecyclerView.a aVar, int i, int i2, int i3) {
        uc();
        int iHn = this.hw.hn();
        int iX = this.hw.x();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewZo = zo(i);
            int iX2 = x(viewZo);
            if (iX2 >= 0 && iX2 < i3) {
                if (((RecyclerView.vk) viewZo.getLayoutParams()).hw()) {
                    if (view2 == null) {
                        view2 = viewZo;
                    }
                } else {
                    if (this.hw.pr(viewZo) < iX && this.hw.hw(viewZo) >= iHn) {
                        return viewZo;
                    }
                    if (view == null) {
                        view = viewZo;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View uc(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return this.hn ? zo(ntVar, aVar) : aj(ntVar, aVar);
    }

    private View fw(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return this.hn ? aj(ntVar, aVar) : zo(ntVar, aVar);
    }

    private View zo(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return pr(0, qa());
    }

    private View aj(RecyclerView.nt ntVar, RecyclerView.a aVar) {
        return pr(qa() - 1, -1);
    }

    public int vk() {
        View viewPr = pr(0, qa(), false, true);
        if (viewPr == null) {
            return -1;
        }
        return x(viewPr);
    }

    public int w() {
        View viewPr = pr(qa() - 1, -1, false, true);
        if (viewPr == null) {
            return -1;
        }
        return x(viewPr);
    }

    public View pr(int i, int i2, boolean z, boolean z2) {
        int i3;
        uc();
        int i4 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = 0;
        }
        return (this.pr == 0 ? this.vk : this.w).pr(i, i2, i3, i4);
    }

    public View pr(int i, int i2) {
        byte b;
        int i3;
        int i4;
        uc();
        if (i2 > i) {
            b = 1;
        } else {
            b = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b == 0) {
            return zo(i);
        }
        if (this.hw.pr(zo(i)) < this.hw.hn()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.pr == 0 ? this.vk : this.w).pr(i, i2, i3, i4);
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public View pr(View view, int i, RecyclerView.nt ntVar, RecyclerView.a aVar) {
        int iC;
        View viewUc;
        View viewLs;
        e();
        if (qa() == 0 || (iC = c(i)) == Integer.MIN_VALUE) {
            return null;
        }
        uc();
        uc();
        pr(iC, (int) (this.hw.uc() * 0.33333334f), false, aVar);
        this.lb.fw = Integer.MIN_VALUE;
        this.lb.pr = false;
        pr(ntVar, this.lb, aVar, true);
        if (iC == -1) {
            viewUc = fw(ntVar, aVar);
        } else {
            viewUc = uc(ntVar, aVar);
        }
        if (iC == -1) {
            viewLs = s();
        } else {
            viewLs = ls();
        }
        if (viewLs.hasFocusable()) {
            if (viewUc == null) {
                return null;
            }
            return viewLs;
        }
        return viewUc;
    }

    @Override // com.byazt.hr.RecyclerView.aj
    public boolean k() {
        return this.uc == null && this.qa == this.cz;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 401})
    protected static class hw {
        public boolean hn;
        public boolean hw;
        public int pr;
        public boolean x;

        public void pr() {
            this.pr = 0;
            this.hw = false;
            this.hn = false;
            this.x = false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 169})
    static class pr {
        public boolean c;
        public int hn;
        public int hw;
        public zo pr;
        public boolean x;

        public pr() {
            pr();
        }

        public void pr() {
            this.hw = -1;
            this.hn = Integer.MIN_VALUE;
            this.x = false;
            this.c = false;
        }

        public void hw() {
            this.hn = this.x ? this.pr.x() : this.pr.hn();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.hw + ", mCoordinate=" + this.hn + ", mLayoutFromEnd=" + this.x + ", mValid=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }

        public boolean pr(View view, RecyclerView.a aVar) {
            RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
            return !vkVar.hw() && vkVar.x() >= 0 && vkVar.x() < aVar.x();
        }

        public void pr(View view, int i) {
            int iHw = this.pr.hw();
            if (iHw >= 0) {
                hw(view, i);
                return;
            }
            this.hw = i;
            if (this.x) {
                int iX = (this.pr.x() - iHw) - this.pr.hw(view);
                this.hn = this.pr.x() - iX;
                if (iX > 0) {
                    int iC = this.hn - this.pr.c(view);
                    int iHn = this.pr.hn();
                    int iMin = iC - (iHn + Math.min(this.pr.pr(view) - iHn, 0));
                    if (iMin < 0) {
                        this.hn += Math.min(iX, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iPr = this.pr.pr(view);
            int iHn2 = iPr - this.pr.hn();
            this.hn = iPr;
            if (iHn2 > 0) {
                int iX2 = (this.pr.x() - Math.min(0, (this.pr.x() - iHw) - this.pr.hw(view))) - (iPr + this.pr.c(view));
                if (iX2 < 0) {
                    this.hn -= Math.min(iHn2, -iX2);
                }
            }
        }

        public void hw(View view, int i) {
            if (this.x) {
                this.hn = this.pr.hw(view) + this.pr.hw();
            } else {
                this.hn = this.pr.pr(view);
            }
            this.hw = i;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC})
    public static class x implements Parcelable {
        public static final Parcelable.Creator<x> CREATOR = new Parcelable.Creator<x>() { // from class: com.byazt.hr.c.x.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i) {
                return new x[i];
            }
        };
        public boolean hn;
        public int hw;
        public int pr;

        public x() {
        }

        public x(Parcel parcel) {
            this.pr = parcel.readInt();
            this.hw = parcel.readInt();
            this.hn = parcel.readInt() == 1;
        }

        public boolean pr() {
            return this.pr >= 0;
        }

        public void hw() {
            this.pr = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.pr);
            parcel.writeInt(this.hw);
            parcel.writeInt(this.hn ? 1 : 0);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 917})
    static class hn {
        public int c;
        public int fw;
        public int hn;
        public int hw;
        public boolean k;
        public int uc;
        public int vk;
        public int x;
        public boolean pr = true;
        public int zo = 0;
        public boolean aj = false;
        public List<RecyclerView.fo> w = null;

        public boolean pr(RecyclerView.a aVar) {
            int i = this.x;
            return i >= 0 && i < aVar.x();
        }

        public View pr(RecyclerView.nt ntVar) {
            if (this.w != null) {
                return hw();
            }
            View viewHw = ntVar.hw(this.x);
            this.x += this.c;
            return viewHw;
        }

        private View hw() {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                View view = this.w.get(i).pr;
                RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
                if (!vkVar.hw() && this.x == vkVar.x()) {
                    pr(view);
                    return view;
                }
            }
            return null;
        }

        public void pr() {
            pr((View) null);
        }

        public void pr(View view) {
            View viewHw = hw(view);
            if (viewHw == null) {
                this.x = -1;
            } else {
                this.x = ((RecyclerView.vk) viewHw.getLayoutParams()).x();
            }
        }

        public View hw(View view) {
            int iX;
            int size = this.w.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.w.get(i2).pr;
                RecyclerView.vk vkVar = (RecyclerView.vk) view3.getLayoutParams();
                if (view3 != view && !vkVar.hw() && (iX = (vkVar.x() - this.x) * this.c) >= 0 && iX < i) {
                    view2 = view3;
                    if (iX == 0) {
                        break;
                    }
                    i = iX;
                }
            }
            return view2;
        }
    }
}
