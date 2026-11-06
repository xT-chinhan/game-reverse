package com.taptap.sdk.update.download.core.listener.assist;

import android.util.SparseArray;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ListenerModel;

/* JADX INFO: loaded from: classes3.dex */
public class ListenerModelHandler<T extends ListenerModel> implements ListenerAssist {
    private Boolean alwaysRecoverModel;
    private final ModelCreator<T> creator;
    final SparseArray<T> modelList = new SparseArray<>();
    volatile T singleTaskModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface ListenerModel {
        int getId();

        void onInfoValid(BreakpointInfo breakpointInfo);
    }

    public interface ModelCreator<T extends ListenerModel> {
        T create(int i);
    }

    ListenerModelHandler(ModelCreator<T> creator) {
        this.creator = creator;
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        Boolean bool = this.alwaysRecoverModel;
        return bool != null && bool.booleanValue();
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean isAlwaysRecoverModel) {
        this.alwaysRecoverModel = Boolean.valueOf(isAlwaysRecoverModel);
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean isAlwaysRecoverAssistModel) {
        if (this.alwaysRecoverModel == null) {
            this.alwaysRecoverModel = Boolean.valueOf(isAlwaysRecoverAssistModel);
        }
    }

    T addAndGetModel(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        T t = (T) this.creator.create(downloadTask.getId());
        synchronized (this) {
            if (this.singleTaskModel == null) {
                this.singleTaskModel = t;
            } else {
                this.modelList.put(downloadTask.getId(), t);
            }
            if (breakpointInfo != null) {
                t.onInfoValid(breakpointInfo);
            }
        }
        return t;
    }

    T getOrRecoverModel(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        int id = downloadTask.getId();
        T t = null;
        synchronized (this) {
            if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                t = this.singleTaskModel;
            }
        }
        if (t == null) {
            t = this.modelList.get(id);
        }
        if (t != null || !isAlwaysRecoverAssistModel()) {
            return t;
        }
        return (T) addAndGetModel(downloadTask, breakpointInfo);
    }

    T removeOrCreate(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        T t;
        int id = downloadTask.getId();
        synchronized (this) {
            if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                t = this.singleTaskModel;
                this.singleTaskModel = null;
            } else {
                t = this.modelList.get(id);
                this.modelList.remove(id);
            }
        }
        if (t == null) {
            t = (T) this.creator.create(id);
            if (breakpointInfo != null) {
                t.onInfoValid(breakpointInfo);
            }
        }
        return t;
    }
}
