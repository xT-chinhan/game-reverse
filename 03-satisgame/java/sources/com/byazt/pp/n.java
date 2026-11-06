package com.byazt.pp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 19})
public final class n<E> implements Collection<E>, Set<E> {
    public static int fs;
    public static Object[] l;
    public static int w;
    public static Object[] x;
    public Object[] n;
    public int qg;
    public int[] rv;
    public cy<E, E> tj;
    public static final int[] s = new int[0];
    public static final Object[] q = new Object[0];

    private int n(Object obj, int i) {
        int i2 = this.qg;
        if (i2 == 0) {
            return -1;
        }
        int iN = qg.n(this.rv, i2, i);
        if (iN < 0 || obj.equals(this.n[iN])) {
            return iN;
        }
        int i3 = iN + 1;
        while (i3 < i2 && this.rv[i3] == i) {
            if (obj.equals(this.n[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iN - 1; i4 >= 0 && this.rv[i4] == i; i4--) {
            if (obj.equals(this.n[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int n() {
        int i = this.qg;
        if (i == 0) {
            return -1;
        }
        int iN = qg.n(this.rv, i, 0);
        if (iN < 0 || this.n[iN] == null) {
            return iN;
        }
        int i2 = iN + 1;
        while (i2 < i && this.rv[i2] == 0) {
            if (this.n[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iN - 1; i3 >= 0 && this.rv[i3] == 0; i3--) {
            if (this.n[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void q(int i) {
        if (i == 8) {
            synchronized (n.class) {
                Object[] objArr = x;
                if (objArr != null) {
                    this.n = objArr;
                    x = (Object[]) objArr[0];
                    this.rv = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    fs--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (n.class) {
                Object[] objArr2 = l;
                if (objArr2 != null) {
                    this.n = objArr2;
                    l = (Object[]) objArr2[0];
                    this.rv = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    w--;
                    return;
                }
            }
        }
        this.rv = new int[i];
        this.n = new Object[i];
    }

    private static void n(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (n.class) {
                if (fs < 10) {
                    objArr[0] = x;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    x = objArr;
                    fs++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (n.class) {
                if (w < 10) {
                    objArr[0] = l;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    l = objArr;
                    w++;
                }
            }
        }
    }

    public n() {
        this(0);
    }

    public n(int i) {
        if (i == 0) {
            this.rv = s;
            this.n = q;
        } else {
            q(i);
        }
        this.qg = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.qg;
        if (i != 0) {
            n(this.rv, this.n, i);
            this.rv = s;
            this.n = q;
            this.qg = 0;
        }
    }

    public void n(int i) {
        int[] iArr = this.rv;
        if (iArr.length < i) {
            Object[] objArr = this.n;
            q(i);
            int i2 = this.qg;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.rv, 0, i2);
                System.arraycopy(objArr, 0, this.n, 0, this.qg);
            }
            n(iArr, objArr, this.qg);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return n(obj) >= 0;
    }

    public int n(Object obj) {
        return obj == null ? n() : n(obj, obj.hashCode());
    }

    public E qg(int i) {
        return (E) this.n[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.qg <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iN;
        if (e == null) {
            iN = n();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iN = n(e, iHashCode);
        }
        if (iN >= 0) {
            return false;
        }
        int i2 = ~iN;
        int i3 = this.qg;
        int[] iArr = this.rv;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.n;
            q(i4);
            int[] iArr2 = this.rv;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.n, 0, objArr.length);
            }
            n(iArr, objArr, this.qg);
        }
        int i5 = this.qg;
        if (i2 < i5) {
            int[] iArr3 = this.rv;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.n;
            System.arraycopy(objArr2, i2, objArr2, i6, this.qg - i2);
        }
        this.rv[i2] = i;
        this.n[i2] = e;
        this.qg++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iN = n(obj);
        if (iN < 0) {
            return false;
        }
        s(iN);
        return true;
    }

    public E s(int i) {
        Object[] objArr = this.n;
        E e = (E) objArr[i];
        int i2 = this.qg;
        if (i2 <= 1) {
            n(this.rv, objArr, i2);
            this.rv = s;
            this.n = q;
            this.qg = 0;
        } else {
            int[] iArr = this.rv;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                q(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.qg--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.rv, 0, i);
                    System.arraycopy(objArr, 0, this.n, 0, i);
                }
                int i3 = this.qg;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.rv, i, i3 - i);
                    System.arraycopy(objArr, i4, this.n, i, this.qg - i);
                }
            } else {
                int i5 = i2 - 1;
                this.qg = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.n;
                    System.arraycopy(objArr2, i6, objArr2, i, this.qg - i);
                }
                this.n[this.qg] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.qg;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.qg;
        Object[] objArr = new Object[i];
        System.arraycopy(this.n, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.qg) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.qg));
        }
        System.arraycopy(this.n, 0, tArr, 0, this.qg);
        int length = tArr.length;
        int i = this.qg;
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
            for (int i = 0; i < this.qg; i++) {
                try {
                    if (!set.contains(qg(i))) {
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
        int[] iArr = this.rv;
        int i = this.qg;
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
        StringBuilder sb = new StringBuilder(this.qg * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.qg; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eQg = qg(i);
            if (eQg != this) {
                sb.append(eQg);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private cy<E, E> qg() {
        if (this.tj == null) {
            this.tj = new cy<E, E>() { // from class: com.byazt.pp.n.1
                @Override // com.byazt.pp.cy
                public int n() {
                    return n.this.qg;
                }

                @Override // com.byazt.pp.cy
                public Object n(int i, int i2) {
                    return n.this.n[i];
                }

                @Override // com.byazt.pp.cy
                public int n(Object obj) {
                    return n.this.n(obj);
                }

                @Override // com.byazt.pp.cy
                public Map<E, E> qg() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.byazt.pp.cy
                public void n(int i) {
                    n.this.s(i);
                }

                @Override // com.byazt.pp.cy
                public void s() {
                    n.this.clear();
                }
            };
        }
        return this.tj;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return qg().q().iterator();
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
        n(this.qg + collection.size());
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
        for (int i = this.qg - 1; i >= 0; i--) {
            if (!collection.contains(this.n[i])) {
                s(i);
                z = true;
            }
        }
        return z;
    }
}
