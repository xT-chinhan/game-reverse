package com.anythink.basead.f.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.ui.BaseMediaATView;
import com.anythink.basead.ui.SimpleMediaATView;
import com.anythink.basead.ui.SimplePlayerMediaView;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    FrameLayout p;

    public b(Context context, bj bjVar, x xVar, boolean z) {
        super(context, bjVar, xVar, z);
    }

    @Override // com.anythink.basead.f.a
    public final ViewGroup b() {
        this.c = G();
        return this.c;
    }

    @Override // com.anythink.basead.f.a
    public final View a(Context context, boolean z, BaseMediaATView.a aVar) {
        if (this.z == 1 && !TextUtils.isEmpty(this.s.E())) {
            SimplePlayerMediaView simplePlayerMediaView = new SimplePlayerMediaView(context);
            a((com.anythink.basead.ui.a) simplePlayerMediaView);
            return simplePlayerMediaView;
        }
        if (TextUtils.isEmpty(this.s.B())) {
            return null;
        }
        SimpleMediaATView simpleMediaATView = new SimpleMediaATView(context);
        simpleMediaATView.initView(this.s);
        if (this.t != null && this.t.o != null && this.t.o.H() != 1) {
            simpleMediaATView.setOnClickListener(this.n);
        }
        return simpleMediaATView;
    }

    @Override // com.anythink.basead.f.b.a.a, com.anythink.basead.f.a
    public final void a(View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, View view2) {
        final Context context;
        super.a(view, list, list2, layoutParams, view2);
        if (this.c == null || this.s == null || this.t == null || TextUtils.isEmpty(this.s.ak()) || (context = this.c.getContext()) == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        int iA = q.a(context, 5.0f);
        int iA2 = q.a(context, 24.0f);
        int iA3 = q.a(context, 4.0f);
        imageView.setPadding(iA, iA, iA, iA);
        imageView.setBackgroundResource(q.a(context, "myoffer_bg_feedback_button", "drawable"));
        imageView.setImageResource(q.a(context, "myoffer_feedback_icon", "drawable"));
        if (layoutParams != null) {
            layoutParams.width = iA2;
            layoutParams.height = iA2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = iA3;
            layoutParams.leftMargin = iA3;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.f.b.a.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                new com.anythink.basead.e().a(context, b.this.s, b.this.t, new com.anythink.basead.e.a() { // from class: com.anythink.basead.f.b.a.b.1.1
                    @Override // com.anythink.basead.e.a
                    public final void a() {
                    }

                    @Override // com.anythink.basead.e.a
                    public final void b() {
                    }
                });
            }
        });
        this.c.addView(imageView, layoutParams);
    }

    @Override // com.anythink.basead.f.b.a.a
    final View L() {
        View[] viewArr = new View[1];
        a(this.c, viewArr);
        if (viewArr[0] != null) {
            this.d = new WeakReference<>(viewArr[0]);
            return viewArr[0];
        }
        return this.c;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final View B() {
        if (!com.anythink.basead.b.e.a(this.t)) {
            return null;
        }
        if (this.p == null) {
            FrameLayout frameLayout = new FrameLayout(this.r);
            this.p = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.l.put(g.a.b, this.p);
        }
        return this.p;
    }

    private void a(View view, View[] viewArr) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), viewArr);
            }
            return;
        }
        if ((view instanceof TextView) && TextUtils.equals(((TextView) view).getText().toString(), this.s.D())) {
            viewArr[0] = view;
        }
    }
}
