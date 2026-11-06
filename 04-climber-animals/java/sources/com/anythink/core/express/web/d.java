package com.anythink.core.express.web;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class d implements a {
    @Override // com.anythink.core.express.web.a
    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        scheme.equals("intent");
        return false;
    }
}
