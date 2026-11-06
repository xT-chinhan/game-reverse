package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.anythink.core.common.l.f;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalBroadcastManager {
    public static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    public static final String TAG = "LocalBroadcastManager";
    public static LocalBroadcastManager mInstance;
    public static final Object mLock = new Object();
    public final Context mAppContext;
    public final Handler mHandler;
    public final HashMap<PluginBroadcastReceiver, ArrayList<qg>> mReceivers = new HashMap<>();
    public final HashMap<String, ArrayList<qg>> mActions = new HashMap<>();
    public final ArrayList<n> mPendingBroadcasts = new ArrayList<>();

    @com.byazt.cp.n(n = {0, 55, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 904})
    private static final class qg {
        public final IntentFilter n;
        public boolean q;
        public final PluginBroadcastReceiver qg;
        public boolean s;

        public qg(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.n = intentFilter;
            this.qg = pluginBroadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.qg);
            sb.append(" filter=");
            sb.append(this.n);
            if (this.q) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    @com.byazt.cp.n(n = {0, 55, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 1615})
    private static final class n {
        public final Intent n;
        public final ArrayList<qg> qg;

        public n(Intent intent, ArrayList<qg> arrayList) {
            this.n = intent;
            this.qg = arrayList;
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            qg qgVar = new qg(intentFilter, pluginBroadcastReceiver);
            ArrayList<qg> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(qgVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<qg> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(qgVar);
            }
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<qg> arrayListRemove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                qg qgVar = arrayListRemove.get(size);
                qgVar.q = true;
                for (int i = 0; i < qgVar.n.countActions(); i++) {
                    String action = qgVar.n.getAction(i);
                    ArrayList<qg> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            qg qgVar2 = arrayList.get(size2);
                            if (qgVar2.qg == pluginBroadcastReceiver) {
                                qgVar2.q = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<qg> arrayList2;
        String str2;
        String str3;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                w.n(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<qg> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    w.n(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    qg qgVar = arrayList3.get(i2);
                    if (z) {
                        w.n(TAG, "Matching against filter " + qgVar.n);
                    }
                    if (qgVar.s) {
                        if (z) {
                            w.n(TAG, "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = qgVar.n.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                w.n(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(qgVar);
                            qgVar.s = true;
                        } else if (z) {
                            if (iMatch == -4) {
                                str3 = "category";
                            } else if (iMatch == -3) {
                                str3 = "action";
                            } else if (iMatch != -2) {
                                str3 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str3 = f.R;
                            }
                            w.n(TAG, "  Filter did not match: ".concat(str3));
                        }
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((qg) arrayList5.get(i3)).s = false;
                    }
                    this.mPendingBroadcasts.add(new n(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void executePendingBroadcasts() {
        int size;
        n[] nVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                nVarArr = new n[size];
                this.mPendingBroadcasts.toArray(nVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                n nVar = nVarArr[i];
                int size2 = nVar.qg.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    qg qgVar = nVar.qg.get(i2);
                    if (!qgVar.q) {
                        qgVar.qg.onReceive(this.mAppContext, nVar.n);
                    }
                }
            }
        }
    }
}
