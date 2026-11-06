package com.anythink.dlopt.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.k.a;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.b.b;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.y;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
public class ApkConfirmDialogActivity extends Activity {
    public static w a;
    private static a b;
    private Dialog c;

    public static void a(final Context context, final w wVar, final a aVar) {
        b.a().a(new Runnable() { // from class: com.anythink.dlopt.activity.ApkConfirmDialogActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.dlopt.common.b.a(context).a(wVar)) {
                    aVar.a(true);
                } else if (com.anythink.dlopt.common.c.a.a(context, wVar.I())) {
                    aVar.a(true);
                } else {
                    t.b().b(new Runnable() { // from class: com.anythink.dlopt.activity.ApkConfirmDialogActivity.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ApkConfirmDialogActivity.a = wVar;
                            a unused = ApkConfirmDialogActivity.b = aVar;
                            Intent intent = new Intent(context, (Class<?>) ApkConfirmDialogActivity.class);
                            intent.addFlags(C.ENCODING_PCM_MU_LAW);
                            context.startActivity(intent);
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        w wVar = a;
        if (wVar == null) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(wVar.x())) {
            w wVar2 = a;
            if (!(wVar2 instanceof bj) || TextUtils.isEmpty(((bj) wVar2).aK())) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        if (z && !TextUtils.isEmpty(a.N()) && !TextUtils.isEmpty(a.M()) && !TextUtils.isEmpty(a.O()) && !TextUtils.isEmpty(a.P())) {
            try {
                w wVar3 = a;
                View viewInflate = LayoutInflater.from(this).inflate(q.a(this, "confirm", "layout"), (ViewGroup) null, false);
                RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(q.a(this, "confirm_dialog_icon", "id"));
                TextView textView = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_title", "id"));
                TextView textView2 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_version_name", "id"));
                TextView textView3 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_publisher_name", "id"));
                TextView textView4 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_permission_manage", "id"));
                TextView textView5 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_privacy_agreement", "id"));
                TextView textView6 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_desc", "id"));
                View viewFindViewById = viewInflate.findViewById(q.a(this, "confirm_dialog_center_line2", "id"));
                TextView textView7 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_download_now", "id"));
                TextView textView8 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_give_up", "id"));
                String strZ = wVar3.z();
                if (!TextUtils.isEmpty(strZ)) {
                    roundImageView.setNeedRadiu(true);
                    roundImageView.setRadiusInDip(4);
                    ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                    com.anythink.core.common.res.b.a(this).a(new e(1, strZ), layoutParams.width, layoutParams.height, new AnonymousClass4(strZ, roundImageView));
                } else {
                    ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                    layoutParams2.width = 0;
                    layoutParams2.height = 0;
                    roundImageView.setLayoutParams(layoutParams2);
                }
                String strAK = wVar3 instanceof bj ? ((bj) wVar3).aK() : "";
                if (TextUtils.isEmpty(strAK)) {
                    strAK = wVar3.x();
                }
                textView.setText(strAK);
                textView2.setText(getResources().getString(q.a(this, "confirm_dialog_version", "string"), wVar3.N()));
                textView3.setText(getResources().getString(q.a(this, "confirm_dialog_publisher", "string"), wVar3.M()));
                String string = getResources().getString(q.a(this, "confirm_dialog_privacy_agreement", "string"));
                String string2 = getResources().getString(q.a(this, "confirm_dialog_application_permission", "string"));
                int length = string.length();
                int length2 = string2.length();
                if (length != length2) {
                    int iAbs = Math.abs(length2 - length);
                    StringBuilder sb = new StringBuilder(string);
                    for (int i = 0; i < iAbs; i++) {
                        sb.append(" ");
                    }
                    string = sb.toString();
                }
                textView5.setText(string);
                textView4.setOnClickListener(new AnonymousClass5(wVar3));
                textView5.setOnClickListener(new AnonymousClass6(wVar3));
                if (!TextUtils.isEmpty(wVar3.h())) {
                    textView6.setVisibility(0);
                    viewFindViewById.setVisibility(0);
                    textView6.setOnClickListener(new AnonymousClass7(wVar3));
                }
                textView7.setOnClickListener(new AnonymousClass8());
                textView8.setOnClickListener(new AnonymousClass9());
                Dialog dialog = new Dialog(this, q.a(this, "style_full_screen_translucent_dialog", "style"));
                this.c = dialog;
                dialog.setContentView(viewInflate);
                this.c.setCancelable(false);
                Window window = this.c.getWindow();
                if (window != null) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(q.a(this, "confirm_dialog_margin", "dimen"));
                    int i2 = getResources().getDisplayMetrics().widthPixels;
                    int i3 = getResources().getDisplayMetrics().heightPixels;
                    if (i2 > i3) {
                        int i4 = i3 - (dimensionPixelSize * 2);
                        window.setLayout((int) Math.ceil(i4 * 0.98859316f), i4);
                    } else {
                        int i5 = i2 - (dimensionPixelSize * 2);
                        window.setLayout(i5, (int) Math.ceil(i5 / 0.98859316f));
                    }
                }
                this.c.show();
                return;
            } catch (Throwable unused) {
                finish();
                return;
            }
        }
        try {
            w wVar4 = a;
            String strAK2 = wVar4 instanceof bj ? ((bj) wVar4).aK() : "";
            if (TextUtils.isEmpty(strAK2)) {
                strAK2 = a.x();
            }
            View viewInflate2 = LayoutInflater.from(this).inflate(q.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView9 = (TextView) viewInflate2.findViewById(q.a(this, "myoffer_confirm_msg", "id"));
            TextView textView10 = (TextView) viewInflate2.findViewById(q.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView11 = (TextView) viewInflate2.findViewById(q.a(this, "myoffer_confirm_continue", "id"));
            textView9.setText(getResources().getString(q.a(this, "sample_dialog_download_app", "string"), strAK2));
            textView10.setText(getResources().getString(q.a(this, "sample_dialog_give_up", "string")));
            textView11.setText(getResources().getString(q.a(this, "sample_dialog_confirm", "string")));
            textView10.setOnClickListener(new AnonymousClass2());
            textView11.setOnClickListener(new AnonymousClass3());
            Dialog dialog2 = new Dialog(this, q.a(this, "style_full_screen_translucent_dialog", "style"));
            this.c = dialog2;
            dialog2.setContentView(viewInflate2);
            this.c.setCancelable(false);
            this.c.show();
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        am.a(true);
    }

    private void b() {
        try {
            w wVar = a;
            String strAK = wVar instanceof bj ? ((bj) wVar).aK() : "";
            if (TextUtils.isEmpty(strAK)) {
                strAK = a.x();
            }
            View viewInflate = LayoutInflater.from(this).inflate(q.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_continue", "id"));
            textView.setText(getResources().getString(q.a(this, "sample_dialog_download_app", "string"), strAK));
            textView2.setText(getResources().getString(q.a(this, "sample_dialog_give_up", "string")));
            textView3.setText(getResources().getString(q.a(this, "sample_dialog_confirm", "string")));
            textView2.setOnClickListener(new AnonymousClass2());
            textView3.setOnClickListener(new AnonymousClass3());
            Dialog dialog = new Dialog(this, q.a(this, "style_full_screen_translucent_dialog", "style"));
            this.c = dialog;
            dialog.setContentView(viewInflate);
            this.c.setCancelable(false);
            this.c.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a().a(new Runnable() { // from class: com.anythink.dlopt.activity.ApkConfirmDialogActivity.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(false);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a().a(new Runnable() { // from class: com.anythink.dlopt.activity.ApkConfirmDialogActivity.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(true);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    private void c() {
        try {
            w wVar = a;
            View viewInflate = LayoutInflater.from(this).inflate(q.a(this, "confirm", "layout"), (ViewGroup) null, false);
            RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(q.a(this, "confirm_dialog_icon", "id"));
            TextView textView = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_title", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_version_name", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_publisher_name", "id"));
            TextView textView4 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_permission_manage", "id"));
            TextView textView5 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_privacy_agreement", "id"));
            TextView textView6 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_desc", "id"));
            View viewFindViewById = viewInflate.findViewById(q.a(this, "confirm_dialog_center_line2", "id"));
            TextView textView7 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_download_now", "id"));
            TextView textView8 = (TextView) viewInflate.findViewById(q.a(this, "confirm_dialog_give_up", "id"));
            String strZ = wVar.z();
            if (!TextUtils.isEmpty(strZ)) {
                roundImageView.setNeedRadiu(true);
                roundImageView.setRadiusInDip(4);
                ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                com.anythink.core.common.res.b.a(this).a(new e(1, strZ), layoutParams.width, layoutParams.height, new AnonymousClass4(strZ, roundImageView));
            } else {
                ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                layoutParams2.width = 0;
                layoutParams2.height = 0;
                roundImageView.setLayoutParams(layoutParams2);
            }
            String strAK = wVar instanceof bj ? ((bj) wVar).aK() : "";
            if (TextUtils.isEmpty(strAK)) {
                strAK = wVar.x();
            }
            textView.setText(strAK);
            textView2.setText(getResources().getString(q.a(this, "confirm_dialog_version", "string"), wVar.N()));
            textView3.setText(getResources().getString(q.a(this, "confirm_dialog_publisher", "string"), wVar.M()));
            String string = getResources().getString(q.a(this, "confirm_dialog_privacy_agreement", "string"));
            String string2 = getResources().getString(q.a(this, "confirm_dialog_application_permission", "string"));
            int length = string.length();
            int length2 = string2.length();
            if (length != length2) {
                int iAbs = Math.abs(length2 - length);
                StringBuilder sb = new StringBuilder(string);
                for (int i = 0; i < iAbs; i++) {
                    sb.append(" ");
                }
                string = sb.toString();
            }
            textView5.setText(string);
            textView4.setOnClickListener(new AnonymousClass5(wVar));
            textView5.setOnClickListener(new AnonymousClass6(wVar));
            if (!TextUtils.isEmpty(wVar.h())) {
                textView6.setVisibility(0);
                viewFindViewById.setVisibility(0);
                textView6.setOnClickListener(new AnonymousClass7(wVar));
            }
            textView7.setOnClickListener(new AnonymousClass8());
            textView8.setOnClickListener(new AnonymousClass9());
            Dialog dialog = new Dialog(this, q.a(this, "style_full_screen_translucent_dialog", "style"));
            this.c = dialog;
            dialog.setContentView(viewInflate);
            this.c.setCancelable(false);
            Window window = this.c.getWindow();
            if (window != null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(q.a(this, "confirm_dialog_margin", "dimen"));
                int i2 = getResources().getDisplayMetrics().widthPixels;
                int i3 = getResources().getDisplayMetrics().heightPixels;
                if (i2 > i3) {
                    int i4 = i3 - (dimensionPixelSize * 2);
                    window.setLayout((int) Math.ceil(i4 * 0.98859316f), i4);
                } else {
                    int i5 = i2 - (dimensionPixelSize * 2);
                    window.setLayout(i5, (int) Math.ceil(i5 / 0.98859316f));
                }
            }
            this.c.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ String a;
        final /* synthetic */ RoundImageView b;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass4(String str, RoundImageView roundImageView) {
            this.a = str;
            this.b = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ w a;

        AnonymousClass5(w wVar) {
            this.a = wVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            y.a(ApkConfirmDialogActivity.this, this.a.P());
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$6, reason: invalid class name */
    final class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ w a;

        AnonymousClass6(w wVar) {
            this.a = wVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            y.a(ApkConfirmDialogActivity.this, this.a.O());
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ w a;

        AnonymousClass7(w wVar) {
            this.a = wVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            y.a(ApkConfirmDialogActivity.this, this.a.h());
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$8, reason: invalid class name */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a().a(new Runnable() { // from class: com.anythink.dlopt.activity.ApkConfirmDialogActivity.8.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(true);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.activity.ApkConfirmDialogActivity$9, reason: invalid class name */
    final class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a().a(new Runnable() { // from class: com.anythink.dlopt.activity.ApkConfirmDialogActivity.9.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(false);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        am.a(false);
        Dialog dialog = this.c;
        if (dialog != null) {
            dialog.dismiss();
            this.c = null;
        }
        a = null;
        b = null;
        super.onDestroy();
    }
}
