document.getElementById('formulario-registro').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const data = new URLSearchParams(formData);

    try {
        const response = await fetch('RegisterController', {
            method: 'POST',
            body: data,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });

        if (response.ok) {
            const result = await response.json();
            alert(result.message);
            window.location.href = 'LogInView.jsp'; // Redirige al login después del registro exitoso
        } else {
            const error = await response.json();
            alert(error.error);
        }
    } catch (error) {
        console.error('Error en el registro:', error.message);
        alert('Error al conectar con el servidor.');
    }
});


