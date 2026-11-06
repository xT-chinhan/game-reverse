package com.byazt.osr;

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
import com.byazt.cq.tj;
import com.byazt.cq.w;
import com.byazt.hkc.rv;
import com.byazt.lh.fs;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.si.ou;
import com.byazt.stl.DynamicLottieView;
import com.byazt.stl.GifView;
import com.byazt.stl.TTRoundRectImageView;
import com.byazt.tk.sz;
import com.byazt.udb.oa;
import com.byazt.wt.UpieImageView;
import com.byazt.zw.AnimationImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1354})
public class DynamicImageView extends DynamicBaseWidgetImp {
    public String n;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        if (!TextUtils.isEmpty(this.d.z()) && fsVar.um()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.d.dn());
            dynamicLottieView.setImageLottieTosPath(this.d.z());
            dynamicLottieView.setLottieAppNameMaxLength(this.d.vb());
            dynamicLottieView.setLottieAdTitleMaxLength(this.d.el());
            dynamicLottieView.setLottieAdDescMaxLength(this.d.he());
            dynamicLottieView.setData(fsVar.a());
            this.k = dynamicLottieView;
        } else if (this.d.k() > 0.0f) {
            this.k = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.k).setXRound((int) com.byazt.cq.fs.n(context, this.d.k()));
            ((TTRoundRectImageView) this.k).setYRound((int) com.byazt.cq.fs.n(context, this.d.k()));
        } else if (!x() && "arrowButton".equals(fsVar.tj().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.d);
            this.k = animationImageView;
        } else if (tj.qg(this.d.cp())) {
            this.k = new GifView(context);
        } else {
            String strCp = this.d.cp();
            oa renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.qg() != null && TextUtils.equals(strCp, renderRequest.n())) {
                this.k = renderRequest.qg();
            } else {
                this.k = new ImageView(context);
            }
        }
        this.n = qg(this.d.cp());
        this.k.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(fsVar.tj().getType())) {
            if (this.d.qg() > 0 || this.d.n() > 0) {
                this.x = Math.min(this.x, this.fs);
                this.fs = Math.min(this.x, this.fs);
                this.rv = (int) (this.rv + com.byazt.cq.fs.n(context, this.d.qg() + (this.d.n() / 2) + 0.5f));
            } else {
                this.x = Math.max(this.x, this.fs);
                this.fs = Math.max(this.x, this.fs);
            }
            this.d.n(this.x / 2);
        }
        addView(this.k, new FrameLayout.LayoutParams(this.x, this.fs));
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.k instanceof ImageView) {
            Drawable drawable = ((ImageView) this.k).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).start();
        }
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.k instanceof ImageView) {
            Drawable drawable = ((ImageView) this.k).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        try {
            if (this.k instanceof UpieImageView) {
                this.k.setBackgroundColor(this.d.ur());
                if (rv()) {
                    ((UpieImageView) this.k).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.d.z())) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.oa.tj().getType())) {
            sz.n(this.cp, "tt_white_righterbackicon_titlebar", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.osr.DynamicImageView.1
                @Override // com.byazt.qyj.n
                public void n(Bitmap bitmap) {
                    ((ImageView) DynamicImageView.this.k).setImageDrawable(new BitmapDrawable(DynamicImageView.this.cp.getResources(), bitmap));
                    if (((ImageView) DynamicImageView.this.k).getDrawable() != null) {
                        ((ImageView) DynamicImageView.this.k).getDrawable().setAutoMirrored(true);
                    }
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            this.k.setPadding(0, 0, 0, 0);
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.k.setBackgroundColor(this.d.ur());
        String strQg = this.oa.tj().qg();
        if ("user".equals(strQg)) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.k).setColorFilter(this.d.x());
            sz.n(getContext(), "tt_user", (ImageView) this.k, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            ((ImageView) this.k).setPadding(this.x / 10, this.fs / 5, this.x / 10, 0);
        } else if (strQg != null && strQg.startsWith("@")) {
            try {
                ((ImageView) this.k).setImageResource(Integer.parseInt(strQg.substring(1)));
            } catch (Exception unused2) {
            }
        }
        ou ouVarL = com.byazt.gkj.n.n().l();
        String strCp = this.d.cp();
        if (!TextUtils.isEmpty(strCp) && !strCp.startsWith("http:") && !strCp.startsWith("https:")) {
            strCp = rv.qg(strCp, (this.sz == null || this.sz.getRenderRequest() == null) ? null : this.sz.getRenderRequest().h());
        }
        com.byazt.si.sz szVarQg = ouVarL.n(strCp).qg(this.n);
        String strCy = this.sz.getRenderRequest().cy();
        if (!TextUtils.isEmpty(strCy)) {
            szVarQg.s(strCy);
        }
        if (rv()) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_CENTER);
            szVarQg.n(Bitmap.Config.ARGB_4444).s(2).n(new n(this.cp)).n(new qg(this.k, getResources()));
        } else {
            if (com.byazt.twc.q.n()) {
                szVarQg.n((ImageView) this.k);
            }
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.k instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.byazt.twc.q.n()) {
            n(szVarQg);
        }
        return true;
    }

    @com.byazt.cp.n(n = {0, 1, 38, 429})
    private static class n implements com.byazt.si.tj {
        public final WeakReference<Context> n;

        public n(Context context) {
            this.n = new WeakReference<>(context);
        }

        @Override // com.byazt.si.tj
        public Bitmap n(Bitmap bitmap) {
            Context context = this.n.get();
            if (context != null) {
                return com.byazt.cq.qg.n(context, bitmap, 25);
            }
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 38, 1156})
    private static class qg implements m<Bitmap> {
        public WeakReference<View> n;
        public Resources qg;

        @Override // com.byazt.si.m
        public void n(int i, String str, Throwable th) {
        }

        public qg(View view, Resources resources) {
            this.n = new WeakReference<>(view);
            this.qg = resources;
        }

        @Override // com.byazt.si.m
        public void n(cy<Bitmap> cyVar) {
            Bitmap bitmapS;
            View view = this.n.get();
            if (view == null || (bitmapS = cyVar.s()) == null || cyVar.q() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.qg, bitmapS));
        }
    }

    private boolean rv() {
        String strD = this.d.d();
        if (this.d.a()) {
            return true;
        }
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strD);
            return Math.abs((((float) this.x) / (((float) this.fs) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    public String qg(String str) {
        Map<String, String> mapOa = this.sz.getRenderRequest().oa();
        if (mapOa == null || mapOa.size() <= 0) {
            return null;
        }
        return mapOa.get(str);
    }

    private void n(com.byazt.si.sz szVar) {
        szVar.s(3).n(new m() { // from class: com.byazt.osr.DynamicImageView.2
            @Override // com.byazt.si.m
            public void n(int i, String str, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy cyVar) {
                Object objS = cyVar.s();
                if ((objS instanceof byte[]) && (DynamicImageView.this.k instanceof ImageView)) {
                    w.qg((ImageView) DynamicImageView.this.k, (byte[]) objS, DynamicImageView.this.x, DynamicImageView.this.fs);
                }
            }
        }, 4);
    }
}
