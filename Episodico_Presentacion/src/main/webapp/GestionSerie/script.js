document.addEventListener("DOMContentLoaded", () => {
    const btnAdd = document.getElementById("btn-agregar");
    const btnModify = document.getElementById("btn-mod");
    const btnDelete = document.getElementById("btn-ele");
    const extraFields = document.getElementById("extras");
    const form = document.getElementById("form-serie");

    btnAdd.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "/agregarSerie";
        extraFields.style.display = "block";
    });

    btnModify.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "/modificarSerie";
        extraFields.style.display = "block";
    });

    btnDelete.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "/eliminarSerie";
        extraFields.style.display = "none";
    });
});
