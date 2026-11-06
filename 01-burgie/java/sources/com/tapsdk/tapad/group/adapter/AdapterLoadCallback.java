package com.tapsdk.tapad.group.adapter;

import com.tapsdk.tapad.group.adapter.AdapterAdSession;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterLoadCallback<S extends AdapterAdSession> {
    void onFailure(int i, String str);

    void onSuccess(List<S> list);
}
