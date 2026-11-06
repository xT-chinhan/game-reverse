package com.byazt.za;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.ia.NativeDrawVideoTsView;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.ndr.RoundImageView;
import com.byazt.ndr.TTRatingBar;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.wt.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 110})
public class sz extends BackupView {
    public static um[] oa = {new um(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new um(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX), new um(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new um(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX), new um(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX), new um(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX)};
    public ImageView a;
    public TextView cd;
    public NativeExpressView cy;
    public ITTInnerDownloadAdapter hd;
    public View k;
    public int sz;
    public TextView um;

    public sz(Context context) {
        super(context);
        this.n = context;
    }

    public void n(pk pkVar, NativeExpressView nativeExpressView, ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        setBackgroundColor(-1);
        this.qg = pkVar;
        this.cy = nativeExpressView;
        this.hd = iTTInnerDownloadAdapter;
        int iCy = com.byazt.vgx.w.cy(this.qg);
        this.sz = iCy;
        qg(iCy);
        int iD = com.byazt.vgx.w.d(this.qg);
        s(iD);
        l(com.byazt.vyf.s.cy().dh());
        int i = iD != 9 ? -2 : -1;
        this.cy.addView(this, new ViewGroup.LayoutParams(i, i));
    }

    private void s(int i) {
        um umVarQ = q(this.qg.ge());
        this.w = com.byazt.okk.s.s(this.n, this.cy.getExpectExpressWidth());
        this.x = com.byazt.okk.s.s(this.n, this.cy.getExpectExpressHeight());
        if (this.w <= 0) {
            this.w = com.byazt.okk.s.l(this.n);
        }
        if (this.x <= 0) {
            this.x = Float.valueOf(this.w / umVarQ.s).intValue();
        }
        if (this.w > 0 && this.w > com.byazt.okk.s.l(this.n)) {
            float fL = com.byazt.okk.s.l(this.n) / this.w;
            this.w = com.byazt.okk.s.l(this.n);
            this.x = Float.valueOf(this.x * fL).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.w, this.x);
        }
        layoutParams.width = this.w;
        layoutParams.height = this.x;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (i == 9) {
            this.l = "draw_ad";
            if (com.byazt.gks.n.n(this.qg)) {
                cp();
                return;
            } else {
                fs();
                return;
            }
        }
        this.l = com.byazt.wg.qg.AD_TAG_FEED;
        int iGe = this.qg.ge();
        if (iGe == 2) {
            s();
            return;
        }
        if (iGe == 3) {
            w();
            return;
        }
        if (iGe == 4) {
            q();
            return;
        }
        if (iGe == 5) {
            rv();
            return;
        }
        if (iGe == 15) {
            x();
            return;
        }
        if (iGe == 16) {
            tj();
            return;
        }
        if (iGe == 131) {
            tj();
        } else if (iGe == 166) {
            d();
        } else {
            tj();
        }
    }

    private um q(int i) {
        um[] umVarArr = oa;
        um umVar = umVarArr[0];
        try {
            for (um umVar2 : umVarArr) {
                if (umVar2.n == i) {
                    return umVar2;
                }
            }
            return umVar;
        } catch (Throwable unused) {
            return umVar;
        }
    }

    private void n(ImageView imageView) {
        com.byazt.imu.s.n(this.qg.jo().get(0)).n(imageView);
        if (com.byazt.aci.n.q(this.qg)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.byazt.aci.n.tj(this.qg), com.byazt.du.n.n(this.qg), com.byazt.aci.n.d(this.qg));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.aci.n.n(imageView, upieImageView);
        }
    }

    private void s() {
        View viewDg = com.byazt.cb.qg.dg(this.n);
        this.k = viewDg;
        addView(viewDg);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        this.a = (ImageView) this.k.findViewById(2114387854);
        this.um = (TextView) this.k.findViewById(2114387920);
        this.cd = (TextView) this.k.findViewById(2114387940);
        n((LinearLayout) this.k.findViewById(2114387660), (TextView) this.k.findViewById(2114387658), this.qg);
        n(imageView);
        this.um.setText(getDescription());
        this.cd.setText(getTitle());
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sz.this.l();
            }
        });
        n(this, true);
    }

    private void n(View view, TextView textView, pk pkVar) {
        if (view == null || textView == null) {
            return;
        }
        if (pkVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(pkVar.fw())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            com.byazt.okk.s.n(view, pkVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            com.byazt.okk.s.n(textView, pkVar);
        }
    }

    private void q() {
        View viewB = com.byazt.cb.qg.b(this.n);
        this.k = viewB;
        addView(viewB);
        ImageView imageView = (ImageView) this.k.findViewById(2114387695);
        ImageView imageView2 = (ImageView) this.k.findViewById(2114387692);
        ImageView imageView3 = (ImageView) this.k.findViewById(2114387690);
        ImageView imageView4 = (ImageView) this.k.findViewById(2114387931);
        this.a = (ImageView) this.k.findViewById(2114387854);
        this.um = (TextView) this.k.findViewById(2114387920);
        this.cd = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        com.byazt.okk.s.n((TextView) this.k.findViewById(2114387658), this.qg);
        com.byazt.imu.s.n(this.qg.jo().get(0)).n(imageView);
        com.byazt.imu.s.n(this.qg.jo().get(1)).n(imageView2);
        com.byazt.imu.s.n(this.qg.jo().get(2)).n(imageView3);
        com.byazt.imu.s.n(this.qg.xu()).n(imageView4);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sz.this.l();
            }
        });
        this.um.setText(getDescription());
        this.cd.setText(getTitle());
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView.setText(this.qg.jb());
        }
        n(this, false);
        n(textView, true);
    }

    private void w() {
        View viewRf = com.byazt.cb.qg.rf(this.n);
        this.k = viewRf;
        addView(viewRf);
        this.k.findViewById(2114387734).setVisibility(8);
        this.k.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        this.a = (ImageView) this.k.findViewById(2114387854);
        this.um = (TextView) this.k.findViewById(2114387920);
        this.cd = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        com.byazt.okk.s.n((TextView) this.k.findViewById(2114387658), this.qg);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.x);
        n(imageView);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sz.this.l();
            }
        });
        this.um.setText(getDescription());
        this.cd.setText(getTitle());
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView.setText(this.qg.jb());
        }
        n(this, false);
        n(textView, true);
    }

    private void x() {
        View viewNf = com.byazt.cb.qg.nf(this.n);
        this.k = viewNf;
        addView(viewNf);
        this.k.findViewById(2114387734).setVisibility(0);
        this.k.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387965);
        ImageView imageView = (ImageView) this.k.findViewById(2114387913);
        this.a = (ImageView) this.k.findViewById(2114387854);
        this.um = (TextView) this.k.findViewById(2114387920);
        this.cd = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387855);
        TextView textView2 = (TextView) this.k.findViewById(2114387856);
        TextView textView3 = (TextView) this.k.findViewById(2114387633);
        TextView textView4 = (TextView) this.k.findViewById(2114387908);
        TTRatingBar tTRatingBar = (TTRatingBar) this.k.findViewById(2114387874);
        com.byazt.okk.s.n((TextView) this.k.findViewById(2114387617), this.qg);
        com.byazt.imu.s.n(this.qg.xu()).n(imageView);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sz.this.l();
            }
        });
        int iL = this.qg.k() != null ? this.qg.k().l() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iL)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iL);
        tTRatingBar.setStarImageWidth(com.byazt.okk.s.s(this.n, 15.0f));
        tTRatingBar.setStarImageHeight(com.byazt.okk.s.s(this.n, 14.0f));
        tTRatingBar.setStarImagePadding(com.byazt.okk.s.s(this.n, 4.0f));
        tTRatingBar.n();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.um.setText(getDescription());
        this.cd.setText(getTitle());
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView3.setText(this.qg.jb());
        }
        View viewN = n(this.cy);
        if (viewN != null) {
            int i = (this.w * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(viewN, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        n(this, false);
        n(textView3, true);
    }

    private void fs() {
        View viewSh = com.byazt.cb.qg.sh(this.n);
        this.k = viewSh;
        addView(viewSh);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387734);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        TextView textView = (TextView) this.k.findViewById(2114387920);
        TextView textView2 = (TextView) this.k.findViewById(2114387940);
        TextView textView3 = (TextView) this.k.findViewById(2114387633);
        TextView textView4 = (TextView) this.k.findViewById(2114387658);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        com.byazt.okk.s.n(textView4, this.qg);
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView3.setText(this.qg.jb());
        }
        if (!pk.s(this.qg)) {
            n(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        View viewN = n(this.cy);
        NativeExpressView nativeExpressView = this.cy;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (viewN instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) viewN;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (viewN != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewN, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.k.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        n(textView2, false);
        n(textView, false);
        n(textView3, true);
    }

    private void rv() {
        View viewRf = com.byazt.cb.qg.rf(this.n);
        this.k = viewRf;
        addView(viewRf);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387734);
        frameLayout.setVisibility(0);
        this.k.findViewById(2114387955).setVisibility(8);
        this.a = (ImageView) this.k.findViewById(2114387854);
        this.um = (TextView) this.k.findViewById(2114387920);
        this.cd = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        com.byazt.okk.s.n((TextView) this.k.findViewById(2114387658), this.qg);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sz.this.l();
            }
        });
        this.um.setText(getDescription());
        this.cd.setText(getTitle());
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView.setText(this.qg.jb());
        }
        View viewN = n(this.cy);
        if (viewN != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewN, new ViewGroup.LayoutParams(this.w, (this.w * 9) / 16));
        }
        n(this, false);
        n(textView, true);
    }

    private void tj() {
        View viewNf = com.byazt.cb.qg.nf(this.n);
        this.k = viewNf;
        addView(viewNf);
        this.k.findViewById(2114387734).setVisibility(8);
        this.k.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        this.a = (ImageView) this.k.findViewById(2114387854);
        this.um = (TextView) this.k.findViewById(2114387920);
        this.cd = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        com.byazt.okk.s.n((TextView) this.k.findViewById(2114387658), this.qg);
        n(imageView);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sz.this.l();
            }
        });
        this.um.setText(getDescription());
        this.cd.setText(getTitle());
        if (!TextUtils.isEmpty(this.qg.jb())) {
            textView.setText(this.qg.jb());
        }
        n(this, false);
        n(textView, true);
    }

    private void cp() {
        if (this.qg == null) {
            return;
        }
        View viewY = com.byazt.cb.qg.y(this.n);
        this.k = viewY;
        addView(viewY);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387765);
        TextView textView = (TextView) this.k.findViewById(2114387899);
        View view = (RelativeLayout) this.k.findViewById(2114387650);
        RoundImageView roundImageView = (RoundImageView) this.k.findViewById(2114387818);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(2114387777);
        TextView textView2 = (TextView) this.k.findViewById(2114387768);
        TextView textView3 = (TextView) this.k.findViewById(2114387619);
        TextView textView4 = (TextView) this.k.findViewById(2114387895);
        ImageView imageView = (ImageView) this.k.findViewById(2114387881);
        if (com.byazt.gks.n.n(this.qg)) {
            String strRv = oj.rv(this.qg);
            if (!TextUtils.isEmpty(strRv) && roundImageView != null) {
                com.byazt.okk.s.n((View) relativeLayout, 0);
                com.byazt.imu.s.n(strRv).n(roundImageView);
            } else {
                com.byazt.okk.s.n((View) relativeLayout, 8);
            }
            if (textView != null) {
                textView.setText(oj.s(this.qg));
            }
            if (textView2 != null) {
                int iQ = oj.q(this.qg);
                if (iQ < 0) {
                    textView2.setVisibility(4);
                    com.byazt.okk.s.n((View) imageView, 4);
                } else {
                    textView2.setText(String.format("粉丝 %1$s", iQ > 10000 ? (iQ / 10000.0f) + "w" : String.valueOf(iQ)));
                }
            }
            if (textView3 != null) {
                int iL = oj.l(this.qg);
                if (iL < 0) {
                    com.byazt.okk.s.n((View) imageView, 4);
                    textView3.setVisibility(4);
                } else {
                    textView3.setText(String.format("观看 %1$s", iL > 10000 ? (iL / 10000.0f) + "w" : String.valueOf(iL)));
                }
            }
            if (textView4 != null) {
                textView4.setText(oj.w(this.qg));
            }
            View viewN = n(this.cy);
            if (viewN != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewN, new ViewGroup.LayoutParams(-1, -1));
            }
            com.byazt.ys.n nVarOa = oa();
            n(roundImageView, nVarOa, "click_live_avata");
            n(textView, nVarOa, "click_live_author_nickname");
            n(textView2, nVarOa, "click_live_author_follower_count");
            n(textView3, nVarOa, "click_live_author_following_count");
            n(textView4, nVarOa, "click_live_author_description");
            n(frameLayout, nVarOa, "click_live_feed");
            n(view, nVarOa, "click_live_button");
        }
    }

    private void d() {
        if (this.qg == null) {
            return;
        }
        View viewDh = com.byazt.cb.qg.dh(this.n);
        this.k = viewDh;
        addView(viewDh);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387621);
        TextView textView = (TextView) this.k.findViewById(2114387827);
        TextView textView2 = (TextView) this.k.findViewById(2114387937);
        View view = (TextView) this.k.findViewById(2114387861);
        RoundImageView roundImageView = (RoundImageView) this.k.findViewById(2114387902);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(2114387851);
        TextView textView3 = (TextView) this.k.findViewById(2114387622);
        TextView textView4 = (TextView) this.k.findViewById(2114387672);
        TextView textView5 = (TextView) this.k.findViewById(2114387703);
        ImageView imageView = (ImageView) this.k.findViewById(2114387881);
        if (com.byazt.gks.n.n(this.qg)) {
            String strRv = oj.rv(this.qg);
            if (!TextUtils.isEmpty(strRv) && roundImageView != null) {
                com.byazt.okk.s.n((View) relativeLayout, 0);
                com.byazt.imu.s.n(strRv).n(roundImageView);
            } else {
                com.byazt.okk.s.n((View) relativeLayout, 8);
            }
            if (textView2 != null) {
                textView2.setText(oj.s(this.qg));
            }
            if (textView3 != null) {
                int iQ = oj.q(this.qg);
                if (iQ < 0) {
                    textView3.setVisibility(4);
                    com.byazt.okk.s.n((View) imageView, 4);
                } else {
                    textView3.setText(String.format("粉丝 %1$s", iQ > 10000 ? (iQ / 10000.0f) + "w" : String.valueOf(iQ)));
                }
            }
            if (textView4 != null) {
                int iL = oj.l(this.qg);
                if (iL < 0) {
                    textView4.setVisibility(4);
                    com.byazt.okk.s.n((View) imageView, 4);
                } else {
                    textView4.setText(String.format("观看 %1$s", iL > 10000 ? (iL / 10000.0f) + "w" : String.valueOf(iL)));
                }
            }
            if (textView != null) {
                textView.setText(oj.w(this.qg));
            }
            View viewN = n(this.cy);
            if (viewN != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewN, new ViewGroup.LayoutParams(-1, -1));
            }
            com.byazt.ys.n nVarOa = oa();
            n(roundImageView, nVarOa, "click_live_avata");
            n(textView2, nVarOa, "click_live_author_nickname");
            n(textView3, nVarOa, "click_live_author_follower_count");
            n(textView4, nVarOa, "click_live_author_following_count");
            n(textView, nVarOa, "click_live_author_description");
            n(frameLayout, nVarOa, "click_live_feed");
            n(view, nVarOa, "click_live_button");
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.za.sz.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    sz.this.l();
                }
            });
        }
    }

    private com.byazt.ys.n oa() {
        final com.byazt.ys.n nVar = new com.byazt.ys.n(this.n, this.qg, this.l, com.byazt.vgx.w.q(this.l)) { // from class: com.byazt.za.sz.8
            @Override // com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, com.byazt.gct.tj tjVar) {
                if (view == null) {
                    super.n(view, tjVar);
                    return;
                }
                HashMap map = new HashMap();
                map.put("click_live_element", view.getTag());
                ((com.byazt.fq.n) n(com.byazt.fq.n.class)).n(map);
                super.n(view, tjVar);
            }
        };
        s sVar = new s() { // from class: com.byazt.za.sz.9
            @Override // com.byazt.za.s
            public void n(View view, int i, com.byazt.gct.wm wmVar) {
                try {
                    wmVar.n().put("click_extra_map", ((com.byazt.fq.n) nVar.n(com.byazt.fq.n.class)).l());
                } catch (JSONException unused) {
                }
                sz.this.n(view, i, wmVar);
            }
        };
        com.byazt.soz.n nVar2 = (com.byazt.soz.n) nVar.n(com.byazt.soz.n.class);
        if (nVar2 != null) {
            nVar2.n(sVar);
            nVar2.n(2);
        }
        return nVar;
    }

    private void n(View view, com.byazt.ys.qg qgVar, String str) {
        if (view == null || qgVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(qgVar);
    }

    @Override // com.byazt.za.BackupView
    public void n(View view, int i, com.byazt.gct.wm wmVar) {
        NativeExpressView nativeExpressView = this.cy;
        if (nativeExpressView != null) {
            if (i == 1 && nativeExpressView.getClickListener() != null) {
                this.cy.getClickListener().qg(this.a);
            }
            if (i == 2 && this.cy.getClickCreativeListener() != null) {
                this.cy.getClickCreativeListener().qg(this.a);
            }
            this.cy.n(view, i, wmVar, -1);
        }
    }

    @Override // com.byazt.za.BackupView
    public NativeVideoTsView n(Context context, pk pkVar, String str, boolean z, boolean z2) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, pkVar, str, z, z2);
        }
        return new NativeVideoTsView(context, pkVar, str, z, z2);
    }

    private void l(int i) {
        if (i == 1) {
            qg();
            this.k.setBackgroundColor(0);
            if (this.a != null) {
                com.byazt.tk.sz.n(getContext(), "tt_dislike_icon_night", this.a, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                return;
            }
            return;
        }
        n();
        this.k.setBackgroundColor(-1);
        if (this.a != null) {
            com.byazt.tk.sz.n(getContext(), "tt_dislike_icon2", this.a, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    public void n() {
        if (this.cd == null || this.um == null) {
            return;
        }
        int iGe = this.qg.ge();
        if (iGe == 2) {
            this.cd.setTextColor(Color.parseColor("#FFBCBCBC"));
            this.um.setTextColor(Color.parseColor("#FF999999"));
            return;
        }
        if (iGe != 3) {
            if (iGe == 4) {
                this.cd.setTextColor(Color.parseColor("#FF3E3E3E"));
                this.um.setTextColor(Color.parseColor("#FF3E3E3E"));
                return;
            } else if (iGe != 5 && iGe != 15 && iGe != 16) {
                return;
            }
        }
        this.cd.setTextColor(Color.parseColor("#FF222222"));
        this.um.setTextColor(Color.parseColor("#FF505050"));
    }

    public void qg() {
        TextView textView = this.cd;
        if (textView == null || this.um == null) {
            return;
        }
        textView.setTextColor(-1);
        this.um.setTextColor(-1);
    }

    @Override // com.byazt.za.BackupView, com.byazt.hne.n
    public void b_(int i) {
        super.b_(i);
        l(i);
    }
}
