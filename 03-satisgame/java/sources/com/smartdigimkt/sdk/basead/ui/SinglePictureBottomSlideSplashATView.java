package com.smartdigimkt.sdk.basead.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.k5;
import com.smartdigimkt.n1.l5;
import com.smartdigimkt.n1.m5;
import com.smartdigimkt.n1.n5;
import com.smartdigimkt.n1.o5;
import com.smartdigimkt.n1.p5;
import com.smartdigimkt.n1.s5;
import com.smartdigimkt.n1.t5;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.z.c0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SinglePictureBottomSlideSplashATView extends BaseNewStyleSDKSplashATView {
    public View o0;
    public ImageView p0;
    public SplashBottomShakeTextHintView q0;
    public TextView r0;
    public TextView s0;
    public ArrayList t0;
    public ObjectAnimator u0;
    public ValueAnimator v0;

    public SinglePictureBottomSlideSplashATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(int i) {
        super.a(i);
        if (i != 110) {
            if (i == 111) {
                f.a().a(new o5(this));
                return;
            } else if (i != 114) {
                if (i != 115) {
                    return;
                }
                f.a().a(new p5(this));
                return;
            }
        }
        f.a().a(new n5(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_single_bottom_slide", "layout"), this);
        r();
        r rVar = this.T;
        if (rVar != null) {
            rVar.c = KsDexEncryptHelper.DECRYPT_ERROR_IO;
            rVar.l = new k5(this);
            rVar.a(getContext(), viewInflate);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void q() {
        this.l0 = true;
        m.a(getContext()).a(new o(1, this.c.f), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new s5(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void s() {
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_container", "id"));
        this.m = viewFindViewById;
        this.j.add(viewFindViewById);
        this.o0 = findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_bg", "id"));
        this.p0 = (ImageView) findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_slide_icon", "id"));
        this.q0 = (SplashBottomShakeTextHintView) findViewById(k.a(getContext(), "myoffer_splash_cta_shake", "id"));
        this.r0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_slide_hint", "id"));
        this.s0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_slide_title", "id"));
        if (c0.d(this.b)) {
            if (this.q0 != null) {
                this.p0.setVisibility(8);
                this.r0.setVisibility(8);
                this.s0.setText(c0.a(getContext(), this.c.o));
                this.q0.setVisibility(0);
                this.q0.setShakeSetting(this.b.s, this.c.o);
                this.q0.setOnShakeListener(new l5(this), this.b.s);
                return;
            }
            return;
        }
        View view = this.o0;
        if (view != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f);
            this.u0 = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.u0.setRepeatCount(-1);
            this.u0.setRepeatMode(2);
        }
        if (this.p0 != null) {
            ArrayList arrayList = new ArrayList();
            this.t0 = arrayList;
            arrayList.add(Integer.valueOf(k.a(getContext(), "myoffer_slide_up_arrow_1", "drawable")));
            this.t0.add(Integer.valueOf(k.a(getContext(), "myoffer_slide_up_arrow_2", "drawable")));
            this.t0.add(Integer.valueOf(k.a(getContext(), "myoffer_slide_up_arrow_3", "drawable")));
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.t0.size());
            this.v0 = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(700L);
            this.v0.setRepeatCount(-1);
            this.v0.addUpdateListener(new m5(this));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void t() {
        int i = this.b.s.R;
        this.A = new t5(this);
        c();
    }

    public SinglePictureBottomSlideSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }
}
