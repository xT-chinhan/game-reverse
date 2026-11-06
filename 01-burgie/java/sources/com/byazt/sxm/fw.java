package com.byazt.sxm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.byazt.uk.w;
import com.byazt.zkm.k;
import com.byazt.zkm.m;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, 62})
public class fw extends com.byazt.zkm.pr {
    public static String pr = fw.class.getSimpleName();

    @Override // com.byazt.zkm.pr, com.byazt.zkm.x
    public m pr(Context context) {
        return new m(context) { // from class: com.byazt.sxm.fw.1
            public DialogInterface.OnClickListener c;
            public com.byazt.cxa.hw.pr hn;
            public final /* synthetic */ Context pr;
            public DialogInterface.OnCancelListener uc;
            public DialogInterface.OnClickListener x;

            {
                this.pr = context;
                this.hn = new com.byazt.cxa.hw.pr(context);
            }

            @Override // com.byazt.zkm.m
            public m pr(CharSequence charSequence) {
                this.hn.pr((String) charSequence);
                return this;
            }

            @Override // com.byazt.zkm.m
            public m pr(String str) {
                this.hn.hw(str);
                return this;
            }

            @Override // com.byazt.zkm.m
            public m pr(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.hn.hn((String) charSequence);
                this.x = onClickListener;
                return this;
            }

            @Override // com.byazt.zkm.m
            public m hw(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.hn.x((String) charSequence);
                this.c = onClickListener;
                return this;
            }

            @Override // com.byazt.zkm.m
            public m pr(DialogInterface.OnCancelListener onCancelListener) {
                this.uc = onCancelListener;
                return this;
            }

            @Override // com.byazt.zkm.m
            public m pr(boolean z) {
                this.hn.pr(z);
                return this;
            }

            @Override // com.byazt.zkm.m
            public k pr() {
                this.hn.pr(new com.byazt.cxa.hw.InterfaceC0036hw() { // from class: com.byazt.sxm.fw.1.1
                    @Override // com.byazt.cxa.hw.InterfaceC0036hw
                    public void pr(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.x != null) {
                            AnonymousClass1.this.x.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.byazt.cxa.hw.InterfaceC0036hw
                    public void hw(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.c != null) {
                            AnonymousClass1.this.c.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.byazt.cxa.hw.InterfaceC0036hw
                    public void hn(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.uc != null && dialogInterface != null) {
                            AnonymousClass1.this.uc.onCancel(dialogInterface);
                        }
                    }
                });
                w.pr(fw.pr, "getThemedAlertDlgBuilder", null);
                this.hn.pr(3);
                return new pr(com.byazt.eld.k.hn().hw(this.hn.pr()));
            }
        };
    }

    @com.byazt.vzx.pr(pr = {0, 1, 448, 766})
    private static class pr implements k {
        public Dialog pr;

        public pr(Dialog dialog) {
            if (dialog != null) {
                this.pr = dialog;
                pr();
            }
        }

        @Override // com.byazt.zkm.k
        public void pr() {
            Dialog dialog = this.pr;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.byazt.zkm.k
        public boolean hw() {
            Dialog dialog = this.pr;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }
}
