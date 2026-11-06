package com.byazt.ca;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public class b {
    public static SoftReference<Toast> pr;

    private static Toast pr(Context context) {
        if (context == null) {
            SoftReference<Toast> softReference = pr;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }
        SoftReference<Toast> softReference2 = new SoftReference<>(Toast.makeText(context.getApplicationContext(), "", 0));
        pr = softReference2;
        return softReference2.get();
    }

    public static Toast pr(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        toast.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(pr(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(pr(context, 20.0f), pr(context, 12.0f), pr(context, 20.0f), pr(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void pr(Context context, String str, int i) {
        hw(context, str, i, 80, 0, pr(context, 40.0f));
    }

    public static void hw(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toastPr = pr(context);
        if (toastPr != null) {
            toastPr.setDuration(i);
            toastPr.setGravity(i2, i3, i4);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(pr(context, 10.0f));
            gradientDrawable.setColor(Color.parseColor("#CC161823"));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(pr(context, 20.0f), pr(context, 12.0f), pr(context, 20.0f), pr(context, 12.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            toastPr.setView(linearLayout);
            toastPr.show();
        }
    }

    private static int pr(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
