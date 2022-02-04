package take2;
import java.rmi.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface interf extends Remote{

	// String Sayhello() throws RemoteException;
	

	String getPergunta(String s) throws RemoteException;

	//String getPergunta() throws RemoteException;

}
