package source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class creaMatriz {

	public static void main(String[] args) throws IOException {
		 
		{		
			PrintWriter out = new PrintWriter(new FileWriter("src/TP2/Test/Lotes/10_casoFatiga2000.in"));
			int dim1=2000;
			Random rnd=new Random();
			out.println(dim1);
			int i=0;
			int j=0;
			while(i<dim1){
				while(j<dim1){
				    out.print(i);
					System.out.print(i);
					out.print(" ");
					System.out.print(" ");
					out.print(j);
					System.out.print(j);
					out.print(" ");
					System.out.print(" ");
					out.println(rnd.nextDouble()*100+0);
					System.out.println(rnd.nextDouble()*100+0);
				    j++;
				}
				j=0;
				i++;
 			}
				

			for(int h=0;h<dim1;h++){
			   out.println(rnd.nextDouble()*100+0);
			   System.out.println(rnd.nextDouble()*100+0);
			}
			out.close();
		}

	}

}
