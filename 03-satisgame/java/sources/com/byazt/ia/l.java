package com.byazt.ia;

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
import androidx.core.view.ViewCompat;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.lz.TTViewStub;
import com.byazt.mr.sz;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.byazt.tk.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 18})
public class l extends w {
    public TextView b;
    public int ci;
    public int cx;
    public View df;
    public TextView dg;
    public SeekBar dh;
    public float dn;
    public sz dw;
    public boolean e;
    public boolean ei;
    public int el;
    public TextView f;
    public ImageView fi;
    public int fl;
    public float g;
    public final View.OnTouchListener ha;
    public final Rect he;
    public int hf;
    public int i;
    public int ic;
    public float ju;
    public final Rect kc;
    public int lq;
    public final Rect mz;
    public ImageView nf;
    public float np;
    public TextView oj;
    public final t pe;
    public ImageView pk;
    public final Rect r;
    public View rf;
    public TextView ri;
    public ColorStateList ry;
    public ImageView sh;
    public boolean sq;
    public boolean su;
    public final Rect ta;
    public TextView u;
    public boolean vb;
    public View wo;
    public float wv;
    public ColorStateList xi;
    public TextView y;
    public boolean yw;
    public ColorStateList z;

    @Override // com.byazt.ia.w, com.byazt.iag.qg
    public /* bridge */ /* synthetic */ void n(pk pkVar, WeakReference weakReference, boolean z) {
        n(pkVar, (WeakReference<Context>) weakReference, z);
    }

    public l(Context context, View view, boolean z, EnumSet<com.byazt.iag.qg.n> enumSet, pk pkVar, com.byazt.iag.s sVar, boolean z2) {
        super(context, view, z, enumSet, pkVar, sVar, z2, null);
        this.pe = new t(Looper.getMainLooper(), this);
        this.e = false;
        this.yw = false;
        this.cx = 0;
        this.lq = 0;
        this.ic = 0;
        this.ci = 0;
        this.hf = 0;
        this.kc = new Rect();
        this.he = new Rect();
        this.el = 0;
        this.fl = 0;
        this.i = 0;
        this.dw = null;
        this.su = false;
        this.ha = new View.OnTouchListener() { // from class: com.byazt.ia.l.8
            public float qg;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        l.this.su = Math.abs(this.qg - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.qg = x;
                }
                return false;
            }
        };
        this.ta = new Rect();
        this.r = new Rect();
        this.mz = new Rect();
        this.h = rv.getContext().getApplicationContext();
        q(z2);
        this.n = view;
        this.py = z;
        sz szVar = new sz(this);
        this.dw = szVar;
        szVar.n(this.py);
        DisplayMetrics displayMetrics = this.h.getResources().getDisplayMetrics();
        this.fl = displayMetrics.widthPixels;
        this.i = displayMetrics.heightPixels;
        this.m = enumSet == null ? EnumSet.noneOf(com.byazt.iag.qg.n.class) : enumSet;
        this.lh = sVar;
        this.hu = pkVar;
        q(8);
        n(context, this.n, pkVar);
        fs();
        cy();
    }

    @Override // com.byazt.ia.w
    public void n(Context context, View view, pk pkVar) {
        super.n(context, view, pkVar);
        this.f = (TextView) view.findViewById(2114387759);
        this.fi = (ImageView) view.findViewById(2114387678);
        this.df = view.findViewById(2114387605);
        this.pk = (ImageView) view.findViewById(2114387897);
        this.oj = (TextView) view.findViewById(2114387730);
        this.dg = (TextView) view.findViewById(2114387706);
        this.u = (TextView) view.findViewById(2114387846);
        this.wo = view.findViewById(2114387823);
        this.sh = (ImageView) view.findViewById(2114387618);
        this.y = (TextView) view.findViewById(2114387860);
        this.dh = (SeekBar) view.findViewById(2114387872);
        this.b = (TextView) view.findViewById(2114387668);
        this.ri = (TextView) view.findViewById(2114387811);
        this.rf = view.findViewById(2114387628);
        this.nf = (ImageView) view.findViewById(2114387661);
        this.x = (TTViewStub) view.findViewById(2114387744);
    }

    @Override // com.byazt.ia.w
    public void fs() {
        super.fs();
        this.dw.n(this.n);
        com.byazt.okk.s.n((View) this.fi, (this.py || this.m.contains(com.byazt.iag.qg.n.hideCloseBtn)) ? 8 : 0);
        this.fi.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.py()) {
                    l.this.ur.s(l.this, view);
                }
            }
        });
        com.byazt.okk.s.n((View) this.f, (!this.py || this.m.contains(com.byazt.iag.qg.n.alwayShowBackBtn)) ? 0 : 8);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.py()) {
                    l.this.ur.q(l.this, view);
                }
            }
        });
        this.pk.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.py()) {
                    l.this.ur.l(l.this, view);
                }
            }
        });
        this.sh.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.qg(false, true);
                l.this.d();
                l.this.cp();
                l.this.py();
            }
        });
        this.nf.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ia.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.py()) {
                    l.this.ur.qg(l.this, view);
                }
            }
        });
        this.dh.setThumbOffset(0);
        this.dh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.byazt.ia.l.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!l.this.e && l.this.h != null) {
                    seekBar.setThumb(l.qg(15, "#1E000000"));
                }
                if (l.this.py()) {
                    seekBar.setThumbOffset(0);
                    l.this.ur.n(l.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!l.this.e && l.this.h != null) {
                    seekBar.setThumb(l.qg(22, "#1E000000"));
                }
                if (l.this.py()) {
                    seekBar.setThumbOffset(0);
                    l.this.ur.qg(l.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (l.this.py()) {
                    l.this.ur.n(l.this, i, z);
                }
            }
        });
        this.dh.setOnTouchListener(this.ha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable qg(int i, String str) {
        Context context = rv.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iS = com.byazt.okk.s.s(context, i);
        shapeDrawable.setIntrinsicWidth(iS);
        shapeDrawable.setIntrinsicHeight(iS);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(com.byazt.okk.s.s(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    @Override // com.byazt.ia.w
    public void rv() {
        this.pe.removeMessages(1);
        this.pe.sendMessageDelayed(this.pe.obtainMessage(1), 2000L);
    }

    @Override // com.byazt.ia.w
    public void tj() {
        this.pe.removeMessages(1);
    }

    @Override // com.byazt.ia.w
    public void qg(boolean z) {
        int i = x() ? this.i : this.hd;
        int i2 = x() ? this.fl : this.cd;
        if (this.a <= 0 || this.um <= 0 || i <= 0) {
            return;
        }
        if (!sz() && !x() && !this.m.contains(com.byazt.iag.qg.n.fixedSize)) {
            i2 = com.byazt.lz.qg.n.qg;
        }
        int i3 = (int) (this.a * ((i * 1.0f) / this.um));
        if (i3 > i2) {
            i = (int) (this.um * ((i2 * 1.0f) / this.a));
        } else {
            i2 = i3;
        }
        if (!z && !x()) {
            i = this.hd;
            i2 = this.cd;
        }
        this.qg.n(i, i2);
    }

    @Override // com.byazt.ia.w
    public void n(String str) {
        TextView textView = this.oj;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.dg;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.byazt.ia.w
    public void qg(int i) {
        View view = this.rf;
        if (view != null && view.getVisibility() == 0) {
            com.byazt.okk.s.n((View) this.k, 8);
            return;
        }
        com.byazt.okk.s.n((View) this.k, 0);
        this.dh.setProgress(i);
        this.k.setProgress(i);
    }

    @Override // com.byazt.ia.w
    public void n(long j, long j2) {
        this.b.setText(com.byazt.udy.n.n(j2));
        this.ri.setText(com.byazt.udy.n.n(j));
        this.dh.setProgress(com.byazt.udy.n.n(j, j2));
    }

    @Override // com.byazt.ia.w
    public void cp() {
        if (com.byazt.gks.n.n(this.hu)) {
            ou();
            return;
        }
        com.byazt.okk.s.w(this.q);
        com.byazt.okk.s.w(this.l);
        com.byazt.okk.s.l(this.wo);
        if (this.w != null && this.hu != null && !TextUtils.isEmpty(ta.qg(this.hu))) {
            com.byazt.okk.s.w(this.w);
            com.byazt.imu.s.n(ta.qg(this.hu)).n(this.w);
            n(this.w, ta.qg(this.hu));
        }
        if (this.s.getVisibility() == 0) {
            com.byazt.okk.s.n((View) this.s, 8);
        }
    }

    @Override // com.byazt.ia.w, com.byazt.iag.qg
    public void n() {
        n(false, this.py);
        hu();
    }

    @Override // com.byazt.ia.w
    public void n(long j) {
        this.ri.setText(com.byazt.udy.n.n(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.ia.w
    public void n(pk pkVar, WeakReference<Context> weakReference, boolean z) {
        if (pkVar == null) {
            return;
        }
        if (com.byazt.gks.n.n(pkVar)) {
            n(rv.getContext(), this.n);
            cd();
            return;
        }
        n(this.n, rv.getContext());
        n(false, this.py);
        com.byazt.okk.s.n(this.fs, 0);
        com.byazt.okk.s.n((View) this.rv, 0);
        com.byazt.okk.s.n(this.tj, 0);
        if (this.rv != null && this.hu != null && !TextUtils.isEmpty(ta.qg(this.hu))) {
            com.byazt.imu.s.n(ta.qg(this.hu)).n(this.rv);
            n(this.rv, ta.qg(this.hu));
        }
        com.byazt.okk.s.n((View) this.sz, 0);
        com.byazt.okk.s.n((View) this.cp, 8);
        com.byazt.okk.s.n((View) this.d, 8);
        com.byazt.okk.s.n((View) this.oa, 8);
        com.byazt.okk.s.n(this.sz, "重新播放");
        com.byazt.okk.s.n(this.sz, new View.OnClickListener() { // from class: com.byazt.ia.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ur != null) {
                    l.this.ur.n();
                }
            }
        }, "video_ad_button");
        com.byazt.okk.s.n(this.sz, (View.OnTouchListener) null, "video_ad_button");
        if (lh()) {
            com.byazt.okk.s.n(this.tj, 8);
        }
    }

    @Override // com.byazt.ia.w
    public void d() {
        com.byazt.okk.s.l(this.q);
        com.byazt.okk.s.l(this.wo);
    }

    @Override // com.byazt.ia.w
    public void oa() {
        this.dh.setProgress(0);
        this.dh.setSecondaryProgress(0);
        this.k.setProgress(0);
        this.k.setSecondaryProgress(0);
        this.b.setText("00:00");
        this.ri.setText("00:00");
        q(8);
        if (ur()) {
            this.qg.setVisibility(8);
        }
        if (this.w != null) {
            this.w.setImageDrawable(null);
            this.w.setBackground(null);
        }
        q(8);
        com.byazt.okk.s.n(this.rf, 8);
        com.byazt.okk.s.n(this.fs, 8);
        com.byazt.okk.s.n((View) this.rv, 8);
        com.byazt.okk.s.n(this.tj, 8);
        com.byazt.okk.s.n((View) this.cp, 8);
        com.byazt.okk.s.n((View) this.d, 8);
        com.byazt.okk.s.n((View) this.oa, 8);
        if (this.t != null) {
            this.t.n(true);
        }
    }

    @Override // com.byazt.ia.w, com.byazt.mr.k.qg
    public boolean x() {
        return this.e;
    }

    @Override // com.byazt.ia.w
    public boolean sz() {
        return this.py;
    }

    @Override // com.byazt.ia.w
    public void n(ViewGroup viewGroup) {
        if (viewGroup != null && (this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.e = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            this.lq = marginLayoutParams.leftMargin;
            this.cx = marginLayoutParams.topMargin;
            this.ic = marginLayoutParams.width;
            this.ci = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.n.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.hf = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.kc.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                com.byazt.okk.s.qg(viewGroup, 0, 0, 0, 0);
            }
            qg(true);
            com.byazt.tk.sz.n(this.h, "tt_shrink_video", this.nf, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            this.dh.setThumb(qg(18, "#00000000"));
            this.dh.setThumbOffset(0);
            com.byazt.udy.n.n(this.n, false);
            w(this.e);
            com.byazt.okk.s.n(this.df, 8);
            if (!this.py) {
                com.byazt.okk.s.n((View) this.fi, 8);
                com.byazt.okk.s.n((View) this.f, 8);
            } else if (this.m.contains(com.byazt.iag.qg.n.hideCloseBtn)) {
                com.byazt.okk.s.n((View) this.fi, 8);
            }
        }
    }

    @Override // com.byazt.ia.w
    public void qg(ViewGroup viewGroup) {
        k.qg("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.e = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
        marginLayoutParams.width = this.ic;
        marginLayoutParams.height = this.ci;
        marginLayoutParams.leftMargin = this.lq;
        marginLayoutParams.topMargin = this.cx;
        this.n.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.hf);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            com.byazt.okk.s.qg(viewGroup, this.kc.left, this.kc.top, this.kc.right, this.kc.bottom);
        }
        qg(true);
        com.byazt.tk.sz.n(this.h, "tt_enlarge_video", this.nf, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.dh.setThumb(qg(15, "#1E000000"));
        this.dh.setThumbOffset(0);
        com.byazt.udy.n.n(this.n, true);
        w(this.e);
        com.byazt.okk.s.n(this.df, 8);
        if (this.m.contains(com.byazt.iag.qg.n.alwayShowBackBtn)) {
            com.byazt.okk.s.n((View) this.f, 0);
        }
    }

    private void w(boolean z) {
        if (z) {
            bb();
        } else {
            ln();
        }
    }

    private void bb() {
        DisplayMetrics displayMetrics = this.h.getResources().getDisplayMetrics();
        TextView textView = this.ri;
        if (textView != null) {
            this.g = textView.getTextSize();
            this.ri.setTextSize(2, 14.0f);
            ColorStateList textColors = this.ri.getTextColors();
            this.ry = textColors;
            if (textColors != null) {
                this.ri.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
            this.ju = this.ri.getAlpha();
            this.ri.setAlpha(0.85f);
            this.ri.setShadowLayer(0.0f, com.byazt.okk.s.s(this.h, 0.5f), com.byazt.okk.s.s(this.h, 0.5f), -1308622848);
            ViewGroup.LayoutParams layoutParams = this.ri.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ta.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                com.byazt.okk.s.qg(this.ri, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.ta.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.ta.bottom);
            }
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            this.wv = textView2.getTextSize();
            this.b.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.b.getTextColors();
            this.xi = textColors2;
            if (textColors2 != null) {
                this.b.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
            this.np = this.b.getAlpha();
            this.b.setAlpha(0.85f);
            this.b.setShadowLayer(0.0f, com.byazt.okk.s.s(this.h, 0.5f), com.byazt.okk.s.s(this.h, 0.5f), -1308622848);
            ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.r.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                com.byazt.okk.s.qg(this.b, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.r.top, this.r.right, this.r.bottom);
            }
        }
        ImageView imageView = this.nf;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.mz.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                com.byazt.okk.s.qg(this.nf, this.mz.left, this.mz.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.mz.bottom);
            }
        }
        if (this.nf != null) {
            com.byazt.tk.sz.n(this.h, "tt_shrink_fullscreen", this.nf, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        TextView textView3 = this.dg;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.z = textColors3;
            if (textColors3 != null) {
                this.dg.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
            this.dn = this.dg.getAlpha();
            this.dg.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.dg.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.he.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                com.byazt.okk.s.qg(this.dg, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.r.top, this.r.right, this.r.bottom);
            }
        }
        View view = this.df;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.el = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.df.setLayoutParams(layoutParams5);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#66000000"), Color.parseColor("#00000000")});
            this.df.setBackground(gradientDrawable);
        }
        qg(this.vb, true);
    }

    private void ln() {
        TextView textView = this.ri;
        if (textView != null) {
            textView.setTextSize(0, this.g);
            ColorStateList colorStateList = this.ry;
            if (colorStateList != null) {
                this.ri.setTextColor(colorStateList);
            }
            this.ri.setAlpha(this.ju);
            this.ri.setShadowLayer(com.byazt.okk.s.s(this.h, 1.0f), 0.0f, 0.0f, 1912602624);
            com.byazt.okk.s.qg(this.ri, this.ta.left, this.ta.top, this.ta.right, this.ta.bottom);
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setTextSize(0, this.wv);
            ColorStateList colorStateList2 = this.xi;
            if (colorStateList2 != null) {
                this.b.setTextColor(colorStateList2);
            }
            this.b.setAlpha(this.np);
            this.b.setShadowLayer(com.byazt.okk.s.s(this.h, 1.0f), 0.0f, 0.0f, 1912602624);
            com.byazt.okk.s.qg(this.b, this.r.left, this.r.top, this.r.right, this.r.bottom);
        }
        ImageView imageView = this.nf;
        if (imageView != null) {
            com.byazt.okk.s.qg(imageView, this.mz.left, this.mz.top, this.mz.right, this.mz.bottom);
        }
        if (this.nf != null) {
            com.byazt.tk.sz.n(this.h, "tt_enlarge_video", this.nf, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        TextView textView3 = this.dg;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.z;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.dg.setAlpha(this.dn);
            com.byazt.okk.s.qg(this.dg, this.r.left, this.r.top, this.r.right, this.r.bottom);
        }
        View view = this.df;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.el;
            this.df.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.df.setBackground(gradientDrawable);
        }
        qg(this.vb, true);
    }

    @Override // com.byazt.ia.w, com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 1) {
            return;
        }
        w();
    }

    @Override // com.byazt.ia.w
    public void n(boolean z, boolean z2, boolean z3) {
        com.byazt.okk.s.n(this.rf, 0);
        com.byazt.okk.s.n((View) this.k, 0);
        if (this.e) {
            com.byazt.okk.s.n(this.df, 0);
            com.byazt.okk.s.n((View) this.dg, 0);
        } else if (z3) {
            com.byazt.okk.s.n(this.df, 8);
        }
        com.byazt.okk.s.n((View) this.s, (!z || this.q.getVisibility() == 0) ? 8 : 0);
        if (!this.py && !this.e) {
            if (!this.m.contains(com.byazt.iag.qg.n.hideCloseBtn) && !z3) {
                com.byazt.okk.s.n((View) this.fi, 0);
            }
            com.byazt.okk.s.n((View) this.f, z3 ? 8 : 0);
        }
        com.byazt.okk.s.n((View) this.b, 0);
        com.byazt.okk.s.n((View) this.ri, 0);
        if (lh()) {
            com.byazt.okk.s.n((View) this.dh, 8);
        } else {
            com.byazt.okk.s.n((View) this.dh, 0);
        }
    }

    @Override // com.byazt.ia.w
    public void n(boolean z, boolean z2) {
        com.byazt.okk.s.n(this.rf, 8);
        com.byazt.okk.s.n(this.df, 8);
        com.byazt.okk.s.n((View) this.k, z ? 0 : 8);
        com.byazt.okk.s.n((View) this.s, 8);
        if (!this.py && !this.e) {
            com.byazt.okk.s.n((View) this.fi, 8);
            if (!this.m.contains(com.byazt.iag.qg.n.alwayShowBackBtn)) {
                com.byazt.okk.s.n((View) this.f, 8);
            }
        } else if (this.m.contains(com.byazt.iag.qg.n.hideCloseBtn)) {
            com.byazt.okk.s.n((View) this.fi, 8);
        }
        if (z2) {
            com.byazt.okk.s.n((View) this.fi, 8);
            com.byazt.okk.s.n((View) this.f, 8);
        }
        s(false);
    }

    @Override // com.byazt.ia.w, com.byazt.mr.k.qg
    public void w() {
        n(true, false);
    }

    @Override // com.byazt.ia.w
    public boolean s(int i) {
        SeekBar seekBar = this.dh;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.byazt.ia.w
    public void s(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.oj != null) {
            if (this.py) {
                textView2 = this.oj;
            } else {
                textView = this.oj;
                if (z) {
                    i = 0;
                } else {
                    textView2 = textView;
                }
                com.byazt.okk.s.n((View) textView, i);
            }
            textView = textView2;
            i = 8;
            com.byazt.okk.s.n((View) textView, i);
        }
    }

    @Override // com.byazt.ia.w
    public boolean k() {
        return this.ou;
    }

    @Override // com.byazt.ia.w
    public void q(int i) {
        this.wm = i;
        com.byazt.okk.s.n(this.n, i);
        if (i != 0) {
            this.ei = false;
        } else if (this.sq) {
            this.ei = true;
        }
    }

    @Override // com.byazt.ia.w, com.byazt.mr.sz.n
    public void n(View view, boolean z) {
        if (x()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.hu != null && !TextUtils.isEmpty(this.hu.E_())) {
                n(this.hu.E_());
            }
            this.u.setText(str);
        } else {
            n("");
            this.u.setText("");
        }
        if (this.bb) {
            return;
        }
        s(this.py && !this.e);
        if (py()) {
            this.ur.n(this, view, true, this.q.getVisibility() != 0);
        }
    }

    @Override // com.byazt.ia.w, com.byazt.mr.sz.n
    public void q() {
        w();
        s(false);
    }

    @Override // com.byazt.ia.w, com.byazt.mr.sz.n
    public boolean l() {
        return this.t != null && this.t.n();
    }

    private boolean lh() {
        if (this.hu == null) {
            return false;
        }
        int iLa = this.hu.la();
        return iLa == 1 || iLa == 2;
    }
}
