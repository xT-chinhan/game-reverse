package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.byazt.dea.uc;
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
    public final HashMap<PluginBroadcastReceiver, ArrayList<hw>> mReceivers = new HashMap<>();
    public final HashMap<String, ArrayList<hw>> mActions = new HashMap<>();
    public final ArrayList<pr> mPendingBroadcasts = new ArrayList<>();

    @com.byazt.vzx.pr(pr = {0, 78, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 797})
    private static final class hw {
        public boolean hn;
        public final PluginBroadcastReceiver hw;
        public final IntentFilter pr;
        public boolean x;

        public hw(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.pr = intentFilter;
            this.hw = pluginBroadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.hw);
            sb.append(" filter=");
            sb.append(this.pr);
            if (this.x) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 78, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 845})
    private static final class pr {
        public final ArrayList<hw> hw;
        public final Intent pr;

        public pr(Intent intent, ArrayList<hw> arrayList) {
            this.pr = intent;
            this.hw = arrayList;
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
                switch (message.what) {
                    case 1:
                        LocalBroadcastManager.this.executePendingBroadcasts();
                        break;
                    default:
                        super.handleMessage(message);
                        break;
                }
            }
        };
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            hw hwVar = new hw(intentFilter, pluginBroadcastReceiver);
            ArrayList<hw> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(hwVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<hw> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(hwVar);
            }
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<hw> arrayListRemove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                hw hwVar = arrayListRemove.get(size);
                hwVar.x = true;
                for (int i = 0; i < hwVar.pr.countActions(); i++) {
                    String action = hwVar.pr.getAction(i);
                    ArrayList<hw> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            hw hwVar2 = arrayList.get(size2);
                            if (hwVar2.hw == pluginBroadcastReceiver) {
                                hwVar2.x = true;
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
        ArrayList<hw> arrayList2;
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
                uc.pr(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<hw> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    uc.pr(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    hw hwVar = arrayList3.get(i2);
                    if (z) {
                        uc.pr(TAG, "Matching against filter " + hwVar.pr);
                    }
                    if (hwVar.hn) {
                        if (!z) {
                            i = i2;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = strResolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            uc.pr(TAG, "  Filter's target already added");
                            i = i2;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = strResolveTypeIfNeeded;
                            arrayList = arrayList4;
                        }
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = hwVar.pr.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                uc.pr(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            if (arrayList != null) {
                                arrayList4 = arrayList;
                            } else {
                                arrayList4 = new ArrayList();
                            }
                            arrayList4.add(hwVar);
                            hwVar.hn = true;
                        } else if (z) {
                            switch (iMatch) {
                                case -4:
                                    str3 = "category";
                                    break;
                                case -3:
                                    str3 = "action";
                                    break;
                                case -2:
                                    str3 = "data";
                                    break;
                                case -1:
                                    str3 = "type";
                                    break;
                                default:
                                    str3 = "unknown reason";
                                    break;
                            }
                            uc.pr(TAG, "  Filter did not match: ".concat(String.valueOf(str3)));
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
                        ((hw) arrayList5.get(i3)).hn = false;
                    }
                    this.mPendingBroadcasts.add(new pr(intent, arrayList5));
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
        pr[] prVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                prVarArr = new pr[size];
                this.mPendingBroadcasts.toArray(prVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                pr prVar = prVarArr[i];
                int size2 = prVar.hw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    hw hwVar = prVar.hw.get(i2);
                    if (!hwVar.x) {
                        hwVar.hw.onReceive(this.mAppContext, prVar.pr);
                    }
                }
            }
        }
    }
}
