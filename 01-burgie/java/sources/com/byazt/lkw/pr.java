package com.byazt.lkw;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.byazt.zkm.k;
import com.byazt.zkm.m;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 970, 37})
public class pr extends com.byazt.zkm.hw {
    public AlertDialog.Builder pr;

    public pr(Context context) {
        this.pr = new AlertDialog.Builder(context);
    }

    @Override // com.byazt.zkm.m
    public m pr(CharSequence charSequence) {
        AlertDialog.Builder builder = this.pr;
        if (builder != null) {
            builder.setTitle(charSequence);
        }
        return this;
    }

    @Override // com.byazt.zkm.m
    public m pr(String str) {
        AlertDialog.Builder builder = this.pr;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.byazt.zkm.m
    public m pr(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.pr;
        if (builder != null) {
            builder.setPositiveButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.byazt.zkm.m
    public m hw(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.pr;
        if (builder != null) {
            builder.setNegativeButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.byazt.zkm.m
    public m pr(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.pr;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.byazt.zkm.m
    public k pr() {
        return new C0123pr(this.pr);
    }

    /* JADX INFO: renamed from: com.byazt.lkw.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 970, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0123pr implements k {
        public AlertDialog pr;

        public C0123pr(AlertDialog.Builder builder) {
            if (builder != null) {
                this.pr = builder.show();
            }
        }

        @Override // com.byazt.zkm.k
        public void pr() {
            AlertDialog alertDialog = this.pr;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.byazt.zkm.k
        public boolean hw() {
            AlertDialog alertDialog = this.pr;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }
}
