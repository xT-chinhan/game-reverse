package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
class ci extends j {
    final /* synthetic */ ca.c b;
    final /* synthetic */ Handler c;
    final /* synthetic */ ca d;

    ci(ca caVar, ca.c cVar, Handler handler) {
        this.d = caVar;
        this.b = cVar;
        this.c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        try {
            try {
                synchronized (ca.class) {
                    try {
                        this.d.b(this.b, this.c);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                SharedPreferences.Editor editorEdit = this.d.m().edit();
                editorEdit.putString(ca.d, this.d.a());
                editorEdit.apply();
                return null;
            } catch (Throwable th2) {
                try {
                    this.d.z.a(ca.a, "Load APK Failed: " + th2.toString());
                    this.d.b(false);
                    SharedPreferences.Editor editorEdit2 = this.d.m().edit();
                    editorEdit2.putString(ca.d, this.d.a());
                    editorEdit2.apply();
                    return null;
                } catch (Throwable th3) {
                    try {
                        SharedPreferences.Editor editorEdit3 = this.d.m().edit();
                        editorEdit3.putString(ca.d, this.d.a());
                        editorEdit3.apply();
                    } catch (Throwable th4) {
                        this.d.z.a(ca.a, th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            this.d.z.a(ca.a, th5);
            return null;
        }
    }
}
