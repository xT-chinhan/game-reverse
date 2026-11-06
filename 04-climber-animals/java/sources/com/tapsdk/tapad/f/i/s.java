package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
class s implements com.tapsdk.tapad.f.b {
    private final Context a;
    private Class<?> b;
    private Object c;

    public s(Context context) {
        this.a = context;
    }

    private String b() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String str = (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.a);
        return TextUtils.isEmpty(str) ? (String) this.b.getMethod("getAAID", Context.class).invoke(this.c, this.a) : str;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        if (this.b == null || this.c == null) {
            aVar.a(new com.tapsdk.tapad.f.c("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new com.tapsdk.tapad.f.c("OAID query failed");
            }
            aVar.a(strB);
        } catch (Exception e) {
            aVar.a(e);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Xiaomi";
    }
}
