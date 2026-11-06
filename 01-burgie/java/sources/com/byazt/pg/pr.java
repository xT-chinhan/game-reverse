package com.byazt.pg;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.pi.TTRatingBar;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 90, 37})
public class pr {
    public of aj;
    public TextView c;
    public TextView fw;
    public TextView hn;
    public TTRoundRectImageView hw;
    public LinearLayout pr;
    public TextView uc;
    public int vk;
    public boolean w;
    public TTRatingBar x;
    public final TTBaseVideoActivity zo;

    public pr(TTBaseVideoActivity tTBaseVideoActivity) {
        this.zo = tTBaseVideoActivity;
    }

    public void pr(of ofVar) {
        if (this.w) {
            return;
        }
        this.w = true;
        this.aj = ofVar;
        this.vk = ofVar.rf();
        c();
        hw();
        pr(x());
        uc();
    }

    private void c() {
        this.pr = (LinearLayout) this.zo.findViewById(2114387739);
        this.hw = (TTRoundRectImageView) this.zo.findViewById(2114387773);
        this.hn = (TextView) this.zo.findViewById(2114387645);
        this.x = (TTRatingBar) this.zo.findViewById(2114387779);
        this.c = (TextView) this.zo.findViewById(2114387782);
        this.uc = (TextView) this.zo.findViewById(2114387864);
        this.fw = (TextView) this.zo.findViewById(2114387709);
        TTRatingBar tTRatingBar = this.x;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.x.setStarFillNum(4);
            this.x.setStarImageWidth(er.hn(this.zo, 16.0f));
            this.x.setStarImageHeight(er.hn(this.zo, 16.0f));
            this.x.setStarImagePadding(er.hn(this.zo, 4.0f));
            this.x.pr();
        }
    }

    public void pr(com.byazt.az.hw hwVar) {
        er.pr(this.pr, new View.OnClickListener() { // from class: com.byazt.pg.pr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.uc;
        if (textView != null) {
            textView.setOnClickListener(hwVar);
            this.uc.setOnTouchListener(hwVar);
        }
    }

    public void pr() {
        er.pr((View) this.pr, 0);
        of ofVar = this.aj;
        if (ofVar != null && ofVar.oq() != 100.0f) {
            er.pr((View) this.x, 8);
            er.pr((View) this.c, 8);
        }
    }

    private void uc() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.vk == 1 && (tTRoundRectImageView = this.hw) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, er.hn(this.zo, 50.0f), 0, 0);
            this.hw.setLayoutParams(layoutParams);
        }
    }

    public void hw() {
        if (this.hw != null) {
            y yVarMo = this.aj.mo();
            if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
                com.byazt.ub.hw.pr(yVarMo).pr(this.hw);
            } else {
                g.pr((Context) this.zo, "tt_ad_logo_small", (ImageView) this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (this.hn != null) {
            if (this.aj.ho() != null && !TextUtils.isEmpty(this.aj.ho().hn())) {
                this.hn.setText(this.aj.ho().hn());
            } else {
                this.hn.setText(this.aj.A_());
            }
        }
        if (this.c != null) {
            int iUc = 6870;
            if (this.aj.ho() != null) {
                iUc = this.aj.ho().uc();
            }
            this.c.setText(String.format("(%1$s个评论)", iUc > 10000 ? (iUc / 10000) + "万" : String.valueOf(iUc)));
        }
        TextView textView = this.fw;
        if (textView != null) {
            er.pr(textView, this.aj);
        }
    }

    public void pr(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.uc) != null) {
            textView.setText(str);
        }
    }

    public void hn() {
        er.pr((View) this.pr, 8);
    }

    public String x() {
        of ofVar = this.aj;
        if (ofVar == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(ofVar.se())) {
            return this.aj.aj() != 4 ? "查看详情" : "立即下载";
        }
        return this.aj.se();
    }
}
