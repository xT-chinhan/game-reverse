package com.onevcat.uniwebview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Q extends Toolbar {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public S d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setTitle("");
        setElevation(5.0f);
        setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(context);
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        linearLayout.setLayoutParams(layoutParams);
        TextView textViewA = a("❮");
        this.b = textViewA;
        TextView textViewA2 = a("❯");
        this.c = textViewA2;
        TextView textViewA3 = a("Done");
        this.a = textViewA3;
        a(false, false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(24, 0, 24, 0);
        linearLayout.addView(textViewA, layoutParams2);
        linearLayout.addView(textViewA2, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(48, 0, 24, 0);
        linearLayout.addView(textViewA3, layoutParams3);
        addView(linearLayout);
    }

    public final TextView a(String str) {
        final TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.onevcat.uniwebview.Q$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Q.a(this.f$0, textView, view);
            }
        });
        return textView;
    }

    public final void b(float f, float f2, float f3, float f4) {
        float f5 = 255;
        setTitleTextColor(Color.argb((int) (f4 * f5), (int) (f * f5), (int) (f2 * f5), (int) (f3 * f5)));
    }

    public final S getDelegate() {
        return this.d;
    }

    public final void setDelegate(S s) {
        this.d = s;
    }

    public final void setDoneButtonText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a.setText(text);
    }

    public final void setGoBackButtonText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.b.setText(text);
    }

    public final void setGoForwardButtonText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.c.setText(text);
    }

    public final void setNavigationButtonsShow(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
        this.c.setVisibility(z ? 0 : 8);
    }

    public static final void a(Q this$0, TextView button, View view) {
        S s;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(button, "$button");
        if (Intrinsics.areEqual(button, this$0.a)) {
            S s2 = this$0.d;
            if (s2 != null) {
                N n = (N) s2;
                n.c.a(n.p.getName(), d2.WebViewDone, "");
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(button, this$0.b)) {
            S s3 = this$0.d;
            if (s3 != null) {
                ((N) s3).p.b();
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(button, this$0.c) || (s = this$0.d) == null) {
            return;
        }
        C0764w c0764w = ((N) s).p;
        C0764w c0764w2 = c0764w.d.i;
        if (c0764w2 != null) {
            if (c0764w2.canGoForward()) {
                c0764w2.goForward();
            }
        } else if (c0764w.canGoForward()) {
            c0764w.goForward();
        }
    }

    public final void a(float f, float f2, float f3, float f4) {
        float f5 = 255;
        setBackgroundColor(Color.argb((int) (f4 * f5), (int) (f * f5), (int) (f2 * f5), (int) (f3 * f5)));
    }

    public final void a(boolean z, boolean z2) {
        this.b.setEnabled(z);
        this.b.setAlpha(z ? 1.0f : 0.3f);
        this.c.setEnabled(z2);
        this.c.setAlpha(z2 ? 1.0f : 0.3f);
    }
}
