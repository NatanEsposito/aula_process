package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	
public RedesController() {
	super();
	}
//retorne o S.o. ue esta na maquina
public String os (){
	String os = System.getProperty("os.name");
	String arch = System.getProperty("os.arch");
	String version = System.getProperty("os.version");
	
	return os+ "-v."+version+"- arch."+ arch ;
	
}
public void callProcess(String process) {
	try{
		Runtime.getRuntime().exec(process);
	}catch(Exception e) {
		String msgErro=e.getMessage();
		System.err.println(msgErro);
		if(msgErro.contains("740")) {
			//cmd/c caminho_do_processo
			StringBuffer buffer = new StringBuffer();
			buffer.append("cmd/c");
			buffer.append(" ");
			buffer.append(process);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			}catch (IOException e1) {
					e1.printStackTrace();
			
				}
			}else {
				System.err.println(msgErro);
				
			
		}
	}
	
}
public void readProcess() {
	if(os().contains("windows")) {
		
	try {

		Process p = Runtime.getRuntime().exec("ipconfig");
		InputStream fluxo = p.getInputStream();
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer=new BufferedReader(leitor);
		String linha = buffer.readLine();
		while(linha!=null) {
			if(linha.contains("adaptador")) {
				System.out.println(linha);
			}
			if(linha.contains("IPv4")) {
				System.out.println(linha);
				
			}
			linha = buffer.readLine();
			
		}
		buffer.close();
		leitor.close();
		fluxo.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}else {
	if(os().contains("linux")) {
		try {
			Process p = Runtime.getRuntime().exec("ifconfig");
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer=new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha!=null) {
				if(linha.contains("flags")) {
					System.out.println(linha);
				}
				if(linha.contains("inet") && !linha.contains("inet6")) {
					System.out.println(linha.split("netmask")[0]);
					
				}
				linha = buffer.readLine();
				
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
}


	public void chamaPing() {
		if(os().contains("windows")) {
			
			try {

				Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br ");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer=new BufferedReader(leitor);
				String linha = buffer.readLine();
				String linha2="";
				while(linha!=null) {
					System.out.println(linha);
					linha2=linha;
					linha = buffer.readLine();
					}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
				if (os().contains("windows")) {
					JOptionPane.showMessageDialog(null,"" +linha2.split("-")[3]);
										
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,"erro de conecao", "erro", JOptionPane.ERROR_MESSAGE);
				
				e.printStackTrace();
			}
			
		}else {
			if(os().contains("linux")) {
				try {
					Process p = Runtime.getRuntime().exec("PING -4 -c 10 www.google.com.br ");
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer=new BufferedReader(leitor);
					String linha = buffer.readLine();
					String linha2="";
					
					while(linha!=null) {
						System.out.println(linha);
						linha2=linha;
						linha = buffer.readLine();
							
							
						}
						
						
					linha = buffer.readLine();
					buffer.close();
					leitor.close();
					fluxo.close();
					if (os().contains("Linux")){
						JOptionPane.showMessageDialog(null,"media"+ linha2.split("/")[4]+"ms");
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"erro de conecao","error",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
	}
	}
}
