package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.p0;
import com.smartdigimkt.n1.q2;
import com.smartdigimkt.n1.s2;
import com.smartdigimkt.n1.t2;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public class EndCardView extends BaseEndCardView {
    public int e;
    public int f;
    public RoundImageView g;
    public RoundImageView h;
    public ScanningAnimButton i;
    public Bitmap j;
    public final q2 k;

    public EndCardView(Context context, c cVar, a aVar) {
        super(context, cVar, aVar);
        this.k = new q2(this);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseEndCardView
    public Drawable getBgDrawable() {
        Bitmap bitmap = this.j;
        return (bitmap == null || bitmap.isRecycled()) ? super.getBgDrawable() : new BitmapDrawable(this.j);
    }

    public View getLearnMoreButton() {
        return this.i;
    }

    public void init(boolean z, boolean z2, p0 p0Var) {
        setId(k.a(getContext(), "myoffer_end_card_id", "id"));
        this.mListener = p0Var;
        this.g = new RoundImageView(getContext());
        addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        if (z) {
            c cVar = this.a;
            this.h = new RoundImageView(getContext());
            int iA = k.a(getContext(), 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            addView(this.h, layoutParams);
            this.h.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.h.setImageResource(k.a(getContext(), "myoffer_ad_logo_default", "drawable"));
            String str = SDMSDK.getInstance().isUseLocalLogo() ? "" : cVar.g;
            if (!TextUtils.isEmpty(str)) {
                ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
                m.a(getContext()).a(new o(1, str), layoutParams2.width, layoutParams2.height, new t2(this, str, iA));
            }
        }
        if (z2) {
            ScanningAnimButton scanningAnimButton = new ScanningAnimButton(getContext());
            this.i = scanningAnimButton;
            scanningAnimButton.setText(k.a(getContext(), "myoffer_cta_learn_more", "string"));
            this.i.setTextColor(Color.parseColor("#ffffffff"));
            this.i.setTextSize(14.0f);
            this.i.setGravity(17);
            this.i.setBackgroundResource(k.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", "drawable"));
            this.a.getClass();
            this.i.setOnClickListener(this.k);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, k.a(getContext(), 48.0f));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = k.a(getContext(), 96.0f);
            layoutParams3.leftMargin = k.a(getContext(), 24.0f);
            layoutParams3.rightMargin = k.a(getContext(), 24.0f);
            addView(this.i, layoutParams3);
        }
        this.a.getClass();
        setOnClickListener(this.k);
    }

    public void load() {
        c cVar = this.a;
        try {
            m.a(getContext()).a(new o(1, cVar.f), this.e, this.f, new s2(this, cVar));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setSize(int i, int i2) {
        this.e = i;
        this.f = i2;
    }
}
