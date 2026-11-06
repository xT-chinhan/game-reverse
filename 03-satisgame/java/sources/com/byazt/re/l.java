package com.byazt.re;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.ndr.TopProxyLayout;
import com.byazt.tk.k;
import com.byazt.xdp.RewardBrowserMixTopLayoutImpl;
import com.byazt.xdp.TopLayoutImpl;
import com.byazt.zc.UgenBanner;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 796, 18})
public class l {
    public com.byazt.xdp.q fs;
    public UgenBanner l;
    public final TTBaseVideoActivity n;
    public TextView q;
    public pk qg;
    public com.byazt.xdp.l rv;
    public com.byazt.xdp.n s;
    public com.byazt.ys.qg w;
    public com.byazt.xdp.w x;

    public l(TTBaseVideoActivity tTBaseVideoActivity) {
        this.n = tTBaseVideoActivity;
    }

    public void n(pk pkVar, qg qgVar, boolean z, com.byazt.ys.qg qgVar2) {
        this.qg = pkVar;
        this.w = qgVar2;
        fs();
        this.x = new com.byazt.xdp.w(this.n, this.qg, qgVar, this, z);
        this.rv = new com.byazt.xdp.l(this.n, this.qg, qgVar, this, z);
        this.fs = new com.byazt.xdp.q(this.n, this.qg, qgVar, this, z);
        n(1);
    }

    private void fs() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.n.findViewById(2114387721);
        if (topProxyLayout != null) {
            n(topProxyLayout);
        }
        this.q = (TextView) this.n.findViewById(2114387801);
        this.l = (UgenBanner) this.n.findViewById(2114387901);
    }

    public void n(TopProxyLayout topProxyLayout) {
        View viewN;
        if (cd.oa(this.qg)) {
            viewN = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).n(this.qg);
        } else {
            viewN = new TopLayoutImpl(topProxyLayout.getContext()).n(this.qg);
        }
        if (viewN != null) {
            this.s = (com.byazt.xdp.n) viewN;
        } else {
            k.qg("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            n(topProxyLayout, viewN, (ViewGroup) parent);
        }
    }

    private void n(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void n(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setVisible(z);
        }
    }

    public void qg(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setShowDislike(z);
        }
    }

    public void s(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setDislikeLeft(z);
        }
    }

    public void q(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setSoundMute(z);
        }
    }

    public void l(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setShowSound(z);
        }
    }

    public void w(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setShowBack(z);
        }
    }

    public void n(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.n(z, str, str2, z2, z3);
        }
    }

    public void n(String str, String str2, boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.n(str, str2, z);
        }
    }

    public void n() {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.n();
        }
    }

    public void qg() {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.qg();
        }
    }

    public void s() {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.s();
        }
    }

    public View q() {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            return nVar.getCloseButton();
        }
        return null;
    }

    public boolean l() {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            return nVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void n(int i) {
        if (i == 2) {
            n(this.fs);
        } else if (i == 4) {
            n(this.rv);
        } else {
            n(this.x);
        }
    }

    public void n(com.byazt.xdp.qg qgVar) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setListener(qgVar);
        }
    }

    public void x(boolean z) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setShowAgain(z);
        }
    }

    public void n(String str) {
        com.byazt.xdp.n nVar = this.s;
        if (nVar != null) {
            nVar.setPlayAgainEntranceText(str);
        }
    }

    public void qg(String str) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(str);
            this.q.setVisibility(0);
            this.q.postDelayed(new Runnable() { // from class: com.byazt.re.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.this.q.setVisibility(8);
                }
            }, 3000L);
        }
    }

    public void w() {
        UgenBanner ugenBanner = this.l;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.n(this.qg, this.w);
    }

    public void x() {
        UgenBanner ugenBanner = this.l;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.n();
    }

    public void n(pk pkVar) {
        com.byazt.xdp.w wVar = this.x;
        if (wVar != null) {
            wVar.n(pkVar);
        }
        com.byazt.xdp.q qVar = this.fs;
        if (qVar != null) {
            qVar.n(pkVar);
        }
        com.byazt.xdp.l lVar = this.rv;
        if (lVar != null) {
            lVar.n(pkVar);
        }
    }
}
