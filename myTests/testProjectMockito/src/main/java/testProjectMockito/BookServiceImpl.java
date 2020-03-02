package testProjectMockito;

import java.util.List;

public class BookServiceImpl implements BookService {

	private BookDao bookdao;
	
	
	public List<Book> findBookByAuthor(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public BookDao getBookdao() {
		return bookdao;
	}


	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	
	
	
}
