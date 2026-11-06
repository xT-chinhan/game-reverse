package com.byazt.xk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.ndr.TTRatingBar;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.okk.s;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 92, 19})
public class n {
    public boolean cp;
    public final TTBaseVideoActivity fs;
    public TextView l;
    public LinearLayout n;
    public TTRatingBar q;
    public TTRoundRectImageView qg;
    public pk rv;
    public TextView s;
    public int tj;
    public TextView w;
    public TextView x;

    public n(TTBaseVideoActivity tTBaseVideoActivity) {
        this.fs = tTBaseVideoActivity;
    }

    public void n(pk pkVar) {
        if (this.cp) {
            return;
        }
        this.cp = true;
        this.rv = pkVar;
        this.tj = pkVar.ys();
        l();
        qg();
        n(q());
        w();
    }

    private void l() {
        this.n = (LinearLayout) this.fs.findViewById(2114387739);
        this.qg = (TTRoundRectImageView) this.fs.findViewById(2114387773);
        this.s = (TextView) this.fs.findViewById(2114387645);
        this.q = (TTRatingBar) this.fs.findViewById(2114387779);
        this.l = (TextView) this.fs.findViewById(2114387782);
        this.w = (TextView) this.fs.findViewById(2114387864);
        this.x = (TextView) this.fs.findViewById(2114387709);
        TTRatingBar tTRatingBar = this.q;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.q.setStarFillNum(4);
            this.q.setStarImageWidth(s.s(this.fs, 16.0f));
            this.q.setStarImageHeight(s.s(this.fs, 16.0f));
            this.q.setStarImagePadding(s.s(this.fs, 4.0f));
            this.q.n();
        }
    }

    public void n(com.byazt.ys.qg qgVar) {
        s.n(this.n, new View.OnClickListener() { // from class: com.byazt.xk.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.w;
        if (textView != null) {
            textView.setOnClickListener(qgVar);
            this.w.setOnTouchListener(qgVar);
        }
    }

    public void n() {
        s.n((View) this.n, 0);
        pk pkVar = this.rv;
        if (pkVar == null || pkVar.sl() == 100.0f) {
            return;
        }
        s.n((View) this.q, 8);
        s.n((View) this.l, 8);
    }

    private void w() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.tj == 1 && (tTRoundRectImageView = this.qg) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, s.s(this.fs, 50.0f), 0, 0);
            this.qg.setLayoutParams(layoutParams);
        }
    }

    public void qg() {
        if (this.qg != null) {
            v vVarXu = this.rv.xu();
            if (vVarXu != null && !TextUtils.isEmpty(vVarXu.n())) {
                com.byazt.imu.s.n(vVarXu).n(this.qg);
            } else {
                sz.n((Context) this.fs, "tt_ad_logo_small", (ImageView) this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (this.s != null) {
            if (this.rv.k() != null && !TextUtils.isEmpty(this.rv.k().s())) {
                this.s.setText(this.rv.k().s());
            } else {
                this.s.setText(this.rv.E_());
            }
        }
        if (this.l != null) {
            int iW = this.rv.k() != null ? this.rv.k().w() : 6870;
            this.l.setText(String.format("(%1$s个评论)", iW > 10000 ? (iW / 10000) + "万" : String.valueOf(iW)));
        }
        TextView textView = this.x;
        if (textView != null) {
            s.n(textView, this.rv);
        }
    }

    public void n(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.w) == null) {
            return;
        }
        textView.setText(str);
    }

    public void s() {
        s.n((View) this.n, 8);
    }

    public String q() {
        pk pkVar = this.rv;
        if (pkVar == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(pkVar.jb())) {
            return this.rv.rv() != 4 ? "查看详情" : "立即下载";
        }
        return this.rv.jb();
    }
}
