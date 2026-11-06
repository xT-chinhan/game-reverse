package com.mar.sdk.gg;

import com.mar.sdk.MARSDK;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class AdInst {
    protected static final String TAG = "MARSDK-AD";
    private AdEvent adEvent;
    protected String[] idList;
    protected AdEvent.InstType instType;
    protected Listener listener;
    protected AdEvent.AdType type;
    protected int idx = 0;
    protected AdEvent.LoadState loadState = AdEvent.LoadState.UNLOAD;
    protected boolean isShow = false;
    protected boolean sucShow = false;
    protected boolean ready2show = false;
    protected int errorLoadTimes = 0;
    protected long lastShowTime = 0;
    protected long recordShowTime = 0;
    protected long recordShowTimeSpace = 0;
    public int showPos = 0;
    public double floatIconPosX = 0.0d;
    public double floatIconPosY = 0.0d;
    public double lucencyPosX = 0.0d;
    public double lucencyPosY = 0.0d;
    public boolean isMixReward = false;

    public interface Listener {
        void hide(AdInst adInst);

        void onHide(AdInst adInst);

        void onShow(AdInst adInst, boolean z);

        boolean show(AdInst adInst);
    }

    public void init(AdEvent.AdType type, AdEvent.InstType instType, String[] idList) {
        this.type = type;
        this.instType = instType;
        this.idList = idList;
        doInit();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    protected void logD(String msg) {
        Log.d(TAG, "[" + this.instType + "] " + msg);
    }

    protected AdEvent genAdEvent() {
        this.adEvent.instType = this.instType;
        this.adEvent.type = this.type;
        return this.adEvent;
    }

    public void load() {
        if (this.adEvent != null) {
            this.adEvent = null;
        }
        this.adEvent = new AdEvent();
        if (this.loadState == AdEvent.LoadState.UNLOAD) {
            this.loadState = AdEvent.LoadState.LOADING;
            if (this.idx >= this.idList.length) {
                this.idx = 0;
            }
            logD("load:" + this.idx + " : " + this.idList[this.idx]);
            genAdEvent().adId = this.idList[this.idx];
            genAdEvent().adPlacementId = this.idList[this.idx];
            doLoad(this.idList[this.idx]);
            this.idx++;
            this.isMixReward = false;
        }
    }

    public void show(String json) {
        if (json != null && !json.equals("")) {
            genAdEvent().gameEvent = json;
            logD("show :" + genAdEvent().instType.name() + " == " + genAdEvent().type.name() + "==" + json);
        }
        show();
    }

    public void show() {
        if (this.isShow || this.ready2show) {
            this.errorLoadTimes = 0;
            return;
        }
        boolean ret = this.listener.show(this);
        if (ret) {
            this.isShow = true;
            if (!this.sucShow) {
                logD("show: " + this.loadState);
                if (this.loadState != AdEvent.LoadState.LOADED) {
                    this.ready2show = true;
                    this.errorLoadTimes = 0;
                } else {
                    doShow();
                }
            }
        }
    }

    protected String genNextAdId() {
        if (this.idx >= this.idList.length) {
            this.idx = 0;
        }
        logD("genNextAdId: " + this.idx + ":" + this.idList[this.idx]);
        String adId = this.idList[this.idx];
        this.idx++;
        return adId;
    }

    public void hide() {
        if (this.isShow) {
            doHide();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoad(boolean suc, String msg) {
        logD("onLoad:" + suc + ":" + (msg != null ? msg : ""));
        if (suc) {
            this.loadState = AdEvent.LoadState.LOADED;
            this.errorLoadTimes = 0;
            if (this.ready2show) {
                doShow();
            }
            MARSDK.getInstance().onAdResult(1007, genAdEvent());
            return;
        }
        this.loadState = AdEvent.LoadState.UNLOAD;
        this.errorLoadTimes++;
        genAdEvent().error = msg;
        MARSDK.getInstance().onAdResult(1005, genAdEvent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShow(boolean suc, String msg) {
        if (!this.isShow) {
            hide();
            return;
        }
        if (!this.sucShow) {
            logD("onShow: " + suc + " : " + (msg != null ? msg : ""));
            this.sucShow = suc;
            if (suc) {
                this.lastShowTime = System.currentTimeMillis();
                MARSDK.getInstance().onAdResult(1001, genAdEvent());
            } else {
                this.loadState = AdEvent.LoadState.UNLOAD;
                genAdEvent().error = msg;
                MARSDK.getInstance().onAdResult(1009, genAdEvent());
                MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.AdInst.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AdInst.this.isShow) {
                            AdInst.this.hide();
                            AdInst.this.load();
                        }
                    }
                });
            }
            this.listener.onShow(this, suc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHide() {
        if (this.isShow) {
            this.sucShow = false;
            logD("onHide");
            if (this.loadState != AdEvent.LoadState.LOADING && this.lastShowTime > 0) {
                this.recordShowTime += Math.abs(System.currentTimeMillis() - this.lastShowTime);
                if (this.recordShowTime > this.recordShowTimeSpace) {
                    this.recordShowTime = 0L;
                    this.loadState = AdEvent.LoadState.UNLOAD;
                }
                this.lastShowTime = 0L;
            }
            this.ready2show = false;
            this.isShow = false;
            this.listener.onHide(this);
            MARSDK.getInstance().onAdResult(1002, genAdEvent());
            this.adEvent = new AdEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClick() {
        MARSDK.getInstance().onAdResult(1003, genAdEvent());
    }

    protected void onResult(boolean isReward) {
        AdEvent event = genAdEvent();
        event.isReward = isReward;
        MARSDK.getInstance().onAdResult(1004, event);
    }

    protected void tick() {
        if (this.loadState != AdEvent.LoadState.UNLOAD) {
            doTick();
        } else if (this.errorLoadTimes >= this.idList.length * 2) {
            doTick();
        } else {
            MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.AdInst.2
                @Override // java.lang.Runnable
                public void run() {
                    AdInst.this.load();
                }
            });
        }
    }

    protected void doInit() {
    }

    protected void doLoad(String adId) {
    }

    protected void doShow() {
    }

    protected void doHide() {
    }

    protected void doTick() {
    }

    public boolean getFlag() {
        this.errorLoadTimes = 0;
        return this.loadState == AdEvent.LoadState.LOADED;
    }

    public void showWithPos(int pos, String json) {
        this.showPos = pos;
        show(json);
    }

    public void setShowfloat(double x, double y, String json) {
        this.floatIconPosX = x;
        this.floatIconPosY = y;
        show(json);
    }

    public void setShowLucency(double x, double y, String json) {
        this.lucencyPosX = x;
        this.lucencyPosY = y;
        show(json);
    }
}
