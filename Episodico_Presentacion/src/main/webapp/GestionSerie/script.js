document.addEventListener("DOMContentLoaded", () => {
    const btnAdd = document.getElementById("btn-agregar");
    const btnModify = document.getElementById("btn-mod");
    const btnDelete = document.getElementById("btn-ele");
    const extraFields = document.getElementById("extras");
    const form = document.getElementById("form-serie");

    btnAdd.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "/GestionSerieController?accion=agregar";
        extraFields.style.display = "block";
    });

    btnModify.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "/GestionSerieController?accion=modificar";
        extraFields.style.display = "block";
    });

    btnDelete.addEventListener("click", (e) => {
        e.preventDefault();
        form.action = "/GestionSerieController?accion=eliminar";
        extraFields.style.display = "none";
    });
});
