package com.taptap.sdk.initialize;

import com.taptap.sdk.startup.task.Task;
import com.taptap.sdk.update.internal.UpdateInitializeTask;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: Sdk_tap_update_TaskFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/initialize/Sdk_tap_update_TaskFactory;", "", "()V", "create", "", "Lcom/taptap/sdk/startup/task/Task;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Sdk_tap_update_TaskFactory {
    public final List<Task> create() {
        List tasks = new ArrayList();
        tasks.add(new Task("UpdateInitializeTask", UpdateInitializeTask.class, false, 0, SetsKt.setOf((Object[]) new String[]{"com.taptap.sdk.gid.GidInitializeTask", "com.taptap.sdk.db.DBInitializeTask"}), null, null, 96, null));
        return tasks;
    }
}
