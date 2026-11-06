package com.bytedance.sdk.component.widget.recycler.ms.xr;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ah<E> implements Cloneable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Object f1422ms = new Object();
    private long[] ah;
    private Object[] d;
    private int ka;
    private boolean xr;

    public ah() {
        this(10);
    }

    public ah(int i) {
        this.xr = false;
        if (i == 0) {
            this.ah = xr.xr;
            this.d = xr.ah;
        } else {
            int iMs = xr.ms(i);
            this.ah = new long[iMs];
            this.d = new Object[iMs];
        }
        this.ka = 0;
    }

    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ah<E> clone() {
        try {
            ah<E> ahVar = (ah) super.clone();
            ahVar.ah = (long[]) this.ah.clone();
            ahVar.d = (Object[]) this.d.clone();
            return ahVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E ms(long j) {
        return ms(j, null);
    }

    public E ms(long j, E e) {
        E e2;
        int iMs = xr.ms(this.ah, this.ka, j);
        return (iMs < 0 || (e2 = (E) this.d[iMs]) == f1422ms) ? e : e2;
    }

    public void delete(long j) {
        int iMs = xr.ms(this.ah, this.ka, j);
        if (iMs >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[iMs];
            Object obj2 = f1422ms;
            if (obj != obj2) {
                objArr[iMs] = obj2;
                this.xr = true;
            }
        }
    }

    public void ms(int i) {
        Object[] objArr = this.d;
        Object obj = objArr[i];
        Object obj2 = f1422ms;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.xr = true;
        }
    }

    private void d() {
        int i = this.ka;
        long[] jArr = this.ah;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1422ms) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.xr = false;
        this.ka = i2;
    }

    public void xr(long j, E e) {
        int iMs = xr.ms(this.ah, this.ka, j);
        if (iMs >= 0) {
            this.d[iMs] = e;
            return;
        }
        int i = ~iMs;
        int i2 = this.ka;
        if (i < i2) {
            Object[] objArr = this.d;
            if (objArr[i] == f1422ms) {
                this.ah[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.xr && i2 >= this.ah.length) {
            d();
            i = ~xr.ms(this.ah, this.ka, j);
        }
        int i3 = this.ka;
        if (i3 >= this.ah.length) {
            int iMs2 = xr.ms(i3 + 1);
            long[] jArr = new long[iMs2];
            Object[] objArr2 = new Object[iMs2];
            long[] jArr2 = this.ah;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.ah = jArr;
            this.d = objArr2;
        }
        int i4 = this.ka;
        if (i4 - i != 0) {
            long[] jArr3 = this.ah;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i5, this.ka - i);
        }
        this.ah[i] = j;
        this.d[i] = e;
        this.ka++;
    }

    public int xr() {
        if (this.xr) {
            d();
        }
        return this.ka;
    }

    public long xr(int i) {
        if (this.xr) {
            d();
        }
        return this.ah[i];
    }

    public E ah(int i) {
        if (this.xr) {
            d();
        }
        return (E) this.d[i];
    }

    public void ah() {
        int i = this.ka;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.ka = 0;
        this.xr = false;
    }

    public String toString() {
        if (xr() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.ka * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.ka; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(xr(i));
            sb.append('=');
            E eAh = ah(i);
            if (eAh != this) {
                sb.append(eAh);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
