package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    private String a;
    private String b;
    private int c;

    public i(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    private String b() {
        return this.a;
    }

    public final String a() {
        return this.b;
    }

    private int c() {
        return this.c;
    }

    public final boolean a(bv bvVar) {
        if (bvVar != null) {
            int i = bvVar.a;
            if (i != 2) {
                return i == 3 && bvVar.g() == this.c;
            }
            return bvVar.z().equals(this.a);
        }
        return false;
    }
}
