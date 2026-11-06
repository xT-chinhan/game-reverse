package com.byazt.tkz;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.mr.d;
import com.byazt.ndr.TTRatingBar;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 8})
public class s extends qg {
    public TTRatingBar a;
    public TextView cd;
    public TTRoundRectImageView cy;
    public TextView hd;
    public final AtomicBoolean k;
    public FrameLayout ou;
    public FrameLayout py;
    public int sz;
    public TextView um;

    public s(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
        this.sz = 0;
        this.k = new AtomicBoolean(false);
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.fs = (RelativeLayout) this.qg.findViewById(2114387649);
        this.cy = (TTRoundRectImageView) this.qg.findViewById(2114387793);
        this.hd = (TextView) this.qg.findViewById(2114387875);
        this.cd = (TextView) this.qg.findViewById(2114387630);
        this.um = (TextView) this.qg.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) this.qg.findViewById(2114387609);
        this.a = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.a.setStarFillNum(4);
            this.a.setStarImageWidth(com.byazt.okk.s.s(this.qg, 15.0f));
            this.a.setStarImageHeight(com.byazt.okk.s.s(this.qg, 14.0f));
            this.a.setStarImagePadding(com.byazt.okk.s.s(this.qg, 4.0f));
            this.a.n();
        }
        this.tj = (TextView) this.qg.findViewById(2114387658);
        this.rv = (FrameLayout) this.qg.findViewById(2114387642);
        this.py = (FrameLayout) this.qg.findViewById(2114387964);
        this.ou = (FrameLayout) this.qg.findViewById(2114387925);
        com.byazt.okk.s.n(this.tj, this.s);
        try {
            if (this.q == 2 && this.s.ox() == 1 && (this.um.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.um.getLayoutParams();
                layoutParams.height = com.byazt.okk.s.s(this.qg, 55.0f);
                layoutParams.topMargin = com.byazt.okk.s.s(this.qg, 20.0f);
                this.um.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fs.getLayoutParams();
                layoutParams2.bottomMargin = com.byazt.okk.s.s(this.qg, 12.0f);
                this.fs.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.s.ox() == 1 && this.rv != null && (this.rv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.rv.getLayoutParams();
            int iL = com.byazt.okk.s.l((Context) this.qg);
            layoutParams3.width = iL;
            int i = (iL * 9) / 16;
            layoutParams3.height = i;
            this.rv.setLayoutParams(layoutParams3);
            this.sz = (com.byazt.okk.s.w((Context) this.qg) - i) / 2;
        }
        s();
        q();
        l();
        w();
        x();
        cp();
    }

    private void s() {
        if (this.cy != null) {
            v vVarXu = this.s.xu();
            if (vVarXu != null && !TextUtils.isEmpty(vVarXu.n())) {
                com.byazt.imu.s.n(vVarXu).n(this.cy);
            } else {
                sz.n((Context) this.qg, "tt_ad_logo_small", (ImageView) this.cy, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (this.hd != null) {
            if (this.q == 1 && this.s.k() != null && !TextUtils.isEmpty(this.s.k().s())) {
                this.hd.setText(this.s.k().s());
            } else {
                this.hd.setText(this.s.E_());
            }
        }
    }

    private void q() {
        if (this.cd == null) {
            return;
        }
        int iW = this.s.k() != null ? this.s.k().w() : 6870;
        this.cd.setText(String.format("%1$s个评分", iW > 10000 ? (iW / 10000) + "万" : String.valueOf(iW)));
    }

    private void l() {
        TextView textView = this.um;
        if (textView != null) {
            textView.setText(this.s.ox() == 3 ? fs() : qg());
        }
    }

    private void w() {
        if (this.q == 1) {
            TextView textView = this.hd;
            if (textView != null) {
                textView.setMaxWidth(com.byazt.okk.s.s(this.qg, 153.0f));
            }
        } else {
            TextView textView2 = this.hd;
            if (textView2 != null) {
                textView2.setMaxWidth(com.byazt.okk.s.s(this.qg, 404.0f));
            }
        }
        if (this.w) {
            return;
        }
        com.byazt.okk.s.n((View) this.fs, 0);
    }

    private void x() {
        if (this.s.ox() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            d.n((LinearLayout) this.qg.findViewById(2114387898), new d.n().n(iArr[0]).qg(Color.parseColor("#80000000")).n(iArr).s(com.byazt.okk.s.s(this.qg, 17.0f)).q(0).l(com.byazt.okk.s.s(this.qg, 3.0f)));
        }
    }

    public String qg() {
        if (this.s == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(this.s.jb())) {
            return this.s.rv() != 4 ? "查看详情" : "立即下载";
        }
        return this.s.jb();
    }

    private String fs() {
        boolean z;
        boolean zEquals;
        String strN = com.byazt.vgx.w.n(this.qg);
        if (strN == null) {
            strN = "";
        }
        try {
            z = strN.equals(Locale.CHINESE.getLanguage()) || strN.equals(Locale.CHINA.getLanguage()) || strN.equals(Locale.TRADITIONAL_CHINESE.getLanguage());
            try {
                zEquals = strN.equals(Locale.ENGLISH.getLanguage());
            } catch (Throwable unused) {
                zEquals = false;
            }
        } catch (Throwable unused2) {
            z = true;
        }
        String strJb = "下载";
        if (!z && zEquals) {
            strJb = "Install";
        }
        if (this.s == null) {
            return strJb;
        }
        if (TextUtils.isEmpty(this.s.jb())) {
            if (this.s.rv() != 4) {
                if (z) {
                    strJb = "查看";
                } else if (zEquals) {
                    strJb = "View";
                }
            }
        } else {
            strJb = this.s.jb();
            if (strJb != null) {
                if (!com.byazt.vgx.w.fs(strJb) || strJb.length() <= 2) {
                    if (!com.byazt.vgx.w.fs(strJb) && strJb.length() > 7) {
                        if (z) {
                            strJb = n(true);
                        } else if (zEquals) {
                            strJb = n(false);
                        }
                    }
                } else if (z) {
                    strJb = n(true);
                } else if (zEquals) {
                    strJb = n(false);
                }
            }
        }
        if (zEquals && !com.byazt.vgx.w.fs(strJb)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.um.getLayoutParams();
            layoutParams.bottomMargin = com.byazt.okk.s.s(this.qg, 4.0f);
            this.um.setLayoutParams(layoutParams);
        }
        return strJb;
    }

    private String n(boolean z) {
        if (this.s == null) {
            return null;
        }
        if (z) {
            return this.s.rv() == 4 ? "下载" : "查看";
        }
        return this.s.rv() == 4 ? "Install" : "View";
    }

    @Override // com.byazt.tkz.qg
    public void n(com.byazt.ys.qg qgVar, com.byazt.ys.qg qgVar2) {
        if (this.s == null) {
            return;
        }
        com.byazt.okk.s.n((View) this.um, (View.OnClickListener) qgVar, (String) null);
        com.byazt.okk.s.n((View) this.um, (View.OnTouchListener) qgVar, (String) null);
        n((View.OnTouchListener) qgVar2);
        n((View.OnClickListener) qgVar2);
        if (this.s.ox() == 1) {
            FrameLayout frameLayout = this.py;
            if (frameLayout != null) {
                com.byazt.okk.s.n((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.py.getLayoutParams();
                layoutParams.height = this.sz;
                this.py.setLayoutParams(layoutParams);
            }
            FrameLayout frameLayout2 = this.ou;
            if (frameLayout2 != null) {
                com.byazt.okk.s.n((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ou.getLayoutParams();
                layoutParams2.height = this.sz;
                this.ou.setLayoutParams(layoutParams2);
            }
        }
    }

    private void n(View.OnTouchListener onTouchListener) {
        com.byazt.okk.s.n(this.fs, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        com.byazt.okk.s.n(this.hd, onTouchListener, "TTBaseVideoActivity#mTvAppName");
        com.byazt.okk.s.n(this.cy, onTouchListener, "TTBaseVideoActivity#mIvIcon");
        com.byazt.okk.s.n(this.cd, onTouchListener, "TTBaseVideoActivity#mTvCommentVertical");
        com.byazt.okk.s.n(this.a, onTouchListener, "TTBaseVideoActivity#mRbScore");
        com.byazt.okk.s.n(this.rv, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        com.byazt.okk.s.n(this.py, onTouchListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        com.byazt.okk.s.n(this.ou, onTouchListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    private void n(View.OnClickListener onClickListener) {
        com.byazt.okk.s.n(this.fs, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        com.byazt.okk.s.n(this.hd, onClickListener, "TTBaseVideoActivity#mTvAppName");
        com.byazt.okk.s.n(this.cy, onClickListener, "TTBaseVideoActivity#mIvIcon");
        com.byazt.okk.s.n(this.cd, onClickListener, "TTBaseVideoActivity#mTvCommentVertical");
        com.byazt.okk.s.n(this.a, onClickListener, "TTBaseVideoActivity#mRbScore");
        com.byazt.okk.s.n(this.rv, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
        com.byazt.okk.s.n(this.py, onClickListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        com.byazt.okk.s.n(this.ou, onClickListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    @Override // com.byazt.tkz.qg
    public void qg(int i) {
        if (this.fs == null || this.oa == -1 || i != this.oa || this.k.getAndSet(true)) {
            return;
        }
        com.byazt.okk.s.n((View) this.fs, 0);
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.fs, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }
}
