function carregarTarefas() {
    $.ajax({
        url: '/tarefa/',
        type: 'GET',
        success: function (tarefas) {
            let lista = '';
            tarefas.forEach(tarefa => {
                lista += `<li class="list-group-item">
    <strong>${tarefa.nome}</strong><br>
    <small>${tarefa.descricao}</small>
    </li>`;
            });
            $('#listaTarefas').html(lista);
        }
    });
}

$(document).ready(function () {
    carregarTarefas();
});