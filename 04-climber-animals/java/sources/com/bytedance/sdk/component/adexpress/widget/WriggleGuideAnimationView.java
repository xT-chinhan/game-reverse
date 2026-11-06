package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.ch;
import com.bytedance.sdk.component.utils.b;

/* JADX INFO: loaded from: classes2.dex */
public class WriggleGuideAnimationView extends LinearLayout {
    private LottieAnimationView ab;
    private b ah;
    private LinearLayout c;
    private TextView d;
    private ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f985ms;
    private boolean ny;
    private ch x;
    private TextView xr;

    public interface ms {
        void ms();
    }

    public WriggleGuideAnimationView(Context context, View view, ch chVar, boolean z, int i) {
        super(context);
        this.x = chVar;
        this.ny = z;
        this.f985ms = i;
        ms(context, view);
    }

    private void ms(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.c = (LinearLayout) findViewById(2097610722);
        this.xr = (TextView) findViewById(2097610719);
        this.d = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.ab = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.ab.setImageAssetsFolder("images/");
        this.ab.ms(true);
    }

    public void setShakeText(String str) {
        this.d.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.c;
    }

    public View getWriggleProgressIv() {
        return this.ab;
    }

    public TextView getTopTextView() {
        return this.xr;
    }

    public void setOnShakeViewListener(ms msVar) {
        this.ka = msVar;
    }

    public void ms() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.ab.ms();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.ah == null) {
                this.ah = new b(getContext().getApplicationContext(), 2, this.ny);
            }
            this.ah.ms(new b.ms() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.b.ms
                public void ms(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.ka != null) {
                        WriggleGuideAnimationView.this.ka.ms();
                    }
                }
            });
            ch chVar = this.x;
            if (chVar != null) {
                this.ah.xr(chVar.ah());
                this.ah.c(this.x.ka());
                this.ah.ms(this.x.c());
                this.ah.xr(this.x.x());
            }
            this.ah.ms(this.f985ms);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.ah;
        if (bVar != null) {
            bVar.xr(this.f985ms);
        }
        try {
            LottieAnimationView lottieAnimationView = this.ab;
            if (lottieAnimationView != null) {
                lottieAnimationView.c();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        b bVar = this.ah;
        if (bVar != null) {
            if (z) {
                bVar.ms(this.f985ms);
            } else {
                bVar.xr(this.f985ms);
            }
        }
    }
}
