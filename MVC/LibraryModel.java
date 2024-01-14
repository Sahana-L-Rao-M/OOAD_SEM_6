class BookModel
{
	String name;
	String author;
	String publication;
	int book_id;
	
	//Getters
	String getbookname()
	{
		return this.name;
	}
	String getbookauthor()
	{
		return this.author;
	}
	String getbookpub()
	{
		return this.publication;
	}
	String getbookid()
	{
		return this.book_id;
	}
	
	//Setters
	void setbookname(String name)
	{
		this.name=name;
	}
	void setbooksuthor(String author)
	{
		this.author=author;
	}
	void setbookpub(String publication)
	{
		this.publication=publication;
	}
	void getbookid(book_id)
	{
		this.book_id=book_id;
	}
}