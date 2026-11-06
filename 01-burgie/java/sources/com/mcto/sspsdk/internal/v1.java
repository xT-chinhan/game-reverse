package com.mcto.sspsdk.internal;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;
import com.mcto.sspsdk.QyBannerStyle;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.interaction.QySharkView;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 implements Runnable {
    public final /* synthetic */ w1 a;

    public v1(w1 w1Var) {
        this.a = w1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y2 y2Var = this.a.b.b;
        if (y2Var == null || y2Var.F) {
            return;
        }
        int i = y2Var.v.w0;
        e eVar = y2Var.E;
        if (eVar != null && eVar.q == 1) {
            i = 4;
        }
        if (QyBannerStyle.QYBANNER_FULL_DETAIL_PAGE.equals(y2Var.l) || QyBannerStyle.QYBANNER_STRIP.equals(y2Var.l) || QyBannerStyle.QYBANNER_TITLEBUTTON.equals(y2Var.l)) {
            return;
        }
        if (i == 4 || i == 7) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            y2Var.j = new TextView(y2Var.getContext());
            if (i == 4) {
                QySharkView qySharkView = new QySharkView(y2Var.getContext());
                qySharkView.setImageResource(R.drawable.qy_lg_shark);
                qySharkView.c();
                e eVar2 = y2Var.E;
                boolean z = eVar2 != null && eVar2.q == 1;
                if (z) {
                    qySharkView.a(eVar2.l, eVar2.m, eVar2.n);
                }
                qySharkView.a();
                qySharkView.a(new x2(y2Var, y2Var, z));
                y2Var.i = qySharkView;
                layoutParams.width = hk.a(y2Var.getContext(), 80.0f);
                layoutParams.height = hk.a(y2Var.getContext(), 80.0f);
                layoutParams.dimensionRatio = "1:1";
                y2Var.postDelayed(new t2(y2Var), 2000L);
                y2Var.j.setText("摇一摇 " + y2Var.C);
            } else {
                layoutParams.width = hk.a(y2Var.getContext(), 250.0f);
                layoutParams.height = hk.a(y2Var.getContext(), 85.0f);
                ge geVar = new ge(y2Var.getContext());
                geVar.d = true;
                y2Var.i = geVar;
                y2Var.postDelayed(new u2(y2Var), 5000L);
                y2Var.j.setText("滑动屏幕 " + y2Var.C);
            }
            View view = y2Var.i;
            if (view == null) {
                return;
            }
            view.setId(R.id.qy_banner_action_icon);
            int i2 = R.id.qy_banner_core;
            layoutParams.rightToRight = i2;
            layoutParams.leftToLeft = i2;
            layoutParams.topToTop = i2;
            layoutParams.bottomToTop = R.id.qy_banner_action_title;
            layoutParams.verticalChainStyle = 2;
            y2Var.addView(y2Var.i, layoutParams);
            y2Var.j.setId(R.id.qy_banner_action_title);
            y2Var.j.setSingleLine();
            y2Var.j.setTextColor(-1);
            y2Var.j.getPaint().setFakeBoldText(true);
            y2Var.j.setShadowLayer(3.0f, 0.0f, 0.0f, y2Var.getResources().getColor(R.color.qy_btn_color_red));
            y2Var.j.setTextSize(1, 15.0f);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
            int i3 = R.id.qy_banner_core;
            layoutParams2.rightToRight = i3;
            layoutParams2.leftToLeft = i3;
            layoutParams2.topToBottom = R.id.qy_banner_action_icon;
            layoutParams2.bottomToBottom = i3;
            layoutParams2.setMargins(0, hk.a(y2Var.getContext(), 7.0f), 0, 0);
            y2Var.addView(y2Var.j, layoutParams2);
        }
    }
}
