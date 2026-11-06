package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.basead.b.e;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class ShakeView extends BaseShakeView {
    public static final String TAG = "ShakeView";
    TextView l;
    TextView m;
    String n;
    private View o;
    private View p;
    private Boolean q;

    public ShakeView(Context context) {
        super(context);
        this.q = Boolean.FALSE;
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = Boolean.FALSE;
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = Boolean.FALSE;
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.q = Boolean.FALSE;
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(1);
        setGravity(1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_shake_button", "layout"), (ViewGroup) null);
        this.o = viewInflate;
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(q.a(getContext(), 300.0f), q.a(getContext(), 100.0f)));
        TextView textView = (TextView) this.o.findViewById(q.a(t.b().g(), "tv_splash_shake_view_hint_text", "id"));
        this.l = textView;
        if (textView != null) {
            textView.setText(q.a(t.b().g(), "myoffer_shake_full_title", "string"));
        }
        this.a = (ImageView) this.o.findViewById(q.a(t.b().g(), "tv_splash_shake_view_icon", "id"));
        View viewInflate2 = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_shake_hint_text", "layout"), (ViewGroup) null);
        this.p = viewInflate2;
        viewInflate2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = (TextView) this.p.findViewById(q.a(t.b().g(), "tv_splash_shake_hint_text", "id"));
        this.m = textView2;
        if (textView2 != null) {
            textView2.setText(q.a(t.b().g(), "myoffer_shake_full_title", "string"));
        }
        this.b = (ImageView) this.p.findViewById(q.a(t.b().g(), "tv_splash_shake_hint_icon", "id"));
        this.p.setVisibility(8);
        addView(this.o);
        addView(this.p);
    }

    public void setNeedHideShakeIcon(boolean z) {
        this.q = Boolean.valueOf(z);
        if (z) {
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
                if (this.b != null) {
                    this.a = this.b;
                }
            }
            View view2 = this.o;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void startAnimation(Animation animation) {
        super.startAnimation(animation);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public void setShakeSetting(y yVar, int i) {
        super.setShakeSetting(yVar, i);
        if (TextUtils.isEmpty(this.n)) {
            if (!TextUtils.isEmpty(this.f)) {
                TextView textView = this.l;
                if (textView != null) {
                    textView.setText(this.f);
                }
                TextView textView2 = this.m;
                if (textView2 != null) {
                    textView2.setText(this.f);
                    return;
                }
                return;
            }
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setText(e.a(getContext(), i));
            }
            TextView textView4 = this.m;
            if (textView4 != null) {
                textView4.setText(e.a(getContext(), i));
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            this.o.setOnClickListener(onClickListener);
            this.p.setOnClickListener(onClickListener);
        } catch (Throwable unused) {
        }
    }

    public void setShakeHintText(String str) {
        this.n = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public void replaceShakeCTAButton(View view) {
        View view2;
        if (view == null || (view2 = this.o) == null) {
            return;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            this.o.setVisibility(8);
            this.o = view;
            view.setVisibility(0);
            if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.LayoutParams)) {
                layoutParams = view.getLayoutParams();
            }
            am.a(view);
            if (t.b().F()) {
                Log.d(TAG, "DIRECTLY Splash View replace shake cta success");
            }
            addView(view, layoutParams);
        } catch (Throwable th) {
            if (t.b().F()) {
                Log.d(TAG, "DIRECTLY Splash View replace shake cta fail:" + th.getMessage());
            }
            am.a(this.o);
            addView(this.o);
            this.o.setVisibility(0);
        }
    }
}
