package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Answer;
import com.esprit.pidevbackend.Domain.QVT;
import com.esprit.pidevbackend.Domain.Question;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.QVTRepsitory;
import com.esprit.pidevbackend.Repository.UserRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PdfServiceImpl implements IPdfService {

    @Autowired
    UserRepository accountRepo;
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Autowired
    IQuestionService iQuestionService;
    @Autowired
    IAnswerService iAnswerService;
	
	
	@Override
	public String toPDF(Long idUser,Long idQvt) {

	    QVT qvt=qvtRepsitory.findById(idQvt).orElse(null);
        User user=accountRepo.findById(idUser).orElse(null);


        String URL_file = null;
		
		 Date d = new Date();
         SimpleDateFormat formater = null;
         formater = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try {
			try {
				try {
					try {

	                        URL_file = "D:\\dossier Developper\\"+user.getUsername()+formater.format(d)+".pdf";
	                        OutputStream file = new FileOutputStream(new File(URL_file));

	                        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GRAY);
	                        Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
	                        Font AnswerCorrect = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.GREEN);

	                        Font catFont17Bcour = new Font(Font.FontFamily.COURIER, 9, Font.NORMAL, BaseColor.BLUE);
	                        Font subFontPara13N= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
	                        
	                        Document my_pdf_report = new Document();
	                        PdfWriter.getInstance(my_pdf_report, file);
	                        my_pdf_report.open();

	                        ///Imageee
	                        Image img = null;

	                         img = Image.getInstance("C:\\Users\\aymen\\Desktop\\GetCloser_Logo.png");

	                        img.setAbsolutePosition(50,769);
	                        img.scaleAbsolute(70,50);
	                        my_pdf_report.add(img);

	                        //Dateeee
	                        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
	                        String dt = df.format(new Date());
	                        Paragraph dateStr = new Paragraph(dt, catFont15B);
		                      //separator
	                        Paragraph separator1 = new Paragraph("_______________________________________________________________________________" , subFontPara13N);
	                        
	                        Paragraph titre=new Paragraph(""+user.getUsername()+formater.format(d));
	                        dateStr.setAlignment(Element.ALIGN_RIGHT);
	                        separator1.setAlignment(Element.ALIGN_RIGHT);
	                        titre.setAlignment(Element.ALIGN_RIGHT);

	                      //espaceee
	                        Paragraph espace = new Paragraph(" ", subFont);
	                        espace.setAlignment(Element.ALIGN_LEFT);

//	                       titreee
	                        Paragraph titre2 = new Paragraph("DETAILS ABOUT QVT :" , catFont15B);
	                        titre2.setAlignment(Element.ALIGN_CENTER);

	                      //separator
	                        Paragraph separator = new Paragraph("_________________________________________________________" , subFontPara13N);
	                        separator.setAlignment(Element.ALIGN_CENTER);

                        Paragraph Celmargg11 = new Paragraph(new Phrase("User :"+user.getName() , catFont17Bcour));
                        Celmargg11.setIndentationLeft(430);
                        my_pdf_report.add(Celmargg11);
                        Paragraph Celmargg12 = new Paragraph(new Phrase("NBR Question : "+qvt.getNbrQuestion() , catFont17Bcour));
                        Celmargg12.setIndentationLeft(430);
                        my_pdf_report.add(Celmargg12);

                        if (qvt.getRQuizzes() !=null) {
                            Paragraph Celmargg13 = new Paragraph(new Phrase("BAD : "+qvt.getRQuizzes().getPourCentageBAD()+"%" , catFont17Bcour));
                            Celmargg13.setIndentationLeft(430);
                            my_pdf_report.add(Celmargg13);
                            Paragraph Celmargg14 = new Paragraph(new Phrase("GOOD : "+qvt.getRQuizzes().getPourCentageGood()+"%" , catFont17Bcour));
                            Celmargg14.setIndentationLeft(430);
                            my_pdf_report.add(Celmargg14);
                            Paragraph Celmargg15 = new Paragraph(new Phrase("EXCELLENT : "+qvt.getRQuizzes().getPourCentageEx()+"%" , catFont17Bcour));
                            Celmargg15.setIndentationLeft(430);
                            my_pdf_report.add(Celmargg15);
                        }
                        my_pdf_report.add(espace);
                        my_pdf_report.add(titre2);
                        my_pdf_report.add(espace);
                        my_pdf_report.add(espace);

                        List<Question>qs=iQuestionService.findAllQuestionByQVT(idQvt);
                       for (Question q :qs) {
                            int i=1;
                           my_pdf_report.add(separator);
                           Paragraph para2 = new Paragraph(i+" ) "+q.getQuestion()+" :" , subFontPara13N);
                           para2.setAlignment(Element.ALIGN_LEFT);
                           para2.setIndentationLeft(100);
                           my_pdf_report.add(para2);
                           i++;
                           List<Answer> answers=iAnswerService.findAllAnswerForQuestion(q.getId());

                           List<Answer> ansByUser=iAnswerService.findAllAnswerByUser(idUser);
                           for ( Answer a :answers ) {
                               Paragraph Celmargg = new Paragraph(new Phrase(""+a.getTypeAnswer() , subFontPara13N));
                               for ( Answer auser :ansByUser ) {
                               if (auser.getId()==a.getId()){
                                   Paragraph Celmargg1 = new Paragraph(new Phrase(""+a.getTypeAnswer() , AnswerCorrect));
                                   Celmargg1.setIndentationLeft(200);
                                   my_pdf_report.add(Celmargg1);
                                 }
                               else{
                                   Celmargg.setIndentationLeft(200);
                                   my_pdf_report.add(Celmargg);
                                    }
                               }

                           }
                       }

	                        my_pdf_report.close();
	                        file.close();
	                        
	          Runtime.getRuntime()
	                                .exec("rundll32 url.dll,FileProtocolHandler D:\\dossier Developper\\"+user.getUsername()+formater.format(d)+".pdf");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} catch (DocumentException e) {
					e.printStackTrace();
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return ""+user.getUsername()+formater.format(d)+".pdf";
	}

}
