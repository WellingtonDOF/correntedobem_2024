document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('funcionarioForm');
    const funcionariosTable = document.getElementById('funcionariosTable').getElementsByTagName('tbody')[0];

    // Function to fetch all employees and populate the table
    function fetchFuncionarios() {
        fetch('http://localhost:8080/apis/funcionarios')
            .then(response => response.json())
            .then(data => {
                funcionariosTable.innerHTML = '';
                data.forEach(funcionario => {
                    const row = funcionariosTable.insertRow();
                    row.innerHTML = `
                        <td>${funcionario.idFuncionario}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.telefone}</td>
                        <td>${funcionario.email}</td>
                        <td>
                            <button onclick="viewFuncionario(${funcionario.idFuncionario})">Ver</button>
                            <button onclick="editFuncionario(${funcionario.idFuncionario})">Editar</button>
                            <button onclick="deleteFuncionario(${funcionario.idFuncionario})">Deletar</button>
                        </td>
                    `;
                });
            })
            .catch(error => console.error('Erro ao buscar funcionários:', error));
    }

    // Function to add or update employee
    form.addEventListener('submit', event => {
        event.preventDefault();
        const formData = new FormData(form);
        const idFuncionario = formData.get('idFuncionario');
        const method = idFuncionario ? 'PUT' : 'POST';
        const url = `http://localhost:8080/apis/funcionarios${idFuncionario ? `/${idFuncionario}` : ''}`;

        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(Object.fromEntries(formData.entries()))
        })
        .then(response => response.json())
        .then(data => {
            fetchFuncionarios();
            form.reset();
        })
        .catch(error => console.error('Erro ao salvar funcionário:', error));
    });

    // Function to delete employee
    window.deleteFuncionario = function(idFuncionario) {
        fetch(`http://localhost:8080/apis/funcionarios/${idFuncionario}`, {
            method: 'DELETE'
        })
        .then(() => fetchFuncionarios())
        .catch(error => console.error('Erro ao deletar funcionário:', error));
    }

    // Function to edit employee
    window.editFuncionario = function(idFuncionario) {
        fetch(`http://localhost:8080/apis/funcionarios/${idFuncionario}`)
            .then(response => response.json())
            .then(data => {
                for (const key in data) {
                    if (form.elements[key]) {
                        form.elements[key].value = data[key];
                    }
                }
            })
            .catch(error => console.error('Erro ao buscar funcionário:', error));
    }

    window.viewFuncionario = function(idFuncionario) {
        fetch(`http://localhost:8080/apis/funcionarios/${idFuncionario}`)
            .then(response => response.json())
            .then(data => {
                const modalContent = document.getElementById('funcionarioDetails');
                modalContent.innerHTML = `
                    <p><strong>ID:</strong> ${data.idFuncionario}</p>
                    <p><strong>Nome:</strong> ${data.nome}</p>
                    <p><strong>CPF:</strong> ${data.cpf}</p>
                    <p><strong>Telefone:</strong> ${data.telefone}</p>
                    <p><strong>Endereço:</strong> ${data.endereco}</p>
                    <p><strong>Email:</strong> ${data.email}</p>
                    <p><strong>Sexo:</strong> ${data.sexo}</p>
                    <p><strong>Estado:</strong> ${data.estado}</p>
                    <p><strong>Cidade:</strong> ${data.cidade}</p>
                    <p><strong>Bairro:</strong> ${data.bairro}</p>
                    <p><strong>CEP:</strong> ${data.cep}</p>
                    <p><strong>Data de Nascimento:</strong> ${data.dtaNascimento}</p>
                    <p><strong>Data de Admissão:</strong> ${data.dtaAdmissao}</p>
                    <p><strong>Data de Demissão:</strong> ${data.dtaDemissao}</p>
                `;
                const modal = document.getElementById('modal');
                modal.style.display = "block";
            })
            .catch(error => console.error('Erro ao buscar detalhes do funcionário:', error));

        // Obtenha uma referência para o botão de fechar
        const closeModal = document.getElementById('closeModal');

        // Adicione um event listener para o botão de fechar
        closeModal.addEventListener('click', () => {
            const modal = document.getElementById('modal');
            modal.style.display = "none";
        });
    }
    
    // Initial fetch of employees
    fetchFuncionarios();
});
