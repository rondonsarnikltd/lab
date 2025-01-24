function toggleMenu() {
    let menu = document.getElementById('menu-tl');
    if (menu.classList.contains('hidden')) {
        menu.classList.remove('hidden');
    } else {
        menu.classList.add('hidden');
    }
}