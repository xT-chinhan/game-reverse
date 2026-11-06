package com.smartdigimkt.c1;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ g a;

    public a(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            String string = textView.getTag().toString();
            g gVar = this.a;
            if (TextUtils.isEmpty(gVar.q)) {
                gVar.q = string;
                gVar.r = textView;
                textView.setTextColor(Color.parseColor("#2265FF"));
                gVar.r.setBackgroundResource(k.a(textView.getContext(), "myoffer_bg_feedback_textview_pressed", "drawable"));
            } else if (TextUtils.equals(gVar.q, string)) {
                TextView textView2 = gVar.r;
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor("#84879D"));
                    gVar.r.setBackgroundResource(k.a(textView.getContext(), "myoffer_bg_feedback_textview", "drawable"));
                }
                gVar.q = "";
                gVar.r = null;
            } else {
                TextView textView3 = gVar.r;
                if (textView3 != null) {
                    textView3.setTextColor(Color.parseColor("#84879D"));
                    gVar.r.setBackgroundResource(k.a(textView.getContext(), "myoffer_bg_feedback_textview", "drawable"));
                }
                gVar.q = string;
                gVar.r = textView;
                textView.setTextColor(Color.parseColor("#2265FF"));
                gVar.r.setBackgroundResource(k.a(textView.getContext(), "myoffer_bg_feedback_textview_pressed", "drawable"));
            }
            if (TextUtils.isEmpty(gVar.q) && TextUtils.isEmpty(gVar.e.getText().toString())) {
                gVar.g.setEnabled(false);
            } else {
                gVar.g.setEnabled(true);
            }
        }
    }
}
