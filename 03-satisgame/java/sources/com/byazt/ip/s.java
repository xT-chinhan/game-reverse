package com.byazt.ip;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1625, 8})
public class s<E> implements Cloneable {
    public static final Object n = new Object();
    public int l;
    public Object[] q;
    public boolean qg;
    public long[] s;

    public s() {
        this(10);
    }

    public s(int i) {
        this.qg = false;
        if (i == 0) {
            this.s = qg.qg;
            this.q = qg.s;
        } else {
            int iN = qg.n(i);
            this.s = new long[iN];
            this.q = new Object[iN];
        }
        this.l = 0;
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public s<E> clone() {
        try {
            s<E> sVar = (s) super.clone();
            sVar.s = (long[]) this.s.clone();
            sVar.q = (Object[]) this.q.clone();
            return sVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E n(long j) {
        return n(j, null);
    }

    public E n(long j, E e) {
        E e2;
        int iN = qg.n(this.s, this.l, j);
        return (iN < 0 || (e2 = (E) this.q[iN]) == n) ? e : e2;
    }

    public void delete(long j) {
        int iN = qg.n(this.s, this.l, j);
        if (iN >= 0) {
            Object[] objArr = this.q;
            Object obj = objArr[iN];
            Object obj2 = n;
            if (obj != obj2) {
                objArr[iN] = obj2;
                this.qg = true;
            }
        }
    }

    public void n(int i) {
        Object[] objArr = this.q;
        Object obj = objArr[i];
        Object obj2 = n;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.qg = true;
        }
    }

    private void q() {
        int i = this.l;
        long[] jArr = this.s;
        Object[] objArr = this.q;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != n) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.qg = false;
        this.l = i2;
    }

    public void qg(long j, E e) {
        int iN = qg.n(this.s, this.l, j);
        if (iN >= 0) {
            this.q[iN] = e;
            return;
        }
        int i = ~iN;
        int i2 = this.l;
        if (i < i2) {
            Object[] objArr = this.q;
            if (objArr[i] == n) {
                this.s[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.qg && i2 >= this.s.length) {
            q();
            i = ~qg.n(this.s, this.l, j);
        }
        int i3 = this.l;
        if (i3 >= this.s.length) {
            int iN2 = qg.n(i3 + 1);
            long[] jArr = new long[iN2];
            Object[] objArr2 = new Object[iN2];
            long[] jArr2 = this.s;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.q;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.s = jArr;
            this.q = objArr2;
        }
        int i4 = this.l;
        if (i4 - i != 0) {
            long[] jArr3 = this.s;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.q;
            System.arraycopy(objArr4, i, objArr4, i5, this.l - i);
        }
        this.s[i] = j;
        this.q[i] = e;
        this.l++;
    }

    public int qg() {
        if (this.qg) {
            q();
        }
        return this.l;
    }

    public long qg(int i) {
        if (this.qg) {
            q();
        }
        return this.s[i];
    }

    public E s(int i) {
        if (this.qg) {
            q();
        }
        return (E) this.q[i];
    }

    public void s() {
        int i = this.l;
        Object[] objArr = this.q;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.l = 0;
        this.qg = false;
    }

    public String toString() {
        if (qg() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.l * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.l; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(qg(i));
            sb.append('=');
            E eS = s(i);
            if (eS != this) {
                sb.append(eS);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
