/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.yourcompany.struts.form.CreditCardForm;

/**
 * MyEclipse Struts
 * Creation date: 07-29-2008
 *
 * XDoclet definition:
 * @struts.action path="/CreditCard" name="creditCardForm" attribute="CreditCardForm" input="/CreditCard.jsp" scope="request" validate="true"
 */
public class CreditCardAction extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
		CreditCardForm CreditCardForm = (CreditCardForm) form;// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String accountnumber=CreditCardForm.getAccountnumber();
		String password=CreditCardForm.getPassword();
		String process=request.getParameter("process");
		String result="failure";
		String status="";
		String type="";
		Process compile;
		WASP.CharacterLevel character=new WASP.CharacterLevel();
		Vector v=new Vector();
		v.add(accountnumber);
		v.add(password);
		if(process==null)
		{
	         		process="normal";
			System.out.println(process);
			session.setAttribute("process",process);
        DataBase.database data=new DataBase.database();

			System.out.println("normal   "  +(String)session.getAttribute("process"));

			 data.setTableName("creditcard");

			result=data.check(accountnumber, password);
			session.setAttribute("accountnumber",accountnumber);

    		System.out.println("result befor to redirect  "  +result);

		}
		else if(process.equals("positive"))
		{
			session.setAttribute("process","positive");
			System.out.println("dsdsdssdsdsdsdsdssdssd");
	    	String file="C:\\WASP\\";


	   FileReader fr=new FileReader(file+"Metastring.java");
	    System.out.println("file reader");
	    BufferedReader br=new BufferedReader(fr);
	    System.out.println("buffer reader");

	    String data="";
	    String s;
	    while((s=br.readLine())!=null)
	    {
	    	s=s.replace("xxx",accountnumber);
	    	s=s.replace("zzz", password);
	    	data=data+"\n"+s;
	    	//System.out.println("correct classs   " +s);
	    }
	     System.out.println("classs "+data);
	     br.close();
	     FileWriter fw=new FileWriter(file+"Metastring.java");
	     fw.write(data);
	     fw.flush();
	     fw.close();

	   String JAVA_HOME = System.getProperty("java.home");
	 	String java_dir	= JAVA_HOME.substring(0,JAVA_HOME.lastIndexOf(File.separator));
	 	String compileCommand = java_dir+File.separator+"bin"+File.separator+"javac.exe ";
	 	String path="-d "+" "+file;

	 	//String fullpath="C:/Program Files/Apache Software Foundation/Tomcat 5.0/bin/Metastring.java";
	 	//System.out.println(fullpath);
	 	String fullpath=file+"Metastring.java";
	 	System.out.println(compileCommand +" "+path+"\\"+" "+fullpath);

	 	compile = Runtime.getRuntime().exec(compileCommand +" "+path+"\\"+" "+fullpath);
	    System.out.println("comple class created");
	    Thread.sleep(5000);
	    WASP.PositiveTaint positive=new WASP.PositiveTaint();
	      positive.classcode();
	      positive.changeclass("sample.txt","Metastring");
	      String Accountnumber=positive.accnumber;
	      String pass=positive.password;
	      request.setAttribute("typeofinje",type);
	      if(positive.result.equals("notinjected"))
	      {
	      DataBase.database database=new DataBase.database();
	      database.setTableName("creditcard");
	      result=database.check(Accountnumber, pass);
	      session.setAttribute("accountnumber",accountnumber);
	      }
	      else if(positive.result.equals("injected"))
	      {
	    	result="failure" ;
	      }

		}
		else if(process.equals("character"))
		{
			System.out.println("character");
			session.setAttribute("process","character");;
			System.out.println("if blockkkk");
			character.calculate(v);
			status=character.injection;
		    System.out.println("result value  if" +status);
		    type=character.typeofinjection;
		   // session.setAttribute("typeofinje", type);
		    request.setAttribute("typeofinje", type);
			 if(status.equals("sucess"))
		    {
		    	DataBase.database data=new DataBase.database();

		    	    	System.out.println("22222222222222222222");
		    	    data.setTableName("creditcard");
		    	   result=data.check(accountnumber, password);
		    	   session.setAttribute("accountnumber",accountnumber);

		    		System.out.println("result befor to redirect  "  +result);
		    }
		}
		else if(process.equals("syntax"))
		{

			session.setAttribute("process","syntax");
			  DataBase.databasesyntax datasyn=new DataBase.databasesyntax();
			  datasyn.setCheckquery("creditcard", accountnumber, password);
			  String query=datasyn.getCheckquery();
			  System.out.println("  sdsasfsdfsdfdfdf " +query);
			 WASP.SyntaxAware syntax=new WASP.SyntaxAware();
			 syntax.setsyntaxselect(query);
	         String tablename=syntax.getTablename();

	        accountnumber=syntax.getAccountnumber();
	        System.out.println("accountnumber   " +accountnumber);
	        int flength=accountnumber.length();
	        int hlength=accountnumber.indexOf("=");
	        accountnumber=accountnumber.substring(hlength+1, flength);
	        System.out.println("accountnumber   " +accountnumber);
	        String pass=syntax.getPassword();
	         flength=pass.length();
	        hlength=pass.indexOf("=");
	        pass=pass.substring(hlength+1, flength);
	        System.out.println("password   " +pass);
	        query="select * from "+tablename+ " where accountnumber="+accountnumber+" AND password='"+pass+"'";
	       System.out.println(query);
	       datasyn.setCheck(query);
	        result=datasyn.getCheck();
	        session.setAttribute("accountnumber",accountnumber);
		}

		return mapping.findForward(result);
	}
}