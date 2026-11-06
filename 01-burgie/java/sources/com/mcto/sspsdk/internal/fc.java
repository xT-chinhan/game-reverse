package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class fc {
    public static Toast a;

    public static void a(Context context, String str, int i) {
        Toast toastMakeText;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                toastMakeText = a;
            } else {
                toastMakeText = Toast.makeText(applicationContext.getApplicationContext(), "", 1);
                a = toastMakeText;
            }
            if (toastMakeText != null) {
                toastMakeText.setDuration(i);
                TextView textView = new TextView(applicationContext);
                textView.setText(str);
                int iA = hk.a(applicationContext, 15.0f);
                textView.setPadding(iA, iA / 2, iA, iA / 2);
                textView.setBackground(applicationContext.getDrawable(R.drawable.qy_bg_toast));
                textView.setTextColor(ContextCompat.getColor(applicationContext, R.color.qy_text_color_white_95alpha));
                toastMakeText.setView(textView);
                toastMakeText.setGravity(17, 0, -((int) ((applicationContext.getResources().getDisplayMetrics().density * 120.0f) + 0.5f)));
                toastMakeText.show();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void a(Context context, String str) {
        kh.a.a(new ec(context, str));
    }
}
