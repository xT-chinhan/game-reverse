package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    protected ViewGroup ab;
    protected final lm ah;
    protected final boolean c;
    protected TextView ch;
    protected final int d;
    protected RelativeLayout hi;
    protected final float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final String f2216ms;
    protected FrameLayout ny;
    protected int sl = 3;
    protected RelativeLayout x;
    protected final TTBaseVideoActivity xr;

    public void ah(int i) {
    }

    public void ch() {
    }

    public void d(int i) {
    }

    public void ms(DownloadListener downloadListener) {
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
    }

    public void xr(int i) {
    }

    public xr(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        this.xr = tTBaseVideoActivity;
        this.ah = lmVar;
        this.d = lmVar.od();
        this.ka = lmVar.ld();
        this.c = z;
        this.f2216ms = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public void ms() {
        ViewGroup viewGroup = (ViewGroup) this.xr.findViewById(2114387959);
        this.ab = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    protected void hi() {
        if (this.c) {
            int iGy = this.ah.gy();
            this.sl = iGy;
            if (iGy == -200) {
                this.sl = re.xr().sl(new StringBuilder().append(f.ny(this.ah)).toString());
            }
            if (this.sl == -1) {
                ul.ms((View) this.x, 0);
            }
        }
    }

    public void ka(int i) {
        ul.ms((View) this.ch, i);
    }

    public void c(int i) {
        ul.ms((View) this.x, i);
    }

    public FrameLayout sl() {
        return this.ny;
    }

    public RelativeLayout zb() {
        return this.x;
    }

    protected String u() {
        return f.h(this.ah);
    }

    protected String ub() {
        return f.qv(this.ah);
    }

    protected void ms(ImageView imageView, UpieImageView upieImageView) {
        List<g> listFk = this.ah.fk();
        if (listFk == null || listFk.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(listFk.get(0)).ms(imageView);
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.ah)) {
            com.bytedance.sdk.openadsdk.ka.ms.ms(imageView, upieImageView);
        }
    }

    public void ah(boolean z) {
        this.xr.jw().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public void ao() {
        lm lmVar = this.ah;
        String strZe = lmVar != null ? lmVar.ze() : null;
        if (this.ch == null || !TextUtils.isEmpty(strZe)) {
            return;
        }
        t.ms(this.xr, "tt_ad_logo_backup", this.ch);
    }
}
