package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final RecyclerView.ny f1430ms;
    final Rect xr;

    public abstract int ab();

    public abstract int ah();

    public abstract int ah(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int ka();

    public abstract int ka(View view);

    public abstract int ms(View view);

    public abstract void ms(int i);

    public abstract int x();

    public abstract int xr(View view);

    private x(RecyclerView.ny nyVar) {
        this.ah = Integer.MIN_VALUE;
        this.xr = new Rect();
        this.f1430ms = nyVar;
    }

    public void ms() {
        this.ah = c();
    }

    public int xr() {
        if (Integer.MIN_VALUE == this.ah) {
            return 0;
        }
        return c() - this.ah;
    }

    public static x ms(RecyclerView.ny nyVar, int i) {
        if (i == 0) {
            return ms(nyVar);
        }
        if (i == 1) {
            return xr(nyVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static x ms(RecyclerView.ny nyVar) {
        return new x(nyVar) { // from class: com.bytedance.sdk.component.widget.recycler.x.1
            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int d() {
                return this.f1430ms.b() - this.f1430ms.yu();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ka() {
                return this.f1430ms.b();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public void ms(int i) {
                this.f1430ms.ny(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ah() {
                return this.f1430ms.i();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ka(View view) {
                RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
                return this.f1430ms.ka(view) + chVar.leftMargin + chVar.rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int c(View view) {
                RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
                return this.f1430ms.c(view) + chVar.topMargin + chVar.bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int xr(View view) {
                return this.f1430ms.ny(view) + ((RecyclerView.ch) view.getLayoutParams()).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ms(View view) {
                return this.f1430ms.ab(view) - ((RecyclerView.ch) view.getLayoutParams()).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ah(View view) {
                this.f1430ms.ms(view, true, this.xr);
                return this.xr.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int d(View view) {
                this.f1430ms.ms(view, true, this.xr);
                return this.xr.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int c() {
                return (this.f1430ms.b() - this.f1430ms.i()) - this.f1430ms.yu();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ab() {
                return this.f1430ms.yu();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int x() {
                return this.f1430ms.t();
            }
        };
    }

    public static x xr(RecyclerView.ny nyVar) {
        return new x(nyVar) { // from class: com.bytedance.sdk.component.widget.recycler.x.2
            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int d() {
                return this.f1430ms.re() - this.f1430ms.op();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ka() {
                return this.f1430ms.re();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public void ms(int i) {
                this.f1430ms.ch(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ah() {
                return this.f1430ms.w();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ka(View view) {
                RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
                return this.f1430ms.c(view) + chVar.topMargin + chVar.bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int c(View view) {
                RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
                return this.f1430ms.ka(view) + chVar.leftMargin + chVar.rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int xr(View view) {
                return this.f1430ms.ch(view) + ((RecyclerView.ch) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ms(View view) {
                return this.f1430ms.x(view) - ((RecyclerView.ch) view.getLayoutParams()).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ah(View view) {
                this.f1430ms.ms(view, true, this.xr);
                return this.xr.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int d(View view) {
                this.f1430ms.ms(view, true, this.xr);
                return this.xr.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int c() {
                return (this.f1430ms.re() - this.f1430ms.w()) - this.f1430ms.op();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int ab() {
                return this.f1430ms.op();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.x
            public int x() {
                return this.f1430ms.nw();
            }
        };
    }
}
