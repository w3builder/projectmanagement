<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">GESTÃO DE PROJETOS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Início</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/projects/new">Novo</a>
                </li>		
            </ul>
            <form action="/projects/search" class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Buscar por nome" aria-label="Buscar por nome" name="name">
                <button class="btn btn-outline-success" type="submit">Buscar</button>
            </form>
        </div>
    </div>
</nav>