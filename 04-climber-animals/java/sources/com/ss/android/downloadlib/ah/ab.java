package com.ss.android.downloadlib.ah;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.ah.hi;
import com.ss.android.socialbase.appdownloader.ah.sl;

/* JADX INFO: loaded from: classes3.dex */
public class ab extends com.ss.android.socialbase.appdownloader.ah.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4465ms = "ab";

    @Override // com.ss.android.socialbase.appdownloader.ah.ms, com.ss.android.socialbase.appdownloader.ah.ah
    public sl ms(Context context) {
        return new sl(context) { // from class: com.ss.android.downloadlib.ah.ab.1
            private com.ss.android.download.api.model.xr.ms ah;
            private DialogInterface.OnCancelListener c;
            private DialogInterface.OnClickListener d;
            private DialogInterface.OnClickListener ka;

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            final /* synthetic */ Context f4466ms;

            {
                this.f4466ms = context;
                this.ah = new com.ss.android.download.api.model.xr.ms(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public sl ms(int i) {
                this.ah.ms(this.f4466ms.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public sl ms(String str) {
                this.ah.xr(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public sl ms(int i, DialogInterface.OnClickListener onClickListener) {
                this.ah.ah(this.f4466ms.getResources().getString(i));
                this.d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public sl xr(int i, DialogInterface.OnClickListener onClickListener) {
                this.ah.d(this.f4466ms.getResources().getString(i));
                this.ka = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public sl ms(DialogInterface.OnCancelListener onCancelListener) {
                this.c = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public sl ms(boolean z) {
                this.ah.ms(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ah.sl
            public hi ms() {
                this.ah.ms(new com.ss.android.download.api.model.xr.InterfaceC0531xr() { // from class: com.ss.android.downloadlib.ah.ab.1.1
                    @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
                    public void ms(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.d != null) {
                            AnonymousClass1.this.d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
                    public void xr(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.ka != null) {
                            AnonymousClass1.this.ka.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
                    public void ah(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.c == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.c.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.ab.hi.ms(ab.f4465ms, "getThemedAlertDlgBuilder", null);
                this.ah.ms(3);
                return new ms(com.ss.android.downloadlib.addownload.hi.ah().xr(this.ah.ms()));
            }
        };
    }

    private static class ms implements hi {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Dialog f4468ms;

        public ms(Dialog dialog) {
            if (dialog != null) {
                this.f4468ms = dialog;
                ms();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.ah.hi
        public void ms() {
            Dialog dialog = this.f4468ms;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.ah.hi
        public boolean xr() {
            Dialog dialog = this.f4468ms;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }
}
