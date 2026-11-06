package com.byazt.jm;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.ca.ny;
import com.byazt.hg.gu;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 121})
public class x extends hn implements View.OnClickListener {
    public RelativeLayout a;
    public FrameLayout aj;
    public com.byazt.mr.fw c;
    public TextView cz;
    public View.OnClickListener fo;
    public ImageView fw;
    public TextView g;
    public TextView ho;
    public TextView k;
    public TextView lb;
    public TextView m;
    public View nt;
    public ny ny;
    public TextView qa;
    public RelativeLayout uc;
    public RelativeLayout vk;
    public ImageView w;
    public RelativeLayout yb;
    public View zo;

    private View pr(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.uc = relativeLayout2;
        relativeLayout2.setId(2114387562);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.uc.setClipChildren(false);
        this.uc.setVisibility(4);
        this.uc.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.uc);
        ImageView imageView = new ImageView(context);
        this.zo = imageView;
        imageView.setId(2114387561);
        this.zo.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.uc.addView(this.zo);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387560);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.uc.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.g = textView;
        textView.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = er.hn(context, 8.0f);
        layoutParams3.bottomMargin = er.hn(context, 10.0f);
        layoutParams3.rightMargin = er.hn(context, 4.0f);
        this.g.setLayoutParams(layoutParams3);
        g.pr(this.pr, "tt_splash_card_feedback_bg", this.g, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.g.setGravity(17);
        this.g.setText("反馈");
        this.g.setTextColor(Color.parseColor("#99FFFFFF"));
        this.g.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.g);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.vk = relativeLayout4;
        relativeLayout4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387560);
        this.vk.setLayoutParams(layoutParams4);
        this.vk.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.uc.addView(this.vk);
        FrameLayout frameLayout = new FrameLayout(context);
        this.aj = frameLayout;
        frameLayout.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = er.hn(context, -42.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            this.aj.setElevation(er.hn(context, 3.0f));
        }
        this.aj.setLayoutParams(layoutParams5);
        this.vk.addView(this.aj);
        ImageView imageView2 = new ImageView(context);
        this.w = imageView2;
        imageView2.setId(2114387556);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(er.hn(context, 2.0f), er.hn(context, 2.0f), er.hn(context, 2.0f), er.hn(context, 2.0f));
        this.w.setLayoutParams(layoutParams6);
        this.aj.addView(this.w);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iHn = er.hn(context, 6.0f);
        gradientDrawable.setCornerRadius(iHn);
        gradientDrawable.setStroke(iHn / 3, -1);
        view.setBackground(gradientDrawable);
        this.aj.addView(view);
        TextView textView2 = new TextView(context);
        this.k = textView2;
        textView2.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387557);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = er.hn(context, 16.0f);
        this.k.setLayoutParams(layoutParams7);
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.k.setMaxLines(1);
        this.k.setTextColor(Color.parseColor("#161823"));
        this.k.setTextSize(2, 20.0f);
        this.vk.addView(this.k);
        TextView textView3 = new TextView(context);
        this.m = textView3;
        textView3.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387555);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(er.hn(context, 42.0f));
        layoutParams8.setMarginEnd(er.hn(context, 42.0f));
        layoutParams8.topMargin = er.hn(context, 8.0f);
        this.m.setLayoutParams(layoutParams8);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setGravity(1);
        this.m.setMaxLines(2);
        this.m.setTextColor(Color.parseColor("#90161823"));
        this.m.setTextSize(2, 14.0f);
        this.vk.addView(this.m);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.yb = relativeLayout5;
        relativeLayout5.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387554);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = er.hn(context, 36.0f);
        this.yb.setLayoutParams(layoutParams9);
        g.pr(this.pr, "tt_splash_card_btn_bg", this.yb, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.yb.setGravity(17);
        this.vk.addView(this.yb);
        TextView textView4 = new TextView(context);
        this.lb = textView4;
        textView4.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.lb.setLayoutParams(layoutParams10);
        this.lb.setEllipsize(TextUtils.TruncateAt.END);
        this.lb.setMaxLines(1);
        this.lb.setTextColor(Color.parseColor("#FFFFFF"));
        this.lb.setTextSize(2, 14.0f);
        this.lb.setTypeface(Typeface.defaultFromStyle(1));
        this.yb.addView(this.lb);
        TextView textView5 = new TextView(context);
        this.qa = textView5;
        textView5.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387552);
        layoutParams11.addRule(14);
        this.qa.setLayoutParams(layoutParams11);
        this.qa.setEllipsize(TextUtils.TruncateAt.END);
        this.qa.setMaxLines(1);
        this.qa.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.qa.setTextSize(2, 11.0f);
        this.yb.addView(this.qa);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.a = relativeLayout6;
        relativeLayout6.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387554);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = er.hn(context, 36.0f);
        this.a.setLayoutParams(layoutParams12);
        g.pr(this.pr, "tt_splash_card_btn_bg", this.a, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.a.setVisibility(8);
        this.vk.addView(this.a);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.a.addView(relativeLayout7);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(2114387549);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        g.pr(this.pr, "tt_splash_card_shake", (View) imageView3, 160);
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.cz = textView6;
        textView6.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = er.hn(context, 8.0f);
        layoutParams15.addRule(1, 2114387549);
        layoutParams15.addRule(15);
        this.cz.setLayoutParams(layoutParams15);
        this.cz.setEllipsize(TextUtils.TruncateAt.END);
        this.cz.setTypeface(Typeface.defaultFromStyle(1));
        this.cz.setMaxLines(1);
        this.cz.setTextColor(Color.parseColor("#FFFFFF"));
        this.cz.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.cz);
        TextView textView7 = new TextView(context);
        this.ho = textView7;
        textView7.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(er.hn(context, 8.0f));
        layoutParams16.bottomMargin = er.hn(context, 8.0f);
        this.ho.setLayoutParams(layoutParams16);
        com.byazt.hb.x.pr(this.pr, 1, this.ho);
        this.vk.addView(this.ho);
        ImageView imageView4 = new ImageView(context);
        this.nt = imageView4;
        imageView4.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387562);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = er.hn(context, 48.0f);
        this.nt.setLayoutParams(layoutParams17);
        g.pr(this.pr, "tt_splash_card_close", this.nt, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(this.nt);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.fw = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387545);
        this.fw.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.fw);
        return relativeLayout;
    }

    @Override // com.byazt.jm.hn
    public void pr(Context context, ViewGroup viewGroup, of ofVar) {
        super.pr(context, viewGroup, ofVar);
        View viewPr = pr(this.pr);
        if (viewPr == null) {
            return;
        }
        this.hw.addView(viewPr);
        if (Build.VERSION.SDK_INT >= 21) {
            this.uc.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.jm.x.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), er.hn(a.getContext(), 18.0f));
                }
            });
            this.uc.setClipToOutline(true);
            this.fw.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.jm.x.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), er.hn(a.getContext(), 28.0f));
                }
            });
            this.fw.setClipToOutline(true);
            er.pr(this.ho, this.hn);
        }
        List<y> listDe = this.hn.de();
        if (listDe != null && listDe.size() > 0) {
            com.byazt.ub.hw.pr(listDe.get(0)).hn(2).pr(Bitmap.Config.ARGB_8888).pr(new rc<Bitmap>() { // from class: com.byazt.jm.x.3
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapPr;
                    Bitmap bitmapHn = ntVar.hn();
                    if (bitmapHn == null) {
                        return;
                    }
                    try {
                        if (bitmapHn.getConfig() == Bitmap.Config.RGB_565) {
                            bitmapHn = bitmapHn.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable th) {
                    }
                    if (Build.VERSION.SDK_INT < 17) {
                        bitmapPr = null;
                    } else {
                        bitmapPr = com.byazt.js.hw.pr(x.this.pr, bitmapHn, 10);
                    }
                    if (bitmapPr == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(x.this.pr.getResources(), bitmapPr);
                    com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.x.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (x.this.zo != null) {
                                x.this.zo.setBackground(bitmapDrawable);
                            }
                            if (x.this.fw != null) {
                                x.this.fw.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            }, 4);
        }
        com.byazt.ub.hw.pr(this.hn.mo()).pr(this.w);
        this.k.setText(hn());
        this.m.setText(x());
        this.g.setVisibility(this.hn.zz() ? 0 : 8);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.jm.x.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.this.c();
            }
        });
        this.lb.setText(gu.x(this.hn));
        this.qa.setText(gu.hn(this.hn));
        pr(this.hn);
    }

    private void pr(of ofVar) {
        if (ofVar == null || this.uc == null || gu.c(ofVar) != 1) {
            return;
        }
        er.pr((View) this.a, 0);
        er.pr((View) this.yb, 8);
        TextView textView = this.cz;
        if (textView != null) {
            textView.setText(gu.x(ofVar));
        }
        if (this.ny == null) {
            this.ny = new ny(a.getContext(), 1, com.byazt.sd.zo.nt().x());
        }
        this.ny.hw(this.hn.qz());
        this.ny.pr(this.hn.gv());
        this.ny.hw(this.hn.yd());
        this.ny.uc(this.hn.kl());
        this.ny.pr(ofVar.tm());
        this.ny.hn(ofVar.dj());
        this.ny.c(ofVar.gg());
        this.ny.pr(new ny.pr() { // from class: com.byazt.jm.x.5
            @Override // com.byazt.ca.ny.pr
            public void pr(int i) {
                if (x.this.fo != null && x.this.uc.isShown()) {
                    switch (i) {
                        case 1:
                            if (x.this.fo != null) {
                                if (x.this.fo instanceof com.byazt.az.pr) {
                                    ((com.byazt.yx.pr) ((com.byazt.az.pr) x.this.fo).pr(com.byazt.yx.pr.class)).pr();
                                }
                                x.this.fo.onClick(x.this.uc);
                            }
                            break;
                    }
                }
            }
        });
        this.ny.pr(this.hn != null ? this.hn.nl() : 0);
    }

    @Override // com.byazt.jm.hn
    public void pr(com.byazt.az.pr prVar) {
        if (prVar == null) {
            return;
        }
        this.fo = prVar;
        if (gu.fw(this.hn)) {
            this.uc.setOnClickListener(this);
            this.zo.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.vk.setOnClickListener(this);
        }
        this.yb.setOnClickListener(this);
    }

    @Override // com.byazt.jm.hn
    public void pr(com.byazt.gz.x xVar, aj.pr prVar) {
        super.pr(xVar, prVar);
        this.hw.post(new Runnable() { // from class: com.byazt.jm.x.6
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT < 19 || x.this.uc.isAttachedToWindow()) {
                    x.this.uc().run();
                } else {
                    x.this.hw.postDelayed(x.this.uc(), 20L);
                }
            }
        });
        if (this.x != null) {
            this.nt.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.jm.x.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.byazt.pj.pr.hw(x.this.hn, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e) {
                    }
                    x.this.x.hw();
                }
            });
        }
        gu.aj(this.hn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable uc() {
        return new Runnable() { // from class: com.byazt.jm.x.8
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.fw.getWidth() != 0 && x.this.fw.getHeight() != 0) {
                    float width = x.this.uc.getWidth() / x.this.fw.getWidth();
                    float height = x.this.uc.getHeight() / x.this.fw.getHeight();
                    if (Build.VERSION.SDK_INT >= 19) {
                        x.this.fw.animate().scaleX(width).scaleY(height).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.byazt.jm.x.8.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                x.this.fw.setVisibility(8);
                                x.this.uc.setVisibility(0);
                                x.this.aj.setScaleX(0.0f);
                                x.this.aj.setScaleY(0.0f);
                                x.this.aj.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                                x.this.k.setScaleX(0.0f);
                                x.this.k.setScaleY(0.0f);
                                x.this.k.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                                x.this.m.setScaleX(0.0f);
                                x.this.m.setScaleY(0.0f);
                                x.this.m.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                                x.this.yb.setScaleX(0.0f);
                                x.this.yb.setScaleY(0.0f);
                                x.this.yb.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                                if (x.this.x != null) {
                                    x.this.x.pr(gu.uc(x.this.hn));
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }
                        });
                    }
                }
            }
        };
    }

    @Override // com.byazt.jm.hn
    public String pr() {
        return "splash_card_show";
    }

    public String hn() {
        if (this.hn == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.hn.zj())) {
            return (this.hn.ho() == null || TextUtils.isEmpty(this.hn.ho().hn())) ? "" : this.hn.ho().hn();
        }
        return this.hn.zj();
    }

    public String x() {
        return (this.hn == null || TextUtils.isEmpty(this.hn.A_())) ? "" : this.hn.A_();
    }

    public void c() {
        if (this.x == null) {
            return;
        }
        if (this.c == null) {
            this.c = new com.byazt.pfl.hw(this.x.getActivity(), this.hn.ae(), "splash_ad", true, com.byazt.ub.hw.pr());
            com.byazt.pw.hn.pr(this.x.getActivity(), this.hn, (com.byazt.pfl.hw) this.c);
        }
        this.c.pr("splash_card");
        this.c.pr();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == 2114387553) {
            i = 0;
        } else if (view.getId() == 2114387561) {
            i = 1;
        } else if (view.getId() == 2114387556) {
            i = 2;
        } else if (view.getId() == 2114387555) {
            i = 3;
        } else if (view.getId() == 2114387554) {
            i = 4;
        } else {
            i = 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.byazt.pj.pr.hw(this.hn, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e) {
        }
        View.OnClickListener onClickListener = this.fo;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.byazt.jm.hn
    public void hw() {
        if (gu.zo(this.hn)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.byazt.pj.pr.hw(this.hn, "splash_ad", "splash_card_close", jSONObject);
                if (this.x != null) {
                    this.x.hw();
                }
            } catch (JSONException e) {
            }
        }
    }

    @Override // com.byazt.jm.hn
    public void pr(boolean z) {
        super.pr(z);
        if (this.x == null) {
            return;
        }
        if (z) {
            this.x.pr(-1L);
        } else {
            this.x.pr();
        }
        ny nyVar = this.ny;
        if (nyVar != null) {
            if (z) {
                nyVar.pr(this.hn != null ? this.hn.nl() : 0);
            } else {
                nyVar.hw(this.hn != null ? this.hn.nl() : 0);
            }
        }
    }
}
