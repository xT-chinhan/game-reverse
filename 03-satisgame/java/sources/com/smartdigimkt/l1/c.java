package com.smartdigimkt.l1;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new SimpleDateFormat("yyyyMMdd", Locale.US);
    }
}
