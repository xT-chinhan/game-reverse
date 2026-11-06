package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.b.e;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class ShakeBorderThumbView extends BaseShakeView {
    TextView l;

    public ShakeBorderThumbView(Context context) {
        super(context);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    void a() {
        setOrientation(0);
        setGravity(17);
        setClipToPadding(false);
        setBackgroundResource(q.a(t.b().g(), "myoffer_bg_shake_border_thumb", "drawable"));
        LayoutInflater.from(getContext()).inflate(d(), (ViewGroup) this, true);
        int iA = q.a(getContext(), 10.0f);
        int iA2 = q.a(getContext(), 10.0f);
        int iA3 = q.a(getContext(), 6.0f);
        setPadding(iA, iA3, iA2, iA3);
        this.a = (ImageView) findViewById(q.a(t.b().g(), "myoffer_splash_shake_border_img", "id"));
        this.l = (TextView) findViewById(q.a(t.b().g(), "myoffer_splash_shake_hint_text", "id"));
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public void setShakeSetting(y yVar, int i) {
        super.setShakeSetting(yVar, i);
        if (this.l != null) {
            if (!TextUtils.isEmpty(this.h)) {
                this.l.setText(this.h);
            } else {
                this.l.setText(e.a(getContext(), i));
            }
        }
    }

    protected int d() {
        return q.a(getContext(), "myoffer_shake_border_thumb", "layout");
    }
}
