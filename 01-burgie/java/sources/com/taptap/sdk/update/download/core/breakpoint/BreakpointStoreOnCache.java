package com.taptap.sdk.update.download.core.breakpoint;

import android.util.SparseArray;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.IdentifiedTask;
import com.taptap.sdk.update.download.core.cause.EndCause;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointStoreOnCache implements DownloadStore {
    public static final int FIRST_ID = 1;
    private final List<Integer> fileDirtyList;
    private final KeyToIdMap keyToIdMap;
    private final HashMap<String, String> responseFilenameMap;
    private final List<Integer> sortedOccupiedIds;
    private final SparseArray<BreakpointInfo> storedInfos;
    private final SparseArray<IdentifiedTask> unStoredTasks;

    public BreakpointStoreOnCache() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    BreakpointStoreOnCache(SparseArray<BreakpointInfo> storedInfos, List<Integer> fileDirtyList, HashMap<String, String> responseFilenameMap, SparseArray<IdentifiedTask> unStoredTasks, List<Integer> sortedOccupiedIds, KeyToIdMap keyToIdMap) {
        this.unStoredTasks = unStoredTasks;
        this.fileDirtyList = fileDirtyList;
        this.storedInfos = storedInfos;
        this.responseFilenameMap = responseFilenameMap;
        this.sortedOccupiedIds = sortedOccupiedIds;
        this.keyToIdMap = keyToIdMap;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> storedInfos, List<Integer> fileDirtyList, HashMap<String, String> responseFilenameMap) {
        this.unStoredTasks = new SparseArray<>();
        this.storedInfos = storedInfos;
        this.fileDirtyList = fileDirtyList;
        this.responseFilenameMap = responseFilenameMap;
        this.keyToIdMap = new KeyToIdMap();
        int count = storedInfos.size();
        this.sortedOccupiedIds = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            this.sortedOccupiedIds.add(Integer.valueOf(storedInfos.valueAt(i).id));
        }
        Collections.sort(this.sortedOccupiedIds);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int id) {
        return this.storedInfos.get(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask task) {
        int id = task.getId();
        BreakpointInfo newInfo = new BreakpointInfo(id, task.getUrl(), task.getParentFile(), task.getFilename());
        synchronized (this) {
            this.storedInfos.put(id, newInfo);
            this.unStoredTasks.remove(id);
        }
        return newInfo;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onTaskStart(int id) {
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo info, int blockIndex, long increaseLength) throws IOException {
        BreakpointInfo onCacheOne = this.storedInfos.get(info.id);
        if (info != onCacheOne) {
            throw new IOException("Info not on store!");
        }
        onCacheOne.getBlock(blockIndex).increaseCurrentOffset(increaseLength);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) {
        String filename = breakpointInfo.getFilename();
        if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
            this.responseFilenameMap.put(breakpointInfo.getUrl(), filename);
        }
        BreakpointInfo onCacheOne = this.storedInfos.get(breakpointInfo.id);
        if (onCacheOne == null) {
            return false;
        }
        if (onCacheOne == breakpointInfo) {
            return true;
        }
        synchronized (this) {
            this.storedInfos.put(breakpointInfo.id, breakpointInfo.copy());
        }
        return true;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public void onTaskEnd(int id, EndCause cause, Exception exception) {
        if (cause == EndCause.COMPLETED) {
            remove(id);
        }
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int id) {
        return null;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public boolean markFileDirty(int id) {
        if (!this.fileDirtyList.contains(Integer.valueOf(id))) {
            synchronized (this.fileDirtyList) {
                if (!this.fileDirtyList.contains(Integer.valueOf(id))) {
                    this.fileDirtyList.add(Integer.valueOf(id));
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.DownloadStore
    public boolean markFileClear(int id) {
        boolean zRemove;
        synchronized (this.fileDirtyList) {
            zRemove = this.fileDirtyList.remove(Integer.valueOf(id));
        }
        return zRemove;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public synchronized void remove(int id) {
        this.storedInfos.remove(id);
        if (this.unStoredTasks.get(id) == null) {
            this.sortedOccupiedIds.remove(Integer.valueOf(id));
        }
        this.keyToIdMap.remove(id);
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public synchronized int findOrCreateId(DownloadTask task) {
        Integer candidate = this.keyToIdMap.get(task);
        if (candidate != null) {
            return candidate.intValue();
        }
        int size = this.storedInfos.size();
        for (int i = 0; i < size; i++) {
            BreakpointInfo info = this.storedInfos.valueAt(i);
            if (info != null && info.isSameFrom(task)) {
                return info.id;
            }
        }
        int unStoredSize = this.unStoredTasks.size();
        for (int i2 = 0; i2 < unStoredSize; i2++) {
            IdentifiedTask another = this.unStoredTasks.valueAt(i2);
            if (another != null && another.compareIgnoreId(task)) {
                return another.getId();
            }
        }
        int id = allocateId();
        this.unStoredTasks.put(id, task.mock(id));
        this.keyToIdMap.add(task, id);
        return id;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask task, BreakpointInfo ignored) {
        SparseArray<BreakpointInfo> clonedMap;
        synchronized (this) {
            clonedMap = this.storedInfos.clone();
        }
        int size = clonedMap.size();
        for (int i = 0; i < size; i++) {
            BreakpointInfo info = clonedMap.valueAt(i);
            if (info != ignored && info.isSameFrom(task)) {
                return info;
            }
        }
        return null;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return true;
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int id) {
        return this.fileDirtyList.contains(Integer.valueOf(id));
    }

    @Override // com.taptap.sdk.update.download.core.breakpoint.BreakpointStore
    public String getResponseFilename(String url) {
        return this.responseFilenameMap.get(url);
    }

    synchronized int allocateId() {
        int newId;
        newId = 0;
        int index = 0;
        int curId = 0;
        for (int i = 0; i < this.sortedOccupiedIds.size(); i++) {
            Integer curIdObj = this.sortedOccupiedIds.get(i);
            if (curIdObj == null) {
                index = i;
                newId = curId + 1;
                break;
            }
            curId = curIdObj.intValue();
            if (curId == 0) {
                if (curId != 1) {
                    newId = 1;
                    index = 0;
                    break;
                }
            } else {
                if (curId != curId + 1) {
                    newId = curId + 1;
                    index = i;
                    break;
                }
            }
            throw th;
        }
        if (newId == 0) {
            if (this.sortedOccupiedIds.isEmpty()) {
                newId = 1;
            } else {
                List<Integer> list = this.sortedOccupiedIds;
                newId = list.get(list.size() - 1).intValue() + 1;
                index = this.sortedOccupiedIds.size();
            }
        }
        this.sortedOccupiedIds.add(index, Integer.valueOf(newId));
        return newId;
    }
}
