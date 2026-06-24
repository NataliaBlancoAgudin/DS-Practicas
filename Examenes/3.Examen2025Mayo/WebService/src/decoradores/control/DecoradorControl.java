package decoradores.control;

import paginas.PaginaStrategy;

public abstract class DecoradorControl implements PaginaStrategy {

    protected PaginaStrategy paginaValida;
    protected PaginaStrategy paginaError;

    public DecoradorControl(PaginaStrategy pagina, PaginaStrategy paginaError) {
        this.paginaValida = pagina;
        this.paginaError = paginaError;
    }

    @Override
    public String getTitle() {
        return paginaValida.getTitle();
    }
}
