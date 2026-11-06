package com.byazt.dx;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 37})
public final class pr<E> implements Collection<E>, Set<E> {
    public static Object[] c;
    public static Object[] fw;
    public static int uc;
    public static int zo;
    public int[] aj;
    public int hw;
    public Object[] pr;
    public nt<E, E> vk;
    public static final int[] hn = new int[0];
    public static final Object[] x = new Object[0];

    private int pr(Object obj, int i) {
        int i2 = this.hw;
        if (i2 == 0) {
            return -1;
        }
        int iPr = hw.pr(this.aj, i2, i);
        if (iPr < 0 || obj.equals(this.pr[iPr])) {
            return iPr;
        }
        int i3 = iPr + 1;
        while (i3 < i2 && this.aj[i3] == i) {
            if (obj.equals(this.pr[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iPr - 1; i4 >= 0 && this.aj[i4] == i; i4--) {
            if (obj.equals(this.pr[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int pr() {
        int i = this.hw;
        if (i == 0) {
            return -1;
        }
        int iPr = hw.pr(this.aj, i, 0);
        if (iPr < 0 || this.pr[iPr] == null) {
            return iPr;
        }
        int i2 = iPr + 1;
        while (i2 < i && this.aj[i2] == 0) {
            if (this.pr[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iPr - 1; i3 >= 0 && this.aj[i3] == 0; i3--) {
            if (this.pr[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void x(int i) {
        if (i == 8) {
            synchronized (pr.class) {
                Object[] objArr = fw;
                if (objArr != null) {
                    this.pr = objArr;
                    fw = (Object[]) objArr[0];
                    this.aj = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    zo--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (pr.class) {
                Object[] objArr2 = c;
                if (objArr2 != null) {
                    this.pr = objArr2;
                    c = (Object[]) objArr2[0];
                    this.aj = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    uc--;
                    return;
                }
            }
        }
        this.aj = new int[i];
        this.pr = new Object[i];
    }

    private static void pr(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (pr.class) {
                if (zo < 10) {
                    objArr[0] = fw;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    fw = objArr;
                    zo++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (pr.class) {
                if (uc < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    c = objArr;
                    uc++;
                }
            }
        }
    }

    public pr() {
        this(0);
    }

    public pr(int i) {
        if (i == 0) {
            this.aj = hn;
            this.pr = x;
        } else {
            x(i);
        }
        this.hw = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.hw;
        if (i != 0) {
            pr(this.aj, this.pr, i);
            this.aj = hn;
            this.pr = x;
            this.hw = 0;
        }
    }

    public void pr(int i) {
        int[] iArr = this.aj;
        if (iArr.length < i) {
            Object[] objArr = this.pr;
            x(i);
            int i2 = this.hw;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.aj, 0, i2);
                System.arraycopy(objArr, 0, this.pr, 0, this.hw);
            }
            pr(iArr, objArr, this.hw);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return pr(obj) >= 0;
    }

    public int pr(Object obj) {
        return obj == null ? pr() : pr(obj, obj.hashCode());
    }

    public E hw(int i) {
        return (E) this.pr[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.hw <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iPr;
        if (e == null) {
            iPr = pr();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iPr = pr(e, iHashCode);
        }
        if (iPr >= 0) {
            return false;
        }
        int i2 = ~iPr;
        int i3 = this.hw;
        int[] iArr = this.aj;
        if (i3 >= iArr.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            Object[] objArr = this.pr;
            x(i4);
            int[] iArr2 = this.aj;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.pr, 0, objArr.length);
            }
            pr(iArr, objArr, this.hw);
        }
        int i5 = this.hw;
        if (i2 < i5) {
            int[] iArr3 = this.aj;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.pr;
            System.arraycopy(objArr2, i2, objArr2, i6, this.hw - i2);
        }
        this.aj[i2] = i;
        this.pr[i2] = e;
        this.hw++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iPr = pr(obj);
        if (iPr >= 0) {
            hn(iPr);
            return true;
        }
        return false;
    }

    public E hn(int i) {
        Object[] objArr = this.pr;
        E e = (E) objArr[i];
        int i2 = this.hw;
        if (i2 <= 1) {
            pr(this.aj, objArr, i2);
            this.aj = hn;
            this.pr = x;
            this.hw = 0;
        } else {
            int[] iArr = this.aj;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                x(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.hw--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.aj, 0, i);
                    System.arraycopy(objArr, 0, this.pr, 0, i);
                }
                int i3 = this.hw;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.aj, i, i3 - i);
                    System.arraycopy(objArr, i4, this.pr, i, this.hw - i);
                }
            } else {
                int i5 = i2 - 1;
                this.hw = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.pr;
                    System.arraycopy(objArr2, i6, objArr2, i, this.hw - i);
                }
                this.pr[this.hw] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.hw;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.hw;
        Object[] objArr = new Object[i];
        System.arraycopy(this.pr, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.hw) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.hw));
        }
        System.arraycopy(this.pr, 0, tArr, 0, this.hw);
        int length = tArr.length;
        int i = this.hw;
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
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        for (int i = 0; i < this.hw; i++) {
            try {
                if (!set.contains(hw(i))) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.aj;
        int i = this.hw;
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
        StringBuilder sb = new StringBuilder(this.hw * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.hw; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eHw = hw(i);
            if (eHw != this) {
                sb.append(eHw);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private nt<E, E> hw() {
        if (this.vk == null) {
            this.vk = new nt<E, E>() { // from class: com.byazt.dx.pr.1
                @Override // com.byazt.dx.nt
                public int pr() {
                    return pr.this.hw;
                }

                @Override // com.byazt.dx.nt
                public Object pr(int i, int i2) {
                    return pr.this.pr[i];
                }

                @Override // com.byazt.dx.nt
                public int pr(Object obj) {
                    return pr.this.pr(obj);
                }

                @Override // com.byazt.dx.nt
                public Map<E, E> hw() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.byazt.dx.nt
                public void pr(int i) {
                    pr.this.hn(i);
                }

                @Override // com.byazt.dx.nt
                public void hn() {
                    pr.this.clear();
                }
            };
        }
        return this.vk;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return hw().x().iterator();
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
        pr(this.hw + collection.size());
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
        for (int i = this.hw - 1; i >= 0; i--) {
            if (!collection.contains(this.pr[i])) {
                hn(i);
                z = true;
            }
        }
        return z;
    }
}
