package com.byazt.nr;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1357, 26})
public class qg {
    public static String n(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        StringBuilder sb = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + "\n");
        sb.append("processName: " + processErrorStateInfo.processName + "\n");
        sb.append("pid: " + processErrorStateInfo.pid + "\n");
        sb.append("uid: " + processErrorStateInfo.uid + "\n");
        sb.append("tag: " + processErrorStateInfo.tag + "\n");
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + "\n");
        sb.append("longMsg : " + processErrorStateInfo.longMsg + "\n");
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }
}
