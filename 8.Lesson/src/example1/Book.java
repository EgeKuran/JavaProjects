package example1;
import java.util.ArrayList;
import java.util.List;

public class Book {

	private String title;
	
	private List<Chapter> chapters = new  ArrayList<>();
	
	public void addChapters(Chapter chapter) 
	{
		chapters.add(chapter);
	}
	
	
	public Book() {
		super();
	}


	public void setTitle(String title) {
		this.title = title;
	}
	//interface
		interface Page
		{
			public String getContent();
		}
		
	public void addCoverPage() 
	{
		//local inner class
		class CoverPage implements Page
		{
			String coverImage;
			public String getCoverImage() 
			{
				return coverImage;
			}
			
			@Override
			public String getContent() {
				// TODO Auto-generated method stub
				return coverImage;
			}
			
			CoverPage pg = new CoverPage();
		}
			
	}

	
	
	
	//static inner member class
	static class Test{
		public String value;
	}

	//Member  inner class
	class Chapter
	{
		private String title;
		private int no;
		
		public Chapter() {
			// TODO Auto-generated constructor stub
		}

		
		public Chapter(String title, int no) {
			super();
			this.title = title;
			this.no = no;
		}


		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}
		
		
	}
}
