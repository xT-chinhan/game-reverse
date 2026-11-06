package com.byazt.xt;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.f;
import com.byazt.hg.of;
import com.byazt.hg.v;
import com.byazt.pi.RoundImageView;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends hw {
    public TextView a;
    public RelativeLayout cz;
    public TextView fo;
    public RoundImageView g;
    public RelativeLayout ho;
    public ImageView lb;
    public TextView nt;
    public RelativeLayout ny;
    public TextView qa;
    public TextView rc;
    public TextView yb;
    public boolean z;

    public zo(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.zo = (RelativeLayout) this.hw.findViewById(2114387662);
        this.aj = (FrameLayout) this.hw.findViewById(2114387754);
        this.vk = (TextView) this.hw.findViewById(2114387658);
        this.g = (RoundImageView) this.hw.findViewById(2114387882);
        this.ho = (RelativeLayout) this.hw.findViewById(2114387911);
        this.nt = (TextView) this.hw.findViewById(2114387921);
        this.yb = (TextView) this.hw.findViewById(2114387850);
        this.lb = (ImageView) this.hw.findViewById(2114387881);
        this.qa = (TextView) this.hw.findViewById(2114387781);
        this.a = (TextView) this.hw.findViewById(2114387640);
        this.cz = (RelativeLayout) this.hw.findViewById(2114387663);
        this.ny = (RelativeLayout) this.hw.findViewById(2114387835);
        this.w = (RelativeLayout) this.hw.findViewById(2114387717);
        this.fo = (TextView) this.hw.findViewById(2114387752);
        this.rc = (TextView) this.hw.findViewById(2114387716);
        er.pr(this.vk, this.hn);
        w();
        if (com.byazt.lpk.pr.pr(this.hn)) {
            String strAj = v.aj(this.hn);
            if (!TextUtils.isEmpty(strAj) && this.g != null) {
                er.pr((View) this.ho, 0);
                com.byazt.ub.hw.pr(strAj).pr(this.g);
            } else {
                er.pr((View) this.ho, 8);
            }
            if (this.nt != null) {
                this.nt.setText(v.hn(this.hn));
            }
            if (this.yb != null) {
                int iX = v.x(this.hn);
                if (iX < 0) {
                    this.yb.setVisibility(4);
                    er.pr((View) this.lb, 4);
                } else {
                    this.yb.setText(String.format("粉丝 %1$s", iX > 10000 ? (iX / 10000.0f) + "w" : String.valueOf(iX)));
                }
            }
            if (this.qa != null) {
                int iC = v.c(this.hn);
                if (iC < 0) {
                    this.qa.setVisibility(4);
                    er.pr((View) this.lb, 4);
                } else {
                    this.qa.setText(String.format("观看 %1$s", iC > 10000 ? (iC / 10000.0f) + "w" : String.valueOf(iC)));
                }
            }
            if (this.a != null) {
                this.a.setText(v.uc(this.hn));
            }
        }
    }

    @Override // com.byazt.xt.hw
    public void pr(com.byazt.az.hw hwVar, com.byazt.az.hw hwVar2) {
        er.pr((View) this.fo, (View.OnTouchListener) hwVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        er.pr((View) this.fo, (View.OnClickListener) hwVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        er.pr((View) this.rc, (View.OnClickListener) hwVar, "TTBaseVideoActivity#mLiveVideoBtn");
        er.pr((View) this.rc, (View.OnClickListener) hwVar, "TTBaseVideoActivity#mLiveVideoBtn");
        pr(hwVar2);
        pr((View.OnTouchListener) hwVar2);
    }

    private void pr(View.OnTouchListener onTouchListener) {
        er.pr(this.zo, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        er.pr(this.aj, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        er.pr(this.a, onTouchListener, "TTBaseVideoActivity#mLiveDesc");
        er.pr(this.yb, onTouchListener, "TTBaseVideoActivity#mLiveFans");
        er.pr(this.qa, onTouchListener, "TTBaseVideoActivity#mLiveWatch");
        er.pr(this.nt, onTouchListener, "TTBaseVideoActivity#mLiveName");
        er.pr(this.g, onTouchListener, "TTBaseVideoActivity#mLiveIcon");
        er.pr(this.w, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void pr(com.byazt.az.hw hwVar) {
        pr(this.aj, hwVar, "click_live_feed");
        pr(this.a, hwVar, "click_live_author_description");
        pr(this.yb, hwVar, "click_live_author_follower_count");
        pr(this.qa, hwVar, "click_live_author_following_count");
        pr(this.nt, hwVar, "click_live_author_nickname");
        pr(this.g, hwVar, "click_live_avata");
        pr(this.zo, hwVar, "click_live_button");
        pr(this.w, hwVar, "click_live_btn_layout");
    }

    private void pr(View view, final com.byazt.az.hw hwVar, final String str) {
        if (view == null || hwVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setOnClickListener(new com.byazt.az.hw(this.hw, this.hn, this.uc ? "rewarded_video" : "fullscreen_interstitial_ad", this.uc ? 7 : 5) { // from class: com.byazt.xt.zo.1
            @Override // com.byazt.az.hw, com.byazt.az.x
            public void pr(View view2, com.byazt.hg.vk vkVar) {
                HashMap map = new HashMap();
                map.put("click_live_element", str);
                ((com.byazt.yx.pr) hwVar.pr(com.byazt.yx.pr.class)).pr(map);
                hwVar.pr(view2, vkVar);
            }
        });
    }

    @Override // com.byazt.xt.hw
    public void hn(int i) {
        er.pr((View) this.cz, i);
        er.pr((View) this.ny, i);
    }

    @Override // com.byazt.xt.hw
    public void x(int i) {
        if (!this.z) {
            er.pr((View) this.w, i);
        }
    }

    public void pr(int i, int i2) {
        TextView textView;
        if (i != 0) {
            this.z = true;
            er.pr((View) this.w, 8);
            return;
        }
        er.pr((View) this.w, 0);
        if (i2 < 0 || !com.byazt.eg.hw.pr().hw(this.hn) || !f.pr(this.hn) || f.c(this.hn) != 3 || (textView = (TextView) this.hw.findViewById(2114387716)) == null) {
            return;
        }
        textView.setText(String.format("%1$s后自动进入直播间", i2 + an.aB));
    }
}
