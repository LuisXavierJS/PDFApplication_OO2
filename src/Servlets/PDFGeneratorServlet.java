package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class PDFGeneratorServlet
 */
@WebServlet("/PDFGeneratorServlet")
public class PDFGeneratorServlet extends HttpServlet {
	private static Map<String,String> todasAsChavesEValores = new HashMap<String,String>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFGeneratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/pdf");
        try {
//            // step 1
            Document document = new Document();
//            // step 2
            PdfWriter.getInstance(document, response.getOutputStream());
//            // step 3
            document.open();
//            // step 4
            Integer numeroDeChaves = todasAsChavesEValores.size();
            Set<String> todasAsChaves = todasAsChavesEValores.keySet();
            document.add(new Paragraph("Foram cadastradas "+numeroDeChaves+" itens"));
            numeroDeChaves = 0;
            for(String chave : todasAsChaves){
            	numeroDeChaves++;
            	String valor = todasAsChavesEValores.get(chave);
            	document.add(new Paragraph("Item " + numeroDeChaves + ": [Chave:" + chave + " | Valor:" + valor + "]"));
            }
            // step 5
            document.close();
        } catch (DocumentException de) {
        	System.out.println("PRINT ERRO");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String chave = (String) request.getParameter("chave");
		String valor = (String) request.getParameter("valor");
		if(chave!=null && valor!= null){
			todasAsChavesEValores.put(chave, valor);
		}
		response.sendRedirect("index.jsp");
	}

}
