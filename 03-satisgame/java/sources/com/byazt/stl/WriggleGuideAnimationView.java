package com.byazt.stl;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.lh.tj;
import com.byazt.pp.LottieAnimationView;
import com.byazt.tk.ou;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1794})
public class WriggleGuideAnimationView extends LinearLayout {
    public tj fs;
    public n l;
    public int n;
    public TextView q;
    public TextView qg;
    public boolean rv;
    public ou s;
    public LinearLayout w;
    public LottieAnimationView x;

    public interface n {
        void n();
    }

    public WriggleGuideAnimationView(Context context, View view, tj tjVar, boolean z, int i) {
        super(context);
        this.fs = tjVar;
        this.rv = z;
        this.n = i;
        n(context, view);
    }

    private void n(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.w = (LinearLayout) findViewById(2097610722);
        this.qg = (TextView) findViewById(2097610719);
        this.q = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.x = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.x.setImageAssetsFolder("images/");
        this.x.n(true);
    }

    public void setShakeText(String str) {
        this.q.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.w;
    }

    public View getWriggleProgressIv() {
        return this.x;
    }

    public TextView getTopTextView() {
        return this.qg;
    }

    public void setOnShakeViewListener(n nVar) {
        this.l = nVar;
    }

    public void n() {
        postDelayed(new Runnable() { // from class: com.byazt.stl.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.x.n();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.s == null) {
                this.s = new ou(getContext().getApplicationContext(), 2, this.rv);
            }
            this.s.n(new ou.n() { // from class: com.byazt.stl.WriggleGuideAnimationView.2
                @Override // com.byazt.tk.ou.n
                public void n(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.l != null) {
                        WriggleGuideAnimationView.this.l.n();
                    }
                }
            });
            tj tjVar = this.fs;
            if (tjVar != null) {
                this.s.qg(tjVar.s());
                this.s.w(this.fs.l());
                this.s.n(this.fs.w());
                this.s.qg(this.fs.fs());
            }
            this.s.n(this.n);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ou ouVar = this.s;
        if (ouVar != null) {
            ouVar.qg(this.n);
        }
        try {
            LottieAnimationView lottieAnimationView = this.x;
            if (lottieAnimationView != null) {
                lottieAnimationView.w();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ou ouVar = this.s;
        if (ouVar != null) {
            if (z) {
                ouVar.n(this.n);
            } else {
                ouVar.qg(this.n);
            }
        }
    }
}
