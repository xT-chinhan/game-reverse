package com.byazt.jt;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.ny;
import com.byazt.dx.LottieAnimationView;
import com.byazt.rk.vk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1635})
public class WriggleGuideAnimationView extends LinearLayout {
    public boolean aj;
    public pr c;
    public LottieAnimationView fw;
    public ny hn;
    public TextView hw;
    public int pr;
    public LinearLayout uc;
    public TextView x;
    public vk zo;

    public interface pr {
        void pr();
    }

    public WriggleGuideAnimationView(Context context, View view, vk vkVar, boolean z, int i) {
        super(context);
        this.aj = true;
        this.zo = vkVar;
        this.aj = z;
        this.pr = i;
        pr(context, view);
    }

    private void pr(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.uc = (LinearLayout) findViewById(2097610722);
        this.hw = (TextView) findViewById(2097610719);
        this.x = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.fw = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.fw.setImageAssetsFolder("images/");
        this.fw.pr(true);
    }

    public void setShakeText(String str) {
        this.x.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.uc;
    }

    public View getWriggleProgressIv() {
        return this.fw;
    }

    public TextView getTopTextView() {
        return this.hw;
    }

    public void setOnShakeViewListener(pr prVar) {
        this.c = prVar;
    }

    public void pr() {
        postDelayed(new Runnable() { // from class: com.byazt.jt.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.fw.pr();
                } catch (Throwable th) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.hn == null) {
                this.hn = new ny(getContext().getApplicationContext(), 2, this.aj);
            }
            this.hn.pr(new ny.pr() { // from class: com.byazt.jt.WriggleGuideAnimationView.2
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.c != null) {
                        WriggleGuideAnimationView.this.c.pr();
                    }
                }
            });
            vk vkVar = this.zo;
            if (vkVar != null) {
                this.hn.hw(vkVar.hn());
                this.hn.uc(this.zo.c());
                this.hn.pr(this.zo.uc());
                this.hn.hw(this.zo.zo());
            }
            this.hn.pr(this.pr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ny nyVar = this.hn;
        if (nyVar != null) {
            nyVar.hw(this.pr);
        }
        try {
            LottieAnimationView lottieAnimationView = this.fw;
            if (lottieAnimationView != null) {
                lottieAnimationView.uc();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ny nyVar = this.hn;
        if (nyVar != null) {
            if (z) {
                nyVar.pr(this.pr);
            } else {
                nyVar.hw(this.pr);
            }
        }
    }
}
