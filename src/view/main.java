package view;
import javax.swing.JOptionPane;

import Controller.RedesController;
public class main {

    public static void main (String[] args) {
      int opc;
      opc=0;
      while(opc!=9) {
    
      opc=Integer.parseInt(JOptionPane.showInputDialog("informe a opção: 1 - exibe OS / 2 - chama ip / 3 - chama ping / 9 - encerra"));
        RedesController reController = new RedesController();

        String os= reController.os();
      
        if (opc!=1||opc!=2||opc!=3||opc!=9) {
        	JOptionPane.showMessageDialog(null, "opção invalida");
        }
        

	switch(opc) {
	
        case 1:
        System.out.println(os);
        break;

        case 2 :
            reController.readProcess();
        break;

        case 3: 
           
        reController.chamaPing();
break;
}
        }
        }

}