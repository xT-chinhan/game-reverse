package com.byazt.ht;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.byazt.rz.cp;
import com.byazt.z.d;
import com.byazt.z.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 21})
public class x extends com.byazt.z.n {
    public static String n = "x";

    @Override // com.byazt.z.n, com.byazt.z.q
    public oa n(Context context) {
        return new oa(context) { // from class: com.byazt.ht.x.1
            public DialogInterface.OnClickListener l;
            public final /* synthetic */ Context n;
            public DialogInterface.OnClickListener q;
            public com.byazt.os.qg.n s;
            public DialogInterface.OnCancelListener w;

            {
                this.n = context;
                this.s = new com.byazt.os.qg.n(context);
            }

            @Override // com.byazt.z.oa
            public oa n(CharSequence charSequence) {
                this.s.n((String) charSequence);
                return this;
            }

            @Override // com.byazt.z.oa
            public oa n(String str) {
                this.s.qg(str);
                return this;
            }

            @Override // com.byazt.z.oa
            public oa n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.s.s((String) charSequence);
                this.q = onClickListener;
                return this;
            }

            @Override // com.byazt.z.oa
            public oa qg(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.s.q((String) charSequence);
                this.l = onClickListener;
                return this;
            }

            @Override // com.byazt.z.oa
            public oa n(DialogInterface.OnCancelListener onCancelListener) {
                this.w = onCancelListener;
                return this;
            }

            @Override // com.byazt.z.oa
            public oa n(boolean z) {
                this.s.n(z);
                return this;
            }

            @Override // com.byazt.z.oa
            public d n() {
                this.s.n(new com.byazt.os.qg.InterfaceC0286qg() { // from class: com.byazt.ht.x.1.1
                    @Override // com.byazt.os.qg.InterfaceC0286qg
                    public void n(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.q != null) {
                            AnonymousClass1.this.q.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.byazt.os.qg.InterfaceC0286qg
                    public void qg(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.l != null) {
                            AnonymousClass1.this.l.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.byazt.os.qg.InterfaceC0286qg
                    public void s(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.w == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.w.onCancel(dialogInterface);
                    }
                });
                cp.n(x.n, "getThemedAlertDlgBuilder", null);
                this.s.n(3);
                return new n(com.byazt.ug.d.s().qg(this.s.n()));
            }
        };
    }

    @com.byazt.cp.n(n = {0, 1, 1169, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static class n implements d {
        public Dialog n;

        public n(Dialog dialog) {
            if (dialog != null) {
                this.n = dialog;
                n();
            }
        }

        @Override // com.byazt.z.d
        public void n() {
            Dialog dialog = this.n;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.byazt.z.d
        public boolean qg() {
            Dialog dialog = this.n;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }
}
