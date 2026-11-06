package com.byazt.lv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1420, 19})
public class n implements com.byazt.lz.n {
    @Override // com.byazt.lz.n
    public View qg(Context context) {
        Button button = new Button(context);
        button.setId(2114387729);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, com.byazt.okk.s.s(context, 48.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        button.setBackground(gradientDrawable);
        button.setText("立即下载");
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setTextSize(2, 16.0f);
        return button;
    }
}
