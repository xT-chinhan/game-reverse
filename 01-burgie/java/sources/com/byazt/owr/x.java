package com.byazt.owr;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.KeyEvent;
import com.byazt.zkm.g;
import com.bykv.vk.component.ttvideo.player.C;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 404, 121})
public class x {
    public static com.byazt.sv.pr hn;
    public static AlertDialog x;
    public static final String pr = x.class.getSimpleName();
    public static List<g> hw = new ArrayList();

    public static boolean pr() {
        try {
            return hw();
        } catch (Throwable th) {
            return true;
        }
    }

    private static boolean hw() {
        Context contextOf = com.byazt.lj.hn.of();
        NotificationManager notificationManager = (NotificationManager) contextOf.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 24) {
            return notificationManager.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) contextOf.getSystemService("appops");
        ApplicationInfo applicationInfo = contextOf.getApplicationInfo();
        String packageName = contextOf.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
            return true;
        }
    }

    public static synchronized void pr(boolean z) {
        try {
            AlertDialog alertDialog = x;
            if (alertDialog != null) {
                alertDialog.cancel();
                x = null;
            }
            for (g gVar : hw) {
                if (gVar != null) {
                    if (z) {
                        gVar.pr();
                    } else {
                        gVar.hw();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static synchronized void pr(final Activity activity, final g gVar) {
        if (gVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    hw.add(gVar);
                    AlertDialog alertDialog = x;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        x = new AlertDialog.Builder(activity).setTitle("设置").setMessage("为了您能在方便地在通知栏控制下载任务，请到设置中开启通知，如果不需要可直接下载").setPositiveButton("去设置", new DialogInterface.OnClickListener() { // from class: com.byazt.owr.x.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                x.hw(activity, gVar);
                                dialogInterface.cancel();
                                AlertDialog unused = x.x = null;
                            }
                        }).setNegativeButton("立即下载", new DialogInterface.OnClickListener() { // from class: com.byazt.owr.x.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                x.pr(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.byazt.owr.x.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    x.pr(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable th) {
                pr(false);
                return;
            }
        }
        gVar.hw();
    }

    public static void hw(Activity activity, g gVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = pr;
                    com.byazt.sv.pr prVar = (com.byazt.sv.pr) fragmentManager.findFragmentByTag(str);
                    hn = prVar;
                    if (prVar == null) {
                        hn = new com.byazt.sv.pr();
                        fragmentManager.beginTransaction().add(hn, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                        }
                    }
                    hn.pr();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    gVar.pr();
                    return;
                } catch (Throwable th3) {
                    return;
                }
            }
        }
        gVar.pr();
    }

    public static void pr(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.byazt.ew.pr.pr(i).hw("enable_target_34") <= 0 || pr()) {
            return;
        }
        Context contextOf = com.byazt.lj.hn.of();
        try {
            Intent intent = new Intent(contextOf, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            contextOf.startActivity(intent);
        } catch (Throwable th) {
            com.byazt.p000do.pr.c(pr, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
