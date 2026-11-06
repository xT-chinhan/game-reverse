package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mcto.sspsdk.IQyBanner;
import com.mcto.sspsdk.QyBannerStyle;
import com.mcto.sspsdk.QyVideoPlayOption;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.component.interaction.QySharkView;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j2 extends o3 implements View.OnClickListener {
    public boolean A;
    public final i2 B;
    public int C;
    public final Context b;
    public final QYNiceImageView c;
    public final FrameLayout d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public final FrameLayout j;
    public final View k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public boolean s;
    public q2 t;
    public v3 u;
    public r2 v;
    public final y9 w;
    public final QyBannerStyle x;
    public final boolean y;
    public boolean z;

    public j2(Context context, QyBannerStyle qyBannerStyle, boolean z, boolean z2) {
        super(context);
        this.C = 1;
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = true;
        this.z = false;
        this.B = new i2(this);
        this.b = context;
        this.x = qyBannerStyle;
        this.y = z2;
        LayoutInflater.from(context).inflate(R.layout.qy_layout_banner_video_ad_palyer_controller, (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.qy_banner_ad_player_center_start);
        this.d = frameLayout;
        ImageView imageView = (ImageView) findViewById(R.id.qy_banner_ad_player_volume);
        this.e = imageView;
        this.c = (QYNiceImageView) findViewById(R.id.qy_banner_ad_player_cover_image);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.qy_banner_ad_player_error);
        this.g = linearLayout;
        TextView textView = (TextView) findViewById(R.id.qy_banner_ad_player_retry);
        this.h = textView;
        TextView textView2 = (TextView) findViewById(R.id.qy_banner_ad_player_completed_replay);
        this.i = textView2;
        this.j = (FrameLayout) findViewById(R.id.qy_banner_ad_player_completed);
        this.f = (LinearLayout) findViewById(R.id.qy_banner_ad_player_loading);
        View viewFindViewById = findViewById(R.id.qy_banner_ad_player_blank);
        this.k = viewFindViewById;
        if (z2) {
            imageView.setVisibility(8);
        } else {
            imageView.setOnClickListener(this);
        }
        frameLayout.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        viewFindViewById.setVisibility((qyBannerStyle != QyBannerStyle.QYBANNER_TITLEIN || z) ? 8 : 0);
        this.w = new y9(context);
    }

    /* JADX WARN: Type inference failed for: r1v27, types: [android.view.View, com.mcto.sspsdk.internal.n7] */
    @Override // com.mcto.sspsdk.internal.o3
    public final void a(int i) {
        pa paVar;
        pa paVar2;
        boolean z;
        if (i == -1) {
            b(-1);
            r2 r2Var = this.v;
            if (r2Var == null || this.a == null) {
                return;
            }
            q2 q2Var = r2Var.J;
            if (q2Var != null) {
                q2Var.c = -1;
            }
            if (q2Var != null && q2Var.b < 0) {
                q2Var.b = 0;
            }
            IQyBanner.IAdInteractionListener iAdInteractionListener = r2Var.L;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onAdPlayError();
            }
            x1 x1Var = r2Var.K;
            if (x1Var != null) {
                x1Var.a.a();
                return;
            }
            return;
        }
        if (i == 11) {
            b(11);
            this.j.removeAllViews();
            if (TextUtils.isEmpty(this.q)) {
                Bitmap bitmap = this.t.d;
                if (bitmap != null) {
                    ImageView imageView = new ImageView(this.b);
                    imageView.setImageBitmap(bitmap);
                    this.j.addView(imageView);
                }
            } else {
                QYNiceImageView qYNiceImageView = new QYNiceImageView(this.b);
                qYNiceImageView.a(this.q);
                this.j.addView(qYNiceImageView);
            }
            if (this.t.g) {
                bb bbVar = new bb(getContext());
                bbVar.e = new e2(this);
                j.b(3, this.C);
                String str = this.n;
                String str2 = this.o;
                String str3 = this.l;
                String str4 = this.m;
                String str5 = this.r;
                bbVar.b.setText(str);
                if (!lj.b(str4)) {
                    bbVar.a.a(str4);
                    bbVar.a.c();
                }
                Context context = bbVar.getContext();
                int iA = hk.a(context, 100.0f);
                int i2 = (int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
                bbVar.d.removeAllViews();
                DownloadButtonView downloadButtonView = new DownloadButtonView(context);
                bbVar.c = downloadButtonView;
                downloadButtonView.setWidth(iA);
                bbVar.c.setHeight(i2);
                bbVar.c.b(str5);
                h hVar = new h(bbVar.c);
                hVar.a(str3, str2);
                bbVar.c.a(hVar);
                bbVar.d.addView(bbVar.c, new LinearLayout.LayoutParams(iA, i2));
                bbVar.invalidate();
                bbVar.d.setOnTouchListener(bbVar);
                bbVar.a.setOnTouchListener(bbVar);
                bbVar.b.setOnTouchListener(bbVar);
                this.j.addView(bbVar, new FrameLayout.LayoutParams(-1, -1));
            }
            v3 v3Var = this.u;
            if (v3Var != null) {
                v3Var.a();
            }
            d();
            r2 r2Var2 = this.v;
            if (r2Var2 != null && (paVar = this.a) != null) {
                int iB = paVar.b();
                TextView textView = r2Var2.a;
                if (textView != null && r2Var2.l == QyBannerStyle.QYBANNER_TITLEIN) {
                    textView.setVisibility(8);
                }
                View view = r2Var2.i;
                if (view instanceof QySharkView) {
                    ((QySharkView) view).b();
                    r2Var2.i.setVisibility(8);
                }
                q2 q2Var2 = r2Var2.J;
                if (q2Var2 != null) {
                    q2Var2.c = 11;
                }
                if (q2Var2 != null && iB > q2Var2.b) {
                    q2Var2.b = iB;
                }
                l lVarA = l.a();
                p pVar = r2Var2.v;
                lVarA.getClass();
                l.a(18, pVar, null);
                IQyBanner.IAdInteractionListener iAdInteractionListener2 = r2Var2.L;
                if (iAdInteractionListener2 != null) {
                    iAdInteractionListener2.onAdComplete();
                }
                x1 x1Var2 = r2Var2.K;
                if (x1Var2 != null) {
                    x1Var2.a.b();
                }
            }
            this.z = false;
            return;
        }
        switch (i) {
            case 1:
                b(this.s);
                getViewTreeObserver().addOnWindowFocusChangeListener(new h2(this));
                p pVar2 = this.t.a;
                this.C = pVar2.S0;
                this.l = pVar2.E;
                this.p = pVar2.G;
                this.r = pVar2.g();
                JSONObject jSONObjectI = pVar2.i();
                this.m = jSONObjectI.optString("appIcon");
                this.n = jSONObjectI.optString("appName");
                this.o = jSONObjectI.optString("apkName");
                String strOptString = jSONObjectI.optString("background");
                this.q = strOptString;
                if (!TextUtils.isEmpty(strOptString)) {
                    this.c.a(this.q);
                } else if (this.t.d == null) {
                    zg.a.a(new c2(this));
                }
                b(1);
                break;
            case 2:
                r2 r2Var3 = this.v;
                if (r2Var3 != null && (paVar2 = this.a) != null) {
                    int iB2 = paVar2.b();
                    q2 q2Var3 = r2Var3.J;
                    if (q2Var3 != null) {
                        q2Var3.c = 2;
                    }
                    if (q2Var3 != null && iB2 > 0) {
                        p pVar3 = q2Var3.a;
                        int i3 = iB2;
                        if (pVar3.h <= 0) {
                            pVar3.h = i3;
                        }
                    }
                    x1 x1Var3 = r2Var3.K;
                    if (x1Var3 != null) {
                        x1Var3.a.i.a(1);
                    }
                    break;
                }
                break;
            case 3:
                if (b()) {
                    this.a.f();
                    q2 q2Var4 = this.t;
                    int i4 = q2Var4 != null ? q2Var4.b : 0;
                    if (i4 > 0) {
                        pa paVar3 = this.a;
                        long j = i4;
                        paVar3.getClass();
                        try {
                            zb zbVar = paVar3.f;
                            if (zbVar != null) {
                                zbVar.c.post(new hb(zbVar, j));
                            }
                        } catch (Exception e) {
                            r9.a("ssp_player", "" + paVar3.k.a, e);
                            return;
                        }
                    }
                }
                break;
            case 4:
                if (this.y) {
                    z = false;
                } else {
                    this.w.b = new f2(this);
                    z = true;
                }
                if (this.t.h == QyVideoPlayOption.WIFI) {
                    this.w.c = new g2(this);
                    z = true;
                }
                if (z) {
                    this.w.a();
                }
                b(this.s);
                b(4);
                r2 r2Var4 = this.v;
                if (r2Var4 != null && this.a != null) {
                    TextView textView2 = r2Var4.a;
                    if (textView2 != null && r2Var4.l == QyBannerStyle.QYBANNER_TITLEIN) {
                        textView2.setVisibility(0);
                    }
                    if (!r2Var4.F) {
                        View view2 = r2Var4.i;
                        if (view2 instanceof QySharkView) {
                            view2.setVisibility(0);
                            r2Var4.i.a();
                        }
                    }
                    q2 q2Var5 = r2Var4.J;
                    if (q2Var5 != null) {
                        q2Var5.c = 4;
                    }
                    HashMap map = new HashMap(1);
                    map.put(v5.KEY_VIEW_COORDINATE, gj.a(r2Var4.I));
                    l lVarA2 = l.a();
                    p pVar4 = r2Var4.v;
                    lVarA2.getClass();
                    l.a(13, pVar4, map);
                    IQyBanner.IAdInteractionListener iAdInteractionListener3 = r2Var4.L;
                    if (iAdInteractionListener3 != null) {
                        iAdInteractionListener3.onAdStart();
                    }
                    x1 x1Var4 = r2Var4.K;
                    if (x1Var4 != null) {
                        x1Var4.a.c();
                    }
                    break;
                }
                break;
            case 5:
                b(5);
                r2 r2Var5 = this.v;
                if (r2Var5 != null && this.a != null) {
                    q2 q2Var6 = r2Var5.J;
                    if (q2Var6 != null) {
                        q2Var6.c = 5;
                    }
                    IQyBanner.IAdInteractionListener iAdInteractionListener4 = r2Var5.L;
                    if (iAdInteractionListener4 != null) {
                        iAdInteractionListener4.onAdStop();
                    }
                    break;
                }
                break;
        }
    }

    public final void b(int i) {
        int i2 = 8;
        this.d.setVisibility(((i != 1 || this.A) && i != 5) ? 8 : 0);
        this.f.setVisibility((i == 1 && this.A) ? 0 : 8);
        this.c.setVisibility((i == 1 || i == 5) ? 0 : 8);
        this.g.setVisibility(i == -1 ? 0 : 8);
        this.j.setVisibility(i == 11 ? 0 : 8);
        this.i.setVisibility(i == 11 ? 0 : 8);
        ImageView imageView = this.e;
        if (i != 11 && this.x != QyBannerStyle.QYBANNER_STRIP && !this.y) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
    }

    public final void c() {
        pa paVar = this.a;
        if (paVar == null || this.t == null) {
            return;
        }
        try {
            paVar.l = 0;
            paVar.e.set(false);
            zb zbVar = paVar.f;
            if (zbVar != null) {
                if (zbVar.f.hasMessages(110)) {
                    zbVar.f.removeMessages(110);
                }
                zbVar.c.post(new wb(zbVar));
            }
        } catch (Exception e) {
            r9.a("ssp_player", "" + paVar.k.a, e);
        }
        q2 q2Var = this.t;
        q2Var.c = 0;
        q2Var.b = 0;
        if (this.z) {
            this.a.a(q2Var.a);
        }
        if (this.u == null) {
            this.u = new v3(this, 0.5f, 200L);
        }
        this.u.a(this.B);
    }

    public final void d() {
        y9 y9Var = this.w;
        if (y9Var == null || !y9Var.e) {
            return;
        }
        try {
            y9Var.a.unregisterReceiver(y9Var.d);
            y9Var.b = null;
            y9Var.c = null;
            y9Var.e = false;
        } catch (Exception e) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.t.c == 11) {
            return;
        }
        if (this.u == null) {
            this.u = new v3(this, 0.5f, 200L);
        }
        this.u.a(this.B);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.h || view == this.i) {
            this.z = true;
            c();
        } else if (view != this.e) {
            this.z = true;
            a(true);
        } else {
            boolean z = !this.s;
            this.s = z;
            b(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r9.a("ssp_player", "onDetachedFromWindow: ", null);
        a();
        v3 v3Var = this.u;
        if (v3Var != null) {
            v3Var.a();
        }
        d();
    }

    public final void b(boolean z) {
        if (z) {
            this.a.a(0.0f);
            this.e.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
        } else {
            this.w.getClass();
            AudioManager audioManager = y9.f;
            this.a.a(audioManager != null ? audioManager.getStreamVolume(3) : -1.0f);
            this.e.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
        }
    }

    public final boolean b() {
        boolean zEquals;
        boolean zEquals2;
        if (this.z) {
            QyVideoPlayOption qyVideoPlayOption = this.t.h;
            if (qyVideoPlayOption == QyVideoPlayOption.WIFI) {
                zEquals2 = TextUtils.equals(ha.a(), "1");
            } else {
                zEquals2 = qyVideoPlayOption == QyVideoPlayOption.ALWAYS;
            }
            if (!zEquals2) {
                return this.A;
            }
        }
        if (this.A) {
            QyVideoPlayOption qyVideoPlayOption2 = this.t.h;
            if (qyVideoPlayOption2 == QyVideoPlayOption.WIFI) {
                zEquals = TextUtils.equals(ha.a(), "1");
            } else {
                zEquals = qyVideoPlayOption2 == QyVideoPlayOption.ALWAYS;
            }
            if (zEquals) {
                return true;
            }
        }
        return false;
    }

    public final void a(boolean z) {
        pa paVar = this.a;
        if (paVar == null || !z) {
            return;
        }
        if (this.t.c == 11) {
            c();
        } else {
            paVar.f();
        }
    }

    public final void a() {
        zb zbVar;
        int i;
        int iB;
        q2 q2Var = this.t;
        if (q2Var != null && (i = q2Var.c) != 0) {
            if (i == 11) {
                iB = this.a.b();
            } else {
                iB = this.a.l;
            }
            q2 q2Var2 = this.t;
            if (iB > q2Var2.b) {
                q2Var2.b = iB;
            }
        }
        pa paVar = this.a;
        if (paVar == null || (zbVar = paVar.f) == null) {
            return;
        }
        try {
            int i2 = paVar.k.a;
            int i3 = paVar.a;
            if (i3 != 4 && i3 != 1 && i3 != 3) {
                if (i3 == 6) {
                    zbVar.c.post(new xb(zbVar));
                    paVar.a = 7;
                    paVar.a(7);
                    return;
                } else {
                    if (i3 == 9) {
                        paVar.a = 10;
                        paVar.a(10);
                        return;
                    }
                    return;
                }
            }
            zbVar.c.post(new xb(zbVar));
            paVar.a = 5;
            paVar.a(5);
        } catch (Exception e) {
            int i4 = paVar.k.a;
        }
    }
}
