package pubSub;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Scanner;

public class Ouvinte implements IOuvinte{
    public void notificar( String dados, String topico ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n-------------------------------------");
        System.out.println("O usuario: " +"###" + topico+ "###" +" acabou de fazer um post" +"\n");
        System.out.print( "Post: "+dados );
        System.out.println("\n\n-------------------------------------\n\n\n");
    }

    private void seguirUsuario(INotificador servidor, String id ) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o nome do usuario? ");
        String topico = sc.nextLine();

        try {
        servidor.seguir( topico, id );
        } catch(Exception e) {
            System.err.println("Exception:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Scanner sc = new Scanner(System.in);

            //Gerando o ID aleatório.
            Random gerador = new Random();
            String ID = Integer.toString(gerador.nextInt());

            //Criando o objeto remoto e exportando e registrando no rmiregistry
            Ouvinte ouvinte = new Ouvinte();
            IOuvinte stub = (IOuvinte) UnicastRemoteObject.exportObject(ouvinte, 0);
            Registry registry = LocateRegistry.getRegistry(3031);
            registry.rebind(ID, stub);

            INotificador servidor = (INotificador) registry.lookup("Notificador");

            //Menu
            int opcao = -1;
            while(opcao != 0){
                System.out.println("Escolha uma opção: ");
                System.out.println("0 -> Sair");
                System.out.println("1 -> Para seguir um usuario");

                try{
                    opcao = sc.nextInt();
                } catch (Exception e) {
                    opcao = -1; //Para que, caso seja colocado um valor que não é numero, não continue selecionando a opção selecionada previamente
                }

                sc.nextLine();

                if (opcao == 1){
                    ouvinte.seguirUsuario(servidor, ID);
                }

            }
        } catch (Exception e) {
            System.err.println("Exception:");
            e.printStackTrace();
        }
        System.exit(0);
    }
}
