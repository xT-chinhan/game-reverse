package com.anythink.basead.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.b.e;
import com.anythink.basead.d.g;
import com.anythink.basead.ui.f.d;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SinglePictureBottomSlideSplashATView extends BaseNewStyleSDKSplashATView {
    View a;
    TextView ad;
    final long ae;
    ObjectAnimator af;
    ValueAnimator ag;
    private List<Integer> ah;
    ImageView b;
    SplashBottomShakeTextHintView c;
    TextView d;

    public SinglePictureBottomSlideSplashATView(Context context) {
        super(context);
        this.ae = 500L;
    }

    public SinglePictureBottomSlideSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
        this.ae = 500L;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_single_bottom_slide", "layout"), this);
        w();
        if (this.T != null) {
            this.T.a(d.c).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    SinglePictureBottomSlideSplashATView.this.a(i, i2);
                }
            }).a(getContext(), viewInflate);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void b() {
        this.q = findViewById(q.a(getContext(), "myoffer_splash_ad_bottom_container", "id"));
        this.n.add(this.q);
        this.a = findViewById(q.a(getContext(), "myoffer_splash_ad_bottom_bg", "id"));
        this.b = (ImageView) findViewById(q.a(getContext(), "myoffer_splash_ad_bottom_slide_icon", "id"));
        this.c = (SplashBottomShakeTextHintView) findViewById(q.a(getContext(), "myoffer_splash_cta_shake", "id"));
        this.d = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_bottom_slide_hint", "id"));
        this.ad = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_bottom_slide_title", "id"));
        if (n()) {
            if (this.c != null) {
                this.b.setVisibility(8);
                this.d.setVisibility(8);
                this.ad.setText(e.a(getContext(), this.g.K()));
                this.c.setVisibility(0);
                this.c.setShakeSetting(this.f.o, this.g.K());
                this.c.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView.2
                    @Override // com.anythink.basead.ui.BaseShakeView.a
                    public final boolean a() {
                        if (!SinglePictureBottomSlideSplashATView.this.C()) {
                            return false;
                        }
                        SinglePictureBottomSlideSplashATView.this.a(4, 5);
                        return true;
                    }
                }, this.f.o);
                return;
            }
            return;
        }
        View view = this.a;
        if (view != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f);
            this.af = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.af.setRepeatCount(-1);
            this.af.setRepeatMode(2);
        }
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            this.ah = arrayList;
            arrayList.add(Integer.valueOf(q.a(getContext(), "myoffer_slide_up_arrow_1", "drawable")));
            this.ah.add(Integer.valueOf(q.a(getContext(), "myoffer_slide_up_arrow_2", "drawable")));
            this.ah.add(Integer.valueOf(q.a(getContext(), "myoffer_slide_up_arrow_3", "drawable")));
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.ah.size());
            this.ag = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(700L);
            this.ag.setRepeatCount(-1);
            this.ag.addUpdateListener(new AnonymousClass3());
        }
    }

    private void D() {
        View view = this.a;
        if (view != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f);
            this.af = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.af.setRepeatCount(-1);
            this.af.setRepeatMode(2);
        }
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            this.ah = arrayList;
            arrayList.add(Integer.valueOf(q.a(getContext(), "myoffer_slide_up_arrow_1", "drawable")));
            this.ah.add(Integer.valueOf(q.a(getContext(), "myoffer_slide_up_arrow_2", "drawable")));
            this.ah.add(Integer.valueOf(q.a(getContext(), "myoffer_slide_up_arrow_3", "drawable")));
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.ah.size());
            this.ag = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(700L);
            this.ag.setRepeatCount(-1);
            this.ag.addUpdateListener(new AnonymousClass3());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView$3, reason: invalid class name */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (SinglePictureBottomSlideSplashATView.this.b == null || iIntValue >= SinglePictureBottomSlideSplashATView.this.ah.size()) {
                return;
            }
            SinglePictureBottomSlideSplashATView.this.b.setImageResource(((Integer) SinglePictureBottomSlideSplashATView.this.ah.get(iIntValue)).intValue());
        }
    }

    private void E() {
        ObjectAnimator objectAnimator = this.af;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        ValueAnimator valueAnimator = this.ag;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private void F() {
        ObjectAnimator objectAnimator = this.af;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ValueAnimator valueAnimator = this.ag;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private void G() {
        ObjectAnimator objectAnimator = this.af;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.af.cancel();
        }
        ValueAnimator valueAnimator = this.ag;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.ag.cancel();
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void c() {
        super.c();
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.g.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView.4
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, SinglePictureBottomSlideSplashATView.this.g.B())) {
                    SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView = SinglePictureBottomSlideSplashATView.this;
                    final WrapRoundImageView wrapRoundImageView = (WrapRoundImageView) singlePictureBottomSlideSplashATView.findViewById(q.a(singlePictureBottomSlideSplashATView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
                    SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView2 = SinglePictureBottomSlideSplashATView.this;
                    final RoundImageView roundImageView = (RoundImageView) singlePictureBottomSlideSplashATView2.findViewById(q.a(singlePictureBottomSlideSplashATView2.getContext(), "myoffer_splash_bg", "id"));
                    wrapRoundImageView.setVisibility(0);
                    if (SinglePictureBottomSlideSplashATView.this.f.o.t() == 2) {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        wrapRoundImageView.setImageBitmap(bitmap);
                    } else {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        wrapRoundImageView.post(new Runnable() { // from class: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                wrapRoundImageView.setBitmapAndResize(bitmap, SinglePictureBottomSlideSplashATView.this.getWidth(), SinglePictureBottomSlideSplashATView.this.getHeight());
                            }
                        });
                    }
                    if (roundImageView != null) {
                        h.a(SinglePictureBottomSlideSplashATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView.4.2
                            @Override // com.anythink.core.common.v.h.a
                            public final void a() {
                            }

                            @Override // com.anythink.core.common.v.h.a
                            public final void a(Bitmap bitmap2) {
                                roundImageView.setVisibility(0);
                                roundImageView.setImageBitmap(bitmap2);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void d() {
        a(this.f.o.Z() < 0 ? 100 : this.f.o.Z(), new Runnable() { // from class: com.anythink.basead.ui.SinglePictureBottomSlideSplashATView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (SinglePictureBottomSlideSplashATView.this.O == null) {
                    return;
                }
                int width = SinglePictureBottomSlideSplashATView.this.getWidth();
                int height = SinglePictureBottomSlideSplashATView.this.getHeight();
                int i = (int) (((double) SinglePictureBottomSlideSplashATView.this.getResources().getDisplayMetrics().widthPixels) * 0.5d);
                int i2 = (int) (((double) SinglePictureBottomSlideSplashATView.this.getResources().getDisplayMetrics().heightPixels) * 0.5d);
                if (width < i) {
                    SinglePictureBottomSlideSplashATView.this.a(g.a(g.k, "Splash display width is less than 50% of screen width!"));
                    Log.e("anythink", "Splash display width is less than 50% of screen width!");
                } else if (height < i2) {
                    SinglePictureBottomSlideSplashATView.this.a(g.a(g.k, "Splash display height is less than 50% of screen height!"));
                    Log.e("anythink", "Splash display height is less than 50% of screen height!");
                } else {
                    SinglePictureBottomSlideSplashATView.this.j();
                }
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView, com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    protected final void a(int i) {
        super.a(i);
        if (i != 110) {
            if (i == 111) {
                ObjectAnimator objectAnimator = this.af;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                ValueAnimator valueAnimator = this.ag;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    return;
                }
                return;
            }
            if (i != 114) {
                if (i != 115) {
                    return;
                }
                ObjectAnimator objectAnimator2 = this.af;
                if (objectAnimator2 != null) {
                    objectAnimator2.removeAllListeners();
                    this.af.cancel();
                }
                ValueAnimator valueAnimator2 = this.ag;
                if (valueAnimator2 != null) {
                    valueAnimator2.removeAllListeners();
                    this.ag.cancel();
                    return;
                }
                return;
            }
        }
        ObjectAnimator objectAnimator3 = this.af;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
        ValueAnimator valueAnimator3 = this.ag;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }
}
