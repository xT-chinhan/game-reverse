package com.taptap.sdk.startup.utils;

import com.taptap.sdk.startup.task.Task;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: TaskFactoryCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/startup/utils/TaskFactoryCollector;", "", "()V", "collect", "", "Lcom/taptap/sdk/startup/task/Task;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TaskFactoryCollector {
    public final List<Task> collect() {
        List tasks = new ArrayList();
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_achievement_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_compliance_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_core_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_db_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_gid_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_license_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_login_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_moment_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_openlog_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_review_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_share_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_update_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_payment_core_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_payment_iap_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_payment_checkout_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_relation_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_relation_lite_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_leaderboard_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_cloudsave_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_rep_TaskFactory"));
        CollectionsKt.addAll(tasks, ReflectUtils.INSTANCE.create("com.taptap.sdk.initialize.Sdk_tap_battle_TaskFactory"));
        return tasks;
    }
}
