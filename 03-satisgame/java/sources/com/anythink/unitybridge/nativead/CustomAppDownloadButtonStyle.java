package com.anythink.unitybridge.nativead;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.huawei.hms.ads.AppDownloadButtonStyle;

/* JADX INFO: loaded from: classes.dex */
public class CustomAppDownloadButtonStyle extends AppDownloadButtonStyle {
    public CustomAppDownloadButtonStyle(Context context, ViewInfo viewInfo) {
        super(context);
        try {
            if (!TextUtils.isEmpty(viewInfo.ctaView.textcolor)) {
                this.normalStyle.setTextColor(Color.parseColor(viewInfo.ctaView.textcolor));
                this.processingStyle.setTextColor(Color.parseColor(viewInfo.ctaView.textcolor));
                this.installingStyle.setTextColor(Color.parseColor(viewInfo.ctaView.textcolor));
            }
            if (TextUtils.isEmpty(viewInfo.ctaView.bgcolor)) {
                return;
            }
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(viewInfo.ctaView.bgcolor));
            this.normalStyle.setBackground(colorDrawable);
            this.processingStyle.setBackground(colorDrawable);
            this.installingStyle.setBackground(colorDrawable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
