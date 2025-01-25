function toggleMobileMenu() {
    let mnu= {
        btn: document.getElementById('mobile-menu'),
        ishidden: () => { return mnu.btn.classList.contains('hidden'); },
        show: () => { mnu.btn.classList.remove('hidden'); },
        hide: () => { mnu.btn.classList.add('hidden'); }
    }
    let mbo = { 
        btn: document.getElementById('svg-openmenu'),
        show: () => {
            mbo.btn.classList.remove('hidden');
            mbo.btn.classList.add('block'); },
        hide: () => { 
            mbo.btn.classList.remove('block');
            mbo.btn.classList.add('hidden');
        }
    };
    let mbc = { 
        btn: document.getElementById('svg-closemenu'),
        show: () => {
            mbc.btn.classList.remove('hidden');
            mbc.btn.classList.add('block'); },
        hide: () => { 
            mbc.btn.classList.remove('block');
            mbc.btn.classList.add('hidden');
        }
    }
    if (mnu.ishidden()) {
        mnu.show();
        mbo.hide();
        mbc.show();
    } else {
        mnu.hide();
        mbc.hide();
        mbo.show();
    }
}

function toggleMenu(delay) {
    let mnu= {
        btn: document.getElementById('menu-tl'),
        ishidden: () => { return mnu.btn.classList.contains('hidden'); },
        show: () => { mnu.btn.classList.remove('hidden'); },
        hide: () => { mnu.btn.classList.add('hidden'); }
    }
    if(delay) {
        setTimeout(() => {
            if (mnu.ishidden()) mnu.show();
            else mnu.hide();
        }, 180);
    } else {
        if (mnu.ishidden()) mnu.show();
        else mnu.hide();
    }
}