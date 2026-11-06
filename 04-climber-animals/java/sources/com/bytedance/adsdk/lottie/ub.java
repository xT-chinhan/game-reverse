package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class ub<K, V> {
    ub<K, V>.xr xr;

    protected abstract void ah();

    protected abstract int ms();

    protected abstract int ms(Object obj);

    protected abstract Object ms(int i, int i2);

    protected abstract void ms(int i);

    protected abstract Map<K, V> xr();

    ub() {
    }

    final class ms<T> implements Iterator<T> {
        int ah;
        boolean d = false;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final int f274ms;
        int xr;

        ms(int i) {
            this.f274ms = i;
            this.xr = ub.this.ms();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.ah < this.xr;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) ub.this.ms(this.ah, this.f274ms);
            this.ah++;
            this.d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            int i = this.ah - 1;
            this.ah = i;
            this.xr--;
            this.d = false;
            ub.this.ms(i);
        }
    }

    final class xr implements Set<K> {
        xr() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            ub.this.ah();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return ub.this.ms(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return ub.ms(ub.this.xr(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return ub.this.ms() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ms(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iMs = ub.this.ms(obj);
            if (iMs < 0) {
                return false;
            }
            ub.this.ms(iMs);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return ub.xr(ub.this.xr(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return ub.ah(ub.this.xr(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return ub.this.ms();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return ub.this.xr(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ub.this.ms(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return ub.ms(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMs = ub.this.ms() - 1; iMs >= 0; iMs--) {
                Object objMs = ub.this.ms(iMs, 0);
                iHashCode += objMs == null ? 0 : objMs.hashCode();
            }
            return iHashCode;
        }
    }

    public static <K, V> boolean ms(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean xr(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean ah(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] xr(int i) {
        int iMs = ms();
        Object[] objArr = new Object[iMs];
        for (int i2 = 0; i2 < iMs; i2++) {
            objArr[i2] = ms(i2, i);
        }
        return objArr;
    }

    public <T> T[] ms(T[] tArr, int i) {
        int iMs = ms();
        if (tArr.length < iMs) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iMs));
        }
        for (int i2 = 0; i2 < iMs; i2++) {
            tArr[i2] = ms(i2, i);
        }
        if (tArr.length > iMs) {
            tArr[iMs] = null;
        }
        return tArr;
    }

    public static <T> boolean ms(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<K> d() {
        if (this.xr == null) {
            this.xr = new xr();
        }
        return this.xr;
    }
}
