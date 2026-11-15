document.querySelector('#feedback').addEventListener('submit', event => {
    event.preventDefault();
    document.querySelector('#status').textContent = 'Учебная форма: сообщение не отправляется.';
});
