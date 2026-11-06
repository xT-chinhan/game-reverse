package com.anythink.basead.ui.component.emdcardimprove;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.ScanningAnimButton;
import com.anythink.basead.ui.f.b;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SecondEndCardView extends RelativeLayout {
    RelativeLayout a;
    RoundImageView b;
    ImageView c;
    TextView d;
    TextView e;
    ScanningAnimButton f;
    b.a g;
    ObjectAnimator h;

    public SecondEndCardView(Context context) {
        this(context, null);
    }

    public SecondEndCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SecondEndCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    protected void a() {
        LayoutInflater.from(getContext()).inflate(c(), this);
        this.a = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_second_ec_container", "id"));
        this.b = (RoundImageView) findViewById(q.a(getContext(), "myoffer_second_ec_ad_icon", "id"));
        this.c = (ImageView) findViewById(q.a(getContext(), "myoffer_second_ec_ad_poster", "id"));
        if (m.f(getContext()) == 2) {
            this.b.setRadiusInDip(18);
        } else {
            this.b.setRadiusInDip(24);
        }
        this.b.setNeedRadiu(true);
        this.d = (TextView) findViewById(q.a(getContext(), "myoffer_second_ec_ad_title", "id"));
        this.e = (TextView) findViewById(q.a(getContext(), "myoffer_second_ec_ad_desc", "id"));
        this.f = (ScanningAnimButton) findViewById(q.a(getContext(), "myoffer_second_ec_cta", "id"));
        b();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.2f, 1.0f);
        this.h = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(500L);
        if (this.c != null) {
            String strA = g.a().a(com.anythink.core.common.a.b.d.p);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (SecondEndCardView.this.c != null) {
                        SecondEndCardView.this.c.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    protected void b() {
        ScanningAnimButton scanningAnimButton = this.f;
        if (scanningAnimButton != null) {
            scanningAnimButton.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (SecondEndCardView.this.g != null) {
                        SecondEndCardView.this.g.a(15, 36);
                    }
                }
            });
        }
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (SecondEndCardView.this.g != null) {
                        SecondEndCardView.this.g.a(15, 37);
                    }
                }
            });
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SecondEndCardView.this.g != null) {
                    SecondEndCardView.this.g.a(15, 38);
                }
            }
        });
    }

    protected int c() {
        return q.a(getContext(), "myoffer_endcard_improve_second_endcard", "layout");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void setSecondECClickListener(b.a aVar) {
        this.g = aVar;
    }

    public void setAdTitle(String str) {
        if (this.d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setText(str);
    }

    public void setAdDesc(String str) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
    }

    public void setAdIcon(final String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, str), layoutParams.width, layoutParams.height, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView.5
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str2, String str3) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str2, Bitmap bitmap) {
                if (!TextUtils.equals(str2, str) || SecondEndCardView.this.b == null) {
                    return;
                }
                SecondEndCardView.this.b.setImageBitmap(bitmap);
            }
        });
    }

    public void setAdPoster(final String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, str), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView.6
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str2, String str3) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str2, Bitmap bitmap) {
                if (!TextUtils.equals(str2, str) || SecondEndCardView.this.c == null) {
                    return;
                }
                SecondEndCardView.this.c.setImageBitmap(bitmap);
            }
        });
    }

    public void setCTAText(String str) {
        if (this.f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f.setText(str);
    }

    public void addApkComplianceElements(boolean z) {
        RelativeLayout relativeLayout;
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_include_4_element", "layout"), (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (!z && (relativeLayout = this.a) != null) {
            relativeLayout.addView(viewInflate, layoutParams);
        } else {
            addView(viewInflate, layoutParams);
        }
    }

    public void addCloseView(View view, ViewGroup.LayoutParams layoutParams) {
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            relativeLayout.addView(view, layoutParams);
        } else {
            addView(view, layoutParams);
        }
    }
}
