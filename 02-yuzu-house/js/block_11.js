(function() {
  "use strict";
  const $ = (id) => document.getElementById(id), modal = document.createElement("div");
  modal.id = "howToDiagram";
  modal.hidden = true;
  modal.innerHTML = '<section class="howto-card" role="dialog" aria-modal="true" aria-labelledby="howToTitle"><header><span>小小玩法书</span><button id="howToClose" aria-label="关闭玩法图解" type="button">×</button></header><p id="howToCount"></p><h2 id="howToTitle"></h2><div id="howToArt" class="howto-art" aria-hidden="true"></div><p id="howToText"></p><div class="howto-dots" aria-label="图解步骤"></div><footer><button id="howToBack" type="button">上一步</button><button id="howToNext" type="button">下一步</button></footer></section>';
  document.body.append(modal);
  const steps = [["拖到同级，松手合成", "把甜品拖到同级甜品上，再松开手。", () => '<div class="howto-track"><i class="howto-sweet drag-from">' + CottonTileArt[0].svg + '</i><span class="howto-arrow">→</span><i class="howto-sweet">' + CottonTileArt[0].svg + '</i><span class="howto-finger">↗</span></div>'], ["范围里的，也一起合", "松手前看看圈内：同级甜品越多，合成越厉害。", () => '<div class="howto-range">' + [0, 1, 0, 0, 0, 2, 2, 0, 1].map((n, i) => '<i class="howto-mini ' + (n === 0 ? "matching" : "") + '">' + CottonTileArt[n].svg + "</i>").join("") + '<span class="howto-ring"></span></div>'], ["连锁与升级", "新甜品继续遇到同级，就能连锁。等级按钮亮起时，点它选增益。", () => '<div class="howto-chain"><i class="howto-sweet">' + CottonTileArt[1].svg + '</i><b>＋</b><i class="howto-sweet">' + CottonTileArt[1].svg + '</i><b>→</b><i class="howto-sweet result">' + CottonTileArt[2].svg + '</i></div><div class="howto-upgrade">等级 ↑ <span>选择增益</span></div>']];
  let page = 0, returnFocus = null;
  function paint() {
    const s = steps[page];
    $("howToCount").textContent = "0" + (page + 1) + " / 03";
    $("howToTitle").textContent = s[0];
    $("howToText").textContent = s[1];
    $("howToArt").innerHTML = s[2]();
    $("howToBack").disabled = page === 0;
    $("howToNext").textContent = page === 2 ? "知道啦" : "下一步";
    modal.querySelector(".howto-dots").innerHTML = steps.map((_, i) => '<button type="button" aria-label="第' + (i + 1) + '步" aria-current="' + (i === page ? "step" : "false") + '" data-page="' + i + '"></button>').join("");
  }
  function close() {
    modal.hidden = true;
    returnFocus == null ? void 0 : returnFocus.focus();
  }
  function show() {
    page = 0;
    returnFocus = document.activeElement;
    window.dispatchEvent(new CustomEvent("cotton-speech", { detail: { text: "", duration: 0 } }));
    paint();
    modal.hidden = false;
    $("howToClose").focus();
  }
  $("howToClose").onclick = close;
  $("howToBack").onclick = () => {
    page = Math.max(0, page - 1);
    paint();
  };
  $("howToNext").onclick = () => {
    if (page === 2) close();
    else {
      page++;
      paint();
    }
  };
  modal.querySelector(".howto-dots").onclick = (e) => {
    const b = e.target.closest("[data-page]");
    if (b) {
      page = Number(b.dataset.page);
      paint();
    }
  };
  modal.addEventListener("keydown", (e) => {
    if (e.key === "Escape") {
      e.preventDefault();
      close();
    }
    if (e.key === "Tab") {
      const focus = [...modal.querySelectorAll("button:not(:disabled)")], first = focus[0], last = focus[focus.length - 1];
      if (e.shiftKey && document.activeElement === first) {
        e.preventDefault();
        last.focus();
      } else if (!e.shiftKey && document.activeElement === last) {
        e.preventDefault();
        first.focus();
      }
    }
  });
  window.addEventListener("cotton-howto", show);
  window.CottonHowTo = Object.freeze({ show, getStatus: () => ({ open: !modal.hidden, page, steps: steps.length, kind: "illustrated" }) });
})();
