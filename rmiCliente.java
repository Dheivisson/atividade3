package take2;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class rmiCliente {
	private rmiCliente() {};
	public static void main(String[] args) {

		//String host = (args.length < 1 ) ? null:args[0];
		try {
			String msg ="";
			Registry registry = LocateRegistry.getRegistry(4777);
			interf stub = (interf) registry.lookup("hello");
			System.out.println("Servidor online! \n");

			System.out.println("**** Digite a Menssagem ***");
			Scanner sc = new Scanner(System.in);
			msg = sc.nextLine();

			String response = stub.getPergunta(msg);
			System.out.println("Resposta do servidor: " + response);
		}
		catch(Exception e){ 
			System.err.println("Servidor Falhou!: "+ e.toString());
			e.printStackTrace();
		}
	}

}
