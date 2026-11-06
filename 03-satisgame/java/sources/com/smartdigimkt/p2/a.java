package com.smartdigimkt.p2;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Throwable {
    public a(Exception exc) {
        super(exc);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return getCause() != null ? a.class.getName() + ": " + getCause() : super.toString();
    }
}
