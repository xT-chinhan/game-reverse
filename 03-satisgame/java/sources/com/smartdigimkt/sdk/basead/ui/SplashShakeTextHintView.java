package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class SplashShakeTextHintView extends ShakeTextHintView {
    public SplashShakeTextHintView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView, com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public final void a() {
        setOrientation(0);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        int iA = k.a(getContext(), 4.0f);
        setPadding(iA, iA, iA, iA);
        Context contextD = SDKContext.getInstance().d();
        int iA2 = k.a(contextD, "myoffer_shake_text_hint_img", "id");
        int iA3 = k.a(contextD, "myoffer_shake_text_hint_title", "id");
        this.a = (ImageView) findViewById(iA2);
        TextView textView = (TextView) findViewById(iA3);
        this.tvShakeTitleView = textView;
        if (textView != null) {
            textView.setGravity(17);
            this.tvShakeTitleView.setTextAlignment(4);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView
    public int getLayoutId() {
        return k.a(getContext(), "myoffer_shake_text_hint_splash", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeTextHintView, com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setShakeSetting(e eVar, int i) {
        setShakeSetting(eVar, i, null);
    }

    public void setTextSize(int i) {
        TextView textView = this.tvShakeTitleView;
        if (textView != null) {
            textView.setTextSize(1, i);
        }
    }

    public void showDefaultCta(CharSequence charSequence) {
        releaseShakeListener();
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.tvShakeTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public SplashShakeTextHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setShakeSetting(e eVar, int i, c cVar) {
        super.setShakeSetting(eVar, i);
        if (this.tvShakeTitleView == null) {
            return;
        }
        String str = "摇动或点击查看详情";
        if ((cVar instanceof l) && ((l) cVar).U == 3) {
            if (!TextUtils.isEmpty(this.h)) {
                this.tvShakeTitleView.setText(this.h);
                return;
            }
            int iA = c0.a(getContext(), i);
            if (iA > 0) {
                this.tvShakeTitleView.setText(iA);
                return;
            } else {
                this.tvShakeTitleView.setText((i == 1 || i == 4) ? "摇动或点击下载应用" : "摇动或点击查看详情");
                return;
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.tvShakeTitleView.setText(this.g);
            return;
        }
        int iA2 = c0.a(getContext(), i);
        if (iA2 > 0) {
            str = "";
        } else if (i == 1 || i == 4) {
            str = "摇动或点击下载应用";
        }
        if (iA2 > 0) {
            this.tvShakeTitleView.setText(iA2);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.tvShakeTitleView.setText(str);
        }
    }

    public SplashShakeTextHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SplashShakeTextHintView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
