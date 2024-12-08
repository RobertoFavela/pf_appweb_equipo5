document.getElementById('form-reseña').addEventListener('submit', async function (event) {
    event.preventDefault();
    const formData = new FormData(this); 
    const data = new URLSearchParams(formData);

    try {
        const response = await fetch('ResenaController', {
            method: 'POST',
            body: data,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' 
            }
        });
        if (response.ok) {
            const result = await response.json();
            alert('Reseña guardada con éxito');
            console.log(result);
        } else {
            alert('Hubo un error al guardar la reseña.');
            console.error('Error:', response.statusText);
        }
    } catch (error) {
        console.error('Error:', error);
    }
});
