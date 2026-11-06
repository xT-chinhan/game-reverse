package com.taptap.sdk.update.download.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class RemitSyncExecutor implements Handler.Callback {
    private static final String TAG = "RemitSyncExecutor";
    static final int WHAT_REMOVE_FREE_BUNCH_ID = -1;
    static final int WHAT_REMOVE_FREE_ID = -2;
    static final int WHAT_REMOVE_INFO = -3;
    static final int WHAT_SYNC_BUNCH_ID = 0;
    private final RemitAgent agent;
    private final Set<Integer> freeToDBIdList;
    private final Handler handler;

    interface RemitAgent {
        void removeInfo(int i);

        void syncCacheToDB(int i) throws IOException;

        void syncCacheToDB(List<Integer> list) throws IOException;
    }

    RemitSyncExecutor(RemitAgent agent) {
        this.agent = agent;
        this.freeToDBIdList = new HashSet();
        HandlerThread thread = new HandlerThread("OkDownload RemitHandoverToDB");
        thread.start();
        this.handler = new Handler(thread.getLooper(), this);
    }

    RemitSyncExecutor(RemitAgent agent, Handler handler, Set<Integer> freeToDBIdList) {
        this.agent = agent;
        this.handler = handler;
        this.freeToDBIdList = freeToDBIdList;
    }

    void shutdown() {
        this.handler.getLooper().quit();
    }

    boolean isFreeToDatabase(int id) {
        return this.freeToDBIdList.contains(Integer.valueOf(id));
    }

    public void postSyncInfoDelay(int id, long delayMillis) {
        this.handler.sendEmptyMessageDelayed(id, delayMillis);
    }

    public void postSync(int id) {
        this.handler.sendEmptyMessage(id);
    }

    public void postSync(List<Integer> idList) {
        Message message = this.handler.obtainMessage(0);
        message.obj = idList;
        this.handler.sendMessage(message);
    }

    public void postRemoveInfo(int id) {
        Message message = this.handler.obtainMessage(-3);
        message.arg1 = id;
        this.handler.sendMessage(message);
    }

    public void postRemoveFreeIds(List<Integer> idList) {
        Message message = this.handler.obtainMessage(-1);
        message.obj = idList;
        this.handler.sendMessage(message);
    }

    public void postRemoveFreeId(int id) {
        Message message = this.handler.obtainMessage(-2);
        message.arg1 = id;
        this.handler.sendMessage(message);
    }

    void removePostWithId(int id) {
        this.handler.removeMessages(id);
    }

    void removePostWithIds(int[] ids) {
        for (int id : ids) {
            this.handler.removeMessages(id);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case -3:
                int id = msg.arg1;
                this.freeToDBIdList.remove(Integer.valueOf(id));
                this.agent.removeInfo(id);
                Util.d(TAG, "remove info " + id);
                break;
            case -2:
                int id2 = msg.arg1;
                this.freeToDBIdList.remove(Integer.valueOf(id2));
                Util.d(TAG, "remove free bunch id " + id2);
                break;
            case -1:
                List<Integer> idList = (List) msg.obj;
                this.freeToDBIdList.removeAll(idList);
                Util.d(TAG, "remove free bunch ids " + idList);
                break;
            case 0:
                List<Integer> idList2 = (List) msg.obj;
                try {
                    this.agent.syncCacheToDB(idList2);
                    this.freeToDBIdList.addAll(idList2);
                    Util.d(TAG, "sync bunch info with ids: " + idList2);
                } catch (IOException e) {
                    Util.w(TAG, "sync info to db failed for ids: " + idList2);
                    return true;
                }
                break;
            default:
                int id3 = msg.what;
                try {
                    this.agent.syncCacheToDB(id3);
                    this.freeToDBIdList.add(Integer.valueOf(id3));
                    Util.d(TAG, "sync info with id: " + id3);
                } catch (IOException e2) {
                    Util.w(TAG, "sync cache to db failed for id: " + id3);
                    return true;
                }
                break;
        }
        return true;
    }
}
