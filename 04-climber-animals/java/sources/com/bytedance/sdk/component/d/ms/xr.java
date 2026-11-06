package com.bytedance.sdk.component.d.ms;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface xr extends SharedPreferences {

    public interface ms<T> {
        void ms(T t);
    }

    void ms();

    void ms(ms<Map<String, ?>> msVar);

    void ms(String str);

    void ms(String str, float f);

    void ms(String str, int i);

    void ms(String str, long j);

    void ms(String str, String str2);

    void ms(String str, Set<String> set);

    void ms(String str, boolean z);

    float xr(String str, float f);

    int xr(String str, int i);

    long xr(String str, long j);

    String xr(String str, String str2);

    Set<String> xr(String str, Set<String> set);

    void xr();

    boolean xr(String str, boolean z);
}
