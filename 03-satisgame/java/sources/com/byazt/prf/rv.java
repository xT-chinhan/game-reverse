package com.byazt.prf;

import android.graphics.Rect;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public abstract class rv {
    public final RecyclerView.rv n;
    public final Rect qg;
    public int s;

    public abstract int fs();

    public abstract int l();

    public abstract int l(View view);

    public abstract int n(View view);

    public abstract void n(int i);

    public abstract int q();

    public abstract int q(View view);

    public abstract int qg(View view);

    public abstract int rv();

    public abstract int s();

    public abstract int s(View view);

    public abstract int w();

    public abstract int w(View view);

    public abstract int x();

    private rv(RecyclerView.rv rvVar) {
        this.s = Integer.MIN_VALUE;
        this.qg = new Rect();
        this.n = rvVar;
    }

    public void n() {
        this.s = w();
    }

    public int qg() {
        if (Integer.MIN_VALUE == this.s) {
            return 0;
        }
        return w() - this.s;
    }

    public static rv n(RecyclerView.rv rvVar, int i) {
        if (i == 0) {
            return n(rvVar);
        }
        if (i == 1) {
            return qg(rvVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static rv n(RecyclerView.rv rvVar) {
        return new rv(rvVar) { // from class: com.byazt.prf.rv.1
            @Override // com.byazt.prf.rv
            public int q() {
                return this.n.m() - this.n.ur();
            }

            @Override // com.byazt.prf.rv
            public int l() {
                return this.n.m();
            }

            @Override // com.byazt.prf.rv
            public void n(int i) {
                this.n.tj(i);
            }

            @Override // com.byazt.prf.rv
            public int s() {
                return this.n.h();
            }

            @Override // com.byazt.prf.rv
            public int l(View view) {
                RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
                return this.n.w(view) + tjVar.leftMargin + tjVar.rightMargin;
            }

            @Override // com.byazt.prf.rv
            public int w(View view) {
                RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
                return this.n.x(view) + tjVar.topMargin + tjVar.bottomMargin;
            }

            @Override // com.byazt.prf.rv
            public int qg(View view) {
                return this.n.tj(view) + ((RecyclerView.tj) view.getLayoutParams()).rightMargin;
            }

            @Override // com.byazt.prf.rv
            public int n(View view) {
                return this.n.fs(view) - ((RecyclerView.tj) view.getLayoutParams()).leftMargin;
            }

            @Override // com.byazt.prf.rv
            public int s(View view) {
                this.n.n(view, true, this.qg);
                return this.qg.right;
            }

            @Override // com.byazt.prf.rv
            public int q(View view) {
                this.n.n(view, true, this.qg);
                return this.qg.left;
            }

            @Override // com.byazt.prf.rv
            public int w() {
                return (this.n.m() - this.n.h()) - this.n.ur();
            }

            @Override // com.byazt.prf.rv
            public int x() {
                return this.n.ur();
            }

            @Override // com.byazt.prf.rv
            public int fs() {
                return this.n.ou();
            }

            @Override // com.byazt.prf.rv
            public int rv() {
                return this.n.wm();
            }
        };
    }

    public static rv qg(RecyclerView.rv rvVar) {
        return new rv(rvVar) { // from class: com.byazt.prf.rv.2
            @Override // com.byazt.prf.rv
            public int q() {
                return this.n.hu() - this.n.bb();
            }

            @Override // com.byazt.prf.rv
            public int l() {
                return this.n.hu();
            }

            @Override // com.byazt.prf.rv
            public void n(int i) {
                this.n.cp(i);
            }

            @Override // com.byazt.prf.rv
            public int s() {
                return this.n.t();
            }

            @Override // com.byazt.prf.rv
            public int l(View view) {
                RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
                return this.n.x(view) + tjVar.topMargin + tjVar.bottomMargin;
            }

            @Override // com.byazt.prf.rv
            public int w(View view) {
                RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
                return this.n.w(view) + tjVar.leftMargin + tjVar.rightMargin;
            }

            @Override // com.byazt.prf.rv
            public int qg(View view) {
                return this.n.cp(view) + ((RecyclerView.tj) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.byazt.prf.rv
            public int n(View view) {
                return this.n.rv(view) - ((RecyclerView.tj) view.getLayoutParams()).topMargin;
            }

            @Override // com.byazt.prf.rv
            public int s(View view) {
                this.n.n(view, true, this.qg);
                return this.qg.bottom;
            }

            @Override // com.byazt.prf.rv
            public int q(View view) {
                this.n.n(view, true, this.qg);
                return this.qg.top;
            }

            @Override // com.byazt.prf.rv
            public int w() {
                return (this.n.hu() - this.n.t()) - this.n.bb();
            }

            @Override // com.byazt.prf.rv
            public int x() {
                return this.n.bb();
            }

            @Override // com.byazt.prf.rv
            public int fs() {
                return this.n.wm();
            }

            @Override // com.byazt.prf.rv
            public int rv() {
                return this.n.ou();
            }
        };
    }
}
