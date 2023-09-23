const carouselContainers = document.querySelectorAll('.carousel-container'); // Selecciona todos los carruseles
const carouselTracks = document.querySelectorAll('.carousel-track'); // Selecciona todas las pistas de carrusel
const images = document.querySelectorAll('.carousel-track img');

let currentIndex = 0;
const slideWidth = images[0].clientWidth;
const animationDuration = 60000; // Duplica la duración de la animación en milisegundos (60 segundos)

// Agrega eventos de pausa al hacer hover en todos los carruseles
carouselContainers.forEach((container, index) => {
    const track = carouselTracks[index];
    
    container.addEventListener('mouseover', () => {
        // Pausar la animación al hacer hover
        track.style.animationPlayState = 'paused';
        images[currentIndex].style.animationDuration = '120s'; // Duplica la duración de la imagen actual
    });

    container.addEventListener('mouseout', () => {
        // Reanudar la animación al salir del hover
        track.style.animationPlayState = 'running';
        images[currentIndex].style.animationDuration = animationDuration + 'ms'; // Restaurar la duración original de la imagen
    });
});

function nextSlide() {
    currentIndex = (currentIndex + 1) % images.length;
    updateCarousels();
}

function updateCarousels() {
    carouselTracks.forEach((track) => {
        const offset = currentIndex * -slideWidth;
        track.style.transform = `translateX(${offset}px)`;
    });
}

setInterval(nextSlide, 3000); // Cambia la imagen cada 3 segundos