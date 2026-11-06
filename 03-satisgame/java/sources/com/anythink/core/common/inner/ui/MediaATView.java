package com.anythink.core.common.inner.ui;

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
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.g;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaATView extends BaseMediaATView {
    public static final String TAG = "anythink_MediaATView";
    protected TextView j;
    protected TextView k;
    protected ImageView l;
    protected ImageView m;
    protected RoundImageView n;
    protected TextView o;
    protected ImageView p;
    RelativeLayout q;

    private static void d() {
    }

    public MediaATView(Context context, w wVar, x xVar, boolean z, BaseMediaATView.a aVar) {
        super(context, wVar, xVar, z, aVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.anythink.core.common.inner.ui.BaseMediaATView
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
        View viewInflate = LayoutInflater.from(getContext()).inflate(p.a(getContext(), str, "layout"), (ViewGroup) null, false);
        if (this.f != null) {
            this.f.removeAllViews();
            this.f.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        }
        this.j = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.k = (TextView) findViewById(p.a(getContext(), "myoffer_media_ad_cta", "id"));
        this.l = (ImageView) findViewById(p.a(getContext(), "myoffer_media_ad_bg_blur", "id"));
        this.m = (ImageView) findViewById(p.a(getContext(), "myoffer_media_ad_main_image", "id"));
        this.p = (ImageView) findViewById(p.a(getContext(), "myoffer_ad_logo", "id"));
        this.n = (RoundImageView) findViewById(p.a(getContext(), "myoffer_media_ad_icon", "id"));
        this.o = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_desc", "id"));
        this.q = (RelativeLayout) findViewById(p.a(getContext(), "myoffer_media_ad_container", "id"));
        String strJ = this.a.j();
        if (!TextUtils.isEmpty(strJ)) {
            this.j.setText(strJ);
        } else {
            this.j.setVisibility(8);
        }
        String strO = this.a.o();
        if (!TextUtils.isEmpty(strO)) {
            this.k.setText(strO);
        } else {
            this.k.setText(p.a(getContext(), "myoffer_cta_learn_more", "string"));
        }
        String strK = this.a.k();
        if (!TextUtils.isEmpty(strK)) {
            this.o.setText(strK);
        } else {
            this.o.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.a.l())) {
            this.n.setRadiusInDip(6);
            this.n.setNeedRadiu(true);
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            b.a(getContext()).a(new e(1, this.a.l()), layoutParams.width, layoutParams.height, new b.a() { // from class: com.anythink.core.common.inner.ui.MediaATView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str2, String str3) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str2, Bitmap bitmap) {
                    if (TextUtils.equals(MediaATView.this.a.l(), str2)) {
                        MediaATView.this.n.setImageBitmap(bitmap);
                    }
                }
            });
        } else {
            this.n.setVisibility(8);
        }
        this.i = new com.anythink.core.common.inner.ui.e.a(this.a, this.c);
        this.i.b(this);
        if (!com.anythink.core.common.inner.a.a.a(this.a) && (viewFindViewById = findViewById(p.a(getContext(), "myoffer_media_ad_main_image_container", "id"))) != null) {
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = p.a(getContext(), 84.0f);
                viewFindViewById.setLayoutParams(layoutParams2);
            }
        }
        a(i, i2);
        if ((this.k instanceof ScanningAnimButton) && this.a != null && this.a.f() != null) {
            ((ScanningAnimButton) this.k).startAnimation(this.a.f().D());
        }
        if (a()) {
            if (this.h == 3 || this.h == 4 || this.h == 5) {
                ViewGroup viewGroup = (ViewGroup) findViewById(p.a(getContext(), "myoffer_title_desc", "id"));
                if (viewGroup != null) {
                    ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
                    if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams3).leftMargin = getResources().getDimensionPixelSize(p.a(getContext(), "myoffer_template_margin_white", "dimen"));
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
        if (TextUtils.isEmpty(this.a.j()) && this.h == 6) {
            ViewGroup.LayoutParams layoutParams5 = this.o.getLayoutParams();
            if (layoutParams5 instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams5).topMargin = 0;
                this.o.setLayoutParams(layoutParams5);
            }
        }
        if (TextUtils.isEmpty(this.a.k())) {
            if (this.h == 2 || this.h == 1) {
                ViewGroup.LayoutParams layoutParams6 = this.k.getLayoutParams();
                if (layoutParams6 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
                    layoutParams7.addRule(13);
                    layoutParams7.removeRule(12);
                }
            }
            if (this.h != 5 || (frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_template_bg_desc", "id"))) == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }
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
                ViewGroup viewGroup = (ViewGroup) findViewById(p.a(getContext(), "myoffer_title_desc", "id"));
                if (viewGroup != null) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(p.a(getContext(), "myoffer_template_margin_white", "dimen"));
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
        if (TextUtils.isEmpty(this.a.j()) && this.h == 6) {
            ViewGroup.LayoutParams layoutParams3 = this.o.getLayoutParams();
            if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams3).topMargin = 0;
                this.o.setLayoutParams(layoutParams3);
            }
        }
        if (TextUtils.isEmpty(this.a.k())) {
            if (this.h == 2 || this.h == 1) {
                ViewGroup.LayoutParams layoutParams4 = this.k.getLayoutParams();
                if (layoutParams4 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
                    layoutParams5.addRule(13);
                    layoutParams5.removeRule(12);
                }
            }
            if (this.h != 5 || (frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_template_bg_desc", "id"))) == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    protected boolean a() {
        return TextUtils.isEmpty(this.a.l());
    }

    private void b(int i, int i2) {
        this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        b.a(getContext()).a(new e(1, this.a.m()), i, i2, new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.MediaATView$2, reason: invalid class name */
    final class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(MediaATView.this.a.m(), str)) {
                MediaATView.this.m.setVisibility(0);
                MediaATView.this.m.setImageBitmap(bitmap);
                MediaATView.this.post(new Runnable() { // from class: com.anythink.core.common.inner.ui.MediaATView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int width = MediaATView.this.getWidth();
                        int height = MediaATView.this.getHeight();
                        if (width <= 0 || height <= 0) {
                            return;
                        }
                        int[] iArrA = al.a(width, height, bitmap.getWidth() / bitmap.getHeight());
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MediaATView.this.m.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iArrA[0];
                            layoutParams.height = iArrA[1];
                            layoutParams.addRule(13);
                            MediaATView.this.m.setLayoutParams(layoutParams);
                        }
                    }
                });
                g.a(MediaATView.this.getContext(), bitmap, new g.a() { // from class: com.anythink.core.common.inner.ui.MediaATView.2.2
                    @Override // com.anythink.core.common.u.g.a
                    public final void a() {
                    }

                    @Override // com.anythink.core.common.u.g.a
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

    @Override // com.anythink.core.common.inner.ui.BaseMediaATView
    public List<View> getClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.k);
        if (this.b.q() == 1) {
            return arrayList;
        }
        arrayList.add(this.j);
        arrayList.add(this.m);
        arrayList.add(this.n);
        arrayList.add(this.o);
        if (this.b != null && this.b.q() == 0) {
            arrayList.add(this.l);
            arrayList.add(this.q);
        }
        return arrayList;
    }

    protected void a(int i, int i2) {
        this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        b.a(getContext()).a(new e(1, this.a.m()), i, i2, new AnonymousClass2());
    }
}
