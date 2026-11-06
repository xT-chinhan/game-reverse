package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaATView extends BaseMediaATView implements a {
    public static final String TAG = "anythink_MediaATView";
    protected TextView j;
    protected TextView k;
    protected ImageView l;
    protected ImageView m;
    protected RoundImageView n;
    protected TextView o;
    protected ImageView p;
    RelativeLayout q;
    private SimplePlayerMediaView r;

    public MediaATView(Context context, w wVar, x xVar, boolean z, BaseMediaATView.a aVar) {
        super(context, wVar, xVar, z, aVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public void init(int i, int i2, int i3) {
        String str;
        FrameLayout frameLayout;
        TextView textView;
        View viewFindViewById;
        super.init(i, i2, i3);
        int i4 = this.h;
        if (i4 == 1) {
            str = "myoffer_template_left_image";
        } else if (i4 == 2) {
            str = "myoffer_template_left_text";
        } else if (i4 == 3) {
            str = "myoffer_template_top_image";
        } else if (i4 != 4) {
            str = i4 != 5 ? "myoffer_media_ad_view" : "myoffer_template_text_float";
        } else {
            str = "myoffer_template_top_text";
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), str, "layout"), (ViewGroup) null, false);
        if (this.f != null) {
            this.f.removeAllViews();
            this.f.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        }
        this.j = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.k = (TextView) findViewById(q.a(getContext(), "myoffer_media_ad_cta", "id"));
        this.l = (ImageView) findViewById(q.a(getContext(), "myoffer_media_ad_bg_blur", "id"));
        this.m = (ImageView) findViewById(q.a(getContext(), "myoffer_media_ad_main_image", "id"));
        this.p = (ImageView) findViewById(q.a(getContext(), "myoffer_ad_logo", "id"));
        this.n = (RoundImageView) findViewById(q.a(getContext(), "myoffer_media_ad_icon", "id"));
        this.o = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_desc", "id"));
        this.q = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_media_ad_container", "id"));
        String strX = this.a.x();
        if (!TextUtils.isEmpty(strX)) {
            this.j.setText(strX);
        } else {
            this.j.setVisibility(8);
        }
        String strD = this.a.D();
        if (!TextUtils.isEmpty(strD)) {
            this.k.setText(strD);
        } else {
            this.k.setText(q.a(getContext(), "myoffer_cta_learn_more", "string"));
        }
        String strY = this.a.y();
        if (!TextUtils.isEmpty(strY)) {
            this.o.setText(strY);
        } else {
            this.o.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.a.z())) {
            this.n.setRadiusInDip(6);
            this.n.setNeedRadiu(true);
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.a.z()), layoutParams.width, layoutParams.height, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.MediaATView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str2, String str3) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str2, Bitmap bitmap) {
                    if (TextUtils.equals(MediaATView.this.a.z(), str2)) {
                        MediaATView.this.n.setImageBitmap(bitmap);
                    }
                }
            });
        } else {
            this.n.setVisibility(8);
        }
        this.i = new com.anythink.basead.ui.f.a(this.a, this.c);
        this.i.b(this);
        if (!com.anythink.basead.b.e.a(this.a) && (viewFindViewById = findViewById(q.a(getContext(), "myoffer_media_ad_main_image_container", "id"))) != null) {
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = q.a(getContext(), 84.0f);
                viewFindViewById.setLayoutParams(layoutParams2);
            }
        }
        a(i, i2);
        if ((this.k instanceof ScanningAnimButton) && this.a != null && this.a.r() != null) {
            ((ScanningAnimButton) this.k).startAnimation(this.a.r().aF());
        }
        if (a()) {
            if (this.h == 3 || this.h == 4 || this.h == 5) {
                ViewGroup viewGroup = (ViewGroup) findViewById(q.a(getContext(), "myoffer_title_desc", "id"));
                if (viewGroup != null) {
                    ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
                    if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams3).leftMargin = getResources().getDimensionPixelSize(q.a(getContext(), "myoffer_template_margin_white", "dimen"));
                        viewGroup.setLayoutParams(layoutParams3);
                    }
                }
            } else if ((this.h == 1 || this.h == 2) && (textView = this.j) != null) {
                ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                if (layoutParams4 instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams4).leftMargin = 0;
                    this.j.setLayoutParams(layoutParams4);
                }
            }
        }
        if (TextUtils.isEmpty(this.a.x()) && this.h == 6) {
            ViewGroup.LayoutParams layoutParams5 = this.o.getLayoutParams();
            if (layoutParams5 instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams5).topMargin = 0;
                this.o.setLayoutParams(layoutParams5);
            }
        }
        if (TextUtils.isEmpty(this.a.y())) {
            if (this.h == 2 || this.h == 1) {
                ViewGroup.LayoutParams layoutParams6 = this.k.getLayoutParams();
                if (layoutParams6 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
                    layoutParams7.addRule(13);
                    layoutParams7.removeRule(12);
                }
            }
            if (this.h != 5 || (frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_template_bg_desc", "id"))) == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    protected void a(int i, int i2) {
        if (com.anythink.basead.b.e.a(this.a, this.c)) {
            SimplePlayerMediaView simplePlayerMediaView = (SimplePlayerMediaView) findViewById(q.a(getContext(), "myoffer_media_ad_simple_player_view_no_g2c", "id"));
            this.r = simplePlayerMediaView;
            if (simplePlayerMediaView != null) {
                simplePlayerMediaView.setVisibility(0);
                return;
            }
            return;
        }
        this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.a.B()), i, i2, new AnonymousClass2());
    }

    private String b() {
        int i = this.h;
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

    private void c() {
        FrameLayout frameLayout;
        TextView textView;
        if (a()) {
            if (this.h == 3 || this.h == 4 || this.h == 5) {
                ViewGroup viewGroup = (ViewGroup) findViewById(q.a(getContext(), "myoffer_title_desc", "id"));
                if (viewGroup != null) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(q.a(getContext(), "myoffer_template_margin_white", "dimen"));
                        viewGroup.setLayoutParams(layoutParams);
                    }
                }
            } else if ((this.h == 1 || this.h == 2) && (textView = this.j) != null) {
                ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                    this.j.setLayoutParams(layoutParams2);
                }
            }
        }
        if (TextUtils.isEmpty(this.a.x()) && this.h == 6) {
            ViewGroup.LayoutParams layoutParams3 = this.o.getLayoutParams();
            if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams3).topMargin = 0;
                this.o.setLayoutParams(layoutParams3);
            }
        }
        if (TextUtils.isEmpty(this.a.y())) {
            if (this.h == 2 || this.h == 1) {
                ViewGroup.LayoutParams layoutParams4 = this.k.getLayoutParams();
                if (layoutParams4 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
                    layoutParams5.addRule(13);
                    layoutParams5.removeRule(12);
                }
            }
            if (this.h != 5 || (frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_template_bg_desc", "id"))) == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    protected boolean a() {
        return TextUtils.isEmpty(this.a.z());
    }

    private void b(int i, int i2) {
        this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.a.B()), i, i2, new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MediaATView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(MediaATView.this.a.B(), str)) {
                MediaATView.this.m.setVisibility(0);
                MediaATView.this.m.setImageBitmap(bitmap);
                MediaATView.this.post(new Runnable() { // from class: com.anythink.basead.ui.MediaATView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int width = MediaATView.this.getWidth();
                        int height = MediaATView.this.getHeight();
                        if (width <= 0 || height <= 0) {
                            return;
                        }
                        int[] iArrA = am.a(width, height, bitmap.getWidth() / bitmap.getHeight());
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MediaATView.this.m.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iArrA[0];
                            layoutParams.height = iArrA[1];
                            layoutParams.addRule(13);
                            MediaATView.this.m.setLayoutParams(layoutParams);
                        }
                    }
                });
                h.a(MediaATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.MediaATView.2.2
                    @Override // com.anythink.core.common.v.h.a
                    public final void a() {
                    }

                    @Override // com.anythink.core.common.v.h.a
                    public final void a(Bitmap bitmap2) {
                        MediaATView.this.l.setVisibility(0);
                        MediaATView.this.l.setScaleType(ImageView.ScaleType.FIT_XY);
                        MediaATView.this.l.setImageBitmap(bitmap2);
                    }
                });
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            Log.e(MediaATView.TAG, "load: image load fail:".concat(String.valueOf(str2)));
        }
    }

    private void d() {
        SimplePlayerMediaView simplePlayerMediaView = (SimplePlayerMediaView) findViewById(q.a(getContext(), "myoffer_media_ad_simple_player_view_no_g2c", "id"));
        this.r = simplePlayerMediaView;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public View getMonitorClickView() {
        return this.k;
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public List<View> getClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.k);
        if (this.b.H() == 1) {
            return arrayList;
        }
        arrayList.add(this.j);
        arrayList.add(this.m);
        arrayList.add(this.n);
        arrayList.add(this.o);
        if (this.b != null && this.b.H() == 0) {
            arrayList.add(this.l);
            arrayList.add(this.q);
        }
        return arrayList;
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public List<View> getContainerClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.l);
        arrayList.add(this.q);
        return arrayList;
    }

    @Override // com.anythink.basead.ui.a
    public void initPlayerView(w wVar, x xVar, com.anythink.basead.ui.component.a.InterfaceC0058a interfaceC0058a, com.anythink.basead.j.e eVar) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.initPlayerView(wVar, xVar, interfaceC0058a, eVar);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void resumeVideo() {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.resumeVideo();
        }
    }

    @Override // com.anythink.basead.ui.a
    public void pauseVideo() {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.pauseVideo();
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setIsMuted(boolean z) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setIsMuted(z);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setVideoListener(a.InterfaceC0052a interfaceC0052a) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setVideoListener(interfaceC0052a);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setATImproveClickViewController(com.anythink.basead.ui.improveclick.a aVar) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setATImproveClickViewController(aVar);
        }
    }

    @Override // com.anythink.basead.ui.a
    public long getVideoCurrentPosition() {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            return simplePlayerMediaView.getVideoCurrentPosition();
        }
        return 0L;
    }

    @Override // com.anythink.basead.ui.a
    public void destroyPlayerView(int i) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.destroyPlayerView(i);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setPlayerOnClickListener(View.OnClickListener onClickListener) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setPlayerOnClickListener(onClickListener);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setAutoPlay(String str) {
        SimplePlayerMediaView simplePlayerMediaView = this.r;
        if (simplePlayerMediaView != null) {
            simplePlayerMediaView.setAutoPlay(str);
        }
    }
}
