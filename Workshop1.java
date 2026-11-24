import java.util.Scanner;

class Workshop1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Porti: ");
        int port = scanner.nextInt();

        // Kontrollojme portin
        if (port < 0 || port > 65535) {
            System.out.println("Porti nuk ekziston.");
            return;
        }

        scanner.nextLine(); // pastrojme Enter-in

        System.out.print("Protokolli (TCP/UDP): ");
        String protocol = scanner.nextLine().toUpperCase();

        // Rreziku sipas portit
        double risk = switch (port) {
            case 22 -> 7.5;
            case 53 -> 3.5;
            case 80 -> 4.0;
            case 443 -> 2.0;
            case 3389 -> 9.0;
            default -> 5.0;
        };

        boolean allowed = false;

        if (protocol.equals("TCP")) {

            if (port == 80 || port == 443) {
                allowed = true;

            } else if (port == 22) {

                System.out.print("Nga rrjeti i brendshem? (po/jo): ");
                String internal = scanner.nextLine().toLowerCase();

                if (internal.equals("po")) {
                    allowed = true;
                }
            }

        } else if (protocol.equals("UDP")) {

            if (port == 53) {
                allowed = true;
            }

        } else {
            System.out.println("Protokoll i panjohur.");
        }

        String result = allowed ? "LEJOHET" : "BLLOKOHET";

        System.out.println(protocol + " " + port + ": " + result);
        System.out.printf("Rreziku i portit: %.2f nga 10%n", risk);

        scanner.close();
    }
}