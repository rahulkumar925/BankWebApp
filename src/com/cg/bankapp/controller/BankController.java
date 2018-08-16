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
    double debitedBalance;
    double creditedBalance;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
		case "/withdraw.app":
			  int flag=0;
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
					flag=1;
				
				}
				}
				if(flag==0) {
					page="error.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			
			break;
		case "/deposit.app":
			int flag1=0;
			String page2="";
			  accounts=service.viewBankAccount();
			  accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			  double depositAmount=Double.parseDouble(request.getParameter("depositAmount"));
			  
			  for(BankAccount account2 : accounts) {
				  if(accountNumber==account2.getAccountNumber()) {
					  balance = service.deposit(depositAmount,accountNumber);
					  request.setAttribute("bal", balance);
					  page2="SuccessDeposit.jsp";
					  flag1=1;
				  }
			  }
				  if(flag1==0) {
					  page2="errordeposit.jsp";
				  }
				  dispatcher = request.getRequestDispatcher(page2);
				  dispatcher.forward(request, response);
			  break;
		case "/viewAccount.app":
             accounts=service.viewBankAccount();
             request.setAttribute("account", accounts);
             dispatcher = request.getRequestDispatcher("viewAccount.jsp");
             dispatcher.forward(request, response);
			 break;
		case "/fundTransfer.app":
			accounts=service.viewBankAccount();
			int flag2=0;
			String page1="";
			int senderAccountNumber = Integer.parseInt(request.getParameter("senderAccountNumber"));
			int receiverAccountNumber = Integer.parseInt(request.getParameter("receiverAccountNumber"));
			double transferAmount=Double.parseDouble(request.getParameter("transferAmount"));
			
			for(BankAccount account3 : accounts) {
				if(senderAccountNumber==account3.getAccountNumber()) {
					flag2=1;
					for(BankAccount account4 : accounts) {
						if(receiverAccountNumber==account4.getAccountNumber()) {
							debitedBalance=service.withdraw(transferAmount, senderAccountNumber);
							creditedBalance=service.deposit(transferAmount, receiverAccountNumber);
							request.setAttribute("debit", debitedBalance);
							request.setAttribute("credit", creditedBalance);
							page1="SuccessTransfer.jsp";
							flag2=2;
						}
					}
				}
			}
			    if(flag2==0) {
			    	page1="sendererror.jsp";
			    }
			    if(flag2==1) {
			    	page1="receivererror.jsp";
			    }
				  RequestDispatcher dispatcher1 = request.getRequestDispatcher(page1);
				  dispatcher1.forward(request, response);	
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
