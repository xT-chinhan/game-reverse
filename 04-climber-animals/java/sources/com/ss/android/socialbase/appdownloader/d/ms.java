package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.ah.hi;
import com.ss.android.socialbase.appdownloader.ah.sl;

/* JADX INFO: loaded from: classes3.dex */
public class ms extends com.ss.android.socialbase.appdownloader.ah.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AlertDialog.Builder f4577ms;

    public ms(Context context) {
        this.f4577ms = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.sl
    public sl ms(int i) {
        AlertDialog.Builder builder = this.f4577ms;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.sl
    public sl ms(String str) {
        AlertDialog.Builder builder = this.f4577ms;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.sl
    public sl ms(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f4577ms;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.sl
    public sl xr(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f4577ms;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.sl
    public sl ms(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f4577ms;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.sl
    public hi ms() {
        return new C0546ms(this.f4577ms);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.d.ms$ms, reason: collision with other inner class name */
    private static class C0546ms implements hi {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private AlertDialog f4578ms;

        public C0546ms(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f4578ms = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.ah.hi
        public void ms() {
            AlertDialog alertDialog = this.f4578ms;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.ah.hi
        public boolean xr() {
            AlertDialog alertDialog = this.f4578ms;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }
}
