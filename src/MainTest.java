import java.util.Random;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Personaggi eroe1 = new Personaggi("Hero1", 5,280, 10, 10);
        Personaggi eroe2 = new Personaggi("Hero2", 2,250, 24, 6);
        Personaggi eroe3 = new Personaggi("Hero3", 10,600, 4, 25);
        Personaggi eroe4 = new Personaggi("Hero4", 7,400, 7, 15);
        Personaggi p1 = new Personaggi (null,0,0,0,0);
        Personaggi p2 = new Personaggi (null,0,0,0,0);
        int counter = 50;
        boolean menuPrincipale = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Benvenuto nell'arena");
        while (!menuPrincipale) {
            int sel = 0;
                Conversazioni.menuIniziale();
            try {
                sel = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Carattere non ammesso.");
            }
            switch (sel) {
                case 2 -> {
                    String exit ="";
                        Conversazioni.spiegazioneGioco();
                    exit = scan.next();
                }
                case 3 -> {
                    int sceltaMenuEroi = 0;
                    boolean fineMenuEroe = false;
                    while (!fineMenuEroe) {
                            Conversazioni.menuEroi();
                        try {
                            sceltaMenuEroi = Integer.parseInt(scan.next());
                        } catch (Exception e) {
                            System.out.println("Carattere non ammesso.");
                        }
                        switch (sceltaMenuEroi) {
                            case 1 -> {
                                String exit = "";
                                Conversazioni.spiegHero1();
                                exit = scan.next();
                            }
                            case 2 -> {
                                String exit = "";
                                Conversazioni.spiegHero2();
                                exit = scan.next();
                            }
                            case 3 -> {
                                String exit = "";
                                Conversazioni.spiegHero3();
                                exit = scan.next();
                            }
                            case 4 -> {
                                String exit = "";
                                Conversazioni.spiegHero4();
                                exit = scan.next();
                            }
                            case 5 -> {
                                fineMenuEroe = true;
                            }
                            default -> System.out.println("Seleziona un numero da 1 a 5");
                        }
                    }
                }
                case 4 -> {
                    menuPrincipale = true;
                }
                case 1 -> {
                    while (p1.nome == null) {
                        System.out.println("Seleziona il primo personaggio che combatterà: ");
                        int play1 = 0;
                        try {
                            play1 = Integer.parseInt(scan.next());
                        } catch (Exception e) {
                            System.out.println("Carattere non ammesso.");
                        }
                        switch (play1) {
                            case 1 -> {
                                p1 = eroe1;
                            }
                            case 2 -> {
                                p1 = eroe2;
                            }
                            case 3 -> {
                                p1 = eroe3;
                            }
                            case 4 -> {
                                p1 = eroe4;
                            }
                            default -> System.out.println("Inserisci un numero da 1 a 4");
                        }
                    }
                    while (p2.nome == null) {
                        System.out.println("Ora, seleziona il secondo: ");
                        int play2 = 0;
                        try {
                            play2 = Integer.parseInt(scan.next());
                        } catch (Exception e) {
                            System.out.println("Carattere non ammesso.");
                        }
                        switch (play2) {
                            case 1 -> {
                                p2 = eroe1;
                            }
                            case 2 -> {
                                p2 = eroe2;
                            }
                            case 3 -> {
                                p2 = eroe3;
                            }
                            case 4 -> {
                                p2 = eroe4;
                            }
                            default -> System.out.println("Inserisci un numero da 1 a 4");
                        }
                    }
                    boolean fightFinito = false;
                    boolean turno1 = true;

                    System.out.println("Bene, premi qualsiasi tasto per iniziare il combattimento");
                    while (!fightFinito) {
                        String avanti = scan.next();
                        int colpi = 0;
                        if (turno1) {
                            int dannoturno = 0;
                            for (int i = 1; i < counter; i++) {
                                if (i <= p1.velocità) {
                                    colpi++;
                                    Random r = new Random();
                                    int danno = r.nextInt(p1.potenzamax-p1.potenzamin) + p1.potenzamin;
                                    p2.vita = p2.vita - danno;
                                    dannoturno = dannoturno + danno;
                                }
                            }

                            System.out.println(p1.nome + " ha colpito " + p2.nome + " " + colpi + " volte, causandogli "+ dannoturno +" danni.");

                            if (p2.vita <= 0) {
                                System.out.println(p2.nome + " è rimasto esanime a terra, vince il duello " + p1.nome + "!!!");
                                System.out.println("");
                                fightFinito = true;
                            } else {
                                System.out.println("Ora " + p2.nome + " ha soltanto " + p2.vita + " punti vita!");
                                System.out.println("Premi qualsiasi tasto per proseguire");
                                turno1 = false;
                            }
                        } else {
                            int dannoturno = 0;
                            for (int i = 1; i < counter; i++) {
                                if (i <= p2.velocità) {
                                    colpi++;
                                    Random r = new Random();
                                    int danno = r.nextInt(p2.potenzamax-p2.potenzamin) + p2.potenzamin;
                                   p1.vita = p1.vita - danno;
                                    dannoturno = dannoturno + danno;
                                }
                            }

                            System.out.println(p2.nome + " ha colpito " + p1.nome + " " + colpi + " volte, causandogli "+dannoturno+" danni.");

                            if (p1.vita <= 0) {
                                System.out.println(p1.nome + " è rimasto esanime a terra, vince il duello " + p2.nome + "!!!");
                                System.out.println("");
                                fightFinito = true;
                            } else {
                                System.out.println("Ora " + p1.nome + " ha soltanto " + p1.vita + " punti vita!");
                                System.out.println("Premi qualsiasi tasto per proseguire");
                                turno1 = true;
                            }
                        }
                    }
                }
            }
        }
    }
}





