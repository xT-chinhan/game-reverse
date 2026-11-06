package com.byazt.ip;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1625, 18})
public class l<K, V> {
    public static Object[] n;
    public static int q;
    public static int qg;
    public static Object[] s;
    public int[] l = qg.n;
    public Object[] w = qg.s;
    public int x = 0;

    private static int n(int[] iArr, int i, int i2) {
        try {
            return qg.n(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int n(Object obj, int i) {
        int i2 = this.x;
        if (i2 == 0) {
            return -1;
        }
        int iN = n(this.l, i2, i);
        if (iN < 0 || obj.equals(this.w[iN << 1])) {
            return iN;
        }
        int i3 = iN + 1;
        while (i3 < i2 && this.l[i3] == i) {
            if (obj.equals(this.w[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iN - 1; i4 >= 0 && this.l[i4] == i; i4--) {
            if (obj.equals(this.w[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public int n() {
        int i = this.x;
        if (i == 0) {
            return -1;
        }
        int iN = n(this.l, i, 0);
        if (iN < 0 || this.w[iN << 1] == null) {
            return iN;
        }
        int i2 = iN + 1;
        while (i2 < i && this.l[i2] == 0) {
            if (this.w[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iN - 1; i3 >= 0 && this.l[i3] == 0; i3--) {
            if (this.w[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void q(int i) {
        if (i == 8) {
            synchronized (n.class) {
                Object[] objArr = s;
                if (objArr != null) {
                    this.w = objArr;
                    s = (Object[]) objArr[0];
                    this.l = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    q--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (n.class) {
                Object[] objArr2 = n;
                if (objArr2 != null) {
                    this.w = objArr2;
                    n = (Object[]) objArr2[0];
                    this.l = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    qg--;
                    return;
                }
            }
        }
        this.l = new int[i];
        this.w = new Object[i << 1];
    }

    private static void n(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (n.class) {
                if (q < 10) {
                    objArr[0] = s;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    s = objArr;
                    q++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (n.class) {
                if (qg < 10) {
                    objArr[0] = n;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    n = objArr;
                    qg++;
                }
            }
        }
    }

    public void clear() {
        int i = this.x;
        if (i > 0) {
            int[] iArr = this.l;
            Object[] objArr = this.w;
            this.l = qg.n;
            this.w = qg.s;
            this.x = 0;
            n(iArr, objArr, i);
        }
        if (this.x > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return n(obj) >= 0;
    }

    public int n(Object obj) {
        return obj == null ? n() : n(obj, obj.hashCode());
    }

    public int qg(Object obj) {
        int i = this.x * 2;
        Object[] objArr = this.w;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return qg(obj) >= 0;
    }

    public V get(Object obj) {
        int iN = n(obj);
        if (iN >= 0) {
            return (V) this.w[(iN << 1) + 1];
        }
        return null;
    }

    public K n(int i) {
        return (K) this.w[i << 1];
    }

    public V qg(int i) {
        return (V) this.w[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.x <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iN;
        int i2 = this.x;
        if (k == null) {
            iN = n();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iN = n(k, iHashCode);
        }
        if (iN >= 0) {
            int i3 = (iN << 1) + 1;
            Object[] objArr = this.w;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iN;
        int[] iArr = this.l;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.w;
            q(i5);
            if (i2 != this.x) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.l;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.w, 0, objArr2.length);
            }
            n(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.l;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.w;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.x - i4) << 1);
        }
        int i7 = this.x;
        if (i2 == i7) {
            int[] iArr4 = this.l;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.w;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.x = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iN = n(obj);
        if (iN >= 0) {
            return s(iN);
        }
        return null;
    }

    public V s(int i) {
        Object[] objArr = this.w;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.x;
        int i4 = 0;
        if (i3 <= 1) {
            n(this.l, objArr, i3);
            this.l = qg.n;
            this.w = qg.s;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.l;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                q(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.x) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.l, 0, i);
                    System.arraycopy(objArr, 0, this.w, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.l, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.w, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.w;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.w;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 != this.x) {
            throw new ConcurrentModificationException();
        }
        this.x = i4;
        return v;
    }

    public int size() {
        return this.x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (size() != lVar.size()) {
                return false;
            }
            for (int i = 0; i < this.x; i++) {
                try {
                    K kN = n(i);
                    V vQg = qg(i);
                    Object obj2 = lVar.get(kN);
                    if (vQg == null) {
                        if (obj2 != null || !lVar.containsKey(kN)) {
                            return false;
                        }
                    } else if (!vQg.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.x; i2++) {
            try {
                K kN2 = n(i2);
                V vQg2 = qg(i2);
                Object obj3 = map.get(kN2);
                if (vQg2 == null) {
                    if (obj3 != null || !map.containsKey(kN2)) {
                        return false;
                    }
                } else if (!vQg2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.l;
        Object[] objArr = this.w;
        int i = this.x;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.x * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.x; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kN = n(i);
            if (kN != this) {
                sb.append(kN);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vQg = qg(i);
            if (vQg != this) {
                sb.append(vQg);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
