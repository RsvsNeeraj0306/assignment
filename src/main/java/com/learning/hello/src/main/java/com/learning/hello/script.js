document.getElementById("guessForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the default form submission

    var formData = new FormData(document.getElementById("guessForm"));
    var userInput = formData.get("guess");

    var url = "GuessServlet?guess=" + userInput;

    fetch(url)
        .then(response => response.text())
        .then(message => {
            document.getElementById("message").textContent = message;
        });
});

