
document.addEventListener('DOMContentLoaded', () => {
    const botonesEliminar = document.querySelectorAll('.eliminar-post');

    botonesEliminar.forEach(boton => {
        boton.addEventListener('click', () => {
            const postId = boton.getAttribute('data-id');

            if (confirm('¿Estás seguro de que deseas eliminar este post?')) {
                fetch(`Postcontroller`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: `accion=eliminar&id=${postId}`
                })
                        .then(response => response.json())
                        .then(data => {
                            if (data.success) {
                                alert('Post eliminado correctamente');
                                boton.closest('.resena').remove(); // Elimina el post del DOM
                            } else {
                                alert('Error al eliminar el post');
                            }
                        })
                        .catch(error => console.error('Error:', error));
            }
        });
    });
});


