package com.byazt.n;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.byazt.z.d;
import com.byazt.z.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 19, 19})
public class n extends com.byazt.z.qg {
    public AlertDialog.Builder n;

    public n(Context context) {
        this.n = new AlertDialog.Builder(context);
    }

    @Override // com.byazt.z.oa
    public oa n(CharSequence charSequence) {
        AlertDialog.Builder builder = this.n;
        if (builder != null) {
            builder.setTitle(charSequence);
        }
        return this;
    }

    @Override // com.byazt.z.oa
    public oa n(String str) {
        AlertDialog.Builder builder = this.n;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.byazt.z.oa
    public oa n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.n;
        if (builder != null) {
            builder.setPositiveButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.byazt.z.oa
    public oa qg(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.n;
        if (builder != null) {
            builder.setNegativeButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.byazt.z.oa
    public oa n(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.n;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.byazt.z.oa
    public d n() {
        return new C0255n(this.n);
    }

    /* JADX INFO: renamed from: com.byazt.n.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 19, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0255n implements d {
        public AlertDialog n;

        public C0255n(AlertDialog.Builder builder) {
            if (builder != null) {
                this.n = builder.show();
            }
        }

        @Override // com.byazt.z.d
        public void n() {
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.byazt.z.d
        public boolean qg() {
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }
}
