package example1;

import example1.Book.Chapter;
import example1.Book.Test;

public class MainClass {

	public static void main(String[] args) {
		Book book = new Book();
		book.setTitle("Grapes of Wrath");
		
		Chapter chp = new Book().new Chapter();
		chp.setNo(1);
		chp.setTitle("Chapter 1");
		book.addChapters(chp);
		Chapter chp2 = new Book().new Chapter();
		chp.setNo(2);
		chp.setTitle("Chapter 2");
		
		Test t = new Book.Test();
		
	}
}
