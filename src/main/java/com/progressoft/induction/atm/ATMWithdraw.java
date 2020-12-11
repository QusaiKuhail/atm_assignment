package com.progressoft.induction.atm;

import com.progressoft.induction.atm.exceptions.AccountNotFoundException;
import com.progressoft.induction.atm.exceptions.InsufficientFundsException;
import com.progressoft.induction.atm.exceptions.NotEnoughMoneyInATMException;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class ATMWithdraw implements ATM {
    boolean alreadyExecuted=false;
    BigDecimal ATMAmountOfMoney=BigDecimal.valueOf(2400);
    String AccNum;
    BigDecimal amount;
    Balance[] Account=new Balance[5];
     Balance TheAccount;
    @Override
    public List<Banknote> withdraw(String accountNumber, BigDecimal amount) {
        AccNum=accountNumber;
        this.amount=amount;
        if (AccountCheck(AccNum)){
                if(BalanceCheck(amount))
               if(ATMMoneyCheck(amount))
                   TheAccount.amount= TheAccount.getAccountBalance(accountNumber).subtract(amount);
              ATMAmountOfMoney= ATMAmountOfMoney.subtract(amount);
        }
        return null;
    }
    public void initAccs(){
        if(!alreadyExecuted){
        for (int i=0;i<5;i++){
            Account[i]=new Balance();
        }
        Account[0].debitAccount("123456789", BigDecimal.valueOf(1000));
        Account[1].debitAccount("111111111", BigDecimal.valueOf(1000));
        Account[2].debitAccount("222222222", BigDecimal.valueOf(1000));
        Account[3].debitAccount("333333333", BigDecimal.valueOf(1000));
        Account[4].debitAccount("444444444", BigDecimal.valueOf(1000));
        alreadyExecuted=true;
    }}
    public  boolean AccountCheck(String accNum) throws AccountNotFoundException {
        initAccs();
        for (int i=0;i<5;i++){
            if(accNum.equals(Account[i].accountNumber)){
                TheAccount=Account[i];
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"Could not find this account number");
        throw new AccountNotFoundException("Could not find this account number"+" "+AccNum);
    }
    public  boolean BalanceCheck(BigDecimal amount)throws InsufficientFundsException {
        if (TheAccount.getAccountBalance(AccNum).compareTo(amount)==1 || TheAccount.getAccountBalance(AccNum).compareTo(amount)==0){
        }
        else {
            JOptionPane.showMessageDialog(null,"We're sorry , you don't have this amount in your account");
            throw new InsufficientFundsException("Not enough money");
        }
        return true;
    }
    public boolean ATMMoneyCheck(BigDecimal amount) throws NotEnoughMoneyInATMException{
        if(amount.compareTo(ATMAmountOfMoney)==1 ){
            JOptionPane.showMessageDialog(null,"Not enough money in ATM");
            throw new NotEnoughMoneyInATMException("Not enough money in ATM");
        }
        return true;
    }
}
