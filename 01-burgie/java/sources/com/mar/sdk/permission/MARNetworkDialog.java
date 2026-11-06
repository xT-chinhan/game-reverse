package com.mar.sdk.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.mar.sdk.utils.ResourceHelper;

/* JADX INFO: loaded from: classes2.dex */
public class MARNetworkDialog extends Dialog {
    private static boolean showing = false;
    private AlertDialog ad;
    private boolean canRetry;
    private INetworkListener listener;

    public MARNetworkDialog(Context context) {
        super(context, ResourceHelper.getIdentifier(context, "R.style.mar_permission_dialog"));
        this.ad = new AlertDialog.Builder(context).create();
        this.ad.setCancelable(false);
        this.ad.setCanceledOnTouchOutside(false);
        this.ad.getWindow().setType(2);
    }

    private void doShow(Activity activity) {
        this.ad.show();
        WindowManager.LayoutParams attrs = this.ad.getWindow().getAttributes();
        WindowManager wm = (WindowManager) activity.getSystemService("window");
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        float ratio = 0.9f;
        if (activity.getResources().getConfiguration().orientation == 2) {
            ratio = 0.6f;
        }
        attrs.width = (int) (dm.widthPixels * ratio);
        this.ad.getWindow().setAttributes(attrs);
        Window window = this.ad.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(ResourceHelper.getIdentifier(activity, "R.layout.mar_network_tip_layout"));
        initView(window);
    }

    private void initView(Window view) {
        Button exit = (Button) ResourceHelper.getViewByWindow(view, "R.id.mar_network_exit");
        exit.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARNetworkDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MARNetworkDialog.this.dismiss();
                if (MARNetworkDialog.this.listener != null) {
                    MARNetworkDialog.this.listener.exit();
                }
            }
        });
        Button retry = (Button) ResourceHelper.getViewByWindow(view, "R.id.mar_network_retry");
        if (!this.canRetry) {
            retry.setVisibility(8);
        } else {
            retry.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARNetworkDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    MARNetworkDialog.this.dismiss();
                    if (MARNetworkDialog.this.listener != null) {
                        MARNetworkDialog.this.listener.retry();
                    }
                }
            });
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        showing = false;
        if (this.ad != null) {
            try {
                this.ad.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showDialog(Activity activity, boolean canRetry, INetworkListener networkListener) {
        if (showing) {
            Log.d("MARSDK", "network dialog is showing");
            return;
        }
        showing = true;
        MARNetworkDialog dialog = new MARNetworkDialog(activity);
        dialog.listener = networkListener;
        dialog.canRetry = canRetry;
        dialog.doShow(activity);
    }
}
