package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.support.constraint.ConstraintSet;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class f9 implements e9 {
    public final q6 a;
    public final int b;

    public f9(q6 q6Var, int i) {
        this.a = q6Var;
        this.b = i;
    }

    @Override // com.mcto.sspsdk.internal.e9
    public final void a(ConstraintSet constraintSet, Configuration configuration, q6 q6Var) {
        boolean z = configuration.orientation == 2;
        q6 q6Var2 = this.a;
        q6Var2.i = true;
        if (!z) {
            constraintSet.setVisibility(R.id.qy_full_screen_gradient, 8);
            Context context = this.a.getContext();
            constraintSet.clone(q6Var);
            int iA = hk.a(context, 304.0f);
            int i = (int) ((context.getResources().getDisplayMetrics().density * 478.0f) + 0.5f);
            constraintSet.clear(R.id.qy_full_screen_background);
            constraintSet.constrainWidth(R.id.qy_full_screen_background, iA);
            constraintSet.constrainHeight(R.id.qy_full_screen_background, i);
            constraintSet.connect(R.id.qy_full_screen_background, 1, 0, 1);
            constraintSet.connect(R.id.qy_full_screen_background, 2, 0, 2);
            constraintSet.connect(R.id.qy_full_screen_background, 3, 0, 3);
            constraintSet.connect(R.id.qy_full_screen_background, 4, 0, 4);
            hk.a(this.a.p, this.b);
            constraintSet.clear(R.id.qy_full_screen_app_icon);
            constraintSet.constrainWidth(R.id.qy_full_screen_app_icon, (int) ((context.getResources().getDisplayMetrics().density * 58.0f) + 0.5f));
            constraintSet.constrainHeight(R.id.qy_full_screen_app_icon, (int) ((context.getResources().getDisplayMetrics().density * 58.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_app_icon, 1, R.id.qy_full_screen_background, 1, 0);
            constraintSet.connect(R.id.qy_full_screen_app_icon, 2, R.id.qy_full_screen_background, 2, 0);
            constraintSet.connect(R.id.qy_full_screen_app_icon, 3, R.id.qy_full_screen_background, 3, (int) (((double) i) * 0.15d));
            constraintSet.clear(R.id.qy_full_screen_app_name);
            constraintSet.constrainWidth(R.id.qy_full_screen_app_name, 0);
            constraintSet.constrainHeight(R.id.qy_full_screen_app_name, -2);
            constraintSet.connect(R.id.qy_full_screen_app_name, 1, R.id.qy_full_screen_ad_button, 1, 0);
            constraintSet.connect(R.id.qy_full_screen_app_name, 2, R.id.qy_full_screen_ad_button, 2, 0);
            constraintSet.connect(R.id.qy_full_screen_app_name, 3, R.id.qy_full_screen_app_icon, 4, (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f));
            TextView textView = this.a.o;
            textView.setVisibility(0);
            constraintSet.clear(R.id.qy_full_screen_ad_title);
            constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, -2);
            constraintSet.constrainWidth(R.id.qy_full_screen_ad_title, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_title, 1, R.id.qy_full_screen_ad_button, 1);
            constraintSet.connect(R.id.qy_full_screen_ad_title, 2, R.id.qy_full_screen_ad_button, 2);
            constraintSet.connect(R.id.qy_full_screen_ad_title, 3, R.id.qy_full_screen_app_name, 4, (int) ((context.getResources().getDisplayMetrics().density * 6.0f) + 0.5f));
            textView.setMaxLines(2);
            textView.setGravity(17);
            textView.setTextSize(1, 12.0f);
            constraintSet.clear(R.id.qy_full_screen_main_creative);
            constraintSet.constrainWidth(R.id.qy_full_screen_main_creative, iA);
            constraintSet.constrainHeight(R.id.qy_full_screen_main_creative, (int) (iA / this.a.k));
            constraintSet.connect(R.id.qy_full_screen_main_creative, 1, R.id.qy_full_screen_background, 1);
            constraintSet.connect(R.id.qy_full_screen_main_creative, 2, R.id.qy_full_screen_background, 2);
            constraintSet.connect(R.id.qy_full_screen_main_creative, 3, R.id.qy_full_screen_ad_title, 4, (int) ((context.getResources().getDisplayMetrics().density * 23.0f) + 0.5f));
            hk.a(this.a.l, 0.0f);
            constraintSet.clear(R.id.qy_full_screen_ad_button);
            constraintSet.constrainWidth(R.id.qy_full_screen_ad_button, 0);
            constraintSet.constrainHeight(R.id.qy_full_screen_ad_button, (int) ((context.getResources().getDisplayMetrics().density * 36.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_ad_button, 3, R.id.qy_full_screen_main_creative, 4, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_button, 1, R.id.qy_full_screen_background, 1, (int) ((context.getResources().getDisplayMetrics().density * 24.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_ad_button, 2, R.id.qy_full_screen_background, 2, (int) ((context.getResources().getDisplayMetrics().density * 24.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_ad_button, 4, R.id.qy_full_screen_background, 4, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_badge, 4, 0, 4, (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_ad_badge, 1, 0, 1, (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
            e eVar = this.a.g;
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
            int i3 = eVar == null ? 1 : eVar.h;
            int i4 = eVar == null ? 2 : eVar.g;
            if (i3 == 1) {
                boolean z2 = i4 == 2;
                constraintSet.clear(R.id.qy_full_screen_ad_close_icon, 2);
                constraintSet.clear(R.id.qy_full_screen_ad_close_icon, 1);
                constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 3, R.id.qy_full_screen_background, 3, i2);
                if (z2) {
                    constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 2, R.id.qy_full_screen_background, 2, i2);
                } else {
                    constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 1, R.id.qy_full_screen_background, 1, i2);
                }
                constraintSet.clear(R.id.qy_full_screen_ad_video_volume, 2);
                constraintSet.clear(R.id.qy_full_screen_ad_video_volume, 1);
                constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 3, R.id.qy_full_screen_ad_close_icon, 3, 0);
                if (z2) {
                    constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 1, R.id.qy_full_screen_background, 1, i2);
                } else {
                    constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 2, R.id.qy_full_screen_background, 2, i2);
                }
            } else {
                constraintSet.clear(R.id.qy_full_screen_ad_close_icon, 2);
                constraintSet.clear(R.id.qy_full_screen_ad_close_icon, 1);
                constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 3, R.id.qy_full_screen_main_creative, 3, i2);
                if (i4 == 1) {
                    constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 1, R.id.qy_full_screen_main_creative, 1, i2);
                } else {
                    constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 2, R.id.qy_full_screen_main_creative, 2, i2);
                }
                constraintSet.clear(R.id.qy_full_screen_ad_video_volume, 2);
                constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 3, R.id.qy_full_screen_background, 3, i2);
                constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 1, R.id.qy_full_screen_background, 1, i2);
            }
            constraintSet.connect(R.id.qy_card_app_developer_info, 1, 0, 1, 0);
            constraintSet.connect(R.id.qy_card_app_developer_info, 2, 0, 2, 0);
            constraintSet.connect(R.id.qy_card_app_developer_info, 4, 0, 4, (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
            q6 q6Var3 = this.a;
            if (q6Var3.n != null) {
                q6Var3.m.a(true);
                constraintSet.clear(R.id.qy_full_screen_action);
                constraintSet.constrainWidth(R.id.qy_full_screen_action, 0);
                constraintSet.constrainHeight(R.id.qy_full_screen_action, 0);
                constraintSet.connect(R.id.qy_full_screen_action, 4, R.id.qy_full_screen_ad_button, 4);
                constraintSet.connect(R.id.qy_full_screen_action, 3, R.id.qy_full_screen_ad_button, 3);
                constraintSet.connect(R.id.qy_full_screen_action, 1, R.id.qy_full_screen_ad_button, 1);
                constraintSet.connect(R.id.qy_full_screen_action, 2, R.id.qy_full_screen_ad_button, 2);
            }
            constraintSet.applyTo(q6Var);
            return;
        }
        Context context2 = q6Var2.getContext();
        constraintSet.clone(q6Var);
        constraintSet.setVisibility(R.id.qy_full_screen_app_icon, 0);
        constraintSet.setVisibility(R.id.qy_full_screen_app_name, 0);
        constraintSet.setVisibility(R.id.qy_full_screen_background, 0);
        int iA2 = hk.a(context2, 285.0f);
        constraintSet.clear(R.id.qy_full_screen_background);
        constraintSet.constrainWidth(R.id.qy_full_screen_background, iA2);
        constraintSet.constrainHeight(R.id.qy_full_screen_background, iA2);
        constraintSet.connect(R.id.qy_full_screen_background, 1, 0, 1);
        constraintSet.connect(R.id.qy_full_screen_background, 2, 0, 2);
        constraintSet.connect(R.id.qy_full_screen_background, 3, 0, 3);
        constraintSet.connect(R.id.qy_full_screen_background, 4, 0, 4);
        hk.a(this.a.p, this.b);
        constraintSet.clear(R.id.qy_full_screen_main_creative);
        constraintSet.constrainWidth(R.id.qy_full_screen_main_creative, iA2);
        float f = iA2;
        constraintSet.constrainHeight(R.id.qy_full_screen_main_creative, (int) (f / this.a.k));
        constraintSet.connect(R.id.qy_full_screen_main_creative, 1, R.id.qy_full_screen_background, 1);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 2, R.id.qy_full_screen_background, 2);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 3, R.id.qy_full_screen_background, 3);
        hk.a(this.a.l, this.b, 3);
        constraintSet.clear(R.id.qy_full_screen_gradient);
        constraintSet.setVisibility(R.id.qy_full_screen_gradient, 0);
        constraintSet.constrainWidth(R.id.qy_full_screen_gradient, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_gradient, (int) ((context2.getResources().getDisplayMetrics().density * 60.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_gradient, 1, R.id.qy_full_screen_main_creative, 1);
        constraintSet.connect(R.id.qy_full_screen_gradient, 2, R.id.qy_full_screen_main_creative, 2);
        constraintSet.connect(R.id.qy_full_screen_gradient, 4, R.id.qy_full_screen_main_creative, 4);
        constraintSet.clear(R.id.qy_full_screen_app_icon);
        int i5 = (int) (f * 0.2f);
        constraintSet.constrainWidth(R.id.qy_full_screen_app_icon, i5);
        constraintSet.constrainHeight(R.id.qy_full_screen_app_icon, i5);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 1, R.id.qy_full_screen_background, 1);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 2, R.id.qy_full_screen_background, 2);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 4, 0, 4);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 3, 0, 3);
        constraintSet.clear(R.id.qy_full_screen_app_name);
        constraintSet.constrainWidth(R.id.qy_full_screen_app_name, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_app_name, -2);
        constraintSet.connect(R.id.qy_full_screen_app_name, 1, R.id.qy_full_screen_ad_button, 1);
        constraintSet.connect(R.id.qy_full_screen_app_name, 2, R.id.qy_full_screen_ad_button, 2);
        constraintSet.connect(R.id.qy_full_screen_app_name, 3, R.id.qy_full_screen_app_icon, 4, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        TextView textView2 = this.a.o;
        constraintSet.clear(R.id.qy_full_screen_ad_title);
        constraintSet.constrainWidth(R.id.qy_full_screen_ad_title, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, -2);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 1, R.id.qy_full_screen_ad_button, 1);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 2, R.id.qy_full_screen_ad_button, 2);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 3, R.id.qy_full_screen_app_name, 4, (int) ((context2.getResources().getDisplayMetrics().density * 6.0f) + 0.5f));
        textView2.setBackgroundColor(0);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setPadding(0, 0, 0, 0);
        textView2.setTextSize(1, 12.0f);
        textView2.setVisibility(0);
        constraintSet.clear(R.id.qy_full_screen_ad_button);
        constraintSet.constrainWidth(R.id.qy_full_screen_ad_button, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_ad_button, (int) ((context2.getResources().getDisplayMetrics().density * 36.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 1, R.id.qy_full_screen_background, 1, (int) ((context2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 2, R.id.qy_full_screen_background, 2, (int) ((context2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 4, R.id.qy_full_screen_background, 4, (int) ((context2.getResources().getDisplayMetrics().density * 17.0f) + 0.5f));
        q6 q6Var4 = this.a;
        e eVar2 = q6Var4.g;
        int iA3 = hk.a(q6Var4.getContext(), 12.0f);
        boolean z3 = eVar2 == null || eVar2.g == 2;
        constraintSet.clear(R.id.qy_full_screen_ad_close_icon, 2);
        constraintSet.clear(R.id.qy_full_screen_ad_close_icon, 1);
        constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 3, R.id.qy_full_screen_main_creative, 3, iA3);
        if (z3) {
            constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 2, R.id.qy_full_screen_main_creative, 2, iA3);
        } else {
            constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 1, R.id.qy_full_screen_main_creative, 1, iA3);
        }
        constraintSet.clear(R.id.qy_full_screen_ad_video_volume, 2);
        constraintSet.clear(R.id.qy_full_screen_ad_video_volume, 1);
        constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 3, R.id.qy_full_screen_ad_close_icon, 3, 0);
        if (z3) {
            constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 1, R.id.qy_full_screen_main_creative, 1, iA3);
        } else {
            constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 2, R.id.qy_full_screen_main_creative, 2, iA3);
        }
        constraintSet.connect(R.id.qy_card_app_developer_info, 1, 0, 1, 0);
        constraintSet.connect(R.id.qy_card_app_developer_info, 2, 0, 2, 0);
        constraintSet.connect(R.id.qy_card_app_developer_info, 4, 0, 4, (int) ((context2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_badge, 4, 0, 4, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_badge, 1, 0, 1, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        q6 q6Var5 = this.a;
        if (q6Var5.n != null) {
            q6Var5.m.a(true);
            constraintSet.clear(R.id.qy_full_screen_action);
            constraintSet.constrainWidth(R.id.qy_full_screen_action, 0);
            constraintSet.constrainHeight(R.id.qy_full_screen_action, 0);
            constraintSet.connect(R.id.qy_full_screen_action, 4, R.id.qy_full_screen_ad_button, 4);
            constraintSet.connect(R.id.qy_full_screen_action, 3, R.id.qy_full_screen_ad_button, 3);
            constraintSet.connect(R.id.qy_full_screen_action, 1, R.id.qy_full_screen_ad_button, 1);
            constraintSet.connect(R.id.qy_full_screen_action, 2, R.id.qy_full_screen_ad_button, 2);
        }
        constraintSet.applyTo(q6Var);
    }
}
