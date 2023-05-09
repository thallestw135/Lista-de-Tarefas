const checkboxes = document.querySelectorAll('input[type="checkbox"]');
checkboxes.forEach(checkbox => {
  checkbox.addEventListener('change', event => {
    const taskText = event.target.parentElement.nextElementSibling;
    if (event.target.checked) {
      taskText.classList.add('strikethrough');
    } else {
      taskText.classList.remove('strikethrough');
    }
  });
});


const deleteAllButton = document.querySelector('#delete-all-button');
const confirmationDialog = document.querySelector('#confirmation-dialog');
const yesButton = document.querySelector('#yes-button');
const noButton = document.querySelector('#no-button');

deleteAllButton.addEventListener('click', event => {
  event.preventDefault();
  confirmationDialog.style.display = 'block';
});

yesButton.addEventListener('click', () => {
  confirmationDialog.style.display = 'none';
  fetch('/tasks/delete', { method: 'DELETE' })
    .then(response => {
      if (response.ok) {
        // Recarregue a página após excluir todas as tarefas
        window.location.reload();
      } else {
        // Mostre uma mensagem de erro ao usuário
        alert('Houve um erro ao tentar apagar todas as tarefas, tente novamente.');
      }
    });
});

noButton.addEventListener('click', () => {
  confirmationDialog.style.display = 'none';
});



const deleteButtons = document.querySelectorAll('.delete-button');
deleteButtons.forEach(deleteButton => {
  deleteButton.addEventListener('click', event => {
    event.preventDefault();
    const taskId = event.target.dataset.id;
    fetch(`/tasks/delete/${taskId}`, { method: 'DELETE' })
      .then(response => {
        if (response.ok) {
          // Recarregue a página após excluir a tarefa
          window.location.reload();
        } else {
          // Mostre uma mensagem de erro ao usuário
          alert('Houve um erro ao tentar apagar a tarefa, tente novamente.');
        }
      });
  });
});