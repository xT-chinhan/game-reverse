package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends RecyclerView.ny implements RecyclerView.y.xr {
    final ms ab;
    boolean ah;
    private boolean b;
    d c;
    int d;
    private final xr i;
    int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f1413ms;
    private boolean nw;
    private ah qv;
    private boolean re;
    private boolean t;
    private int w;
    x xr;
    private boolean y;

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public boolean ms() {
        return true;
    }

    public ka(Context context) {
        this(context, 1, false);
    }

    public ka(Context context, int i, boolean z) {
        this.f1413ms = 1;
        this.t = false;
        this.ah = false;
        this.nw = false;
        this.b = true;
        this.d = -1;
        this.ka = Integer.MIN_VALUE;
        this.c = null;
        this.ab = new ms();
        this.i = new xr();
        this.w = 2;
        ms(i);
        ms(z);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public RecyclerView.ch xr() {
        return new RecyclerView.ch(-2, -2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(RecyclerView recyclerView, RecyclerView.ao aoVar) {
        super.ms(recyclerView, aoVar);
        if (this.re) {
            ah(aoVar);
            aoVar.ms();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public boolean ah() {
        return this.f1413ms == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public boolean d() {
        return this.f1413ms == 1;
    }

    public void ms(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        ms((String) null);
        if (i != this.f1413ms || this.xr == null) {
            x xVarMs = x.ms(this, i);
            this.xr = xVarMs;
            this.ab.f1416ms = xVarMs;
            this.f1413ms = i;
            zb();
        }
    }

    private void jw() {
        if (this.f1413ms != 1 && ka()) {
            this.ah = !this.t;
        } else {
            this.ah = this.t;
        }
    }

    public void ms(boolean z) {
        ms((String) null);
        if (z != this.t) {
            this.t = z;
            zb();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public View xr(int i) {
        int iY = y();
        if (iY == 0) {
            return null;
        }
        int iD = i - d(x(0));
        if (iD >= 0 && iD < iY) {
            View viewX = x(iD);
            if (d(viewX) == i) {
                return viewX;
            }
        }
        return super.xr(i);
    }

    protected int ms(RecyclerView.t tVar) {
        if (tVar.ah()) {
            return this.xr.c();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        c cVar = new c(recyclerView.getContext());
        cVar.ah(i);
        ms(cVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y.xr
    public PointF ah(int i) {
        if (y() == 0) {
            return null;
        }
        int i2 = (i < d(x(0))) != this.ah ? -1 : 1;
        return this.f1413ms == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iMs;
        int i6;
        View viewXr;
        int iMs2;
        int iD;
        if ((this.c != null || this.d != -1) && tVar.d() == 0) {
            ah(aoVar);
            return;
        }
        d dVar = this.c;
        if (dVar != null && dVar.ms()) {
            this.d = this.c.f1415ms;
        }
        c();
        this.qv.f1414ms = false;
        jw();
        View viewLe = le();
        if (this.ab.ka && this.d == -1 && this.c == null) {
            if (viewLe != null && (this.xr.ms(viewLe) >= this.xr.d() || this.xr.xr(viewLe) <= this.xr.ah())) {
                this.ab.ms(viewLe, d(viewLe));
            }
        } else {
            this.ab.ms();
            this.ab.d = this.ah ^ this.nw;
            ms(aoVar, tVar, this.ab);
            this.ab.ka = true;
        }
        int iMs3 = ms(tVar);
        if (this.qv.ch >= 0) {
            i = iMs3;
            iMs3 = 0;
        } else {
            i = 0;
        }
        int iAh = iMs3 + this.xr.ah();
        int iAb = i + this.xr.ab();
        if (tVar.ms() && (i6 = this.d) != -1 && this.ka != Integer.MIN_VALUE && (viewXr = xr(i6)) != null) {
            if (this.ah) {
                iD = this.xr.d() - this.xr.xr(viewXr);
                iMs2 = this.ka;
            } else {
                iMs2 = this.xr.ms(viewXr) - this.xr.ah();
                iD = this.ka;
            }
            int i7 = iD - iMs2;
            if (i7 > 0) {
                iAh += i7;
            } else {
                iAb -= i7;
            }
        }
        ms(aoVar);
        this.qv.sl = x();
        this.qv.ny = tVar.ms();
        if (this.ab.d) {
            xr(this.ab);
            this.qv.x = iAh;
            ms(aoVar, this.qv, tVar, false);
            i3 = this.qv.xr;
            int i8 = this.qv.d;
            if (this.qv.ah > 0) {
                iAb += this.qv.ah;
            }
            ms(this.ab);
            this.qv.x = iAb;
            this.qv.d += this.qv.ka;
            ms(aoVar, this.qv, tVar, false);
            i2 = this.qv.xr;
            if (this.qv.ah > 0) {
                int i9 = this.qv.ah;
                ab(i8, i3);
                this.qv.x = i9;
                ms(aoVar, this.qv, tVar, false);
                i3 = this.qv.xr;
            }
        } else {
            ms(this.ab);
            this.qv.x = iAb;
            ms(aoVar, this.qv, tVar, false);
            i2 = this.qv.xr;
            int i10 = this.qv.d;
            if (this.qv.ah > 0) {
                iAh += this.qv.ah;
            }
            xr(this.ab);
            this.qv.x = iAh;
            this.qv.d += this.qv.ka;
            ms(aoVar, this.qv, tVar, false);
            i3 = this.qv.xr;
            if (this.qv.ah > 0) {
                int i11 = this.qv.ah;
                c(i10, i2);
                this.qv.x = i11;
                ms(aoVar, this.qv, tVar, false);
                i2 = this.qv.xr;
            }
        }
        if (y() > 0) {
            if (this.ah ^ this.nw) {
                int iMs4 = ms(i2, aoVar, tVar, true);
                i4 = i3 + iMs4;
                i5 = i2 + iMs4;
                iMs = xr(i4, aoVar, tVar, false);
            } else {
                int iXr = xr(i3, aoVar, tVar, true);
                i4 = i3 + iXr;
                i5 = i2 + iXr;
                iMs = ms(i5, aoVar, tVar, false);
            }
            i3 = i4 + iMs;
            i2 = i5 + iMs;
        }
        xr(aoVar, tVar, i3, i2);
        if (!tVar.ms()) {
            this.xr.ms();
        } else {
            this.ab.ms();
        }
        this.y = this.nw;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void xr(RecyclerView.t tVar) {
        super.xr(tVar);
        this.c = null;
        this.d = -1;
        this.ka = Integer.MIN_VALUE;
        this.ab.ms();
    }

    private void xr(RecyclerView.ao aoVar, RecyclerView.t tVar, int i, int i2) {
        if (!tVar.xr() || y() == 0 || tVar.ms() || !sl()) {
            return;
        }
        List<RecyclerView.re> listAh = aoVar.ah();
        int size = listAh.size();
        int iD = d(x(0));
        int iKa = 0;
        int iKa2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.re reVar = listAh.get(i3);
            if (!reVar.h()) {
                if (((reVar.d() < iD) != this.ah ? (byte) -1 : (byte) 1) == -1) {
                    iKa += this.xr.ka(reVar.f1391ms);
                } else {
                    iKa2 += this.xr.ka(reVar.f1391ms);
                }
            }
        }
        this.qv.hi = listAh;
        if (iKa > 0) {
            ab(d(f()), i);
            this.qv.x = iKa;
            this.qv.ah = 0;
            this.qv.ms();
            ms(aoVar, this.qv, tVar, false);
        }
        if (iKa2 > 0) {
            c(d(ul()), i2);
            this.qv.x = iKa2;
            this.qv.ah = 0;
            this.qv.ms();
            ms(aoVar, this.qv, tVar, false);
        }
        this.qv.hi = null;
    }

    private void ms(RecyclerView.ao aoVar, RecyclerView.t tVar, ms msVar) {
        if (ms(tVar, msVar) || xr(aoVar, tVar, msVar)) {
            return;
        }
        msVar.xr();
        msVar.xr = this.nw ? tVar.d() - 1 : 0;
    }

    private boolean xr(RecyclerView.ao aoVar, RecyclerView.t tVar, ms msVar) {
        if (y() == 0) {
            return false;
        }
        View viewLe = le();
        if (viewLe != null && msVar.ms(viewLe, tVar)) {
            msVar.ms(viewLe, d(viewLe));
            return true;
        }
        if (this.y != this.nw) {
            return false;
        }
        View viewXr = msVar.d ? xr(aoVar, tVar) : ah(aoVar, tVar);
        if (viewXr == null) {
            return false;
        }
        msVar.xr(viewXr, d(viewXr));
        if (!tVar.ms() && sl()) {
            if (this.xr.ms(viewXr) >= this.xr.d() || this.xr.xr(viewXr) < this.xr.ah()) {
                msVar.ah = msVar.d ? this.xr.d() : this.xr.ah();
            }
        }
        return true;
    }

    private boolean ms(RecyclerView.t tVar, ms msVar) {
        int i;
        if (!tVar.ms() && (i = this.d) != -1) {
            if (i >= 0 && i < tVar.d()) {
                msVar.xr = this.d;
                d dVar = this.c;
                if (dVar != null && dVar.ms()) {
                    msVar.d = this.c.ah;
                    if (msVar.d) {
                        msVar.ah = this.xr.d() - this.c.xr;
                    } else {
                        msVar.ah = this.xr.ah() + this.c.xr;
                    }
                    return true;
                }
                if (this.ka == Integer.MIN_VALUE) {
                    View viewXr = xr(this.d);
                    if (viewXr != null) {
                        if (this.xr.ka(viewXr) > this.xr.c()) {
                            msVar.xr();
                            return true;
                        }
                        if (this.xr.ms(viewXr) - this.xr.ah() < 0) {
                            msVar.ah = this.xr.ah();
                            msVar.d = false;
                            return true;
                        }
                        if (this.xr.d() - this.xr.xr(viewXr) < 0) {
                            msVar.ah = this.xr.d();
                            msVar.d = true;
                            return true;
                        }
                        msVar.ah = msVar.d ? this.xr.xr(viewXr) + this.xr.xr() : this.xr.ms(viewXr);
                    } else {
                        if (y() > 0) {
                            msVar.d = (this.d < d(x(0))) == this.ah;
                        }
                        msVar.xr();
                    }
                    return true;
                }
                msVar.d = this.ah;
                if (this.ah) {
                    msVar.ah = this.xr.d() - this.ka;
                } else {
                    msVar.ah = this.xr.ah() + this.ka;
                }
                return true;
            }
            this.d = -1;
            this.ka = Integer.MIN_VALUE;
        }
        return false;
    }

    private int ms(int i, RecyclerView.ao aoVar, RecyclerView.t tVar, boolean z) {
        int iD;
        int iD2 = this.xr.d() - i;
        if (iD2 <= 0) {
            return 0;
        }
        int i2 = -ah(-iD2, aoVar, tVar);
        int i3 = i + i2;
        if (!z || (iD = this.xr.d() - i3) <= 0) {
            return i2;
        }
        this.xr.ms(iD);
        return iD + i2;
    }

    private int xr(int i, RecyclerView.ao aoVar, RecyclerView.t tVar, boolean z) {
        int iAh;
        int iAh2 = i - this.xr.ah();
        if (iAh2 <= 0) {
            return 0;
        }
        int i2 = -ah(iAh2, aoVar, tVar);
        int i3 = i + i2;
        if (!z || (iAh = i3 - this.xr.ah()) <= 0) {
            return i2;
        }
        this.xr.ms(-iAh);
        return i2 - iAh;
    }

    private void ms(ms msVar) {
        c(msVar.xr, msVar.ah);
    }

    private void c(int i, int i2) {
        this.qv.ah = this.xr.d() - i2;
        this.qv.ka = this.ah ? -1 : 1;
        this.qv.d = i;
        this.qv.c = 1;
        this.qv.xr = i2;
        this.qv.ab = Integer.MIN_VALUE;
    }

    private void xr(ms msVar) {
        ab(msVar.xr, msVar.ah);
    }

    private void ab(int i, int i2) {
        this.qv.ah = i2 - this.xr.ah();
        this.qv.d = i;
        this.qv.ka = this.ah ? 1 : -1;
        this.qv.c = -1;
        this.qv.xr = i2;
        this.qv.ab = Integer.MIN_VALUE;
    }

    protected boolean ka() {
        return h() == 1;
    }

    void c() {
        if (this.qv == null) {
            this.qv = ab();
        }
    }

    ah ab() {
        return new ah();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void d(int i) {
        this.d = i;
        this.ka = Integer.MIN_VALUE;
        d dVar = this.c;
        if (dVar != null) {
            dVar.xr();
        }
        zb();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int ms(int i, RecyclerView.ao aoVar, RecyclerView.t tVar) {
        if (this.f1413ms == 1) {
            return 0;
        }
        return ah(i, aoVar, tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int xr(int i, RecyclerView.ao aoVar, RecyclerView.t tVar) {
        if (this.f1413ms == 0) {
            return 0;
        }
        return ah(i, aoVar, tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int ah(RecyclerView.t tVar) {
        return ny(tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int d(RecyclerView.t tVar) {
        return ny(tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int ka(RecyclerView.t tVar) {
        return ch(tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int c(RecyclerView.t tVar) {
        return ch(tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int ab(RecyclerView.t tVar) {
        return hi(tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int x(RecyclerView.t tVar) {
        return hi(tVar);
    }

    private int ny(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        c();
        return ch.ms(tVar, this.xr, ms(!this.b, true), xr(!this.b, true), this, this.b, this.ah);
    }

    private int ch(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        c();
        return ch.ms(tVar, this.xr, ms(!this.b, true), xr(!this.b, true), this, this.b);
    }

    private int hi(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        c();
        return ch.xr(tVar, this.xr, ms(!this.b, true), xr(!this.b, true), this, this.b);
    }

    private void ms(int i, int i2, boolean z, RecyclerView.t tVar) {
        int iAh;
        this.qv.sl = x();
        this.qv.x = ms(tVar);
        this.qv.c = i;
        if (i == 1) {
            this.qv.x += this.xr.ab();
            View viewUl = ul();
            this.qv.ka = this.ah ? -1 : 1;
            this.qv.d = d(viewUl) + this.qv.ka;
            this.qv.xr = this.xr.xr(viewUl);
            iAh = this.xr.xr(viewUl) - this.xr.d();
        } else {
            View viewF = f();
            this.qv.x += this.xr.ah();
            this.qv.ka = this.ah ? 1 : -1;
            this.qv.d = d(viewF) + this.qv.ka;
            this.qv.xr = this.xr.ms(viewF);
            iAh = (-this.xr.ms(viewF)) + this.xr.ah();
        }
        this.qv.ah = i2;
        if (z) {
            this.qv.ah -= iAh;
        }
        this.qv.ab = iAh;
    }

    boolean x() {
        return this.xr.x() == 0 && this.xr.ka() == 0;
    }

    void ms(RecyclerView.t tVar, ah ahVar, RecyclerView.ny.ms msVar) {
        int i = ahVar.d;
        if (i < 0 || i >= tVar.d()) {
            return;
        }
        msVar.xr(i, Math.max(0, ahVar.ab));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(int i, RecyclerView.ny.ms msVar) {
        boolean z;
        int i2;
        d dVar = this.c;
        if (dVar != null && dVar.ms()) {
            z = this.c.ah;
            i2 = this.c.f1415ms;
        } else {
            jw();
            z = this.ah;
            i2 = this.d;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.w && i2 >= 0 && i2 < i; i4++) {
            msVar.xr(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(int i, int i2, RecyclerView.t tVar, RecyclerView.ny.ms msVar) {
        if (this.f1413ms != 0) {
            i = i2;
        }
        if (y() == 0 || i == 0) {
            return;
        }
        c();
        ms(i > 0 ? 1 : -1, Math.abs(i), true, tVar);
        ms(tVar, this.qv, msVar);
    }

    int ah(int i, RecyclerView.ao aoVar, RecyclerView.t tVar) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        this.qv.f1414ms = true;
        c();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        ms(i2, iAbs, true, tVar);
        int iMs = this.qv.ab + ms(aoVar, this.qv, tVar, false);
        if (iMs < 0) {
            return 0;
        }
        if (iAbs > iMs) {
            i = i2 * iMs;
        }
        this.xr.ms(-i);
        this.qv.ch = i;
        return i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(String str) {
        if (this.c == null) {
            super.ms(str);
        }
    }

    private void ms(RecyclerView.ao aoVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    ms(i, aoVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    ms(i3, aoVar);
                }
            }
        }
    }

    private void ms(RecyclerView.ao aoVar, int i) {
        if (i >= 0) {
            int iY = y();
            if (!this.ah) {
                for (int i2 = 0; i2 < iY; i2++) {
                    View viewX = x(i2);
                    if (this.xr.xr(viewX) > i || this.xr.ah(viewX) > i) {
                        ms(aoVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iY - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewX2 = x(i4);
                if (this.xr.xr(viewX2) > i || this.xr.ah(viewX2) > i) {
                    ms(aoVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void xr(RecyclerView.ao aoVar, int i) {
        int iY = y();
        if (i >= 0) {
            int iKa = this.xr.ka() - i;
            if (this.ah) {
                for (int i2 = 0; i2 < iY; i2++) {
                    View viewX = x(i2);
                    if (this.xr.ms(viewX) < iKa || this.xr.d(viewX) < iKa) {
                        ms(aoVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iY - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewX2 = x(i4);
                if (this.xr.ms(viewX2) < iKa || this.xr.d(viewX2) < iKa) {
                    ms(aoVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void ms(RecyclerView.ao aoVar, ah ahVar) {
        if (!ahVar.f1414ms || ahVar.sl) {
            return;
        }
        if (ahVar.c == -1) {
            xr(aoVar, ahVar.ab);
        } else {
            ms(aoVar, ahVar.ab);
        }
    }

    int ms(RecyclerView.ao aoVar, ah ahVar, RecyclerView.t tVar, boolean z) {
        int i = ahVar.ah;
        if (ahVar.ab != Integer.MIN_VALUE) {
            if (ahVar.ah < 0) {
                ahVar.ab += ahVar.ah;
            }
            ms(aoVar, ahVar);
        }
        int i2 = ahVar.ah + ahVar.x;
        xr xrVar = this.i;
        while (true) {
            if ((!ahVar.sl && i2 <= 0) || !ahVar.ms(tVar)) {
                break;
            }
            xrVar.ms();
            ms(aoVar, tVar, ahVar, xrVar);
            if (!xrVar.xr) {
                ahVar.xr += xrVar.f1417ms * ahVar.c;
                if (!xrVar.ah || this.qv.hi != null || !tVar.ms()) {
                    ahVar.ah -= xrVar.f1417ms;
                    i2 -= xrVar.f1417ms;
                }
                if (ahVar.ab != Integer.MIN_VALUE) {
                    ahVar.ab += xrVar.f1417ms;
                    if (ahVar.ah < 0) {
                        ahVar.ab += ahVar.ah;
                    }
                    ms(aoVar, ahVar);
                }
                if (z && xrVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - ahVar.ah;
    }

    void ms(RecyclerView.ao aoVar, RecyclerView.t tVar, ah ahVar, xr xrVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iC;
        View viewMs = ahVar.ms(aoVar);
        if (viewMs == null) {
            xrVar.xr = true;
            return;
        }
        RecyclerView.ch chVar = (RecyclerView.ch) viewMs.getLayoutParams();
        if (ahVar.hi == null) {
            if (this.ah == (ahVar.c == -1)) {
                xr(viewMs);
            } else {
                xr(viewMs, 0);
            }
        } else {
            if (this.ah == (ahVar.c == -1)) {
                ms(viewMs);
            } else {
                ms(viewMs, 0);
            }
        }
        ms(viewMs, 0, 0);
        xrVar.f1417ms = this.xr.ka(viewMs);
        if (this.f1413ms == 1) {
            if (ka()) {
                iC = b() - yu();
                i4 = iC - this.xr.c(viewMs);
            } else {
                i4 = i();
                iC = this.xr.c(viewMs) + i4;
            }
            if (ahVar.c == -1) {
                int i5 = ahVar.xr;
                i2 = ahVar.xr - xrVar.f1417ms;
                i = iC;
                i3 = i5;
            } else {
                int i6 = ahVar.xr;
                i3 = ahVar.xr + xrVar.f1417ms;
                i = iC;
                i2 = i6;
            }
        } else {
            int iW = w();
            int iC2 = this.xr.c(viewMs) + iW;
            if (ahVar.c == -1) {
                i2 = iW;
                i = ahVar.xr;
                i3 = iC2;
                i4 = ahVar.xr - xrVar.f1417ms;
            } else {
                int i7 = ahVar.xr;
                i = ahVar.xr + xrVar.f1417ms;
                i2 = iW;
                i3 = iC2;
                i4 = i7;
            }
        }
        ms(viewMs, i4, i2, i, i3);
        if (chVar.xr() || chVar.ah()) {
            xrVar.ah = true;
        }
        xrVar.d = viewMs.hasFocusable();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    boolean ny() {
        return (nw() == 1073741824 || t() == 1073741824 || !pc()) ? false : true;
    }

    int ka(int i) {
        if (i == 1) {
            return (this.f1413ms != 1 && ka()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.f1413ms != 1 && ka()) ? -1 : 1;
        }
        if (i == 17) {
            return this.f1413ms == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.f1413ms == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.f1413ms == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1413ms == 0 ? 1 : Integer.MIN_VALUE;
    }

    private View f() {
        return x(this.ah ? y() - 1 : 0);
    }

    private View ul() {
        return x(this.ah ? 0 : y() - 1);
    }

    private View ms(boolean z, boolean z2) {
        int iY;
        int iY2;
        if (this.ah) {
            iY = y() - 1;
            iY2 = -1;
        } else {
            iY = 0;
            iY2 = y();
        }
        return ms(iY, iY2, z, z2);
    }

    private View xr(boolean z, boolean z2) {
        int iY;
        int iY2;
        if (this.ah) {
            iY = 0;
            iY2 = y();
        } else {
            iY = y() - 1;
            iY2 = -1;
        }
        return ms(iY, iY2, z, z2);
    }

    private View xr(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return this.ah ? d(aoVar, tVar) : ka(aoVar, tVar);
    }

    private View ah(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return this.ah ? ka(aoVar, tVar) : d(aoVar, tVar);
    }

    private View d(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return ms(aoVar, tVar, 0, y(), tVar.d());
    }

    private View ka(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return ms(aoVar, tVar, y() - 1, -1, tVar.d());
    }

    View ms(RecyclerView.ao aoVar, RecyclerView.t tVar, int i, int i2, int i3) {
        c();
        int iAh = this.xr.ah();
        int iD = this.xr.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewX = x(i);
            int iD2 = d(viewX);
            if (iD2 >= 0 && iD2 < i3) {
                if (((RecyclerView.ch) viewX.getLayoutParams()).xr()) {
                    if (view2 == null) {
                        view2 = viewX;
                    }
                } else {
                    if (this.xr.ms(viewX) < iD && this.xr.xr(viewX) >= iAh) {
                        return viewX;
                    }
                    if (view == null) {
                        view = viewX;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View c(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return this.ah ? x(aoVar, tVar) : ny(aoVar, tVar);
    }

    private View ab(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return this.ah ? ny(aoVar, tVar) : x(aoVar, tVar);
    }

    private View x(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return ms(0, y());
    }

    private View ny(RecyclerView.ao aoVar, RecyclerView.t tVar) {
        return ms(y() - 1, -1);
    }

    public int ch() {
        View viewMs = ms(0, y(), false, true);
        if (viewMs == null) {
            return -1;
        }
        return d(viewMs);
    }

    public int hi() {
        View viewMs = ms(y() - 1, -1, false, true);
        if (viewMs == null) {
            return -1;
        }
        return d(viewMs);
    }

    View ms(int i, int i2, boolean z, boolean z2) {
        c();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return (this.f1413ms == 0 ? this.ch : this.hi).ms(i, i2, i4, i3);
    }

    View ms(int i, int i2) {
        byte b;
        int i3;
        int i4;
        c();
        if (i2 > i) {
            b = 1;
        } else {
            b = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b == 0) {
            return x(i);
        }
        if (this.xr.ms(x(i)) < this.xr.ah()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.f1413ms == 0 ? this.ch : this.hi).ms(i, i2, i3, i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public View ms(View view, int i, RecyclerView.ao aoVar, RecyclerView.t tVar) {
        int iKa;
        View viewC;
        View viewUl;
        jw();
        if (y() == 0 || (iKa = ka(i)) == Integer.MIN_VALUE) {
            return null;
        }
        c();
        c();
        ms(iKa, (int) (this.xr.c() * 0.33333334f), false, tVar);
        this.qv.ab = Integer.MIN_VALUE;
        this.qv.f1414ms = false;
        ms(aoVar, this.qv, tVar, true);
        if (iKa == -1) {
            viewC = ab(aoVar, tVar);
        } else {
            viewC = c(aoVar, tVar);
        }
        if (iKa == -1) {
            viewUl = f();
        } else {
            viewUl = ul();
        }
        if (!viewUl.hasFocusable()) {
            return viewC;
        }
        if (viewC == null) {
            return null;
        }
        return viewUl;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public boolean sl() {
        return this.c == null && this.y == this.nw;
    }

    protected static class xr {
        public boolean ah;
        public boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f1417ms;
        public boolean xr;

        protected xr() {
        }

        void ms() {
            this.f1417ms = 0;
            this.xr = false;
            this.ah = false;
            this.d = false;
        }
    }

    static class ms {
        int ah;
        boolean d;
        boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        x f1416ms;
        int xr;

        ms() {
            ms();
        }

        void ms() {
            this.xr = -1;
            this.ah = Integer.MIN_VALUE;
            this.d = false;
            this.ka = false;
        }

        void xr() {
            this.ah = this.d ? this.f1416ms.d() : this.f1416ms.ah();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.xr + ", mCoordinate=" + this.ah + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.ka + AbstractJsonLexerKt.END_OBJ;
        }

        boolean ms(View view, RecyclerView.t tVar) {
            RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
            return !chVar.xr() && chVar.d() >= 0 && chVar.d() < tVar.d();
        }

        public void ms(View view, int i) {
            int iXr = this.f1416ms.xr();
            if (iXr >= 0) {
                xr(view, i);
                return;
            }
            this.xr = i;
            if (this.d) {
                int iD = (this.f1416ms.d() - iXr) - this.f1416ms.xr(view);
                this.ah = this.f1416ms.d() - iD;
                if (iD > 0) {
                    int iKa = this.ah - this.f1416ms.ka(view);
                    int iAh = this.f1416ms.ah();
                    int iMin = iKa - (iAh + Math.min(this.f1416ms.ms(view) - iAh, 0));
                    if (iMin < 0) {
                        this.ah += Math.min(iD, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMs = this.f1416ms.ms(view);
            int iAh2 = iMs - this.f1416ms.ah();
            this.ah = iMs;
            if (iAh2 > 0) {
                int iD2 = (this.f1416ms.d() - Math.min(0, (this.f1416ms.d() - iXr) - this.f1416ms.xr(view))) - (iMs + this.f1416ms.ka(view));
                if (iD2 < 0) {
                    this.ah -= Math.min(iAh2, -iD2);
                }
            }
        }

        public void xr(View view, int i) {
            if (this.d) {
                this.ah = this.f1416ms.xr(view) + this.f1416ms.xr();
            } else {
                this.ah = this.f1416ms.ms(view);
            }
            this.xr = i;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.bytedance.sdk.component.widget.recycler.ka.d.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        boolean ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1415ms;
        int xr;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f1415ms = parcel.readInt();
            this.xr = parcel.readInt();
            this.ah = parcel.readInt() == 1;
        }

        boolean ms() {
            return this.f1415ms >= 0;
        }

        void xr() {
            this.f1415ms = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1415ms);
            parcel.writeInt(this.xr);
            parcel.writeInt(this.ah ? 1 : 0);
        }
    }

    static class ah {
        int ab;
        int ah;
        int c;
        int ch;
        int d;
        int ka;
        boolean sl;
        int xr;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1414ms = true;
        int x = 0;
        boolean ny = false;
        List<RecyclerView.re> hi = null;

        ah() {
        }

        boolean ms(RecyclerView.t tVar) {
            int i = this.d;
            return i >= 0 && i < tVar.d();
        }

        View ms(RecyclerView.ao aoVar) {
            if (this.hi != null) {
                return xr();
            }
            View viewXr = aoVar.xr(this.d);
            this.d += this.ka;
            return viewXr;
        }

        private View xr() {
            int size = this.hi.size();
            for (int i = 0; i < size; i++) {
                View view = this.hi.get(i).f1391ms;
                RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
                if (!chVar.xr() && this.d == chVar.d()) {
                    ms(view);
                    return view;
                }
            }
            return null;
        }

        public void ms() {
            ms((View) null);
        }

        public void ms(View view) {
            View viewXr = xr(view);
            if (viewXr == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.ch) viewXr.getLayoutParams()).d();
            }
        }

        public View xr(View view) {
            int iD;
            int size = this.hi.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.hi.get(i2).f1391ms;
                RecyclerView.ch chVar = (RecyclerView.ch) view3.getLayoutParams();
                if (view3 != view && !chVar.xr() && (iD = (chVar.d() - this.d) * this.ka) >= 0 && iD < i) {
                    view2 = view3;
                    if (iD == 0) {
                        break;
                    }
                    i = iD;
                }
            }
            return view2;
        }
    }
}
