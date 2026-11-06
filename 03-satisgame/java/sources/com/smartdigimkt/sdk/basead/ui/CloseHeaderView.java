package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class CloseHeaderView extends RelativeLayout {
    public ViewGroup a;
    public CloseImageView b;
    public TextView c;
    public String d;
    public String e;
    public long f;

    public CloseHeaderView(Context context) {
        super(context);
        this.d = "";
        this.e = "";
        a();
    }

    public final void a() {
        setBackgroundColor(Color.parseColor("#000000"));
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_close_header_view", "layout"), this);
        this.a = (ViewGroup) findViewById(k.a(getContext(), "myoffer_feedback_ll_nobg_id", "id"));
        this.b = (CloseImageView) findViewById(k.a(getContext(), "myoffer_btn_close_ch_id", "id"));
        this.c = (TextView) findViewById(k.a(getContext(), "myoffer_tv_countdown_text", "id"));
        this.d = getContext().getString(k.a(getContext(), "myoffer_count_down_to_rewarded", "string"));
        this.e = getContext().getString(k.a(getContext(), "myoffer_count_down_finish_rewarded", "string"));
    }

    public CloseImageView getCloseImageView() {
        return this.b;
    }

    public ViewGroup getFeedbackButton() {
        return this.a;
    }

    public void refresh(long j) {
        long j2 = this.f;
        if (j >= j2) {
            this.c.setText(this.e);
            this.c.setTextColor(-1);
        } else {
            this.c.setText(Html.fromHtml(String.format(this.d, Integer.valueOf((int) Math.ceil((j2 - j) / 1000.0d)))));
        }
    }

    public void setDuration(long j) {
        this.f = j;
    }

    public CloseHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "";
        this.e = "";
        a();
    }

    public CloseHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = "";
        this.e = "";
        a();
    }
}
