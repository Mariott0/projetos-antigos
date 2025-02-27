document.getElementById('appointment-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const notes = document.getElementById('notes').value;

    if (name && email && phone && date && time) {
        const appointment = { name, email, phone, date, time, notes };

        // Recupera os agendamentos do localStorage
        let appointments = JSON.parse(localStorage.getItem('appointments')) || [];
        appointments.push(appointment);

        // Salva os agendamentos atualizados no localStorage
        localStorage.setItem('appointments', JSON.stringify(appointments));

        alert('Agendamento realizado com sucesso!');

        // Limpa o formulário
        document.getElementById('appointment-form').reset();
    } else {
        alert('Por favor, preencha todos os campos obrigatórios.');
    }
});

// Função para carregar os agendamentos e exibi-los na tabela
function loadAppointments() {
    const appointmentsList = document.getElementById('appointments-list');
    let appointments = JSON.parse(localStorage.getItem('appointments')) || [];

    appointments.forEach(appointment => {
        let row = document.createElement('tr');

        row.innerHTML = `
            <td>${appointment.name}</td>
            <td>${appointment.email}</td>
            <td>${appointment.phone}</td>
            <td>${appointment.date}</td>
            <td>${appointment.time}</td>
            <td>${appointment.notes}</td>
        `;

        appointmentsList.appendChild(row);
    });
}

// Chama a função para carregar os agendamentos ao carregar a página agendamentos.html
if (document.getElementById('appointments-list')) {
    loadAppointments();
}

// Função para imprimir a tabela de agendamentos
function printAppointments() {
    window.print();
}

// Adiciona evento ao botão de impressão
if (document.getElementById('print-button')) {
    document.getElementById('print-button').addEventListener('click', printAppointments);
}
