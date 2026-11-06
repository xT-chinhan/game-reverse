package com.anythink.basead.b.d;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.core.common.a.b;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    CTAButtonLayout a;
    ImageView b;
    View c;
    View d;
    Context e;
    ValueAnimator f;
    boolean g;
    boolean h;
    int i;
    int j;

    public a(final Context context) {
        this.e = context;
        this.c = LayoutInflater.from(context).inflate(q.a(context, "myoffer_letter_top_layout", "layout"), (ViewGroup) null);
        View view = new View(context);
        this.d = view;
        view.setBackgroundResource(q.a(context, "myoffer_letter_bottom", "drawable"));
        this.a = (CTAButtonLayout) this.c.findViewById(q.a(context, "myoffer_panel_cta_layout", "id"));
        this.b = (ImageView) this.c.findViewById(q.a(context, "myoffer_letter_icon", "id"));
        String strA = g.a().a(b.d.c);
        String strA2 = g.a().a(b.d.d);
        if (!TextUtils.isEmpty(strA)) {
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.b.d.a.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    View viewFindViewById;
                    if (a.this.c == null || context == null || (viewFindViewById = a.this.c.findViewById(q.a(context, "myoffer_letter_top", "id"))) == null) {
                        return;
                    }
                    viewFindViewById.setBackground(new BitmapDrawable(context.getResources(), bitmap));
                }
            });
        }
        if (TextUtils.isEmpty(strA2)) {
            return;
        }
        com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA2), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.b.d.a.2
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, Bitmap bitmap) {
                if (a.this.b == null || context == null) {
                    return;
                }
                a.this.b.setImageBitmap(bitmap);
            }
        });
    }

    public final void a(RelativeLayout relativeLayout, int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, i);
        this.c.setLayoutParams(layoutParams);
        relativeLayout.addView(this.c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(8, this.c.getId());
        layoutParams2.addRule(5, this.c.getId());
        layoutParams2.addRule(7, this.c.getId());
        relativeLayout.addView(this.d, 0, layoutParams2);
    }

    public final void a(w wVar, x xVar, final com.anythink.basead.ui.f.b.a aVar) {
        if (!TextUtils.isEmpty(wVar.H())) {
            this.a.initSetting(wVar, xVar, false, new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.b.d.a.3
                @Override // com.anythink.basead.ui.f.b.a
                public final void a(int i, int i2) {
                    com.anythink.basead.ui.f.b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(i, i2);
                    }
                }
            });
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.b.d.a.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.anythink.basead.ui.f.b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(1, 1);
                    }
                }
            });
            this.b.setVisibility(8);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
        }
        new com.anythink.basead.ui.f.a(wVar, xVar).b(this.c);
    }

    public final void a(int i) {
        this.i = (i * 111) / 300;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = this.i;
        this.c.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = (layoutParams.height * 200) / 111;
        this.d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams3.height = (layoutParams.height * 48) / TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_TOAST;
        layoutParams3.bottomMargin = (this.i / TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA) * 35;
        ((RelativeLayout.LayoutParams) this.b.getLayoutParams()).bottomMargin = (this.i / TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA) * 35;
        this.j = this.i / 3;
    }

    public final void a(final View view) {
        if (this.g || this.h) {
            return;
        }
        this.g = true;
        view.postDelayed(new Runnable() { // from class: com.anythink.basead.b.d.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.f = ValueAnimator.ofFloat(0.0f, 720.0f);
                a.this.f.setDuration(com.anythink.basead.exoplayer.i.a.f);
                a.this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.b.d.a.5.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view.setTranslationY(-((float) (((double) a.this.j) * Math.sin(Math.toRadians(((Float) valueAnimator.getAnimatedValue()).floatValue())) * Math.pow(((valueAnimator.getDuration() * 2) - valueAnimator.getCurrentPlayTime()) / (valueAnimator.getDuration() * 2.0f), 2.0d))));
                    }
                });
                if (a.this.f.isStarted()) {
                    return;
                }
                a.this.f.start();
            }
        }, com.anythink.basead.exoplayer.i.a.f);
    }

    public final int a() {
        return this.i;
    }

    public final int b() {
        return this.j;
    }

    public final void c() {
        this.h = true;
        try {
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f.cancel();
        } catch (Throwable unused) {
        }
    }

    public final View d() {
        return this.a;
    }
}
