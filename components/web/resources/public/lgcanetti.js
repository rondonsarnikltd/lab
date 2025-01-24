function toggleMobileMenu() {
    let menu = document.getElementById('mobile-menu');
    let svgomm = document.getElementById('svg-openmenu');
    let svgcmm = document.getElementById('svg-closemenu');
    if (menu.classList.contains('hidden')) {
        menu.classList.remove('hidden');
        svgomm.classList.remove('block');
        svgomm.classList.add('hidden');
        svgcmm.classList.remove('hidden');
        svgcmm.classList.add('block');
    } else {
        menu.classList.add('hidden');
        svgcmm.classList.remove('block');
        svgcmm.classList.add('hidden');
        svgomm.classList.remove('hidden');
        svgomm.classList.add('block');
    }
}

function toggleMenu() {
    let menu = document.getElementById('menu-tl');
    if (menu.classList.contains('hidden')) {
        menu.classList.remove('hidden');
    } else {
        menu.classList.add('hidden');
    }
}