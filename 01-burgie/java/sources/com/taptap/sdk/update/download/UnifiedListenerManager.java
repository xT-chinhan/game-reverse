package com.taptap.sdk.update.download;

import android.util.SparseArray;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.listener.assist.ListenerAssist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UnifiedListenerManager {
    final List<Integer> autoRemoveListenerIdList = new ArrayList();
    final DownloadListener hostListener = new DownloadListener() { // from class: com.taptap.sdk.update.download.UnifiedListenerManager.1
        @Override // com.taptap.sdk.update.download.DownloadListener
        public void taskStart(DownloadTask task) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.taskStart(task);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectTrialStart(DownloadTask task, Map<String, List<String>> requestHeaderFields) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.connectTrialStart(task, requestHeaderFields);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectTrialEnd(DownloadTask task, int responseCode, Map<String, List<String>> responseHeaderFields) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.connectTrialEnd(task, responseCode, responseHeaderFields);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void downloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.downloadFromBeginning(task, info, cause);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.downloadFromBreakpoint(task, info);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectStart(DownloadTask task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.connectStart(task, blockIndex, requestHeaderFields);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.connectEnd(task, blockIndex, responseCode, responseHeaderFields);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void fetchStart(DownloadTask task, int blockIndex, long contentLength) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.fetchStart(task, blockIndex, contentLength);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.fetchProgress(task, blockIndex, increaseBytes);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void fetchEnd(DownloadTask task, int blockIndex, long contentLength) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.fetchEnd(task, blockIndex, contentLength);
                }
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
            DownloadListener[] listeners = UnifiedListenerManager.getThreadSafeArray(task, UnifiedListenerManager.this.realListenerMap);
            if (listeners == null) {
                return;
            }
            for (DownloadListener realOne : listeners) {
                if (realOne != null) {
                    realOne.taskEnd(task, cause, realCause);
                }
            }
            if (UnifiedListenerManager.this.autoRemoveListenerIdList.contains(Integer.valueOf(task.getId()))) {
                UnifiedListenerManager.this.detachListener(task.getId());
            }
        }
    };
    final SparseArray<ArrayList<DownloadListener>> realListenerMap = new SparseArray<>();

    public synchronized void detachListener(int id) {
        this.realListenerMap.remove(id);
    }

    public synchronized void addAutoRemoveListenersWhenTaskEnd(int id) {
        if (this.autoRemoveListenerIdList.contains(Integer.valueOf(id))) {
            return;
        }
        this.autoRemoveListenerIdList.add(Integer.valueOf(id));
    }

    public synchronized void removeAutoRemoveListenersWhenTaskEnd(int id) {
        this.autoRemoveListenerIdList.remove(Integer.valueOf(id));
    }

    public synchronized void detachListener(DownloadListener listener) {
        int count = this.realListenerMap.size();
        List<Integer> needRemoveKeyList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<DownloadListener> listenerList = this.realListenerMap.valueAt(i);
            if (listenerList != null) {
                listenerList.remove(listener);
                if (listenerList.isEmpty()) {
                    needRemoveKeyList.add(Integer.valueOf(this.realListenerMap.keyAt(i)));
                }
            }
        }
        Iterator<Integer> it = needRemoveKeyList.iterator();
        while (it.hasNext()) {
            int key = it.next().intValue();
            this.realListenerMap.remove(key);
        }
    }

    public synchronized boolean detachListener(DownloadTask task, DownloadListener listener) {
        int id = task.getId();
        List<DownloadListener> listenerList = this.realListenerMap.get(id);
        if (listenerList == null) {
            return false;
        }
        boolean result = listenerList.remove(listener);
        if (listenerList.isEmpty()) {
            this.realListenerMap.remove(id);
        }
        return result;
    }

    public synchronized void attachListener(DownloadTask task, DownloadListener listener) {
        int id = task.getId();
        ArrayList<DownloadListener> listenerList = this.realListenerMap.get(id);
        if (listenerList == null) {
            listenerList = new ArrayList<>();
            this.realListenerMap.put(id, listenerList);
        }
        if (!listenerList.contains(listener)) {
            listenerList.add(listener);
            if (listener instanceof ListenerAssist) {
                ((ListenerAssist) listener).setAlwaysRecoverAssistModelIfNotSet(true);
            }
        }
    }

    public synchronized void attachAndEnqueueIfNotRun(DownloadTask task, DownloadListener listener) {
        attachListener(task, listener);
        if (!isTaskPendingOrRunning(task)) {
            task.enqueue(this.hostListener);
        }
    }

    public synchronized void replaceListener(DownloadTask task, DownloadListener listener) {
        int id = task.getId();
        ArrayList<DownloadListener> listenerList = this.realListenerMap.get(id);
        if (listenerList == null) {
            listenerList = new ArrayList<>();
            this.realListenerMap.put(id, listenerList);
        }
        String className = listener.getClass().getName();
        DownloadListener oldListener = null;
        for (DownloadListener downloadListener : listenerList) {
            if (downloadListener.getClass().getName().equals(className)) {
                oldListener = downloadListener;
            }
        }
        if (oldListener != null) {
            listenerList.remove(oldListener);
        }
        if (!listenerList.contains(listener)) {
            listenerList.add(listener);
            if (listener instanceof ListenerAssist) {
                ((ListenerAssist) listener).setAlwaysRecoverAssistModelIfNotSet(true);
            }
        }
    }

    public synchronized boolean isListenerAttached(DownloadTask task, DownloadListener listener) {
        int id = task.getId();
        ArrayList<DownloadListener> listenerList = this.realListenerMap.get(id);
        if (listenerList == null) {
            return false;
        }
        return listenerList.contains(listener);
    }

    public DownloadListener getDownloadListener(DownloadTask task, String className) {
        int id = task.getId();
        ArrayList<DownloadListener> listenerList = this.realListenerMap.get(id);
        if (listenerList == null) {
            return null;
        }
        DownloadListener dest = null;
        for (DownloadListener listener : listenerList) {
            if (listener.getClass().getName().equals(className)) {
                dest = listener;
            }
        }
        return dest;
    }

    public synchronized void enqueueTaskWithUnifiedListener(DownloadTask task, DownloadListener listener) {
        attachListener(task, listener);
        task.enqueue(this.hostListener);
    }

    public synchronized void executeTaskWithUnifiedListener(DownloadTask task, DownloadListener listener) {
        attachListener(task, listener);
        task.execute(this.hostListener);
    }

    public DownloadListener getHostListener() {
        return this.hostListener;
    }

    boolean isTaskPendingOrRunning(DownloadTask task) {
        return StatusUtil.isSameTaskPendingOrRunning(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DownloadListener[] getThreadSafeArray(DownloadTask task, SparseArray<ArrayList<DownloadListener>> realListenerMap) {
        ArrayList<DownloadListener> listenerList = realListenerMap.get(task.getId());
        if (listenerList == null || listenerList.size() <= 0) {
            return null;
        }
        DownloadListener[] copyList = new DownloadListener[listenerList.size()];
        listenerList.toArray(copyList);
        return copyList;
    }
}
