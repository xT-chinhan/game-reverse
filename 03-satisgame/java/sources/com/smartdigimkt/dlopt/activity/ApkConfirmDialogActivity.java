package com.smartdigimkt.dlopt.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.g3.a;
import com.smartdigimkt.i.d;
import com.smartdigimkt.i.f;
import com.smartdigimkt.i.g;
import com.smartdigimkt.i.h;
import com.smartdigimkt.i.i;
import com.smartdigimkt.i.j;
import com.smartdigimkt.i.n;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ApkConfirmDialogActivity extends Activity {
    public static c c;
    public static a d;
    public Dialog a;
    public boolean b = false;

    /* JADX WARN: Code duplicated, block: B:12:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x00fb A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:24:0x010f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0113 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0125  */
    /* JADX WARN: Code duplicated, block: B:30:0x012f A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:31:0x015a A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0172 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0178  */
    /* JADX WARN: Code duplicated, block: B:38:0x0180 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01db  */
    /* JADX WARN: Code duplicated, block: B:42:0x01dc A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01e9 A[Catch: all -> 0x02a5, LOOP:0: B:43:0x01e7->B:44:0x01e9, LOOP_END, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0210 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0259 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0282 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0291 A[Catch: all -> 0x02a5, TryCatch #1 {all -> 0x02a5, blocks: (B:20:0x006b, B:23:0x00fb, B:26:0x0113, B:28:0x0127, B:30:0x012f, B:32:0x016e, B:34:0x0172, B:36:0x017a, B:38:0x0180, B:39:0x0182, B:46:0x01f5, B:48:0x0210, B:49:0x0223, B:51:0x0259, B:53:0x0282, B:54:0x0291, B:55:0x029f, B:42:0x01dc, B:44:0x01e9, B:45:0x01f1, B:31:0x015a), top: B:76:0x006b }] */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        c cVar;
        View viewInflate;
        RoundImageView roundImageView;
        TextView textView;
        View viewFindViewById;
        TextView textView2;
        TextView textView3;
        String str;
        String str2;
        String string;
        int length;
        int length2;
        int iAbs;
        StringBuilder sb;
        int i;
        Window window;
        int dimensionPixelSize;
        int i2;
        int i3;
        super.onCreate(bundle);
        if (c == null) {
            finish();
            return;
        }
        this.b = getIntent().getBooleanExtra("flag_apk_exists", false);
        if (TextUtils.isEmpty(c.c)) {
            c cVar2 = c;
            if ((cVar2 instanceof l) && !TextUtils.isEmpty(((l) cVar2).X)) {
                if (!TextUtils.isEmpty(c.s) && !TextUtils.isEmpty(c.r) && !TextUtils.isEmpty(c.t) && !TextUtils.isEmpty(c.u)) {
                    try {
                        cVar = c;
                        viewInflate = LayoutInflater.from(this).inflate(k.a(this, "confirm", "layout"), (ViewGroup) null, false);
                        roundImageView = (RoundImageView) viewInflate.findViewById(k.a(this, "confirm_dialog_icon", "id"));
                        TextView textView4 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_title", "id"));
                        TextView textView5 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_version_name", "id"));
                        TextView textView6 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_publisher_name", "id"));
                        TextView textView7 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_permission_manage", "id"));
                        TextView textView8 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_privacy_agreement", "id"));
                        textView = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_desc", "id"));
                        viewFindViewById = viewInflate.findViewById(k.a(this, "confirm_dialog_center_line2", "id"));
                        textView2 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_download_now", "id"));
                        textView3 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_give_up", "id"));
                        if (this.b) {
                            if (textView2 != null) {
                                textView2.setText(getResources().getString(k.a(this, "cta_download_finished", "string")));
                            }
                            if (textView3 != null) {
                                textView3.setText(getResources().getString(k.a(this, "confirm_dialog_install_give_up", "string")));
                            }
                        } else {
                            viewInflate = viewInflate;
                        }
                        str = cVar.e;
                        if (TextUtils.isEmpty(str)) {
                            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                            layoutParams.width = 0;
                            layoutParams.height = 0;
                            roundImageView.setLayoutParams(layoutParams);
                        } else {
                            roundImageView.setNeedRadiu(true);
                            roundImageView.setRadiusInDip(4);
                            ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                            m.a(this).a(new o(1, str), layoutParams2.width, layoutParams2.height, new g(str, roundImageView));
                        }
                        if (cVar instanceof l) {
                            str2 = ((l) cVar).X;
                        } else {
                            str2 = "";
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = cVar.c;
                        }
                        textView4.setText(str2);
                        textView5.setText(getResources().getString(k.a(this, "confirm_dialog_version", "string"), cVar.s));
                        textView6.setText(getResources().getString(k.a(this, "confirm_dialog_publisher", "string"), cVar.r));
                        string = getResources().getString(k.a(this, "confirm_dialog_privacy_agreement", "string"));
                        String string2 = getResources().getString(k.a(this, "confirm_dialog_application_permission", "string"));
                        length = string.length();
                        length2 = string2.length();
                        if (length == length2) {
                            iAbs = Math.abs(length2 - length);
                            sb = new StringBuilder(string);
                            for (i = 0; i < iAbs; i++) {
                                sb.append(" ");
                            }
                            string = sb.toString();
                        }
                        textView8.setText(string);
                        textView7.setOnClickListener(new h(this, cVar));
                        textView8.setOnClickListener(new i(this, cVar));
                        if (!TextUtils.isEmpty(cVar.v)) {
                            textView.setVisibility(0);
                            viewFindViewById.setVisibility(0);
                            textView.setOnClickListener(new j(this, cVar));
                        }
                        textView2.setOnClickListener(new com.smartdigimkt.i.l(this));
                        textView3.setOnClickListener(new n(this));
                        Dialog dialog = new Dialog(this, k.a(this, "style_full_screen_translucent_dialog", "style"));
                        this.a = dialog;
                        dialog.setContentView(viewInflate);
                        this.a.setCancelable(false);
                        window = this.a.getWindow();
                        if (window != null) {
                            dimensionPixelSize = getResources().getDimensionPixelSize(k.a(this, "confirm_dialog_margin", "dimen"));
                            i2 = getResources().getDisplayMetrics().widthPixels;
                            i3 = getResources().getDisplayMetrics().heightPixels;
                            if (i2 > i3) {
                                int i4 = i3 - (dimensionPixelSize * 2);
                                window.setLayout((int) Math.ceil(i4 * 0.98859316f), i4);
                            } else {
                                int i5 = i2 - (dimensionPixelSize * 2);
                                window.setLayout(i5, (int) Math.ceil(i5 / 0.98859316f));
                            }
                        }
                        this.a.show();
                        return;
                    } catch (Throwable unused) {
                        finish();
                        return;
                    }
                }
            }
        } else if (!TextUtils.isEmpty(c.s)) {
            cVar = c;
            viewInflate = LayoutInflater.from(this).inflate(k.a(this, "confirm", "layout"), (ViewGroup) null, false);
            roundImageView = (RoundImageView) viewInflate.findViewById(k.a(this, "confirm_dialog_icon", "id"));
            TextView textView9 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_title", "id"));
            TextView textView10 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_version_name", "id"));
            TextView textView11 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_publisher_name", "id"));
            TextView textView12 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_permission_manage", "id"));
            TextView textView13 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_privacy_agreement", "id"));
            textView = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_desc", "id"));
            viewFindViewById = viewInflate.findViewById(k.a(this, "confirm_dialog_center_line2", "id"));
            textView2 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_download_now", "id"));
            textView3 = (TextView) viewInflate.findViewById(k.a(this, "confirm_dialog_give_up", "id"));
            if (this.b) {
                if (textView2 != null) {
                    textView2.setText(getResources().getString(k.a(this, "cta_download_finished", "string")));
                }
                if (textView3 != null) {
                    textView3.setText(getResources().getString(k.a(this, "confirm_dialog_install_give_up", "string")));
                }
            } else {
                viewInflate = viewInflate;
            }
            str = cVar.e;
            if (TextUtils.isEmpty(str)) {
                roundImageView.setNeedRadiu(true);
                roundImageView.setRadiusInDip(4);
                ViewGroup.LayoutParams layoutParams3 = roundImageView.getLayoutParams();
                m.a(this).a(new o(1, str), layoutParams3.width, layoutParams3.height, new g(str, roundImageView));
            } else {
                ViewGroup.LayoutParams layoutParams4 = roundImageView.getLayoutParams();
                layoutParams4.width = 0;
                layoutParams4.height = 0;
                roundImageView.setLayoutParams(layoutParams4);
            }
            if (cVar instanceof l) {
                str2 = ((l) cVar).X;
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = cVar.c;
            }
            textView9.setText(str2);
            textView10.setText(getResources().getString(k.a(this, "confirm_dialog_version", "string"), cVar.s));
            textView11.setText(getResources().getString(k.a(this, "confirm_dialog_publisher", "string"), cVar.r));
            string = getResources().getString(k.a(this, "confirm_dialog_privacy_agreement", "string"));
            String string3 = getResources().getString(k.a(this, "confirm_dialog_application_permission", "string"));
            length = string.length();
            length2 = string3.length();
            if (length == length2) {
                iAbs = Math.abs(length2 - length);
                sb = new StringBuilder(string);
                while (i < iAbs) {
                    sb.append(" ");
                }
                string = sb.toString();
            }
            textView13.setText(string);
            textView12.setOnClickListener(new h(this, cVar));
            textView13.setOnClickListener(new i(this, cVar));
            if (!TextUtils.isEmpty(cVar.v)) {
                textView.setVisibility(0);
                viewFindViewById.setVisibility(0);
                textView.setOnClickListener(new j(this, cVar));
            }
            textView2.setOnClickListener(new com.smartdigimkt.i.l(this));
            textView3.setOnClickListener(new n(this));
            Dialog dialog2 = new Dialog(this, k.a(this, "style_full_screen_translucent_dialog", "style"));
            this.a = dialog2;
            dialog2.setContentView(viewInflate);
            this.a.setCancelable(false);
            window = this.a.getWindow();
            if (window != null) {
                dimensionPixelSize = getResources().getDimensionPixelSize(k.a(this, "confirm_dialog_margin", "dimen"));
                i2 = getResources().getDisplayMetrics().widthPixels;
                i3 = getResources().getDisplayMetrics().heightPixels;
                if (i2 > i3) {
                    int i6 = i3 - (dimensionPixelSize * 2);
                    window.setLayout((int) Math.ceil(i6 * 0.98859316f), i6);
                } else {
                    int i7 = i2 - (dimensionPixelSize * 2);
                    window.setLayout(i7, (int) Math.ceil(i7 / 0.98859316f));
                }
            }
            this.a.show();
            return;
        }
        try {
            c cVar3 = c;
            String str3 = cVar3 instanceof l ? ((l) cVar3).X : "";
            if (TextUtils.isEmpty(str3)) {
                str3 = c.c;
            }
            View viewInflate2 = LayoutInflater.from(this).inflate(k.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView14 = (TextView) viewInflate2.findViewById(k.a(this, "myoffer_confirm_msg", "id"));
            TextView textView15 = (TextView) viewInflate2.findViewById(k.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView16 = (TextView) viewInflate2.findViewById(k.a(this, "myoffer_confirm_continue", "id"));
            String string4 = getResources().getString(k.a(this, "sample_dialog_download_app", "string"), str3);
            if (this.b) {
                string4 = getResources().getString(k.a(this, "sample_dialog_install_app", "string"), str3);
            }
            textView14.setText(string4);
            textView15.setText(getResources().getString(k.a(this, "sample_dialog_give_up", "string")));
            textView16.setText(getResources().getString(k.a(this, "sample_dialog_confirm", "string")));
            textView15.setOnClickListener(new d(this));
            textView16.setOnClickListener(new f(this));
            Dialog dialog3 = new Dialog(this, k.a(this, "style_full_screen_translucent_dialog", "style"));
            this.a = dialog3;
            dialog3.setContentView(viewInflate2);
            this.a.setCancelable(false);
            this.a.show();
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        com.smartdigimkt.o3.d.a = false;
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
            this.a = null;
        }
        c = null;
        d = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        com.smartdigimkt.o3.d.a = true;
    }
}
