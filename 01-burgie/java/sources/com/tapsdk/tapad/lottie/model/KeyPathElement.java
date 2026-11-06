package com.tapsdk.tapad.lottie.model;

import com.tapsdk.tapad.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2);
}
