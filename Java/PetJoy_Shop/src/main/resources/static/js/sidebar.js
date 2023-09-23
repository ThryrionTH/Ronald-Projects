const currentUrl = window.location.pathname;

const menuItems = document.querySelectorAll('.sidebar-options li');

menuItems.forEach((menuItem) => {
    const link = menuItem.querySelector('a');
    const href = link.getAttribute('href');

    // Compara la URL actual con la URL del enlace del menú
    if (currentUrl === href) {
        menuItem.classList.add('active');
    }
});