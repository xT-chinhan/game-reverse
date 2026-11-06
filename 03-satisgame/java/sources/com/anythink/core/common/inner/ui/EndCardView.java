package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.g;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes.dex */
public class EndCardView extends BaseEndCardView {
    private int e;
    private int f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private Bitmap j;
    private final View.OnClickListener k;

    @Override // com.anythink.core.common.inner.ui.BaseEndCardView
    protected final void a() {
    }

    public EndCardView(Context context, w wVar, x xVar) {
        super(context, wVar, xVar);
        this.k = new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.EndCardView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (EndCardView.this.d != null) {
                    if (EndCardView.this.d.q() == 0) {
                        TextView unused = EndCardView.this.i;
                    } else {
                        if (EndCardView.this.i == null || view != EndCardView.this.i) {
                            return;
                        }
                        EndCardView.this.i.getVisibility();
                    }
                }
            }
        };
    }

    public void setSize(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.EndCardView$2, reason: invalid class name */
    final class AnonymousClass2 implements b.a {
        final /* synthetic */ w a;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass2(w wVar) {
            this.a = wVar;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a.m())) {
                EndCardView.this.g.setImageBitmap(bitmap);
                g.a(EndCardView.this.getContext(), bitmap, new g.a() { // from class: com.anythink.core.common.inner.ui.EndCardView.2.1
                    @Override // com.anythink.core.common.u.g.a
                    public final void a() {
                    }

                    @Override // com.anythink.core.common.u.g.a
                    public final void a(Bitmap bitmap2) {
                        EndCardView.this.j = bitmap2;
                        EndCardView.this.setBackgroundDrawable(new BitmapDrawable(EndCardView.this.j));
                    }
                });
            }
        }
    }

    private void a(w wVar) {
        try {
            b.a(getContext()).a(new e(1, wVar.m()), this.e, this.f, new AnonymousClass2(wVar));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    public void init(boolean z, boolean z2, BaseEndCardView.a aVar) {
        setId(p.a(getContext(), "myoffer_end_card_id", "id"));
        this.mListener = aVar;
        this.g = new RoundImageView(getContext());
        addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        if (z) {
            w wVar = this.b;
            this.h = new RoundImageView(getContext());
            int iA = p.a(getContext(), 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            addView(this.h, layoutParams);
            String strN = wVar.n();
            if (!TextUtils.isEmpty(strN)) {
                ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
                b.a(getContext()).a(new e(1, strN), layoutParams2.width, layoutParams2.height, new AnonymousClass3(strN, iA));
            }
        }
        if (z2) {
            ScanningAnimButton scanningAnimButton = new ScanningAnimButton(getContext());
            this.i = scanningAnimButton;
            scanningAnimButton.setText(p.a(getContext(), "myoffer_cta_learn_more", "string"));
            this.i.setTextColor(Color.parseColor("#ffffffff"));
            this.i.setTextSize(14.0f);
            this.i.setGravity(17);
            this.i.setBackgroundResource(p.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", "drawable"));
            if (!this.b.D()) {
                this.i.setOnClickListener(this.k);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, p.a(getContext(), 48.0f));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = p.a(getContext(), 96.0f);
            layoutParams3.leftMargin = p.a(getContext(), 24.0f);
            layoutParams3.rightMargin = p.a(getContext(), 24.0f);
            addView(this.i, layoutParams3);
        }
        if (this.b.D()) {
            return;
        }
        setOnClickListener(this.k);
    }

    private void b(w wVar) {
        this.h = new RoundImageView(getContext());
        int iA = p.a(getContext(), 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        addView(this.h, layoutParams);
        String strN = wVar.n();
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
        b.a(getContext()).a(new e(1, strN), layoutParams2.width, layoutParams2.height, new AnonymousClass3(strN, iA));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.EndCardView$3, reason: invalid class name */
    final class AnonymousClass3 implements b.a {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass3(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                int i = this.b;
                ViewGroup.LayoutParams layoutParams = EndCardView.this.h.getLayoutParams();
                layoutParams.width = (int) (i * width);
                layoutParams.height = i;
                EndCardView.this.h.setLayoutParams(layoutParams);
                EndCardView.this.h.setScaleType(ImageView.ScaleType.FIT_XY);
                EndCardView.this.h.setImageBitmap(bitmap);
            }
        }
    }

    private void c() {
        ScanningAnimButton scanningAnimButton = new ScanningAnimButton(getContext());
        this.i = scanningAnimButton;
        scanningAnimButton.setText(p.a(getContext(), "myoffer_cta_learn_more", "string"));
        this.i.setTextColor(Color.parseColor("#ffffffff"));
        this.i.setTextSize(14.0f);
        this.i.setGravity(17);
        this.i.setBackgroundResource(p.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", "drawable"));
        if (!this.b.D()) {
            this.i.setOnClickListener(this.k);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, p.a(getContext(), 48.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = p.a(getContext(), 96.0f);
        layoutParams.leftMargin = p.a(getContext(), 24.0f);
        layoutParams.rightMargin = p.a(getContext(), 24.0f);
        addView(this.i, layoutParams);
    }

    public void load() {
        w wVar = this.b;
        try {
            b.a(getContext()).a(new e(1, wVar.m()), this.e, this.f, new AnonymousClass2(wVar));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public View getLearnMoreButton() {
        return this.i;
    }

    @Override // com.anythink.core.common.inner.ui.BaseEndCardView
    protected final Drawable b() {
        Bitmap bitmap = this.j;
        if (bitmap != null && !bitmap.isRecycled()) {
            return new BitmapDrawable(this.j);
        }
        return super.b();
    }
}
