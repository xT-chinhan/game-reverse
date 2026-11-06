package com.mcto.sspsdk.internal;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class j4 extends LinearLayout {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final TextView p;
    public final TextView q;
    public final TextView r;

    public j4(AppCompatActivity appCompatActivity) {
        super(appCompatActivity, null, 0);
        this.a = "%wd%rc";
        this.b = "可领取奖励";
        this.c = false;
        this.d = true;
        this.l = -1;
        this.m = -1;
        this.n = Integer.MAX_VALUE;
        this.o = 0;
        setGravity(17);
        setBackgroundResource(R.drawable.qy_bg_corners50_stroke1_white40_solid_black);
        setPadding(hk.a(getContext(), 12.0f), hk.a(getContext(), 6.0f), hk.a(getContext(), 12.0f), hk.a(getContext(), 6.0f));
        TextView textView = new TextView(getContext());
        this.p = textView;
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(1, 13.0f);
        textView.setId(R.id.qy_count_down_desc);
        addView(textView);
        TextView textView2 = new TextView(getContext());
        this.q = textView2;
        textView2.setText("  |  ");
        textView2.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_white_60alpha));
        textView2.setGravity(17);
        textView2.setTextSize(1, 13.0f);
        textView2.setVisibility(8);
        textView2.setId(LinearLayout.generateViewId());
        addView(textView2);
        TextView textView3 = new TextView(getContext());
        this.r = textView3;
        textView3.setText("关闭");
        textView3.setTextColor(-1);
        textView3.setGravity(17);
        textView3.setTextSize(1, 13.0f);
        textView3.setVisibility(8);
        textView3.setId(R.id.qy_count_down_close);
        addView(textView3);
    }

    public final void a(long j) {
        if (this.o == 0) {
            long j2 = j / 1000;
            TextView textView = this.p;
            String strReplace = this.a;
            if (this.c) {
                strReplace = ((long) this.l) > j2 ? strReplace.replace("%cd", (((long) this.l) - j2) + "秒后") : strReplace.replace("%cd", "");
            }
            if (this.d) {
                strReplace = ((long) this.m) > j2 ? strReplace.replace("%wd", (((long) this.m) - j2) + "秒后") : strReplace.replace("%wd", "0秒后");
            }
            textView.setText(strReplace);
            if (this.n <= j2) {
                this.q.setVisibility(0);
                this.r.setVisibility(0);
            }
        }
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(str)) {
                spannableStringBuilder.append((CharSequence) "  ");
                float textSize = this.p.getTextSize();
                Paint paint = new Paint();
                paint.setTextSize(textSize);
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                int i = fontMetricsInt.descent - fontMetricsInt.ascent;
                Drawable drawable = getContext().getResources().getDrawable("1".equals(str) ? R.drawable.qy_ic_start_next_green : R.drawable.qy_ic_start_green);
                if (this.g != -16711936) {
                    drawable.mutate();
                    drawable.setColorFilter(this.g, PorterDuff.Mode.SRC_IN);
                }
                drawable.setBounds(0, 0, i, i);
                spannableStringBuilder.setSpan(new r5(drawable), 0, 1, 33);
            }
            spannableStringBuilder.append((CharSequence) str2);
            this.p.setText(spannableStringBuilder);
            this.p.setTextColor(this.g);
            this.q.setVisibility(0);
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        }
        this.r.setVisibility(0);
        this.r.setText(this.j);
    }
}
