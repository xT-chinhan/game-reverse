package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class CloseHeaderView extends RelativeLayout {
    private ViewGroup a;
    private CloseImageView b;
    private TextView c;
    private String d;
    private String e;
    private long f;
    private long g;

    public CloseHeaderView(Context context) {
        super(context);
        this.d = "";
        this.e = "";
        a();
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

    private void a() {
        setBackgroundColor(Color.parseColor("#000000"));
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_close_header_view", "layout"), this);
        this.a = (ViewGroup) findViewById(q.a(getContext(), "myoffer_feedback_ll_nobg_id", "id"));
        this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_btn_close_ch_id", "id"));
        this.c = (TextView) findViewById(q.a(getContext(), "myoffer_tv_countdown_text", "id"));
        this.d = getContext().getString(q.a(getContext(), "myoffer_count_down_to_rewarded", "string"));
        this.e = getContext().getString(q.a(getContext(), "myoffer_count_down_finish_rewarded", "string"));
    }

    public void setDuration(long j) {
        this.f = j;
    }

    public void refresh(long j) {
        this.g = j;
        long j2 = this.f;
        if (j >= j2) {
            this.c.setText(this.e);
            this.c.setTextColor(-1);
        } else {
            this.c.setText(Html.fromHtml(String.format(this.d, Integer.valueOf((int) Math.ceil((j2 - j) / 1000.0d)))));
        }
    }

    public ViewGroup getFeedbackButton() {
        return this.a;
    }

    public CloseImageView getCloseImageView() {
        return this.b;
    }
}
