package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class k8 extends u8 {
    public k8(ve veVar, p pVar, long j, a aVar, re reVar) {
        super(veVar, pVar, j, aVar, reVar);
    }

    @Override // com.mcto.sspsdk.internal.s8, com.mcto.sspsdk.internal.j7
    public final void a() {
        zg.a.a(new j8(this));
    }

    @Override // com.mcto.sspsdk.internal.s8, com.mcto.sspsdk.internal.j7
    public final void f() {
        a(this.a.getContext(), this.d);
    }

    @Override // com.mcto.sspsdk.internal.u8, com.mcto.sspsdk.internal.s8
    public final void a(p pVar) {
        String str = this.c.g;
        if (TextUtils.isEmpty(str)) {
            str = "https://pic1.iqiyipic.com/lequ/20241216/gift_box.png";
        }
        Context context = this.a.getContext();
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        this.d = constraintLayout;
        constraintLayout.setId(R.id.qy_reward_interactive_container);
        this.d.setBackgroundResource(R.color.qy_dialog_bg);
        this.d.setOnClickListener(this);
        QYNiceImageView qYNiceImageView = new QYNiceImageView(context);
        qYNiceImageView.a(this.u);
        qYNiceImageView.a(str);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        qYNiceImageView.setScaleType(scaleType);
        qYNiceImageView.setId(R.id.qy_reward_interactive_background);
        qYNiceImageView.setOnClickListener(this);
        this.d.addView(qYNiceImageView);
        TextView textView = new TextView(context);
        this.e = textView;
        textView.setId(R.id.qy_reward_interactive_title);
        this.e.setTextSize(1, 16.0f);
        this.e.setTextColor(-1);
        this.e.setText(sg.a(this.c.i, "%nrt", (this.m / 1000) + "秒"));
        h6.a(context, this.e, this.c.p);
        this.d.addView(this.e);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.qy_ic_close);
        imageView.setScaleType(scaleType);
        imageView.setId(R.id.qy_reward_interactive_close);
        imageView.setOnClickListener(this);
        this.d.addView(imageView);
        a(context, this.d);
    }

    public static void a(Context context, ConstraintLayout constraintLayout) {
        boolean z = context.getResources().getConfiguration().orientation == 2;
        ConstraintSet constraintSet = new ConstraintSet();
        int i = (int) ((context.getResources().getDisplayMetrics().density * 280.0f) + 0.5f);
        constraintSet.constrainWidth(R.id.qy_reward_interactive_background, i);
        constraintSet.constrainHeight(R.id.qy_reward_interactive_background, i);
        constraintSet.connect(R.id.qy_reward_interactive_background, 1, 0, 1);
        constraintSet.connect(R.id.qy_reward_interactive_background, 2, 0, 2);
        constraintSet.connect(R.id.qy_reward_interactive_background, 3, 0, 3);
        if (!z) {
            constraintSet.setMargin(R.id.qy_reward_interactive_background, 3, (int) ((context.getResources().getDisplayMetrics().density * 215.0f) + 0.5f));
        } else {
            constraintSet.connect(R.id.qy_reward_interactive_background, 4, R.id.qy_reward_interactive_title, 3);
            constraintSet.setVerticalChainStyle(R.id.qy_reward_interactive_background, 2);
        }
        constraintSet.constrainWidth(R.id.qy_reward_interactive_title, -2);
        constraintSet.constrainHeight(R.id.qy_reward_interactive_title, -2);
        constraintSet.connect(R.id.qy_reward_interactive_title, 1, R.id.qy_reward_interactive_background, 1);
        constraintSet.connect(R.id.qy_reward_interactive_title, 2, R.id.qy_reward_interactive_background, 2);
        constraintSet.connect(R.id.qy_reward_interactive_title, 3, R.id.qy_reward_interactive_background, 4);
        constraintSet.setMargin(R.id.qy_reward_interactive_title, 3, (int) ((context.getResources().getDisplayMetrics().density * 25.0f) + 0.5f));
        if (z) {
            constraintSet.connect(R.id.qy_reward_interactive_title, 4, 0, 4);
            constraintSet.setVerticalChainStyle(R.id.qy_reward_interactive_title, 2);
        }
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f);
        constraintSet.constrainWidth(R.id.qy_reward_interactive_close, i2);
        constraintSet.constrainHeight(R.id.qy_reward_interactive_close, i2);
        if (z && !hk.d(context)) {
            constraintSet.connect(R.id.qy_reward_interactive_close, 1, R.id.qy_reward_interactive_background, 2);
            constraintSet.connect(R.id.qy_reward_interactive_close, 3, R.id.qy_reward_interactive_background, 3);
            constraintSet.setMargin(R.id.qy_reward_interactive_close, 3, (int) ((context.getResources().getDisplayMetrics().density * 42.0f) + 0.5f));
            constraintSet.setMargin(R.id.qy_reward_interactive_close, 1, (int) ((context.getResources().getDisplayMetrics().density * 16.0f) + 0.5f));
        } else {
            constraintSet.connect(R.id.qy_reward_interactive_close, 3, R.id.qy_reward_interactive_title, 4);
            constraintSet.connect(R.id.qy_reward_interactive_close, 1, 0, 1);
            constraintSet.connect(R.id.qy_reward_interactive_close, 2, 0, 2);
            constraintSet.setMargin(R.id.qy_reward_interactive_close, 3, (int) ((context.getResources().getDisplayMetrics().density * 42.0f) + 0.5f));
        }
        constraintSet.applyTo(constraintLayout);
    }
}
