package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ms extends Dialog {
    private ClipImageView ab;
    private TextView ah;
    private TextView c;
    private final long ch;
    private TextView d;
    private long hi;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f4384ms;
    private Activity ny;
    private final com.ss.android.downloadlib.addownload.xr.xr sl;
    private LinearLayout x;
    private TextView xr;

    public ms(Activity activity, long j) {
        super(activity);
        this.ny = activity;
        this.ch = j;
        this.sl = (com.ss.android.downloadlib.addownload.xr.xr) ah.ms().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.sl == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.hi = this.sl.xr;
        ms();
        ab.xr("lp_app_dialog_show", this.hi);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ms.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ab.ms("lp_app_dialog_cancel", ms.this.hi);
            }
        });
    }

    private void ms() {
        this.f4384ms = (TextView) findViewById(R.id.tv_app_name);
        this.xr = (TextView) findViewById(R.id.tv_app_version);
        this.ah = (TextView) findViewById(R.id.tv_app_developer);
        this.d = (TextView) findViewById(R.id.tv_app_detail);
        this.ka = (TextView) findViewById(R.id.tv_app_privacy);
        this.c = (TextView) findViewById(R.id.tv_give_up);
        this.ab = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.x = (LinearLayout) findViewById(R.id.ll_download);
        this.f4384ms.setText(zb.ms(this.sl.ka, "--"));
        this.xr.setText("版本号：" + zb.ms(this.sl.c, "--"));
        this.ah.setText("开发者：" + zb.ms(this.sl.ab, "应用信息正在完善中"));
        this.ab.setRoundRadius(zb.ms(hi.getContext(), 8.0f));
        this.ab.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.ms().ms(this.ch, new d.ms() { // from class: com.ss.android.downloadlib.addownload.compliance.ms.2
            @Override // com.ss.android.downloadlib.addownload.compliance.d.ms
            public void ms(Bitmap bitmap) {
                if (bitmap != null) {
                    ms.this.ab.setImageBitmap(bitmap);
                } else {
                    ab.ms(8, ms.this.hi);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ms.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.ms().ms(ms.this.ny);
                AppDetailInfoActivity.ms(ms.this.ny, ms.this.ch);
                ab.ms("lp_app_dialog_click_detail", ms.this.hi);
            }
        });
        this.ka.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ms.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.ms().ms(ms.this.ny);
                AppPrivacyPolicyActivity.ms(ms.this.ny, ms.this.ch);
                ab.ms("lp_app_dialog_click_privacy", ms.this.hi);
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ms.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ms.this.dismiss();
                ab.ms("lp_app_dialog_click_giveup", ms.this.hi);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ms.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab.ms("lp_app_dialog_click_download", ms.this.hi);
                xr.ms().xr(ms.this.hi);
                ms.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.ah.ms(this.ny);
    }
}
