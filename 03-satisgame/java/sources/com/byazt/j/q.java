package com.byazt.j;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import com.byazt.z.sz;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 5})
public class q {
    public static final String n = "q";
    public static AlertDialog q;
    public static List<sz> qg = new ArrayList();
    public static com.byazt.a.n s;

    public static boolean n() {
        try {
            return qg();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean qg() {
        return ((NotificationManager) com.byazt.xv.s.u().getSystemService("notification")).areNotificationsEnabled();
    }

    public static synchronized void n(boolean z) {
        try {
            AlertDialog alertDialog = q;
            if (alertDialog != null) {
                alertDialog.cancel();
                q = null;
            }
            for (sz szVar : qg) {
                if (szVar != null) {
                    if (z) {
                        szVar.n();
                    } else {
                        szVar.qg();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void n(final Activity activity, final sz szVar) {
        if (szVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    qg.add(szVar);
                    AlertDialog alertDialog = q;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        q = new AlertDialog.Builder(activity).setTitle("设置").setMessage("为了您能在方便地在通知栏控制下载任务，请到设置中开启通知，如果不需要可直接下载").setPositiveButton("去设置", new DialogInterface.OnClickListener() { // from class: com.byazt.j.q.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                q.qg(activity, szVar);
                                dialogInterface.cancel();
                                AlertDialog unused = q.q = null;
                            }
                        }).setNegativeButton("立即下载", new DialogInterface.OnClickListener() { // from class: com.byazt.j.q.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                q.n(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.byazt.j.q.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    q.n(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable unused) {
                n(false);
                return;
            }
        }
        szVar.qg();
    }

    public static void qg(Activity activity, sz szVar) {
        if (activity != null) {
            try {
                try {
                    if (!activity.isFinishing()) {
                        FragmentManager fragmentManager = activity.getFragmentManager();
                        String str = n;
                        com.byazt.a.n nVar = (com.byazt.a.n) fragmentManager.findFragmentByTag(str);
                        s = nVar;
                        if (nVar == null) {
                            s = new com.byazt.a.n();
                            fragmentManager.beginTransaction().add(s, str).commitAllowingStateLoss();
                            try {
                                fragmentManager.executePendingTransactions();
                            } catch (Throwable unused) {
                            }
                        }
                        s.n();
                        return;
                    }
                } catch (Throwable unused2) {
                    szVar.n();
                    return;
                }
            } catch (Throwable unused3) {
                return;
            }
        }
        szVar.n();
    }

    public static void n(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.byazt.f.n.n(i).qg("enable_target_34") <= 0 || n()) {
            return;
        }
        Context contextU = com.byazt.xv.s.u();
        try {
            Intent intent = new Intent(contextU, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            contextU.startActivity(intent);
        } catch (Throwable th) {
            com.byazt.fe.n.l(n, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
