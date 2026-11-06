package com.byazt.dx;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 74})
public abstract class nt<K, V> {
    public nt<K, V>.hw hw;

    public abstract void hn();

    public abstract Map<K, V> hw();

    public abstract int pr();

    public abstract int pr(Object obj);

    public abstract Object pr(int i, int i2);

    public abstract void pr(int i);

    @com.byazt.vzx.pr(pr = {0, 1, 229, 350})
    final class pr<T> implements Iterator<T> {
        public int hn;
        public int hw;
        public final int pr;
        public boolean x = false;

        public pr(int i) {
            this.pr = i;
            this.hw = nt.this.pr();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hn < this.hw;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) nt.this.pr(this.hn, this.pr);
            this.hn++;
            this.x = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.x) {
                throw new IllegalStateException();
            }
            int i = this.hn - 1;
            this.hn = i;
            this.hw--;
            this.x = false;
            nt.this.pr(i);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, 1803})
    final class hw implements Set<K> {
        public hw() {
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
            nt.this.hn();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return nt.this.pr(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return nt.pr(nt.this.hw(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return nt.this.pr() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new pr(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iPr = nt.this.pr(obj);
            if (iPr >= 0) {
                nt.this.pr(iPr);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return nt.hw(nt.this.hw(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return nt.hn(nt.this.hw(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return nt.this.pr();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return nt.this.hw(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) nt.this.pr(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return nt.pr(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iPr = nt.this.pr() - 1; iPr >= 0; iPr--) {
                Object objPr = nt.this.pr(iPr, 0);
                iHashCode += objPr == null ? 0 : objPr.hashCode();
            }
            return iHashCode;
        }
    }

    public static <K, V> boolean pr(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean hw(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean hn(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] hw(int i) {
        int iPr = pr();
        Object[] objArr = new Object[iPr];
        for (int i2 = 0; i2 < iPr; i2++) {
            objArr[i2] = pr(i2, i);
        }
        return objArr;
    }

    public <T> T[] pr(T[] tArr, int i) {
        int iPr = pr();
        if (tArr.length < iPr) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iPr));
        }
        for (int i2 = 0; i2 < iPr; i2++) {
            tArr[i2] = pr(i2, i);
        }
        if (tArr.length > iPr) {
            tArr[iPr] = null;
        }
        return tArr;
    }

    public static <T> boolean pr(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public Set<K> x() {
        if (this.hw == null) {
            this.hw = new hw();
        }
        return this.hw;
    }
}
