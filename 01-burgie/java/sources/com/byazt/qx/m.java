package com.byazt.qx;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.gz.NativeDrawVideoTsView;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.hg.v;
import com.byazt.oc.UpieImageView;
import com.byazt.pi.RoundImageView;
import com.byazt.pi.TTRatingBar;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mar.sdk.MARCode;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 108})
public class m extends BackupView {
    public static lb[] m = {new lb(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new lb(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX), new lb(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new lb(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX), new lb(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX), new lb(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX)};
    public ImageView a;
    public int g;
    public View ho;
    public TextView lb;
    public NativeExpressView nt;
    public TextView qa;
    public com.byazt.nv.hn yb;

    public m(Context context) {
        super(context);
        this.pr = context;
    }

    public void pr(of ofVar, NativeExpressView nativeExpressView, com.byazt.nv.hn hnVar) {
        setBackgroundColor(-1);
        this.hw = ofVar;
        this.nt = nativeExpressView;
        this.yb = hnVar;
        int iM = ls.m(this.hw);
        this.g = iM;
        hw(iM);
        int iK = ls.k(this.hw);
        hn(iK);
        c(com.byazt.sd.zo.nt().nw());
        int i = iK != 9 ? -2 : -1;
        this.nt.addView(this, new ViewGroup.LayoutParams(i, i));
    }

    private void hn(int i) {
        lb lbVarX = x(this.hw.jg());
        this.uc = er.hn(this.pr, this.nt.getExpectExpressWidth());
        this.fw = er.hn(this.pr, this.nt.getExpectExpressHeight());
        if (this.uc <= 0) {
            this.uc = er.c(this.pr);
        }
        if (this.fw <= 0) {
            this.fw = Float.valueOf(this.uc / lbVarX.hn).intValue();
        }
        if (this.uc > 0 && this.uc > er.c(this.pr)) {
            float fC = er.c(this.pr) / this.uc;
            this.uc = er.c(this.pr);
            this.fw = Float.valueOf(this.fw * fC).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.uc, this.fw);
        }
        layoutParams.width = this.uc;
        layoutParams.height = this.fw;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (i == 9) {
            this.c = "draw_ad";
            if (com.byazt.lpk.pr.pr(this.hw)) {
                w();
            } else {
                zo();
                return;
            }
        }
        this.c = com.byazt.pfl.hw.AD_TAG_FEED;
        switch (this.hw.jg()) {
            case 2:
                hn();
                break;
            case 3:
                uc();
                break;
            case 4:
                x();
                break;
            case 5:
                aj();
                break;
            case 15:
                fw();
                break;
            case 16:
                vk();
                break;
            case 131:
                vk();
                break;
            case 166:
                k();
                break;
            default:
                vk();
                break;
        }
    }

    private lb x(int i) {
        lb[] lbVarArr = m;
        lb lbVar = lbVarArr[0];
        try {
            for (lb lbVar2 : lbVarArr) {
                if (lbVar2.pr == i) {
                    return lbVar2;
                }
            }
            return lbVar;
        } catch (Throwable th) {
            return lbVar;
        }
    }

    private void pr(ImageView imageView) {
        com.byazt.ub.hw.pr(this.hw.de().get(0)).pr(imageView);
        if (com.byazt.ja.pr.x(this.hw)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.byazt.ja.pr.vk(this.hw), com.byazt.vr.pr.pr(this.hw), com.byazt.ja.pr.w(this.hw));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.ja.pr.pr(imageView, upieImageView);
        }
    }

    private void hn() {
        View viewQn = com.byazt.sdv.c.qn(this.pr);
        this.ho = viewQn;
        addView(viewQn);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387936);
        this.a = (ImageView) this.ho.findViewById(2114387854);
        this.qa = (TextView) this.ho.findViewById(2114387920);
        this.lb = (TextView) this.ho.findViewById(2114387940);
        pr((LinearLayout) this.ho.findViewById(2114387660), (TextView) this.ho.findViewById(2114387658), this.hw);
        pr(imageView);
        this.qa.setText(getDescription());
        this.lb.setText(getTitle());
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
            }
        });
        pr(this, true);
    }

    private void pr(View view, TextView textView, of ofVar) {
        if (view == null || textView == null) {
            return;
        }
        if (ofVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(ofVar.jr())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            er.pr(view, ofVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            er.pr(textView, ofVar);
        }
    }

    private void x() {
        View viewO = com.byazt.sdv.c.o(this.pr);
        this.ho = viewO;
        addView(viewO);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387695);
        ImageView imageView2 = (ImageView) this.ho.findViewById(2114387692);
        ImageView imageView3 = (ImageView) this.ho.findViewById(2114387690);
        ImageView imageView4 = (ImageView) this.ho.findViewById(2114387931);
        this.a = (ImageView) this.ho.findViewById(2114387854);
        this.qa = (TextView) this.ho.findViewById(2114387920);
        this.lb = (TextView) this.ho.findViewById(2114387940);
        TextView textView = (TextView) this.ho.findViewById(2114387633);
        er.pr((TextView) this.ho.findViewById(2114387658), this.hw);
        com.byazt.ub.hw.pr(this.hw.de().get(0)).pr(imageView);
        com.byazt.ub.hw.pr(this.hw.de().get(1)).pr(imageView2);
        com.byazt.ub.hw.pr(this.hw.de().get(2)).pr(imageView3);
        com.byazt.ub.hw.pr(this.hw.mo()).pr(imageView4);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
            }
        });
        this.qa.setText(getDescription());
        this.lb.setText(getTitle());
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView.setText(this.hw.se());
        }
        pr(this, false);
        pr(textView, true);
    }

    private void uc() {
        View viewNw = com.byazt.sdv.c.nw(this.pr);
        this.ho = viewNw;
        addView(viewNw);
        this.ho.findViewById(2114387734).setVisibility(8);
        this.ho.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387936);
        this.a = (ImageView) this.ho.findViewById(2114387854);
        this.qa = (TextView) this.ho.findViewById(2114387920);
        this.lb = (TextView) this.ho.findViewById(2114387940);
        TextView textView = (TextView) this.ho.findViewById(2114387633);
        er.pr((TextView) this.ho.findViewById(2114387658), this.hw);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.fw);
        pr(imageView);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
            }
        });
        this.qa.setText(getDescription());
        this.lb.setText(getTitle());
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView.setText(this.hw.se());
        }
        pr(this, false);
        pr(textView, true);
    }

    private void fw() {
        View viewBm = com.byazt.sdv.c.bm(this.pr);
        this.ho = viewBm;
        addView(viewBm);
        this.ho.findViewById(2114387734).setVisibility(0);
        this.ho.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.ho.findViewById(2114387965);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387913);
        this.a = (ImageView) this.ho.findViewById(2114387854);
        this.qa = (TextView) this.ho.findViewById(2114387920);
        this.lb = (TextView) this.ho.findViewById(2114387940);
        TextView textView = (TextView) this.ho.findViewById(2114387855);
        TextView textView2 = (TextView) this.ho.findViewById(2114387856);
        TextView textView3 = (TextView) this.ho.findViewById(2114387633);
        TextView textView4 = (TextView) this.ho.findViewById(2114387908);
        TTRatingBar tTRatingBar = (TTRatingBar) this.ho.findViewById(2114387874);
        er.pr((TextView) this.ho.findViewById(2114387617), this.hw);
        com.byazt.ub.hw.pr(this.hw.mo()).pr(imageView);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
            }
        });
        int iC = this.hw.ho() != null ? this.hw.ho().c() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iC)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iC);
        tTRatingBar.setStarImageWidth(er.hn(this.pr, 15.0f));
        tTRatingBar.setStarImageHeight(er.hn(this.pr, 14.0f));
        tTRatingBar.setStarImagePadding(er.hn(this.pr, 4.0f));
        tTRatingBar.pr();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.qa.setText(getDescription());
        this.lb.setText(getTitle());
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView3.setText(this.hw.se());
        }
        View viewPr = pr(this.nt);
        if (viewPr != null) {
            int i = (this.uc * MARCode.CODE_VIVOCHANNEL_CALLBACK) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(viewPr, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        pr(this, false);
        pr(textView3, true);
    }

    private void zo() {
        View viewR = com.byazt.sdv.c.r(this.pr);
        this.ho = viewR;
        addView(viewR);
        FrameLayout frameLayout = (FrameLayout) this.ho.findViewById(2114387734);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387936);
        TextView textView = (TextView) this.ho.findViewById(2114387920);
        TextView textView2 = (TextView) this.ho.findViewById(2114387940);
        TextView textView3 = (TextView) this.ho.findViewById(2114387633);
        TextView textView4 = (TextView) this.ho.findViewById(2114387658);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        er.pr(textView4, this.hw);
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView3.setText(this.hw.se());
        }
        if (!of.hn(this.hw)) {
            pr(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        View viewPr = pr(this.nt);
        NativeExpressView nativeExpressView = this.nt;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (viewPr instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) viewPr;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (viewPr != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewPr, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.ho.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        pr(textView2, false);
        pr(textView, false);
        pr(textView3, true);
    }

    private void aj() {
        View viewNw = com.byazt.sdv.c.nw(this.pr);
        this.ho = viewNw;
        addView(viewNw);
        FrameLayout frameLayout = (FrameLayout) this.ho.findViewById(2114387734);
        frameLayout.setVisibility(0);
        this.ho.findViewById(2114387955).setVisibility(8);
        this.a = (ImageView) this.ho.findViewById(2114387854);
        this.qa = (TextView) this.ho.findViewById(2114387920);
        this.lb = (TextView) this.ho.findViewById(2114387940);
        TextView textView = (TextView) this.ho.findViewById(2114387633);
        er.pr((TextView) this.ho.findViewById(2114387658), this.hw);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
            }
        });
        this.qa.setText(getDescription());
        this.lb.setText(getTitle());
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView.setText(this.hw.se());
        }
        View viewPr = pr(this.nt);
        if (viewPr != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewPr, new ViewGroup.LayoutParams(this.uc, (this.uc * 9) / 16));
        }
        pr(this, false);
        pr(textView, true);
    }

    private void vk() {
        View viewBm = com.byazt.sdv.c.bm(this.pr);
        this.ho = viewBm;
        addView(viewBm);
        this.ho.findViewById(2114387734).setVisibility(8);
        this.ho.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387936);
        this.a = (ImageView) this.ho.findViewById(2114387854);
        this.qa = (TextView) this.ho.findViewById(2114387920);
        this.lb = (TextView) this.ho.findViewById(2114387940);
        TextView textView = (TextView) this.ho.findViewById(2114387633);
        er.pr((TextView) this.ho.findViewById(2114387658), this.hw);
        pr(imageView);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
            }
        });
        this.qa.setText(getDescription());
        this.lb.setText(getTitle());
        if (!TextUtils.isEmpty(this.hw.se())) {
            textView.setText(this.hw.se());
        }
        pr(this, false);
        pr(textView, true);
    }

    private void w() {
        if (this.hw == null) {
            return;
        }
        View viewHs = com.byazt.sdv.c.hs(this.pr);
        this.ho = viewHs;
        addView(viewHs);
        FrameLayout frameLayout = (FrameLayout) this.ho.findViewById(2114387765);
        TextView textView = (TextView) this.ho.findViewById(2114387899);
        View view = (RelativeLayout) this.ho.findViewById(2114387650);
        RoundImageView roundImageView = (RoundImageView) this.ho.findViewById(2114387818);
        RelativeLayout relativeLayout = (RelativeLayout) this.ho.findViewById(2114387777);
        TextView textView2 = (TextView) this.ho.findViewById(2114387768);
        TextView textView3 = (TextView) this.ho.findViewById(2114387619);
        TextView textView4 = (TextView) this.ho.findViewById(2114387895);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387881);
        if (com.byazt.lpk.pr.pr(this.hw)) {
            String strAj = v.aj(this.hw);
            if (!TextUtils.isEmpty(strAj) && roundImageView != null) {
                er.pr((View) relativeLayout, 0);
                com.byazt.ub.hw.pr(strAj).pr(roundImageView);
            } else {
                er.pr((View) relativeLayout, 8);
            }
            if (textView != null) {
                textView.setText(v.hn(this.hw));
            }
            if (textView2 != null) {
                int iX = v.x(this.hw);
                if (iX < 0) {
                    textView2.setVisibility(4);
                    er.pr((View) imageView, 4);
                } else {
                    textView2.setText(String.format("粉丝 %1$s", iX > 10000 ? (iX / 10000.0f) + "w" : String.valueOf(iX)));
                }
            }
            if (textView3 != null) {
                int iC = v.c(this.hw);
                if (iC < 0) {
                    er.pr((View) imageView, 4);
                    textView3.setVisibility(4);
                } else {
                    textView3.setText(String.format("观看 %1$s", iC > 10000 ? (iC / 10000.0f) + "w" : String.valueOf(iC)));
                }
            }
            if (textView4 != null) {
                textView4.setText(v.uc(this.hw));
            }
            View viewPr = pr(this.nt);
            if (viewPr != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewPr, new ViewGroup.LayoutParams(-1, -1));
            }
            com.byazt.az.pr prVarM = m();
            pr(roundImageView, prVarM, "click_live_avata");
            pr(textView, prVarM, "click_live_author_nickname");
            pr(textView2, prVarM, "click_live_author_follower_count");
            pr(textView3, prVarM, "click_live_author_following_count");
            pr(textView4, prVarM, "click_live_author_description");
            pr(frameLayout, prVarM, "click_live_feed");
            pr(view, prVarM, "click_live_button");
        }
    }

    private void k() {
        if (this.hw == null) {
            return;
        }
        View viewIe = com.byazt.sdv.c.ie(this.pr);
        this.ho = viewIe;
        addView(viewIe);
        FrameLayout frameLayout = (FrameLayout) this.ho.findViewById(2114387621);
        TextView textView = (TextView) this.ho.findViewById(2114387827);
        TextView textView2 = (TextView) this.ho.findViewById(2114387937);
        View view = (TextView) this.ho.findViewById(2114387861);
        RoundImageView roundImageView = (RoundImageView) this.ho.findViewById(2114387902);
        RelativeLayout relativeLayout = (RelativeLayout) this.ho.findViewById(2114387851);
        TextView textView3 = (TextView) this.ho.findViewById(2114387622);
        TextView textView4 = (TextView) this.ho.findViewById(2114387672);
        TextView textView5 = (TextView) this.ho.findViewById(2114387703);
        ImageView imageView = (ImageView) this.ho.findViewById(2114387881);
        if (com.byazt.lpk.pr.pr(this.hw)) {
            String strAj = v.aj(this.hw);
            if (!TextUtils.isEmpty(strAj) && roundImageView != null) {
                er.pr((View) relativeLayout, 0);
                com.byazt.ub.hw.pr(strAj).pr(roundImageView);
            } else {
                er.pr((View) relativeLayout, 8);
            }
            if (textView2 != null) {
                textView2.setText(v.hn(this.hw));
            }
            if (textView3 != null) {
                int iX = v.x(this.hw);
                if (iX < 0) {
                    textView3.setVisibility(4);
                    er.pr((View) imageView, 4);
                } else {
                    textView3.setText(String.format("粉丝 %1$s", iX > 10000 ? (iX / 10000.0f) + "w" : String.valueOf(iX)));
                }
            }
            if (textView4 != null) {
                int iC = v.c(this.hw);
                if (iC < 0) {
                    textView4.setVisibility(4);
                    er.pr((View) imageView, 4);
                } else {
                    textView4.setText(String.format("观看 %1$s", iC > 10000 ? (iC / 10000.0f) + "w" : String.valueOf(iC)));
                }
            }
            if (textView != null) {
                textView.setText(v.uc(this.hw));
            }
            View viewPr = pr(this.nt);
            if (viewPr != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewPr, new ViewGroup.LayoutParams(-1, -1));
            }
            com.byazt.az.pr prVarM = m();
            pr(roundImageView, prVarM, "click_live_avata");
            pr(textView2, prVarM, "click_live_author_nickname");
            pr(textView3, prVarM, "click_live_author_follower_count");
            pr(textView4, prVarM, "click_live_author_following_count");
            pr(textView, prVarM, "click_live_author_description");
            pr(frameLayout, prVarM, "click_live_feed");
            pr(view, prVarM, "click_live_button");
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qx.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    m.this.c();
                }
            });
        }
    }

    private com.byazt.az.pr m() {
        final com.byazt.az.pr prVar = new com.byazt.az.pr(this.pr, this.hw, this.c, ls.x(this.c)) { // from class: com.byazt.qx.m.8
            @Override // com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, com.byazt.hg.vk vkVar) {
                if (view == null) {
                    super.pr(view, vkVar);
                    return;
                }
                HashMap map = new HashMap();
                map.put("click_live_element", view.getTag());
                ((com.byazt.yx.pr) pr(com.byazt.yx.pr.class)).pr(map);
                super.pr(view, vkVar);
            }
        };
        hn hnVar = new hn() { // from class: com.byazt.qx.m.9
            @Override // com.byazt.qx.hn
            public void pr(View view, int i, com.byazt.hg.fo foVar) {
                try {
                    foVar.pr().put("click_extra_map", ((com.byazt.yx.pr) prVar.pr(com.byazt.yx.pr.class)).c());
                } catch (JSONException e) {
                }
                m.this.pr(view, i, foVar);
            }
        };
        com.byazt.md.pr prVar2 = (com.byazt.md.pr) prVar.pr(com.byazt.md.pr.class);
        if (prVar2 != null) {
            prVar2.pr(hnVar);
            prVar2.pr(2);
        }
        return prVar;
    }

    private void pr(View view, com.byazt.az.hw hwVar, String str) {
        if (view == null || hwVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(hwVar);
    }

    @Override // com.byazt.qx.BackupView
    public void pr(View view, int i, com.byazt.hg.fo foVar) {
        NativeExpressView nativeExpressView = this.nt;
        if (nativeExpressView != null) {
            if (i == 1 && nativeExpressView.getClickListener() != null) {
                this.nt.getClickListener().hw(this.a);
            }
            if (i == 2 && this.nt.getClickCreativeListener() != null) {
                this.nt.getClickCreativeListener().hw(this.a);
            }
            this.nt.pr(view, i, foVar, -1);
        }
    }

    @Override // com.byazt.qx.BackupView
    public NativeVideoTsView pr(Context context, of ofVar, String str, boolean z, boolean z2) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, ofVar, str, z, z2);
        }
        return new NativeVideoTsView(context, ofVar, str, z, z2);
    }

    private void c(int i) {
        if (i == 1) {
            hw();
            this.ho.setBackgroundColor(0);
            if (this.a != null) {
                com.byazt.ca.g.pr(getContext(), "tt_dislike_icon_night", this.a, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                return;
            }
            return;
        }
        pr();
        this.ho.setBackgroundColor(-1);
        if (this.a != null) {
            com.byazt.ca.g.pr(getContext(), "tt_dislike_icon2", this.a, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    public void pr() {
        if (this.lb == null || this.qa == null) {
            return;
        }
        switch (this.hw.jg()) {
            case 2:
                this.lb.setTextColor(Color.parseColor("#FFBCBCBC"));
                this.qa.setTextColor(Color.parseColor("#FF999999"));
                break;
            case 3:
            case 5:
            case 15:
            case 16:
                this.lb.setTextColor(Color.parseColor("#FF222222"));
                this.qa.setTextColor(Color.parseColor("#FF505050"));
                break;
            case 4:
                this.lb.setTextColor(Color.parseColor("#FF3E3E3E"));
                this.qa.setTextColor(Color.parseColor("#FF3E3E3E"));
                break;
        }
    }

    public void hw() {
        TextView textView = this.lb;
        if (textView == null || this.qa == null) {
            return;
        }
        textView.setTextColor(-1);
        this.qa.setTextColor(-1);
    }

    @Override // com.byazt.qx.BackupView, com.byazt.mo.pr
    public void b_(int i) {
        super.b_(i);
        c(i);
    }
}
