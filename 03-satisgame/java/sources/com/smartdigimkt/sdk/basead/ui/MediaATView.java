package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.h1.n;
import com.smartdigimkt.i2.j;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.i3;
import com.smartdigimkt.n1.s3;
import com.smartdigimkt.n1.v3;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MediaATView extends BaseMediaATView implements i3 {
    public static final String TAG = "sdm_MediaATView";
    public TextView l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public RoundImageView p;
    public TextView q;
    public RelativeLayout r;
    public SimplePlayerMediaView s;

    public MediaATView(Context context, c cVar, a aVar, n nVar) {
        super(context, cVar, aVar, nVar);
    }

    private String getLayoutResName() {
        int i = this.k;
        if (i == 1) {
            return "myoffer_template_left_image";
        }
        if (i == 2) {
            return "myoffer_template_left_text";
        }
        if (i == 3) {
            return "myoffer_template_top_image";
        }
        if (i != 4) {
            return i != 5 ? "myoffer_media_ad_view" : "myoffer_template_text_float";
        }
        return "myoffer_template_top_text";
    }

    @Override // com.smartdigimkt.n1.i3
    public void destroyPlayerView(int i) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.destroyPlayerView(i);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseMediaATView
    public List<View> getClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.m);
        if (this.b.e == 1) {
            return arrayList;
        }
        arrayList.add(this.l);
        arrayList.add(this.o);
        arrayList.add(this.p);
        arrayList.add(this.q);
        e eVar = this.b;
        if (eVar != null && eVar.e == 0) {
            arrayList.add(this.n);
            arrayList.add(this.r);
        }
        return arrayList;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseMediaATView
    public List<View> getContainerClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n);
        arrayList.add(this.r);
        return arrayList;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseMediaATView
    public View getMonitorClickView() {
        return this.m;
    }

    @Override // com.smartdigimkt.n1.i3
    public long getVideoCurrentPosition() {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            return simplePlayerMediaView.getVideoCurrentPosition();
        }
        return 0L;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseMediaATView
    public void init(int i, int i2, int i3) {
        FrameLayout frameLayout;
        TextView textView;
        c cVar;
        e eVar;
        View viewFindViewById;
        super.init(i, i2, i3);
        View viewInflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), getLayoutResName(), "layout"), (ViewGroup) null, false);
        FrameLayout frameLayout2 = this.i;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            this.i.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        }
        this.l = (TextView) findViewById(k.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.m = (TextView) findViewById(k.a(getContext(), "myoffer_media_ad_cta", "id"));
        this.n = (ImageView) findViewById(k.a(getContext(), "myoffer_media_ad_bg_blur", "id"));
        this.o = (ImageView) findViewById(k.a(getContext(), "myoffer_media_ad_main_image", "id"));
        this.p = (RoundImageView) findViewById(k.a(getContext(), "myoffer_media_ad_icon", "id"));
        this.q = (TextView) findViewById(k.a(getContext(), "myoffer_banner_ad_desc", "id"));
        this.r = (RelativeLayout) findViewById(k.a(getContext(), "myoffer_media_ad_container", "id"));
        String str = this.a.c;
        if (TextUtils.isEmpty(str)) {
            this.l.setVisibility(8);
        } else {
            this.l.setText(str);
        }
        String str2 = this.a.h;
        if (TextUtils.isEmpty(str2)) {
            this.m.setText(k.a(getContext(), "myoffer_cta_learn_more", "string"));
        } else {
            this.m.setText(str2);
        }
        String str3 = this.a.d;
        if (TextUtils.isEmpty(str3)) {
            this.q.setVisibility(8);
        } else {
            this.q.setText(str3);
        }
        if (TextUtils.isEmpty(this.a.e)) {
            this.p.setVisibility(8);
        } else {
            this.p.setRadiusInDip(6);
            this.p.setNeedRadiu(true);
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            m.a(getContext()).a(new o(1, this.a.e), layoutParams.width, layoutParams.height, new s3(this));
        }
        new j(this.a, this.c).a(this);
        if (!c0.a(this.a) && (viewFindViewById = findViewById(k.a(getContext(), "myoffer_media_ad_main_image_container", "id"))) != null) {
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = k.a(getContext(), 84.0f);
                viewFindViewById.setLayoutParams(layoutParams2);
            }
        }
        if (c0.h(this.a, this.c)) {
            SimplePlayerMediaView simplePlayerMediaView = (SimplePlayerMediaView) findViewById(k.a(getContext(), "myoffer_media_ad_simple_player_view_no_g2c", "id"));
            this.s = simplePlayerMediaView;
            if (simplePlayerMediaView != null) {
                simplePlayerMediaView.setVisibility(0);
            }
        } else {
            this.o.setScaleType(ImageView.ScaleType.FIT_CENTER);
            m.a(getContext()).a(new o(1, this.a.f), i, i2, new v3(this));
        }
        TextView textView2 = this.m;
        if ((textView2 instanceof ScanningAnimButton) && (cVar = this.a) != null && (eVar = cVar.w) != null) {
            ((ScanningAnimButton) textView2).startAnimation(eVar.z0);
        }
        if (TextUtils.isEmpty(this.a.e)) {
            int i4 = this.k;
            if (i4 == 3 || i4 == 4 || i4 == 5) {
                ViewGroup viewGroup = (ViewGroup) findViewById(k.a(getContext(), "myoffer_title_desc", "id"));
                if (viewGroup != null) {
                    ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
                    if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams3).leftMargin = getResources().getDimensionPixelSize(k.a(getContext(), "myoffer_template_margin_white", "dimen"));
                        viewGroup.setLayoutParams(layoutParams3);
                    }
                }
            } else if ((i4 == 1 || i4 == 2) && (textView = this.l) != null) {
                ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                if (layoutParams4 instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams4).leftMargin = 0;
                    this.l.setLayoutParams(layoutParams4);
                }
            }
        }
        if (TextUtils.isEmpty(this.a.c) && this.k == 6) {
            ViewGroup.LayoutParams layoutParams5 = this.q.getLayoutParams();
            if (layoutParams5 instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams5).topMargin = 0;
                this.q.setLayoutParams(layoutParams5);
            }
        }
        if (TextUtils.isEmpty(this.a.d)) {
            int i5 = this.k;
            if (i5 == 2 || i5 == 1) {
                ViewGroup.LayoutParams layoutParams6 = this.m.getLayoutParams();
                if (layoutParams6 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
                    layoutParams7.addRule(13);
                    layoutParams7.removeRule(12);
                }
            }
            if (this.k != 5 || (frameLayout = (FrameLayout) findViewById(k.a(getContext(), "myoffer_template_bg_desc", "id"))) == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void initPlayerView(c cVar, a aVar, com.smartdigimkt.u1.c cVar2) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.initPlayerView(cVar, aVar, cVar2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.smartdigimkt.n1.i3
    public void pauseVideo() {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.pauseVideo();
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void resumeVideo() {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.resumeVideo();
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setATImproveClickViewController(com.smartdigimkt.b2.c cVar) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setATImproveClickViewController(cVar);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setAutoPlay(String str) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setAutoPlay(str);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setIsMuted(boolean z) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setIsMuted(z);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setPlayerOnClickListener(View.OnClickListener onClickListener) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setPlayerOnClickListener(onClickListener);
        }
    }

    @Override // com.smartdigimkt.n1.i3
    public void setVideoListener(SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener) {
        SimplePlayerMediaView simplePlayerMediaView = this.s;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setVideoListener(sDMNativeAdMediaViewListener);
        }
    }
}
