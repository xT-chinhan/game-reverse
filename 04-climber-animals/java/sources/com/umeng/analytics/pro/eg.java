package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class eg {
    private static int a = Integer.MAX_VALUE;

    public static void a(int i) {
        a = i;
    }

    public static void a(ed edVar, byte b) throws dk {
        a(edVar, b, a);
    }

    public static void a(ed edVar, byte b, int i) throws dk {
        if (i <= 0) {
            throw new dk("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                edVar.t();
                return;
            case 3:
                edVar.u();
                return;
            case 4:
                edVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                edVar.v();
                return;
            case 8:
                edVar.w();
                return;
            case 10:
                edVar.x();
                return;
            case 11:
                edVar.A();
                return;
            case 12:
                edVar.j();
                while (true) {
                    dy dyVarL = edVar.l();
                    if (dyVarL.b != 0) {
                        a(edVar, dyVarL.b, i - 1);
                        edVar.m();
                    } else {
                        edVar.k();
                        return;
                    }
                }
                break;
            case 13:
                ea eaVarN = edVar.n();
                while (i2 < eaVarN.c) {
                    int i3 = i - 1;
                    a(edVar, eaVarN.a, i3);
                    a(edVar, eaVarN.b, i3);
                    i2++;
                }
                edVar.o();
                return;
            case 14:
                eh ehVarR = edVar.r();
                while (i2 < ehVarR.b) {
                    a(edVar, ehVarR.a, i - 1);
                    i2++;
                }
                edVar.s();
                return;
            case 15:
                dz dzVarP = edVar.p();
                while (i2 < dzVarP.b) {
                    a(edVar, dzVarP.a, i - 1);
                    i2++;
                }
                edVar.q();
                return;
        }
    }

    public static ef a(byte[] bArr, ef efVar) {
        if (bArr[0] > 16) {
            return new dx.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? efVar : new dx.a();
    }
}
