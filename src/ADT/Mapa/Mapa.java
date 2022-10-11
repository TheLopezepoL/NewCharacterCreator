package ADT.Mapa;

public class Mapa {

    public static final int TAMANHO_X = 10; // Cantidad Filas
    public static final int TAMANHO_Y = 10; // Cantidad Columnas
    private double[][] obstaculos;

    public Mapa(){
        this.obstaculos = new double[TAMANHO_X][TAMANHO_Y];
        for (int row = 0; row < TAMANHO_X; row++) {
            for (int column = 0; column < TAMANHO_Y; column++)
                this.obstaculos[row][column] = 0;
        }
    }

    public boolean agregarObstaculos(int x, int y, double obstaculoAlt){
        if (0 <= x && 0 <= y && x < TAMANHO_X && y < TAMANHO_Y) {
            if (this.obstaculos[x][y] != 0) {
                this.obstaculos[x][y] = obstaculoAlt;
                return true;
            }
        }
        return false;
    }

    public double verObstaculo(int x, int y){
        if (0 <= x && 0 <= y && x < TAMANHO_X && y < TAMANHO_Y)
            return this.obstaculos[x][y];
        return -1;
    }

    public boolean destruirObstaculo(int x, int y){
        if (0 <= x && 0 <= y && x < TAMANHO_X && y < TAMANHO_Y) {
            this.obstaculos[x][y] = 0;
            return true;
        }
        return false;
    }

}
