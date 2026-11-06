package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

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
import com.bytedance.sdk.component.adexpress.d.c;
import com.bytedance.sdk.component.adexpress.d.ch;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.d.ny;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.ub;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.umeng.analytics.pro.be;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f820ms;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (!TextUtils.isEmpty(this.sl.gy()) && xVar.y()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.sl.vl());
            dynamicLottieView.setImageLottieTosPath(this.sl.gy());
            dynamicLottieView.setLottieAppNameMaxLength(this.sl.jm());
            dynamicLottieView.setLottieAdTitleMaxLength(this.sl.ce());
            dynamicLottieView.setLottieAdDescMaxLength(this.sl.qr());
            dynamicLottieView.setData(xVar.t());
            this.ub = dynamicLottieView;
        } else if (this.sl.ub() > 0.0f) {
            this.ub = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.ub).setXRound((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, this.sl.ub()));
            ((TTRoundRectImageView) this.ub).setYRound((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, this.sl.ub()));
        } else if (!ab() && "arrowButton".equals(xVar.ch().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.sl);
            this.ub = animationImageView;
        } else if (ch.xr(this.sl.hi())) {
            this.ub = new GifView(context);
        } else {
            String strHi = this.sl.hi();
            zb renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.xr() != null && TextUtils.equals(strHi, renderRequest.ms())) {
                this.ub = renderRequest.xr();
            } else {
                this.ub = new ImageView(context);
            }
        }
        this.f820ms = xr(this.sl.hi());
        this.ub.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(xVar.ch().getType())) {
            if (this.sl.xr() > 0 || this.sl.ms() > 0) {
                this.ab = Math.min(this.ab, this.x);
                this.x = Math.min(this.ab, this.x);
                this.ny = (int) (this.ny + com.bytedance.sdk.component.adexpress.d.x.ms(context, this.sl.xr() + (this.sl.ms() / 2) + 0.5f));
            } else {
                this.ab = Math.max(this.ab, this.x);
                this.x = Math.max(this.ab, this.x);
            }
            this.sl.ms(this.ab / 2);
        }
        addView(this.ub, new FrameLayout.LayoutParams(this.ab, this.x));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ub instanceof ImageView) {
            Drawable drawable = ((ImageView) this.ub).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).start();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ub instanceof ImageView) {
            Drawable drawable = ((ImageView) this.ub).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        try {
            if (this.ub instanceof UpieImageView) {
                this.ub.setBackgroundColor(this.sl.le());
                if (ny()) {
                    ((UpieImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        if (!TextUtils.isEmpty(this.sl.gy())) {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.zb.ch().getType())) {
            ((ImageView) this.ub).setImageResource(t.ka(this.hi, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.ub).getDrawable() != null) {
                ((ImageView) this.ub).getDrawable().setAutoMirrored(true);
            }
            this.ub.setPadding(0, 0, 0, 0);
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.ub.setBackgroundColor(this.sl.le());
        String strXr = this.zb.ch().xr();
        if (be.m.equals(strXr)) {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.ub).setColorFilter(this.sl.ab());
            t.ms(getContext(), "tt_user", (ImageView) this.ub);
            ((ImageView) this.ub).setPadding(this.ab / 10, this.x / 5, this.ab / 10, 0);
        } else if (strXr != null && strXr.startsWith("@")) {
            try {
                ((ImageView) this.ub).setImageResource(Integer.parseInt(strXr.substring(1)));
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        ub ubVarKa = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka();
        String strHi = this.sl.hi();
        if (!TextUtils.isEmpty(strHi) && !strHi.startsWith("http:") && !strHi.startsWith("https:")) {
            strHi = ny.xr(strHi, (this.u == null || this.u.getRenderRequest() == null) ? null : this.u.getRenderRequest().op());
        }
        com.bytedance.sdk.component.c.ch chVarXr = ubVarKa.ms(strHi).xr(this.f820ms);
        String strH = this.u.getRenderRequest().h();
        if (!TextUtils.isEmpty(strH)) {
            chVarXr.ah(strH);
        }
        if (ny()) {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_CENTER);
            chVarXr.ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ms(this.hi)).ms(new xr(this.ub, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                chVarXr.ms((ImageView) this.ub);
            }
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.ub instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.d.ms()) {
            ms(chVarXr);
        }
        return true;
    }

    private static class ms implements com.bytedance.sdk.component.c.x {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final WeakReference<Context> f822ms;

        public ms(Context context) {
            this.f822ms = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.c.x
        @ATSMethod(1)
        public Bitmap ms(Bitmap bitmap) {
            Context context = this.f822ms.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.d.xr.ms(context, bitmap, 25);
            }
            return null;
        }
    }

    private static class xr implements ao<Bitmap> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private WeakReference<View> f823ms;
        private Resources xr;

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(2)
        public void ms(int i, String str, Throwable th) {
        }

        public xr(View view, Resources resources) {
            this.f823ms = new WeakReference<>(view);
            this.xr = resources;
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(1)
        public void ms(hi<Bitmap> hiVar) {
            Bitmap bitmapAh;
            View view = this.f823ms.get();
            if (view == null || (bitmapAh = hiVar.ah()) == null || hiVar.d() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.xr, bitmapAh));
        }
    }

    private boolean ny() {
        String strSl = this.sl.sl();
        if (this.sl.t()) {
            return true;
        }
        if (TextUtils.isEmpty(strSl)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strSl);
            return Math.abs((((float) this.ab) / (((float) this.x) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            sl.ms(e);
            return false;
        }
    }

    protected String xr(String str) {
        Map<String, String> mapU = this.u.getRenderRequest().u();
        if (mapU == null || mapU.size() <= 0) {
            return null;
        }
        return mapU.get(str);
    }

    private void ms(com.bytedance.sdk.component.c.ch chVar) {
        chVar.ah(3).ms(new ao() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi hiVar) {
                Object objAh = hiVar.ah();
                if ((objAh instanceof byte[]) && (DynamicImageView.this.ub instanceof ImageView)) {
                    c.xr((ImageView) DynamicImageView.this.ub, (byte[]) objAh, DynamicImageView.this.ab, DynamicImageView.this.x);
                }
            }
        }, 4);
    }
}
