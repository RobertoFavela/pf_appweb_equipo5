// Referencias a los elementos
const contenedor = document.getElementById('contenedor');
const panelLogo = document.getElementById('panel-logo');
const panelFormulario = document.querySelector('.panel-formulario');
const formularioInicio = document.getElementById('formulario-inicio');
const formularioRegistro = document.getElementById('formulario-registro');

// Mostrar el formulario de registro y mover el logo a la derecha
document.getElementById('mostrar-registro').addEventListener('click', () => {
    panelLogo.classList.add('mover-derecha');
    panelFormulario.classList.add('mover-izquierda');
    formularioInicio.classList.remove('activo');
    formularioRegistro.classList.add('activo');
});

// Mostrar el formulario de inicio de sesión y devolver el logo a la izquierda
document.getElementById('mostrar-inicio').addEventListener('click', () => {
    panelLogo.classList.remove('mover-derecha');
    panelFormulario.classList.remove('mover-izquierda');
    formularioRegistro.classList.remove('activo');
    formularioInicio.classList.add('activo');
});
