package com.byazt.tkz;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.ndr.RatioImageView;
import com.byazt.ndr.TTRatingBar;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.wt.UpieImageView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 13})
public class w extends qg {
    public TextView a;
    public TextView cd;
    public TextView cy;
    public TextView hd;
    public TTRoundRectImageView k;
    public UpieImageView py;
    public RatioImageView sz;
    public TTRatingBar um;

    public w(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.rv = (FrameLayout) this.x.findViewById(2114387642);
        this.sz = (RatioImageView) this.x.findViewById(2114387766);
        this.k = (TTRoundRectImageView) this.x.findViewById(2114387722);
        this.cy = (TextView) this.x.findViewById(2114387702);
        this.hd = (TextView) this.x.findViewById(2114387934);
        this.cd = (TextView) this.x.findViewById(2114387789);
        this.a = (TextView) this.x.findViewById(2114387962);
        this.um = (TTRatingBar) this.x.findViewById(2114387787);
        if (this.sz != null && com.byazt.aci.n.q(this.s)) {
            UpieImageView upieImageView = new UpieImageView(this.sz.getContext(), com.byazt.aci.n.tj(this.s), com.byazt.du.n.n(this.s), com.byazt.aci.n.d(this.s));
            this.py = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        qg();
    }

    @Override // com.byazt.tkz.qg
    public void n(com.byazt.ys.qg qgVar, com.byazt.ys.qg qgVar2) {
        n(this.a, qgVar, qgVar);
        n(this.sz, qgVar2, qgVar2);
        n(this.k, qgVar2, qgVar2);
        n(this.cy, qgVar2, qgVar2);
        n(this.hd, qgVar2, qgVar2);
        n(this.cd, qgVar2, qgVar2);
        n(this.um, qgVar2, qgVar2);
        n(this.py, qgVar2, qgVar2);
    }

    public void n(View view, com.byazt.ys.qg qgVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.qg == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(qgVar);
    }

    private void qg() {
        v vVarXu;
        com.byazt.okk.s.n((TextView) this.qg.findViewById(2114387658), this.s);
        if (this.sz != null) {
            int iGe = this.s.ge();
            if (iGe == 3) {
                this.sz.setRatio(1.91f);
            } else if (iGe == 33) {
                this.sz.setRatio(1.0f);
            } else {
                this.sz.setRatio(0.56f);
            }
            n(this.sz, this.py);
        }
        if (this.k != null && (vVarXu = this.s.xu()) != null) {
            com.byazt.imu.s.n(vVarXu).n(this.k);
        }
        TextView textView = this.cy;
        if (textView != null) {
            textView.setText(sz());
        }
        TextView textView2 = this.hd;
        if (textView2 != null) {
            textView2.setText(k());
        }
        s();
        q();
    }

    private void s() {
        TTRatingBar tTRatingBar = this.um;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.um.setStarFillNum(4);
        this.um.setStarImageWidth(com.byazt.okk.s.s(this.qg, 16.0f));
        this.um.setStarImageHeight(com.byazt.okk.s.s(this.qg, 16.0f));
        this.um.setStarImagePadding(com.byazt.okk.s.s(this.qg, 4.0f));
        this.um.n();
    }

    private void q() {
        if (this.cd == null) {
            return;
        }
        int iW = this.s.k() != null ? this.s.k().w() : 6870;
        this.cd.setText(String.format("(%1$s个评论)", iW > 10000 ? (iW / 10000) + "万" : String.valueOf(iW)));
    }
}
