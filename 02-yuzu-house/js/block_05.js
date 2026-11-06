var __defProp = Object.defineProperty;
var __getOwnPropSymbols = Object.getOwnPropertySymbols;
var __hasOwnProp = Object.prototype.hasOwnProperty;
var __propIsEnum = Object.prototype.propertyIsEnumerable;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __spreadValues = (a, b) => {
  for (var prop in b || (b = {}))
    if (__hasOwnProp.call(b, prop))
      __defNormalProp(a, prop, b[prop]);
  if (__getOwnPropSymbols)
    for (var prop of __getOwnPropSymbols(b)) {
      if (__propIsEnum.call(b, prop))
        __defNormalProp(a, prop, b[prop]);
    }
  return a;
};
(function() {
  "use strict";
  function $(id) {
    return document.getElementById(id);
  }
  function clamp(v, a, b) {
    return v < a ? a : v > b ? b : v;
  }
  function dist(a, b) {
    var ar = Math.floor(a / G.n), ac = a % G.n, br = Math.floor(b / G.n), bc = b % G.n;
    return Math.abs(ar - br) + Math.abs(ac - bc);
  }
  function hexToRgb(hex) {
    return {
      r: parseInt(hex.substr(1, 2), 16),
      g: parseInt(hex.substr(3, 2), 16),
      b: parseInt(hex.substr(5, 2), 16)
    };
  }
  function toHex(r, g, b) {
    return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);
  }
  function darken(hex, f) {
    var c = hexToRgb(hex);
    return toHex(clamp(Math.round(c.r * f), 0, 255), clamp(Math.round(c.g * f), 0, 255), clamp(Math.round(c.b * f), 0, 255));
  }
  function lighten(hex, f) {
    var c = hexToRgb(hex);
    return toHex(clamp(Math.round(c.r + (255 - c.r) * f), 0, 255), clamp(Math.round(c.g + (255 - c.g) * f), 0, 255), clamp(Math.round(c.b + (255 - c.b) * f), 0, 255));
  }
  var LV_COLOR = [
    "#EDB6CE",
    "#B69AE3",
    "#99D9C5",
    "#46A7A6",
    "#F3AD8D",
    "#D87694",
    "#A5C9F0",
    "#737BD1",
    "#F5DB96",
    "#EFBD54"
  ];
  var LV_DARK = [], LV_LITE = [];
  (function() {
    for (var i = 0; i < 10; i++) {
      LV_DARK.push(darken(LV_COLOR[i], 0.55));
      LV_LITE.push(lighten(LV_COLOR[i], 0.62));
    }
  })();
  var BAND_NAME = ["星芒", "星芒", "冰", "冰", "火", "火", "引力", "引力", "能量", "能量"];
  function isBandStart(lv) {
    return lv === 3 || lv === 5 || lv === 7 || lv === 9;
  }
  function coreSize(lv) {
    return lv <= 1 ? 0 : 20 + (lv - 2) * 7;
  }
  function scoreOf(n) {
    var mul = 1 + (G && G.scoreBoost ? G.scoreBoost : 0);
    if (G && G.resoLv >= 8) mul *= 1.25;
    else if (G && G.resoLv >= 1) mul *= 1.1;
    return Math.round(12 * Math.pow(n, 1.5) * mul);
  }
  var RESO_COLOR = [
    "#B9A9AE",
    "#A9BCEA",
    "#93A8DC",
    "#CBBDE8",
    "#F3C583",
    "#F7EDE2",
    "#A8DCC8",
    "#A2B8EE",
    "#D8A8E8",
    "#F6CC84",
    "#FFF6EC"
  ];
  var ACH_NAME = [
    "",
    "星芒初现",
    "星芒凝聚",
    "寒霜初结",
    "寒霜之心",
    "烈焰初燃",
    "烈焰掌控",
    "引力觉醒",
    "引力主宰",
    "能量方块",
    "能量巅峰"
  ];
  var UP_DEFS = [
    {
      id: "r",
      name: "扩张",
      w: 1.6,
      max: 1,
      desc: function() {
        return "范围半径 +0.5（现在 R" + fmtR(wellRadius()) + "）。";
      }
    },
    {
      id: "g",
      name: "增幅",
      w: 1,
      max: 2,
      desc: function() {
        return "每次合并多升 1 级（现在 4 颗升 " + wellGain(4) + " 级）。";
      }
    },
    {
      id: "c",
      name: "扩容",
      w: 3.6,
      max: 4,
      desc: function() {
        return "单次合并上限 +1（现在 " + wellCap() + " 颗）。";
      }
    },
    {
      id: "s",
      name: "贪婪",
      w: 5,
      max: 5,
      desc: function() {
        return "合并得分 ×1.35（现在 ×" + (1 + G.scoreBoost).toFixed(2) + "）。";
      }
    },
    {
      id: "m",
      name: "连击",
      w: 1,
      max: 1,
      desc: function() {
        var t = msThreshold();
        return "合并奖励提前：" + t[0] + " / " + t[1] + " / " + t[2] + " 颗就触发。";
      }
    },
    {
      id: "p",
      name: "蓄能",
      w: 4,
      max: 4,
      desc: function() {
        return "脉冲充能 +30%（现在 +" + Math.round(G.pulseBoost * 100) + "%）。";
      }
    },
    {
      id: "k",
      name: "暴击",
      w: 4.2,
      max: 3,
      desc: function() {
        return "合并有 " + Math.round((G.crit || 0) * 100) + "% 概率额外 +1 级（每次 +15%）。";
      }
    },
    {
      id: "b",
      name: "借力",
      w: 4.2,
      max: 3,
      desc: function() {
        return "合并 4 颗以上，每颗额外 +25 分（现在 +" + (G.forceBonus || 0) + "）。";
      }
    },
    {
      id: "f",
      name: "轻装",
      w: 3,
      max: 2,
      desc: function() {
        return "投料间隔 -20%（现在 " + Math.round(feedInterval()) + "ms 一颗）。";
      }
    },
    {
      id: "q",
      name: "涌流",
      w: 4.2,
      max: 3,
      desc: function() {
        return "每次合并额外 +2 能量（现在 +" + (G.resoBonus || 0) + "）。";
      }
    },
    {
      id: "e",
      name: "共鸣",
      w: 2.2,
      max: 1,
      desc: "合并 12 颗以上时，脉冲直接充满。"
    },
    {
      id: "h",
      name: "物质",
      w: 2.2,
      max: 1,
      desc: "黑块变黑洞（刷新 5%）；在它旁边合一次，吸走全场 25%。"
    }
  ];
  function fmtR(v) {
    if (v === Math.floor(v)) return String(v);
    var s = v.toFixed(2);
    if (s.charAt(s.length - 1) === "0") s = s.slice(0, -1);
    return s;
  }
  function wellCap() {
    return WELL_MAX_GROUP + (G.wellCap || 0) + (G.resoLv || 0);
  }
  var K_NORMAL = 0;
  var K_RESON = 1;
  var K_VOID = 2;
  var RESO_TH = [0, 26, 66, 130, 220, 340, 490, 670, 880, 1120, 1400];
  var RESO_TIP = [
    "",
    "合并得分 +10%",
    /* 1 */
    "范围 +1",
    /* 2 */
    "棋盘 +1 格",
    /* 3 */
    "投料必出 L2",
    /* 4 */
    "棋盘 +1 格",
    /* 5 */
    "脉冲充能 +40%",
    /* 6 */
    "棋盘 +1 格",
    /* 7 */
    "得分 +25% · 能量块 ×2",
    /* 8 */
    "棋盘 +1 格",
    /* 9 */
    "通关"
  ];
  var VOID_FEED_P = 0.075;
  var CORE_FEED_P = 0.045;
  var BLACKHOLE_P = 0.05;
  var PULSE_FULL = 140;
  var PULSE_UNIT = 7;
  var PULSE_SCORE = 50;
  function pulseTopLv() {
    if (G.resoLv >= 8) return 3;
    if (G.resoLv >= 4) return 2;
    return 1;
  }
  function pulseLabel() {
    var t = pulseTopLv();
    return t === 1 ? "L1" : t === 2 ? "L1+L2" : "L1+L2+L3";
  }
  var VOID_CLEAR_SCORE = 30;
  function resoAtLeast(n) {
    return G.resoLv >= n;
  }
  function wellRadius() {
    var r = WELL_R + (G.upRadius || 0) + (G.resoLv || 0) * 0.05;
    if (resoAtLeast(2)) r += 1;
    return r;
  }
  function SeededRand(seed) {
    var s = seed >>> 0;
    return function() {
      s = s + 1831565813 >>> 0;
      var t = s;
      t = Math.imul(t ^ t >>> 15, t | 1);
      t ^= t + Math.imul(t ^ t >>> 7, t | 61);
      return ((t ^ t >>> 14) >>> 0) / 4294967296;
    };
  }
  var DROP_CUM = [0.8, 0.94, 0.99, 1];
  function rollLevel(rnd) {
    var r = rnd();
    var lv;
    if (r < DROP_CUM[0]) lv = 1;
    else if (r < DROP_CUM[1]) lv = 2;
    else if (r < DROP_CUM[2]) lv = 3;
    else lv = 4;
    if (G.resoLv >= 4 && lv < 2) lv = 2;
    return lv;
  }
  var SEED_COUNT = 12;
  var FALLBACK_POS = [0, 1, 5, 6, 2, 3, 7, 8, 12, 13, 18, 19];
  var FALLBACK_LV = [1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 3, 3];
  var LevelGen = {
    generate: function(rnd) {
      var board = [], i, j, t;
      for (i = 0; i < G.cells; i++) board.push(null);
      var slots = [];
      for (i = 0; i < G.cells; i++) slots.push(i);
      for (i = G.cells - 1; i > 0; i--) {
        j = Math.floor(rnd() * (i + 1));
        t = slots[i];
        slots[i] = slots[j];
        slots[j] = t;
      }
      for (i = 0; i < SEED_COUNT; i++) {
        board[slots[i]] = { lv: rollLevel(rnd), kind: K_NORMAL };
      }
      var p = SEED_COUNT;
      var vn = 1 + (rnd() < 0.35 ? 1 : 0);
      for (i = 0; i < vn; i++) {
        if (p >= G.cells) break;
        board[slots[p++]] = { lv: 0, kind: K_VOID };
      }
      if (rnd() < 0.45 && p < G.cells) {
        board[slots[p++]] = { lv: rollLevel(rnd), kind: K_RESON };
      }
      return { board };
    },
    validate: function(lv) {
      var cnt = {}, i, k, pairs = 0;
      for (i = 0; i < G.cells; i++) {
        if (lv.board[i] && lv.board[i].lv > 0) {
          k = lv.board[i].lv;
          cnt[k] = (cnt[k] || 0) + 1;
        }
      }
      for (k in cnt) {
        if (cnt.hasOwnProperty(k)) pairs += Math.floor(cnt[k] / 2);
      }
      return pairs >= 2;
    },
    fallback: function() {
      var board = [], i;
      for (i = 0; i < G.cells; i++) board.push(null);
      for (i = 0; i < FALLBACK_POS.length; i++) {
        board[FALLBACK_POS[i]] = { lv: FALLBACK_LV[i], kind: K_NORMAL };
      }
      board[G.cells - 1] = { lv: 0, kind: K_VOID };
      return { board };
    }
  };
  function instantBoot(seedOpt) {
    var seed = seedOpt || (Date.now() ^ Math.floor(Math.random() * 4294967295)) >>> 0;
    var rnd = SeededRand(seed);
    var lv = null, i;
    for (i = 0; i < 20; i++) {
      lv = LevelGen.generate(rnd);
      if (LevelGen.validate(lv)) break;
    }
    if (i === 20) lv = LevelGen.fallback();
    return { seed, level: lv };
  }
  function parseSeed() {
    var m = /[?&]seed=(\d+)/.exec(window.location.search);
    return m ? parseInt(m[1], 10) >>> 0 : 0;
  }
  var CLEAR_PER = 60;
  var WELL_R = 1;
  var WELL_MAX_GROUP = 8;
  var G = {
    board: [],
    /* n×n 格：null 或 { lv, id, kind } */
    n: 5,
    /* 棋盘边长：5 起步，3/5/7/9 级各扩一格 */
    cells: 25,
    /* n×n，跟着 n 一起改 */
    els: {},
    /* id -> DOM */
    nextId: 1,
    score: 0,
    best: 0,
    maxLv: 1,
    reso: 0,
    /* 本局累积能量 */
    resoLv: 0,
    /* 等级 0–5 */
    pulse: 0,
    /* 脉冲充能 0–100 */
    pulses: 0,
    /* 本局已释放脉冲次数 */
    voidGone: 0,
    /* 本局被坍缩掉的黑块数 */
    milestones: 0,
    /* 本局触发的连锁奖励次数 */
    bestChain: 0,
    /* 本局单次操作最高合并数 */
    upRadius: 0,
    /* 升级树 · 范围半径 +0.5/次 */
    wellBoost: 0,
    /* 升级树 · 引力增幅（每次多升 1 级） */
    wellCap: 0,
    /* 升级树 · 合并上限加成 */
    scoreBoost: 0,
    /* 升级树 · 合并得分加成 */
    msStep: 0,
    /* 升级树 · 奖励提前层数（每层三档各降 2） */
    pulseBoost: 0,
    /* 升级树 · 脉冲充能加速 */
    crit: 0,
    /* 升级树 · 暴击率：合并额外 +1 级 */
    forceBonus: 0,
    /* 升级树 · 借力：4 颗以上每颗额外加分 */
    feedMul: 1,
    /* 升级树 · 轻装：投料间隔倍率 */
    resoBonus: 0,
    /* 升级树 · 涌流：每次合并额外能量 */
    pulseEcho: 0,
    /* 升级树 · 共鸣：12 颗以上脉冲充满 */
    matter: 0,
    /* 升级树 · 物质：黑块化作黑洞，黑洞旁合成会吸走场上 25% */
    upTaken: null,
    /* 升级树 · 各词条已叠加层数 */
    pendingUps: 0,
    /* 待处理的升级三选一 */
    pendingExpand: 0,
    /* 待执行的扩盘次数（等合成动画收口再动棋盘） */
    reached10: 0,
    /* **本局**是否合出过 10 级：重开按钮唯一的开放条件。
       不能用 maxLv 间接判断——「保留成长重开」虽然把等级归零，
       但玩家心理上还是「上一局已经通关过」，两套语义会打架；
       这里给一个本局专用的显式标志，applyBoot 一定清零。 */
    started: 0,
    /* 主界面点过「开始游戏」才为 1：挡掉菜单期的自动投料 */
    tally: {},
    /* 方块榜：等级 -> 本局合成数量 */
    kinds: 0,
    locked: false,
    over: false,
    seed: 0,
    dropRng: null,
    pendingBoot: null
  };
  var CH = null;
  function spiralArms(n, r0, r1, turns, phase, w0, w1) {
    var out = "", j, i, t, a, r, half, steps = 20;
    for (j = 0; j < n; j++) {
      var p0 = phase + j * (Math.PI * 2 / n);
      var d = "";
      for (i = 0; i <= steps; i++) {
        t = i / steps;
        a = p0 + turns * Math.PI * 2 * t;
        r = r0 + (r1 - r0) * t;
        half = (w0 + (w1 - w0) * t) / 2;
        d += (i ? "L" : "M") + (50 + Math.cos(a) * (r + half)).toFixed(1) + " " + (50 + Math.sin(a) * (r + half)).toFixed(1);
      }
      for (i = steps; i >= 0; i--) {
        t = i / steps;
        a = p0 + turns * Math.PI * 2 * t;
        r = r0 + (r1 - r0) * t;
        half = (w0 + (w1 - w0) * t) / 2;
        d += "L" + (50 + Math.cos(a) * (r - half)).toFixed(1) + " " + (50 + Math.sin(a) * (r - half)).toFixed(1);
      }
      out += '<path d="' + d + 'Z"/>';
    }
    return out;
  }
  function spiralLine(n, r0, r1, turns, phase) {
    var out = "", j, i, t, a, r, steps = 26;
    for (j = 0; j < n; j++) {
      var p0 = phase + j * (Math.PI * 2 / n);
      var d = "";
      for (i = 0; i <= steps; i++) {
        t = i / steps;
        a = p0 + turns * Math.PI * 2 * t;
        r = r0 + (r1 - r0) * t;
        d += (i ? "L" : "M") + (50 + Math.cos(a) * r).toFixed(1) + " " + (50 + Math.sin(a) * r).toFixed(1);
      }
      out += '<path d="' + d + '"/>';
    }
    return out;
  }
  var SWIRL_HTML = '<div class="fun"><i class="glow"></i><svg class="sw" viewBox="0 0 100 100"><g class="g g1">' + spiralArms(2, 18, 46, 1, 0, 2, 7.5) + '</g><g class="g g2">' + spiralArms(3, 15, 43, 0.75, 1.05, 1, 4.5) + '</g><g class="g g4">' + spiralLine(2, 17, 46, 1, 0.35) + '</g></svg><i class="h"></i><i class="rim"></i><b class="c"></b></div>';
  var GEO = { size: 0, cs: 0, gap: 6, inner: 0 };
  var boardEl = null, fxEl = null, cells = [];
  var burstEl = null, burstTxt = null;
  var drag = null, ghostEl = null;
  function cellXY(i) {
    var r = Math.floor(i / G.n), c = i % G.n;
    return { x: c * GEO.cs + GEO.gap / 2, y: r * GEO.cs + GEO.gap / 2 };
  }
  function layout() {
    var mid = $("mid");
    var st = $("stage");
    var reserve = 0;
    if (st) {
      var h0 = mid.clientHeight;
      var size0 = Math.floor(Math.min(mid.clientWidth, h0 - 102));
      if (size0 < 120) size0 = 120;
      var sh = Math.round(Math.max(96, Math.min(250, h0 * 0.33)));
      if (sh < 96) sh = 96;
      if (sh > 320) sh = 320;
      st.style.height = sh + "px";
      st.style.setProperty("--pfs", Math.round(Math.max(12, Math.min(22, sh * 0.078))) + "px");
      st.style.setProperty("--lfs", Math.round(Math.max(7, Math.min(11, sh * 0.04))) + "px");
      reserve = sh + 6;
    }
    var w = mid.clientWidth, h = mid.clientHeight - reserve;
    var size = Math.floor(Math.min(w, h));
    if (!size || size < 120) size = 120;
    GEO.size = size;
    GEO.cs = size / G.n;
    GEO.gap = Math.max(4, Math.round(size * 0.022));
    GEO.inner = GEO.cs - GEO.gap;
    boardEl.style.width = size + "px";
    boardEl.style.height = size + "px";
    var i, xy, c;
    for (i = 0; i < G.cells; i++) {
      xy = cellXY(i);
      c = cells[i];
      if (!c) continue;
      c.style.left = xy.x + "px";
      c.style.top = xy.y + "px";
      c.style.width = GEO.inner + "px";
      c.style.height = GEO.inner + "px";
    }
    for (var id in G.els) {
      if (!G.els.hasOwnProperty(id)) continue;
      if (holeEl && G.els[id].parentNode === holeEl) continue;
      sizeCrystal(G.els[id]);
    }
    focusRing();
  }
  function makeCrystal(lv, kind) {
    var el = document.createElement("div");
    el.className = "crystal";
    var inner = document.createElement("div");
    inner.className = "inner";
    var shd = document.createElement("i");
    shd.className = "shd";
    var gem = document.createElement("div");
    gem.className = "gem";
    var core = document.createElement("div");
    core.className = "core";
    var mark = document.createElement("div");
    mark.className = "mark";
    if (kind === K_RESON) {
      var r1 = document.createElement("i");
      r1.className = "r1";
      var r2 = document.createElement("i");
      r2.className = "r2";
      mark.appendChild(r1);
      mark.appendChild(r2);
    } else if (kind === K_VOID) {
      var x1 = document.createElement("i");
      x1.className = "x1";
      var x2 = document.createElement("i");
      x2.className = "x2";
      mark.appendChild(x1);
      mark.appendChild(x2);
      var sw = document.createElement("div");
      sw.className = "swirl";
      sw.innerHTML = SWIRL_HTML;
      mark.appendChild(sw);
    }
    inner.appendChild(shd);
    inner.appendChild(gem);
    inner.appendChild(core);
    inner.appendChild(mark);
    el.appendChild(inner);
    el.__inner = inner;
    el.__gem = gem;
    el.__core = core;
    el.__mark = mark;
    if (kind === K_VOID && G.matter) el.__hole = 1;
    setGem(el, lv, kind || 0);
    return el;
  }
  function setGem(el, lv, kind) {
    el.__lv = lv;
    el.__kind = kind || 0;
    var gem = el.__gem, core = el.__core;
    el.classList.remove("reson");
    el.classList.remove("void");
    el.classList.remove("hole");
    el.classList.remove("sp");
    if (kind === K_VOID) {
      el.classList.add("void");
      el.classList.add("sp");
      if (el.__hole) {
        el.classList.add("hole");
        gem.style.background = "#1A1218";
        gem.style.borderColor = "#140E12";
      } else {
        gem.style.background = "#2C2229";
        gem.style.borderColor = "#171014";
      }
      gem.className = "gem";
      core.style.display = "none";
      return;
    }
    if (kind === K_RESON) {
      el.classList.add("reson");
      el.classList.add("sp");
    }
    gem.style.background = LV_COLOR[lv - 1];
    gem.style.borderColor = kind === K_RESON ? "#F7EDE2" : LV_DARK[lv - 1];
    gem.className = lv >= 6 && kind !== K_RESON ? "gem diamond" : "gem";
    var cs = coreSize(lv);
    if (cs > 0) {
      core.style.display = "block";
      core.style.width = cs + "%";
      core.style.height = cs + "%";
      core.style.background = LV_LITE[lv - 1];
    } else {
      core.style.display = "none";
    }
  }
  function setPos(el, idx) {
    el.__idx = idx;
    var xy = cellXY(idx);
    el.style.transform = "translate(" + xy.x + "px," + xy.y + "px)";
  }
  function sizeCrystal(el) {
    el.style.width = GEO.inner + "px";
    el.style.height = GEO.inner + "px";
    setPos(el, el.__idx || 0);
  }
  function addCrystal(idx, lv, kind, animate, delayMs) {
    var el = makeCrystal(lv, kind || 0);
    el.style.width = GEO.inner + "px";
    el.style.height = GEO.inner + "px";
    setPos(el, idx);
    boardEl.appendChild(el);
    var id = G.nextId++;
    el.__id = id;
    G.els[id] = el;
    G.board[idx] = { lv, id, kind: kind || 0 };
    if (el.__hole) G.board[idx].hole = 1;
    if (animate) {
      if (delayMs) el.__inner.style.animationDelay = delayMs + "ms";
      el.classList.add("drop");
    }
    return id;
  }
  function removeEl(id) {
    var el = G.els[id];
    if (el && el.parentNode) el.parentNode.removeChild(el);
    delete G.els[id];
  }
  function clearAllEls() {
    for (var id in G.els) {
      if (G.els.hasOwnProperty(id)) {
        var el = G.els[id];
        if (el && el.parentNode) el.parentNode.removeChild(el);
      }
    }
    G.els = {};
  }
  function boardIsFull() {
    for (var i = 0; i < G.cells; i++) {
      if (!G.board[i]) return false;
    }
    return true;
  }
  function hasPair() {
    var cnt = {}, i, k;
    for (i = 0; i < G.cells; i++) {
      if (G.board[i] && G.board[i].kind !== K_VOID) {
        k = G.board[i].lv;
        cnt[k] = (cnt[k] || 0) + 1;
      }
    }
    for (k in cnt) {
      if (cnt.hasOwnProperty(k) && cnt[k] >= 2) return true;
    }
    return false;
  }
  function addReso(n) {
    if (G.over) return;
    G.reso += n;
    var lv = 0, i;
    for (i = RESO_TH.length - 1; i >= 0; i--) {
      if (G.reso >= RESO_TH[i]) {
        lv = i;
        break;
      }
    }
    if (lv > G.resoLv) {
      var from = G.resoLv, k;
      G.pendingUps += lv - from;
      G.resoLv = lv;
      toast("等级 " + lv + " · " + RESO_TIP[lv]);
      flashScreen(false);
      sfx("band");
      var rv = $("vReso");
      rv.classList.remove("up");
      void rv.offsetWidth;
      rv.classList.add("up");
      for (k = from + 1; k <= lv; k++) {
        if (k === 3 || k === 5 || k === 7 || k === 9) queueExpand();
      }
      if (lv >= 10) {
        G.reached10 = 1;
        setTimeout(function() {
          topAlert("已合出 Lv10 · 点「重开」可以开新局", 5200);
        }, 700);
      }
    }
    updateHUD();
  }
  var expandTimer = 0;
  function queueExpand() {
    G.pendingExpand = (G.pendingExpand || 0) + 1;
    if (expandTimer) clearTimeout(expandTimer);
    expandTimer = setTimeout(flushExpand, 330);
  }
  function flushExpand() {
    if (expandTimer) {
      clearTimeout(expandTimer);
      expandTimer = 0;
    }
    if (BURST.on) {
      expandTimer = setTimeout(flushExpand, 260);
      return;
    }
    if (HOLE.on) {
      expandTimer = setTimeout(flushExpand, 260);
      return;
    }
    var n = G.pendingExpand || 0, i;
    G.pendingExpand = 0;
    for (i = 0; i < n; i++) expandBoard();
  }
  var taTimer = 0;
  function topAlert(msg, ms) {
    var el = $("topAlert");
    if (!el) return;
    $("topAlertT").textContent = msg;
    el.classList.remove("off");
    el.classList.remove("on");
    void el.offsetWidth;
    el.classList.add("on");
    if (taTimer) clearTimeout(taTimer);
    taTimer = setTimeout(function() {
      el.classList.remove("on");
      el.classList.add("off");
      taTimer = 0;
    }, ms || 4200);
  }
  function upSummary() {
    var out = [], i, d, n;
    for (i = 0; i < UP_DEFS.length; i++) {
      d = UP_DEFS[i];
      n = upStacks(d.id);
      if (n > 0) out.push({ name: d.name, n });
    }
    return out;
  }
  function renderKeepList() {
    var box = $("winKeepList"), cnt = $("winKeepCnt");
    var list = upSummary(), i, sp, u;
    while (box.firstChild) box.removeChild(box.firstChild);
    if (cnt) cnt.textContent = list.length;
    if (!list.length) {
      sp = document.createElement("span");
      sp.className = "none";
      sp.textContent = "这一局还没拿到成长 · 开新关卡也不亏";
      box.appendChild(sp);
      return;
    }
    for (i = 0; i < list.length; i++) {
      sp = document.createElement("span");
      sp.className = "kp";
      sp.appendChild(document.createTextNode(list[i].name));
      u = document.createElement("u");
      u.textContent = "×" + list[i].n;
      sp.appendChild(u);
      box.appendChild(sp);
    }
  }
  function openRestartAsk() {
    renderKeepList();
    $("winAsk").classList.add("on");
    $("win").classList.add("on");
  }
  function closeRestartAsk() {
    $("winAsk").classList.remove("on");
    $("win").classList.remove("on");
    focusRing();
  }
  function resoPct() {
    if (G.resoLv >= RESO_TH.length - 1) return 100;
    var lo = RESO_TH[G.resoLv], hi = RESO_TH[G.resoLv + 1];
    return clamp(Math.round((G.reso - lo) / (hi - lo) * 100), 0, 100);
  }
  function addPulse(lv) {
    if (G.over) return;
    if (G.pulse >= PULSE_FULL) return;
    var gain = PULSE_UNIT + lv * 2 + Math.round(G.resoLv * 1.5);
    if (G.pulseBoost) gain = Math.round(gain * (1 + G.pulseBoost));
    if (G.resoLv >= 6) gain = Math.round(gain * 1.4);
    G.pulse = Math.min(PULSE_FULL, G.pulse + gain);
    if (G.pulse >= PULSE_FULL && !G.__pulseNoticed) {
      G.__pulseNoticed = 1;
      pulseChargeFx();
      toast("脉冲已蓄满 · " + pulseLabel() + " · 点底部「脉冲」释放");
      setTimeout(function() {
        tutSay("t5", "底下那根条满了就点「脉冲」，直接跳级，别攒着。", 5200);
      }, 900);
    }
    updateRoute();
  }
  function fillPulse() {
    if (G.over || G.pulse >= PULSE_FULL) return;
    G.pulse = PULSE_FULL;
    if (!G.__pulseNoticed) {
      G.__pulseNoticed = 1;
      pulseChargeFx();
      toast("共鸣 · 脉冲已蓄满 · 点底部「脉冲」释放");
    }
    updateRoute();
  }
  var BOLT_PAD = 20;
  function forkSpecs(w, h, L) {
    var out = [], i, x, y;
    var tx = [0.16, 0.5, 0.84];
    for (i = 0; i < 3; i++) {
      x = Math.round(w * tx[i]);
      out.push("M" + x + " 1 L" + Math.round(x - L * 0.36) + " " + Math.round(-L * 0.4) + " L" + Math.round(x + L * 0.12) + " " + Math.round(-L * 0.3) + " L" + Math.round(x - L * 0.18) + " " + Math.round(-L));
    }
    var bx = [0.3, 0.7];
    for (i = 0; i < 2; i++) {
      x = Math.round(w * bx[i]);
      out.push("M" + x + " " + (h - 1) + " L" + Math.round(x - L * 0.36) + " " + Math.round(h + L * 0.4) + " L" + Math.round(x + L * 0.12) + " " + Math.round(h + L * 0.3) + " L" + Math.round(x - L * 0.18) + " " + Math.round(h + L));
    }
    y = Math.round(h * 0.42);
    out.push("M1 " + y + " L" + Math.round(-L * 0.42) + " " + Math.round(y - L * 0.34) + " L" + Math.round(-L * 0.3) + " " + Math.round(y + L * 0.1) + " L" + Math.round(-L) + " " + Math.round(y - L * 0.16));
    y = Math.round(h * 0.58);
    out.push("M" + (w - 1) + " " + y + " L" + Math.round(w + L * 0.42) + " " + Math.round(y - L * 0.34) + " L" + Math.round(w + L * 0.3) + " " + Math.round(y + L * 0.1) + " L" + Math.round(w + L) + " " + Math.round(y - L * 0.16));
    return out;
  }
  function buildBolts() {
    var b = $("bPulse");
    if (!b) return;
    var svg = b.querySelector(".bolts");
    if (!svg) return;
    var w = b.offsetWidth, h = b.offsetHeight;
    if (!w || !h) return;
    var pad = BOLT_PAD;
    svg.setAttribute("viewBox", -pad + " " + -pad + " " + (w + pad * 2) + " " + (h + pad * 2));
    svg.style.width = w + pad * 2 + "px";
    svg.style.height = h + pad * 2 + "px";
    svg.style.left = -pad + "px";
    svg.style.top = -pad + "px";
    var arcs = svg.querySelectorAll(".arc"), i;
    for (i = 0; i < arcs.length; i++) {
      arcs[i].setAttribute("x", -3);
      arcs[i].setAttribute("y", -3);
      arcs[i].setAttribute("width", w + 6);
      arcs[i].setAttribute("height", h + 6);
      arcs[i].setAttribute("rx", Math.min(15, Math.round(h / 4) + 3));
    }
    var L = Math.max(11, Math.min(pad - 2, Math.round(h * 0.42)));
    var specs = forkSpecs(w, h, L);
    var forks = svg.querySelectorAll(".fork");
    for (i = 0; i < forks.length && i < specs.length; i++) {
      forks[i].setAttribute("d", specs[i]);
    }
  }
  function pulseChargeFx() {
    var b = $("bPulse");
    if (!b) return;
    b.classList.add("charged");
    buildBolts();
    b.classList.remove("pop");
    void b.offsetWidth;
    b.classList.add("pop");
    setTimeout(function() {
      b.classList.remove("pop");
    }, 470);
    var r = b.getBoundingClientRect();
    var bw = b.offsetWidth, bh = b.offsetHeight;
    var cx = r.left + r.width / 2, cy = r.top + r.height / 2;
    var g = document.createElement("div");
    g.className = "pulseGhost";
    g.style.left = cx - bw / 2 + "px";
    g.style.top = cy - bh / 2 + "px";
    g.style.width = bw + "px";
    g.style.height = bh + "px";
    document.body.appendChild(g);
    setTimeout(function() {
      if (g.parentNode) g.parentNode.removeChild(g);
    }, 1060);
    flashScreen(false);
    sfx("band");
  }
  function releasePulse() {
    if (G.locked || G.over) return;
    if (G.pulse < PULSE_FULL) {
      toast("脉冲充能 " + G.pulse + "% · 还需 " + (PULSE_FULL - G.pulse) + "%");
      return;
    }
    var topLv = pulseTopLv();
    var list = [], i, c;
    for (i = 0; i < G.cells; i++) {
      c = G.board[i];
      if (!c || c.kind === K_VOID) continue;
      if (c.lv >= 1 && c.lv <= topLv) list.push(i);
    }
    if (!list.length) {
      toast("没有可升级的方块");
      return;
    }
    G.locked = true;
    G.pulse = 0;
    G.__pulseNoticed = 0;
    G.pulses++;
    var pts = 0;
    for (i = 0; i < list.length; i++) {
      var idx = list[i], cell = G.board[idx];
      if (!cell) continue;
      var nlv = cell.lv + 1;
      if (nlv > 10) nlv = 10;
      cell.lv = nlv;
      if (cell.kind === K_RESON && nlv > 1) cell.kind = K_RESON;
      G.score += PULSE_SCORE;
      pts += PULSE_SCORE;
      if (nlv > G.maxLv) G.maxLv = nlv;
      G.tally[nlv] = (G.tally[nlv] || 0) + 1;
      var el = G.els[cell.id];
      if (el) {
        setGem(el, nlv, cell.kind || 0);
        el.classList.add("pop");
        (function(e2) {
          setTimeout(function() {
            if (e2) e2.classList.remove("pop");
          }, 300);
        })(el);
      }
    }
    G.locked = false;
    flashScreen(false);
    sfx("band");
    floatScore(list[0], pts, true);
    addReso(G.resoLv * 3);
    toast("脉冲 · " + pulseLabel() + " · " + list.length + " 颗升级 · +" + pts);
    updateHUD();
    if (G.pendingUps > 0) markUpPending();
  }
  function clearVoidNear(idx) {
    if (G.over) return 0;
    var nb = around8(idx), i, cell, n = 0;
    for (i = 0; i < nb.length; i++) {
      cell = G.board[nb[i]];
      if (!cell || cell.kind !== K_VOID) continue;
      if (cell.hole) continue;
      removeEl(cell.id);
      G.board[nb[i]] = null;
      n++;
    }
    if (n > 0) {
      var pts = n * VOID_CLEAR_SCORE;
      G.score += pts;
      G.voidGone += n;
      floatScore(idx, pts);
      toast("黑块被冲掉 ×" + n + " · +" + pts);
      sfx("drop");
      updateHUD();
    }
    return n;
  }
  function convertHoles() {
    var i, c, el, n = 0;
    for (i = 0; i < G.cells; i++) {
      c = G.board[i];
      if (!c || c.kind !== K_VOID || c.hole) continue;
      c.hole = 1;
      el = G.els[c.id];
      if (el) {
        el.__hole = 1;
        setGem(el, c.lv, c.kind);
        el.classList.add("pop");
        (function(e) {
          setTimeout(function() {
            e.classList.remove("pop");
          }, 260);
        })(el);
      }
      n++;
    }
    return n;
  }
  function holeNear(idx, froms) {
    if (!G.matter) return -1;
    var best = -1, bestD = 1e9, seen = {}, j, k, nb, c, d, at, n = froms ? froms.length : 0;
    for (j = -1; j < n; j++) {
      at = j < 0 ? idx : froms[j];
      if (at === void 0 || at < 0) continue;
      nb = around8(at);
      for (k = 0; k < nb.length; k++) {
        if (seen[nb[k]]) continue;
        seen[nb[k]] = 1;
        if (nb[k] === idx) continue;
        c = G.board[nb[k]];
        if (!c || c.kind !== K_VOID || !c.hole) continue;
        d = distE(nb[k], idx);
        if (d < bestD) {
          bestD = d;
          best = nb[k];
        }
      }
    }
    return best;
  }
  function consumeVoid(from, to) {
    var a = G.board[from], b = G.board[to], n = 0, el;
    if (b && b.kind === K_VOID) {
      removeEl(b.id);
      G.board[to] = null;
      n++;
    }
    if (a && a.kind === K_VOID) {
      removeEl(a.id);
      G.board[from] = null;
      n++;
    }
    if (a && a.kind !== K_VOID && !G.board[to]) {
      G.board[to] = a;
      G.board[from] = null;
      el = G.els[a.id];
      if (el) {
        setPos(el, to);
        el.classList.add("pop");
        setTimeout(function() {
          el.classList.remove("pop");
        }, 240);
      }
    }
    if (!n) return;
    var pts = n * VOID_CLEAR_SCORE;
    G.score += pts;
    G.voidGone += n;
    floatScore(to, pts);
    toast("黑块消失 ×" + n + " · +" + pts);
    sfx("drop");
    updateHUD();
    focusRing();
  }
  function around8(i) {
    var r = Math.floor(i / G.n), c = i % G.n, out = [], dr, dc, nr, nc;
    for (dr = -1; dr <= 1; dr++) {
      for (dc = -1; dc <= 1; dc++) {
        if (!dr && !dc) continue;
        nr = r + dr;
        nc = c + dc;
        if (nr < 0 || nr >= G.n || nc < 0 || nc >= G.n) continue;
        out.push(nr * G.n + nc);
      }
    }
    return out;
  }
  function updateHUD() {
    $("vScore").textContent = G.score;
    $("vBest").textContent = Math.max(G.best, G.score);
    var rv = $("vReso");
    rv.textContent = "Lv" + G.resoLv;
    rv.style.color = RESO_COLOR[G.resoLv];
    var nxt = G.resoLv < RESO_TH.length - 1 ? RESO_COLOR[G.resoLv + 1] : RESO_COLOR[G.resoLv];
    var bar = $("vResoBar");
    bar.style.width = resoPct() + "%";
    bar.style.background = "linear-gradient(90deg," + RESO_COLOR[G.resoLv] + "," + nxt + ")";
    $("bFeed").disabled = G.over || boardIsFull();
    updateRoute();
    updateCodex();
  }
  function updateRoute() {
    $("rAbs").textContent = "R" + fmtR(wellRadius());
    $("rChain").textContent = wellCap();
    if (G.resoLv >= RESO_TH.length - 1) {
      $("rReso").textContent = "满级";
    } else {
      $("rReso").textContent = G.reso + "/" + RESO_TH[G.resoLv + 1];
    }
    $("rBar").style.width = resoPct() + "%";
    var pe = $("rPulse"), pb = $("bPulse");
    var full = G.pulse >= PULSE_FULL && !G.over;
    if (pe) pe.textContent = full ? pulseLabel() : Math.floor(G.pulse / PULSE_FULL * 100) + "%";
    if (pb) {
      if (full) pb.classList.add("charged");
      else {
        pb.classList.remove("charged");
        pb.classList.remove("pop");
      }
    }
  }
  function updateCodex() {
    var i, n, kinds = 0;
    for (i = 1; i <= 10; i++) {
      n = G.tally[i] || 0;
      if (n > 0) kinds++;
      var pip = cxPips[i - 1];
      if (!pip) continue;
      pip.className = n > 0 ? "pip on" : "pip";
      pip.style.color = n > 0 ? LV_COLOR[i - 1] : "";
      pip.__pc.textContent = n;
      var row = cxRows[i - 1];
      if (row) {
        row.className = n > 0 ? "cxrow on" : "cxrow";
        row.__ct.textContent = n;
      }
    }
    G.kinds = kinds;
    $("cxKinds").textContent = kinds + "/10";
    var best = G.maxLv < 1 ? 1 : G.maxLv;
    $("cxBest").textContent = "Lv" + best;
    $("cxBest").style.color = LV_COLOR[best - 1];
    $("cxAch").textContent = "最佳 · " + ACH_NAME[best];
    $("cxAchLv").textContent = "Lv" + best;
    $("cxAchLv").style.color = LV_COLOR[best - 1];
    $("cxAchNm").textContent = ACH_NAME[best];
    var sb = $("stats");
    if (sb) {
      if (G.reached10) sb.classList.add("maxed");
      else sb.classList.remove("maxed");
    }
  }
  var SVGNS = "http://www.w3.org/2000/svg";
  var chainSvg = null, chainSvgAbs = null, ringEl = null, ringTagEl = null, predEl = null, guideEl = null;
  var cxPips = [], cxRows = [];
  function buildChainFx() {
    chainSvgAbs = document.createElementNS(SVGNS, "svg");
    chainSvgAbs.setAttribute("id", "chainSvg");
    chainSvgAbs.setAttribute("class", "abs");
    chainSvg = document.createElementNS(SVGNS, "svg");
    chainSvg.setAttribute("id", "chainSvg");
    ringEl = document.createElement("div");
    ringEl.id = "ring";
    ringEl.innerHTML = '<svg viewBox="0 0 100 100" preserveAspectRatio="none" aria-hidden="true"><circle cx="50" cy="50" r="49.6" fill="none" stroke="rgba(176,196,236,.92)" stroke-width="0.72" stroke-dasharray="6.2 4.2" stroke-linecap="butt"/></svg>';
    ringTagEl = document.createElement("div");
    ringTagEl.id = "ringTag";
    predEl = document.createElement("div");
    predEl.id = "predTag";
    guideEl = document.createElement("div");
    guideEl.id = "guide";
    fxEl.appendChild(chainSvgAbs);
    fxEl.appendChild(chainSvg);
    fxEl.appendChild(guideEl);
    fxEl.appendChild(ringEl);
    fxEl.appendChild(ringTagEl);
    fxEl.appendChild(predEl);
  }
  function clearFx() {
    if (!fxEl) return;
    var keep = [chainSvgAbs, chainSvg, ringEl, ringTagEl, predEl, guideEl], arr = [], i;
    for (i = 0; i < fxEl.childNodes.length; i++) arr.push(fxEl.childNodes[i]);
    for (i = 0; i < arr.length; i++) {
      if (keep.indexOf(arr[i]) < 0 && arr[i].parentNode) arr[i].parentNode.removeChild(arr[i]);
    }
  }
  function cellCenter(idx) {
    var xy = cellXY(idx);
    return { x: xy.x + GEO.inner / 2, y: xy.y + GEO.inner / 2 };
  }
  function distE(a, b) {
    var dr = Math.floor(a / G.n) - Math.floor(b / G.n);
    var dc = a % G.n - b % G.n;
    return Math.sqrt(dr * dr + dc * dc);
  }
  function showGuide(from, to) {
    if (!guideEl || !GEO.cs) return;
    var a = cellCenter(from), b = cellCenter(to);
    var dx = b.x - a.x, dy = b.y - a.y;
    var len = Math.sqrt(dx * dx + dy * dy);
    if (len < 1) {
      hideGuide();
      return;
    }
    var ang = Math.atan2(dy, dx) * 180 / Math.PI;
    guideEl.style.width = len.toFixed(1) + "px";
    guideEl.style.transform = "translate(" + a.x.toFixed(1) + "px," + a.y.toFixed(1) + "px) rotate(" + ang.toFixed(2) + "deg)";
    guideEl.classList.add("on");
  }
  function hideGuide() {
    if (guideEl) guideEl.classList.remove("on");
  }
  function addSeg(from, to, color, w, isAbs) {
    if (!chainSvg) return;
    var a = cellCenter(from), b = cellCenter(to);
    var ln = document.createElementNS(SVGNS, "line");
    ln.setAttribute("x1", a.x);
    ln.setAttribute("y1", a.y);
    ln.setAttribute("x2", b.x);
    ln.setAttribute("y2", b.y);
    ln.setAttribute("stroke", color);
    ln.setAttribute("stroke-width", w);
    (isAbs ? chainSvgAbs : chainSvg).appendChild(ln);
  }
  function markChain(idx, isOver) {
    if (!cells[idx]) return;
    cells[idx].classList.add("chain");
    if (isOver) cells[idx].classList.add("over");
  }
  function showRing(idx, r, isOver) {
    if (!ringEl || !GEO.cs) return;
    clearFocusGem();
    var c = cellCenter(idx), d = 2 * r * GEO.cs;
    ringEl.style.left = c.x + "px";
    ringEl.style.top = c.y + "px";
    ringEl.style.width = d + "px";
    ringEl.style.height = d + "px";
    ringEl.classList.add("on");
    ringEl.classList.remove("focus");
    if (isOver) ringEl.classList.add("over");
    else ringEl.classList.remove("over");
    var ty;
    if (d >= GEO.size - 1) {
      ty = c.y - GEO.cs * 0.62;
      if (ty < 12) ty = c.y + GEO.cs * 0.62;
    } else {
      ty = c.y - d / 2 - 12;
      if (ty < 10) ty = c.y + d / 2 + 12;
    }
    ringTagEl.textContent = "吸附范围 R" + fmtR(r);
    var hw = ringTagEl.offsetWidth / 2;
    ringTagEl.style.left = clamp(c.x, hw + 3, GEO.size - hw - 3) + "px";
    ringTagEl.style.top = ty + "px";
    ringTagEl.classList.add("on");
    ringTagEl.classList.remove("focus");
    if (isOver) ringTagEl.classList.add("over");
    else ringTagEl.classList.remove("over");
  }
  function hideRing() {
    if (!ringEl) return;
    ringEl.classList.remove("on");
    ringEl.classList.remove("focus");
    ringEl.classList.remove("over");
    ringTagEl.classList.remove("on");
    ringTagEl.classList.remove("focus");
    ringTagEl.classList.remove("over");
    hideGuide();
    clearFocusGem();
  }
  var focusEl = null;
  function clearFocusGem() {
    if (focusEl) {
      focusEl.classList.remove("focusgem");
      focusEl = null;
    }
  }
  function focusIdx() {
    var best = -1, bi = -1, i, c;
    for (i = 0; i < G.cells; i++) {
      c = G.board[i];
      if (c && c.lv > 0 && c.lv > best) {
        best = c.lv;
        bi = i;
      }
    }
    return bi;
  }
  function focusRing() {
    if (!ringEl || !GEO.cs) return;
    if (drag || CH) return;
    if (HOLE.on) {
      hideRing();
      return;
    }
    var bi = focusIdx();
    if (bi < 0) {
      hideRing();
      return;
    }
    var c = G.board[bi], r = wellRadius();
    hideRing();
    if (c) {
      var el = G.els[c.id];
      if (el) {
        el.classList.add("focusgem");
        focusEl = el;
      }
    }
    var cen = cellCenter(bi);
    var ty = cen.y - GEO.cs * 0.64;
    if (ty < 12) ty = cen.y + GEO.cs * 0.64;
    ringTagEl.textContent = "范围 R" + fmtR(r);
    var hw = ringTagEl.offsetWidth / 2;
    ringTagEl.style.left = clamp(cen.x, hw + 3, GEO.size - hw - 3) + "px";
    ringTagEl.style.top = ty + "px";
    ringTagEl.classList.add("on");
    ringTagEl.classList.add("focus");
  }
  function clearChainFx() {
    var i;
    if (chainSvg) {
      while (chainSvg.firstChild) chainSvg.removeChild(chainSvg.firstChild);
    }
    if (chainSvgAbs) {
      while (chainSvgAbs.firstChild) chainSvgAbs.removeChild(chainSvgAbs.firstChild);
    }
    if (ringEl) {
      ringEl.classList.remove("on");
      ringEl.classList.remove("over");
    }
    if (ringTagEl) {
      ringTagEl.classList.remove("on");
      ringTagEl.classList.remove("over");
    }
    for (i = 0; i < G.cells; i++) {
      if (!cells[i]) continue;
      cells[i].classList.remove("chain");
      cells[i].classList.remove("over");
    }
  }
  var toastTimer = 0;
  function toast(msg) {
    var t = $("toast");
    t.textContent = msg;
    t.classList.add("on");
    if (toastTimer) clearTimeout(toastTimer);
    toastTimer = setTimeout(function() {
      t.classList.remove("on");
    }, 1300);
  }
  var TUT_SEEN = {};
  var tutTimer = 0;
  function tutSay(key, text, hold) {
    if (TUT_SEEN[key]) return;
    TUT_SEEN[key] = 1;
    var b = $("tut");
    if (!b) return;
    $("tutT").textContent = text;
    b.classList.add("on");
    if (tutTimer) clearTimeout(tutTimer);
    tutTimer = setTimeout(function() {
      b.classList.remove("on");
    }, hold || 4600);
  }
  function flashScreen(strong) {
    var f = $("flash");
    f.className = strong ? "strong" : "";
    void f.offsetWidth;
    f.classList.add("on");
    setTimeout(function() {
      f.classList.remove("on");
    }, 600);
  }
  function shockwave() {
    var s = document.createElement("div");
    s.className = "shock";
    fxEl.appendChild(s);
    setTimeout(function() {
      if (s.parentNode) s.parentNode.removeChild(s);
    }, 620);
  }
  var appEl = null;
  var shakeT = 0, shakeDur = 0, shakeAmp = 0;
  function shakeScreen(n) {
    if (n <= 2) return;
    var k = n - 2;
    if (k > 6) k = 6;
    var amp = 2 + k * 0.9;
    if (amp > 7.5) amp = 7.5;
    if (amp >= shakeAmp || shakeT <= 0) {
      shakeAmp = amp;
      shakeDur = 210 + k * 24;
      shakeT = shakeDur;
    }
  }
  var burstShake = 0, burstShakeDur = 1, burstAmp = 0;
  function shakeBurst(ms, amp) {
    burstShakeDur = ms;
    burstShake = ms;
    burstAmp = amp;
  }
  function updateShake(dt) {
    if (burstShake > 0) {
      burstShake -= dt;
      if (burstShake < 0) burstShake = 0;
      var bq = burstShake / burstShakeDur;
      var ba = burstAmp * (bq > 0.78 ? 1 : bq / 0.78);
      var bp = (burstShakeDur - burstShake) * 0.115;
      if (appEl) {
        appEl.style.transform = "translate3d(" + (Math.sin(bp * 2.3) * ba).toFixed(2) + "px," + (Math.cos(bp * 3.1) * ba * 0.8).toFixed(2) + "px,0)";
      }
      if (burstShake <= 0) {
        if (appEl) appEl.style.transform = "";
        shakeT = 0;
        shakeAmp = 0;
      }
      return;
    }
    if (shakeT <= 0) return;
    shakeT -= dt;
    if (shakeT <= 0) {
      shakeT = 0;
      shakeAmp = 0;
      if (appEl) appEl.style.transform = "";
      return;
    }
    var p = shakeT / shakeDur;
    var a = shakeAmp * p;
    var ph = shakeT * 0.085;
    var x = Math.sin(ph * 2.1) * a;
    var y = Math.cos(ph * 2.7) * a * 0.72;
    if (appEl) {
      appEl.style.transform = "translate3d(" + x.toFixed(2) + "px," + y.toFixed(2) + "px,0)";
    }
  }
  var BURST = {
    on: false,
    t: 0,
    cx: 0,
    cy: 0,
    maxR: 0,
    ox: 0,
    oy: 0,
    rings: [],
    hit: null,
    bonus: 0,
    txtOn: false
  };
  var BURST_WAVE = 2e3;
  var BURST_TEXT = 1e3;
  var BURST_TOTAL = BURST_WAVE + BURST_TEXT;
  var RING_N = 3;
  var RING_DELAY = 90;
  var RING_DUR = 1800;
  var RING_OP = [0.95, 0.62, 0.34];
  var BURST_WORDS = ["全场清空", "无懈可击", "一锤定音", "满盘皆碎"];
  function ringRadius(tl) {
    if (tl <= 0 || tl >= RING_DUR) return -1;
    var p = tl / RING_DUR;
    return BURST.maxR * (1 - Math.pow(1 - p, 1.35));
  }
  function gemColor(el) {
    if (!el || !el.__gem) return "#F3C583";
    var c = el.__gem.style.background || "";
    if (!c) {
      try {
        c = window.getComputedStyle(el.__gem).backgroundColor || "";
      } catch (e) {
        c = "";
      }
    }
    if (!c || c === "transparent" || c === "rgba(18,12,16,0)") return "#F3C583";
    return c;
  }
  function shatterAt(x, y, color) {
    var n = 6 + Math.floor(Math.random() * 4), i;
    for (i = 0; i < n; i++) {
      var a = Math.random() * Math.PI * 2;
      var sp = GEO.inner * (0.45 + Math.random() * 0.95);
      var w = Math.max(3, GEO.inner * (0.09 + Math.random() * 0.11));
      var hh = w * (0.55 + Math.random() * 0.75);
      var p = document.createElement("i");
      p.className = "shat";
      p.style.left = x.toFixed(1) + "px";
      p.style.top = y.toFixed(1) + "px";
      p.style.width = w.toFixed(1) + "px";
      p.style.height = hh.toFixed(1) + "px";
      p.style.background = color;
      p.style.boxShadow = "0 0 7px " + color;
      p.style.setProperty("--dx", (Math.cos(a) * sp).toFixed(1) + "px");
      p.style.setProperty("--dy", (Math.sin(a) * sp).toFixed(1) + "px");
      p.style.setProperty("--rot", Math.round(Math.random() * 720 - 360) + "deg");
      p.style.animationDuration = (0.5 + Math.random() * 0.32).toFixed(2) + "s";
      p.style.animationDelay = (Math.random() * 0.07).toFixed(3) + "s";
      burstEl.appendChild(p);
    }
  }
  function burstStart(bonus) {
    if (!burstEl || !appEl) return;
    var i, w, h, dxm, dym, r;
    BURST.on = true;
    BURST.t = 0;
    BURST.bonus = bonus;
    BURST.txtOn = false;
    BURST.hit = {};
    appEl.style.transform = "";
    var ar = appEl.getBoundingClientRect();
    var br = boardEl.getBoundingClientRect();
    BURST.ox = br.left - ar.left;
    BURST.oy = br.top - ar.top;
    BURST.cx = BURST.ox + br.width / 2;
    BURST.cy = BURST.oy + br.height / 2;
    w = ar.width;
    h = ar.height;
    dxm = Math.max(BURST.cx, w - BURST.cx);
    dym = Math.max(BURST.cy, h - BURST.cy);
    BURST.maxR = Math.sqrt(dxm * dxm + dym * dym) * 1.08;
    while (burstEl.firstChild) burstEl.removeChild(burstEl.firstChild);
    BURST.rings = [];
    for (i = 0; i < RING_N; i++) {
      r = document.createElement("div");
      r.className = "bring";
      r.style.left = BURST.cx + "px";
      r.style.top = BURST.cy + "px";
      r.style.width = "0px";
      r.style.height = "0px";
      r.style.transform = "translate(-50%,-50%)";
      r.style.display = "none";
      burstEl.appendChild(r);
      BURST.rings.push(r);
    }
    burstEl.appendChild(burstTxt);
    burstTxt.className = "";
    burstEl.classList.add("on");
    hideRing();
    hideGuide();
    clearFocusGem();
    shakeBurst(BURST_WAVE - 120, 6.4);
    flashScreen(true);
    sfxBoom();
  }
  function burstSweep(r) {
    var i, c, xy, dx, dy, d, el;
    for (i = 0; i < G.cells; i++) {
      if (BURST.hit[i]) continue;
      c = G.board[i];
      if (!c) continue;
      xy = cellCenter(i);
      dx = xy.x + BURST.ox - BURST.cx;
      dy = xy.y + BURST.oy - BURST.cy;
      d = Math.sqrt(dx * dx + dy * dy);
      if (d - GEO.inner * 0.5 > r) continue;
      BURST.hit[i] = 1;
      el = G.els[c.id] || null;
      shatterAt(xy.x + BURST.ox, xy.y + BURST.oy, gemColor(el));
      G.board[i] = null;
      removeEl(c.id);
    }
  }
  function showBurstTxt(bonus) {
    if (!burstTxt) return;
    var bn = burstTxt.querySelector(".bn");
    var bs = burstTxt.querySelector(".bs");
    if (bn) bn.textContent = "+" + bonus;
    if (bs) bs.textContent = "满级 · " + BURST_WORDS[Math.floor(Math.random() * BURST_WORDS.length)];
    burstTxt.className = "on";
    sfx("band");
  }
  function burstEnd() {
    BURST.on = false;
    BURST.txtOn = false;
    BURST.rings = [];
    if (burstTxt) burstTxt.className = "";
    if (burstEl) {
      var i;
      for (i = 0; i < burstEl.childNodes.length; i++) {
        if (burstEl.childNodes[i] !== burstTxt) {
          burstEl.removeChild(burstEl.childNodes[i]);
          i--;
        }
      }
      burstEl.classList.remove("on");
    }
    updateHUD();
  }
  function updateBurst(dt) {
    if (!BURST.on) return;
    BURST.t += dt;
    var t = BURST.t, i, r, el, p;
    for (i = 0; i < RING_N; i++) {
      el = BURST.rings[i];
      if (!el) continue;
      r = ringRadius(t - i * RING_DELAY);
      if (r < 0) {
        if (el.style.display !== "none") el.style.display = "none";
        continue;
      }
      p = (t - i * RING_DELAY) / RING_DUR;
      el.style.display = "block";
      el.style.width = (r * 2).toFixed(1) + "px";
      el.style.height = (r * 2).toFixed(1) + "px";
      el.style.opacity = (RING_OP[i] * Math.min(1, (1 - p) / 0.3)).toFixed(3);
    }
    r = ringRadius(t);
    if (r >= 0) burstSweep(r);
    if (!BURST.txtOn && t >= BURST_WAVE) {
      BURST.txtOn = true;
      burstSweep(1e9);
      showBurstTxt(BURST.bonus);
    }
    if (t >= BURST_TOTAL) burstEnd();
  }
  var HOLE = {
    on: false,
    t: 0,
    dur: 0,
    idx: -1,
    cx: 0,
    cy: 0,
    ox: 0,
    oy: 0,
    items: [],
    vortex: null,
    bonus: 0,
    reserved: {},
    blockId: 0,
    out: 0,
    /* 演出不锁盘之后，玩家完全可能在上一场还没演完时又擦到另一个洞。
       演出层只有一套（HOLE.items / vortex 都是单份），第二场直接开就会把
       第一场的方块和漩涡顶掉。所以这里排个队：正在演就记下格号，
       holeEnd 收干净之后再接着演下一场。 */
    next: -1
  };
  var HOLE_GROW = 420;
  var HOLE_LOCK = 250;
  var HOLE_RISE = 560;
  var HOLE_HOLD = 210;
  var HOLE_HOLD_ROT = 22;
  var HOLE_FLY = 800;
  var HOLE_TAIL = 620;
  var HOLE_OUTRO = 340;
  var HOLE_PCT = 0.25;
  var holeEl = null;
  function holeScore(lv) {
    return Math.round((26 + lv * 18) * (1 + (G.scoreBoost || 0)));
  }
  function holePicks(except, pct) {
    var i, c, lv, k, arr, j, tmp, rnd = G.dropRng || Math.random;
    var byLv = {}, order = [], out = [], cand = 0, want;
    for (i = 0; i < G.cells; i++) {
      if (i === except) continue;
      c = G.board[i];
      if (!c || c.kind === K_VOID) continue;
      cand++;
    }
    if (!cand) return out;
    want = Math.round(cand * pct);
    if (want < 1) want = 1;
    if (want > cand) want = cand;
    for (i = 0; i < G.cells; i++) {
      if (i === except) continue;
      c = G.board[i];
      if (!c || c.kind === K_VOID) continue;
      lv = c.lv || 1;
      if (!byLv[lv]) {
        byLv[lv] = [];
        order.push(lv);
      }
      byLv[lv].push(i);
    }
    order.sort(function(a, b) {
      return a - b;
    });
    for (k = 0; k < order.length && out.length < want; k++) {
      arr = byLv[order[k]];
      for (i = arr.length - 1; i > 0; i--) {
        j = Math.floor(rnd() * (i + 1));
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
      for (i = 0; i < arr.length && out.length < want; i++) out.push(arr[i]);
    }
    return out;
  }
  function makeVortex(cx, cy, size) {
    var v = document.createElement("div");
    v.className = "vortex";
    v.style.left = cx.toFixed(1) + "px";
    v.style.top = cy.toFixed(1) + "px";
    v.style.width = size.toFixed(1) + "px";
    v.style.height = size.toFixed(1) + "px";
    v.innerHTML = '<div class="swirl">' + SWIRL_HTML + "</div>";
    holeEl.appendChild(v);
    if (v.offsetWidth >= 0) v.classList.add("grow");
    return v;
  }
  function holeFire(idx) {
    if (!holeEl) return 0;
    var c = G.board[idx];
    if (!c || c.kind !== K_VOID || !c.hole) return 0;
    if (HOLE.on) {
      HOLE.next = idx;
      return 0;
    }
    var rnd = G.dropRng || Math.random;
    if (appEl) appEl.style.transform = "";
    var ar = appEl ? appEl.getBoundingClientRect() : { left: 0, top: 0 };
    var br = boardEl.getBoundingClientRect();
    var ox = br.left - ar.left, oy = br.top - ar.top;
    var cp = cellCenter(idx);
    HOLE.on = true;
    HOLE.t = 0;
    HOLE.idx = idx;
    HOLE.out = 0;
    HOLE.ox = ox;
    HOLE.oy = oy;
    HOLE.cx = ox + cp.x;
    HOLE.cy = oy + cp.y;
    HOLE.items = [];
    HOLE.reserved = {};
    HOLE.bonus = 0;
    HOLE.reserved[idx] = 1;
    HOLE.dur = HOLE_GROW + HOLE_TAIL;
    var vel = G.els[c.id] || null;
    G.board[idx] = null;
    HOLE.blockId = c.id;
    if (vel) vel.classList.add("holefire");
    holeEl.classList.add("on");
    HOLE.vortex = makeVortex(HOLE.cx, HOLE.cy, GEO.inner);
    hideRing();
    hideGuide();
    clearFocusGem();
    sfxHole();
    shakeBurst(HOLE_GROW + 240, 2.6);
    var picks = holePicks(idx, HOLE_PCT), i, pi, pc, pel, p0, ex, ey, dx, dy;
    var stag = picks.length > 1 ? Math.min(48, Math.floor(700 / (picks.length - 1))) : 0;
    var maxFly = HOLE_FLY;
    for (i = 0; i < picks.length; i++) {
      pi = picks[i];
      pc = G.board[pi];
      if (!pc) continue;
      pel = G.els[pc.id] || null;
      if (!pel) {
        G.board[pi] = null;
        continue;
      }
      p0 = cellCenter(pi);
      holeEl.appendChild(pel);
      pel.style.transition = "none";
      pel.style.transform = "translate(" + (ox + p0.x).toFixed(1) + "px," + (oy + p0.y).toFixed(1) + "px)";
      pel.__inner.style.transition = "none";
      pel.classList.remove("drop");
      pel.classList.add("suck");
      ex = ox + p0.x;
      ey = oy + p0.y - GEO.inner * 1.15;
      dx = ex - HOLE.cx;
      dy = ey - HOLE.cy;
      var myFly = HOLE_FLY * (0.84 + rnd() * 0.34);
      if (myFly > maxFly) maxFly = myFly;
      HOLE.items.push({
        id: pc.id,
        el: pel,
        lv: pc.lv || 1,
        sx: ox + p0.x,
        sy: oy + p0.y,
        t0: HOLE_LOCK + i * stag,
        rad0: Math.sqrt(dx * dx + dy * dy),
        ang0: Math.atan2(dy, dx),
        turns: 1.05 + rnd() * 0.7,
        fly: myFly,
        spin: 110 + rnd() * 170,
        done: false
      });
      HOLE.bonus += holeScore(pc.lv || 1);
      G.board[pi] = null;
      HOLE.reserved[pi] = 1;
    }
    HOLE.dur = HOLE_LOCK + Math.max(0, (HOLE.items.length - 1) * stag) + HOLE_RISE + HOLE_HOLD + maxFly + HOLE_TAIL;
    return HOLE.dur;
  }
  function updateHole(dt) {
    if (!HOLE.on) return;
    HOLE.t += dt;
    var t = HOLE.t, i, it, el, p, q, e, ang, rad, x, y, sc, op;
    if (HOLE.blockId && HOLE.t >= HOLE_GROW) {
      removeEl(HOLE.blockId);
      HOLE.blockId = 0;
    }
    for (i = 0; i < HOLE.items.length; i++) {
      it = HOLE.items[i];
      if (it.done) continue;
      el = it.el;
      if (!el) {
        it.done = true;
        continue;
      }
      p = t - it.t0;
      if (p < 0) continue;
      if (p < HOLE_RISE) {
        q = p / HOLE_RISE;
        var dip, sq, sc2, rot, sway, jit, rr2, kk;
        if (q < 0.26) {
          kk = q / 0.26;
          e = 0;
          dip = -0.025 * kk;
          sq = 0.35 * kk;
          sway = 0;
          jit = Math.sin(q * 44) * 0.038 * (1 - kk * 0.55);
          sc2 = 1 + 0.075 * kk;
        } else if (q < 0.42) {
          rr2 = (q - 0.26) / 0.16;
          e = 0;
          dip = -0.025 + 0.185 * rr2;
          sq = 0.35 + 0.45 * rr2;
          sway = 0;
          jit = Math.sin(q * 44) * 0.017 * (1 - rr2);
          sc2 = 1.075 - 0.045 * rr2;
        } else {
          rr2 = (q - 0.42) / 0.58;
          e = 1 - Math.pow(1 - rr2, 1.85);
          dip = 0.16 * Math.max(0, 1 - rr2 / 0.46);
          sq = Math.max(0, 0.8 * (1 - rr2 / 0.42));
          sway = Math.sin(rr2 * Math.PI * 1.4) * 0.045 * (1 - rr2);
          jit = 0;
          sc2 = 1.03 + 0.11 * e;
        }
        x = it.sx + GEO.inner * (sway + jit);
        y = it.sy + GEO.inner * dip - GEO.inner * 1.15 * e;
        rot = it.ang0 * 57.2958 + 90 + Math.sin(q * Math.PI * 2) * 6 * (1 - q);
        el.style.transform = "translate(" + x.toFixed(1) + "px," + y.toFixed(1) + "px)";
        el.__inner.style.transform = "rotate(" + rot.toFixed(1) + "deg) scale(" + (sc2 * (1 + 0.13 * sq)).toFixed(3) + "," + (sc2 * (1 - 0.15 * sq)).toFixed(3) + ")";
        continue;
      }
      if (p < HOLE_RISE + HOLE_HOLD) {
        var hp = (p - HOLE_RISE) / HOLE_HOLD;
        x = it.sx;
        y = it.sy - GEO.inner * 1.15 + Math.sin(hp * Math.PI * 2) * GEO.inner * 0.03;
        rot = it.ang0 * 57.2958 + 90 + hp * HOLE_HOLD_ROT;
        el.style.transform = "translate(" + x.toFixed(1) + "px," + y.toFixed(1) + "px)";
        el.__inner.style.transform = "rotate(" + rot.toFixed(1) + "deg) scale(1.14)";
        continue;
      }
      q = (p - HOLE_RISE - HOLE_HOLD) / it.fly;
      if (q > 1) q = 1;
      if (q < 0) q = 0;
      rad = it.rad0 * (1 - Math.pow(q, 1.55));
      ang = it.ang0 + it.turns * Math.PI * 2 * Math.pow(q, 1.7);
      x = HOLE.cx + Math.cos(ang) * rad;
      y = HOLE.cy + Math.sin(ang) * rad;
      var kq = Math.pow(q, 1.3);
      var kSc = 1.14 * (1 - kq * 0.96);
      var st = kSc * (1 + 0.62 * Math.pow(q, 1.4));
      var sr = kSc * (1 - 0.4 * Math.pow(q, 1.4));
      var bodyRot = ang * 57.2958 + 90 + HOLE_HOLD_ROT + it.spin * Math.pow(q, 1.6);
      op = q > 0.9 ? (1 - q) / 0.1 : 1;
      el.style.transform = "translate(" + x.toFixed(1) + "px," + y.toFixed(1) + "px)";
      el.__inner.style.transform = "rotate(" + bodyRot.toFixed(1) + "deg) scale(" + st.toFixed(3) + "," + sr.toFixed(3) + ")";
      el.__inner.style.opacity = op.toFixed(3);
      if (q >= 1) {
        it.done = true;
        removeEl(it.id);
        holeGulp();
        G.score += holeScore(it.lv);
        voice(96 + it.lv * 9, 0.075, "sine", 0.022, 0, 0, 1);
        updateHUD();
        var dn = 0, j;
        for (j = 0; j < HOLE.items.length; j++) {
          if (HOLE.items[j].done) dn++;
        }
        if (dn === HOLE.items.length) holeFloat(HOLE.bonus);
      }
    }
    if (!HOLE.out && HOLE.t >= HOLE.dur - HOLE_OUTRO) {
      HOLE.out = 1;
      if (HOLE.vortex) HOLE.vortex.classList.add("out");
    }
    if (HOLE.t >= HOLE.dur) holeEnd();
  }
  function holeGulp() {
    if (!holeEl) return;
    var d = document.createElement("div");
    d.className = "hgulp";
    d.style.left = HOLE.cx.toFixed(1) + "px";
    d.style.top = HOLE.cy.toFixed(1) + "px";
    d.style.width = (GEO.inner * 0.46).toFixed(1) + "px";
    d.style.height = d.style.width;
    holeEl.appendChild(d);
    setTimeout(function() {
      if (d.parentNode) d.parentNode.removeChild(d);
    }, 520);
  }
  function holeFloat(pts) {
    if (!holeEl || !pts) return;
    var d = document.createElement("div");
    d.className = "hfloat";
    d.textContent = "+" + pts;
    d.style.left = HOLE.cx.toFixed(1) + "px";
    d.style.top = HOLE.cy.toFixed(1) + "px";
    holeEl.appendChild(d);
  }
  function holeEnd() {
    HOLE.on = false;
    HOLE.t = 0;
    HOLE.out = 0;
    var i, it, arr = [];
    for (i = 0; i < HOLE.items.length; i++) {
      it = HOLE.items[i];
      if (!it.done) {
        it.done = true;
        if (it.el && it.el.parentNode) it.el.parentNode.removeChild(it.el);
        delete G.els[it.id];
      }
    }
    HOLE.items = [];
    HOLE.reserved = {};
    if (HOLE.blockId) {
      removeEl(HOLE.blockId);
      HOLE.blockId = 0;
    }
    if (HOLE.vortex && HOLE.vortex.parentNode) HOLE.vortex.parentNode.removeChild(HOLE.vortex);
    HOLE.vortex = null;
    if (holeEl) {
      for (i = 0; i < holeEl.childNodes.length; i++) arr.push(holeEl.childNodes[i]);
      for (i = 0; i < arr.length; i++) {
        if (arr[i].parentNode) arr[i].parentNode.removeChild(arr[i]);
      }
      holeEl.classList.remove("on");
    }
    updateHUD();
    focusRing();
    var nx = HOLE.next;
    HOLE.next = -1;
    if (nx >= 0) {
      setTimeout(function() {
        holeSolo(nx);
      }, 120);
    }
  }
  function holeSolo(hIdx) {
    if (HOLE.on) {
      HOLE.next = hIdx;
      return;
    }
    hideRing();
    hideGuide();
    var d = holeFire(hIdx);
    if (!d) return;
    setTimeout(function() {
      if (HOLE.on && HOLE.idx === hIdx) holeEnd();
      updateHUD();
      focusRing();
      if (!G.over && G.pendingUps > 0) markUpPending();
    }, d + 140);
  }
  function sfxHole() {
    if (!AC) return;
    try {
      var t0 = AC.currentTime, out = busSfx || AC.destination;
      var o1 = AC.createOscillator(), g1 = AC.createGain();
      o1.type = "sine";
      o1.frequency.setValueAtTime(96, t0);
      o1.frequency.exponentialRampToValueAtTime(58, t0 + 0.42);
      o1.frequency.exponentialRampToValueAtTime(31, t0 + 1.5);
      g1.gain.setValueAtTime(1e-4, t0);
      g1.gain.exponentialRampToValueAtTime(0.105, t0 + 0.18);
      g1.gain.exponentialRampToValueAtTime(1e-4, t0 + 1.62);
      o1.connect(g1);
      g1.connect(out);
      o1.start(t0);
      o1.stop(t0 + 1.7);
      var o2 = AC.createOscillator(), g2 = AC.createGain();
      o2.type = "sine";
      o2.frequency.setValueAtTime(64, t0 + 0.1);
      o2.frequency.exponentialRampToValueAtTime(23, t0 + 1.55);
      g2.gain.setValueAtTime(1e-4, t0 + 0.1);
      g2.gain.exponentialRampToValueAtTime(0.07, t0 + 0.34);
      g2.gain.exponentialRampToValueAtTime(1e-4, t0 + 1.6);
      o2.connect(g2);
      g2.connect(out);
      o2.start(t0 + 0.1);
      o2.stop(t0 + 1.66);
      if (noiseBuf) {
        var src = AC.createBufferSource(), bp = AC.createBiquadFilter(), g3 = AC.createGain();
        src.buffer = noiseBuf;
        bp.type = "bandpass";
        bp.Q.value = 1.5;
        bp.frequency.setValueAtTime(3400, t0);
        bp.frequency.exponentialRampToValueAtTime(260, t0 + 1.42);
        g3.gain.setValueAtTime(1e-4, t0);
        g3.gain.exponentialRampToValueAtTime(0.042, t0 + 0.52);
        g3.gain.exponentialRampToValueAtTime(1e-4, t0 + 1.46);
        src.connect(bp);
        bp.connect(g3);
        g3.connect(out);
        src.start(t0);
        src.stop(t0 + 1.5);
      }
      var o3 = AC.createOscillator(), g4 = AC.createGain();
      o3.type = "triangle";
      o3.frequency.setValueAtTime(480, t0);
      o3.frequency.exponentialRampToValueAtTime(190, t0 + 0.11);
      g4.gain.setValueAtTime(1e-4, t0);
      g4.gain.exponentialRampToValueAtTime(0.048, t0 + 0.012);
      g4.gain.exponentialRampToValueAtTime(1e-4, t0 + 0.14);
      o3.connect(g4);
      g4.connect(out);
      o3.start(t0);
      o3.stop(t0 + 0.16);
    } catch (e) {
    }
  }
  function floatScore(idx, pts, big) {
    var xy = cellXY(idx);
    var d = document.createElement("div");
    d.className = big ? "fscore big" : pts < 0 ? "fscore neg" : "fscore";
    d.textContent = (pts < 0 ? "" : "+") + pts;
    var sz = 15 + Math.sqrt(Math.abs(pts)) * 0.95;
    if (sz > 40) sz = 40;
    if (sz < 15) sz = 15;
    d.style.fontSize = sz.toFixed(1) + "px";
    d.style.left = xy.x + GEO.inner / 2 + "px";
    d.style.top = xy.y + GEO.inner / 2 + "px";
    fxEl.appendChild(d);
    setTimeout(function() {
      if (d.parentNode) d.parentNode.removeChild(d);
    }, 900);
  }
  var AC = null, audioReady = false;
  var busMusic = null, busSfx = null, limiter = null, noiseBuf = null;
  var VOL = { music: 0.55, sfx: 1 };
  function ensureAudio() {
    if (audioReady) {
      if (AC && AC.state === "suspended" && AC.resume) {
        try {
          AC.resume();
        } catch (e) {
        }
      }
      return;
    }
    audioReady = true;
    try {
      var Ctx = window.AudioContext || window.webkitAudioContext;
      if (!Ctx) return;
      AC = new Ctx();
      limiter = AC.createDynamicsCompressor();
      limiter.threshold.value = -10;
      limiter.knee.value = 14;
      limiter.ratio.value = 8;
      limiter.attack.value = 3e-3;
      limiter.release.value = 0.18;
      limiter.connect(AC.destination);
      busMusic = AC.createGain();
      busMusic.gain.value = VOL.music;
      busMusic.connect(limiter);
      busSfx = AC.createGain();
      busSfx.gain.value = VOL.sfx;
      busSfx.connect(limiter);
      noiseBuf = AC.createBuffer(1, Math.floor(AC.sampleRate * 0.4), AC.sampleRate);
      var nd = noiseBuf.getChannelData(0), i;
      for (i = 0; i < nd.length; i++) nd[i] = Math.random() * 2 - 1;
    } catch (e) {
      AC = null;
    }
  }
  function setVol(kind, v) {
    if (kind === "music") VOL.music = clamp(v, 0, 1);
    else VOL.sfx = clamp(v, 0, 2);
    if (!AC) return;
    var g = kind === "music" ? busMusic : busSfx;
    if (g) g.gain.value = VOL[kind];
  }
  function varyK() {
    return 0.8 + Math.random() * 0.4;
  }
  function voice(freq, dur, type, vol, delay, detune, k, dest) {
    if (!AC) return;
    var kk = k || 1;
    try {
      var t0 = AC.currentTime + (delay || 0);
      var d = dur / kk;
      var o = AC.createOscillator(), g = AC.createGain();
      o.type = type || "sine";
      o.frequency.setValueAtTime(freq * kk, t0);
      if (detune && o.detune) o.detune.setValueAtTime(detune, t0);
      g.gain.setValueAtTime(1e-4, t0);
      g.gain.exponentialRampToValueAtTime(Math.max(4e-4, vol || 0.05), t0 + 4e-3 / kk);
      g.gain.exponentialRampToValueAtTime(1e-4, t0 + d);
      o.connect(g);
      g.connect(dest || busSfx || AC.destination);
      o.start(t0);
      o.stop(t0 + d + 0.04);
    } catch (e) {
    }
  }
  function synthNote(freq, dur, type, vol, at, detune, dest, cut, q) {
    if (!AC) return;
    try {
      var o = AC.createOscillator(), g = AC.createGain(), f = AC.createBiquadFilter();
      o.type = type || "sawtooth";
      o.frequency.setValueAtTime(freq, at);
      if (detune) o.detune.setValueAtTime(detune, at);
      var c0 = Math.max(160, cut || 2e3);
      f.type = "lowpass";
      f.Q.value = q || 1;
      f.frequency.setValueAtTime(c0, at);
      f.frequency.exponentialRampToValueAtTime(Math.max(120, c0 * 0.24), at + dur);
      g.gain.setValueAtTime(1e-4, at);
      g.gain.exponentialRampToValueAtTime(Math.max(4e-4, vol), at + 8e-3);
      g.gain.exponentialRampToValueAtTime(1e-4, at + dur);
      o.connect(f);
      f.connect(g);
      g.connect(dest || busSfx || AC.destination);
      o.start(at);
      o.stop(at + dur + 0.04);
    } catch (e) {
    }
  }
  function sfx(name) {
    if (!AC) return;
    var k = varyK();
    if (name === "drop") {
      voice(520, 0.085, "triangle", 0.05, 0, 0, k);
      voice(1040, 0.05, "sine", 0.017, 4e-3, 0, k);
    } else if (name === "merge") {
      voice(700, 0.12, "sine", 0.06, 0, 0, k);
      voice(1050, 0.07, "triangle", 0.022, 0.01, 0, k);
    } else if (name === "move") {
      voice(400, 0.045, "sine", 0.022, 0, 0, k);
    } else if (name === "fail") {
      voice(170, 0.1, "sawtooth", 0.034, 0, 0, k);
      voice(122, 0.14, "sine", 0.028, 0.03, 0, k * 0.94);
    } else if (name === "band") {
      voice(660, 0.16, "triangle", 0.05, 0, 0, k);
      voice(990, 0.2, "sine", 0.028, 0.06, 0, k);
    } else if (name === "clear") {
      voice(880, 0.24, "sine", 0.06, 0, 0, k);
      voice(1320, 0.36, "sine", 0.045, 0.05, 0, k);
      noiseBurst(0.42, 0.05, 2600, 0);
    } else if (name === "tap") {
      voice(880, 0.05, "triangle", 0.045, 0, 0, k);
      voice(1320, 0.03, "sine", 0.018, 0.022, 0, k);
    } else if (name === "upReady") {
      voice(1046, 0.13, "sine", 0.048, 0, 0, k);
      voice(1568, 0.18, "sine", 0.03, 0.062, 0, k);
      voice(2093, 0.1, "triangle", 0.014, 0.115, 0, k);
    }
  }
  function noiseBurst(dur, vol, hp, delay) {
    if (!AC || !noiseBuf) return;
    try {
      var t0 = AC.currentTime + (delay || 0);
      var src = AC.createBufferSource(), f = AC.createBiquadFilter(), g = AC.createGain();
      src.buffer = noiseBuf;
      f.type = "highpass";
      f.frequency.value = hp || 6e3;
      g.gain.setValueAtTime(vol, t0);
      g.gain.exponentialRampToValueAtTime(1e-4, t0 + dur);
      src.connect(f);
      f.connect(g);
      g.connect(busSfx || AC.destination);
      src.start(t0);
      src.stop(t0 + dur + 0.02);
    } catch (e) {
    }
  }
  function sfxBoom() {
    if (!AC) return;
    try {
      var t0 = AC.currentTime;
      var o = AC.createOscillator(), g = AC.createGain();
      o.type = "sine";
      o.frequency.setValueAtTime(170, t0);
      o.frequency.exponentialRampToValueAtTime(32, t0 + 0.8);
      g.gain.setValueAtTime(1e-4, t0);
      g.gain.exponentialRampToValueAtTime(0.3, t0 + 0.02);
      g.gain.exponentialRampToValueAtTime(1e-4, t0 + 1.05);
      o.connect(g);
      g.connect(busSfx || AC.destination);
      o.start(t0);
      o.stop(t0 + 1.1);
    } catch (e) {
    }
    noiseBurst(0.6, 0.05, 1500, 0);
    noiseBurst(0.34, 0.032, 5200, 0.05);
  }
  var SFX_BASE = 261.63;
  var SFX_PENTA = [0, 2, 4, 7, 9];
  var SFX_STEP_MAX = 12;
  function mergeFreq(step) {
    var s = (step || 1) - 1;
    if (s < 0) s = 0;
    if (s > SFX_STEP_MAX) s = SFX_STEP_MAX;
    var semi = SFX_PENTA[s % 5] + 12 * Math.floor(s / 5);
    return SFX_BASE * Math.pow(2, semi / 12);
  }
  function sfxMerge(step, lv) {
    if (!AC) return;
    var n = step || 1;
    var k = CH && CH.key || varyK();
    var base = 152 - Math.min(n, 12) * 3;
    voice(base, 0.15, "sine", 0.055, 0, 0, k);
    voice(base * 0.5, 0.22, "sine", 0.04, 0, 0, k);
    if ((lv || 0) >= 5) voice(base * 0.25, 0.26, "sine", 0.028, 0, 0, k);
    noiseBurst(0.08, 0.02, 3400, 0);
  }
  function sfxChainEnd(n, key) {
    if (!AC) return;
    if (!n || n < 4) return;
    var k = key || varyK();
    var f = mergeFreq(n);
    voice(f, 0.13, "sine", 0.032, 0, 0, k);
    voice(f * 0.749, 0.14, "sine", 0.028, 0.075, 0, k);
    voice(f * 0.5, 0.2, "sine", 0.03, 0.15, 0, k);
  }
  var MUS = { on: false, timer: 0, step: 0, nextT: 0, bar: 0 };
  var A2 = 110;
  var PROG = [
    { root: 0, type: "m" },
    /* Am */
    { root: 8, type: "M" },
    /* F  */
    { root: 3, type: "M" },
    /* C  */
    { root: 10, type: "M" },
    /* G  */
    { root: 0, type: "m" },
    /* Am */
    { root: 8, type: "M" },
    /* F  */
    { root: 5, type: "m" },
    /* Dm */
    { root: 7, type: "M" }
    /* E  */
  ];
  var TRI_M = [0, 3, 7], TRI_MJ = [0, 4, 7];
  var LEAD = [
    [[0, 12], [3, 15], [6, 19], [8, 17], [10, 15], [12, 12]],
    [[0, 15], [2, 17], [4, 20], [6, 17], [8, 15], [10, 12], [14, 15]],
    [[0, 19], [2, 22], [4, 19], [6, 15], [8, 19], [10, 27], [12, 22], [14, 19]],
    [[0, 22], [2, 19], [4, 17], [6, 14], [8, 17], [10, 22], [12, 19]],
    [[0, 12], [2, 15], [4, 19], [6, 27], [8, 24], [10, 19], [12, 15], [14, 12]],
    [[0, 20], [2, 19], [4, 17], [6, 15], [8, 17], [10, 20], [12, 27]],
    [[0, 17], [2, 20], [4, 17], [6, 15], [8, 14], [10, 17], [12, 20], [14, 17]],
    [[0, 19], [2, 23], [4, 19], [6, 26], [8, 23], [10, 19], [12, 14], [14, 19]]
  ];
  function midiHz(semi) {
    return A2 * Math.pow(2, semi / 12);
  }
  function musicStart() {
    if (!AC || MUS.on) return;
    MUS.on = true;
    MUS.step = 0;
    MUS.bar = 0;
    MUS.nextT = AC.currentTime + 0.1;
    if (MUS.timer) clearInterval(MUS.timer);
    MUS.timer = setInterval(musicTick, 60);
  }
  function musicStop() {
    MUS.on = false;
    if (MUS.timer) {
      clearInterval(MUS.timer);
      MUS.timer = 0;
    }
  }
  function musicTick() {
    if (!AC || !MUS.on) return;
    var lv = Math.min(G.resoLv || 0, 10);
    var bpm = 84 + lv * 6;
    var sd = 60 / bpm / 4;
    var now = AC.currentTime;
    if (MUS.nextT < now - 0.5) MUS.nextT = now + 0.05;
    var horizon = now + 0.22;
    var guard = 0;
    while (MUS.nextT < horizon && guard++ < 24) {
      playStep(MUS.step, MUS.nextT, lv, sd);
      MUS.nextT += sd;
      MUS.step++;
      if (MUS.step >= 16) {
        MUS.step = 0;
        MUS.bar = (MUS.bar + 1) % PROG.length;
      }
    }
  }
  function kick(at, vol) {
    if (!AC) return;
    try {
      var o = AC.createOscillator(), g = AC.createGain();
      o.type = "sine";
      o.frequency.setValueAtTime(150, at);
      o.frequency.exponentialRampToValueAtTime(44, at + 0.1);
      g.gain.setValueAtTime(vol, at);
      g.gain.exponentialRampToValueAtTime(1e-4, at + 0.17);
      o.connect(g);
      g.connect(busMusic || AC.destination);
      o.start(at);
      o.stop(at + 0.2);
    } catch (e) {
    }
  }
  function hat(at, vol, open) {
    if (!AC || !noiseBuf) return;
    try {
      var src = AC.createBufferSource(), f = AC.createBiquadFilter(), g = AC.createGain();
      src.buffer = noiseBuf;
      f.type = "highpass";
      f.frequency.value = 7600;
      var d = open ? 0.1 : 0.036;
      g.gain.setValueAtTime(vol, at);
      g.gain.exponentialRampToValueAtTime(1e-4, at + d);
      src.connect(f);
      f.connect(g);
      g.connect(busMusic || AC.destination);
      src.start(at);
      src.stop(at + d + 0.02);
    } catch (e) {
    }
  }
  function snare(at, vol) {
    if (!AC || !noiseBuf) return;
    try {
      var src = AC.createBufferSource(), f = AC.createBiquadFilter(), g = AC.createGain();
      src.buffer = noiseBuf;
      f.type = "bandpass";
      f.frequency.value = 1900;
      f.Q.value = 0.9;
      g.gain.setValueAtTime(vol, at);
      g.gain.exponentialRampToValueAtTime(1e-4, at + 0.14);
      src.connect(f);
      f.connect(g);
      g.connect(busMusic || AC.destination);
      src.start(at);
      src.stop(at + 0.16);
    } catch (e) {
    }
    synthNote(190, 0.09, "triangle", vol * 0.55, at, 0, busMusic, 900, 1);
  }
  function playStep(s, t, lv, sd) {
    var ch = PROG[MUS.bar];
    var root = ch.root;
    var tri = ch.type === "m" ? TRI_M : TRI_MJ;
    var i, semi;
    if (s === 0 || s === 8) kick(t, 0.4);
    else if (lv >= 3 && (s === 4 || s === 12)) kick(t, 0.3);
    else if (lv >= 7 && s === 14) kick(t, 0.22);
    if (lv >= 2 && (s === 4 || s === 12)) snare(t, 0.05 + lv * 3e-3);
    if (lv >= 7 && s === 15) snare(t, 0.028);
    if (s === 0 || s === 8 || lv >= 3 && s === 6 || lv >= 6 && (s === 3 || s === 11) || lv >= 9 && s === 14) {
      var oct = lv >= 9 && (s === 3 || s === 11) ? 0 : -12;
      synthNote(midiHz(root + oct), sd * 1.6, "sawtooth", 0.15, t, 0, busMusic, 640, 3);
    }
    if (lv >= 2 && s % 2 === 0) hat(t, s % 4 === 0 ? 0.05 : 0.032, false);
    if (lv >= 8) hat(t + sd * 0.5, 0.018, false);
    var lead = LEAD[MUS.bar];
    for (i = 0; i < lead.length; i++) {
      if (lead[i][0] !== s) continue;
      semi = lead[i][1];
      synthNote(
        midiHz(semi),
        sd * 1.5,
        "sawtooth",
        0.03 + lv * 18e-4,
        t,
        -6,
        busMusic,
        3e3 + lv * 180,
        2
      );
      synthNote(
        midiHz(semi),
        sd * 1.5,
        "sawtooth",
        0.023 + lv * 14e-4,
        t,
        7,
        busMusic,
        2600 + lv * 160,
        2
      );
      if (lv >= 7) {
        synthNote(
          midiHz(semi + 12),
          sd * 1.1,
          "square",
          8e-3 + lv * 6e-4,
          t,
          0,
          busMusic,
          5200,
          1
        );
      }
    }
    if (lv >= 5 && (s === 3 || s === 7 || s === 11 || s === 15)) {
      semi = tri[(s >> 2) % 3] + 12;
      synthNote(
        midiHz(root + semi),
        sd * 1.3,
        "square",
        0.016 + lv * 9e-4,
        t,
        0,
        busMusic,
        2e3 + lv * 120,
        2
      );
    }
    if (lv >= 6 && s === 0) {
      for (i = 0; i < 3; i++) {
        synthNote(
          midiHz(root + tri[i] + 12),
          sd * 15,
          "triangle",
          0.024,
          t,
          i * 4,
          busMusic,
          1100,
          1
        );
      }
    } else if (lv < 6 && s === 0) {
      synthNote(midiHz(root + 12), sd * 15, "triangle", 0.02, t, 0, busMusic, 760, 1);
    }
    if (MUS.bar === PROG.length - 1 && lv >= 4 && s >= 12) {
      hat(t, 0.03, false);
      hat(t + sd * 0.5, 0.02, false);
    }
    if (lv >= 9 && (s === 6 || s === 14)) {
      synthNote(midiHz(root + 6), sd * 1, "sawtooth", 0.03, t, 0, busMusic, 1800, 5);
    }
    if (lv >= 10 && s === 12) {
      synthNote(midiHz(root + 1), sd * 0.7, "square", 0.02, t, 0, busMusic, 2200, 4);
    }
  }
  var MEL_BASE = 12;
  var MELODIES = [
    [0, 2, 4, 7, 9, 12, 14, 16],
    /* 大调五声 */
    [0, 3, 5, 7, 10, 12, 15, 17],
    /* 小调五声 */
    [0, 2, 4, 5, 7, 9, 11, 12, 14],
    /* 自然大调 */
    [0, 2, 3, 5, 7, 8, 10, 12, 15],
    /* 自然小调 */
    [0, 4, 7, 12, 16, 19, 24],
    /* 大三和弦分解 */
    [0, 3, 7, 12, 15, 19, 24],
    /* 小三和弦分解 */
    [0, 5, 7, 12, 14, 17, 19, 24],
    /* 四度叠置，空灵 */
    [0, 2, 4, 7, 11, 12, 16, 19],
    /* 利底亚，明亮 */
    [0, 1, 5, 7, 8, 12, 13, 17],
    /* 和声小调，带异域 */
    [0, 2, 4, 6, 8, 10, 12, 14]
    /* 全音阶，上滑感最强 */
  ];
  function playRise(n, lv) {
    if (!AC || !n || n < 2) return;
    var m = MELODIES[Math.floor(Math.random() * MELODIES.length)];
    var k = CH && CH.key || varyK();
    var cnt = n > 16 ? 16 : n;
    var iv = 280 / cnt;
    if (iv > 105) iv = 105;
    if (iv < 30) iv = 30;
    var top = m.length - 1;
    var vol = 0.04 + Math.min(n, 10) * 18e-4;
    var i, idx, f;
    voice(midiHz(MEL_BASE + m[0] - 12), 0.16, "sine", vol * 0.85, 0.02, 0, k);
    for (i = 0; i < cnt; i++) {
      idx = i < top ? i : top;
      f = midiHz(MEL_BASE + m[idx]);
      voice(f, iv * 1.5 / 1e3, "triangle", vol, 0.02 + i * iv / 1e3, 0, k);
      voice(f * 2, iv * 1 / 1e3, "sine", vol * 0.32, 0.02 + i * iv / 1e3, 0, k);
    }
    if (cnt > top) {
      voice(
        midiHz(MEL_BASE + m[top]) * 2,
        0.1,
        "sine",
        vol * 0.5,
        0.02 + top * iv / 1e3,
        0,
        k
      );
    }
  }
  var anim = { q: [], timer: 0, active: false, done: null };
  function startAnim(plan, done) {
    anim.q = plan;
    anim.timer = 0;
    anim.active = true;
    anim.done = done;
  }
  function updateAnim(dt) {
    if (!anim.active) return;
    anim.timer -= dt;
    if (anim.timer > 0) return;
    if (anim.q.length === 0) {
      anim.active = false;
      var d = anim.done;
      anim.done = null;
      if (d) d();
      return;
    }
    var s = anim.q.shift();
    applyStep(s);
    anim.timer = s.dur;
  }
  function copySim(s) {
    var o = [], i;
    for (i = 0; i < G.cells; i++) o.push(s[i] ? { lv: s[i].lv, id: s[i].id } : null);
    return o;
  }
  function wellGroup(sim, lv, idx, cap) {
    var r0 = Math.floor(idx / G.n), c0 = idx % G.n;
    var rad = wellRadius();
    var lim = rad * rad;
    var list = [], i, c, dr, dc;
    for (i = 0; i < G.cells; i++) {
      c = sim[i];
      if (!c || c.kind === K_VOID || c.lv !== lv) continue;
      dr = Math.floor(i / G.n) - r0;
      dc = i % G.n - c0;
      if (dr * dr + dc * dc <= lim) list.push(i);
    }
    if (list.length > cap) {
      list.sort(function(a, b) {
        return dist(a, idx) - dist(b, idx);
      });
      list.length = cap;
    }
    return list;
  }
  function wellGain(n) {
    var g = Math.floor(Math.log(n) / Math.LN2);
    if (g < 1) g = 1;
    return g + (G.wellBoost || 0);
  }
  function nextPlan(cap) {
    var plan = [];
    if (!CH.first) return plan;
    var f = CH.first;
    CH.first = null;
    var lv = CH.baseLv, idx = f.to, i;
    var group = wellGroup(CH.sim, lv, idx, wellCap());
    var hasFrom = false;
    for (i = 0; i < group.length; i++) {
      if (group[i] === f.from) hasFrom = true;
    }
    if (!hasFrom) {
      if (group.length >= wellCap()) group[group.length - 1] = f.from;
      else group.push(f.from);
    }
    var n = group.length;
    if (n < 2) {
      CH.exhausted = true;
      return plan;
    }
    var gain = wellGain(n);
    var crit = false;
    if (G.crit && (G.dropRng ? G.dropRng() : Math.random()) < G.crit) {
      gain += 1;
      crit = true;
    }
    var nl = lv + gain;
    if (nl > 10) nl = 10;
    var froms = [], keepId = -1;
    for (i = 0; i < n; i++) {
      if (group[i] !== idx) froms.push(group[i]);
    }
    if (CH.sim[idx]) keepId = CH.sim[idx].id;
    CH.sim[idx] = { lv: nl, id: keepId, kind: (CH.sim[idx] ? CH.sim[idx].kind : 0) || 0 };
    for (i = 0; i < froms.length; i++) {
      CH.sim[froms[i]] = null;
    }
    var pts = scoreOf(n);
    if (n >= 4 && G.forceBonus) pts += n * G.forceBonus;
    plan.push({
      type: "well",
      idx,
      froms,
      lv: nl,
      base: lv,
      n,
      gain,
      crit,
      score: pts,
      dur: 400,
      mi: n
    });
    CH.idx = idx;
    CH.lv = nl;
    CH.merges = n;
    var hIdx = holeNear(idx, froms);
    if (hIdx >= 0) {
      plan.push({ type: "hole", idx: hIdx, dur: 1200 });
    }
    if (nl >= 10) {
      plan.push({ type: "clear", dur: 300 });
      CH.cleared = true;
    }
    return plan;
  }
  function predictChain(from, to) {
    var sim = copySim(G.board);
    if (!sim[to] || !sim[from]) return { n: 0, moves: [] };
    var lv = sim[to].lv;
    var group = wellGroup(sim, lv, to, wellCap());
    var hasFrom = false, i;
    for (i = 0; i < group.length; i++) {
      if (group[i] === from) hasFrom = true;
    }
    if (!hasFrom) {
      if (group.length >= wellCap()) group[group.length - 1] = from;
      else group.push(from);
    }
    var n = group.length;
    var moves = [];
    for (i = 0; i < n; i++) {
      if (group[i] !== to) moves.push({ from: group[i], to });
    }
    return { n, moves, lv, gain: wellGain(n) };
  }
  function markWillAbsorb(moves) {
    clearWillAbsorb();
    if (!moves || !moves.length) return;
    var list = [], i, c, el;
    for (i = 0; i < moves.length; i++) {
      c = G.board[moves[i].from];
      if (!c) continue;
      el = G.els[c.id];
      if (el) {
        el.classList.add("willabs");
        list.push(el);
      }
    }
    if (drag) drag.willEls = list;
  }
  function clearWillAbsorb() {
    if (!drag || !drag.willEls) return;
    for (var i = 0; i < drag.willEls.length; i++) {
      if (drag.willEls[i]) drag.willEls[i].classList.remove("willabs");
    }
    drag.willEls = [];
  }
  function markHoleHint(idx) {
    clearHoleHint();
    if (!drag || idx < 0) return;
    var c = G.board[idx];
    if (!c) return;
    var el = G.els[c.id];
    if (!el) return;
    el.classList.add("holetgt");
    drag.holeEl = el;
  }
  function clearHoleHint() {
    if (drag && drag.holeEl) {
      drag.holeEl.classList.remove("holetgt");
      drag.holeEl = null;
    }
  }
  function showPred(n, x, y, hole) {
    if (!predEl) return;
    predEl.textContent = hole ? "合并 " + n + " 颗 · 触发黑洞" : "合并 " + n + " 颗";
    var below = y < GEO.size * 0.35;
    predEl.style.left = x + "px";
    predEl.style.top = y + "px";
    predEl.style.transform = below ? "translate(-50%,250%)" : "translate(-50%,-250%)";
    predEl.classList.add("on");
    if (ringTagEl) ringTagEl.classList.remove("on");
  }
  function hidePred() {
    if (predEl) predEl.classList.remove("on");
  }
  function applyStep(s) {
    if (s.type === "well") {
      var wCell = G.board[s.idx];
      var wKeepId = wCell ? wCell.id : -1;
      var wCenter = wKeepId >= 0 ? G.els[wKeepId] : null;
      var wKill = [], wi, wf, wfe;
      if (wCenter) wCenter.classList.add("wellCharge");
      for (wi = 0; wi < s.froms.length; wi++) {
        wf = G.board[s.froms[wi]];
        if (!wf) continue;
        wKill.push(wf.id);
        wfe = G.els[wf.id];
        if (wfe) {
          setPos(wfe, s.idx);
          wfe.classList.add("wellPull");
        }
        G.board[s.froms[wi]] = null;
      }
      G.board[s.idx] = { lv: s.lv, id: wKeepId, kind: wCell ? wCell.kind || 0 : 0 };
      G.score += s.score;
      if (s.lv > G.maxLv) G.maxLv = s.lv;
      G.tally[s.lv] = (G.tally[s.lv] || 0) + 1;
      if (CH) CH.score += s.score;
      addReso(3 + s.lv * 3 + (G.resoBonus || 0));
      addPulse(s.lv);
      if (G.pulseEcho && s.n >= 12) fillPulse();
      applyMilestone(s.n);
      clearVoidNear(s.idx);
      showRing(s.idx, wellRadius(), false);
      (function(kId, kills, lv, keepIdx, pts, n, gain, crit) {
        setTimeout(function() {
          for (var j = 0; j < kills.length; j++) removeEl(kills[j]);
          if (kId >= 0) {
            var k = G.els[kId];
            if (k) {
              k.classList.remove("wellCharge");
              setGem(k, lv);
              k.classList.add("pop");
              setTimeout(function() {
                k.classList.remove("pop");
              }, 280);
            }
          }
          floatScore(keepIdx, pts);
          if (n >= 4) showMsBanner("范围 · " + n + " 颗", "+" + gain + " 级 · +" + pts);
          else if (crit) showMsBanner("暴击", "+" + gain + " 级 · +" + pts);
          updateHUD();
        }, 250);
      })(wKeepId, wKill, s.lv, s.idx, s.score, s.n, s.gain, s.crit);
      sfxMerge(s.n, s.lv);
      playRise(s.n, s.lv);
      shakeScreen(s.n);
      if (s.n >= 4) {
        flashScreen(false);
        shockwave();
      }
      if (isBandStart(s.lv)) crossBand(s.lv, s.idx);
      return;
    }
    if (s.type === "clear") {
      doClear();
      return;
    }
    if (s.type === "hole") {
      holeFire(s.idx);
      var k2;
      for (k2 = 0; k2 < anim.q.length; k2++) {
        if (anim.q[k2].type === "clear") {
          doClear();
          break;
        }
      }
      anim.q = [];
      anim.done = null;
      anim.active = false;
      s.dur = 0;
      finishChain();
      return;
    }
  }
  function crossBand(lv, idx) {
    G.score += 150;
    flashScreen(false);
    floatScore(idx, 150, true);
    sfx("band");
    updateHUD();
  }
  function doClear() {
    var n = 0, i, c;
    for (i = 0; i < G.cells; i++) {
      if (G.board[i]) n++;
    }
    var bonus = n * CLEAR_PER;
    G.score += bonus;
    G.maxLv = 10;
    G.reached10 = 1;
    if (burstEl && appEl) {
      burstStart(bonus);
    } else {
      for (i = 0; i < G.cells; i++) {
        c = G.board[i];
        if (c) removeEl(c.id);
        G.board[i] = null;
      }
    }
    updateHUD();
  }
  function moveCrystal(from, to) {
    if (G.locked || G.over) return;
    var cell = G.board[from];
    if (!cell || G.board[to] || HOLE.reserved[to]) return;
    G.board[to] = cell;
    G.board[from] = null;
    var el = G.els[cell.id];
    if (el) {
      setPos(el, to);
      el.classList.add("pop");
      setTimeout(function() {
        el.classList.remove("pop");
      }, 240);
    }
    sfx("move");
    tutSay("t3", "拖到空格是挪位置。把同色攒一堆，一次能合并一大片。", 5200);
    focusRing();
    updateHUD();
  }
  function tryMerge(from, to) {
    if (G.locked || G.over) return;
    if (from === to || from < 0 || to < 0) return;
    var a = G.board[from], b = G.board[to];
    if (!a || !b) return;
    if (a.kind === K_VOID) return;
    if (b.kind === K_VOID) {
      if (b.hole) {
        holeSolo(to);
        return;
      }
      consumeVoid(from, to);
      return;
    }
    if (a.lv !== b.lv) {
      bounce(from);
      flashBad(to);
      sfx("fail");
      return;
    }
    G.locked = true;
    hideRing();
    CH = {
      sim: copySim(G.board),
      first: { from, to },
      baseLv: a.lv,
      idx: to,
      lv: a.lv,
      merges: 0,
      key: varyK(),
      /* 整条连锁共用一个变调系数，爬阶才听得出来 */
      score: 0,
      exhausted: false,
      cleared: false
    };
    continueChain();
  }
  function continueChain() {
    if (!CH) {
      G.locked = false;
      return;
    }
    var plan = nextPlan();
    if (plan.length) {
      startAnim(plan, onSegDone);
      return;
    }
    finishChain();
  }
  function onSegDone() {
    if (!CH) {
      G.locked = false;
      return;
    }
    finishChain();
  }
  var msTimer = 0;
  function msThreshold() {
    var s = G.msStep || 0, out = [], i, v;
    for (i = 0; i < 3; i++) {
      v = [4, 6, 8][i] - s * 2;
      if (v < 2) v = 2;
      out.push(v);
    }
    if (out[1] <= out[0]) out[1] = out[0] + 1;
    if (out[2] <= out[1]) out[2] = out[1] + 1;
    return out;
  }
  function applyMilestone(mi) {
    if (!CH || !mi) return;
    var th = msThreshold();
    var pts = 0, best = null;
    if (mi >= th[0] && !CH.m4) {
      CH.m4 = 1;
      pts += 200;
      best = [th[0], "合得漂亮", "起手奖励"];
    }
    if (mi >= th[1] && !CH.m6) {
      CH.m6 = 1;
      pts += 500;
      best = [th[1], "一口气", "大合并奖励"];
    }
    if (mi >= th[2] && !CH.m8) {
      CH.m8 = 1;
      CH.spawnL3 = 1;
      pts += 1e3;
      best = [th[2], "全合掉", "额外落 1 颗 L3"];
    }
    if (!best) return;
    G.score += pts;
    G.milestones++;
    if (CH) CH.score += pts;
    flashScreen(false);
    sfx("band");
    if (CH) floatScore(CH.idx, pts, true);
    showMsBanner(best[1], "合并 " + mi + " 颗 · +" + pts);
    updateHUD();
  }
  function showMsBanner(name, sub) {
    var b = $("msBanner");
    if (!b) return;
    $("msT").textContent = name;
    $("msS").textContent = sub;
    b.classList.remove("on");
    void b.offsetWidth;
    b.classList.add("on");
    if (msTimer) clearTimeout(msTimer);
    msTimer = setTimeout(function() {
      b.classList.remove("on");
    }, 820);
  }
  function spawnBonusL3() {
    var empty = [], i;
    for (i = 0; i < G.cells; i++) {
      if (!G.board[i] && !HOLE.reserved[i]) empty.push(i);
    }
    if (!empty.length) return;
    var pick = Math.floor(G.dropRng() * empty.length);
    if (pick >= empty.length) pick = empty.length - 1;
    addCrystal(empty[pick], 3, K_NORMAL, true, 0);
    if (G.maxLv < 3) G.maxLv = 3;
    sfx("drop");
  }
  function finishChain(afterFn) {
    var ch = CH;
    CH = null;
    G.locked = false;
    if (ch) {
      if (ch.merges >= 2) {
        tutSay("t2", "喏，周围同色的全被吸过来了 —— 一次全合掉。", 5200);
        setTimeout(function() {
          tutSay("t4", "合并 4 颗跳 2 级，8 颗跳 3 级。所以啊，别急着合，先攒。", 5200);
        }, 5600);
      }
      if (ch.merges > G.bestChain) G.bestChain = ch.merges;
      if (ch.spawnL3) spawnBonusL3();
      if (!ch.cleared) sfxChainEnd(ch.merges, ch.key);
    }
    updateHUD();
    focusRing();
    if (afterFn) afterFn();
    if (!G.over) {
      if (G.pendingUps > 0) markUpPending();
    }
  }
  function markUpPending() {
    if (G.over) return;
    var box = $("bLv");
    if (!box) return;
    if (G.pendingUps > 0) {
      box.classList.add("ready");
      if (!box.__flashed) {
        box.__flashed = 1;
        box.classList.remove("flash");
        void box.offsetWidth;
        box.classList.add("flash");
        sfx("upReady");
        tutSay("t6", "左上角「等级」亮了 · 点它挑一个增益，本局一直有效。", 6200);
      }
    } else {
      box.classList.remove("ready");
      box.__flashed = 0;
    }
  }
  function openUpPanel() {
    if (G.over || G.pendingUps <= 0) return;
    if ($("up").classList.contains("on")) return;
    if (G.locked) return;
    G.pendingUps--;
    var rnd = G.dropRng || Math.random;
    var pool = [], picks = [], i, j, sel, total, acc, x;
    for (i = 0; i < UP_DEFS.length; i++) {
      if (upStacks(UP_DEFS[i].id) < UP_DEFS[i].max) pool.push(i);
    }
    for (i = 0; i < 3 && pool.length > 0; i++) {
      total = 0;
      for (j = 0; j < pool.length; j++) total += UP_DEFS[pool[j]].w;
      x = rnd() * total;
      acc = 0;
      sel = pool.length - 1;
      for (j = 0; j < pool.length; j++) {
        acc += UP_DEFS[pool[j]].w;
        if (x < acc) {
          sel = j;
          break;
        }
      }
      picks.push(pool[sel]);
      pool.splice(sel, 1);
    }
    if (!picks.length) {
      G.pendingUps++;
      markUpPending();
      return;
    }
    G.locked = true;
    $("upT").textContent = "等级 " + G.resoLv + " · 选一个方向";
    $("upS").textContent = "本局有效 · 范围 R" + fmtR(wellRadius()) + " / 合并上限 " + wellCap() + " / 脉冲 +" + Math.round(G.pulseBoost * 100) + "%";
    var btns = [$("bUpA"), $("bUpB"), $("bUpC")];
    for (i = 0; i < 3; i++) {
      if (picks[i] === void 0) {
        btns[i].style.visibility = "hidden";
        btns[i].__up = null;
      } else {
        btns[i].style.visibility = "";
        fillUpBtn(btns[i], UP_DEFS[picks[i]]);
      }
    }
    $("up").classList.add("on");
  }
  function closeUpPanel() {
    if (!$("up").classList.contains("on")) return;
    $("up").classList.remove("on");
    G.pendingUps++;
    G.locked = false;
    markUpPending();
    updateHUD();
  }
  function upStacks(id) {
    if (!G.upTaken) G.upTaken = {};
    return G.upTaken[id] || 0;
  }
  function fillUpBtn(btn, def) {
    btn.__up = def.id;
    btn.children[0].textContent = def.name;
    btn.children[1].textContent = typeof def.desc === "function" ? def.desc() : def.desc;
  }
  function pickUpgrade(id) {
    if (!$("up").classList.contains("on")) return;
    $("up").classList.remove("on");
    if (!id) {
      G.locked = false;
      updateHUD();
      return;
    }
    var i, def = null;
    for (i = 0; i < UP_DEFS.length; i++) {
      if (UP_DEFS[i].id === id) def = UP_DEFS[i];
    }
    if (def) {
      if (!G.upTaken) G.upTaken = {};
      G.upTaken[id] = (G.upTaken[id] || 0) + 1;
      if (id === "r") G.upRadius += 0.5;
      else if (id === "g") G.wellBoost += 1;
      else if (id === "c") G.wellCap += 1;
      else if (id === "s") G.scoreBoost += 0.35;
      else if (id === "m") G.msStep = (G.msStep || 0) + 1;
      else if (id === "p") G.pulseBoost += 0.3;
      else if (id === "k") G.crit = (G.crit || 0) + 0.15;
      else if (id === "b") G.forceBonus = (G.forceBonus || 0) + 25;
      else if (id === "f") {
        G.feedMul = (G.feedMul || 1) * 0.8;
        startAutoFeed();
      } else if (id === "q") G.resoBonus = (G.resoBonus || 0) + 2;
      else if (id === "e") G.pulseEcho = 1;
      else if (id === "h") {
        G.matter = 1;
        convertHoles();
      }
      G.score += 800;
      flashScreen(false);
      shockwave();
      floatScore(12, 800, true);
      sfx("band");
      toast("成长 · " + def.name + " · +800");
    }
    G.locked = false;
    updateHUD();
    if (G.over) return;
    markUpPending();
    focusRing();
  }
  function bounce(idx) {
    var c = G.board[idx];
    if (!c) return;
    var el = G.els[c.id];
    if (!el) return;
    el.classList.add("bounce");
    setTimeout(function() {
      el.classList.remove("bounce");
    }, 180);
  }
  function feed(auto) {
    if (!G.started || G.over) return;
    if (G.locked && !HOLE.on) return;
    var empty = [], i;
    for (i = 0; i < G.cells; i++) {
      if (!G.board[i] && !HOLE.reserved[i]) empty.push(i);
    }
    if (!empty.length) {
      if (!hasPair()) {
        var cleared = clearAllVoids();
        if (cleared) {
          if (!auto) toast("棋盘满了 · 挤掉 " + cleared + " 颗黑块");
          return;
        }
      }
      if (!auto) toast("棋盘满了 · 先合几对腾出空间");
      return;
    }
    var r = G.dropRng();
    var kind = K_NORMAL;
    var coreP = CORE_FEED_P * (G.resoLv >= 8 ? 2 : 1);
    var voidP = G.matter ? BLACKHOLE_P : VOID_FEED_P;
    if (r < voidP) kind = K_VOID;
    else if (r < voidP + coreP) kind = K_RESON;
    var lv = kind === K_VOID ? 0 : rollLevel(G.dropRng);
    var pick = Math.floor(G.dropRng() * empty.length);
    if (pick >= empty.length) pick = empty.length - 1;
    addCrystal(empty[pick], lv, kind, true, 0);
    if (lv > G.maxLv) G.maxLv = lv;
    updateHUD();
    sfx("drop");
    if (!auto) {
      if (kind === K_VOID && G.matter) toast("黑洞落入 · 在它旁边合一次，它会吞掉场上 25%");
      else if (kind === K_VOID) toast("黑方块落入 · 不能合并，在它旁边合一次就能冲掉");
      else if (kind === K_RESON) toast("能量块落入 · 稀有外观");
    }
  }
  var autoFeedTimer = 0;
  function feedInterval() {
    var ms = 1e3 - (G.resoLv || 0) * 100;
    if (ms < 50) ms = 50;
    ms = Math.round(ms * (G.feedMul || 1));
    if (ms < 50) ms = 50;
    return ms;
  }
  function clearAllVoids() {
    var i, c, n = 0;
    for (i = 0; i < G.cells; i++) {
      c = G.board[i];
      if (!c || c.kind !== K_VOID) continue;
      removeEl(c.id);
      G.board[i] = null;
      n++;
    }
    if (n) updateHUD();
    return n;
  }
  function startAutoFeed() {
    if (autoFeedTimer) clearTimeout(autoFeedTimer);
    autoFeedTimer = setTimeout(function tick() {
      var winOpen = $("win") && $("win").classList.contains("on");
      var setOpen = $("set") && $("set").classList.contains("on");
      if (G.started && !G.over && !winOpen && !setOpen && !menuOpen && (!G.locked || HOLE.on)) feed(true);
      autoFeedTimer = setTimeout(tick, feedInterval());
    }, feedInterval());
  }
  function applyBoot(boot2, keepUp) {
    G.seed = boot2.seed;
    G.dropRng = SeededRand((boot2.seed ^ 2654435769) >>> 0);
    G.n = 5;
    G.cells = 25;
    G.pendingExpand = 0;
    if (expandTimer) {
      clearTimeout(expandTimer);
      expandTimer = 0;
    }
    if (HOLE.on) {
      HOLE.on = false;
      HOLE.out = 0;
      HOLE.items = [];
      HOLE.reserved = {};
      HOLE.blockId = 0;
      if (HOLE.vortex && HOLE.vortex.parentNode) HOLE.vortex.parentNode.removeChild(HOLE.vortex);
      HOLE.vortex = null;
      if (holeEl) holeEl.classList.remove("on");
    }
    HOLE.next = -1;
    clearAllEls();
    clearChainFx();
    clearFx();
    if (cells.length !== G.cells) rebuildCells();
    G.board = [];
    G.nextId = 1;
    G.score = 0;
    G.maxLv = 1;
    G.reached10 = 0;
    G.reso = 0;
    G.resoLv = 0;
    G.pulse = 0;
    G.pulses = 0;
    G.voidGone = 0;
    G.milestones = 0;
    G.bestChain = 0;
    G.__pulseNoticed = 0;
    if (!keepUp) {
      G.upRadius = 0;
      G.wellBoost = 0;
      G.wellCap = 0;
      G.scoreBoost = 0;
      G.msStep = 0;
      G.pulseBoost = 0;
      G.crit = 0;
      G.forceBonus = 0;
      G.feedMul = 1;
      G.resoBonus = 0;
      G.pulseEcho = 0;
      G.matter = 0;
      G.upTaken = {};
    }
    G.pendingUps = 0;
    G.tally = {};
    for (i = 1; i <= 10; i++) G.tally[i] = 0;
    CH = null;
    G.locked = false;
    G.over = false;
    $("up").classList.remove("on");
    $("msBanner").classList.remove("on");
    $("tut").classList.remove("on");
    hidePred();
    $("codexPanel").classList.remove("on");
    $("win").classList.remove("on");
    $("winAsk").classList.remove("on");
    var b = boot2.level.board, i;
    for (i = 0; i < G.cells; i++) G.board.push(null);
    for (i = 0; i < G.cells; i++) {
      if (b[i]) {
        addCrystal(i, b[i].lv, b[i].kind === void 0 ? K_NORMAL : b[i].kind, true, i * 9);
        if (b[i].lv > G.maxLv) G.maxLv = b[i].lv;
      }
    }
    updateHUD();
    layout();
    focusRing();
  }
  var RESTARTING = 0;
  function restartFx(keepUp) {
    if (RESTARTING) return;
    RESTARTING = 1;
    G.locked = true;
    $("win").classList.remove("on");
    $("winAsk").classList.remove("on");
    $("up").classList.remove("on");
    hidePred();
    hideRing();
    hideGuide();
    clearHighlights();
    if (drag) {
      drag = null;
      if (ghostEl && ghostEl.parentNode) ghostEl.parentNode.removeChild(ghostEl);
      ghostEl = null;
    }
    var i, c, el, n = G.n, r, cc, dly, maxD = 0;
    var hasExtra = n > 5;
    for (i = 0; i < G.cells; i++) {
      c = G.board[i];
      if (!c) continue;
      el = G.els[c.id];
      if (!el) continue;
      el.style.transition = "transform .24s ease-in,opacity .24s ease-in";
      el.style.transform += " scale(.18)";
      el.style.opacity = "0";
    }
    if (hasExtra && GEO.size > 0) {
      var csOld = GEO.cs, innerOld = GEO.inner;
      var csNew = GEO.size / 5, innerNew = csNew - GEO.gap;
      var k = innerNew / innerOld, step = csNew - csOld;
      for (i = 0; i < G.cells; i++) {
        r = Math.floor(i / n);
        cc = i % n;
        if (r >= 5 || cc >= 5) {
          dly = (n - 1 - r + (n - 1 - cc)) * 26;
          if (dly > maxD) maxD = dly;
          cells[i].style.transitionDelay = dly + "ms";
          cells[i].classList.add("gone");
        } else {
          cells[i].style.transition = "transform .34s cubic-bezier(.2,.85,.25,1),opacity .2s ease";
          cells[i].style.transitionDelay = "90ms";
          cells[i].style.transform = "translate(" + ((cc + 0.5) * step).toFixed(2) + "px," + ((r + 0.5) * step).toFixed(2) + "px) scale(" + k.toFixed(4) + ")";
        }
      }
    }
    var wait = maxD + 210;
    if (hasExtra) wait = Math.max(wait, 450);
    setTimeout(function() {
      var j;
      for (j = 0; j < cells.length; j++) {
        cells[j].classList.remove("gone");
        cells[j].style.transitionDelay = "";
        cells[j].style.transition = "";
        cells[j].style.transform = "";
      }
      G.n = 5;
      G.cells = 25;
      applyBoot(instantBoot(parseSeed()), keepUp ? true : void 0);
      boardEl.classList.remove("revive");
      void boardEl.offsetWidth;
      boardEl.classList.add("revive");
      setTimeout(function() {
        boardEl.classList.remove("revive");
        G.locked = false;
        RESTARTING = 0;
        updateHUD();
        focusRing();
      }, 500);
    }, wait);
  }
  function restart() {
    restartFx(false);
  }
  function restartKeep() {
    restartFx(true);
  }
  function evtPoint(e) {
    if (e.touches && e.touches.length) return { x: e.touches[0].clientX, y: e.touches[0].clientY };
    if (e.changedTouches && e.changedTouches.length) return { x: e.changedTouches[0].clientX, y: e.changedTouches[0].clientY };
    return { x: e.clientX, y: e.clientY };
  }
  function cellFromPoint(x, y) {
    if (!GEO.cs) return -1;
    var r = boardEl.getBoundingClientRect();
    var lx = x - r.left, ly = y - r.top;
    if (lx < 0 || ly < 0 || lx >= r.width || ly >= r.height) return -1;
    var c = Math.floor(lx / GEO.cs), rr = Math.floor(ly / GEO.cs);
    if (c < 0 || c >= G.n || rr < 0 || rr >= G.n) return -1;
    return rr * G.n + c;
  }
  function highlightSame(lv, exceptIdx) {
    for (var i = 0; i < G.cells; i++) {
      if (i === exceptIdx) continue;
      var c = G.board[i];
      if (c && c.lv === lv) cells[i].classList.add("hl");
    }
  }
  function clearHighlights() {
    for (var i = 0; i < G.cells; i++) {
      cells[i].classList.remove("hl");
      cells[i].classList.remove("tgt");
      cells[i].classList.remove("bad");
    }
  }
  function markTarget(idx, lv, from) {
    for (var i = 0; i < G.cells; i++) {
      cells[i].classList.remove("tgt");
      cells[i].classList.remove("bad");
    }
    if (idx < 0 || idx === from) return;
    var c = G.board[idx];
    if (!c) return;
    cells[idx].classList.add(c.kind === K_VOID || c.lv === lv ? "tgt" : "bad");
  }
  function flashBad(idx) {
    if (idx < 0) return;
    cells[idx].classList.add("bad");
    setTimeout(function() {
      cells[idx].classList.remove("bad");
    }, 200);
  }
  function makeGhost(lv, x, y) {
    var el = makeCrystal(lv);
    el.className = "crystal ghost";
    el.style.width = GEO.inner + "px";
    el.style.height = GEO.inner + "px";
    moveGhostEl(el, x, y);
    $("ghostLayer").appendChild(el);
    ghostEl = el;
  }
  function moveGhostEl(el, x, y) {
    el.style.transform = "translate(" + x + "px," + y + "px) translate(-50%,-50%) scale(1.1)";
  }
  function removeGhost() {
    if (ghostEl && ghostEl.parentNode) ghostEl.parentNode.removeChild(ghostEl);
    ghostEl = null;
  }
  function onDown(e) {
    ensureAudio();
    if (G.locked || G.over) return;
    if (e.pointerType === "mouse" && e.button !== 0) return;
    var p = evtPoint(e);
    var idx = cellFromPoint(p.x, p.y);
    if (idx < 0) return;
    var cell = G.board[idx];
    if (!cell) return;
    if (cell.kind === K_VOID) {
      bounce(idx);
      sfx("fail");
      toast(cell.hole ? "黑洞拖不动 · 在它旁边合一次才吸" : "黑块拖不动 · 在它旁边合一次就冲掉");
      return;
    }
    if (e.preventDefault) e.preventDefault();
    var el = G.els[cell.id];
    drag = {
      from: idx,
      lv: cell.lv,
      kind: cell.kind || 0,
      id: cell.id,
      el,
      sx: p.x,
      sy: p.y,
      moved: false,
      lastH: -2,
      willEls: [],
      holeEl: null
    };
    if (el) el.classList.add("picked");
    makeGhost(cell.lv, p.x, p.y);
    highlightSame(cell.lv, idx);
    cells[idx].classList.add("tgt");
  }
  function onMove(e) {
    if (!drag) return;
    var p = evtPoint(e);
    var dx = p.x - drag.sx, dy = p.y - drag.sy;
    if (!drag.moved && dx * dx + dy * dy < 9) return;
    drag.moved = true;
    if (e.preventDefault) e.preventDefault();
    if (ghostEl) moveGhostEl(ghostEl, p.x, p.y);
    var h = cellFromPoint(p.x, p.y);
    markTarget(h, drag.lv, drag.from);
    var rect = boardEl.getBoundingClientRect();
    var bx = clamp(p.x - rect.left, 40, GEO.size - 40);
    var by = clamp(p.y - rect.top, 12, GEO.size - 12);
    if (h >= 0 && h !== drag.from && G.board[h] && G.board[h].lv === drag.lv && G.board[h].kind !== K_VOID) {
      if (drag.lastH !== h) {
        drag.lastH = h;
        drag.pred = predictChain(drag.from, h);
        var rr = wellRadius();
        showRing(h, rr, false);
        if (distE(drag.from, h) > rr + 0.01) showGuide(drag.from, h);
        else hideGuide();
        markWillAbsorb(drag.pred.moves);
        var pfs = [], pj;
        for (pj = 0; pj < drag.pred.moves.length; pj++) pfs.push(drag.pred.moves[pj].from);
        markHoleHint(holeNear(h, pfs));
      }
      showPred(drag.pred ? drag.pred.n : 1, bx, by, drag.holeEl ? 1 : 0);
    } else if (h === drag.from) {
      drag.lastH = h;
      showRing(h, wellRadius(), false);
      hideGuide();
      markWillAbsorb(null);
      clearHoleHint();
      hidePred();
    } else {
      drag.lastH = h;
      hideRing();
      markWillAbsorb(null);
      clearHoleHint();
      hidePred();
    }
  }
  function onUp(e) {
    if (!drag) return;
    var d = drag;
    clearWillAbsorb();
    clearHoleHint();
    hidePred();
    drag = null;
    removeGhost();
    clearHighlights();
    if (d.el) d.el.classList.remove("picked");
    var p = evtPoint(e);
    var idx = cellFromPoint(p.x, p.y);
    var tgt = idx >= 0 && idx !== d.from ? G.board[idx] : null;
    var voidInvolved = tgt && tgt.kind === K_VOID;
    if (tgt && (voidInvolved || tgt.lv === d.lv)) {
      tryMerge(d.from, idx);
    } else if (d.moved && idx >= 0 && idx !== d.from && !tgt) {
      moveCrystal(d.from, idx);
    } else if (d.moved && idx >= 0) {
      bounce(d.from);
      flashBad(idx);
      sfx("fail");
      focusRing();
    } else {
      focusRing();
    }
  }
  var menuOpen = true;
  function openMenu() {
    menuOpen = true;
    $("menu").classList.add("on");
  }
  function startGame() {
    if (!menuOpen) return;
    menuOpen = false;
    $("menu").classList.remove("on");
    ensureAudio();
    setVol("music", VOL.music);
    setVol("sfx", VOL.sfx);
    musicStart();
    G.started = 1;
    sfx("tap");
    setTimeout(function() {
      tutSay("t1", "先把一颗拖到同色的上面 —— 不同色合不了。", 5200);
    }, 700);
  }
  function paintSld(el) {
    if (!el) return;
    var a = parseFloat(el.min) || 0, b = parseFloat(el.max) || 100;
    var p = (parseFloat(el.value) - a) / (b - a) * 100;
    if (p < 0) p = 0;
    if (p > 100) p = 100;
    el.style.setProperty("--p", p.toFixed(1) + "%");
  }
  function syncSet() {
    var m = Math.round(VOL.music * 100), s = Math.round(VOL.sfx * 100);
    $("sMus").value = m;
    $("sSfx").value = s;
    $("vMus").textContent = m + "%";
    $("vSfx").textContent = s + "%";
    paintSld($("sMus"));
    paintSld($("sSfx"));
  }
  function openSet() {
    syncSet();
    $("set").classList.add("on");
  }
  function closeSet() {
    $("set").classList.remove("on");
  }
  var lastT = 0;
  function loop(t) {
    if (!lastT) lastT = t;
    var dt = t - lastT;
    lastT = t;
    if (dt < 0) dt = 0;
    if (dt > 120) dt = 120;
    updateAnim(dt);
    updateBurst(dt);
    updateHole(dt);
    updateShake(dt);
    requestAnimationFrame(loop);
  }
  function buildBoard() {
    boardEl = $("board");
    fxEl = $("fxLayer") || null;
    cells = [];
    for (var i = 0; i < G.cells; i++) {
      var c = document.createElement("div");
      c.className = "cell";
      boardEl.appendChild(c);
      cells.push(c);
    }
    var fx = document.createElement("div");
    fx.id = "fx";
    boardEl.appendChild(fx);
    fxEl = fx;
    buildChainFx();
    var be = document.createElement("div");
    be.id = "burst";
    var bt = document.createElement("div");
    bt.id = "burstTxt";
    bt.innerHTML = '<div class="bn"></div><div class="bs"></div>';
    be.appendChild(bt);
    ($("app") || document.body).appendChild(be);
    burstEl = be;
    burstTxt = bt;
    var he = document.createElement("div");
    he.id = "hole";
    ($("app") || document.body).appendChild(he);
    holeEl = he;
  }
  function rebuildCells() {
    var i, c, frag = document.createDocumentFragment();
    for (i = 0; i < cells.length; i++) {
      if (cells[i] && cells[i].parentNode) cells[i].parentNode.removeChild(cells[i]);
    }
    cells = [];
    for (i = 0; i < G.cells; i++) {
      c = document.createElement("div");
      c.className = "cell";
      frag.appendChild(c);
      cells.push(c);
    }
    boardEl.insertBefore(frag, boardEl.firstChild);
  }
  function expandBoard() {
    var oldN = G.n, oldBoard = G.board, i, r, c, nb = [], j;
    G.n = oldN + 1;
    G.cells = G.n * G.n;
    for (j = 0; j < G.cells; j++) nb.push(null);
    for (i = 0; i < oldBoard.length; i++) {
      if (!oldBoard[i]) continue;
      r = Math.floor(i / oldN);
      c = i % oldN;
      nb[r * G.n + c] = oldBoard[i];
    }
    G.board = nb;
    rebuildCells();
    layout();
    for (i = 0; i < G.cells; i++) {
      var cell = G.board[i];
      if (!cell) continue;
      var el = G.els[cell.id];
      if (!el) continue;
      el.style.width = GEO.inner + "px";
      el.style.height = GEO.inner + "px";
      setPos(el, i);
      sizeCrystal(el);
    }
    flashScreen(true);
    shockwave();
    sfx("band");
    toast("棋盘扩大 · " + G.n + " × " + G.n);
  }
  function buildCodex() {
    var box = $("cxPips"), pbox = $("cxRows"), i, p, row, l, c, chip, dot, nm, ct;
    cxPips = [];
    cxRows = [];
    for (i = 1; i <= 10; i++) {
      p = document.createElement("div");
      p.className = "pip";
      l = document.createElement("span");
      l.className = "pl";
      l.textContent = "L" + i;
      c = document.createElement("span");
      c.className = "pc";
      c.textContent = "0";
      p.appendChild(l);
      p.appendChild(c);
      box.appendChild(p);
      p.__pc = c;
      cxPips.push(p);
      row = document.createElement("div");
      row.className = "cxrow";
      chip = document.createElement("i");
      chip.className = "chip";
      chip.style.background = LV_COLOR[i - 1];
      chip.style.borderColor = LV_DARK[i - 1];
      dot = document.createElement("u");
      var cs = coreSize(i);
      if (cs > 0) {
        dot.style.width = Math.round(cs * 0.2) + "px";
        dot.style.height = Math.round(cs * 0.2) + "px";
      } else {
        dot.style.display = "none";
      }
      chip.appendChild(dot);
      nm = document.createElement("span");
      nm.className = "nm";
      nm.textContent = "L" + i + " · " + BAND_NAME[i - 1] + "方块";
      ct = document.createElement("span");
      ct.className = "ct";
      ct.textContent = "0";
      row.appendChild(chip);
      row.appendChild(nm);
      row.appendChild(ct);
      pbox.appendChild(row);
      row.__ct = ct;
      cxRows.push(row);
    }
  }
  function bindEvents() {
    if (window.PointerEvent) {
      boardEl.addEventListener("pointerdown", onDown, false);
      document.addEventListener("pointermove", onMove, false);
      document.addEventListener("pointerup", onUp, false);
      document.addEventListener("pointercancel", onUp, false);
    } else {
      boardEl.addEventListener("mousedown", onDown, false);
      document.addEventListener("mousemove", onMove, false);
      document.addEventListener("mouseup", onUp, false);
      boardEl.addEventListener("touchstart", onDown, false);
      document.addEventListener("touchmove", onMove, false);
      document.addEventListener("touchend", onUp, false);
      document.addEventListener("touchcancel", onUp, false);
    }
    $("bPulse").addEventListener("click", function() {
      ensureAudio();
      releasePulse();
    }, false);
    $("bFeed").addEventListener("click", function() {
      ensureAudio();
      feed();
    }, false);
    $("bLv").addEventListener("click", function(e) {
      if (e.stopPropagation) e.stopPropagation();
      ensureAudio();
      if (G.pendingUps <= 0) {
        sfx("move");
        toast("等级 " + G.resoLv + " · 还没攒到可选的增益");
        return;
      }
      if (G.locked) {
        sfx("move");
        return;
      }
      openUpPanel();
      sfx("tap");
    }, false);
    $("up").addEventListener("click", function(e) {
      if (e.target === $("up")) closeUpPanel();
    }, false);
    $("bUpA").addEventListener("click", function() {
      pickUpgrade($("bUpA").__up);
    }, false);
    $("bUpB").addEventListener("click", function() {
      pickUpgrade($("bUpB").__up);
    }, false);
    $("bUpC").addEventListener("click", function() {
      pickUpgrade($("bUpC").__up);
    }, false);
    $("stats").addEventListener("click", function() {
      if (G.over) return;
      $("codexPanel").classList.add("on");
    }, false);
    $("bCxClose").addEventListener("click", function() {
      $("codexPanel").classList.remove("on");
    }, false);
    $("bAgain").addEventListener("click", function(e) {
      if (e.stopPropagation) e.stopPropagation();
      openRestartAsk();
      sfx("tap");
    }, false);
    $("bWinBack").addEventListener("click", function() {
      closeRestartAsk();
      sfx("tap");
    }, false);
    $("bWinFresh").addEventListener("click", function() {
      $("win").classList.remove("on");
      restart();
    }, false);
    $("bWinKeep").addEventListener("click", function() {
      $("win").classList.remove("on");
      restartKeep();
    }, false);
    window.addEventListener("resize", function() {
      if ($("bPulse") && $("bPulse").classList.contains("charged")) buildBolts();
    }, false);
    var taps = 0, tapTimer = 0;
    $("top").addEventListener("pointerdown", function() {
      taps++;
      if (tapTimer) clearTimeout(tapTimer);
      tapTimer = setTimeout(function() {
        taps = 0;
      }, 900);
      if (taps >= 5) {
        taps = 0;
        toast("种子 " + G.seed);
      }
    }, false);
    var rt = 0;
    window.addEventListener("resize", function() {
      if (rt) clearTimeout(rt);
      rt = setTimeout(layout, 80);
    }, false);
    window.addEventListener("orientationchange", function() {
      setTimeout(layout, 220);
    }, false);
    $("bStart").addEventListener("click", startGame, false);
    $("bSetOpen").addEventListener("click", function() {
      ensureAudio();
      openSet();
    }, false);
    $("bWear").addEventListener("click", function() {
      ensureAudio();
      sfx("fail");
      toast("换装还没开放 · 等下一版");
    }, false);
    $("bSet").addEventListener("click", function() {
      ensureAudio();
      sfx("tap");
      openSet();
    }, false);
    $("bSetClose").addEventListener("click", function() {
      sfx("tap");
      closeSet();
    }, false);
    $("set").addEventListener("pointerdown", function() {
      ensureAudio();
    }, false);
    $("sMus").addEventListener("input", function() {
      setVol("music", this.value / 100);
      $("vMus").textContent = Math.round(VOL.music * 100) + "%";
      paintSld(this);
    }, false);
    var sfxDemoT = 0;
    $("sSfx").addEventListener("input", function() {
      setVol("sfx", this.value / 100);
      $("vSfx").textContent = Math.round(VOL.sfx * 100) + "%";
      paintSld(this);
      var now = Date.now();
      if (AC && now - sfxDemoT > 90) {
        sfxDemoT = now;
        sfx("merge");
      }
    }, false);
  }
  function boot() {
    var seedOpt = parseSeed();
    var bootData = instantBoot(seedOpt);
    appEl = $("app");
    buildBoard();
    buildCodex();
    layout();
    applyBoot(bootData);
    bindEvents();
    startAutoFeed();
    syncSet();
    openMenu();
    requestAnimationFrame(function() {
      layout();
    });
    requestAnimationFrame(loop);
    window.addEventListener("load", function() {
      layout();
    }, false);
  }
  VOID_FEED_P = 0.05;
  BLACKHOLE_P = 0.01;
  var cottonClearPending = false, cottonHoleEpoch = 0;
  var cottonFixRaw = {
    setGem,
    convertHoles,
    holeFire,
    applyBoot,
    makeGhost,
    removeGhost,
    onDown,
    onMove,
    onUp,
    feed,
    applyStep,
    doClear,
    burstEnd,
    updateHUD,
    openMenu
  };
  setGem = function(el, lv, kind) {
    el.__hole = kind === K_VOID && G.matter ? 1 : 0;
    return cottonFixRaw.setGem.apply(this, arguments);
  };
  convertHoles = function() {
    if (!G.matter) return 0;
    return cottonFixRaw.convertHoles.apply(this, arguments);
  };
  function cottonCancelDrag() {
    clearWillAbsorb();
    clearHoleHint();
    if (drag && drag.el) drag.el.classList.remove("picked");
    drag = null;
    removeGhost();
    hidePred();
    hideGuide();
    hideRing();
    clearHighlights();
  }
  removeGhost = function() {
    cottonFixRaw.removeGhost();
    var layer = $("ghostLayer");
    if (layer) while (layer.firstChild) layer.removeChild(layer.firstChild);
  };
  makeGhost = function() {
    removeGhost();
    cottonFixRaw.makeGhost.apply(this, arguments);
    if (ghostEl) {
      ghostEl.setAttribute("aria-hidden", "true");
      ghostEl.removeAttribute("role");
      ghostEl.tabIndex = -1;
    }
  };
  onDown = function(e) {
    if (e.isPrimary === false || RESTARTING || cottonClearPending || BURST.on) return;
    if (drag) cottonCancelDrag();
    var result = cottonFixRaw.onDown.apply(this, arguments);
    if (drag) {
      drag.pointerId = e.pointerId;
      if (typeof e.pointerId === "number" && boardEl.setPointerCapture) {
        try {
          boardEl.setPointerCapture(e.pointerId);
        } catch (ignore) {
        }
      }
    }
    return result;
  };
  onMove = function(e) {
    if (drag && typeof drag.pointerId === "number" && typeof e.pointerId === "number" && drag.pointerId !== e.pointerId) return;
    return cottonFixRaw.onMove.apply(this, arguments);
  };
  onUp = function(e) {
    if (drag && typeof drag.pointerId === "number" && typeof e.pointerId === "number" && drag.pointerId !== e.pointerId) return;
    if (e.type === "pointercancel" || e.type === "touchcancel") {
      cottonCancelDrag();
      return;
    }
    var id = drag && drag.pointerId, result = cottonFixRaw.onUp.apply(this, arguments);
    removeGhost();
    if (typeof id === "number" && boardEl.releasePointerCapture) {
      try {
        boardEl.releasePointerCapture(id);
      } catch (ignore) {
      }
    }
    return result;
  };
  window.addEventListener("blur", cottonCancelDrag);
  document.addEventListener("visibilitychange", function() {
    if (document.hidden) cottonCancelDrag();
  });
  document.addEventListener("lostpointercapture", function() {
    if (drag) cottonCancelDrag();
  });
  window.addEventListener("keydown", function(e) {
    if (e.key === "Escape") cottonCancelDrag();
  });
  openMenu = function() {
    cottonCancelDrag();
    return cottonFixRaw.openMenu.apply(this, arguments);
  };
  function cottonAbortHole() {
    cottonHoleEpoch++;
    HOLE.on = false;
    HOLE.next = -1;
    HOLE.out = 0;
    for (var i = 0; i < HOLE.items.length; i++) removeEl(HOLE.items[i].id);
    if (HOLE.blockId) removeEl(HOLE.blockId);
    HOLE.items = [];
    HOLE.blockId = 0;
    HOLE.reserved = {};
    HOLE.vortex = null;
    if (holeEl) {
      while (holeEl.firstChild) holeEl.removeChild(holeEl.firstChild);
      holeEl.classList.remove("on");
    }
  }
  holeFire = function(idx) {
    if (!G.matter || RESTARTING || cottonClearPending || BURST.on) return 0;
    var starts = {};
    if (!HOLE.on) {
      if (appEl) appEl.style.transform = "";
      for (var id in G.els) {
        var node = G.els[id];
        if (node.parentNode === boardEl) {
          var box = node.getBoundingClientRect();
          starts[id] = { x: box.left + box.width / 2, y: box.top + box.height / 2 };
        }
      }
    }
    var source = G.board[idx], holeStart = source && starts[source.id];
    var active = HOLE.on, d = cottonFixRaw.holeFire.apply(this, arguments);
    if (!d || active) return d;
    cottonHoleEpoch++;
    var u = GEO.inner, origin = holeEl.getBoundingClientRect();
    if (holeStart) {
      HOLE.cx = holeStart.x - origin.left;
      HOLE.cy = holeStart.y - origin.top;
      if (HOLE.vortex) {
        HOLE.vortex.style.left = HOLE.cx + "px";
        HOLE.vortex.style.top = HOLE.cy + "px";
      }
    }
    for (var i = 0; i < HOLE.items.length; i++) {
      var it = HOLE.items[i], el = it.el;
      if (starts[it.id]) {
        it.sx = starts[it.id].x - origin.left;
        it.sy = starts[it.id].y - origin.top;
      }
      it.unit = u;
      it.lift = 0;
      it.liftRot = 0;
      it.t0 = HOLE_LOCK + i * Math.min(26, 150 / Math.max(1, HOLE.items.length - 1));
      it.bend = (i % 2 ? 1 : -1) * 0.13;
      el.style.marginLeft = -u / 2 + "px";
      el.style.marginTop = -u / 2 + "px";
      el.style.width = u + "px";
      el.style.height = u + "px";
      el.style.pointerEvents = "none";
      el.style.transform = "translate(" + it.sx.toFixed(3) + "px," + it.sy.toFixed(3) + "px)";
      el.setAttribute("aria-hidden", "true");
      el.removeAttribute("role");
      el.tabIndex = -1;
      el.classList.remove("drop", "pop", "wellPull", "wellCharge", "picked", "willabs");
      el.__inner.style.animation = "none";
      el.__inner.style.animationDelay = "";
      el.__inner.style.transform = "rotate(0deg) scale(1)";
      el.__inner.style.opacity = "1";
      var dx = it.sx - HOLE.cx, dy = it.sy - HOLE.cy;
      it.rad0 = Math.sqrt(dx * dx + dy * dy);
      it.ang0 = Math.atan2(dy, dx);
    }
    HOLE.dur = Math.max.apply(null, [HOLE_GROW].concat(HOLE.items.map(function(it2) {
      return it2.t0 + it2.fly;
    }))) + HOLE_TAIL;
    return HOLE.dur;
  };
  HOLE_GROW = 180;
  HOLE_LOCK = 35;
  HOLE_RISE = 0;
  HOLE_HOLD = 0;
  HOLE_FLY = 420;
  HOLE_TAIL = 220;
  HOLE_OUTRO = 180;
  updateHole = function(dt) {
    if (!HOLE.on) return;
    HOLE.t += dt;
    if (HOLE.blockId && HOLE.t >= HOLE_GROW) {
      removeEl(HOLE.blockId);
      HOLE.blockId = 0;
    }
    for (var i = 0; i < HOLE.items.length; i++) {
      var it = HOLE.items[i];
      if (it.done) continue;
      var el = it.el;
      if (!el) {
        it.done = true;
        continue;
      }
      var t = HOLE.t - it.t0;
      if (t < 0) continue;
      var q, x = it.sx, y = it.sy, sx = 1, sy = 1, rot = 0, op = 1;
      q = Math.min(1, t / it.fly);
      var pull = q * q * (3 - 2 * q), dx = HOLE.cx - it.sx, dy = HOLE.cy - it.sy;
      var bend = Math.sin(q * Math.PI) * (1 - q) * it.bend;
      x = it.sx + dx * pull - dy * bend;
      y = it.sy + dy * pull + dx * bend;
      var scale = 1 - 0.97 * Math.pow(q, 2.1);
      sx = scale * (1 + 0.15 * Math.sin(q * Math.PI));
      sy = scale * (1 - 0.08 * Math.sin(q * Math.PI));
      rot = (it.turns * 220 + it.spin) * Math.pow(q, 1.12);
      op = q > 0.86 ? (1 - q) / 0.14 : 1;
      el.style.transform = "translate(" + x.toFixed(2) + "px," + y.toFixed(2) + "px)";
      el.__inner.style.transform = "rotate(" + rot.toFixed(2) + "deg) scale(" + sx.toFixed(4) + "," + sy.toFixed(4) + ")";
      el.__inner.style.opacity = String(op);
      if (t >= HOLE_RISE + HOLE_HOLD + it.fly) {
        it.done = true;
        removeEl(it.id);
        holeGulp();
        G.score += holeScore(it.lv);
        voice(96 + it.lv * 9, 0.075, "sine", 0.022, 0, 0, 1);
        updateHUD();
        if (HOLE.items.every(function(v) {
          return v.done;
        })) holeFloat(HOLE.bonus);
      }
    }
    if (!HOLE.out && HOLE.t >= HOLE.dur - HOLE_OUTRO) {
      HOLE.out = 1;
      if (HOLE.vortex) HOLE.vortex.classList.add("out");
    }
    if (HOLE.t >= HOLE.dur) holeEnd();
  };
  holeEnd = function() {
    var next = HOLE.next;
    cottonAbortHole();
    updateHUD();
    focusRing();
    var epoch = cottonHoleEpoch;
    if (next >= 0) setTimeout(function() {
      if (epoch === cottonHoleEpoch && !RESTARTING) holeSolo(next);
    }, 120);
  };
  holeSolo = function(idx) {
    if (!G.matter || RESTARTING || cottonClearPending || BURST.on) return;
    if (HOLE.on) {
      HOLE.next = idx;
      return;
    }
    hideRing();
    hideGuide();
    var d = holeFire(idx), epoch = cottonHoleEpoch;
    if (!d) return;
    setTimeout(function() {
      if (epoch !== cottonHoleEpoch) return;
      if (HOLE.on && HOLE.idx === idx) holeEnd();
      updateHUD();
      focusRing();
      if (!G.over && G.pendingUps > 0) markUpPending();
    }, d + 140);
  };
  feed = function() {
    if (cottonClearPending || BURST.on || RESTARTING) return;
    return cottonFixRaw.feed.apply(this, arguments);
  };
  applyStep = function(s) {
    if (s && (s.type === "well" && s.lv >= 10 || s.type === "clear")) cottonClearPending = true;
    return cottonFixRaw.applyStep.apply(this, arguments);
  };
  doClear = function() {
    cottonClearPending = true;
    var result = cottonFixRaw.doClear.apply(this, arguments);
    if (!BURST.on) cottonClearPending = false;
    updateHUD();
    return result;
  };
  burstEnd = function() {
    var result = cottonFixRaw.burstEnd.apply(this, arguments);
    cottonClearPending = false;
    updateHUD();
    return result;
  };
  updateHUD = function() {
    var result = cottonFixRaw.updateHUD.apply(this, arguments);
    if (cottonClearPending || BURST.on || RESTARTING) $("bFeed").disabled = true;
    return result;
  };
  applyBoot = function() {
    cottonCancelDrag();
    cottonAbortHole();
    cottonClearPending = false;
    return cottonFixRaw.applyBoot.apply(this, arguments);
  };
  restartFx = function(keepUp) {
    if (RESTARTING) return;
    RESTARTING = 1;
    G.locked = true;
    cottonCancelDrag();
    cottonAbortHole();
    if (BURST.on) burstEnd();
    anim.q = [];
    anim.active = false;
    anim.done = null;
    CH = null;
    if (expandTimer) {
      clearTimeout(expandTimer);
      expandTimer = 0;
    }
    G.pendingExpand = 0;
    ["win", "winAsk", "up", "codexPanel"].forEach(function(id2) {
      $(id2).classList.remove("on");
    });
    boardEl.classList.remove("revive");
    boardEl.dataset.restartPhase = "disappear";
    var n = G.n, maxD = 0, keep = [], oldInner = GEO.inner, oldCs = GEO.cs, size = GEO.size;
    for (var id in G.els) {
      var el = G.els[id];
      el.style.transition = "transform .24s ease-in,opacity .24s ease-in";
      el.style.transform += " scale(.18)";
      el.style.opacity = "0";
    }
    for (var i = 0; i < cells.length; i++) {
      var row = Math.floor(i / n), col = i % n, cell = cells[i];
      if (row >= 5 || col >= 5) {
        var delay = (n - 1 - row + (n - 1 - col)) * 26;
        maxD = Math.max(maxD, delay);
        cell.style.transitionDelay = delay + "ms";
        cell.classList.add("gone");
      } else keep.push({ el: cell, row, col });
    }
    updateHUD();
    setTimeout(function() {
      boardEl.dataset.restartPhase = "enlarge";
      var newCs = size / 5, k = (newCs - GEO.gap) / oldInner, step = newCs - oldCs;
      if (n > 5) keep.forEach(function(v) {
        v.el.style.transition = "transform .42s cubic-bezier(.22,.8,.25,1)";
        v.el.style.transitionDelay = "0ms";
        v.el.style.transform = "translate(" + ((v.col + 0.5) * step).toFixed(2) + "px," + ((v.row + 0.5) * step).toFixed(2) + "px) scale(" + k.toFixed(5) + ")";
      });
      setTimeout(function() {
        cells.forEach(function(cell2) {
          if (cell2.classList.contains("gone") && cell2.parentNode) cell2.parentNode.removeChild(cell2);
        });
        cells = keep.map(function(v) {
          v.el.classList.remove("gone");
          v.el.style.transition = "none";
          v.el.style.transitionDelay = "";
          v.el.style.transform = "";
          return v.el;
        });
        G.n = 5;
        G.cells = 25;
        applyBoot(instantBoot(parseSeed()), keepUp ? true : void 0);
        cells.forEach(function(cell2) {
          cell2.style.transition = "";
        });
        G.locked = false;
        RESTARTING = 0;
        boardEl.dataset.restartPhase = "idle";
        updateHUD();
        focusRing();
      }, n > 5 ? 440 : 30);
    }, n > 5 ? maxD + 240 : 250);
  };
  var cottonBurstStart = burstStart, cottonBurstEnd = burstEnd, cottonBurstCells = [], cottonShards = [], cottonShardRAF = 0, cottonShardPeak = 0;
  var cottonShardCanvas = null, cottonShardContext = null, cottonParticles = [], cottonShardScale = 1;
  function cottonPrepareShards() {
    if (!cottonShardCanvas) {
      cottonShardCanvas = document.createElement("canvas");
      cottonShardCanvas.style.cssText = "position:absolute;left:0;top:0;width:100%;height:100%;pointer-events:none";
      cottonShardContext = cottonShardCanvas.getContext("2d");
    }
    cottonParticles = [];
    cottonShardScale = Math.min(1.5, window.devicePixelRatio || 1);
    cottonShardCanvas.width = Math.max(1, Math.round(burstEl.clientWidth * cottonShardScale));
    cottonShardCanvas.height = Math.max(1, Math.round(burstEl.clientHeight * cottonShardScale));
    burstEl.appendChild(cottonShardCanvas);
  }
  function cottonAddShards(cell) {
    var now = performance.now(), n = 6 + Math.floor(Math.random() * 4);
    for (var i = 0; i < n && cottonParticles.length < 384; i++) {
      var angle = Math.random() * Math.PI * 2, speed = GEO.inner * (0.45 + Math.random() * 0.95), w = Math.max(3, GEO.inner * (0.09 + Math.random() * 0.11));
      cottonParticles.push({ x: cell.x, y: cell.y, dx: Math.cos(angle) * speed, dy: Math.sin(angle) * speed, w, h: w * (0.55 + Math.random() * 0.75), rotation: (Math.random() * 720 - 360) * Math.PI / 180, start: now + Math.random() * 70, duration: 500 + Math.random() * 320, color: cell.color });
    }
  }
  function cottonPaintShards(now) {
    var g = cottonShardContext;
    if (!g) return;
    g.setTransform(1, 0, 0, 1, 0, 0);
    g.clearRect(0, 0, cottonShardCanvas.width, cottonShardCanvas.height);
    g.scale(cottonShardScale, cottonShardScale);
    var write = 0;
    for (var i = 0; i < cottonParticles.length; i++) {
      var p = cottonParticles[i], age = (now - p.start) / p.duration;
      if (age >= 1) continue;
      cottonParticles[write++] = p;
      if (age < 0) continue;
      var k = 1 - Math.pow(1 - age, 3);
      g.save();
      g.globalAlpha = 1 - age;
      g.translate(p.x + p.dx * k, p.y + p.dy * k);
      g.rotate(p.rotation * k);
      g.fillStyle = p.color;
      g.fillRect(-p.w / 2, -p.h / 2, p.w * (1 - age * 0.65), p.h * (1 - age * 0.65));
      g.restore();
    }
    cottonParticles.length = write;
  }
  function cottonShardFrame() {
    cottonShardRAF = 0;
    if (!BURST.on) {
      cottonShards = [];
      return;
    }
    var start = performance.now(), count = 0;
    while (cottonShards.length && count < 3) {
      var p = cottonShards.shift();
      cottonAddShards(p);
      count++;
      if (performance.now() - start >= 3) break;
    }
    cottonShardPeak = Math.max(cottonShardPeak, count);
    cottonPaintShards(performance.now());
    if (cottonShards.length || cottonParticles.length) cottonShardRAF = requestAnimationFrame(cottonShardFrame);
  }
  burstStart = function() {
    cancelAnimationFrame(cottonShardRAF);
    cottonShardRAF = 0;
    cottonShards = [];
    cottonShardPeak = 0;
    var result = cottonBurstStart.apply(this, arguments);
    cottonPrepareShards();
    cottonBurstCells = [];
    for (var i = 0; i < G.cells; i++) {
      var cell = G.board[i];
      if (!cell) continue;
      var xy = cellCenter(i), x = xy.x + BURST.ox, y = xy.y + BURST.oy, dx = x - BURST.cx, dy = y - BURST.cy;
      cottonBurstCells.push({ index: i, id: cell.id, x, y, r: Math.sqrt(dx * dx + dy * dy) - GEO.inner * 0.5, color: gemColor(G.els[cell.id]) });
    }
    return result;
  };
  burstSweep = function(radius) {
    for (var i = 0; i < cottonBurstCells.length; i++) {
      var cell = cottonBurstCells[i];
      if (BURST.hit[cell.index] || cell.r > radius) continue;
      BURST.hit[cell.index] = 1;
      G.board[cell.index] = null;
      removeEl(cell.id);
      cottonShards.push(cell);
    }
    if (cottonShards.length && !cottonShardRAF) cottonShardRAF = requestAnimationFrame(cottonShardFrame);
  };
  burstEnd = function() {
    cancelAnimationFrame(cottonShardRAF);
    cottonShardRAF = 0;
    cottonShards = [];
    cottonBurstCells = [];
    cottonParticles = [];
    return cottonBurstEnd.apply(this, arguments);
  };
  if (window.COTTON_QA) window.CottonBurstWorkQA = { getStatus: function() {
    return { on: BURST.on, occupied: G.board.filter(Boolean).length, score: G.score, pending: cottonShards.length, cells: cottonBurstCells.length, peak: cottonShardPeak };
  }, clear: function() {
    var count = G.board.filter(Boolean).length, before = G.score;
    doClear();
    return { count, before, expected: before + count * CLEAR_PER, after: G.score };
  } };
  var cottonRaw = { applyStep, finishChain, doClear, addReso, feed, applyBoot, makeCrystal, setGem, setPos, sizeCrystal, buildBoard, rebuildCells, updateHUD, openMenu, startGame };
  function cottonSnapshot() {
    var count = 0;
    for (var i = 0; i < G.cells; i++) if (G.board[i]) count++;
    return { score: G.score, best: G.best, resoLv: G.resoLv, maxLv: G.maxLv, bestChain: G.bestChain, occupied: count, cells: G.cells, n: G.n, pulse: G.pulse, pulseFull: PULSE_FULL, started: !!G.started, menu: menuOpen, locked: G.locked, reached10: !!G.reached10, upgrades: G.pendingUps };
  }
  function cottonSignal(type, payload) {
    try {
      window.dispatchEvent(new CustomEvent("cotton-game", { detail: { type, payload: payload || {}, state: cottonSnapshot() } }));
    } catch (error) {
    }
  }
  var cottonDanger = false, cottonLastState = "";
  function cottonState() {
    var snap = cottonSnapshot(), danger = snap.occupied / snap.cells >= 0.88;
    if (danger !== cottonDanger) {
      cottonDanger = danger;
      cottonSignal(danger ? "danger" : "recover");
    }
    var key = [snap.score, snap.resoLv, snap.maxLv, snap.bestChain, snap.occupied, snap.menu, snap.started].join(":");
    if (key !== cottonLastState) {
      cottonLastState = key;
      cottonSignal("state");
    }
  }
  applyStep = function(s) {
    var result = cottonRaw.applyStep.apply(this, arguments);
    if (s && s.type === "well") cottonSignal("merge", { count: s.n, level: s.lv, gain: s.gain });
    return result;
  };
  finishChain = function() {
    var chain = CH;
    var result = cottonRaw.finishChain.apply(this, arguments);
    if (chain && !chain.cleared && chain.merges >= 3) cottonSignal("combo", { chain: chain.merges });
    return result;
  };
  doClear = function() {
    var result = cottonRaw.doClear.apply(this, arguments);
    cottonSignal("clear");
    return result;
  };
  addReso = function() {
    var old = G.resoLv;
    var result = cottonRaw.addReso.apply(this, arguments);
    if (G.resoLv > old) cottonSignal("levelUp", { level: G.resoLv });
    return result;
  };
  feed = function() {
    var result = cottonRaw.feed.apply(this, arguments);
    cottonState();
    return result;
  };
  applyBoot = function() {
    var result = cottonRaw.applyBoot.apply(this, arguments);
    cottonBoardAccess();
    cottonDanger = false;
    cottonSignal("reset");
    return result;
  };
  updateHUD = function() {
    var result = cottonRaw.updateHUD.apply(this, arguments);
    cottonState();
    return result;
  };
  openMenu = function() {
    var result = cottonRaw.openMenu.apply(this, arguments);
    cottonSignal("home");
    return result;
  };
  startGame = function() {
    var result = cottonRaw.startGame.apply(this, arguments);
    cottonSignal("play");
    return result;
  };
  var cottonIcons = [
    '<path d="m12 2 2.8 6.2 6.7.8-5 4.5 1.4 6.6-5.9-3.4-5.9 3.4 1.4-6.6-5-4.5 6.7-.8Z"/>',
    '<path d="M12 2v20M3.4 7l17.2 10M3.4 17 20.6 7M8 4l4 3 4-3M8 20l4-3 4 3M3.5 11.5l4-1-.5-4M20.5 12.5l-4 1 .5 4" fill="none" stroke="currentColor" stroke-width="1.8" stroke-linecap="round"/>',
    '<path d="M13 2c2 5-3 6-1 10 1-2 3-3 4-4 7 6 2 14-4 14S1 16 6 10c-1 4 2 5 3 3C7 8 11 7 13 2Z"/>',
    '<circle cx="12" cy="12" r="3"/><ellipse cx="12" cy="12" rx="10" ry="5" fill="none" stroke="currentColor" stroke-width="1.5" transform="rotate(-30 12 12)"/><ellipse cx="12" cy="12" rx="10" ry="5" fill="none" stroke="currentColor" stroke-width="1.5" transform="rotate(45 12 12)"/>',
    '<path d="m12 1 2.5 7.5L22 11l-7.5 2.5L12 22l-2.5-8.5L2 11l7.5-2.5Z"/><path d="m21 1 .6 2.4L24 4l-2.4.6L21 7l-.6-2.4L18 4l2.4-.6Z"/>'
  ];
  function cottonDecorate(el) {
    if (!el || !el.__inner) return;
    var lv = el.__lv || 0, kind = el.__kind || 0;
    el.dataset.level = String(lv);
    el.dataset.kind = String(kind);
    el.style.setProperty("--tile", kind === K_VOID ? "#343a57" : LV_COLOR[Math.max(0, lv - 1)]);
    el.style.setProperty("--tile-ink", [2, 4, 6, 8].indexOf(lv) >= 0 ? "#fff6ef" : "#535574");
    el.style.setProperty("--tile-font", Math.max(9, Math.min(16, (GEO.inner || 48) * 0.24)) + "px");
    if (!el.__cottonNumber) {
      el.__cottonNumber = document.createElement("span");
      el.__cottonNumber.className = "tile-number";
      el.__inner.appendChild(el.__cottonNumber);
      el.__cottonIcon = document.createElement("span");
      el.__cottonIcon.className = "tile-icon";
      el.__inner.appendChild(el.__cottonIcon);
    }
    el.__cottonNumber.textContent = kind === K_VOID ? "" : String(lv);
    var art = window.CottonTileArt && CottonTileArt[Math.max(0, Math.min(9, lv - 1))];
    el.__cottonIcon.innerHTML = art ? art.svg : '<svg viewBox="0 0 24 24" fill="currentColor" aria-hidden="true">' + cottonIcons[0] + "</svg>";
    if (art) {
      el.dataset.collectible = art.name;
      el.title = kind === K_VOID ? "暗影石 · 获得物质增益后成为黑洞" : art.name + " · 等级" + lv;
    }
    el.setAttribute("role", "button");
    el.tabIndex = 0;
    cottonTileLabel(el);
  }
  function cottonTileLabel(el) {
    if (!el) return;
    var idx = el.__idx;
    if (typeof idx === "number") {
      el.dataset.index = String(idx);
      el.setAttribute("aria-label", "第" + (Math.floor(idx / G.n) + 1) + "行第" + (idx % G.n + 1) + "列，" + (el.__kind === K_VOID ? el.__hole ? "黑洞" : "黑方块" : "等级" + el.__lv));
    }
  }
  setGem = function(el) {
    var result = cottonRaw.setGem.apply(this, arguments);
    cottonDecorate(el);
    return result;
  };
  setPos = function(el) {
    var result = cottonRaw.setPos.apply(this, arguments);
    cottonTileLabel(el);
    return result;
  };
  sizeCrystal = function(el) {
    var result = cottonRaw.sizeCrystal.apply(this, arguments);
    cottonDecorate(el);
    return result;
  };
  makeCrystal = function() {
    var el = cottonRaw.makeCrystal.apply(this, arguments);
    cottonDecorate(el);
    return el;
  };
  var cottonKeyFrom = -1, cottonKeysBound = false;
  function cottonClearKeys() {
    cottonKeyFrom = -1;
    for (var id in G.els) if (G.els[id]) G.els[id].classList.remove("keyboard-picked");
  }
  function cottonBoardAccess() {
    boardEl.setAttribute("role", "group");
    boardEl.setAttribute("aria-label", "星光合成棋盘");
    for (var i = 0; i < cells.length; i++) {
      cells[i].dataset.index = String(i);
      cells[i].setAttribute("role", "button");
      cells[i].setAttribute("aria-label", "棋盘位置，第" + (Math.floor(i / G.n) + 1) + "行第" + (i % G.n + 1) + "列");
      cells[i].tabIndex = 0;
    }
    if (cottonKeysBound) return;
    cottonKeysBound = true;
    boardEl.addEventListener("keydown", function(e) {
      if (e.key === "Escape") {
        cottonClearKeys();
        return;
      }
      if (e.key !== "Enter" && e.key !== " ") return;
      var target = e.target.closest(".crystal,.cell");
      if (!target) return;
      var idx = Number(target.dataset.index);
      if (!Number.isInteger(idx) || G.locked || G.over || menuOpen) return;
      e.preventDefault();
      if (cottonKeyFrom < 0) {
        var c = G.board[idx];
        if (!c || c.kind === K_VOID) return;
        cottonKeyFrom = idx;
        if (G.els[c.id]) G.els[c.id].classList.add("keyboard-picked");
        return;
      }
      var from = cottonKeyFrom;
      cottonClearKeys();
      if (from === idx) return;
      var rect = boardEl.getBoundingClientRect();
      function point(n) {
        return { clientX: rect.left + (n % G.n + 0.5) * GEO.cs, clientY: rect.top + (Math.floor(n / G.n) + 0.5) * GEO.cs, preventDefault: function() {
        } };
      }
      onDown(point(from));
      if (drag) drag.moved = true;
      onUp(point(idx));
    });
  }
  buildBoard = function() {
    var result = cottonRaw.buildBoard.apply(this, arguments);
    cottonBoardAccess();
    return result;
  };
  rebuildCells = function() {
    var result = cottonRaw.rebuildCells.apply(this, arguments);
    cottonClearKeys();
    cottonBoardAccess();
    return result;
  };
  window.CottonGame = Object.freeze({ snapshot: cottonSnapshot, relayout: layout, home: function() {
    cottonClearKeys();
    openMenu();
    musicStop();
  }, start: function() {
    startGame();
  } });
  var cottonPetVoices = /* @__PURE__ */ new Map();
  VOL.music = 0.5;
  var cottonMusicGainScale = 1.4;
  VOL.sfx = 1.2;
  try {
    const saved = localStorage.getItem("yuzu-house-sfx");
    if (saved !== null && Number.isFinite(Number(saved))) VOL.sfx = clamp(Number(saved), 0, 2);
  } catch (e) {
  }
  const cottonRawSetVolume = setVol;
  setVol = function(kind, value) {
    const result = cottonRawSetVolume.apply(this, arguments);
    if (kind === "music" && busMusic) busMusic.gain.setTargetAtTime(VOL.music * cottonMusicGainScale, AC.currentTime, 0.025);
    if (kind === "sfx") try {
      localStorage.setItem("yuzu-house-sfx", String(VOL.sfx));
    } catch (e) {
    }
    return result;
  };
  var cottonSynth = null, cottonMusicStep = 0, cottonVocalLevel = 0.4, cottonVoiceTimers = [], cottonFeedSound = null, cottonFeedAudioDepth = 0, cottonFeedAutomatic = false, cottonMaster = null, cottonMasterLevel = 0.8, cottonMergeImpact = null;
  var cottonVoiceShape = CottonSynth.normalizeVoice();
  try {
    var storedShape = JSON.parse(localStorage.getItem("yuzu-voice-shape"));
    if (storedShape) cottonVoiceShape = CottonSynth.normalizeVoice(storedShape);
  } catch (e) {
  }
  function cottonSetVoice(shape) {
    cottonVoiceShape = CottonSynth.normalizeVoice(Object.assign({}, cottonVoiceShape, shape));
    if (cottonSynth) cottonSynth.setVoice(cottonVoiceShape);
    try {
      localStorage.setItem("yuzu-voice-shape", JSON.stringify(cottonVoiceShape));
    } catch (e) {
    }
    window.dispatchEvent(new Event("cotton-voice-shape"));
    return Object.assign({}, cottonVoiceShape);
  }
  function cottonPreviewVoice() {
    ensureAudio();
    var synth = cottonEnsureSynth();
    if (synth) {
      synth.cancel(AC.currentTime + 2e-3);
      return synth.strike(AC.currentTime + 0.06, 4, 4);
    }
  }
  try {
    var savedMaster = localStorage.getItem("yuzu-house-master");
    if (savedMaster !== null) cottonMasterLevel = clamp(Number(savedMaster) || 0, 0, 1);
  } catch (e) {
  }
  var cottonMasterEnsureAudio = ensureAudio;
  ensureAudio = function() {
    var result = cottonMasterEnsureAudio.apply(this, arguments);
    if (AC && busMusic) busMusic.gain.setTargetAtTime(VOL.music * cottonMusicGainScale, AC.currentTime, 0.025);
    if (AC && limiter && !cottonMaster) {
      cottonMaster = AC.createGain();
      cottonMaster.gain.value = cottonMasterLevel;
      limiter.disconnect();
      limiter.connect(cottonMaster);
      cottonMaster.connect(AC.destination);
    }
    return result;
  };
  function cottonSetMaster(value) {
    cottonMasterLevel = clamp(Number(value) || 0, 0, 1);
    ensureAudio();
    if (cottonMaster) cottonMaster.gain.setTargetAtTime(cottonMasterLevel, AC.currentTime, 0.025);
    try {
      localStorage.setItem("yuzu-house-master", String(cottonMasterLevel));
    } catch (e) {
    }
    window.dispatchEvent(new Event("cotton-volume"));
  }
  try {
    var cottonStoredVocal = localStorage.getItem("cotton-theatre-vocal");
    if (cottonStoredVocal !== null) cottonVocalLevel = clamp(Number(cottonStoredVocal) || 0, 0, 1);
  } catch (e) {
  }
  var cottonVocalOutput = null;
  function cottonEnsureSynth() {
    if (!AC || !window.CottonSynth) return null;
    if (!cottonSynth) {
      cottonVocalOutput = AC.createGain();
      cottonVocalOutput.gain.value = 1.5;
      cottonVocalOutput.connect(limiter);
      cottonSynth = CottonSynth.create(AC, busMusic, cottonVocalOutput, { live: true, vocal: cottonVocalLevel, voice: cottonVoiceShape, onNote: function(note) {
        var timer = setTimeout(function() {
          if (!cottonSynth.isCurrent(note.identity)) return;
          window.dispatchEvent(new CustomEvent("cotton-vocal", { detail: { duration: note.duration, syllable: note.syllable, midi: note.midi } }));
        }, Math.max(0, (note.at - AC.currentTime) * 1e3));
        cottonVoiceTimers.push(timer);
        if (cottonVoiceTimers.length > 256) cottonVoiceTimers.splice(0, 128);
      } });
    }
    return cottonSynth;
  }
  musicStart = function() {
    if (!AC || MUS.on) return;
    var synth = cottonEnsureSynth();
    if (!synth) return;
    MUS.on = true;
    cottonMusicStep = 0;
    MUS.nextT = AC.currentTime + 0.055;
    synth.setEpoch(MUS.nextT);
    if (MUS.timer) clearInterval(MUS.timer);
    MUS.timer = setInterval(musicTick, 35);
    musicTick();
  };
  musicStop = function(keepVocal) {
    MUS.on = false;
    if (MUS.timer) {
      clearInterval(MUS.timer);
      MUS.timer = 0;
    }
    if (!keepVocal) {
      if (cottonSynth && AC) cottonSynth.cancel(AC.currentTime + 5e-3);
      cottonVoiceTimers.forEach(clearTimeout);
      cottonVoiceTimers = [];
    }
    if (cottonMergeImpact) cottonMergeImpact.cancel();
  };
  musicTick = function() {
    if (!AC || !MUS.on || !cottonSynth) return;
    var now = AC.currentTime;
    if (MUS.nextT < now - 0.35) MUS.nextT = now + 0.025;
    var guard = 0;
    while (MUS.nextT < now + 0.16 && guard++ < 16) {
      cottonSynth.step(cottonMusicStep, MUS.nextT);
      cottonMusicStep++;
      MUS.nextT += CottonSynth.grid;
    }
  };
  var cottonAudioRawSfx = sfx;
  function cottonEnsureFeedSound() {
    if (!AC) return null;
    if (!cottonFeedSound) {
      var output = AC.createGain();
      output.gain.value = 0.5;
      output.connect(busSfx || limiter);
      cottonFeedSound = CottonSynth.createFeedSound(AC, output);
    }
    return cottonFeedSound;
  }
  var cottonAudioRawFeed = feed;
  feed = function(auto) {
    var prior = cottonFeedAutomatic;
    cottonFeedAudioDepth++;
    cottonFeedAutomatic = !!auto;
    try {
      return cottonAudioRawFeed.apply(this, arguments);
    } finally {
      cottonFeedAudioDepth--;
      cottonFeedAutomatic = prior;
    }
  };
  sfx = function(name) {
    if (name === "drop" && cottonFeedAudioDepth) {
      var pop = cottonEnsureFeedSound();
      if (pop) pop.play(AC.currentTime + 3e-3, cottonFeedAutomatic);
      return;
    }
    return cottonAudioRawSfx.apply(this, arguments);
  };
  var cottonVocalRawStep = applyStep;
  applyStep = function(step) {
    var result = cottonVocalRawStep.apply(this, arguments);
    if (step && step.type === "well" && AC) {
      var synth = cottonEnsureSynth();
      if (synth) synth.strike(AC.currentTime + 8e-3, step.n, step.lv);
    }
    return result;
  };
  function cottonEnsureMergeImpact() {
    if (!AC) return null;
    if (!cottonMergeImpact) cottonMergeImpact = CottonMergeImpactAudio.create(AC, busSfx || limiter);
    return cottonMergeImpact;
  }
  var cottonOriginalTimeline = { "source": "d05-ability-merge.html", "case": "reward4", "description": "原版四颗合成，从松手至结算，含奖励与跨区间双音、低频、上行旋律和收尾", "events": [{ "type": "voice", "at": 16, "args": [660, 0.16, "triangle", 0.05, 0, 0, 1] }, { "type": "voice", "at": 16, "args": [990, 0.2, "sine", 0.028, 0.06, 0, 1] }, { "type": "voice", "at": 16, "args": [140, 0.15, "sine", 0.055, 0, 0, 1] }, { "type": "voice", "at": 16, "args": [70, 0.22, "sine", 0.04, 0, 0, 1] }, { "type": "noise", "at": 16, "args": [0.08, 0.02, 3400, 0] }, { "type": "voice", "at": 16, "args": [110, 0.16, "sine", 0.040119999999999996, 0.02, 0, 1] }, { "type": "voice", "at": 16, "args": [220, 0.105, "triangle", 0.0472, 0.02, 0, 1] }, { "type": "voice", "at": 16, "args": [440, 0.07, "sine", 0.015104, 0.02, 0, 1] }, { "type": "voice", "at": 16, "args": [246.94165062806206, 0.105, "triangle", 0.0472, 0.09000000000000001, 0, 1] }, { "type": "voice", "at": 16, "args": [493.8833012561241, 0.07, "sine", 0.015104, 0.09000000000000001, 0, 1] }, { "type": "voice", "at": 16, "args": [277.1826309768721, 0.105, "triangle", 0.0472, 0.16, 0, 1] }, { "type": "voice", "at": 16, "args": [554.3652619537442, 0.07, "sine", 0.015104, 0.16, 0, 1] }, { "type": "voice", "at": 16, "args": [329.6275569128699, 0.105, "triangle", 0.0472, 0.22999999999999998, 0, 1] }, { "type": "voice", "at": 16, "args": [659.2551138257398, 0.07, "sine", 0.015104, 0.22999999999999998, 0, 1] }, { "type": "voice", "at": 16, "args": [660, 0.16, "triangle", 0.05, 0, 0, 1] }, { "type": "voice", "at": 16, "args": [990, 0.2, "sine", 0.028, 0.06, 0, 1] }, { "type": "voice", "at": 416, "args": [392.0020805232462, 0.13, "sine", 0.032, 0, 0, 1] }, { "type": "voice", "at": 416, "args": [293.6095583119114, 0.14, "sine", 0.028, 0.075, 0, 1] }, { "type": "voice", "at": 416, "args": [196.0010402616231, 0.2, "sine", 0.03, 0.15, 0, 1] }] }, cottonMergePreviewAt = -Infinity;
  function cottonPreviewOriginalMerge() {
    ensureAudio();
    if (!AC || AC.currentTime - cottonMergePreviewAt < 0.85) return false;
    cottonMergePreviewAt = AC.currentTime;
    cottonWithMergeOutput(function() {
      for (var i = 0; i < cottonOriginalTimeline.events.length; i++) {
        var e = cottonOriginalTimeline.events[i], a = e.args.slice();
        if (e.type === "voice") {
          a[4] = (a[4] || 0) + e.at / 1e3;
          voice.apply(null, a);
        } else if (e.type === "noise") {
          a[3] = (a[3] || 0) + e.at / 1e3;
          noiseBurst.apply(null, a);
        }
      }
    }, null, []);
    return true;
  }
  function cottonSetVocal(value) {
    cottonVocalLevel = clamp(Number(value) || 0, 0, 1);
    if (cottonSynth) cottonSynth.setVocal(cottonVocalLevel);
    for (const synth of cottonPetVoices.values()) synth.setVocal(cottonVocalLevel);
    try {
      localStorage.setItem("cotton-theatre-vocal", String(cottonVocalLevel));
    } catch (e) {
    }
    $("vVocal").textContent = Math.round(cottonVocalLevel * 100) + "%";
    $("sVocal").value = Math.round(cottonVocalLevel * 100);
    paintSld($("sVocal"));
  }
  window.CottonMusic = Object.freeze({ getOutput: function() {
    ensureAudio();
    return { context: AC, node: limiter };
  }, getStatus: function() {
    var _a;
    return { playing: MUS.on, music: VOL.music, musicGainScale: cottonMusicGainScale, musicGain: (_a = busMusic == null ? void 0 : busMusic.gain.value) != null ? _a : null, bpm: CottonSynth.bpm, voice: Object.assign({}, cottonVoiceShape), master: cottonMasterLevel, vocal: cottonVocalLevel, context: AC ? AC.state : "not-started", feed: cottonFeedSound ? cottonFeedSound.getStats() : null, synth: cottonSynth ? cottonSynth.getStats() : null };
  }, setVoiceShape: cottonSetVoice, previewVoice: cottonPreviewVoice, petVoice: function(shape, key) {
    ensureAudio();
    var synth = cottonEnsureSynth();
    if (shape && synth) {
      key = String(key || "preview");
      if (!cottonPetVoices.has(key)) cottonPetVoices.set(key, CottonSynth.create(AC, busMusic, cottonVocalOutput, { live: true, vocal: cottonVocalLevel, voice: shape }));
      synth = cottonPetVoices.get(key);
      synth.setVoice(shape);
    }
    return synth ? synth.exclaim(AC.currentTime + 8e-3) : null;
  }, releasePetVoice: function(key) {
    var synth = cottonPetVoices.get(String(key));
    if (synth) synth.dispose();
    cottonPetVoices.delete(String(key));
  }, getPetVoiceStatus: function() {
    return Array.from(cottonPetVoices, ([key, synth]) => __spreadValues({ key }, synth.getStats()));
  }, setMasterVolume: cottonSetMaster, setVocalVolume: cottonSetVocal, renderDemo: function() {
    return CottonSynth.renderDemo({ voice: cottonVoiceShape });
  } });
  $("sVocal").addEventListener("input", function() {
    ensureAudio();
    cottonSetVocal(this.value / 100);
  });
  cottonSetVocal(cottonVocalLevel);
  $("bVocalDemo").addEventListener("click", function() {
    ensureAudio();
    var synth = cottonEnsureSynth();
    if (synth) synth.strike(AC.currentTime + 8e-3, 4, 4);
  });
  $("bExportMusic").addEventListener("click", async function() {
    var button = this;
    button.disabled = true;
    button.textContent = "正在合成试听…";
    try {
      var audio = await CottonSynth.renderDemo({ voice: cottonVoiceShape }), url = URL.createObjectURL(audio.blob), a = document.createElement("a");
      a.href = url;
      a.download = "棉糖合成人声-试听.wav";
      a.click();
      setTimeout(function() {
        URL.revokeObjectURL(url);
      }, 3e3);
      button.textContent = "已导出试听 WAV";
    } catch (error) {
      button.textContent = "导出未完成，请使用较新的浏览器";
    } finally {
      button.disabled = false;
      setTimeout(function() {
        button.textContent = "导出试听 WAV";
      }, 3500);
    }
  });
  $("bFeedDemo").addEventListener("click", function() {
    ensureAudio();
    var pop = cottonEnsureFeedSound();
    if (pop) pop.play(AC.currentTime + 3e-3, false);
  });
  window.CottonMergeImpact = Object.freeze({ getStatus: function() {
    return { source: "d05-ability-merge.html", mode: "original-full-release-settlement", previewEvents: cottonOriginalTimeline.events.length };
  }, preview: cottonPreviewOriginalMerge });
  $("bMergeDemo").addEventListener("click", function() {
    CottonMergeImpact.preview();
  });
  window.addEventListener("cotton-game", function(e) {
    if (["home", "reset"].indexOf((e.detail || {}).type) >= 0 && cottonMergeImpact) cottonMergeImpact.cancel();
  });
  function cottonCreatePulseSound(ctx, dest) {
    var played = 0, empty = 0, lastEmpty = -Infinity, active = 0;
    var air = ctx.createBuffer(1, Math.ceil(ctx.sampleRate * 0.06), ctx.sampleRate), data = air.getChannelData(0), seed = 38017;
    for (var i = 0; i < data.length; i++) {
      seed = Math.imul(seed, 1664525) + 1013904223 >>> 0;
      data[i] = seed / 2147483648 - 1;
    }
    function tone(at, points, volume, duration, type) {
      var o = ctx.createOscillator(), g = ctx.createGain(), f = ctx.createBiquadFilter();
      o.type = type || "sine";
      o.frequency.setValueAtTime(points[0][1], at);
      for (var j = 1; j < points.length; j++) o.frequency.exponentialRampToValueAtTime(points[j][1], at + points[j][0]);
      f.type = "lowpass";
      f.frequency.value = 1900;
      g.gain.setValueAtTime(1e-4, at);
      g.gain.exponentialRampToValueAtTime(volume, at + 6e-3);
      g.gain.exponentialRampToValueAtTime(1e-4, at + duration);
      o.connect(f);
      f.connect(g);
      g.connect(dest);
      o.start(at);
      o.stop(at + duration + 0.025);
      active++;
      o.onended = function() {
        active--;
        o.disconnect();
        g.disconnect();
        f.disconnect();
      };
    }
    function play(at, ready) {
      var t = Math.max(ctx.currentTime + 3e-3, at || 0);
      if (ready === false) {
        if (t - lastEmpty < 0.14) return false;
        lastEmpty = t;
        empty++;
        tone(t, [[0, 210], [0.05, 155]], 0.024, 0.065);
        return true;
      }
      played++;
      tone(t, [[0, 190], [0.035, 510], [0.16, 235]], 0.085, 0.205, "triangle");
      tone(t + 0.035, [[0, 128], [0.12, 73]], 0.11, 0.17);
      var src = ctx.createBufferSource(), f = ctx.createBiquadFilter(), g = ctx.createGain();
      src.buffer = air;
      f.type = "bandpass";
      f.Q.value = 0.7;
      f.frequency.setValueAtTime(1700, t);
      f.frequency.exponentialRampToValueAtTime(650, t + 0.05);
      g.gain.setValueAtTime(1e-4, t);
      g.gain.exponentialRampToValueAtTime(0.021, t + 9e-3);
      g.gain.exponentialRampToValueAtTime(1e-4, t + 0.055);
      src.connect(f);
      f.connect(g);
      g.connect(dest);
      src.start(t);
      src.stop(t + 0.06);
      src.onended = function() {
        src.disconnect();
        f.disconnect();
        g.disconnect();
      };
      return true;
    }
    return { play, getStats: function() {
      return { played, notReady: empty, active, name: "奶糖能量波", kind: "pulse-only rounded sweep", duration: 0.23 };
    } };
  }
  var cottonPulseAudioDepth = 0, cottonPulsePlayed = false, cottonPulseSound = null, cottonPulseRaw = { release: releasePulse, sfx };
  function cottonEnsurePulseSound() {
    if (!AC) return null;
    if (!cottonPulseSound) cottonPulseSound = cottonCreatePulseSound(AC, busSfx || limiter);
    return cottonPulseSound;
  }
  sfx = function(name) {
    if (name === "band" && cottonPulseAudioDepth && !cottonPulsePlayed) {
      cottonPulsePlayed = true;
      var p = cottonEnsurePulseSound();
      if (p) p.play(AC.currentTime + 3e-3, true);
      return;
    }
    return cottonPulseRaw.sfx.apply(this, arguments);
  };
  releasePulse = function() {
    var prior = cottonPulsePlayed, allowed = !G.locked && !G.over, was = G.pulses;
    cottonPulsePlayed = false;
    cottonPulseAudioDepth++;
    try {
      return cottonPulseRaw.release.apply(this, arguments);
    } finally {
      cottonPulseAudioDepth--;
      if (allowed && G.pulses === was) {
        var p = cottonEnsurePulseSound();
        if (p) p.play(AC.currentTime + 3e-3, false);
      }
      cottonPulsePlayed = prior;
    }
  };
  window.CottonPulseAudio = Object.freeze({ getStatus: function() {
    return cottonPulseSound ? cottonPulseSound.getStats() : { played: 0, notReady: 0, active: 0, name: "奶糖能量波" };
  }, preview: function() {
    ensureAudio();
    return cottonEnsurePulseSound().play(AC.currentTime + 3e-3, true);
  } });
  var cottonMergeOutputDepth = 0, cottonMergeOutputs = /* @__PURE__ */ new WeakMap();
  function cottonWithMergeOutput(fn, self, args) {
    if (!AC || cottonMergeOutputDepth) return fn.apply(self, args);
    var parent = busSfx || limiter, output = cottonMergeOutputs.get(parent);
    if (!output) {
      output = AC.createGain();
      output.gain.value = 1.5;
      output.connect(parent);
      cottonMergeOutputs.set(parent, output);
    }
    var prior = busSfx;
    cottonMergeOutputDepth++;
    busSfx = output;
    try {
      return fn.apply(self, args);
    } finally {
      busSfx = prior;
      cottonMergeOutputDepth--;
    }
  }
  var cottonBalancedRaw = { sfx, sfxMerge, playRise, sfxChainEnd, sfxHole, sfxBoom, updateHole };
  sfx = function(name) {
    if (name === "drop" && cottonFeedAudioDepth || name === "band" && cottonPulseAudioDepth && !cottonPulsePlayed) return cottonBalancedRaw.sfx.apply(this, arguments);
    if (["band", "upReady", "drop", "merge", "clear"].indexOf(name) >= 0) return cottonWithMergeOutput(cottonBalancedRaw.sfx, this, arguments);
    return cottonBalancedRaw.sfx.apply(this, arguments);
  };
  sfxMerge = function() {
    return cottonWithMergeOutput(cottonBalancedRaw.sfxMerge, this, arguments);
  };
  playRise = function() {
    return cottonWithMergeOutput(cottonBalancedRaw.playRise, this, arguments);
  };
  sfxChainEnd = function() {
    return cottonWithMergeOutput(cottonBalancedRaw.sfxChainEnd, this, arguments);
  };
  sfxHole = function() {
    return cottonWithMergeOutput(cottonBalancedRaw.sfxHole, this, arguments);
  };
  sfxBoom = function() {
    return cottonWithMergeOutput(cottonBalancedRaw.sfxBoom, this, arguments);
  };
  updateHole = function() {
    return cottonWithMergeOutput(cottonBalancedRaw.updateHole, this, arguments);
  };
  window.CottonAudioBalance = Object.freeze({ getStatus: function() {
    return { feed: 0.5, merge: 1.5, vocal: 1.5, nesting: cottonMergeOutputDepth, ui: 1, music: 1.4 };
  } });
  (function() {
    "use strict";
    const samples = { "click": { "sampleRate": 22050, "pcm": "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" }, "tab": { "sampleRate": 22050, "pcm": "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" }, "dress": { "sampleRate": 22050, "pcm": "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" }, "color": { "sampleRate": 22050, "pcm": "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" }, "confirm": { "sampleRate": 22050, "pcm": "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" }, "back": { "sampleRate": 22050, "pcm": "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" }, "toggle": { "sampleRate": 22050, "pcm": "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" } }, buffers = /* @__PURE__ */ new Map(), active = /* @__PURE__ */ new Set(), counts = { click: 0, tab: 0, dress: 0, color: 0, confirm: 0, back: 0, toggle: 0 };
    let played = 0, handling = false, dispatch = 0, lastKind = "", lastSource = "", lastAt = -1e3, errors = 0, suppressed = 0;
    function prepare() {
      ensureAudio();
      if (!AC || !busSfx) return false;
      if (!buffers.size) for (const [kind2, sample] of Object.entries(samples)) {
        const raw = atob(sample.pcm), buf = AC.createBuffer(1, raw.length / 2, sample.sampleRate), values = buf.getChannelData(0);
        for (let i = 0; i < values.length; i++) {
          let v = raw.charCodeAt(i * 2) | raw.charCodeAt(i * 2 + 1) << 8;
          if (v > 32767) v -= 65536;
          values[i] = v / 32768;
        }
        buffers.set(kind2, buf);
      }
      return true;
    }
    function play(kind2 = "click", source = "ui") {
      if (!samples[kind2]) kind2 = "click";
      try {
        if (!prepare()) return false;
        const now = AC.currentTime;
        for (const voice3 of active) if (active.size >= 5) {
          voice3.gain.gain.cancelScheduledValues(now);
          voice3.gain.gain.setTargetAtTime(1e-4, now, 4e-3);
          voice3.node.stop(now + 0.018);
          active.delete(voice3);
        }
        const node = AC.createBufferSource(), gain = AC.createGain(), voice2 = { node, gain };
        node.buffer = buffers.get(kind2);
        node.playbackRate.value = { click: 1.04, tab: 1.06, dress: 1.05, color: 1.1, confirm: 1, back: 1, toggle: 1.04 }[kind2] * (1 + (counts[kind2] % 3 - 1) * 0.012);
        gain.gain.value = kind2 === "confirm" ? 0.31 : kind2 === "tab" ? 0.32 : 0.42;
        node.connect(gain);
        gain.connect(busSfx);
        active.add(voice2);
        node.onended = () => {
          active.delete(voice2);
          node.disconnect();
          gain.disconnect();
        };
        node.start(now + 2e-3);
        counts[kind2]++;
        played++;
        lastKind = kind2;
        lastSource = String(source).slice(0, 80);
        lastAt = performance.now();
        document.body.dataset.uiSoundCount = String(played);
        document.body.dataset.uiSoundKind = kind2;
        return true;
      } catch (error) {
        errors++;
        return false;
      }
    }
    function target(e) {
      const el = e.target.closest('button,[role="button"],summary,input[type="checkbox"]');
      if (!el || ["bFeed", "bPulse"].includes(el.id) || el.closest("#board,#qaControls") || el.disabled || el.getAttribute("aria-disabled") === "true" || el.closest("[inert]")) return null;
      return el;
    }
    function kind(el) {
      if (["wardrobeDone", "bSetClose", "bCxClose", "bWinBack", "guideSkip"].includes(el.id)) return "back";
      if (["bStart", "bFree", "bUpA", "bUpB", "bUpC", "bWinFresh", "bWinKeep"].includes(el.id)) return "confirm";
      if (el.matches('input[type="checkbox"]')) return "toggle";
      return "click";
    }
    document.addEventListener("click", (e) => {
      const el = target(e), stamp = ++dispatch;
      handling = !!el;
      queueMicrotask(() => {
        if (stamp === dispatch) handling = false;
      });
      if (!el || !e.isTrusted || e.button > 0) return;
      play(kind(el), el.id || el.getAttribute("aria-label") || el.textContent);
    }, true);
    document.addEventListener("change", (e) => {
      if (e.isTrusted && e.target.matches('select,input[type="range"]') && !["voicePitch", "voiceSize", "voiceSoft"].includes(e.target.id)) play("tab", e.target.id);
    }, true);
    const legacy = sfx;
    sfx = function(name) {
      if (name === "tap" && handling) {
        suppressed++;
        return;
      }
      return legacy.apply(this, arguments);
    };
    window.CottonUIAudio = Object.freeze({ play, getStatus: () => ({ played, counts: __spreadValues({}, counts), lastKind, lastSource, lastAt, active: active.size, decoded: buffers.size, context: AC ? AC.state : "not-started", errors, suppressedLegacyTaps: suppressed, output: "shared-sfx-and-master", selected: "D", source: "Original cartoon mew — D 奶猫啾" }) });
  })();
  var cottonSpokenSeen = {}, cottonSpokenPending = 0, cottonGuideRaw = { tutSay, markUpPending, pickUpgrade, openMenu };
  function cottonSpeak(text, hold) {
    window.dispatchEvent(new CustomEvent("cotton-speech", { detail: { text, duration: hold || 4300 } }));
  }
  tutSay = function(key, text, hold) {
    if (cottonSpokenSeen[key]) return;
    cottonSpokenSeen[key] = true;
    var lines = { t1: "把同级的小甜品拖到一起，就能合成啦。", t3: "也可以先挪到空格，把同级的凑近一点。" };
    cottonSpeak(lines[key] || String(text).replace(/——/g, "，").slice(0, 48), Math.min(6e3, hold || 4300));
  };
  markUpPending = function() {
    var r = cottonGuideRaw.markUpPending.apply(this, arguments);
    if (G.pendingUps > cottonSpokenPending && !menuOpen) cottonSpeak("升级啦！点左上角的等级，选个喜欢的增益吧。", 4800);
    cottonSpokenPending = G.pendingUps;
    return r;
  };
  pickUpgrade = function(id) {
    var def = UP_DEFS.find(function(d) {
      return d.id === id;
    }), was = $("up").classList.contains("on"), r = cottonGuideRaw.pickUpgrade.apply(this, arguments);
    cottonSpokenPending = G.pendingUps;
    if (was && def) cottonSpeak("收到「" + def.name + "」啦，一起继续合成吧。", 4e3);
    return r;
  };
  openMenu = function() {
    var r = cottonGuideRaw.openMenu.apply(this, arguments);
    cottonSpeak("", 0);
    return r;
  };
  setTimeout(function() {
    $("tut").textContent = "";
    if ($("bHowTo")) {
      $("bHowTo").setAttribute("aria-label", "玩法图解");
      $("bHowTo").onclick = function() {
        window.dispatchEvent(new Event("cotton-howto"));
      };
    }
  }, 0);
  window.CottonGuide = { show: function() {
    cottonSpeak("拖动同级甜品来合成，升级后点左上角选增益哦。", 5400);
  }, getStatus: function() {
    return { page: -1, coach: false, introSeen: true, upgradeSeen: true, blocksFeed: false, mode: "character-speech" };
  } };
  if (window.COTTON_QA) window.CottonGuide.testing = { reset: function() {
    cottonSpokenSeen = {};
    cottonSpokenPending = 0;
    cottonSpeak("", 0);
  } };
  var cottonFeedback = null, cottonParticles = [], cottonFxFrame = 0, cottonFxSerial = 0, cottonFxCounts = { merges: 0, taps: 0, jellies: 0 }, cottonLastFlash = -1e3;
  var cottonFeedbackRaw = { applyStep, onDown, showPred, buildBoard, shakeScreen, shakeBurst, updateShake, flashScreen };
  function cottonFeedbackSetup() {
    if (!cottonFeedback) {
      var layer = document.createElement("div");
      layer.id = "cottonFeedbackLayer";
      var canvas = document.createElement("canvas");
      canvas.setAttribute("aria-hidden", "true");
      layer.appendChild(canvas);
      document.body.appendChild(layer);
      cottonFeedback = { layer, canvas, g: canvas.getContext("2d") };
      var base = document.createElement("div");
      base.id = "cottonBackdropBase";
      var back = document.createElement("canvas");
      back.id = "cottonBackdropCanvas";
      back.setAttribute("aria-hidden", "true");
      document.body.insertBefore(base, document.body.firstChild);
      document.body.insertBefore(back, base.nextSibling);
      cottonFeedback.base = base;
      cottonFeedback.back = back;
      cottonFeedback.bg = back.getContext("2d");
      base.hidden = back.hidden = menuOpen;
      cottonFeedback.layer.hidden = menuOpen;
      cottonFeedbackResize();
      window.addEventListener("resize", cottonFeedbackResize);
    }
    [predEl, burstEl, holeEl, $("flash"), $("msBanner")].forEach(function(el) {
      if (el && el.parentNode !== cottonFeedback.layer) cottonFeedback.layer.appendChild(el);
    });
    cottonFeedbackPosition();
  }
  function cottonFeedbackPosition() {
    if (!cottonFeedback || !appEl) return;
    var r = appEl.getBoundingClientRect();
    if (cottonFeedback.base) {
      var bs = cottonFeedback.base.style;
      bs.left = r.left + "px";
      bs.top = r.top + "px";
      bs.width = r.width + "px";
      bs.height = r.height + "px";
      bs.borderRadius = getComputedStyle(appEl).borderRadius;
    }
    [burstEl, holeEl].forEach(function(el) {
      if (el) {
        el.style.left = r.left + "px";
        el.style.top = r.top + "px";
        el.style.width = r.width + "px";
        el.style.height = r.height + "px";
      }
    });
    var stage = $("puppet").getBoundingClientRect(), banner = $("msBanner");
    banner.style.left = stage.right - 10 + "px";
    banner.style.top = stage.top + 10 + "px";
    if (predEl && predEl.classList.contains("on") && cottonFeedback.pred) cottonFeedbackPred(cottonFeedback.pred);
  }
  function cottonFeedbackResize() {
    if (!cottonFeedback) return;
    var d = Math.min(2, window.devicePixelRatio || 1), c = cottonFeedback.canvas;
    c.width = Math.round(innerWidth * d);
    c.height = Math.round(innerHeight * d);
    cottonFeedback.g.setTransform(d, 0, 0, d, 0, 0);
    cottonFeedback.back.width = c.width;
    cottonFeedback.back.height = c.height;
    cottonFeedback.bg.setTransform(d, 0, 0, d, 0, 0);
    cottonFeedbackPosition();
  }
  function cottonFeedbackPred(p) {
    var r = boardEl.getBoundingClientRect(), cs = GEO.cs || 50, x = r.left + p.x, y = r.top + p.y, up = y - cs * 0.88;
    predEl.style.left = clamp(x, 80, innerWidth - 80) + "px";
    predEl.style.top = clamp(up < r.top + 12 ? y + cs * 0.88 : up, 25, innerHeight - 25) + "px";
  }
  showPred = function(n, x, y, hole) {
    cottonFeedbackSetup();
    var result = cottonFeedbackRaw.showPred.apply(this, arguments);
    cottonFeedback.pred = { x, y };
    cottonFeedbackPred(cottonFeedback.pred);
    return result;
  };
  var cottonFxIds = [0, 2, 3, 4, 5, 7, 8], cottonFxKinds = ["心动啵啵", "糖果泡泡", "星星弹射", "彩虹弧光", "蝴蝶彩带", "软糖光圈", "旋转方块"], cottonFxSeen = {};
  function cottonFxStar(g, x, y, r, angle) {
    g.beginPath();
    for (var j = 0; j < 10; j++) {
      var a = angle - Math.PI / 2 + j * Math.PI / 5, rr = j % 2 ? r * 0.48 : r;
      j ? g.lineTo(x + Math.cos(a) * rr, y + Math.sin(a) * rr) : g.moveTo(x + Math.cos(a) * rr, y + Math.sin(a) * rr);
    }
    g.closePath();
  }
  function cottonFxHeart(g, x, y, r) {
    g.beginPath();
    g.moveTo(x, y + r * 0.8);
    g.bezierCurveTo(x - r * 1.8, y - r * 0.25, x - r * 0.75, y - r * 1.5, x, y - r * 0.55);
    g.bezierCurveTo(x + r * 0.75, y - r * 1.5, x + r * 1.8, y - r * 0.25, x, y + r * 0.8);
    g.closePath();
  }
  function cottonFxEmit(x, y, n, level, tap, impact) {
    cottonFeedbackSetup();
    var serial = cottonFxSerial++, kind = cottonFxIds[Math.floor(serial / 2) % cottonFxIds.length], colors = ["#e6b1c7", "#c6b7df", "#aed6c8", "#b4d3e2", "#e7c5a8", "#dfb4c8", "#bdd4e6", "#c7bfe2", "#e2cfa9", "#e9d3b1"];
    if (!tap && !impact) cottonFxSeen[kind] = true;
    cottonParticles.push({ x, y, n, kind, at: performance.now() + (tap || impact ? 0 : 250), life: tap ? 140 : impact ? 140 : n < 4 ? 280 : 340, ink: ["#bc829c", "#a08ab9", "#83ad9b", "#8aaabd", "#bd9b80"][Math.max(0, level - 1) % 5], color: colors[Math.max(0, level - 1) % colors.length], tap: !!tap, impact: !!impact, seed: serial });
    if (cottonParticles.length > 4) cottonParticles.shift();
    if (!cottonFxFrame) cottonFxFrame = requestAnimationFrame(cottonFxDraw);
  }
  var cottonFullFx = null, cottonFullSerial = 0, cottonFullIds = [0, 1, 2, 4, 5, 6, 7, 9, 10, 11], cottonFullKinds = ["彩带横扫", "丝带落幕", "斜切色纸", "彩点节拍", "双侧弧线", "星形放射", "波浪条纹", "双环交叠", "扇形开合", "长条穿梭"];
  function cottonFullEmit(n, level) {
    cottonFeedbackSetup();
    var now = performance.now();
    if (cottonFullFx && now - cottonFullFx.at < 300) return;
    cottonFullFx = { at: now + 250, life: 560, kind: cottonFullIds[cottonFullSerial++ % cottonFullIds.length], color: ["#f1cfe0", "#ddd2f0", "#cce9df", "#cee4f4", "#f6e3ba"][Math.max(0, level - 1) % 5], secondary: ["#d4e9e4", "#f3dbd0", "#e1d9f1", "#f6e6bf", "#dce7f5"][Math.max(0, level - 1) % 5], n, anchor: [[0.18, 0.35], [0.82, 0.42], [0.3, 0.7], [0.72, 0.26], [0.5, 0.5]][cottonFullSerial % 5], direction: (cottonFullSerial + Math.floor(cottonFullSerial / 11)) % 2 ? 1 : -1 };
    if (!cottonFxFrame) cottonFxFrame = requestAnimationFrame(cottonFxDraw);
  }
  function cottonFullDraw(g, now) {
    var e = cottonFullFx;
    if (!e || now < e.at) return;
    if (now - e.at >= e.life) {
      cottonFullFx = null;
      return;
    }
    var q = Math.max(0, Math.min(1, (now - e.at) / e.life)), p = 1 - Math.pow(1 - q, 3), area = $("puppet").getBoundingClientRect(), w = area.width, h = area.height, u = Math.min(w, h), pulse = Math.sin(q * Math.PI), kind = e.kind;
    g.save();
    g.translate(area.left, area.top);
    g.beginPath();
    g.rect(0, 0, w, h);
    g.clip();
    g.globalAlpha = 1;
    g.fillStyle = e.color;
    g.strokeStyle = e.color;
    g.lineWidth = 6;
    g.lineCap = "round";
    var ax = e.anchor[0] * w, ay = e.anchor[1] * h;
    if (e.direction < 0) {
      g.translate(w, 0);
      g.scale(-1, 1);
    }
    if (kind === 0 || kind === 11) {
      for (var i = 0; i < 3; i++) {
        var x = -w * 1.15 + p * w * 2.4 - i % 2 * w * 0.4, y = h * (0.09 + e.anchor[1] * 0.2 + i * 0.27);
        g.save();
        g.translate(x, y);
        if (kind === 11) g.rotate(-0.18);
        g.beginPath();
        g.moveTo(0, 0);
        g.lineTo(w * 0.85, 0);
        g.lineTo(w * 0.85 - u * 0.045, u * 0.07);
        g.lineTo(0, u * 0.07);
        g.lineTo(u * 0.04, u * 0.035);
        g.closePath();
        g.fill();
        g.restore();
      }
    } else if (kind === 1) {
      for (var i = 0; i < 4; i++) {
        var x = w * (0.1 + i * 0.25), y = -h + p * h * 1.5 - i % 2 * h * 0.2;
        g.fillRect(x, y, u * 0.075, h * 0.78);
        g.fillStyle = i % 2 ? e.secondary : e.color;
      }
    } else if (kind === 2) {
      g.save();
      g.translate(w * 0.5, h * 0.5);
      g.rotate(-0.6);
      for (var i = -2; i <= 2; i++) g.fillRect(-w + p * w * 0.75, i * u * 0.18, w * 1.1, u * 0.065);
      g.restore();
    } else if (kind === 4) {
      for (var r = 0; r < 5; r++) for (var c = 0; c < 7; c++) {
        g.beginPath();
        g.arc(w * (c + 0.5) / 7, h * (r + 0.5) / 5, u * 0.014 * pulse * (0.6 + 0.4 * Math.sin(q * 8 + r + c)), 0, Math.PI * 2);
        g.fill();
      }
    } else if (kind === 5) {
      for (var side = 0; side < 2; side++) {
        g.lineWidth = u * 0.013;
        g.beginPath();
        g.arc(side ? w : 0, h * 0.52, u * (0.25 + p * 0.65), -Math.PI * 0.8, Math.PI * 0.8);
        g.stroke();
        g.lineWidth = 2;
        g.beginPath();
        g.arc(side ? w : 0, h * 0.52, u * (0.32 + p * 0.65), -Math.PI * 0.8, Math.PI * 0.8);
        g.stroke();
      }
    } else if (kind === 6) {
      for (var i = 0; i < 8; i++) {
        var a = i * Math.PI / 4, r = u * (0.22 + p * 0.32);
        cottonFxStar(g, ax + Math.cos(a) * r, ay + Math.sin(a) * r, u * 0.04 * p * pulse, a * 0.1);
        g.fill();
      }
    } else if (kind === 7) {
      for (var j = 0; j < 3; j++) {
        g.beginPath();
        for (var x = 0; x <= w + 20; x += 20) {
          var y = h * (0.22 + j * 0.28) + Math.sin(x / w * Math.PI * 2 + p * 3) * u * 0.08;
          x ? g.lineTo(x, y) : g.moveTo(x, y);
        }
        g.lineWidth = u * 0.012;
        g.stroke();
      }
    } else if (kind === 9) {
      g.lineWidth = u * 0.023;
      for (var j = 0; j < 2; j++) {
        g.beginPath();
        g.arc(w * (j ? 0.63 : 0.37), ay, u * (0.16 + p * 0.21), 0, Math.PI * 2);
        g.stroke();
      }
    } else if (kind === 10) {
      for (var corner = 0; corner < 2; corner++) {
        g.save();
        g.translate(corner ? w : 0, corner ? 0 : h);
        g.rotate(corner ? Math.PI / 2 : -Math.PI / 2);
        for (var i = 0; i < 3; i++) {
          g.beginPath();
          g.moveTo(0, 0);
          g.arc(0, 0, u * (0.5 + p * 0.4), i * 0.28 + q * 0.3, i * 0.28 + 0.14 + q * 0.3);
          g.closePath();
          g.fill();
        }
        g.restore();
      }
    }
    g.restore();
  }
  function cottonFxDraw(now) {
    var g = cottonFeedback.g;
    g.clearRect(0, 0, innerWidth, innerHeight);
    var bg = cottonFeedback.bg;
    bg.clearRect(0, 0, innerWidth, innerHeight);
    cottonFullDraw(bg, now);
    cottonParticles = cottonParticles.filter(function(v) {
      return now - v.at < v.life;
    });
    for (var e of cottonParticles) {
      if (now < e.at) continue;
      var q = Math.max(0, Math.min(1, (now - e.at) / e.life)), p = 1 - Math.pow(1 - q, 4), unit = GEO.cs || 55, r = unit * (0.16 + (0.94 + Math.min(8, e.n) * 0.012) * p), fade = q < 0.24 ? 1 : Math.pow((1 - q) / 0.76, 1.7);
      g.save();
      g.globalAlpha = fade;
      g.strokeStyle = e.color;
      g.fillStyle = e.color;
      g.lineWidth = 3;
      g.lineCap = "round";
      if (e.tap || e.impact) {
        var cr = e.impact ? unit * (0.4 - 0.2 * q) : unit * 0.38 * p;
        g.globalAlpha = (1 - q) * 0.6;
        g.lineWidth = 2;
        g.beginPath();
        g.arc(e.x, e.y, Math.max(2, cr), 0, Math.PI * 2);
        g.stroke();
      } else {
        g.strokeStyle = e.ink || e.color;
        g.lineWidth = 5.5 * (1 - q) + 1.2;
        g.beginPath();
        g.arc(e.x, e.y, Math.max(2, r * 0.82), 0, Math.PI * 2);
        g.stroke();
        if (q < 0.68) {
          g.strokeStyle = e.color;
          g.lineWidth = 2.2 * (1 - q) + 0.5;
          g.beginPath();
          g.arc(e.x, e.y, r * 1.05, Math.PI * 0.14 + q * 0.3, Math.PI * 0.8 + q * 0.3);
          g.stroke();
          g.beginPath();
          g.arc(e.x, e.y, r * 1.05, Math.PI * 1.14 + q * 0.3, Math.PI * 1.8 + q * 0.3);
          g.stroke();
        }
        if (e.kind === 4) {
          g.lineWidth = 3;
          g.strokeStyle = "#eddcb8";
          g.beginPath();
          g.arc(e.x, e.y, Math.max(2, r * 0.87), Math.PI * 1.05, Math.PI * 1.95);
          g.stroke();
        }
        var amount = [3, 0, 4, 4, 2, 4, 0, 2, 3][e.kind];
        for (var i = 0; i < amount; i++) {
          var a = i * Math.PI * 2 / amount + e.kind * 0.35 + (e.kind === 8 ? p * Math.PI * 0.72 : 0), rr = r * (0.95 + i % 2 * 0.12), x = e.x + Math.cos(a) * rr, y = e.y + Math.sin(a) * rr, size = unit * 0.085 * (1 - q * 0.45);
          g.save();
          g.translate(x, y);
          g.rotate(a * 0.12 + q * 0.4);
          g.fillStyle = e.color;
          g.strokeStyle = "#fffcf5";
          g.lineWidth = 1;
          if (e.kind === 8) {
            g.rotate(q * Math.PI * 1.6);
            g.strokeStyle = e.ink;
            g.lineWidth = 2;
            g.strokeRect(-size, -size, size * 2, size * 2);
          } else if (e.kind === 0) {
            cottonFxHeart(g, 0, 0, size);
            g.fill();
            g.stroke();
          } else if (e.kind === 2) {
            g.beginPath();
            g.arc(0, 0, size, 0, Math.PI * 2);
            g.fill();
            g.stroke();
          } else if (e.kind === 5) {
            g.beginPath();
            g.moveTo(-size, -size * 0.5);
            g.lineTo(size, -size * 0.5);
            g.lineTo(size * 0.5, size * 0.5);
            g.lineTo(-size * 1.5, size * 0.5);
            g.closePath();
            g.fill();
          } else {
            cottonFxStar(g, 0, 0, size * 1.2, 0);
            g.fill();
            g.stroke();
          }
          g.restore();
        }
        if (e.n >= 2 && q < 0.48) {
          g.strokeStyle = e.ink || e.color;
          g.lineWidth = 3 * (1 - q) + 1;
          for (var i = 0; i < 4; i++) {
            var a = i * Math.PI / 2 + Math.PI / 4;
            g.beginPath();
            g.moveTo(e.x + Math.cos(a) * r * 0.9, e.y + Math.sin(a) * r * 0.9);
            g.lineTo(e.x + Math.cos(a) * r * 1.18, e.y + Math.sin(a) * r * 1.18);
            g.stroke();
          }
        }
      }
      g.restore();
    }
    cottonFxFrame = cottonParticles.length || cottonFullFx ? requestAnimationFrame(cottonFxDraw) : 0;
  }
  applyStep = function(s) {
    var center = s && s.type === "well" ? cellCenter(s.idx) : null, r = center ? boardEl.getBoundingClientRect() : null, result = cottonFeedbackRaw.applyStep.apply(this, arguments);
    if (center) {
      cottonFxCounts.merges++;
      cottonFullEmit(s.n, s.lv);
      cottonFxEmit(r.left + center.x, r.top + center.y, s.n, s.lv, false, true);
      cottonFxEmit(r.left + center.x, r.top + center.y, s.n, s.lv, false);
    }
    return result;
  };
  onDown = function(e) {
    var result = cottonFeedbackRaw.onDown.apply(this, arguments);
    if (drag && e.clientX !== void 0) {
      cottonFxCounts.taps++;
      cottonFxEmit(e.clientX, e.clientY, 0, drag.lv || 1, true);
    }
    return result;
  };
  var cottonLastShake = -1e4;
  shakeScreen = function(n) {
    var now = performance.now();
    if (n < 6 || now - cottonLastShake < 1e3) return;
    cottonLastShake = now;
    var r = cottonFeedbackRaw.shakeScreen.call(this, n);
    cottonFxCounts.jellies++;
    cottonSignal("jelly", { strength: Math.min(1, (n - 1) / 7), duration: 0.65 });
    return r;
  };
  shakeBurst = function(ms, amp) {
    var now = performance.now();
    if (now - cottonLastShake < 1e3) return;
    cottonLastShake = now;
    var r = cottonFeedbackRaw.shakeBurst.call(this, ms, amp);
    cottonFxCounts.jellies++;
    cottonSignal("jelly", { strength: Math.min(1, (amp || 3) / 7), duration: 0.9 });
    return r;
  };
  updateShake = function(dt) {
    var was = shakeT > 0 || burstShake > 0, r = cottonFeedbackRaw.updateShake.apply(this, arguments);
    if (was) {
      cottonFeedbackPosition();
      window.dispatchEvent(new Event("cotton-shake-frame"));
    }
    return r;
  };
  flashScreen = function(strong) {
    var now = performance.now();
    if (!strong && now - cottonLastFlash < 280) return;
    cottonLastFlash = now;
    cottonFeedbackSetup();
    return cottonFeedbackRaw.flashScreen.apply(this, arguments);
  };
  buildBoard = function() {
    var r = cottonFeedbackRaw.buildBoard.apply(this, arguments);
    setTimeout(cottonFeedbackSetup, 0);
    return r;
  };
  window.addEventListener("cotton-game", function(e) {
    if (cottonFeedback && e.detail && e.detail.state) cottonFeedback.layer.hidden = cottonFeedback.base.hidden = cottonFeedback.back.hidden = !!e.detail.state.menu;
  });
  setTimeout(cottonFeedbackSetup, 0);
  window.CottonFeedback = { getStatus: function() {
    return { counts: cottonFxCounts, activeEffects: cottonParticles.length, effectKinds: cottonFxKinds.slice(), fullScreenKinds: cottonFullKinds.slice(), fullScreenLayer: "stage-background", fullScreenOpacity: 1, bloom: { landingDelayMs: 250, maxRadiusCells: 1.196, shape: "outward-ring-arcs-and-four-accents" }, shakeThreshold: 6, shakeCooldownMs: 1e3, backgroundCanvas: cottonFeedback && cottonFeedback.back.id, activeFullScreen: cottonFullFx ? 1 : 0, seenKinds: Object.keys(cottonFxSeen).length, layer: cottonFeedback && cottonFeedback.layer.id, portalNodes: cottonFeedback ? [].map.call(cottonFeedback.layer.children, function(v) {
      return v.id || v.tagName;
    }) : [] };
  } };
  function cottonClearLegacyStageText() {
    clearTimeout(toastTimer);
    clearTimeout(msTimer);
    for (var id of ["toast", "msBanner"]) {
      var el = $(id);
      if (el) {
        el.classList.remove("on");
        el.hidden = true;
        el.setAttribute("aria-hidden", "true");
      }
    }
    if ($("toast")) $("toast").textContent = "";
    if ($("msT")) $("msT").textContent = "";
    if ($("msS")) $("msS").textContent = "";
  }
  toast = function() {
    cottonClearLegacyStageText();
  };
  showMsBanner = function() {
    cottonClearLegacyStageText();
  };
  cottonClearLegacyStageText();
  var yuzuChapters = [
    { name: "初次开场", level: 3, merges: 2, seed: 36001, pace: 1.65, theme: "cream", note: "把同级甜品放在一起，暖暖场。" },
    { name: "薄荷小合奏", level: 4, merges: 4, seed: 36002, pace: 1.4, theme: "mint", note: "多攒几颗，再一起合成。" },
    { name: "月光练习曲", level: 5, merges: 6, seed: 36003, pace: 1.2, theme: "lilac", note: "升级后，试试不同的增益。" },
    { name: "粉色谢幕", level: 6, merges: 8, seed: 36004, pace: 1, theme: "peach", note: "把今天的小小舞台演到最后吧。" }
  ];
  var yuzuRun = { chapter: -1, merges: 0, highest: 1, done: false, loading: false }, yuzuProgress = { completed: [] }, yuzuLevelPaused = false;
  try {
    var yp = JSON.parse(localStorage.getItem("yuzu-chapters36"));
    if (yp && Array.isArray(yp.completed)) yuzuProgress.completed = yp.completed.filter(function(n) {
      return Number.isInteger(n) && n >= 0 && n < 4;
    });
  } catch (e) {
  }
  function yuzuUnlocked(i) {
    return i === 0 || yuzuProgress.completed.indexOf(i - 1) >= 0;
  }
  function yuzuLevelEvent() {
    window.dispatchEvent(new CustomEvent("yuzu-levels", { detail: yuzuLevelStatus() }));
  }
  function yuzuLevelStatus() {
    return { chapters: yuzuChapters.map(function(c, i) {
      return Object.assign({ id: i, unlocked: yuzuUnlocked(i), completed: yuzuProgress.completed.indexOf(i) >= 0 }, c);
    }), run: Object.assign({}, yuzuRun), maxLevel: yuzuRun.chapter < 0 ? G.maxLv : yuzuRun.highest, playing: !!G.started && !menuOpen };
  }
  var yuzuLevelRaw = { start: startGame, boot: applyBoot, step: applyStep, finish: finishChain, interval: feedInterval, home: openMenu, feed };
  feed = function() {
    if (yuzuLevelPaused || yuzuRun.done || yuzuRun.loading) return;
    return yuzuLevelRaw.feed.apply(this, arguments);
  };
  function yuzuCheckChapter() {
    if (yuzuLevelPaused || yuzuRun.chapter < 0 || yuzuRun.done || yuzuRun.loading || menuOpen || !G.started || G.locked || CH || anim.active || HOLE.on || BURST.on || RESTARTING) return;
    var c = yuzuChapters[yuzuRun.chapter];
    if (yuzuRun.highest < c.level || yuzuRun.merges < c.merges) return;
    yuzuRun.done = true;
    G.over = true;
    cottonCancelDrag();
    musicStop(true);
    if (yuzuProgress.completed.indexOf(yuzuRun.chapter) < 0) yuzuProgress.completed.push(yuzuRun.chapter);
    try {
      localStorage.setItem("yuzu-chapters36", JSON.stringify(yuzuProgress));
    } catch (e) {
    }
    yuzuLevelEvent();
    window.dispatchEvent(new Event("yuzu-level-win"));
  }
  applyStep = function(s) {
    var r = yuzuLevelRaw.step.apply(this, arguments);
    if (s && s.type === "well" && yuzuRun.chapter >= 0 && !yuzuRun.done) {
      yuzuRun.merges++;
      yuzuRun.highest = Math.max(yuzuRun.highest, s.lv);
      yuzuLevelEvent();
    }
    return r;
  };
  finishChain = function() {
    var r = yuzuLevelRaw.finish.apply(this, arguments);
    yuzuCheckChapter();
    return r;
  };
  applyBoot = function() {
    yuzuRun.merges = 0;
    yuzuRun.highest = 1;
    yuzuRun.done = false;
    var r = yuzuLevelRaw.boot.apply(this, arguments);
    yuzuLevelEvent();
    return r;
  };
  feedInterval = function() {
    var ms = yuzuLevelRaw.interval.apply(this, arguments);
    return yuzuRun.chapter < 0 ? ms : Math.round(ms * yuzuChapters[yuzuRun.chapter].pace);
  };
  startGame = function() {
    if (window.COTTON_QA || /[?&]stagepreview=/.test(location.search)) return yuzuLevelRaw.start.apply(this, arguments);
    window.dispatchEvent(new Event("yuzu-level-open"));
  };
  function yuzuStartChapter(id) {
    if (yuzuRun.loading || !Number.isInteger(id) || id < -1 || id >= 4 || id >= 0 && !yuzuUnlocked(id)) return false;
    yuzuRun.loading = true;
    yuzuLevelEvent();
    function launch() {
      if (G.locked || CH || anim.active || HOLE.on || BURST.on || RESTARTING) {
        setTimeout(launch, 80);
        return;
      }
      musicStop();
      yuzuRun.chapter = id;
      yuzuRun.merges = 0;
      yuzuRun.done = false;
      applyBoot(instantBoot(id < 0 ? parseSeed() : yuzuChapters[id].seed));
      yuzuRun.loading = false;
      yuzuLevelPaused = false;
      if (id >= 0 && window.CottonStage) CottonStage.setTheme(yuzuChapters[id].theme);
      menuOpen = true;
      yuzuLevelRaw.start();
      yuzuLevelEvent();
      window.dispatchEvent(new Event("yuzu-level-started"));
    }
    launch();
    return true;
  }
  function yuzuResumeChapter() {
    if (!G.started || yuzuRun.done || yuzuRun.loading) return false;
    yuzuLevelPaused = false;
    yuzuLevelRaw.start();
    yuzuLevelEvent();
    window.dispatchEvent(new Event("yuzu-level-started"));
    return true;
  }
  window.addEventListener("yuzu-level-pause", function() {
    yuzuLevelPaused = true;
  });
  window.addEventListener("yuzu-level-unpause", function() {
    yuzuLevelPaused = false;
  });
  window.YuzuLevels = Object.freeze({ status: yuzuLevelStatus, start: yuzuStartChapter, resume: yuzuResumeChapter, check: yuzuCheckChapter });
  setInterval(yuzuCheckChapter, 180);
  (function() {
    var copy = {
      r: function() {
        return "吸附圈再大半格，远一点的方块也够得到。现在是 R" + fmtR(wellRadius()) + "。";
      },
      g: function() {
        return "每次合成再多升1级，更快攒出大方块。现在4颗能升" + wellGain(4) + "级。";
      },
      c: function() {
        return "一次能再多合1颗，连起来更痛快。现在最多能合" + wellCap() + "颗。";
      },
      s: function() {
        return "合成得分再加35%，同一局里还能继续叠加。";
      },
      m: function() {
        var n = msThreshold();
        return "连击奖励更容易拿到！现在合" + n.join("、") + "颗会给奖励。";
      },
      p: function() {
        return "脉冲充能再加30%，不用等那么久就能放一次。";
      },
      k: function() {
        return "再多15%的机会，让合成结果额外升1级。现在有" + Math.round((G.crit || 0) * 100) + "%的机会。";
      },
      b: function() {
        return "一次合4颗或更多，每颗再多拿25分。";
      },
      f: function() {
        return "每次投料少等20%的时间。现在每" + (feedInterval() / 1e3).toFixed(2) + "秒出一颗。";
      },
      q: function() {
        return "每次合成再多攒2点能量，升级也能快一点。";
      },
      e: function() {
        return "一口气合12颗或更多，脉冲就直接攒满！";
      },
      h: function() {
        return "黑块会变成黑洞，出现几率是5%。在旁边合一次，就能吸走全场四分之一的方块。";
      }
    };
    var paths = { r: "M16 4a12 12 0 1 0 12 12M16 9a7 7 0 1 0 7 7M21 5h7m-3-3v7", g: "m8 17 8-8 8 8M8 25l8-8 8 8", c: "M5 5h8v8H5Zm14 0h8v8h-8ZM5 19h8v8H5Zm14 4h8m-4-4v8", s: "m16 4 4 8 9 1-6 6 1 9-8-4-8 4 1-9-6-6 9-1Z", m: "M13 21l-3 3a5 5 0 0 1-7-7l6-6a5 5 0 0 1 7 0m3 0 3-3a5 5 0 0 1 7 7l-6 6a5 5 0 0 1-7 0m-6-5 12-6", p: "m18 3-11 15h8l-1 11 11-16h-8Z", k: "m16 3 3 9 10 4-10 3-3 10-4-10-9-3 9-4Z", b: "M6 23c5 2 7-1 10-6m-8-3 8 3 2 7M16 17c2-7 6-10 11-11 0 7-4 12-11 11Z", f: "M5 10h10M3 16h9M5 22h10m4-15 9 9-9 9", q: "M9 6c0 7-5 10-5 15a6 6 0 0 0 12 0c0-5-7-8-7-15Zm15-3c0 5-4 7-4 11a4 4 0 0 0 8 0c0-4-4-6-4-11Z", e: "M4 16c4-10 8-10 12 0s8 10 12 0M4 16c4 10 8 10 12 0s8-10 12 0", h: "M8 8c10-7 22 1 19 11-2 8-13 11-18 5-4-5-1-11 4-12 5-1 9 5 5 8-2 2-5 0-4-2" };
    var english = { r: () => "Reach another half-cell farther. Current range: R" + fmtR(wellRadius()) + ".", g: () => "Every merge gains 1 extra level. Four tiles currently gain " + wellGain(4) + " levels.", c: () => "Merge 1 more tile at a time. Current limit: " + wellCap() + ".", s: () => "Add another 35% to merge scores. You can stack this bonus.", m: () => "Get combo rewards sooner! Current rewards start at " + msThreshold().join(", ") + " tiles.", p: () => "Add 30% more pulse charge and use it sooner.", k: () => "Add a 15% chance to gain 1 extra level. Current chance: " + Math.round((G.crit || 0) * 100) + "%.", b: () => "Merge at least 4 tiles to earn another 25 points per tile.", f: () => "Wait 20% less between feeds. Currently one every " + (feedInterval() / 1e3).toFixed(2) + " seconds.", q: () => "Gain 2 extra energy per merge and level up sooner.", e: () => "Merge at least 12 tiles to fill your pulse instantly!", h: () => "Black tiles become black holes, with a 5% spawn chance. Merge nearby to pull in a quarter of the board." };
    for (var def of UP_DEFS) if (copy[def.id]) def.desc = /* @__PURE__ */ (function(id) {
      return function() {
        var _a;
        return ((_a = window.CottonI18n) == null ? void 0 : _a.getLanguage()) === "en" ? english[id]() : copy[id]();
      };
    })(def.id);
    var panel = $("up"), box = panel.querySelector(".box"), heading = document.createElement("header"), tag = document.createElement("span"), close = document.createElement("button");
    heading.className = "upgrade-heading";
    tag.id = "upgradeLevel";
    tag.className = "upgrade-level";
    tag.textContent = "Lv0";
    close.type = "button";
    close.className = "upgrade-close";
    close.setAttribute("aria-label", "稍后再选升级");
    close.textContent = "×";
    close.onclick = function() {
      closeUpPanel();
      $("bLv").focus({ preventScroll: true });
    };
    var titles = document.createElement("div");
    titles.append($("upT"), $("upS"));
    heading.append(titles, tag, close);
    box.prepend(heading);
    panel.setAttribute("role", "dialog");
    panel.setAttribute("aria-modal", "true");
    panel.setAttribute("aria-labelledby", "upT");
    $("upHint").textContent = "不急，关掉也会帮你留着这次机会。";
    var rawFill = fillUpBtn;
    fillUpBtn = function(btn, def2) {
      rawFill(btn, def2);
      btn.classList.add("upgrade-choice");
      btn.dataset.upgrade = def2.id;
      var icon = btn.querySelector(".upgrade-icon");
      if (!icon) {
        icon = document.createElement("span");
        icon.className = "upgrade-icon";
        icon.setAttribute("aria-hidden", "true");
        btn.append(icon);
      }
      icon.innerHTML = '<svg viewBox="0 0 32 32" aria-hidden="true"><path d="' + paths[def2.id] + '"/></svg>';
    };
    var rawOpen = openUpPanel;
    openUpPanel = function() {
      var result = rawOpen.apply(this, arguments);
      if (panel.classList.contains("on")) {
        $("upT").textContent = "升级啦";
        $("upS").textContent = "挑一个喜欢的，这局都管用。";
        tag.textContent = "Lv" + G.resoLv;
        var first = box.querySelector('button.upgrade-choice:not([style*="hidden"])');
        first == null ? void 0 : first.focus({ preventScroll: true });
      }
      return result;
    };
    if (window.COTTON_QA) window.CottonUpgradeQA = { open: function(ids) {
      G.pendingUps = Math.max(1, G.pendingUps);
      G.locked = false;
      openUpPanel();
      if (ids) ids.forEach(function(id, n) {
        var def2 = UP_DEFS.find(function(d) {
          return d.id === id;
        });
        if (def2) fillUpBtn($(["bUpA", "bUpB", "bUpC"][n]), def2);
      });
    }, close: closeUpPanel, status: function() {
      return { pending: G.pendingUps, locked: G.locked, score: G.score, taken: __spreadValues({}, G.upTaken), radius: G.upRadius, definitions: UP_DEFS.map(function(d) {
        return { id: d.id, max: d.max, name: d.name, desc: typeof d.desc === "function" ? d.desc() : d.desc };
      }) };
    } };
  })();
  boot();
})();
