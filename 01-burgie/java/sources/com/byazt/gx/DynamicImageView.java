package com.byazt.gx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.js.uc;
import com.byazt.js.vk;
import com.byazt.jt.DynamicLottieView;
import com.byazt.jt.GifView;
import com.byazt.jt.TTRoundRectImageView;
import com.byazt.ld.nt;
import com.byazt.ld.ny;
import com.byazt.ld.rc;
import com.byazt.mq.m;
import com.byazt.oc.UpieImageView;
import com.byazt.rk.zo;
import com.byazt.uko.aj;
import com.byazt.vry.AnimationImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import com.umeng.analytics.pro.z;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1224})
public class DynamicImageView extends DynamicBaseWidgetImp {
    public String pr;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        if (!TextUtils.isEmpty(this.k.pq()) && zoVar.qa()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.k.jw());
            dynamicLottieView.setImageLottieTosPath(this.k.pq());
            dynamicLottieView.setLottieAppNameMaxLength(this.k.iy());
            dynamicLottieView.setLottieAdTitleMaxLength(this.k.aa());
            dynamicLottieView.setLottieAdDescMaxLength(this.k.wt());
            dynamicLottieView.setData(zoVar.a());
            this.ho = dynamicLottieView;
        } else if (this.k.ho() > 0.0f) {
            this.ho = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.ho).setXRound((int) com.byazt.js.zo.pr(context, this.k.ho()));
            ((TTRoundRectImageView) this.ho).setYRound((int) com.byazt.js.zo.pr(context, this.k.ho()));
        } else if (!fw() && "arrowButton".equals(zoVar.vk().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.k);
            this.ho = animationImageView;
        } else if (vk.hw(this.k.w())) {
            this.ho = new GifView(context);
        } else {
            String strW = this.k.w();
            m renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.hw() != null && TextUtils.equals(strW, renderRequest.pr())) {
                this.ho = renderRequest.hw();
            } else {
                this.ho = new ImageView(context);
            }
        }
        this.pr = hw(this.k.w());
        this.ho.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(zoVar.vk().getType())) {
            if (this.k.hw() > 0 || this.k.pr() > 0) {
                this.fw = Math.min(this.fw, this.zo);
                this.zo = Math.min(this.fw, this.zo);
                this.aj = (int) (this.aj + com.byazt.js.zo.pr(context, this.k.hw() + (this.k.pr() / 2) + 0.5f));
            } else {
                this.fw = Math.max(this.fw, this.zo);
                this.zo = Math.max(this.fw, this.zo);
            }
            this.k.pr(this.fw / 2);
        }
        addView(this.ho, new FrameLayout.LayoutParams(this.fw, this.zo));
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ho instanceof ImageView) {
            Drawable drawable = ((ImageView) this.ho).getDrawable();
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                ((AnimatedImageDrawable) drawable).start();
            }
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ho instanceof ImageView) {
            Drawable drawable = ((ImageView) this.ho).getDrawable();
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                ((AnimatedImageDrawable) drawable).stop();
            }
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        try {
            if (this.ho instanceof UpieImageView) {
                this.ho.setBackgroundColor(this.k.ve());
                if (aj() && Build.VERSION.SDK_INT >= 17) {
                    ((UpieImageView) this.ho).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.ho).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
        }
        if (!TextUtils.isEmpty(this.k.pq())) {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.m.vk().getType())) {
            g.pr(this.w, "tt_white_righterbackicon_titlebar", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.gx.DynamicImageView.1
                @Override // com.byazt.ezf.pr
                public void pr(Bitmap bitmap) {
                    ((ImageView) DynamicImageView.this.ho).setImageDrawable(new BitmapDrawable(DynamicImageView.this.w.getResources(), bitmap));
                    if (Build.VERSION.SDK_INT >= 19 && ((ImageView) DynamicImageView.this.ho).getDrawable() != null) {
                        ((ImageView) DynamicImageView.this.ho).getDrawable().setAutoMirrored(true);
                    }
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            this.ho.setPadding(0, 0, 0, 0);
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.ho.setBackgroundColor(this.k.ve());
        String strHw = this.m.vk().hw();
        if (z.m.equals(strHw)) {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.ho).setColorFilter(this.k.fw());
            g.pr(getContext(), "tt_user", (ImageView) this.ho, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            ((ImageView) this.ho).setPadding(this.fw / 10, this.zo / 5, this.fw / 10, 0);
        } else if (strHw != null && strHw.startsWith("@")) {
            try {
                ((ImageView) this.ho).setImageResource(Integer.parseInt(strHw.substring(1)));
            } catch (Exception e) {
            }
        }
        ny nyVarC = com.byazt.bg.pr.pr().c();
        String strW = this.k.w();
        if (!TextUtils.isEmpty(strW) && !strW.startsWith("http:") && !strW.startsWith("https:")) {
            String strB = null;
            if (this.g != null && this.g.getRenderRequest() != null) {
                strB = this.g.getRenderRequest().b();
            }
            strW = aj.hw(strW, strB);
        }
        com.byazt.ld.g gVarHw = nyVarC.pr(strW).hw(this.pr);
        String strNt = this.g.getRenderRequest().nt();
        if (!TextUtils.isEmpty(strNt)) {
            gVarHw.hn(strNt);
        }
        if (aj() && Build.VERSION.SDK_INT >= 17) {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.FIT_CENTER);
            gVarHw.pr(Bitmap.Config.ARGB_4444).hn(2).pr(new pr(this.w)).pr(new hw(this.ho, getResources()));
        } else {
            if (com.byazt.dj.x.pr()) {
                gVarHw.pr((ImageView) this.ho);
            }
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.ho instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.byazt.dj.x.pr()) {
            pr(gVarHw);
        }
        return true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 63, ComplianceMessage.DURATION_LIMIT})
    private static class pr implements com.byazt.ld.vk {
        public final WeakReference<Context> pr;

        public pr(Context context) {
            this.pr = new WeakReference<>(context);
        }

        @Override // com.byazt.ld.vk
        public Bitmap pr(Bitmap bitmap) {
            Context context = this.pr.get();
            if (context != null) {
                return com.byazt.js.hw.pr(context, bitmap, 25);
            }
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 63, 1098})
    private static class hw implements rc<Bitmap> {
        public Resources hw;
        public WeakReference<View> pr;

        public hw(View view, Resources resources) {
            this.pr = new WeakReference<>(view);
            this.hw = resources;
        }

        @Override // com.byazt.ld.rc
        public void pr(nt<Bitmap> ntVar) {
            Bitmap bitmapHn;
            View view = this.pr.get();
            if (view == null || (bitmapHn = ntVar.hn()) == null || ntVar.x() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.hw, bitmapHn));
        }

        @Override // com.byazt.ld.rc
        public void pr(int i, String str, Throwable th) {
        }
    }

    private boolean aj() {
        String strK = this.k.k();
        if (this.k.a()) {
            return true;
        }
        if (TextUtils.isEmpty(strK)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strK);
            return Math.abs((((float) this.fw) / (((float) this.zo) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            return false;
        }
    }

    public String hw(String str) {
        Map<String, String> mapM = this.g.getRenderRequest().m();
        if (mapM == null || mapM.size() <= 0) {
            return null;
        }
        return mapM.get(str);
    }

    private void pr(com.byazt.ld.g gVar) {
        gVar.hn(3).pr(new rc() { // from class: com.byazt.gx.DynamicImageView.2
            @Override // com.byazt.ld.rc
            public void pr(nt ntVar) {
                Object objHn = ntVar.hn();
                if ((objHn instanceof byte[]) && (DynamicImageView.this.ho instanceof ImageView)) {
                    uc.hw((ImageView) DynamicImageView.this.ho, (byte[]) objHn, DynamicImageView.this.fw, DynamicImageView.this.zo);
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str, Throwable th) {
            }
        }, 4);
    }
}
