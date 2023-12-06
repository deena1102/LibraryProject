/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ppu
 */
public class Student extends Author {
    
    private String major; 
    ArrayList<Book> loanedBooks;
    
    public Student( int ID, String Name, String address, MyDate BD , String major) {
        super(ID, Name, address, BD);
        this.major = major;
    }

    public Student() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.major);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if(!super.equals(obj))
            return false;
        
        final Student other = (Student) obj;
        if (!Objects.equals(this.major, other.major)) {
            return false;
        }
        return true;
    }
     
    @Override
    public String getInfo() 
    {
        return super.getInfo() + "Majer : " + this.major;
    }
    
    public ArrayList<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void addLoanedBook(Book book) {
        loanedBooks.add(book);
    }

    public void removeLoanedBook(Book book) {
        loanedBooks.remove(book);
    }
    
    
}
