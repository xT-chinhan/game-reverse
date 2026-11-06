package com.bytedance.sdk.openadsdk.res.layout.ms;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.openadsdk.res.layout.ms {
    @Override // com.bytedance.sdk.openadsdk.res.layout.ms
    public View xr(Context context) {
        Button button = new Button(context);
        button.setId(2114387735);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, ul.ah(context, 48.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        button.setBackground(gradientDrawable);
        button.setText(t.ms(context, "tt_download"));
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setTextSize(2, 16.0f);
        return button;
    }
}
