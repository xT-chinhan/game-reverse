package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class qo extends nn<tk> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final r f515ms;
    final nl xr;

    @Override // com.bytedance.embedapplog.nn, com.bytedance.embedapplog.pl
    public /* bridge */ /* synthetic */ boolean ms(Context context) {
        return super.ms(context);
    }

    qo() {
        super("com.hihonor.id");
        this.f515ms = new r();
        this.xr = new nl();
    }

    @Override // com.bytedance.embedapplog.nn
    protected ch.xr<tk, String> ms() {
        return new ch.xr<tk, String>() { // from class: com.bytedance.embedapplog.qo.1
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public tk ms(IBinder iBinder) {
                return tk.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public String ms(tk tkVar) {
                if (tkVar == null) {
                    com.bytedance.sdk.component.utils.sl.d("honor# ", "service is null");
                    return null;
                }
                tkVar.ms(qo.this.f515ms);
                tkVar.xr(qo.this.xr);
                return "";
            }
        };
    }

    @Override // com.bytedance.embedapplog.nn
    protected Intent ah(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.nn, com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        new ch(context, ah(context), ms()).ms();
        pl.ms msVar = new pl.ms();
        msVar.xr = this.f515ms.xr();
        msVar.ah = this.xr.xr();
        return msVar;
    }
}
