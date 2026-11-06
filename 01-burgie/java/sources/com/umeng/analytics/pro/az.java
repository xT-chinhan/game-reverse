package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class az {
    private final bv a;
    private final ci b;

    public az() {
        this(new bp.a());
    }

    public az(bx bxVar) {
        this.b = new ci();
        this.a = bxVar.a(this.b);
    }

    public void a(aw awVar, byte[] bArr) throws bc {
        try {
            this.b.a(bArr);
            awVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(aw awVar, String str, String str2) throws bc {
        try {
            try {
                a(awVar, str.getBytes(str2));
                this.a.B();
            } catch (UnsupportedEncodingException e) {
                throw new bc("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } catch (Throwable th) {
            this.a.B();
            throw th;
        }
    }

    public void a(aw awVar, byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        try {
            try {
                if (j(bArr, bdVar, bdVarArr) != null) {
                    awVar.read(this.a);
                }
                this.b.e();
                this.a.B();
            } catch (Exception e) {
                throw new bc(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    public Boolean a(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Boolean) a((byte) 2, bArr, bdVar, bdVarArr);
    }

    public Byte b(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Byte) a((byte) 3, bArr, bdVar, bdVarArr);
    }

    public Double c(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Double) a((byte) 4, bArr, bdVar, bdVarArr);
    }

    public Short d(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Short) a((byte) 6, bArr, bdVar, bdVarArr);
    }

    public Integer e(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Integer) a((byte) 8, bArr, bdVar, bdVarArr);
    }

    public Long f(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Long) a((byte) 10, bArr, bdVar, bdVarArr);
    }

    public String g(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (String) a((byte) 11, bArr, bdVar, bdVarArr);
    }

    public ByteBuffer h(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (ByteBuffer) a((byte) 100, bArr, bdVar, bdVarArr);
    }

    public Short i(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        Short shValueOf;
        try {
            try {
                if (j(bArr, bdVar, bdVarArr) != null) {
                    this.a.j();
                    shValueOf = Short.valueOf(this.a.l().c);
                } else {
                    shValueOf = null;
                }
                this.b.e();
                this.a.B();
                return shValueOf;
            } catch (Exception e) {
                throw new bc(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x009a  */
    private Object a(byte b, byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        Object objValueOf;
        try {
            try {
                bq bqVarJ = j(bArr, bdVar, bdVarArr);
                if (bqVarJ != null) {
                    if (b != 6) {
                        if (b != 8) {
                            if (b != 100) {
                                switch (b) {
                                    case 2:
                                        if (bqVarJ.b == 2) {
                                            objValueOf = Boolean.valueOf(this.a.t());
                                        } else {
                                            objValueOf = null;
                                        }
                                        break;
                                    case 3:
                                        if (bqVarJ.b == 3) {
                                            objValueOf = Byte.valueOf(this.a.u());
                                        } else {
                                            objValueOf = null;
                                        }
                                        break;
                                    case 4:
                                        if (bqVarJ.b == 4) {
                                            objValueOf = Double.valueOf(this.a.y());
                                        } else {
                                            objValueOf = null;
                                        }
                                        break;
                                    default:
                                        switch (b) {
                                            case 10:
                                                if (bqVarJ.b == 10) {
                                                    objValueOf = Long.valueOf(this.a.x());
                                                } else {
                                                    objValueOf = null;
                                                }
                                                break;
                                            case 11:
                                                if (bqVarJ.b == 11) {
                                                    objValueOf = this.a.z();
                                                } else {
                                                    objValueOf = null;
                                                }
                                                break;
                                            default:
                                                objValueOf = null;
                                                break;
                                        }
                                        break;
                                }
                            } else if (bqVarJ.b == 11) {
                                objValueOf = this.a.A();
                            } else {
                                objValueOf = null;
                            }
                        } else if (bqVarJ.b == 8) {
                            objValueOf = Integer.valueOf(this.a.w());
                        } else {
                            objValueOf = null;
                        }
                    } else if (bqVarJ.b == 6) {
                        objValueOf = Short.valueOf(this.a.v());
                    } else {
                        objValueOf = null;
                    }
                } else {
                    objValueOf = null;
                }
                this.b.e();
                this.a.B();
                return objValueOf;
            } catch (Exception e) {
                throw new bc(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    private bq j(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        this.b.a(bArr);
        bd[] bdVarArr2 = new bd[bdVarArr.length + 1];
        int i = 0;
        bdVarArr2[0] = bdVar;
        int i2 = 0;
        while (i2 < bdVarArr.length) {
            int i3 = i2 + 1;
            bdVarArr2[i3] = bdVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        bq bqVarL = null;
        while (i < bdVarArr2.length) {
            bqVarL = this.a.l();
            if (bqVarL.b == 0 || bqVarL.c > bdVarArr2[i].a()) {
                return null;
            }
            if (bqVarL.c != bdVarArr2[i].a()) {
                by.a(this.a, bqVarL.b);
                this.a.m();
            } else {
                i++;
                if (i < bdVarArr2.length) {
                    this.a.j();
                }
            }
        }
        return bqVarL;
    }

    public void a(aw awVar, String str) throws bc {
        a(awVar, str.getBytes());
    }
}
