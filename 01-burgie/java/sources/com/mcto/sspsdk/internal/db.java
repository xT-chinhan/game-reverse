package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.webview.QyWebViewCore;

/* JADX INFO: loaded from: classes2.dex */
public abstract class db {
    public static void a(TextView textView, Context context, String str, String str2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(context).inflate(R.layout.qy_layout_developer_webview, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow((View) constraintLayout, -1, -1, true);
        cb cbVar = new cb(popupWindow);
        popupWindow.setClippingEnabled(false);
        ((TextView) constraintLayout.findViewById(R.id.qy_app_developer_info_webview_title)).setText(str);
        ((QyWebViewCore) constraintLayout.findViewById(R.id.qy_layout_developer_webview_core)).loadUrl(str2);
        constraintLayout.findViewById(R.id.qy_app_developer_info_webview_close).setOnClickListener(cbVar);
        constraintLayout.findViewById(R.id.qy_app_developer_info_webview_outline).setOnClickListener(cbVar);
        popupWindow.showAtLocation(textView, 17, 0, 0);
    }
}
