import Almacen.Articulo;
import Servicio.ArticuloService;

public class Main {
    public static void main(String[] args) {

        ArticuloService articuloService = new ArticuloService();
        articuloService.menu();
    }
}