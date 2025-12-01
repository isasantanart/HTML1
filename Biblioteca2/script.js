function pesquisarLivro() {
    const livros = [
        "Amor, teoricamente",
        "Delilah Green não está nem aí",
        "A vida invisível de addie larue",
        "Heated rivalry",
        "Amor em roma",
        "Aprendiz do vilão",
        "O príncipe cruel",
        "Promessas cruéis",
        "Divinso rivais",
        "A rainha vermelha"

    ];

    let pesquisa = document.getElementById("campoPesquisa").value.toLowerCase();
    let resultado = document.getElementById("resultadoPesquisa");

    if (pesquisa.trim() === "") {
        resultado.innerHTML = "Digite o nome de um livro.";
        return;
    }

    let encontrado = livros.some(livro => livro.toLowerCase().includes(pesquisa));

    if (encontrado) {
        resultado.innerHTML = "✅ Livro encontrado!";
        resultado.style.color = "green";
    } else {
        resultado.innerHTML = "❌ Livro não encontrado.";
        resultado.style.color = "red";
    }
}