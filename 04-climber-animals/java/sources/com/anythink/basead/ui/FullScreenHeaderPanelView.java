package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenHeaderPanelView extends RelativeLayout {
    protected w a;
    protected x b;
    protected y c;
    protected a d;
    private View e;
    private TextView f;
    private TextView g;
    private ScanningAnimButton h;
    private RoundImageView i;
    private final View.OnClickListener j;

    public interface a {
        void a();
    }

    public FullScreenHeaderPanelView(Context context) {
        super(context);
        this.j = new View.OnClickListener() { // from class: com.anythink.basead.ui.FullScreenHeaderPanelView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FullScreenHeaderPanelView.this.c != null) {
                    if (FullScreenHeaderPanelView.this.c.H() == 1) {
                        if (FullScreenHeaderPanelView.this.h == null || view != FullScreenHeaderPanelView.this.h || FullScreenHeaderPanelView.this.d == null) {
                            return;
                        }
                        FullScreenHeaderPanelView.this.d.a();
                        return;
                    }
                    if (FullScreenHeaderPanelView.this.d != null) {
                        FullScreenHeaderPanelView.this.d.a();
                    }
                }
            }
        };
        a();
    }

    public FullScreenHeaderPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new View.OnClickListener() { // from class: com.anythink.basead.ui.FullScreenHeaderPanelView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FullScreenHeaderPanelView.this.c != null) {
                    if (FullScreenHeaderPanelView.this.c.H() == 1) {
                        if (FullScreenHeaderPanelView.this.h == null || view != FullScreenHeaderPanelView.this.h || FullScreenHeaderPanelView.this.d == null) {
                            return;
                        }
                        FullScreenHeaderPanelView.this.d.a();
                        return;
                    }
                    if (FullScreenHeaderPanelView.this.d != null) {
                        FullScreenHeaderPanelView.this.d.a();
                    }
                }
            }
        };
        a();
    }

    public FullScreenHeaderPanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new View.OnClickListener() { // from class: com.anythink.basead.ui.FullScreenHeaderPanelView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FullScreenHeaderPanelView.this.c != null) {
                    if (FullScreenHeaderPanelView.this.c.H() == 1) {
                        if (FullScreenHeaderPanelView.this.h == null || view != FullScreenHeaderPanelView.this.h || FullScreenHeaderPanelView.this.d == null) {
                            return;
                        }
                        FullScreenHeaderPanelView.this.d.a();
                        return;
                    }
                    if (FullScreenHeaderPanelView.this.d != null) {
                        FullScreenHeaderPanelView.this.d.a();
                    }
                }
            }
        };
        a();
    }

    private void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_full_screen_top_panel", "layout"), (ViewGroup) this, true);
        this.e = viewInflate;
        this.i = (RoundImageView) viewInflate.findViewById(q.a(getContext(), "myoffer_full_screen_top_banner_icon", "id"));
        this.h = (ScanningAnimButton) this.e.findViewById(q.a(getContext(), "myoffer_full_screen_top_banner_cta", "id"));
        this.f = (TextView) this.e.findViewById(q.a(getContext(), "myoffer_full_screen_top_banner_title", "id"));
        this.g = (TextView) this.e.findViewById(q.a(getContext(), "myoffer_full_screen_top_banner_desc", "id"));
        RoundImageView roundImageView = this.i;
        if (roundImageView != null) {
            roundImageView.setNeedRadiu(true);
            this.i.setRadiusInDip(12);
        }
        ScanningAnimButton scanningAnimButton = this.h;
        if (scanningAnimButton != null) {
            scanningAnimButton.setOnClickListener(this.j);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(q.a(getContext(), 12.0f));
        setBackground(gradientDrawable);
        setOnClickListener(this.j);
    }

    public void initSetting(w wVar, x xVar, a aVar) {
        this.a = wVar;
        this.b = xVar;
        this.c = xVar.o;
        this.d = aVar;
        String strZ = this.a.z();
        if (TextUtils.isEmpty(strZ)) {
            strZ = this.a.B();
        }
        if (!TextUtils.isEmpty(strZ)) {
            this.i.setVisibility(0);
            int iA = q.a(getContext(), 42.0f);
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, strZ), iA, iA, new AnonymousClass2(strZ));
        } else {
            this.i.setVisibility(8);
        }
        if (this.h != null) {
            if (!TextUtils.isEmpty(this.a.D())) {
                this.h.setText(this.a.D());
            } else {
                this.h.setText(com.anythink.basead.b.e.a(getContext(), this.a));
            }
            this.h.startAnimation(this.b.o.aF());
        }
        if (!TextUtils.isEmpty(this.a.x())) {
            this.f.setVisibility(0);
            this.f.setText(this.a.x());
        } else {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.a.y())) {
            this.g.setVisibility(0);
            this.g.setText(this.a.y());
        } else {
            this.g.setVisibility(8);
        }
    }

    private void b() {
        String strZ = this.a.z();
        if (TextUtils.isEmpty(strZ)) {
            strZ = this.a.B();
        }
        if (!TextUtils.isEmpty(strZ)) {
            this.i.setVisibility(0);
            int iA = q.a(getContext(), 42.0f);
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, strZ), iA, iA, new AnonymousClass2(strZ));
        } else {
            this.i.setVisibility(8);
        }
        if (this.h != null) {
            if (!TextUtils.isEmpty(this.a.D())) {
                this.h.setText(this.a.D());
            } else {
                this.h.setText(com.anythink.basead.b.e.a(getContext(), this.a));
            }
            this.h.startAnimation(this.b.o.aF());
        }
        if (!TextUtils.isEmpty(this.a.x())) {
            this.f.setVisibility(0);
            this.f.setText(this.a.x());
        } else {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.a.y())) {
            this.g.setVisibility(0);
            this.g.setText(this.a.y());
        } else {
            this.g.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.FullScreenHeaderPanelView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ String a;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass2(String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                FullScreenHeaderPanelView.this.i.setImageBitmap(bitmap);
            }
        }
    }
}
