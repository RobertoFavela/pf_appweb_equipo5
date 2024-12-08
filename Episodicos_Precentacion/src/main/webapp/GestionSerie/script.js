document.addEventListener("DOMContentLoaded", () => {
    const btnAdd = document.getElementById("btn-agregar");
    const btnModify = document.getElementById("btn-mod");
    const btnDelete = document.getElementById("btn-ele");
    const extraFields = document.getElementById("extras");
    const form = document.getElementById("form-serie");
    const titulo = document.getElementById("titulo");

    btnAdd.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "GestionSerieController";
        form.querySelector('input[name="accion"]').value = "agregar";
        titulo.querySelector('h2[name="titulo"]').textContent  = "Agregar Serie";
        extraFields.style.display = "block";
    });

    btnModify.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "GestionSerieController";
        form.querySelector('input[name="accion"]').value = "modificar";
        titulo.querySelector('h2[name="titulo"]').textContent  = "Modificar Serie";
        extraFields.style.display = "block";
    });

    btnDelete.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "GestionSerieController";
        form.querySelector('input[name="accion"]').value = "eliminar";
        titulo.querySelector('h2[name="titulo"]').textContent  = "Eliminar Serie";
        extraFields.style.display = "none";
    });
});
