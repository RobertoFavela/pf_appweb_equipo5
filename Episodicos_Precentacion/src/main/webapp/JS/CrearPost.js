document.getElementById('form-reseña').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    try {
        const response = await fetch('ResenaController', {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            const result = await response.text(); 
            alert('Reseña guardada con éxito');
            console.log(result);
        } else {
            alert('Hubo un error al guardar la reseña.');
            console.error('Error:', response.statusText);
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Hubo un error al comunicarse con el servidor.');
    }
});

