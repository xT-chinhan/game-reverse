package com.mcto.sspsdk.internal;

import android.content.res.Configuration;
import android.support.constraint.ConstraintSet;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class g9 implements e9 {
    public static final int c = R.drawable.qy_gradient_black_100_to_0_bg;
    public final q6 a;
    public final int b;

    public g9(q6 q6Var, int i) {
        this.a = q6Var;
        this.b = i;
    }

    @Override // com.mcto.sspsdk.internal.e9
    public final void a(ConstraintSet constraintSet, Configuration configuration, q6 q6Var) {
        boolean z = configuration.orientation == 2;
        this.a.i = false;
        constraintSet.clone(q6Var);
        constraintSet.setVisibility(R.id.qy_full_screen_app_icon, 8);
        constraintSet.setVisibility(R.id.qy_full_screen_app_name, 8);
        constraintSet.setVisibility(R.id.qy_full_screen_background, 8);
        float fMin = Math.min((this.a.getContext().getResources().getDisplayMetrics().widthPixels * 0.872f) / this.a.k, hk.b(this.a.getContext()) * (z ? 0.6f : 0.7f));
        int iRound = Math.round(this.a.k * fMin);
        int iRound2 = Math.round(fMin);
        constraintSet.clear(R.id.qy_full_screen_main_creative);
        constraintSet.constrainWidth(R.id.qy_full_screen_main_creative, iRound);
        constraintSet.constrainHeight(R.id.qy_full_screen_main_creative, iRound2);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 1, 0, 1);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 2, 0, 2);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 3, 0, 3);
        constraintSet.connect(R.id.qy_full_screen_main_creative, 4, R.id.qy_full_screen_ad_button, 3, hk.a(this.a.getContext(), 12.0f));
        constraintSet.setVerticalChainStyle(R.id.qy_full_screen_main_creative, 2);
        hk.a(this.a.l, this.b);
        q6 q6Var2 = this.a;
        e eVar = q6Var2.g;
        int iA = hk.a(q6Var2.getContext(), 12.0f);
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
        q6 q6Var3 = this.a;
        TextView textView = q6Var3.o;
        if (q6Var3.j) {
            constraintSet.setVisibility(R.id.qy_full_screen_ad_title, 4);
        } else {
            constraintSet.clear(R.id.qy_full_screen_ad_title);
            if (this.a.n == null) {
                textView.setBackgroundResource(c);
                constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, hk.a(this.a.getContext(), 60.0f));
            } else {
                constraintSet.constrainHeight(R.id.qy_full_screen_ad_title, -2);
                textView.setBackgroundColor(0);
            }
            constraintSet.constrainWidth(R.id.qy_full_screen_ad_title, 0);
            constraintSet.connect(R.id.qy_full_screen_ad_title, 1, R.id.qy_full_screen_main_creative, 1);
            constraintSet.connect(R.id.qy_full_screen_ad_title, 2, R.id.qy_full_screen_main_creative, 2);
            constraintSet.connect(R.id.qy_full_screen_ad_title, 4, R.id.qy_full_screen_main_creative, 4);
            textView.setPadding(hk.a(this.a.getContext(), 7.0f), hk.a(this.a.getContext(), 12.0f), hk.a(this.a.getContext(), 40.0f), hk.a(this.a.getContext(), 7.0f));
            textView.setMaxLines(1);
            textView.setGravity(80);
            textView.setTextSize(1, 15.0f);
            textView.setTextColor(-1);
            hk.a(textView, this.b);
        }
        constraintSet.clear(R.id.qy_full_screen_ad_button, 1);
        constraintSet.constrainWidth(R.id.qy_full_screen_ad_button, iRound);
        constraintSet.constrainHeight(R.id.qy_full_screen_ad_button, hk.a(this.a.getContext(), 36.0f));
        constraintSet.connect(R.id.qy_full_screen_ad_button, 3, R.id.qy_full_screen_main_creative, 4, 0);
        constraintSet.connect(R.id.qy_full_screen_ad_button, 1, 0, 1, 0);
        constraintSet.connect(R.id.qy_full_screen_ad_button, 2, 0, 2, 0);
        constraintSet.connect(R.id.qy_full_screen_ad_button, 4, 0, 4, 0);
        constraintSet.setVerticalChainStyle(R.id.qy_full_screen_ad_button, 2);
        constraintSet.connect(R.id.qy_full_screen_ad_badge, 4, 0, 4, hk.a(this.a.getContext(), 4.0f));
        constraintSet.connect(R.id.qy_full_screen_ad_badge, 1, 0, 1, hk.a(this.a.getContext(), 4.0f));
        constraintSet.connect(R.id.qy_card_app_developer_info, 1, 0, 1, 0);
        constraintSet.connect(R.id.qy_card_app_developer_info, 2, 0, 2, 0);
        constraintSet.connect(R.id.qy_card_app_developer_info, 4, 0, 4, hk.a(this.a.getContext(), 20.0f));
        hi hiVar = this.a.n;
        if (hiVar != null) {
            constraintSet.clear(R.id.qy_full_screen_action);
            if (this.a.k < 1.0f) {
                constraintSet.constrainHeight(R.id.qy_full_screen_action, iRound2 / 2);
                constraintSet.connect(R.id.qy_full_screen_action, 1, R.id.qy_full_screen_main_creative, 1, 0);
                constraintSet.connect(R.id.qy_full_screen_action, 2, R.id.qy_full_screen_main_creative, 2, 0);
                constraintSet.connect(R.id.qy_full_screen_action, 4, R.id.qy_full_screen_main_creative, 4, 0);
            } else {
                this.a.m.a(true);
                constraintSet.clear(R.id.qy_full_screen_action);
                constraintSet.constrainWidth(R.id.qy_full_screen_action, 0);
                constraintSet.constrainHeight(R.id.qy_full_screen_action, 0);
                constraintSet.connect(R.id.qy_full_screen_action, 4, R.id.qy_full_screen_ad_button, 4);
                constraintSet.connect(R.id.qy_full_screen_action, 3, R.id.qy_full_screen_ad_button, 3);
                constraintSet.connect(R.id.qy_full_screen_action, 1, R.id.qy_full_screen_ad_button, 1);
                constraintSet.connect(R.id.qy_full_screen_action, 2, R.id.qy_full_screen_ad_button, 2);
            }
            hk.a(hiVar, this.b);
        }
        constraintSet.applyTo(q6Var);
    }
}
