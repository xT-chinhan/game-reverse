package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: classes4.dex */
public class dd extends dk {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final ei j = new ei("TApplicationException");
    private static final dy k = new dy("message", (byte) 11, 1);
    private static final dy l = new dy("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public dd() {
        this.i = 0;
    }

    public dd(int i) {
        this.i = i;
    }

    public dd(int i, String str) {
        super(str);
        this.i = i;
    }

    public dd(String str) {
        super(str);
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public static dd a(ed edVar) throws dk {
        edVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            dy dyVarL = edVar.l();
            if (dyVarL.b != 0) {
                short s = dyVarL.c;
                if (s != 1) {
                    if (s == 2) {
                        if (dyVarL.b == 8) {
                            iW = edVar.w();
                        } else {
                            eg.a(edVar, dyVarL.b);
                        }
                    } else {
                        eg.a(edVar, dyVarL.b);
                    }
                } else if (dyVarL.b == 11) {
                    strZ = edVar.z();
                } else {
                    eg.a(edVar, dyVarL.b);
                }
                edVar.m();
            } else {
                edVar.k();
                return new dd(iW, strZ);
            }
        }
    }

    public void b(ed edVar) throws dk {
        edVar.a(j);
        if (getMessage() != null) {
            edVar.a(k);
            edVar.a(getMessage());
            edVar.c();
        }
        edVar.a(l);
        edVar.a(this.i);
        edVar.c();
        edVar.d();
        edVar.b();
    }
}
