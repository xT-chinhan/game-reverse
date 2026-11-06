package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class zb {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final xr f1433ms;
    ms xr = new ms();

    interface xr {
        int ms();

        int ms(View view);

        View ms(int i);

        int xr();

        int xr(View view);
    }

    zb(xr xrVar) {
        this.f1433ms = xrVar;
    }

    View ms(int i, int i2, int i3, int i4) {
        int iMs = this.f1433ms.ms();
        int iXr = this.f1433ms.xr();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewMs = this.f1433ms.ms(i);
            this.xr.ms(iMs, iXr, this.f1433ms.ms(viewMs), this.f1433ms.xr(viewMs));
            if (i3 != 0) {
                this.xr.ms();
                this.xr.ms(i3);
                if (this.xr.xr()) {
                    return viewMs;
                }
            }
            if (i4 != 0) {
                this.xr.ms();
                this.xr.ms(i4);
                if (this.xr.xr()) {
                    view = viewMs;
                }
            }
            i += i5;
        }
        return view;
    }

    static class ms {
        int ah;
        int d;
        int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1434ms = 0;
        int xr;

        int ms(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        ms() {
        }

        void ms(int i, int i2, int i3, int i4) {
            this.xr = i;
            this.ah = i2;
            this.d = i3;
            this.ka = i4;
        }

        void ms(int i) {
            this.f1434ms = i | this.f1434ms;
        }

        void ms() {
            this.f1434ms = 0;
        }

        boolean xr() {
            int i = this.f1434ms;
            if ((i & 7) != 0 && (i & (ms(this.d, this.xr) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1434ms;
            if ((i2 & 112) != 0 && (i2 & (ms(this.d, this.ah) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1434ms;
            if ((i3 & 1792) != 0 && (i3 & (ms(this.ka, this.xr) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1434ms;
            return (i4 & 28672) == 0 || (i4 & (ms(this.ka, this.ah) << 12)) != 0;
        }
    }
}
