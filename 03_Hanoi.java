class Hanoi {

    static int n_bewegungen = 0;

    static void tausche(int n_scheiben, int quellPlatz, int hilfsPlatz, int zielPlatz){
        if(n_scheiben > 0){
            tausche(n_scheiben - 1, quellPlatz, zielPlatz, hilfsPlatz);
            System.out.println("Nimm Scheibe Nummer " + n_scheiben + " von Säule " + quellPlatz + " und lege sie auf Säule " + zielPlatz);
            tausche(n_scheiben - 1, hilfsPlatz, quellPlatz, zielPlatz);
            n_bewegungen++;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        tausche(n, 1, 2, 3);

        System.out.println("Es werden " + n_bewegungen + " Bewegungen benötigt.");
        System.out.println("Das sind ca. " + n_bewegungen/60 + " Minuten.");
        System.out.println("Das sind ca. " + n_bewegungen/360 + " Stunden.");
    }
}
