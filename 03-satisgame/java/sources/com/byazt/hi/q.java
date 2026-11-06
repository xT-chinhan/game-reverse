package com.byazt.hi;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
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
import com.byazt.gct.dn;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.ou;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 5})
public class q extends s implements View.OnClickListener {
    public RelativeLayout a;
    public TextView cd;
    public ImageView cp;
    public View cy;
    public TextView d;
    public View fs;
    public RelativeLayout hd;
    public TextView k;
    public com.byazt.fvm.x l;
    public TextView oa;
    public ou ou;
    public TextView py;
    public FrameLayout rv;
    public TextView sz;
    public RelativeLayout tj;
    public TextView um;
    public RelativeLayout w;
    public View.OnClickListener wm;
    public ImageView x;

    @Override // com.byazt.hi.s
    public String n() {
        return "splash_card_show";
    }

    private View n(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.w = relativeLayout2;
        relativeLayout2.setId(2114387562);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.w.setClipChildren(false);
        this.w.setVisibility(4);
        this.w.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.w);
        ImageView imageView = new ImageView(context);
        this.fs = imageView;
        imageView.setId(2114387561);
        this.fs.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.w.addView(this.fs);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387560);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.w.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.sz = textView;
        textView.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = com.byazt.okk.s.s(context, 8.0f);
        layoutParams3.bottomMargin = com.byazt.okk.s.s(context, 10.0f);
        layoutParams3.rightMargin = com.byazt.okk.s.s(context, 4.0f);
        this.sz.setLayoutParams(layoutParams3);
        sz.n(this.n, "tt_splash_card_feedback_bg", this.sz, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.sz.setGravity(17);
        this.sz.setText("反馈");
        this.sz.setTextColor(Color.parseColor("#99FFFFFF"));
        this.sz.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.sz);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.tj = relativeLayout4;
        relativeLayout4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387560);
        this.tj.setLayoutParams(layoutParams4);
        this.tj.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.w.addView(this.tj);
        FrameLayout frameLayout = new FrameLayout(context);
        this.rv = frameLayout;
        frameLayout.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = com.byazt.okk.s.s(context, -42.0f);
        this.rv.setElevation(com.byazt.okk.s.s(context, 3.0f));
        this.rv.setLayoutParams(layoutParams5);
        this.tj.addView(this.rv);
        ImageView imageView2 = new ImageView(context);
        this.cp = imageView2;
        imageView2.setId(2114387556);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(com.byazt.okk.s.s(context, 2.0f), com.byazt.okk.s.s(context, 2.0f), com.byazt.okk.s.s(context, 2.0f), com.byazt.okk.s.s(context, 2.0f));
        this.cp.setLayoutParams(layoutParams6);
        this.rv.addView(this.cp);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iS = com.byazt.okk.s.s(context, 6.0f);
        gradientDrawable.setCornerRadius(iS);
        gradientDrawable.setStroke(iS / 3, -1);
        view.setBackground(gradientDrawable);
        this.rv.addView(view);
        TextView textView2 = new TextView(context);
        this.d = textView2;
        textView2.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387557);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = com.byazt.okk.s.s(context, 16.0f);
        this.d.setLayoutParams(layoutParams7);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setMaxLines(1);
        this.d.setTextColor(Color.parseColor("#161823"));
        this.d.setTextSize(2, 20.0f);
        this.tj.addView(this.d);
        TextView textView3 = new TextView(context);
        this.oa = textView3;
        textView3.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387555);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(com.byazt.okk.s.s(context, 42.0f));
        layoutParams8.setMarginEnd(com.byazt.okk.s.s(context, 42.0f));
        layoutParams8.topMargin = com.byazt.okk.s.s(context, 8.0f);
        this.oa.setLayoutParams(layoutParams8);
        this.oa.setEllipsize(TextUtils.TruncateAt.END);
        this.oa.setGravity(1);
        this.oa.setMaxLines(2);
        this.oa.setTextColor(Color.parseColor("#90161823"));
        this.oa.setTextSize(2, 14.0f);
        this.tj.addView(this.oa);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.hd = relativeLayout5;
        relativeLayout5.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387554);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = com.byazt.okk.s.s(context, 36.0f);
        this.hd.setLayoutParams(layoutParams9);
        sz.n(this.n, "tt_splash_card_btn_bg", this.hd, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.hd.setGravity(17);
        this.tj.addView(this.hd);
        TextView textView4 = new TextView(context);
        this.cd = textView4;
        textView4.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.cd.setLayoutParams(layoutParams10);
        this.cd.setEllipsize(TextUtils.TruncateAt.END);
        this.cd.setMaxLines(1);
        this.cd.setTextColor(Color.parseColor("#FFFFFF"));
        this.cd.setTextSize(2, 14.0f);
        this.cd.setTypeface(Typeface.defaultFromStyle(1));
        this.hd.addView(this.cd);
        TextView textView5 = new TextView(context);
        this.um = textView5;
        textView5.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387552);
        layoutParams11.addRule(14);
        this.um.setLayoutParams(layoutParams11);
        this.um.setEllipsize(TextUtils.TruncateAt.END);
        this.um.setMaxLines(1);
        this.um.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.um.setTextSize(2, 11.0f);
        this.hd.addView(this.um);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.a = relativeLayout6;
        relativeLayout6.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387554);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = com.byazt.okk.s.s(context, 36.0f);
        this.a.setLayoutParams(layoutParams12);
        sz.n(this.n, "tt_splash_card_btn_bg", this.a, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.a.setVisibility(8);
        this.tj.addView(this.a);
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
        sz.n(this.n, "tt_splash_card_shake", (View) imageView3, 160);
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.py = textView6;
        textView6.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = com.byazt.okk.s.s(context, 8.0f);
        layoutParams15.addRule(1, 2114387549);
        layoutParams15.addRule(15);
        this.py.setLayoutParams(layoutParams15);
        this.py.setEllipsize(TextUtils.TruncateAt.END);
        this.py.setTypeface(Typeface.defaultFromStyle(1));
        this.py.setMaxLines(1);
        this.py.setTextColor(Color.parseColor("#FFFFFF"));
        this.py.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.py);
        TextView textView7 = new TextView(context);
        this.k = textView7;
        textView7.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(com.byazt.okk.s.s(context, 8.0f));
        layoutParams16.bottomMargin = com.byazt.okk.s.s(context, 8.0f);
        this.k.setLayoutParams(layoutParams16);
        com.byazt.iu.qg.n(this.n, 1, this.k);
        this.tj.addView(this.k);
        ImageView imageView4 = new ImageView(context);
        this.cy = imageView4;
        imageView4.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387562);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = com.byazt.okk.s.s(context, 48.0f);
        this.cy.setLayoutParams(layoutParams17);
        sz.n(this.n, "tt_splash_card_close", this.cy, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(this.cy);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.x = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387545);
        this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.x.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.x);
        return relativeLayout;
    }

    @Override // com.byazt.hi.s
    public void n(Context context, ViewGroup viewGroup, pk pkVar) {
        super.n(context, viewGroup, pkVar);
        View viewN = n(this.n);
        if (viewN == null) {
            return;
        }
        this.qg.addView(viewN);
        this.w.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.hi.q.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), 18.0f));
            }
        });
        this.w.setClipToOutline(true);
        this.x.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.hi.q.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), 28.0f));
            }
        });
        this.x.setClipToOutline(true);
        com.byazt.okk.s.n(this.k, this.s);
        List<v> listJo = this.s.jo();
        if (listJo != null && listJo.size() > 0) {
            com.byazt.imu.s.n(listJo.get(0)).s(2).n(Bitmap.Config.ARGB_8888).n(new m<Bitmap>() { // from class: com.byazt.hi.q.3
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    Bitmap bitmapS = cyVar.s();
                    if (bitmapS == null) {
                        return;
                    }
                    try {
                        if (bitmapS.getConfig() == Bitmap.Config.RGB_565) {
                            bitmapS = bitmapS.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap bitmapN = com.byazt.cq.qg.n(q.this.n, bitmapS, 10);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(q.this.n.getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.q.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (q.this.fs != null) {
                                q.this.fs.setBackground(bitmapDrawable);
                            }
                            if (q.this.x != null) {
                                q.this.x.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
        com.byazt.imu.s.n(this.s.xu()).n(this.cp);
        this.d.setText(s());
        this.oa.setText(q());
        this.sz.setVisibility(this.s.yv() ? 0 : 8);
        this.sz.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.hi.q.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.l();
            }
        });
        this.cd.setText(dn.q(this.s));
        this.um.setText(dn.s(this.s));
        n(this.s);
    }

    private void n(pk pkVar) {
        if (pkVar == null || this.w == null || dn.l(pkVar) != 1) {
            return;
        }
        com.byazt.okk.s.n((View) this.a, 0);
        com.byazt.okk.s.n((View) this.hd, 8);
        TextView textView = this.py;
        if (textView != null) {
            textView.setText(dn.q(pkVar));
        }
        if (this.ou == null) {
            this.ou = new ou(com.byazt.nf.rv.getContext(), 1, com.byazt.vyf.s.cy().q());
        }
        this.ou.qg(this.s.eu());
        this.ou.n(this.s.kv());
        this.ou.qg(this.s.bs());
        this.ou.w(this.s.on());
        this.ou.n(pkVar.mp());
        this.ou.s(pkVar.rk());
        this.ou.l(pkVar.qd());
        this.ou.n(new ou.n() { // from class: com.byazt.hi.q.5
            @Override // com.byazt.tk.ou.n
            public void n(int i) {
                if (q.this.wm == null || !q.this.w.isShown() || i != 1 || q.this.wm == null) {
                    return;
                }
                if (q.this.wm instanceof com.byazt.ys.n) {
                    ((com.byazt.fq.n) ((com.byazt.ys.n) q.this.wm).n(com.byazt.fq.n.class)).n();
                }
                q.this.wm.onClick(q.this.w);
            }
        });
        this.ou.n(this.s != null ? this.s.v() : 0);
    }

    @Override // com.byazt.hi.s
    public void n(com.byazt.ys.n nVar) {
        if (nVar == null) {
            return;
        }
        this.wm = nVar;
        if (dn.x(this.s)) {
            this.w.setOnClickListener(this);
            this.fs.setOnClickListener(this);
            this.cp.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.oa.setOnClickListener(this);
            this.tj.setOnClickListener(this);
        }
        this.hd.setOnClickListener(this);
    }

    @Override // com.byazt.hi.s
    public void n(com.byazt.ia.q qVar, tj.n nVar) {
        super.n(qVar, nVar);
        this.qg.post(new Runnable() { // from class: com.byazt.hi.q.6
            @Override // java.lang.Runnable
            public void run() {
                if (!q.this.w.isAttachedToWindow()) {
                    q.this.qg.postDelayed(q.this.w(), 20L);
                } else {
                    q.this.w().run();
                }
            }
        });
        if (this.q != null) {
            this.cy.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.hi.q.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.byazt.hm.n.qg(q.this.s, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException unused) {
                    }
                    q.this.q.qg();
                }
            });
        }
        dn.rv(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable w() {
        return new Runnable() { // from class: com.byazt.hi.q.8
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.x.getWidth() == 0 || q.this.x.getHeight() == 0) {
                    return;
                }
                q.this.x.animate().scaleX(q.this.w.getWidth() / q.this.x.getWidth()).scaleY(q.this.w.getHeight() / q.this.x.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.byazt.hi.q.8.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        q.this.x.setVisibility(8);
                        q.this.w.setVisibility(0);
                        q.this.rv.setScaleX(0.0f);
                        q.this.rv.setScaleY(0.0f);
                        q.this.rv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        q.this.d.setScaleX(0.0f);
                        q.this.d.setScaleY(0.0f);
                        q.this.d.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        q.this.oa.setScaleX(0.0f);
                        q.this.oa.setScaleY(0.0f);
                        q.this.oa.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        q.this.hd.setScaleX(0.0f);
                        q.this.hd.setScaleY(0.0f);
                        q.this.hd.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        if (q.this.q != null) {
                            q.this.q.n(dn.w(q.this.s));
                        }
                    }
                });
            }
        };
    }

    public String s() {
        if (this.s == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.s.yr())) {
            return (this.s.k() == null || TextUtils.isEmpty(this.s.k().s())) ? "" : this.s.k().s();
        }
        return this.s.yr();
    }

    public String q() {
        return (this.s == null || TextUtils.isEmpty(this.s.E_())) ? "" : this.s.E_();
    }

    public void l() {
        if (this.q == null) {
            return;
        }
        if (this.l == null) {
            this.l = new com.byazt.wg.qg(this.q.getActivity(), this.s.pt(), "splash_ad", true, com.byazt.imu.s.n());
            com.byazt.yo.s.n(this.q.getActivity(), this.s, (com.byazt.wg.qg) this.l);
        }
        this.l.n("splash_card");
        this.l.n();
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
        } else {
            i = view.getId() == 2114387554 ? 4 : 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.byazt.hm.n.qg(this.s, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException unused) {
        }
        View.OnClickListener onClickListener = this.wm;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.byazt.hi.s
    public void qg() {
        if (dn.fs(this.s)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.byazt.hm.n.qg(this.s, "splash_ad", "splash_card_close", jSONObject);
                if (this.q != null) {
                    this.q.qg();
                }
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.byazt.hi.s
    public void n(boolean z) {
        super.n(z);
        if (this.q == null) {
            return;
        }
        if (z) {
            this.q.n(-1L);
        } else {
            this.q.n();
        }
        ou ouVar = this.ou;
        if (ouVar != null) {
            if (z) {
                ouVar.n(this.s != null ? this.s.v() : 0);
            } else {
                ouVar.qg(this.s != null ? this.s.v() : 0);
            }
        }
    }
}
