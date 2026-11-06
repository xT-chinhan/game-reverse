package com.anythink.basead.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anythink.core.common.v.q;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
public class RewardExitConfirmDialogActivity extends Activity {
    public static final int a = 1;
    public static final int b = 2;
    private static Runnable c = null;
    private static String d = null;
    private static int e = 1;
    private Dialog f;

    public static void a(Context context, String str, Runnable runnable, int i) {
        d = str;
        c = runnable;
        e = i;
        Intent intent = new Intent(context, (Class<?>) RewardExitConfirmDialogActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View viewInflate = LayoutInflater.from(this).inflate(q.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_continue", "id"));
            textView2.setText(getResources().getString(q.a(this, "myoffer_reward_exit_confirm_give_up", "string")));
            if (e == 2) {
                textView.setText(getResources().getString(q.a(this, "myoffer_anim_reward_exit_confirm_msg", "string"), d));
                textView3.setText(getResources().getString(q.a(this, "myoffer_anim_reward_exit_confirm_continue", "string")));
            } else {
                textView.setText(getResources().getString(q.a(this, "myoffer_reward_exit_confirm_msg", "string"), d));
                textView3.setText(getResources().getString(q.a(this, "myoffer_reward_exit_confirm_continue", "string")));
            }
            textView2.setOnClickListener(new AnonymousClass1());
            textView3.setOnClickListener(new AnonymousClass2());
            Dialog dialog = new Dialog(this, q.a(this, "style_full_screen_translucent_dialog", "style"));
            this.f = dialog;
            dialog.setContentView(viewInflate);
            this.f.setCancelable(false);
            this.f.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    private void b() {
        try {
            View viewInflate = LayoutInflater.from(this).inflate(q.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(q.a(this, "myoffer_confirm_continue", "id"));
            textView2.setText(getResources().getString(q.a(this, "myoffer_reward_exit_confirm_give_up", "string")));
            if (e == 2) {
                textView.setText(getResources().getString(q.a(this, "myoffer_anim_reward_exit_confirm_msg", "string"), d));
                textView3.setText(getResources().getString(q.a(this, "myoffer_anim_reward_exit_confirm_continue", "string")));
            } else {
                textView.setText(getResources().getString(q.a(this, "myoffer_reward_exit_confirm_msg", "string"), d));
                textView3.setText(getResources().getString(q.a(this, "myoffer_reward_exit_confirm_continue", "string")));
            }
            textView2.setOnClickListener(new AnonymousClass1());
            textView3.setOnClickListener(new AnonymousClass2());
            Dialog dialog = new Dialog(this, q.a(this, "style_full_screen_translucent_dialog", "style"));
            this.f = dialog;
            dialog.setContentView(viewInflate);
            this.f.setCancelable(false);
            this.f.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RewardExitConfirmDialogActivity.this.finish();
            if (RewardExitConfirmDialogActivity.c != null) {
                RewardExitConfirmDialogActivity.c.run();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RewardExitConfirmDialogActivity.this.finish();
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
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.dismiss();
            this.f = null;
        }
        c = null;
        super.onDestroy();
    }
}
