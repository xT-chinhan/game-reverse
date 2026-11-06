package com.byazt.fz;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1569, 20})
public class hn<E> implements Cloneable {
    public static final Object pr = new Object();
    public int c;
    public long[] hn;
    public boolean hw;
    public Object[] x;

    public hn() {
        this(10);
    }

    public hn(int i) {
        this.hw = false;
        if (i == 0) {
            this.hn = hw.hw;
            this.x = hw.hn;
        } else {
            int iPr = hw.pr(i);
            this.hn = new long[iPr];
            this.x = new Object[iPr];
        }
        this.c = 0;
    }

    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public hn<E> clone() {
        try {
            hn<E> hnVar = (hn) super.clone();
            hnVar.hn = (long[]) this.hn.clone();
            hnVar.x = (Object[]) this.x.clone();
            return hnVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E pr(long j) {
        return pr(j, null);
    }

    public E pr(long j, E e) {
        E e2;
        int iPr = hw.pr(this.hn, this.c, j);
        return (iPr < 0 || (e2 = (E) this.x[iPr]) == pr) ? e : e2;
    }

    public void delete(long j) {
        int iPr = hw.pr(this.hn, this.c, j);
        if (iPr >= 0) {
            Object[] objArr = this.x;
            Object obj = objArr[iPr];
            Object obj2 = pr;
            if (obj != obj2) {
                objArr[iPr] = obj2;
                this.hw = true;
            }
        }
    }

    public void pr(int i) {
        Object[] objArr = this.x;
        Object obj = objArr[i];
        Object obj2 = pr;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.hw = true;
        }
    }

    private void x() {
        int i = this.c;
        long[] jArr = this.hn;
        Object[] objArr = this.x;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != pr) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.hw = false;
        this.c = i2;
    }

    public void hw(long j, E e) {
        int iPr = hw.pr(this.hn, this.c, j);
        if (iPr >= 0) {
            this.x[iPr] = e;
            return;
        }
        int i = ~iPr;
        int i2 = this.c;
        if (i < i2) {
            Object[] objArr = this.x;
            if (objArr[i] == pr) {
                this.hn[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.hw && i2 >= this.hn.length) {
            x();
            i = ~hw.pr(this.hn, this.c, j);
        }
        int i3 = this.c;
        if (i3 >= this.hn.length) {
            int iPr2 = hw.pr(i3 + 1);
            long[] jArr = new long[iPr2];
            Object[] objArr2 = new Object[iPr2];
            long[] jArr2 = this.hn;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.x;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.hn = jArr;
            this.x = objArr2;
        }
        int i4 = this.c;
        if (i4 - i != 0) {
            long[] jArr3 = this.hn;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.x;
            System.arraycopy(objArr4, i, objArr4, i5, this.c - i);
        }
        this.hn[i] = j;
        this.x[i] = e;
        this.c++;
    }

    public int hw() {
        if (this.hw) {
            x();
        }
        return this.c;
    }

    public long hw(int i) {
        if (this.hw) {
            x();
        }
        return this.hn[i];
    }

    public E hn(int i) {
        if (this.hw) {
            x();
        }
        return (E) this.x[i];
    }

    public void hn() {
        int i = this.c;
        Object[] objArr = this.x;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.c = 0;
        this.hw = false;
    }

    public String toString() {
        if (hw() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(hw(i));
            sb.append('=');
            E eHn = hn(i);
            if (eHn != this) {
                sb.append(eHn);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
