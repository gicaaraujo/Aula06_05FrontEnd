function adicionarTarefa() {
    const tarefa = {
        nome: $('#nomeTarefa').val(),
        descricao: $('#descricaoTarefa').val()
    };

    $.ajax({
        url: '/tarefa/',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(tarefa),
        success: function () {
            $('#formTarefa')[0].reset(); // limpa o formulário
            carregarTarefas(); // atualiza a lista automaticamente
        }
    });
}

function carregarTarefas() {
    $.ajax({
        url: '/tarefa/',
        type: 'GET',
        success: function(tarefas) {
            let lista = '';
            tarefas.forEach(tarefa => {
                lista += `<li class="list-group-item d-flex justify-content-between align-items-start">
                    <div>
                        <strong id="nome-${tarefa.id}">${tarefa.nome}</strong><br>
                        <small id="descricao-${tarefa.id}">${tarefa.descricao}</small>
                    </div>
                    <div>
                        <button class="btn btn-sm btn-warning me-2" onclick="prepararEdicao(${tarefa.id})">Editar</button>
                        <button class="btn btn-sm btn-danger" onclick="excluirTarefa(${tarefa.id})">Excluir</button>
                    </div>
                </li>`;
            });
            $('#listaTarefas').html(lista);
        }
    });
}

function excluirTarefa(id){
	if(confirm("Tem certeza que deseja excluir esta tarefa?")) {
		$.ajax({
			url: `/tarefa/${id}`,
			type: 'DELETE',
			success: function (){
				carregarTarefas();
			}
		});
	}
}