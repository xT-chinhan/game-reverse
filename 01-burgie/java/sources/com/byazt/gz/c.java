package com.byazt.gz;

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
import android.support.v4.view.ViewCompat;
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
import com.byazt.bs.TTViewStub;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.nc.g;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends uc {
    public int aa;
    public final Rect ag;
    public boolean bh;
    public ImageView bm;
    public int cr;
    public final Rect d;
    public float eh;
    public ImageView er;
    public float ey;
    public TextView f;
    public boolean fe;
    public int gu;
    public TextView hs;
    public View i;
    public SeekBar ie;
    public ImageView ii;
    public boolean iy;
    public int j;
    public final iu jn;
    public float jw;
    public boolean l;
    public TextView ls;
    public boolean lv;
    public final Rect mr;
    public int mw;
    public ColorStateList na;
    public final Rect np;
    public View nw;
    public TextView o;
    public int od;
    public TextView of;
    public final View.OnTouchListener pj;
    public ColorStateList pq;
    public TextView qi;
    public TextView qn;
    public g qo;
    public ColorStateList qv;
    public boolean qx;
    public ImageView r;
    public float rk;
    public int sv;
    public float u;
    public View v;
    public int vj;
    public final Rect wt;

    @Override // com.byazt.gz.uc, com.byazt.w.hw
    public /* bridge */ /* synthetic */ void pr(Object obj, WeakReference weakReference, boolean z) {
        pr((of) obj, (WeakReference<Context>) weakReference, z);
    }

    public c(Context context, View view, boolean z, EnumSet<com.byazt.w.hw.pr> enumSet, of ofVar, com.byazt.w.hn hnVar, boolean z2) {
        super(context, view, z, enumSet, ofVar, hnVar, z2, null);
        this.jn = new iu(Looper.getMainLooper(), this);
        this.l = false;
        this.lv = false;
        this.od = 0;
        this.vj = 0;
        this.mw = 0;
        this.sv = 0;
        this.gu = 0;
        this.d = new Rect();
        this.wt = new Rect();
        this.aa = 0;
        this.cr = 0;
        this.j = 0;
        this.qo = null;
        this.bh = false;
        this.pj = new View.OnTouchListener() { // from class: com.byazt.gz.c.8
            public float hw;

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.hw = x;
                        return false;
                    case 1:
                        c.this.bh = Math.abs(this.hw - motionEvent.getX()) < 10.0f;
                        return false;
                    case 2:
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                        return false;
                    case 3:
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.np = new Rect();
        this.mr = new Rect();
        this.ag = new Rect();
        this.b = a.getContext().getApplicationContext();
        x(z2);
        this.pr = view;
        this.cz = z;
        g gVar = new g(this);
        this.qo = gVar;
        gVar.pr(this.cz);
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        this.cr = displayMetrics.widthPixels;
        this.j = displayMetrics.heightPixels;
        this.rc = enumSet == null ? EnumSet.noneOf(com.byazt.w.hw.pr.class) : enumSet;
        this.y = hnVar;
        this.z = ofVar;
        x(8);
        pr(context, this.pr, ofVar);
        x();
        nt();
    }

    @Override // com.byazt.gz.uc
    public void pr(Context context, View view, of ofVar) {
        super.pr(context, view, ofVar);
        this.ls = (TextView) view.findViewById(2114387759);
        this.er = (ImageView) view.findViewById(2114387678);
        this.v = view.findViewById(2114387605);
        this.ii = (ImageView) view.findViewById(2114387897);
        this.qi = (TextView) view.findViewById(2114387730);
        this.qn = (TextView) view.findViewById(2114387706);
        this.of = (TextView) view.findViewById(2114387846);
        this.i = view.findViewById(2114387823);
        this.r = (ImageView) view.findViewById(2114387618);
        this.hs = (TextView) view.findViewById(2114387860);
        this.ie = (SeekBar) view.findViewById(2114387872);
        this.o = (TextView) view.findViewById(2114387668);
        this.f = (TextView) view.findViewById(2114387811);
        this.nw = view.findViewById(2114387628);
        this.bm = (ImageView) view.findViewById(2114387661);
        this.fw = (TTViewStub) view.findViewById(2114387744);
    }

    @Override // com.byazt.gz.uc
    public void x() {
        super.x();
        this.qo.pr(this.pr);
        er.pr((View) this.er, (this.cz || this.rc.contains(com.byazt.w.hw.pr.hideCloseBtn)) ? 8 : 0);
        this.er.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cz()) {
                    c.this.ve.hn(c.this, view);
                }
            }
        });
        er.pr((View) this.ls, (!this.cz || this.rc.contains(com.byazt.w.hw.pr.alwayShowBackBtn)) ? 0 : 8);
        this.ls.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cz()) {
                    c.this.ve.x(c.this, view);
                }
            }
        });
        this.ii.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cz()) {
                    c.this.ve.c(c.this, view);
                }
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hw(false, true);
                c.this.zo();
                c.this.fw();
                c.this.cz();
            }
        });
        this.bm.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cz()) {
                    c.this.ve.hw(c.this, view);
                }
            }
        });
        this.ie.setThumbOffset(0);
        this.ie.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.byazt.gz.c.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!c.this.l && c.this.b != null) {
                    seekBar.setThumb(c.hw(15, "#1E000000"));
                }
                if (c.this.cz()) {
                    seekBar.setThumbOffset(0);
                    c.this.ve.pr(c.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!c.this.l && c.this.b != null) {
                    seekBar.setThumb(c.hw(22, "#1E000000"));
                }
                if (c.this.cz()) {
                    seekBar.setThumbOffset(0);
                    c.this.ve.hw(c.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (c.this.cz()) {
                    c.this.ve.pr(c.this, i, z);
                }
            }
        });
        this.ie.setOnTouchListener(this.pj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable hw(int i, String str) {
        Context context = a.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iHn = er.hn(context, i);
        shapeDrawable.setIntrinsicWidth(iHn);
        shapeDrawable.setIntrinsicHeight(iHn);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(er.hn(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    @Override // com.byazt.gz.uc
    public void c() {
        this.jn.removeMessages(1);
        this.jn.sendMessageDelayed(this.jn.obtainMessage(1), 2000L);
    }

    @Override // com.byazt.gz.uc
    public void uc() {
        this.jn.removeMessages(1);
    }

    @Override // com.byazt.gz.uc
    public void hw(boolean z) {
        int i = vk() ? this.j : this.yb;
        int i2 = vk() ? this.cr : this.lb;
        if (this.a <= 0 || this.qa <= 0 || i <= 0) {
            return;
        }
        if (!w() && !vk() && !this.rc.contains(com.byazt.w.hw.pr.fixedSize)) {
            i2 = com.byazt.bs.hw.pr.hw;
        }
        int i3 = (int) (this.a * ((i * 1.0f) / this.qa));
        if (i3 <= i2) {
            i2 = i3;
        } else {
            i = (int) (this.qa * ((i2 * 1.0f) / this.a));
        }
        if (!z && !vk()) {
            i = this.yb;
            i2 = this.lb;
        }
        this.hw.pr(i, i2);
    }

    @Override // com.byazt.gz.uc
    public void pr(String str) {
        TextView textView = this.qi;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.qn;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.byazt.gz.uc
    public void hw(int i) {
        View view = this.nw;
        if (view != null && view.getVisibility() == 0) {
            er.pr((View) this.ho, 8);
            return;
        }
        er.pr((View) this.ho, 0);
        this.ie.setProgress(i);
        this.ho.setProgress(i);
    }

    @Override // com.byazt.gz.uc
    public void pr(long j, long j2) {
        this.o.setText(com.byazt.t.pr.pr(j2));
        this.f.setText(com.byazt.t.pr.pr(j));
        this.ie.setProgress(com.byazt.t.pr.pr(j, j2));
    }

    @Override // com.byazt.gz.uc
    public void fw() {
        if (com.byazt.lpk.pr.pr(this.z)) {
            ny();
            return;
        }
        er.uc(this.x);
        er.uc(this.c);
        er.c(this.i);
        if (this.uc != null && this.z != null && !TextUtils.isEmpty(qv.hw(this.z))) {
            er.uc(this.uc);
            com.byazt.ub.hw.pr(qv.hw(this.z)).pr(this.uc);
            pr(this.uc, qv.hw(this.z));
        }
        if (this.hn.getVisibility() == 0) {
            er.pr((View) this.hn, 8);
        }
    }

    @Override // com.byazt.gz.uc, com.byazt.w.hw
    public void pr() {
        pr(false, this.cz);
        z();
    }

    @Override // com.byazt.gz.uc
    public void pr(long j) {
        this.f.setText(com.byazt.t.pr.pr(j));
    }

    @Override // com.byazt.gz.uc
    public void pr(of ofVar, WeakReference<Context> weakReference, boolean z) {
        if (ofVar == null) {
            return;
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            pr(a.getContext(), this.pr);
            lb();
            return;
        }
        pr(this.pr, a.getContext());
        pr(false, this.cz);
        er.pr(this.zo, 0);
        er.pr((View) this.aj, 0);
        er.pr(this.vk, 0);
        if (this.aj != null && this.z != null && !TextUtils.isEmpty(qv.hw(this.z))) {
            com.byazt.ub.hw.pr(qv.hw(this.z)).pr(this.aj);
            pr(this.aj, qv.hw(this.z));
        }
        er.pr((View) this.g, 0);
        er.pr((View) this.w, 8);
        er.pr((View) this.k, 8);
        er.pr((View) this.m, 8);
        er.pr(this.g, "重新播放");
        er.pr(this.g, new View.OnClickListener() { // from class: com.byazt.gz.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ve != null) {
                    c.this.ve.pr();
                }
            }
        }, "video_ad_button");
        er.pr(this.g, (View.OnTouchListener) null, "video_ad_button");
        if (y()) {
            er.pr(this.vk, 8);
        }
    }

    @Override // com.byazt.gz.uc
    public void zo() {
        er.c(this.x);
        er.c(this.i);
    }

    @Override // com.byazt.gz.uc
    public void aj() {
        this.ie.setProgress(0);
        this.ie.setSecondaryProgress(0);
        this.ho.setProgress(0);
        this.ho.setSecondaryProgress(0);
        this.o.setText("00:00");
        this.f.setText("00:00");
        x(8);
        if (ve()) {
            this.hw.setVisibility(8);
        }
        if (this.uc != null) {
            this.uc.setImageDrawable(null);
            this.uc.setBackground(null);
        }
        x(8);
        er.pr(this.nw, 8);
        er.pr(this.zo, 8);
        er.pr((View) this.aj, 8);
        er.pr(this.vk, 8);
        er.pr((View) this.w, 8);
        er.pr((View) this.k, 8);
        er.pr((View) this.m, 8);
        if (this.iu != null) {
            this.iu.pr(true);
        }
    }

    @Override // com.byazt.gz.uc, com.byazt.nc.ho.hw
    public boolean vk() {
        return this.l;
    }

    @Override // com.byazt.gz.uc
    public boolean w() {
        return this.cz;
    }

    @Override // com.byazt.gz.uc
    public void pr(ViewGroup viewGroup) {
        if (viewGroup == null || !(this.pr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.l = true;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.pr.getLayoutParams();
        this.vj = marginLayoutParams.leftMargin;
        this.od = marginLayoutParams.topMargin;
        this.mw = marginLayoutParams.width;
        this.sv = marginLayoutParams.height;
        marginLayoutParams.width = -1;
        marginLayoutParams.height = -1;
        marginLayoutParams.topMargin = 0;
        marginLayoutParams.leftMargin = 0;
        this.pr.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] rules = layoutParams2.getRules();
            this.gu = rules.length > 0 ? rules[3] : 0;
            layoutParams2.addRule(3, 0);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            this.d.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            er.hw(viewGroup, 0, 0, 0, 0);
        }
        hw(true);
        com.byazt.ca.g.pr(this.b, "tt_shrink_video", this.bm, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.ie.setThumb(hw(18, "#00000000"));
        this.ie.setThumbOffset(0);
        com.byazt.t.pr.pr(this.pr, false);
        uc(this.l);
        er.pr(this.v, 8);
        if (!this.cz) {
            er.pr((View) this.er, 8);
            er.pr((View) this.ls, 8);
        } else if (this.rc.contains(com.byazt.w.hw.pr.hideCloseBtn)) {
            er.pr((View) this.er, 8);
        }
    }

    @Override // com.byazt.gz.uc
    public void hw(ViewGroup viewGroup) {
        ho.hw("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || this.pr == null || !(this.pr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.l = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.pr.getLayoutParams();
        marginLayoutParams.width = this.mw;
        marginLayoutParams.height = this.sv;
        marginLayoutParams.leftMargin = this.vj;
        marginLayoutParams.topMargin = this.od;
        this.pr.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.gu);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            er.hw(viewGroup, this.d.left, this.d.top, this.d.right, this.d.bottom);
        }
        hw(true);
        com.byazt.ca.g.pr(this.b, "tt_enlarge_video", this.bm, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.ie.setThumb(hw(15, "#1E000000"));
        this.ie.setThumbOffset(0);
        com.byazt.t.pr.pr(this.pr, true);
        uc(this.l);
        er.pr(this.v, 8);
        if (this.rc.contains(com.byazt.w.hw.pr.alwayShowBackBtn)) {
            er.pr((View) this.ls, 0);
        }
    }

    private void uc(boolean z) {
        if (z) {
            gz();
        } else {
            nl();
        }
    }

    private void gz() {
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        TextView textView = this.f;
        if (textView != null) {
            this.ey = textView.getTextSize();
            this.f.setTextSize(2, 14.0f);
            ColorStateList textColors = this.f.getTextColors();
            this.qv = textColors;
            if (textColors != null) {
                this.f.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
            this.u = this.f.getAlpha();
            this.f.setAlpha(0.85f);
            this.f.setShadowLayer(0.0f, er.hn(this.b, 0.5f), er.hn(this.b, 0.5f), -1308622848);
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.np.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                er.hw(this.f, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.np.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.np.bottom);
            }
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            this.eh = textView2.getTextSize();
            this.o.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.o.getTextColors();
            this.na = textColors2;
            if (textColors2 != null) {
                this.o.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
            this.rk = this.o.getAlpha();
            this.o.setAlpha(0.85f);
            this.o.setShadowLayer(0.0f, er.hn(this.b, 0.5f), er.hn(this.b, 0.5f), -1308622848);
            ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.mr.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                er.hw(this.o, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.mr.top, this.mr.right, this.mr.bottom);
            }
        }
        ImageView imageView = this.bm;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.ag.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                er.hw(this.bm, this.ag.left, this.ag.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.ag.bottom);
            }
        }
        if (this.bm != null) {
            com.byazt.ca.g.pr(this.b, "tt_shrink_fullscreen", this.bm, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        TextView textView3 = this.qn;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.pq = textColors3;
            if (textColors3 != null) {
                this.qn.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
            this.jw = this.qn.getAlpha();
            this.qn.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.qn.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.wt.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                er.hw(this.qn, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.mr.top, this.mr.right, this.mr.bottom);
            }
        }
        View view = this.v;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.aa = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.v.setLayoutParams(layoutParams5);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#66000000"), Color.parseColor("#00000000")});
            this.v.setBackground(gradientDrawable);
        }
        hw(this.iy, true);
    }

    private void nl() {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextSize(0, this.ey);
            ColorStateList colorStateList = this.qv;
            if (colorStateList != null) {
                this.f.setTextColor(colorStateList);
            }
            this.f.setAlpha(this.u);
            this.f.setShadowLayer(er.hn(this.b, 1.0f), 0.0f, 0.0f, 1912602624);
            er.hw(this.f, this.np.left, this.np.top, this.np.right, this.np.bottom);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setTextSize(0, this.eh);
            ColorStateList colorStateList2 = this.na;
            if (colorStateList2 != null) {
                this.o.setTextColor(colorStateList2);
            }
            this.o.setAlpha(this.rk);
            this.o.setShadowLayer(er.hn(this.b, 1.0f), 0.0f, 0.0f, 1912602624);
            er.hw(this.o, this.mr.left, this.mr.top, this.mr.right, this.mr.bottom);
        }
        ImageView imageView = this.bm;
        if (imageView != null) {
            er.hw(imageView, this.ag.left, this.ag.top, this.ag.right, this.ag.bottom);
        }
        if (this.bm != null) {
            com.byazt.ca.g.pr(this.b, "tt_enlarge_video", this.bm, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        TextView textView3 = this.qn;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.pq;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.qn.setAlpha(this.jw);
            er.hw(this.qn, this.mr.left, this.mr.top, this.mr.right, this.mr.bottom);
        }
        View view = this.v;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.aa;
            this.v.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.v.setBackground(gradientDrawable);
        }
        hw(this.iy, true);
    }

    @Override // com.byazt.gz.uc, com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1:
                k();
                break;
        }
    }

    @Override // com.byazt.gz.uc
    public void pr(boolean z, boolean z2, boolean z3) {
        er.pr(this.nw, 0);
        er.pr((View) this.ho, 0);
        if (this.l) {
            er.pr(this.v, 0);
            er.pr((View) this.qn, 0);
        } else if (z3) {
            er.pr(this.v, 8);
        }
        er.pr((View) this.hn, (!z || this.x.getVisibility() == 0) ? 8 : 0);
        if (!this.cz && !this.l) {
            if (!this.rc.contains(com.byazt.w.hw.pr.hideCloseBtn) && !z3) {
                er.pr((View) this.er, 0);
            }
            er.pr((View) this.ls, z3 ? 8 : 0);
        }
        er.pr((View) this.o, 0);
        er.pr((View) this.f, 0);
        if (y()) {
            er.pr((View) this.ie, 8);
        } else {
            er.pr((View) this.ie, 0);
        }
    }

    @Override // com.byazt.gz.uc
    public void pr(boolean z, boolean z2) {
        er.pr(this.nw, 8);
        er.pr(this.v, 8);
        er.pr((View) this.ho, z ? 0 : 8);
        er.pr((View) this.hn, 8);
        if (!this.cz && !this.l) {
            er.pr((View) this.er, 8);
            if (!this.rc.contains(com.byazt.w.hw.pr.alwayShowBackBtn)) {
                er.pr((View) this.ls, 8);
            }
        } else if (this.rc.contains(com.byazt.w.hw.pr.hideCloseBtn)) {
            er.pr((View) this.er, 8);
        }
        if (z2) {
            er.pr((View) this.er, 8);
            er.pr((View) this.ls, 8);
        }
        hn(false);
    }

    @Override // com.byazt.gz.uc, com.byazt.nc.ho.hw
    public void k() {
        pr(true, false);
    }

    @Override // com.byazt.gz.uc
    public boolean hn(int i) {
        SeekBar seekBar = this.ie;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.byazt.gz.uc
    public void hn(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.qi != null) {
            if (this.cz) {
                textView2 = this.qi;
            } else {
                textView = this.qi;
                if (z) {
                    i = 0;
                } else {
                    textView2 = textView;
                }
                er.pr((View) textView, i);
            }
            textView = textView2;
            i = 8;
            er.pr((View) textView, i);
        }
    }

    @Override // com.byazt.gz.uc
    public boolean m() {
        return this.ny;
    }

    @Override // com.byazt.gz.uc
    public void x(int i) {
        this.fo = i;
        er.pr(this.pr, i);
        if (i != 0) {
            this.fe = false;
        } else if (this.qx) {
            this.fe = true;
        }
    }

    @Override // com.byazt.gz.uc, com.byazt.nc.g.pr
    public void pr(View view, boolean z) {
        if (vk()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.z != null && !TextUtils.isEmpty(this.z.A_())) {
                pr(this.z.A_());
            }
            this.of.setText(str);
        } else {
            pr("");
            this.of.setText("");
        }
        if (!this.gz) {
            hn(this.cz && !this.l);
            if (cz()) {
                this.ve.pr(this, view, true, this.x.getVisibility() != 0);
            }
        }
    }

    @Override // com.byazt.gz.uc, com.byazt.nc.g.pr
    public void g() {
        k();
        hn(false);
    }

    @Override // com.byazt.gz.uc, com.byazt.nc.g.pr
    public boolean ho() {
        return this.iu != null && this.iu.pr();
    }

    private boolean y() {
        if (this.z == null) {
            return false;
        }
        int iKs = this.z.ks();
        return iKs == 1 || iKs == 2;
    }
}
