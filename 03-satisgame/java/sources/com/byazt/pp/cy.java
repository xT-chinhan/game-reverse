package com.byazt.pp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public abstract class cy<K, V> {
    public cy<K, V>.qg qg;

    public abstract int n();

    public abstract int n(Object obj);

    public abstract Object n(int i, int i2);

    public abstract void n(int i);

    public abstract Map<K, V> qg();

    public abstract void s();

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 1086})
    final class n<T> implements Iterator<T> {
        public final int n;
        public boolean q = false;
        public int qg;
        public int s;

        public n(int i) {
            this.n = i;
            this.qg = cy.this.n();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.s < this.qg;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) cy.this.n(this.s, this.n);
            this.s++;
            this.q = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.q) {
                throw new IllegalStateException();
            }
            int i = this.s - 1;
            this.s = i;
            this.qg--;
            this.q = false;
            cy.this.n(i);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 2092})
    final class qg implements Set<K> {
        public qg() {
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
            cy.this.s();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return cy.this.n(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return cy.n(cy.this.qg(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return cy.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new n(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iN = cy.this.n(obj);
            if (iN < 0) {
                return false;
            }
            cy.this.n(iN);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return cy.qg(cy.this.qg(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return cy.s(cy.this.qg(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return cy.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return cy.this.qg(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) cy.this.n(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return cy.n(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iN = cy.this.n() - 1; iN >= 0; iN--) {
                Object objN = cy.this.n(iN, 0);
                iHashCode += objN == null ? 0 : objN.hashCode();
            }
            return iHashCode;
        }
    }

    public static <K, V> boolean n(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean qg(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean s(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] qg(int i) {
        int iN = n();
        Object[] objArr = new Object[iN];
        for (int i2 = 0; i2 < iN; i2++) {
            objArr[i2] = n(i2, i);
        }
        return objArr;
    }

    public <T> T[] n(T[] tArr, int i) {
        int iN = n();
        if (tArr.length < iN) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iN));
        }
        for (int i2 = 0; i2 < iN; i2++) {
            tArr[i2] = n(i2, i);
        }
        if (tArr.length > iN) {
            tArr[iN] = null;
        }
        return tArr;
    }

    public static <T> boolean n(Set<T> set, Object obj) {
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

    public Set<K> q() {
        if (this.qg == null) {
            this.qg = new qg();
        }
        return this.qg;
    }
}
