package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ms<E> implements Collection<E>, Set<E> {
    private static Object[] ab;
    private static int c;
    private static Object[] ka;
    private static int x;
    private ub<E, E> ch;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Object[] f241ms;
    private int[] ny;
    int xr;
    private static final int[] ah = new int[0];
    private static final Object[] d = new Object[0];

    private int ms(Object obj, int i) {
        int i2 = this.xr;
        if (i2 == 0) {
            return -1;
        }
        int iMs = xr.ms(this.ny, i2, i);
        if (iMs < 0 || obj.equals(this.f241ms[iMs])) {
            return iMs;
        }
        int i3 = iMs + 1;
        while (i3 < i2 && this.ny[i3] == i) {
            if (obj.equals(this.f241ms[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iMs - 1; i4 >= 0 && this.ny[i4] == i; i4--) {
            if (obj.equals(this.f241ms[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int ms() {
        int i = this.xr;
        if (i == 0) {
            return -1;
        }
        int iMs = xr.ms(this.ny, i, 0);
        if (iMs < 0 || this.f241ms[iMs] == null) {
            return iMs;
        }
        int i2 = iMs + 1;
        while (i2 < i && this.ny[i2] == 0) {
            if (this.f241ms[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iMs - 1; i3 >= 0 && this.ny[i3] == 0; i3--) {
            if (this.f241ms[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void d(int i) {
        if (i == 8) {
            synchronized (ms.class) {
                Object[] objArr = ab;
                if (objArr != null) {
                    this.f241ms = objArr;
                    ab = (Object[]) objArr[0];
                    this.ny = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    x--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ms.class) {
                Object[] objArr2 = ka;
                if (objArr2 != null) {
                    this.f241ms = objArr2;
                    ka = (Object[]) objArr2[0];
                    this.ny = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.ny = new int[i];
        this.f241ms = new Object[i];
    }

    private static void ms(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ms.class) {
                if (x < 10) {
                    objArr[0] = ab;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    ab = objArr;
                    x++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ms.class) {
                if (c < 10) {
                    objArr[0] = ka;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    ka = objArr;
                    c++;
                }
            }
        }
    }

    public ms() {
        this(0);
    }

    public ms(int i) {
        if (i == 0) {
            this.ny = ah;
            this.f241ms = d;
        } else {
            d(i);
        }
        this.xr = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.xr;
        if (i != 0) {
            ms(this.ny, this.f241ms, i);
            this.ny = ah;
            this.f241ms = d;
            this.xr = 0;
        }
    }

    public void ms(int i) {
        int[] iArr = this.ny;
        if (iArr.length < i) {
            Object[] objArr = this.f241ms;
            d(i);
            int i2 = this.xr;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.ny, 0, i2);
                System.arraycopy(objArr, 0, this.f241ms, 0, this.xr);
            }
            ms(iArr, objArr, this.xr);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return ms(obj) >= 0;
    }

    public int ms(Object obj) {
        return obj == null ? ms() : ms(obj, obj.hashCode());
    }

    public E xr(int i) {
        return (E) this.f241ms[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.xr <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iMs;
        if (e == null) {
            iMs = ms();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iMs = ms(e, iHashCode);
        }
        if (iMs >= 0) {
            return false;
        }
        int i2 = ~iMs;
        int i3 = this.xr;
        int[] iArr = this.ny;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.f241ms;
            d(i4);
            int[] iArr2 = this.ny;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f241ms, 0, objArr.length);
            }
            ms(iArr, objArr, this.xr);
        }
        int i5 = this.xr;
        if (i2 < i5) {
            int[] iArr3 = this.ny;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f241ms;
            System.arraycopy(objArr2, i2, objArr2, i6, this.xr - i2);
        }
        this.ny[i2] = i;
        this.f241ms[i2] = e;
        this.xr++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iMs = ms(obj);
        if (iMs < 0) {
            return false;
        }
        ah(iMs);
        return true;
    }

    public E ah(int i) {
        Object[] objArr = this.f241ms;
        E e = (E) objArr[i];
        int i2 = this.xr;
        if (i2 <= 1) {
            ms(this.ny, objArr, i2);
            this.ny = ah;
            this.f241ms = d;
            this.xr = 0;
        } else {
            int[] iArr = this.ny;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                d(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.xr--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.ny, 0, i);
                    System.arraycopy(objArr, 0, this.f241ms, 0, i);
                }
                int i3 = this.xr;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.ny, i, i3 - i);
                    System.arraycopy(objArr, i4, this.f241ms, i, this.xr - i);
                }
            } else {
                int i5 = i2 - 1;
                this.xr = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.f241ms;
                    System.arraycopy(objArr2, i6, objArr2, i, this.xr - i);
                }
                this.f241ms[this.xr] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.xr;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.xr;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f241ms, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.xr) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.xr));
        }
        System.arraycopy(this.f241ms, 0, tArr, 0, this.xr);
        int length = tArr.length;
        int i = this.xr;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.xr; i++) {
                try {
                    if (!set.contains(xr(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.ny;
        int i = this.xr;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.xr * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.xr; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eXr = xr(i);
            if (eXr != this) {
                sb.append(eXr);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private ub<E, E> xr() {
        if (this.ch == null) {
            this.ch = new ub<E, E>() { // from class: com.bytedance.adsdk.lottie.ms.1
                @Override // com.bytedance.adsdk.lottie.ub
                protected int ms() {
                    return ms.this.xr;
                }

                @Override // com.bytedance.adsdk.lottie.ub
                protected Object ms(int i, int i2) {
                    return ms.this.f241ms[i];
                }

                @Override // com.bytedance.adsdk.lottie.ub
                protected int ms(Object obj) {
                    return ms.this.ms(obj);
                }

                @Override // com.bytedance.adsdk.lottie.ub
                protected Map<E, E> xr() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.ub
                protected void ms(int i) {
                    ms.this.ah(i);
                }

                @Override // com.bytedance.adsdk.lottie.ub
                protected void ah() {
                    ms.this.clear();
                }
            };
        }
        return this.ch;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return xr().d().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ms(this.xr + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.xr - 1; i >= 0; i--) {
            if (!collection.contains(this.f241ms[i])) {
                ah(i);
                z = true;
            }
        }
        return z;
    }
}
