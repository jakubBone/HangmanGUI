public class Gibbet {
    public static String[][] gibbet = new String[9][18];
    public static int gibbetElementsCounter = 0;
    public void createEmptyGibbet() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 18; j++) {
                gibbet[i][j] = " ";
            }
        }
    }

    public static void buildAndPrintGibbet(){
        Gibbet.buildGibbet();
        Gibbet.printGibbet();
        System.out.println("-----------------");
    }

    public static void printGibbet(){
        for(int i = 0; i < 9 ; i++){
            System.out.println();
            for (int j = 0; j < 18; j++) {
                System.out.print(gibbet[i][j]);
            }
        }
        System.out.println();
    }

    public static void buildGibbet() {

        switch (gibbetElementsCounter) {
            case 0:
                gibbet[8][0] = "/";
                break;
            case 1:
                gibbet[8][2] = "\\";
                break;
            case 2:
                for (int i = 1; i < 8; i++) {
                    gibbet[i][1] = "|";
                }
                break;
            case 3:
                for (int i = 1; i < 17; i++) {
                    gibbet[0][i] = "_";
                }
                break;
            case 4:
                gibbet[1][2] = "/";
                break;
            case 5:
                gibbet[1][16] = "|";
                gibbet[2][16] = "|";
                break;
            case 6:
                gibbet[3][16] = "0";
                break;
            case 7:
                gibbet[4][16] = "|";
                gibbet[5][16] = "|";
                break;
            case 8:
                gibbet[4][15] = "/";
                break;
            case 9:
                gibbet[4][17] = "\\";
                break;
            case 10:
                gibbet[6][15] = "/";
                break;
            case 11:
                gibbet[6][17] = "\\";
                break;
        }
    }
}
