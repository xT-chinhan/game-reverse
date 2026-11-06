package com.bytedance.sdk.openadsdk.core.component.splash;

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
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.ti;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class ah extends xr implements View.OnClickListener {
    private ImageView ab;
    private View ao;
    private b b;
    private RelativeLayout c;
    private RelativeLayout ch;
    private RelativeLayout h;
    private ImageView hi;
    protected com.bytedance.sdk.openadsdk.ao.xr.xr.ab ka;
    private TextView nw;
    private FrameLayout ny;
    private TextView qv;
    private View.OnClickListener re;
    private TextView sl;
    private RelativeLayout t;
    private TextView u;
    private TextView ub;
    private View x;
    private TextView y;
    private TextView zb;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xr
    public String ms() {
        return "splash_card_show";
    }

    ah() {
    }

    private View ms(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.c = relativeLayout2;
        relativeLayout2.setId(2114387568);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.c.setClipChildren(false);
        this.c.setVisibility(4);
        this.c.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.c);
        ImageView imageView = new ImageView(context);
        this.x = imageView;
        imageView.setId(2114387567);
        this.x.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.c.addView(this.x);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387566);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.c.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.u = textView;
        textView.setId(2114387565);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = ul.ah(context, 8.0f);
        layoutParams3.bottomMargin = ul.ah(context, 10.0f);
        layoutParams3.rightMargin = ul.ah(context, 4.0f);
        this.u.setLayoutParams(layoutParams3);
        t.ms(this.f2438ms, "tt_splash_card_feedback_bg", this.u);
        this.u.setGravity(17);
        this.u.setText(t.ms(this.f2438ms, "tt_feedback"));
        this.u.setTextColor(Color.parseColor("#99FFFFFF"));
        this.u.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.u);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.ch = relativeLayout4;
        relativeLayout4.setId(2114387564);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387566);
        this.ch.setLayoutParams(layoutParams4);
        this.ch.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.c.addView(this.ch);
        FrameLayout frameLayout = new FrameLayout(context);
        this.ny = frameLayout;
        frameLayout.setId(2114387563);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = ul.ah(context, -42.0f);
        this.ny.setElevation(ul.ah(context, 3.0f));
        this.ny.setLayoutParams(layoutParams5);
        this.ch.addView(this.ny);
        ImageView imageView2 = new ImageView(context);
        this.hi = imageView2;
        imageView2.setId(2114387562);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(ul.ah(context, 2.0f), ul.ah(context, 2.0f), ul.ah(context, 2.0f), ul.ah(context, 2.0f));
        this.hi.setLayoutParams(layoutParams6);
        this.ny.addView(this.hi);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iAh = ul.ah(context, 6.0f);
        gradientDrawable.setCornerRadius(iAh);
        gradientDrawable.setStroke(iAh / 3, -1);
        view.setBackground(gradientDrawable);
        this.ny.addView(view);
        TextView textView2 = new TextView(context);
        this.sl = textView2;
        textView2.setId(2114387561);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387563);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = ul.ah(context, 16.0f);
        this.sl.setLayoutParams(layoutParams7);
        this.sl.setEllipsize(TextUtils.TruncateAt.END);
        this.sl.setMaxLines(1);
        this.sl.setTextColor(Color.parseColor("#161823"));
        this.sl.setTextSize(2, 20.0f);
        this.ch.addView(this.sl);
        TextView textView3 = new TextView(context);
        this.zb = textView3;
        textView3.setId(2114387560);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387561);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(ul.ah(context, 42.0f));
        layoutParams8.setMarginEnd(ul.ah(context, 42.0f));
        layoutParams8.topMargin = ul.ah(context, 8.0f);
        this.zb.setLayoutParams(layoutParams8);
        this.zb.setEllipsize(TextUtils.TruncateAt.END);
        this.zb.setGravity(1);
        this.zb.setMaxLines(2);
        this.zb.setTextColor(Color.parseColor("#90161823"));
        this.zb.setTextSize(2, 14.0f);
        this.ch.addView(this.zb);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.h = relativeLayout5;
        relativeLayout5.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387560);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = ul.ah(context, 36.0f);
        this.h.setLayoutParams(layoutParams9);
        t.ms(this.f2438ms, "tt_splash_card_btn_bg", this.h);
        this.h.setGravity(17);
        this.ch.addView(this.h);
        TextView textView4 = new TextView(context);
        this.qv = textView4;
        textView4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.qv.setLayoutParams(layoutParams10);
        this.qv.setEllipsize(TextUtils.TruncateAt.END);
        this.qv.setMaxLines(1);
        this.qv.setTextColor(Color.parseColor("#FFFFFF"));
        this.qv.setTextSize(2, 14.0f);
        this.qv.setTypeface(Typeface.defaultFromStyle(1));
        this.h.addView(this.qv);
        TextView textView5 = new TextView(context);
        this.y = textView5;
        textView5.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387558);
        layoutParams11.addRule(14);
        this.y.setLayoutParams(layoutParams11);
        this.y.setEllipsize(TextUtils.TruncateAt.END);
        this.y.setMaxLines(1);
        this.y.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.y.setTextSize(2, 11.0f);
        this.h.addView(this.y);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.t = relativeLayout6;
        relativeLayout6.setId(2114387556);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387560);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = ul.ah(context, 36.0f);
        this.t.setLayoutParams(layoutParams12);
        t.ms(this.f2438ms, "tt_splash_card_btn_bg", this.t);
        this.t.setVisibility(8);
        this.ch.addView(this.t);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.t.addView(relativeLayout7);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        t.ms(this.f2438ms, "tt_splash_card_shake", (View) imageView3);
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.nw = textView6;
        textView6.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = ul.ah(context, 8.0f);
        layoutParams15.addRule(1, 2114387555);
        layoutParams15.addRule(15);
        this.nw.setLayoutParams(layoutParams15);
        this.nw.setEllipsize(TextUtils.TruncateAt.END);
        this.nw.setTypeface(Typeface.defaultFromStyle(1));
        this.nw.setMaxLines(1);
        this.nw.setTextColor(Color.parseColor("#FFFFFF"));
        this.nw.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.nw);
        TextView textView7 = new TextView(context);
        this.ub = textView7;
        textView7.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(ul.ah(context, 8.0f));
        layoutParams16.bottomMargin = ul.ah(context, 8.0f);
        this.ub.setLayoutParams(layoutParams16);
        t.ms(this.f2438ms, "tt_ad_logo_new", this.ub);
        this.ch.addView(this.ub);
        ImageView imageView4 = new ImageView(context);
        this.ao = imageView4;
        imageView4.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387568);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = ul.ah(context, 48.0f);
        this.ao.setLayoutParams(layoutParams17);
        t.ms(this.f2438ms, "tt_splash_card_close", this.ao);
        relativeLayout.addView(this.ao);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.ab = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387551);
        this.ab.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ab.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.ab);
        return relativeLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xr
    public void ms(Context context, ViewGroup viewGroup, lm lmVar) {
        super.ms(context, viewGroup, lmVar);
        View viewMs = ms(this.f2438ms);
        if (viewMs == null) {
            return;
        }
        this.xr.addView(viewMs);
        this.c.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ul.ah(re.getContext(), 18.0f));
            }
        });
        this.c.setClipToOutline(true);
        this.ab.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ul.ah(re.getContext(), 28.0f));
            }
        });
        this.ab.setClipToOutline(true);
        ul.ms(this.ub, this.ah);
        List<g> listFk = this.ah.fk();
        if (listFk != null && listFk.size() > 0) {
            com.bytedance.sdk.openadsdk.x.xr.ms(listFk.get(0)).ah(2).ms(Bitmap.Config.ARGB_8888).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.3
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    Bitmap bitmapAh = hiVar.ah();
                    if (bitmapAh == null) {
                        return;
                    }
                    try {
                        if (bitmapAh.getConfig() == Bitmap.Config.RGB_565) {
                            bitmapAh = bitmapAh.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(ah.this.f2438ms, bitmapAh, 10);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(ah.this.f2438ms.getResources(), bitmapMs);
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ah.this.x != null) {
                                ah.this.x.setBackground(bitmapDrawable);
                            }
                            if (ah.this.ab != null) {
                                ah.this.ab.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(this.ah.qd()).ms(this.hi);
        this.sl.setText(ah());
        this.zb.setText(d());
        this.u.setVisibility(this.ah.rk() ? 0 : 8);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ah.this.ka();
            }
        });
        this.qv.setText(ti.d(this.ah));
        this.y.setText(ti.ah(this.ah));
        ms(this.ah);
    }

    private void ms(lm lmVar) {
        if (lmVar == null || this.c == null || ti.ka(lmVar) != 1) {
            return;
        }
        ul.ms((View) this.t, 0);
        ul.ms((View) this.h, 8);
        TextView textView = this.nw;
        if (textView != null) {
            textView.setText(ti.d(lmVar));
        }
        if (this.b == null) {
            this.b = new b(re.getContext(), 1, ch.ub().ka());
        }
        this.b.xr(this.ah.ia());
        this.b.ms(this.ah.ax());
        this.b.xr(this.ah.rg());
        this.b.c(this.ah.ec());
        this.b.ms(lmVar.on());
        this.b.ah(lmVar.wr());
        this.b.ka(lmVar.n());
        this.b.ms(new b.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.5
            @Override // com.bytedance.sdk.component.utils.b.ms
            public void ms(int i) {
                if (ah.this.re == null || !ah.this.c.isShown() || i != 1 || ah.this.re == null) {
                    return;
                }
                if (ah.this.re instanceof com.bytedance.sdk.openadsdk.core.xr.ms) {
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ((com.bytedance.sdk.openadsdk.core.xr.ms) ah.this.re).ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms();
                }
                ah.this.re.onClick(ah.this.c);
            }
        });
        this.b.ms(this.ah != null ? this.ah.ka() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xr
    public void ms(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        if (msVar == null) {
            return;
        }
        this.re = msVar;
        if (ti.ab(this.ah)) {
            this.c.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.hi.setOnClickListener(this);
            this.sl.setOnClickListener(this);
            this.zb.setOnClickListener(this);
            this.ch.setOnClickListener(this);
        }
        this.h.setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xr
    public void ms(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, ab.ms msVar) {
        super.ms(dVar, msVar);
        this.xr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.6
            @Override // java.lang.Runnable
            public void run() {
                if (!ah.this.c.isAttachedToWindow()) {
                    ah.this.xr.postDelayed(ah.this.c(), 20L);
                } else {
                    ah.this.c().run();
                }
            }
        });
        if (this.d != null) {
            this.ao.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.bytedance.sdk.openadsdk.core.zb.ah.xr(ah.this.ah, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                    ah.this.d.xr();
                }
            });
        }
        ti.ms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable c() {
        return new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.8
            @Override // java.lang.Runnable
            public void run() {
                if (ah.this.ab.getWidth() == 0 || ah.this.ab.getHeight() == 0) {
                    return;
                }
                ah.this.ab.animate().scaleX(ah.this.c.getWidth() / ah.this.ab.getWidth()).scaleY(ah.this.c.getHeight() / ah.this.ab.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.8.1
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
                        ah.this.ab.setVisibility(8);
                        ah.this.c.setVisibility(0);
                        ah.this.ny.setScaleX(0.0f);
                        ah.this.ny.setScaleY(0.0f);
                        ah.this.ny.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        ah.this.sl.setScaleX(0.0f);
                        ah.this.sl.setScaleY(0.0f);
                        ah.this.sl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        ah.this.zb.setScaleX(0.0f);
                        ah.this.zb.setScaleY(0.0f);
                        ah.this.zb.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        ah.this.h.setScaleX(0.0f);
                        ah.this.h.setScaleY(0.0f);
                        ah.this.h.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        if (ah.this.d != null) {
                            ah.this.d.ms(ti.c(ah.this.ah));
                        }
                    }
                });
            }
        };
    }

    protected String ah() {
        if (this.ah == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.ah.nq())) {
            return (this.ah.zh() == null || TextUtils.isEmpty(this.ah.zh().ah())) ? "" : this.ah.zh().ah();
        }
        return this.ah.nq();
    }

    protected String d() {
        return (this.ah == null || TextUtils.isEmpty(this.ah.eh())) ? "" : this.ah.eh();
    }

    public void ka() {
        if (this.d == null) {
            return;
        }
        if (this.ka == null) {
            this.ka = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(this.d.getActivity(), this.ah.ca(), "splash_ad", true);
            com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.d.getActivity(), (com.bytedance.sdk.openadsdk.core.dislike.ui.ms) this.ka, this.ah);
        }
        this.ka.ms("splash_card");
        this.ka.ms();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == 2114387559) {
            i = 0;
        } else if (view.getId() == 2114387567) {
            i = 1;
        } else if (view.getId() == 2114387562) {
            i = 2;
        } else if (view.getId() == 2114387561) {
            i = 3;
        } else {
            i = view.getId() == 2114387560 ? 4 : 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e) {
            sl.ms(e);
        }
        View.OnClickListener onClickListener = this.re;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xr
    public void xr() {
        if (ti.x(this.ah)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, "splash_ad", "splash_card_close", jSONObject);
                if (this.d != null) {
                    this.d.xr();
                }
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xr
    public void ms(boolean z) {
        super.ms(z);
        if (this.d == null) {
            return;
        }
        if (z) {
            this.d.ms(-1L);
        } else {
            this.d.ms();
        }
        b bVar = this.b;
        if (bVar != null) {
            if (z) {
                bVar.ms(this.ah != null ? this.ah.ka() : 0);
            } else {
                bVar.xr(this.ah != null ? this.ah.ka() : 0);
            }
        }
    }
}
