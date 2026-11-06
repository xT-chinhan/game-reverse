(function() {
  "use strict";
  const $ = (id) => document.getElementById(id), overlay = document.createElement("section");
  overlay.id = "chapterOverlay";
  overlay.hidden = true;
  overlay.setAttribute("role", "dialog");
  overlay.setAttribute("aria-modal", "true");
  overlay.setAttribute("aria-label", "小小关卡");
  overlay.innerHTML = '<div class="chapter-panel"><header><div><small>YUZU / LITTLE CHAPTERS</small><h2 id="chapterTitle">小小关卡</h2></div><button id="chapterClose" aria-label="关闭选关">×</button></header><p id="chapterIntro">四段小演出，不限时，慢慢合也没关系。</p><div id="chapterList"></div><div class="chapter-tools"><button id="chapterResume" hidden>继续这次演出</button><button id="chapterFree">自由合成</button></div><p class="chapter-save">通关会自动记住，下次接着挑战。</p></div>';
  document.body.append(overlay);
  const goal = document.createElement("button");
  goal.id = "chapterGoal";
  goal.type = "button";
  goal.hidden = true;
  goal.setAttribute("aria-label", "查看关卡目标");
  $("route").insertAdjacentElement("afterend", goal);
  function transition(fn) {
    if (window.CottonTransitions) CottonTransitions.run("chapters", fn);
    else fn();
  }
  function open() {
    window.dispatchEvent(new Event("yuzu-level-pause"));
    render();
    transition(() => {
      overlay.hidden = false;
      $("chapterClose").focus();
    });
  }
  function close() {
    window.dispatchEvent(new Event("yuzu-level-unpause"));
    transition(() => {
      overlay.hidden = true;
      if (document.body.classList.contains("in-home")) $("bStart").focus();
      else goal.focus();
    });
  }
  function render() {
    const s = YuzuLevels.status(), r = s.run;
    $("chapterTitle").textContent = "小小关卡";
    $("chapterIntro").textContent = r.loading ? "正在准备舞台…" : "四段小演出，不限时，慢慢合也没关系。";
    $("chapterList").replaceChildren();
    for (const c of s.chapters) {
      const b = document.createElement("button");
      b.className = "chapter-card";
      b.disabled = !c.unlocked || r.loading;
      b.dataset.chapter = String(c.id);
      b.innerHTML = '<span class="chapter-number">' + String(c.id + 1).padStart(2, "0") + '</span><span class="chapter-copy"><b>' + c.name + "</b><small>合出 " + c.level + " 级 · 完成 " + c.merges + ' 次合成</small></span><span class="chapter-state">' + (c.completed ? "✓" : c.unlocked ? "→" : "未解锁") + "</span>";
      b.onclick = () => {
        YuzuLevels.start(c.id);
      };
      $("chapterList").append(b);
    }
    $("chapterFree").disabled = r.loading;
    $("chapterResume").hidden = !s.playing && !document.body.classList.contains("in-home") || !s.run || r.done || r.loading || !document.body.dataset.yuzuHasRun;
    $("chapterResume").textContent = r.chapter >= 0 ? "继续第 " + (r.chapter + 1) + " 关" : "继续自由合成";
    goal.hidden = r.chapter < 0;
    goal.textContent = r.chapter >= 0 ? "第 " + (r.chapter + 1) + " 关 · " + s.chapters[r.chapter].name + "　" + Math.min(s.maxLevel, s.chapters[r.chapter].level) + "/" + s.chapters[r.chapter].level + " 级 · " + Math.min(r.merges, s.chapters[r.chapter].merges) + "/" + s.chapters[r.chapter].merges + " 次" : "";
    goal.disabled = r.done;
  }
  const win = document.createElement("section");
  win.id = "chapterWin";
  win.hidden = true;
  win.setAttribute("role", "dialog");
  win.setAttribute("aria-modal", "true");
  win.setAttribute("aria-label", "关卡完成");
  win.innerHTML = '<div class="chapter-panel chapter-win-panel"><div class="chapter-confetti" aria-hidden="true">✦　●　✧</div><small>LOVELY LITTLE PERFORMANCE</small><h2 id="chapterWinTitle">演出完成！</h2><p id="chapterWinText"></p><div class="chapter-win-actions"><button id="chapterNext">下一关 →</button><button id="chapterReplay">再演一次</button><button id="chapterBack">回主界面</button></div></div>';
  document.body.append(win);
  function showWin() {
    overlay.hidden = true;
    const s = YuzuLevels.status(), id = s.run.chapter;
    $("chapterWinTitle").textContent = id === 3 ? "四场演出，全部完成！" : "第 " + (id + 1) + " 关完成！";
    $("chapterWinText").textContent = s.chapters[id].name + " · " + s.run.merges + " 次合成，合出 " + s.maxLevel + " 级";
    $("chapterNext").textContent = id === 3 ? "去自由合成 →" : "下一关 →";
    transition(() => {
      win.hidden = false;
      $("chapterNext").focus();
    });
    if (window.CottonStage) CottonStage.preview();
  }
  $("chapterNext").onclick = () => YuzuLevels.start(YuzuLevels.status().run.chapter === 3 ? -1 : YuzuLevels.status().run.chapter + 1);
  $("chapterReplay").onclick = () => YuzuLevels.start(YuzuLevels.status().run.chapter);
  $("chapterBack").onclick = () => {
    transition(() => {
      win.hidden = true;
      CottonGame.home();
    });
  };
  $("chapterClose").onclick = close;
  goal.onclick = open;
  $("chapterFree").onclick = () => YuzuLevels.start(-1);
  $("chapterResume").onclick = () => YuzuLevels.resume();
  overlay.addEventListener("click", (e) => {
    if (e.target === overlay) close();
  });
  document.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && !overlay.hidden) {
      e.preventDefault();
      close();
    }
    if (e.key === "Tab" && (!overlay.hidden || !win.hidden)) {
      const root = win.hidden ? overlay : win, items = [...root.querySelectorAll("button:not(:disabled)")].filter((b) => !b.hidden), first = items[0], last = items.at(-1);
      if (e.shiftKey && document.activeElement === first) {
        e.preventDefault();
        last.focus();
      } else if (!e.shiftKey && document.activeElement === last) {
        e.preventDefault();
        first.focus();
      }
    }
  });
  window.addEventListener("yuzu-level-open", open);
  window.addEventListener("yuzu-levels", render);
  window.addEventListener("yuzu-level-win", showWin);
  window.addEventListener("yuzu-level-started", () => {
    document.body.dataset.yuzuHasRun = "1";
    transition(() => {
      overlay.hidden = true;
      win.hidden = true;
    });
    render();
  });
  render();
})();
