package take2;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class rmiServer implements interf {
	public rmiServer() throws RemoteException {
		super();
	}


	@Override
	public String getPergunta(String s) throws RemoteException {
		String gab =  "1;4;vvvf";  
		String[] gab_split = gab.split(";");
		String[] dividida = s.split(";");

		String n_quest = dividida[0];
		//String n_alter = dividida[1];

		char[] q = gab_split[2].toCharArray();
		char[]r = dividida[2].toCharArray();

		int acerto = 0;
		int erro = 0;
		boolean a  = false;


		if (n_quest.equals(gab_split[0])) {

			for(int i = 0; i< q.length; i++) {
				a =  r[i] == q[i];

				if(a == true) 
					acerto++;

				else
					erro++;

			}

		}

		else
			erro++;

		String retorno = new String ("Questão: " + n_quest + ";" +"Acerto(s): " + acerto +
				";" +"Erro(s): "+ erro );
		return retorno;
	}

	public static void main (String args[]) throws RemoteException,
	AlreadyBoundException {

		try {
			rmiServer obj = new rmiServer();
			interf stub = (interf) UnicastRemoteObject.exportObject(obj, 0);

			//Registry registry = LocateRegistry.getRegistry(4777);
			Registry registry = LocateRegistry.createRegistry(4777);
			registry.rebind("hello", stub);

			System.out.println("* Servidor Pronto! *");
		} 
		catch(Exception e){ 
			System.err.println("Servidor Falhou!: "+ e.toString());
			e.printStackTrace();
		}
	}



}
