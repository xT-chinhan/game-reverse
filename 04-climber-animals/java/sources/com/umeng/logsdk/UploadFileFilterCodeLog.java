package com.umeng.logsdk;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UploadFileFilterCodeLog implements IFileFilter {
    private ULogConfigManager a;
    private b b;
    private String c;
    private String e;
    private long g;
    private long h;
    private int d = -1;
    private int f = -1;

    private void a() {
        Log.i("UploadFileFilterCodeLog", "reset task.");
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.g = 0L;
        this.h = 0L;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean filter(File file) {
        StringBuilder sbAppend;
        StringBuilder sb;
        List<b> taskList;
        if (this.b == null) {
            ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
            this.a = uLogConfigManager;
            if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
                for (int i = 0; i < taskList.size(); i++) {
                    b bVar = taskList.get(i);
                    this.b = bVar;
                    if (bVar != null) {
                        int i2 = bVar.b;
                        this.d = i2;
                        if (i2 == 0) {
                            this.c = this.b.a;
                            this.e = this.b.d;
                            this.f = this.b.c;
                            this.g = this.b.e;
                            this.h = this.b.f;
                            break;
                        }
                        a();
                    }
                }
            }
        }
        if (this.b != null && this.d == 0) {
            Log.i("UploadFileFilterCodeLog", this.c + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h);
            String name = file.getName();
            LogDto logDtoCreateLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (logDtoCreateLogDtoByName == null) {
                CacheManager.getInstance().onChangeDtoError(file);
                return true;
            }
            long beginTime = logDtoCreateLogDtoByName.getBeginTime();
            logDtoCreateLogDtoByName.getEndTime();
            String did = logDtoCreateLogDtoByName.getDid();
            String uid = logDtoCreateLogDtoByName.getUid();
            if (beginTime < this.g || beginTime > this.h) {
                sbAppend = new StringBuilder("time is ").append(beginTime >= this.g).append(", is ").append(beginTime <= this.h);
            } else {
                Log.i("UploadFileFilterCodeLog", "task target type is " + this.f);
                int i3 = this.f;
                if (i3 == 1) {
                    if (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(did) && this.e.equals(did)) {
                        sb = new StringBuilder("task is ");
                        Log.i("UploadFileFilterCodeLog", sb.append(this.c).append(", target is ").append(this.e).append(", file time is ").append(beginTime).toString());
                        return false;
                    }
                    sbAppend = new StringBuilder("taskTarget is ").append(this.e).append(", did is ").append(did);
                } else if (i3 == 0) {
                    if (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(uid) && this.e.equals(uid)) {
                        sb = new StringBuilder("task is ");
                        Log.i("UploadFileFilterCodeLog", sb.append(this.c).append(", target is ").append(this.e).append(", file time is ").append(beginTime).toString());
                        return false;
                    }
                    sbAppend = new StringBuilder("taskTarget is ").append(this.e).append(", uid is ").append(uid);
                }
            }
            Log.i("UploadFileFilterCodeLog", sbAppend.toString());
        }
        return true;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public void finish() {
        ULogConfigManager uLogConfigManager;
        Log.i("UploadFileFilterCodeLog", "clear task.");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i("UploadFileFilterCodeLog", "taskEndTime is " + this.h + ", current time is " + jCurrentTimeMillis);
        if (this.h > jCurrentTimeMillis) {
            Log.i("UploadFileFilterCodeLog", "future task. not remove.");
            uLogConfigManager = this.a;
            if (uLogConfigManager != null) {
                uLogConfigManager.removeTask(this.b);
            }
        } else {
            ULogConfigManager uLogConfigManager2 = this.a;
            if (uLogConfigManager2 != null) {
                uLogConfigManager2.reMoveTaskFroSP(this.c);
                uLogConfigManager = this.a;
                uLogConfigManager.removeTask(this.b);
            }
        }
        a();
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public void finish(boolean z, boolean z2) {
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean hasTask() {
        List<b> taskList;
        ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
        if (uLogConfigManager == null || (taskList = uLogConfigManager.getTaskList()) == null || taskList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < taskList.size(); i++) {
            b bVar = taskList.get(i);
            if (bVar != null && bVar.b == 0) {
                return true;
            }
        }
        return false;
    }
}
