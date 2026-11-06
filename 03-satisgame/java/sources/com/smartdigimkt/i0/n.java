package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public z a;
    public int b;
    public boolean c;
    public int d;

    public final void a(int i) {
        if (!this.c || this.d == 4) {
            this.c = true;
            this.d = i;
        } else if (i != 4) {
            throw new IllegalArgumentException();
        }
    }
}
