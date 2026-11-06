package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class BaseShakeTextHintView extends BaseShakeView {
    public TextView tvShakeTitleView;

    public BaseShakeTextHintView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void a() {
        setOrientation(0);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        int iA = k.a(getContext(), 4.0f);
        setPadding(iA, iA, iA, iA);
        int iA2 = k.a(SDKContext.getInstance().d(), "myoffer_shake_text_hint_img", "id");
        int iA3 = k.a(SDKContext.getInstance().d(), "myoffer_shake_text_hint_title", "id");
        this.a = (ImageView) findViewById(iA2);
        this.tvShakeTitleView = (TextView) findViewById(iA3);
    }

    public int getLayoutId() {
        return k.a(getContext(), "myoffer_shake_text_hint", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setShakeSetting(e eVar, int i) {
        super.setShakeSetting(eVar, i);
        if (this.tvShakeTitleView != null) {
            if (TextUtils.isEmpty(this.g)) {
                this.tvShakeTitleView.setText(c0.a(getContext(), i));
            } else {
                this.tvShakeTitleView.setText(this.g);
            }
        }
    }

    public BaseShakeTextHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseShakeTextHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BaseShakeTextHintView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
