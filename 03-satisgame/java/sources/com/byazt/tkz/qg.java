package com.byazt.tkz;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.mr.EmptyView;
import com.byazt.tk.sz;
import com.byazt.wt.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 26})
public class qg {
    public RelativeLayout cp;
    public TextView d;
    public RelativeLayout fs;
    public final float l;
    public final String n;
    public int oa = 3;
    public final int q;
    public final TTBaseVideoActivity qg;
    public FrameLayout rv;
    public final pk s;
    public TextView tj;
    public final boolean w;
    public ViewGroup x;

    public void n(DownloadListener downloadListener) {
    }

    public void n(com.byazt.ys.qg qgVar, com.byazt.ys.qg qgVar2) {
    }

    public void q(int i) {
    }

    public void qg(int i) {
    }

    public void s(int i) {
    }

    public void tj() {
    }

    public qg(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        this.qg = tTBaseVideoActivity;
        this.s = pkVar;
        this.q = pkVar.ys();
        this.l = pkVar.sl();
        this.w = z;
        this.n = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public void n() {
        ViewGroup viewGroup = (ViewGroup) this.qg.findViewById(2114387959);
        this.x = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        com.byazt.wb.fs.n(this.x);
        if (nf.n(this.s) != 2) {
            qg();
        }
    }

    private void qg() {
        ViewGroup viewGroup = this.x;
        if (viewGroup != null) {
            EmptyView emptyViewN = n(viewGroup);
            if (emptyViewN == null) {
                pk pkVar = this.s;
                EmptyView emptyView = new EmptyView(this.qg, this.x, pkVar != null ? pkVar.yq() : 1000);
                emptyView.n(this.s, this.n);
                this.x.addView(emptyView);
                emptyViewN = emptyView;
            }
            emptyViewN.setNeedCheckingShow(false);
            emptyViewN.setCallback(new EmptyView.n() { // from class: com.byazt.tkz.qg.1
                @Override // com.byazt.mr.EmptyView.n
                public void n() {
                }

                @Override // com.byazt.mr.EmptyView.n
                public void n(View view, Map<String, Object> map) {
                }

                @Override // com.byazt.mr.EmptyView.n
                public void n(boolean z) {
                }

                @Override // com.byazt.mr.EmptyView.n
                public void qg() {
                }
            });
        }
    }

    public void cp() {
        if (this.w) {
            int iCt = this.s.ct();
            this.oa = iCt;
            if (iCt == -200) {
                this.oa = com.byazt.nf.rv.qg().cp(new StringBuilder().append(com.byazt.vgx.w.cy(this.s)).toString());
            }
            if (this.oa == -1) {
                com.byazt.okk.s.n((View) this.fs, 0);
            }
        }
    }

    public void l(int i) {
        com.byazt.okk.s.n((View) this.tj, i);
    }

    public void w(int i) {
        com.byazt.okk.s.n((View) this.fs, i);
    }

    public FrameLayout d() {
        return this.rv;
    }

    public RelativeLayout oa() {
        return this.fs;
    }

    public String sz() {
        return com.byazt.vgx.w.m(this.s);
    }

    public String k() {
        return com.byazt.vgx.w.hu(this.s);
    }

    public void n(ImageView imageView, UpieImageView upieImageView) {
        List<v> listJo;
        if (imageView == null || (listJo = this.s.jo()) == null || listJo.size() <= 0) {
            return;
        }
        com.byazt.imu.s.n(listJo.get(0)).n(imageView);
        if (upieImageView == null || !com.byazt.aci.n.q(this.s)) {
            return;
        }
        com.byazt.aci.n.n(imageView, upieImageView);
    }

    public void s(boolean z) {
        this.qg.an().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public void cy() {
        pk pkVar = this.s;
        String strFw = pkVar != null ? pkVar.fw() : null;
        if (this.tj == null || !TextUtils.isEmpty(strFw)) {
            return;
        }
        sz.n(this.qg, "tt_ad_logo_backup", this.tj, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    private EmptyView n(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
