package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
class SupportInfo {
    String a;
    Boolean b;

    SupportInfo() {
    }

    void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    boolean a() {
        return this.b != null;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }

    void b(String str) {
        this.a = str;
    }

    boolean b() {
        if (this.b != null) {
            return this.b.booleanValue();
        }
        return false;
    }
}
