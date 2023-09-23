document.addEventListener('DOMContentLoaded', function() {
    const logoutButton = document.querySelector('.btn-logout a');
    
    logoutButton.addEventListener('click', function(event) {
        event.preventDefault();

        Swal.fire({
            title: '¿Estás seguro de que deseas cerrar sesión?',
            text: 'Serás redirigido a la página de inicio',
            // icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#86EB9A',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, cerrar sesión',
            cancelButtonText: 'Cancelar',
            background: '#202123',
            color: '#fff',
            customClass: {
                confirmButton: 'text-dark' 
            }
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = '/logout';
            }
        });
    });
});
