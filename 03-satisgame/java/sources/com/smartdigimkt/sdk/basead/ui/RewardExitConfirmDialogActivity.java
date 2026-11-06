package com.smartdigimkt.sdk.basead.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.smartdigimkt.n1.l4;
import com.smartdigimkt.n1.m4;
import com.smartdigimkt.n1.n4;
import com.smartdigimkt.r4.b;
import com.smartdigimkt.r4.d;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class RewardExitConfirmDialogActivity extends Activity {
    public static Runnable c = null;
    public static String d = null;
    public static int e = 1;
    public b a;
    public Dialog b;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = d.a(this, new l4());
        try {
            View viewInflate = LayoutInflater.from(this).inflate(k.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(k.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(k.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(k.a(this, "myoffer_confirm_continue", "id"));
            textView2.setText(getResources().getString(k.a(this, "myoffer_reward_exit_confirm_give_up", "string")));
            if (e != 2) {
                textView.setText(getResources().getString(k.a(this, "myoffer_reward_exit_confirm_msg", "string"), d));
                textView3.setText(getResources().getString(k.a(this, "myoffer_reward_exit_confirm_continue", "string")));
            } else {
                textView.setText(getResources().getString(k.a(this, "myoffer_anim_reward_exit_confirm_msg", "string"), d));
                textView3.setText(getResources().getString(k.a(this, "myoffer_anim_reward_exit_confirm_continue", "string")));
            }
            textView2.setOnClickListener(new m4(this));
            textView3.setOnClickListener(new n4(this));
            Dialog dialog = new Dialog(this, k.a(this, "style_full_screen_translucent_dialog", "style"));
            this.b = dialog;
            dialog.setContentView(viewInflate);
            this.b.setCancelable(false);
            this.b.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.run();
            this.a = null;
        }
        Dialog dialog = this.b;
        if (dialog != null) {
            dialog.dismiss();
            this.b = null;
        }
        c = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
