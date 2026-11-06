package com.bytedance.sdk.component.widget.recycler.ms.xr;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ka<K, V> {
    static Object[] ah;
    static int d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static Object[] f1424ms;
    static int xr;
    int[] ka = xr.f1425ms;
    Object[] c = xr.ah;
    int ab = 0;

    private static int ms(int[] iArr, int i, int i2) {
        try {
            return xr.ms(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    int ms(Object obj, int i) {
        int i2 = this.ab;
        if (i2 == 0) {
            return -1;
        }
        int iMs = ms(this.ka, i2, i);
        if (iMs < 0 || obj.equals(this.c[iMs << 1])) {
            return iMs;
        }
        int i3 = iMs + 1;
        while (i3 < i2 && this.ka[i3] == i) {
            if (obj.equals(this.c[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iMs - 1; i4 >= 0 && this.ka[i4] == i; i4--) {
            if (obj.equals(this.c[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    int ms() {
        int i = this.ab;
        if (i == 0) {
            return -1;
        }
        int iMs = ms(this.ka, i, 0);
        if (iMs < 0 || this.c[iMs << 1] == null) {
            return iMs;
        }
        int i2 = iMs + 1;
        while (i2 < i && this.ka[i2] == 0) {
            if (this.c[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iMs - 1; i3 >= 0 && this.ka[i3] == 0; i3--) {
            if (this.c[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void d(int i) {
        if (i == 8) {
            synchronized (ms.class) {
                Object[] objArr = ah;
                if (objArr != null) {
                    this.c = objArr;
                    ah = (Object[]) objArr[0];
                    this.ka = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ms.class) {
                Object[] objArr2 = f1424ms;
                if (objArr2 != null) {
                    this.c = objArr2;
                    f1424ms = (Object[]) objArr2[0];
                    this.ka = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    xr--;
                    return;
                }
            }
        }
        this.ka = new int[i];
        this.c = new Object[i << 1];
    }

    private static void ms(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ms.class) {
                if (d < 10) {
                    objArr[0] = ah;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    ah = objArr;
                    d++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ms.class) {
                if (xr < 10) {
                    objArr[0] = f1424ms;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1424ms = objArr;
                    xr++;
                }
            }
        }
    }

    public void clear() {
        int i = this.ab;
        if (i > 0) {
            int[] iArr = this.ka;
            Object[] objArr = this.c;
            this.ka = xr.f1425ms;
            this.c = xr.ah;
            this.ab = 0;
            ms(iArr, objArr, i);
        }
        if (this.ab > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return ms(obj) >= 0;
    }

    public int ms(Object obj) {
        return obj == null ? ms() : ms(obj, obj.hashCode());
    }

    int xr(Object obj) {
        int i = this.ab * 2;
        Object[] objArr = this.c;
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
        return xr(obj) >= 0;
    }

    public V get(Object obj) {
        int iMs = ms(obj);
        if (iMs >= 0) {
            return (V) this.c[(iMs << 1) + 1];
        }
        return null;
    }

    public K ms(int i) {
        return (K) this.c[i << 1];
    }

    public V xr(int i) {
        return (V) this.c[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.ab <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iMs;
        int i2 = this.ab;
        if (k == null) {
            iMs = ms();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iMs = ms(k, iHashCode);
        }
        if (iMs >= 0) {
            int i3 = (iMs << 1) + 1;
            Object[] objArr = this.c;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iMs;
        int[] iArr = this.ka;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.c;
            d(i5);
            if (i2 != this.ab) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.ka;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.c, 0, objArr2.length);
            }
            ms(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.ka;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.ab - i4) << 1);
        }
        int i7 = this.ab;
        if (i2 == i7) {
            int[] iArr4 = this.ka;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.c;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.ab = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iMs = ms(obj);
        if (iMs >= 0) {
            return ah(iMs);
        }
        return null;
    }

    public V ah(int i) {
        Object[] objArr = this.c;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.ab;
        int i4 = 0;
        if (i3 <= 1) {
            ms(this.ka, objArr, i3);
            this.ka = xr.f1425ms;
            this.c = xr.ah;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.ka;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                d(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.ab) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.ka, 0, i);
                    System.arraycopy(objArr, 0, this.c, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.ka, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.c, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.c;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 != this.ab) {
            throw new ConcurrentModificationException();
        }
        this.ab = i4;
        return v;
    }

    public int size() {
        return this.ab;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ka) {
            ka kaVar = (ka) obj;
            if (size() != kaVar.size()) {
                return false;
            }
            for (int i = 0; i < this.ab; i++) {
                try {
                    K kMs = ms(i);
                    V vXr = xr(i);
                    Object obj2 = kaVar.get(kMs);
                    if (vXr == null) {
                        if (obj2 != null || !kaVar.containsKey(kMs)) {
                            return false;
                        }
                    } else if (!vXr.equals(obj2)) {
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
        for (int i2 = 0; i2 < this.ab; i2++) {
            try {
                K kMs2 = ms(i2);
                V vXr2 = xr(i2);
                Object obj3 = map.get(kMs2);
                if (vXr2 == null) {
                    if (obj3 != null || !map.containsKey(kMs2)) {
                        return false;
                    }
                } else if (!vXr2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.ka;
        Object[] objArr = this.c;
        int i = this.ab;
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
        StringBuilder sb = new StringBuilder(this.ab * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.ab; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kMs = ms(i);
            if (kMs != this) {
                sb.append(kMs);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vXr = xr(i);
            if (vXr != this) {
                sb.append(vXr);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
