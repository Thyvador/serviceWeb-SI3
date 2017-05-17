package fr.polytech.si3.net.rmi;

        import fr.polytech.si3.net.protocol.Idea;

        import java.net.MalformedURLException;
        import java.rmi.*;
        import java.util.List;

/**
 * Created by user on 17/05/2017.
 */
public class ClientLauncher {
    public static void main(String[] args) {
        System.out.println("Lancement du client");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            Remote r = Naming.lookup("rmi://10.0.0.13/TestRMI");
            System.out.println(r);
            if (r instanceof IdeaHandler) {
                List<Idea> list = ((IdeaHandler) r).list();
                System.out.println(list);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Fin du client");

    }
}
