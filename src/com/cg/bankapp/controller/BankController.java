package com.cg.bankapp.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bankapp.pojo.BankAccount;
import com.cg.bankapp.service.BankAccountService;


@WebServlet("*.app")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public BankController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private BankAccountService service = new BankAccountService();
    double balance;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
		case "/withdraw.app":
			  
			Collection <BankAccount> accounts = service.viewBankAccount();
		    //request.setAttribute("account", accounts );
			int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			double withdrawAmount=Double.parseDouble(request.getParameter("withdrawAmount"));
			String page="";
			for(BankAccount account1 : accounts) {
				if(accountNumber==account1.getAccountNumber()) {
					
					balance = service.withdraw(withdrawAmount,accountNumber);
					request.setAttribute("bal", balance);
					page="SuccessWithdrawal.jsp";
					
				
				}
				else {
					page="error.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			}
			break;
		case "/deposit.app":
			  accounts=service.viewBankAccount();
			  accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			  double depositAmount=Double.parseDouble(request.getParameter("depositAmount"));
			  
			  for(BankAccount account2 : accounts) {
				  if(accountNumber==account2.getAccountNumber()) {
					  balance = service.deposit(depositAmount,accountNumber);
					  request.setAttribute("bal", balance);
					  page="SuccessDeposit.jsp";
					 
				  }
				  else {
					  page="errordeposit.jsp";
				  }
				  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				  dispatcher.forward(request, response);
			  }
			  break;
		default:
			    break;
			  
			  
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
