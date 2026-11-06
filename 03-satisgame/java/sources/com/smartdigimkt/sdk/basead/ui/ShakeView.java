package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeView extends BaseShakeView {
    public static final String TAG = "ShakeView";
    public View n;
    public View o;
    public TextView p;
    public TextView q;
    public String r;

    public ShakeView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public final void a() {
        setOrientation(1);
        setGravity(1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_shake_button", "layout"), (ViewGroup) null);
        this.n = viewInflate;
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(k.a(getContext(), 300.0f), k.a(getContext(), 100.0f)));
        TextView textView = (TextView) this.n.findViewById(k.a(SDKContext.getInstance().d(), "tv_splash_shake_view_hint_text", "id"));
        this.p = textView;
        if (textView != null) {
            textView.setText(k.a(SDKContext.getInstance().d(), "myoffer_shake_full_title", "string"));
        }
        this.a = (ImageView) this.n.findViewById(k.a(SDKContext.getInstance().d(), "tv_splash_shake_view_icon", "id"));
        View viewInflate2 = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_shake_hint_text", "layout"), (ViewGroup) null);
        this.o = viewInflate2;
        viewInflate2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = (TextView) this.o.findViewById(k.a(SDKContext.getInstance().d(), "tv_splash_shake_hint_text", "id"));
        this.q = textView2;
        if (textView2 != null) {
            textView2.setText(k.a(SDKContext.getInstance().d(), "myoffer_shake_full_title", "string"));
        }
        this.b = (ImageView) this.o.findViewById(k.a(SDKContext.getInstance().d(), "tv_splash_shake_hint_icon", "id"));
        this.o.setVisibility(8);
        addView(this.n);
        addView(this.o);
    }

    public void replaceShakeCTAButton(View view) {
        View view2;
        if (view == null || (view2 = this.n) == null) {
            return;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            this.n.setVisibility(8);
            this.n = view;
            view.setVisibility(0);
            if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.LayoutParams)) {
                layoutParams = view.getLayoutParams();
            }
            d.a(view);
            SDKContext.getInstance().j();
            addView(view, layoutParams);
        } catch (Throwable th) {
            if (SDKContext.getInstance().j()) {
                th.getMessage();
            }
            d.a(this.n);
            addView(this.n);
            this.n.setVisibility(0);
        }
    }

    public void setNeedHideShakeIcon(boolean z) {
        if (z) {
            View view = this.o;
            if (view != null) {
                view.setVisibility(0);
                ImageView imageView = this.b;
                if (imageView != null) {
                    this.a = imageView;
                }
            }
            View view2 = this.n;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            this.n.setOnClickListener(onClickListener);
            this.o.setOnClickListener(onClickListener);
        } catch (Throwable unused) {
        }
    }

    public void setShakeHintText(String str) {
        this.r = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.p;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.q;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setShakeSetting(e eVar, int i) {
        String str;
        super.setShakeSetting(eVar, i);
        if (TextUtils.isEmpty(this.r)) {
            if (!TextUtils.isEmpty(this.g)) {
                TextView textView = this.p;
                if (textView != null) {
                    textView.setText(this.g);
                }
                TextView textView2 = this.q;
                if (textView2 != null) {
                    textView2.setText(this.g);
                    return;
                }
                return;
            }
            int iA = c0.a(getContext(), i);
            if (iA <= 0) {
                str = (i == 1 || i == 4) ? "摇动或点击下载应用" : "摇动或点击查看详情";
            } else {
                str = "";
            }
            TextView textView3 = this.p;
            if (textView3 != null) {
                if (iA > 0) {
                    textView3.setText(iA);
                } else if (!TextUtils.isEmpty(str)) {
                    this.p.setText(str);
                }
            }
            TextView textView4 = this.q;
            if (textView4 != null) {
                if (iA > 0) {
                    textView4.setText(iA);
                } else {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.q.setText(str);
                }
            }
        }
    }

    @Override // android.view.View
    public void startAnimation(Animation animation) {
        super.startAnimation(animation);
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
