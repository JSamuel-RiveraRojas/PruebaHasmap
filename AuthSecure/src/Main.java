import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                AuthService authService = new AuthService();

                int opcion;

                do {

                    System.out.println();
                    System.out.println("------------------------------------------");
                    System.out.println("        AUTHSECURE - CONTROL DE ACCESOS");
                    System.out.println("-----------------------------------------");
                    System.out.println("1. Registrar nuevo usuario");
                    System.out.println("2. Iniciar sesión ");
                    System.out.println("3. Eliminar cuenta de usuario");
                    System.out.println("4. Verificar disponibilidad de Username");
                    System.out.println("5. Salir");
                    System.out.println("+----------------------------------------");

                    System.out.print("Seleccione una opción: ");

                    try {
                        opcion = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        opcion = 0;
                    }

                    switch (opcion) {

                        case 1:
                            registrar(scanner, authService);
                            break;

                        case 2:
                            iniciarSesion(scanner, authService);
                            break;

                        case 3:
                            eliminar(scanner, authService);
                            break;

                        case 4:
                            verificarUsername(scanner, authService);
                            break;

                        case 5:
                            System.out.println("\nCerrando sesion...");
                            break;

                        default:
                            System.out.println("\nOpción no valida.");
                    }

                } while (opcion != 5);

                scanner.close();
            }



            private static void registrar(Scanner scanner,
                                          AuthService authService) {

                System.out.println("\n--- REGISTRO DE USUARIO ---");

                System.out.print("Username: ");
                String username = scanner.nextLine();

                if (!authService.usernameDisponible(username)) {
                    System.out.println("ERROR: El username ya existe.");
                    return;
                }

                System.out.print("Password: ");
                String password = scanner.nextLine();

                System.out.print("Nombre completo: ");
                String nombre = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                boolean registrado = authService.registrarUsuario(
                        username,
                        password,
                        nombre,
                        email
                );

                if (registrado) {
                    System.out.println("Usuario registrado correctamente.");
                } else {
                    System.out.println("No se pudo registrar el usuario.");
                }
            }



            private static void iniciarSesion(Scanner scanner,
                                              AuthService authService) {

                System.out.println("\n--- INICIO DE SESIÓN ---");

                System.out.print("Username: ");
                String username = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                boolean autenticado = authService.iniciarSesion(
                        username,
                        password
                );

                if (autenticado) {
                    System.out.println("Autenticación exitosa.");
                    System.out.println("Bienvenido, " + username + ".");
                } else {
                    System.out.println("ERROR: Username o password incorrectos.");
                }
            }

            private static void eliminar(Scanner scanner,
                                         AuthService authService) {

                System.out.println("\n--- ELIMINAR CUENTA ---");

                System.out.print("Username: ");
                String username = scanner.nextLine();

                boolean eliminado = authService.eliminarUsuario(username);

                if (eliminado) {
                    System.out.println("Cuenta eliminada correctamente.");
                } else {
                    System.out.println("ERROR: El usuario no existe.");
                }
            }


            private static void verificarUsername(Scanner scanner,
                                                  AuthService authService) {

                System.out.println("\n--- DISPONIBILIDAD DE USERNAME ---");

                System.out.print("Username a verificar: ");
                String username = scanner.nextLine();

                if (authService.usernameDisponible(username)) {
                    System.out.println("El username '" + username
                            + "' está disponible.");
                } else {
                    System.out.println("El username '" + username
                            + "' NO está disponible.");
                }
            }
        }

