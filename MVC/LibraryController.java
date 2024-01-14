public class BookController {
       private BookModel model;
       private BookView view;
 
       public BookController(BookModel model, BookView view){
          this.model = model;
          this.view = view;
       }
		//Book name
       public void setBookName(String name){
          model.setbookname(String name);
 
       public String getBookName(){
          return model.getbookname();       
       }
		//Book author
       public void setBookAuthor(String author){
          model.setbookauthor(author);      
       }
 
       public String getBookAuthor(){
          return model.getbookauthor();     
       }
		//Book publication
       public void setBookPublication(String publication){
              model.setbookpub(publication);      
       }
 
           public String getBookPublication(String publictaion){
              return model.getbookpub();       
       }
	   //Book id
	   public void setBookId(String book_id){
              model.setbookpub(book_id);      
       }
 
           public int getBookId(String book_id){
              return model.getbookid();       
       }
 
    }