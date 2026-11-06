package com.byazt.be;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.byazt.gct.t;
import com.byazt.ou.fs;
import com.byazt.wt.UpieImageView;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 668, 2227})
public class CreativeContainer extends FrameLayout implements fs.n {
    public boolean l;
    public final com.byazt.tx.s n;
    public View q;
    public fs qg;
    public UpieImageView s;
    public View.OnLayoutChangeListener w;

    public CreativeContainer(Context context, pk pkVar, com.byazt.tx.s sVar) {
        super(context);
        this.n = sVar;
        if (pk.s(pkVar)) {
            return;
        }
        UpieImageView upieImageView = new UpieImageView(context, com.byazt.aci.n.tj(pkVar), com.byazt.du.n.n(pkVar), com.byazt.aci.n.q(pkVar) ? com.byazt.aci.n.d(pkVar) : null);
        this.s = upieImageView;
        addView(upieImageView, new FrameLayout.LayoutParams(-1, -1));
        this.s.setVisibility(4);
        qg();
    }

    public static boolean n(pk pkVar) {
        return pk.n(pkVar) && !pk.qg(pkVar);
    }

    public static boolean qg(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        if (pk.s(pkVar)) {
            if (n(pkVar) || com.byazt.gks.n.n(pkVar) || com.byazt.ql.s.n(pkVar)) {
                return false;
            }
            return t.l(pkVar);
        }
        return s(pkVar);
    }

    public void setSizeView(View view) {
        if (view == null) {
            return;
        }
        View view2 = this.q;
        if (view2 != view) {
            com.byazt.okk.s.fs(view2);
            this.l = false;
            View.OnLayoutChangeListener onLayoutChangeListener = this.w;
            if (onLayoutChangeListener != null) {
                removeOnLayoutChangeListener(onLayoutChangeListener);
                this.w = null;
            }
            fs fsVar = this.qg;
            if (fsVar != null) {
                fsVar.cp();
            }
            this.q = view;
        }
        com.byazt.okk.s.fs(this.q);
        qg();
    }

    private void qg() {
        if (this.s == null && this.q == null) {
            return;
        }
        com.byazt.tx.s sVar = this.n;
        if (sVar == null) {
            q();
            return;
        }
        if (this.qg == null) {
            fs fsVarN = sVar.n();
            this.qg = fsVarN;
            if (fsVarN == null) {
                q();
                return;
            }
            fsVarN.n((fs.n) this);
        }
        s();
    }

    private void s() {
        if (this.l || this.qg == null) {
            return;
        }
        View view = this.s;
        if (view == null) {
            view = this;
        }
        if (getWidth() > 0 && getHeight() > 0) {
            this.l = true;
            this.qg.qg(this, view);
        } else {
            if (this.w != null) {
                return;
            }
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.byazt.be.CreativeContainer.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int i9 = i3 - i;
                    int i10 = i4 - i2;
                    if (CreativeContainer.this.l || i9 <= 0 || i10 <= 0) {
                        return;
                    }
                    CreativeContainer.this.l = true;
                    CreativeContainer.this.removeOnLayoutChangeListener(this);
                    CreativeContainer.this.w = null;
                    CreativeContainer.this.qg.qg(CreativeContainer.this, CreativeContainer.this.s != null ? CreativeContainer.this.s : CreativeContainer.this);
                }
            };
            this.w = onLayoutChangeListener;
            addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.byazt.ou.fs.n
    public void n(ViewGroup viewGroup) {
        View view;
        UpieImageView upieImageView = this.s;
        if (upieImageView != null) {
            upieImageView.setVisibility(8);
        } else {
            if (viewGroup == null || (view = this.q) == null) {
                return;
            }
            com.byazt.okk.s.fs(view);
            viewGroup.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.byazt.ou.fs.n
    public void n() {
        q();
    }

    private void q() {
        fs fsVar = this.qg;
        if (fsVar != null) {
            fsVar.cp();
        }
        UpieImageView upieImageView = this.s;
        if (upieImageView != null) {
            upieImageView.setVisibility(0);
            return;
        }
        View view = this.q;
        if (view == null || view.getParent() == this) {
            return;
        }
        com.byazt.okk.s.fs(this.q);
        addView(this.q, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public static boolean s(pk pkVar) {
        return (n(pkVar) || pkVar == null || pk.s(pkVar) || (!t.l(pkVar) && !com.byazt.aci.n.fs(pkVar))) ? false : true;
    }
}
