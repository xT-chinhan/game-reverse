package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SplashEndCardView extends BaseEndCardView {
    protected String e;
    RoundImageView f;
    TextView g;
    TextView h;
    CTAButtonLayout i;
    TextView j;
    BaseShakeView k;
    ImageView l;
    private View m;
    private long n;
    private final View.OnClickListener o;

    @Override // com.anythink.basead.ui.BaseEndCardView
    protected final void a() {
    }

    public SplashEndCardView(Context context, w wVar, x xVar) {
        View viewFindViewById;
        super(context, wVar, xVar);
        this.e = "Skip";
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.anythink.basead.ui.SplashEndCardView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SplashEndCardView.this.d != null) {
                    if (SplashEndCardView.this.d.H() == 0) {
                        if (SplashEndCardView.this.mListener != null) {
                            SplashEndCardView.this.mListener.a(22);
                        }
                    } else {
                        if (SplashEndCardView.this.i == null || view != SplashEndCardView.this.i || SplashEndCardView.this.mListener == null) {
                            return;
                        }
                        SplashEndCardView.this.mListener.a(22);
                    }
                }
            }
        };
        this.o = onClickListener;
        this.e = getResources().getString(q.a(getContext(), "myoffer_splash_skip_text", "string"));
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_endcard", "layout"), (ViewGroup) this, true);
        this.m = viewInflate;
        this.f = (RoundImageView) viewInflate.findViewById(q.a(getContext(), "myoffer_splash_endcard_icon", "id"));
        this.i = (CTAButtonLayout) this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_cta", "id"));
        this.g = (TextView) this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_title", "id"));
        this.h = (TextView) this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_desc", "id"));
        this.j = (TextView) this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_count_down_text", "id"));
        this.k = (BaseShakeView) this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_shake_hint_text", "id"));
        this.l = (ImageView) this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_top_bg", "id"));
        if (!this.b.c()) {
            setOnClickListener(onClickListener);
        }
        RoundImageView roundImageView = this.f;
        if (roundImageView != null) {
            roundImageView.setNeedRadiu(true);
            this.f.setRadiusInDip(12);
        }
        if (this.i != null && !this.b.c()) {
            this.i.setOnClickListener(onClickListener);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(q.a(getContext(), 12.0f));
        setBackground(gradientDrawable);
        if (this.j != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(Integer.MIN_VALUE);
            gradientDrawable2.setCornerRadius(q.a(getContext(), 12.0f));
            this.j.setBackground(gradientDrawable2);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.SplashEndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (SplashEndCardView.this.mListener instanceof BaseEndCardView.b) {
                        ((BaseEndCardView.b) SplashEndCardView.this.mListener).b();
                    }
                }
            });
        }
        if (TextUtils.isEmpty(this.b.x()) && TextUtils.isEmpty(this.b.y()) && (viewFindViewById = this.m.findViewById(q.a(getContext(), "myoffer_splash_endcard_header_container", "id"))) != null) {
            viewFindViewById.getLayoutParams().height = q.a(getContext(), 240.0f);
        }
        String strA = g.a().a(com.anythink.core.common.a.b.d.e);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.SplashEndCardView.3
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, Bitmap bitmap) {
                if (bitmap != null) {
                    SplashEndCardView.this.l.setImageBitmap(bitmap);
                }
            }
        });
    }

    public void init(BaseEndCardView.a aVar, long j) {
        this.mListener = aVar;
        final String strZ = this.b.z();
        if (TextUtils.isEmpty(strZ)) {
            strZ = this.b.B();
        }
        int iA = q.a(getContext(), 60.0f);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, strZ), iA, iA, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.SplashEndCardView.4
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, Bitmap bitmap) {
                if (TextUtils.equals(str, strZ)) {
                    SplashEndCardView.this.f.setImageBitmap(bitmap);
                }
            }
        });
        CTAButtonLayout cTAButtonLayout = this.i;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(this.b, this.c, true, new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.SplashEndCardView.5
                @Override // com.anythink.basead.ui.f.b.a
                public final void a(int i, int i2) {
                    if (SplashEndCardView.this.mListener != null) {
                        SplashEndCardView.this.mListener.a(i2);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.b.x())) {
            this.g.setVisibility(0);
            this.g.setText(this.b.x());
        } else {
            this.g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.b.y())) {
            this.h.setVisibility(0);
            this.h.setText(this.b.y());
        } else {
            this.h.setVisibility(8);
        }
        if (com.anythink.basead.b.e.a(this.c)) {
            this.k.setVisibility(0);
            this.k.setShakeSetting(this.c.o, this.b.K());
            if (this.d.H() != 1 && !this.b.c()) {
                this.k.setOnClickListener(this.o);
            }
            this.k.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.SplashEndCardView.6
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    if (!com.anythink.basead.ui.f.b.a(SplashEndCardView.this.n, SplashEndCardView.this.c) || SplashEndCardView.this.mListener == null) {
                        return false;
                    }
                    SplashEndCardView.this.mListener.a(9);
                    return true;
                }
            }, this.d);
        } else {
            this.k.setVisibility(8);
        }
        this.n = j;
    }

    public void onCountDownTick(long j) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText((j / 1000) + "s | " + this.e);
        }
    }
}
