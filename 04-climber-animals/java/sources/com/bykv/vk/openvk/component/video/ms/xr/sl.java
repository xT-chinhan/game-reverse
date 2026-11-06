package com.bykv.vk.openvk.component.video.ms.xr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Set<String> f104ms = new HashSet();
    private static final Set<String> xr = new HashSet();
    private final int ab;
    private final ArrayList<ms> ah;
    private int c;
    private final int d;
    private int ka = -1;

    sl(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.d = size;
        this.ah = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            ms msVar = new ms(str);
            if (f104ms.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(msVar);
            } else if (xr.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(msVar);
            } else {
                this.ah.add(msVar);
            }
        }
        if (arrayList != null) {
            this.ah.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.ah.addAll(arrayList2);
        }
        Integer num = ka.ny;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.d >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.ab = iIntValue;
    }

    sl(String str) {
        ArrayList<ms> arrayList = new ArrayList<>(1);
        this.ah = arrayList;
        arrayList.add(new ms(str));
        this.d = 1;
        this.ab = 1;
    }

    boolean ms() {
        return this.c < this.ab;
    }

    ms xr() {
        if (!ms()) {
            throw new NoSuchElementException();
        }
        int i = this.ka + 1;
        if (i >= this.d - 1) {
            this.ka = -1;
            this.c++;
        } else {
            this.ka = i;
        }
        ms msVar = this.ah.get(i);
        msVar.xr = (this.c * this.d) + this.ka;
        return msVar;
    }

    public class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final String f105ms;
        int xr;

        ms(String str) {
            this.f105ms = str;
        }

        void ms() {
            sl.f104ms.add(this.f105ms);
        }

        void xr() {
            sl.xr.add(this.f105ms);
        }

        public String toString() {
            return this.f105ms;
        }
    }
}
