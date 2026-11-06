package com.byazt.tkz;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.e;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.ndr.RoundImageView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 101})
public class fs extends qg {
    public TextView a;
    public ImageView cd;
    public TextView cy;
    public TextView hd;
    public boolean hu;
    public RelativeLayout k;
    public TextView m;
    public RelativeLayout ou;
    public RelativeLayout py;
    public RoundImageView sz;
    public TextView um;
    public TextView wm;

    public fs(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.fs = (RelativeLayout) this.qg.findViewById(2114387662);
        this.rv = (FrameLayout) this.qg.findViewById(2114387754);
        this.tj = (TextView) this.qg.findViewById(2114387658);
        this.sz = (RoundImageView) this.qg.findViewById(2114387882);
        this.k = (RelativeLayout) this.qg.findViewById(2114387911);
        this.cy = (TextView) this.qg.findViewById(2114387921);
        this.hd = (TextView) this.qg.findViewById(2114387850);
        this.cd = (ImageView) this.qg.findViewById(2114387881);
        this.um = (TextView) this.qg.findViewById(2114387781);
        this.a = (TextView) this.qg.findViewById(2114387640);
        this.py = (RelativeLayout) this.qg.findViewById(2114387663);
        this.ou = (RelativeLayout) this.qg.findViewById(2114387835);
        this.cp = (RelativeLayout) this.qg.findViewById(2114387717);
        this.wm = (TextView) this.qg.findViewById(2114387752);
        this.m = (TextView) this.qg.findViewById(2114387716);
        com.byazt.okk.s.n(this.tj, this.s);
        cp();
        if (com.byazt.gks.n.n(this.s)) {
            String strRv = oj.rv(this.s);
            if (!TextUtils.isEmpty(strRv) && this.sz != null) {
                com.byazt.okk.s.n((View) this.k, 0);
                com.byazt.imu.s.n(strRv).n(this.sz);
            } else {
                com.byazt.okk.s.n((View) this.k, 8);
            }
            if (this.cy != null) {
                this.cy.setText(oj.s(this.s));
            }
            if (this.hd != null) {
                int iQ = oj.q(this.s);
                if (iQ < 0) {
                    this.hd.setVisibility(4);
                    com.byazt.okk.s.n((View) this.cd, 4);
                } else {
                    this.hd.setText(String.format("粉丝 %1$s", iQ > 10000 ? (iQ / 10000.0f) + "w" : String.valueOf(iQ)));
                }
            }
            if (this.um != null) {
                int iL = oj.l(this.s);
                if (iL < 0) {
                    this.um.setVisibility(4);
                    com.byazt.okk.s.n((View) this.cd, 4);
                } else {
                    this.um.setText(String.format("观看 %1$s", iL > 10000 ? (iL / 10000.0f) + "w" : String.valueOf(iL)));
                }
            }
            if (this.a != null) {
                this.a.setText(oj.w(this.s));
            }
        }
    }

    @Override // com.byazt.tkz.qg
    public void n(com.byazt.ys.qg qgVar, com.byazt.ys.qg qgVar2) {
        com.byazt.okk.s.n((View) this.wm, (View.OnTouchListener) qgVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        com.byazt.okk.s.n((View) this.wm, (View.OnClickListener) qgVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        com.byazt.okk.s.n((View) this.m, (View.OnClickListener) qgVar, "TTBaseVideoActivity#mLiveVideoBtn");
        com.byazt.okk.s.n((View) this.m, (View.OnClickListener) qgVar, "TTBaseVideoActivity#mLiveVideoBtn");
        n(qgVar2);
        n((View.OnTouchListener) qgVar2);
    }

    private void n(View.OnTouchListener onTouchListener) {
        com.byazt.okk.s.n(this.fs, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        com.byazt.okk.s.n(this.rv, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        com.byazt.okk.s.n(this.a, onTouchListener, "TTBaseVideoActivity#mLiveDesc");
        com.byazt.okk.s.n(this.hd, onTouchListener, "TTBaseVideoActivity#mLiveFans");
        com.byazt.okk.s.n(this.um, onTouchListener, "TTBaseVideoActivity#mLiveWatch");
        com.byazt.okk.s.n(this.cy, onTouchListener, "TTBaseVideoActivity#mLiveName");
        com.byazt.okk.s.n(this.sz, onTouchListener, "TTBaseVideoActivity#mLiveIcon");
        com.byazt.okk.s.n(this.cp, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void n(com.byazt.ys.qg qgVar) {
        n(this.rv, qgVar, "click_live_feed");
        n(this.a, qgVar, "click_live_author_description");
        n(this.hd, qgVar, "click_live_author_follower_count");
        n(this.um, qgVar, "click_live_author_following_count");
        n(this.cy, qgVar, "click_live_author_nickname");
        n(this.sz, qgVar, "click_live_avata");
        n(this.fs, qgVar, "click_live_button");
        n(this.cp, qgVar, "click_live_btn_layout");
    }

    private void n(View view, final com.byazt.ys.qg qgVar, final String str) {
        if (view == null || qgVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setOnClickListener(new com.byazt.ys.qg(this.qg, this.s, this.w ? "rewarded_video" : "fullscreen_interstitial_ad", this.w ? 7 : 5) { // from class: com.byazt.tkz.fs.1
            @Override // com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view2, com.byazt.gct.tj tjVar) {
                HashMap map = new HashMap();
                map.put("click_live_element", str);
                ((com.byazt.fq.n) qgVar.n(com.byazt.fq.n.class)).n(map);
                qgVar.n(view2, tjVar);
            }
        });
    }

    @Override // com.byazt.tkz.qg
    public void s(int i) {
        com.byazt.okk.s.n((View) this.py, i);
        com.byazt.okk.s.n((View) this.ou, i);
    }

    @Override // com.byazt.tkz.qg
    public void q(int i) {
        if (this.hu) {
            return;
        }
        com.byazt.okk.s.n((View) this.cp, i);
    }

    public void n(int i, int i2) {
        TextView textView;
        if (i != 0) {
            this.hu = true;
            com.byazt.okk.s.n((View) this.cp, 8);
            return;
        }
        com.byazt.okk.s.n((View) this.cp, 0);
        if (i2 >= 0 && com.byazt.wq.qg.n().qg(this.s) && e.n(this.s) && e.l(this.s) == 3 && (textView = (TextView) this.qg.findViewById(2114387716)) != null) {
            textView.setText(String.format("%1$s后自动进入直播间", i2 + com.anythink.core.common.s.a));
        }
    }
}
