package com.anythink.basead.exoplayer;

/* JADX INFO: loaded from: classes.dex */
public final class aa {
    public static final aa a = new aa(0);
    public final int b;

    public aa(int i) {
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.b == ((aa) obj).b;
    }

    public final int hashCode() {
        return this.b;
    }
}
