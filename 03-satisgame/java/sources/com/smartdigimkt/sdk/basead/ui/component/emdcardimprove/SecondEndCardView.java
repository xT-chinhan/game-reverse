package com.smartdigimkt.sdk.basead.ui.component.emdcardimprove;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.i2.k;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.w1.p;
import com.smartdigimkt.w1.q;
import com.smartdigimkt.w1.r;
import com.smartdigimkt.w1.s;
import com.smartdigimkt.w1.t;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class SecondEndCardView extends RelativeLayout {
    public RelativeLayout a;
    public RoundImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ScanningAnimButton f;
    public k g;
    public ObjectAnimator h;

    public SecondEndCardView(Context context) {
        this(context, null);
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(getLayoutInflateID(), this);
        this.a = (RelativeLayout) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_second_ec_container", "id"));
        this.b = (RoundImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_second_ec_ad_icon", "id"));
        this.c = (ImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_second_ec_ad_poster", "id"));
        if (h.y(getContext()) == 2) {
            this.b.setRadiusInDip(18);
        } else {
            this.b.setRadiusInDip(24);
        }
        this.b.setNeedRadiu(true);
        this.d = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_second_ec_ad_title", "id"));
        this.e = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_second_ec_ad_desc", "id"));
        this.f = (ScanningAnimButton) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_second_ec_cta", "id"));
        b();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.2f, 1.0f);
        this.h = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(500L);
        if (this.c != null) {
            String strB = d.a().b(b.d.p);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            d0.a().a(new o(3, strB), -1, -1, new com.smartdigimkt.w1.o(this));
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

    public void addComplianceElements(boolean z) {
        RelativeLayout relativeLayout;
        View viewInflate = LayoutInflater.from(getContext()).inflate(com.smartdigimkt.r4.k.a(getContext(), "myoffer_include_4_element", "layout"), (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (z || (relativeLayout = this.a) == null) {
            addView(viewInflate, layoutParams);
        } else {
            relativeLayout.addView(viewInflate, layoutParams);
        }
    }

    public void b() {
        ScanningAnimButton scanningAnimButton = this.f;
        if (scanningAnimButton != null) {
            scanningAnimButton.setOnClickListener(new p(this));
        }
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new q(this));
        }
        setOnClickListener(new r(this));
    }

    public RoundImageView getAdIconView() {
        return this.b;
    }

    public ScanningAnimButton getCTAButton() {
        return this.f;
    }

    public k getClickListener() {
        return this.g;
    }

    public RelativeLayout getContainerView() {
        return this.a;
    }

    public int getLayoutInflateID() {
        return com.smartdigimkt.r4.k.a(getContext(), "myoffer_endcard_improve_second_endcard", "layout");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void setAdDesc(String str) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
    }

    public void setAdIcon(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        m.a(getContext()).a(new o(1, str), layoutParams.width, layoutParams.height, new s(this, str));
    }

    public void setAdPoster(String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        m.a(getContext()).a(new o(1, str), -1, -1, new t(this, str));
    }

    public void setAdTitle(String str) {
        if (this.d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setText(str);
    }

    public void setCTAText(String str) {
        if (this.f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f.setText(str);
    }

    public void setSecondECClickListener(k kVar) {
        this.g = kVar;
    }

    public SecondEndCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SecondEndCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
