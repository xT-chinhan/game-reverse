package com.byazt.bq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 122, 13})
public class hw {
    public static hw hw;
    public final Map<String, pr> hn = new ConcurrentHashMap();
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> x = new ConcurrentHashMap();
    public final Set<Integer> pr = new CopyOnWriteArraySet();

    @com.byazt.vzx.pr(pr = {0, 1, 122, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public final Set<PluginBroadcastReceiver> hw = new CopyOnWriteArraySet();
        public String pr;

        public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.hw.add(pluginBroadcastReceiver);
            }
        }

        public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                try {
                    if (this.hw.size() > 0) {
                        this.hw.remove(pluginBroadcastReceiver);
                    }
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + this.pr + "[exception]:", th);
                }
            }
        }

        public void pr(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.hw;
            if (set != null && set.size() > 0) {
                for (PluginBroadcastReceiver pluginBroadcastReceiver : this.hw) {
                    if (pluginBroadcastReceiver != null) {
                        try {
                            pluginBroadcastReceiver.onReceive(context, intent);
                        } catch (Throwable th) {
                            ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                        }
                    }
                }
            }
        }
    }

    private hw() {
    }

    public static hw pr() {
        if (hw == null) {
            synchronized (com.byazt.wee.pr.class) {
                if (hw == null) {
                    hw = new hw();
                }
            }
        }
        return hw;
    }

    public boolean pr(int i) {
        return this.pr.contains(Integer.valueOf(i));
    }

    private void pr(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter != null && intentFilter.actionsIterator() != null) {
            Iterator<String> itActionsIterator = intentFilter.actionsIterator();
            while (itActionsIterator.hasNext()) {
                String next = itActionsIterator.next();
                if (next != null) {
                    pr prVar = this.hn.get(next);
                    if (prVar != null) {
                        prVar.registerReceiver(pluginBroadcastReceiver);
                    } else {
                        pr prVar2 = new pr();
                        prVar2.pr = next;
                        prVar2.registerReceiver(pluginBroadcastReceiver);
                        this.hn.put(next, prVar2);
                    }
                }
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        Intent intentRegisterReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, 2);
        } else {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter);
        }
        this.x.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        pr(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        Intent intentRegisterReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, 2);
        } else {
            intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler);
        }
        this.x.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.pr.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        pr(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, i);
        this.x.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        pr(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (intentFilter == null || intentFilter.actionsIterator() == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent intentRegisterReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, i);
        this.x.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.pr.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        pr(intentFilter, pluginBroadcastReceiver);
        return intentRegisterReceiver;
    }

    public void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Iterator<Map.Entry<String, pr>> it = this.hn.entrySet().iterator();
        while (it.hasNext()) {
            pr value = it.next().getValue();
            if (value != null) {
                value.unregisterReceiver(pluginBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.x.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    this.pr.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    this.x.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
                }
            }
        }
    }

    public void pr(Context context, Intent intent) {
        pr value;
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            Map<String, pr> map = this.hn;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, pr> entry : this.hn.entrySet()) {
                    if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                        value.pr(context, intent);
                    }
                }
            }
        }
    }
}
