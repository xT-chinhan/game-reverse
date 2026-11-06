package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.widget.u;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends c {
    private TextView am;
    private ImageView az;
    private int bz;
    private int ce;
    private TextView e;
    private float ec;
    private ImageView eg;
    private View fm;
    private boolean gs;
    private ColorStateList gy;
    private boolean ih;
    private TextView il;
    private u j;
    private boolean jm;
    private int jy;
    private TextView k;
    private final Rect kl;
    private SeekBar l;
    private TextView lm;
    private View m;
    private ColorStateList n;
    private final Rect nn;
    private float o;
    private final View.OnTouchListener oh;
    private View qf;
    private int qk;
    private final Rect qr;
    private boolean r;
    private int rt;
    private boolean s;
    private TextView sa;
    private final Rect sk;
    private final le ti;
    private float tk;
    private ImageView tz;
    private TextView ul;
    private boolean v;
    private final Rect vf;
    private float vl;
    private int vm;
    private int vy;
    private ImageView xn;
    private ColorStateList z;
    private float zd;
    private int zf;

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bykv.vk.openvk.component.video.api.d.xr
    public /* bridge */ /* synthetic */ void ms(lm lmVar, WeakReference weakReference, boolean z) {
        ms(lmVar, (WeakReference<Context>) weakReference, z);
    }

    public ka(Context context, View view, boolean z, EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> enumSet, lm lmVar, com.bykv.vk.openvk.component.video.api.d.ah ahVar, boolean z2) {
        super(context, view, z, enumSet, lmVar, ahVar, z2, null);
        this.ti = new le(Looper.getMainLooper(), this);
        this.s = false;
        this.v = false;
        this.qk = 0;
        this.vm = 0;
        this.zf = 0;
        this.rt = 0;
        this.vy = 0;
        this.sk = new Rect();
        this.qr = new Rect();
        this.ce = 0;
        this.bz = 0;
        this.jy = 0;
        this.j = null;
        this.ih = false;
        this.oh = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.7
            private float xr;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        ka.this.ih = Math.abs(this.xr - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.xr = x;
                }
                return false;
            }
        };
        this.nn = new Rect();
        this.vf = new Rect();
        this.kl = new Rect();
        this.yu = re.getContext().getApplicationContext();
        d(z2);
        this.f3616ms = view;
        this.nw = z;
        u uVar = new u(this);
        this.j = uVar;
        uVar.ms(this.nw);
        DisplayMetrics displayMetrics = this.yu.getResources().getDisplayMetrics();
        this.bz = displayMetrics.widthPixels;
        this.jy = displayMetrics.heightPixels;
        this.i = enumSet == null ? EnumSet.noneOf(com.bykv.vk.openvk.component.video.api.d.xr.ms.class) : enumSet;
        this.of = ahVar;
        this.w = lmVar;
        d(8);
        ms(context, this.f3616ms, lmVar);
        d();
        ao();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    protected void ms(Context context, View view, lm lmVar) {
        super.ms(context, view, lmVar);
        this.ul = (TextView) view.findViewById(2114387765);
        this.az = (ImageView) view.findViewById(2114387684);
        this.m = view.findViewById(2114387611);
        this.eg = (ImageView) view.findViewById(2114387903);
        this.lm = (TextView) view.findViewById(2114387736);
        this.e = (TextView) view.findViewById(2114387712);
        this.k = (TextView) view.findViewById(2114387852);
        this.fm = view.findViewById(2114387829);
        this.xn = (ImageView) view.findViewById(2114387624);
        this.il = (TextView) view.findViewById(2114387866);
        this.l = (SeekBar) view.findViewById(2114387878);
        this.am = (TextView) view.findViewById(2114387674);
        this.sa = (TextView) view.findViewById(2114387817);
        this.qf = view.findViewById(2114387634);
        this.tz = (ImageView) view.findViewById(2114387667);
        this.ab = (TTViewStub) view.findViewById(2114387750);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    protected void d() {
        super.d();
        this.j.ms(this.f3616ms);
        ul.ms((View) this.az, (this.nw || this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideCloseBtn)) ? 8 : 0);
        this.az.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ka.this.nw()) {
                    ka.this.le.ah(ka.this, view);
                }
            }
        });
        ul.ms((View) this.ul, (!this.nw || this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.alwayShowBackBtn)) ? 0 : 8);
        this.ul.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ka.this.nw()) {
                    ka.this.le.d(ka.this, view);
                }
            }
        });
        this.eg.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ka.this.nw()) {
                    ka.this.le.ka(ka.this, view);
                }
            }
        });
        this.xn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.this.xr(false, true);
                ka.this.x();
                ka.this.ab();
                ka.this.nw();
            }
        });
        this.tz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ka.this.nw()) {
                    ka.this.le.xr(ka.this, view);
                }
            }
        });
        this.l.setThumbOffset(0);
        this.l.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!ka.this.s && ka.this.yu != null) {
                    seekBar.setThumb(ka.xr(15, "#1E000000"));
                }
                if (ka.this.nw()) {
                    seekBar.setThumbOffset(0);
                    ka.this.le.ms(ka.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!ka.this.s && ka.this.yu != null) {
                    seekBar.setThumb(ka.xr(22, "#1E000000"));
                }
                if (ka.this.nw()) {
                    seekBar.setThumbOffset(0);
                    ka.this.le.xr(ka.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (ka.this.nw()) {
                    ka.this.le.ms(ka.this, i, z);
                }
            }
        });
        this.l.setOnTouchListener(this.oh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable xr(int i, String str) {
        Context context = re.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iAh = ul.ah(context, i);
        shapeDrawable.setIntrinsicWidth(iAh);
        shapeDrawable.setIntrinsicHeight(iAh);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ul.ah(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ka() {
        this.ti.removeMessages(1);
        this.ti.sendMessageDelayed(this.ti.obtainMessage(1), a.f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c() {
        this.ti.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void xr(boolean z) {
        int i = ch() ? this.jy : this.h;
        int dimensionPixelSize = ch() ? this.bz : this.qv;
        if (this.t <= 0 || this.y <= 0 || i <= 0) {
            return;
        }
        if (!hi() && !ch() && !this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.fixedSize)) {
            dimensionPixelSize = this.yu.getResources().getDimensionPixelSize(t.x(this.yu, "tt_video_container_maxheight"));
        }
        int i2 = (int) (this.t * ((i * 1.0f) / this.y));
        if (i2 > dimensionPixelSize) {
            i = (int) (this.y * ((dimensionPixelSize * 1.0f) / this.t));
        } else {
            dimensionPixelSize = i2;
        }
        if (!z && !ch()) {
            i = this.h;
            dimensionPixelSize = this.qv;
        }
        this.xr.ms(i, dimensionPixelSize);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(String str) {
        TextView textView = this.lm;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void xr(int i) {
        View view = this.qf;
        if (view != null && view.getVisibility() == 0) {
            ul.ms((View) this.ub, 8);
            return;
        }
        ul.ms((View) this.ub, 0);
        this.l.setProgress(i);
        this.ub.setProgress(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(long j, long j2) {
        this.am.setText(com.bykv.vk.openvk.component.video.ms.ka.ms.ms(j2));
        this.sa.setText(com.bykv.vk.openvk.component.video.ms.ka.ms.ms(j));
        this.l.setProgress(com.bykv.vk.openvk.component.video.ms.ka.ms.ms(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ab() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.w)) {
            b();
            return;
        }
        ul.c(this.d);
        ul.c(this.ka);
        ul.ka(this.fm);
        if (this.c != null && this.w != null && !TextUtils.isEmpty(qr.xr(this.w))) {
            ul.c(this.c);
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.w)).ms(this.c);
            ms(this.c, qr.xr(this.w));
        }
        if (this.ah.getVisibility() == 0) {
            ul.ms((View) this.ah, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bykv.vk.openvk.component.video.api.d.xr
    public void ms() {
        ms(false, this.nw);
        w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(long j) {
        this.sa.setText(com.bykv.vk.openvk.component.video.ms.ka.ms.ms(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(lm lmVar, WeakReference<Context> weakReference, boolean z) {
        if (lmVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            ms(re.getContext(), this.f3616ms);
            qv();
            return;
        }
        ms(this.f3616ms, re.getContext());
        ms(false, this.nw);
        ul.ms(this.x, 0);
        ul.ms((View) this.ny, 0);
        ul.ms(this.ch, 0);
        if (this.ny != null && this.w != null && !TextUtils.isEmpty(qr.xr(this.w))) {
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.w)).ms(this.ny);
            ms(this.ny, qr.xr(this.w));
        }
        ul.ms((View) this.u, 0);
        ul.ms((View) this.hi, 8);
        ul.ms((View) this.sl, 8);
        ul.ms((View) this.zb, 8);
        ul.ms(this.u, t.ms(this.yu, "tt_video_dial_replay"));
        ul.ms(this.u, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ka.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ka.this.le != null) {
                    ka.this.le.ms();
                }
            }
        }, "video_ad_button");
        ul.ms(this.u, (View.OnTouchListener) null, "video_ad_button");
        if (of()) {
            ul.ms(this.ch, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void x() {
        ul.ka(this.d);
        ul.ka(this.fm);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ny() {
        this.l.setProgress(0);
        this.l.setSecondaryProgress(0);
        this.ub.setProgress(0);
        this.ub.setSecondaryProgress(0);
        this.am.setText(t.ms(this.yu, "tt_00_00"));
        this.sa.setText(t.ms(this.yu, "tt_00_00"));
        d(8);
        if (le()) {
            this.xr.setVisibility(8);
        }
        if (this.c != null) {
            this.c.setImageDrawable(null);
            this.c.setBackground(null);
        }
        d(8);
        ul.ms(this.qf, 8);
        ul.ms(this.x, 8);
        ul.ms((View) this.ny, 8);
        ul.ms(this.ch, 8);
        ul.ms((View) this.hi, 8);
        ul.ms((View) this.sl, 8);
        ul.ms((View) this.zb, 8);
        if (this.op != null) {
            this.op.ms(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bytedance.sdk.openadsdk.core.widget.ub.xr
    public boolean ch() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean hi() {
        return this.nw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(ViewGroup viewGroup) {
        if (viewGroup != null && (this.f3616ms.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.s = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3616ms.getLayoutParams();
            this.vm = marginLayoutParams.leftMargin;
            this.qk = marginLayoutParams.topMargin;
            this.zf = marginLayoutParams.width;
            this.rt = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f3616ms.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.vy = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.sk.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ul.xr(viewGroup, 0, 0, 0, 0);
            }
            xr(true);
            t.ms(this.yu, "tt_shrink_video", this.tz);
            this.l.setThumb(xr(18, "#00000000"));
            this.l.setThumbOffset(0);
            com.bykv.vk.openvk.component.video.ms.ka.ms.ms(this.f3616ms, false);
            c(this.s);
            ul.ms(this.m, 8);
            if (!this.nw) {
                ul.ms((View) this.az, 8);
                ul.ms((View) this.ul, 8);
            } else if (this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideCloseBtn)) {
                ul.ms((View) this.az, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void xr(ViewGroup viewGroup) {
        sl.d("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || this.f3616ms == null || !(this.f3616ms.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.s = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3616ms.getLayoutParams();
        marginLayoutParams.width = this.zf;
        marginLayoutParams.height = this.rt;
        marginLayoutParams.leftMargin = this.vm;
        marginLayoutParams.topMargin = this.qk;
        this.f3616ms.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.vy);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ul.xr(viewGroup, this.sk.left, this.sk.top, this.sk.right, this.sk.bottom);
        }
        xr(true);
        t.ms(this.yu, "tt_enlarge_video", this.tz);
        this.l.setThumb(xr(15, "#1E000000"));
        this.l.setThumbOffset(0);
        com.bykv.vk.openvk.component.video.ms.ka.ms.ms(this.f3616ms, true);
        c(this.s);
        ul.ms(this.m, 8);
        if (this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.alwayShowBackBtn)) {
            ul.ms((View) this.ul, 0);
        }
    }

    private void c(boolean z) {
        if (z) {
            cv();
        } else {
            g();
        }
    }

    private void cv() {
        DisplayMetrics displayMetrics = this.yu.getResources().getDisplayMetrics();
        TextView textView = this.sa;
        if (textView != null) {
            this.zd = textView.getTextSize();
            this.sa.setTextSize(2, 14.0f);
            ColorStateList textColors = this.sa.getTextColors();
            this.z = textColors;
            if (textColors != null) {
                this.sa.setTextColor(t.ny(this.yu, "tt_ssxinzi15"));
            }
            this.tk = this.sa.getAlpha();
            this.sa.setAlpha(0.85f);
            this.sa.setShadowLayer(0.0f, ul.ah(this.yu, 0.5f), ul.ah(this.yu, 0.5f), t.ny(this.yu, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.sa.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.nn.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                ul.xr(this.sa, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.nn.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.nn.bottom);
            }
        }
        TextView textView2 = this.am;
        if (textView2 != null) {
            this.o = textView2.getTextSize();
            this.am.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.am.getTextColors();
            this.n = textColors2;
            if (textColors2 != null) {
                this.am.setTextColor(t.ny(this.yu, "tt_ssxinzi15"));
            }
            this.ec = this.am.getAlpha();
            this.am.setAlpha(0.85f);
            this.am.setShadowLayer(0.0f, ul.ah(this.yu, 0.5f), ul.ah(this.yu, 0.5f), t.ny(this.yu, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.am.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.vf.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ul.xr(this.am, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.vf.top, this.vf.right, this.vf.bottom);
            }
        }
        ImageView imageView = this.tz;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.kl.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ul.xr(this.tz, this.kl.left, this.kl.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.kl.bottom);
            }
        }
        if (this.tz != null) {
            t.ms(this.yu, "tt_shrink_fullscreen", this.tz);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.gy = textColors3;
            if (textColors3 != null) {
                this.e.setTextColor(t.ny(this.yu, "tt_ssxinzi15"));
            }
            this.vl = this.e.getAlpha();
            this.e.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.e.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.qr.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                ul.xr(this.e, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.vf.top, this.vf.right, this.vf.bottom);
            }
        }
        View view = this.m;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.ce = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.m.setLayoutParams(layoutParams5);
            t.ms(this.yu, "tt_shadow_fullscreen_top", this.m);
        }
        xr(this.jm, true);
    }

    private void g() {
        TextView textView = this.sa;
        if (textView != null) {
            textView.setTextSize(0, this.zd);
            ColorStateList colorStateList = this.z;
            if (colorStateList != null) {
                this.sa.setTextColor(colorStateList);
            }
            this.sa.setAlpha(this.tk);
            this.sa.setShadowLayer(ul.ah(this.yu, 1.0f), 0.0f, 0.0f, t.ny(this.yu, "tt_video_shadow_color"));
            ul.xr(this.sa, this.nn.left, this.nn.top, this.nn.right, this.nn.bottom);
        }
        TextView textView2 = this.am;
        if (textView2 != null) {
            textView2.setTextSize(0, this.o);
            ColorStateList colorStateList2 = this.n;
            if (colorStateList2 != null) {
                this.am.setTextColor(colorStateList2);
            }
            this.am.setAlpha(this.ec);
            this.am.setShadowLayer(ul.ah(this.yu, 1.0f), 0.0f, 0.0f, t.ny(this.yu, "tt_video_shadow_color"));
            ul.xr(this.am, this.vf.left, this.vf.top, this.vf.right, this.vf.bottom);
        }
        ImageView imageView = this.tz;
        if (imageView != null) {
            ul.xr(imageView, this.kl.left, this.kl.top, this.kl.right, this.kl.bottom);
        }
        if (this.tz != null) {
            t.ms(this.yu, "tt_enlarge_video", this.tz);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.gy;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.e.setAlpha(this.vl);
            ul.xr(this.e, this.vf.left, this.vf.top, this.vf.right, this.vf.bottom);
        }
        View view = this.m;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.ce;
            this.m.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.m.setBackground(gradientDrawable);
        }
        xr(this.jm, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what != 1) {
            return;
        }
        sl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(boolean z, boolean z2, boolean z3) {
        ul.ms(this.qf, 0);
        ul.ms((View) this.ub, 0);
        if (this.s) {
            ul.ms(this.m, 0);
            ul.ms((View) this.e, 0);
        } else if (z3) {
            ul.ms(this.m, 8);
        }
        ul.ms((View) this.ah, (!z || this.d.getVisibility() == 0) ? 8 : 0);
        if (!this.nw && !this.s) {
            if (!this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideCloseBtn) && !z3) {
                ul.ms((View) this.az, 0);
            }
            ul.ms((View) this.ul, z3 ? 8 : 0);
        }
        ul.ms((View) this.am, 0);
        ul.ms((View) this.sa, 0);
        if (of()) {
            ul.ms((View) this.l, 8);
        } else {
            ul.ms((View) this.l, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ms(boolean z, boolean z2) {
        ul.ms(this.qf, 8);
        ul.ms(this.m, 8);
        ul.ms((View) this.ub, z ? 0 : 8);
        ul.ms((View) this.ah, 8);
        if (!this.nw && !this.s) {
            ul.ms((View) this.az, 8);
            if (!this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.alwayShowBackBtn)) {
                ul.ms((View) this.ul, 8);
            }
        } else if (this.i.contains(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideCloseBtn)) {
            ul.ms((View) this.az, 8);
        }
        if (z2) {
            ul.ms((View) this.az, 8);
            ul.ms((View) this.ul, 8);
        }
        ah(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bytedance.sdk.openadsdk.core.widget.ub.xr
    public void sl() {
        ms(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean ah(int i) {
        SeekBar seekBar = this.l;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void ah(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.lm != null) {
            if (this.nw) {
                textView2 = this.lm;
            } else {
                textView = this.lm;
                if (z) {
                    i = 0;
                } else {
                    textView2 = textView;
                }
                ul.ms((View) textView, i);
            }
            textView = textView2;
            i = 8;
            ul.ms((View) textView, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean zb() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(int i) {
        this.re = i;
        ul.ms(this.f3616ms, i);
        if (i != 0) {
            this.r = false;
        } else if (this.gs) {
            this.r = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bytedance.sdk.openadsdk.core.widget.u.ms
    public void ms(View view, boolean z) {
        if (ch()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.w != null && !TextUtils.isEmpty(this.w.eh())) {
                ms(this.w.eh());
            }
            this.k.setText(str);
        } else {
            ms("");
            this.k.setText("");
        }
        if (this.cv) {
            return;
        }
        ah(this.nw && !this.s);
        if (nw()) {
            this.le.ms(this, view, true, this.d.getVisibility() != 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bytedance.sdk.openadsdk.core.widget.u.ms
    public void u() {
        sl();
        ah(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c, com.bytedance.sdk.openadsdk.core.widget.u.ms
    public boolean ub() {
        return this.op != null && this.op.ms();
    }

    private boolean of() {
        if (this.w == null) {
            return false;
        }
        int iS = this.w.s();
        return iS == 1 || iS == 2;
    }
}
