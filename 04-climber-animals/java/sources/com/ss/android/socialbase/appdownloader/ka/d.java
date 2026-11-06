package com.ss.android.socialbase.appdownloader.ka;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.appdownloader.ah.u;
import com.ss.android.socialbase.appdownloader.ny;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static com.ss.android.socialbase.appdownloader.view.ms ah = null;
    private static AlertDialog d = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4586ms = "d";
    private static List<u> xr = new ArrayList();

    public static boolean ms() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.ah.k()).areNotificationsEnabled();
        } catch (Throwable th) {
            ab.ms(th);
            return true;
        }
    }

    public static synchronized void ms(boolean z) {
        try {
            AlertDialog alertDialog = d;
            if (alertDialog != null) {
                alertDialog.cancel();
                d = null;
            }
            for (u uVar : xr) {
                if (uVar != null) {
                    if (z) {
                        uVar.ms();
                    } else {
                        uVar.xr();
                    }
                }
            }
        } catch (Throwable th) {
            ab.ms(th);
        }
    }

    public static synchronized void ms(final Activity activity, final u uVar) {
        if (uVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    int iMs = ny.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), "tt_appdownloader_notification_request_title");
                    int iMs2 = ny.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), "tt_appdownloader_notification_request_message");
                    int iMs3 = ny.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), "tt_appdownloader_notification_request_btn_yes");
                    int iMs4 = ny.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), "tt_appdownloader_notification_request_btn_no");
                    xr.add(uVar);
                    AlertDialog alertDialog = d;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        d = new AlertDialog.Builder(activity).setTitle(iMs).setMessage(iMs2).setPositiveButton(iMs3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.ka.d.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                d.xr(activity, uVar);
                                dialogInterface.cancel();
                                AlertDialog unused = d.d = null;
                            }
                        }).setNegativeButton(iMs4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.ka.d.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                d.ms(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.ka.d.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    d.ms(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable th) {
                ab.ms(th);
                ms(false);
                return;
            }
        }
        uVar.xr();
    }

    public static void xr(Activity activity, u uVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f4586ms;
                    com.ss.android.socialbase.appdownloader.view.ms msVar = (com.ss.android.socialbase.appdownloader.view.ms) fragmentManager.findFragmentByTag(str);
                    ah = msVar;
                    if (msVar == null) {
                        ah = new com.ss.android.socialbase.appdownloader.view.ms();
                        fragmentManager.beginTransaction().add(ah, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            ab.ms(th);
                        }
                    }
                    ah.ms();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    ab.ms(th2);
                    uVar.ms();
                    return;
                } catch (Throwable th3) {
                    ab.ms(th3);
                    return;
                }
            }
        }
        uVar.ms();
    }
}
