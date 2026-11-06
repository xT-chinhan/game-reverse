package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.support.constraint.ConstraintSet;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class h9 implements e9 {
    public final q6 a;
    public final int b;

    public h9(q6 q6Var, int i) {
        this.a = q6Var;
        this.b = i;
    }

    @Override // com.mcto.sspsdk.internal.e9
    public final void a(ConstraintSet constraintSet, Configuration configuration, q6 q6Var) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        boolean z = configuration.orientation == 2;
        q6 q6Var2 = this.a;
        q6Var2.i = true;
        if (!z) {
            Context context = q6Var2.getContext();
            this.a.i = false;
            constraintSet.clone(q6Var);
            constraintSet.setVisibility(R.id.qy_full_screen_app_icon, 8);
            constraintSet.setVisibility(R.id.qy_full_screen_app_name, 8);
            constraintSet.setVisibility(R.id.qy_full_screen_background, 8);
            float fMin = Math.min((context.getResources().getDisplayMetrics().widthPixels * 0.872f) / this.a.k, hk.b(context) * 0.7f);
            int iRound = Math.round(this.a.k * fMin);
            int iRound2 = Math.round(fMin);
            constraintSet.clear(R.id.qy_full_screen_main_creative);
            constraintSet.constrainWidth(R.id.qy_full_screen_main_creative, iRound);
            constraintSet.constrainHeight(R.id.qy_full_screen_main_creative, iRound2);
            constraintSet.connect(R.id.qy_full_screen_main_creative, 1, 0, 1);
            constraintSet.connect(R.id.qy_full_screen_main_creative, 2, 0, 2);
            constraintSet.connect(R.id.qy_full_screen_main_creative, 3, 0, 3);
            constraintSet.connect(R.id.qy_full_screen_main_creative, 4, R.id.qy_full_screen_ad_button, 3, (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f));
            constraintSet.setVerticalChainStyle(R.id.qy_full_screen_main_creative, 2);
            hk.a(this.a.l, this.b);
            q6 q6Var3 = this.a;
            TextView textView = q6Var3.o;
            if (q6Var3.j) {
                constraintSet.setVisibility(R.id.qy_full_screen_ad_title, 4);
            } else {
                constraintSet.clear(R.id.qy_full_screen_ad_title);
                if (this.a.n == null) {
                    textView.setBackgroundResource(R.drawable.qy_gradient_black_100_to_0_bg);
                    constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, (int) ((context.getResources().getDisplayMetrics().density * 60.0f) + 0.5f));
                } else {
                    constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, -2);
                    textView.setBackgroundColor(0);
                }
                constraintSet.constrainWidth(R.id.qy_full_screen_ad_title, 0);
                constraintSet.connect(R.id.qy_full_screen_ad_title, 1, R.id.qy_full_screen_main_creative, 1);
                constraintSet.connect(R.id.qy_full_screen_ad_title, 2, R.id.qy_full_screen_main_creative, 2);
                constraintSet.connect(R.id.qy_full_screen_ad_title, 4, R.id.qy_full_screen_main_creative, 4);
                textView.setPadding((int) ((context.getResources().getDisplayMetrics().density * 7.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 40.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 7.0f) + 0.5f));
                textView.setMaxLines(1);
                textView.setGravity(80);
                textView.setTextSize(1, 15.0f);
                textView.setTextColor(-1);
                hk.a(textView, this.b);
            }
            constraintSet.clear(R.id.qy_full_screen_ad_button, 1);
            constraintSet.constrainWidth(R.id.qy_full_screen_ad_button, iRound);
            constraintSet.constrainHeight(R.id.qy_full_screen_ad_button, (int) ((context.getResources().getDisplayMetrics().density * 36.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_ad_button, 3, R.id.qy_full_screen_main_creative, 4, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_button, 1, 0, 1, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_button, 2, 0, 2, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_button, 4, 0, 4, 0);
            constraintSet.setVerticalChainStyle(R.id.qy_full_screen_ad_button, 2);
            q6 q6Var4 = this.a;
            e eVar = q6Var4.g;
            int iA = hk.a(q6Var4.getContext(), 12.0f);
            boolean z2 = eVar == null || eVar.g == 2;
            constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 3, R.id.qy_full_screen_main_creative, 3, iA);
            if (z2) {
                constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 2, R.id.qy_full_screen_main_creative, 2, iA);
            } else {
                constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 1, R.id.qy_full_screen_main_creative, 1, iA);
            }
            constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 3, R.id.qy_full_screen_ad_close_icon, 3, 0);
            if (z2) {
                constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 1, R.id.qy_full_screen_main_creative, 1, iA);
            } else {
                constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 2, R.id.qy_full_screen_main_creative, 2, iA);
            }
            constraintSet.connect(R.id.qy_full_screen_ad_badge, 4, 0, 4, (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
            constraintSet.connect(R.id.qy_full_screen_ad_badge, 1, 0, 1, (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
            constraintSet.connect(R.id.qy_card_app_developer_info, 1, 0, 1, 0);
            constraintSet.connect(R.id.qy_card_app_developer_info, 2, 0, 2, 0);
            constraintSet.connect(R.id.qy_card_app_developer_info, 4, 0, 4, (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
            hi hiVar = this.a.n;
            if (hiVar != null) {
                constraintSet.clear(R.id.qy_full_screen_action);
                constraintSet.constrainHeight(R.id.qy_full_screen_action, iRound2 / 2);
                constraintSet.connect(R.id.qy_full_screen_action, 1, R.id.qy_full_screen_main_creative, 1, 0);
                constraintSet.connect(R.id.qy_full_screen_action, 2, R.id.qy_full_screen_main_creative, 2, 0);
                constraintSet.connect(R.id.qy_full_screen_action, 4, R.id.qy_full_screen_main_creative, 4, 0);
                hk.a(hiVar, this.b);
                hiVar.setPadding(0, iRound2 / 7, 0, 0);
                TextView textView2 = hiVar.c;
                if (textView2 != null) {
                    textView2.setTextSize(1, 12.0f);
                }
                TextView textView3 = hiVar.b;
                if (textView3 != null) {
                    textView3.setTextSize(1, 16.0f);
                }
                int i = (int) ((context.getResources().getDisplayMetrics().density * 80.0f) + 0.5f);
                int i2 = (int) ((context.getResources().getDisplayMetrics().density * 80.0f) + 0.5f);
                View view = hiVar.d;
                if (view != null && (layoutParams = view.getLayoutParams()) != null) {
                    layoutParams.width = i;
                    layoutParams.height = i2;
                    hiVar.d.setLayoutParams(layoutParams);
                    hiVar.requestLayout();
                }
            }
            constraintSet.applyTo(q6Var);
            return;
        }
        Context context2 = q6Var2.getContext();
        constraintSet.clone(q6Var);
        constraintSet.setVisibility(R.id.qy_full_screen_app_icon, 0);
        constraintSet.setVisibility(R.id.qy_full_screen_app_name, 0);
        constraintSet.setVisibility(R.id.qy_full_screen_background, 0);
        int iA2 = hk.a(context2, 335.5f);
        int i3 = (int) ((context2.getResources().getDisplayMetrics().density * 285.0f) + 0.5f);
        constraintSet.clear(R.id.qy_full_screen_background);
        constraintSet.constrainWidth(R.id.qy_full_screen_background, iA2);
        constraintSet.constrainHeight(R.id.qy_full_screen_background, i3);
        constraintSet.connect(R.id.qy_full_screen_background, 1, 0, 1);
        constraintSet.connect(R.id.qy_full_screen_background, 2, 0, 2);
        constraintSet.connect(R.id.qy_full_screen_background, 3, 0, 3);
        constraintSet.connect(R.id.qy_full_screen_background, 4, 0, 4);
        hk.a(this.a.p, this.b);
        constraintSet.clear(R.id.qy_full_screen_main_creative);
        constraintSet.constrainWidth(R.id.qy_full_screen_main_creative, (int) (i3 * this.a.k));
        constraintSet.constrainHeight(R.id.qy_full_screen_main_creative, i3);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 1, R.id.qy_full_screen_background, 1);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 4, R.id.qy_full_screen_background, 4);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 3, R.id.qy_full_screen_background, 3);
        hk.a(this.a.l, this.b, 2);
        constraintSet.clear(R.id.qy_full_screen_app_icon);
        constraintSet.constrainWidth(R.id.qy_full_screen_app_icon, (int) ((context2.getResources().getDisplayMetrics().density * 50.0f) + 0.5f));
        constraintSet.constrainHeight(R.id.qy_full_screen_app_icon, (int) ((context2.getResources().getDisplayMetrics().density * 50.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_app_icon, 1, R.id.qy_full_screen_ad_button, 1);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 2, R.id.qy_full_screen_ad_button, 2);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 3, R.id.qy_full_screen_main_creative, 3);
        constraintSet.connect(R.id.qy_full_screen_app_icon, 4, R.id.qy_full_screen_app_name, 3);
        constraintSet.setVerticalChainStyle(R.id.qy_full_screen_app_icon, 2);
        constraintSet.clear(R.id.qy_full_screen_app_name);
        constraintSet.constrainWidth(R.id.qy_full_screen_app_name, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_app_name, -2);
        constraintSet.connect(R.id.qy_full_screen_app_name, 1, R.id.qy_full_screen_ad_button, 1);
        constraintSet.connect(R.id.qy_full_screen_app_name, 2, R.id.qy_full_screen_ad_button, 2);
        constraintSet.connect(R.id.qy_full_screen_app_name, 3, R.id.qy_full_screen_app_icon, 4, (int) ((context2.getResources().getDisplayMetrics().density * 7.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_app_name, 4, R.id.qy_full_screen_ad_title, 3, (int) ((context2.getResources().getDisplayMetrics().density * 7.0f) + 0.5f));
        constraintSet.setVerticalChainStyle(R.id.qy_full_screen_app_name, 2);
        TextView textView4 = this.a.o;
        constraintSet.clear(R.id.qy_full_screen_ad_title);
        constraintSet.constrainWidth(R.id.qy_full_screen_ad_title, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, -2);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 1, R.id.qy_full_screen_ad_button, 1);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 2, R.id.qy_full_screen_ad_button, 2);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 4, R.id.qy_full_screen_ad_button, 3);
        constraintSet.connect(R.id.qy_full_screen_ad_title, 3, R.id.qy_full_screen_app_name, 4);
        constraintSet.setVerticalChainStyle(R.id.qy_full_screen_ad_title, 2);
        textView4.setBackgroundColor(0);
        textView4.setMaxLines(2);
        textView4.setGravity(17);
        textView4.setPadding(0, 0, 0, 0);
        textView4.setTextSize(1, 12.0f);
        textView4.setVisibility(0);
        textView4.setTextColor(ContextCompat.getColor(context2, R.color.qy_text_color_black_65alpha));
        constraintSet.clear(R.id.qy_full_screen_ad_button);
        constraintSet.constrainWidth(R.id.qy_full_screen_ad_button, 0);
        constraintSet.constrainHeight(R.id.qy_full_screen_ad_button, (int) ((context2.getResources().getDisplayMetrics().density * 36.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 1, R.id.qy_full_screen_main_creative, 2, (int) ((context2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 2, R.id.qy_full_screen_background, 2, (int) ((context2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 4, R.id.qy_full_screen_background, 4, (int) (((double) i3) * 0.18d));
        e eVar2 = this.a.g;
        int i4 = (int) ((context2.getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
        int i5 = eVar2 == null ? 1 : eVar2.h;
        int i6 = eVar2 == null ? 2 : eVar2.g;
        int i7 = i5 == 2 ? R.id.qy_full_screen_main_creative : R.id.qy_full_screen_background;
        boolean z3 = i6 == 2;
        constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 3, i7, 3, i4);
        if (z3) {
            constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 2, i7, 2, i4);
        } else {
            constraintSet.connect(R.id.qy_full_screen_ad_close_icon, 1, i7, 1, i4);
        }
        constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 3, R.id.qy_full_screen_ad_close_icon, 3, 0);
        if (z3) {
            constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 1, R.id.qy_full_screen_background, 1, i4);
        } else {
            constraintSet.connect(R.id.qy_full_screen_ad_video_volume, 2, R.id.qy_full_screen_background, 2, i4);
        }
        constraintSet.connect(R.id.qy_card_app_developer_info, 1, 0, 1, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        constraintSet.connect(R.id.qy_card_app_developer_info, 2, 0, 2, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        constraintSet.connect(R.id.qy_card_app_developer_info, 4, 0, 4, (int) ((context2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_badge, 4, 0, 4, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        constraintSet.connect(R.id.qy_full_screen_ad_badge, 1, 0, 1, (int) ((context2.getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        hi hiVar2 = this.a.n;
        if (hiVar2 != null) {
            constraintSet.clear(R.id.qy_full_screen_action);
            constraintSet.constrainHeight(R.id.qy_full_screen_action, i3 / 2);
            constraintSet.constrainWidth(R.id.qy_full_screen_action, 0);
            constraintSet.connect(R.id.qy_full_screen_action, 1, R.id.qy_full_screen_main_creative, 1, 0);
            constraintSet.connect(R.id.qy_full_screen_action, 2, R.id.qy_full_screen_main_creative, 2, 0);
            constraintSet.connect(R.id.qy_full_screen_action, 4, R.id.qy_full_screen_main_creative, 4, 0);
            hk.a(hiVar2, this.b, 2);
            hiVar2.setPadding(0, i3 / 8, 0, 0);
            TextView textView5 = hiVar2.c;
            if (textView5 != null) {
                textView5.setTextSize(1, 10.0f);
            }
            TextView textView6 = hiVar2.b;
            if (textView6 != null) {
                textView6.setTextSize(1, 12.0f);
            }
            int i8 = (int) ((context2.getResources().getDisplayMetrics().density * 39.0f) + 0.5f);
            int i9 = (int) ((context2.getResources().getDisplayMetrics().density * 39.0f) + 0.5f);
            View view2 = hiVar2.d;
            if (view2 != null && (layoutParams2 = view2.getLayoutParams()) != null) {
                layoutParams2.width = i8;
                layoutParams2.height = i9;
                hiVar2.d.setLayoutParams(layoutParams2);
                hiVar2.requestLayout();
            }
        }
        constraintSet.applyTo(q6Var);
    }
}
