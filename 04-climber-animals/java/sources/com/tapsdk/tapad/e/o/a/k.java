package com.tapsdk.tapad.e.o.a;

import com.tapsdk.tapad.constants.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    private int a;
    private String b;

    public static class b {
        int a = -1;
        String b = Constants.l.b;

        public b a(int i) {
            this.a = i;
            return this;
        }

        public b a(String str) {
            this.b = str;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }

    private k(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.a;
    }
}
