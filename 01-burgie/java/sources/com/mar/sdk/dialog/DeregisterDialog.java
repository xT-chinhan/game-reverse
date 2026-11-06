package com.mar.sdk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.mar.sdk.MARSDK;
import com.mar.sdk.utils.ResourceHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DeregisterDialog extends Dialog {
    private final Context context;
    private CountDownTimer timer;

    public DeregisterDialog(Context context) {
        super(context, ResourceHelper.getIdentifier(context, "R.style.mar_fullDialog"));
        this.context = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(ResourceHelper.getIdentifier(this.context, "R.layout.mar_logout_layout"));
        TextView content = (TextView) findViewById(ResourceHelper.getIdentifier(this.context, "R.id.logout_content"));
        TextView cancel = (TextView) findViewById(ResourceHelper.getIdentifier(this.context, "R.id.logout_cancel"));
        final TextView confirm = (TextView) findViewById(ResourceHelper.getIdentifier(this.context, "R.id.logout_true"));
        content.setText(String.format(ResourceHelper.getString(this.context, "R.string.mar_logout_tip"), new Object[0]));
        if (this.timer == null) {
            this.timer = new CountDownTimer(5000L, 1000L) { // from class: com.mar.sdk.dialog.DeregisterDialog.1
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    int second = (int) (millisUntilFinished / 1000);
                    confirm.setText(String.format(ResourceHelper.getString(DeregisterDialog.this.context, "R.string.mar_logout_confirm"), Integer.valueOf(second + 1)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    confirm.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.dialog.DeregisterDialog.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            DeregisterDialog.this.deregister();
                            DeregisterDialog.this.dismiss();
                        }
                    });
                    confirm.setText(ResourceHelper.getString(DeregisterDialog.this.context, "R.string.mar_logout_confirm2"));
                    confirm.setBackground(ResourceHelper.getDrawable(DeregisterDialog.this.context, "R.drawable.mar_corner_button_pressed"));
                }
            };
        }
        this.timer.start();
        cancel.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.dialog.DeregisterDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeregisterDialog.this.timer.cancel();
                DeregisterDialog.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deregister() {
        dismiss();
        MARSDK.getInstance().getContext().finish();
        System.exit(0);
    }
}
