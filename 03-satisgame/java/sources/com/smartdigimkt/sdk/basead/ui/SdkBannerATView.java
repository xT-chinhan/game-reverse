package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.h.y;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.e3.a;
import com.smartdigimkt.i2.j;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.n0;
import com.smartdigimkt.n1.o0;
import com.smartdigimkt.n1.q4;
import com.smartdigimkt.n1.r4;
import com.smartdigimkt.n1.s4;
import com.smartdigimkt.n1.t4;
import com.smartdigimkt.n1.u4;
import com.smartdigimkt.n1.w4;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class SdkBannerATView extends BaseBannerATView {
    public static final /* synthetic */ int N = 0;
    public String I;
    public int J;
    public SimplePlayerBannerMediaView K;
    public final q4 L;
    public final r4 M;

    public SdkBannerATView(Context context) {
        super(context);
        this.L = new q4(this);
        this.M = new r4(this);
    }

    public final void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (c0.h(this.c, this.b)) {
                SimplePlayerBannerMediaView simplePlayerBannerMediaView = new SimplePlayerBannerMediaView(getContext());
                this.K = simplePlayerBannerMediaView;
                simplePlayerBannerMediaView.setmIsPureMode(this.J == 1);
                viewGroup.addView(this.K, 0, new RelativeLayout.LayoutParams(-1, -1));
                this.K.setATImproveClickViewController(this.o);
                this.K.setIsMuted(true);
                this.K.initPlayerView(this.c, this.b, new t4(this));
                this.K.setPlayerOnClickListener(new u4(this));
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = this.c.a(this.b.s);
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.c.e;
                }
                if (TextUtils.isEmpty(str)) {
                    viewGroup.setVisibility(8);
                    return;
                }
                RecycleImageView recycleImageView = new RecycleImageView(getContext());
                recycleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                RecycleImageView recycleImageView2 = new RecycleImageView(getContext());
                recycleImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                viewGroup.addView(recycleImageView2, 0, new RelativeLayout.LayoutParams(-1, -1));
                m.a(getContext()).a(new o(1, str), -1, -1, new w4(this, str, recycleImageView, recycleImageView2));
                viewGroup.addView(recycleImageView, 1, new RelativeLayout.LayoutParams(-1, -1));
                this.j.add(recycleImageView);
            }
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        SimplePlayerBannerMediaView simplePlayerBannerMediaView = this.K;
        if (simplePlayerBannerMediaView != null) {
            simplePlayerBannerMediaView.destroyPlayerView(4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        byte b;
        String str;
        String str2 = this.b.s.n;
        if (TextUtils.isEmpty(str2)) {
            str2 = y.a;
        }
        String strA = this.c.a(this.b.s);
        int iHashCode = str2.hashCode();
        if (iHashCode != -559799608) {
            if (iHashCode != 1507809730) {
                if (iHashCode != 1507809854) {
                    if (iHashCode == 1622564786 && str2.equals(y.d)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals(y.b)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals(y.a)) {
                b = 3;
            } else {
                b = -1;
            }
        } else if (str2.equals(y.c)) {
            b = 1;
        } else {
            b = -1;
        }
        if (b == 0) {
            this.I = y.b;
            str = (this.c.h() || !TextUtils.isEmpty(strA)) ? "myoffer_banner_ad_layout_320x90" : "myoffer_banner_ad_layout_no_main_res_320x90";
        } else if (b == 1) {
            this.I = y.c;
            str = "myoffer_banner_ad_layout_300x250";
        } else if (b != 2) {
            this.I = y.a;
            str = "myoffer_banner_ad_layout_320x50";
        } else {
            this.I = y.d;
            str = "myoffer_banner_ad_layout_728x90";
        }
        c cVar = this.c;
        int i = (!(cVar instanceof l) ? !(!(cVar instanceof a) || TextUtils.equals(strA, cVar.f)) : ((l) cVar).U == 1) ? 2 : 1;
        this.J = i;
        if (1 == i) {
            LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_banner_ad_layout_pure_picture", "layout"), this);
            int iA = k.a(getContext(), 320.0f);
            int iA2 = k.a(getContext(), 50.0f);
            str2.hashCode();
            switch (str2) {
                case "300x250":
                    iA = k.a(getContext(), 300.0f);
                    iA2 = k.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = k.a(getContext(), 320.0f);
                    iA2 = k.a(getContext(), 50.0f);
                    break;
                case "320x90":
                    iA = k.a(getContext(), 320.0f);
                    iA2 = k.a(getContext(), 90.0f);
                    break;
                case "728x90":
                    iA = k.a(getContext(), 720.0f);
                    iA2 = k.a(getContext(), 90.0f);
                    break;
            }
            e eVar = this.b.s;
            int i2 = eVar.I;
            if (i2 > 0) {
                iA = i2;
            }
            int i3 = eVar.J;
            if (i3 > 0) {
                iA2 = i3;
            }
            setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(k.a(getContext(), "myoffer_banner_root", "id"));
            CloseImageView closeImageView = (CloseImageView) findViewById(k.a(getContext(), "myoffer_banner_close", "id"));
            this.E = closeImageView;
            if (this.b.s.o == 0) {
                closeImageView.setVisibility(0);
                if (TextUtils.equals(y.d, this.I)) {
                    ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
                    layoutParams.width = k.a(getContext(), 23.0f);
                    layoutParams.height = k.a(getContext(), 23.0f);
                    this.E.setLayoutParams(layoutParams);
                }
                a(this.E, false);
            } else {
                com.smartdigimkt.i2.l.a(closeImageView, true);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            relativeLayout.setLayoutParams(layoutParams2);
            a(this, strA);
        } else {
            LayoutInflater.from(getContext()).inflate(k.a(getContext(), str, "layout"), this);
            RoundImageView roundImageView = (RoundImageView) findViewById(k.a(getContext(), "myoffer_banner_icon", "id"));
            TextView textView = (TextView) findViewById(k.a(getContext(), "myoffer_banner_ad_title", "id"));
            TextView textView2 = (TextView) findViewById(k.a(getContext(), "myoffer_banner_desc", "id"));
            Button button = (Button) findViewById(k.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
            this.m = button;
            CloseImageView closeImageView2 = (CloseImageView) findViewById(k.a(getContext(), "myoffer_banner_close", "id"));
            this.E = closeImageView2;
            if (this.b.s.o == 0) {
                closeImageView2.setVisibility(0);
                a(this.E, false);
            } else {
                com.smartdigimkt.i2.l.a(closeImageView2, true);
            }
            if (roundImageView != null) {
                if (TextUtils.isEmpty(this.c.e)) {
                    roundImageView.setVisibility(0);
                    com.smartdigimkt.i2.l.a(roundImageView, false);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = roundImageView.getLayoutParams();
                    roundImageView.setVisibility(0);
                    roundImageView.setRadiusInDip(6);
                    roundImageView.setNeedRadiu(true);
                    this.j.add(roundImageView);
                    m.a(getContext()).a(new o(1, this.c.e), layoutParams3.width, layoutParams3.height, new s4(this, roundImageView));
                }
            }
            if (TextUtils.isEmpty(this.c.h)) {
                button.setVisibility(8);
            } else {
                button.setText(this.c.h);
                button.setVisibility(0);
                this.j.add(button);
                setTrackClickAreaView(button);
            }
            if (TextUtils.isEmpty(this.c.c)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.c.c);
                textView.setVisibility(0);
                this.j.add(textView);
            }
            if (textView2 != null) {
                if (TextUtils.isEmpty(this.c.d)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(this.c.d);
                    textView2.setVisibility(0);
                    this.j.add(textView2);
                }
            }
            a((ViewGroup) findViewById(k.a(getContext(), "myoffer_main_resouce_container", "id")), (String) null);
        }
        new j(this.c, this.b).a(this);
    }

    public SdkBannerATView(Context context, com.smartdigimkt.a3.a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
        q4 q4Var = new q4(this);
        this.L = q4Var;
        r4 r4Var = new r4(this);
        this.M = r4Var;
        int i = this.b.s.R;
        this.A = new n0(this);
        c();
        this.E.setOnTouchListener(new o0(this));
        if (this.J != 1) {
            if (this.b.s.e == 1) {
                View view = this.m;
                if (view != null) {
                    view.setOnClickListener(r4Var);
                }
            } else {
                int size = this.j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view2 = (View) this.j.get(i2);
                    if (view2 != null) {
                        view2.setOnClickListener(this.M);
                    }
                }
            }
            if (this.b.s.e == 0) {
                setOnClickListener(this.L);
                return;
            }
            return;
        }
        setOnClickListener(q4Var);
    }
}
