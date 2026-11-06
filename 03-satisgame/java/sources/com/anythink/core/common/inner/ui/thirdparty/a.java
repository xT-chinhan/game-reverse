package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.anythink.core.common.u.a.f;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private Timer a;
    private long b;
    private InterfaceC0027a c;
    private View d;
    private TextView e;
    private f.b f = new f.b(1);
    private String g;

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.a$a, reason: collision with other inner class name */
    public interface InterfaceC0027a {
        void a(int i);
    }

    static /* synthetic */ long b(a aVar, long j) {
        long j2 = aVar.b - j;
        aVar.b = j2;
        return j2;
    }

    public a(Context context, View view, long j, InterfaceC0027a interfaceC0027a) {
        this.g = "";
        this.d = view;
        TextView textView = new TextView(context);
        textView.setHeight(a(context, 24.0f));
        textView.setGravity(17);
        textView.setPadding(a(context, 14.0f), 0, a(context, 11.0f), 0);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(1, 12.0f);
        int color = Color.parseColor("#99000000");
        float fA = a(context, 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(fA);
        textView.setBackground(gradientDrawable);
        this.e = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.thirdparty.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.a(a.this, 2);
            }
        });
        this.c = interfaceC0027a;
        this.b = j;
        this.g = Locale.getDefault().getLanguage().equals("zh") ? "跳过" : "Skip";
    }

    private static TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setHeight(a(context, 24.0f));
        textView.setGravity(17);
        textView.setPadding(a(context, 14.0f), 0, a(context, 11.0f), 0);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(1, 12.0f);
        int color = Color.parseColor("#99000000");
        float fA = a(context, 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(fA);
        textView.setBackground(gradientDrawable);
        return textView;
    }

    public final TextView a() {
        return this.e;
    }

    public final void b() {
        if (this.a == null) {
            Timer timer = new Timer();
            this.a = timer;
            timer.schedule(new TimerTask() { // from class: com.anythink.core.common.inner.ui.thirdparty.a.2
                final /* synthetic */ long a = 1000;

                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    a.this.d.post(new Runnable() { // from class: com.anythink.core.common.inner.ui.thirdparty.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.d.getParent() != null && (a.this.d.getParent() instanceof View) && a.this.f.a((View) a.this.d.getParent(), a.this.d, 80, 0)) {
                                if (a.this.b > 0) {
                                    a.a(a.this, a.this.b);
                                } else {
                                    a.a(a.this, 3);
                                }
                                a.b(a.this, AnonymousClass2.this.a);
                            }
                        }
                    });
                }
            }, 1000L, 1000L);
            this.d.post(new Runnable() { // from class: com.anythink.core.common.inner.ui.thirdparty.a.3
                final /* synthetic */ long a = 1000;

                @Override // java.lang.Runnable
                public final void run() {
                    a aVar = a.this;
                    a.a(aVar, aVar.b);
                    a.b(a.this, this.a);
                }
            });
        }
    }

    private void a(long j) {
        int i = (int) (j / 1000);
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(i + "s | " + this.g);
        }
    }

    private void a(int i) {
        InterfaceC0027a interfaceC0027a = this.c;
        if (interfaceC0027a != null) {
            interfaceC0027a.a(i);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }

    private void c() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }

    private static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static boolean d() {
        return Locale.getDefault().getLanguage().equals("zh");
    }

    static /* synthetic */ void a(a aVar, int i) {
        InterfaceC0027a interfaceC0027a = aVar.c;
        if (interfaceC0027a != null) {
            interfaceC0027a.a(i);
        }
        TextView textView = aVar.e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        Timer timer = aVar.a;
        if (timer != null) {
            timer.cancel();
            aVar.a = null;
        }
    }

    static /* synthetic */ void a(a aVar, long j) {
        int i = (int) (j / 1000);
        TextView textView = aVar.e;
        if (textView != null) {
            textView.setText(i + "s | " + aVar.g);
        }
    }
}
