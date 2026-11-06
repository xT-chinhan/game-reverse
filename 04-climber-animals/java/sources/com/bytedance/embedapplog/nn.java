package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class nn<SERVICE> implements pl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f507ms;
    private ce<Boolean> xr = new ce<Boolean>() { // from class: com.bytedance.embedapplog.nn.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.ce
        /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
        public Boolean ms(Object... objArr) {
            return Boolean.valueOf(kl.ms((Context) objArr[0], nn.this.f507ms));
        }
    };

    protected abstract Intent ah(Context context);

    protected abstract ch.xr<SERVICE, String> ms();

    nn(String str) {
        this.f507ms = str;
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        if (context == null) {
            return false;
        }
        return this.xr.xr(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        return ms((String) new ch(context, ah(context), ms()).ms());
    }

    private pl.ms ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        pl.ms msVar = new pl.ms();
        msVar.xr = str;
        return msVar;
    }
}
