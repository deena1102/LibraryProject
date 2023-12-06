/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ppu
 */
public class Library {

    ArrayList<Book> books;
    ArrayList<Student> students;
    

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
      

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addstudent(Student student) {
        students.add(student);
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found: " + book.getInfo());
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void searchByNumber(int number) {
        for (Book book : books) {
            if (book.getNO() == number) {
                System.out.println("Book found: " + book.getInfo());
                return;
            }
        }
        System.out.println("Book not found with number: " + number);
    }

    public void searchByAuthor(String authorName) {
        for (Book book : books) {
            if (book.getAuthor().getName().equals(authorName)) {
                System.out.println("Book found: " + book.getInfo());
                return;
            }
        }
        System.out.println("Book not found by author: " + authorName);
    }

    public void checkBookavailable() {

        for (Book book : books) {
            if (book.inLoan()) {
                System.out.println("Book in loan: " + book.getInfo());
            } else {
                System.out.println(" No Book in loan: ");
            }
        }
    }

    public void showBook() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Book Title: " + book.getTitle() + ", Number: " + book.getNO());
            }
        }
    }

    public void loanBook(Student student, Book book) {
        if (books.contains(book)) {
            if (!book.inLoan()) {
                if (student.getLoanedBooks().size() < 3) {
                    book.setOnLone(true);
                    book.setLoneDate(new Date());
                    book.setDueDate(calculateDueDate(book.getLoneDate()));
                    student.addLoanedBook(book);
                    System.out.println("Book loaned successfully: " + book.getInfo());
                } else {
                    System.out.println("Student has reached the maximum number of loans.");
                }
            } else {
                System.out.println("Book is already on loan.");
            }
        } else {
            System.out.println(" book not found in the library.");
        }
    }

    public void returnBook(Student student, Book book) {
        if (books.contains(book)) {
            if (book.inLoan() && student.getLoanedBooks().contains(book)) {
                book.setOnLone(false);
                student.removeLoanedBook(book);
                CheckLoan(book);
            } else {
                System.out.println("Book is not on loan by the student.");
            }
        } else {
            System.out.println(" book not found in the library.");
        }
    }

    private Date calculateDueDate(Date loanDate) {
        return new Date(loanDate.getTime() + (5 * 24 * 60 * 60 * 1000));
    }

    public void CheckLoan(Book book) {
        Date currentDate = new Date();
        if (book.inLoan()) {
            if (currentDate.after(book.getDueDate())) {
               System.out.println( "Book returned late! Overdue loan detected: " +book.getTitle()  );
            } else {
                System.out.println( "Book returned successfully:" + book.getTitle()) ;
            }
        }
    }

}
