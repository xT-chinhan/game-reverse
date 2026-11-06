package com.umeng.analytics.pro;

import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dl;
import java.io.Serializable;

/* JADX INFO: compiled from: TBase.java */
/* JADX INFO: loaded from: classes4.dex */
public interface de<T extends de<?, ?>, F extends dl> extends Serializable {
    void clear();

    de<T, F> deepCopy();

    F fieldForId(int i);

    void read(ed edVar) throws dk;

    void write(ed edVar) throws dk;
}
