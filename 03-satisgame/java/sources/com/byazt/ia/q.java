package com.byazt.ia;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.byazt.fvm.oa;
import com.byazt.gct.i;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lz.TTViewStub;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.pp.LottieAnimationView;
import com.byazt.shr.um;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.tk.sz;
import com.byazt.un.LayoutVideoDetail;
import com.byazt.vzj.UpieVideoView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.LiveMetrics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 5})
public class q extends com.byazt.du.n {
    public boolean ae;
    public String an;
    public ViewGroup bb;
    public int dn;
    public int e;
    public boolean f;
    public WeakReference<com.byazt.iag.s.qg> fi;
    public final boolean j;
    public long kc;
    public int nf;
    public Map<String, Object> pe;
    public WeakReference<com.byazt.iag.s.q> pk;
    public long ri;
    public int sh;
    public com.byazt.iag.s.n v;
    public WeakReference<n> wo;
    public int y;
    public long ln = 0;
    public long lh = 0;
    public boolean df = false;
    public boolean oj = false;
    public boolean dg = true;
    public volatile boolean u = false;
    public int rf = 0;
    public boolean dh = false;
    public boolean b = true;
    public boolean yw = false;
    public boolean cx = false;
    public boolean lq = false;
    public boolean ic = false;
    public com.byazt.ej.x.n ci = new com.byazt.ej.x.n() { // from class: com.byazt.ia.q.1
        @Override // com.byazt.ej.x.n
        public void qg(com.byazt.ej.x xVar) {
        }

        @Override // com.byazt.ej.x.n
        public void qg(com.byazt.ej.x xVar, int i) {
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar) {
            com.byazt.de.s.w(q.this.z());
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.1
                @Override // java.lang.Runnable
                public void run() {
                    q.this.dh();
                }
            });
            q.this.n(4);
            q.this.qg(4);
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, long j) {
            if (!q.this.yw) {
                q.this.yw = true;
                com.byazt.de.s.qg(q.this.z(), 1);
            }
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.l != null) {
                        if (!q.this.yw() || !rv.qg().on()) {
                            q.this.l.qg();
                        } else {
                            q.this.l.t();
                        }
                        q.this.n.removeCallbacks(q.this.ur);
                        q.this.dh = false;
                    }
                    if (q.this.wo != null && q.this.wo.get() != null) {
                        ((n) q.this.wo.get()).fs();
                    }
                    q.this.n.removeCallbacks(q.this.ur);
                }
            });
            q.this.e();
            q.this.ri = System.currentTimeMillis();
            q.this.kc();
        }

        @Override // com.byazt.ej.x.n
        public void s(com.byazt.ej.x xVar) {
            if (!q.this.cx) {
                q.this.cx = true;
                com.byazt.de.s.s(q.this.z());
            }
            if (com.byazt.gks.n.n(q.this.w)) {
                q.this.w.s(xVar.h());
            }
            if (!q.this.j || com.byazt.ql.s.n(q.this.w)) {
                q.this.e();
            }
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.pk != null && q.this.pk.get() != null) {
                        ((com.byazt.iag.s.q) q.this.pk.get()).w_();
                    }
                    if (q.this.l != null && (!q.this.yw() || !rv.qg().on())) {
                        q.this.l.qg();
                    }
                    q.this.n.removeCallbacks(q.this.ur);
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, final com.byazt.ej.s sVar) {
            com.byazt.de.s.s(q.this.z(), 1);
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.4
                /* JADX WARN: Code duplicated, block: B:27:0x00d9  */
                /* JADX WARN: Code duplicated, block: B:30:0x00ee  */
                @Override // java.lang.Runnable
                public void run() {
                    int iN = sVar.n();
                    int iQg = sVar.qg();
                    q.this.n(iN, iQg, sVar.s(), (JSONArray) null);
                    k.qg("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!q.this.wo() || iQg == -1004) {
                        k.qg("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + iN + "," + iQg);
                        if (!q.this.q(iN, iQg) && !com.byazt.gks.n.n(q.this.w)) {
                            if (iN == 1 && (iQg == -19 || iQg == -38)) {
                                if (q.this.l != null) {
                                    q.this.l.n(q.this.w, q.this.rv, false);
                                }
                            }
                            if (q.this.l != null) {
                                q.this.l.qg();
                            }
                            if (q.this.v != null) {
                                q.this.v.qg(q.this.lh, com.byazt.udy.n.n(q.this.x, q.this.cy));
                            }
                            if (q.this.pk != null || q.this.pk.get() == null || q.this.wo()) {
                                return;
                            }
                            ((com.byazt.iag.s.q) q.this.pk.get()).a_(iN, iQg);
                            return;
                        }
                        k.qg("NativeVideoController", "出错后展示结果页、、、、、、、");
                        if (q.this.l != null) {
                            q.this.l.n(q.this.w, q.this.rv, false);
                        }
                        q.this.s(true);
                        q.this.tj();
                        if (q.this.l != null) {
                            q.this.l.qg();
                        }
                        if (q.this.v != null) {
                            q.this.v.qg(q.this.lh, com.byazt.udy.n.n(q.this.x, q.this.cy));
                        }
                        if (q.this.pk != null) {
                        }
                    }
                }
            });
            q.this.n(sVar.n(), sVar.s());
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, boolean z) {
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.l != null) {
                        q.this.l.qg();
                    }
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void q(com.byazt.ej.x xVar) {
            com.byazt.de.s.s(q.this.z(), 2);
            q.this.ci();
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, final int i, final int i2) {
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.6
                @Override // java.lang.Runnable
                public void run() {
                    q.this.qg(i, i2);
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, int i, int i2, int i3) {
            com.byazt.de.s.q(q.this.z());
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.l != null) {
                        q.this.l.wm();
                        q.this.n.postDelayed(q.this.ur, 8000L);
                        q.this.dh = true;
                    }
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, int i) {
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.l != null) {
                        q.this.l.qg();
                    }
                    q.this.n.removeCallbacks(q.this.ur);
                    q.this.dh = false;
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, final long j, final long j2) {
            if (q.this.lq && q.this.ic) {
                q.this.lq = false;
                q.this.ic = false;
                com.byazt.de.s.qg(q.this.z(), 2);
            }
            if (Math.abs(j - q.this.x) < 50) {
                return;
            }
            q.this.n.post(new Runnable() { // from class: com.byazt.ia.q.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.wm != null) {
                        q.this.wm.n(j, j2);
                    }
                    q.this.n(j, j2);
                    q.this.qg(j, j2);
                }
            });
        }

        @Override // com.byazt.ej.x.n
        public void n(com.byazt.ej.x xVar, JSONObject jSONObject, String str) {
            if (com.byazt.vyf.s.cy().pk()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.byazt.hm.n.n((Context) q.this.rv.get(), q.this.w, q.this.an, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.byazt.ej.x.n
        public void l(com.byazt.ej.x xVar) {
            q.this.lq = true;
            com.byazt.de.s.l(q.this.z());
        }

        @Override // com.byazt.ej.x.n
        public void w(com.byazt.ej.x xVar) {
            q.this.ic = true;
        }
    };
    public int hf = 0;
    public Runnable ur = new Runnable() { // from class: com.byazt.ia.q.6
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.l != null) {
                q.this.l.n(q.this.w, q.this.rv, false);
                q.this.l.qg();
                q.this.s(true);
                k.qg("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    public final com.byazt.hsi.s z = new com.byazt.hsi.s() { // from class: com.byazt.ia.q.8
        public final long qg = com.byazt.hsi.q.n();

        @Override // com.byazt.hsi.s
        public void n(Context context, Intent intent, boolean z, int i) {
            q.this.s(context, i);
        }

        @Override // com.byazt.hsi.s
        public long n() {
            return this.qg;
        }
    };
    public boolean he = false;

    public interface n {
        void fs();

        void n(int i);

        void rv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200 || i == 60008;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public boolean l() {
        return false;
    }

    @Override // com.byazt.du.n
    public boolean lh() {
        return true;
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public boolean q() {
        return false;
    }

    @Override // com.byazt.iag.s
    public boolean s() {
        return false;
    }

    public void q(int i) {
        this.nf = i;
    }

    public void qg(pk pkVar) {
        this.w = pkVar;
    }

    public void n(com.byazt.vd.n nVar) {
        if (this.l != null) {
            this.l.n(nVar);
        }
    }

    public void n(final NativeVideoTsView.n nVar) {
        if (!this.d || this.l == null) {
            return;
        }
        this.l.n(new NativeVideoTsView.n() { // from class: com.byazt.ia.q.3
            @Override // com.byazt.ia.NativeVideoTsView.n
            public void n(View view, int i) {
                NativeVideoTsView.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(view, i);
                }
            }
        });
    }

    public void n(oa oaVar) {
        if (!this.d || this.l == null) {
            return;
        }
        this.l.n(oaVar);
    }

    public void n(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.sh = i;
        this.y = i2;
    }

    private void n(Context context) {
        EnumSet<com.byazt.iag.qg.n> enumSetNoneOf = EnumSet.noneOf(com.byazt.iag.qg.n.class);
        enumSetNoneOf.add(com.byazt.iag.qg.n.hideCloseBtn);
        enumSetNoneOf.add(com.byazt.iag.qg.n.hideBackBtn);
        try {
            this.l = n(context, enumSetNoneOf);
            if (this.l != null) {
                this.l.n((com.byazt.iag.n) this);
                this.l.n((com.byazt.cs.n.InterfaceC0149n) this);
            }
        } catch (Throwable th) {
            k.qg("NativeVideoController", th.getMessage());
        }
    }

    public w n(Context context, EnumSet<com.byazt.iag.qg.n> enumSet) {
        View layoutVideoDetail;
        if (this.d) {
            layoutVideoDetail = qg(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.d) {
            return new w(context, view, true, enumSet, this.w, this, fi(), null);
        }
        return new l(context, view, true, enumSet, this.w, this, false);
    }

    private View qg(final Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387651);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        sz.n(context, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ia.q.4
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(tTProgressBar);
        View viewQg = new com.byazt.un.q().qg(context);
        viewQg.setId(2114387688);
        viewQg.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(viewQg);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387626);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        sz.n(context, "tt_new_play_video", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar2.setIndeterminate(false);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387653);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fS = com.byazt.okk.s.s(context, 1.0f);
        gradientDrawable.setCornerRadius(fS);
        int iS = com.byazt.okk.s.s(context, 2.0f);
        gradientDrawable.setSize(-1, iS);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fS);
        gradientDrawable2.setSize(-1, iS);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fS);
        gradientDrawable3.setSize(-1, iS);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        TTViewStub tTViewStub = new TTViewStub(context, new com.byazt.un.w());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new com.byazt.un.qg());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        TTViewStub tTViewStub3 = new TTViewStub(context, new com.byazt.un.x());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387828);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public q(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        this.an = com.byazt.wg.qg.AD_TAG_FEED;
        this.ae = false;
        this.f = true;
        this.sh = 0;
        this.y = 0;
        this.dn = 1;
        this.dn = hd.s(context);
        n(z);
        this.an = str;
        try {
            this.sh = viewGroup.getWidth();
            this.y = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.bb = viewGroup;
        this.rv = new WeakReference<>(context);
        this.w = pkVar;
        n(context);
        this.j = true;
        this.ae = z2;
        this.f = z3;
    }

    public q(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2) {
        this.an = com.byazt.wg.qg.AD_TAG_FEED;
        this.ae = false;
        this.f = true;
        this.sh = 0;
        this.y = 0;
        this.dn = 1;
        this.dn = hd.s(context);
        try {
            this.sh = viewGroup.getWidth();
            this.y = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.bb = viewGroup;
        this.an = str;
        this.rv = new WeakReference<>(context);
        this.w = pkVar;
        n(context);
        this.j = true;
        this.ae = z;
        this.f = z2;
    }

    @Override // com.byazt.iag.s
    public void n(com.byazt.iag.s.q qVar) {
        this.pk = new WeakReference<>(qVar);
    }

    @Override // com.byazt.iag.s
    public boolean n(com.byazt.zsl.l lVar) {
        lVar.ou();
        if (TextUtils.isEmpty(lVar.ou())) {
            n("url is null");
            k.qg("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.ou = lVar;
        this.hd = lVar.k();
        this.x = lVar.sz();
        if (lVar.sz() > 0) {
            this.x = lVar.sz();
            this.fs = this.fs > this.x ? this.fs : this.x;
        }
        if (this.l != null) {
            this.l.n();
            if (this.hf == 0) {
                this.l.cp();
            }
            this.l.s(lVar.tj(), lVar.cp());
            this.l.s(this.bb);
            this.l.n(lVar.tj(), lVar.cp());
        }
        try {
            if (this.q == null) {
                if (!rf()) {
                    n("create video error");
                    return false;
                }
                this.q.n(this.ci);
            }
            bb();
            this.lh = 0L;
            s(lVar);
            return true;
        } catch (Throwable th) {
            n(th.getMessage());
            k.qg("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    private boolean rf() {
        int i;
        com.byazt.ej.x qVar;
        pk pkVar = this.w;
        this.h = null;
        if (com.byazt.aci.n.qg(pkVar)) {
            com.byazt.hlq.qg qgVarM = m();
            if (qgVarM != null) {
                int iD = com.byazt.vgx.w.d(this.w);
                this.hu = ln();
                this.q = new com.byazt.vzj.qg(qgVarM, com.byazt.aci.n.tj(pkVar), new com.byazt.vmq.q(String.valueOf(iD), this.hu), ta.cd(pkVar), n(this.w));
                i = 1;
            } else {
                if (this.ci != null) {
                    this.ci.n((com.byazt.ej.x) null, new com.byazt.zsl.qg(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.l == null)));
                }
                k.qg("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.byazt.aci.n.s(pkVar)) {
            com.byazt.hlq.qg qgVarM2 = m();
            if (qgVarM2 != null) {
                int iD2 = com.byazt.vgx.w.d(this.w);
                this.hu = ln();
                ArrayList arrayList = new ArrayList();
                Map<com.byazt.ej.k, com.byazt.ej.oa> mapN = com.byazt.aci.n.n(pkVar, this.ou, this.hu, arrayList);
                if (mapN == null || mapN.size() <= 1 || arrayList.size() <= 1) {
                    if (tj.l() && this.ou.m() == 1) {
                        qVar = com.byazt.gks.qg.n().n(rv.getContext(), String.valueOf(iD2));
                    } else {
                        qVar = new com.byazt.vmq.q(String.valueOf(iD2), this.hu);
                    }
                } else {
                    this.h = new com.byazt.vzj.n(new com.byazt.vmq.q(String.valueOf(iD2), null), mapN, arrayList);
                    qVar = this.h;
                }
                this.q = new com.byazt.vzj.s(qVar, com.byazt.aci.n.tj(pkVar), n(pkVar), qgVarM2);
                i = 2;
            } else {
                if (this.ci != null) {
                    this.ci.n((com.byazt.ej.x) null, new com.byazt.zsl.qg(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.l == null)));
                }
                k.qg("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iD3 = com.byazt.vgx.w.d(this.w);
            if (com.byazt.gks.n.n(this.w)) {
                this.q = com.byazt.gks.qg.n().n(rv.getContext(), lh(), (long) ta.x(this.w), rv.qg().qn(), null);
                i = 3;
            } else if (tj.l() && this.ou.m() == 1) {
                this.q = com.byazt.gks.qg.n().n(rv.getContext(), String.valueOf(iD3));
                i = 4;
            } else {
                this.hu = ln();
                this.q = new com.byazt.vmq.q(String.valueOf(iD3), this.hu);
                i = 5;
            }
        }
        if (pkVar != null) {
            com.byazt.de.s.n(pkVar, String.valueOf(com.byazt.vgx.w.cy(this.w)), com.byazt.vgx.w.d(this.w), i, this.w.h());
        }
        return true;
    }

    @Override // com.byazt.iag.s
    public int k() {
        return com.byazt.udy.n.n(this.fs, this.cy);
    }

    @Override // com.byazt.iag.s
    public void qg(Map<String, Object> map) {
        this.pe = map;
    }

    @Override // com.byazt.du.n
    public Map<String, Object> pk() {
        return this.pe;
    }

    private void s(com.byazt.zsl.l lVar) {
        if (lVar == null) {
            n("model is null");
            return;
        }
        boolean z = false;
        if (this.q != null) {
            if (this.w != null) {
                lVar.q(String.valueOf(com.byazt.vgx.w.cy(this.w)));
            }
            lVar.q(0);
            com.byazt.de.s.qg(z());
            this.q.n(lVar);
        }
        this.ln = System.currentTimeMillis();
        if (!TextUtils.isEmpty(lVar.ou())) {
            if (this.l != null) {
                this.l.l(8);
                this.l.l(0);
            }
            boolean zQ = com.byazt.vgx.w.q(this.w);
            boolean zS = com.byazt.vgx.w.s(this.w);
            boolean zQg = this.l != null ? com.byazt.okk.q.qg(this.l.n, 50, 9) : true;
            boolean zNf = rv.qg().nf();
            Runnable runnable = new Runnable() { // from class: com.byazt.ia.q.5
                @Override // java.lang.Runnable
                public void run() {
                    q.this.py.n();
                    q.this.u();
                    q.this.ln = System.currentTimeMillis();
                    if (q.this.l != null) {
                        q.this.l.q(0);
                    }
                    q.this.e = 1;
                    q.this.yw = false;
                    q.this.cx = false;
                    com.byazt.de.s.n(q.this.z(), q.this.e);
                    q.this.q.n(true, q.this.x, q.this.hd);
                }
            };
            if (zQ || (zS && !zNf)) {
                z = true;
            }
            if (z && !zQg) {
                qg(runnable);
                fs(true);
                WeakReference<n> weakReference = this.wo;
                if (weakReference != null && weakReference.get() != null) {
                    this.wo.get().rv();
                }
            } else {
                n(runnable);
            }
        } else {
            n("url is null");
        }
        if (this.d) {
            sh();
        }
    }

    @Override // com.byazt.iag.s
    public void n(com.byazt.iag.s.qg qgVar) {
        this.fi = new WeakReference<>(qgVar);
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public long d() {
        if (hd() == null) {
            return 0L;
        }
        return hd().cy();
    }

    @Override // com.byazt.iag.s
    public int oa() {
        if (hd() == null) {
            return 0;
        }
        return hd().um();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh() {
        this.hf++;
        if (v() && this.l != null) {
            this.l.qg();
            com.byazt.iag.s.n nVar = this.v;
            if (nVar != null) {
                nVar.n(this.lh, com.byazt.udy.n.n(this.x, this.cy));
            }
            this.lh = System.currentTimeMillis() - this.ln;
            this.l.l(true);
            boolean zN = com.byazt.gks.n.n(this.w);
            int iZe = this.w.ze();
            boolean z = iZe <= 0;
            boolean z2 = !z && this.hf >= iZe;
            boolean zQ = com.byazt.vgx.w.q(this.w);
            if (!zQ || z2 || zN) {
                this.l.n(this.w, this.rv, true);
            }
            if (!this.py.n(64) || b() || ri()) {
                this.py.s(64);
                qg(this.cy, this.cy);
                long j = this.cy;
                this.x = j;
                this.fs = j;
                um.n nVarDf = df();
                nVarDf.n(cp());
                nVarDf.s(sz());
                nVarDf.qg(d());
                nVarDf.w(oa());
                com.byazt.gw.s.q(this.l, nVarDf);
            }
            if (!this.d && this.a) {
                l(this.l, (View) null);
            }
            this.um = true;
            if (zN) {
                return;
            }
            if (zQ && (z || this.hf < iZe)) {
                h();
                return;
            }
            if (!(com.byazt.ql.s.n(this.w) && (((sz() / 1000) > 10L ? 1 : ((sz() / 1000) == 10L ? 0 : -1)) < 0)) || this.hf >= 2) {
                return;
            }
            h();
        }
    }

    @Override // com.byazt.iag.s
    public void n(com.byazt.iag.s.n nVar) {
        this.v = nVar;
    }

    @Override // com.byazt.iag.s
    public void w() {
        if (this.q != null) {
            this.q.q();
        }
        if ((!this.py.n(64) || b()) && this.py.n(2)) {
            um.n nVarDf = df();
            nVarDf.n(cp());
            nVarDf.s(sz());
            nVarDf.qg(d());
            n(this.l, nVarDf);
        }
    }

    @Override // com.byazt.iag.s
    public void n(Map<String, Object> map) {
        if (this.q != null) {
            this.q.q();
        }
        if ((!this.py.n(64) || b()) && this.py.n(2)) {
            um.n nVarDf = df();
            nVarDf.n(cp());
            nVarDf.s(sz());
            nVarDf.qg(d());
            if (map != null) {
                nVarDf.n(map);
            }
            n(this.l, nVarDf);
        }
    }

    private boolean b() {
        return this.hf > 0 && com.byazt.vgx.w.q(this.w);
    }

    private boolean ri() {
        return this.hf > 0 && com.byazt.ql.s.n(this.w);
    }

    @Override // com.byazt.iag.s
    public void x() {
        if (this.q != null) {
            this.q.q();
        }
    }

    @Override // com.byazt.iag.s
    public void fs() {
        if (this.l != null) {
            this.l.n();
        }
        if (this.l != null) {
            this.l.m();
        }
        pe();
    }

    public void w(boolean z) {
        if (this.l != null) {
            this.l.n();
        }
        if (this.l != null && z) {
            this.l.m();
        }
        pe();
    }

    private boolean nf() {
        return this.d && com.byazt.vyf.s.cy().e() > 0;
    }

    private void pe() {
        Object[] objArr = new Object[2];
        Boolean.valueOf(this.tj);
        if (this.q != null) {
            if (this.q.d() && !nf()) {
                if (this.tj || ((this.ou != null && this.ou.fs()) || com.byazt.aci.n.qg(this.w))) {
                    ae();
                } else {
                    qg(this.t);
                }
                Object[] objArr2 = new Object[2];
                Boolean.valueOf(this.tj);
            } else if (nf()) {
                this.x = com.byazt.vyf.s.cy().e();
                com.byazt.vyf.s.cy().n(-1L);
                this.q.n(this.x);
                this.q.s();
            } else {
                this.e = 1;
                this.yw = false;
                this.q.n(false, this.x, this.hd);
            }
        }
        if (this.py.n(2)) {
            um.n nVarDf = df();
            nVarDf.n(cp());
            nVarDf.s(sz());
            nVarDf.qg(d());
            qg(cd(), nVarDf);
        }
    }

    @Override // com.byazt.iag.s
    public void n(long j) {
        this.x = j;
        this.fs = this.fs > this.x ? this.fs : this.x;
        if (this.l != null) {
            this.l.n();
        }
        if (this.q != null) {
            this.e = 1;
            this.yw = false;
            this.q.n(true, this.x, this.hd);
        }
    }

    @Override // com.byazt.iag.s
    public void rv() {
        n(true, 3);
    }

    @Override // com.byazt.iag.s
    public void n(boolean z, int i) {
        if (this.d) {
            n(1);
        }
        long jSz = sz();
        if ((!this.py.n(64) || b()) && this.py.n(1) && jSz > 0) {
            if (z) {
                um.n nVarDf = df();
                nVarDf.n(cp());
                nVarDf.s(jSz);
                nVarDf.qg(d());
                nVarDf.l(i);
                nVarDf.w(oa());
                this.py.s(32);
                com.byazt.gw.s.n(this.l, nVarDf, this.pe, !this.py.n(2) ? 1 : 0);
            } else {
                um.n nVarDf2 = df();
                nVarDf2.n(cp());
                nVarDf2.s(jSz);
                nVarDf2.qg(d());
                n(this.l, nVarDf2);
            }
        }
        tj();
    }

    @Override // com.byazt.iag.s
    public void tj() {
        qg(sz() == 0 ? -2 : -1);
        if (this.q != null) {
            this.q.w();
            this.q = null;
            this.h = null;
        }
        int iZe = this.w == null ? 2 : this.w.ze();
        boolean z = iZe > 0 && this.hf == iZe;
        if (!com.byazt.vgx.w.q(this.w) || z) {
            try {
                this.l.n(this.w, this.rv, true);
            } catch (Exception e) {
                k.qg("NativeVideoController", e.getMessage());
            }
        }
        if (this.n != null) {
            this.n.removeCallbacksAndMessages(null);
        }
        if (this.cp != null) {
            this.cp.clear();
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.py.n(2) || b()) {
            um.n nVarDf = df();
            if (yw()) {
                this.dg = true;
            }
            nVarDf.qg(this.dg);
            nVarDf.s(sz());
            this.py.s(2);
            com.byazt.gw.s.n(this.l, nVarDf);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0091 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a3 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00d7 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    public void qg(int i, int i2) {
        ViewGroup viewGroup;
        int iRound;
        int iRound2;
        RelativeLayout.LayoutParams layoutParams;
        Object objM;
        ViewGroup.LayoutParams layoutParams2;
        try {
            if (this.rv != null && this.rv.get() != null && m() != null && this.q != null && (viewGroup = this.bb) != null && viewGroup != null) {
                if (i < 0 && i2 < 0) {
                    i = this.q.hd();
                    i2 = this.q.cd();
                }
                int width = this.bb.getWidth();
                int height = this.bb.getHeight();
                if (width > 0 && height > 0 && i2 > 0 && i > 0) {
                    if (i != i2) {
                        if (i > i2) {
                            iRound = (int) Math.round((((double) width) * 1.0d) / ((double) ((i * 1.0f) / i2)));
                            iRound2 = width;
                        } else if (cx()) {
                            iRound = 0;
                        } else {
                            iRound2 = (int) Math.round(((double) (height * 1.0f)) / ((double) ((i2 * 1.0f) / i)));
                            iRound = height;
                        }
                        if (iRound <= height || iRound <= 0) {
                            iRound = height;
                        }
                        if (qg(i, i2, iRound2, width)) {
                            iRound2 = width;
                        }
                        if (cx()) {
                            n(i, i2, width, height);
                            return;
                        }
                        layoutParams = new RelativeLayout.LayoutParams(iRound2, iRound);
                        layoutParams.addRule(13);
                        objM = m();
                        if (objM instanceof TextureView) {
                            ((TextureView) objM).setLayoutParams(layoutParams);
                        } else if (objM instanceof UpieVideoView) {
                            ((UpieVideoView) objM).setLayoutParams(layoutParams);
                        } else if (objM instanceof SurfaceView) {
                            ((SurfaceView) objM).setLayoutParams(layoutParams);
                        }
                        if (s(i, i2) && (layoutParams2 = this.bb.getLayoutParams()) != null) {
                            layoutParams2.height = iRound;
                            layoutParams2.width = iRound2;
                            this.bb.setLayoutParams(layoutParams2);
                            if (this.l != null) {
                                this.l.n(layoutParams2.width, layoutParams2.height);
                            }
                        }
                        n(width, height, iRound2, iRound);
                        return;
                    }
                    iRound = width > height ? height : width;
                    iRound2 = iRound;
                    if (iRound <= height) {
                        iRound = height;
                    } else {
                        iRound = height;
                    }
                    if (qg(i, i2, iRound2, width)) {
                        iRound2 = width;
                    }
                    if (cx()) {
                        n(i, i2, width, height);
                        return;
                    }
                    layoutParams = new RelativeLayout.LayoutParams(iRound2, iRound);
                    layoutParams.addRule(13);
                    objM = m();
                    if (objM instanceof TextureView) {
                        ((TextureView) objM).setLayoutParams(layoutParams);
                    } else if (objM instanceof UpieVideoView) {
                        ((UpieVideoView) objM).setLayoutParams(layoutParams);
                    } else if (objM instanceof SurfaceView) {
                        ((SurfaceView) objM).setLayoutParams(layoutParams);
                    }
                    if (s(i, i2)) {
                        layoutParams2.height = iRound;
                        layoutParams2.width = iRound2;
                        this.bb.setLayoutParams(layoutParams2);
                        if (this.l != null) {
                            this.l.n(layoutParams2.width, layoutParams2.height);
                        }
                    }
                    n(width, height, iRound2, iRound);
                    return;
                }
                return;
            }
            if (this.rv != null) {
                this.rv.get();
            }
            m();
        } catch (Throwable unused) {
        }
    }

    private void n(float f, float f2, float f3, float f4) {
        boolean zTj;
        if (rv.qg().k()) {
            WeakReference<n> weakReference = this.wo;
            View view = null;
            n nVar = weakReference != null ? weakReference.get() : null;
            if (nVar instanceof NativeVideoTsView) {
                NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) nVar;
                zTj = nativeVideoTsView.tj();
                Object parent = nativeVideoTsView.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                }
            } else {
                zTj = true;
            }
            View view2 = view;
            if (zTj) {
                com.byazt.eji.s.n().n(this.w, f, f2, f3, f4, view2);
            }
        }
    }

    private void n(int i, int i2, int i3, int i4) {
        Matrix matrix;
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        try {
            Object objM = m();
            if (objM instanceof TextureView) {
                matrix = ((TextureView) objM).getMatrix();
            } else if (objM instanceof UpieVideoView) {
                matrix = ((UpieVideoView) objM).getMatrix();
            } else {
                matrix = objM instanceof SurfaceView ? ((SurfaceView) objM).getMatrix() : null;
            }
            float fMax = Math.max(f3, f6);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i3 - i) / 2, (i4 - i2) / 2);
            matrix.preScale(f2 / f, f5 / f4);
            matrix.postScale(fMax, fMax, i3 / 2, i4 / 2);
            if (objM instanceof TextureView) {
                ((TextureView) objM).setTransform(matrix);
                ((TextureView) objM).postInvalidate();
                return;
            }
            if (objM instanceof UpieVideoView) {
                LottieAnimationView lottieAnimationViewN = n((View) objM);
                if (lottieAnimationViewN != null) {
                    lottieAnimationViewN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                }
                return;
            }
            if (objM instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) objM).setAnimationMatrix(matrix);
                }
                ((SurfaceView) objM).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    private LottieAnimationView n(View view) {
        LottieAnimationView lottieAnimationViewN;
        if (view instanceof LottieAnimationView) {
            return (LottieAnimationView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof LottieAnimationView) {
                return (LottieAnimationView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (lottieAnimationViewN = n(childAt)) != null) {
                return lottieAnimationViewN;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yw() {
        return TextUtils.equals(this.an, "splash_ad") || TextUtils.equals(this.an, "cache_splash_ad");
    }

    private boolean cx() {
        i iVarDd;
        if (yw()) {
            return this.w == null || (iVarDd = this.w.dd()) == null || iVarDd.n() != 0;
        }
        return false;
    }

    private boolean qg(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !s(i, i2)) || i3 <= 0;
    }

    private boolean s(int i, int i2) {
        return i < i2 && lq();
    }

    private boolean lq() {
        return this.w != null && this.w.qh() == 1 && "draw_ad".equals(this.an) && this.bb != null;
    }

    public com.byazt.hlq.qg m() {
        if (this.rv == null || this.rv.get() == null) {
            return null;
        }
        if ((this.rv.get().getResources().getConfiguration().orientation == 1 || com.byazt.aci.n.n(this.w)) && this.l != null) {
            return this.l.hd();
        }
        return null;
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, View view) {
        if (this.q == null || !v()) {
            return;
        }
        if (this.q.tj()) {
            w();
            if (this.l != null) {
                this.l.qg(true, false);
                this.l.tj();
                return;
            }
            return;
        }
        if (!this.q.d()) {
            if (this.l != null) {
                this.l.s(this.bb);
            }
            n(this.x);
            if (this.l != null) {
                this.l.qg(false, false);
                return;
            }
            return;
        }
        w(false);
        if (this.l != null) {
            this.l.qg(false, false);
        }
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, int i) {
        if (this.q == null) {
            return;
        }
        n(this.kc, w(i));
    }

    @Override // com.byazt.iag.n
    public void qg(com.byazt.iag.qg qgVar, int i) {
        if (this.l != null) {
            this.l.tj();
        }
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, int i, boolean z) {
        if (v()) {
            long j = (long) (((((long) i) * this.cy) * 1.0f) / 100.0f);
            if (this.cy > 0) {
                this.kc = (int) j;
            } else {
                this.kc = 0L;
            }
            if (this.l != null) {
                this.l.n(this.kc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j, long j2) {
        this.x = j;
        this.cy = j2;
        if (this.l != null) {
            this.l.n(j, j2);
            this.l.qg(com.byazt.udy.n.n(j, j2));
        }
        try {
            com.byazt.iag.s.n nVar = this.v;
            if (nVar != null) {
                nVar.n(j, j2);
            }
        } catch (Throwable th) {
            k.n("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.byazt.iag.n
    public void qg(com.byazt.iag.qg qgVar, View view) {
        qg(qgVar, view, false, false);
    }

    public void qg(com.byazt.iag.qg qgVar, View view, boolean z, boolean z2) {
        if (v()) {
            rv(!this.a);
            if (this.rv.get() instanceof Activity) {
                if (this.a) {
                    l(z ? 8 : 0);
                    if (this.l != null) {
                        this.l.n(this.bb);
                        this.l.s(false);
                    }
                } else {
                    l(1);
                    if (this.l != null) {
                        this.l.qg(this.bb);
                        this.l.s(false);
                    }
                }
                WeakReference<com.byazt.iag.s.qg> weakReference = this.fi;
                com.byazt.iag.s.qg qgVar2 = weakReference != null ? weakReference.get() : null;
                if (qgVar2 != null) {
                    qgVar2.n(this.a);
                }
            }
        }
    }

    public void l(int i) {
        if (v()) {
            boolean z = i == 0 || i == 8;
            Context context = this.rv.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.byazt.iag.n
    public void s(com.byazt.iag.qg qgVar, View view) {
        if (this.l != null) {
            this.l.oa();
        }
        n(1);
        n(true, 3);
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, View view, boolean z, boolean z2) {
        if (this.d) {
            w();
        }
        if (this.l == null) {
            return;
        }
        if (z && !this.d && !hu()) {
            this.l.qg(!wo(), false);
            this.l.n(z2, true, false);
        }
        if (this.q != null && this.q.tj()) {
            this.l.tj();
            this.l.rv();
        } else {
            this.l.tj();
        }
    }

    @Override // com.byazt.iag.n
    public void q(com.byazt.iag.qg qgVar, View view) {
        if (this.a) {
            rv(false);
            if (this.l != null) {
                this.l.qg(this.bb);
            }
            l(1);
            return;
        }
        n(1);
        n(true, 3);
    }

    @Override // com.byazt.iag.n
    public void l(com.byazt.iag.qg qgVar, View view) {
        n(qgVar, view, false);
    }

    public void n(com.byazt.iag.qg qgVar, View view, boolean z) {
        ic();
    }

    private void ic() {
        if (v()) {
            rv(!this.a);
            if (this.rv.get() instanceof Activity) {
                if (this.l != null) {
                    this.l.qg(this.bb);
                    this.l.s(false);
                }
                l(1);
                WeakReference<com.byazt.iag.s.qg> weakReference = this.fi;
                com.byazt.iag.s.qg qgVar = weakReference != null ? weakReference.get() : null;
                if (qgVar != null) {
                    qgVar.n(this.a);
                }
            }
        }
    }

    public boolean hu() {
        return this.q == null || this.q.k();
    }

    public void h() {
        if (hd.s(rv.getContext()) == 0) {
            return;
        }
        if (this.l != null) {
            this.l.n();
        }
        s(false);
        if (this.q != null) {
            this.py.n();
            u();
            this.e = 2;
            this.yw = false;
            this.q.qg();
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci() {
        if (!this.u || this.l == null || this.l.s() == null) {
            return;
        }
        this.u = false;
        this.l.s().post(new Runnable() { // from class: com.byazt.ia.q.7
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.ou == null) {
                    return;
                }
                q.this.ou.qg(q.this.w.q());
                q.this.ou.qg(q.this.sh);
                q.this.ou.s(q.this.y);
                q.this.ou.n((List<String>) null);
                q.this.ou.s(q.this.w.F_());
                q.this.ou.n(0L);
                q.this.ou.qg(q.this.um());
                q.this.ou.n(q.this.ou.l());
                q qVar = q.this;
                qVar.n(qVar.ou);
                q.this.s(false);
            }
        });
    }

    @Override // com.byazt.iag.n
    public void n() {
        if (hd.s(rv.getContext()) == 0) {
            return;
        }
        this.u = true;
        if (this.q == null) {
            tj();
            ci();
        } else {
            tj();
        }
    }

    public boolean wo() {
        return this.q != null && this.q.tj();
    }

    private void n(long j, boolean z) {
        if (this.q == null) {
            return;
        }
        if (z) {
            hf();
        }
        this.q.n(j);
    }

    private boolean w(int i) {
        return this.l != null && this.l.s(i);
    }

    private void hf() {
        if (this.l != null) {
            this.l.q(0);
            this.l.n(false, false);
            this.l.s(false);
            this.l.rv();
            this.l.cp();
        }
    }

    /* JADX INFO: renamed from: com.byazt.ia.q$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 63})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.mr.k.n.values().length];
            n = iArr;
            try {
                iArr[com.byazt.mr.k.n.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.mr.k.n.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.mr.k.n.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.byazt.ia.qg
    public void n(com.byazt.mr.k.n nVar, String str) {
        int i = AnonymousClass2.n[nVar.ordinal()];
        if (i == 1) {
            w();
            return;
        }
        if (i == 2) {
            n(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            fs();
            this.k = false;
            this.df = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(int i) {
        int iS = hd.s(rv.getContext());
        if (iS == 0) {
            w();
            this.k = true;
            if (this.l != null) {
                this.l.n(this.w, this.rv, false);
            }
        }
        if (iS != 4 && iS != 0) {
            if (this.l != null) {
                this.l.n();
            }
            w();
            this.k = true;
            this.df = false;
            if (this.l != null && this.w != null) {
                return this.l.n(i, ta.k(this.w), this.f);
            }
        } else if (iS == 4) {
            this.k = false;
            if (this.l != null) {
                this.l.a();
            }
        }
        return true;
    }

    private void qg(Context context, int i) {
        if (!v() || context == null || this.dn == i) {
            return;
        }
        this.dn = i;
        if (i != 4 && i != 0) {
            this.df = false;
        }
        if (!this.df && !a() && this.ae) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.ia.q.9
                @Override // java.lang.Runnable
                public void run() {
                    q.this.x(2);
                }
            });
        }
        WeakReference<n> weakReference = this.wo;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wo.get().n(this.dn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context, int i) {
        qg(context, i);
        if (i == 4) {
            this.k = false;
        }
    }

    public void n(Context context, int i) {
        qg(context, i);
        if (i == 4) {
            this.k = false;
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.ia.q.10
                @Override // java.lang.Runnable
                public void run() {
                    q.this.fs();
                }
            });
        }
    }

    public void sh() {
        if (this.he || !this.b) {
            return;
        }
        this.he = true;
        ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(this.z);
    }

    public void y() {
        if (this.he) {
            this.he = false;
            try {
                ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).qg(this.z);
            } catch (Throwable unused) {
            }
        }
    }

    public void n(n nVar) {
        this.wo = new WeakReference<>(nVar);
    }

    @Override // com.byazt.iag.s
    public boolean py() {
        return this.dg;
    }

    @Override // com.byazt.iag.s
    public void q(boolean z) {
        this.dg = z;
    }

    @Override // com.byazt.iag.s
    public boolean ou() {
        return this.dh;
    }

    @Override // com.byazt.iag.s
    public void l(boolean z) {
        this.b = z;
    }

    @Override // com.byazt.iag.s
    public void qg(com.byazt.zsl.l lVar) {
        this.ou = lVar;
    }

    @Override // com.byazt.du.n, com.byazt.iag.s
    public void wm() {
        super.wm();
        this.b = false;
        this.u = false;
        this.v = null;
        this.wo = null;
        if (this.q != null) {
            this.q.w();
            this.q = null;
            this.h = null;
        }
        if (this.n != null) {
            this.n.removeCallbacksAndMessages(null);
        }
        if (this.cp != null) {
            this.cp.clear();
        }
        y();
    }

    @Override // com.byazt.du.n
    public void u() {
        if (this.rv == null) {
            return;
        }
        this.m = com.byazt.gw.s.n();
        if (this.hu != null) {
            this.hu.n(this.m);
        }
        this.py.s(1);
        com.byazt.gw.s.n(this.w, this.l, this.ou, this.dg, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc() {
        if (com.byazt.gks.n.n(this.w) && !TextUtils.isEmpty(this.an)) {
            boolean zN = this.py.n(1024);
            long jLongValue = this.py.qg(1).longValue();
            if (zN) {
                return;
            }
            this.py.s(1024);
            if (this.an.equals(com.byazt.wg.qg.AD_TAG_FEED)) {
                com.byazt.hm.n.n(this.w, com.byazt.wg.qg.AD_TAG_FEED, System.currentTimeMillis() - jLongValue, com.byazt.gw.s.n(this.l));
            } else if (this.an.equals("draw_ad")) {
                com.byazt.hm.n.n(this.w, "draw_ad", System.currentTimeMillis() - jLongValue, com.byazt.gw.s.n(this.l));
            }
        }
    }

    @Override // com.byazt.iag.s
    public void n(int i) {
        if (com.byazt.gks.n.n(this.w)) {
            if (this.ri <= 0) {
                this.ri = System.currentTimeMillis();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.ri;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(oa()));
                jSONObject.putOpt("buffer_time", Long.valueOf(d()));
            } catch (Exception unused) {
            }
            if (!this.py.n(512)) {
                this.py.s(512);
                if (this.an.equals(com.byazt.wg.qg.AD_TAG_FEED)) {
                    com.byazt.hm.n.n(this.w, com.byazt.wg.qg.AD_TAG_FEED, jCurrentTimeMillis, jSONObject, com.byazt.gw.s.n(this.l));
                } else if (this.an.equals("draw_ad")) {
                    com.byazt.hm.n.n(this.w, "draw_ad", jCurrentTimeMillis, jSONObject, com.byazt.gw.s.n(this.l));
                }
            }
            if (com.byazt.gks.n.n(this.w)) {
                if (com.byazt.wq.qg.n().n(this.w)) {
                    com.byazt.wq.qg.n().n(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.w, jCurrentTimeMillis);
                } else {
                    com.byazt.gks.n.n(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.w, jCurrentTimeMillis);
                }
            }
        }
    }

    @Override // com.byazt.iag.s
    public void qg() {
        if (this.q != null) {
            s(false);
            this.e = 2;
            this.yw = false;
            this.q.qg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (com.byazt.gks.n.n(this.w)) {
            if (this.an.equals(com.byazt.wg.qg.AD_TAG_FEED)) {
                com.byazt.hm.n.n(this.w, com.byazt.wg.qg.AD_TAG_FEED, i, str, com.byazt.gw.s.n(this.l));
            } else if (this.an.equals("draw_ad")) {
                com.byazt.hm.n.n(this.w, "draw_ad", i, str, com.byazt.gw.s.n(this.l));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z() {
        if (this.w == null) {
            return null;
        }
        return this.w.h();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.s.s(z(), 3);
    }
}
