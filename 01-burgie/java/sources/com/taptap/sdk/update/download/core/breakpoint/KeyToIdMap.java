package com.taptap.sdk.update.download.core.breakpoint;

import android.util.SparseArray;
import com.taptap.sdk.update.download.DownloadTask;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class KeyToIdMap {
    private final SparseArray<String> idToKeyMap;
    private final HashMap<String, Integer> keyToIdMap;

    KeyToIdMap() {
        this(new HashMap(), new SparseArray());
    }

    KeyToIdMap(HashMap<String, Integer> keyToIdMap, SparseArray<String> idToKeyMap) {
        this.keyToIdMap = keyToIdMap;
        this.idToKeyMap = idToKeyMap;
    }

    public Integer get(DownloadTask task) {
        Integer candidate = this.keyToIdMap.get(generateKey(task));
        if (candidate != null) {
            return candidate;
        }
        return null;
    }

    public void remove(int id) {
        String key = this.idToKeyMap.get(id);
        if (key != null) {
            this.keyToIdMap.remove(key);
            this.idToKeyMap.remove(id);
        }
    }

    public void add(DownloadTask task, int id) {
        String key = generateKey(task);
        this.keyToIdMap.put(key, Integer.valueOf(id));
        this.idToKeyMap.put(id, key);
    }

    String generateKey(DownloadTask task) {
        String tag = task.getTag() == null ? "" : (String) task.getTag();
        return tag + task.getFilename();
    }
}
